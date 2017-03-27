/*
 * PhHypertensionMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.inspectCore.inspect.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensionExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface PhHypertensionMapper extends GenericBaseDao<PhHypertension, PhHypertensionExample, Long> {
	
//	int selectTotalByNum(Integer num);
	PhHypertension selectLatestPhHypertensionByMemberId(Integer memberId);
	
	List<PhHypertension> selectPhHypertensionList(PhHypertension pojo);
	
	List<PhHypertension> selectPage(Page<PhHypertension> page, @Param("model") PhHypertension model, @Param("odgpIds") List<Integer> odgpIds);
}