package com.push.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.push.Utils.APNSPushHelper;
import com.push.Utils.PushUtils;
import com.push.Utils.SystemUtils;
import com.push.constants.Constants;
import com.push.dao.PushMemberMapper;
import com.push.dao.PushMsgMapper;
import com.push.dao.PushTagMapper;
import com.push.model.CustomContent;
import com.push.model.HKPushIosBean;
import com.push.model.HKPushMsgFormatBean;
import com.push.model.HKPushInfo;
import com.push.model.HkPushMember;
import com.push.result.ResultObject;
import com.push.service.PushMsgService;
import com.push.thread.PushThreadTask;

/**
 * @author 
 *
 */
@Service("pushMsgService")
public class PushMsgServiceImpl implements PushMsgService {
	
	private static Logger logger = Logger.getLogger(PushMsgServiceImpl.class); 
	
	APNSPushHelper apnsPushHelper = APNSPushHelper.getAPNSPushHelper();
	
	@Autowired 
	private TaskExecutor taskExecutor;

	@Autowired
	private PushMsgMapper pushMsgMapper;
	
	@Autowired
	private PushMemberMapper pushMemberMapper;
	
	@Autowired
	private PushTagMapper pushTagMapper;
	
	@Override
	public void updateHkPushMemberMsgStatus(HKPushInfo pushInfo) throws Exception {
		pushMsgMapper.updateHkPushMemberMsgStatus(pushInfo);
	}

	@Override
	public List<HKPushInfo> selectHKPushInfoByMemberId(HKPushInfo pushInfo) throws Exception {
		return pushMsgMapper.selectHKPushInfoByMemberId(pushInfo.getMemberId());
	}

	@Override
	public void pushByMemberId(HKPushInfo pushInfo) {
		
		//生成消息ID
		pushInfo.setMsgId(getMsgId());	
		long currentTime = System.currentTimeMillis()/1000/60; //只比较分钟
		long sendTime = pushInfo.getSendTime()/1000/60; //只比较分钟
		boolean isUseDeplayFunction = SystemUtils.getValue(Constants.IS_USER_DEPLAY_FUNCTION).equals("true");
		if(!isUseDeplayFunction){
			pushInfo.setSendTime(0);
		}
		//根据发送时间判断是否发送消息
		if( sendTime<= currentTime +5){
			//查找memberID对应的channelID 最新的登录这信息
			HkPushMember memberInfo = pushMemberMapper.queryPushMemberByMemberId(pushInfo.getMemberId());
			if(memberInfo != null && pushInfo.getMemberId().equals(memberInfo.getMemberId())){
				try{
					//用户在线
					if(Constants.ON_LINE == memberInfo.getLineStatus()){
						pushInfo.setChannelId(memberInfo.getChannelId());
						pushInfo.setDeviceType(memberInfo.getLoginPlatform());
						pushSingleMsg(pushInfo);
						logger.info("用户在线开始推送消息");
					}else{
						logger.info("用户离线线延后推送消息");
					}
				}catch(Exception e){
					logger.error("推送单条消息异常", e);
				}
			}
		}

		//无论在线与否，保存用户的推送消息
		pushInfo.setMessengerStatus(Constants.MSG_STATUS_NOT_RECEIVED);
		pushMsgMapper.saveMsgMember(pushInfo);
		pushMsgMapper.saveMessenger(pushInfo);
		
	}

	/**
	 * 推送多条消息
	 * @param pushInfoList
	 */
	public void pushMultiMsg(List<HKPushInfo> pushInfoList){
		if(pushInfoList == null || pushInfoList.size() == 0){
			return;
		}
		for(HKPushInfo pushInfo:pushInfoList){
			pushSingleMsg(pushInfo);
		}
	}
	
	/**
	 * 推送单条消息
	 * @param pushInfo
	 */
	public void pushSingleMsg(HKPushInfo pushInfo){

		JSONObject  msgJsonObj =  formatPushMsg(pushInfo);
		//消息推送
		if(pushInfo.getDeviceType() == Constants.DEVICE_TYPE_ANDROID){
			//封装推送参数及推送内容
			PushMsgToSingleDeviceRequest pushPequest = new PushMsgToSingleDeviceRequest();
			pushPequest.setChannelId(pushInfo.getChannelId());
			//pushPequest.setMessageType(pushInfo.getMsgType());//0：消息（透传给应用的消息体）1：通知（对应设备上的消息通知）
			pushPequest.setMessageType(0);//安卓统一调用 透传形式，弹出内容有客户端处理
			pushPequest.setDeviceType(getDeviceType(pushInfo.getDeviceType()));
			pushPequest.setMessage(msgJsonObj.toString());
			if(Constants.DEVICE_TYPE_IOS == pushInfo.getDeviceType()){
				pushPequest.setDeployStatus(Integer.parseInt(SystemUtils.getValue(Constants.DEPLOY_STATUS))); //1：开发状态  2：生产状态 默认为生产状态
			}
			pushPequest.setMsgExpires(Integer.parseInt(SystemUtils.getValue(Constants.MSG_EXPIRES_TIME)));// 相对于当前时间的消息过期时间，单位为秒
			taskExecutor.execute(new PushThreadTask().pushMsgToSingleDevice(pushPequest));
		}else if(pushInfo.getDeviceType() == Constants.DEVICE_TYPE_IOS){
			HKPushIosBean iosBean = new HKPushIosBean();
			iosBean.setPayload(msgJsonObj);
			iosBean.setApnsToken(pushInfo.getChannelId());
			taskExecutor.execute(new PushThreadTask().pushMsgToSingleDeviceForIos(iosBean));
		}
	}

	/**
	 * 格式化推送消息格式
	 * @param pushInfo
	 * @return
	 */
	private JSONObject formatPushMsg(HKPushInfo pushInfo){
		HKPushMsgFormatBean formatBean = new HKPushMsgFormatBean();
		
		if(Constants.DEVICE_TYPE_IOS == pushInfo.getDeviceType()){//iOS通知消息格式
			JSONObject jsonAPS = new JSONObject();
			jsonAPS.put("alert", pushInfo.getTitle()==null?SystemUtils.getValue(Constants.ADVICE_TITLE):pushInfo.getTitle());
			jsonAPS.put("sound", SystemUtils.getValue(Constants.ADVICE_IOS_SOUND)); // 设置通知铃声样式，用户自定义。
			jsonAPS.put("badge", pushInfo.getBadge());
			formatBean.setAps(jsonAPS);
			formatBean.setReceiverId(pushInfo.getMemberId());
			formatBean.setSenderId(pushInfo.getSender());
			formatBean.setTimestamp(System.currentTimeMillis());
			formatBean.setData(pushInfo.getData());
			formatBean.setMsgId(pushInfo.getMsgId());
		}else if(Constants.DEVICE_TYPE_ANDROID == pushInfo.getDeviceType()){//android
			formatBean.setReceiverId(pushInfo.getMemberId());
			formatBean.setSenderId(pushInfo.getSender());
			formatBean.setTimestamp(System.currentTimeMillis());
			formatBean.setData(pushInfo.getData());
			formatBean.setMsgId(pushInfo.getMsgId());
		}
		
		
		

		
		return PushUtils.BeanToJsonObject(formatBean);
	}
	
	
	
	/**
	 * 根据消息内容等生成消息ID
	 * @return
	 */
	public synchronized String getMsgId(){
		String msgId=null;
		try {
			msgId = String.valueOf(System.nanoTime()).replace("-", "");
		} catch (Exception e) {
			logger.error("生成消息ID时发生异常！"+e.getMessage());
		}
		return msgId;
	}
	
	/**
	 * 根据登陆平台获取推送设备类型
	 * @param data
	 * @return
	 */
	private int getDeviceType(int loginPlatform){
		int deviceType; 
		switch(loginPlatform){
			case 0:deviceType=Constants.BAIDU_DEVICE_TYPE_ANDROID;break;/* android */
			case 1:deviceType=Constants.BAIDU_DEVICE_TYPE_IOS;break;/* ios */
			default : deviceType = 3;break;/* android */
		}
		return deviceType;
	}
	
	@Override
	public void pushByMemberIds(HKPushInfo pushInfo) {
		JSONArray memberIdArray = JSONArray.fromObject(pushInfo.getMemberIds());
    	for(Object obj:memberIdArray){
    		pushInfo.setMemberId(obj.toString());
    		pushByMemberId(pushInfo);
    	}
	}

	@Override
	public ResultObject pushByTag(HKPushInfo pushInfo) {
		ResultObject  result = new ResultObject();
		pushInfo.setTag(pushInfo.getModel()+"_"+pushInfo.getTag());
		//获取tag对应的用户信息
		List<HKPushInfo> memberList = pushTagMapper.queryMemberByTag(pushInfo.getTag());
		if(null != memberList && memberList.size() != 0){
			pushMsgByTag(memberList,pushInfo);
		}else{
			result.setResult(Constants.PARAMETER_ERROR,"参数[tag]不存在或没有关联用户！","");
		}
		return result;
	}

	@Override
	public ResultObject pushByTags(HKPushInfo pushInfo) {
		ResultObject  result = new ResultObject();
		JSONArray tags;
		try{
			tags= JSONArray.fromObject(pushInfo.getTags());
		}catch(Exception e){
			logger.error("参数[tags]格式错误！",e);
			result.setResult(Constants.PARAMETER_ERROR, "参数[tags]格式错误！", "");
			return result;
		}
		//获取多个tag对应的用户信息
		@SuppressWarnings("deprecation")
		List<HKPushInfo> memberList = pushTagMapper.queryMemberByTags(JSONArray.toList(tags));
		
		if(null != memberList && memberList.size() != 0){
			pushMsgByTag(memberList,pushInfo);
		}else{
			result.setResult(Constants.PARAMETER_ERROR,"参数[tag]不存在或没有关联用户！","");
		}
		return result;
	}

	/**
	 * 
	 * @param memberList
	 * @param pushInfo
	 */
	private void pushMsgByTag(List<HKPushInfo> memberList,HKPushInfo pushInfo){
		long currentTime = System.currentTimeMillis()/1000;
		
		boolean isUseDeplayFunction = SystemUtils.getValue(Constants.IS_USER_DEPLAY_FUNCTION).equals("true");
		if(!isUseDeplayFunction){
			pushInfo.setSendTime(0);
		}
		//根据发送时间判断是否发送消息
		if(pushInfo.getSendTime() < currentTime){
			//需要发送的用户集合 （把tag关联的用户以其ChannelId为key存入Map中，当有相同ChannelId时，后面的值将覆盖前面的值，确保memberList是按登录时间降序排列）
			Map<String,HKPushInfo> sendMemberMap  = new HashMap<String,HKPushInfo>();
			pushInfo.setMsgId(getMsgId());
			for(HKPushInfo member:memberList){
				member.setData(pushInfo.getData());
				member.setSender(pushInfo.getSender());
				member.setTitle(pushInfo.getTitle());
				member.setDescription(pushInfo.getDescription());
				member.setMsgId(pushInfo.getMsgId());
				member.setMessengerStatus(Constants.MSG_STATUS_NOT_RECEIVED);
				member.setMsgType(pushInfo.getMsgType());
				member.setDeviceType(member.getLoginPlatform());
				sendMemberMap.put(member.getChannelId(), member);
			}
			try{
				//发送消息
				for(HKPushInfo hKPushInfo :sendMemberMap.values()){
					pushSingleMsg(hKPushInfo);
				}
			}catch(Exception e){
				logger.error("根据自定义的tag推送消息异常",e);
			}
		}
		
		//保存用户推送消息
		pushMsgMapper.saveMsgMemberBatch(memberList);
		pushMsgMapper.saveMessenger(memberList.get(0));
	}
	
	
	
	
	@Override
	public void pushToAll(HKPushInfo pushInfo) {
		List<HKPushInfo> pushInfoList = pushMemberMapper.queryAllMemberId();
		pushInfo.setMsgId(getMsgId());
		pushInfo.setMemberId("all");
		long currentTime = System.currentTimeMillis()/1000;
		boolean isUseDeplayFunction = SystemUtils.getValue(Constants.IS_USER_DEPLAY_FUNCTION).equals("true");
		if(!isUseDeplayFunction){
			pushInfo.setSendTime(0);
		}
		//根据发送时间判读是否发送消息
		if(pushInfo.getSendTime() < currentTime){
			//ios在线用户token List
			List<String> iosTokenList = new ArrayList<String>();
			
			for(HKPushInfo tempPushInfo:pushInfoList){
				tempPushInfo.setMsgId(pushInfo.getMsgId());
				tempPushInfo.setMessengerStatus(Constants.MSG_STATUS_NOT_RECEIVED);
				if(tempPushInfo.getLoginPlatform() == 1 && tempPushInfo.getLineStatus() == 0){
					iosTokenList.add(tempPushInfo.getChannelId());
				}
			}
			
			try{
				//推送到Android平台
				pushInfo.setDeviceType(Constants.DEVICE_TYPE_ANDROID);
				pushMsgToAllDevice(pushInfo);
				//推送到iOS平台
				pushInfo.setDeviceType(Constants.DEVICE_TYPE_IOS);
				pushMsgToAllDeviceForIos(pushInfo,iosTokenList);
			}catch(Exception e){
				logger.error("推送消息到应用所有绑定用户异常", e);
			}
		}
		//保存用户推送消息
		pushMsgMapper.saveMsgMemberBatch(pushInfoList);
		pushMsgMapper.saveMessenger(pushInfo);	
	}
	
	/**
	 * 推送消息到所有设备（广播）
	 * @param pushInfo
	 */
	public void pushMsgToAllDevice(HKPushInfo pushInfo){
		JSONObject  msgJsonObj =  formatPushMsg(pushInfo);
		
		PushMsgToAllRequest pushPequest = new PushMsgToAllRequest();
		
		pushPequest.setMessageType(pushInfo.getMsgType());//0：消息（透传给应用的消息体）1：通知（对应设备上的消息通知）
		pushPequest.setDeviceType(getDeviceType(pushInfo.getDeviceType()));
		pushPequest.setMessage(msgJsonObj.toString());
		if(Constants.DEVICE_TYPE_IOS == pushInfo.getDeviceType()){
			pushPequest.setDeployStatus(Integer.parseInt(SystemUtils.getValue(Constants.DEPLOY_STATUS))); //1：开发状态  2：生产状态 默认为生产状态
		}
		pushPequest.setMsgExpires(Integer.parseInt(SystemUtils.getValue(Constants.MSG_EXPIRES_TIME)));// 相对于当前时间的消息过期时间，单位为秒
		
		taskExecutor.execute(new PushThreadTask().pushMsgToAll(pushPequest));
	}
	
	/**
	 * 推送消息到所有ios设备（广播）
	 * @param pushInfo
	 */
	public void pushMsgToAllDeviceForIos(HKPushInfo pushInfo,List<String> tokenList){
		HKPushIosBean iosBean = new HKPushIosBean();
		JSONObject  msgJsonObj =  formatPushMsg(pushInfo);	
		iosBean.setPayload(msgJsonObj);
		iosBean.setApnsTokens(tokenList);
		taskExecutor.execute(new PushThreadTask().pushMsgToAllForIos(iosBean));
	}
		
}
