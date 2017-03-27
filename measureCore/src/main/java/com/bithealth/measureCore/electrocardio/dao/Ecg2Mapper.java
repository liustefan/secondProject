/*
 * Ecg2Mapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Ecg2Example;
import com.bithealth.measureCore.electrocardio.model.Ecg2Key;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface Ecg2Mapper extends GenericBaseDao<Ecg2, Ecg2Example, Ecg2Key> {
	
	public void addEcg2List(@Param("list")List<Ecg2> ecg2);
	
}