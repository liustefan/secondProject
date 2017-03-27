/**
 * @PackageName:      com.bithealth.doctorCore.doctor.service.impl
 * @FileName:     OrolServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 下午2:30:10  
 * 
 */
package com.bithealth.doctorCore.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.doctorCore.doctor.dao.OrolMapper;
import com.bithealth.doctorCore.doctor.model.Orol;
import com.bithealth.doctorCore.doctor.model.OrolExample;
import com.bithealth.doctorCore.doctor.service.OrolService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: OrolServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 下午2:30:10 
 * 
 * @author liuhm
 * @version  
 */
@Service("orolService")
public class OrolServiceImpl extends
		GenericBaseServiceImpl<Orol, OrolExample, Short> implements OrolService {
	
	@Autowired
	private OrolMapper mapper;

	@Override
	public GenericBaseDao<Orol, OrolExample, Short> getDao() {
		return mapper;
	}

}
