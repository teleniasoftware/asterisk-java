package org.asteriskjava.manager.event;

public class PickupEvent extends ManagerEvent
{
	private static final long serialVersionUID = 1L;
    
    private String channel;
    private String uniqueId;
    private String linkedId;
    private String targetChannel;
    private String targetUniqueId;
    private String targetLinkedId;
    
	public PickupEvent(Object source) 
	{
		super(source);
	}



	public String getChannel()
	{
		return channel;
	}

	public void setChannel(String channel)
	{
		this.channel = channel;
	}

	public String getTargetChannel()
	{
		return targetChannel;
	}

	public void setTargetChannel(String targetchannel)
	{
		this.targetChannel = targetchannel;
	}


    /**
     * @return the uniqueId
     */
    public String getUniqueId() {
        return uniqueId;
    }


    /**
     * @param uniqueId the uniqueId to set
     */
    public void setUniqueId( String uniqueId ) {
        this.uniqueId = uniqueId;
    }


    /**
     * @return the linkedId
     */
    public String getLinkedId() {
        return linkedId;
    }


    /**
     * @param linkedId the linkedId to set
     */
    public void setLinkedId( String linkedId ) {
        this.linkedId = linkedId;
    }


    /**
     * @return the targetUniqueId
     */
    public String getTargetUniqueId() {
        return targetUniqueId;
    }


    /**
     * @param targetUniqueId the targetUniqueId to set
     */
    public void setTargetUniqueId( String targetUniqueId ) {
        this.targetUniqueId = targetUniqueId;
    }


    /**
     * @return the targetLinkedId
     */
    public String getTargetLinkedId() {
        return targetLinkedId;
    }


    /**
     * @param targetLinkedId the targetLinkedId to set
     */
    public void setTargetLinkedId( String targetLinkedId ) {
        this.targetLinkedId = targetLinkedId;
    }

}
