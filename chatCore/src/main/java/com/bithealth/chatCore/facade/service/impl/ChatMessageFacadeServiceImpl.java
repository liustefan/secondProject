/**
 * @PackageName:      com.bithealth.chatCore.facade.service.impl
 * @FileName:     ChatMessageFacadeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年8月3日 上午11:32:23  
 * 
 */
package com.bithealth.chatCore.facade.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.agentCore.AgentStatus;
import com.bithealth.chatCore.facade.service.ChatMessageFacadeService;
import com.bithealth.chatCore.model.ChatMessage;
import com.bithealth.chatCore.model.ChatMessageExample;
import com.bithealth.chatCore.model.ChatMessageVo;
import com.bithealth.chatCore.service.ChatService;
import com.bithealth.chatCore.service.ChatMessageService; 
import com.bithealth.memberCore.member.model.MemAccount;
import com.bithealth.memberCore.member.model.MemAccountExample;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: ChatMessageFacadeServiceImpl  
 * 功能描述: TODO 聊天功能对外接口的业务实现类.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月3日 上午11:32:23 
 * 
 * @author 胡翔
 * @version  
 */
@Service
public class ChatMessageFacadeServiceImpl   extends GenericBaseServiceImpl<ChatMessage,ChatMessageExample,Integer> implements ChatMessageFacadeService{

	private static Logger logger = LoggerFactory.getLogger(ChatMessageFacadeServiceImpl.class);

	@Autowired
	private ChatMessageService chatMessageService;
	@Autowired
	private ChatService chatService;
	
	@Override
	public Response saveAndPushChatMessage(ChatMessage chat) {
		logger.info("聊天入库保存和推送:saveAndPushChatMessage");
		chat.setSendTime(new Date());
		Response res = new Response();
		try{
			int id=chatMessageService.insert(chat);
			logger.info("聊天入库保存状态:"+id);
			if(id!=1){
				logger.info("聊天入库保存失败");
				res.setStatus(0);
				res.setBody("保存消息失败。");
				return res;
			}
		}catch(Exception e){
			logger.info("聊天入库保存出现异常");
			res.setStatus(0);
			res.setBody("保存消息异常。");
			return res;
		}
		Response resp = null;
		try {
			logger.info("聊天开始推送");
			resp = chatMessageService.pushChatMessage(chat);
		} catch (Exception e) {
			logger.info("聊天推送异常");
			resp.setStatus(0);
			resp.setBody("推送消息失败。");
			e.printStackTrace();
			return resp;
		}
		if(resp == null){
			logger.error("消息推送失败！statusCode:{}");
		}else{
			if(AgentStatus.SC_OK == resp.getStatus()){
				logger.info("消息推送成功！！");
			}else{
				logger.error("消息推送失败！!{}",resp.getBody());
			}
		}
		return resp;
	}

	@Override
	public ChatMessage selectChatMessageById(Integer id) throws Exception {
		return chatMessageService.getChatMessageById(id);
	}

	@Override
	public List<ChatMessage> selectByExampleAndPage(Page<ChatMessage> page,
			ChatMessageExample example) {
		return chatMessageService.selectByExampleAndPage(page, example);
	}
	
	@Override
	public List<ChatMessage> selectSendersNewMsgToReceiverPage(Page<ChatMessage> page,Integer receiver,String senders) throws Exception{
		return chatMessageService.selectSendersNewMsgToReceiverPage(page, receiver,senders);
	}

	@Override
	public Page<ChatMessage> selectByChat(Page<ChatMessage> page, Integer id) {
		return chatMessageService.selectByChat(page, id);
	}

	@Override
	public GenericBaseDao getDao() {
		return null;
	}

	@Override
	public ChatMessage selectId(Integer id) {
		return chatService.selectId(id);
	}
	
	/**
	 * selectDoctorToMemberMsgsPage 
	 * @Description:TODO(获取医生们发送给会员的最新消息) 
	 * @author liuxiaoqin
	 * @param 
	 * @return 查询的结果集
	 */
	public List<ChatMessageVo> selectDoctorToMemberMsgsPage(Integer receiver,Integer pageSize,Integer pageNow) throws Exception{
		return chatMessageService.selectDoctorToMemberMsgsPage(receiver,pageSize,pageNow);
	}
	
	/**
	 * selectDoctorToMemberMsgsPage 
	 * @Description:TODO(获取会员发送给医生的最新消息) 
	 * @author liuxiaoqin
	 * @param 
	 * @return 查询的结果集
	 */
	public List<ChatMessageVo> selectMemberToDoctorsgsPage(Integer receiver,String userName,Integer pageSize,Integer pageNow) throws Exception{
		return chatMessageService.selectMemberToDoctorsgsPage(receiver,userName,pageSize,pageNow);
	}

	 
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
	public int updateStatusByRefid( Byte refType,Long refID,Byte refStatus){ 
		 
		ChatMessageExample example = new ChatMessageExample();
		example.createCriteria().andRefTypeEqualTo(refType) .andRefIDEqualTo(refID); 
		
		ChatMessage record = new ChatMessage();
		record.setRefStatus(refStatus);  
		
	    return	chatMessageService.updateByExampleSelective(record, example);
	}
	
	public int upStatusSendMsgByRefid( Byte refType,Long refID,Byte refStatus){ 
		 
		ChatMessageExample example = new ChatMessageExample();
		example.createCriteria().andRefTypeEqualTo(refType) .andRefIDEqualTo(refID); 
		
		ChatMessage record = new ChatMessage();
		record.setRefStatus(refStatus);  
		
	   int updaterecord = 	chatMessageService.updateByExampleSelective(record, example);

       if (updaterecord>0)	{ 
 		   List<ChatMessage> list = chatMessageService.selectByExample(example);
 		    for(ChatMessage chat:list){
 		    	Response resp = null;
 				try {
 					logger.info("聊天开始推送");
 					resp = chatMessageService.pushChatMessage(chat);
 				} catch (Exception e) {
 					logger.info("聊天推送异常");
 					resp.setStatus(0);
 					resp.setBody("推送消息失败。");
 					e.printStackTrace();
 				
 				}
 				if(resp == null){
 					logger.error("消息推送失败！statusCode:{}");
 				}else{
 					if(AgentStatus.SC_OK == resp.getStatus()){
 						logger.info("消息推送成功！！");
 					}else{
 						logger.error("消息推送失败！!{}",resp.getBody());
 					}
 				} 
 		    } 
	    }
	   
		return updaterecord;
	    
	}
}
