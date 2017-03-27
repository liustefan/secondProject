package com.bithealth.chatCore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.chatCore.model.ChatMessage;
import com.bithealth.chatCore.service.ChatService;
import com.bithealth.chatCore.service.ChatMessageService;
/**
 * 类名称: chatServiceImpl  
 * 功能描述: 医患沟通服务接口实现
 * 日期: 2016年9月13日 下午4:15:26 
 * 
 * @author 周玉飞
 * @version  
 */
@Service
public class chatServiceImpl implements ChatService {

	@Autowired
	private ChatMessageService chatMessageService;

	@Override
	public ChatMessage selectId(Integer id) {
		
		return chatMessageService.selectById(id);
	}
	
	

}
