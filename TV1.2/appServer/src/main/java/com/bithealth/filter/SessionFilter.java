package com.bithealth.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
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
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.model.AppUser;
import com.bithealth.sdk.core.entity.JSONResult;

@Component("sessionFilter")
public class SessionFilter extends OncePerRequestFilter{
	
	private Logger logger = Logger.getLogger(SessionFilter.class);
	
	@Resource
    private MemberService memberService;
	
	@Resource
    private DoctorService doctorService;
	
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
		String jsonStr = "";
		String params = request.getParameter("params");
		String submitMehtod = request.getMethod();
		// POST
        if(submitMehtod.equals("POST")){
        	if(StringUtils.isEmpty(params)){
        		jsonStr = getRequestPostStr(request);
        	}else{
        		jsonStr = params;
        	}
        }
        //协议头
        String head = "";
        //协议内容
        String content = "";
        if(!StringUtils.isEmpty(jsonStr)){
        	//表单提交，上传文件或者图片的时候
        	if(uri != null && uri.equals("") == false && (uri.startsWith("/member/updateMemberBasicInfo") || uri.startsWith("/measure/uploadMini")
        			|| uri.startsWith("/measure/uploadThreeInOne") || uri.startsWith("/chat/sendChatContent"))){
        		head = params;
        	}else{
        		JSONObject jsonObject = JSON.parseObject(jsonStr);
        		head = jsonObject.getString("head");
        		content = jsonObject.getString("content");
        	}
        }
		String requestUri = uri;
		String appUserStr = "";
		String otherParamStr = "";
		if(!StringUtils.isEmpty(head)){
			requestUri = requestUri + "?" + head;
			JSONResult<Object> paramValue = parseRequestParam(request,head,content,params);
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
		
	    if(null != requestUri && requestUri.length() > 1 && requestUri.startsWith("/")){ 
			// 移除前面的"//"
			requestUri = removePrex(requestUri);
		}
	    
	    /* 验证用户账号禁用状态 begin */
	    if(head != null && (null != requestUri) && !"/".equals(requestUri) && !submitMehtod.equals("POST")
	    		&& !"index.jsp".equals(requestUri) && !"login.jsp".equals(requestUri) && !requestUri.startsWith("member/login")
	    		&& !requestUri.startsWith("img") && !requestUri.startsWith("css") && !requestUri.startsWith("html") && !requestUri.startsWith("js")
	    		&& !requestUri.startsWith("member/findMemberHealthFile")
	    		&& !requestUri.startsWith("measure/findMeasDataImages")
	    		&& !requestUri.startsWith("measure/findMeasRecordList")
	    		&& !requestUri.startsWith("measure/findMeasRecordByEventIdAndType")
	    		&& !requestUri.startsWith("measure/findRecordListByEventIdsAndType")
	    		&& !requestUri.startsWith("health/findHealthServiceList")
	    		&& !requestUri.startsWith("health/findHealthServiceDetail")
	    		&& !requestUri.startsWith("health/findDoctorVisitingRecords")
	    		&& !requestUri.startsWith("file/downloadFileOrImage")
	    		&& !requestUri.startsWith("file/downloadThumbnailImage")
	    		&& !requestUri.startsWith("information/findAdvertisementDetail")
	    		&& !requestUri.startsWith("information/findInformationDetail")
	    		&& !requestUri.startsWith("attachedurl")
	    		&& !requestUri.startsWith("doctor/login") && !requestUri.startsWith("doctor/logout")){
	    	AppUser user = JSON.parseObject(appUserStr, AppUser.class);
    		try{
    			boolean isValidUser = checkUserAccountStatus(user);
    			if(isValidUser == false){
    				value.setStatusCode(4);
    				value.setMessage("用户账号冻结");
    				PrintWriter out = response.getWriter();
    				out.println(JSON.toJSONString(value));						
    				return;
    			}
    		}catch(Exception e){
	        	value.setStatusCode(2);
				value.setMessage("验证账户冻结状态异常");
				PrintWriter out = response.getWriter();
				out.println(JSON.toJSONString(value));
				logger.error("验证账户冻结状态异常。"+e);
				return;
	        }
	    }
	    /* 验证用户账号禁用状态 end */
	    
	    /* 验证session begin */
	    if(null == requestUri || "/".equals(requestUri) || "index.jsp".equals(requestUri)|| requestUri.startsWith("js")|| submitMehtod.equals("GET")
	    		|| requestUri.startsWith("img") || requestUri.startsWith("css") || requestUri.startsWith("html")
	    		|| requestUri.startsWith("member/login")|| requestUri.startsWith("member/logout")
	    		|| requestUri.startsWith("member/findMemberHealthFile")
	    		|| requestUri.startsWith("measure/findMeasDataImages")
	    		|| requestUri.startsWith("measure/findMeasRecordList")
	    		|| requestUri.startsWith("measure/findMeasRecordByEventIdAndType")
	    		|| requestUri.startsWith("measure/findRecordListByEventIdsAndType")
	    		|| requestUri.startsWith("health/findHealthServiceList")
	    		|| requestUri.startsWith("health/findHealthServiceDetail")
	    		|| requestUri.startsWith("health/findDoctorVisitingRecords")
	    		|| requestUri.startsWith("dictionary/findDiseaseDic")
	    		|| requestUri.startsWith("file/downloadFileOrImage")
	    		|| requestUri.startsWith("file/downloadThumbnailImage")
	    		|| requestUri.startsWith("information/findAdvertisementDetail")
	    		|| requestUri.startsWith("information/findInformationDetail")
	    		|| requestUri.startsWith("attachedurl")
	    		|| requestUri.startsWith("doctor/login")|| requestUri.startsWith("doctor/logout")){
	    	chain.doFilter(request, response);
	    }else if(head != null){
	    	AppUser user = JSON.parseObject(appUserStr, AppUser.class);
    		try{
				boolean isValidSession = checkUserSession(user);
				if(isValidSession == false){
					value.setStatusCode(5);
					value.setMessage("用户session失效");
					PrintWriter out = response.getWriter();
					out.println(JSON.toJSONString(value));						
					return;
				}
	    	}catch(Exception e){
	    		value.setStatusCode(2);
				value.setMessage("验证用户session异常");
				PrintWriter out = response.getWriter();
				out.println(JSON.toJSONString(value));
				logger.error("验证用户session异常"+e);
				return;
	    	}
	    	chain.doFilter(request, response);
	    }
	    /* 验证session end */
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
	 * @Description: 验证用户的账号是否有效
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月19日 
	 */
	public boolean checkUserAccountStatus(AppUser user)throws Exception{
		boolean isValidUser = false;
		Integer userType = user.getUserType();
		if(userType != null && userType == 1){
			String status = memberService.selectById(user.getUserId()).getStatus();
			if(!StringUtils.isEmpty(status) && status.equals("T")){
				isValidUser = true;
			}
		}else if(userType != null && userType == 2){
			isValidUser = true;
		}
		return isValidUser;
	}
	
	/**
	 * @Description: 验证用户的session是否失效 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月19日 
	 */
	public boolean checkUserSession(AppUser user)throws Exception{
		boolean isValidSession = false;
		Integer userType = user.getUserType();
		String userSession = user.getSession();
		if(userType != null && userType == 1){
			String session = memberService.selectMemberExtById(user.getUserId()).getMemSession().getSession();
			if(!StringUtils.isEmpty(session) && session.equals(userSession)){
				isValidSession = true;
			}
		}else if(userType != null && userType == 2){
			String session = doctorService.selectById(user.getUserId()).getDoctorSession().getSession();
			if(!StringUtils.isEmpty(session) && session.equals(userSession)){
				isValidSession = true;
			}
		}
		return isValidSession;
	}
	
	/**
	 * @Description: 解析请求参数
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月19日 
	 */
	public JSONResult<Object> parseRequestParam(HttpServletRequest request,String head,String content,String params){
 		JSONResult<Object> value = new JSONResult<Object>();
		try{
			if(!StringUtils.isEmpty(params)){
				JSONObject newObject = JSON.parseObject(params);
				if(newObject != null){
					String appUserStr = newObject.getString("head");
					String otherParamStr =  newObject.getString("content");
					request.setAttribute("appUserStr", appUserStr);
					request.setAttribute("otherParamStr",otherParamStr);
				}
			}else{
				if(!StringUtils.isEmpty(head)){
					request.setAttribute("appUserStr", head);
				}
				if(!StringUtils.isEmpty(content)){
					request.setAttribute("otherParamStr",content);
				}
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


}
