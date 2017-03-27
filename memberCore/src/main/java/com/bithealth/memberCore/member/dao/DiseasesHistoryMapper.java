/*
 * DiseasesHistoryMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.dao;

import java.util.List;

import com.bithealth.memberCore.member.model.DiseasesHistory;
import com.bithealth.memberCore.member.model.DiseasesHistoryExample;
import com.bithealth.memberCore.member.model.DiseasesHistoryKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface DiseasesHistoryMapper extends GenericBaseDao<DiseasesHistory, DiseasesHistoryExample, DiseasesHistoryKey> {
	
	/**
	 * 
	 * @Title:insertBatch 
	 * @Description:批量保存会员疾病史. 
	 * @author liuhm
	 * @param list
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int insertBatch(List<DiseasesHistory> list);
}