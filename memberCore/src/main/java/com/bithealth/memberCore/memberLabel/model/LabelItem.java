/*
 * LabelItem.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.memberCore.memberLabel.model;

import com.bithealth.memberCore.memberLabel.enmu.LabelStatus;
import com.bithealth.memberCore.memberLabel.enmu.LabelUserRange;
import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * [3.0]会员标签小项表
 * 
 * @author ${user}
 * @version 1.0 2016-11-29
 */
public class LabelItem extends GenericModel {

	private static final long serialVersionUID = -6300127469720799507L;
	/**
     * 标签小项ID
     */
    private Integer litemid;
    /**
     * 标签分类ID
     */
    private Integer lclassid;
    /**
     * 名称
     */
    private String itemname;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 状态：1-新增，2-启用，3-禁用
     */
    private Byte itemstatus;
    /**
     * 组织ID
     */
    private Integer orgid;
    /**
     * 使用范围：1-全局，2-组织内，3-私有
     */
    private Byte userange;
    /**
     * 创建医生ID
     */
    private Integer createid;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 更新医生ID
     */
    private Integer updateid;
    /**
     * 更新时间
     */
    private Date updatetime;
    
    private String orgName;
    
    private LabelTag labelTag;
    
    private String labelClassName;
    
    private String superOrgIds;
    
    private Integer roleId;
    
    private String docname;
    
    private boolean checked;
    
    private Integer orgID;
    
    
    public Integer getOrgID() {
		return orgID;
	}
	public void setOrgID(Integer orgID) {
		this.orgID = orgID;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public Integer getLitemid() {
        return litemid;
    }
    public void setLitemid(Integer litemid) {
        this.litemid = litemid;
    }
    public Integer getLclassid() {
        return lclassid;
    }
    public void setLclassid(Integer lclassid) {
        this.lclassid = lclassid;
    }
    public String getItemname() {
        return itemname;
    }
    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Byte getItemstatus() {
        return itemstatus;
    }
    public void setItemstatus(Byte itemstatus) {
        this.itemstatus = itemstatus;
    }
    public Integer getOrgid() {
        return orgid;
    }
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }
    public Byte getUserange() {
        return userange;
    }
    public void setUserange(Byte userange) {
        this.userange = userange;
    }
    public Integer getCreateid() {
        return createid;
    }
    public void setCreateid(Integer createid) {
        this.createid = createid;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public Integer getUpdateid() {
        return updateid;
    }
    public void setUpdateid(Integer updateid) {
        this.updateid = updateid;
    }
    public Date getUpdatetime() {
        return updatetime;
    }
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public LabelTag getLabelTag() {
		return labelTag;
	}
	public void setLabelTag(LabelTag labelTag) {
		this.labelTag = labelTag;
	}
	public String getLabelClassName() {
		return labelClassName;
	}
	public void setLabelClassName(String labelClassName) {
		this.labelClassName = labelClassName;
	}
	
	public String getSuperOrgIds() {
		return superOrgIds;
	}
	public void setSuperOrgIds(String superOrgIds) {
		this.superOrgIds = superOrgIds;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getLabelUserRange(){
		return  LabelUserRange.getEnumByCode(this.userange).getName();
	}
	
	public String getLabelStatus(){
		return LabelStatus.getEnumByCode(this.itemstatus).getName();
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	
}