/**
 * @PackageName:      com.bithealth.chatCore.service
 * @FileName:     ChatMessageService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年7月19日 下午4:40:35  
 * 
 */
package com.bithealth.chatCore.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.bithealth.chatCore.model.ChatMessage;
import com.bithealth.chatCore.model.ChatMessageExample;
import com.bithealth.chatCore.model.ChatMessageVo;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: ChatMessageService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月19日 下午4:40:35 
 * 
 * @author 胡翔
 * @version  
 */
public interface ChatMessageService extends GenericBaseService<ChatMessage,ChatMessageExample,Integer> {
	/**
	 * 
	 * @Title:pushChatMessage 
	 * @Description:TODO(推送聊天消息).  
	 * @author 胡翔
	 * @param chat 需要推送的聊天消息信息
	 * @throws Exception 抛出异常，代表推送失败
	 */
	public Response pushChatMessage(ChatMessage chat) throws Exception;
	/**
	 * 
	 * @Title:getChatMessageById 
	 * @Description:TODO(通过ID获取聊天消息,并更新消息接收时间).  
	 * @author 胡翔
	 * @param id 聊天表ID
	 * @return 返回聊天消息信息
	 * @throws Exception 获取失败，抛出异常
	 */
	public ChatMessage getChatMessageById(Integer id) throws Exception;

	/**
	 * 
	 * selectByChat 
	 * @Description:TODO(获取聊天消息的历史记录).  
	 * @author 曾许华
	 * @param page 分页查询对象
	 * @param id 查询条件
	 * @return 查询的结果集
	 */
	Page<ChatMessage> selectByChat(Page<ChatMessage> page,@Param("id")Integer id);
	/**
	 * @Title:selectByChatCode 
	 * @Description:TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 胡翔
	 * @param page
	 * @param sId
	 * @param recId
	 * @return 
	 */ 
	Page<ChatMessage> selectByChatCode(Page<ChatMessage> page, Integer sId,
			Integer recId);
	
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

}
