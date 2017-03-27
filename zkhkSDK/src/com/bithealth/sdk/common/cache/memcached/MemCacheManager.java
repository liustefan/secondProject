/**
 * 
 */
package com.bithealth.sdk.common.cache.memcached;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

import com.alisoft.xplatform.asf.cache.ICacheManager;
import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import com.alisoft.xplatform.asf.cache.memcached.CacheUtil;
import com.alisoft.xplatform.asf.cache.memcached.MemcachedCacheManager;
import com.bithealth.sdk.common.cache.CacheManager;
 

/**
 * 管理Memcache缓存的客户端
 * @author jasonchai
 * 
 * 
 */
public class MemCacheManager implements CacheManager,InitializingBean {
	
	protected final Log logger = LogFactory.getLog(MemCacheManager.class);
	private ICacheManager<IMemcachedCache> manager;
	private Map<String, MemCache > caches = new ConcurrentHashMap<String, MemCache>();
	private String configLocation;
	
	public void afterPropertiesSet() throws Exception {
		
		if(StringUtils.isEmpty(configLocation))
			throw new Exception("未指定Memcache配件文件");
		
		manager = CacheUtil.getCacheManager(IMemcachedCache.class,MemcachedCacheManager.class.getName());
		manager.setConfigFile(configLocation);
		manager.setResponseStatInterval(5*1000);
		manager.start();
	}

	
	public void setConfigLocation(String configLocation) {
		this.configLocation = configLocation;
	}


	/**
	 * 获取缓存客户端
	 * @param cacheName 客户端名称
	 * @return
	 */
	public MemCache getCache(String cacheName) {
		MemCache  cache =  caches.get(cacheName);
		
		if(cache == null){
			IMemcachedCache icache = manager.getCache(cacheName);
			cache = new MemCache(icache);
			caches.put(cacheName, cache);
		}

		 
		return cache;
	}

	/**
	 * 关闭整个缓存服务
	 */
	public void shutdown() {
		manager.stop();
	}

}
