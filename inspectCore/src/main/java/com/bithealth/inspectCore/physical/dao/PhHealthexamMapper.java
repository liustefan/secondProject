/*
 * PhHealthexamMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-27 Created
 */
package com.bithealth.inspectCore.physical.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface PhHealthexamMapper extends GenericBaseDao<PhHealthexam, PhHealthexamExample, Long> {
	
	PhHealthexam selectLatestPhHealthexamByMemberId(Integer memberId);
	
	List<PhHealthexam> selectPhHealthexamList(PhHealthexam pojo);
	
	List<PhHealthexam> selectPage(Page<PhHealthexam> page, @Param("model") PhHealthexam model, @Param("odgpIds") List<Integer> odgpIds);
}