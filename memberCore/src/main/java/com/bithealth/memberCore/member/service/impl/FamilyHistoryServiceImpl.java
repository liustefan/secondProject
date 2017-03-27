/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     FamilyHistoryServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 上午10:14:18  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.dao.FamilyHistoryMapper;
import com.bithealth.memberCore.member.model.FamilyHistory;
import com.bithealth.memberCore.member.model.FamilyHistoryExample;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.FamilyHistoryService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: FamilyHistoryServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 上午10:14:18 
 * 
 * @author liuhm
 * @version  
 */
@Service("familyHistoryService")
public class FamilyHistoryServiceImpl extends GenericBaseServiceImpl<FamilyHistory, FamilyHistoryExample, Long> implements
		FamilyHistoryService {
	
	@Autowired
	private FamilyHistoryMapper mapper;

	@Override
	public GenericBaseDao<FamilyHistory, FamilyHistoryExample, Long> getDao() {
		return mapper;
	}

	@Override
	public int insetOrUpdate(List<FamilyHistory> list,  Member member) {
		FamilyHistoryExample example = new FamilyHistoryExample();
		FamilyHistoryExample.Criteria criteria = example.createCriteria();
		criteria.andMemberIDEqualTo(member.getMemberid());
		int count = mapper.deleteByExample(example);
		if(list == null || list.size() == 0) {
			return count;
		}
		
		for(FamilyHistory history : list) {
			if(history.getDiseaseID() == null) {
				continue;
			}
			history.setMemberID(member.getMemberid());
			history.setCreateTime(new java.util.Date());
		}
		if(list.isEmpty()) {
			return count;
		}
		return mapper.insetBatch(list);
	}

}
