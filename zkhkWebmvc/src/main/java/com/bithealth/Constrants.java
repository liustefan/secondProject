/**
 * @PackageName:      com.bithealth
 * @FileName:     Constrants.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月19日 下午4:49:46  
 * 
 */
package com.bithealth;

import com.bithealth.util.PropertiesUtil;

/**
 * 类名称: Constrants  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月19日 下午4:49:46 
 * 
 * @author liuhm
 * @version  
 */
public class Constrants {
	
	
	public static final String USER_ID = "user_id";
	
    public static final String SESSION_FORCE_LOGOUT_KEY = "session.force.logout";
    
    public static final String[] HEADER = PropertiesUtil.getProperty("header").split(",");
    
    public static final String[] FIELDS = PropertiesUtil.getProperty("fields").split(",");
    
    public static final String VERSION_TAG = PropertiesUtil.getProperty("version_tag");
	

}
