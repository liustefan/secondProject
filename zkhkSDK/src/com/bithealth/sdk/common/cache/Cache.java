package com.bithealth.sdk.common.cache;

import java.util.Date;

public interface Cache {

	public final static String CACHE_NORMAL = "normal";
		
	public void put(String key,Object value);
	
	public void put(String key,Object value,int expire);
	
	public Object get(String key);
	
	public Object remove(String key);
	
	public boolean isExist(String key);
	
	public boolean replace(String key,Object value);
	
	public boolean replace(String key,Object value,Date expire);
}
