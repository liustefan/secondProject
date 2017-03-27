package com.bithealth.web.session;

import java.util.Map;

/**
 * 自定义session
 * @author jasonchai
 *
 */
public class MemSession
{

	//public static String SESSION_KEY  = "JSESSIONID";
	
	public static String SESSION_KEY  = "SSHOW_SESSION_ID";
	
	private String sid = "";

	private Map<String,Object> map = null;
		
	private MemSession(String sid,boolean create) 
	{
		this.sid = sid;
		this.map = SessionService.getInstance().getSession(sid,create);
	}
	
	/**
	 * 获取session
	 * @param sid
	 * @return
	 */
	public static MemSession getSession(String sid)
	{
		MemSession session = null;
		
		session = new MemSession(sid,true);
		
		return session;
	}
	
	/**
	 * 获取session,如果不存在,则创建
	 * @param sid
	 * @param create
	 * @return
	 */
	public static MemSession getSession(String sid,boolean create)
	{
		MemSession session = null;
		
		session = new MemSession(sid,create);
		
		return session;
	}

	
	/**
	 * 判断是否有此id的session
	 * @param sid
	 * @return
	 */
	public static boolean sessionExists(String sid)
	{
		return SessionService.getInstance().sessionExists(sid);
	}
	
	/**
	 * 从session中取值
	 * @param arg0
	 * @return
	 */
	public Object getAttribute(String arg0) 
	{
		return this.map.get(arg0);
	}

	/**
	 * 使session失效
	 */
	public void invalidate() 
	{
		this.map.clear();
		SessionService.getInstance().removeSession(this.sid);
	}

	
	public void removeAttribute(String arg0) 
	{
		if(arg0 == null || arg0.trim().length() <= 0)
		{
			return;
		}
		this.map.remove(arg0);
		SessionService.getInstance().saveSession(this.sid, this.map);
	}
	
	public void setAttribute(String arg0, Object arg1) 
	{
		if(arg0 == null || arg0.trim().length() <= 0 || arg1 == null)
		{
			return ;
		}
		this.map.put(arg0, arg1);
		SessionService.getInstance().saveSession(this.sid, this.map);
	}
	
	/**
	 * 更新过期时间
	 * @param sid
	 */
	public void updateExpiryDate(String sid)
	{
		SessionService.getInstance().updateExpiryDate(sid);
	}
	
}
