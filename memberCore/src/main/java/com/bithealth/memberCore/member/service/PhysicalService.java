/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     PhysicalService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 上午11:26:46  
 * 
 */
package com.bithealth.memberCore.member.service;

import com.bithealth.memberCore.member.model.PhysicalExamination;
import com.bithealth.memberCore.member.model.PhysicalExaminationExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: PhysicalService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 上午11:26:46 
 * 
 * @author liuhm
 * @version  
 */
public interface PhysicalService extends
		GenericBaseService<PhysicalExamination, PhysicalExaminationExample, Integer> {
	
	/**
	 * 
	 * @Title:insertOrUpdate 
	 * @Description:保存或者更新体格检查. 
	 * @author liuhm
	 * @param physical
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int insertOrUpdate(PhysicalExamination physical);

}
