/*
 * Org.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.orgainCore.model;

import java.util.ArrayList;
import java.util.List;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 组织架构表(ORGS)
 * 
 * @author ${user}
 * @version 1.0 2016-07-12
 */
public class Org extends GenericModel {

	private static final long serialVersionUID = -518589424280841585L;
	/**
     * 组织代码
     */
    private Integer orgId;
    /**
     * 组织架构编码
     */
    private String orgCode;
    /**
     * 组织名称
     */
    private String orgName;
    /**
     * 上级组织代码
     */
    private Integer superior;
    
    /**
     * 是否对外提供服务
     */
    private String isExternalService;
    /**
     * 类型
     */
    private Short otype;
    /**
     * 会员数
     */
    private Integer memnum;
    /**
     * 组织架构内医生人数
     */
    private Integer docNum;
    /**
     * 使用标记
     */
    private String useTag;
    /**
     * 排序
     */
    private Integer order;
    /**
     * 路径(以逗号拼接)，比如：,0,1,2,
     */
    private String path;
    
    /**
     * 上级组织
     */
    private Org parentOrg;
    
    private boolean hasDoctor;
    
    private List<Org> children = new ArrayList<Org>();
    
    /**
     * 组织配置
     */
    private OrgConfig orgConfig;

    public Integer getOrgId() {
        return orgId;
    }
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    public String getOrgCode() {
        return orgCode;
    }
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
    public String getOrgName() {
        return orgName;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public Integer getSuperior() {
        return superior;
    }
    public void setSuperior(Integer superior) {
        this.superior = superior;
    }
    public Short getOtype() {
        return otype;
    }
    public void setOtype(Short otype) {
        this.otype = otype;
    }
    public Integer getMemnum() {
        return memnum;
    }
    public void setMemnum(Integer memnum) {
        this.memnum = memnum;
    }
    public Integer getDocNum() {
        return docNum;
    }
    public void setDocNum(Integer docNum) {
        this.docNum = docNum;
    }
    public String getUseTag() {
        return useTag;
    }
    public void setUseTag(String useTag) {
        this.useTag = useTag;
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
	public Org getParentOrg() {
		return parentOrg;
	}
	public void setParentOrg(Org parentOrg) {
		this.parentOrg = parentOrg;
	}
	public List<Org> getChildren() {
		return children;
	}
	public void setChildren(List<Org> children) {
		this.children = children;
	}
	public boolean getHasDoctor() {
		return hasDoctor;
	}
	public void setHasDoctor(boolean hasDoctor) {
		this.hasDoctor = hasDoctor;
	}
	public String getIsExternalService() {
		return isExternalService;
	}
	public void setIsExternalService(String isExternalService) {
		this.isExternalService = isExternalService;
	}
	public OrgConfig getOrgConfig() {
		return orgConfig;
	}
	public void setOrgConfig(OrgConfig orgConfig) {
		this.orgConfig = orgConfig;
	}
}