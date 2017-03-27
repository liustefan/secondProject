/*
 * Cqt1Key.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class Cqt1Key extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 7178503014907203191L;
	/**
     * 组合答卷ID
     */
    private Integer combQustid;
    /**
     * 问卷ID号
     */
    private Integer qustid;

    public Integer getCombQustid() {
        return combQustid;
    }
    public void setCombQustid(Integer combQustid) {
        this.combQustid = combQustid;
    }
    public Integer getQustid() {
        return qustid;
    }
    public void setQustid(Integer qustid) {
        this.qustid = qustid;
    }
}