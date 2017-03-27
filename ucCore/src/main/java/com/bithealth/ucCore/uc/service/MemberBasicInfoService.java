package com.bithealth.ucCore.uc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.ucCore.uc.model.MemberBasicInfo;
import com.bithealth.ucCore.uc.model.MemberBasicInfoExample; 
import com.bithealth.ucCore.uc.result.MemberBase;

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
	
	
	/**
	 * @Title:selectByIdCareOrMemberNameAndTel 
	 * @Description:通过身份证号 或者 手机号+姓名 的条件查询会员
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
	public List<MemberBase> selectMemberByDetail(String memberName, String idcard, String tel);
	
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
	 * @Title:selectByIdcard 
	 * @Description:身份证查找会员. 
	 * @author liuhm
	 * @param idcard
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberBasicInfo
	 */
	public MemberBasicInfo selectByIdcard(String idcard);
	
	/**
	 * 
	 * @Title:countByTel 
	 * @Description:用手机号从基本资料中查找会员. 
	 * @author liuhm
	 * @param tel
	 * @return 
	 * @param 
	 * @throws
	 * @retrun Integer
	 */
	public Integer countByTel(String tel, String memberGuid);
	
	/**
	 * 
	 * @Title:selectByGuid 
	 * @Description:依据MemberGuid查找会员. 
	 * @author liuhm
	 * @param guid
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberBasicInfo
	 */
	public MemberBasicInfo selectByGuid(String guid);
	
	/**
	 * 
	 * @Title:selectByNameAndTel 
	 * @Description:会员姓名+手机号，完善情况查询会员. 
	 * @author liuhm
	 * @param name
	 * @param tel
	 * @param isInfoPerfect
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberBasicInfo
	 */
	public MemberBasicInfo selectByNameAndTel(String name, String tel, Byte isInfoPerfect);
	
	/**
	 * 
	 * @Title:updateLabel 
	 * @Description:修改已认证标识. 
	 * @author liuhm
	 * @param perfect
	 * @param verified
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int updateLabel(Byte verified, String memberGuid);
	
}
