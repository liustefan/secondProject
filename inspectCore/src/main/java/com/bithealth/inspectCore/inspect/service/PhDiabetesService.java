 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.service
 * @FileName:     PhDiabetesService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午10:44:08  
 * 
 */

package com.bithealth.inspectCore.inspect.service;

import java.util.List;

import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;


/**
 * 
 * 类名称: PhDiabetesService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午10:48:49 
 * 
 * @author baozj
 * @version
 */
public interface PhDiabetesService extends GenericBaseService<PhDiabetes, PhDiabetesExample, Long>{

	int deleteByMasterId(List<Long> ids);
	
	List<PhDiabetes> selectStayPhDiabetesByMemberId(Integer memberId);
	
	PhDiabetes selectLatestPhDiabetesByMemberId(Integer memberId);
	
	List<PhDiabetes> selectPhDiabetesList(PhDiabetes pojo);
	
	Page<PhDiabetes> selectPage(Page<PhDiabetes> page, PhDiabetes model, List<Integer> odgpIds);
}

