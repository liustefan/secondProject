/**
 * @PackageName:      com.bithealth.doctorCore.facede.service
 * @FileName:     DoctorGroupInterfService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月27日 下午4:22:24  
 * 
 */
package com.bithealth.doctorCore.facede.service;

import com.bithealth.doctorCore.docGroup.model.DoctorGroup;

/**
 * 类名称: DoctorGroupInterfService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月27日 下午4:22:24 
 * 
 * @author liuhm
 * @version  
 */
public interface DoctorGroupInterfService {
	
	/**
	 * 
	 * @Title:saveOrUpdate 
	 * @Description:新增、修改医生分组
	 * @author liuhm
	 * @param doctorGroup
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int saveOrUpdate(DoctorGroup doctorGroup);
	
	/**
	 * 
	 * @Title:deleteDoctorGroup 
	 * @Description:删除医生分组. 
	 * @author liuhm
	 * @param id
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int deleteDoctorGroup(Integer id);
	
}
