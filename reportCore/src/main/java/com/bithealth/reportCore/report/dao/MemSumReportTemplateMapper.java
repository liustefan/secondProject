/*
 * MemSumReportTemplateMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.dao;

import java.util.Map;

import com.bithealth.reportCore.report.model.MemSumReportTemplate;
import com.bithealth.reportCore.report.model.MemSumReportTemplateExample;
import com.bithealth.reportCore.report.model.MemSumReportTemplateKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemSumReportTemplateMapper extends GenericBaseDao<MemSumReportTemplate, MemSumReportTemplateExample, MemSumReportTemplateKey> {
	
	/**
	 * @Title:exProc_pro_updOsrs2 
	 * @Description:调用 pro_updOsrs2 存储过程
	 * @author 谢美团
	 * @param paramMap 
	 * @throws
	 * @retrun void
	 */ 
	public void exProc_pro_updOsrs2(Map<String,Object> paramMap);
}