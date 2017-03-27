package com.bithealth.chatCore.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * 
 * 类名称: PushUtils  
 * 功能描述: TODO 推送消息工具类.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月21日 上午11:02:38 
 * 
 * @author 胡翔
 * @version
 */
public class PushUtils {
	
	/**
	 * 解码BASE64位字节数组
     * @param bytes
     * @return
     */
    public static byte[] decode(final byte[] bytes) {
        return Base64.decodeBase64(bytes);
    }

    /**
     * 二进制数据编码为BASE64字符串
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encode(final byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }
    
    /**
     * 生成数据的MD5值
     * @param bytes
     * @return
     */
    public static String MD5(final byte[] bytes) {
        return DigestUtils.md5Hex(bytes);
    }
    
    
}