/*
 *  Copyright 2004-2006 Stefan Reuter
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.asteriskjava.manager.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import static org.easymock.EasyMock.*;

import org.asteriskjava.io.SocketConnectionFacade;
import org.asteriskjava.manager.AsteriskServer;
import org.asteriskjava.manager.Dispatcher;
import org.asteriskjava.manager.ManagerReader;
import org.asteriskjava.manager.MyUserEvent;
import org.asteriskjava.manager.event.ConnectEvent;
import org.asteriskjava.manager.event.DisconnectEvent;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.StatusCompleteEvent;
import org.asteriskjava.manager.response.CommandResponse;
import org.asteriskjava.manager.response.ManagerResponse;
import org.asteriskjava.util.DateUtil;

public class ManagerReaderImplTest extends TestCase
{
    private Date now;
    private MockedDispatcher dispatcher;
    private SocketConnectionFacade socketConnectionFacade;
    private AsteriskServer asteriskServer;
    private ManagerReader managerReader;

    protected void setUp()
    {
        now = new Date();
        DateUtil.overrideCurrentDate(now);
        asteriskServer = new AsteriskServer();
        dispatcher = new MockedDispatcher();
        managerReader = new ManagerReaderImpl(dispatcher, asteriskServer);

        socketConnectionFacade = createMock(SocketConnectionFacade.class);
    }

    protected void tearDown()
    {
        DateUtil.overrideCurrentDate(null);
    }

    public void testRunWithoutSocket() throws Exception
    {
        try
        {
            managerReader.run();
            fail("Must throw IllegalStateException");
        }
        catch (IllegalStateException e)
        {
            assertTrue("Exception must be of type IllegalStateException",
                    e instanceof IllegalStateException);
        }
    }

    public void testRunReceivingProtocolIdentifier() throws Exception
    {
        expect(socketConnectionFacade.readLine()).andReturn("Asterisk Call Manager/1.0");
        expect(socketConnectionFacade.readLine()).andReturn(null);

        replay(socketConnectionFacade);

        managerReader.setSocket(socketConnectionFacade);
        managerReader.run();

        verify(socketConnectionFacade);

        assertEquals("not exactly two events dispatched", 2,
                dispatcher.dispatchedEvents.size());

        assertEquals("first event must be a ConnectEvent", ConnectEvent.class,
                dispatcher.dispatchedEvents.get(0).getClass());

        assertEquals("ConnectEvent contains incorrect protocol identifier",
                "Asterisk Call Manager/1.0",
                ((ConnectEvent) dispatcher.dispatchedEvents.get(0))
                        .getProtocolIdentifier());

        assertEquals("ConnectEvent contains incorrect dateReceived", now,
                ((ConnectEvent) dispatcher.dispatchedEvents.get(0))
                        .getDateReceived());

        assertEquals("second event must be a DisconnectEvent",
                DisconnectEvent.class, dispatcher.dispatchedEvents.get(1)
                        .getClass());

        assertEquals("DisconnectEvent contains incorrect dateReceived", now,
                ((DisconnectEvent) dispatcher.dispatchedEvents.get(1))
                        .getDateReceived());
    }

    public void testRunReceivingEvent() throws Exception
    {
        expect(socketConnectionFacade.readLine()).andReturn("Event: StatusComplete");
        expect(socketConnectionFacade.readLine()).andReturn("");
        expect(socketConnectionFacade.readLine()).andReturn(null);

        replay(socketConnectionFacade);

        managerReader.setSocket(socketConnectionFacade);
        managerReader.run();

        verify(socketConnectionFacade);

        assertEquals("not exactly two events dispatched", 2,
                dispatcher.dispatchedEvents.size());

        assertEquals("first event must be a StatusCompleteEvent",
                StatusCompleteEvent.class, dispatcher.dispatchedEvents.get(0)
                        .getClass());

        assertEquals("second event must be a DisconnectEvent",
                DisconnectEvent.class, dispatcher.dispatchedEvents.get(1)
                        .getClass());
    }

    public void testRunReceivingUserEvent() throws Exception
    {
        managerReader.registerEventClass(MyUserEvent.class);

        expect(socketConnectionFacade.readLine()).andReturn("Event: MyUser");
        expect(socketConnectionFacade.readLine()).andReturn("");
        expect(socketConnectionFacade.readLine()).andReturn(null);

        replay(socketConnectionFacade);

        managerReader.setSocket(socketConnectionFacade);
        managerReader.run();

        verify(socketConnectionFacade);

        assertEquals("not exactly two events dispatched", 2,
                dispatcher.dispatchedEvents.size());

        assertEquals("first event must be a MyUserEvent", MyUserEvent.class,
                dispatcher.dispatchedEvents.get(0).getClass());

        assertEquals("second event must be a DisconnectEvent",
                DisconnectEvent.class, dispatcher.dispatchedEvents.get(1)
                        .getClass());
    }

    public void testRunReceivingResponse() throws Exception
    {
        expect(socketConnectionFacade.readLine()).andReturn("Response: Success");
        expect(socketConnectionFacade.readLine()).andReturn("Message: Authentication accepted");
        expect(socketConnectionFacade.readLine()).andReturn("");
        expect(socketConnectionFacade.readLine()).andReturn(null);

        replay(socketConnectionFacade);

        managerReader.setSocket(socketConnectionFacade);
        managerReader.run();

        verify(socketConnectionFacade);

        assertEquals("not exactly one response dispatched", 1,
                dispatcher.dispatchedResponses.size());

        assertEquals("first response must be a ManagerResponse",
                ManagerResponse.class, dispatcher.dispatchedResponses.get(0)
                        .getClass());

        assertEquals("ManagerResponse contains incorrect response", "Success",
                ((ManagerResponse) dispatcher.dispatchedResponses.get(0))
                        .getResponse());

        assertEquals("ManagerResponse contains incorrect message",
                "Authentication accepted",
                ((ManagerResponse) dispatcher.dispatchedResponses.get(0))
                        .getMessage());

        assertEquals("ManagerResponse contains incorrect message (via getAttribute)",
                "Authentication accepted",
                ((ManagerResponse) dispatcher.dispatchedResponses.get(0))
                        .getAttribute("MESSAGE"));

        assertEquals("ManagerResponse contains incorrect dateReceived", now,
                ((ManagerResponse) dispatcher.dispatchedResponses.get(0))
                        .getDateReceived());

        assertEquals("not exactly one events dispatched", 1,
                dispatcher.dispatchedEvents.size());

        assertEquals("first event must be a DisconnectEvent",
                DisconnectEvent.class, dispatcher.dispatchedEvents.get(0)
                        .getClass());
    }

    public void testRunReceivingCommandResponse() throws Exception
    {
        List<String> result = new ArrayList<String>();

        expect(socketConnectionFacade.readLine()).andReturn("Response: Follows");
        expect(socketConnectionFacade.readLine()).andReturn("ActionID: 12345");
        expect(socketConnectionFacade.readLine()).andReturn("Line1");
        expect(socketConnectionFacade.readLine()).andReturn("Line2");
        expect(socketConnectionFacade.readLine()).andReturn("--END COMMAND--");
        expect(socketConnectionFacade.readLine()).andReturn("");
        expect(socketConnectionFacade.readLine()).andReturn(null);

        result.add("Line1");
        result.add("Line2");

        replay(socketConnectionFacade);

        managerReader.setSocket(socketConnectionFacade);
        managerReader.run();

        verify(socketConnectionFacade);

        assertEquals("not exactly one response dispatched", 1,
                dispatcher.dispatchedResponses.size());

        assertEquals("first response must be a CommandResponse",
                CommandResponse.class, dispatcher.dispatchedResponses.get(0)
                        .getClass());

        assertEquals("CommandResponse contains incorrect response", "Follows",
                ((CommandResponse) dispatcher.dispatchedResponses.get(0))
                        .getResponse());

        assertEquals("CommandResponse contains incorrect actionId", "12345",
                ((CommandResponse) dispatcher.dispatchedResponses.get(0))
                        .getActionId());

        assertEquals("CommandResponse contains incorrect actionId (via getAttribute)", "12345",
                ((CommandResponse) dispatcher.dispatchedResponses.get(0))
                        .getAttribute("actionId"));

        assertEquals("CommandResponse contains incorrect result", result,
                ((CommandResponse) dispatcher.dispatchedResponses.get(0))
                        .getResult());

        assertEquals("CommandResponse contains incorrect dateReceived", now,
                ((CommandResponse) dispatcher.dispatchedResponses.get(0))
                        .getDateReceived());
    }

    public void testRunCatchingIOException() throws Exception
    {
        expect(socketConnectionFacade.readLine()).andThrow(new IOException(
                "Something happened to the network..."));

        replay(socketConnectionFacade);

        managerReader.setSocket(socketConnectionFacade);
        managerReader.run();

        verify(socketConnectionFacade);

        assertEquals("must not dispatch a response", 0,
                dispatcher.dispatchedResponses.size());

        assertEquals("not exactly one events dispatched", 1,
                dispatcher.dispatchedEvents.size());

        assertEquals("first event must be a DisconnectEvent",
                DisconnectEvent.class, dispatcher.dispatchedEvents.get(0)
                        .getClass());
    }

    private class MockedDispatcher implements Dispatcher
    {
        List<ManagerEvent> dispatchedEvents;
        List<ManagerResponse> dispatchedResponses;

        public MockedDispatcher()
        {
            this.dispatchedEvents = new ArrayList<ManagerEvent>();
            this.dispatchedResponses = new ArrayList<ManagerResponse>();
        }

        public void dispatchResponse(ManagerResponse response)
        {
            dispatchedResponses.add(response);
        }

        public void dispatchEvent(ManagerEvent event)
        {
            dispatchedEvents.add(event);
        }
    }
}
