 
/**
 * @PackageName:      com.bithealth.inspectCore.physical.service
 * @FileName:     PhHealthexamService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午10:28:09  
 * 
 */

package com.bithealth.inspectCore.physical.service;

import java.util.List;

import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;


/**
 * 类名称: PhHealthexamService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午10:28:09 
 * 
 * @author baozj
 * @version  
 */
public interface PhHealthexamService extends
		GenericBaseService<PhHealthexam, PhHealthexamExample, Long> {

	int deleteByMasterId(List<Long> masterIds);
	
	PhHealthexam selectLatestPhHealthexamByMemberId(Integer memberId);
	
	List<PhHealthexam> selectPhHealthexamList(PhHealthexam pojo);
	
	Page<PhHealthexam> selectPage(Page<PhHealthexam> page, PhHealthexam model, List<Integer> odgpIds);
	
	int updateByPrimaryKeySelective(PhHealthexam pojo);
}

