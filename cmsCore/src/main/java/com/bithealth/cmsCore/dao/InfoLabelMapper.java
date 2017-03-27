/*
 * infoLabelMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-05 Created
 */
package com.bithealth.cmsCore.dao;

import com.bithealth.cmsCore.model.InfoLabel;
import com.bithealth.cmsCore.model.InfoLabelExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

/**
 * 类名称: infoLabelMapper  
 * 功能描述: 资讯标签关系接口
 * 日期: 2016年9月5日 上午10:40:49
 * 
 * @author 周玉飞
 * @version  
 */
public interface InfoLabelMapper extends GenericBaseDao<InfoLabel, InfoLabelExample, Long> {

	int deleteInfoLable(Integer id);


}