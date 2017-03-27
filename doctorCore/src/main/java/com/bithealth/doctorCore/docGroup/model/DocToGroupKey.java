/*
 * DocToGroupKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.docGroup.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class DocToGroupKey extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -3433665431286019083L;
	/**
     * 分组代码
     */
    private Integer odgpid;
    /**
     * 医生代码
     */
    private Integer docid;

    public Integer getOdgpid() {
        return odgpid;
    }
    public void setOdgpid(Integer odgpid) {
        this.odgpid = odgpid;
    }
    public Integer getDocid() {
        return docid;
    }
    public void setDocid(Integer docid) {
        this.docid = docid;
    }
}