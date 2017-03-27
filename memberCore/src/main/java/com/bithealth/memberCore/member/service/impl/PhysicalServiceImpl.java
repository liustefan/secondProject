/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     PhysicalServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 上午11:31:06  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.dao.PhysicalExaminationMapper;
import com.bithealth.memberCore.member.model.PhysicalExamination;
import com.bithealth.memberCore.member.model.PhysicalExaminationExample;
import com.bithealth.memberCore.member.service.PhysicalService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: PhysicalServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 上午11:31:06 
 * 
 * @author liuhm
 * @version  
 */
@Service("physicalService")
public class PhysicalServiceImpl extends
		GenericBaseServiceImpl<PhysicalExamination, PhysicalExaminationExample, Integer> implements
		PhysicalService {
	
	@Autowired
	private PhysicalExaminationMapper mapper;

	@Override
	public GenericBaseDao<PhysicalExamination, PhysicalExaminationExample, Integer> getDao() {
		return mapper;
	}

	@Override
	public int insertOrUpdate(PhysicalExamination physical) {
		int count = mapper.updateByPrimaryKey(physical);
		if(count == 0) {
			count = mapper.insert(physical);
		}
		return count;
	}

}
