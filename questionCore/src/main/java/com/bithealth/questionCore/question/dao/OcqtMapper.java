/*
 * OcqtMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.dao;

import org.apache.ibatis.annotations.Param;

import com.bithealth.questionCore.question.model.Ocqt;
import com.bithealth.questionCore.question.model.OcqtExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface OcqtMapper extends GenericBaseDao<Ocqt, OcqtExample, Integer> {
	
	Integer selectComQuestionMaxQustCode(@Param("orgId")Integer orgId, @Param("qustTag")String excTag);
	String selectComQuestionMaxQustVerByName(@Param("orgId")Integer orgId, @Param("combQustName")String name, @Param("qustTag")String excTag);
}