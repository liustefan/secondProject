/**
 * @PackageName:      com.bithealth.taskMgrCore.task
 * @FileName:     MsgCenterCodeTask.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年9月1日 上午10:27:52  
 * 
 */
package com.bithealth.centCore.msgCenterCore.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.alibaba.fastjson.JSON;
import com.bithealth.agentCore.agent.RedicrectService;
import com.bithealth.agentCore.bean.Parameter;
import com.bithealth.agentCore.enums.PushMethodEnum;
import com.bithealth.centCore.msgCenterCore.model.MessageCenter;
import com.bithealth.centCore.msgCenterCore.model.MessageCenterExample;
import com.bithealth.centCore.msgCenterCore.model.MessageCenterExample.Criteria;
import com.bithealth.centCore.msgCenterCore.service.MessageCenterFacadeService;
import com.bithealth.centCore.msgCenterCore.service.MessageCenterService;
import com.bithealth.centCore.msgCenterCore.util.PushUtils;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.common.utils.TimeUtil;

/**
 * 类名称: MsgCenterCodeTask 功能描述: TODO ADD FUNCTION. 增加/修改原 因: TODO ADD
 * REASON(可选). 日期: 2016年9月1日 上午10:27:52
 * 
 * @author 曾许华
 * @version
 */
@Service("msgCenterCodeTask")
public class MsgCenterCodeTask extends TimerTask {

	protected static Logger logger = Logger.getLogger(MsgCenterCodeTask.class);

	@Autowired
	private MessageCenterFacadeService messageCenterFacadeService;
	@Autowired
	private  RedicrectService redirectImpl;
	private static Parameter parameter;
	private MessageCenterExample example = new MessageCenterExample();
	private Response resp;

	/**
	 * @Title: send   
	 * @Description: TODO 简单描述该方法的实现功能（可选）.  @param
	 * @throws       
	 * @retrun 
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		Date executeTime = new Date(this.scheduledExecutionTime()); 
        logger.info("本次任务执行的时间是" + TimeUtil.formatDatetime2(executeTime));
		this.sendMsgCode();
	}

	public void sendMsgCode() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		logger.info("开始被调用方法");
		Criteria criteria = example.createCriteria();
		// 查询出不是发送成功的数据定时器一次发送出去
		criteria.andSendStatusNotEqualTo(Byte.valueOf("2"));
		// 查询出小于当前时间的消息
		//criteria.andScheduleTimeLessThanOrEqualTo(new Date());
		try {
			List<MessageCenter> list = messageCenterFacadeService.selectByExample(example);
			logger.info("开始推送消息总个数为:"+list.size());
			if (CollectionUtils.isNotEmpty(list)) {
				for (MessageCenter messageCenter : list) {
					resp = messageCenterFacadeService.sendMsg(messageCenter);
					  if(resp.getStatus()==200){
						  messageCenter.setSendStatus(Byte.valueOf("2")); 
					  }else{
						  messageCenter.setSendStatus(Byte.valueOf("3")); 
					  } 
					  int stat= messageCenterFacadeService.update(messageCenter);
					  logger.info("推送消息完成更新消息状态:"+stat);
				}
			}
		} catch (Exception e) {
			logger.info("推送消息出现异常");
			e.printStackTrace();
		}
		logger.info("推送消息完成");
	}

	
	public  Response sendMsg(MessageCenter messageCenter) throws Exception{
			Map map = new HashMap();
			int num;
			parameter = new Parameter();
			String str=messageCenter.getSender();
			logger.info("推送消息开始组装");
			if(str.toLowerCase().equals("sz")){
				map.put("tag",str);
				num=3;
			}else if(str.contains(",")){
				map.put("memberIds", str);
				num=2;
			}else{
				map.put("memberId", str);
				num=1;
			}
			map.put("sender", messageCenter.getSender().toString());
			// TODO ,聊天的推送和其他的推送有区别
			if(messageCenter.getMsgType().toString().equals("2")){
				map.put("platform", "1");
				map.put("msgType", "0");
				map.put("title", "");
				map.put("description", "");
				map.put("data", "{\"msgType\":\""+String.valueOf(messageCenter.getMsgType())
						+"\",\"_logid\":"+String.valueOf(messageCenter.getLastSourceID())+",\"createTime\":\""
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm").format(messageCenter.getCreateTime())+"\"}");
			}else{
				map.put("data", "{\"lastSourceID\":\""
						+String.valueOf(messageCenter.getLastSourceID())+"\",\"msgType\":"+String.valueOf(messageCenter.getMsgType())
						+",\"receiveType\":"+String.valueOf(messageCenter.getReceiveType())+",\"createTime\":\""
						+new SimpleDateFormat("yyyy-MM-dd HH:mm").format(messageCenter.getCreateTime())+"\"}");
				map.put("deviceType", "1");
				map.put("msgType", "1");
				map.put("platfrom", "1");
				map.put("title", messageCenter.getLastContent());
				map.put("sign", getSign(map));
			}
			parameter.setParam(map);
		return   getMethod(num,parameter); 
	}
	
	private Response getMethod(int num, Parameter parameter){
		logger.info("推送消息调用接口");
		if(num==3){
			resp=redirectImpl.redirect(PushMethodEnum.Tag_Specific, parameter);
		}else if(num==2){
			resp=redirectImpl.redirect(PushMethodEnum.Users_Specific, parameter);
		}else{
			resp=redirectImpl.redirect(PushMethodEnum.User_Specific, parameter);
		}
		return resp;
	}
	
	public String getSign(Map<String, Object> paramMap) throws Exception {
		StringBuffer buffer = new StringBuffer("");
		buffer.append(PushUtils.encode(PushMethodEnum.User_Specific.toString().getBytes("UTF-8")));
		// 循环请求参数
		for (Object key : paramMap.keySet()) {
			buffer.append(key);
			String value = (String) (paramMap.get(key) + "");
			// System.out.println(value);
			buffer.append(PushUtils.encode(value.getBytes("UTF-8")));

		}
		// System.out.println(PushUtils.MD5(buffer.toString().getBytes(Constants.PUSH_CHARSET)));
		return PushUtils.MD5(buffer.toString().getBytes("UTF-8"));
	}
}
