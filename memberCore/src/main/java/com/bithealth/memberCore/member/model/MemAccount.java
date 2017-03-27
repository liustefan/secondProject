/*
 * MemAccount.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.memberCore.enmu.AccountTypeEnum;
import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * 会员账号表
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class MemAccount extends GenericModel {

	private static final long serialVersionUID = 3871998532811267534L;
	/**
     * 记录ID
     */
    private Integer logid;
    /**
     * 会员代码，引用omem
     */
    private Integer memberid;
    /**
     * 会员账号
     */
    private String account;
    /**
     * 账号类型：1-手机号码；2-邮件；3-身份证
     */
    private Byte accounttype;
    /**
     * 与UC同步状态：1-待新增，2-新增成功，3-待删除
     */
    private Byte status = new Byte("2");
    /**
     * 创建医生ID(引用odoc表)，其中0-系统/对接，-1-会员
     */
    private Integer createdrid = 0;
    /**
     * 记录创建时间
     */
    private Date createtime = new Date();
    /**
     * 更新医生ID(引用odoc表)，0-系统/对接
     */
    private Integer updatedrid = 0;
    /**
     * 记录更新时间
     */
    private Date updatetime = new Date();
    
    /**
     * 会员
     */
    private Member member;
    
    private MemSession memberSession;
    
    private String accounttypeName;
    
    public MemAccount() {
    	
    }
    public MemAccount(String account, AccountTypeEnum type) {
    	this.account = account;
    	this.accounttype = type.getType().byteValue();
    }
    
    public MemSession getMemberSession() {
		return memberSession;
	}
	public void setMemberSession(MemSession memberSession) {
		this.memberSession = memberSession;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Integer getLogid() {
        return logid;
    }
    public void setLogid(Integer logid) {
        this.logid = logid;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
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
    	this.accounttypeName = AccountTypeEnum.getAccountType(accounttype.shortValue()).getText();
        this.accounttype = accounttype;
    }
    
    public String getAccounttypeName() {
		return accounttypeName;
	}
	public Byte getStatus() {
        return status;
    }
    public void setStatus(Byte status) {
        this.status = status;
    }
    public Integer getCreatedrid() {
        return createdrid;
    }
    public void setCreatedrid(Integer createdrid) {
        this.createdrid = createdrid;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public Integer getUpdatedrid() {
        return updatedrid;
    }
    public void setUpdatedrid(Integer updatedrid) {
        this.updatedrid = updatedrid;
    }
    public Date getUpdatetime() {
        return updatetime;
    }
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    
}