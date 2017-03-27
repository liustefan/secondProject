package com.bithealth.reportCore.template.service.impl;

import java.util.List;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.template.dao.SummaryAuditDetailMapper;
import com.bithealth.reportCore.template.model.SummaryAuditDetail; 
import com.bithealth.reportCore.template.model.SummaryAuditDetailExample;
import com.bithealth.reportCore.template.service.SummaryAuditDetailService;
import com.bithealth.reportCore.template.model. SummaryAuditDetailKey; 

@Service("summaryauditdetailService") 
public class SummaryAuditDetailServiceImpl extends GenericBaseServiceImpl<SummaryAuditDetail,SummaryAuditDetailExample,
      SummaryAuditDetailKey> implements SummaryAuditDetailService {
          
    @Resource 
    SummaryAuditDetailMapper summaryauditdetailMapper;
        
    @Override
    public GenericBaseDao<SummaryAuditDetail,SummaryAuditDetailExample,  SummaryAuditDetailKey > getDao() {
        return summaryauditdetailMapper;
    }

	public int insertBatch(List<SummaryAuditDetail> list) {
		if(list != null && list.size() > 0){
			return summaryauditdetailMapper.insertByBatch(list);
		}else{
			return 0;
		}
	}  
}
