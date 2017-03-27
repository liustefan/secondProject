 
/**
 * @PackageName:      com.bithealth.measureCore.constant
 * @FileName:     Constants.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年8月8日 上午9:56:25  
 * 
 */

package com.bithealth.measureCore.constant;


/**
 * 类名称: Constants  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月8日 上午9:56:25 
 * 
 * @author 陈哲
 * @version  
 */
public class Constant {
	//高血压
	public static final String BLOODPRES_EXC_LOW = "低血压";
	
	public static final String BLOODPRES_NORMAL = "正常";
	
	public static final String BLOODPRES_NORMAL_HIGH = "正常高值";
	
	public static final String BLOODPRES_EXC_ISOLATED = "单纯收缩期高血压";
	
	public static final String BLOODPRES_EXC_LIGHT = "轻度高血压";
	
	public static final String BLOODPRES_EXC_MIDDLE = "中度高血压";
	
	public static final String BLOODPRES_EXC_HIGH = "重度高血压";
	
	//糖尿病
	public static final String BLOODSUG_NORMAL = "正常";
	
	public static final String BLOODSUG_EXC_LOW = "血糖偏低";
	
	public static final String BLOODSUG_EXC_HIGH = "血糖偏高";

	//每测量一次血压(blood pressure)得1 分
    public static final int ONCE_MEASURE_BP_SCORE = 1;
    
    //每测量一次血糖(Blood glucose)得3 分
    public static final int ONCE_MEASURE_BG_SCORE = 3;
    
    //每测量一次三合一(three in one)得2 分
    public static final int ONCE_MEASURE_TIN_SCORE = 2;
    
    //每测量一次miniHolter得5 分
    public static final int ONCE_MEASURE_MNH_SCORE = 5;
    
    /*以下是mini心电的数据类型定义*/
    //无符号型单字节
    public static final int DATATYPE_UNSIGNED_SINGLEBYTE = 1;
    
    //有符号型单字节
    public static final int DATATYPE_SIGNED_SINGLEBYTE = 2;
    
    //无符号型双字节
    public static final int DATATYPE_SIGNED_DOUBLEBYTE = 3;
    
    //有符号型双字节
    public static final int DATATYPE_UNSIGNED_DOUBLEBYTE = 4;
    
    //无符号型4字节
    public static final int DATATYPE_UNSIGNED_FOURBYTE = 5;
    
    //有符号型4字节
    public static final int DATATYPE_SIGNED_FOUREBYTE = 6;
    
    /*以下是mini心电设备类型定义*/
    //老mini心电设备
    public static final String DEVICETYPE_OLD = "SIAT_ELECECG";
    
    //老mini心电设备，为区分app或web端上传，标识web端上传
    public static final String DEVICETYPE_OLD_WEB = "SIAT_ELECECG_WEB";
    
     //新mini心电设备
    public static final String DEVICETYPE_NEW = "ZKHK_ELECECG";
    
    /*以下是三合一设备类型定义*/
    //三合一设备类型
    public static final String DEVICETYPE_ELE_PULSE = "SIAT3IN1_E";

}

