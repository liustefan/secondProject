/**
 * @PackageName:      com.bithealth.orgainCore.service
 * @FileName:     OrgConfigServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月11日 下午5:33:23  
 * 
 */
package com.bithealth.orgainCore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.orgainCore.dao.OrgConfigMapper;
import com.bithealth.orgainCore.model.OrgConfig;
import com.bithealth.orgainCore.model.OrgConfigExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: OrgConfigServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月11日 下午5:33:23 
 * 
 * @author liuhm
 * @version  
 */
@Service("orgConfigService")
public class OrgConfigServiceImpl extends GenericBaseServiceImpl<OrgConfig, OrgConfigExample, Integer> implements OrgConfigService {

	@Autowired
	private OrgConfigMapper orgConfigMapper;
	
	@Override
	public GenericBaseDao<OrgConfig, OrgConfigExample, Integer> getDao() {
		return orgConfigMapper;
	}

	@Override
	public OrgConfig selectByOrgId(Integer orgId) {
		return orgConfigMapper.selectByOrg(orgId);
	}

}
