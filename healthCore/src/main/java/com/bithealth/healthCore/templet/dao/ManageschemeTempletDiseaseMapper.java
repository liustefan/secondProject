/*
 * ManageschemeTempletDiseaseMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.healthCore.templet.dao;

import java.util.List;

import com.bithealth.healthCore.templet.model.ManageschemeTempletDisease;
import com.bithealth.healthCore.templet.model.ManageschemeTempletDiseaseExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface ManageschemeTempletDiseaseMapper extends GenericBaseDao<ManageschemeTempletDisease, ManageschemeTempletDiseaseExample, Integer> {
	
	List<ManageschemeTempletDisease> selectList(Integer masterId);
}