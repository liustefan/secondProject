/**
 * @PackageName:      com.bithealth.memberCore.group.service.impl
 * @FileName:     MemberGroupServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月28日 下午1:45:24  
 * 
 */
package com.bithealth.memberCore.group.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.group.dao.MemberGroupMapper;
import com.bithealth.memberCore.group.model.DoctorGrp;
import com.bithealth.memberCore.group.model.MemGroupExt;
import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.group.model.MemberGroupExample;
import com.bithealth.memberCore.group.service.MemberGroupService;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MemberGroupServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 下午1:45:24 
 * 
 * @author liuhm
 * @version  
 */
@Service("memberGroupService")
public class MemberGroupServiceImpl extends
		GenericBaseServiceImpl<MemberGroup, MemberGroupExample, Integer> implements
		MemberGroupService {

	@Autowired
	private MemberGroupMapper memberGroupMapper;
	
	@Override
	public GenericBaseDao<MemberGroup, MemberGroupExample, Integer> getDao() {
		return memberGroupMapper;
	}
	@Override
	public MemberGroup checkGroupExist(Integer orgId, Integer parentId, String groupName) {
		parentId = parentId == null ? 0 : parentId;
		MemberGroupExample example = new MemberGroupExample();
		MemberGroupExample.Criteria criteria = example.createCriteria();
		criteria.andOrgidEqualTo(orgId == null ? 0 : orgId);
		criteria.andFamemidEqualTo(parentId);
		criteria.andMemgrpnameEqualTo(groupName);
		List<MemberGroup> list = memberGroupMapper.selectByExample(example);
		if(list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	@Override
	public int insert(MemberGroup model) {
		if(model.getFamemid() == null) {
			model.setFamemid(0);
		}
		MemberGroup preGroup = this.checkGroupExist(model.getOrgid(), model.getFamemid(), model.getMemgrpname());
		if(preGroup != null) {   //存在重复医生分组
			return 0;  
		}
		MemberGroup parent = memberGroupMapper.selectByPrimaryKey(model.getFamemid());
		String path = ",0,";
		if(parent != null) {
			path = parent.getPath();
		}
		model.setPath(path);
		int count = super.insert(model);
		if(count > 0) {
			model.setPath(path + model.getMemgrpid() + ",");
			return memberGroupMapper.updateByPrimaryKeySelective(model);
		}
		return 0;
	}
	
	@Override
	public int delete(Integer id) throws BusinessException {
		MemGroupExt group = memberGroupMapper.selectMemGrpExtById(id);
		if(group == null) {  //不存在
			throw new BusinessException("分组不存在");
		}
		
		List<MemberGroup> children = group.getChildren();
		if(children != null && children.size() > 0) {  //存在子节点
			throw new BusinessException("分组存在子节点");
		}
		
		List<DoctorGrp> docGrps = group.getDoctorGrpList();
		if(docGrps != null && docGrps.size() > 0) {  //已经绑定医生分组
			throw new BusinessException("会员分组已绑定医生分组");
		}
		
		return super.delete(id);
	}
	
	@Override
	public int updateByPrimaryKey(MemberGroup model) {
		MemberGroup preGroup = this.checkGroupExist(model.getOrgid(), model.getFamemid(), model.getMemgrpname());
		if(preGroup != null) {
			if(preGroup.getMemgrpid().intValue() != model.getMemgrpid().intValue()) {
				return 0;
			}
		}
		return super.updateByPrimaryKey(model);
	}
	
	@Override
	public int deleteByExample(MemberGroupExample example) {
		return 0;
	}
	
	@Override
	public MemGroupExt selectMemGrpExtById(Integer id) {
		return memberGroupMapper.selectMemGrpExtById(id);
	}
	
	@Override
	public List<MemberGroup> selectByDoctorAndOrg(Integer doctorId, Integer orgId) {
		MemberGroupExample example = new MemberGroupExample();
		MemberGroupExample.Criteria criteria = example.createCriteria();
		criteria.andOrgidEqualTo(orgId == null ? 0 : orgId);
		criteria.andDocidEqualsTo(doctorId);
//		criteria.andUsetagEqualTo(UseTag.T.name());
		return memberGroupMapper.selectByExample(example);
	}
	
	@Override
	public int getMaxOrder(int parentId, int orgId) {
		MemberGroupExample example = new MemberGroupExample();
		example.setOrderByClause("`order` DESC");
		example.createCriteria().andOrgidEqualTo(orgId).andFamemidEqualTo(parentId);
		List<MemberGroup> list = memberGroupMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return 10;
		}
		Integer max = list.get(0).getOrder();
		return max == 0 ? 10 : (max.intValue() + 10);
	}
	
}
