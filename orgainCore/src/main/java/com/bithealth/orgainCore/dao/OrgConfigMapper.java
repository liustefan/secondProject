/*
 * OrgConfigMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-11 Created
 */
package com.bithealth.orgainCore.dao;

import com.bithealth.orgainCore.model.OrgConfig;
import com.bithealth.orgainCore.model.OrgConfigExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface OrgConfigMapper extends GenericBaseDao<OrgConfig, OrgConfigExample, Integer> {
	
	/**
	 * 
	 * @Title:selectByOrg 
	 * @Description:获取组织的配置. 
	 * @author liuhm
	 * @param orgID
	 * @return 
	 * @param 
	 * @throws
	 * @retrun OrgConfig
	 */
	public OrgConfig selectByOrg(Integer orgID);
}