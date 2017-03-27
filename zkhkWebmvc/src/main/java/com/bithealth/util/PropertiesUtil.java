/**
 * @PackageName:      com.bithealth
 * @FileName:     PropertiesUtil.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月9日 下午4:29:28  
 * 
 */
package com.bithealth.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 类名称: PropertiesUtil  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月9日 下午4:29:28 
 * 
 * @author liuhm
 * @version  
 */
public class PropertiesUtil {
	 static Properties prop = new Properties();
	 static {
		 try {
			InputStreamReader in = new InputStreamReader(PropertiesUtil.class.getResourceAsStream("/memberImport.properties"), "UTF-8"); 
			prop.load(in);
			in = new InputStreamReader(PropertiesUtil.class.getResourceAsStream("/title.properties"), "UTF-8");
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 
	 public static String getProperty(String name) {
		return prop.getProperty(name);
	 }
	 
}
