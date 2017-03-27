package com.bithealth.common.service.impl;

/**
 * 描述 ：
 *
 * @author admin
 * @date 2016年5月4日
 */ 
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
 


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.bithealth.sdk.common.cache.Cache;
import com.bithealth.sdk.common.cache.CacheManager;
import com.bithealth.common.service.PageCacheManager;
 

@Service("pageCacheManager")

public class PageCacheManagerImpl implements PageCacheManager,InitializingBean{

    public final static String KEY = "PAGE";
    
    @Resource
    private CacheManager osCachedManager;
    
    
    private Cache pageCache;

    @Override
    public void afterPropertiesSet() throws Exception {
        
        pageCache =  osCachedManager.getCache(KEY);
        
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> get(HttpServletRequest request) {
        
        String key = getKey(request);
        
        Object o = pageCache.get(key);
        
        if(o != null)
            return (Map<String,Object>)o;
        
        return null;
    }
    
    public void append2Page(HttpServletRequest request,Map<String, Object> data){
        
        for(Object name : data.keySet()){
            
            request.setAttribute(String.valueOf(name), data.get(name));
            
            
        }
    }

    @Override
    public void put(HttpServletRequest request) {
        
        String key = getKey(request);
        
        Map<String,Object> data = new HashMap<String,Object>();
        
        Enumeration  e =(Enumeration)request.getAttributeNames();
        
        while(e.hasMoreElements())     {   
            String name=(String)e.nextElement();   
        
            /**
             * 过滤系统属性
             */
            if(name.indexOf('.') != -1) 
                continue;
            
            Object value = request.getAttribute(name); 
            
            
            data.put(name, value);
            
        }   
        
        pageCache.put(key, data);
        
    }
    
    private String getKey(HttpServletRequest request){
        
        StringBuffer url = new StringBuffer(request.getRequestURI());
        url.append("?");
        
        Enumeration  e =(Enumeration)request.getParameterNames();   
        
        while(e.hasMoreElements())     {   
            String name=(String)e.nextElement();   
        
            String value = request.getParameter(name); 
            
            url.append(name).append(value);
            
        }   
        
        return url.toString();

    }

    /* (non-Javadoc)  
     * @see com.bithealth.common.service.PageCacheManager#remove(javax.servlet.http.HttpServletRequest)  
     */
    @Override
    public void remove(HttpServletRequest request) {
        // TODO Auto-generated method stub
  
        String key = getKey(request);
        
        Map<String,Object> data = new HashMap<String,Object>();
        
        Enumeration  e =(Enumeration)request.getAttributeNames();
        
        
        
        while(e.hasMoreElements())     {   
            String name=(String)e.nextElement();   
        
     
//            
            /**
             * 过滤系统属性
             */
            if(name.indexOf('.') != -1) 
                continue;
//            
//            
//            
//            Object value = request.getAttribute(name); 
//            
//            
//            data.put(name, value);
            if (data.containsKey(name)){
                data.remove( name );    
            }
            
        }   
        
        pageCache.put(key, data);
    }
}
