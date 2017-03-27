/**
 * @PackageName:      com.bithealth.memberCore.member.model
 * @FileName:     Org.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月6日 上午11:06:47  
 * 
 */
package com.bithealth.memberCore.member.model;

import java.io.Serializable;

/**
 * 类名称: Org  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 上午11:06:47 
 * 
 * @author liuhm
 * @version  
 */
public class Org implements Serializable {

	private static final long serialVersionUID = -8288663483952697856L;
	
	private int orgId;
	
	private String orgName;
	
	private String orgCode;

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

}
