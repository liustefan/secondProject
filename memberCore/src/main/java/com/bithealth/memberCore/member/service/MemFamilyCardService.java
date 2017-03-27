/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     MemFamilyCardService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月12日 下午3:52:22  
 * 
 */
package com.bithealth.memberCore.member.service;

import java.util.List;

import com.bithealth.memberCore.enmu.FamilyRoleEnmu;
import com.bithealth.memberCore.member.model.MemFamilyCard;
import com.bithealth.memberCore.member.model.MemFamilyCardExample;
import com.bithealth.memberCore.member.model.MemFamilyCardExt;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MemFamilyCardService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月12日 下午3:52:22 
 * 
 * @author liuhm
 * @version  
 */
public interface MemFamilyCardService extends GenericBaseService<MemFamilyCard, MemFamilyCardExample, Integer> {
	
	/**
	 * 
	 * @Title:selectByMemberAndRole 
	 * @Description:获取会员家庭成员智能卡. 
	 * @author liuhm
	 * @param memberId
	 * @param role
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemFamilyCard>
	 */
	List<MemFamilyCard> selectByMemberAndRole(Integer memberId, FamilyRoleEnmu role);
	
	/**
	 *
	 * @Title:selectMemCardExtNotMy 
	 * 查询制定会员关联家庭成员的只能卡号
	 * @author liuhm
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemFamilyCardExt>
	 */
	List<MemFamilyCardExt> selectMemCardExtNotMy(Integer memberId);
	
	/**
	 * 
	 * @Title:selectExistsCard 
	 * @Description:校验会员卡号是否存在，为空不存在，否则存在. 
	 * @author liuhm
	 * @param memberId
	 * @param cardNos
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemFamilyCard>
	 */
	public List<MemFamilyCard> selectExistsCard(Integer memberId, List<String> cardNos);
	
	/**
	 * 
	 * @Title:insertMemFamily 
	 * @Description:会员家庭成员添加. 
	 * @author liuhm
	 * @param cardList
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int insertMemFamily(List<MemFamilyCardExt> cardList, Integer memberId);
	
	/**
	 * 
	 * @Title:insertMemberCard 
	 * @Description:添加会员智能卡号. 
	 * @author liuhm
	 * @param cardList
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int insertMemberCard(List<MemFamilyCard> cardList, Integer memberId);
	
	/**
	 * 
	 * @Title:existMemberCard 
	 * @Description:智能卡号是否存在. 
	 * @author liuhm
	 * @param cardList
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	public String existMemberCard(List<MemFamilyCard> cardList, Integer memberId);
	
}
