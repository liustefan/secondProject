/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     HabitServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 上午10:29:58  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.dao.HabitMapper;
import com.bithealth.memberCore.member.model.Habit;
import com.bithealth.memberCore.member.model.HabitExample;
import com.bithealth.memberCore.member.service.HabitService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: HabitServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 上午10:29:58 
 * 
 * @author liuhm
 * @version  
 */
@Service("habitService")
public class HabitServiceImpl extends GenericBaseServiceImpl<Habit, HabitExample, Integer> implements HabitService {
	
	@Autowired
	private HabitMapper mapper;

	@Override
	public GenericBaseDao<Habit, HabitExample, Integer> getDao() {
		return mapper;
	}

	@Override
	public int insertOrUpdate(Habit habit) {
		int count = mapper.updateByPrimaryKey(habit);
		if(count > 0) {
			return count;
		}
		return mapper.insert(habit);
	}

}
