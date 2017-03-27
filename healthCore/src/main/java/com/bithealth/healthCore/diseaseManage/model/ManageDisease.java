/*
 * ManageDisease.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.healthCore.diseaseManage.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * [3.0]管理方案_疾病
 * 
 * @author ${user}
 * @version 1.0 2016-11-29
 */
public class ManageDisease extends GenericModel {

	private static final long serialVersionUID = 3118951720919119775L;
	/**
     * 疾病ID
     */
    private Integer msdiseaseid;
    /**
     * 名称
     */
    private String diseasename;
    /**
     * 父疾病ID
     */
    private Integer parentid;
    /**
     * 排序号
     */
    private Integer sortno;
    /**
     * 描述
     */
    private String description;
    /**
     * 路径，如,0,1,2,
     */
    private String path;
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
    /**
     * 是否关联模版
     */
    private boolean hasDiseaseModel;
    /*
     * 上级疾病
     */
    private ManageDisease parentDisease;
    
    private String docname;
    
    List<ManageDisease> children= new ArrayList<ManageDisease>();
    
    public ManageDisease getParentDisease() {
		return parentDisease;
	}
	public void setParentDisease(ManageDisease parentDisease) {
		this.parentDisease = parentDisease;
	}
	public boolean getHasDiseaseModel() {
		return hasDiseaseModel;
	}
	public void setHasDiseaseModel(boolean hasDiseaseModel) {
		this.hasDiseaseModel = hasDiseaseModel;
	}
	public Integer getMsdiseaseid() {
        return msdiseaseid;
    }
    public void setMsdiseaseid(Integer msdiseaseid) {
        this.msdiseaseid = msdiseaseid;
    }
    public String getDiseasename() {
        return diseasename;
    }
    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename;
    }
    public Integer getParentid() {
        return parentid;
    }
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
    public Integer getSortno() {
        return sortno;
    }
    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
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
	public List<ManageDisease> getChildren() {
		return children;
	}
	public void setChildren(List<ManageDisease> children) {
		this.children = children;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
    
}