/**
 * @PackageName:      com.bithealth.memberCore.group.service
 * @FileName:     MemberGroupService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月28日 下午1:44:23  
 * 
 */
package com.bithealth.memberCore.group.service;

import java.util.List;

import com.bithealth.memberCore.group.model.MemGroupExt;
import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.group.model.MemberGroupExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MemberGroupService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 下午1:44:23 
 * 
 * @author liuhm
 * @version  
 */
public interface MemberGroupService extends
		GenericBaseService<MemberGroup, MemberGroupExample, Integer> {
	
	/**
	 * 
	 * @Title:checkGroupExist 
	 * @Description:校验会员分组是否存在 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param orgId
	 * @param parentId
	 * @param groupName
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberGroup
	 */
	MemberGroup checkGroupExist(Integer orgId, Integer parentId,String groupName);
	
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
	
	/**
	 * 
	 * @Title:selectByDoctorAndOrg 
	 * @Description:查询当前组织下，当前医生管理的会员分组. 
	 * @author liuhm
	 * @param doctorId
	 * @param orgId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemberGroup>
	 */
	List<MemberGroup> selectByDoctorAndOrg(Integer doctorId, Integer orgId);
	
	/**
	 * 
	 * @Title:getMaxOrder 
	 * @Description:获取某个节点下的默认排序号. 
	 * @author liuhm
	 * @param parentId
	 * @param orgId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int getMaxOrder(int parentId, int orgId);
	
}
