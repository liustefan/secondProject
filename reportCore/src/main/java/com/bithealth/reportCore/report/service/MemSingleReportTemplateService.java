package com.bithealth.reportCore.report.service;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.reportCore.report.model.MemSingleReportTemplate;
import com.bithealth.reportCore.report.model.MemSingleReportTemplateExample; 
import com.bithealth.reportCore.report.model. MemSingleReportTemplateKey; 

public interface MemSingleReportTemplateService extends GenericBaseService<MemSingleReportTemplate,MemSingleReportTemplateExample,
   MemSingleReportTemplateKey > {  
	
	/**
	 * @Title:exProc_pro_insOMAS 
	 * @Description:调用 pro_insOMAS 存储过程
	 * @author 谢美团
	 * @param createId
	 * @param createName
	 * @param memberId 
	 * @throws
	 * @retrun void
	 */ 
	public void exProc_pro_insOMAS(Integer createId,String createName,Integer memberId);  
	
	
}
