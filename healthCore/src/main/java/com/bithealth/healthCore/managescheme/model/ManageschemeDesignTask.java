/*
 * ManageschemeDesignTask.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.healthCore.managescheme.model;

import com.bithealth.healthCore.enmu.ExecuteWayEnum;
import com.bithealth.healthCore.enmu.TaskTypeEnum;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;

/**
 * [3.0]管理方案_制定_任务
 * 
 * @author ${user}
 * @version 1.0 2016-12-08
 */
public class ManageschemeDesignTask extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 7349907135172492136L;
	/**
     * 管理方案_制定_任务ID
     */
    private Integer MSDTaskID;
    /**
     * 管理方案_制定ID
     */
    private Integer MSDesignID;
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
    
    private Byte excludeExecWay;
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
    
    private ManageschemeDesign design;
    
    private ManageschemeExecTask execTask;
    
    private Map<String, Object> taskRef;

    /**
     * 计划时间
     */
    private Date planTime;
    
    public Integer getMSDTaskID() {
        return MSDTaskID;
    }
    public void setMSDTaskID(Integer MSDTaskID) {
        this.MSDTaskID = MSDTaskID;
    }
    public Integer getMSDesignID() {
        return MSDesignID;
    }
    public void setMSDesignID(Integer MSDesignID) {
        this.MSDesignID = MSDesignID;
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
    public String getTaskTypeName() {
        return TaskTypeEnum.getEnumByCode(this.taskType).getName();
    }
    public void setTaskType(Byte taskType) {
        this.taskType = taskType;
    }
    public Byte getExecWay() {
    	if(!TaskTypeEnum.SUMMARY.getCode().equals(this.taskType))
    		return execWay;
    	else
    		return null;
    }
    public String getExecWayName() {
    	ExecuteWayEnum eum = ExecuteWayEnum.getEnumByCode(this.getExecWay());
        return eum != null ? eum.getName() : null;
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
	 * execTask.
	 *
	 * @return  the execTask 
	 */
	public ManageschemeExecTask getExecTask() {
		return execTask;
	}
	/**
	 * execTask.
	 *
	 * @param   execTask    the execTask to set 
	 */
	public void setExecTask(ManageschemeExecTask execTask) {
		this.execTask = execTask;
	}
	/**
	 * design.
	 *
	 * @return  the design 
	 */
	public ManageschemeDesign getDesign() {
		return design;
	}
	/**
	 * design.
	 *
	 * @param   design    the design to set 
	 */
	public void setDesign(ManageschemeDesign design) {
		this.design = design;
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
	 * excludeExecWay.
	 *
	 * @return  the excludeExecWay 
	 */
	public Byte getExcludeExecWay() {
		return excludeExecWay;
	}
	/**
	 * excludeExecWay.
	 *
	 * @param   excludeExecWay    the excludeExecWay to set 
	 */
	public void setExcludeExecWay(Byte excludeExecWay) {
		this.excludeExecWay = excludeExecWay;
	}
	
	/**
	 * 
	 * @Title:calculatePlanTime 
	 * @Description: 计算任务计划执行时间
	 * TODO  
	 * @author baozj
	 * @param planTimeType
	 * @return 
	 * @throws
	 * @retrun Date
	 */
	public static Date calculatePlanTime(Byte planTimeType, Short planTimeValue){
		Date planTime = null;
		if(planTimeType != null && planTimeValue != null){
			switch (planTimeType) {
				case 1:
					planTime = DateUtils.addDays(TimeUtil.now(), planTimeValue);
					break;
				case 2:
					planTime = DateUtils.addWeeks(TimeUtil.now(), planTimeValue);
					break;
				case 3:
					planTime = DateUtils.addMonths(TimeUtil.now(), planTimeValue);
					break;
				case 4:
					planTime = DateUtils.addYears(TimeUtil.now(), planTimeValue);
					break;
			}
		}
		return planTime;
	}
	
	public Date getPlanTime() {
		if(this.planTime == null)
			return calculatePlanTime(this.planTimeType, this.planTimeValue);
		else
			return this.planTime;
    }
	/**
	 * planTime.
	 *
	 * @param   planTime    the planTime to set 
	 */
	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}
	
	
	
}