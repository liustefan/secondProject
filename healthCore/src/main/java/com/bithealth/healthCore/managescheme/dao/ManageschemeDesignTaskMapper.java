/*
 * ManageschemeDesignTaskMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.healthCore.managescheme.dao;

import java.util.List;

import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTaskExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface ManageschemeDesignTaskMapper extends GenericBaseDao<ManageschemeDesignTask, ManageschemeDesignTaskExample, Integer> {

	List<ManageschemeDesignTask> selectByMasterId(Integer masterId);
}