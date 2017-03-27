/*
 * Doctor.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.doctor.model;

import com.bithealth.doctorCore.doctor.model.DoctorAccount;
import com.bithealth.doctorCore.doctor.model.DoctorScore;
import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 医生档案(ODOC)
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class Doctor extends GenericModel {

	private static final long serialVersionUID = 7800290334469314479L;
	/**
     * 医生代码
     */
    private Integer docid;
    /**
     * 角色代码
     */
    private Short roleid;
    /**
     * 组织代码
     */
    private Integer orgid;
    /**
     * 医生姓名
     */
    private String docname;
    /**
     * 职称
     */
    private String title;
    /**
     * 性别
     */
    private String gender;
    /**
     * 出生年月
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    /**
     * 联系电话
     */
    private String contacttel;
    /**
     * 手机号码
     */
    private String tel;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 家庭地址
     */
    private String homeaddress;
    /**
     * 工作单位
     */
    private String workaddress;
    /**
     * 单位地址
     */
    private String unitaddress;
    /**
     * 户口地址
     */
    private String resideaddress;
    /**
     * 证件类型
     */
    private String certitype;
    /**
     * 证件号码
     */
    private String certinum;
    /**
     * 微信号
     */
    private String weixin;
    /**
     * 简介
     */
    private String desription;
    /**
     * 工作科室
     */
    private String workdepart;
    /**
     * 头像地址
     */
    private String headaddress;
    /**
     * 签名地址
     */
    private String signaddress;
    /**
     * 状态
     */
    private String tag;
    
    private String docGUID;
    
    /**
     * 医生账号
     */
    private DoctorAccount doctorAccount;
    
    /**
     * 登录session对象
     */
    private DoctorSession doctorSession;
    
    /**
     * 医生积分
     */
    private DoctorScore doctorScore;
    
    /**
     * 角色对象
     */
    private Orol orol;
    
    /**
     * 组织名
     */
    private String orgName;
    
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Orol getOrol() {
		return orol;
	}

	public void setOrol(Orol orol) {
		this.orol = orol;
	}

	public DoctorAccount getDoctorAccount() {
		return doctorAccount;
	}

	public void setDoctorAccount(DoctorAccount doctorAccount) {
		this.doctorAccount = doctorAccount;
	}
	
	public DoctorScore getDoctorScore() {
		return doctorScore;
	}

	public void setDoctorScore(DoctorScore doctorScore) {
		this.doctorScore = doctorScore;
	}

    public DoctorSession getDoctorSession() {
		return doctorSession;
	}

	public void setDoctorSession(DoctorSession doctorSession) {
		this.doctorSession = doctorSession;
	}

	public Integer getDocid() {
        return docid;
    }
    public void setDocid(Integer docid) {
        this.docid = docid;
    }
    public Short getRoleid() {
        return roleid;
    }
    public void setRoleid(Short roleid) {
        this.roleid = roleid;
    }
    public Integer getOrgid() {
        return orgid;
    }
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }
    public String getDocname() {
        return docname;
    }
    public void setDocname(String docname) {
        this.docname = docname;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    public String getContacttel() {
        return contacttel;
    }
    public void setContacttel(String contacttel) {
        this.contacttel = contacttel;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getHomeaddress() {
        return homeaddress;
    }
    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }
    public String getWorkaddress() {
        return workaddress;
    }
    public void setWorkaddress(String workaddress) {
        this.workaddress = workaddress;
    }
    public String getUnitaddress() {
        return unitaddress;
    }
    public void setUnitaddress(String unitaddress) {
        this.unitaddress = unitaddress;
    }
    public String getResideaddress() {
        return resideaddress;
    }
    public void setResideaddress(String resideaddress) {
        this.resideaddress = resideaddress;
    }
    public String getCertitype() {
        return certitype;
    }
    public void setCertitype(String certitype) {
        this.certitype = certitype;
    }
    public String getCertinum() {
        return certinum;
    }
    public void setCertinum(String certinum) {
        this.certinum = certinum;
    }
    public String getWeixin() {
        return weixin;
    }
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }
    public String getDesription() {
        return desription;
    }
    public void setDesription(String desription) {
        this.desription = desription;
    }
    public String getWorkdepart() {
        return workdepart;
    }
    public void setWorkdepart(String workdepart) {
        this.workdepart = workdepart;
    }
    public String getHeadaddress() {
        return headaddress;
    }
    public void setHeadaddress(String headaddress) {
        this.headaddress = headaddress;
    }
    public String getSignaddress() {
        return signaddress;
    }
    public void setSignaddress(String signaddress) {
        this.signaddress = signaddress;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }

	public String getDocGUID() {
		return docGUID;
	}

	public void setDocGUID(String docGUID) {
		this.docGUID = docGUID;
	}
}