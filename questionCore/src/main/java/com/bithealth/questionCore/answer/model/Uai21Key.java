/*
 * Uai21Key.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-18 Created
 */
package com.bithealth.questionCore.answer.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class Uai21Key extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 7589031596193362674L;
	/**
     * 答卷编号
     */
    private Integer ansNumber;
    /**
     * 问题ID
     */
    private Integer problemid;
    /**
     * 答案ID
     */
    private Short ansid;

    public Integer getAnsNumber() {
        return ansNumber;
    }
    public void setAnsNumber(Integer ansNumber) {
        this.ansNumber = ansNumber;
    }
    public Integer getProblemid() {
        return problemid;
    }
    public void setProblemid(Integer problemid) {
        this.problemid = problemid;
    }
    public Short getAnsid() {
        return ansid;
    }
    public void setAnsid(Short ansid) {
        this.ansid = ansid;
    }
}