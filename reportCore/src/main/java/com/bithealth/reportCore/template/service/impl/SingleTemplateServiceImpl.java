package com.bithealth.reportCore.template.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.template.dao.SingleTemplateMapper;
import com.bithealth.reportCore.template.model.SingleTemplate; 
import com.bithealth.reportCore.template.model.SingleTemplateExample;
import com.bithealth.reportCore.template.service.SingleTemplateService;

@Service("singletemplateService") 
public class SingleTemplateServiceImpl extends GenericBaseServiceImpl<SingleTemplate,SingleTemplateExample,
      Integer> implements SingleTemplateService {
          
    @Resource 
    SingleTemplateMapper singletemplateMapper;
        
    @Override
    public GenericBaseDao<SingleTemplate,SingleTemplateExample,  Integer > getDao() {
        return singletemplateMapper;
    }
    
	public List<SingleTemplate> selectSingleTemplateBySummaryCode(Integer sumRepTempCode) {
		
		return singletemplateMapper.selectSingleTemplateBySummaryCode(sumRepTempCode);
		
	}
	
	public List<SingleTemplate> selectByOrgId(Integer orgId) {
		
		return singletemplateMapper.selectByOrgId(orgId);
	}

	public Integer selectMaxAuditLevelByParams(Integer orgId,Short funId,Short optId) {
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("orgId", orgId);
		paramsMap.put("funId", funId);
		paramsMap.put("optId", optId);
		return singletemplateMapper.selectMaxAuditLevelByParams(paramsMap);
	}

	public List<SingleTemplate> selectOtherSingelTemplateList(Integer sumRepTempCode, Integer orgId) {
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("orgId", orgId);
		paramsMap.put("sumRepTempCode", sumRepTempCode);
		return singletemplateMapper.selectOtherSingelTemplateList(paramsMap);
	}  
}
