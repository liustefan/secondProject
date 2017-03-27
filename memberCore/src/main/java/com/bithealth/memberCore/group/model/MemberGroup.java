/*
 * MemberGroup.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.group.model;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 会员分组设置（OMGS)
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class MemberGroup extends GenericModel {

	private static final long serialVersionUID = -3239847608770327561L;
	/**
     * 会员分组代码
     */
    private Integer memgrpid;
    /**
     * 会员分组代码
     */
    private String memgrpname;
    /**
     * 会员分组说明
     */
    private String memgrpdesc;
    /**
     * 上级会员分组代码
     */
    private Integer famemid;
    /**
     * 组织代码
     */
    private Integer orgid;
    /**
     * 使用标记
     */
    private String usetag;
    /**
     * 排序
     */
    private Integer order;
    /**
     * 路径(以逗号拼接)，比如：,0,1,2,
     */
    private String path;
    
    private MemberGroup parentGroup;
    
    private List<MemberGroup> children;
    
    public MemberGroup getParentGroup() {
		return parentGroup;
	}
	public void setParentGroup(MemberGroup parentGroup) {
		this.parentGroup = parentGroup;
	}
	public List<MemberGroup> getChildren() {
		return children;
	}
	public void setChildren(List<MemberGroup> children) {
		this.children = children;
	}
	public Integer getMemgrpid() {
        return memgrpid;
    }
    public void setMemgrpid(Integer memgrpid) {
        this.memgrpid = memgrpid;
    }
    public String getMemgrpname() {
        return memgrpname;
    }
    public void setMemgrpname(String memgrpname) {
        this.memgrpname = memgrpname;
    }
    public String getMemgrpdesc() {
        return memgrpdesc;
    }
    public void setMemgrpdesc(String memgrpdesc) {
        this.memgrpdesc = memgrpdesc;
    }
    public Integer getFamemid() {
        return famemid;
    }
    public void setFamemid(Integer famemid) {
        this.famemid = famemid;
    }
    public Integer getOrgid() {
        return orgid;
    }
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }
    public String getUsetag() {
        return usetag;
    }
    public void setUsetag(String usetag) {
        this.usetag = usetag;
    }
    public Integer getOrder() {
        return order;
    }
    public void setOrder(Integer order) {
        this.order = order;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}