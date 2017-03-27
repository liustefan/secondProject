/**
 * @PackageName:      com.bithealth.msgCenterCore.service.impl
 * @FileName:     MessageCenterServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年7月26日 下午3:33:20  
 * 
 */
package com.bithealth.centCore.msgCenterCore.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.centCore.msgCenterCore.dao.MessageCenterMapper;
import com.bithealth.centCore.msgCenterCore.service.MessageCenterService;
import com.bithealth.centCore.msgCenterCore.model.MessageCenter;
import com.bithealth.centCore.msgCenterCore.model.MessageCenterExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MessageCenterServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月26日 下午3:33:20 
 * 
 * @author 胡翔
 * @version  
 */
@Service
public class MessageCenterServiceImpl extends GenericBaseServiceImpl<MessageCenter,MessageCenterExample,Integer> implements MessageCenterService{

	@Autowired
	private MessageCenterMapper messageCenterMapper;
	
	@Override
	public GenericBaseDao<MessageCenter, MessageCenterExample, Integer> getDao() {
		return this.messageCenterMapper;
	}
	
	public int insert(MessageCenter message){
		return messageCenterMapper.insert(message);
	}

	 public List<MessageCenter>  selectByExample( MessageCenterExample example){
		 return messageCenterMapper.selectByExample(example);
	 }

	@Override
	public int selectMaxIdByParam(String recieverGUID, String senderGUID,List<Byte> msgTypeList) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("recieverGUID", recieverGUID);
		paramMap.put("senderGUID", senderGUID);
		paramMap.put("list", msgTypeList);
		return messageCenterMapper.selectMaxIdByParam(paramMap);
	}

	@Override
	public int selectMaxIdByMsgType(Byte msgType ,String recieverGUID) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("msgType", msgType);
		paramMap.put("recieverGUID", recieverGUID);
		return messageCenterMapper.selectMaxIdByMsgType(paramMap);
	}
}
