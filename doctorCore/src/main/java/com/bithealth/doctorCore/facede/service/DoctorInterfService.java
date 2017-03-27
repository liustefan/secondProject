/**
 * @PackageName:      com.bithealth.doctorCore.interf.service
 * @FileName:     DoctorInterfService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月22日 上午11:26:59  
 * 
 */
package com.bithealth.doctorCore.facede.service;

import java.util.List;

import com.bithealth.doctorCore.docGroup.model.DocToGroup;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorAccount;
import com.bithealth.doctorCore.enmu.DeviceEnum;
import com.bithealth.doctorCore.exception.AuthorizedException;
import com.bithealth.doctorCore.exception.LoginException;

/**
 * 类名称: DoctorInterfService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月22日 上午11:26:59 
 * 
 * @author liuhm
 * @version  
 */
public interface DoctorInterfService {
	
	/**
	 * 
	 * @Title:login 
	 * @Description:登录验证. 
	 * 1、医生账号登录，失败时判断上次失败的时间距离现在时间是否超过规定间隔时间，如果超过，失败次数值为0，否则在原来基础上+1
	 * 2、在规定间隔时间内超过失败的次数，不允许在规定时间内登录
	 * 3、判断是否首次登录从医生对象中取医生账号的上次登录时间为空
	 * @author liuhm
	 * @param doctorAccount
	 * @param device 登录终端
	 * @return 
	 * @param 
	 * @throws LoginException 登录异常信息
	 * @retrun Doctor
	 */
	Doctor login(DoctorAccount doctorAccount, DeviceEnum device)  throws LoginException ;
	
	/**
	 * 
	 * @Title:logout 
	 * @Description:注销登录. 
	 * @author liuhm
	 * @param loginDoc 
	 * @param 
	 * @throws
	 * @retrun void
	 */
	void logout(Doctor loginDoc);
	
	/**
	 * 
	 * @Title:insertDoctorGroupBatch 
	 * @Description:给医生设定医生分组
	 * @author liuhm
	 * @param loginDoc 操作管理员
	 * @param targetDoctor 目标医生
	 * @param list
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertDoctorGroupBatch(Doctor loginDoc, Doctor targetDoctor, List<DocToGroup> list)  throws AuthorizedException ;
	
	/**
	 * 
	 * @Title:restPassword 
	 * @Description:重置医生或者管理员密码,重置时需要验证登录医生的合法性 
	 * @author liuhm
	 * @param loginDoc
	 * @param targetDoc
	 * @return 
	 * @param 
	 * @throws AuthorizedException
	 * @retrun boolean
	 */
	boolean restPassword(Doctor loginDoc, Doctor targetDoc) throws AuthorizedException;
	
	/**
	 * 
	 * @Title:insertDoctor 
	 * @Description:保存修改医生，包括医生账号、基本信息. 
	 * @author liuhm
	 * @param targetDoc 需要新增修改医生，包含医生账号对象
	 * @param loginDoc  操作管理员
	 * @throws AuthorizedException
	 * @return boolean
	 */
	boolean insertOrUpdateDoctor(Doctor loginDoc, Doctor targetDoc) throws AuthorizedException;
	
	/**
	 * 
	 * @Title:delete 
	 * @Description:删除医生或者管理员. 
	 * @author liuhm
	 * @param loginDoc 登录用户
	 * @param targetDoc 需要删除对象
	 * @return 
	 * @param 
	 * @throws AuthorizedException
	 * @retrun boolean
	 */
	boolean delete(Doctor loginDoc, Doctor targetDoc) throws AuthorizedException;
	
	/**
	 * 修改密码
	 * @Title:updateInitPwdBySelf
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * @author liuhm
	 * @param doctor 
	 * @param 
	 * @throws
	 * @retrun void
	 */
	void updateInitPwdBySelf(Doctor doctor);
	
}
