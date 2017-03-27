/*
 * HealthnewsLableMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-29 Created
 */
package com.bithealth.cmsCore.dao;

import java.util.List;

import com.bithealth.cmsCore.model.HealthnewsLable;
import com.bithealth.cmsCore.model.HealthnewsLableExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
/**
 * 类名称: HealthnewsLableMapper  
 * 功能描述: 健康资讯标签HealthnewsLableMapper服务接口
 * 日期: 2016年7月29日 下午3:49:26 
 * 
 * @author 周玉飞
 * @version  
 */
public interface HealthnewsLableMapper extends GenericBaseDao<HealthnewsLable, HealthnewsLableExample, Integer> {
	 
	 
     List<HealthnewsLable> selectByExampleAndPage(Page<HealthnewsLable> page,HealthnewsLableExample example);

     int updateLableByStatus(HealthnewsLable pojo);
     
     List<HealthnewsLable> selectAllLable(HealthnewsLable pojo);

     List<HealthnewsLable> selectListByHNInfoID(Integer hninfoid);
     
     
     
}