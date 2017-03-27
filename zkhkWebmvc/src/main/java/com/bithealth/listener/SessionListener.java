/**
 * @PackageName:      com.bithealth.listener
 * @FileName:     SessionListener.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月19日 上午9:41:54  
 * 
 */
package com.bithealth.listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 类名称: SessionListener  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月19日 上午9:41:54 
 * 
 * @author liuhm
 * @version  
 */
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener{

	private static HashMap<String, Object> hUser = new HashMap<String, Object>();//保存sessionID和user的映射
	
	 /**以下是实现HttpSessionListener中的方法**/
	 /**创建session时，什么都不做**/
	@Override
	public void sessionCreated(HttpSessionEvent session) {
		
	}

	 /**session失效时，删除列表中用户信息**/
	@Override
	public void sessionDestroyed(HttpSessionEvent session) {
		hUser.remove(session.getSession().getId());
	}

	/**以下是实现HttpSessionAttributeListener中的方法**/
    /**调用session.setAttribute("user",user)时，添加用户信息到列表中**/
	@Override
	public void attributeAdded(HttpSessionBindingEvent session) {
		//用户ID
		 if(session.getName().equals("user_id")){
             hUser.put(session.getSession().getId(), session.getValue());
         } 
	}

	 /**调用session.removeAttribute("user",user")时，删除列表中用户信息**/
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		//用户ID
		if(se.getName().equals("user_id")){
			if(hUser.containsValue(se.getValue())){
				Iterator<String> iter = hUser.keySet().iterator();
				while (iter.hasNext()) {
					String key = iter.next();
					Object val = hUser.get(key);
					if((val).equals(se.getValue())){
						iter.remove();
					}
				}
			}
		} 
	}

	 /**调用更改"user"属性值时同时更改列表中用户信息**/
	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		if(se.getName().equals("user_id")){
			if(hUser.containsValue(se.getValue())){
				Iterator<String> iter = hUser.keySet().iterator();
				while (iter.hasNext()) {
					String key = iter.next();
					Object val = hUser.get(key);
					if(val.equals(se.getValue()) ){
						hUser.put(key,se.getValue());
					}
				}
			}
		} 
	}
	
	 /*返回用户列表*/
    public static HashMap<String, Object> getList(){
        return hUser;
    }

}
