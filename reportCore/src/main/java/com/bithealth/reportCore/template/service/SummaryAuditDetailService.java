package com.bithealth.reportCore.template.service;

import java.util.List;

import com.bithealth.reportCore.template.model.SummaryAuditDetail;
import com.bithealth.reportCore.template.model.SummaryAuditDetailExample;
import com.bithealth.reportCore.template.model.SummaryAuditDetailKey;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface SummaryAuditDetailService extends GenericBaseService<SummaryAuditDetail,SummaryAuditDetailExample,SummaryAuditDetailKey > {    
	
	/**
	 * @Title:insertBatch 
	 * @Description:批量插入 
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int insertBatch(List<SummaryAuditDetail> list);
	
}
