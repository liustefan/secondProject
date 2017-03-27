/*
 * OecgMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.dao;

import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface OecgMapper extends GenericBaseDao<Oecg, OecgExample, Long> {
	
	int insert(Oecg oecg);
}