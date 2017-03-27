 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.service
 * @FileName:     PhDiabetesdetailService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午10:44:42  
 * 
 */

package com.bithealth.inspectCore.inspect.service;

import java.util.List;

import com.bithealth.inspectCore.inspect.model.PhDiabetesdetail;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetailExample;
import com.bithealth.sdk.core.generic.GenericBaseService;


/**
 * 类名称: PhDiabetesdetailService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午10:44:42 
 * 
 * @author baozj
 * @version  
 */
public interface PhDiabetesdetailService extends GenericBaseService<PhDiabetesdetail, PhDiabetesdetailExample, Long> {

	int insert(PhDiabetesdetail pojo, Long masterId);
	
	int updateByMasterId(PhDiabetesdetail pojo, Long masterId);
	
	int deleteByMasterId(List<Long> masterIds);
	
}

