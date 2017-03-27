/*
 * CareInfoMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-05 Created
 */
package com.bithealth.centCore.care.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.centCore.care.model.CareInfo;
import com.bithealth.centCore.care.model.CareInfoExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface CareInfoMapper extends GenericBaseDao<CareInfo, CareInfoExample, Long> {
	
	/**
	 * @Title:selectBySearchParam 
	 * @Description:根据参数查询会员（多表关联）
	 * @author 谢美团
	 * @param searchParam
	 * @return 
	 * @throws
	 * @retrun List<CareInfo>
	 */ 
	public List<CareInfo> selectBySearchParam(Map<String,String>  parmaMap);
	
	public List<CareInfo> selectMergeData(Map<String,String>  parmaMap);
}