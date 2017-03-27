/*
 * OptionKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class OptionKey extends GenericModel {

    /**
     * 选项代码
     */
    private Short optId;
    /**
     * 功能代码
     */
    private Short funId;

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
}