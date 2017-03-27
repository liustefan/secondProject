/*
 * Uai4Key.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-18 Created
 */
package com.bithealth.questionCore.answer.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class Uai4Key extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 5570506020863490422L;
	/**
     * 答卷编号
     */
    private Integer ansNumber;
    /**
     * 行号
     */
    private Short lineNum;

    public Integer getAnsNumber() {
        return ansNumber;
    }
    public void setAnsNumber(Integer ansNumber) {
        this.ansNumber = ansNumber;
    }
    public Short getLineNum() {
        return lineNum;
    }
    public void setLineNum(Short lineNum) {
        this.lineNum = lineNum;
    }
}