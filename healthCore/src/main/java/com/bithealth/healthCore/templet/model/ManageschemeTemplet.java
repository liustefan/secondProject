/*
 * ManageschemeTemplet.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.healthCore.templet.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bithealth.healthCore.enmu.TempletStatusEnum;
import com.bithealth.healthCore.enmu.UseRangeEnum;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * [3.0]管理方案_模板
 * 
 * @author ${user}
 * @version 1.0 2016-11-29
 */
public class ManageschemeTemplet extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 287017317376233512L;
	/**
     * 管理方案_模板ID
     */
    private Integer MSTempletID;
    /**
     * 方案标题
     */
    private String schemeTitle;
    /**
     * 总体管理目标
     */
    private String manageGoal;
    /**
     * 基准时间：1-方案触发时间
     */
    private Byte benchmarkTime;
    /**
     * 服务期限数值
     */
    private Byte srvLimitValue;
    /**
     * 服务期限类型：1-天，2-周，3-月，4-年
     */
    private Byte srvLimitType;
    /**
     * 是否收费：0-否，1-是
     */
    private Byte isCharge;
    /**
     * 收费价格(元)
     */
    private BigDecimal price;
    /**
     * 附件显示名称
     */
    private String fileName;
    /**
     * 附件路径+文件名
     */
    private String filePath;
    /**
     * 方案介绍
     */
    private String introduction;
    /**
     * 被使用次数
     */
    private Integer usedNumber;
    /**
     * 状态：1-新增，2-生效，3-作废，4-删除
     */
    private Byte templetStatus;
    /**
     * 组织ID
     */
    private Integer orgID;
    /**
     * 使用范围：1-全局，2-组织内，3-私有
     */
    private Byte useRange;
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
    
    private String updateName;
    
    private Date updateTimeS;
    
    private Date updateTimeE;
    
    private Integer MSDiseaseID;
    
    private List<ManageschemeTempletDisease> diseases; 
    
    private List<ManageschemeTempletTask> tasks;
    
    private MultipartFile file;
    
    private String superOrgIds;
    
    private Integer roleId;
    
    private Integer referenceId;
    
    private String MSDiseaseIDs;
    
    private String MSDiseaseName;
    
    public Integer getMSTempletID() {
        return MSTempletID;
    }
    public void setMSTempletID(Integer MSTempletID) {
        this.MSTempletID = MSTempletID;
    }
    public String getSchemeTitle() {
        return schemeTitle;
    }
    public void setSchemeTitle(String schemeTitle) {
        this.schemeTitle = schemeTitle;
    }
    public String getManageGoal() {
        return manageGoal;
    }
    public void setManageGoal(String manageGoal) {
        this.manageGoal = manageGoal;
    }
    public Byte getBenchmarkTime() {
        return benchmarkTime;
    }
    public void setBenchmarkTime(Byte benchmarkTime) {
        this.benchmarkTime = benchmarkTime;
    }
    public Byte getSrvLimitValue() {
        return srvLimitValue;
    }
    public void setSrvLimitValue(Byte srvLimitValue) {
        this.srvLimitValue = srvLimitValue;
    }
    public Byte getSrvLimitType() {
        return srvLimitType;
    }
    public void setSrvLimitType(Byte srvLimitType) {
        this.srvLimitType = srvLimitType;
    }
    public Byte getIsCharge() {
        return isCharge;
    }
    public void setIsCharge(Byte isCharge) {
        this.isCharge = isCharge;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public Integer getUsedNumber() {
        return usedNumber;
    }
    public void setUsedNumber(Integer usedNumber) {
        this.usedNumber = usedNumber;
    }
    public Byte getTempletStatus() {
        return templetStatus;
    }
    public void setTempletStatus(Byte templetStatus) {
        this.templetStatus = templetStatus;
    }
    public Integer getOrgID() {
        return orgID;
    }
    public void setOrgID(Integer orgID) {
        this.orgID = orgID;
    }
    public Byte getUseRange() {
        return useRange;
    }
    public void setUseRange(Byte useRange) {
        this.useRange = useRange;
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
	 * diseases.
	 *
	 * @return  the diseases 
	 */
	public List<ManageschemeTempletDisease> getDiseases() {
		return diseases;
	}
	/**
	 * diseases.
	 *
	 * @param   diseases    the diseases to set 
	 */
	public void setDiseases(List<ManageschemeTempletDisease> diseases) {
		this.diseases = diseases;
	}
	/**
	 * tasks.
	 *
	 * @return  the tasks 
	 */
	public List<ManageschemeTempletTask> getTasks() {
		return tasks;
	}
	/**
	 * tasks.
	 *
	 * @param   tasks    the tasks to set 
	 */
	public void setTasks(List<ManageschemeTempletTask> tasks) {
		this.tasks = tasks;
	}
	
	public String getUseRangeName(){
		return UseRangeEnum.getEnumByCode(this.useRange).getName();
	}
	
	public String getTempletStatusName(){
		return TempletStatusEnum.getEnumByCode(this.templetStatus).getName();
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
	/**
	 * updateTimeS.
	 *
	 * @return  the updateTimeS 
	 */
	public Date getUpdateTimeS() {
		return updateTimeS;
	}
	/**
	 * updateTimeS.
	 *
	 * @param   updateTimeS    the updateTimeS to set 
	 */
	public void setUpdateTimeS(Date updateTimeS) {
		this.updateTimeS = updateTimeS;
	}
	/**
	 * updateTimeE.
	 *
	 * @return  the updateTimeE 
	 */
	public Date getUpdateTimeE() {
		return updateTimeE;
	}
	/**
	 * updateTimeE.
	 *
	 * @param   updateTimeE    the updateTimeE to set 
	 */
	public void setUpdateTimeE(Date updateTimeE) {
		this.updateTimeE = updateTimeE;
	}
	/**
	 * mSDiseaseID.
	 *
	 * @return  the mSDiseaseID 
	 */
	public Integer getMSDiseaseID() {
		return MSDiseaseID;
	}
	/**
	 * mSDiseaseID.
	 *
	 * @param   mSDiseaseID    the mSDiseaseID to set 
	 */
	public void setMSDiseaseID(Integer mSDiseaseID) {
		MSDiseaseID = mSDiseaseID;
	}
	/**
	 * file.
	 *
	 * @return  the file 
	 */
	public MultipartFile getFile() {
		return file;
	}
	/**
	 * file.
	 *
	 * @param   file    the file to set 
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
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
	/**
	 * roleId.
	 *
	 * @return  the roleId 
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * roleId.
	 *
	 * @param   roleId    the roleId to set 
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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
	 * mSDiseaseIDs.
	 *
	 * @return  the mSDiseaseIDs 
	 */
	public String getMSDiseaseIDs() {
		return MSDiseaseIDs;
	}
	/**
	 * mSDiseaseIDs.
	 *
	 * @param   mSDiseaseIDs    the mSDiseaseIDs to set 
	 */
	public void setMSDiseaseIDs(String mSDiseaseIDs) {
		MSDiseaseIDs = mSDiseaseIDs;
	}
	/**
	 * mSDiseaseName.
	 *
	 * @return  the mSDiseaseName 
	 */
	public String getMSDiseaseName() {
		return MSDiseaseName;
	}
	/**
	 * mSDiseaseName.
	 *
	 * @param   mSDiseaseName    the mSDiseaseName to set 
	 */
	public void setMSDiseaseName(String mSDiseaseName) {
		MSDiseaseName = mSDiseaseName;
	}
	
    
}