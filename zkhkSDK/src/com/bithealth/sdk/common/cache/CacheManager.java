package com.bithealth.sdk.common.cache;
 

/**
 * 缓存管理器
 * @author jasonchai
 *
 */
public interface CacheManager {

	/**
	 * 获取缓存客户端
	 * @param cacheName 客户端名称
	 * @return
	 */
	public Cache getCache(String cacheName);
	
	/**
	 * 关闭整个缓存服务
	 */
	public void shutdown();
}
