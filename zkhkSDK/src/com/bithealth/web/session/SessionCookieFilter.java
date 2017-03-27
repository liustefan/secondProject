package com.bithealth.web.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 

import com.bithealth.sdk.common.utils.EnvUtils;
import com.bithealth.sdk.common.utils.RequestUtils;
import com.bithealth.web.Env;


/**
 * session与cookie过滤器
 * @author jasonchai
 *
 */
public class SessionCookieFilter extends HttpServlet implements Filter 
{

	private final static Log log = LogFactory.getLog(SessionCookieFilter.class);
	
	private static final long serialVersionUID = -6516046520244652987L;
	
	private int expiryDate = 1000 * 60 * 60 * 24;//seconeds
	
	
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException 
	{		
		log.debug("call doFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		
		Cookie cookie = RequestUtils.getCookie(request, MemSession.SESSION_KEY);		
		
		log.debug("cookie:" + cookie);
		
		if (cookie != null) 
		{
			String sid = cookie.getValue();
			//����cookie����Ч��
			RequestUtils.setCookie(request, response, MemSession.SESSION_KEY, sid, expiryDate);
			MemSession session = MemSession.getSession(sid);
			
			if(session != null)
				session.updateExpiryDate(sid);
		}else{
			
			
			RequestUtils.setCookie(request, response, MemSession.SESSION_KEY, request.getSession().getId(), expiryDate);
			
			if(RequestUtils.getCookie(request, MemSession.SESSION_KEY) == null){
				StringBuffer url = request.getRequestURL();
				url.append("?");
				
				for(Object o : request.getParameterMap().keySet()){
					
					String name = (String)o;
					String value = request.getParameter(name);
					
					url.append(name).append("=").append(value).append("&");
				}
				response.sendRedirect(url.toString());
				return;
			}
		}
		
		Cookie cookie2 = RequestUtils.getCookie(request, MemSession.SESSION_KEY);		
		
		
		
		log.debug("cookie:" + cookie2);
		
		Env env = EnvUtils.getEnv();

	    env.setRequest((HttpServletRequest) request);
	    env.setResponse((HttpServletResponse) response);
	    
	    
		filterChain.doFilter(request,response);
	}
	public void init(FilterConfig filterConfig) throws ServletException 
	{		
		RequestUtils.cookieDomain = filterConfig.getInitParameter("cookieDomain");
		if (RequestUtils.cookieDomain == null) 
		{
			RequestUtils.cookieDomain = "";
		}

		RequestUtils.cookiePath = filterConfig.getInitParameter("cookiePath");
		if (RequestUtils.cookiePath == null || RequestUtils.cookiePath.length() == 0) 
		{
			RequestUtils.cookiePath = "/";
		}
	}

}
