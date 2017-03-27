/*
 * Cam2Key.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-19 Created
 */
package com.bithealth.questionCore.audit.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class Cam2Key extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -1428585644065134299L;
	/**
     * 组合答卷ID
     */
    private Integer combAnsid;
    /**
     * 行号
     */
    private Short lineNum;

    public Integer getCombAnsid() {
        return combAnsid;
    }
    public void setCombAnsid(Integer combAnsid) {
        this.combAnsid = combAnsid;
    }
    public Short getLineNum() {
        return lineNum;
    }
    public void setLineNum(Short lineNum) {
        this.lineNum = lineNum;
    }
}