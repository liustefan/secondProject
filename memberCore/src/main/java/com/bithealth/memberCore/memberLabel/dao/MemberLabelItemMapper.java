/*
 * MemberLabelItemMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-02 Created
 */
package com.bithealth.memberCore.memberLabel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.model.MemberLabelItem;
import com.bithealth.memberCore.memberLabel.model.MemberLabelItemExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemberLabelItemMapper extends GenericBaseDao<MemberLabelItem, MemberLabelItemExample, Integer> {
	
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
	int insertBatch(List<MemberLabelItem> list);
	
	/**
	 * 
	 * @Title:selectMemberLabelItems 
	 * @Description:获取指定范围内会员对应的会员标签. 
	 * @author liuhm
	 * @param status
	 * @param memberId
	 * @param items
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<LabelItem>
	 */
	List<LabelItem> selectMemberLabelItems(Map<String, Object> map);
}