/**
 * @PackageName:      com.bithealth.msgCenterCore.facade.service.impl
 * @FileName:     MessageCenterFacadeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年7月28日 下午2:10:15  
 * 
 */
package com.bithealth.centCore.msgCenterCore.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bithealth.agentCore.agent.RedicrectService;
import com.bithealth.agentCore.bean.Parameter;
import com.bithealth.agentCore.enums.PushMethodEnum;
import com.bithealth.centCore.facade.model.MsgPushData;
import com.bithealth.centCore.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.centCore.msgCenterCore.constants.SendStatusEnum;
import com.bithealth.centCore.msgCenterCore.dao.MessageCenterMapper;
import com.bithealth.centCore.msgCenterCore.model.MessageCenter;
import com.bithealth.centCore.msgCenterCore.model.MessageCenterExample;
import com.bithealth.centCore.msgCenterCore.model.MessageCenterExample.Criteria;
import com.bithealth.centCore.msgCenterCore.service.MessageCenterFacadeService;
import com.bithealth.centCore.msgCenterCore.service.MessageCenterService;
import com.bithealth.centCore.msgCenterCore.util.PushUtils;
import com.bithealth.centCore.schedule.model.MessageSchedule;
import com.bithealth.centCore.schedule.service.MessageScheduleService;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MessageCenterFacadeServiceImpl  
 * 功能描述:  消息中心对外接口实现类  
 * 日期: 2016年7月28日 下午2:10:15 
 * 
 * @author 曾许华
 * @version  
 */
@Service("messageCenterFacadeService")
public class MessageCenterFacadeServiceImpl extends GenericBaseServiceImpl<MessageCenter,MessageCenterExample,Integer> implements MessageCenterFacadeService{
	
	private static Logger logger = Logger.getLogger(MessageCenterFacadeServiceImpl.class);
	//消息发送次数
	public static final int PUSH_COUNT = 3;
	//编码
	public static final String  PUSH_CHARSET="UTF-8";
	
	@Autowired
	private MessageCenterMapper messageCenterMapper;
	@Autowired
	private  RedicrectService redirectImpl;
	@Autowired
	private MessageScheduleService messageScheduleService;
	@Autowired
	MessageCenterService  messageCenterService;
	
	@Override
	public GenericBaseDao<MessageCenter, MessageCenterExample, Integer> getDao() {
		return this.messageCenterMapper;
	}
	
    
	@Override
	public List<MessageCenter> getMessageList(Page<MessageCenter> page,MessageCenterExample example) {
		logger.info("调用查询消息汇总ServiceImpl");
		return messageCenterMapper.selectByExampleAndPage(page, example);
	}
	
	/**
	 * 
	 * @Title:insertMessage 
	 * @Description:保存或更新消息，并发送消息到推送服务.  
	 * @author 曾许华
	 * @param 要插入或更新的消息记录对象
	 * @return 返回数据处理结果
	 */
	@Override
	public boolean insertOrUpdateMessageSynchronized(MessageCenter messageCenter) throws Exception{
		return inserOrUpdateMsg(messageCenter ,true);
	}
	
	/**
	 * 
	 * @Title:insertMessage 
	 * @Description: 保存或更新消息，不发送消息到推送服务.    
	 * @author 曾许华
	 * @param 要插入或更新的消息记录对象
	 * @return 返回数据处理结果
	 */
	@Override
	public boolean insertOrUpdateMessageAsynchronous(MessageCenter messageCenter) throws Exception{
		return inserOrUpdateMsg(messageCenter ,false);
	}
	
	
	private boolean inserOrUpdateMsg(MessageCenter messageCenter ,boolean isSendMsg) throws Exception{
		boolean fla=false;
		
		if(messageCenter == null ||  messageCenter.getSendType() == null || messageCenter.getReceiveType() == null || messageCenter.getMsgType() == null){
			return false;
		}
		// content内容长度做限制
		String content=messageCenter.getLastContent();
		if(content != null && content.length()>60){
			content=content.substring(0, 59)+"...";
			messageCenter.setLastContent(content);
		}
		if(messageCenter.getScheduleTime() == null){
			messageCenter.setScheduleTime(new Date());
		}
		
		if(messageCenter.getCreateTime() == null){
			messageCenter.setCreateTime(new Date());
		}
		
		//转换亲友状态中的消息类型
		messageCenter.setMsgType(convertMsgType(messageCenter.getMsgType()));
		
		//查询消息中心是否有该条数据
		MessageCenterExample example = new MessageCenterExample();
		Criteria criteria = example.createCriteria();
		criteria.andMsgTypeIn(getMsgTypeList(messageCenter.getMsgType()));
		criteria.andSenderEqualTo(messageCenter.getSender());
		criteria.andReceiverEqualTo(messageCenter.getReceiver());
		criteria.andSendTypeEqualTo(messageCenter.getSendType());
		criteria.andReceiveTypeEqualTo(messageCenter.getReceiveType());
		List<MessageCenter> msgCenterList = messageCenterMapper.selectByExample(example);
		boolean isEmpty = CollectionUtils.isEmpty(msgCenterList);
		
		if(msgCenterList != null && msgCenterList.size() > 0){
			messageCenter.setNumber(msgCenterList.get(0).getNumber()+1);
			messageCenter.setUpdateTime(new Date());
			messageCenter.setLogID(msgCenterList.get(0).getLogID());
		}else{
			messageCenter.setCreateTime(new Date());
			messageCenter.setNumber(1);
		}
		
		//判断是否发送消息到推送服务
		if (isSendMsg){//即时消息
			Response resp = sendMsg(messageCenter);
			if(resp != null && resp.getStatus()==200){
				messageCenter.setSendStatus(SendStatusEnum.SEND_SUCCESS.getType());
			}else{
				messageCenter.setSendStatus(SendStatusEnum.SEND_FAIL.getType());
				logger.error("消息发送到推送服务器异常："+JSONObject.toJSONString(resp));
			}
		}else{// 非即时消息，消息保存到 定时发送消息任务表（tb_messageschedule）中，不需要保存到消息记录表（tb_messagecenter）
			messageCenter.setSendStatus(SendStatusEnum.TO_BE_SEND.getType());
			MessageSchedule messageSchedule = new MessageSchedule();
			BeanUtils.copyProperties(messageCenter, messageSchedule);
			messageScheduleService.insert(messageSchedule);
			logger.info("定时或异步消息保存到定时消息任务表成功.消息内容："+messageSchedule.getLastContent());
			return true;
		}
		
		//保存消息或者更新消息
		if(isEmpty){
			insert(messageCenter);
			fla=true;
			logger.info("消息保存入库完成");
		}else{
			messageCenterMapper.updateByPrimaryKeySelective(messageCenter);
			logger.info("消息更新完成");
			fla=true;
		}
		return fla;
	}
	
	
	private Byte convertMsgType(Byte msgType){
		if(msgType == 11 || msgType == 12 || msgType == 13 || msgType == 15 || msgType == 16 || msgType == 17 || msgType == 18){
			return MessageTypeEnum.FRIENDS_DYNAMIC.getType();
		}else{
			return msgType;
		}
		
	}
	
	/**
	 * @Title:countBadge 
	 * @Description:统计应用的未读消息
	 * @author 谢美团
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	private int countBadge(String receiverGUID,String msgTypes){
		int badge = 1;
		List<MessageCenter> list = selectByMessageList(getMsgTypeList(MessageTypeEnum.All.getType()),receiverGUID);
		//logger.info("消息数量："+JSONObject.toJSONString(list));
		if(list != null){
			for(MessageCenter msg:list){
				if(msg.getNumber() !=null){
					badge=badge+(int)msg.getNumber();
				}
			}
		}
		return badge;
	}
	
	
	

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public  Response sendMsg(MessageCenter messageCenter) throws Exception{
		Map map = new HashMap();
		Parameter parameter = new Parameter();
		int num;
		String str=messageCenter.getReceiver();
		logger.info("调用同步插入或更新，开始推送消息，组装要推送的消息内容:"+str);
		if(str.toLowerCase().equals("sz")){// 按组发送tag区别
			map.put("tag", str);
			num=3;
		}else if(str.contains(",")){
			map.put("memberIds", str);
			num=2;
		}else{
			map.put("memberId", str);
			num=1;
		}
		map.put("sendTime", messageCenter.getScheduleTime() == null?String.valueOf(new Date().getTime()):String.valueOf(messageCenter.getScheduleTime().getTime()));
		map.put("sender", messageCenter.getSender().toString());
		
		MsgPushData data = new MsgPushData();
		data.setLastContent(messageCenter.getLastContentNotice());
		data.setCreateTime(messageCenter.getCreateTime());
		data.setMsgType(messageCenter.getMsgType().toString());
		data.setLastSourceID(String.valueOf(messageCenter.getLastSourceID()));
		map.put("data", JSONObject.toJSONString(data));
		map.put("msgType", "1");
		map.put("platfrom", "1");
		map.put("title", messageCenter.getLastContentNotice());
		int badge = countBadge(messageCenter.getReceiver(),String.valueOf(messageCenter.getMsgType()));
		map.put("badge", badge+"");
		parameter.setParam(map);
		return   getMethod(num,parameter); 
	}
		
	private Response getMethod(int num, Parameter parameter){
		Response resp = new Response();
		if(num==3){
			resp=redirectImpl.redirect(PushMethodEnum.Tag_Specific, parameter);
		}else if(num==2){
			resp=redirectImpl.redirect(PushMethodEnum.Users_Specific, parameter);
		}else{
			resp=redirectImpl.redirect(PushMethodEnum.User_Specific, parameter);
		}
		logger.info("调用同步插入或更新，推送的结果状态:"+resp.getStatus());
		return resp;
	}
	
	public  String getSign(Map<String, Object> paramMap) throws Exception {
		StringBuffer buffer = new StringBuffer("");
		buffer.append(PushUtils.encode(PushMethodEnum.User_Specific.toString().getBytes(PUSH_CHARSET)));
		// 循环请求参数
		for (Object key : paramMap.keySet()) {
			buffer.append(key);
			String value = (String) (paramMap.get(key) + "");
			buffer.append(PushUtils.encode(value.getBytes(PUSH_CHARSET)));
		}
		return PushUtils.MD5(buffer.toString().getBytes(PUSH_CHARSET));
	}


	@Override
	public List<MessageCenter> selectByMessageList(List<Byte> list,String receiverGUID) {
		
		return messageCenterMapper.selectByMessageList(list,receiverGUID,new Date());
	}

	@Override
	public List<MessageCenter> selectByMessageListByIds(List litIds,Byte msgType) {
		return messageCenterMapper.selectByMessageListByIds(litIds,msgType);
	}

	@Override
	public MessageCenter selectId(Integer id) {
		return messageCenterMapper.selectId(id);
	}

	/** 
	     * @Title: send 
	     * @Description: 根据参数删除消息中心的消息（适用于 聊天，亲友动态，温馨提示等查看列表时全部删除的 类型）
	     * @param  
	     * @throws      
	     * @retrun  
	     */
	@Override
	public int deleteMsgByParams(String recieverGUID, String senderGUID,Byte msgType) {
/*		//获取最新一条消息的主键
		Integer maxId = messageCenterService.selectMaxIdByParam(recieverGUID, senderGUID, msgTypeList);
		//根据参数删除除最新一条消息的其他消息
		MessageCenterExample example = new MessageCenterExample();
		com.bithealth.centCore.msgCenterCore.model.MessageCenterExample.Criteria criteria = example.createCriteria();
		criteria.andReceiverEqualTo(recieverGUID).andMsgTypeIn(msgTypeList).andLogIDNotEqualTo(maxId.longValue());
		if(senderGUID != null){
			criteria.andSenderEqualTo(senderGUID);
		}
		messageCenterService.deleteByExample(example);
		
		//更新最新一条数据number 为 0
		MessageCenter model = new MessageCenter();
		model.setLogID(maxId.longValue());
		model.setNumber(0);
		messageCenterService.update(model);*/
		
		//根据接受者发送和消息类型更新该条数据为已读
		MessageCenter model = new MessageCenter();
		model.setNumber(0);
		//model.setUpdateTime(new Date());
		MessageCenterExample example = new MessageCenterExample();
		example.createCriteria().andReceiverEqualTo(recieverGUID).andSenderEqualTo(senderGUID).andMsgTypeEqualTo(msgType);		
		return messageCenterService.updateByExampleSelective(model, example);
	}

	@Override
	public int deleteMsgById(Integer id,Byte msgType,String recieverGUID) {
		//获取最新一条消息的主键id
		Integer maxId = messageCenterService.selectMaxIdByMsgType(msgType, recieverGUID);
		if(maxId != 0){
			//删除以前的已读的数据
			MessageCenterExample example = new MessageCenterExample();
			example.createCriteria().andMsgTypeEqualTo(msgType).andReceiverEqualTo(recieverGUID).andNumberEqualTo(0).andLogIDNotEqualTo(maxId.longValue());
			messageCenterService.deleteByExample(example);
			//更新传入参数数据的 number为0 已读
			MessageCenter model = new MessageCenter();
			MessageCenterExample msgExample = new MessageCenterExample();
			model.setNumber(0);
			msgExample.createCriteria().andLastSourceIDEqualTo(id.longValue()).andMsgTypeEqualTo(msgType).andReceiverEqualTo(recieverGUID);
			messageCenterService.updateByExampleSelective(model, msgExample);
		}
		//messageCenterService.delete(id);
		return 1;
	}


	@Override
	public List<Byte> getMsgTypeList(byte type) {
		//消息集合分三大类， 温馨提示，医患沟通 和亲友动态，其中亲友动态包括测量和公卫随访
		List<Byte> list = new ArrayList<Byte>();
		if(MessageTypeEnum.KINDLY_REMINDER.getType() ==	type){ //温馨提示
			list.add(type);
		}else if(MessageTypeEnum.MY_CONSULT.getType() == type){//医患沟通
			list.add(type);
		}else if(MessageTypeEnum.All.getType() == type){//全部
			list.add(MessageTypeEnum.KINDLY_REMINDER.getType());/*** 1,温馨提示 */
			list.add(MessageTypeEnum.MY_CONSULT.getType());/*** 2,我的咨询*/
			list.add(MessageTypeEnum.FRIENDS_DYNAMIC.getType()); /**14 亲友动态*/
		}else{//亲友动态
			list.add(MessageTypeEnum.FRIENDS_DYNAMIC.getType()); /**14 亲友动态*/
		}
		return list;
	}

}
