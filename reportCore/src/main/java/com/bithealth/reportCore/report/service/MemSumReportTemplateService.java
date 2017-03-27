package com.bithealth.reportCore.report.service;

import com.bithealth.reportCore.report.model.MemSumReportTemplate;
import com.bithealth.reportCore.report.model.MemSumReportTemplateExample;
import com.bithealth.reportCore.report.model.MemSumReportTemplateKey;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface MemSumReportTemplateService extends GenericBaseService<MemSumReportTemplate,MemSumReportTemplateExample, MemSumReportTemplateKey > {   
	
	/**
	 * @Title:exProc_pro_updOsrs2 
	 * @Description:调用存储过程
	 * @author 谢美团
	 * @param creatId
	 * @param memberId 
	 * @throws
	 * @retrun void
	 */ 
	public void exProc_pro_updOsrs2(Integer createId,Integer memberId);
	
	
}
