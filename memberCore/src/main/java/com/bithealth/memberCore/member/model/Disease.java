/*
 * Disease.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-25 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 疾病数字字典 
 * 
 * @author ${user}
 * @version 1.0 2016-07-25
 */
public class Disease extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -7928508667383341696L;
	/**
     * 主键
     */
    private Integer id;
    /**
     * 疾病id
     */
    private Integer disease_id;
    /**
     * 疾病名称
     */
    private String disease_name;
    
    /**
     * 排序号
     */
    private Integer sortNO;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getDisease_id() {
        return disease_id;
    }
    public void setDisease_id(Integer disease_id) {
        this.disease_id = disease_id;
    }
    public String getDisease_name() {
        return disease_name;
    }
    public void setDisease_name(String disease_name) {
        this.disease_name = disease_name;
    }
	public Integer getSortNO() {
		return sortNO;
	}
	public void setSortNO(Integer sortNO) {
		this.sortNO = sortNO;
	}
}