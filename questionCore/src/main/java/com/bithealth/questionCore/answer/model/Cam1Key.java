/*
 * Cam1Key.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-18 Created
 */
package com.bithealth.questionCore.answer.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class Cam1Key extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -1954576528237917769L;
	/**
     * 组合答卷ID
     */
    private Integer combAnsid;
    /**
     * 答卷编号
     */
    private Integer ansNumber;

    public Integer getCombAnsid() {
        return combAnsid;
    }
    public void setCombAnsid(Integer combAnsid) {
        this.combAnsid = combAnsid;
    }
    public Integer getAnsNumber() {
        return ansNumber;
    }
    public void setAnsNumber(Integer ansNumber) {
        this.ansNumber = ansNumber;
    }
}