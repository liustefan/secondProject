/*
 * Packag.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.packagCore.packag.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 服务套餐设置(OPSP)
 * 
 * @author ${user}
 * @version 1.0 2016-07-05
 */
public class Packag extends GenericModel {

    /**
     * 套餐代码
     */
    private Integer packageCode;
    /**
     * 组织代码
     */
    private Integer orgId;
    /**
     * 套餐名称
     */
    private String packageName;
    /**
     * 套餐说明
     */
    private String packageDesc;
    /**
     * 套餐类型
     */
    private Short packageType;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 套餐级别
     */
    private String packageLevel;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 创建医生ID
     */
    private Integer createid;
    /**
     * 创建人姓名
     */
    private String createName;
    /**
     * 使用标记  T : 正常，F : 关闭
     */
    private String useTag = "T";
    
    /**
     * 套餐明细列表 
     */
    private List<PackagDetail> packagDetailList;
    
    
    public List<PackagDetail> getPackagDetailList() {
		return packagDetailList;
	}
	public void setPackagDetailList(List<PackagDetail> packagDetailList) {
		this.packagDetailList = packagDetailList;
	}
	public Integer getPackageCode() {
        return packageCode;
    }
    public void setPackageCode(Integer packageCode) {
        this.packageCode = packageCode;
    }
    public Integer getOrgId() {
        return orgId;
    }
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    public String getPackageName() {
        return packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public String getPackageDesc() {
        return packageDesc;
    }
    public void setPackageDesc(String packageDesc) {
        this.packageDesc = packageDesc;
    }
    public Short getPackageType() {
        return packageType;
    }
    public void setPackageType(Short packageType) {
        this.packageType = packageType;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getPackageLevel() {
        return packageLevel;
    }
    public void setPackageLevel(String packageLevel) {
        this.packageLevel = packageLevel;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getCreateid() {
        return createid;
    }
    public void setCreateid(Integer createid) {
        this.createid = createid;
    }
    public String getCreateName() {
        return createName;
    }
    public void setCreateName(String createName) {
        this.createName = createName;
    }
    public String getUseTag() {
        return useTag;
    }
    public void setUseTag(String useTag) {
        this.useTag = useTag;
    }
}