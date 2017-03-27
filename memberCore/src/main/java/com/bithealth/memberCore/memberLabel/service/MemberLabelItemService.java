/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     MemberLabelItemService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月6日 上午10:24:56  
 * 
 */
package com.bithealth.memberCore.memberLabel.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.memberCore.memberLabel.enmu.LabelStatus;
import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.model.MemberLabelItem;
import com.bithealth.memberCore.memberLabel.model.MemberLabelItemExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MemberLabelItemService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月6日 上午10:24:56 
 * 
 * @author liuhm
 * @version  
 */
public interface MemberLabelItemService extends GenericBaseService<MemberLabelItem, MemberLabelItemExample, Integer> {
	
	/**
	 * 批量保存
	 * @Title:insertBatch 
	 * @author liuhm
	 * @param list
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int insertBatch(List<MemberLabelItem> list, Integer memberId);
	
	/**
	 * 
	 * @Title:deleteBatch 
	 * @Description:删除会员制定的会员标签. 
	 * @author liuhm
	 * @param list
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int deleteBatch(List<MemberLabelItem> list, Integer memberId);
	
	/**
	 * 
	 * @Title:saveOrUpdate 
	 * @Description:修改或者更新会员标签关系. 
	 * @author liuhm
	 * @param memberId
	 * @param itemList
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int saveOrUpdate(int memberId, List<MemberLabelItem> itemList);
	
	/**
	 * 
	 * @Title:initializeItemLabel 
	 * @Description:初始化会员对应的标签. 
	 * @author liuhm
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int initializeItemLabel(int memberId, boolean fromApp);
	
	/**
	 * 
	 * @Title:isAppRegist 
	 * @Description:会员是否App注册. 
	 * @author liuhm
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	boolean isAppRegist(int memberId, Integer itemId);
	
	List<LabelItem> selectMemberLabelItems(LabelStatus status, Integer memberId, List<LabelItem> items);
}
