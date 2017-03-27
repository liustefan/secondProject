package com.bithealth.centCore.care.service;

import java.util.List;

import com.bithealth.centCore.care.model.FamilyNews;
import com.bithealth.centCore.care.model.FamilyNewsExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface FamilyNewsService extends GenericBaseService<FamilyNews,FamilyNewsExample,Integer > {    
	
	/**
	 * @Title:getMyCareMemberNews 
	 * @Description:获取我关注的人的亲友动态列表
	 * @author 谢美团
	 * @param page
	 * @param memberGUID
	 * @return 
	 * @throws
	 * @retrun List<MessageCenter>
	 */ 
	List<FamilyNews> getMyCareMemberNews(Page<FamilyNews> page,String memberGUID);
	
	
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
	List<FamilyNews> getLastFamilyNewsAndReadStatus(Page<FamilyNews> page,String sender,String receiver);
}
