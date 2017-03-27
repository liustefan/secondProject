/*
 * Cam2Mapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-19 Created
 */
package com.bithealth.questionCore.audit.dao;

import com.bithealth.questionCore.audit.model.Cam2;
import com.bithealth.questionCore.audit.model.Cam2Example;
import com.bithealth.questionCore.audit.model.Cam2Key;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface Cam2Mapper extends GenericBaseDao<Cam2, Cam2Example, Cam2Key> {

	public Cam2 selectLatestAudit(Integer memberId);
	
}