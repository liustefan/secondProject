 
/**
 * @PackageName:      com.bithealth.inspectCore.physical.service
 * @FileName:     PhHealthexamdetailfamilybedService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午10:49:59  
 * 
 */

package com.bithealth.inspectCore.physical.service;

import java.util.List;

import com.bithealth.inspectCore.physical.model.PhHealthexamdetailfamilybed;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailfamilybedExample;
import com.bithealth.sdk.core.generic.GenericBaseService;


/**
 * 类名称: PhHealthexamdetailfamilybedService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午10:49:59 
 * 
 * @author baozj
 * @version  
 */
public interface PhHealthexamdetailfamilybedService extends
		GenericBaseService<PhHealthexamdetailfamilybed, PhHealthexamdetailfamilybedExample, Long> {
	
	/**
	 * 
	 * @Title:inserts 
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author baozj
	 * @param pojos
	 * @param HExamID
	 * @return 
	 * @throws
	 * @retrun int
	 */
	int inserts(List<PhHealthexamdetailfamilybed> pojos, Long masterId);
	
	List<PhHealthexamdetailfamilybed> selectByMasterId(Long masterId);
	
	int deleteByMasterId(List<Long> masterIds);
	
	int updateByMasterId(List<PhHealthexamdetailfamilybed> pojos, Long masterId);
}

