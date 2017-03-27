package com.bithealth.reportCore.report.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.report.dao.SummaryReportMapper;
import com.bithealth.reportCore.report.model.SummaryReport; 
import com.bithealth.reportCore.report.model.SummaryReportExample;
import com.bithealth.reportCore.report.service.SummaryReportService;

@Service("summaryreportService") 
public class SummaryReportServiceImpl extends GenericBaseServiceImpl<SummaryReport,SummaryReportExample,
      Integer> implements SummaryReportService {
          
    @Resource SummaryReportMapper summaryreportMapper;
        
    @Override
    public GenericBaseDao<SummaryReport,SummaryReportExample,  Integer > getDao() {
        return summaryreportMapper;
    }

	public List<SummaryReport> selectByDocIdAndOrgid(Page<SummaryReport> page,int docId, int orgId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("docId", docId);
		paramMap.put("orgId", orgId);
		return summaryreportMapper.selectByDocIdAndOrgid(page, paramMap);
	}

	
	public List<SummaryReport> selectMemSumReportList(Page<SummaryReport> page,Integer memberId) {
		return summaryreportMapper.selectMemSumReportList(page, memberId);
	}  
}
