/*
 * PackagDetail.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.packagCore.packag.model;

import java.util.Date;

/**
 * 套餐明细（PSP1）
 * 
 * @author ${user}
 * @version 1.0 2016-07-05
 */
public class PackagDetail extends PackagDetailKey {

    /**
     * 次数
     */
    private Short numTimes;
    /**
     * 周期天数
     */
    private Short numDay;
    /**
     * 计算类型    T :计时，C： 计次
     */
    private String calcType;
    /**
     * 创建日期
     */
    private Date createTime = new Date();
    /**
     * 创建医生ID
     */
    private Integer createid;

    public Short getNumTimes() {
        return numTimes;
    }
    public void setNumTimes(Short numTimes) {
        this.numTimes = numTimes;
    }
    public Short getNumDay() {
        return numDay;
    }
    public void setNumDay(Short numDay) {
        this.numDay = numDay;
    }
    public String getCalcType() {
        return calcType;
    }
    public void setCalcType(String calcType) {
        this.calcType = calcType;
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
}