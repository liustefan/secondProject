 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.service
 * @FileName:     PhHypertensiondetailmedicineService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午10:46:14  
 * 
 */

package com.bithealth.inspectCore.inspect.service;

import java.util.List;

import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailmedicine;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailmedicineExample;
import com.bithealth.sdk.core.generic.GenericBaseService;


/**
 * 类名称: PhHypertensiondetailmedicineService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午10:46:14 
 * 
 * @author baozj
 * @version  
 */
public interface PhHypertensiondetailmedicineService extends GenericBaseService<PhHypertensiondetailmedicine, PhHypertensiondetailmedicineExample, Long> {

	List<PhHypertensiondetailmedicine> selectByMasterId(Long masterId);
	
	int deleteByMasterId(List<Long> masterIds);
	
	int inserts(List<PhHypertensiondetailmedicine> pojos, Long masterId);
	
	int updateByMasterId(List<PhHypertensiondetailmedicine> pojos, Long masterId);
}

