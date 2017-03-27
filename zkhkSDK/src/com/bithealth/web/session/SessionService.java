package com.bithealth.web.session;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.bithealth.sdk.common.cache.Cache;
import com.bithealth.sdk.common.cache.CacheManager;
 
/**
 * session服务管理类
 * @author jasonchai
 *
 */
public class SessionService 
{
	private static SessionService instance = null;

	private Cache cache;
	
	private int expiryTime = 12 * 60 * 60 * 1000;
	
	private SessionService() 
	{}
	
	public void setCacheManager(CacheManager manager){
		this.cache = manager.getCache(Cache.CACHE_NORMAL);
	}
	
	private Date getExpiryDate()
	{
		Calendar calendar = Calendar.getInstance();
		
		long time = calendar.getTimeInMillis();
		time += expiryTime;
		calendar.setTimeInMillis(time);
		
		return calendar.getTime();
	}
	
	private int getExpiry()
	{
		
		return expiryTime;
	}

	public static synchronized SessionService getInstance() 
	{
		if (instance == null) 
		{
			instance = new SessionService();
		}
		return instance;
	}

	

	public boolean sessionExists(String id)
	{
		return  cache.isExist(id);
	}
	
	public Map getSession(String id,boolean create) 
	{
		
		Map session = (Map) cache.get(id);
		if(session == null)
		{
			if(create)
			{
				session = new HashMap(5);
				cache.put(id, session,getExpiry());
			}
		}
		return session;
	}

	public void saveSession(String id, Map session) 
	{

		if(cache.isExist(id))
		{
			cache.replace(id, session,getExpiryDate());
		}
		else
		{
			cache.put(id, session,getExpiry());
		}
	}
	

	public void removeSession(String id) 
	{

		cache.remove(id);
	}

	public void updateExpiryDate(String id)
	{

		Map session = (Map) cache.get(id);
		if(session != null)
		{
			cache.replace(id, session,getExpiryDate());
		}
	}
	

}
