 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.service
 * @FileName:     PhHypertensiondetailService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午10:45:59  
 * 
 */

package com.bithealth.inspectCore.inspect.service;

import java.util.List;

import com.bithealth.inspectCore.inspect.model.PhHypertensiondetail;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailExample;
import com.bithealth.sdk.core.generic.GenericBaseService;


/**
 * 类名称: PhHypertensiondetailService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午10:45:59 
 * 
 * @author baozj
 * @version  
 */
public interface PhHypertensiondetailService extends GenericBaseService<PhHypertensiondetail, PhHypertensiondetailExample, Long> {

	int deleteByMasterId(List<Long> masterIds);
	
	int insert(PhHypertensiondetail pojo, Long masterId);
	
	int updateByMasterId(PhHypertensiondetail pojo, Long masterId);
}

