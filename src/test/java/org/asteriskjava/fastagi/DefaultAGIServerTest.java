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
package org.asteriskjava.fastagi;

import java.io.IOException;

import junit.framework.TestCase;
import static org.easymock.EasyMock.*;

import org.asteriskjava.fastagi.DefaultAGIServer;
import org.asteriskjava.io.ServerSocketFacade;
import org.asteriskjava.io.SocketConnectionFacade;

public class DefaultAGIServerTest extends TestCase
{
    private DefaultAGIServer server;
    private MockedServerSocketFacade serverSocket;
    private SocketConnectionFacade socket;

    protected void setUp() throws Exception
    {
        super.setUp();

        serverSocket = new MockedServerSocketFacade();
        server = new MockedDefaultAGIServer();
    }

    protected void tearDown() throws Exception
    {
        super.tearDown();
        server.shutdown();
    }

    public void testDummy()
    {
        
    }
    
    public void XtestStartup() throws Exception
    {
        socket = createMock(SocketConnectionFacade.class);

        expect(socket.readLine()).andReturn(null);
        expect(socket.getLocalAddress()).andReturn(null);
        expect(socket.getLocalPort()).andReturn(1);
        expect(socket.getRemoteAddress()).andReturn(null);
        expect(socket.getRemotePort()).andReturn(2);
        socket.write("VERBOSE \"No script configured for null\" 1\n");
        socket.flush();
        expect(socket.readLine()).andReturn(null);
        socket.close();
        replay(socket);

        try
        {
            server.startup();
        }
        catch (IOException e)
        {
            
        }
        Thread.sleep(500);

        assertEquals("serverSocket.accept() not called 2 times", 2,
                serverSocket.acceptCalls);
        assertEquals("serverSocket.close() not called", 1,
                serverSocket.closeCalls);
        
        verify(socket);
    }

    class MockedDefaultAGIServer extends DefaultAGIServer
    {
        protected ServerSocketFacade createServerSocket()
        {
            return serverSocket;
        }
    }

    class MockedServerSocketFacade implements ServerSocketFacade
    {
        public int acceptCalls = 0;
        public int closeCalls = 0;

        public SocketConnectionFacade accept() throws IOException
        {
            acceptCalls++;
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
            }

            if (acceptCalls == 1)
            {
                return socket;
            }
            else
            {
                throw new IOException("Provoked IOException");
            }
        }

        public void close() throws IOException
        {
            closeCalls++;
        }
    }
}
