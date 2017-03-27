/*
 * SummaryReportRelationKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.model;


@SuppressWarnings("serial")
public class SummaryReportRelation extends SummaryReportRelationKey {

    /**
     * 汇总测量ID
     */
    private Integer ID;
    /**
     * 单项测量报告ID
     */
    private Integer singleID;

    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public Integer getSingleID() {
        return singleID;
    }
    public void setSingleID(Integer singleID) {
        this.singleID = singleID;
    }
}