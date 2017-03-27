/*
 * ManageschemeExecTaskMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.healthCore.managescheme.dao;

import java.util.List;

import com.bithealth.healthCore.managescheme.model.ManageschemeExecTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTaskExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface ManageschemeExecTaskMapper extends GenericBaseDao<ManageschemeExecTask, ManageschemeExecTaskExample, Long> {
	
	List<ManageschemeExecTask> selectManageschemeTaskPage(Page<ManageschemeExecTask> page, ManageschemeExecTask model);
	
	List<ManageschemeExecTask> selectByMasterId(Long masterId);
	
	int deleteByMSDesignID(Integer MSDesignID);
}