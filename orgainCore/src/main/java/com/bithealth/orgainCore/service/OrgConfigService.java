/**
 * @PackageName:      com.bithealth.orgainCore.service
 * @FileName:     OrgConfigService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月11日 下午5:32:23  
 * 
 */
package com.bithealth.orgainCore.service;

import com.bithealth.orgainCore.model.OrgConfig;
import com.bithealth.orgainCore.model.OrgConfigExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: OrgConfigService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月11日 下午5:32:23 
 * 
 * @author liuhm
 * @version  
 */
public interface OrgConfigService extends GenericBaseService<OrgConfig, OrgConfigExample, Integer> {
	
	/**
	 * 
	 * @Title:selectByOrgId 
	 * @Description:根据组织ID获取组织配置信息. 
	 * @author liuhm
	 * @param orgId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun OrgConfig
	 */
	public OrgConfig selectByOrgId(Integer orgId);

}
