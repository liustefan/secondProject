/*
 * Omfq.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.bithealth.questionCore.answer.model.Uai21;
import com.bithealth.questionCore.enmu.SingleQuestionStatusEnum;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 问卷信息主表（OMFQ)
 * 
 * @author ${user}
 * @version 1.0 2016-07-12
 */
public class Omfq extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 4242568945191538731L;
	/**
     * 问卷ID号
     */
    private Integer qustid;
    /**
     * 选项代码
     */
    private Short optId;
    /**
     * 功能代码
     */
    private Short funId;
    /**
     * 组织代码
     */
    private Integer orgId;
    /**
     * 问卷编号
     */
    private String qustCode;
    /**
     * 问卷名称
     */
    private String qustname;
    /**
     * 回答方式
     */
    private String ansMode;
    /**
     * 简单介绍
     */
    private String desription;
    /**
     * 问卷版本号
     */
    private String qustVer;
    /**
     * 问卷说明
     */
    private String qustDesc;
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
     * 应用范围：1-全局，2-组织内共享(管理员)，3-组织内共享(医生)
     */
    private Byte useRange;
    
    private String optName;
    
    private List<Mfq1> mfq1s = new ArrayList<Mfq1>();
    
    private Mfq2 mfq2;
    
    private List<Mfq21> mfq21s;
    
    private String qustNameType;
    
    private String orgName;
    
    private String superOrgIds;
    
    public Integer getQustid() {
        return qustid;
    }
    public void setQustid(Integer qustid) {
        this.qustid = qustid;
    }
    public Short getOptId() {
        return optId;
    }
    public void setOptId(Short optId) {
        this.optId = optId;
    }
    public Short getFunId() {
        return funId;
    }
    public void setFunId(Short funId) {
        this.funId = funId;
    }
    public Integer getOrgId() {
        return orgId;
    }
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    public String getQustCode() {
        return qustCode;
    }
    public void setQustCode(String qustCode) {
        this.qustCode = qustCode;
    }
    public String getQustname() {
        return qustname;
    }
    public void setQustname(String qustname) {
        this.qustname = qustname;
    }
    public String getAnsMode() {
        return ansMode;
    }
    public void setAnsMode(String ansMode) {
        this.ansMode = ansMode;
    }
    public String getDesription() {
        return desription;
    }
    public void setDesription(String desription) {
        this.desription = desription;
    }
    public String getQustVer() {
        return qustVer;
    }
    public void setQustVer(String qustVer) {
        this.qustVer = qustVer;
    }
    public String getQustDesc() {
        return qustDesc;
    }
    public void setQustDesc(String qustDesc) {
        this.qustDesc = qustDesc;
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
	public Byte getUseRange() {
		return useRange;
	}
	public void setUseRange(Byte useRange) {
		this.useRange = useRange;
	}
	public List<Mfq1> getMfq1s() {
		return mfq1s;
	}
	public void setMfq1s(List<Mfq1> mfq1s) {
		this.mfq1s = mfq1s;
	}
	
	public Mfq2 getMfq2() {
		return mfq2;
	}
	public void setMfq2(Mfq2 mfq2) {
		this.mfq2 = mfq2;
	}
	public List<Mfq21> getMfq21s() {
		return mfq21s;
	}
	public void setMfq21s(List<Mfq21> mfq21s) {
		this.mfq21s = mfq21s;
	}
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
	}
	@JSONField(serialize = false)
	public boolean isValid(){
		return SingleQuestionStatusEnum.VALID.getCode().equals(this.qustTag);
	}
	public String getQustNameType() {
		return qustNameType;
	}
	public void setQustNameType(String qustNameType) {
		this.qustNameType = qustNameType;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
	/**
	 * superOrgIds.
	 *
	 * @return  the superOrgIds 
	 */
	public String getSuperOrgIds() {
		return superOrgIds;
	}
	/**
	 * superOrgIds.
	 *
	 * @param   superOrgIds    the superOrgIds to set 
	 */
	public void setSuperOrgIds(String superOrgIds) {
		this.superOrgIds = superOrgIds;
	}
	public void setAnswer(List<Uai21> uai21s){
		if(uai21s != null && uai21s.size() > 0 && mfq1s != null && mfq1s.size() > 0){
			for(Iterator<Mfq1> mIt = mfq1s.iterator(); mIt.hasNext();){
				Mfq1 question = mIt.next();
				for(Iterator<Uai21> uIt = uai21s.iterator(); uIt.hasNext();){
					Uai21 answer = uIt.next();
					if(question.getProblemid().equals(answer.getProblemid())){
						if(question.getUai21s() == null)
							question.setUai21s(new ArrayList<Uai21>());
						question.getUai21s().add(answer);
					}
				}
			}
		}
	}
	
}