/**
 * <b>项目名：</b>系统项目名称<br/>  
 * <b>包名：</b>com.bithealth.common.annotation<br/>  
 * <b>@FileName: 文件名：</b>Cache.java<br/>  
 * <b>@Description: TODO <br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月12日-下午8:28:21<br/>  
 * <b>Copyright Copyright(C) 2016-2026 </b> 2016深圳中科汇康技术有限公司-版权所有<br/>   
 * <b>Company      深圳中科汇康技术有限公司
 * <b>@author:     名字  * 
 * <b>@version      V1.0  
 * <b>@Createdate:  2016年5月12日 下午8:28:21    
*/

package com.bithealth.common.annotation;

import java.lang.annotation.Documented;  
import java.lang.annotation.ElementType;  
import java.lang.annotation.Inherited;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  
  
/** 
 * 用于在查询的时候 ，放置缓存信息 
 * @author jasonchai 
 * @email sf.chai@gmail.com 
 * 
 * 2016-5-12 上午10:42:06 
 */  
@Target(ElementType.METHOD)     
@Retention(RetentionPolicy.RUNTIME)      
@Documented      
@Inherited   
public @interface Cache {  
      
    String prefix();//key的前缀，如咨询：zx  
  
    long expiration() default 1000*60*60*2;//缓存有效期 1000*60*60*2==2小时过期  
      
      
}  