package com.bithealth.reportCore.template.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.reportCore.template.model.SummaryRelation;
import com.bithealth.reportCore.template.model.SummaryRelationExample; 
import com.bithealth.reportCore.template.model. SummaryRelationKey; 

public interface SummaryRelationService extends GenericBaseService<SummaryRelation,SummaryRelationExample,SummaryRelationKey > { 
	
	
	/**
	 * @Title:deleteSummaryRelationByList 
	 * @Description:批量删除汇总模板关联的单项模板 
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int deleteSummaryRelationByList (List<SummaryRelation> list);
	
	
	/**
	 * @Title:insertByBatch 
	 * @Description:批量插入
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int insertByBatch(List<SummaryRelation> list);
	
}
