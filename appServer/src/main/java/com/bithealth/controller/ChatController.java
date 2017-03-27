package com.bithealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.chatCore.facade.service.ChatMessageFacadeService;
import com.bithealth.chatCore.model.ChatMessage;
import com.bithealth.chatCore.model.ChatMessageExample;
import com.bithealth.chatCore.model.ChatMessageExample.Criteria;
import com.bithealth.chatCore.model.ChatMessageVo;
import com.bithealth.cmsCore.healthEducation.facede.HealthFacedeService;
import com.bithealth.cmsCore.healthEducation.model.HealthEducation;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.model.AppUser;
import com.bithealth.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.MessageUtil;
import com.bithealth.util.TimeUtil;

/**
 * @PackageName: com.bithealth.controller
 * @FileName:    ChatController.java  
 * @Description: 聊天功能  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuxiaoqin
 * @version      V1.0  
 * @Createdate:  2016年7月28日 
 */
@Controller
@RequestMapping(value = "/chat")
public class ChatController extends BaseSpringController{
	
	@Resource
    private ChatMessageFacadeService chatMessageFacadeService;
	
	@Resource
    private FileManagerServiceFacade fileManagerServiceFacade;
	
	@Resource
    private DoctorService doctorService;
	
	@Resource
    private MemberService memberService;
	
	@Resource
    private MessageCenterFacadeService messageCenterFacadeService;
	
	@Resource
    private HealthFacedeService healthFacedeService;
	
	/**
	 * @Description: 获取聊天消息的历史记录 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月8日 
	 */
	@RequestMapping(value = "/findMyChatRecord", method = RequestMethod.POST)
    public void selectMyChatRecord(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer pageNow = StrObject.getInteger("pageNow");
    	Integer pageSize = StrObject.getInteger("pageSize");
    	Integer senderId = 0;
    	Integer receiverId = 0;
    	Byte sendType = 0;
    	Byte receiveType = 0;
    	try{
    		if(user.getUserType() == 1){
    			senderId = user.getUserId();
    			receiverId = StrObject.getInteger("receiverId");
    			if(receiverId == null || receiverId <= 0){
    	    		value.setStatusCode(1);
    				value.setMessage("参数receiverId【"+receiverId+"】应为正整数");
    				logger.info("参数receiverId【"+receiverId+"】应为正整数");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return;
    	    	}
    			sendType = 2;
    			receiveType = 1;
    		}else if(user.getUserType() == 2){
    			senderId = user.getUserId();
    			receiverId = StrObject.getInteger("receiverId");
    			if(receiverId == null || receiverId <= 0){
    	    		value.setStatusCode(1);
    				value.setMessage("参数receiverId【"+receiverId+"】应为正整数");
    				logger.info("参数receiverId【"+receiverId+"】应为正整数");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return;
    	    	}
    			sendType = 1;
    			receiveType = 2;
    		}
    		List<Integer> senderIds = new ArrayList<Integer>();
    		senderIds.add(senderId);
    		senderIds.add(receiverId);
    		List<Integer> receiverIds = new ArrayList<Integer>();
    		receiverIds.add(senderId);
    		receiverIds.add(receiverId);
    		List<Byte> sendTypes = new ArrayList<Byte>();
    		sendTypes.add(sendType);
    		sendTypes.add(receiveType);
    		List<Byte> receiveTypes = new ArrayList<Byte>();
    		receiveTypes.add(sendType);
    		receiveTypes.add(receiveType);
    		Page<ChatMessage> page = new Page<ChatMessage>(pageNow,pageSize);
    		ChatMessageExample example = new ChatMessageExample();
    		Criteria criteria = example.createCriteria();
    		criteria.andSendTypeIn(sendTypes);
    		criteria.andReceiveTypeIn(receiveTypes);
    		criteria.andSenderIn(senderIds);
    		criteria.andReceiverIn(receiverIds);
    		example.setOrderByClause("SendTime DESC");
    		List<ChatMessage> list = chatMessageFacadeService.selectByExampleAndPage(page, example);
    		if(list != null && list.size()>0){
    			/* 批量删除未读消息的红点   begin */
    			String realSender = "";
    			String senderGUID = list.get(0).getSenderGUID();
    			String receiverGUID = list.get(0).getReceiverGUID();
    			String userGUID = user.getUserGUID();
    			if(userGUID.equals(receiverGUID)){
    				realSender = senderGUID;
    			}else{
    				realSender = receiverGUID;
    			}
    			Byte msgType = MessageTypeEnum.MY_CONSULT.getType();
    			boolean isOk = messageCenterFacadeService.deleteBySendAndReceiver(realSender, userGUID, msgType);
    			if(isOk == true){
    				logger.info("更新消息为已读成功。");
    			}else{
    				logger.info("更新消息为已读失败。");
    			}
    			/* 批量删除未读消息的红点   end */
    		    List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
    			for(ChatMessage message : list){
    				Map<String,Object> map = new HashMap<String, Object>();
    				if(user.getUserType() == 2){
    					map = convertChatMessage(message,null,"doctor");
    	    		}else{
    	    			map = convertChatMessage(message,null,"member");
    	    		}
    				mapList.add(map);
    			}
    			value.setData(mapList);
    			value.setStatusCode(0);
    			value.setMessage("获取聊天消息的历史记录成功");
    			logger.info("获取聊天消息的历史记录成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有聊天记录 ");
    			logger.info("没有聊天记录");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("获取聊天消息的历史记录异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 发送聊天信息 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月8日 
	 */
	@RequestMapping(value = "/sendChatContent", method = RequestMethod.POST)
    public void insertChatContent(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer senderId = 0;
    	Integer receiverId = 0;
    	Byte sendType = 0;
    	Byte receiveType = 0;
    	try{
    		String senderGUID = user.getUserGUID();;
    		if(user.getUserType() == 1){
    			senderId = user.getUserId();
    			receiverId = StrObject.getInteger("receiverId");
    			if(receiverId == null || receiverId <= 0){
    	    		value.setStatusCode(1);
    				value.setMessage("参数receiverId【"+receiverId+"】应为正整数");
    				logger.info("参数receiverId【"+receiverId+"】应为正整数");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return;
    	    	}
    			sendType = 2;
    			receiveType = 1;
    		}else if(user.getUserType() == 2){
    			senderId = user.getUserId();
    			receiverId = StrObject.getInteger("receiverId");
    			if(receiverId == null || receiverId <= 0){
    	    		value.setStatusCode(1);
    				value.setMessage("参数receiverId【"+receiverId+"】应为正整数");
    				logger.info("参数receiverId【"+receiverId+"】应为正整数");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return;
    	    	}
    			sendType = 1;
    			receiveType = 2;
    		}
    		String receiverGUID = StrObject.getString("receiverGUID");
			if(StringUtils.isEmpty(receiverGUID)){
	    		value.setStatusCode(1);
				value.setMessage("参数receiverGUID【"+receiverGUID+"】不能为空");
				logger.info("参数receiverGUID【"+receiverGUID+"】不能为空");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
	    	}
    		String contentNew = StrObject.getString("content");
    		String content = StringEscapeUtils.unescapeHtml(contentNew);
    		Integer contentType = StrObject.getInteger("contentType");
    		if(contentType == null || contentType <= 0){
	    		value.setStatusCode(1);
				value.setMessage("参数contentType【"+contentType+"】应为正整数");
				logger.info("参数contentType【"+contentType+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
	    	}
    		String uniqueId = "";
    		if(contentType != 1){
    			//上传内容是图片，语音，视频等
    			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
        		MultipartFile fileName = multipartRequest.getFile("fileName");
        		if(fileName == null){
        			value.setStatusCode(1);
    				value.setMessage("文件fileName【"+fileName+"】不能为空");
    				logger.info("文件fileName【"+fileName+"】不能为空");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return;
        		}
    			FileConfigModel modle = new FileConfigModel();
    			String fileType = fileName.getContentType();
    			String realFileType = fileType.substring(fileType.lastIndexOf("/")+1);
    			modle.setTypeEnum(FileTypeEnum.findEnumByFormat(realFileType));
    			modle.setNeedCompress(false);
    			uniqueId = fileManagerServiceFacade.uploadFileAppChat(fileName.getInputStream(), modle);
    			if(StringUtils.isEmpty(uniqueId)){
    				value.setStatusCode(1);
    				value.setMessage("上传文件失败");
    				logger.info("上传文件【"+fileName+"】失败");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return;
    			}
    			content = uniqueId;
    		}
    		int type = contentType;
    		byte newContentType = (byte)type;
    		ChatMessage chat = new ChatMessage();
    		chat.setReceiver(receiverId);
    		chat.setReceiveType(receiveType);
    		chat.setSender(senderId);
    		chat.setSendType(sendType);
    		chat.setContent(content);
    		chat.setContentType(newContentType);
    		chat.setReceiverGUID(receiverGUID);
    		chat.setSenderGUID(senderGUID);
    		chat.setSenderName(user.getUserName());
    		Response resp = chatMessageFacadeService.saveAndPushChatMessage(chat);
    		if(resp != null && resp.getStatus() == 200){
    			value.setStatusCode(0);
    			value.setMessage("发送聊天信息成功");
    			logger.info("发送聊天信息成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(1);
    			value.setMessage("发送聊天信息失败");
    			logger.info("发送聊天信息失败");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.insert.data"));
			logger.info("发送聊天信息异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 根据id来查找消息详情 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月8日 
	 */
	@RequestMapping(value = "/findChatMessageById", method = RequestMethod.POST)
    public void selectChatMessageById(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		try{
			String appUser = (String)request.getAttribute("appUserStr");
	    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	    String otherParam = (String)request.getAttribute("otherParamStr");
	    	JSONObject StrObject = JSON.parseObject(otherParam);
	    	Integer logId = StrObject.getInteger("logId");
			if(logId == null || logId <= 0){
	    		value.setStatusCode(1);
				value.setMessage("参数logId【"+logId+"】应为正整数");
				logger.info("参数logId【"+logId+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
	    	}
			ChatMessage message = chatMessageFacadeService.selectChatMessageById(logId);
    		if(message != null){
    			Map<String,Object> map = new HashMap<String, Object>();
    			if(user.getUserType() == 2){
					map = convertChatMessage(message,"singleInfo","doctor");
	    		}else{
	    			map = convertChatMessage(message,"singleInfo","member");
	    		}
    			value.setStatusCode(0);
    			value.setMessage("根据id来查找消息详情成功");
    			logger.info("根据id来查找消息详情成功！");
    			value.setSuccess(true);
    			value.setData(map);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有该条聊天记录 ");
    			logger.info("没有该条聊天记录");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("根据id来查找消息详情异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 获取某些发送者们给接受者的最新消息 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月29日 
	 */
	@RequestMapping(value = "/findSendersNewMsgToReceiver", method = RequestMethod.POST)
    public void selectSendersNewMsgToReceiver(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer pageNow = StrObject.getInteger("pageNow");
    	Integer pageSize = StrObject.getInteger("pageSize");
    	Integer receiverId = user.getUserId();
    	try{
    		Integer pageNo = (pageNow - 1)*pageSize;
    		List<ChatMessageVo> listMsg = new ArrayList<ChatMessageVo>();
    		if(user.getUserType() == 1){
    			listMsg = chatMessageFacadeService.selectDoctorToMemberMsgsPage(receiverId, pageSize, pageNo);
    		}else{
    			String userName = "";
    			String name = StrObject.getString("userName");
    			if(!StringUtils.isEmpty(name)){
    				userName = name;
    			}
    			listMsg = chatMessageFacadeService.selectMemberToDoctorsgsPage(receiverId, userName, pageSize, pageNo);
    		}
    		if(listMsg != null && listMsg.size()>0){
    			/*获取未读数据的id begin */
    			List<Integer> unreadMgsIds = new ArrayList<Integer>();
    			List<Integer> mgsIds = new ArrayList<Integer>();
    			for(ChatMessageVo message : listMsg){
    				Integer logId = message.get_logid();
    				if(logId != null && logId >0){
    					mgsIds.add(logId);
    				}
    			}
    			if(mgsIds != null && mgsIds.size() > 0){
    				Byte msgType = MessageTypeEnum.MY_CONSULT.getType();
    				List<Integer> unreadMsgList = messageCenterFacadeService.getMessageListByIds(mgsIds,msgType);
    				if(unreadMsgList != null && unreadMsgList.size() > 0){
    					for(Integer msgId : unreadMsgList){
    						unreadMgsIds.add(msgId);
    					}
    				}
    			}
    			/*获取未读数据的id end */
    		    List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
    			for(ChatMessageVo message : listMsg){
    				Map<String,Object> map = convertSendersNewMsg(message,user.getUserType(),unreadMgsIds);
    				mapList.add(map);
    			}
    			value.setData(mapList);
    			value.setStatusCode(0);
    			value.setMessage("获取某些发送者们给接受者的最新消息成功");
    			logger.info("获取某些发送者们给接受者的最新消息成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有聊天记录 ");
    			logger.info("没有聊天记录");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("获取某些发送者们给接受者的最新消息异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}

	/**
	 * @Description: 转化返回值属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月9日 
	 */
	public Map<String,Object> convertChatMessage(ChatMessage message,String singleInfo,String userType)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		Integer logId = message.get_logid();
		map.put("logId", logId);
		Byte sendType = message.getSendType();
		map.put("sendType", sendType);
		map.put("senderId", message.getSender());
		Date date = message.getSendTime();
		if(date != null){
			String realTime = "";
			String sendTime = TimeUtil.formatDatetime2(date);
			String today = TimeUtil.formatDatetime2(new Date());
			String sendTimeStr = sendTime.substring(0,10);
			String todayStr = today.substring(0,10);
			if(sendTimeStr.equals(todayStr)){
				realTime = sendTime.substring(11, 16);
			}else{
				realTime = sendTime.substring(0, 16);
			}
			map.put("sendTime", realTime);
		}
		map.put("receiveType", message.getReceiveType());
		map.put("receiverId", message.getReceiver());
		Date receiveDate = message.getReceiveTime();
		if(receiveDate != null){
			map.put("receiveTime", TimeUtil.formatDatetime2(receiveDate));
		}
		map.put("contentType", message.getContentType());
		map.put("content", message.getContent());
		if(!StringUtils.isEmpty(userType)){
			/*关联信息   begin*/
			Byte refType = message.getRefType();
			if(refType != null && refType == 1){
				long heducationid = message.getRefID();
				HealthEducation info = healthFacedeService.selectHealthById((int)heducationid);
				if(info != null){
					Byte sourceWay = info.getSourceway();
					map.put("healthSourceWay", sourceWay);
					if(sourceWay != null && sourceWay == 3){
						map.put("healthSourceContent", info.getContent());
					}
				}
			}
			map.put("refType", message.getRefType());
			map.put("refID", message.getRefID());
			map.put("refStatus", message.getRefStatus());
			/*关联信息   end*/
		}
		
		//查询单条信息需要返回一下信息
		if(!StringUtils.isEmpty(singleInfo)){
			map.put("senderGUID", message.getSenderGUID());
			map.put("receiverGUID", message.getReceiverGUID());
			String senderName = "";
			if(sendType != null && sendType == 1){
				Doctor doctor = doctorService.selectById(message.getSender());
				senderName = doctor.getDocname();
			}else if(sendType != null && sendType == 2){
				Member member = memberService.selectById(message.getSender());
				senderName = member.getMemname();
			}
			map.put("senderName", senderName);
		}
		return map;
	}
	
	/**
	 * @Description: 某些发送者们给接受者的最新消息属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月31日 
	 */
	public Map<String,Object> convertSendersNewMsg(ChatMessageVo message,Integer userType,List<Integer> unreadMgsIds)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		Integer logId = message.get_logid();
		map.put("logId", logId);
		map.put("sendType", message.getSendType());
		Integer senderId = message.getSender();
		map.put("senderId", senderId);
		Date date = message.getSendTime();
		if(date != null){
			String realTime = "";
			String sendTime = TimeUtil.formatDatetime2(date);
			String today = TimeUtil.formatDatetime2(new Date());
			String sendTimeStr = sendTime.substring(0,10);
			String todayStr = today.substring(0,10);
			if(sendTimeStr.equals(todayStr)){
				realTime = sendTime.substring(11, 16);
			}else{
				realTime = sendTime.substring(0, 16);
			}
			map.put("sendTime", realTime);
		}
		map.put("receiveType", message.getReceiveType());
		map.put("receiverId", message.getReceiver());
		Date receiveDate = message.getReceiveTime();
		if(receiveDate != null){
			map.put("receiveTime", TimeUtil.formatDatetime2(receiveDate));
		}
		map.put("contentType", message.getContentType());
		map.put("content", message.getContent());
		Date dateNew = message.getBirthDate();
        if(dateNew != null){
            String birthDate = TimeUtil.formatDate(dateNew);
            map.put("age", TimeUtil.getCurrentAgeByBirthdate(birthDate));
        }else{
            map.put("age", 0);
        }
		if(userType == 1){
			map.put("doctorId",message.getUserId());
			map.put("doctorName",message.getUserName());
			map.put("gender",message.getGender());
			map.put("workdepart",message.getWorkdepart());
			map.put("headaddress",message.getHeadaddress());
			map.put("doctorGUID",message.getUserGUID());
		}else{
			map.put("memberId",message.getUserId());
			map.put("memberName",message.getUserName());
			map.put("gender",message.getGender());
			map.put("headaddress",message.getHeadaddress());
			map.put("memberGUID",message.getUserGUID());
		}
		//是否为未读消息 :0未读；1已读
		int hasRead = 1;
		if(unreadMgsIds != null && unreadMgsIds.size() > 0){
			Integer hasReply = message.getHasReply();
			for(Integer id : unreadMgsIds){
				if(id.equals(logId)== true && hasReply != null && hasReply == 2){
					hasRead = 0;
				}
			}
		}
		map.put("hasRead",hasRead);
		return map;
	}
	
}
