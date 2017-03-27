/*
 * MemFamilyCardMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-11 Created
 */
package com.bithealth.memberCore.member.dao;

import java.util.List;

import com.bithealth.memberCore.member.model.MemFamilyCard;
import com.bithealth.memberCore.member.model.MemFamilyCardExample;
import com.bithealth.memberCore.member.model.MemFamilyCardExt;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemFamilyCardMapper extends GenericBaseDao<MemFamilyCard, MemFamilyCardExample, Integer> {
	
	List<MemFamilyCardExt> selectMemCardExtByExample(MemFamilyCardExample example);
	
	/**
	 * 
	 * @Title:insertBatch 
	 * @Description:批量添加家庭成员卡号. 
	 * @author liuhm
	 * @param list
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int insertBatch(List<MemFamilyCard> list);
}