package com.bithealth.system.security;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import com.bithealth.Constrants;
import com.bithealth.doctor.ShiroConver;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorAccount;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.doctorCore.enmu.DeviceEnum;
import com.bithealth.doctorCore.exception.LoginException;
import com.bithealth.doctorCore.facede.service.DoctorInterfService;
import com.bithealth.sdk.web.vo.ShiroUser;


/**
 * 用户身份验证,授权 Realm 组件
 * 
 * @author JasonChai
 * @since 2014年6月11日 上午11:35:28
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

    @Resource
    private DoctorInterfService doctorInterfService;
    

    @Resource
    private DoctorService doctorService;
    
    
    private String                             kickoutUrl;          //踢出后到的地址  
    private boolean                            kickoutAfter = false; //踢出之前登录的/之后登录的用户 默认踢出之前登录的用户  
    private int                                maxSession   = 1;    //同一个帐号最大会话数 默认1  

    private SessionManager                     sessionManager;
    private Cache<String, Deque<Serializable>> cache;

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

//
//    @Resource
//    private RoleService roleService;
//
//    @Resource
//    private PermissionService permissionService;


    /**
     * 权限检查
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        String username = String.valueOf(principals.getPrimaryPrincipal());
        ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName())
                .iterator().next();
//        String username = shiroUser.getName();
         
        DoctorAccount doctorAccount   = new DoctorAccount();
        

        final  Doctor authentication =  doctorService.selectById(shiroUser.getId()) ;
        
//        
//        final List<orol> roleInfos = roleService.selectRolesByUserId(user.getId());
//        
//        for (Role role : roleInfos) {
//            // 添加角色
//            System.err.println(role);
//            authorizationInfo.addRole(role.getRoleSign());
//
//            final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getId());
//            for (Permission permission : permissions) {
//                // 添加权限
//                System.err.println(permission);
//                authorizationInfo.addStringPermission(permission.getPermissionSign());
//            }
//        }
         
        
        return authorizationInfo;
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

    	UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String userName = String.valueOf(upToken.getPrincipal());
        String password = new String((char[]) upToken.getCredentials());
         
        DoctorAccount doctorAccount   = new DoctorAccount();
        doctorAccount.setLastloginaddr(upToken.getHost());
        doctorAccount.setDocacc(userName);
        doctorAccount.setDocpass(password);
        
        // 通过数据库进行验证 
        
        DeviceEnum device  =  DeviceEnum.PC ;
        Doctor authentication  = null;
        try {
            authentication = doctorInterfService.login(doctorAccount, device);
        } catch (LoginException e) {
            if(e.getCode().equals(LoginException.ERROR_NAME) ) {  
                throw new UnknownAccountException(e);//"username wasn't in the system." 
            }  
            
            if(e.getCode().equals(LoginException.ERROR_PWD) ) {  
                throw new IncorrectCredentialsException(e);//"password didn't match."
            } 
            
            if(e.getCode().equals(LoginException.ERROR_STATUS) ) {  
                throw new DisabledAccountException(e);//帐号锁定  
            } 
            
            if(e.getCode().equals(LoginException.OVER_FAIL_COUNT)) { 
                throw new ExcessiveAttemptsException(e); //帐号锁定  
            }  
        }catch ( Exception e) {
        	e.printStackTrace();
        	 throw new AuthenticationException("系统错误."+e.getMessage());
        }
         
        if (authentication == null) {
            throw new AuthenticationException("用户名或密码错误.");
        }
        
        ShiroUser shiroUser = new ShiroUser( ); 
        
        shiroUser = ShiroConver.getUser(authentication, shiroUser) ;

        kickout(shiroUser); 
        
        
        SimpleAuthenticationInfo authenticationInfo =  new SimpleAuthenticationInfo(shiroUser, password, getName());
        
//      //apache shiro获取所有在线用户  
//        Collection<Session> sessions = sessionDAO.getActiveSessions();  
//        for(Session session:sessions){  
//            String loginUsername = String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));//获得session中已经登录用户的名字  
//              
//            if(username.equals(loginUsername)){  //这里的username也就是当前登录的username  
//                session.setTimeout(0);  //这里就把session清除，  
//                  
//            }  
//        }  
        
        
        return authenticationInfo; 
    }
    
    
  private void kickout(ShiroUser shiroUser ){
        
        Subject subject = SecurityUtils.getSubject();; 
//        
//        if(!subject.isAuthenticated() && !subject.isRemembered()) {//未授权且非remember   
//            //如果没有登录，直接进行之后的流程  
//            return true;  
//        }   
    
        Session session = subject.getSession();  
//        
//   //提前1秒去判断   防止这个if没进  等执行下面的时候它却失效了  <span style="font-family: Arial, Helvetica, sans-serif;">lengthenTimeOut是失效时间</span>  
//        
//        if((System.currentTimeMillis()-session.getStartTimestamp().getTime())>=lengthenTimeOut-1000){  
//            ThreadContext.remove(ThreadContext.SUBJECT_KEY);//移除线程里面的subject  
//            shiroSessionManager.getSessionDAO().delete(session);//移除失效的session  
//            subject = SecurityUtils.getSubject();//重新获取subject  
//        }  
        
        
//        ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
//        String username = (String) subject.getPrincipal();  
        Serializable sessionId = session.getId();  
        String username = (String) shiroUser.getId().toString() ;  

        System.out.println("sessionId:"+sessionId   +"  username::"+username);
        
        //TODO 同步控制  
        Deque<Serializable> deque = cache.get(username);  
        if(deque == null) {  
            deque = new LinkedList<Serializable>();  
            cache.put(username, deque);  
        }  
  
        //如果队列里没有此sessionId，且用户没有被踢出；放入队列  
        if(!deque.contains(sessionId) && session.getAttribute("kickout") == null) {  
            deque.push(sessionId);  
        }  
  
        boolean isloginflag = false;
        //如果队列里的sessionId数超出最大会话数，开始踢人  
        while(deque.size() > maxSession) {
            isloginflag =true;
            Serializable kickoutSessionId = null;  
            if(kickoutAfter) { //如果踢出后者  
                kickoutSessionId = deque.removeFirst();  
            } else { //否则踢出前者  
                kickoutSessionId = deque.removeLast();  
            }  
            try {  
                Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));  
                if(kickoutSession != null) {  
                    //设置会话的kickout属性表示踢出了  
                    kickoutSession.setAttribute(Constrants.SESSION_FORCE_LOGOUT_KEY, Boolean.TRUE); 
                }  
            } catch (Exception e) {//ignore exception  
            }  
        }  
        
//        session.setAttribute("removeOther", "Y"); 
        
        if (isloginflag)
            session.setAttribute("removeOther", "Y");
        
    }
     
}
