/**
 * @PackageName:      com.bithealth.doctor.doctor
 * @FileName:     ShiroConver.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月23日 下午4:21:36  
 * 
 */
package com.bithealth.doctor;

import java.util.Date;

import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorAccount;
import com.bithealth.sdk.web.vo.ShiroUser;

/**
 * 类名称: ShiroConver  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月23日 下午4:21:36 
 * 
 * @author liuhm
 * @version  
 */
public class ShiroConver {
	
	 public static ShiroUser getUser(Doctor authentication,  ShiroUser shiroUser) {
         shiroUser.setId(authentication.getDocid());
         shiroUser.setName(authentication.getDoctorAccount().getDocacc());
         shiroUser.setRealName(authentication.getDocname());
         shiroUser.setDept_id(authentication.getOrgid());
         shiroUser.setState(authentication.getTag());
         shiroUser.setLoginTime(new Date());
         shiroUser.setRoleid(Integer.valueOf(authentication.getRoleid()));//.getId();
         shiroUser.setLastLoginAddr(authentication.getDoctorAccount().getLastloginaddr());
         shiroUser.setLastLoginTime(authentication.getDoctorAccount().getLastlogintime());
         shiroUser.setHeadAddress(authentication.getHeadaddress());
         shiroUser.setSignAddress(authentication.getSignaddress());
         shiroUser.setOrgName(authentication.getOrgName());
         shiroUser.setEmail(authentication.getEmail());
         shiroUser.setGender(authentication.getGender());
         return shiroUser;
    }
	 
	 public static Doctor getDoctor(ShiroUser shiroUser) {
		 Doctor doctor = new Doctor();
		 doctor.setDocid(shiroUser.getId());
		 doctor.setOrgid(shiroUser.getDept_id());
		 if(doctor.getDoctorAccount() == null) {
			 doctor.setDoctorAccount(new DoctorAccount());
		 }
		 doctor.getDoctorAccount().setDocacc(shiroUser.getName());
		 doctor.setRoleid(shiroUser.getRoleid().shortValue());
		 doctor.setDocname(shiroUser.getRealName());
		 return doctor;
	 }

}
