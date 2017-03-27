/*
 * OasrMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-19 Created
 */
package com.bithealth.questionCore.audit.dao;

import java.util.List;

import com.bithealth.questionCore.audit.model.Oasr;
import com.bithealth.questionCore.audit.model.OasrExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface OasrMapper extends GenericBaseDao<Oasr, OasrExample, Long> {
	
	List<Oasr> selectSingleAnswerAuditByExampleAndPage(Page<Oasr> page, OasrExample example);
	
	List<Oasr> selectComAnswerAuditByExampleAndPage(Page<Oasr> page, OasrExample example);
}