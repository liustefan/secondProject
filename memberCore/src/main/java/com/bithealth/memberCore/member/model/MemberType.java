/*
 * MemberType.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 会员类型(OMES)
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class MemberType extends GenericModel {

	private static final long serialVersionUID = 4015860279479685076L;
	/**
     * 会员类型
     */
    private Short memid;
    /**
     * 组织代码
     */
    private Integer orgid;
    /**
     * 会员类型名
     */
    private String memname;
    /**
     * 会员类型说明
     */
    private String memdesc;
    /**
     * 标记
     */
    private String tag;

    public Short getMemid() {
        return memid;
    }
    public void setMemid(Short memid) {
        this.memid = memid;
    }
    public Integer getOrgid() {
        return orgid;
    }
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }
    public String getMemname() {
        return memname;
    }
    public void setMemname(String memname) {
        this.memname = memname;
    }
    public String getMemdesc() {
        return memdesc;
    }
    public void setMemdesc(String memdesc) {
        this.memdesc = memdesc;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}