/*
 * MemSession.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * 会员登录密码及状态表
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class MemSession extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 8832883980062788878L;
	/**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 密码
     */
    private String password;
    /**
     * 令牌
     */
    private String session;
    /**
     * 状态
     */
    private String curtag;
    private Date logintime;
    private String device;

    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
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
    public String getCurtag() {
        return curtag;
    }
    public void setCurtag(String curtag) {
        this.curtag = curtag;
    }
    public Date getLogintime() {
        return logintime;
    }
    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }
    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
    }
}