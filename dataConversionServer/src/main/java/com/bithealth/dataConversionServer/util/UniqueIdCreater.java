package com.bithealth.dataConversionServer.util;

import java.util.UUID;

/**
 * @ClassName:     UniqueIdCreater.java 
 * @Description:   唯一标识生成器
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月10日 上午11:40:58
*****/
public class UniqueIdCreater {
	
	
	 /** 
	 * @Title: getUUID 
	 * @Description: 获取128位的全球唯一标识 
	 * @return    
	 * @return String
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	
	 /** 
	 * @Title: getUniqueNumberId 
	 * @Description: 返回20位的一个唯一数字
	 * @return    
	 * @retrun String
	 */
	public static synchronized String getUniqueNumberId(){
		StringBuffer sb = new StringBuffer();
		sb.append(System.currentTimeMillis());	
		sb.append((long)(Math.random()*10000000));
		return sb.toString();
	}
	
}
