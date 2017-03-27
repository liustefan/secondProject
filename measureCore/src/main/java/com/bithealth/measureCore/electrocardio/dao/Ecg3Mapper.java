/*
 * Ecg3Mapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.measureCore.electrocardio.model.Ecg3;
import com.bithealth.measureCore.electrocardio.model.Ecg3Example;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface Ecg3Mapper extends GenericBaseDao<Ecg3, Ecg3Example, String> {
	
	void addEcg3List(@Param("list")List<Ecg3> ecg3);
}