/*
 * SingleReportMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.reportCore.report.model.SingleReport;
import com.bithealth.reportCore.report.model.SingleReportExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface SingleReportMapper extends GenericBaseDao<SingleReport, SingleReportExample, Integer> {
	
	/**
	 * @Title:selectBySumReportId 
	 * @Description:根据汇总报告id查询其关联的单项报告列表
	 * @author 谢美团
	 * @param sumReportId
	 * @return 
	 * @throws
	 * @retrun List<SingleReport>
	 */ 
	public List<SingleReport> selectBySumReportId(Integer sumReportId);
	
	
	/**
	 * @Title:selectByDocidAndOrgid 
	 * @Description:根据医生id和组织id关联查询单项报告列表
	 * @author 谢美团
	 * @param paramsMap
	 * @return 
	 * @throws
	 * @retrun List<SingleReport>
	 */ 
	public List<SingleReport> selectByDocidAndOrgid(Page<SingleReport> page,Map<String, Object> paramsMap);
	
}