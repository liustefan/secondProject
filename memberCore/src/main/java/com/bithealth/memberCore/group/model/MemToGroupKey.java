/*
 * MemToGroupKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.group.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class MemToGroupKey extends GenericModel {

	private static final long serialVersionUID = -2768910660818576071L;
	/**
     * 会员分组代码
     */
    private Integer memgrpid;
    /**
     * 会员代码
     */
    private Integer memberid;
    
    public Integer getMemgrpid() {
        return memgrpid;
    }
    public void setMemgrpid(Integer memgrpid) {
        this.memgrpid = memgrpid;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
}