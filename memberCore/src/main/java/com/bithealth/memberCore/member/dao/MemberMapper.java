/*
 * MemberMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExample;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.model.SearchCondition;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemberMapper extends GenericBaseDao<Member, MemberExample, Integer> {
	
	/**
	 * 
	 * @Title:selectMemberExtById 
	 * @Description:获取会员详细信息. 
	 * @author liuhm
	 * @param id
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberExt
	 */
	MemberExt selectMemberExtById(Integer id);
	
	/**
	 * 
	 * @Title:selectMyMembers 
	 * @Description:我的会员列表. 
	 * @author liuhm
	 * @param search
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemberVo>
	 */
	List<MemberVo> exeProMyMembers(SearchCondition<MemberVo> search);
	
	/**
	 * 
	 * @Title:selectOtherMembers 
	 * @Description:其他会员列表. 
	 * @author liuhm
	 * @param search
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemberVo>
	 */
	List<MemberVo> exeProOtherMembers(SearchCondition<MemberVo> search);
	
	/**
	 * 
	 * @Title:selectAllMembers 
	 * @Description:所有会员列表. 
	 * @author liuhm
	 * @param search
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemberVo>
	 */
	List<MemberVo> exeProAllMembers(SearchCondition<MemberVo> search);
	
	/**
	 * 更新状态
	 * @Title:updateUseTagByUUID 
	 * @author liuhm
	 * @param member
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int updateUseTagByUUID(Member member);
	
	List<Map<String, Object>> selectErrorMemberList(Map<String, Object> params);
	
	int countErrorMemberList(Member member);
	
	List<MemberExt> selectMemberExtByExample(MemberExample member);
	
}