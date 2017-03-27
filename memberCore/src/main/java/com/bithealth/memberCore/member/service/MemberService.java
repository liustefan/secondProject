/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     MemberService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月30日 上午9:50:15  
 * 
 */
package com.bithealth.memberCore.member.service;


import java.util.List;

import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExample;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.model.SearchCondition;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MemberService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月30日 上午9:50:15 
 * 
 * @author liuhm
 * @version  
 */
public interface MemberService extends GenericBaseService<Member, MemberExample, Integer> {
	
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
	 * @Title:selectMemberExtByUUID 
	 * @Description:根据UUID获取会员详细信息. 
	 * @author liuhm
	 * @param uuid
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberExt
	 */
	MemberExt selectMemberExtByUUID(String uuid);
	
	/**
	 * 
	 * @Title:selectByIdcard 
	 * @Description:身份证查询会员. 
	 * @author liuhm
	 * @param idcard
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun Member
	 */
	public Member selectByIdcard(String idcard);
	
	/**
	 * 
	 * @Title:selectByNameAndTel 
	 * @Description:依据姓名和手机号查询会员. 
	 * @author liuhm
	 * @param tel
	 * @param name
	 * @return 
	 * @param 
	 * @throws
	 * @retrun Member
	 */
	public Member selectByNameAndTel(String tel, String name);
	
	/**
	 * 
	 * @Title:selectByUniqueId 
	 * @Description:依据档案号获取会员. 
	 * @author liuhm
	 * @param uniqueId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun Member
	 */
	public Member selectByUniqueId(String uniqueId);
	
	/**
	 * 
	 * @Title:selectByUUID 
	 * @Description:UUID获取会员. 
	 * @author liuhm
	 * @param UUID
	 * @return 
	 * @param 
	 * @throws
	 * @retrun Member
	 */
	public Member selectByUUID(String UUID, UseTag tag);
	
	/**
	 * 
	 * @Title:updateUseTagByUUID
	 * @Description:更新会员状态. 
	 * 会员注册时的初始状态为R注册中，当UC成功后，更新为T,当异步注册时，失败为B.  
	 * @author liuhm
	 * @param UUID
	 * @param tag
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int updateUseTagByUUID(String UUID, UseTag tag);
	
	/**
	 * 
	 * @Title:deleteByUUID 
	 * @Description:根据UUID删除会员. 
	 * @author liuhm
	 * @param UUID
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int deleteByUUID(String UUID);
	
	/**
	 * 
	 * @Title:deleteById 
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int updateTagById(Integer memberId, UseTag tag);
	
	/**
	 * 
	 * @Title:listMyMemberByPage 
	 * @Description:分页查询我的会员. 
	 * @author liuhm
	 * @param condition
	 * @return 
	 * @param 
	 * @throws
	 * @retrun Page<MemberVo>
	 */
	public Page<MemberVo> listMyMemberByPage(SearchCondition<MemberVo> condition);
	
	/**
	 * 
	 * @Title:selectOtherMemberByPage 
	 * @Description:分页查询其他会员. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param condition
	 * @return 
	 * @param 
	 * @throws
	 * @retrun Page<MemberVo>
	 */
	public Page<MemberVo> listOtherMemberByPage(SearchCondition<MemberVo> condition);
	
	/**
	 * 
	 * @Title:selectAllMemberByPage 
	 * @Description:分页查询所有的会员. 
	 * @author liuhm
	 * @param condition
	 * @return 
	 * @param 
	 * @throws
	 * @retrun Page<MemberVo>
	 */
	public Page<MemberVo> listAllMemberByPage(SearchCondition<MemberVo> condition);
	
	public List<MemberExt> selectMemberExt(Member member);
	
}
