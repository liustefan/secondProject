/*
 * MemBerPackagTemplate.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.packagCore.packag.model;

import java.util.Date;

/**
 * 与PSP1表对应
 * 
 * @author ${user}
 * @version 1.0 2016-07-05
 */
public class MemBerPackagTemplate extends MemBerPackagTemplateKey {

    /**
     * 次数
     */
    private Short numTimes;
    /**
     * 已提交次数
     */
    private Short submitNum;
    /**
     * 开始时间
     */
    private Date beginDate;
    /**
     * 有效天数
     */
    private Date endDate;
    /**
     * 计算类型
     */
    private String calcType;
    /**
     * 标记  T：有效，F：无效
     */
    private String tag;
    
    //额外增加的属性
    /**
     * 汇总报告名称
     */
    private String sumRepTempName;
    

    public String getSumRepTempName() {
		return sumRepTempName;
	}
	public void setSumRepTempName(String sumRepTempName) {
		this.sumRepTempName = sumRepTempName;
	}
	public Short getNumTimes() {
        return numTimes;
    }
    public void setNumTimes(Short numTimes) {
        this.numTimes = numTimes;
    }
    public Short getSubmitNum() {
        return submitNum;
    }
    public void setSubmitNum(Short submitNum) {
        this.submitNum = submitNum;
    }
    public Date getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getCalcType() {
        return calcType;
    }
    public void setCalcType(String calcType) {
        this.calcType = calcType;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}