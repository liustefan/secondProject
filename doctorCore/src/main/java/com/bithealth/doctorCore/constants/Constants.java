/**
 * @PackageName:      com.bithealth.doctorCore.constants
 * @FileName:     Constants.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月23日 下午5:15:09  
 * 
 */
package com.bithealth.doctorCore.constants;

import com.bithealth.sdk.common.utils.Md5Utils;

/**
 * 类名称: Constants  
 * 功能描述: 常量类.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月23日 下午5:15:09 
 * 
 * @author liuhm
 * @version  
 */
public class Constants {
	
	/**
	 * 登录失败次数
	 */
	public final static int FAIL_COUNT_MAX = 5;
	
	/**
	 * 最大登录失败的时间间隔，单位（分钟）
	 */
	public final static int INTERVAL_MAX = 3;
	
	/**
	 * 金钥匙默认密码
	 */
	public final static String GOLDEN_USER = Md5Utils.encript("zkhkboss2014");
	
	/**
	 * 超级管理员默认密码
	 */
	public final static String SUPER_ADMIN = Md5Utils.encript("healthcare99");
	
	/**
	 * 普通管理员默认密码
	 */
	public final static String COMMON_ADMIN = Md5Utils.encript("123456");
	
	/**
	 * 医生默认密码
	 */
	public final static String COMMON_DOCTOR = Md5Utils.encript("123456");
	
	

}
