/*
 * OasrSerialnumber.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-19 Created
 */
package com.bithealth.questionCore.audit.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 
 * 
 * @author ${user}
 * @version 1.0 2016-07-19
 */
public class OasrSerialnumber extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -439146343761863471L;
	private Long serialNumber;

    public Long getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }
}