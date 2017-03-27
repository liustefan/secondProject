/*
 * Mfq11Key.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class Mfq11Key extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -2637698477640483140L;
	/**
     * 问卷ID号
     */
    private Integer qustid;
    /**
     * 问题ID
     */
    private Integer problemid;
    /**
     * 答案ID
     */
    private Short ansid;

    public Integer getQustid() {
        return qustid;
    }
    public void setQustid(Integer qustid) {
        this.qustid = qustid;
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