/**
 * @PackageName:      com.bithealth.chatCore
 * @FileName:     ChatMessageTest.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年8月5日 上午10:52:26  
 * 
 */
package com.bithealth.chatCore;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bithealth.chatCore.model.ChatMessage;
import com.bithealth.chatCore.model.ChatMessageExample;
import com.bithealth.chatCore.service.ChatMessageService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名称: ChatMessageTest  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月5日 上午10:52:26 
 * 
 * @author 胡翔
 * @version  
 */
public class ChatMessageTest extends BaseTest{
	
	@Autowired
	ChatMessageService service;
	@Test
	public void testInsert() throws Exception{
		ChatMessage chat = new ChatMessage();
		chat.setContentType((byte)1);
		chat.setContent("123123131");
		chat.setReceiver(1);
		chat.setReceiveType((byte)1);
		chat.setSendType((byte)2);
		chat.setSender(2);
		service.pushChatMessage(chat);
		System.out.println("insert后的id为："+chat.get_logid());
	}
	
}
