package com.bithealth.sdk.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {

    private Md5Utils(){}
    
    public static String encript(String plainText) {
        
        /**    
         *  对文本执行 md5 摘要加密, 此算法与 mysql,JavaScript生成的md5摘要进行过一致性对比.    
         *  * @param plainText    
         *  * @return 返回值中的字母为小写 
         */  
        
        if (null == plainText) {       
            
            plainText = "";     
        }     
        
        String MD5Str = "";  
        
        try {       
            /**
             * JDK 6 支持以下6种消息摘要算法，不区分大小写 
             * md5,sha(sha-1),md2,sha-256,sha-384,sha-512  
             */
                   
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            
            md.update(plainText.getBytes());     
            
            byte b[] = md.digest();      
            
            int i;         
            
            StringBuilder builder = new StringBuilder(32); 
            
            for (int offset = 0; offset < b.length; offset++) {  
                
                i = b[offset];         
                
                if (i < 0) {         
                    i += 256;
                }
                
                if (i < 16) {     
                    builder.append("0"); 
                }
                
                builder.append(Integer.toHexString(i)); 
                
            }      
            
            MD5Str = builder.toString();      

        } catch (NoSuchAlgorithmException e) {       
                    
            e.printStackTrace();    
        }    
        
        return MD5Str;   
    }
    
    public static void main(String[] args) {
        
        System.out.println(encript("123456"));
    }
}