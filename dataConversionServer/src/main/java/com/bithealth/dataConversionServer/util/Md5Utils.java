package com.bithealth.dataConversionServer.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Utils {

	
    /**
     * 生成数据的MD5值
     * @param bytes
     * @return
     */
    public static String getMD5(final byte[] bytes) {
        return DigestUtils.md5Hex(bytes);
    }
	
	public static void main(String[] args) {
		
		System.out.println(getMD5("123456".getBytes()));
	}
}