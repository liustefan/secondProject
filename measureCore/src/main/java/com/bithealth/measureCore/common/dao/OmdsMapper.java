/*
 * OmdsMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-22 Created
 */
package com.bithealth.measureCore.common.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.common.model.OmdsExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface OmdsMapper extends GenericBaseDao<Omds, OmdsExample, Long> {
	
	public List<Omds> getOmdsByGUIDAndEnventType(Page<Omds> page ,Map<String, Object> paramMap);
	
}