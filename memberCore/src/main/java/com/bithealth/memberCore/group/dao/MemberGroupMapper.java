/*
 * MemberGroupMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.group.dao;

import com.bithealth.memberCore.group.model.MemGroupExt;
import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.group.model.MemberGroupExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemberGroupMapper extends GenericBaseDao<MemberGroup, MemberGroupExample, Integer> {
	
	/**
	 * 
	 * @Title:selectMemGrpExtById 
	 * @Description:查询复杂的会员分组对象，包含关联的会员，医生分组，父节点、子节点. 
	 * @author liuhm
	 * @param id
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemGroupExt
	 */
	MemGroupExt selectMemGrpExtById(Integer id);
	
}