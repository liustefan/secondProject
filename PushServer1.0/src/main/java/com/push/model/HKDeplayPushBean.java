package com.push.model;

/**
 * @author xiemt
 *
 */
public class HKDeplayPushBean implements java.io.Serializable{
	/**
	* TODO
	*/
	
	private static final long serialVersionUID = 1L;
	//会员id
	private String memberId;
	//消息唯一标识符
	private String msgId;
	//消息延迟推送的推送时间
	private long sendTime = 0;

	public long getSendTime() {
		return sendTime;
	}
	public void setSendTime(long sendTime) {
		this.sendTime = sendTime;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}