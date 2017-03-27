package com.bithealth.common.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 页面缓存管理接口
 * @author vincent ke 
 *
 */
public interface PageCacheManager {

	/**
	 * 获取指定key的缓存数据
	 * @param key
	 * @return
	 */
	public Map<String,Object> get(HttpServletRequest request);
	
	/**
	 * 将缓存数据传给页面
	 * @param request
	 * @param data
	 */
	public void append2Page(HttpServletRequest request,Map<String, Object> data);
	/**
	 * 将数据写入缓存
	 * @param key
	 * @param data
	 */
	public void put(HttpServletRequest request);
	
	/**
     * 将数据删除缓存
     * @param key
     * @param data
     */
    public void remove(HttpServletRequest request);
    
}
