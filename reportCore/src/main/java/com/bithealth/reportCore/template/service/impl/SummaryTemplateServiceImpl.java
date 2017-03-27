package com.bithealth.reportCore.template.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.template.dao.SummaryTemplateMapper;
import com.bithealth.reportCore.template.model.SummaryTemplate; 
import com.bithealth.reportCore.template.model.SummaryTemplateExample;
import com.bithealth.reportCore.template.service.SummaryTemplateService;

@Service("summarytemplateService") 
public class SummaryTemplateServiceImpl extends GenericBaseServiceImpl<SummaryTemplate,SummaryTemplateExample,
      Integer> implements SummaryTemplateService {
          
    @Resource 
    SummaryTemplateMapper summarytemplateMapper;
        
    @Override
    public GenericBaseDao<SummaryTemplate,SummaryTemplateExample,  Integer > getDao() {
        return summarytemplateMapper;
    }  
    
	public Integer selectMaxAuditLevelByParams(Integer orgId) {
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("orgId", orgId);
		return summarytemplateMapper.selectMaxAuditLevelByParams(paramsMap);
	} 
}
