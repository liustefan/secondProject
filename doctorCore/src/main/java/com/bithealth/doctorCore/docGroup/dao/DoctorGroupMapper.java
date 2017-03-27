/*
 * DoctorGroupMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.docGroup.dao;

import org.apache.ibatis.annotations.Param;

import com.bithealth.doctorCore.docGroup.model.DoctorGroup;
import com.bithealth.doctorCore.docGroup.model.DoctorGroupExample;
import com.bithealth.doctorCore.docGroup.model.DoctorGroupExt;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface DoctorGroupMapper extends GenericBaseDao<DoctorGroup, DoctorGroupExample, Integer> {
	
	DoctorGroupExt selectGrpWithMemGrpById(Integer id);
	
	int updateTemParamClear(@Param("orgId")int orgId, @Param("funId")Short funId, @Param("optId")Short optId);
}