/*
 * PhDictitem.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.inspectCore.dict.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * 公共卫生_字典小项表
 * 
 * @author ${user}
 * @version 1.0 2016-06-28
 */
public class PhDictitem extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 2928727216271560388L;
	/**
     * 记录ID
     */
    private Integer logID;
    /**
     * 字典类型ID，引用ph_DictType
     */
    private Short DTypeID;
    /**
     * 字典小项ID
     */
    private Byte DItemID;
    /**
     * 字典小项名称
     */
    private String DItemName;
    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 字典类型名称
     */
    private String DTypeName;
    /**
     * 来源分类
     */
    private String source;
    
    public Integer getLogID() {
        return logID;
    }
    public void setLogID(Integer logID) {
        this.logID = logID;
    }
    public Short getDTypeID() {
        return DTypeID;
    }
    public void setDTypeID(Short DTypeID) {
        this.DTypeID = DTypeID;
    }
    public Byte getDItemID() {
        return DItemID;
    }
    public void setDItemID(Byte DItemID) {
        this.DItemID = DItemID;
    }
    public String getDItemName() {
        return DItemName;
    }
    public void setDItemName(String DItemName) {
        this.DItemName = DItemName;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDTypeName() {
		return DTypeName;
	}
	public void setDTypeName(String dTypeName) {
		DTypeName = dTypeName;
	}
	
    
}