/*
 * HealthEducationDisease.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.cmsCore.healthEducation.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * [3.0]健教库_疾病关系
 * 
 * @author ${user}
 * @version 1.0 2016-11-29
 */
public class HealthEducationDisease extends GenericModel {

	private static final long serialVersionUID = 7783706174384027162L;
	/**
     * 记录ID
     */
    private Integer logid;
    /**
     * 管理方案_模板ID
     */
    private Integer heducationid;
    /**
     * 疾病ID
     */
    private Integer msdiseaseid;
    /**
     * 更新时间
     */
    private Date updatetime;
    
    private String diseaseName;
    
    public HealthEducationDisease() {
		super();
	}
	public HealthEducationDisease(Integer msdiseaseid) {
		super();
		this.msdiseaseid = msdiseaseid;
	}
	public Integer getLogid() {
        return logid;
    }
    public void setLogid(Integer logid) {
        this.logid = logid;
    }
    public Integer getHeducationid() {
        return heducationid;
    }
    public void setHeducationid(Integer heducationid) {
        this.heducationid = heducationid;
    }
    public Integer getMsdiseaseid() {
        return msdiseaseid;
    }
    public void setMsdiseaseid(Integer msdiseaseid) {
        this.msdiseaseid = msdiseaseid;
    }
    public Date getUpdatetime() {
        return updatetime;
    }
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
    
}