package com.bithealth.centCore.msgCenterCore.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bithealth.agentCore.agent.impl.RedirectImpl;


/**
 * @author 
 *
 */
public class PushUtils {
   //编码
   public static final String  PUSH_CHARSET="UTF-8";
   
	@Autowired
	private static RedirectImpl redirectImpl;

	/**
	 * 
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