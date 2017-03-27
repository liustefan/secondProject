/*
 * DoctorMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.doctor.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface DoctorMapper extends GenericBaseDao<Doctor, DoctorExample, Integer> {
	
	boolean isMyMember(@Param("docId")Integer docId, @Param("memberId")Integer memberId, @Param("orgId")Integer orgId);
	
	List<Doctor> selectByMember(@Param("memberId")Integer memberId, @Param("offset")int offset, @Param("pageSize")int pageSize);
	
	int countByMember(@Param("memberId")Integer memberId);
}