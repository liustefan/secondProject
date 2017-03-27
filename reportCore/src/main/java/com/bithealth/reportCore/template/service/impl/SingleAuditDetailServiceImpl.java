package com.bithealth.reportCore.template.service.impl;

import java.util.List;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.template.dao.SingleAuditDetailMapper;
import com.bithealth.reportCore.template.model.SingleAuditDetail; 
import com.bithealth.reportCore.template.model.SingleAuditDetailExample;
import com.bithealth.reportCore.template.service.SingleAuditDetailService;
import com.bithealth.reportCore.template.model. SingleAuditDetailKey; 

@Service("singleauditdetailService") 
public class SingleAuditDetailServiceImpl extends GenericBaseServiceImpl<SingleAuditDetail,SingleAuditDetailExample,
      SingleAuditDetailKey> implements SingleAuditDetailService {
          
    @Resource SingleAuditDetailMapper singleauditdetailMapper;
        
    @Override
    public GenericBaseDao<SingleAuditDetail,SingleAuditDetailExample,  SingleAuditDetailKey > getDao() {
        return singleauditdetailMapper;
    }

	public int insertBatch(List<SingleAuditDetail> list) {
		if(list != null && list.size() > 0){
			return singleauditdetailMapper.insertByBatch(list);
		}else{
			return 0;
		}
	}  
}
