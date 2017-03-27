/**
 * @PackageName:      com.bithealth.memberCore.group.service
 * @FileName:     MemToGroupService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月29日 下午5:10:20  
 * 
 */
package com.bithealth.memberCore.group.service;

import java.util.List;

import com.bithealth.memberCore.group.model.MemToGroupExample;
import com.bithealth.memberCore.group.model.MemToGroupKey;
import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MemToGroupService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月29日 下午5:10:20 
 * 
 * @author liuhm
 * @version  
 */
public interface MemToGroupService extends GenericBaseService<MemToGroupKey, MemToGroupExample, MemToGroupKey> {
	
	/**
	 * 
	 * @Title:insertBatch 
	 * @Description:批量保存会员与分组的关系.一个分组绑多个会员 
	 * @author liuhm
	 * @param list
	 * @param group
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int insertBatchByGroup(List<Member> list, MemberGroup group);
	
	/**
	 * 
	 * @Title:insertBatchByMember 
	 * @Description:批量保存会员与分组的关系.一个会员绑多个分组 . 
	 * @author liuhm
	 * @param list
	 * @param member
	 * @param docAuthGroups 医生具有的权限
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int insertBatchByMember(List<MemberGroup> list, Member member, List<MemberGroup> docAuthGroups);
	
	/**
	 * 
	 * @Title:insertBatch 
	 * @Description:批量分配会员分组. 
	 * @author liuhm
	 * @param groupList
	 * @param memberList
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int insertBatch(List<MemberGroup> groupList, List<Member> memberList);
	
	int countByMemAndGrpId(Integer memberId, Integer grpId);

}
