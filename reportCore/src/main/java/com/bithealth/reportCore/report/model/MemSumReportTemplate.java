/*
 * MemSumReportTemplate.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.model;

import java.util.Date;

/**
 * 会员汇总测量报告关联单项(OSRS)
 * 
 * @author ${user}
 * @version 1.0 2016-07-20
 */
public class MemSumReportTemplate extends MemSumReportTemplateKey {

    /**
     * 当前已使用报告单号
     */
    private Integer currReportid;
    /**
     * 组织代码
     */
    private Integer orgId;
    /**
     * 最后产生报告日期
     */
    private Date endProDate;

    public Integer getCurrReportid() {
        return currReportid;
    }
    public void setCurrReportid(Integer currReportid) {
        this.currReportid = currReportid;
    }
    public Integer getOrgId() {
        return orgId;
    }
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    public Date getEndProDate() {
        return endProDate;
    }
    public void setEndProDate(Date endProDate) {
        this.endProDate = endProDate;
    }
}