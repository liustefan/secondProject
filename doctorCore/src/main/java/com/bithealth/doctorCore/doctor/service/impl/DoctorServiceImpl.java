/**
 * @PackageName:      com.bithealth.doctorCore.doctor.service.impl
 * @FileName:     DoctorServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      刘海明 
 * @version      V1.0  
 * @Createdate:  2016年6月17日 下午3:35:47  
 * 
 */
package com.bithealth.doctorCore.doctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.doctorCore.doctor.dao.DoctorMapper;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorExample;
import com.bithealth.doctorCore.doctor.model.DoctorExample.Criteria;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.doctorCore.enmu.TagStatus;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: DoctorServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月17日 下午3:35:47 
 * 
 * @author 刘海明
 * @version  
 */
@Service("doctorService")
public class DoctorServiceImpl extends GenericBaseServiceImpl<Doctor, DoctorExample, Integer> implements DoctorService {
	
	@Autowired
	private DoctorMapper doctorMapper;

	@Override
	public GenericBaseDao<Doctor, DoctorExample, Integer> getDao() {
		return doctorMapper;
	}

	@Override
	public List<Doctor> selectDoctorByGroup(int doctorGroupId) {
		DoctorExample example = new DoctorExample();
		Criteria criteria =  example.createCriteria();
		criteria.andDocInGroup(doctorGroupId);
		criteria.andTagEqualTo(TagStatus.T.name());
		return doctorMapper.selectByExample(example);
	}

	@Override
	public int delete(Integer id) {
		Doctor doctor = doctorMapper.selectByPrimaryKey(id);
		if(doctor.getRoleid().intValue() == 6) {  //系统管理员物理删除，其他逻辑删除
			return doctorMapper.deleteByPrimaryKey(id);
		}
		doctor.setTag(TagStatus.E.name());
		return doctorMapper.updateByPrimaryKey(doctor);
	}

	@Override
	public int deleteByExample(DoctorExample example) {
		Doctor doctor = new Doctor();
		doctor.setTag(TagStatus.E.name());
		return doctorMapper.updateByExampleSelective(doctor, example);
	}

	@Override
	public boolean isMyMember(Integer docId, Integer memberId, Integer orgId) {
		return doctorMapper.isMyMember(docId, memberId, orgId);
	}

	@Override
	public Doctor selectByUUID(String UUID) {
		DoctorExample example = new DoctorExample();
		example.createCriteria().andTagEqualTo(TagStatus.T.name()).andDocGUIDEqualTo(UUID);
		List<Doctor> list = doctorMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Page<Doctor> selectByMember(Integer memberId, Page<Doctor> page) {
		List<Doctor> list = doctorMapper.selectByMember(memberId, page.getOffset(), page.getPageSize());
		int count = doctorMapper.countByMember(memberId);
		page.setResult(list);
		page.setTotalCount(count);
		return page;
	}

	@Override
	public Integer countByMember(Integer memberId) {
		return doctorMapper.countByMember(memberId);
	}
	
	
}
