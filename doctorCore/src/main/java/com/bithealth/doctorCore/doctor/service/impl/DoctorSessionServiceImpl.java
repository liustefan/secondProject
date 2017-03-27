/**
 * @PackageName:      com.bithealth.doctorCore.doctor.service.impl
 * @FileName:     DoctorSessionServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午9:42:28  
 * 
 */
package com.bithealth.doctorCore.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.doctorCore.doctor.dao.DoctorSessionMapper;
import com.bithealth.doctorCore.doctor.model.DoctorSession;
import com.bithealth.doctorCore.doctor.model.DoctorSessionExample;
import com.bithealth.doctorCore.doctor.service.DoctorSessionService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: DoctorSessionServiceImpl  
 * 功能描述:医生登录session操作
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午9:42:28 
 * 
 * @author liuhm
 * @version  
 */
@Service("doctorSessionService")
public class DoctorSessionServiceImpl extends GenericBaseServiceImpl<DoctorSession, DoctorSessionExample, Integer> implements DoctorSessionService {

	@Autowired
	private DoctorSessionMapper doctorSessionMapper;
	
	@Override
	public GenericBaseDao<DoctorSession, DoctorSessionExample, Integer> getDao() {
		return doctorSessionMapper;
	}

	@Override
	public int insertOrUpdate(DoctorSession session) {
		int count = doctorSessionMapper.updateByPrimaryKey(session);
		if(count > 0) {
			return count;
		}
		return doctorSessionMapper.insert(session);
	}

}
