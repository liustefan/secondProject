/**
 * @PackageName:      com.bithealth.msgCenterCore.service
 * @FileName:     MessageCenterService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年7月26日 下午2:40:33  
 * 
 */
package com.bithealth.centCore.msgCenterCore.service;

import java.util.List;

import com.bithealth.centCore.msgCenterCore.model.MessageCenter;
import com.bithealth.centCore.msgCenterCore.model.MessageCenterExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MessageCenterService  
 * 功能描述: TODO 消息中心业务接口.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月26日 下午2:40:33 
 * 
 * @author 胡翔
 * @version  
 */
public interface MessageCenterService extends GenericBaseService<MessageCenter, MessageCenterExample, Integer>{

	
	List<MessageCenter> selectByExample(MessageCenterExample example);
	
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
	int selectMaxIdByParam(String recieverGUID, String senderGUID,List<Byte> msgTypeList);
	
	
	/**
	 * @Title:selectMaxIdByMsgType 
	 * @Description:根据参数获取最大的主键id
	 * @author 谢美团
	 * @param msgType
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	int selectMaxIdByMsgType(Byte msgType,String recieverGUID);
}
