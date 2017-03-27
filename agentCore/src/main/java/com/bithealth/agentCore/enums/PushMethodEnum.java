/**
 * @PackageName:      com.bithealth.agentCore
 * @FileName:     MethodEnum.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月23日 上午9:54:45  
 * 
 */
package com.bithealth.agentCore.enums;

import com.bithealth.agentCore.Constrants;

/**
 * 类名称: MethodEnum  
 * 功能描述: 推送接口名称定义.  
 * 日期: 2016年8月23日 上午9:54:45 
 * 
 * @author liuhm
 * @version  
 */
public enum PushMethodEnum implements Method {
	
	Broadcast("pushToAll", "广播推送"),
	Role_Online("roleOnline", "用户上线"),
	Role_Offline("roleOffline", "用户离线"),
	Tag_Specific("pushByTag", "根据tag推送到指定用户群"),
	Tags_Specific("pushByTags", "多个tag推送到指定用户群"),
	Tag_Update("updateTag", "tag更新"),
	Tag_Add("addNewTag", "tag新增"),
	Tag_delete("deleteTag", "tag删除"),
	Message_Received("msgReceived", "消息成功接收"),
	SmsOrVoice_Send("smsOrVoiceSend", "短信或语音推送"),
	Sms_Status("msgStatus", "短信语音发送状态"),
	User_Specific("pushByMemberId", "推送到指定的对象"),
	Users_Specific("pushByMemberIds", "推送指定的一批对象");
	
	
	private String method;
	
	private String description;
	
	private PushMethodEnum(String method, String description) {
		this.method = method;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String getUrl() {
		return Constrants.PUSH_URL + "/" + this.method;
	}
}
