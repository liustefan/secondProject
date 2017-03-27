/*
 * Ecg2Key.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class Ecg2Key extends GenericModel {

    /**
     * 测量记录号
     */
    private Long docentry;
    /**
     * 心动过速
     */
    private String abnname;

    public Long getDocentry() {
        return docentry;
    }
    public void setDocentry(Long docentry) {
        this.docentry = docentry;
    }
    public String getAbnname() {
        return abnname;
    }
    public void setAbnname(String abnname) {
        this.abnname = abnname;
    }
}