package com.bithealth.listener;

import java.io.Serializable;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.bithealth.Constrants;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.facede.service.DoctorInterfService;
import com.bithealth.sdk.web.vo.ShiroUser;

public class Loginintercetor extends AccessControlFilter {

    private String                             kickoutUrl;          //踢出后到的地址  
    private boolean                            kickoutAfter = false; //踢出之前登录的/之后登录的用户 默认踢出之前登录的用户  
    private int                                maxSession   = 1;    //同一个帐号最大会话数 默认1  

    private SessionManager                     sessionManager;
    private Cache<String, Deque<Serializable>> cache;

    @Resource(name = "doctorInterfService")
    private DoctorInterfService                doctorInterfService;

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro-kickout-session");
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response,
                                      Object mappedValue) throws Exception {
        Session session = getSubject(request, response).getSession(false);
        if (session == null) {
            return true;
        }

        Serializable sessionId = session.getId();
      //  System.out.println("sessionId:" + sessionId);
        return session.getAttribute(Constrants.SESSION_FORCE_LOGOUT_KEY) == null;
        //        return false;  
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
                                                                                      throws Exception {
      
     
        String url1 = ((HttpServletRequest) request).getRequestURI();
        //if(url1.startsWith("/HKEJ/doctor/doctorAction!login.action") || url1.equals("/HKEJ")){
        if(url1.contains("user/login") || url1.equals(((HttpServletRequest) request).getContextPath())){
            return true;
        }
        if(url1.contains("/intef/regist")){
            return true;
        }
        Subject subject = SecurityUtils.getSubject();
        
        //      
        if(!subject.isAuthenticated() && !subject.isRemembered()) {
            //如果没有登录，直接进行之后的流程
            return true;
        }
        //      if(!subject.isAuthenticated() && !subject.isRemembered()) {//未授权且非remember   
        //          //如果没有登录，直接进行之后的流程  
        //          return true;  
        //      }   

        Session session = subject.getSession(false);
        //      
        // //提前1秒去判断   防止这个if没进  等执行下面的时候它却失效了  <span style="font-family: Arial, Helvetica, sans-serif;">lengthenTimeOut是失效时间</span>  
        //      
        //      if((System.currentTimeMillis()-session.getStartTimestamp().getTime())>=lengthenTimeOut-1000){  
        //          ThreadContext.remove(ThreadContext.SUBJECT_KEY);//移除线程里面的subject  
        //          shiroSessionManager.getSessionDAO().delete(session);//移除失效的session  
        //          subject = SecurityUtils.getSubject();//重新获取subject  
        //      }  

        ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
        Doctor loginDoc = new Doctor();
        loginDoc.setDocid(shiroUser.getId());
        doctorInterfService.logout(loginDoc);

        try {
            getSubject(request, response).logout();//强制退出
        } catch (Exception e) {/*ignore exception*/
        }

//        request.setAttribute("timeOut", "Y");
        request.setAttribute("outLine", "Y");
          kickoutUrl = kickoutUrl  + (kickoutUrl.contains("?") ? "&" : "?")
                          + "outLine=Y";
        WebUtils.issueRedirect(request, response, kickoutUrl);
        return false;

    }

    //检测用户Session，判断自己的sessionId是否已被剔除 
    private String checkUserSession(HttpServletRequest request) {
        HashMap hs = SessionListener.getList();
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "timeOut"; //session失效
        }

        if (hs != null && hs.keySet() != null && hs.keySet().size() > 0) {
            String currentId = session.getId(); //当前session的ID
            boolean flag = false;
            Iterator iter = hs.keySet().iterator();
            while (iter.hasNext()) {
                Object obj = iter.next();
                if (obj != null) {
                    String key = obj.toString(); //sessionId
                    if (key.equals(currentId)) {
                        flag = true;
                        break;
                    }
                }
            }
            //如果sessionId被剔除，被迫下线
            if (!flag) {
                session.removeAttribute("user_id");
                session.invalidate();
                return "outLine";
            }
        }
        return null;
    }

}
