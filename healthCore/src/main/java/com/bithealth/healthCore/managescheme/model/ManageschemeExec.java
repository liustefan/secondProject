/*
 * ManageschemeExec.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.healthCore.managescheme.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bithealth.healthCore.enmu.MassEffectProcessEnum;
import com.bithealth.healthCore.enmu.PersonManageschemeEnum;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * [3.0]管理方案_个人执行
 * 
 * @author ${user}
 * @version 1.0 2016-12-08
 */
public class ManageschemeExec extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -4914346220120182880L;
	/**
     * 管理方案_个人执行ID
     */
    private Long MSExecID;
    /**
     * 管理方案_制定ID
     */
    private Integer MSDesignID;
    /**
     * 会员ID
     */
    private Integer memberID;
    /**
     * 执行状态：1-制定中，2-执行中，3-无任务，4-已终止
     */
    private Byte execStatus;
    /**
     * 执行终止时间
     */
    private Date execOffTime;
    /**
     * 执行终止原因
     */
    private String execOffReason;
    /**
     * 群体为已生效的个人处理过程；1-未触发，2-生成中，3-完成，4-失败
     */
    private Byte MEPersonProcess;
    /**
     * 群体为已生效的个人触发时间
     */
    private Date MEPTriggerTime;
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
    
    private String memName; 
    
    private String gender;
    
    private String tel;
    
    private List<String> memberLabels;
    
    private Date createTimeS;
    
    private Date createTimeE;
    
    private String createName;
    
    private List<ManageschemeExecTask> execTasks;
    
    private String updateName;

    public Long getMSExecID() {
        return MSExecID;
    }
    public void setMSExecID(Long MSExecID) {
        this.MSExecID = MSExecID;
    }
    public Integer getMSDesignID() {
        return MSDesignID;
    }
    public void setMSDesignID(Integer MSDesignID) {
        this.MSDesignID = MSDesignID;
    }
    public Integer getMemberID() {
        return memberID;
    }
    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }
    public Byte getExecStatus() {
        return execStatus;
    }
    public String getExecStatusName() {
        return PersonManageschemeEnum.getEnumByCode(this.execStatus).getName();
    }
    public void setExecStatus(Byte execStatus) {
        this.execStatus = execStatus;
    }
    /**
	 * execOffTime.
	 *
	 * @return  the execOffTime 
	 */
	public Date getExecOffTime() {
		return execOffTime;
	}
	/**
	 * execOffTime.
	 *
	 * @param   execOffTime    the execOffTime to set 
	 */
	public void setExecOffTime(Date execOffTime) {
		this.execOffTime = execOffTime;
	}
	public String getExecOffReason() {
        return execOffReason;
    }
    public void setExecOffReason(String execOffReason) {
        this.execOffReason = execOffReason;
    }
    public Byte getMEPersonProcess() {
        return MEPersonProcess;
    }
    public String getMEPersonProcessName() {
    	MassEffectProcessEnum enm = MassEffectProcessEnum.getEnumByCode(this.MEPersonProcess);
        return enm != null ? enm.getName() : null;
    }
    public void setMEPersonProcess(Byte MEPersonProcess) {
        this.MEPersonProcess = MEPersonProcess;
    }
    public Date getMEPTriggerTime() {
        return MEPTriggerTime;
    }
    public void setMEPTriggerTime(Date MEPTriggerTime) {
        this.MEPTriggerTime = MEPTriggerTime;
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
	 * memName.
	 *
	 * @return  the memName 
	 */
	public String getMemName() {
		return memName;
	}
	/**
	 * memName.
	 *
	 * @param   memName    the memName to set 
	 */
	public void setMemName(String memName) {
		this.memName = memName;
	}
	/**
	 * gender.
	 *
	 * @return  the gender 
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * gender.
	 *
	 * @param   gender    the gender to set 
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * tel.
	 *
	 * @return  the tel 
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * tel.
	 *
	 * @param   tel    the tel to set 
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * memberLabels.
	 *
	 * @return  the memberLabels 
	 */
	public List<String> getMemberLabels() {
		return memberLabels;
	}
	public String getMemberLabelsStr() {
		return StringUtils.join(memberLabels, ',');
	}
	/**
	 * memberLabels.
	 *
	 * @param   memberLabels    the memberLabels to set 
	 */
	public void setMemberLabels(List<String> memberLabels) {
		this.memberLabels = memberLabels;
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
	 * execTasks.
	 *
	 * @return  the execTasks 
	 */
	public List<ManageschemeExecTask> getExecTasks() {
		return execTasks;
	}
	/**
	 * execTasks.
	 *
	 * @param   execTasks    the execTasks to set 
	 */
	public void setExecTasks(List<ManageschemeExecTask> execTasks) {
		this.execTasks = execTasks;
	}
	/**
	 * createName.
	 *
	 * @return  the createName 
	 */
	public String getCreateName() {
		return createName;
	}
	/**
	 * createName.
	 *
	 * @param   createName    the createName to set 
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	/**
	 * updateName.
	 *
	 * @return  the updateName 
	 */
	public String getUpdateName() {
		return updateName;
	}
	/**
	 * updateName.
	 *
	 * @param   updateName    the updateName to set 
	 */
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
    
	
}