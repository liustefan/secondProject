/**
 * @PackageName:      com.bithealth.chatCore.service.impl
 * @FileName:     ChatMessageServicepImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 下午4:32:14  
 * 
 */
package com.bithealth.chatCore.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.agentCore.agent.RedicrectService;
import com.bithealth.agentCore.bean.Parameter;
import com.bithealth.chatCore.dao.ChatMessageMapper;
import com.bithealth.chatCore.enmu.RefStatusEnum;
import com.bithealth.chatCore.model.ChatMessage;
import com.bithealth.chatCore.model.ChatMessageExample;
import com.bithealth.chatCore.model.ChatMessageVo;
import com.bithealth.chatCore.service.ChatMessageService;
import com.bithealth.chatCore.utils.PushUtils;
import com.bithealth.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
import com.bithealth.msgCenterCore.model.MessageCenter;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: ChatMessageServicepImpl  
 * 功能描述: TODO ADD 聊天消息业务服务接口实现类
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 下午4:32:14 
 * 
 * @author 曾许华
 * @version  
 */
@Service
public class ChatMessageServicepImpl extends GenericBaseServiceImpl<ChatMessage, ChatMessageExample, Integer> implements ChatMessageService{

	private static Logger logger = LoggerFactory.getLogger(ChatMessageServicepImpl.class);
	
	@Autowired
	private ChatMessageMapper chatMessageMapper;
	@Autowired
	private MessageCenterFacadeService messageCenterFacadeService;
	@Autowired
	private RedicrectService redirectImpl;
	private Parameter parameter= new Parameter();
	private Response resp;
	/**
	 * 调用推送平台消息推送接口协议
	 * @Title:pushsChatMessage
	 * @Description:TODO(给接收者推送一条信息。通知他有新的聊天记录).  
	 * @author 曾许华
	 * @param chat 聊天消息记录
	 * @throws RuntimeException 运行时异常，聊天消息发送失败时，回滚保存的聊天消息
	 */ 
	public Response pushChatMessage(ChatMessage chat) throws RuntimeException {
		logger.info("聊天推送开始,pushChatMessage方法");
		MessageCenter messageCenter = new MessageCenter();
		messageCenter.setCreatetime(new Date());
		 
		
		Byte sendType  = chat.getSendType();
		String senderName = chat.getSenderName();
		String sendcontent = chat.getContent(); 
 
		if(chat.getRefType()==null){
			   
	         Byte contentType  = chat.getContentType(); 
//	  		 if (contentType==1){
//	  		    	sendcontent =sendcontent;
//	  		 }
//	  	     else
	  	      if (contentType==2){
	  	    	sendcontent ="发来一张图片";
	  	     }else if(contentType==3){
	  	    	 sendcontent=  "发来一段语音";
	  	     }else if(contentType==4){
	  	    	 sendcontent="发来一段视频";
	  	     } 
		 }
		  if(sendcontent!=null&&sendcontent.length()>=60){
			  sendcontent = sendcontent.substring(0,57)+"..."; 
//		    	if(lastContentNotice.indexOf("】")<0){
//		    		lastContentNotice = lastContentNotice.substring(0,56)+"...】";
//			    		
//		    	}
		    	
		    }
		  
		messageCenter.setLastcontent(sendcontent);
		 
	     
//	    则显示内容【医生姓名】医生发来一段语音或【医生姓名】医生发来一张图片
	     
	     String lastContentNotice = chat.getLastContentNotice();
	     
	     
		 if (lastContentNotice==null||lastContentNotice.equals("")){
			 lastContentNotice = chat.getContent();
 
//		     	若收到的是问卷调查任务消息，通知消息显示内容：您收到一条待答/已审核问卷：【问卷名称】
		     
//		     	若收到的是健教任务消息，通知消息显示内容：您收到新的健教文章：【健教标题】
//		     	若收到的是复诊任务消息，通知消息显示内容：您收到一条复诊提醒：【任务概述内容】
//		     	若收到的是测量任务消息，通知消息显示内容：您收到一条测量提醒：【任务概述内容】
//		     	若收到的是高血压随访(公卫)任务消息，通知消息显示内容：您收到一条高血压随访消息：【任务概述内容】
//		     	若收到的是糖尿病随访(公卫)任务消息，通知消息显示内容：您收到一条糖尿病随访消息：【任务概述内容】
		     
//		       ***********	若收到的是亲友关怀温馨提示，显示内容：【发送人】:【温馨提示内容】  
//		       ***********---若收到的是我的问卷提示，显示内容：您收到一条待答/已审核问卷：【问卷名称】
//		       ************----	若收到的是亲友动态消息，显示内容：【动态消息内容】 
//		      *****************	若收到的是健康资讯消息，显示内容：您收到新的健康资讯：【健康资讯标题】
//		      ----*************	若收到的是医生提醒温馨提示，显示内容：【发送人】医生:【温馨提示内容】
//		       	若收到的是我的咨询消息，显示内容：【医生姓名】医生:【咨询回复内容】
//		                   若收到的是测量报告提示，显示内容：您收到一条测量报告：[测量报告标题]
		       
		     /**
		      * [3.0]引用类型：1-健教，2-复诊，3-测量，4-单份问卷，5-组合问卷，6-高血压随访(公卫)，7-糖尿病随访(公卫)
		      */
		       Byte refType =  0;
		       refType  = chat.getRefType();
		     
		       Byte   refStatus = chat.getRefStatus(); 
		       if (refType!=null)
		       switch(refType)

		       {
		       case 1:
		       
		    	   lastContentNotice = "您收到新的健教文章："+lastContentNotice;
		    	   break;
		       case 2:
		    	   lastContentNotice = "您收到一条复诊提醒："+lastContentNotice;
		    	   break;
		       case 3:
		    	   lastContentNotice = "您收到一条测量提醒："+lastContentNotice;
		    	   break;
		       case  4:
		       case  5:
		    	   
		    	     lastContentNotice = "您收到一条"+RefStatusEnum.getEnumByCode(refStatus).getName()+"问卷："+lastContentNotice;
		    	      
		    	   break; 
		       case 6:
		    	   lastContentNotice = "您收到一条高血压随访消息："+lastContentNotice;
		    	   break;
		       case 7:
		    	   lastContentNotice = "您收到一条糖尿病随访消息："+lastContentNotice;
		    	   break;
		       default:
		    	
		      }
		       
		       if(chat.getRefType()==null){
				   
			         Byte contentType  = chat.getContentType(); 
			  		 if (contentType==1){
			  		    	sendcontent =":"+sendcontent;
			  		 }
			  	     else if (contentType==2){
			  	    	sendcontent ="发来一张图片";
			  	     }else if(contentType==3){
			  	    	 sendcontent=  "发来一段语音";
			  	     }else if(contentType==4){
			  	    	 sendcontent="发来一段视频";
			  	     }
//			  	     * 发送类型：0-系统，1-医生，2-会员 
			  	     if (sendType==1){
			  	    	lastContentNotice= senderName+"医生"+sendcontent;
			  	     }else if(sendType==2){
			  	    	lastContentNotice=senderName +sendcontent;
			  	     }
			        ;
				 }
		       
		 } 
	     
	    if(lastContentNotice!=null&&lastContentNotice.length()>=60){
	    	lastContentNotice = lastContentNotice.substring(0,57)+"..."; 
//	    	if(lastContentNotice.indexOf("】")<0){
//	    		lastContentNotice = lastContentNotice.substring(0,56)+"...】";
//		    		
//	    	}
	    	
	    }
	    
		messageCenter.setLastContentNotice(lastContentNotice);
		messageCenter.setMsgtype(MessageTypeEnum.MY_CONSULT.getType());
		messageCenter.setLastsourceid(Long.parseLong(chat.get_logid().toString()));
		messageCenter.setNumber(0);
		messageCenter.setReceiver(chat.getReceiverGUID().toString());
		messageCenter.setReceivetype(chat.getReceiveType());
		messageCenter.setScheduletime(new Date());
		messageCenter.setSender(chat.getSenderGUID().toString());
		messageCenter.setSendtype(chat.getSendType());
		messageCenter.setUpdatetime(new Date());
		try {
			logger.info("聊天推送,调用消息同步的接口");
			resp=messageCenterFacadeService.insertOrUpdateMessageSynchronized(messageCenter);
		} catch (Exception e) {
			logger.info("聊天推送,调用消息同步的接口异常");
			e.printStackTrace();
			resp.setBody("出现异常");
		}
		logger.info("聊天推送,调用消息同步的接口完成状态为:"+resp.getStatus());
		return resp;
	}

	
	/**
	 * @Title:caculateSign 
	 * @Description:TODO(计算推送接口的签名值).  
	 * @author 胡翔 
	 * @param map 参数集合
	 * @param pushUrl 推送URL
	 */ 
	private String caculateSign(String pushUrl, TreeMap map) {
		StringBuffer sign = new StringBuffer();
		sign.append(PushUtils.encode(pushUrl.getBytes()));
		Set<Entry<String, Object>> set = map.entrySet();
		for(Entry<String, Object> entry : set){
			String key = entry.getKey();
			String value = entry.getValue().toString();
			try {
				sign.append(key).append(PushUtils.encode(value.getBytes()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return PushUtils.MD5(sign.toString().getBytes());
	}

	/**
	 * @Title:getChatMessage 
	 * @Description:TODO(获取推送的聊天消息记录，更新用户接收消息时间).  
	 * @author 胡翔
	 * @param request  请求对象
	 * @return 返回的数据对象
	 * @throws Exception 
	 */ 
	public ChatMessage getChatMessageById(Integer id) throws Exception {
		//保存消息读取时间
		ChatMessage chat = chatMessageMapper.selectByPrimaryKey(id);
		if(chat == null){
			throw new Exception("["+id+"]聊天消息不存在!");
		}
		update(chat);
		return chat;
	}
	@Override
	public int update(ChatMessage model) {
		model.setReceiveTime(new Date());
		return chatMessageMapper.updateByPrimaryKeySelective(model);
	}
	@Override
	public GenericBaseDao<ChatMessage, ChatMessageExample, Integer> getDao() {
		return chatMessageMapper;
	}
	
	/**
	 * 
	 * selectByExampleAndPage 
	 * @Description:TODO(获取某些发送者们给接受者的最新消息) 
	 * @author liuxiaoqin
	 * @param page 分页查询对象
	 * @param example 查询条件
	 * @return 查询的结果集
	 */
	public List<ChatMessage> selectSendersNewMsgToReceiverPage(Page<ChatMessage> page,Integer receiver,String senders)throws Exception {
		List<ChatMessage> list = new ArrayList<ChatMessage>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("receiver", receiver);
		param.put("senders", senders);
		list = chatMessageMapper.selectSendersNewMsgToReceiverPage(page,param);
		return list;
	}

	/** 
	     * @Title: send 
	     * @Description: TODO 简单描述该方法的实现功能（可选）.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.chatCore.service.ChatMessageService#selectByChat(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.lang.Integer)
	     */
	@Override
	public Page<ChatMessage> selectByChat(Page<ChatMessage> page, Integer id) {
		chatMessageMapper.selectByChat(page, id);
		return page;
	}
	
	@Override
	public Page<ChatMessage> selectByChatCode(Page<ChatMessage> page, Integer sId,Integer recId) {
		chatMessageMapper.selectByChatCode(page, sId,recId);
		return page;
	}

	/**
	 * selectDoctorToMemberMsgsPage 
	 * @Description:TODO(获取医生们发送给会员的最新消息) 
	 * @author liuxiaoqin
	 * @param 
	 * @return 查询的结果集
	 */
	public List<ChatMessageVo> selectDoctorToMemberMsgsPage(Integer receiver,Integer pageSize,Integer pageNow) throws Exception{
		List<ChatMessageVo> list = new ArrayList<ChatMessageVo>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("receiver", receiver);
		param.put("pageSize", pageSize);
		param.put("pageNow", pageNow);
		list = chatMessageMapper.selectDoctorToMemberMsgsPage(param);
		return list;
	}
	
	/**
	 * selectDoctorToMemberMsgsPage 
	 * @Description:TODO(获取会员发送给医生的最新消息) 
	 * @author liuxiaoqin
	 * @param 
	 * @return 查询的结果集
	 */
	public List<ChatMessageVo> selectMemberToDoctorsgsPage(Integer receiver,String userName,Integer pageSize,Integer pageNow) throws Exception{
		List<ChatMessageVo> list = new ArrayList<ChatMessageVo>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("receiver", receiver);
		param.put("userName", "%"+userName+"%");
		param.put("pageSize", pageSize);
		param.put("pageNow", pageNow);
		list = chatMessageMapper.selectMemberToDoctorsgsPage(param);
		return list;
	}
	
}
