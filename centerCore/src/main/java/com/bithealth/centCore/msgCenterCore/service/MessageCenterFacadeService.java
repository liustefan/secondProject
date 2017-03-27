/**
 * @PackageName:      com.bithealth.msgCenterCore.facade.service
 * @FileName:     MessageCenterFacadeService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年7月26日 下午2:41:57  
 * 
 */
package com.bithealth.centCore.msgCenterCore.service;

import java.util.List;

import com.bithealth.centCore.msgCenterCore.model.MessageCenter;
import com.bithealth.centCore.msgCenterCore.model.MessageCenterExample;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MessageCenterFacadeService  
 * 功能描述: 消息中心对外接口  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月26日 下午2:41:57 
 * 
 * @author 胡翔
 * @version  
 */
public interface MessageCenterFacadeService extends GenericBaseService<MessageCenter, MessageCenterExample, Integer>{
	/**
	 * 
	 * @Title:insertMessage 
	 * @Description: 同步插入或更新消息数据.  
	 * @author 胡翔
	 * @param 要插入或更新的消息记录对象
	 * @return 返回数据处理结果
	 */
	boolean insertOrUpdateMessageSynchronized(MessageCenter messageCenter) throws Exception;
	
	/**
	 * 
	 * @Title:insertMessage 
	 * @Description: 异步调用插入或更新消息数据.  
	 * @author 胡翔
	 * @param 要插入或更新的消息记录对象
	 * @return 返回数据处理结果
	 */
	boolean insertOrUpdateMessageAsynchronous(MessageCenter messageCenter) throws Exception;
	/**
	 * 
	 * @Title:getMessageList 
	 * @Description:TODO(根据分页条件和查询条件获取消息列表).  
	 * @author 胡翔
	 * @param page 分页条件对象
	 * @param example 列表查询对象
	 * @return 查询得到的分页结果
	 */
	List<MessageCenter> getMessageList(Page<MessageCenter> page,MessageCenterExample example);

	/**
	 * 
	 * selectByMessageList 
	 * @Description:TODO(所有消息的集合给手机端显示总数和类型).  
	 * @author 曾许华
	 * @param id 消息中心表id
	 * @return 所有消息的集合
	 */
	List<MessageCenter> selectByMessageList(List<Byte> list,String receiverGUID);
	
	/**
	 * 
	 * selectByMessageList 
	 * @Description:TODO(所有未读取消息的集合给appServer).  
	 * @author 曾许华
	 * @param List 消息中心表id
	 * @return 所有未读取消息的集合给appServer
	 */
	List<MessageCenter> selectByMessageListByIds(List litIds,Byte msgType); 
	/**
	 * 
	 * selectByMessageList 
	 * @Description:TODO(所有未读取消息的集合给appServer).  
	 * @author 曾许华
	 * @param List 消息中心表id
	 * @return 所有未读取消息的集合给appServer
	 */
	MessageCenter selectId(Integer id); 
	
	
	/**
	 * @Title:deleteMsgByParams 
	 * @Description:根据参数删除消息中心的消息，前置逻辑：最后的一条数据不删除（适用于 聊天，亲友动态，温馨提示等查看列表时全部删除的 类型）
	 * @author 谢美团
	 * @param recieverGUID
	 * @param senderGUID 类型为聊天是需要传，亲友动态和温馨提示传null 值
	 * @param msgType
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int deleteMsgByParams(String recieverGUID,String senderGUID,Byte msgType);
	
	

	/**
	 * @Title:deleteMsgById 
	 * @Description:根据主键删除消息中心的消息（适用于 报告，问卷等 查看一条数据删除一条数据的 类型）
	 * @author 谢美团
	 * @param id 主键id
	 * @param msgType
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int deleteMsgById(Integer id,Byte msgType,String recieverGUID);
	
	
	/**
	 * @Title:sendMsg 
	 * @Description:发送消息到推送服务
	 * @author 谢美团
	 * @param messageCenter
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun Response
	 */ 
	public  Response sendMsg(MessageCenter messageCenter) throws Exception;
	
	
	
	/**
	 * @Title:getMstTypeList 
	 * @Description:获取消息类型集合
	 * @author 谢美团
	 * @param type
	 * @return 
	 * @throws
	 * @retrun List<Integer>
	 */ 
	public List<Byte> getMsgTypeList(byte type);
	
	
}
