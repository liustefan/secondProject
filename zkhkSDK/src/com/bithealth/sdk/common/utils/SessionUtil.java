package com.bithealth.sdk.common.utils;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bithealth.web.Env;
import com.bithealth.web.session.MemSession;
 


public class SessionUtil
{
	private final static Log log = LogFactory.getLog(SessionUtil.class);
	
	/**
	 * 获取验证码
	 * @param request
	 * @return
	 */
	public static String getValidCode(HttpServletRequest request)
	{
		
		Cookie cookie = RequestUtils.getCookie(request, MemSession.SESSION_KEY);
		
		if(cookie != null)
		{
			String sid = cookie.getValue();//sessionId
			
			MemSession session = MemSession.getSession(sid);
			
			String validCode = (String)session.getAttribute("__VALID_CODE__");
			
			return validCode;
			
		}
		return null;
	}
	
	/**
	 * 存放验证码
	 * @param validCode
	 * @param request
	 * @param response
	 */
	public static void setValidCode(String validCode,HttpServletRequest request,HttpServletResponse response)
	{
		//SessionUtil.invalidate(request,response);
		//RequestUtils.setCookie(request, response, Constants.SESSION_KEY,request.getSession().getId() , 30*60);	
		setAttribute(request, "__VALID_CODE__", validCode);
	}
	

	
	
	/**
	 * @param request
	 * @param response
	 */
	public static void setNextRequest(Map<String, Object> nextRequestScopeHandler,HttpServletRequest request,HttpServletResponse response)
	{
		setAttribute(request, Env.NEXT_REQUEST_SCOPE, nextRequestScopeHandler);
	}
	
	public static void removeNextRequest(HttpServletRequest request)
	{
		removeAttribute(request, Env.NEXT_REQUEST_SCOPE);
	}
	
	/**������ݿ��ж�ȡ��ͬʱ��ŵ�memcached��
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getNextRequest(HttpServletRequest request){
		Cookie cookie = RequestUtils.getCookie(request, MemSession.SESSION_KEY);
		
		if(cookie != null)
		{
			String sid = cookie.getValue();//sessionId
			
			MemSession session = MemSession.getSession(sid);
			
			return (Map<String, Object>)session.getAttribute(Env.NEXT_REQUEST_SCOPE);
			
		}
		return null;
	}
	
	/**
	 * 验证用户是否已登录��֤�Ƿ��¼
	 * @param request
	 * @return
	 */
	public static boolean valideLogin(HttpServletRequest request)
	{

		Cookie cookie = RequestUtils.getCookie(request, MemSession.SESSION_KEY);
		if(cookie == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * �������memcached��sid��
	 * @param sid
	 * @param key
	 * @param value
	 */
	public static void setAttribute(String sid,String key,Object value)
	{
		log.debug("call setAttribute,sid=" + sid +",key=" + key +",value=" + value);
		MemSession session = MemSession.getSession(sid);
		session.setAttribute(key, value);
	}
	/**
	 * ͨ��cookie����Ϣ����memcached
	 * @param request
	 * @param key
	 * @param value
	 */
	public static void setAttribute(HttpServletRequest request,String key,Object value)
	{
		log.debug("call setAttribute,key=" + key +",value=" + value);
		Cookie cookie = RequestUtils.getCookie(request, MemSession.SESSION_KEY);
		if(cookie != null)
		{
			
			String sid = cookie.getValue();
			MemSession session = MemSession.getSession(sid);
			session.setAttribute(key, value);
			
			log.debug("sid=" + sid +",session=" + session);
		}
	}
	/**ֵ
	 * @param sid
	 * @param key
	 * @return
	 */
	public static Object getAttribute(String sid,String key){
		
		log.debug("call getAttribute,sid="+ sid +",key=" + key);
		
		MemSession session = MemSession.getSession(sid);
		return session.getAttribute(key);		
	}
	/**ֵ
	 * @param request
	 * @param key
	 * @return
	 */
	public static Object getAttribute(HttpServletRequest request,String key)
	{
		log.debug("call getAttribute,key=" + key);
		
		Cookie cookie = RequestUtils.getCookie(request, MemSession.SESSION_KEY);
		
		if(cookie != null)
		{
			String sid = cookie.getValue();
			
			MemSession session = MemSession.getSession(sid);
			
			log.debug("sid=" + sid +",session=" + session.getAttribute(key));
			return session.getAttribute(key);		
		}
		return null;
	}
	/**
	 * ͨ��cookie��memcached��ɾ��key
	 * @param request
	 * @param key
	 */
	public static void removeAttribute(HttpServletRequest request,String key)
	{
		Cookie cookie = RequestUtils.getCookie(request, MemSession.SESSION_KEY);
		
		if(cookie != null)
		{
			String sid = cookie.getValue();
			MemSession session = MemSession.getSession(sid);
			session.removeAttribute(key);
		}
		
	}
	/**
	 * 用户退出ͨ��cookieʹ��memcached�е�sessionʧЧ
	 * @param request
	 */
	public static void invalidate(HttpServletRequest request,HttpServletResponse response)
	{
		Cookie cookie = RequestUtils.getCookie(request, MemSession.SESSION_KEY);
		
		if(cookie != null)
		{
			String sid = cookie.getValue();
			MemSession session = MemSession.getSession(sid);
			session.invalidate();
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
	
	public static String createSessionId(HttpServletRequest request,String userId){
		
		return request.getSession().getId() + "_" + userId;
	}
	
}



