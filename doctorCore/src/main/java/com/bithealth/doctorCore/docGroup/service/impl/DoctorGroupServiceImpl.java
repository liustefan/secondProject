/**
 * @PackageName:      com.bithealth.doctorCore.docGroup.service.impl
 * @FileName:     DoctorFroupServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月27日 上午11:23:24  
 * 
 */
package com.bithealth.doctorCore.docGroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.doctorCore.docGroup.dao.DoctorGroupMapper;
import com.bithealth.doctorCore.docGroup.model.DoctorGroup;
import com.bithealth.doctorCore.docGroup.model.DoctorGroupExample;
import com.bithealth.doctorCore.docGroup.model.DoctorGroupExt;
import com.bithealth.doctorCore.docGroup.model.MemGroup;
import com.bithealth.doctorCore.docGroup.service.DoctorGroupService;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: DoctorFroupServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月27日 上午11:23:24 
 * 
 * @author liuhm
 * @version  
 */
@Service("doctorGroupService")
public class DoctorGroupServiceImpl extends
		GenericBaseServiceImpl<DoctorGroup, DoctorGroupExample, Integer> implements
		DoctorGroupService {
	
	@Autowired
	private DoctorGroupMapper doctorGroupMapper;

	
	@Override
	public GenericBaseDao<DoctorGroup, DoctorGroupExample, Integer> getDao() {
		return doctorGroupMapper;
	}


	@Override
	public int insert(DoctorGroup model) {
		DoctorGroup preGroup = this.checkGroupExist(model.getOrgid(), model.getParentGroup().getOdgpid(), model.getOdgpname());
		if(preGroup != null) {   //存在重复医生分组
			return 0;  
		}
		String path = null;
		if(model.getParentGroup() != null && model.getParentGroup().getOdgpid() > 0) {
			model.setFathid(model.getParentGroup().getOdgpid());
			DoctorGroup parent = doctorGroupMapper.selectByPrimaryKey(model.getFathid());
			if(parent.getEndblocktag()) {  //终结点下不允许建分组
				return 0;  
			}
			path = parent.getPath();
		} else {
			model.setFathid(0);
		}
		path = path == null ? ",0," : path;
		model.setPath(path);
		int count = super.insert(model);
		if(count > 0) {
			model.setPath(path + model.getOdgpid() + ",");
			return doctorGroupMapper.updateByPrimaryKeySelective(model);
		}
		return 0;
	}
	

	@Override
	public DoctorGroup checkGroupExist(Integer orgId, Integer parentId, String groupName) {
		parentId = parentId == null ? 0 : parentId;
		DoctorGroupExample example = new DoctorGroupExample();
		DoctorGroupExample.Criteria criteria = example.createCriteria();
		criteria.andOrgidEqualTo(orgId);
		criteria.andFathidEqualTo(parentId);
		criteria.andOdgpnameEqualTo(groupName);
		List<DoctorGroup> list = doctorGroupMapper.selectByExample(example);
		if(list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public boolean bindAuthority(DoctorGroup group) {
		DoctorGroup oldGroup = doctorGroupMapper.selectByPrimaryKey(group.getOdgpid());
		if(oldGroup == null) {
			return false;
		}
		
		oldGroup.setChlevel(group.getChlevel());
		oldGroup.setFunid(group.getFunid());
		oldGroup.setOptid(group.getOptid());
		return doctorGroupMapper.updateByPrimaryKey(group) > 0;
	}


	@Override
	public DoctorGroupExt selectGrpWithMemGrpById(Integer id) {
		return doctorGroupMapper.selectGrpWithMemGrpById(id);
	}

	@Override
	public int delete(Integer id) throws BusinessException {
		DoctorGroupExt doctorGroup = doctorGroupMapper.selectGrpWithMemGrpById(id);
		if(doctorGroup == null) {
			throw new BusinessException("不存在该分组");
		}
		
		List<DoctorGroup> groups = doctorGroup.getChildren();
		if(groups != null && groups.size() > 0) {
			throw new BusinessException("存在子分组，不允许删除");
		}
		
		List<Doctor> list = doctorGroup.getDoctorList();
		if(list != null && !list.isEmpty()) {
			throw new BusinessException("该分组已绑定医生，不允许删除");
		}
		
		List<MemGroup> keyList = doctorGroup.getMemGrpList();
		if(keyList != null && keyList.size() > 0) {
			throw new BusinessException("该分组已绑定会员分组，不允许删除");
		}
		
		return super.delete(id);
	}


	@Override
	public int getDefaultOrder(int parentId, int orgId) {
		DoctorGroupExample example = new DoctorGroupExample();
		DoctorGroupExample.Criteria c = example.createCriteria();
		c.andFathidEqualTo(parentId);
		c.andOrgidEqualTo(orgId);
		example.setOrderByClause("`order` DESC");
		List<DoctorGroup> groups = doctorGroupMapper.selectByExample(example);
		if(groups == null || groups.size() == 0) {
			return 10;
		}
		return groups.get(0).getOrder().intValue() + 10;
	}


	@Override
	public int updateTemParamClear(Integer orgId, Short funId, Short optId) {
		return 0;
	}
	
}
