package com.bithealth.common.dataconversion.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 
 * 类名称: MessageDigestUtils  
 * 功能描述: TODO 消息摘要算法工具类.  
 * JDK 6 支持以下6种消息摘要算法，不区分大小写 md5,sha(sha-1),md2,sha-256,sha-384,sha-512
 * 日期: 2016年6月22日 下午3:41:01 
 * 
 * @author 胡翔
 * @version
 */
public class MessageDigestUtils {

	private MessageDigestUtils() {
	}
	/**
	 * @Title:encryptDataByMD5 
	 * @Description:(按照MD5算法进行加密). 
	 * @author 胡翔
	 * @param source
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String encryptDataByMD5(String source) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(source.getBytes());
		byte b[] = md.digest();
		StringBuilder builder = new StringBuilder(32);
		for (int offset = 0,i=0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				builder.append("0");
			}
			builder.append(Integer.toHexString(i));
		}
		return builder.toString();
	}
	/**
	 * 
	 * @Title:encryptDataBySHA 
	 * @Description:(按照SHA算法进行加密). 
	 * @author 胡翔
	 * @param source 要加密的数据
	 * @return 加密后的数据
	 * @throws NoSuchAlgorithmException 
	 */
	public static String encryptDataBySHA(String source) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(source.getBytes());
		byte b[] = md.digest();
		StringBuilder builder = new StringBuilder(32);
		for (int offset = 0,i=0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				builder.append("0");
			}
			builder.append(Integer.toHexString(i));
		}
		return builder.toString();
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {

		System.out.println(encryptDataBySHA(""));
		System.out.println(encryptDataByMD5(""));
	}
}