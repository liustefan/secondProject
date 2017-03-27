/*
 * PhDicttype.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.inspectCore.dict.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * 公共卫生_字典类型表
 * 
 * @author ${user}
 * @version 1.0 2016-06-28
 */
public class PhDicttype extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -2887391793507698757L;
	/**
     * 字典类型ID
     */
    private Short DTypeID;
    /**
     * 字典类型名称
     */
    private String DTypeName;
    /**
     * 来源分类
     */
    private String source;
    /**
     * 记录创建时间
     */
    private Date createTime;

    public Short getDTypeID() {
        return DTypeID;
    }
    public void setDTypeID(Short DTypeID) {
        this.DTypeID = DTypeID;
    }
    public String getDTypeName() {
        return DTypeName;
    }
    public void setDTypeName(String DTypeName) {
        this.DTypeName = DTypeName;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}