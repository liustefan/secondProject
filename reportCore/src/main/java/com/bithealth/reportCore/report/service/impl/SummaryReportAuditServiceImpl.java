package com.bithealth.reportCore.report.service.impl;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.report.dao.SummaryReportAuditMapper;
import com.bithealth.reportCore.report.model.SummaryReportAudit; 
import com.bithealth.reportCore.report.model.SummaryReportAuditExample;
import com.bithealth.reportCore.report.service.SummaryReportAuditService;

@Service("summaryreportauditService") 
public class SummaryReportAuditServiceImpl extends GenericBaseServiceImpl<SummaryReportAudit,SummaryReportAuditExample,
      Integer> implements SummaryReportAuditService {
          
    @Resource SummaryReportAuditMapper summaryreportauditMapper;
        
    @Override
    public GenericBaseDao<SummaryReportAudit,SummaryReportAuditExample,  Integer > getDao() {
        return summaryreportauditMapper;
    }  
}
