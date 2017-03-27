package com.bithealth.reportCore.template.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bithealth.reportCore.template.dao.SummaryRelationMapper;
import com.bithealth.reportCore.template.model.SummaryRelation;
import com.bithealth.reportCore.template.model.SummaryRelationExample;
import com.bithealth.reportCore.template.model.SummaryRelationKey;
import com.bithealth.reportCore.template.service.SummaryRelationService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Service("summaryrelationService") 
public class SummaryRelationServiceImpl extends GenericBaseServiceImpl<SummaryRelation,SummaryRelationExample,
      SummaryRelationKey> implements SummaryRelationService {
          
    @Resource 
    SummaryRelationMapper summaryrelationMapper;
        
    @Override
    public GenericBaseDao<SummaryRelation,SummaryRelationExample,  SummaryRelationKey > getDao() {
        return summaryrelationMapper;
    }

	public int deleteSummaryRelationByList(List<SummaryRelation> list) {
		if(list != null && list.size() > 0){
			return summaryrelationMapper.deleteSummaryRelationByList(list);
		}else{
			return 0;
		}
	}

	public int insertByBatch(List<SummaryRelation> list) {
		if(list != null && list.size() > 0){
			return summaryrelationMapper.insertByBatch(list);
		}else{
			return 0;
		}
	}  
}
