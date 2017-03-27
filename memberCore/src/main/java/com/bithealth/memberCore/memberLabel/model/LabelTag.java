/*
 * LabelTag.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.memberCore.memberLabel.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * [3.0]会员标签分类
 * 
 * @author ${user}
 * @version 1.0 2016-11-29
 */
public class LabelTag extends GenericModel {

	private static final long serialVersionUID = -5714448907093669572L;
	/**
     * 标签分类ID
     */
    private Integer lclassid;
    /**
     * 名称
     */
    private String classname;
    /**
     * 描述
     */
    private String description;
    /**
     * 是否系统级：0-否，1-是
     */
    private Byte issystem;
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
    
    private String docname;

    public Integer getLclassid() {
        return lclassid;
    }
    public void setLclassid(Integer lclassid) {
        this.lclassid = lclassid;
    }
    public String getClassname() {
        return classname;
    }
    public void setClassname(String classname) {
        this.classname = classname;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Byte getIssystem() {
        return issystem;
    }
    public void setIssystem(Byte issystem) {
        this.issystem = issystem;
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
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
    
}