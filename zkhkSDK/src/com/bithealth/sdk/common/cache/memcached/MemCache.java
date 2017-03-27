package com.bithealth.sdk.common.cache.memcached;

import java.util.Date;

import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import com.bithealth.sdk.common.cache.Cache;
 

public class MemCache implements Cache{

	private IMemcachedCache cache;
	
	private MemCache(){
		
	}
	
	public MemCache(IMemcachedCache cache){
		this.cache = cache;

	}
	
	public Object get(String key) {
		// TODO Auto-generated method stub
		return cache.get(key);
	}

	public void put(String key, Object value) {
		
		cache.put(key, value);

	}

	public void put(String key, Object value,int expire) {
		
		cache.put(key, value,expire);
	
	}
	
	public Object remove(String key){
		
		return cache.remove(key);
	}
	
	public boolean isExist(String key){
		
		return cache.containsKey(key);
	}
	
	public boolean replace(String key,Object value){
		
		return cache.replace(key, value);
	}
	
	public boolean replace(String key,Object value,Date expire){
		
		return cache.replace(key, value,expire);
	}
}
