/*
 * VitalIndex.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 会员活力指数表
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class VitalIndex extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 783500202671113989L;
	/**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 活力指数
     */
    private Integer vigorindex;

    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Integer getVigorindex() {
        return vigorindex;
    }
    public void setVigorindex(Integer vigorindex) {
        this.vigorindex = vigorindex;
    }
}