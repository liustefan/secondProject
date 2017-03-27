/*
 * CareRemark.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-23 Created
 */
package com.bithealth.centCore.care.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 
 * 
 * @author ${user}
 * @version 1.0 2016-08-23
 */
public class CareRemark extends GenericModel {

    private Integer id;
    private Integer memberId;
    private Integer remarkId;
    /**
     * 关系
     */
    private String relation;
    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getMemberId() {
        return memberId;
    }
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    public Integer getRemarkId() {
        return remarkId;
    }
    public void setRemarkId(Integer remarkId) {
        this.remarkId = remarkId;
    }
    public String getRelation() {
        return relation;
    }
    public void setRelation(String relation) {
        this.relation = relation;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}