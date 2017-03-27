/*
 * MemSingleReportTemplateMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.dao;

import java.util.Map;

import com.bithealth.reportCore.report.model.MemSingleReportTemplate;
import com.bithealth.reportCore.report.model.MemSingleReportTemplateExample;
import com.bithealth.reportCore.report.model.MemSingleReportTemplateKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemSingleReportTemplateMapper extends GenericBaseDao<MemSingleReportTemplate, MemSingleReportTemplateExample, MemSingleReportTemplateKey> {
	
	/**
	 * @Title:exProc_pro_insOMAS 
	 * @Description:调用pro_insOMAS存储过程
	 * @author 谢美团
	 * @param createId
	 * @param createName
	 * @param memberId 
	 * @throws
	 * @retrun void
	 */ 
	public void exProc_pro_insOMAS(Map<String,Object> paramMap);
}