 
/**
 * @PackageName:      com.bithealth.listener
 * @FileName:     SessionInterceptor.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      柴仕富
 * @version      V1.0  
 * @Createdate:  2016年7月28日 上午11:26:57  
 * 
 */

package com.bithealth.listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 类名称: SessionInterceptor  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月28日 上午11:26:57 
 * 
 * @author "jason chai"
 * @version  
 */
public class SessionInterceptor extends HandlerInterceptorAdapter{

    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception { 
        
      //  System.out.println(request.getServletPath());
        
        Subject subject = SecurityUtils.getSubject(); 
        Session session = subject.getSession(false);
        
      //  System.out.println(session.getId()+"*******session***********");
        
        Object obj = request.getSession().getAttribute("userInfo");  

      //  System.out.println(obj+"*******obj***********");
      
        if (null == obj) { //未登录
        
            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ //如果是ajax请求响应头会有，x-requested-with  
                response.setHeader("sessionstatus", "timeout");//在响应头设置session状态  
            }else{
                 
                request.setAttribute("timeOut", "Y");
                response.sendRedirect(request.getContextPath()+"/page/sessionOut");
                   
            }  
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}

