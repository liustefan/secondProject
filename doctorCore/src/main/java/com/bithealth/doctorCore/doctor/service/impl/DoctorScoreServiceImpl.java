/**
 * @PackageName:      com.bithealth.doctorCore.doctor.service.impl
 * @FileName:     DoctorScoreServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月22日 下午5:32:12  
 * 
 */
package com.bithealth.doctorCore.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bithealth.doctorCore.doctor.dao.DoctorScoreMapper;
import com.bithealth.doctorCore.doctor.model.DoctorScore;
import com.bithealth.doctorCore.doctor.model.DoctorScoreExample;
import com.bithealth.doctorCore.doctor.service.DoctorScoreService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: DoctorScoreServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月22日 下午5:32:12 
 * 
 * @author liuhm
 * @version  
 */
public class DoctorScoreServiceImpl extends
		GenericBaseServiceImpl<DoctorScore, DoctorScoreExample, Integer> implements
		DoctorScoreService {
	
	@Autowired
	private DoctorScoreMapper doctorScoreMapper;

	@Override
	public GenericBaseDao<DoctorScore, DoctorScoreExample, Integer> getDao() {
		return doctorScoreMapper;
	}


}
