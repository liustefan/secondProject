/*
 * ManageschemeExecTask.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.healthCore.managescheme.model;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.bithealth.healthCore.enmu.ConclusionTypeEnum;
import com.bithealth.healthCore.enmu.TaskExecStatusEnum;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * [3.0]管理方案_个人执行_任务
 * 
 * @author ${user}
 * @version 1.0 2016-12-08
 */
public class ManageschemeExecTask extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -4935794150212532704L;
	/**
     * 管理方案_个人执行_任务ID
     */
    private Long MSETaskID;
    /**
     * 管理方案_执行ID
     */
    private Integer MSExecID;
    /**
     * 管理方案_制定_任务ID
     */
    private Integer MSDTaskID;
    /**
     * 计划时间
     */
    private Date planTime;
    /**
     * 执行时间
     */
    private Date execTime;
    /**
     * 执行结果/总结
     */
    private String execResult;
    /**
     * 执行状态：1-待执行，2-已执行，3-已终止
     */
    private Byte execStatus;
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
    
    private ManageschemeDesignDetail designDetail;
    
    private Integer memberId;
    
    private String memName; 
    
    private String gender;
    
    private String tel;
    
    private String memberLabelIds;
    
    private Integer[] mLabelIds;
    
    private String memberLabelNames;
    
    private Integer memberDiseaseID;
    
    /**
     * 执行医生ID
     */
    private Integer execDrID;
    
    private Date planTimeS;
    
    private Date planTimeE;
    
    private ManageschemeDesignTask designTask;
    
    private Map<String, Object> ref;
    
    private Byte conclusionType;
    
    private ManageschemeExec exec;

    public Long getMSETaskID() {
        return MSETaskID;
    }
    public void setMSETaskID(Long MSETaskID) {
        this.MSETaskID = MSETaskID;
    }
    public Integer getMSExecID() {
        return MSExecID;
    }
    public void setMSExecID(Integer MSExecID) {
        this.MSExecID = MSExecID;
    }
    public Integer getMSDTaskID() {
        return MSDTaskID;
    }
    public void setMSDTaskID(Integer MSDTaskID) {
        this.MSDTaskID = MSDTaskID;
    }
    public Date getPlanTime() {
        return planTime;
    }
    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
    }
    public Date getExecTime() {
        return execTime;
    }
    public void setExecTime(Date execTime) {
        this.execTime = execTime;
    }
    public String getExecResult() {
        return execResult;
    }
    public void setExecResult(String execResult) {
        this.execResult = execResult;
    }
    public Byte getExecStatus() {
        return execStatus;
    }
    public String getExecStatusName() {
        return TaskExecStatusEnum.getEnumByCode(execStatus).getName();
    }
    public void setExecStatus(Byte execStatus) {
        this.execStatus = execStatus;
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
	 * design.
	 *
	 * @param   design    the design to set 
	 */
	public void setDesign(ManageschemeDesign design) {
		this.design = design;
	}
	/**
	 * designTask.
	 *
	 * @return  the designTask 
	 */
	public ManageschemeDesignTask getDesignTask() {
		return designTask;
	}
	/**
	 * designTask.
	 *
	 * @param   designTask    the designTask to set 
	 */
	public void setDesignTask(ManageschemeDesignTask designTask) {
		this.designTask = designTask;
	}
	/**
	 * memberId.
	 *
	 * @return  the memberId 
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * memberId.
	 *
	 * @param   memberId    the memberId to set 
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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
	 * execDrID.
	 *
	 * @return  the execDrID 
	 */
	public Integer getExecDrID() {
		return execDrID;
	}
	/**
	 * execDrID.
	 *
	 * @param   execDrID    the execDrID to set 
	 */
	public void setExecDrID(Integer execDrID) {
		this.execDrID = execDrID;
	}
	/**
	 * planTimeS.
	 *
	 * @return  the planTimeS 
	 */
	public Date getPlanTimeS() {
		return planTimeS;
	}
	/**
	 * planTimeS.
	 *
	 * @param   planTimeS    the planTimeS to set 
	 */
	public void setPlanTimeS(Date planTimeS) {
		this.planTimeS = planTimeS;
	}
	/**
	 * planTimeE.
	 *
	 * @return  the planTimeE 
	 */
	public Date getPlanTimeE() {
		return planTimeE;
	}
	/**
	 * planTimeE.
	 *
	 * @param   planTimeE    the planTimeE to set 
	 */
	public void setPlanTimeE(Date planTimeE) {
		this.planTimeE = planTimeE;
	}
	/**
	 * memberLabelIds.
	 *
	 * @return  the memberLabelIds 
	 */
	public String getMemberLabelIds() {
		return memberLabelIds;
	}
	/**
	 * mLabelIds.
	 *
	 * @return  the mLabelIds 
	 */
	public Integer[] getmLabelIds() {
		if(StringUtils.isNotEmpty(memberLabelIds)){
			String[] temp = memberLabelIds.split(",");
			this.mLabelIds = new Integer[temp.length];
			for (int i = 0; i < temp.length; i++) {
				this.mLabelIds[i] = Integer.parseInt(temp[i]);
			}
		}
		return this.mLabelIds;
	}
	/**
	 * memberLabelIds.
	 *
	 * @param   memberLabelIds    the memberLabelIds to set 
	 */
	public void setMemberLabelIds(String memberLabelIds) {
		this.memberLabelIds = memberLabelIds;
	}
	
	/**
	 * memberLabelNames.
	 *
	 * @return  the memberLabelNames 
	 */
	public String getMemberLabelNames() {
		return memberLabelNames;
	}
	/**
	 * memberLabelNames.
	 *
	 * @param   memberLabelNames    the memberLabelNames to set 
	 */
	public void setMemberLabelNames(String memberLabelNames) {
		this.memberLabelNames = memberLabelNames;
	}
	/**
	 * memberDiseaseID.
	 *
	 * @return  the memberDiseaseID 
	 */
	public Integer getMemberDiseaseID() {
		return memberDiseaseID;
	}
	/**
	 * memberDiseaseID.
	 *
	 * @param   memberDiseaseID    the memberDiseaseID to set 
	 */
	public void setMemberDiseaseID(Integer memberDiseaseID) {
		this.memberDiseaseID = memberDiseaseID;
	}
	/**
	 * ref.
	 *
	 * @return  the ref 
	 */
	public Map<String, Object> getRef() {
		return ref;
	}
	/**
	 * ref.
	 *
	 * @param   ref    the ref to set 
	 */
	public void setRef(Map<String, Object> ref) {
		this.ref = ref;
	}
	/**
	 * conclusionType.
	 *
	 * @return  the conclusionType 
	 */
	public Byte getConclusionType() {
		return conclusionType;
	}
	
	public String getConclusionTypeName() {
		ConclusionTypeEnum enm = ConclusionTypeEnum.getEnumByCode(conclusionType);
		return enm != null ? enm.getName() : null;
	}
	/**
	 * conclusionType.
	 *
	 * @param   conclusionType    the conclusionType to set 
	 */
	public void setConclusionType(Byte conclusionType) {
		this.conclusionType = conclusionType;
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
	
    
}