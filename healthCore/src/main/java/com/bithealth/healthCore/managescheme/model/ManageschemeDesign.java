/*
 * ManageschemeDesign.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.healthCore.managescheme.model;

import java.util.Date;
import java.util.List;

import com.bithealth.healthCore.enmu.GroupManageschemeEnum;
import com.bithealth.healthCore.enmu.MassEffectProcessEnum;
import com.bithealth.healthCore.enmu.SchemeTypeEnum;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * [3.0]管理方案_制定
 * 
 * @author ${user}
 * @version 1.0 2016-12-08
 */
public class ManageschemeDesign extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 6270688127030808390L;
	/**
     * 管理方案_制定ID
     */
    private Integer MSDesignID;
    /**
     * 方案类型：1-个人，2-群体
     */
    private Byte schemeType;
    /**
     * 方案标题
     */
    private String schemeTitle;
    /**
     * 群体状态：1-制定中，2-已生效，3-已终止
     */
    private Byte massStatus;
    /**
     * 生效时间
     */
    private Date massEffectTime;
    /**
     * 群体终止时间
     */
    private Date massOffTime;
    /**
     * 群体终止原因
     */
    private String massOffReason;
    /**
     * 群体为已生效的总处理过程；1-未触发，2-生成中，3-完成，4-失败
     */
    private Byte massEffectProcess;
    /**
     * 执行医生ID
     */
    private Integer execDrID;
    
    private String execDrName;
    
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
    
    private Date createTimeS;
     
    private Date createTimeE;
    
    private ManageschemeDesignDetail designDetail;
    
    private List<ManageschemeDesignTask> designTasks;
    
    /** 个人方案*/
    private ManageschemeExec exec;
    
    private Integer referenceId;
    
    private String tasks;
    
    public Integer getMSDesignID() {
        return MSDesignID;
    }
    public void setMSDesignID(Integer MSDesignID) {
        this.MSDesignID = MSDesignID;
    }
    public Byte getSchemeType() {
        return schemeType;
    }
    public String getSchemeTypeName() {
        return SchemeTypeEnum.getEnumByCode(schemeType).getName();
    }
    public void setSchemeType(Byte schemeType) {
        this.schemeType = schemeType;
    }
    public String getSchemeTitle() {
        return schemeTitle;
    }
    public void setSchemeTitle(String schemeTitle) {
        this.schemeTitle = schemeTitle;
    }
    public Byte getMassStatus() {
        return massStatus;
    }
    public String getMassStatusName() {
    	GroupManageschemeEnum enu = GroupManageschemeEnum.getEnumByCode(this.massStatus);
    	if(enu != null)
    		return enu.getName();
    	else
    		return null;
    }
    public void setMassStatus(Byte massStatus) {
        this.massStatus = massStatus;
    }
    public Date getMassEffectTime() {
        return massEffectTime;
    }
    public void setMassEffectTime(Date massEffectTime) {
        this.massEffectTime = massEffectTime;
    }
	/**
	 * massOffTime.
	 *
	 * @return  the massOffTime 
	 */
	public Date getMassOffTime() {
		return massOffTime;
	}
	/**
	 * massOffTime.
	 *
	 * @param   massOffTime    the massOffTime to set 
	 */
	public void setMassOffTime(Date massOffTime) {
		this.massOffTime = massOffTime;
	}
	public String getMassOffReason() {
        return massOffReason;
    }
    public void setMassOffReason(String massOffReason) {
        this.massOffReason = massOffReason;
    }
    public Byte getMassEffectProcess() {
        return massEffectProcess;
    }
    public String getMassEffectProcessName() {
    	if(this.massEffectProcess != null)
    		return MassEffectProcessEnum.getEnumByCode(this.massEffectProcess).getName();
    	else
    		return null;
    }
    public void setMassEffectProcess(Byte massEffectProcess) {
        this.massEffectProcess = massEffectProcess;
    }
    public Integer getExecDrID() {
        return execDrID;
    }
    public void setExecDrID(Integer execDrID) {
        this.execDrID = execDrID;
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
	 * createTimeS.
	 *
	 * @return  the createTimeS 
	 */
	public Date getCreateTimeS() {
		return createTimeS;
	}
	/**
	 * createTimeS.
	 *
	 * @param   createTimeS    the createTimeS to set 
	 */
	public void setCreateTimeS(Date createTimeS) {
		this.createTimeS = createTimeS;
	}
	/**
	 * createTimeE.
	 *
	 * @return  the createTimeE 
	 */
	public Date getCreateTimeE() {
		return createTimeE;
	}
	/**
	 * createTimeE.
	 *
	 * @param   createTimeE    the createTimeE to set 
	 */
	public void setCreateTimeE(Date createTimeE) {
		this.createTimeE = createTimeE;
	}
	/**
	 * designDetail.
	 *
	 * @return  the designDetail 
	 */
	public ManageschemeDesignDetail getDesignDetail() {
		return designDetail;
	}
	/**
	 * designDetail.
	 *
	 * @param   designDetail    the designDetail to set 
	 */
	public void setDesignDetail(ManageschemeDesignDetail designDetail) {
		this.designDetail = designDetail;
	}
	/**
	 * designTasks.
	 *
	 * @return  the designTasks 
	 */
	public List<ManageschemeDesignTask> getDesignTasks() {
		return designTasks;
	}
	/**
	 * designTasks.
	 *
	 * @param   designTasks    the designTasks to set 
	 */
	public void setDesignTasks(List<ManageschemeDesignTask> designTasks) {
		this.designTasks = designTasks;
	}
	/**
	 * exec.
	 *
	 * @return  the exec 
	 */
	public ManageschemeExec getExec() {
		return exec;
	}
	/**
	 * exec.
	 *
	 * @param   exec    the exec to set 
	 */
	public void setExec(ManageschemeExec exec) {
		this.exec = exec;
	}
	/**
	 * referenceId.
	 *
	 * @return  the referenceId 
	 */
	public Integer getReferenceId() {
		return referenceId;
	}
	/**
	 * referenceId.
	 *
	 * @param   referenceId    the referenceId to set 
	 */
	public void setReferenceId(Integer referenceId) {
		this.referenceId = referenceId;
	}
	/**
	 * execDrName.
	 *
	 * @return  the execDrName 
	 */
	public String getExecDrName() {
		return execDrName;
	}
	/**
	 * execDrName.
	 *
	 * @param   execDrName    the execDrName to set 
	 */
	public void setExecDrName(String execDrName) {
		this.execDrName = execDrName;
	}
	/**
	 * tasks.
	 *
	 * @return  the tasks 
	 */
	public String getTasks() {
		return tasks;
	}
	/**
	 * tasks.
	 *
	 * @param   tasks    the tasks to set 
	 */
	public void setTasks(String tasks) {
		this.tasks = tasks;
	}
	
}