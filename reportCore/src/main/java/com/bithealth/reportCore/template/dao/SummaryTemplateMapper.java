/*
 * SummaryTemplateMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-13 Created
 */
package com.bithealth.reportCore.template.dao;

import java.util.Map;

import com.bithealth.reportCore.template.model.SummaryTemplate;
import com.bithealth.reportCore.template.model.SummaryTemplateExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface SummaryTemplateMapper extends GenericBaseDao<SummaryTemplate, SummaryTemplateExample, Integer> {
	
	public Integer selectMaxAuditLevelByParams(Map paramsMap);
	
}