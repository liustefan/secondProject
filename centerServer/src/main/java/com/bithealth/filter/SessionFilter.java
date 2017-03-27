package com.bithealth.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.sdk.core.entity.JSONResult;

@Component("sessionFilter")
public class SessionFilter extends OncePerRequestFilter{
	
	private Logger logger = Logger.getLogger(SessionFilter.class);

	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain) throws IOException,ServletException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		JSONResult<Object> value = new JSONResult<Object>();
		//获取地址URL
		String uri = request.getRequestURI();
		//得到 项目上下文路径
		String prefix = request.getContextPath();
		//去除 项目上下文路径
		uri = uri.substring(prefix.length());
		
		Map<String, String[]>  a = request.getParameterMap();
		
		if(isRequestFromAPP(uri)){ // app端的请求过来的接口
			String jsonStr = "";
			String submitMehtod = request.getMethod();
			// POST
	        if(submitMehtod.equals("POST")){
	        	jsonStr = getRequestPostStr(request);
	        }
	        //协议头
	        String head = "";
	        //协议内容
	        String content = "";
	        if(!StringUtils.isEmpty(jsonStr)){
	        	JSONObject jsonObject = JSON.parseObject(jsonStr);
	        	head = jsonObject.getString("head");
	        	content = jsonObject.getString("content");
	        }
			String requestUri = uri;
			String appUserStr = "";
			String otherParamStr = "";
			if(!StringUtils.isEmpty(head)){
				requestUri = requestUri + "?" + head;
				JSONResult<Object> paramValue = parseRequestParam(request,head,content);
	        	if(paramValue.isSuccess()){
	        		HttpServletRequest newRequest = (HttpServletRequest)paramValue.getData();
	        		appUserStr = (String)newRequest.getAttribute("appUserStr");
	        		if(!StringUtils.isEmpty(appUserStr)){
	        			request.setAttribute("appUserStr",appUserStr);
	        		}
	        		otherParamStr = (String)newRequest.getAttribute("otherParamStr");
	        		if(!StringUtils.isEmpty(otherParamStr)){
	        			request.setAttribute("otherParamStr",otherParamStr);
	        		}
	        	}else{
	        		value.setStatusCode(paramValue.getStatusCode());
					value.setMessage(paramValue.getMessage());
					PrintWriter out = response.getWriter();
					out.println(JSON.toJSONString(value));
					return;
	        	}
			}
		}
		chain.doFilter(request, response);			
	}

	/**
	 * @Description: 获取取出\\的url 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月19日 
	 */
	public String removePrex(String s){
		String patternStr = "([a-zA-Z]+)";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(s);
		String replaceStr = null;
		if(matcher.find()){
			replaceStr = matcher.group();
		}
		int i = s.indexOf(replaceStr) - 1;
		if(s.length() > i){
			s = s.substring(i + 1, s.length());
		}
		return s;
	}
	
	
	/**
	 * @Description: 解析请求参数
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月19日 
	 */
	public JSONResult<Object> parseRequestParam(HttpServletRequest request,String head,String content){
		JSONResult<Object> value = new JSONResult<Object>();
		try{
			if(!StringUtils.isEmpty(head)){
				request.setAttribute("appUserStr", head);
			}
			if(!StringUtils.isEmpty(content)){
				request.setAttribute("otherParamStr",content);
			}
			value.setSuccess(true);
			value.setStatusCode(0);
			value.setData(request);
		}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(6);
			value.setMessage("url请求参数格式不正确");
			logger.error("url请求参数格式不正确"+e);
		}
		return value;
	}
	
	/**      
     * 描述:获取 post 请求的 byte[] 数组
     * @param request
     * @return
     * @throws IOException      
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {
            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }

    /**      
     * 描述:获取 post 请求内容
     * @param request
     * @return
     * @throws IOException      
     */
    public static String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }

    
    public boolean isRequestFromAPP(String uri){
    	if("/care/getMyCareList".equals(uri) || "/care/getCareMeList".equals(uri) || "/care/getMember".equals(uri) || "/care/addCare".equals(uri) ||
    			"/care/relateAcount".equals(uri) || "/care/updateCare".equals(uri) || "/care/getMemberByGuid".equals(uri) || "/care/getMyCareMessage".equals(uri)||
    			"/care/sendKindlyReminder".equals(uri)|| "/msgCenter/getMessageList".equals(uri) || "/care/getCareMemberNews".equals(uri) 
    			|| "/care/getMyKindlyReminder".equals(uri) || "/msgCenter/deleteMsgByGuid".equals(uri)){
    		return true;
    	}else{
    		return false;
    	}
    	
    	
    }

}
