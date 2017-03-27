/*
 * Ecg1Key.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class Ecg1Key extends GenericModel {

    /**
     * 测量记录号
     */
    private Long docentry;
    /**
     * 行号
     */
    private Short linenum;

    public Long getDocentry() {
        return docentry;
    }
    public void setDocentry(Long docentry) {
        this.docentry = docentry;
    }
    public Short getLinenum() {
        return linenum;
    }
    public void setLinenum(Short linenum) {
        this.linenum = linenum;
    }
}