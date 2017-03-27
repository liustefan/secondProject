/*
 * ManageschemeExecMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.healthCore.managescheme.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.healthCore.managescheme.model.ManageschemeExec;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface ManageschemeExecMapper extends GenericBaseDao<ManageschemeExec, ManageschemeExecExample, Long> {
	
	List<ManageschemeExec> selectPersonManageschemePage(Page<ManageschemeExec> page, ManageschemeExec model);
	
	List<ManageschemeExec> selectManageschemePage(Page<ManageschemeExec> page, ManageschemeExec model);
	
	int inserts(List<ManageschemeExec> list);
	
	int terminatedManageschemeExec(@Param("docId")Integer docId, @Param("MSDesignID")Integer MSDesignID, @Param("massOffReason")String massOffReason);
	
	int updateSingleTerminatedManageschemeExec(@Param("docId")Integer docId, @Param("MSExecID")Long MSExecID, @Param("massOffReason")String massOffReason);
	
	List<String> selectMemberLabels(Integer memberID);
	
	ManageschemeExec selectHasPersonManageschemeExec(Integer memberID);
}