/*
 * AuditProgress.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.model;

import java.util.List;



/**
 * 类名称: AuditProgressParams  
 * 功能描述: 查询待审核报告参数类
 * 日期: 2016年7月23日 下午2:27:28 
 * 
 * @author 谢美团
 * @version  
 */
public class AuditProgressParams {
	
	private String doctorId;
	
	/**
	 * 功能项id
	 */
	private int functionId;
	
	/**
	 * 医生分组id
	 */
	private List<?> groupIdList;

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public int getFunctionId() {
		return functionId;
	}

	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}

	public List getGroupIdList() {
		return groupIdList;
	}

	public void setGroupIdList(List groupIdList) {
		this.groupIdList = groupIdList;
	}

	
}