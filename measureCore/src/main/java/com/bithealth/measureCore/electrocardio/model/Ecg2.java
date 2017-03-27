/*
 * Ecg2.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.model;

/**
 * 心电12种异常（ECG2）
 * 
 * @author ${user}
 * @version 1.0 2016-07-11
 */
public class Ecg2 extends Ecg2Key {

    /**
     * 二联律
     */
    private Integer abnnum;
    
    private String abnCname;
    
    public String getAbnCname() {
		return abnCname;
	}
	public void setAbnCname(String abnCname) {
		this.abnCname = abnCname;
	}
	public Integer getAbnnum() {
        return abnnum;
    }
    public void setAbnnum(Integer abnnum) {
        this.abnnum = abnnum;
    }
    
}