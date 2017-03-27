/*
 * DoctorAccount.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.doctor.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * 医生登录管理表(doc1)
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class DoctorAccount extends GenericModel {

	private static final long serialVersionUID = -6858248700528852501L;
	/**
     * 医生代码
     */
    private Integer docid;
    /**
     * 组织代码
     */
    private Integer orgid;
    /**
     * 登录帐号
     */
    private String docacc;
    /**
     * 登录密码
     */
    private String docpass;
    /**
     * 登录角色：1管理员、6超级管理员、5金钥匙、其它是医生
     */
    private String logrole;
    /**
     * 标记  
     */
    private String tag;
    /**
     * 最近登入失败时间
     */
    private Date failtime;
    /**
     * 失败次数
     */
    private Integer failcount;
    private String lastloginaddr;
    private Date lastlogintime;
    
    /**
     * 医生信息
     */
    private Doctor doctor;
    
    /**
     * 角色对象
     */
    private Orol orol;
    
    public Orol getOrol() {
		return orol;
	}
	public void setOrol(Orol orol) {
		this.orol = orol;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Integer getDocid() {
        return docid;
    }
    public void setDocid(Integer docid) {
        this.docid = docid;
    }
    public Integer getOrgid() {
        return orgid;
    }
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }
    public String getDocacc() {
        return docacc;
    }
    public void setDocacc(String docacc) {
        this.docacc = docacc;
    }
    public String getDocpass() {
        return docpass;
    }
    public void setDocpass(String docpass) {
        this.docpass = docpass;
    }
    public String getLogrole() {
        return logrole;
    }
    public void setLogrole(String logrole) {
        this.logrole = logrole;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public Date getFailtime() {
        return failtime;
    }
    public void setFailtime(Date failtime) {
        this.failtime = failtime;
    }
    public Integer getFailcount() {
        return failcount;
    }
    public void setFailcount(Integer failcount) {
        this.failcount = failcount;
    }
    public String getLastloginaddr() {
        return lastloginaddr;
    }
    public void setLastloginaddr(String lastloginaddr) {
        this.lastloginaddr = lastloginaddr;
    }
    public Date getLastlogintime() {
        return lastlogintime;
    }
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }
}