/*
 * SingleTemplateMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-13 Created
 */
package com.bithealth.reportCore.template.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.reportCore.template.model.SingleTemplate;
import com.bithealth.reportCore.template.model.SingleTemplateExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface SingleTemplateMapper extends GenericBaseDao<SingleTemplate, SingleTemplateExample, Integer> {
	
	public List<SingleTemplate> selectSingleTemplateBySummaryCode(Integer sumRepTempCode) ;
	
	public List<SingleTemplate> selectByOrgId(Integer orgId) ;
	
	public Integer selectMaxAuditLevelByParams(Map paramsMap);
	
	public List<SingleTemplate> selectOtherSingelTemplateList(Map paramsMap);
	
	
}