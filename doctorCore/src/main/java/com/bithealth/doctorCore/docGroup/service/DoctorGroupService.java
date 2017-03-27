/**
 * @PackageName:      com.bithealth.doctorCore.docGroup.service
 * @FileName:     DoctorGroupService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月27日 上午11:20:14  
 * 
 */
package com.bithealth.doctorCore.docGroup.service;

import com.bithealth.doctorCore.docGroup.model.DoctorGroup;
import com.bithealth.doctorCore.docGroup.model.DoctorGroupExample;
import com.bithealth.doctorCore.docGroup.model.DoctorGroupExt;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: DoctorGroupService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月27日 上午11:20:14 
 * 
 * @author liuhm
 * @version  
 */
public interface DoctorGroupService extends
		GenericBaseService<DoctorGroup, DoctorGroupExample, Integer> {
	
	/**
	 * 
	 * @Title:checkGroupExist 
	 * @Description:校验医生分组是否存在 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param orgId
	 * @param parentId
	 * @param groupName
	 * @return 
	 * @param 
	 * @throws
	 * @retrun DoctorGroup
	 */
	DoctorGroup checkGroupExist(Integer orgId, Integer parentId,String groupName);
	
	/**
	 * 
	 * @Title:bindAuthority 
	 * @Description:给分组绑定审核权限. 
	 * @author liuhm
	 * @param group
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	boolean bindAuthority(DoctorGroup group);
	
	/**
	 * 
	 * @Title:selectGrpWithMemGrpById 
	 * @Description: 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param id
	 * @return 
	 * @param 
	 * @throws
	 * @retrun DoctorGroupExt
	 */
	DoctorGroupExt selectGrpWithMemGrpById(Integer id);
	
	/**
	 * 
	 * @Title:getDefaultOrder 
	 * @Description:获取默认排序号. 
	 * @author liuhm
	 * @param parentId
	 * @param orgId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int getDefaultOrder(int parentId, int orgId);
	
	/**
	 * 
	 * @Title:updateTemParam 
	 * @Description:依据功能ID/选项ID/组织ID清空模板参数
	 * @author liuhm
	 * @param orgId
	 * @param funId
	 * @param optId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int updateTemParamClear(Integer orgId, Short funId, Short optId);

}
