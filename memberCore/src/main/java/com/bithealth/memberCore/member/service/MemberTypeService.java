/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     MemberTypeService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 下午5:06:46  
 * 
 */
package com.bithealth.memberCore.member.service;

import java.util.List;

import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.model.MemberType;
import com.bithealth.memberCore.member.model.MemberTypeExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MemberTypeService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 下午5:06:46 
 * 
 * @author liuhm
 * @version  
 */
public interface MemberTypeService extends GenericBaseService<MemberType, MemberTypeExample, Short> {
	
	/**
	 * 
	 * @Title:selectByNameAndOrg 
	 * @Description:依据类型名查询组织下会员类型实体. 
	 * @author liuhm
	 * @param typeName
	 * @param orgId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberType
	 */
	public MemberType selectByNameAndOrg(String typeName, Integer orgId);
	
	/**
	 * 
	 * @Title:selectListByOrg 
	 * @Description:获取组织下的会员类型列表. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param orgId
	 * @param UseTag tag
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemberType>
	 */
	List<MemberType> selectListByOrg(Integer orgId, UseTag tag);

}
