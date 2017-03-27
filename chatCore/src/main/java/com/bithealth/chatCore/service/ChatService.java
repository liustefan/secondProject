package com.bithealth.chatCore.service;

import com.bithealth.chatCore.model.ChatMessage;
/**
 * 类名称: ChatService  
 * 功能描述: 医患沟通服务接口
 * 日期: 2016年9月13日 下午4:15:26 
 * 
 * @author 周玉飞
 * @version  
 */
public interface ChatService {

	ChatMessage selectId(Integer id);
}
