/*
 * ManageschemeTempletDisease.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.healthCore.templet.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * [3.0]管理方案_模板_疾病关系
 * 
 * @author ${user}
 * @version 1.0 2016-11-29
 */
public class ManageschemeTempletDisease extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 52686415420189639L;
	/**
     * 记录ID
     */
    private Integer logID;
    /**
     * 管理方案_模板ID
     */
    private Integer MSTempletID;
    /**
     * 疾病ID
     */
    private Integer MSDiseaseID;
    /**
     * 更新时间
     */
    private Date updateTime;
    
    private String diseaseName;
    
    public ManageschemeTempletDisease(){}
    
    public ManageschemeTempletDisease(Integer MSDiseaseID){
    	this.MSDiseaseID = MSDiseaseID;
    }

    public Integer getLogID() {
        return logID;
    }
    public void setLogID(Integer logID) {
        this.logID = logID;
    }
    public Integer getMSTempletID() {
        return MSTempletID;
    }
    public void setMSTempletID(Integer MSTempletID) {
        this.MSTempletID = MSTempletID;
    }
    public Integer getMSDiseaseID() {
        return MSDiseaseID;
    }
    public void setMSDiseaseID(Integer MSDiseaseID) {
        this.MSDiseaseID = MSDiseaseID;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
	/**
	 * diseaseName.
	 *
	 * @return  the diseaseName 
	 */
	public String getDiseaseName() {
		return diseaseName;
	}
	/**
	 * diseaseName.
	 *
	 * @param   diseaseName    the diseaseName to set 
	 */
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
    
}