package com.bithealth.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

public class MessageUtil {
    
	private static Logger logger = Logger.getLogger(MessageUtil.class);
	
	private static Properties prop = null;	
	
	static{
        try {   
        	prop = new Properties();
    		InputStream in = MessageUtil.class.getResourceAsStream("/messages.properties");  
    		BufferedReader bf = new BufferedReader(new InputStreamReader(in,"utf-8"));  
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
