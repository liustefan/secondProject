/*
 * MemberAccountMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.ucCore.uc.dao;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.ucCore.uc.model.MemberAccount;
import com.bithealth.ucCore.uc.model.MemberAccountExample;

public interface MemberAccountMapper extends GenericBaseDao<MemberAccount, MemberAccountExample, Integer> {
	
	int insertBatch(List<MemberAccount> list);
}