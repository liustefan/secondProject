package com.bithealth.sdk.core.util;

import java.security.Principal;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 

import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.common.YoushangContext;

/**
 * 
 * <p>金蝶移动互联有限公司版权所有</p>
 * 
 * @author szujobs
 * @created 2008-2-18 下午10:32:57
 * @since 2.1.15
 */
public class YoushangContextUtils {
	public static final String HTTP_REQ_ATTR = "com.kingdee.zkhk.HttpServletRequest";
	public static final String HTTP_RESP_ATTR = "com.kingdee.zkhk.HttpServletResponse";
	
	private static ThreadLocal<HttpServletRequest> requestLocale = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> responseLocale = new ThreadLocal<HttpServletResponse>();

	private static ServletContext servletContext = null;

	public static void setServletContext(ServletContext servletContext) {
		YoushangContextUtils.servletContext = servletContext;
	}

	public static ServletContext getServletContext() {
		return servletContext;
	}

	public static void setHttpServletRequest(HttpServletRequest reqeust) {
		requestLocale.set(reqeust);
	}

	public static HttpServletRequest getHttpServletRequest() {
		return requestLocale.get();
	}
	
	public static String getContextPath() {
		YoushangContext context = Env.getContext();

		if (context == null) {
			return null;
		}

		HttpServletRequest request = (HttpServletRequest) context.getTransientAttributes().get(HTTP_REQ_ATTR);
		
		if (request == null) {
			return null;
		}
		
		return request.getContextPath();
	}

	public static void setHttpServletResponse(HttpServletResponse response) {
		responseLocale.set(response);
	}

	public static HttpServletResponse getHttpServletResponse() {
		return responseLocale.get();
	}
	
//	public static YoushangContext createTestContext(long dbId) {
//		SimpleApplicationPrincipal principal = new SimpleApplicationPrincipal();
//		principal.setDbId(dbId);
//		
//		YoushangContext context = new YoushangContext();
//		context.getLoginContext().getSubject().getPrincipals().add(principal);
//		
//		return context;
//	}
//	
//	public static YoushangContext createContext(Principal principal) {
//		YoushangContext context = new YoushangContext();
//		context.getLoginContext().getSubject().getPrincipals().add(principal);
//		
//		return context;
//	}
	
	public static String getStaticURL(){
		String staticURL = (String)Env.getProperty("staticURL");
		if(staticURL!=null)
			return staticURL;
		return getHttpServletRequest().getContextPath();
	}
}
