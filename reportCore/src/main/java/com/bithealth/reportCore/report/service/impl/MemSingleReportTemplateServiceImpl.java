package com.bithealth.reportCore.report.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.report.dao.MemSingleReportTemplateMapper;
import com.bithealth.reportCore.report.model.MemSingleReportTemplate; 
import com.bithealth.reportCore.report.model.MemSingleReportTemplateExample;
import com.bithealth.reportCore.report.service.MemSingleReportTemplateService;
import com.bithealth.reportCore.report.model. MemSingleReportTemplateKey; 

@Service("memsinglereporttemplateService") 
public class MemSingleReportTemplateServiceImpl extends GenericBaseServiceImpl<MemSingleReportTemplate,MemSingleReportTemplateExample,
      MemSingleReportTemplateKey> implements MemSingleReportTemplateService {
          
    @Resource MemSingleReportTemplateMapper memsinglereporttemplateMapper;
        
    @Override
    public GenericBaseDao<MemSingleReportTemplate,MemSingleReportTemplateExample,  MemSingleReportTemplateKey > getDao() {
        return memsinglereporttemplateMapper;
    }

	public void exProc_pro_insOMAS(Integer createId, String createName,Integer memberId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("createId", createId);
		paramMap.put("createName", createName);
		paramMap.put("memberId", memberId);
		memsinglereporttemplateMapper.exProc_pro_insOMAS(paramMap);
	}  
}
