/*
 * MemberBasicInfoMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.ucCore.uc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.ucCore.uc.model.MemberBasicInfo;
import com.bithealth.ucCore.uc.model.MemberBasicInfoExample;
import com.bithealth.ucCore.uc.result.MemberBase;

public interface MemberBasicInfoMapper extends GenericBaseDao<MemberBasicInfo, MemberBasicInfoExample, Integer> {
	
	/**
	 * @Title:selectByMemberIDs 
	 * @Description:根据会ID查询会员基本资料
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun List<MemberBasicInfo>
	 */ 
	public List<MemberBasicInfo> selectByMemberIDs(List<String> list);
	
	/**
	 * @Title:selectMemberBySearchParam 
	 * @Description:根据参数查询会员 
	 * @author 谢美团
	 * @param param
	 * @return 
	 * @throws
	 * @retrun List<MemberBasicInfo>
	 */ 
	public List<MemberBasicInfo> selectMemberBySearchParam(String param);
	
	
	/**
	 * @Title:selectMemberByParamAccount 
	 * @Description:根据账号和密码获取会员的基本信息 
	 * @author 谢美团
	 * @param account
	 * @param pwd
	 * @return 
	 * @throws
	 * @retrun List<MemberBasicInfo>
	 */ 
	public List<MemberBasicInfo> selectMemberByAccountAndPwd(Map<String, String> map);
	
	/**
	 * @Title:selectByIdCareOrMemberNameAndTel 
	 * @Description:唯一性验证，通过身份证号 或者 姓名加手机号的条件查询会员 
	 * @author 谢美团
	 * @param memberBasicInfo
	 * @return 
	 * @throws
	 * @retrun List<MemberBasicInfo>
	 */ 
	public List<MemberBasicInfo> selectByIdCareOrMemberNameAndTel(MemberBasicInfo memberBasicInfo);
	
	/**
	 * 
	 * @Title:selectMemberByDetail 
	 * @Description:根据姓名，身份证，手机号查找会员. 
	 * @author liuhm
	 * @param map
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemberBase>
	 */
	public List<MemberBase> selectMemberByDetail(@Param("memberName")String memberName, @Param("idcard")String idcard, @Param("tel")String tel);
	
	/**
	 * 
	 * @Title:selectByAccount 
	 * @Description:根据帐号查找会员 
	 * @author liuhm
	 * @param account
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberBasicInfo
	 */
	public MemberBasicInfo selectByAccount(String account);
	
	/**
	 * 
	 * @Title:selectByTelNameAndIdcardNull 
	 * @Description:姓名和手机号找会员，并且身份证为空. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param memberName
	 * @param tel
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemberBasicInfo>
	 */
	public List<MemberBasicInfo> selectByTelNameAndIdcardNull(@Param("name")String memberName, @Param("tel")String tel);
	
}