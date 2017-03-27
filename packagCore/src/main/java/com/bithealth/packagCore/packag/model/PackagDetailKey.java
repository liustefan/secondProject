/*
 * PackagDetailKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.packagCore.packag.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class PackagDetailKey extends GenericModel {

    /**
     * 套餐代码
     */
    private Integer packageCode;
    /**
     * 汇总报告审核模板
     */
    private Integer sumRepTempCode;

    public Integer getPackageCode() {
        return packageCode;
    }
    public void setPackageCode(Integer packageCode) {
        this.packageCode = packageCode;
    }
    public Integer getSumRepTempCode() {
        return sumRepTempCode;
    }
    public void setSumRepTempCode(Integer sumRepTempCode) {
        this.sumRepTempCode = sumRepTempCode;
    }
}