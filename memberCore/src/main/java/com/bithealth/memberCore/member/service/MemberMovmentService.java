/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     MemberMovmentService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年11月25日 下午5:44:22  
 * 
 */
package com.bithealth.memberCore.member.service;

import com.bithealth.memberCore.member.model.MemberMovment;
import com.bithealth.memberCore.member.model.MemberMovmentExample;
import com.bithealth.memberCore.member.vo.MovementCondition;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MemberMovmentService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月25日 下午5:44:22 
 * 
 * @author liuhm
 * @version  
 */
public interface MemberMovmentService extends GenericBaseService<MemberMovment, MemberMovmentExample, Integer>{
	
	public Page<MemberMovment> selectByPage(MovementCondition movement, Page<MemberMovment> page);

}
