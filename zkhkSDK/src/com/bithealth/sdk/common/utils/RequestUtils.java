package com.bithealth.sdk.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * web请求的工具类
 * @author jasonchai
 *
 */
public class RequestUtils
{
	private final static Log log = LogFactory.getLog(RequestUtils.class);

	public static String cookieDomain = "";

	public static String cookiePath = "/";
	
	/**
	 * 获取cookie
	 * @param request
	 * @param name
	 */
	public static Cookie getCookie(HttpServletRequest request, String name) 
	{
		log.debug("call getCookie,sessionId=" + request.getSession().getId() +",name=" + name);
		
		Cookie[] cookies = request.getCookies();
		
		
		
		if(cookies == null){
			log.debug("cookies is null");
			return null;
		}else{
			log.debug("cookies size =" + cookies.length);
		}
		for (int i = 0; i < cookies.length; i++) 
		{
			log.debug("cookies name=" + cookies[i].getName());
			
			if (name.equals(cookies[i].getName())) 
			{
				return cookies[i];
			}
		}
		return null;
	}

	/**
	 * 设置cookie
	 * @param request
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name,
			String value, int maxAge) 
	{
		log.debug("call setCookie,sessionId=" + request.getSession().getId() +",name=" + name +",value=" + value +",maxAge=" + maxAge);
		
		Cookie cookie = new Cookie(name, value);
		//cookie.setMaxAge(maxAge);
		//if(cookieDomain!=null )
		//{
		//	cookie.setDomain(cookieDomain);
			
		//}
		cookie.setPath(cookiePath);
		response.addCookie(cookie);

		
	}
	
	/**
	 * 获取url前轻柔,如http://www.abc.com:8080/
	 * @param request
	 * @return
	 */
	public static String getUrlPrefix(HttpServletRequest request)
	{
		StringBuffer url = new StringBuffer(request.getScheme());
		url.append("://");
		url.append(request.getServerName());
		int port = request.getServerPort();
		if(port!=80)
		{
			url.append(":");
			url.append(port);
		}
		return url.toString();
	}
	
	/**
	 * 获取请求的完整url,包括参数
	 * @param request
	 * @return
	 */
	public static String getRequestURL(HttpServletRequest request)
	{
		StringBuffer url = new StringBuffer(request.getRequestURI());
		String param = request.getQueryString();
		if(param!=null){
			url.append('?');
			url.append(param);
		}
		String path = url.toString();
		return path.substring(request.getContextPath().length());
	}
}
