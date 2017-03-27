/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     MemberSessionServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月5日 下午5:41:17  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.dao.MemSessionMapper;
import com.bithealth.memberCore.member.model.MemSession;
import com.bithealth.memberCore.member.model.MemSessionExample;
import com.bithealth.memberCore.member.service.MemberSessionService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MemberSessionServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月5日 下午5:41:17 
 * 
 * @author liuhm
 * @version  
 */
@Service("memberSessionService")
public class MemberSessionServiceImpl extends GenericBaseServiceImpl<MemSession, MemSessionExample, Integer> implements MemberSessionService {
	
	@Autowired
	private MemSessionMapper memSessionMapper;

	@Override
	public GenericBaseDao<MemSession, MemSessionExample, Integer> getDao() {
		return memSessionMapper;
	}

}
