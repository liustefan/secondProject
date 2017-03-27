/**
 * @PackageName:      com.bithealth.doctorCore.doctor.service
 * @FileName:     DoctorSessionService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午9:41:36  
 * 
 */
package com.bithealth.doctorCore.doctor.service;

import com.bithealth.doctorCore.doctor.model.DoctorSession;
import com.bithealth.doctorCore.doctor.model.DoctorSessionExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: DoctorSessionService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午9:41:36 
 * 
 * @author liuhm
 * @version  
 */
public interface DoctorSessionService extends GenericBaseService<DoctorSession, DoctorSessionExample, Integer> {
	
	/**
	 * 
	 * @Title:insertOrUpdate 
	 * @Description:新增或修改医生登录session. 
	 * @author liuhm
	 * @param session
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int insertOrUpdate(DoctorSession session);

}
