/*
 * DoctorGroup.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.docGroup.model;

import java.util.ArrayList;
import java.util.List;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 医生分组(ODGP)
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class DoctorGroup extends GenericModel {

	private static final long serialVersionUID = 3471709274810694112L;
	/**
     * 分组代码
     */
    private Integer odgpid;
    /**
     * 分组名称
     */
    private String odgpname;
    /**
     * 分组说明
     */
    private String remark;
    /**
     * 上级分组代码
     */
    private Integer fathid;
    /**
     * 分组内的医生人数
     */
    private Integer docnum;
    /**
     * 审核级数
     */
    private Short chlevel;
    /**
     * 组织代码
     */
    private Integer orgid;
    /**
     * 选项代码
     */
    private Short optid;
    /**
     * 功能代码
     */
    private Short funid;
    /**
     * 未梢组织
     */
    private Boolean endblocktag;
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
    
    /**
     * 父节点
     */
    private DoctorGroup parentGroup;
    
    /**
     * 子节点集合
     */
    private List<DoctorGroup> children = new ArrayList<DoctorGroup>();
    
    public DoctorGroup getParentGroup() {
		return parentGroup;
	}
	public void setParentGroup(DoctorGroup parentGroup) {
		this.parentGroup = parentGroup;
	}
	public List<DoctorGroup> getChildren() {
		return children;
	}
	public void setChildren(List<DoctorGroup> children) {
		this.children = children;
	}
	public Integer getOdgpid() {
        return odgpid;
    }
    public void setOdgpid(Integer odgpid) {
        this.odgpid = odgpid;
    }
    public String getOdgpname() {
        return odgpname;
    }
    public void setOdgpname(String odgpname) {
        this.odgpname = odgpname;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getFathid() {
        return fathid;
    }
    public void setFathid(Integer fathid) {
        this.fathid = fathid;
    }
    public Integer getDocnum() {
        return docnum;
    }
    public void setDocnum(Integer docnum) {
        this.docnum = docnum;
    }
    public Short getChlevel() {
        return chlevel;
    }
    public void setChlevel(Short chlevel) {
        this.chlevel = chlevel;
    }
    public Integer getOrgid() {
        return orgid;
    }
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }
    public Short getOptid() {
        return optid;
    }
    public void setOptid(Short optid) {
        this.optid = optid;
    }
    public Short getFunid() {
        return funid;
    }
    public void setFunid(Short funid) {
        this.funid = funid;
    }
    public Boolean getEndblocktag() {
        return endblocktag;
    }
    public void setEndblocktag(Boolean endblocktag) {
        this.endblocktag = endblocktag;
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