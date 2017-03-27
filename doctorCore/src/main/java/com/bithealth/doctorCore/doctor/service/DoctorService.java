/**
 * @PackageName:      com.bithealth.doctorCore.doctor.service
 * @FileName:     DoctorService.java  
 * @Description: 提供医生相关服务接口 
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      刘海明 
 * @version      V1.0  
 * @Createdate:  2016年6月17日 下午3:33:14  
 * 
 */
package com.bithealth.doctorCore.doctor.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: DoctorService  
 * 功能描述: 医生服务接口类.  
 * 日期: 2016年6月17日 下午3:33:14 
 * 
 * @author liuhm
 * @version  
 */
public interface DoctorService extends GenericBaseService<Doctor, DoctorExample, Integer> {
	
	/**
	 * 
	 * @Title:checkDoctorExist 
	 * @Description:医生分组下的医生. 
	 * @author liuhm
	 * @param doctorGroupId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List
	 */
	List<Doctor> selectDoctorByGroup(int doctorGroupId);
	
	/**
	 * 
	 * @Title:isMyMember 
	 * @Description:会员是否属于医生管理 
	 * @author liuhm
	 * @param docId
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	boolean isMyMember(Integer docId, Integer memberId, Integer orgId);
	
	/**
	 * 
	 * @Title:selectByUUID 
	 * @Description:依据UUID获取医生. 
	 * @author liuhm
	 * @param UUID
	 * @return 
	 * @param 
	 * @throws
	 * @retrun Doctor
	 */
	Doctor selectByUUID(String UUID);
	
    Page<Doctor> selectByMember(Integer memebrId, Page<Doctor> page);
    
    Integer countByMember(Integer memberId);
}
