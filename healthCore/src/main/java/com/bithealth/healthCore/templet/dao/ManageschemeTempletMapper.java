/*
 * ManageschemeTempletMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.healthCore.templet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.healthCore.templet.model.ManageschemeTemplet;
import com.bithealth.healthCore.templet.model.ManageschemeTempletExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface ManageschemeTempletMapper extends GenericBaseDao<ManageschemeTemplet, ManageschemeTempletExample, Integer> {
	
	List<ManageschemeTemplet> selectTempletPage(Page<ManageschemeTemplet> page,ManageschemeTemplet model);
	
	int updateUsedNumber(Integer id);
	
	ManageschemeTemplet selectTemplet(@Param("roleId")Integer roleId, @Param("schemeTitle")String schemeTitle, @Param("id")Integer id, @Param("createID")Integer docId, @Param("superOrgIds")String allSharedOrg);
}