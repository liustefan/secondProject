/*
 * MemSingleReportTemplate.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.model;

import java.util.Date;

/**
 * 会员测量报告审核设置(OMAS)
 * 
 * @author ${user}
 * @version 1.0 2016-07-20
 */
public class MemSingleReportTemplate extends MemSingleReportTemplateKey {

    /**
     * 分组代码
     */
    private Integer odgpId;
    /**
     * 选项代码
     */
    private Short optId;
    /**
     * 功能代码
     */
    private Short funId;
    /**
     * 当前已使用记录号
     */
    private Long currUesedNum;
    /**
     * 最后产生报告日期
     */
    private Date endProDate;
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

    public Integer getOdgpId() {
        return odgpId;
    }
    public void setOdgpId(Integer odgpId) {
        this.odgpId = odgpId;
    }
    public Short getOptId() {
        return optId;
    }
    public void setOptId(Short optId) {
        this.optId = optId;
    }
    public Short getFunId() {
        return funId;
    }
    public void setFunId(Short funId) {
        this.funId = funId;
    }
    public Long getCurrUesedNum() {
        return currUesedNum;
    }
    public void setCurrUesedNum(Long currUesedNum) {
        this.currUesedNum = currUesedNum;
    }
    public Date getEndProDate() {
        return endProDate;
    }
    public void setEndProDate(Date endProDate) {
        this.endProDate = endProDate;
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
}