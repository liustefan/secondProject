/*
 * OsbpMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-29 Created
 */
package com.bithealth.measureCore.bloodPressure.dao;

import java.util.List;

import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface OsbpMapper extends GenericBaseDao<Osbp, OsbpExample, Long> {
	
	List<Osbp> selectBloodPresListByGUID(String memberGUID ,Page<Osbp> page);
}