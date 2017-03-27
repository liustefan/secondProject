package com.push.thread;


import com.baidu.yun.push.model.PushBatchUniMsgRequest;
import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToTagRequest;
import com.push.Utils.APNSPushHelper;
import com.push.Utils.BaiduPushHelper;
import com.push.constants.Constants;
import com.push.model.HKPushIosBean;

/**
 * @author xiemt
 *
 */
public class PushThreadTask implements Runnable{
	
	BaiduPushHelper pushHelper = BaiduPushHelper.getHelper();
	
	APNSPushHelper apnsPushHelper = APNSPushHelper.getAPNSPushHelper();
	
	public int executeMethod ;
	
	public PushThreadTask(){
	}
	
	private Object request;
	
	
	/**
	 * 推送消息到单个设备
	 * @param request
	 */
	public PushThreadTask pushMsgToSingleDevice(PushMsgToSingleDeviceRequest request){
		executeMethod = Constants.METHOD_PUSHMSGTOSINGLEDEVICE; 
		this.request = request;
		return this;
	}
	
	/**
	 * 推送消息到所有设备
	 * @param request
	 */
	public PushThreadTask pushMsgToAll(PushMsgToAllRequest request){
		executeMethod = Constants.METHOD_PUSHMSGTOALL; 
		this.request = request;
		return this;
	}

	/**
	 * 推送消息到多个设备用户
	 * @param request
	 */
	public PushThreadTask pushBatchUniMsg(PushBatchUniMsgRequest request){
		executeMethod = Constants.METHOD_PUSHBATCHUNIMSG; 
		this.request = request;
		return this;
	}
	
	/**
	 * 推送消息到tag关联设备
	 * @param request
	 */
	public PushThreadTask pushMsgToTag(PushMsgToTagRequest request){
		executeMethod = Constants.METHOD_PUSHMSGTOTAG; 
		this.request = request;
		return this;
	}

	
	/**
	 * 推送消息到单个设备
	 * @param request
	 */
	public PushThreadTask pushMsgToSingleDeviceForIos(HKPushIosBean request){
		executeMethod = Constants.METHOD_PUSHMSGTOSINGLEDEVICEFORIOS; 
		this.request = request;
		return this;
	}
	
	
	/**
	 * 推送消息到所有ios设备
	 * @param request
	 */
	public PushThreadTask pushMsgToAllForIos(HKPushIosBean request){
		executeMethod = Constants.METHOD_PUSHMSGTOALLFORIOS; 
		this.request = request;
		return this;
	}
	
	
	@Override
	public void run() {
		switch(executeMethod){
		case Constants.METHOD_PUSHMSGTOSINGLEDEVICE:pushHelper.pushMsgToSingleDevice((PushMsgToSingleDeviceRequest)request);break;
		case Constants.METHOD_PUSHMSGTOALL:pushHelper.pushMsgToAll((PushMsgToAllRequest)request);break;
		case Constants.METHOD_PUSHBATCHUNIMSG:pushHelper.pushBatchUniMsg((PushBatchUniMsgRequest)request);break;
		case Constants.METHOD_PUSHMSGTOTAG:pushHelper.pushMsgToTag((PushMsgToTagRequest)request);break;
		case Constants.METHOD_PUSHMSGTOSINGLEDEVICEFORIOS:apnsPushHelper.pushMsgToSingleDevice((HKPushIosBean)request);break;
		case Constants.METHOD_PUSHMSGTOALLFORIOS:apnsPushHelper.pushMsgToAll((HKPushIosBean)request);break;
		default:; break;
		}
	}
}
