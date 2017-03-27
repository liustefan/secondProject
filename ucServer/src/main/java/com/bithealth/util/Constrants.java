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
package com.bithealth.util;


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
	
	public static final String UC_URL = config.getProperty("UC.UNIFIEDAUTH");
	
	public static final String Push_URL = config.getProperty("PUSH.URL");
	
    public static final String CenterServer_URL = config.getProperty("MESSAGE.URL");
	
	public static final String Upgrade_URL = config.getProperty("Upgrade_URL");
	
	public static final String AppServer_Regist_URL = config.getProperty("appServer_default");
	
    public static final String UC_URL_HTTPS = config.getProperty("UC.UNIFIEDAUTH_HTTPS");
	
	public static final String Push_URL_HTTPS = config.getProperty("PUSH.URL_HTTPS");
	
    public static final String CenterServer_URL_HTTPS = config.getProperty("MESSAGE.URL_HTTPS");
	
	public static final String Upgrade_URL_HTTPS = config.getProperty("Upgrade_URL_HTTPS");
	
	public static final String AppServer_Regist_URL_HTTPS = config.getProperty("appServer_default_HTTPS");
	
}
