package com.bithealth.fileCore.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 * 类名称: SystemUtils  
 * 功能描述: 读取系统配置文件  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月27日 下午5:06:45 
 * 
 * @author 胡翔
 * @version  
 */
public class SystemUtils { 
	private static Logger logger = Logger.getLogger(SystemUtils.class);
	private static Properties prop = null;	
	private static final String propertiesFile = "/platform-filecore/fileConfig.properties";
	static{
        try {   
        	prop = new Properties();
			InputStream in = SystemUtils.class.getResourceAsStream(propertiesFile);  
    		if (in == null) {
				in = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFile);	
			}
    		BufferedReader bf = new BufferedReader(new InputStreamReader(in));  
    		prop.load(bf);  
            if(in != null){
            	in.close();
            }
        } catch (Exception e) {   
        	logger.error("读取初始配置文件时出现异常：",e);   
        }
	}

	public static String getValue(String key){
		return prop.getProperty(key);
	}
}
