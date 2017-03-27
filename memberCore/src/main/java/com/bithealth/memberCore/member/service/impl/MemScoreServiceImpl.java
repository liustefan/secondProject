/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     MemScoreServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月9日 上午11:28:14  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.dao.MemScoreMapper;
import com.bithealth.memberCore.member.model.MemScore;
import com.bithealth.memberCore.member.model.MemScoreExample;
import com.bithealth.memberCore.member.service.MemScoreService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MemScoreServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月9日 上午11:28:14 
 * 
 * @author liuhm
 * @version  
 */
@Service("memScoreService")
public class MemScoreServiceImpl extends GenericBaseServiceImpl<MemScore, MemScoreExample, Integer> implements MemScoreService {
	
	@Autowired
	private MemScoreMapper memScoreMapper;

	@Override
	public GenericBaseDao<MemScore, MemScoreExample, Integer> getDao() {
		return memScoreMapper;
	}

}
