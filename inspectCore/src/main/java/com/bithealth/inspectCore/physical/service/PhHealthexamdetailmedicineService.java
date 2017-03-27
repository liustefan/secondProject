 
/**
 * @PackageName:      com.bithealth.inspectCore.physical.service
 * @FileName:     PhHealthexamdetailmedicineService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午10:54:54  
 * 
 */

package com.bithealth.inspectCore.physical.service;

import java.util.List;

import com.bithealth.inspectCore.physical.model.PhHealthexamdetailmedicine;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailmedicineExample;
import com.bithealth.sdk.core.generic.GenericBaseService;


/**
 * 类名称: PhHealthexamdetailmedicineService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午10:54:54 
 * 
 * @author baozj
 * @version  
 */
public interface PhHealthexamdetailmedicineService extends
		GenericBaseService<PhHealthexamdetailmedicine, PhHealthexamdetailmedicineExample, Long> {

	int inserts(List<PhHealthexamdetailmedicine> pojos, Long masterId);
	
	List<PhHealthexamdetailmedicine> selectByMasterId(Long masterId);
	
	int deleteByMasterId(List<Long> masterIds);
	
	int updateByMasterId(List<PhHealthexamdetailmedicine> pojos, Long masterId);
}

