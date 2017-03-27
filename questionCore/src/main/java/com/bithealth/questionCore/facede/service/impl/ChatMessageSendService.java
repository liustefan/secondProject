 
/**
 * @PackageName:      com.bithealth.questionCore.facede.service.impl
 * @FileName:     ChatMessageSendService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2017年1月16日 上午9:18:04  
 * 
 */

package com.bithealth.questionCore.facede.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bithealth.chatCore.constants.ChatUserTypeEnum;
import com.bithealth.chatCore.enmu.ChatRefTypeEnmu;
import com.bithealth.chatCore.enmu.RefStatusEnum;
import com.bithealth.chatCore.facade.service.ChatMessageFacadeService;
import com.bithealth.chatCore.model.ChatMessage;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.sdk.common.utils.TimeUtil;


/**
 * 类名称: ChatMessageSendService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2017年1月16日 上午9:18:04 
 * 
 * @author baozj
 * @version  
 */
public class ChatMessageSendService {

	protected static Logger logger = Logger.getLogger(ChatMessageSendService.class);
	
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private MemberService memberService;
	@Autowired
	ChatMessageFacadeService chatService;
	
	protected void sendChat(Integer docId, Integer memberId, ChatRefTypeEnmu type, String content, Long refID, RefStatusEnum refStatus) {
		try {
			
			Doctor doctor = doctorService.selectById(docId);
			Member member = memberService.selectById(memberId);
			//发给会员
			ChatMessage chat = new ChatMessage();
			chat.setSendType(ChatUserTypeEnum.DOCTOR.getType());
			chat.setSender(doctor.getDocid());
			chat.setSenderName(doctor.getDocname());
			chat.setSenderGUID(doctor.getDocGUID());
			chat.setSendTime(TimeUtil.now());
			chat.setReceiveType(ChatUserTypeEnum.MEMBER.getType());
			chat.setReceiver(member.getMemberid());
			chat.setReceiverGUID(member.getMemberGUID());
			chat.setContentType((byte)1);
			chat.setContent(content);
			chat.setRefType(type.getType());
			chat.setRefID(refID);
			chat.setRefStatus(refStatus == null ? null : refStatus.getCode());
			chatService.saveAndPushChatMessage(chat);
			
			//发给医生 
//			ChatMessage chat2 = new ChatMessage();
//			chat2.setSendType(ChatUserTypeEnum.MEMBER.getType());
//			chat2.setSender(member.getMemberid());
//			chat2.setSenderName(member.getMemname());
//			chat2.setSenderGUID(member.getMemberGUID());
//			chat2.setSendTime(TimeUtil.now());
//			chat2.setReceiveType(ChatUserTypeEnum.DOCTOR.getType());
//			chat2.setReceiver(doctor.getDocid());
//			chat2.setReceiverGUID(doctor.getDocGUID());
//			chat2.setContentType((byte)1);
//			chat2.setContent(content);
//			chat2.setRefType(type.getType());
//			chat2.setRefID(refID);
//			chat2.setRefStatus(refStatus == null ? null : refStatus.getCode());
//			chatService.saveAndPushChatMessage(chat2);
		} catch (Exception e) {
			
			logger.error("聊天消息发送失败", e);
			
		}
	}
}

