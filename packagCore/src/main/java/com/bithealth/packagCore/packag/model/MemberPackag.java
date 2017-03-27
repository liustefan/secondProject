/*
 * MemberPackag.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.packagCore.packag.model;

import java.util.Date;

/**
 * 会员订购套餐表(OMMT)
 * 
 * @author ${user}
 * @version 1.0 2016-07-05
 */
public class MemberPackag extends MemberPackagKey {

    /**
     * 套餐代码
     */
    private Integer packageCode;
    
    /**
     * 新套餐的套餐代码，更改套餐时使用. 
     */
    private Integer newPackageCode;
    /**
     * 标记  T : 有效，F：无效
     */
    private String tag;
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
     * 套餐实体对象 
     */
    private Packag packag;
      

    public Packag getPackag() {
		return packag;
	}
	public void setPackag(Packag packag) {
		this.packag = packag;
	}
	public Integer getPackageCode() {
        return packageCode;
    }
    public void setPackageCode(Integer packageCode) {
        this.packageCode = packageCode;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
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
    
	public Integer getNewPackageCode() {
		return newPackageCode;
	}
	public void setNewPackageCode(Integer newPackageCode) {
		this.newPackageCode = newPackageCode;
	}
    
    
}