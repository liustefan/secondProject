/**
 * @PackageName:      com.bithealth.sdk.web.controller
 * @FileName:     BaseSpringController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      柴仕富
 * @version      V1.0  
 * @Createdate:  2016年7月8日 上午11:35:35  
 * 
 */

package com.bithealth.sdk.web.controller;

/**
 * 类名称: BaseSpringController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月8日 上午11:35:35 
 * 
 * @author "jason chai"
 * @version  
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.bithealth.sdk.web.beanutils.BeanUtils;
import com.bithealth.sdk.web.vo.ShiroUser;

public class BaseSpringController extends MultiActionController {

    static {

        ConvertRegisterHelper.registerConverters();
    }

    public void copyProperties(Object target, Object source) {
        BeanUtils.copyProperties(target, source);
    }

    public <T> T copyProperties(Class<T> destClass, Object orig) {
        return BeanUtils.copyProperties(destClass, orig);
    }

    /**
     * 
     *
     * @see MultiActionController#createBinder(HttpServletRequest,Object)
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Short.class, new CustomNumberEditor(Short.class, true));
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
        binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, true));
        binder.registerCustomEditor(Float.class, new CustomNumberEditor(Float.class, true));
        binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, true));
        binder.registerCustomEditor(BigDecimal.class,
            new CustomNumberEditor(BigDecimal.class, true));
        binder.registerCustomEditor(BigInteger.class,
            new CustomNumberEditor(BigInteger.class, true));
        //        binder.registerCustomEditor(Date.class, new CustomDateEditor(new DateEditor(), true));    
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    protected ShiroUser getCurentUser() {
        Subject currentUser = SecurityUtils.getSubject();

        ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipal();

        //        Subject currentUser = SecurityUtils.getSubject();
        //        ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();

        return shiroUser;
    }

    protected void LoginOutCurentUser() {

        Subject currentUser = SecurityUtils.getSubject();
        // 登出操作 
        currentUser.logout();
    }

    protected Session getCurentSession() {

        Subject subject = SecurityUtils.getSubject();

        Session session = subject.getSession();

        return session;

    }

    /**
     * 
     */
    protected static void saveError(HttpServletRequest request, String errorMsg) {
        if (StringUtils.isNotBlank(errorMsg)) {
            List list = getOrCreateRequestAttribute(request, "springErrors", ArrayList.class);
            list.add(errorMsg);
        }
    }

    public static <T> T getOrCreateRequestAttribute(HttpServletRequest request, String key,
                                                    Class<T> clazz) {
        Object value = request.getAttribute(key);
        if (value == null) {
            try {
                value = clazz.newInstance();
            } catch (Exception e) {
                ReflectionUtils.handleReflectionException(e);
            }
            request.setAttribute(key, value);
        }
        return (T) value;
    }
}
