/**
 * @PackageName:  com.bithealth.common.dataconversion.utils
 * @FileName:     Base64Utils.java  
 * @Description: TODO( Base64数据处理工具类)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年6月22日 下午1:46:51  
 * 
 */
package com.bithealth.common.dataconversion.utils;

import java.io.IOException;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * 类名称: Base64Utils  
 * 功能描述: Base64数据处理工具类  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月22日 下午3:28:27 
 * 
 * @author 胡翔
 * @version  
 */
public class Base64Utils {
	/**
	 * @Title:encryptData 
	 * TODO(数据加密).  
	 * @author 胡翔
	 * @param source 需要加密数据 
	 * @return 加密后的数据
	 * @throws Exception
	 */
	public static String encryptData(String source) {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(source.getBytes());
	}
	/**
	 * @Title:decodeData 
	 * TODO(数据解密).  
	 * @author 胡翔
	 * @param source 需要解密的数据
	 * @return 解密后的数据
	 * @throws IOException
	 */
	public static String decodeData(String source) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		return new String(decoder.decodeBuffer(source));
	}
}
