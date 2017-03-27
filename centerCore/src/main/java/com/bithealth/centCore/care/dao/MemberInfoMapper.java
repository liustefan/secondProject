/*
 * MemberBasicInfoMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.centCore.care.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.centCore.care.model.MemberBasicInfo;
import com.bithealth.centCore.care.model.MemberBasicInfoExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemberInfoMapper extends GenericBaseDao<MemberBasicInfo, MemberBasicInfoExample, Integer> {
	
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
	
	
	
	
	
}