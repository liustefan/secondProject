/*
 * ObsrMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.measureCore.bloodSugar.dao;

import java.util.List;

import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.model.ObsrExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface ObsrMapper extends GenericBaseDao<Obsr, ObsrExample, Long> {
	
	List<Obsr> selectBloodSugarByGUID(String memberGUID,Page<Obsr> page);
	
}