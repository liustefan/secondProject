/**
 * @PackageName:      com.bithealth.doctorCore.docGroup.service.impl
 * @FileName:     DoctorToGroupServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月24日 下午3:29:27  
 * 
 */
package com.bithealth.doctorCore.docGroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.doctorCore.docGroup.dao.DocToGroupMapper;
import com.bithealth.doctorCore.docGroup.model.DocToGroup;
import com.bithealth.doctorCore.docGroup.model.DocToGroupExample;
import com.bithealth.doctorCore.docGroup.model.DocToGroupKey;
import com.bithealth.doctorCore.docGroup.service.DoctorToGroupService;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: DoctorToGroupServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 下午3:29:27 
 * 
 * @author liuhm
 * @version  
 */
@Service("doctorToGroupService")
public class DoctorToGroupServiceImpl extends
		GenericBaseServiceImpl<DocToGroup, DocToGroupExample, DocToGroupKey> implements
		DoctorToGroupService {
	
	@Autowired
	private DocToGroupMapper docToGroupMapper;

	@Override
	public GenericBaseDao<DocToGroup, DocToGroupExample, DocToGroupKey> getDao() {
		return docToGroupMapper;
	}

	@Override
	public boolean deleteByDoctor(Integer docId) {
		DocToGroupExample example = new DocToGroupExample();
		com.bithealth.doctorCore.docGroup.model.DocToGroupExample.Criteria c = example.createCriteria();
		c.andDocidEqualTo(docId);
		return docToGroupMapper.deleteByExample(example) > 0;
	}

	@Override
	public int insertBatch(List<DocToGroup> list) {
		return docToGroupMapper.insertBatch(list);
	}

	@Override
	public List<DocToGroup> selectByDocIdAndFunId(Integer doctorId, List<Integer> funIdList, Integer optId) {
		return docToGroupMapper.selectByDocIdAndFunId(doctorId, funIdList, optId);
	}

	@Override
	public int insertBatchByDoctor(List<DocToGroup> list, Doctor doctor) {
		DocToGroupExample example = new DocToGroupExample();
		com.bithealth.doctorCore.docGroup.model.DocToGroupExample.Criteria c = example.createCriteria();
		c.andDocidEqualTo(doctor.getDocid());
		if(doctor.getOrgid() != null) {
			c.andOrgidEqualTo(doctor.getOrgid());
		}
		int count = docToGroupMapper.deleteByExample(example);
		if(list != null && list.size() > 0) {
			return  this.insertBatch(list);
		}
		return count;
	}

	@Override
	public List<DocToGroup> selectByOptAndLevel(Integer docId, Integer optId,Integer auditLevel, Integer orgId) {
		return docToGroupMapper.selectByOptAndLevel(docId, optId, auditLevel, orgId);
	}

	@Override
	public int deleteByDoctorGroup(Integer doctorGroupId) {
		DocToGroupExample example = new DocToGroupExample();
		example.createCriteria().andOdgpidEqualTo(doctorGroupId);
		return docToGroupMapper.deleteByExample(example);
	}

	@Override
	public int countByDoctorAndGrop(Integer doctorId, Integer grpId) {
		DocToGroupExample example = new DocToGroupExample();
		DocToGroupExample.Criteria c = example.createCriteria();
		if(doctorId != null && doctorId > 0) {
			c.andDocidEqualTo(doctorId);
		}
		if(grpId != null && grpId > 0) {
			c.andOdgpidEqualTo(grpId);
		}
		return docToGroupMapper.countByExample(example);
	}
	
}
