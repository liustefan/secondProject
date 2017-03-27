/**
 * <b>项目名：</b>系统项目名称<br/>  
 * <b>包名：</b>com.bithealth.common.service.impl<br/>  
 * <b>@FileName: 文件名：</b>CacheAop.java<br/>  
 * <b>@Description: TODO <br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月12日-下午8:25:31<br/>  
 * <b>Copyright Copyright(C) 2016-2026 </b> 2016深圳中科汇康技术有限公司-版权所有<br/>   
 * <b>Company      深圳中科汇康技术有限公司
 * <b>@author:     名字  * 
 * <b>@version      V1.0  
 * <b>@Createdate:  2016年5月12日 下午8:25:31    
*/

package com.bithealth.common.service.impl;

/**  
 *   
 * <b>类名称：</b>CacheAop<br/>  
 * <b>类描述：</b>拦截缓存 <br/>  
 * <b>创建人：</b>kin<br/>  
 * <b>修改人：</b>kin<br/>  
 * <b>修改时间：</b>2016年5月12日 下午8:25:31<br/>  
 * <b>修改备注：</b><br/>  
 * @version 1.0.0<br/>  
 *   
 */

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.bithealth.common.annotation.Cached;
import com.bithealth.common.annotation.Flush;
import com.bithealth.common.cache.model.CacheLog;
import com.bithealth.common.cache.service.ICacheLogService;
import com.bithealth.sdk.common.Env; 
import com.bithealth.sdk.common.cache.memcached.MemcacheMgr;
import com.bithealth.sdk.common.utils.Md5Utils;
import com.bithealth.sdk.config.KDConfig;
     
@Component
@Aspect
public class CacheAop {

    private ICacheLogService cacheLogService;
    

    @Resource(name = "cacheLogService")
    public void setCacheLogService(ICacheLogService cacheLogService) {
        this.cacheLogService = cacheLogService;
    }
     
    String CACHENAME_SPLIT_CHAR = "##";
    KDConfig                   kdConfig = Env.getBean("rdConfig");

    public final static String KEY      = "PAGE";

    //   private com.bithealth.sdk.common.cache.Cache  pageCache;
    //  
    ////   @Resource
    //     CacheManager cacheManager;
    //          
    //   @Resource(name="memCachedManager")  
    //   public void setCacheManager(CacheManager cacheManager) {  
    //       
    //       this.cacheManager = cacheManager;  
    //       
    //       pageCache =   cacheManager.getCache(KEY);
    //       
    //   }  

    //定义切面   
//    @Pointcut("execution(* com.bithealth..service.*.memcache*||memflush*(..))")
//    public void cachedPointcut() {
//        //       pageCache =    cacheManager.getCache(KEY);
//
//    }
    
    @Pointcut("execution(* com.bithealth..service.*.*_cache(..))")
    private void logmemcache(){}

    @Pointcut("execution(* com.bithealth..service.*.*_cacheflush(..))")
    private void logmemflush(){}

    @Pointcut("logmemcache() || logmemflush()")
    private void cachedPointcut(){}
    
    

    @Around("cachedPointcut()")
    public Object doAround(ProceedingJoinPoint call) {
        Object result = null;
        Method[] methods = call.getTarget().getClass().getDeclaredMethods();

        String classname = call.getTarget().getClass().getName();
        Signature signature = call.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();


//      expire = 1000 * 60 * 20 

//memcache.pool.expiration = 1200000
        String expirationstr = kdConfig.getProperty("memcache.pool.expiration");
        //        String prefix = cache.prefix();
        //        long expiration = cache.expiration(); 

        long expiration = Long.valueOf(expirationstr);

        String prefix =   classname + CACHENAME_SPLIT_CHAR + method.getName();
 
        prefix  = Md5Utils.encript( prefix);
        
        for (Method m : methods) {//循环方法，找匹配的方法进行执行  
            if (m.getName().equals(method.getName())) {
                if (m.isAnnotationPresent(Cached.class)||m.getName().endsWith("_cache")) {
                    Cached cached = m.getAnnotation(Cached.class);
                    //                    String prefix = cache.prefix();
                    //
                    //                    long expiration = expirationstr; 

                    if (cached != null) {
                        prefix = cached.prefix();
                        expiration = cached.expiration();

                    }
                    String tempKey = this.getKey(method, call.getArgs());

                    String key = prefix + "_" + tempKey;
                    
                      key = Md5Utils.encript( key);
                    
                    //                           result =pageCache.get(key);  
                    result = MemcacheMgr.get(key);

                    if (null == result) {
                        try {
                            result = call.proceed();
                            //                                     expiration = cache.expiration();//1000*60*60*2==2小时过期  
                            Date d = new Date();
                            d = new Date(d.getTime() + expiration);
                            
                            //                                   , d
                            MemcacheMgr.set(key, result, d);

                            //将key存入数据库  
                            CacheLog log = new CacheLog();
                            log.setPrefix(prefix);
                            log.setCacheKey(key);
                            log.setAddTime(new Date());
                            this.cacheLogService.add(log);
                        } catch (Throwable e) {
                            e.printStackTrace();
                        }

                    }
                } else 
                    
                    if (method.isAnnotationPresent(Flush.class)||  m.getName().endsWith("_cacheflush")) {
                    Flush flush = method.getAnnotation(Flush.class);
                    if (flush != null) {
                        prefix = flush.prefix();
                    }

                    List<CacheLog> logs = cacheLogService.findListByPrefix(prefix);
                    if (logs != null && !logs.isEmpty()) {
                        //删除数据库  
                        int rows = cacheLogService.deleteByPrefix(prefix);
                        if (rows > 0) {
                            for (CacheLog log : logs) {
                                if (log != null) {
                                    String key = log.getCacheKey();
                                    MemcacheMgr.delete(key);//删除缓存  
                                }
                            }
                        }
                    }
                } else {
                    try {
                        result = call.proceed();
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
                break;
            }

        }

        return result;
    }

    /** 
     * 组装key值 
     * @param method 
     * @param args 
     * @return 
     */
    private String getKey(Method method, Object[] args) {
        StringBuffer sb = new StringBuffer();
        String methodName = method.getName();
        sb.append(methodName);
        if (args != null && args.length > 0) {

            for (Object arg : args) {
                
                String jsonString = JSON.toJSONString(arg);  
                sb.append(CACHENAME_SPLIT_CHAR).append(jsonString);
            }
        }

        return sb.toString();

    }
}
