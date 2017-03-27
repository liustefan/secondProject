/*
 * Ecg1Mapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg1Example;
import com.bithealth.measureCore.electrocardio.model.Ecg1Key;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface Ecg1Mapper extends GenericBaseDao<Ecg1, Ecg1Example, Ecg1Key> {
	
	void addEcg1List(@Param("list")List<Ecg1> ecg1);
}