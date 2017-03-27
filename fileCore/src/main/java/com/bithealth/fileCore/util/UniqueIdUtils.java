package com.bithealth.fileCore.util;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * 类名称: UniqueIdUtils  
 * 功能描述: TODO 唯一ID生成工具，生成14位唯一ID
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月29日 下午3:01:52 
 * 
 * @author 胡翔
 * @version
 */
public class UniqueIdUtils {

	private static AtomicInteger counter = new AtomicInteger(0);
	/**
	 * 
	 * @Title:getUniqueId 
	 * @Description:TODO(获取唯一的ID值).  
	 * @author 胡翔
	 * @return long 唯一的ID值
	 */
    public static long getUniqueId() {
        if (counter.get() > 999999) {
            counter.set(1);
        }
        long time = System.currentTimeMillis();
        long returnValue = time * 10 + counter.incrementAndGet();
        return returnValue;
    }
    
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
    
    public static void main(String[] args) {
         
        System.out.println(UniqueIdUtils.getUniqueId());
    }
}
