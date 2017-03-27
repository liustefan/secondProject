/*
 * SummaryRelationMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-15 Created
 */
package com.bithealth.reportCore.template.dao;

import java.util.List;

import com.bithealth.reportCore.template.model.SummaryRelation;
import com.bithealth.reportCore.template.model.SummaryRelationExample;
import com.bithealth.reportCore.template.model.SummaryRelationKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface SummaryRelationMapper extends GenericBaseDao<SummaryRelation, SummaryRelationExample, SummaryRelationKey> {
	
	/**
	 * @Title:deleteSummaryRelationByList 
	 * @Description:批量删除汇总模板关联的单项模板
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int deleteSummaryRelationByList(List<SummaryRelation> list);
	
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