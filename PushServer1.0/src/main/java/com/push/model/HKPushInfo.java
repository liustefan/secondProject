package com.push.model;

import java.util.Date;


/**
 * @author xiemt
 *
 */
/**
 * @author lenovo
 *
 */
public class HKPushInfo {
	
	private int id ;
	
	//会员id
	private String memberId;
	
	//多个会员id
	private String memberIds;
	
	//应用用户id
	private String userId;
	
	//通道
	private String channelId;
	
	//多个
	private String[] channelIds;

	//推送第三方平台
	private Integer platform;
	
	//在线状态
	private Integer lineStatus;
	
	private Integer deviceType = 0;
	
	//需要推送的消息内容
	private String data;
	
	//消息类型，取值如下：0：透传消息 1：通知 ;默认为 0
	private Integer msgType = 0;
	
	//消息唯一标识符
	private String msgId;
	
	//消息发送者
	private String sender;
	
	//标签
	private String tag;
	
	//多个标签
	private String tags;
	
	//tag对应的模块id
	private String model;
	
	//操作类型，参数值：0：更新；1：增加
	private String type;
	
	//角色登录的平台：0：android；1：ios
	private Integer loginPlatform;
	
	//数字签名
	private String sign;

	//消息状态 ,0：推送成功；1：未推送；2：推送失败
	private Integer messengerStatus;
	
	//通知标题
	private String title;
	//通知描述
	private String description;
	//登陆时间
	private Date loginTime;
	//消息延迟推送的推送时间
	private long sendTime = 0;
	
	
    /**
     * 应用的消息未读数量 
     */
    private int badge;

    public int getBadge() {
		return badge;
	}

	public void setBadge(int badge) {
		this.badge = badge;
	}

	public long getSendTime() {
		return sendTime;
	}
	public void setSendTime(long sendTime) {
		this.sendTime = sendTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getMessengerStatus() {
		return messengerStatus;
	}
	public void setMessengerStatus(Integer messengerStatus) {
		this.messengerStatus = messengerStatus;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public Integer getPlatform() {
		return platform;
	}
	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
	public Integer getLineStatus() {
		return lineStatus;
	}
	public void setLineStatus(Integer lineStatus) {
		this.lineStatus = lineStatus;
	}
	public String getMemberIds() {
		return memberIds;
	}
	public void setMemberIds(String memberIds) {
		this.memberIds = memberIds;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getMsgType() {
		return msgType;
	}
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getLoginPlatform() {
		return loginPlatform;
	}
	public void setLoginPlatform(Integer loginPlatform) {
		this.loginPlatform = loginPlatform;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String[] getChannelIds() {
		return channelIds;
	}
	public void setChannelIds(String[] channelIds) {
		this.channelIds = channelIds;
	}
}