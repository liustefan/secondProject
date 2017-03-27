package com.bithealth;


import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bithealth.sdk.web.controller.BaseSpringController; 
import com.bithealth.sdk.web.vo.ShiroUser;
 
 

/**
 * 视图控制器,返回jsp视图给前端
 * 
 * @author JasonChai
 * @since 2014年5月28日 下午4:00:49
 **/
@Controller
@RequestMapping("/page")
public class PageController extends BaseSpringController{

 
    
    @Autowired  
    private  HttpServletRequest request;  
    /**
     * 登录页
     */
    @RequestMapping("/login")
    public String login( ) {
        String sessionid= request.getSession().getId();
        System.out.println(sessionid);
        return "/login";
    }

    /**
     * 登录页
     */
    @RequestMapping("/nologin")
    public String nologin(HttpServletRequest req, Model model) {
        model.addAttribute("outLine", "Y");  
        return "/tologin";
    }
    
    /**
     * 登录页
     */
    @RequestMapping("/sessionOut")
    public String sessionOut(HttpServletRequest req, Model model) {
        model.addAttribute("timeOut", "Y");  
        return "/tologin";
    }

    
    /**
     * dashboard页
     */
    @RequestMapping("/dashboard")
    public String dashboard() {
         
//       HttpServletRequest request = request ;
        
//        Map data = pageCacheManager.get(request);
//        
//        if(data!=null)
//        {
//            
//            pageCacheManager.append2Page(request, data);
//            
//            
//            
//            return "dashboard";
//        }
//        else
//        { 
//          
////            request.setAttribute("singerMap", singerMap);
////            //获取热门 
////            List<Accompaniment> hotAccompanimentList = accompanimentManager.findHotAccompaniment(10);
////            request.setAttribute("hotAccompanimentList", hotAccompanimentList);
//           
//        //加入缓存中
//        pageCacheManager.put(request);
//        
//        }
        ShiroUser shiroUser = super.getCurentUser();
      
        return "dashboard";
    }

    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }
    
    
    
    /**
     * invalidSession
     */
    @RequestMapping("/invalidSession")
    public String invalidSession() {
        return "invalidSession";
    }
    
    
    
    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }

}