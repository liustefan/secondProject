/*
 * MemToGroupMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.group.dao;

import java.util.List;

import com.bithealth.memberCore.group.model.MemToGroupExample;
import com.bithealth.memberCore.group.model.MemToGroupKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemToGroupMapper extends GenericBaseDao<MemToGroupKey, MemToGroupExample, MemToGroupKey> {
	
	/**
	 * 
	 * @Title:insertBatch 
	 * @Description:批量保存会员与分组的关系. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param list
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int insertBatch(List<MemToGroupKey> list);
}