package com.push.thread;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.push.Utils.SystemUtils;
import com.push.constants.Constants;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;


/**
 * @ClassName:     EcacheManager.java 
 * @Description:   ecache缓存管理器
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月9日 上午9:39:08
*****/
public class EcacheManager{
	private static Logger logger = Logger.getLogger(EcacheManager.class);
	

	private static EcacheManager ecacheManager =   new EcacheManager();
	
	private static CacheManager cacheManager  ;
	

    private   EcacheManager(){
    	cacheManager =    CacheManager.newInstance( this.getClass().getResource("/").getPath()+(SystemUtils.getValue(Constants.EHCACHE_PATH)));
    }

    
	 /** 
	 * @Title: getCache 
	 * @Description: 获取指定缓存对象 
	 * @return    
	 * @retrun Cache
	 */
	public static Cache getCache(String cacheName){
		return  cacheManager.getCache(cacheName);
	}
	

	
	
	
	
	
}
