/*
 * SummaryReportMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.reportCore.report.model.SummaryReport;
import com.bithealth.reportCore.report.model.SummaryReportExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface SummaryReportMapper extends GenericBaseDao<SummaryReport, SummaryReportExample, Integer> {
	
	
	/**
	 * @Title:selectByDocIdAndOrgid 
	 * @Description:通过医生id和组织id关联查询已审核汇总报告列表
	 * @author 谢美团
	 * @param page
	 * @param paramMap
	 * @return 
	 * @throws
	 * @retrun List<SummaryReport>
	 */ 
	public List<SummaryReport> selectByDocIdAndOrgid(Page<SummaryReport> page,Map<String,Object> paramMap);
	
	/**
	 * @Title:selectMemSumReportList 
	 * @Description:根据会与id查询该会员的汇总报告列表
	 * @author 谢美团
	 * @param page
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun List<SummaryReport>
	 */ 
	public List<SummaryReport> selectMemSumReportList(Page<SummaryReport> page,Integer memberId);
}