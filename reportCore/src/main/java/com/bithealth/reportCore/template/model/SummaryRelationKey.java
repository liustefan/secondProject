/*
 * SummaryRelationKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-15 Created
 */
package com.bithealth.reportCore.template.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class SummaryRelationKey extends GenericModel {

    /**
     * 汇总报告审核模板
     */
    private Integer sumRepTempCode;
    /**
     * 模板代码
     */
    private Integer tempCode;

    public Integer getSumRepTempCode() {
        return sumRepTempCode;
    }
    public void setSumRepTempCode(Integer sumRepTempCode) {
        this.sumRepTempCode = sumRepTempCode;
    }
    public Integer getTempCode() {
        return tempCode;
    }
    public void setTempCode(Integer tempCode) {
        this.tempCode = tempCode;
    }
}