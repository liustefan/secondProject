/*
 * Ecg1.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.model;

/**
 * 心电测量明细
 * 
 * @author ${user}
 * @version 1.0 2016-07-11
 */
public class Ecg1 extends Ecg1Key {

    private String objectid;
    private String abecgtype;
    private Integer abecgtime;
    
    public String getObjectid() {
        return objectid;
    }
    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }
    public String getAbecgtype() {
        return abecgtype;
    }
    public void setAbecgtype(String abecgtype) {
        this.abecgtype = abecgtype;
    }
    public Integer getAbecgtime() {
        return abecgtime;
    }
    public void setAbecgtime(Integer abecgtime) {
        this.abecgtime = abecgtime;
    }
	
}