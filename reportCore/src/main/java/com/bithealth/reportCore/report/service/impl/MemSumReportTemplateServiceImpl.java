package com.bithealth.reportCore.report.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.report.dao.MemSumReportTemplateMapper;
import com.bithealth.reportCore.report.model.MemSumReportTemplate; 
import com.bithealth.reportCore.report.model.MemSumReportTemplateExample;
import com.bithealth.reportCore.report.service.MemSumReportTemplateService;
import com.bithealth.reportCore.report.model. MemSumReportTemplateKey; 

@Service("memsumreporttemplateService") 
public class MemSumReportTemplateServiceImpl extends GenericBaseServiceImpl<MemSumReportTemplate,MemSumReportTemplateExample,
      MemSumReportTemplateKey> implements MemSumReportTemplateService {
          
    @Resource MemSumReportTemplateMapper memsumreporttemplateMapper;
        
    @Override
    public GenericBaseDao<MemSumReportTemplate,MemSumReportTemplateExample,  MemSumReportTemplateKey > getDao() {
        return memsumreporttemplateMapper;
    }

	public void exProc_pro_updOsrs2(Integer createId, Integer memberId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("createId", createId);
		paramMap.put("memberId", memberId);
		memsumreporttemplateMapper.exProc_pro_updOsrs2(paramMap);
	}  
}
