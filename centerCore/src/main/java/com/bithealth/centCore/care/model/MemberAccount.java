/*
 * MemberAccount.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-01 Created
 */
package com.bithealth.centCore.care.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * 会员统一登录表
 * 
 * @author ${user}
 * @version 1.0 2016-09-01
 */
public class MemberAccount extends GenericModel {

    /**
     * 记录ID
     */
    private Integer logid;
    /**
     * [1.1]会员ID
     */
    private String memberid;
    /**
     * 会员账号
     */
    private String account;
    /**
     * 账号类型：1-手机号码；2-邮件；3-身份证
     */
    private Byte accounttype;
    /**
     * 服务ID(引用appRecode.app_server.id)
     */
    private Integer serverid;
    /**
     * 记录创建时间
     */
    private Date createtime;
    /**
     * 记录更新时间
     */
    private Date updatetime;

    public Integer getLogid() {
        return logid;
    }
    public void setLogid(Integer logid) {
        this.logid = logid;
    }
    public String getMemberid() {
        return memberid;
    }
    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public Byte getAccounttype() {
        return accounttype;
    }
    public void setAccounttype(Byte accounttype) {
        this.accounttype = accounttype;
    }
    public Integer getServerid() {
        return serverid;
    }
    public void setServerid(Integer serverid) {
        this.serverid = serverid;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public Date getUpdatetime() {
        return updatetime;
    }
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}