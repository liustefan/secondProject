/**
 * @PackageName:  com.bithealth.common.dataconversion.utils
 * @FileName:     DesUtils.java  
 * @Description: TODO(DES算法数据处理工具类)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年6月22日 下午1:46:51  
 * 
 */
package com.bithealth.common.dataconversion.utils;

import java.security.Key;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * 类名称: DesUtils  
 * 功能描述: TODO DES算法处理工具类
 * 日期: 2016年6月22日 下午3:47:10 
 * 
 * @author 胡翔
 * @version  
 */
public class DesUtils {

	/** 指定加密算法为DESede */
	private static String ALGORITHM = "DES";
	/**
	 * 指定私密玥
	 */
	private static String KEY = "zkhk";
	
	/**
	 * @Title:getKey 
	 * TODO(生成算法密钥).  
	 * @author 胡翔
	 * @return 算法密钥
	 * @throws Exception 
	 */ 
	private static Key getKey() throws Exception {
		byte[] arrBTmp = KEY.getBytes();
		// 创建一个空的8位字节数组（默认值为0）
		byte[] arrB = new byte[8];
		// 将原始字节数组转换为8位
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}
		// 生成密钥
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
		return key;
	}

	
	/**
	 * 
	 * @Title:encryptData 
	 * @Description:(数据加密). 
	 * @author 胡翔
	 * @param source 要加密的数据
	 * @return 加密后的数据
	 * @throws Exception 
	 */
	public static String encryptData(String source) throws Exception {
		/** 得到Cipher对象来实现对源数据的DES加密 */
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, getKey());
		byte[] b = source.getBytes();
		/** 执行加密操作 */
		byte[] b1 = cipher.doFinal(b);
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(b1);
	}

	
	
	/**
	 * @Title:decodeData 
	 * @Description:(数据解密). 
	 * @author 胡翔
	 * @param source 要解密的数据
	 * @return 解密后的数据
	 * @throws Exception 
	 */ 
	public static String decodeData(String source) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, getKey());
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] b1 = decoder.decodeBuffer(source);
		byte[] b = cipher.doFinal(b1);
		return new String(b);
	}
}
