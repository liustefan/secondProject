/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     MemberTypeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 下午5:07:28  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.dao.MemberTypeMapper;
import com.bithealth.memberCore.member.model.MemberType;
import com.bithealth.memberCore.member.model.MemberTypeExample;
import com.bithealth.memberCore.member.service.MemberTypeService;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MemberTypeServiceImpl  
 * 功能描述: 会员类型维护service.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 下午5:07:28 
 * 
 * @author liuhm
 * @version  
 */
@Service("memberTypeService")
public class MemberTypeServiceImpl extends GenericBaseServiceImpl<MemberType, MemberTypeExample, Short> implements MemberTypeService {
	
	@Autowired
    private MemberTypeMapper mapper;
	
	@Override
	public GenericBaseDao<MemberType, MemberTypeExample, Short> getDao() {
		return mapper;
	}

	@Override
	public int insert(MemberType model) throws BusinessException {
		MemberType type = this.selectByNameAndOrg(model.getMemname(), model.getOrgid());
		if(type != null) {  //重名
			throw new BusinessException("已经存在【" + model.getMemname() + "】的会员类型");
		}
		return super.insert(model);
	}

	@Override
	public int update(MemberType model) throws BusinessException{
		MemberType type = this.selectByNameAndOrg(model.getMemname(), model.getOrgid());
		if(type != null && type.getMemid().shortValue() != model.getMemid().shortValue()) {  //重名
			throw new BusinessException("已经存在【" + model.getMemname() + "】的会员类型");
		}
		return super.update(model);
	}

	@Override
	public MemberType selectByNameAndOrg(String typeName, Integer orgId) {
		MemberTypeExample example = new MemberTypeExample();
		MemberTypeExample.Criteria criteria = example.createCriteria();
		criteria.andOrgidEqualTo(orgId);
		criteria.andMemnameEqualTo(typeName);
		criteria.andTagEqualTo(UseTag.T.name());
		List<MemberType> type = mapper.selectByExample(example);
		if(type != null && type.size() > 0) {
			return type.get(0);
		}
		return null;
	}

	@Override
	public List<MemberType> selectListByOrg(Integer orgId, UseTag tag) {
		MemberTypeExample example = new MemberTypeExample();
		MemberTypeExample.Criteria criteria = example.createCriteria();
		criteria.andOrgidEqualTo(orgId);
		if(tag != null) {
			criteria.andTagEqualTo(tag.name());
		}
		return mapper.selectByExample(example);
	}

	@Deprecated
	@Override
	public int deleteByExample(MemberTypeExample example) {
		return 0;
	}
	
}
