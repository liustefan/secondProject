/**
 * @PackageName:      com.bithealth.orgainCore.service
 * @FileName:     OrgService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月12日 下午3:30:17  
 * 
 */
package com.bithealth.orgainCore.service;

import com.bithealth.orgainCore.model.Org;
import com.bithealth.orgainCore.model.OrgExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: OrgService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月12日 下午3:30:17 
 * 
 * @author liuhm
 * @version  
 */
public interface OrgService extends GenericBaseService<Org, OrgExample, Integer> {
	
	int getMaxOrger(int parentId);
	
	/**
	 * 
	 * @Title:selectExistByName 
	 * @Description:同级下同名的组织. 
	 * @author liuhm
	 * @param orgName
	 * @param parentId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun Org
	 */
	Org selectExistByName(String orgName, int parentId);
	
	/**
	 * 
	 * @Title:selectExistByCode 
	 * @Description:相同编号的组织 
	 * @author liuhm
	 * @param code
	 * @return 
	 * @param 
	 * @throws
	 * @retrun Org
	 */
	Org selectExistByCode(String code);
	
	/**
	 * 
	 * @Title:selectAllSharedOrg 
	 * @Description:返回当前组织的所有共享父组织. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param orgId
	 * @param isCurrent true包含当前组织，false 排除当前组织
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String 
	 */
	String selectAllSharedOrg(int orgId, boolean isCurrent);

}
