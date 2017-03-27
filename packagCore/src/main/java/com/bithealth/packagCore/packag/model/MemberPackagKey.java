/*
 * MemberPackagKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.packagCore.packag.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class MemberPackagKey extends GenericModel {

    /**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 行号
     */
    private Short lineNum;

    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Short getLineNum() {
        return lineNum;
    }
    public void setLineNum(Short lineNum) {
        this.lineNum = lineNum;
    }
}