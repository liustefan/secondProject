/**
 * <b>项目名：</b>系统项目名称<br/>  
 * <b>包名：</b>com.bithealth.common.cache<br/>  
 * <b>@FileName: 文件名：</b>Memcache.java<br/>  
 * <b>@Description: TODO <br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月14日-下午3:04:03<br/>  
 * <b>Copyright Copyright(C) 2016-2026 </b> 2016深圳中科汇康技术有限公司-版权所有<br/>   
 * <b>Company      深圳中科汇康技术有限公司
 * <b>@author:     名字  * 
 * <b>@version      V1.0  
 * <b>@Createdate:  2016年5月14日 下午3:04:03    
*/

package com.bithealth.sdk.common.cache.memcached;

/**  
 *   
 * <b>类名称：</b>Memcache<br/>  
 * <b>类描述：</b><br/>  
 * <b>创建人：</b>kin<br/>  
 * <b>修改人：</b>kin<br/>  
 * <b>修改时间：</b>2016年5月14日 下午3:04:03<br/>  
 * <b>修改备注：</b><br/>  
 * @version 1.0.0<br/>  
 *   
 */
import java.util.Date;
import java.util.Properties;

import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.config.KDConfig;
import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
public class MemcacheMgr {

    static MemCachedClient memCachedClient=null;
    static{

        
        KDConfig kdConfig = Env.getBean("rdConfig");
        Properties serversProperties = kdConfig.getPropertiesByKey("memcache.pool.server")   ;
      

        String[] servers =StringUtil . propertiestoStringArray ( serversProperties); 
        
        SockIOPool pool = SockIOPool.getInstance();  
        
        pool.setServers(servers);  
        pool.setFailover(true);  
     // 设置初始连接数、最小和最大连接数以及最大处理时间 
    /*    pool.setInitConn(5);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaxIdle(1000 * 60 * 60 * 6); */
       
        
        
//        pool.setInitConn(10);  
        
        pool.setInitConn(Integer.valueOf(kdConfig.getProperty("memcache.pool.initConn")));
//        pool.setMinConn(5);  

        pool.setMinConn(Integer.valueOf(kdConfig.getProperty("memcache.pool.minConn")));
//        pool.setMaxConn(250);  

        pool.setMaxConn(Integer.valueOf(kdConfig.getProperty("memcache.pool.maxConn")));
//        pool.setMaintSleep(30);  // 设置主线程的睡眠时间  
        pool.setMaintSleep(Integer.valueOf(kdConfig.getProperty("memcache.pool.mainSleep")));
//     // 设置TCP的参数，连接超时等 
//        pool.setNagle(false);  

        pool.setNagle(Boolean.valueOf(kdConfig.getProperty("memcache.pool.nagle")));
//        pool.setSocketTO(3000);  

        pool.setSocketTO(Integer.valueOf(kdConfig.getProperty("memcache.pool.socketTo")));
        pool.setAliveCheck(true); 
        
        pool.initialize();  
       
        memCachedClient = new MemCachedClient();    
        memCachedClient.setPrimitiveAsString(true);//锟斤拷锟叫伙拷
    }
    public static Object  get(String key)
    {
        return memCachedClient.get(key);
    }
//  public static Map<String,Object> gets(String[] keys)
//  {       
//      return memCachedClient.getMulti(keys);
//  }
    public static boolean set(String key,Object o)
    {
        return memCachedClient.set(key, o);     
    }
    public static boolean set(String key,Object o,Date ExpireTime)
    {       
        return memCachedClient.set(key, o, ExpireTime);
    }
    public static boolean exists(String key)
    {
        return memCachedClient.keyExists(key);
    }
    public static boolean delete(String key)
    {
        return memCachedClient.delete(key);
    }
}