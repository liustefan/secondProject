/*
 * MemberMovmentMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-25 Created
 */
package com.bithealth.memberCore.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bithealth.memberCore.member.model.MemberMovment;
import com.bithealth.memberCore.member.model.MemberMovmentExample;
import com.bithealth.memberCore.member.vo.MovementCondition;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemberMovmentMapper extends GenericBaseDao<MemberMovment, MemberMovmentExample, Integer> {
	
	public List<MemberMovment> selectByPage(Map<String, Object> param);
	
	public int countMovments(Map<String, Object> param);
}