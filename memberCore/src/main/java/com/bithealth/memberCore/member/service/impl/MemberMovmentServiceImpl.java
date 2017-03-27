/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     MemberMovmentServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年11月25日 下午5:45:13  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.dao.MemberMovmentMapper;
import com.bithealth.memberCore.member.model.MemberMovment;
import com.bithealth.memberCore.member.model.MemberMovmentExample;
import com.bithealth.memberCore.member.service.MemberMovmentService;
import com.bithealth.memberCore.member.vo.MovementCondition;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MemberMovmentServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月25日 下午5:45:13 
 * 
 * @author liuhm
 * @version  
 */
@Service
public class MemberMovmentServiceImpl extends GenericBaseServiceImpl<MemberMovment, MemberMovmentExample, Integer> implements MemberMovmentService {
	
	@Autowired
	private MemberMovmentMapper mapper;

	@Override
	public GenericBaseDao<MemberMovment, MemberMovmentExample, Integer> getDao() {
		return mapper;
	}

	@Override
	public Page<MemberMovment> selectByPage(MovementCondition movement, Page<MemberMovment> page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("condition", movement);
		int total = mapper.countMovments(param);
		param.put("page", page);
		List<MemberMovment> dataList = mapper.selectByPage(param);
		page.setTotalCount(total);
		page.setResult(dataList);
		return page;
	}

}
