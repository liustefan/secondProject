/*
 * HealthnewsInfoMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-29 Created
 */
package com.bithealth.cmsCore.dao;

import java.util.List;

import com.bithealth.cmsCore.model.HealthnewsInfo;
import com.bithealth.cmsCore.model.HealthnewsInfoExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
/**
 * 类名称: HealthnewsInfoMapper  
 * 功能描述: 健康资讯信息表HealthnewsInfoMapper服务接口
 * 日期: 2016年7月29日 下午3:49:26 
 * 
 * @author 周玉飞
 * @version  
 */
public interface HealthnewsInfoMapper extends GenericBaseDao<HealthnewsInfo, HealthnewsInfoExample, Integer> {

	   List<HealthnewsInfo> selectByExampleAndPage(Page<HealthnewsInfo> page,HealthnewsInfoExample example);
      
	   int publishNewsInfo(HealthnewsInfo pojo);
	   
	   List<HealthnewsInfo> selectNewsInfoList(Page<HealthnewsInfo> page,HealthnewsInfoExample example);
	   
}