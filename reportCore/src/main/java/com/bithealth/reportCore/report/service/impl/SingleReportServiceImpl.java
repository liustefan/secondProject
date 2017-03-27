package com.bithealth.reportCore.report.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.report.dao.SingleReportMapper;
import com.bithealth.reportCore.report.model.SingleReport; 
import com.bithealth.reportCore.report.model.SingleReportExample;
import com.bithealth.reportCore.report.service.SingleReportService;

@Service("singlereportService") 
public class SingleReportServiceImpl extends GenericBaseServiceImpl<SingleReport,SingleReportExample,
      Integer> implements SingleReportService {
          
    @Resource 
    SingleReportMapper singlereportMapper;
        
    @Override
    public GenericBaseDao<SingleReport,SingleReportExample,  Integer > getDao() {
        return singlereportMapper;
    }

	public List<SingleReport> selectBySumReportId(Integer sumReportId) {
		return singlereportMapper.selectBySumReportId(sumReportId);
	}

	public List<SingleReport> selectByDocidAndOrgid(Page<SingleReport> page,int docId ,int orgId) {
		Map<String, Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("docId", docId);
		paramsMap.put("orgId", orgId);
		return singlereportMapper.selectByDocidAndOrgid(page,paramsMap);
	}  
}
