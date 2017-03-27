/*
 * FamilyNewsMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-12 Created
 */
package com.bithealth.centCore.care.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.centCore.care.model.FamilyNews;
import com.bithealth.centCore.care.model.FamilyNewsExample;
import com.bithealth.centCore.msgCenterCore.model.MessageCenter;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface FamilyNewsMapper extends GenericBaseDao<FamilyNews, FamilyNewsExample, Integer> {
	
	/**
	 * @Title:getMyCareMemberNews 
	 * @Description:查询我关注的人的最新动态
	 * @author 谢美团
	 * @param page
	 * @param memberGUID
	 * @return 
	 * @throws
	 * @retrun List<MessageCenter>
	 */ 
	public List<FamilyNews> getMyCareMemberNews(Page<FamilyNews> page,String memberGUID);
	
	/**
	 * @Title:getLastFamilyNewsAndReadStatus 
	 * @Description:获取亲友最新动态及阅读状态
	 * @author 谢美团
	 * @param page
	 * @param sender
	 * @param receiver
	 * @return 
	 * @throws
	 * @retrun List<FamilyNews>
	 */ 
	List<FamilyNews> getLastFamilyNewsAndReadStatus(Page<FamilyNews> page,Map<?, ?> paramMap);
}