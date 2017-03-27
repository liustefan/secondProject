/**
 * <b>项目名：</b>系统项目名称<br/>  
 * <b>包名：</b>com.bithealth.common.service<br/>  
 * <b>@FileName: 文件名：</b>ICacheLogService.java<br/>  
 * <b>@Description: TODO <br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月12日-下午8:30:56<br/>  
 * <b>Copyright Copyright(C) 2016-2026 </b> 2016深圳中科汇康技术有限公司-版权所有<br/>   
 * <b>Company      深圳中科汇康技术有限公司
 * <b>@author:     名字  * 
 * <b>@version      V1.0  
 * <b>@Createdate:  2016年5月12日 下午8:30:56    
*/

package com.bithealth.common.cache.service;

import java.util.List;

import com.bithealth.common.cache.model.CacheLog;
import com.bithealth.sdk.core.generic.GenericService; 
 
 

/**  
 *   
 * <b>类名称：</b>ICacheLogService<br/>  
 * <b>类描述：</b><br/>  
 * <b>创建人：</b>kin<br/>  
 * <b>修改人：</b>kin<br/>  
 * <b>修改时间：</b>2016年5月12日 下午8:30:56<br/>  
 * <b>修改备注：</b><br/>  
 * @version 1.0.0<br/>  
 *   
 */
public interface ICacheLogService  extends GenericService<CacheLog, Long> {

    /**  
     * findListByPrefix(这里用一句话描述这个方法的作用)  
     * (这里描述这个方法适用条件 – 可选)  
     * @param prefix
     * @return   
     *List<CacheLog>  
     * @exception   
     * @since  1.0.0  
    */
    List<CacheLog> findListByPrefix(String prefix);

    /**  
     * deleteByPrefix(这里用一句话描述这个方法的作用)  
     * (这里描述这个方法适用条件 – 可选)  
     * @param prefix
     * @return   
     *int  
     * @exception   
     * @since  1.0.0  
    */
    int deleteByPrefix(String prefix);

    /**  
     * add(这里用一句话描述这个方法的作用)  
     * (这里描述这个方法适用条件 – 可选)  
     * @param log   
     *void  
     * @exception   
     * @since  1.0.0  
    */
    void add(CacheLog log);
 

}
