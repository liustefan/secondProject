/*
 * Ecg3.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 
 * 
 * @author ${user}
 * @version 1.0 2016-07-11
 */
public class Ecg3 extends GenericModel {

    private String objectid;
    private Long docentry;
    private Long starttime;
    private Long endtime;

    public String getObjectid() {
        return objectid;
    }
    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }
    public Long getDocentry() {
        return docentry;
    }
    public void setDocentry(Long docentry) {
        this.docentry = docentry;
    }
    public Long getStarttime() {
        return starttime;
    }
    public void setStarttime(Long starttime) {
        this.starttime = starttime;
    }
    public Long getEndtime() {
        return endtime;
    }
    public void setEndtime(Long endtime) {
        this.endtime = endtime;
    }
}