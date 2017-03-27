 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.service
 * @FileName:     PhHypertensionService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午10:45:23  
 * 
 */

package com.bithealth.inspectCore.inspect.service;

import java.util.List;

import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensionExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;


/**
 * 类名称: PhHypertensionService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午10:45:23 
 * 
 * @author baozj
 * @version  
 */
public interface PhHypertensionService extends GenericBaseService<PhHypertension, PhHypertensionExample, Long> {

	int deleteByMasterId(List<Long> masterIds);
	
	List<PhHypertension> selectStayPhDiabetesByMemberId(Integer memberId);
	
	PhHypertension selectLatestPhHypertensionByMemberId(Integer memberId);
	
	List<PhHypertension> selectPhHypertensionList(PhHypertension pojo);
	
	Page<PhHypertension> selectPage(Page<PhHypertension> page, PhHypertension model, List<Integer> odgpIds);
}

