/*
 * Uai3Mapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-19 Created
 */
package com.bithealth.questionCore.audit.dao;

import com.bithealth.questionCore.audit.model.Uai3;
import com.bithealth.questionCore.audit.model.Uai3Example;
import com.bithealth.questionCore.audit.model.Uai3Key;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface Uai3Mapper extends GenericBaseDao<Uai3, Uai3Example, Uai3Key> {
	
	public Uai3 selectLatestAudit(Integer memberId);
}