/*
 * LinkManKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class LinkManKey extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 2468714336838361009L;
	/**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 联系人姓名
     */
    private String contactname;

    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public String getContactname() {
        return contactname;
    }
    public void setContactname(String contactname) {
        this.contactname = contactname;
    }
}