package com.bithealth.reportCore.template.service;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.reportCore.template.model.SummaryTemplate;
import com.bithealth.reportCore.template.model.SummaryTemplateExample; 

public interface SummaryTemplateService extends GenericBaseService<SummaryTemplate,SummaryTemplateExample,Integer > {    
	
	public Integer selectMaxAuditLevelByParams(Integer orgId);
}
