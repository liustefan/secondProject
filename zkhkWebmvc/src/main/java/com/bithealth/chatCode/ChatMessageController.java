/**
 * @PackageName:      com.bithealth.chat
 * @FileName:     ChatMessageController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年8月31日 下午1:51:55  
 * 
 */
package com.bithealth.chatCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bithealth.chatCore.model.ChatMessage;
import com.bithealth.chatCore.model.ChatMessageExample;
import com.bithealth.chatCore.service.ChatMessageService;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorSession;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.doctorCore.doctor.service.DoctorSessionService;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;

/**
 * 类名称: ChatMessageController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月31日 下午1:51:55 
 * 
 * @author 胡翔
 * @version  
 */
@Controller
@RequestMapping("/chatCode")
public class ChatMessageController extends BaseSpringController{

	/*
	@Autowired
	private ChatMessageService chatMessageService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private DoctorService doctorService;
	private ChatMessageExample example;
	private ChatMessage chatMessage;
	private List<ChatMessage> list = new ArrayList<ChatMessage>();
	
	  	@RequestMapping(value = "/getchatCodeList")
	    public String getchatCodeList(ModelMap model,HttpServletRequest request,Page<ChatMessage> page) {
	  		Map mapTel= new TreeMap();
	  		Map mapName= new TreeMap();
	  		Map mapGender= new TreeMap();
	  		Map mapBirthdate= new TreeMap();
	    	ShiroUser shiroUser =(ShiroUser)request.getSession().getAttribute("userInfo");
	    	String name=request.getParameter("name");
	    	String startDate=request.getParameter("startDate");
	    	String endDate=request.getParameter("endDate");
	    	page=chatMessageService.selectByChat(page, shiroUser.getId());
	    	List<ChatMessage> listChatMessage =page.getResult();
	    	for(ChatMessage chat:listChatMessage){
	    		Byte sendType=chat.getSendType();//发送类型：1-医生发送，2-会员发送
	    		Integer memberId=chat.getReceiver();
	    		Member mem=memberService.selectById(memberId);
	    		chatMessage=chatMessageService.selectById(chat.get_logid());
	    		// 如果是医生发送，就是接收者的信息，会员的基本信息
	    		if(sendType.equals(1)){
	    			mapName.put(mem.getMemberid(), mem.getMemname());
	    			mapGender.put(mem.getMemberid(), mem.getGender());
	    			mapBirthdate.put(mem.getMemberid(), mem.getBirthdate());
	    			mapTel.put(mem.getMemberid(), mem.getTel());
	    		}
	    		list.add(chatMessage);
	    		page.setResult(list);
	    	}
	    	return "msgCerter/communicate";
	  	}
	  	
	  	@RequestMapping(value = "/${send}/${receiver}/getchatCodeView")
	    public String getchatCodeView(int send,int receiver,HttpServletRequest request,Page<ChatMessage> page,ModelMap model) {
	  		Map mapMemebre  = new TreeMap();
	  		Map mapdoc  = new TreeMap();
	  		page=chatMessageService.selectByChatCode(page, send, receiver);
	  		ShiroUser shiroUser =(ShiroUser)request.getSession().getAttribute("userInfo");
	  		int id=shiroUser.getId();
	  		ChatMessageExample.Criteria criteria=example.createCriteria();
	  		criteria.andSenderEqualTo(id);
	  		criteria.andSendTypeEqualTo(Byte.valueOf("1"));
	  		List<ChatMessage> list=chatMessageService.selectByExample(example);
	  		Doctor doctor=doctorService.selectById(id);
	  		
	  		ChatMessage chat=list.get(0);
	  		int memberId=chat.getReceiver();
	  		Member mem=memberService.selectById(memberId);
	  		mapMemebre.put(chat.getReceiver(), mem.getMemname());
	  		String memberImg=mem.getHeadaddress();
	  		String doctorImg=doctor.getHeadaddress();
	  		model.addAttribute("page",page);
	  		
	  		return "msgCerter/interflow";
	  	} */
}
