/*
 * DiseasesHistoryKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class DiseasesHistoryKey extends GenericModel {

	private static final long serialVersionUID = 7448194579586104807L;
	/**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 行号
     */
    private Short linenum;

    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Short getLinenum() {
        return linenum;
    }
    public void setLinenum(Short linenum) {
        this.linenum = linenum;
    }
}