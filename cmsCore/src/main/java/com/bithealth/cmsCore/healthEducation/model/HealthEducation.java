/*
 * HealthEducation.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.cmsCore.healthEducation.model;

import com.bithealth.cmsCore.healthEducation.enmu.HealthEducationenum;
import com.bithealth.healthCore.diseaseManage.model.ManageDisease;
import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;
import java.util.List;

/**
 * [3.0]健教库
 * 
 * @author ${user}
 * @version 1.0 2016-11-29
 */
public class HealthEducation extends GenericModel {

	private static final long serialVersionUID = 3523659355674521876L;
	/**
     * 健教ID
     */
    private Integer heducationid;
    /**
     * 健教类型：1-饮食指导，2-运动指导，3-心理指导，4-中医指导，5-生活方式指导，6-用药指导
     */
    private Byte heducationtype;
    /**
     * 标题
     */
    private String title;
    /**
     * 来源方式：1-自定义，2-健康资讯，3-复制网址
     */
    private Byte sourceway;
    /**
     * 来源id
     */
    private Integer sourceid;
    /**
     * 内容
     */
    private String content;
    /**
     * 组织ID
     */
    private Integer orgid;
    /**
     * 使用范围：1-全局，2-组织内，3-私有
     */
    private Byte userange;
    /**
     * 创建医生ID
     */
    private Integer createid;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 更新医生ID
     */
    private Integer updateid;
    /**
     * 更新时间
     */
    private Date updatetime;
    
    private Integer MSDiseaseID;
    
    private List<HealthEducationDisease>  diseases;
    
    private String MSDiseaseIDs;
    
    private String MSDiseaseName;
    
    private String superOrgIds;
    
    private Integer roleId;
    
    private String docname;
    
    public Integer getHeducationid() {
        return heducationid;
    }
    public void setHeducationid(Integer heducationid) {
        this.heducationid = heducationid;
    }
    public Byte getHeducationtype() {
        return heducationtype;
    }
    public void setHeducationtype(Byte heducationtype) {
        this.heducationtype = heducationtype;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Byte getSourceway() {
        return sourceway;
    }
    public void setSourceway(Byte sourceway) {
        this.sourceway = sourceway;
    }
    public Integer getSourceid() {
		return sourceid;
	}
	public void setSourceid(Integer sourceid) {
		this.sourceid = sourceid;
	}
	public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getOrgid() {
        return orgid;
    }
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }
    public Byte getUserange() {
        return userange;
    }
    public void setUserange(Byte userange) {
        this.userange = userange;
    }
    public Integer getCreateid() {
        return createid;
    }
    public void setCreateid(Integer createid) {
        this.createid = createid;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public Integer getUpdateid() {
        return updateid;
    }
    public void setUpdateid(Integer updateid) {
        this.updateid = updateid;
    }
    public Date getUpdatetime() {
        return updatetime;
    }
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
	public Integer getMSDiseaseID() {
		return MSDiseaseID;
	}
	public void setMSDiseaseID(Integer mSDiseaseID) {
		MSDiseaseID = mSDiseaseID;
	}
	public List<HealthEducationDisease> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<HealthEducationDisease> diseases) {
		this.diseases = diseases;
	}
	public String getMSDiseaseName() {
		return MSDiseaseName;
	}
	public void setMSDiseaseName(String mSDiseaseName) {
		MSDiseaseName = mSDiseaseName;
	}
	public String getMSDiseaseIDs() {
		return MSDiseaseIDs;
	}
	public void setMSDiseaseIDs(String mSDiseaseIDs) {
		MSDiseaseIDs = mSDiseaseIDs;
	}
	public String getSuperOrgIds() {
		return superOrgIds;
	}
	public void setSuperOrgIds(String superOrgIds) {
		this.superOrgIds = superOrgIds;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
    
	public String getHealthEducationenum(){
		return HealthEducationenum.getEnumByCode(this.userange).getName();
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	
}