package com.bithealth.reportCore.template.service.impl;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.template.dao.AuditOpinionTemplateMapper;
import com.bithealth.reportCore.template.model.AuditOpinionTemplate; 
import com.bithealth.reportCore.template.model.AuditOpinionTemplateExample;
import com.bithealth.reportCore.template.service.AuditOpinionTemplateService;

@Service("auditopiniontemplateService") 
public class AuditOpinionTemplateServiceImpl extends GenericBaseServiceImpl<AuditOpinionTemplate,AuditOpinionTemplateExample,
      Integer> implements AuditOpinionTemplateService {
          
    @Resource AuditOpinionTemplateMapper auditopiniontemplateMapper;
        
    @Override
    public GenericBaseDao<AuditOpinionTemplate,AuditOpinionTemplateExample,  Integer > getDao() {
        return auditopiniontemplateMapper;
    }  
}
