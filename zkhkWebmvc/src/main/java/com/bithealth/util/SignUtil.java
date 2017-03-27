/**
 * @PackageName:      com.bithealth.util
 * @FileName:     SignUtil.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年11月1日 下午3:22:58  
 * 
 */
package com.bithealth.util;

/**
 * 类名称: SignUtil  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月1日 下午3:22:58 
 * 
 * @author liuhm
 * @version  
 */
import java.util.TreeMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;


/**
 * @author xiemt
 *
 */
public class SignUtil {
	
	private static Logger logger = Logger.getLogger(SignUtil.class); 


	
	/**
	 * 计算请求签名值
	 * @param paramMap 请求参数map
	 * @param url 请求URL
	 * @return
	 */
	public static String caculateSign(TreeMap<String, String> paramMap,String url) {
		String sign = null;
		try{
			StringBuilder buffer = new StringBuilder(new String(Base64.encodeBase64(url.getBytes("utf-8"))));
			//循环请求参数
			for (Object key : paramMap.keySet()) { 
				if(!"token".equals(key)){
					buffer.append(key);
					String value = paramMap.get(key);
					buffer.append(new String(Base64.encodeBase64(value.getBytes("utf-8"))));
				}
	        } 
			sign = DigestUtils.md5Hex(buffer.substring(0));
		}catch(Exception e){
			logger.error("验证签名异常!"+e.getMessage());
		}
		return sign;
	}			 
}