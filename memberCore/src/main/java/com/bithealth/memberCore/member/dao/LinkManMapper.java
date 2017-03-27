/*
 * LinkManMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.dao;

import java.util.List;

import com.bithealth.memberCore.member.model.LinkMan;
import com.bithealth.memberCore.member.model.LinkManExample;
import com.bithealth.memberCore.member.model.LinkManKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface LinkManMapper extends GenericBaseDao<LinkMan, LinkManExample, LinkManKey> {
	
	/**
	 * 
	 * @Title:insertBatch 
	 * @Description:批量保存会员紧急联系人. 
	 * @author liuhm
	 * @param list
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int insertBatch(List<LinkMan> list);
}