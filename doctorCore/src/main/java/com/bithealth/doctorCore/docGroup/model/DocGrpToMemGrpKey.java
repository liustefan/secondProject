/*
 * DocGrpToMemGrpKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.docGroup.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class DocGrpToMemGrpKey extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 1799628882722276611L;
	/**
     * 会员分组代码
     */
    private Integer memgrpid;
    /**
     * 分组代码
     */
    private Integer odgpid;

    public Integer getMemgrpid() {
        return memgrpid;
    }
    public void setMemgrpid(Integer memgrpid) {
        this.memgrpid = memgrpid;
    }
    public Integer getOdgpid() {
        return odgpid;
    }
    public void setOdgpid(Integer odgpid) {
        this.odgpid = odgpid;
    }
}