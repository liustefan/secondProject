/*
 * SummaryAuditDetailMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.dao;

import java.util.List;

import com.bithealth.reportCore.template.model.SummaryAuditDetail;
import com.bithealth.reportCore.template.model.SummaryAuditDetailExample;
import com.bithealth.reportCore.template.model.SummaryAuditDetailKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface SummaryAuditDetailMapper extends GenericBaseDao<SummaryAuditDetail, SummaryAuditDetailExample, SummaryAuditDetailKey> {
	
	/**
	 * @Title:insertBatch 
	 * @Description:批量插入
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int insertByBatch(List<SummaryAuditDetail> list);
}