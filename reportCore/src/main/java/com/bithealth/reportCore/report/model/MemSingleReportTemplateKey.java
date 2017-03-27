/*
 * MemSingleReportTemplateKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class MemSingleReportTemplateKey extends GenericModel {

    /**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 模板代码
     */
    private Integer tempCode;

    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Integer getTempCode() {
        return tempCode;
    }
    public void setTempCode(Integer tempCode) {
        this.tempCode = tempCode;
    }
}