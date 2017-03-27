/**
 * @PackageName:      com.bithealth.doctorCore.doctor.service
 * @FileName:     DoctorAccountService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月22日 上午10:05:37  
 * 
 */
package com.bithealth.doctorCore.doctor.service;

import com.bithealth.doctorCore.doctor.model.DoctorAccount;
import com.bithealth.doctorCore.doctor.model.DoctorAccountExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: DoctorAccountService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月22日 上午10:05:37 
 * 
 * @author liuhm
 * @version  
 */
public interface DoctorAccountService extends GenericBaseService<DoctorAccount, DoctorAccountExample, Integer> {
	
	/**
	 * 
	 * @Title:getSuperAdminAccount 
	 * @Description:获取系统管理员账号. 
	 * @author liuhm
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	public String getSuperAdminAccount();
	
	/**
	 * 
	 * @Title:selectByAccount 
	 * @Description:账号查询. 
	 * @author liuhm
	 * @param account
	 * @return 
	 * @param 
	 * @throws
	 * @retrun DoctorAccount
	 */
	public DoctorAccount selectByAccount(String account);
	
	/**
	 * 
	 * @Title:updateAcountByLogin 
	 * @Description:依据登录情况更新账号表信息. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param isLogined true-登录成功
	 * @param account
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	public boolean updateAcountByLogin(boolean isLogined, DoctorAccount account);
	
	/**
	 * 
	 * @Title:updateSelfPwd 
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param oldPwd 旧密码
	 * @param account 修改账号密码
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	public boolean updateSelfPwd(String oldPwd, DoctorAccount account);
}
