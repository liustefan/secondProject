package com.push.Utils;


import org.apache.log4j.Logger;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushBatchUniMsgRequest;
import com.baidu.yun.push.model.PushBatchUniMsgResponse;
import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToAllResponse;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
import com.baidu.yun.push.model.PushMsgToTagRequest;
import com.baidu.yun.push.model.PushMsgToTagResponse;
import com.baidu.yun.push.model.QueryDeviceNumInTagRequest;
import com.baidu.yun.push.model.QueryDeviceNumInTagResponse;
import com.baidu.yun.push.model.QueryMsgStatusRequest;
import com.baidu.yun.push.model.QueryMsgStatusResponse;
import com.baidu.yun.push.model.QueryStatisticDeviceRequest;
import com.baidu.yun.push.model.QueryStatisticDeviceResponse;
import com.baidu.yun.push.model.QueryStatisticMsgRequest;
import com.baidu.yun.push.model.QueryStatisticMsgResponse;
import com.baidu.yun.push.model.QueryStatisticTopicRequest;
import com.baidu.yun.push.model.QueryStatisticTopicResponse;
import com.baidu.yun.push.model.QueryTimerListRequest;
import com.baidu.yun.push.model.QueryTimerListResponse;
import com.baidu.yun.push.model.QueryTimerRecordsRequest;
import com.baidu.yun.push.model.QueryTimerRecordsResponse;
import com.baidu.yun.push.model.QueryTopicListRequest;
import com.baidu.yun.push.model.QueryTopicListResponse;
import com.baidu.yun.push.model.QueryTopicRecordsRequest;
import com.baidu.yun.push.model.QueryTopicRecordsResponse;
import com.push.constants.Constants;



/**
 * 百度推送帮助类
 * @author xiemt
 *
 */
public class BaiduPushHelper {
	
	private static Logger logger = Logger.getLogger(BaiduPushHelper.class);
	
	private static BaiduPushHelper pushHelper ;
	
	private PushKeyPair  androidPair;
	private PushKeyPair  iosPair;
	
	private BaiduPushClient androidPushClient;
	private BaiduPushClient iosPushClient;
	

	private BaiduPushHelper(){		
		this.androidPair = new PushKeyPair(SystemUtils.getValue(Constants.ANDROID_API_KEY), SystemUtils.getValue(Constants.ANDROID_SECRET_KEY));
		this.iosPair = new PushKeyPair(SystemUtils.getValue(Constants.IOS_API_KEY), SystemUtils.getValue(Constants.IOS_SECRET_KEY));
		this.androidPushClient = new BaiduPushClient(androidPair,BaiduPushConstants.CHANNEL_REST_URL);
		this.iosPushClient = new BaiduPushClient(iosPair,BaiduPushConstants.CHANNEL_REST_URL);
	}
	
	/**
	 * 获取帮助类实例对象
	 * @return
	 */
	public static BaiduPushHelper getHelper(){		
		if(pushHelper == null){
			pushHelper = new BaiduPushHelper();
		}
		return pushHelper;
	}
	
	/**
	 * 推送消息到单个设备
	 * @param request
	 * @return
	 */
	public PushMsgToSingleDeviceResponse pushMsgToSingleDevice(PushMsgToSingleDeviceRequest request){
		logger.info("推送消息到百度服务器线程开始执行。");
		PushMsgToSingleDeviceResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.pushMsgToSingleDevice(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.pushMsgToSingleDevice(request);
			}
		} catch (PushClientException e) {
			e.printStackTrace();
			logger.error("推送消息到单个设备异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}
	
	

	/**
	 * 推送消息到所有设备
	 * @param request
	 * @return
	 */
	public PushMsgToAllResponse pushMsgToAll(PushMsgToAllRequest request){
		PushMsgToAllResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.pushMsgToAll(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.pushMsgToAll(request);
			}
		} catch (PushClientException e) {
			logger.error("推送消息到所有设备异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}
	

	/**
	 * 推送消息到多个设备用户
	 * @param request
	 */
	public PushBatchUniMsgResponse pushBatchUniMsg(PushBatchUniMsgRequest request){
		PushBatchUniMsgResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.pushBatchUniMsg(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.pushBatchUniMsg(request);
			}
		} catch (PushClientException e) {
			logger.error("推送消息到多个设备用户异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}

	/**
	 * 推送消息到tag关联设备
	 * @param request
	 */
	public PushMsgToTagResponse pushMsgToTag(PushMsgToTagRequest request){
		PushMsgToTagResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.pushMsgToTag(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.pushMsgToTag(request);
			}
		} catch (PushClientException e) {
			logger.error("推送消息到tag广联设备异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}
	
	/**
	 * 查看标签组中关联的设备。
	 * @param request
	 * @return
	 */
	public QueryDeviceNumInTagResponse queryDeviceNumInTag(QueryDeviceNumInTagRequest request){
		QueryDeviceNumInTagResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.queryDeviceNumInTag(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.queryDeviceNumInTag(request);
			}
		} catch (PushClientException e) {
			logger.error("查看标签组中关联的设备异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}
	
	/**
	 * 查询消息推送状态，包括成功、失败、待发送、发送中4种状态。
	 * @param request
	 * @return
	 */
	public QueryMsgStatusResponse queryMsgStatus(QueryMsgStatusRequest request){
		QueryMsgStatusResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.queryMsgStatus(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.queryMsgStatus(request);
			}
		} catch (PushClientException e) {
			logger.error("查询消息推送状态异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}
	
	/**
	 * 统计安装了app的设备数,返回30天的所有统计项。
	 * @param request
	 * @return
	 */
	public QueryStatisticDeviceResponse queryStatisticDevice(QueryStatisticDeviceRequest request){
		QueryStatisticDeviceResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.queryStatisticDevice(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.queryStatisticDevice(request);
			}
		} catch (PushClientException e) {
			logger.error("统计安装了app的设备数异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}
	
	/**
	 * 统计app消息信息,返回30天所有统计项
	 * @param request
	 * @return
	 */
	public QueryStatisticMsgResponse queryStatisticMsg(QueryStatisticMsgRequest request){
		QueryStatisticMsgResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.queryStatisticMsg(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.queryStatisticMsg(request);
			}
		} catch (PushClientException e) {
			logger.error("统计app消息信息异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}
	
	/**
	 * 统计app某个分类主题的30天内的消息数。
	 * @param request
	 * @return
	 */
	public QueryStatisticTopicResponse queryStatisticTopic(QueryStatisticTopicRequest request){
		QueryStatisticTopicResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.queryStatisticTopic(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.queryStatisticTopic(request);
			}
		} catch (PushClientException e) {
			logger.error("统计app某个分类主题异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}
	
	/**
	 * 询定时推送任务信息列表。目前，每个应用可设置10个有效的定时任务。
	 * @param request
	 * @return
	 */
	public QueryTimerListResponse queryTimerList(QueryTimerListRequest request){
		QueryTimerListResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.queryTimerList(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.queryTimerList(request);
			}
		} catch (PushClientException e) {
			logger.error("询定时推送任务信息列表异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}
	
	/**
	 * 根据 timerId，获取一个定时的消息推送记录。
	 * @param request
	 * @return
	 */
	public QueryTimerRecordsResponse queryTimerRecords(QueryTimerRecordsRequest request){
		QueryTimerRecordsResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.queryTimerRecords(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.queryTimerRecords(request);
			}
		} catch (PushClientException e) {
			logger.error("获取定时的消息推送记录异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}
	
	/**
	 * 查询当前90天内消息推送中使用的类别主题的信息。
	 * @param request
	 * @return
	 */
	public QueryTopicListResponse queryTopicList(QueryTopicListRequest request){
		QueryTopicListResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.queryTopicList(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.queryTopicList(request);
			}
		} catch (PushClientException e) {
			logger.error("查询当前90天内消息推送中使用的类别主题的信息异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}
	
	/**
	 * 根据 topic_id， 获取相应时间范围内的消息推送记录。
	 * @param request
	 * @return
	 */
	public QueryTopicRecordsResponse queryTopicRecords(QueryTopicRecordsRequest request){
		QueryTopicRecordsResponse response=null;
		try {
			int deviceType = request.getDevice();
			if(Constants.BAIDU_DEVICE_TYPE_ANDROID == deviceType){
				setAndroidChannelLogHandler();
				response = androidPushClient.queryTopicRecords(request);
			}
			if(Constants.BAIDU_DEVICE_TYPE_IOS == deviceType){
				setIosChannelLogHandler();
				response = iosPushClient.queryTopicRecords(request);
			}
		} catch (PushClientException e) {
			logger.error("获取相应时间范围内的消息推送记录异常！"+e.getMessage());
		}catch (PushServerException e) {
			logger.error(String.format("requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			
		}
		return response;
	}
	
	

	private void setAndroidChannelLogHandler(){
		androidPushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				logger.info(event.getMessage());
			}
		});
	}
	
	private void setIosChannelLogHandler(){
		iosPushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				logger.info(event.getMessage());
			}
		});
	}
    
}