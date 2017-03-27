/*
 * MessageCenterMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-26 Created
 */
package com.bithealth.centCore.msgCenterCore.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bithealth.centCore.msgCenterCore.model.MessageCenter;
import com.bithealth.centCore.msgCenterCore.model.MessageCenterExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
/**
 * 
 * 类名称: MessageCenterMapper  
 * 功能描述: TODO 消息中心持久化层  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月1日 下午2:38:50 
 * 
 * @author 胡翔
 * @version
 */
public interface MessageCenterMapper extends GenericBaseDao<MessageCenter,MessageCenterExample,Integer> {
	
	List<MessageCenter> selectByExample(MessageCenterExample example);	

	public List<MessageCenter> getMyChatMessage(MessageCenter messageCenter);
	
	List<MessageCenter> selectByMessageList(@Param("list")List<Byte> list,@Param("receiverGUID")String receiverGUID,@Param("nowDate")Date nowDate);
	
	List<MessageCenter> selectByMessageListByIds(@Param("list")List list,@Param("msgType")Byte msgType);
	
	MessageCenter selectId(@Param("logID")Integer id);
	
	/**
	 * @Title:selectMaxIdByParam 
	 * @Description:根据参数获取最大的主键id
	 * @author 谢美团
	 * @param recieverGUID
	 * @param senderGUID
	 * @param msgTypeList
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	int selectMaxIdByParam(Map<String,Object> paramMap);
	
	
	
	/**
	 * @Title:selectMaxIdByMsgType 
	 * @Description:根据msgType获取最大的主键id
	 * @author 谢美团
	 * @param msgType
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	int selectMaxIdByMsgType(Map<String,Object> paramMap);
	
	
}