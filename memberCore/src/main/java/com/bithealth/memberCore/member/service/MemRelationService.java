/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     MemRelationService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 上午11:36:33  
 * 
 */
package com.bithealth.memberCore.member.service;

import java.util.List;

import com.bithealth.memberCore.enmu.MemberSource;
import com.bithealth.memberCore.member.model.MemRelation;
import com.bithealth.memberCore.member.model.MemRelationExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MemRelationService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 上午11:36:33 
 * 
 * @author liuhm
 * @version  
 */
public interface MemRelationService extends GenericBaseService<MemRelation, MemRelationExample, String> {
	
	/**
	 * 
	 * @Title:selectFailDataBySource 
	 * @Description:获取失败的数据state<>1. 
	 * @author liuhm
	 * @param source
	 * @param limit
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemRelation>
	 */
	List<MemRelation> selectFailDataBySource(MemberSource source, int limit);
	
	/**
	 * 
	 * @Title:countFailDataBySource 
	 * @Description:获取失败的数据state<>1总数. 
	 * @author liuhm
	 * @param source
	 * @param limit
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
    int countFailDataBySource(MemberSource source, int limit);
}
