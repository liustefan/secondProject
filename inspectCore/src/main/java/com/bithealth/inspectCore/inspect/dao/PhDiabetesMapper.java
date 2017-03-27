/*
 * PhDiabetesMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.inspectCore.inspect.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface PhDiabetesMapper extends GenericBaseDao<PhDiabetes, PhDiabetesExample, Long> {
	
//	int selectTotalByNum(Integer num);
	PhDiabetes selectLatestPhDiabetesByMemberId(Integer memberId);
	
	List<PhDiabetes> selectPhDiabetesList(PhDiabetes pojo);
	
	List<PhDiabetes> selectPage(Page<PhDiabetes> page, @Param("model") PhDiabetes model, @Param("odgpIds") List<Integer> odgpIds);
}