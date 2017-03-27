package com.bithealth.centCore.care.service;

import java.util.List;

import com.bithealth.centCore.care.model.MemberBasicInfo;
import com.bithealth.centCore.care.model.MemberBasicInfoExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface MemberBasicInfoService extends GenericBaseService<MemberBasicInfo,MemberBasicInfoExample, Integer > {    
	
	/**
	 * @Title:selectByMemberIDs 
	 * @Description:根据会ID查询会员基本资料
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun List<MemberBasicInfo>
	 */ 
	public List<MemberBasicInfo> selectByMemberIDs(List<String> memberIdList);
	
	
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
	 * @Title:getMemberByParamAccount 
	 * @Description:根据账号和密码获取会员的基本信息
	 * @author 谢美团
	 * @param account
	 * @param pwd
	 * @return 
	 * @throws
	 * @retrun List<MemberBasicInfo>
	 */ 
	public List<MemberBasicInfo> selectMemberByAccountAndPwd(String account,String pwd);
	
	
	
}
