/**
 * 
 */
package org.asteriskjava.manager.event;

/**
 * Raised when two halves of a Local Channel begin to optimize themselves out of the media path.
 * 
 * @see https://wiki.asterisk.org/wiki/display/AST/Asterisk+13+ManagerEvent_LocalOptimizationBegin
 * 
 * @author <a href="mailto:nmazzon@teleniasoftware.it">Nicolò Mazzon</a>
 * @version 1.0.0 15-dic-2016
 */
public class LocalOptimizationBegin extends AbstractLocalOptimization {
    private static final long serialVersionUID = 8941721650166010936L;

    private String            sourceChannel;
    private Integer           sourceChannelState;
    private String            sourceChannelStateDesc;
    private String            sourceCallerIDNum;
    private String            sourceCallerIDName;
    private String            sourceConnectedLineNum;
    private String            sourceConnectedLineName;
    private String            sourceLanguage;
    private String            sourceAccountCode;
    private String            sourceContext;
    private String            sourceExten;
    private Integer           sourcePriority;
    private String            sourceUniqueid;
    private String            sourceLinkedid;
    private String            destUniqueId;

    public LocalOptimizationBegin( Object source ) {
        super( source );
    }


    /**
     * @return the sourceChannel
     */
    public String getSourceChannel() {
        return sourceChannel;
    }


    /**
     * @param sourceChannel the sourceChannel to set
     */
    public void setSourceChannel( String sourceChannel ) {
        this.sourceChannel = sourceChannel;
    }


    /**
     * @return the sourceChannelState
     */
    public Integer getSourceChannelState() {
        return sourceChannelState;
    }


    /**
     * @param sourceChannelState the sourceChannelState to set
     */
    public void setSourceChannelState( Integer sourceChannelState ) {
        this.sourceChannelState = sourceChannelState;
    }


    /**
     * @return the sourceChannelStateDesc
     */
    public String getSourceChannelStateDesc() {
        return sourceChannelStateDesc;
    }


    /**
     * @param sourceChannelStateDesc the sourceChannelStateDesc to set
     */
    public void setSourceChannelStateDesc( String sourceChannelStateDesc ) {
        this.sourceChannelStateDesc = sourceChannelStateDesc;
    }


    /**
     * @return the sourceCallerIDNum
     */
    public String getSourceCallerIDNum() {
        return sourceCallerIDNum;
    }


    /**
     * @param sourceCallerIDNum the sourceCallerIDNum to set
     */
    public void setSourceCallerIDNum( String sourceCallerIDNum ) {
        this.sourceCallerIDNum = sourceCallerIDNum;
    }


    /**
     * @return the sourceCallerIDName
     */
    public String getSourceCallerIDName() {
        return sourceCallerIDName;
    }


    /**
     * @param sourceCallerIDName the sourceCallerIDName to set
     */
    public void setSourceCallerIDName( String sourceCallerIDName ) {
        this.sourceCallerIDName = sourceCallerIDName;
    }


    /**
     * @return the sourceConnectedLineNum
     */
    public String getSourceConnectedLineNum() {
        return sourceConnectedLineNum;
    }


    /**
     * @param sourceConnectedLineNum the sourceConnectedLineNum to set
     */
    public void setSourceConnectedLineNum( String sourceConnectedLineNum ) {
        this.sourceConnectedLineNum = sourceConnectedLineNum;
    }


    /**
     * @return the sourceConnectedLineName
     */
    public String getSourceConnectedLineName() {
        return sourceConnectedLineName;
    }


    /**
     * @param sourceConnectedLineName the sourceConnectedLineName to set
     */
    public void setSourceConnectedLineName( String sourceConnectedLineName ) {
        this.sourceConnectedLineName = sourceConnectedLineName;
    }


    /**
     * @return the sourceLanguage
     */
    public String getSourceLanguage() {
        return sourceLanguage;
    }


    /**
     * @param sourceLanguage the sourceLanguage to set
     */
    public void setSourceLanguage( String sourceLanguage ) {
        this.sourceLanguage = sourceLanguage;
    }


    /**
     * @return the sourceAccountCode
     */
    public String getSourceAccountCode() {
        return sourceAccountCode;
    }


    /**
     * @param sourceAccountCode the sourceAccountCode to set
     */
    public void setSourceAccountCode( String sourceAccountCode ) {
        this.sourceAccountCode = sourceAccountCode;
    }


    /**
     * @return the sourceContext
     */
    public String getSourceContext() {
        return sourceContext;
    }


    /**
     * @param sourceContext the sourceContext to set
     */
    public void setSourceContext( String sourceContext ) {
        this.sourceContext = sourceContext;
    }


    /**
     * @return the sourceExten
     */
    public String getSourceExten() {
        return sourceExten;
    }


    /**
     * @param sourceExten the sourceExten to set
     */
    public void setSourceExten( String sourceExten ) {
        this.sourceExten = sourceExten;
    }


    /**
     * @return the sourcePriority
     */
    public Integer getSourcePriority() {
        return sourcePriority;
    }


    /**
     * @param sourcePriority the sourcePriority to set
     */
    public void setSourcePriority( Integer sourcePriority ) {
        this.sourcePriority = sourcePriority;
    }


    /**
     * @return the sourceUniqueid
     */
    public String getSourceUniqueid() {
        return sourceUniqueid;
    }


    /**
     * @param sourceUniqueid the sourceUniqueid to set
     */
    public void setSourceUniqueid( String sourceUniqueid ) {
        this.sourceUniqueid = sourceUniqueid;
    }


    /**
     * @return the sourceLinkedid
     */
    public String getSourceLinkedid() {
        return sourceLinkedid;
    }


    /**
     * @param sourceLinkedid the sourceLinkedid to set
     */
    public void setSourceLinkedid( String sourceLinkedid ) {
        this.sourceLinkedid = sourceLinkedid;
    }


    /**
     * @return the destUniqueId
     */
    public String getDestUniqueId() {
        return destUniqueId;
    }


    /**
     * @param destUniqueId the destUniqueId to set
     */
    public void setDestUniqueId( String destUniqueId ) {
        this.destUniqueId = destUniqueId;
    }
}
