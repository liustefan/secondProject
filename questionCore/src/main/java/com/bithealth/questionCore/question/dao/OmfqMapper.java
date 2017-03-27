/*
 * OmfqMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.dao;

import org.apache.ibatis.annotations.Param;

import com.bithealth.questionCore.question.model.Omfq;
import com.bithealth.questionCore.question.model.OmfqExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface OmfqMapper extends GenericBaseDao<Omfq, OmfqExample, Integer> {
	
	String selectSingleQuestionMaxQustCode(@Param("orgId")Integer orgId, @Param("qustTag")String excTag);
	String selectSingleQuestionMaxQustVerByName(@Param("orgId")Integer orgId, @Param("qustName")String name, @Param("qustTag")String excTag);
}