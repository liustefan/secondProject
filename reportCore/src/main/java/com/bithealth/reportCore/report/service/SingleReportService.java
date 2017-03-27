package com.bithealth.reportCore.report.service;

import java.util.List;
import java.util.Map;

import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.reportCore.report.model.AuditProgress;
import com.bithealth.reportCore.report.model.SingleReport;
import com.bithealth.reportCore.report.model.SingleReportExample; 

public interface SingleReportService extends GenericBaseService<SingleReport,SingleReportExample,Integer > {    
	
	/**
	 * @Title:selectBySumReportId 
	 * @Description:根据汇总报告查询其所关联的单项报告列表
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
	public List<SingleReport> selectByDocidAndOrgid(Page<SingleReport> page,int docId ,int orgId);
	
}
