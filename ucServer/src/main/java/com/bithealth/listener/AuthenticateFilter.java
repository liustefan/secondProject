package com.bithealth.listener;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSONObject;
import com.bithealth.ucCore.facade.constants.UCConstants;
import com.bithealth.ucCore.uc.model.AppServer;
import com.bithealth.ucCore.uc.model.ReturnObject;
import com.bithealth.ucCore.uc.service.AppServerService;


/**
 * 过滤器
 * 
 * @author bit
 * 
 */
@Component("authenticateFilter")
public class AuthenticateFilter extends OncePerRequestFilter {

	public static Logger logger = Logger.getLogger(AuthenticateFilter.class);
	
	@Resource(name="appServerService")
	private AppServerService appServerService;
	 
	public void destroy() {

	}

	public String removePrex(String s) {
		String patternStr = "([a-zA-Z]+)";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(s);
		String replaceStr = null;
		if (matcher.find()) {
			replaceStr = matcher.group();
		}
		int i = s.indexOf(replaceStr) - 1;
		if (s.length() > i) {
			s = s.substring(i + 1, s.length());
		}
		return s;
	}

	/**
	 * 判断是否为Ajax请求 <功能详细描述>
	 * 
	 * @param request
	 * @return 是true, 否false
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header))
			return true;
		else
			return false;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain chain)throws ServletException, IOException {
		String domain = request.getHeader("DNS");
		String uri = request.getRequestURI(); // 获取地址URL
		String prefix = request.getContextPath(); // 得到 项目上下文路径
		uri = uri.substring(prefix.length()); // 去除 项目上下文路径
		String params = request.getQueryString();// 获取URL后跟的值
		response.setCharacterEncoding("utf-8");
		String requestUri = uri;
		if (params != null) {
			requestUri = requestUri + "?" + params;
		}
		if (null != requestUri && requestUri.length() > 1&& requestUri.startsWith("/")) {
			// 移除前面的"//"
			requestUri = removePrex(requestUri);
		}
		if (requestUri.startsWith("getAddress") || UCConstants.WEB_ADDRESS.contains(domain) || 
				requestUri.startsWith("listPublicURL") || requestUri.startsWith("listPublicHttpsURL")) {
			chain.doFilter(request, response);
		}else {
			String serverID = request.getParameter("serverID");
			if(serverID != null ){
				//根据serverID获取对应服务器配置信息
				AppServer appServer = appServerService.selectById(Integer.parseInt(serverID));
				if(appServer == null) {
					ReturnObject returnObject = new ReturnObject();
					returnObject.setCode(303);
					returnObject.setMessage("认证中心验证失败，无权登入");
					logger.info("没有权限登入");
					response.getWriter().write(JSONObject.toJSONString(returnObject));
					return;
				}
				chain.doFilter(request, response);
//				if(appServer != null && domain!=null && domain.equals(appServer.getWebAddress())){
//					UCConstants.WEB_ADDRESS.add(appServer.getWebAddress());
//					logger.info("登入权限通过");
//					chain.doFilter(request, response);
//				}else{
//					ReturnObject returnObject = new ReturnObject();
//					returnObject.setCode(303);
//					returnObject.setMessage("认证中心验证失败，无权登入");
//					logger.info("没有权限登入");
//					response.getWriter().write(JSONObject.toJSONString(returnObject));
//					return;
//				}
			}else{
				ReturnObject returnObject = new ReturnObject();
				returnObject.setCode(304);
				returnObject.setMessage("serverID为空");
				logger.info("serverID为空");
				response.getWriter().write(JSONObject.toJSONString(returnObject));
				return;
			}
		}

	}


}
