/*
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
package org.asteriskjava.manager.event;

/**
 * 
 * @author <a href="mailto:nmazzon@teleniasoftware.it">Nicolò Mazzon</a>
 * @version 1.0.0 15-dic-2016
 */
public abstract class AbstractLocalOptimization extends ManagerEvent {
    private static final long serialVersionUID = 1166622334619381370L;

    private String  localOneChannel;
    private Integer localOneChannelState;
    private String  localOneChannelStateDesc;
    private String  localOneCallerIDNum;
    private String  localOneCallerIDName;
    private String  localOneConnectedLineNum;
    private String  localOneConnectedLineName;
    private String  localOneLanguage;
    private String  localOneAccountCode;
    private String  localOneContext;
    private String  localOneExten;
    private Integer localOnePriority;
    private String  localOneUniqueid;
    private String  localOneLinkedid;
    private String  localTwoChannel;
    private Integer localTwoChannelState;
    private String  localTwoChannelStateDesc;
    private String  localTwoCallerIDNum;
    private String  localTwoCallerIDName;
    private String  localTwoConnectedLineNum;
    private String  localTwoConnectedLineName;
    private String  localTwoLanguage;
    private String  localTwoAccountCode;
    private String  localTwoContext;
    private String  localTwoExten;
    private Integer localTwoPriority;
    private String  localTwoUniqueid;
    private String  localTwoLinkedid;
    private String  success;
    private Integer id;

    AbstractLocalOptimization( Object source ) {
        super( source );
    }


    /**
     * @return the localOneChannel
     */
    public String getLocalOneChannel() {
        return localOneChannel;
    }


    /**
     * @param localOneChannel the localOneChannel to set
     */
    public void setLocalOneChannel( String localOneChannel ) {
        this.localOneChannel = localOneChannel;
    }


    /**
     * @return the localOneChannelState
     */
    public Integer getLocalOneChannelState() {
        return localOneChannelState;
    }


    /**
     * @param localOneChannelState the localOneChannelState to set
     */
    public void setLocalOneChannelState( Integer localOneChannelState ) {
        this.localOneChannelState = localOneChannelState;
    }


    /**
     * @return the localOneChannelStateDesc
     */
    public String getLocalOneChannelStateDesc() {
        return localOneChannelStateDesc;
    }


    /**
     * @param localOneChannelStateDesc the localOneChannelStateDesc to set
     */
    public void setLocalOneChannelStateDesc( String localOneChannelStateDesc ) {
        this.localOneChannelStateDesc = localOneChannelStateDesc;
    }


    /**
     * @return the localOneCallerIDNum
     */
    public String getLocalOneCallerIDNum() {
        return localOneCallerIDNum;
    }


    /**
     * @param localOneCallerIDNum the localOneCallerIDNum to set
     */
    public void setLocalOneCallerIDNum( String localOneCallerIDNum ) {
        this.localOneCallerIDNum = localOneCallerIDNum;
    }


    /**
     * @return the localOneCallerIDName
     */
    public String getLocalOneCallerIDName() {
        return localOneCallerIDName;
    }


    /**
     * @param localOneCallerIDName the localOneCallerIDName to set
     */
    public void setLocalOneCallerIDName( String localOneCallerIDName ) {
        this.localOneCallerIDName = localOneCallerIDName;
    }


    /**
     * @return the localOneConnectedLineNum
     */
    public String getLocalOneConnectedLineNum() {
        return localOneConnectedLineNum;
    }


    /**
     * @param localOneConnectedLineNum the localOneConnectedLineNum to set
     */
    public void setLocalOneConnectedLineNum( String localOneConnectedLineNum ) {
        this.localOneConnectedLineNum = localOneConnectedLineNum;
    }


    /**
     * @return the localOneConnectedLineName
     */
    public String getLocalOneConnectedLineName() {
        return localOneConnectedLineName;
    }


    /**
     * @param localOneConnectedLineName the localOneConnectedLineName to set
     */
    public void setLocalOneConnectedLineName( String localOneConnectedLineName ) {
        this.localOneConnectedLineName = localOneConnectedLineName;
    }


    /**
     * @return the localOneLanguage
     */
    public String getLocalOneLanguage() {
        return localOneLanguage;
    }


    /**
     * @param localOneLanguage the localOneLanguage to set
     */
    public void setLocalOneLanguage( String localOneLanguage ) {
        this.localOneLanguage = localOneLanguage;
    }


    /**
     * @return the localOneAccountCode
     */
    public String getLocalOneAccountCode() {
        return localOneAccountCode;
    }


    /**
     * @param localOneAccountCode the localOneAccountCode to set
     */
    public void setLocalOneAccountCode( String localOneAccountCode ) {
        this.localOneAccountCode = localOneAccountCode;
    }


    /**
     * @return the localOneContext
     */
    public String getLocalOneContext() {
        return localOneContext;
    }


    /**
     * @param localOneContext the localOneContext to set
     */
    public void setLocalOneContext( String localOneContext ) {
        this.localOneContext = localOneContext;
    }


    /**
     * @return the localOneExten
     */
    public String getLocalOneExten() {
        return localOneExten;
    }


    /**
     * @param localOneExten the localOneExten to set
     */
    public void setLocalOneExten( String localOneExten ) {
        this.localOneExten = localOneExten;
    }


    /**
     * @return the localOnePriority
     */
    public Integer getLocalOnePriority() {
        return localOnePriority;
    }


    /**
     * @param localOnePriority the localOnePriority to set
     */
    public void setLocalOnePriority( Integer localOnePriority ) {
        this.localOnePriority = localOnePriority;
    }


    /**
     * @return the localOneUniqueid
     */
    public String getLocalOneUniqueid() {
        return localOneUniqueid;
    }


    /**
     * @param localOneUniqueid the localOneUniqueid to set
     */
    public void setLocalOneUniqueid( String localOneUniqueid ) {
        this.localOneUniqueid = localOneUniqueid;
    }


    /**
     * @return the localOneLinkedid
     */
    public String getLocalOneLinkedid() {
        return localOneLinkedid;
    }


    /**
     * @param localOneLinkedid the localOneLinkedid to set
     */
    public void setLocalOneLinkedid( String localOneLinkedid ) {
        this.localOneLinkedid = localOneLinkedid;
    }


    /**
     * @return the localTwoChannel
     */
    public String getLocalTwoChannel() {
        return localTwoChannel;
    }


    /**
     * @param localTwoChannel the localTwoChannel to set
     */
    public void setLocalTwoChannel( String localTwoChannel ) {
        this.localTwoChannel = localTwoChannel;
    }


    /**
     * @return the localTwoChannelState
     */
    public Integer getLocalTwoChannelState() {
        return localTwoChannelState;
    }


    /**
     * @param localTwoChannelState the localTwoChannelState to set
     */
    public void setLocalTwoChannelState( Integer localTwoChannelState ) {
        this.localTwoChannelState = localTwoChannelState;
    }


    /**
     * @return the localTwoChannelStateDesc
     */
    public String getLocalTwoChannelStateDesc() {
        return localTwoChannelStateDesc;
    }


    /**
     * @param localTwoChannelStateDesc the localTwoChannelStateDesc to set
     */
    public void setLocalTwoChannelStateDesc( String localTwoChannelStateDesc ) {
        this.localTwoChannelStateDesc = localTwoChannelStateDesc;
    }


    /**
     * @return the localTwoCallerIDNum
     */
    public String getLocalTwoCallerIDNum() {
        return localTwoCallerIDNum;
    }


    /**
     * @param localTwoCallerIDNum the localTwoCallerIDNum to set
     */
    public void setLocalTwoCallerIDNum( String localTwoCallerIDNum ) {
        this.localTwoCallerIDNum = localTwoCallerIDNum;
    }


    /**
     * @return the localTwoCallerIDName
     */
    public String getLocalTwoCallerIDName() {
        return localTwoCallerIDName;
    }


    /**
     * @param localTwoCallerIDName the localTwoCallerIDName to set
     */
    public void setLocalTwoCallerIDName( String localTwoCallerIDName ) {
        this.localTwoCallerIDName = localTwoCallerIDName;
    }


    /**
     * @return the localTwoConnectedLineNum
     */
    public String getLocalTwoConnectedLineNum() {
        return localTwoConnectedLineNum;
    }


    /**
     * @param localTwoConnectedLineNum the localTwoConnectedLineNum to set
     */
    public void setLocalTwoConnectedLineNum( String localTwoConnectedLineNum ) {
        this.localTwoConnectedLineNum = localTwoConnectedLineNum;
    }


    /**
     * @return the localTwoConnectedLineName
     */
    public String getLocalTwoConnectedLineName() {
        return localTwoConnectedLineName;
    }


    /**
     * @param localTwoConnectedLineName the localTwoConnectedLineName to set
     */
    public void setLocalTwoConnectedLineName( String localTwoConnectedLineName ) {
        this.localTwoConnectedLineName = localTwoConnectedLineName;
    }


    /**
     * @return the localTwoLanguage
     */
    public String getLocalTwoLanguage() {
        return localTwoLanguage;
    }


    /**
     * @param localTwoLanguage the localTwoLanguage to set
     */
    public void setLocalTwoLanguage( String localTwoLanguage ) {
        this.localTwoLanguage = localTwoLanguage;
    }


    /**
     * @return the localTwoAccountCode
     */
    public String getLocalTwoAccountCode() {
        return localTwoAccountCode;
    }


    /**
     * @param localTwoAccountCode the localTwoAccountCode to set
     */
    public void setLocalTwoAccountCode( String localTwoAccountCode ) {
        this.localTwoAccountCode = localTwoAccountCode;
    }


    /**
     * @return the localTwoContext
     */
    public String getLocalTwoContext() {
        return localTwoContext;
    }


    /**
     * @param localTwoContext the localTwoContext to set
     */
    public void setLocalTwoContext( String localTwoContext ) {
        this.localTwoContext = localTwoContext;
    }


    /**
     * @return the localTwoExten
     */
    public String getLocalTwoExten() {
        return localTwoExten;
    }


    /**
     * @param localTwoExten the localTwoExten to set
     */
    public void setLocalTwoExten( String localTwoExten ) {
        this.localTwoExten = localTwoExten;
    }


    /**
     * @return the localTwoPriority
     */
    public Integer getLocalTwoPriority() {
        return localTwoPriority;
    }


    /**
     * @param localTwoPriority the localTwoPriority to set
     */
    public void setLocalTwoPriority( Integer localTwoPriority ) {
        this.localTwoPriority = localTwoPriority;
    }


    /**
     * @return the localTwoUniqueid
     */
    public String getLocalTwoUniqueid() {
        return localTwoUniqueid;
    }


    /**
     * @param localTwoUniqueid the localTwoUniqueid to set
     */
    public void setLocalTwoUniqueid( String localTwoUniqueid ) {
        this.localTwoUniqueid = localTwoUniqueid;
    }


    /**
     * @return the localTwoLinkedid
     */
    public String getLocalTwoLinkedid() {
        return localTwoLinkedid;
    }


    /**
     * @param localTwoLinkedid the localTwoLinkedid to set
     */
    public void setLocalTwoLinkedid( String localTwoLinkedid ) {
        this.localTwoLinkedid = localTwoLinkedid;
    }


    /**
     * @return the success
     */
    public String getSuccess() {
        return success;
    }


    /**
     * @param success the success to set
     */
    public void setSuccess( String success ) {
        this.success = success;
    }


    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }


    /**
     * @param id the id to set
     */
    public void setId( Integer id ) {
        this.id = id;
    }
}
