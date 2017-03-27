package com.push.Utils;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.push.constants.Constants;
import com.push.model.HKPushInfo;
import com.push.model.HKPushIosBean;
import com.push.service.PushMsgService;

/**
 * @author xiemt
 *
 */
public class APNSPushHelper {
	private static Logger logger = Logger.getLogger(APNSPushHelper.class);
	
	/** 是否是开发环境*/
	private boolean isDevelop = new Boolean(SystemUtils.getValue(Constants.APNS_IS_DEVELOP));
	
	 /**APNS开发证书路径**/  
    private  String  certificatePathDevelop = this.getClass().getResource("/").getPath()+"/"+SystemUtils.getValue(Constants.APNS_DEVELOP_CERTIFICATE_PATH) ;  
	 /**APNS生产证书路径**/  
    private  String  certificatePathProduct = this.getClass().getResource("/").getPath()+"/"+SystemUtils.getValue(Constants.APNS_PRODUCT_CERTIFICATE_PATH) ;  
    /**APNS开发证书密码**/ 
    private static String  developPassword =SystemUtils.getValue(Constants.APNS_DEVELOP_PASSWORD); 
    /**APNS生产证书密码**/ 
    private static String  productPassword =SystemUtils.getValue(Constants.APNS_PRODUCT_PASSWORD);

	/**APN推送开发环境host**/ 	
    public static String sandboxHost = SystemUtils.getValue(Constants.APNS_SANDBOX_GATEWAY_HOST);
    
    /**APN推送开发环境port**/ 
    public static int sandboxPort = Integer.parseInt(SystemUtils.getValue(Constants.APNS_SANDBOX_GATEWAY_PORT));
    
    public static String sandboxFeedbackHost = SystemUtils.getValue(Constants.APNS_SANDBOX_FEEDBACK_HOST);
    
    public static int sandboxFeedbackPort = Integer.parseInt(SystemUtils.getValue(Constants.APNS_SANDBOX_FEEDBACK_PORT));
    /**APN推送生产环境host**/ 
    public static String productionHost = SystemUtils.getValue(Constants.APNS_PRODUCTION_GATEWAY_HOST);
    /**APN推送生产环境port**/ 
    public static int productionPort = Integer.parseInt(SystemUtils.getValue(Constants.APNS_PRODUCTION_GATEWAY_PORT));
    
    public static String productionFeedbackHost = SystemUtils.getValue(Constants.APNS_PRODUCTION_FEEDBACK_HOST);
    
    public static int productionFeedbackPort = Integer.parseInt(SystemUtils.getValue(Constants.APNS_PRODUCTION_FEEDBACK_PORT));
    
    private static ApnsService apnsService;
    
    private static APNSPushHelper apnsPushHelper;

    
    private APNSPushHelper(){
    	if(isDevelop){
    		apnsService = APNS.newService()
    						.asPool(2)
    						.withGatewayDestination(sandboxHost, sandboxPort)
    						.withFeedbackDestination(sandboxFeedbackHost, sandboxFeedbackPort)
    						.withCert(certificatePathDevelop,developPassword)
    						.build();
    	}else{
    		apnsService = APNS.newService()
					.asPool(2)
					.withGatewayDestination(productionHost, productionPort)
					.withFeedbackDestination(productionFeedbackHost, productionFeedbackPort)
					.withCert(certificatePathProduct,productPassword)
					.build();
    	}
    }
    
    public synchronized static APNSPushHelper getAPNSPushHelper(){
    	if(apnsPushHelper == null){
    		apnsPushHelper = new APNSPushHelper();
    	}
    	return apnsPushHelper;
    };
    
    
    
    
    /**
     * 发送消息到单个iOS设备
     * @param title
     */
    public void pushMsgToSingleDevice(HKPushIosBean iosBean){
    	try{
    		apnsService.push(iosBean.getApnsToken(), iosBean.getPayload().toString());
    		//消息发送到APNS后算是发送成功
    		HKPushInfo pushInfo = new HKPushInfo();
    		pushInfo.setMsgId(iosBean.getPayload().getString("msgId"));
    		pushInfo.setMemberId(iosBean.getPayload().getString("receiverId"));
    		pushInfo.setMessengerStatus(Constants.MSG_STATUS_RECEIVED);
    	    PushMsgService pushMsgService =(PushMsgService)ContextUtil.getBean("pushMsgService");
    		pushMsgService.updateHkPushMemberMsgStatus(pushInfo);
    	}catch(Exception e){
    		logger.error("发送消息到APNS发生异常。"+e.getMessage());
    	}
        
    }

    /**
     * 发送消息到所有iOS设备
     * @param title
     */
    @SuppressWarnings("unchecked")
	public void pushMsgToAll(HKPushIosBean iosBean){
        apnsService.push(iosBean.getApnsTokens(), iosBean.getPayload().toString());
    }
    
    
	/**
	 * 获取失效token列表
	 */
	public Map<String, Date> getInactiveDevices(){
        return apnsService.getInactiveDevices();	
    }
    
 
    
}