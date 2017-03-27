package com.bithealth.reportCore.report.service.impl;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.report.dao.SummaryReportRelationMapper;
import com.bithealth.reportCore.report.model.SummaryReportRelation; 
import com.bithealth.reportCore.report.model.SummaryReportRelationExample;
import com.bithealth.reportCore.report.service.SummaryReportRelationService;
import com.bithealth.reportCore.report.model. SummaryReportRelationKey; 

@Service("summaryreportrelationService") 
public class SummaryReportRelationServiceImpl extends GenericBaseServiceImpl<SummaryReportRelation,SummaryReportRelationExample,
      SummaryReportRelationKey> implements SummaryReportRelationService {
          
    @Resource SummaryReportRelationMapper summaryreportrelationMapper;
        
    @Override
    public GenericBaseDao<SummaryReportRelation,SummaryReportRelationExample,  SummaryReportRelationKey > getDao() {
        return summaryreportrelationMapper;
    }  
}
