package com.push.constants;

/** 
 * @ClassName: Constants 
 * @Description: 推送平台常量类
 * @author 谢美团
 * @date 2015年12月8日 下午2:51:03  
 */
public class Constants {
	
	/**
	 * 系统错误
	 */
	public static final int SYSTEM_ERROR =-1;
	/**
	 * 参数错误
	 */
	public static final int PARAMETER_ERROR =2000;
	/**
	 * 签名错误
	 */
	public static final int SIGN_ERROR =2001;
	/**
	 * 第三方推送不可用
	 */
	public static final int THIRD_PUSH_NOT_AVAILABLE =2002;
	/**
	 * 用户的APP在线（与第三方推送平台保持连接）
	 */
	public static final String USER_APP_ON_LINE ="on";
	/**
	 * 用户的APP离线（与第三方推送平断开连接）
	 */
	public static final String USER_APP_OFF_LINE ="off";
	
	
	/** 第三方推送平台 android apiKey **/
	public static final String ANDROID_API_KEY = "androidApiKey";
	/** 第三方推送平台 android secretKey **/
	public static final String ANDROID_SECRET_KEY = "androidSecretKey";
	
	/** 第三方推送平台 ios apiKey **/
	public static final String IOS_API_KEY = "iosApiKey";
	/** 第三方推送平台 ios secretKey **/
	public static final String IOS_SECRET_KEY = "iosSecretKey";
	
	/** 第三方推送平台发布状态 **/
	public static final String DEPLOY_STATUS = "deployStatus";
	
	/**  通知标题*/
	public static final String ADVICE_TITLE = "adviceTitle";
	
	/**  iOS通知铃声样式*/
	public static final String ADVICE_IOS_SOUND = "adviceIosSound";
	
	/** 在线状态 **/
	public static final int ON_LINE = 0;
	/** 离线状态 **/
	public static final int OFF_LINE = 1;
	
	/** 成功 **/
	public static final String SUCCESS_MSG = "success";
	/** 失败 **/
	public static final String ERROR_MSG = "error";
	
	/**消息类型， 透传消息**/
	public static final int MSG_TYPE_0 = 0;
	
	/**消息类型,通知*/
	public static final int MSG_TYPE_1 = 1;

	/** 更新tag原有用户为新的用户 **/
	public static final String UPDATE_TAG_MEMBER = "0";
	/** 在原有tag群组用户中添加新用户 **/
	public static final String ADD_TAG_MEMBER = "1";
    
	/**设备类型：Android*/
	public static final int DEVICE_TYPE_ANDROID = 0;
	
	/**设备类型：iOS*/
	public static final int DEVICE_TYPE_IOS = 1;
	
	/**设备类型：pc*/
	public static final int DEVICE_TYPE_PC = 3;
	
	/**设备类型：all*/
	public static final int DEVICE_TYPE_ALL = 4;
	
	/**消息状态：已接收*/
	public static final int MSG_STATUS_RECEIVED= 0;	
	
	/**消息状态：未接收*/
	public static final int MSG_STATUS_NOT_RECEIVED = 1;
	
	/**消息失效时间*/
	public static final String MSG_EXPIRES_TIME = "msgExpiresTime";
	
	/**方法：推送消息到单个设备*/
	public static final int METHOD_PUSHMSGTOSINGLEDEVICE = 1;
	
	/**方法：推送消息到所有设备*/
	public static final int METHOD_PUSHMSGTOALL = 2;
	
	/**方法：推送消息到多个设备用户*/
	public static final int METHOD_PUSHBATCHUNIMSG = 3;
	
	/**方法：推送消息到tag关联设备*/
	public static final int METHOD_PUSHMSGTOTAG = 4;
	
	/**方法：推送消息到单个ios设备*/
	public static final int METHOD_PUSHMSGTOSINGLEDEVICEFORIOS = 5;
	
	/**方法：推送消息到所有ios设备*/
	public static final int METHOD_PUSHMSGTOALLFORIOS = 6;

	/**百度推送设备类型：Android*/
	public static final int BAIDU_DEVICE_TYPE_ANDROID = 3;
	
	/**百度推送设备类型：iOS*/
	public static final int BAIDU_DEVICE_TYPE_IOS = 4;
	
	/**APNS开发证书路径**/  
	public static final String APNS_DEVELOP_CERTIFICATE_PATH ="apnsDeveloPpath";
	
	/**APNS开发证书密码**/ 
	public static final String APNS_DEVELOP_PASSWORD ="apnsDevelopPassword";
	
	/**APNS生产证书路径**/  
	public static final String APNS_PRODUCT_CERTIFICATE_PATH ="apnsProductPath";
	
	/**APNS生产证书密码**/ 
	public static final String APNS_PRODUCT_PASSWORD ="apnsProductPassword";
	
	/**APN推送开发环境host**/ 	
    public static final String APNS_SANDBOX_GATEWAY_HOST = "apnsSandboxGatewayHost";
    
    /**APN推送开发环境port**/ 
    public static final String APNS_SANDBOX_GATEWAY_PORT = "apnssandboxGatewayPort";
    
    /**APN推送开发环境失效token host**/
    public static final String APNS_SANDBOX_FEEDBACK_HOST = "apnsSandboxFeedbackHost";
    
    /**APN推送开发环境失效token port**/ 
    public static final String APNS_SANDBOX_FEEDBACK_PORT = "apnsSandboxFeedbackPort";

    /**APN推送生产环境host**/ 
    public static final String APNS_PRODUCTION_GATEWAY_HOST = "apnsProductionGatewayHost";
    
    /**APN推送生产环境port**/ 
    public static final String APNS_PRODUCTION_GATEWAY_PORT = "apnsProductionGatewayPort";
    
    /**APN推送生产环境 失效token host**/ 
    public static final String APNS_PRODUCTION_FEEDBACK_HOST = "apnsProductionFeedbackHost";
    
    /**APN推送生产环境失效token port**/
    public static final String APNS_PRODUCTION_FEEDBACK_PORT = "apnsProductionFeedbackPort";
    
    /**APN推送最大字节数**/
    public static final int APNS_MAX_PAYLOAD_LENGTH = 2048;
    
    /**APN推送生产环境 失效token host**/ 
    public static final String APNS_IS_DEVELOP = "apnsIsDevelop";
    
    /** 延迟推送消息缓存名称 **/ 
    public static final String CACHE_NAME = "deplayMsg";
    
    /** 连接数据库获取延迟推送消息的间隔时间 **/ 
    public static final String  TIME_SPACING= "timeSpacing";
    
    /** 缓存配置文件路径 **/ 
    public static final String  EHCACHE_PATH= "ehcachePath";
    /** 是否启用延迟推推送功能 **/ 
    public static final String  IS_USER_DEPLAY_FUNCTION= "isUserDeplayFunction";
    
    
    /** 短信语音发送方法：获取账号基本信息 **/ 
    public static final String  SMS_METHOD_GETUSERINFO= "getUserInfo";
    
    /** 短信语音发送方法：发送短信或语音 **/ 
    public static final String  SMS_METHOD_CLUSTERSEND= "clusterSend";
    
    /** 短信语音发送方法：修改密码**/ 
    public static final String  SMS_METHOD_SETUSERINFO= "setUserInfo";
    
    /** 短信语音发送方法：短信发送统计 **/ 
    public static final String  SMS_METHOD_GETSENDCOUNT= "getSendCount";
    
    /** 短信语音发送方法：支持自扩展端口发送短信 **/ 
    public static final String  SMS_METHOD_CLUSTERSENDFORPORT= "clusterSendForPort";
    
    /** 短信语音发送方法：收取上行短信**/ 
    public static final String  SMS_METHOD_GETMOMSG= "getMoMsg";
       
    /** 短信发送队列缓存名称：优先级**/ 
    public static final String  CACHE_SMS_LEVEL= "cacheSms";
    
    /** 短信发送队列缓存名称：优先级1**/ 
    public static final String  CACHE_SMS_LEVEL1= "cacheSms1";
    
    /** 短信发送队列缓存名称：优先级2**/ 
    public static final String  CACHE_SMS_LEVEL2= "cacheSms2";
    
    /** 短信发送队列缓存名称：优先级3**/ 
    public static final String  CACHE_SMS_LEVEL3= "cacheSms3";
    
    /** 短信发送队列缓存名称：优先级4**/ 
    public static final String  CACHE_SMS_LEVEL4= "cacheSms4";
    
    /** 短信发送队列缓存名称：优先级5**/ 
    public static final String  CACHE_SMS_LEVEL5= "cacheSms5";
    
    /** 短信发送配置信息缓存**/ 
    public static final String  CACHE_SMS_CONFIG= "smsCofig";
  
    
    
    
    
    
    
    
	
}