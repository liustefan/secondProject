/*
 * ManageschemeTempletTask.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-06 Created
 */
package com.bithealth.healthCore.templet.model;

import java.util.Date;
import java.util.Map;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * [3.0]管理方案_模板_任务
 * 
 * @author ${user}
 * @version 1.0 2016-12-06
 */
public class ManageschemeTempletTask extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 2527365477372248386L;
	/**
     * 管理方案_模板_任务ID
     */
    private Integer MSTTaskID;
    /**
     * 管理方案_模板ID
     */
    private Integer MSTempletID;
    /**
     * 计划时间数值(基准时间后)
     */
    private Short planTimeValue;
    /**
     * 计划时间的类型：1-天，2-周，3-月，4-年
     */
    private Byte planTimeType;
    /**
     * 任务类型：1-健教，2-复诊，3-测量，4-问卷调查，5-高血压随访(公卫)，6-糖尿病随访(公卫)，7-阶段总结
     */
    private Byte taskType;
    
    private Long taskRefID;
    /**
     * 执行方式：1-医生电话服务，2-医生现场服务，3-推送消息给会员
     */
    private Byte execWay;
    /**
     * 任务概述
     */
    private String summary;
    /**
     * 详情内容/任务说明/问卷ID
     */
    private String content;
    /**
     * 创建医生ID
     */
    private Integer createID;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新医生ID
     */
    private Integer updateID;
    /**
     * 更新时间
     */
    private Date updateTime;
    
    private Map<String, Object> taskRef;

    public Integer getMSTTaskID() {
        return MSTTaskID;
    }
    public void setMSTTaskID(Integer MSTTaskID) {
        this.MSTTaskID = MSTTaskID;
    }
    public Integer getMSTempletID() {
        return MSTempletID;
    }
    public void setMSTempletID(Integer MSTempletID) {
        this.MSTempletID = MSTempletID;
    }
    public Short getPlanTimeValue() {
        return planTimeValue;
    }
    public void setPlanTimeValue(Short planTimeValue) {
        this.planTimeValue = planTimeValue;
    }
    public Byte getPlanTimeType() {
        return planTimeType;
    }
    public void setPlanTimeType(Byte planTimeType) {
        this.planTimeType = planTimeType;
    }
    public Byte getTaskType() {
        return taskType;
    }
    public void setTaskType(Byte taskType) {
        this.taskType = taskType;
    }
    public Byte getExecWay() {
        return execWay;
    }
    public void setExecWay(Byte execWay) {
        this.execWay = execWay;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getCreateID() {
        return createID;
    }
    public void setCreateID(Integer createID) {
        this.createID = createID;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getUpdateID() {
        return updateID;
    }
    public void setUpdateID(Integer updateID) {
        this.updateID = updateID;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
	/**
	 * taskRef.
	 *
	 * @return  the taskRef 
	 */
	public Map<String, Object> getTaskRef() {
		return taskRef;
	}
	/**
	 * taskRef.
	 *
	 * @param   taskRef    the taskRef to set 
	 */
	public void setTaskRef(Map<String, Object> taskRef) {
		this.taskRef = taskRef;
	}
	/**
	 * taskRefID.
	 *
	 * @return  the taskRefID 
	 */
	public Long getTaskRefID() {
		return taskRefID;
	}
	/**
	 * taskRefID.
	 *
	 * @param   taskRefID    the taskRefID to set 
	 */
	public void setTaskRefID(Long taskRefID) {
		this.taskRefID = taskRefID;
	}
	
	
    
}