/**
 * <b>项目名：</b>系统项目名称<br/>  
 * <b>包名：</b>com.bithealth.common.annotation<br/>  
 * <b>@FileName: 文件名：</b>Flush.java<br/>  
 * <b>@Description: TODO <br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月12日-下午8:29:38<br/>  
 * <b>Copyright Copyright(C) 2016-2026 </b> 2016深圳中科汇康技术有限公司-版权所有<br/>   
 * <b>Company      深圳中科汇康技术有限公司
 * <b>@author:     名字  * 
 * <b>@version      V1.0  
 * <b>@Createdate:  2016年5月12日 下午8:29:38    
*/

package com.bithealth.common.annotation;

/**  
 *   
 * <b>类名称：</b>Flush<br/>  
 * <b>类描述：</b>用于删除缓存 <br/>  
 * <b>创建人：</b>kin<br/>  
 * <b>修改人：</b>kin<br/>  
 * <b>修改时间：</b>2016年5月12日 下午8:29:38<br/>  
 * <b>修改备注：</b><br/>  
 * @version 1.0.0<br/>  
 *   
 */

import java.lang.annotation.Documented;  
import java.lang.annotation.ElementType;  
import java.lang.annotation.Inherited;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  
  
@Target(ElementType.METHOD)     
@Retention(RetentionPolicy.RUNTIME)      
@Documented      
@Inherited   
public @interface Flush {  
   String prefix();//key的前缀，如咨询：zx  
}  
