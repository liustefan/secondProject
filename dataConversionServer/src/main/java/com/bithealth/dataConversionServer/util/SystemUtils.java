package com.bithealth.dataConversionServer.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;



public class SystemUtils { 
	private static Logger logger = Logger.getLogger(SystemUtils.class);
	private static Properties prop = null;	
	static{
        try {   
        	prop=load(new String[]{"/config.properties","/rabbit.properties"});

        } catch (Exception e) {   
        	logger.error("读取初始配置文件时出现异常：",e);   
        }
	}

	public static String getValue(String key){
		return prop.getProperty(key);
	}
	
	
	public static int getInt(String key){
		return Integer.parseInt(prop.getProperty(key));
	}
	
	
	
	
	public static Properties load(String[] names) throws IOException{
		prop = new Properties();
		InputStream in = null;
		BufferedReader bf = null;
		for(String name:names){
			in = SystemUtils.class.getResourceAsStream(name);  
			bf= new BufferedReader(new InputStreamReader(in)); 
			prop.load(bf);

		}
        if(in != null){
        	in.close();
        }
        if(bf !=null){
        	bf.close();
        }
		return prop;
	}
	
	
	public static void main(String args[]){
		System.out.println(SystemUtils.getValue("adviceTitle"));
		//System.out.println(Integer.parseInt(SystemUtils.getValue(Constants.DEPLOY_STATUS)));
	}
}
