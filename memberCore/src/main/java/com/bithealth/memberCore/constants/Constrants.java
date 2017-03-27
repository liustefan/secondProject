/**
 * @PackageName:      com.bithealth.memberCore.constants
 * @FileName:     Constants.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月30日 上午11:42:38  
 * 
 */
package com.bithealth.memberCore.constants;


import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.config.KDConfig;

/**
 * 类名称: Constants  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月30日 上午11:42:38 
 * 
 * @author liuhm
 * @version  
 */
public class Constrants {
	private static KDConfig config = null;
	static{
		config = Env.getBean("rdConfig");
	}
	
	public static final String DNS = config.getProperty("UC.DNS");
	
	public static final String SERVERID = config.getProperty("SERVERID");
	
	public static final String DEFAULT_ORG = config.getProperty("default_org");
	
	/**
	 * 向UC每次请求的最大会员数
	 */
	public static final int MAX_AUTH = 50;
	
	/**
	 * 距离上次的间隔时间，单位分钟
	 */
	public static final int INTERVAL_TIME = 5;
	
	public static final int APP_USER = 2;
	
	public static final int WEB_USER = 1;
	
}
