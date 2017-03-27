/**
 * @PackageName:      centerServer
 * @FileName:     MsgCenterController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年9月1日 下午3:35:38  
 * 
 */
package com.bithealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.centCore.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.centCore.msgCenterCore.model.MessageCenter;
import com.bithealth.centCore.msgCenterCore.model.MessageCenterExample;
import com.bithealth.centCore.msgCenterCore.service.MessageCenterFacadeService;
import com.bithealth.centCore.msgCenterCore.service.MessageCenterService;
import com.bithealth.model.ResponseObject;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
/**
 * 类名称: MsgCenterController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月1日 下午3:35:38 
 * 
 * @author 曾许华
 * @version  
 */
@Controller
@RequestMapping(value = "/msgCenter")
public class MsgCenterController extends BaseSpringController{

	protected static Logger logger = Logger.getLogger(MsgCenterController.class);
	@Autowired
	private MessageCenterFacadeService messageCenterFacadeService;
	@Autowired
	MessageCenterService messageCenterService;
	
	/**
	 * @Title:deleteById 
	 * @Description:根据主键id和接受者删除数据中心的消息（适用于报告，问卷类型的消息）
	 * @author 谢美团
	 * @param request
	 * @param response
	 * @return 
	 * @throws
	 * @retrun ResponseObject
	 */ 
	@RequestMapping(value = "/deleteById",produces = "application/json;charset=utf-8")
	@ResponseBody
	public ResponseObject deleteById(HttpServletRequest request,HttpServletResponse response){
		ResponseObject responseObject = new ResponseObject();
		try{
			String id=request.getParameter("sourId");
			String msgType=request.getParameter("msgType");
			String recieverGUID = request.getParameter("reciever");
			logger.info("删除的来源id:"+id+":删除的消息类型msgType:"+msgType+"接收者："+recieverGUID);
			if(null!=id && !"".equals(id) && recieverGUID != null && msgType != null){
				//messageCenterFacadeService.deleteMsgById(Integer.parseInt(id), Byte.parseByte(msgType), recieverGUID); 报告，问卷的消息中心功能已经去掉
			}else{
				responseObject.setStatusCode(1);
				responseObject.setMessage("根据主键id和接受者删除数据中心的消息异常");
			}
		}catch(Exception e){
			logger.info("根据主键id和接受者删除数据中心的消息" +e.getMessage());
			responseObject.setStatusCode(1);
			responseObject.setMessage("根据主键id和接受者删除数据中心的消息异常");
		}
		return responseObject;
	}
	
	/**
	 * @Title:deleteBySendAndReceiver 
	 * @Description:根据接受者和发送者删除数据中心的消息（适用于聊天类型的消息）
	 * @author 谢美团
	 * @param request
	 * @param response
	 * @return 
	 * @throws
	 * @retrun ResponseObject
	 */ 
	@RequestMapping(value = "/deleteBySendAndReceiver",produces = "application/json;charset=utf-8")
	@ResponseBody
	public ResponseObject deleteBySendAndReceiver(HttpServletRequest request,HttpServletResponse response){
		ResponseObject responseObject = new ResponseObject();
		try{
			String senderGUID=request.getParameter("send");
			String recieverGUID=request.getParameter("receiver");
			String msgType=request.getParameter("msgType");
			logger.info("删除的类型是:"+msgType+":发送者:"+senderGUID+":接收者:"+recieverGUID);
			if(null!=msgType && !"".equals(senderGUID)&& !"".equals(recieverGUID)){
				messageCenterFacadeService.deleteMsgByParams(recieverGUID, senderGUID, Byte.parseByte(msgType));
			}else{
				responseObject.setStatusCode(1);
				responseObject.setMessage("必要参数为空，删除失败。");
			}
		}catch(Exception e){
			logger.info("删除消息中心的聊天消息异常" +e.getMessage());
			responseObject.setStatusCode(1);
			responseObject.setMessage("删除消息中心的聊天消息异常");
		}
		return responseObject;
	}
	
	/**
	 * @Title:insertOrUpdateMessageSynchronized 
	 * @Description:消息保存入库并同步发送消息到推送服务
	 * @author 谢美团
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws
	 * @retrun ResponseObject
	 */ 
	@RequestMapping(value = "/insertOrUpdateMessageSynchronized",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody 
	public ResponseObject insertOrUpdateMessageSynchronized(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ResponseObject responseObject = new ResponseObject();
		MessageCenter messageCenter = new MessageCenter();
		try {
			String messageStr=request.getParameter("messageCenter");
			logger.info("消息保存入库并同步发送消息到推送服务参数："+messageStr);
			if(null!=messageStr&& !"".equals(messageStr)){
				messageCenter=JSONObject.parseObject(messageStr,MessageCenter.class);
				messageCenter.setUpdateTime(new Date());
				boolean fla=messageCenterFacadeService.insertOrUpdateMessageSynchronized(messageCenter);
				responseObject.setData(fla);
				logger.info("消息保存入库结果:"+fla);
			}else{
				responseObject.setStatusCode(1);
				responseObject.setMessage("必要参数为空，保存失败。");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("消息保存入库异常");
			responseObject.setStatusCode(1);
			responseObject.setMessage("出现异常");
		}
		return responseObject;
	}
	
	/**
	 * @Title:insertOrUpdateMessageAsynchronous 
	 * @Description:消息保存入库，不同步发送消息到推送服务
	 * @author 谢美团
	 * @param msg
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws
	 * @retrun String
	 */ 
	@RequestMapping(value = "/insertOrUpdateMessageAsynchronous",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody 
	public String insertOrUpdateMessageAsynchronous(@ModelAttribute("messageCenter") String msg,HttpServletRequest request,HttpServletResponse response) throws IOException{
		ResponseObject responseObject = new ResponseObject();
		MessageCenter messageCenter = new MessageCenter();
		try {
			String messageStr=request.getParameter("messageCenter");
			logger.info("异步插入或更新消息传入的参数:messageStr"+messageStr);
			if(null!=messageStr&& !"".equals(messageStr)){
				messageCenter=JSONObject.parseObject(messageStr.toString(),MessageCenter.class);
				messageCenter.setUpdateTime(new Date());
				boolean fla=messageCenterFacadeService.insertOrUpdateMessageAsynchronous(messageCenter);
				responseObject.setData("调用成功。");
				logger.info("成功完成异步插入或更新消息");
			}else{
				responseObject.setStatusCode(1);
				responseObject.setMessage("必要参数为空，保存失败。");
			}
		} catch (Exception e) {
			logger.info("异步插入或更新消息服务器出现异常"+e.getMessage());
			responseObject.setStatusCode(1);
			responseObject.setMessage("出现异常");
		}
		return JSON.toJSONString(responseObject);
	}
	
	/**
	 * @Title:getMessageListByIds 
	 * @Description:根据主键id查询数据的阅读状态，返回未阅读的数据的主键id
	 * @author 谢美团
	 * @param request
	 * @param response
	 * @return 
	 * @throws
	 * @retrun List<MessageCenter>
	 */ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/getMessageListByIds",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody 
	public List<MessageCenter> getMessageListByIds(HttpServletRequest request,HttpServletResponse response){
		logger.info("appServer通过IDS查询消息中心的数据，用于匹配getMessageListByIds");
		List listIds = new ArrayList();
		List idList = new ArrayList();
		try{
			String msgIds=request.getParameter("ids");
			String msgType=request.getParameter("msgType");
			logger.info("传入的msgIds:"+msgIds+":传入的msgType:"+msgType);
			String[] str=msgIds.split(",");
			if(null!=str){
				for(String msgIds1:str){
					listIds.add(Integer.parseInt(msgIds1));
				}
			}
			
			if(listIds.size()>0 && null!=msgType){
			Byte type =Byte.parseByte(msgType);
			List<MessageCenter> list=messageCenterFacadeService.selectByMessageListByIds(listIds,type);
				for(MessageCenter msg:list){
					idList.add(msg.getLastSourceID());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return idList;
	}
	
	
	/*
	 * 提供所有消息的类型和总数，摘要等信息
	 * 
	 */
	@RequestMapping(value = "/getMessageList",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody 
	public void getMessageList(HttpServletRequest request,HttpServletResponse response){
		JSONResult<Object> value = new JSONResult<Object>();
		PrintWriter out = null;
		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
		String receiverGUID=paramObj.getString("receiverGUID");
		String msgTypes=paramObj.getString("msgType");// 是聊天模块还是总页面显示
		logger.info("获取未读总数及摘要：receiverGUID:"+receiverGUID+",sourceType:"+msgTypes);
		try {
			out = response.getWriter();
			List<Byte> listMsgType = new ArrayList<Byte>();
			if(String.valueOf(MessageTypeEnum.MY_CONSULT.getType()).equals(msgTypes)){//只是聊天模块,村医版
				listMsgType = messageCenterFacadeService.getMsgTypeList(MessageTypeEnum.MY_CONSULT.getType());
			}else{
				listMsgType = messageCenterFacadeService.getMsgTypeList(MessageTypeEnum.All.getType());
			}
			List<MessageCenter> list=messageCenterFacadeService.selectByMessageList(listMsgType,receiverGUID);

			//获取接受者发送的最新消息
			MessageCenterExample example = new MessageCenterExample();
			example.setOrderByClause(" IFNULL(UpdateTime, CreateTime) DESC");
			example.createCriteria().andMsgTypeEqualTo(MessageTypeEnum.MY_CONSULT.getType()).andSenderEqualTo(receiverGUID);
			Page<MessageCenter> page = new Page<MessageCenter>(1,2);
			List<MessageCenter>  msgList = messageCenterService.selectByExampleAndPage(page, example);
			MessageCenter tempMsg = new MessageCenter();//接收者发送的聊天消息
			if(msgList != null && msgList.size() > 0){
				tempMsg = msgList.get(0);
			}
			boolean isHaveChatMsg = false;//是否包含有聊天模块消息
			String content="";
			if(list != null && list.size()>0){
				for(MessageCenter messageCenter:list){
					content = messageCenter.getLastContent();
					if(MessageTypeEnum.MY_CONSULT.getType() == messageCenter.getMsgType()){//聊天的的最新消息包括自己发送的消息
						if(tempMsg.getLogID() != null){ 
							long tempMsgTime = tempMsg.getUpdateTime() == null?tempMsg.getCreateTime().getTime():tempMsg.getUpdateTime().getTime();
							long messageCenterTime = messageCenter.getUpdateTime() ==null?messageCenter.getCreateTime().getTime():messageCenter.getUpdateTime().getTime();
							if(tempMsgTime > messageCenterTime){
								content = replaceContent(tempMsg.getLastContent());
							}
						}
						isHaveChatMsg = true;
					}
					messageCenter.setLastContent(content);
				}
				if(!isHaveChatMsg && tempMsg != null && tempMsg.getLastContent() != null){//消息列表中没有包含连天模块信息，但是该接受者有自己发送的消息
					tempMsg.setNumber(0);
					tempMsg.setLastContent(replaceContent(content = tempMsg.getLastContent()));
					list.add(tempMsg);
				}
				value.setData(list);
				value.setStatusCode(0);
				value.setMessage("获取未读消息总数接最新消息摘要列表成功");
				logger.info("获取未读消息总数接最新消息摘要列表成功！");

			}else if(tempMsg != null && tempMsg.getLastContent() != null){ //消息列表中，没有任何数据，但是该接受者有自己发送的消息
				list = new ArrayList<MessageCenter>();
				tempMsg.setNumber(0);
				list.add(tempMsg);
				value.setData(list);
				value.setStatusCode(0);
				value.setMessage("获取未读消息总数接最新消息摘要列表成功");
				logger.info("获取未读消息总数接最新消息摘要列表成功！");
			}else{
				value.setStatusCode(3);
				value.setMessage("没有未读消息 ");
				logger.info("没有未读消息");
			}
		} catch (Exception e) {
			logger.info("获取未读消息总数接最新消息摘要列表异常."+e.getMessage());
		}
		out.write(JSON.toJSONString(value));
	} 
	
	private String replaceContent(String content){
		if(content != null && content.indexOf("发来一张图片") != -1){
			content="[图片]";
		}else if(content != null && content.indexOf("发来一段语音") != -1){
			content="[语音]";
		}
		return content;
	}
	
	/**
	* 求Map<K,V>中Key(键)的最大值
	* @param map
	* @return
	*/
	public Object getMaxKey(Map<Integer, Object> map) {
	if (map == null) return null;
	Set<Integer> set = map.keySet();
	Object[] obj = set.toArray();
	Arrays.sort(obj);
	return obj[obj.length-1];
	}
	
	
    /**
     * @Title:deleteMsgByGuid 
     * @Description:根据guid 和消息类型删除消息中心的消息
     * @author 谢美团
     * @param request
     * @param response
     * @throws IOException 
     * @throws
     * @retrun void
     */ 
    @RequestMapping(value = "/deleteMsgByGuid")
    public void deleteMsgByGuid(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
    		String msgTypesStr = paramObj.getString("msgType");
    		
    		if (msgTypesStr != null && msgTypesStr.indexOf(",") != -1){ //版本兼容转换处理
    			msgTypesStr = "14";
    		}
    		
			List<Byte> msgTypeList = new ArrayList<Byte>();
			if(msgTypesStr != null){
/*				String[] msgTypes = msgTypesStr.split(",");
				for(String msgType:msgTypes){
					msgTypeList.add(Byte.parseByte(msgType));
				}*/
	    		messageCenterFacadeService.deleteMsgByParams(paramObj.getString("receiverGUID"),paramObj.getString("senderGUID"), Byte.valueOf(msgTypesStr));
			}else{
				returnObject.setStatusCode(305);;
				returnObject.setMessage("请求参数msgType不能为空");
				logger.error("请求参数msgType不能为空");
			}
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("deleteMsgByGuid接口调用异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
	

}
