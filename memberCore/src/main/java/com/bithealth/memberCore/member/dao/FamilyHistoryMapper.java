/*
 * FamilyHistoryMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.dao;

import java.util.List;

import com.bithealth.memberCore.member.model.FamilyHistory;
import com.bithealth.memberCore.member.model.FamilyHistoryExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface FamilyHistoryMapper extends GenericBaseDao<FamilyHistory, FamilyHistoryExample, Long> {
	
	/**
	 * 
	 * @Title:insetBatch 
	 * @Description:批量保存家族病史. 
	 * @author liuhm
	 * @param list
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int insetBatch(List<FamilyHistory> list);
}