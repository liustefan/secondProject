//package com.bithealth.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.bithealth.constants.Constants;
//import com.bithealth.model.AppUser;
//import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
//import com.bithealth.msgCenterCore.model.MessageCenter;
//import com.bithealth.msgCenterCore.model.MessageCenterExample;
//import com.bithealth.sdk.core.entity.JSONResult;
//import com.bithealth.sdk.core.feature.orm.mybatis.Page;
//import com.bithealth.sdk.web.controller.BaseSpringController;
//import com.bithealth.util.TimeUtil;
//
///**
// * @PackageName: com.bithealth.controller
// * @FileName:    MessageController.java  
// * @Description: 消息功能  
// * Copyright:    Copyright(C) 2016-2026 
// * 公司:          深圳中科汇康技术有限公司 
// * @author:      liuxiaoqin
// * @version      V1.0  
// * @Createdate:  2016年7月28日 
// */
//@Controller
//@RequestMapping(value = "/message")
//public class MessageController extends BaseSpringController{
//	
//	@Resource
//    private MessageCenterFacadeService messageCenterFacadeService;
//	
//	/**
//	 * @Description: 分页条件查询获取各种类型的未读消息
//	 * @author:      liuxiaoqin
//	 * @version      V1.0  
//	 * @Createdate:  2016年8月10日 
//	 */
//	@RequestMapping(value = "/findAllTypeUnreadMessage", method = RequestMethod.POST)
//    public void selectAllTypeUnreadMessage(HttpServletRequest request,HttpServletResponse response) throws IOException{
//		PrintWriter out = response.getWriter();
//		JSONResult<Object> value = new JSONResult<Object>();
//		String appUser = (String)request.getAttribute("appUserStr");
//    	AppUser user = JSON.parseObject(appUser, AppUser.class);
//    	Integer pageNow = 1;
//    	Integer pageSize = 10;
//    	Byte receivetype = 0;
//    	String receiver = user.getUserGUID();
//    	try{
//    		if(user.getUserType() == 1){
//    			receivetype = 2;
//    		}else if(user.getUserType() == 2){
//    			receivetype = 1;
//    		}
//			List<Byte> msgTypeList = new ArrayList<Byte>();
//			Byte[] type = Constants.MSG_TYPE_ARRY;
//			for(Byte i :type){
//				msgTypeList.add(i);
//			}
//    		Page<MessageCenter> page = new Page<MessageCenter>(pageNow,pageSize);
//    		MessageCenterExample example = new MessageCenterExample();
//    		com.bithealth.msgCenterCore.model.MessageCenterExample.Criteria criteria = example.createCriteria();
//    		criteria.andReceivetypeEqualTo(receivetype);
//    		criteria.andReceiverEqualTo(receiver);
//    		criteria.andMsgtypeIn(msgTypeList);
//    		example.setOrderByClause("CreateTime DESC");
//    		List<MessageCenter> list = messageCenterFacadeService.getMessageList(page, example);
//    		if(list != null && list.size()>0){
//    			List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
//    			List<Map<String,Object>> paperList = new ArrayList<Map<String,Object>>();
//    			for(MessageCenter msg : list){
//    				Map<String,Object> map = convertMessageCenterData(msg);
//    				byte i = (byte)map.get("msgtype");
//    				if(i == 5 || i == 6){
//    					paperList.add(map);
//    				}else{
//    					mapList.add(map);
//    				}
//    			}
//    			if(paperList != null && paperList.size() > 0){
//    				Map<String,Object> mapNew = paperList.get(0);
//    				mapNew.put("msgtype", 3);
//    				mapList.add(mapNew);
//    			}
//    			value.setData(mapList);
//    			value.setStatusCode(0);
//    			value.setMessage("分页条件查询获取各种类型的未读消息成功");
//    			logger.info("分页条件查询获取各种类型的未读消息成功！");
//    			value.setSuccess(true);
//    		}else{
//    			value.setStatusCode(3);
//    			value.setMessage("没有未读消息 ");
//    			logger.info("没有未读消息");
//    			value.setSuccess(false);
//    		}
//    	}catch(Exception e){
//    		value.setStatusCode(2);
//			value.setMessage("分页条件查询获取各种类型的未读消息异常");
//			logger.info("分页条件查询获取各种类型的未读消息异常"+e);
//			value.setSuccess(false);
//    	}
//    	out.write(JSON.toJSONString(value));
//	}
//	
////	/**
////	 * @Description: 分页条件查询我的温馨提示列表
////	 * @author:      liuxiaoqin
////	 * @version      V1.0  
////	 * @Createdate:  2016年8月10日 
////	 */
////	@RequestMapping(value = "/findWarmPromptList", method = RequestMethod.POST)
////    public void selectWarmPromptList(HttpServletRequest request,HttpServletResponse response) throws IOException{
////		PrintWriter out = response.getWriter();
////		JSONResult<Object> value = new JSONResult<Object>();
////		String appUser = (String)request.getAttribute("appUserStr");
////    	AppUser user = JSON.parseObject(appUser, AppUser.class);
////    	String otherParam = (String)request.getAttribute("otherParamStr");
////    	JSONObject StrObject = JSON.parseObject(otherParam);
////    	String receiver = user.getUserGUID();
////    	try{
////    		Integer pageNow = StrObject.getInteger("pageNow");
////        	Integer pageSize = StrObject.getInteger("pageSize");
////    		Page<KindlyReminder> page = new Page<KindlyReminder>(pageNow,pageSize);
////    		KindlyReminderExample example = new KindlyReminderExample();
////    		Criteria criteria = example.createCriteria();
////    		criteria.andSenderEqualTo(receiver);
////    		example.setOrderByClause("CreateTime DESC");
////    		List<KindlyReminder> list = kindlyReminderService.selectByExampleAndPage(page, example);
////    		if(list != null && list.size()>0){
////    			List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
////    			for(KindlyReminder reminder : list){
////    				Map<String,Object> map = convertKindlyReminderData(reminder);
////    				mapList.add(map);
////    			}    			
////    			value.setData(mapList);
////    			value.setStatusCode(0);
////    			value.setMessage("分页条件查询我的温馨提示列表成功");
////    			logger.info("分页条件查询我的温馨提示列表成功！");
////    			value.setSuccess(true);
////    		}else{
////    			value.setStatusCode(3);
////    			value.setMessage("没有温馨提示 ");
////    			logger.info("没有温馨提示");
////    			value.setSuccess(false);
////    		}
////    	}catch(Exception e){
////    		value.setStatusCode(2);
////			value.setMessage("分页条件查询我的温馨提示列表异常");
////			logger.info("分页条件查询我的温馨提示列表异常"+e);
////			value.setSuccess(false);
////    	}
////    	out.write(JSON.toJSONString(value));
////	}
//	
//	/**
//	 * @Description: 更新未读消息为已读
//	 * @author:      liuxiaoqin
//	 * @version      V1.0  
//	 * @Createdate:  2016年8月10日 
//	 */
//	@RequestMapping(value = "/updateAllTypeMessageHasRead", method = RequestMethod.POST)
//    public void updateAllTypeMessageHasRead(HttpServletRequest request,HttpServletResponse response) throws IOException{
//		PrintWriter out = response.getWriter();
//		JSONResult<Object> value = new JSONResult<Object>();
//    	String otherParam = (String)request.getAttribute("otherParamStr");
//    	JSONObject StrObject = JSON.parseObject(otherParam);
//    	try{
//    		Integer logid = StrObject.getInteger("logid");
//			if(logid == null || logid <= 0){
//	    		value.setStatusCode(1);
//				value.setMessage("参数logid【"+logid+"】应为正整数");
//				logger.info("参数logid【"+logid+"】应为正整数");
//				value.setSuccess(false);
//				out.write(JSON.toJSONString(value));
//				return; 
//	    	}
//			//未完成
//			boolean count = messageCenterFacadeService.updateMessageNumber(logid);
//    		if(count == true){
//    			value.setStatusCode(0);
//    			value.setMessage("更新未读消息为已读成功");
//    			logger.info("更新未读消息为已读成功！");
//    			value.setSuccess(true);
//    		}else{
//    			value.setStatusCode(1);
//    			value.setMessage("更新未读消息为已读失败 ");
//    			logger.info("更新未读消息为已读失败");
//    			value.setSuccess(false);
//    		}
//    	}catch(Exception e){
//    		value.setStatusCode(2);
//			value.setMessage("更新未读消息为已读异常");
//			logger.info("更新未读消息为已读异常"+e);
//			value.setSuccess(false);
//    	}
//    	out.write(JSON.toJSONString(value));
//	}
//	
//	/**
//	 * @Description: 转化消息属性名 
//	 * @author:      liuxiaoqin
//	 * @version      V1.0  
//	 * @Createdate:  2016年8月25日 
//	 */
//	public Map<String,Object> convertMessageCenterData(MessageCenter msg)throws Exception{
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("logid", msg.getLogid());
//		map.put("msgtype", msg.getMsgtype());
//		map.put("sendtype", msg.getSendtype());
//		map.put("sender", msg.getSender());
//		String date = "";
//		Date updateDate = msg.getUpdatetime();
//		if(updateDate != null){
//			map.put("updatetime", TimeUtil.formatDatetime2(updateDate));
//			date = TimeUtil.formatDate(updateDate);
//		}
//		Date createDate = msg.getCreatetime();
//		if(createDate != null){
//			map.put("createtime", TimeUtil.formatDatetime2(createDate));
//			if(StringUtils.isEmpty(date)){
//				date = TimeUtil.formatDate(createDate);
//			}
//		}
//		map.put("receivetype", msg.getReceivetype());
//		map.put("receiver", msg.getReceiver());
//		map.put("lastsourceid", msg.getLastsourceid());
//		map.put("lastcontent", msg.getLastcontent());
//		map.put("number", msg.getNumber());
//		map.put("date", date);
//		return map;
//	}
//	
////	/**
////	 * @Description: 转化温馨提示属性名 
////	 * @author:      liuxiaoqin
////	 * @version      V1.0  
////	 * @Createdate:  2016年8月25日 
////	 */
////	public Map<String,Object> convertKindlyReminderData(KindlyReminder reminder)throws Exception{
////		Map<String,Object> map = new HashMap<String, Object>();
////		map.put("logID", msg.getLogid());
////		map.put("sendType", msg.getMsgtype());
////		map.put("content", msg.getSendtype());
////		map.put("sender", msg.getSender());
////		String date = "";
////		Date updateDate = msg.getUpdatetime();
////		if(updateDate != null){
////			map.put("updatetime", TimeUtil.formatDatetime2(updateDate));
////			date = TimeUtil.formatDate(updateDate);
////		}
////		Date createDate = msg.getCreatetime();
////		if(createDate != null){
////			map.put("createtime", TimeUtil.formatDatetime2(createDate));
////			if(StringUtils.isEmpty(date)){
////				date = TimeUtil.formatDate(createDate);
////			}
////		}
////		map.put("receivetype", msg.getReceivetype());
////		map.put("receiver", msg.getReceiver());
////		map.put("lastsourceid", msg.getLastsourceid());
////		map.put("lastcontent", msg.getLastcontent());
////		map.put("number", msg.getNumber());
////		map.put("date", date);
////		return map;
////	}
//
//}
