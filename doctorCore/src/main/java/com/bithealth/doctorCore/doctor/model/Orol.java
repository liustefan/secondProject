/*
 * orol.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-24 Created
 */
package com.bithealth.doctorCore.doctor.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 角色表(OROL)
 * 
 * @author ${user}
 * @version 1.0 2016-06-24
 */
public class Orol extends GenericModel {

	private static final long serialVersionUID = -1002189612290760531L;
	/**
     * 角色代码
     */
    private Short roleid;
    /**
     * 角色名称
     */
    private String rolename;
    /**
     * 角色说明
     */
    private String roledes;
    /**
     * 标记
     */
    private String tag;

    public Short getRoleid() {
        return roleid;
    }
    public void setRoleid(Short roleid) {
        this.roleid = roleid;
    }
    public String getRolename() {
        return rolename;
    }
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    public String getRoledes() {
        return roledes;
    }
    public void setRoledes(String roledes) {
        this.roledes = roledes;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}