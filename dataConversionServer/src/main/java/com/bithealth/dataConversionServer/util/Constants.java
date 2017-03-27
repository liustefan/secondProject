package com.bithealth.dataConversionServer.util;

/**
 * @ClassName:     Constants.java 
 * @Description:   数据解析常量类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月23日 下午6:44:49
*****/
public class Constants {

    /** 缓存配置文件路径 **/ 
    public static final String  EHCACHE_PATH= "ehcachePath";
      
    /** 数据收发服务配置缓存**/ 
    public static final String  CACHE_DATA_CONFIG= "dataConfig";
    
    
    public static final String  MQ_HOST= "rabbit.host";
    public static final String  MQ_USERNAME= "rabbit.username";
    public static final String  MQ_PASSWORD= "rabbit.password";
    public static final String  MQ_PORT= "rabbit.port";
    public static final String  MQ_VIRTUAL_HOST = "rabbit.virtualHost";
    /** 交换机**/ 
    public static final String  MQ_EXCHANGE_NAME = "rabbit.exchangeName";

    
    /** 消息队列名称：接收队列**/ 
    public static final String  MQ_QUEUE_RECIVE = "rabbit.queueRecive";
    /** 接收队列路由规则**/ 
    public static final String  MQ_RECIVE_ROUTING_KEY = "rabbit.reciveRoutingKey";
    /** 消息队列名称：发送队列**/ 
    public static final String  MQ_QUEUE_SEND = "rabbit.queueSend";
    /** 发送队列路由规则**/ 
    public static final String  MQ_SEND_ROUTING_KEY = "rabbit.sendRoutingKey";
    
    /** 中联佳裕公司code**/ 
    public static final String  ZLJY_CONPANY_CODE = "zljyCompanyCode";
    /** 中联佳裕webservice 调用 method **/ 
    public static final String  ZLJY_WEBSERVICE_METHOD = "zljyWebserviceMethod";
    /** 中联佳裕获取用户信息参数文件 **/ 
    public static final String  ZLJY_GETUSERINFO_PARAM_PATH = "zljyGetuserinfoParamPath";
    /** 中联佳裕MQ命令：解析XML字符串 **/ 
    public static final String  ZLJY_MQ_PARSEXML = "zljyParseXml";
    
    /** 强华公司code**/ 
    public static final String  QH_CONPANY_CODE = "qhCompanyCode";
    
    /** 数据源1：数据解析服务数据库  **/ 
    public static final String  DATA_SOURCE_1= "dataSource1";
    /** 数据源2：数据收发服务数据库  **/ 
    public static final String  DATA_SOURCE_2 = "dataSource2";
    /** 数据源3：强华sqlserver数据库  **/ 
    public static final String  DATA_SOURCE_3 = "dataSource3";
    
    /** UC统一验证相关参数  **/ 
    public static final String  UC_DNS = "dns";
    /** UC统一验证地址  **/ 
    public static final String  UC_HOST = "unifiedauth";
    public static final String  UC_SERVERID = "serverid";
    
    /** 定时任务发送体检信息给中联佳裕  **/ 
    public static final String  T_HEALTH_EXAM_ZLJY = "3";

    /** 定时任务糖尿病随访给中联佳裕  **/ 
    public static final String  T_DIABETES_VISITS_ZLJY = "4";

    /** 定时任务高血压随访给中联佳裕  **/ 
    public static final String  T_HYPERTENSION_VISITS_ZLJY = "5";

    /** 定时任务血糖测量结果给中联佳裕  **/
    public static final String  T_BLOOD_GLUCOSE_ZLJY = "6";

    /** 定时任务发送血压、脉率测量结果给中联佳裕  **/
    public static final String  T_BLOOD_PRESSURE_ZLJY = "7";
    
//    /** 中联佳裕操作：获取某段时间内更新过的个人基本资料信息。 **/ 
//    public static final String  ZLJY_OPERATION_1 = "zljyOperation1";
//    /** 中联佳裕操作：根据个人身份证号码查询个人基本信息。 **/ 
//    public static final String  ZLJY_OPERATION_2 = "zljyOperation2";
//    /** 中联佳裕操作：上传健康体检信息 **/ 
//    public static final String  ZLJY_OPERATION_3 = "zljyOperation3";
//    /** 中联佳裕操作：根据身份证查询体检报告信息 **/ 
//    public static final String  ZLJY_OPERATION_4 = "zljyOperation4";
//    /** 中联佳裕操作：上传血压、脉率测量结果 **/ 
//    public static final String  ZLJY_OPERATION_5 = "zljyOperation5";
//    /** 中联佳裕操作：上传血糖测量结果**/ 
//    public static final String  ZLJY_OPERATION_6 = "zljyOperation6";
//    /** 中联佳裕操作：糖尿病随访信息上传 **/ 
//    public static final String  ZLJY_OPERATION_7 = "zljyOperation7";
//    /** 中联佳裕操作：高血压随访表上传 **/ 
//    public static final String  ZLJY_OPERATION_8 = "zljyOperation8";
//    /** 中联佳裕操作：获取机构数据 **/ 
//    public static final String  ZLJY_OPERATION_9 = "zljyOperation9";
//    /** 中联佳裕操作：获取行政区域数据 **/ 
//    public static final String  ZLJY_OPERATION_10 = "zljyOperation10";

    /** 获取定时任务  **/
    public static final int  SendDatas = 2;
    
    /** 查询间隔天数  **/
    public static final int  ZLJY_INTERVAL_DAY = 1;
    
    
    public static final String QH_EVERY_TIME_NUM = "qhEveryTimeNum";
    
    public static final String PAGE_SIZE_KEY = "pageSize";
    
    public static final String HYPERTENSION_ASSEM_FILE = "Hypertension.xml";
    
    public static final String HYPERTENSION_DETAIL_FILE = "HypertensionDetail.xml";
    
    public static final String HYPERTENSION_ZLJY_FILE = "ZLJYHypertension.xml";
    
    public static final String HYPERTENSION_MEDCIAL_ZLJY_FILE = "ZLJYHypertensionMedical.xml";
    
    public static final String CONTACT_SEPARATOR = "@#";
    
    public static final String params1="params1";
    
    public static final String params2="params2";
    
    /**
    * HKEJ注册地址
    */
    public static final String HKEJ_REGISTER_URL="hkejRegisterUrl";
    
    /**
    * 注册HKEJ每次鼻梁最大发送的会员数
    */
    public static final String HKEJ_REGISTER_MAX="hkejRegisterMax";
    

}