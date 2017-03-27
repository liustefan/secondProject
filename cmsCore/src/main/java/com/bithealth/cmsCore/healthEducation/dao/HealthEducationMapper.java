/*
 * HealthEducationMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.cmsCore.healthEducation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.cmsCore.healthEducation.model.HealthEducation;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
/**
 * 类名称: HealthEducationMapper  
 * 功能描述: 健教库管理
 * 日期: 2016年11月29日
 * 
 * @author 周玉飞
 * @version  
 */
public interface HealthEducationMapper extends GenericBaseDao<HealthEducation, HealthEducationExample, Integer> {

	List<HealthEducation> selectByExampleAndPage(Page<HealthEducation> page,HealthEducationExample example);
	
	List<HealthEducation> selectHealthEducationPage(Page<HealthEducation> page,HealthEducation model);
	
	HealthEducation selectDiseaseName(HealthEducation pojo);
	
	HealthEducation selectHealthEducation(@Param("roleId")Integer roleId, @Param("title")String title, @Param("id")Integer id, @Param("createID")Integer docId, @Param("superOrgIds")String allSharedOrg);
}