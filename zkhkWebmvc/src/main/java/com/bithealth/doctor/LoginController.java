package com.bithealth.doctor;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bithealth.Constrants;
import com.bithealth.Message;
import com.bithealth.doctorCore.constants.Constants;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorAccount;
import com.bithealth.doctorCore.doctor.service.DoctorAccountService;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.doctorCore.enmu.CertiType;
import com.bithealth.doctorCore.facede.service.DoctorInterfService;
import com.bithealth.listener.SessionListener;
import com.bithealth.sdk.common.utils.Md5Utils;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;
import com.bithealth.web.security.PermissionSign;
import com.bithealth.web.security.RoleSign;

/**
 * 用户控制器
 * 
 * @author JasonChai
 * @since 2016年5月28日 下午3:54:00
 **/
@Controller
@RequestMapping(value = "/user")
public class LoginController extends BaseSpringController {

    @Resource(name="doctorInterfService")
    private DoctorInterfService doctorInterfService;

    @Resource(name="doctorService")
    private DoctorService doctorService;
    
    @Resource(name="doctorAccountServiceImpl")
    private DoctorAccountService accountService;
    
    @Resource(name="shiroEhcacheManager")
    private CacheManager cacheManager;
    
    private Cache<String, Deque<Serializable>> cache;
    
    private static Logger logger=Logger.getLogger(LoginController.class);
    


    public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro-kickout-session");
    }

    private List<String> error = new ArrayList<>(); // 错误信息


    /**
     * 用户登录
     * 
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(@Valid DoctorAccount doctorAccount, BindingResult result, Model model, HttpServletRequest request) {
  
        String password =  Md5Utils.encript(doctorAccount.getDocpass());
        doctorAccount.setDocpass(password );
        
        UsernamePasswordToken token = new UsernamePasswordToken(doctorAccount.getDocacc() , doctorAccount.getDocpass() );
        token.setHost(request.getRemoteAddr());
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        // 已登陆则 跳到首页
        if (subject.isAuthenticated()) {
            return "/public/index";
        }
        if (result.hasErrors()) {
            model.addAttribute("error", "参数错误！");
            return "login";
        }
        
        String error = null; 
        
        try {  
            subject.login(token);   // 身份验证 
        } catch (UnknownAccountException e) {  
            error = "用户名/密码错误";  
        } catch (IncorrectCredentialsException e) {  
            error = "用户名/密码错误";  
        } catch (ExcessiveAttemptsException e) {  
            error = "超过失败次数,请在" + Constants.INTERVAL_MAX + "分中之后登录";  
        } catch(DisabledAccountException e){
        	error = "用户被禁用";
        }catch (AuthenticationException e) {  
            error = "其他错误：" + e.getMessage();  
        }  
        
        
        if(request.getParameter("kickout") != null) {
            model.addAttribute("error", "您已经被管理员强制退出，请重新登录");
        }
        
        
        if (error != null) {// 出错了，返回登录页面  
            model.addAttribute("status", error);
            return "/login";
        }
       // 登录成功  
        ShiroUser shiroUser = getCurentUser();
        request.getSession().setAttribute(Constrants.USER_ID, shiroUser.getId());
        request.getSession().setAttribute("userInfo", shiroUser);
//        if(isLogin(request.getSession())){
//			forcedLogin(request);	//强制剔除已经登录的用户
//			request.setAttribute("removeOther", "Y");
//		}
        
       if (getCurentSession() != null && getCurentSession().getAttribute("removeOther")!=null)
        model.addAttribute("removeOther", getCurentSession().getAttribute("removeOther"));
//        
        //金钥匙或者超级管理员以初始密码登录，提示修改密码，跳转至修改密码页面
        if(5 == shiroUser.getRoleid().intValue() && Constants.GOLDEN_USER.equals(password)) {
        	return "/doctor/sysAdminPwd";
        }
        if(6 == shiroUser.getRoleid().intValue() && Constants.SUPER_ADMIN.equals(password)) {
        	return "/doctor/sysAdminPwd";
        }
        
        if(5 != shiroUser.getRoleid().intValue() && 6 != shiroUser.getRoleid().intValue()) {
        	if(shiroUser.getDept_id() == null) {
        		request.setAttribute("status", "账号所属组织不存在 ，禁止登录");
        		accountService.updateAcountByLogin(false, doctorAccount);
        		return "/login";
        	}
        }
        
        return "/public/index";
    }

    /**
     * 用户登出
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
         
        ShiroUser shiroUser = getCurentUser(); 
         
        String username = (String) shiroUser.getId().toString() ;  
        
        this.cache = cacheManager.getCache("shiro-kickout-session");
        //TODO 同步控制  
        Deque<Serializable> deque = cache.get(username);  
        if(deque != null&&deque.size() >0) {  
            deque.removeLast();  
        }  
   
   
//            if(kickoutAfter) { //如果踢出后者  
//                kickoutSessionId = deque.removeFirst();  
//            } else { //否则踢出前者  
//                kickoutSessionId = deque.removeLast();  
//            }  
            
        Doctor loginDoc = new Doctor();
        loginDoc .setDocid(shiroUser.getId());
        doctorInterfService.logout( loginDoc );
//
        super.LoginOutCurentUser();
         
        //重定向到商品查询页面  
          
        return "redirect:/login";
    }
    
    @RequestMapping(value="myInfoDetail")
    public String myInfoDetail(HttpServletRequest request, RedirectAttributes attr) {
    	ShiroUser user = getCurentUser();
    	Doctor doctor = doctorService.selectById(user.getId());
    	request.setAttribute("doctor", doctor);
    	request.setAttribute("certiType", CertiType.values());
    	attr.addFlashAttribute("msg", attr.getFlashAttributes().get("msg"));
    	attr.addFlashAttribute("success", attr.getFlashAttributes().get("success"));
    	return "/public/myInfoDetail";
    }
    
    @RequestMapping(value="updateSelfPwd")
    @ResponseBody
    public Message updateSelfPwd(DoctorAccount account, String oldDocPass){
    	boolean success = false;
    	try{
    		account.setDocpass(Md5Utils.encript(account.getDocpass()));
    		success = accountService.updateSelfPwd(Md5Utils.encript(oldDocPass), account);
    	} catch (BusinessException e) {
    		return new Message(e.getMessage(), false);
    	}
		if(success){
			return new Message("密码修改成功，请重新登录", true);
		}
		return new Message("修改密码失败，请检查原始密码是否正确", false);
    }
    
    @RequestMapping("/updateAdminPwd")
    public String updateAdminPwd(Doctor doctor, String reDocPass, String originalPwd, HttpServletRequest request) {
    	List<String> msg = new ArrayList<String>();
    	if(StringUtil.isEmpty(reDocPass)) {
    		msg.add("确认密码不能为空");
    	}
    	if(StringUtil.isEmpty(originalPwd)) {
    		msg.add("原始密码不能为空");
    	}
    	if(doctor.getDoctorAccount() == null || StringUtil.isEmpty(doctor.getDoctorAccount().getDocpass())) {
    		msg.add("输入密码不能为空");
    	}
    	if(!reDocPass.equals(doctor.getDoctorAccount().getDocpass())) {
    		msg.add("新密码和确认密码不一致");
    	}
    	Doctor data = doctorService.selectById(doctor.getDocid());
    	if(data == null) {
    		msg.add("用户不存在");
    	}
    	if(!Md5Utils.encript(originalPwd.trim()).equals(data.getDoctorAccount().getDocpass())) {
    		msg.add("原始密码不正确");
    	}
    	if(!msg.isEmpty()) {
    		request.setAttribute("msg", msg);
    		return "/doctor/sysAdminPwd";
    	}
    	if(data.getRoleid().intValue() == 5) {
    		data.setEmail(doctor.getEmail());
    	}
    	data.getDoctorAccount().setDocpass(Md5Utils.encript(doctor.getDoctorAccount().getDocpass()));
    	doctorInterfService.updateInitPwdBySelf(data);
    	return "redirect:/user/logout";
    }

    /**
     * 基于角色 标识的权限控制案例
     */
    @RequestMapping(value = "/admin")
    @ResponseBody
    @RequiresRoles(value = RoleSign.ADMIN)
    public String admin() {
        return "拥有admin角色,能访问";
    }

    /**
     * 基于权限标识的权限控制案例
     */
    @RequestMapping(value = "/create")
    @ResponseBody
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public String create() {
        return "拥有user:create权限,能访问";
    }
    
    /**
	 * 判断同一账号是否在另一客户端处于在线状态登录
	 * @return
	 */
	private boolean isLogin(HttpSession session){
		boolean flag = false;
		HashMap<String, Object> hs = SessionListener.getList();
		if(hs != null && !hs.isEmpty()) {
			String currentId = session.getId();	//当前session的ID
			Object currentAcc = session.getAttribute(Constrants.USER_ID);	//当前账号
			Iterator<String> iter = hs.keySet().iterator();
			while(iter.hasNext()){
				Object obj = iter.next();
				if(obj != null){
					String key = obj.toString();
					//判断缓冲中是否存在相同账号已登录状态
					if(hs.get(key) != null && currentAcc != null 
							&& currentAcc.equals(hs.get(key)) 
							&& !key.equals(currentId)){
						flag = true;
					}
				}
			}
		}
		return flag;
	}
	//剔除其他客户端的登录账号，强制登录，剔除另一客户端登录
	private void forcedLogin(HttpServletRequest request){
		HashMap<String, Object> hs = SessionListener.getList();
		if(hs != null && hs.keySet() != null && hs.keySet().size() > 0){
			String currentId = request.getSession().getId();	//当前session的ID
			Object currentAcc = request.getSession().getAttribute(Constrants.USER_ID);	//当前账号
			Iterator<String> iter = hs.keySet().iterator();
			while(iter.hasNext()){
				String key = iter.next();
				if(String.valueOf(currentAcc).equals(String.valueOf(hs.get(key))) && !currentId.equals(key)) {
					iter.remove();
				}
			}
		}
		 
		
	}
	
	
    
    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }
    
}
