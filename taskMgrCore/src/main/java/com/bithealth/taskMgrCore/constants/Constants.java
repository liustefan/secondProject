package com.bithealth.taskMgrCore.constants;

/**
 * @ClassName:     Constants.java 
 * @Description:    定时任务服务常量类
 * @author         柴仕富
 * @version        V1.0   
 * @Date           2016年08月31日 下午3:59:32
*****/
public class Constants {
 
    /** 启动定时器的状态1，启动，2，禁用 **/ 
    public static final int  detaCenter= 1;
    /** job名称**/
    /**中联**/
    public static final String  HistoryUserData= "HistoryUserData";
    public static final String  ZLJYGetDataJob= "ZLJYGetDataJob"; 
    public static final String  ZLJYResendData= "ZLJYResendData"; 
    
    /************会员Job名称*****************/
    public static final String  MEMBER_INSERT= "MemberInsert";
    public static final String  MEMBER_DELETE= "MemberDelete"; 
    public static final String  MEMBER_UPDATE= "MemberUpdate"; 
 
    /************测量Job名称*****************/
    
    public static final String  MEASURE_RESULT_MSG_SEND= "MeasureResultMsgSend"; 
    
    /** webservice超时时间 **/ 
    public static final String  WEBSERVICE_TIMEOUT= "webServiceTimeOut";
    
    /**失败最大次数**/
    public static final int MAX_FAIL_TIMES = 3;
    
    
    /** 交换机**/ 
    public static final String  MQ_EXCHANGE_NAME = "MiningServer_ACKNOWLEDGE_SEVICE";

    
    /** 消息队列名称：测量分析结果接收队列**/ 
    public static final String  MQ_QUEUE_RECIVE = "ACKNOWLEDGE_SEVICE";
    /** 接收队列路由规则**/ 
    public static final String  MQ_RECIVE_ROUTING_KEY = "ACKNOWLEDGE_SEVICE";

    
    /** 每次获取数据的数量 **/ 
    public static final int  EVERY_TIME_NUMBER = 50;
    
    
    /************会员测量，关注等数据合并Job名称*****************/
    
    public static final String  MEMBER_MERGE= "MemberMerge"; 
    
    /** 每次获取数据的数量 **/ 
    public static final String  MANAGESCHEME_TASK= "ManageschemeTask"; 

}