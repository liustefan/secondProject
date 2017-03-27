/*
 * Mfq21Key.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class Mfq21Key extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 774511389491383849L;
	/**
     * 问卷ID号
     */
    private Integer qustid;
    /**
     * 行号
     */
    private Short lineNum;
    /**
     * 结论ID
     */
    private Short convid;

    public Integer getQustid() {
        return qustid;
    }
    public void setQustid(Integer qustid) {
        this.qustid = qustid;
    }
    public Short getLineNum() {
        return lineNum;
    }
    public void setLineNum(Short lineNum) {
        this.lineNum = lineNum;
    }
    public Short getConvid() {
        return convid;
    }
    public void setConvid(Short convid) {
        this.convid = convid;
    }
}