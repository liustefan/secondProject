/*
 * DoctorSession.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.doctor.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * 医生登录密码及状态表
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class DoctorSession extends GenericModel {

    /**
     * 医生代码
     */
    private Integer doctorId;
    /**
     * 密码
     */
    private String password;
    /**
     * 令牌
     */
    private String session;
    /**
     * 账号禁用状态
     */
    private String tag;
    private Date loginTime;
    private String device;

    public Integer getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSession() {
        return session;
    }
    public void setSession(String session) {
        this.session = session;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public Date getLoginTime() {
        return loginTime;
    }
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
    }
}