/*
 * Ocqt.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import java.util.Date;
import java.util.List;

import com.bithealth.questionCore.enmu.ComQuestionStatusEnum;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 组合问卷主表（OCQT）
 * 
 * @author ${user}
 * @version 1.0 2016-07-12
 */
public class Ocqt extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -3984134848957802137L;
	/**
     * 组合答卷ID
     */
    private Integer combQustid;
    /**
     * 组合问卷名称
     */
    private String combQustName;
    /**
     * 组合问卷编号
     */
    private Integer combQustCode;
    /**
     * 组合介绍
     */
    private String combDesc;
    /**
     * 是否审核
     */
    private String chTag;
    /**
     * 问卷状态
     */
    private String qustTag;
    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 创建医生ID
     */
    private Integer createid;
    /**
     * 创建医生名称
     */
    private String createName;
    /**
     * 组织代码
     */
    private Integer orgId;
    /**
     * 问卷版本号
     */
    private String qustVer;
    /**
     * 选项代码
     */
    private Short optId;
    
    private String optName;
    
    private Integer singleAnswerTotal;
    
    private List<Cqt1> cqt1s;

    public Integer getCombQustid() {
        return combQustid;
    }
    public void setCombQustid(Integer combQustid) {
        this.combQustid = combQustid;
    }
    public String getCombQustName() {
        return combQustName;
    }
    public void setCombQustName(String combQustName) {
        this.combQustName = combQustName;
    }
    public Integer getCombQustCode() {
        return combQustCode;
    }
    public void setCombQustCode(Integer combQustCode) {
        this.combQustCode = combQustCode;
    }
    public String getCombDesc() {
        return combDesc;
    }
    public void setCombDesc(String combDesc) {
        this.combDesc = combDesc;
    }
    public String getChTag() {
        return chTag;
    }
    public void setChTag(String chTag) {
        this.chTag = chTag;
    }
    public String getQustTag() {
        return qustTag;
    }
    public void setQustTag(String qustTag) {
        this.qustTag = qustTag;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Integer getCreateid() {
        return createid;
    }
    public void setCreateid(Integer createid) {
        this.createid = createid;
    }
    public String getCreateName() {
        return createName;
    }
    public void setCreateName(String createName) {
        this.createName = createName;
    }
    public Integer getOrgId() {
        return orgId;
    }
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    public String getQustVer() {
        return qustVer;
    }
    public void setQustVer(String qustVer) {
        this.qustVer = qustVer;
    }
    public Short getOptId() {
        return optId;
    }
    public void setOptId(Short optId) {
        this.optId = optId;
    }
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
	}
	public Integer getSingleAnswerTotal() {
		return singleAnswerTotal;
	}
	public void setSingleAnswerTotal(Integer singleAnswerTotal) {
		this.singleAnswerTotal = singleAnswerTotal;
	}
	public List<Cqt1> getCqt1s() {
		return cqt1s;
	}
	public void setCqt1s(List<Cqt1> cqt1s) {
		this.cqt1s = cqt1s;
	}
	public boolean isValid(){
		return ComQuestionStatusEnum.VALID.getCode().equals(this.qustTag);
	}
}