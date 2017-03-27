package com.bithealth.reportCore.report.service;

import java.util.List;
import java.util.Map;

import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.reportCore.report.model.SummaryReport;
import com.bithealth.reportCore.report.model.SummaryReportExample; 

public interface SummaryReportService extends GenericBaseService<SummaryReport,SummaryReportExample,Integer > {    
	
	
	/**
	 * @Title:selectByDocIdAndOrgid 
	 * @Description:根据参数关联查询已审核汇总报告列表 
	 * @author 谢美团
	 * @param page
	 * @param docId
	 * @param orgId
	 * @return 
	 * @throws
	 * @retrun List<SummaryReport>
	 */ 
	public List<SummaryReport> selectByDocIdAndOrgid(Page<SummaryReport> page,int docId,int orgId);
	
	/**
	 * @Title:selectMemSumReportList 
	 * @Description:根据会员id查询改会员的汇总报告列表 
	 * @author 谢美团
	 * @param page
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun List<SummaryReport>
	 */ 
	public  List<SummaryReport> selectMemSumReportList(Page<SummaryReport> page,Integer memberId);
}
