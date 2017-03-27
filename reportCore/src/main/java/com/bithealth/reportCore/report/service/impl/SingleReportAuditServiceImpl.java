package com.bithealth.reportCore.report.service.impl;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.report.dao.SingleReportAuditMapper;
import com.bithealth.reportCore.report.model.SingleReportAudit; 
import com.bithealth.reportCore.report.model.SingleReportAuditExample;
import com.bithealth.reportCore.report.service.SingleReportAuditService;

@Service("singlereportauditService") 
public class SingleReportAuditServiceImpl extends GenericBaseServiceImpl<SingleReportAudit,SingleReportAuditExample,
      Integer> implements SingleReportAuditService {
          
    @Resource SingleReportAuditMapper singlereportauditMapper;
        
    @Override
    public GenericBaseDao<SingleReportAudit,SingleReportAuditExample,  Integer > getDao() {
        return singlereportauditMapper;
    }  
}
