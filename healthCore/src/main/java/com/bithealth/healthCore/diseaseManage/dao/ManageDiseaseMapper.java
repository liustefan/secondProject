/*
 * ManageDiseaseMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.healthCore.diseaseManage.dao;


import com.bithealth.healthCore.diseaseManage.model.ManageDisease;
import com.bithealth.healthCore.diseaseManage.model.ManageDiseaseExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;
/**
 * 类名称: ManageDiseaseMapper  
 * 功能描述: 疾病管理服务Mapper接口
 * 日期: 2016年11月29日 
 * 
 * @author 周玉飞
 * @version  
 */
public interface ManageDiseaseMapper extends GenericBaseDao<ManageDisease, ManageDiseaseExample, Integer> {

	int  deleteChildren(Integer id);
	
}