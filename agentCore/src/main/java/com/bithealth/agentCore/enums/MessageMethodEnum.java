/**
 * @PackageName:      com.bithealth.agentCore.enums
 * @FileName:     MessageMethodEnum.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年9月5日 下午1:44:53  
 * 
 */
package com.bithealth.agentCore.enums;

import com.bithealth.agentCore.Constrants;

/**
 * 类名称: MessageMethodEnum  
 * 功能描述: 消息中心服务方法.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月5日 下午1:44:53 
 * 
 * @author liuhm
 * @version  
 */
public enum MessageMethodEnum implements Method {
	MessageList("msgCenter/getMessageListByIds", "获取消息信息"),
	MessageDeleteBySendAndReceiver("msgCenter/deleteBySendAndReceiver", "删除消息中心的聊天记录信息"),
	MessageSynchronized("msgCenter/insertOrUpdateMessageSynchronized", "同步插入或更新消息数据"),
	MessageAsynchronous("msgCenter/insertOrUpdateMessageAsynchronous", "异步调用插入或更新消息数据"),
	MessageDelete("msgCenter/deleteById", "删除消息记录"),
	MessageUpdate("msgCenter/update", "更新消息记录"),
	CareMessageList("care/getMyCareMessageForWebClient", "医生端调用获取温馨提示列表"),
	SendMsgToCareMeMember("care/sendMsgToCareMeMemberForWeb", "医生端调用发送测量数据或公卫服务消息给关注我的人"),
	DeleteKindlyReminder("care/deleteKindlyReminderForWebClient", "医生端调用 删除温馨提示"),
	KindlyReminder("care/sendKindlyReminderForWebClient", "医生端发送医生嘱咐（温馨提示）给指定会员"),
	SaveSmsConfig("sms/saveSmsConfig", "医生端 新增或更新组织短信配置"),
	SmsList("sms/getSmsList", "获取短信发送记录(医生端调用)"),
	SmsStatistic("sms/getSmsStatistic", "统计组织及其子组织的短信发送数据"),
	SendSms("sms/smsSend", "医生端或其他应用发送短信到指定的手机上（支持群发）"),
	GetSmsConfig("sms/getSmsConfig", "获取组织的短信配置"),
	DeleteSmsConfig("sms/deleteSmsConfig", "删除组织的短信配置"),
	MergeCareData("care/MergeCareData", "合并关注数据");

	private String method;
	private String description;
	
	private MessageMethodEnum(String method, String description) {
		this.method = method;
		this.description = description;
	}
	
	@Override
	public String getUrl() {
		return Constrants.MESSAGE_URL + this.method;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

}
