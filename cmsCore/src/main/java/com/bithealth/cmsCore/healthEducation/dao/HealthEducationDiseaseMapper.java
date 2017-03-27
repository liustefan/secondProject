/*
 * HealthEducationDiseaseMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.cmsCore.healthEducation.dao;

import java.util.List;

import com.bithealth.cmsCore.healthEducation.model.HealthEducationDisease;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationDiseaseExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;
/**
 * 类名称: HealthEducationDiseaseMapper  
 * 功能描述: 健教与疾病关系
 * 日期: 2016年11月29日
 * @author 周玉飞
 * @version  
 */
public interface HealthEducationDiseaseMapper extends GenericBaseDao<HealthEducationDisease, HealthEducationDiseaseExample, Integer> {

	int deleteHealthEducationDisease(Integer id);

	List<HealthEducationDisease> selectList(Integer id);
}