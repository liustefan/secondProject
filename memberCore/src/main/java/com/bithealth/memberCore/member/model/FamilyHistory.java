/*
 * FamilyHistory.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-09 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * [2.1]会员家族史表
 * 
 * @author ${user}
 * @version 1.0 2016-09-09
 */
public class FamilyHistory extends GenericModel {

	private static final long serialVersionUID = 8456443878731694686L;
	/**
     * 记录ID
     */
    private Long logID;
    /**
     * 关系：1-父亲，2-母亲，3-子女，4-兄弟姐妹
     */
    private Byte relation;
    /**
     * 会员ID
     */
    private Integer memberID;
    /**
     * 疾病ID，来源字典
     */
    private Integer diseaseID;
    /**
     * 其它疾病名称
     */
    private String diseaseName;
    /**
     * 创建时间
     */
    private Date createTime;
    
    public FamilyHistory(){
    	
    }

    public FamilyHistory(Integer memberID, Byte relation) {
    	this.memberID = memberID;
    	this.relation = relation;
    }
    public Long getLogID() {
        return logID;
    }
    public void setLogID(Long logID) {
        this.logID = logID;
    }
    public Byte getRelation() {
        return relation;
    }
    public void setRelation(Byte relation) {
        this.relation = relation;
    }
    public Integer getMemberID() {
        return memberID;
    }
    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }
    public Integer getDiseaseID() {
        return diseaseID;
    }
    public void setDiseaseID(Integer diseaseID) {
        this.diseaseID = diseaseID;
    }
    public String getDiseaseName() {
        return diseaseName;
    }
    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}