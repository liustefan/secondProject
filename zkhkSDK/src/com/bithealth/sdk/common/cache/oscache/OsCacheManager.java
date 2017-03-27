package com.bithealth.sdk.common.cache.oscache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bithealth.sdk.common.cache.CacheManager;
 

/**
 * 简要的oscache管理实现,后期等完善
 * @author jasonchai
 *
 */
public class OsCacheManager implements CacheManager{

	protected final Log logger = LogFactory.getLog(OsCacheManager.class);

	private Map<String, OsCache > caches = new ConcurrentHashMap<String, OsCache>();


	/**
	 * 获取缓存客户端
	 * @param cacheName 客户端名称
	 * @return
	 */
	public OsCache getCache(String cacheName) {
		OsCache  cache =  caches.get(cacheName);
		
		if(cache == null){
			cache = new OsCache();
			caches.put(cacheName, cache);
		}

		 
		return cache;
	}

	/**
	 * 关闭整个缓存服务
	 */
	public void shutdown() {
		caches.clear();
	}

}
