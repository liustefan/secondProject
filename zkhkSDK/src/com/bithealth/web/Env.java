package com.bithealth.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bithealth.sdk.common.utils.SessionUtil;
 
import javax.servlet.jsp.PageContext;



/**
 * @author vincent ke
 */

public class Env {
	
	private final static Log log = LogFactory.getLog(Env.class);
	
	public static final String NEXT_REQUEST_SCOPE = "com.bithealth.developer.NextRequestScope";
	private HttpServletRequest request;
	private HttpServletResponse response;
	private PageContext pageContext;

	@SuppressWarnings("unchecked")
	public void setRequest(HttpServletRequest request) {
		this.request = request;

		Map<String, Object> nextRequestScopeHandler = (Map<String, Object>) SessionUtil
				.getNextRequest(request);
		if (nextRequestScopeHandler != null) {
			SessionUtil.removeNextRequest(request);
			
			 for(String key : nextRequestScopeHandler.keySet()){
			    	request.setAttribute(key, nextRequestScopeHandler.get(key));
			 }
			 
			request.setAttribute(NEXT_REQUEST_SCOPE, nextRequestScopeHandler);
		}

	}
	
	

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
		this.request = (HttpServletRequest) pageContext.getRequest();
		this.response = (HttpServletResponse) pageContext.getResponse();
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public PageContext getPageContext() {
		return pageContext;
	}
	
	
	/**
	 * 获取验证码
	 * @return
	 */
	public String getValidCode() {

		return SessionUtil.getValidCode(request);

	}

	/**
	 * 设置验证码
	 * @param validCode
	 * @throws Exception
	 */
	public void setValidCode(String validCode) throws Exception {


		SessionUtil.setValidCode(validCode, request, response);

	}
	

	/**
	 * 用户退出
	 */
	public void clearSession() {
		SessionUtil.invalidate(request, response);
	}

	

	/**
	 * 获取spring 容器
	 * @return
	 */
	public WebApplicationContext getApplicationContext() {
		if (request != null) {
			return WebApplicationContextUtils.getWebApplicationContext(request
					.getSession().getServletContext());
		} else {
			return null;
		}
	}

	public void setAttribute(String key,Object value, boolean supportRedirect) {

		if (supportRedirect){
			Map<String, Object>  next = getNextRequestScopeHandler();
			next.put(key, value);
			setNextRequestScopeHandler(next);
			
		}else
			request.setAttribute(key, value);
	}


	@SuppressWarnings("unchecked")
	synchronized Map<String, Object> getNextRequestScopeHandler() {

		HashMap<String, Object> nextRequestScopeHandler = (HashMap<String, Object>) SessionUtil
				.getNextRequest(request);
		if (nextRequestScopeHandler == null) {
			nextRequestScopeHandler = new HashMap<String, Object>();
			SessionUtil.setNextRequest(nextRequestScopeHandler, request,
					response);
		}

		return nextRequestScopeHandler;
	}
	
	@SuppressWarnings("unchecked")
	synchronized void setNextRequestScopeHandler(Map<String, Object> nextRequestScopeHandler) {

			SessionUtil.setNextRequest(nextRequestScopeHandler, request,
					response);

	}
	
	public UserExt getUserExt() {
		
		log.debug("call getUserExt");
		
		return (UserExt)SessionUtil.getAttribute(request, "_user_");
	}
	
	public void setUserExt(UserExt userExt) {
		
		log.debug("call setUserExt");
		
		SessionUtil.setAttribute(request, "_user_", userExt);
	}

}
