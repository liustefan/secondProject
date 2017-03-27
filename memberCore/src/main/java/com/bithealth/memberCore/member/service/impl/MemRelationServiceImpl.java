/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     MemRelationServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 上午11:37:48  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.enmu.MemberSource;
import com.bithealth.memberCore.member.dao.MemRelationMapper;
import com.bithealth.memberCore.member.model.MemRelation;
import com.bithealth.memberCore.member.model.MemRelationExample;
import com.bithealth.memberCore.member.service.MemRelationService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MemRelationServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 上午11:37:48 
 * 
 * @author liuhm
 * @version  
 */
@Service("memRelationService")
public class MemRelationServiceImpl extends
		GenericBaseServiceImpl<MemRelation, MemRelationExample, String> implements
		MemRelationService {
	
	@Autowired
	private MemRelationMapper mapper;

	@Override
	public GenericBaseDao<MemRelation, MemRelationExample, String> getDao() {
		return mapper;
	}

	@Override
	public int insert(MemRelation model) {
		MemRelation relation = mapper.selectByPrimaryKey(model.getUniqueId());
		if(relation != null) {
			return mapper.updateByPrimaryKey(relation);
		}
		return super.insert(model);
	}

	@Override
	public List<MemRelation> selectFailDataBySource(MemberSource source,int limit) {
		Page<MemRelation> page = new Page<MemRelation>(1, limit);
		MemRelationExample example = new MemRelationExample();
		MemRelationExample.Criteria criteria = example.createCriteria();
		criteria.andStateNotEqualTo(new Byte("1"));
		criteria.andSourceEqualsTo(source);
		return mapper.selectByExampleAndPage(page, example);
	}

	@Override
	public int countFailDataBySource(MemberSource source, int limit) {
		MemRelationExample example = new MemRelationExample();
		MemRelationExample.Criteria criteria = example.createCriteria();
		criteria.andStateNotEqualTo(new Byte("1"));
		criteria.andSourceEqualsTo(source);
		return mapper.countByExample(example);
	}
	
}
