/*
 * AdvertisementMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-29 Created
 */
package com.bithealth.cmsCore.dao;

import java.util.List;

import com.bithealth.cmsCore.model.Advertisement;
import com.bithealth.cmsCore.model.AdvertisementExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
/**
 * 类名称: AdvertisementMapper  
 * 功能描述: 广告服务类AdvertisementMapper接口
 * 日期: 2016年7月29日 下午3:49:26 
 * 
 * @author 周玉飞
 * @version  
 */
public interface AdvertisementMapper extends GenericBaseDao<Advertisement, AdvertisementExample, Integer> {
      
	  List<Advertisement> selectByExampleAndPage(Page<Advertisement> page,AdvertisementExample example);
	
	  int publishAdvert(Advertisement pojo);
	  
}