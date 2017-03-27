/**
 * @PackageName:      com.bithealth.chatCore.facade.service
 * @FileName:     ChatMessageFacadeService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年8月3日 上午11:26:44  
 * 
 */
package com.bithealth.chatCore.facade.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.chatCore.model.ChatMessage;
import com.bithealth.chatCore.model.ChatMessageExample;
import com.bithealth.chatCore.model.ChatMessageVo;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: ChatMessageFacadeService  
 * 功能描述: TODO 聊天功能对外接口.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月3日 上午11:26:44 
 * 
 * @author 胡翔
 * @version  
 */
public interface ChatMessageFacadeService  extends GenericBaseService<ChatMessage,ChatMessageExample, Integer>{
	/**
	 * 
	 * @Title:pushChatMessage 
	 * @Description:TODO(保存并推送聊天消息).  
	 * @author 胡翔
	 * @param chat 需要推送的聊天消息信息
	 * @throws Exception 抛出异常，代表推送失败
	 */
	public Response saveAndPushChatMessage(ChatMessage chat) throws Exception;
	/**
	 * 
	 * @Title:getChatMessageById 
	 * @Description:TODO(通过聊天消息记录ID获取聊天消息,并更新消息接收时间).  
	 * @author 胡翔
	 * @param id 聊天表ID
	 * @return 返回聊天消息信息
	 * @throws 若数据存在就返回；获取失败，抛出异常
	 */
	public ChatMessage selectChatMessageById(Integer id) throws Exception;
	/**
	 * 
	 * selectByExampleAndPage 
	 * @Description:TODO(获取聊天消息的历史记录).  
	 * @author 曾许华
	 * @param page 分页查询对象
	 * @param example 查询条件
	 * @return 查询的结果集
	 */
	public List<ChatMessage> selectByExampleAndPage(Page<ChatMessage> page,ChatMessageExample example);

	/**
	 * 
	 * selectByChat 
	 * @Description:TODO(获取聊天消息的历史记录).  
	 * @author 曾许华
	 * @param page 分页查询对象
	 * @param id 查询条件当前人员的ID
	 * @return 查询的结果集
	 */
	Page<ChatMessage> selectByChat(Page<ChatMessage> page,@Param("id")Integer id);

	
	/**
	 * 
	 * selectByExampleAndPage 
	 * @Description:TODO(获取某些发送者们给接受者的最新消息) 
	 * @author liuxiaoqin
	 * @param page 分页查询对象
	 * @param example 查询条件
	 * @return 查询的结果集
	 */
	public List<ChatMessage> selectSendersNewMsgToReceiverPage(Page<ChatMessage> page,Integer receiver,String senders) throws Exception;
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	
	ChatMessage selectId(Integer id);
	
	/**
	 * selectDoctorToMemberMsgsPage 
	 * @Description:TODO(获取医生们发送给会员的最新消息) 
	 * @author liuxiaoqin
	 * @param 
	 * @return 查询的结果集
	 */
	public List<ChatMessageVo> selectDoctorToMemberMsgsPage(Integer receiver,Integer pageSize,Integer pageNow) throws Exception;
	
	/**
	 * selectDoctorToMemberMsgsPage 
	 * @Description:TODO(获取会员发送给医生的最新消息) 
	 * @author liuxiaoqin
	 * @param 
	 * @return 查询的结果集
	 */
	public List<ChatMessageVo> selectMemberToDoctorsgsPage(Integer receiver,String userName,Integer pageSize,Integer pageNow) throws Exception;
	
	 
	/**
	 * @Title:updateStatusByRefid 
	 * @Description:(根据引用类型和对应记录ID，变更对应的状态). 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author "jason chai"
	 * @param refType 引用类型：1-健教，2-复诊，3-测量，4-问卷调查，5-高血压随访(公卫)，6-糖尿病随访(公卫)
	 * @param refID  引用相关表记录ID
	 * @param refStatus  引用对应的状态：(问卷调查)1-未答、2-已答、3-已审核、4-已撤回
	 * @throws
	 * @retrun  
	 */ 
	public int updateStatusByRefid( Byte refType,Long refID,Byte refStatus);

	/**
	 * @Title:upStatusSendMsgByRefid 
	 * @Description:(根据引用类型和对应记录ID，变更对应的状态并发消息). 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author "jason chai"
	 * @param refType 引用类型：1-健教，2-复诊，3-测量，4-问卷调查，5-高血压随访(公卫)，6-糖尿病随访(公卫)
	 * @param refID  引用相关表记录ID
	 * @param refStatus  引用对应的状态：(问卷调查)1-未答、2-已答、3-已审核、4-已撤回
	 * @throws
	 * @retrun  
	 */ 
	public int upStatusSendMsgByRefid( Byte refType,Long refID,Byte refStatus);
		
}
