/*
 * SingleReportAuditMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-25 Created
 */
package com.bithealth.reportCore.report.dao;

import java.util.List;

import com.bithealth.reportCore.report.model.SingleReportAudit;
import com.bithealth.reportCore.report.model.SingleReportAuditExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface SingleReportAuditMapper extends GenericBaseDao<SingleReportAudit, SingleReportAuditExample, Integer> {
	
	public List<SingleReportAudit> selectByID(Integer ID);
}