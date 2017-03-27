/**
 * @PackageName:      com.bithealth.doctorCore.facede.service.impl
 * @FileName:     DoctorInterfServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月22日 下午5:29:25  
 * 
 */
package com.bithealth.doctorCore.facede.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bithealth.doctorCore.constants.Constants;
import com.bithealth.doctorCore.docGroup.model.DocToGroup;
import com.bithealth.doctorCore.docGroup.service.DoctorToGroupService;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorAccount;
import com.bithealth.doctorCore.doctor.model.DoctorAccountExample;
import com.bithealth.doctorCore.doctor.model.DoctorSession;
import com.bithealth.doctorCore.doctor.service.DoctorAccountService;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.doctorCore.doctor.service.DoctorSessionService;
import com.bithealth.doctorCore.enmu.DeviceEnum;
import com.bithealth.doctorCore.enmu.TagStatus;
import com.bithealth.doctorCore.exception.AuthorizedException;
import com.bithealth.doctorCore.exception.LoginException;
import com.bithealth.doctorCore.facede.service.DoctorInterfService;
import com.bithealth.sdk.common.utils.StringUtil;

/**
 * 类名称: DoctorInterfServiceImpl  
 * 功能描述: 医生接口实现类.  
 * 日期: 2016年6月22日 下午5:29:25 
 * 
 * @author liuhm
 * @version  
 */
@Service("doctorInterfService")
public class DoctorInterfServiceImpl implements DoctorInterfService {
	
	private final static Logger logger = Logger.getLogger(DoctorInterfServiceImpl.class);
	
	@Resource(name="doctorService")
	private DoctorService doctorService;
	@Resource(name="doctorAccountServiceImpl")
	private DoctorAccountService doctorAccountService;
	
	@Resource(name="doctorSessionService")
	private DoctorSessionService doctorSessionService;
	
	@Resource(name="doctorToGroupService")
	private DoctorToGroupService doctorToGroupService;
	
	@Override
	public Doctor login(DoctorAccount doctorAccount, DeviceEnum device) throws LoginException {
		if(doctorAccount == null || StringUtil.isEmpty(doctorAccount.getDocacc()) || StringUtil.isEmpty(doctorAccount.getDocpass())) {
			throw new LoginException(LoginException.ERROR_EMPTY);
		}
		
		DoctorAccountExample accountExample = new DoctorAccountExample();
		com.bithealth.doctorCore.doctor.model.DoctorAccountExample.Criteria criteria = accountExample.createCriteria();
		criteria.andDocaccEqualTo(doctorAccount.getDocacc());
		List<DoctorAccount> list = doctorAccountService.selectByExample(accountExample);  //依据账号查找
		if(list == null || list.isEmpty()) {
			throw new LoginException(LoginException.ERROR_NAME);
		}
		
		DoctorAccount login = list.get(0);
		Doctor doctor = login.getDoctor();
		if(doctor == null) {
			throw new LoginException(LoginException.ERROR_NAME);
		}
		
		if(!TagStatus.T.name().equals(doctor.getTag())) {
			throw new LoginException(LoginException.ERROR_STATUS);
		}
		
		device = device == null ? DeviceEnum.Other : device;
		int fails = login.getFailcount() == null ? 0 : login.getFailcount();
		long time = login.getFailtime() == null ? 0 : login.getFailtime().getTime();
		long now = System.currentTimeMillis();
		if((now - time) <= Constants.INTERVAL_MAX * 60 * 1000) {  //在规定间隔时间内
			if(Constants.FAIL_COUNT_MAX <= fails) {  //超过失败次数
				this.updateAccount(false, doctorAccount);
				throw new LoginException(LoginException.OVER_FAIL_COUNT);
			}
			
			if(!doctorAccount.getDocpass().equals(login.getDocpass())) {  //密码不对计数+1
				this.updateAccount(false, doctorAccount);
				throw new LoginException(LoginException.ERROR_PWD);
			}
			
		} else {  //在规定时间以外
			if(!doctorAccount.getDocpass().equals(login.getDocpass())) { //密码不对
				this.updateAccount(false, doctorAccount);
				throw new LoginException(LoginException.ERROR_PWD);
			}
		}
		
		
		//登录成功
		this.updateAccount(true, doctorAccount);
		
		DoctorSession session = doctor.getDoctorSession();
		if(session == null) {
			session = new DoctorSession();
		}
		session.setDoctorId(doctor.getDocid());
		session.setTag(TagStatus.T.name());
		session.setPassword(doctorAccount.getDocpass());
		session.setDevice(device == null ? null : device.name());
		session.setLoginTime(new Date());
//		session.setSession(UUID.randomUUID().toString());
		try{
			doctorSessionService.insertOrUpdate(session);
		} catch(Exception e) {
			logger.error("登录时更新令牌失败：" + e.getLocalizedMessage());
		}
		
		doctor.setDoctorSession(session);
		logger.info(new Date() + doctorAccount.getDocacc() + "通过" + doctorAccount.getLastloginaddr() + "在" + (device == null? "" : device.name()) + "设备上登录成功");
		return doctor;
	}
	
	private void updateAccount(boolean isLogined, DoctorAccount doctorAccount) {
		try{
			doctorAccountService.updateAcountByLogin(isLogined, doctorAccount);
		}catch(Exception e) {
			logger.error("登录时更新账号失败：" + e.getLocalizedMessage());
		}
	}
	
	@Override
	public void logout(Doctor loginDoc) {
		Doctor doctor = doctorService.selectById(loginDoc.getDocid());
		if(doctor == null) {
			return;
		}
		DoctorSession session = doctor.getDoctorSession();
		session.setSession(null);
		doctorSessionService.updateByPrimaryKey(session);
		logger.info(new Date() + doctor.getDoctorAccount().getDocacc() + "注销登录");
	}

	@Override
	public boolean insertDoctorGroupBatch(Doctor loginDoc, Doctor targetDoctor, List<DocToGroup> list) throws AuthorizedException {
		loginDoc = doctorService.selectById(loginDoc.getDocid());
		targetDoctor = doctorService.selectById(targetDoctor.getDocid());
		if(loginDoc.getRoleid() != 1) {
			throw new AuthorizedException("您无权操作");
		}
		if(list == null || list.isEmpty()) {
			return false;
		}
		if(doctorToGroupService.deleteByDoctor(targetDoctor.getDocid())) {
			for(DocToGroup group : list) {
				group.setDocid(targetDoctor.getDocid());
				group.setOrgid(targetDoctor.getOrgid());
			}
			doctorToGroupService.insertBatch(list);
		}
		
		return true;
	}

	@Override
	public boolean restPassword(Doctor loginDoc, Doctor targetDoc) throws AuthorizedException {
		// 需要确定各角色初始密码:系统管理员role=6初始密码为：healthcare99，
		DoctorAccount account = targetDoc.getDoctorAccount();
		String newPwd = Constants.COMMON_ADMIN;
		if(account != null) {
			newPwd = targetDoc.getDoctorAccount().getDocpass();
		}
		targetDoc = doctorService.selectById(targetDoc.getDocid());
		account = targetDoc.getDoctorAccount();
		account.setDocpass(newPwd); //设置医生默认密码
		loginDoc = doctorService.selectById(loginDoc.getDocid());
		
		int targetRole = targetDoc.getRoleid();
		
		//普通管理员重置医生密码
		if(loginDoc.getRoleid().intValue() == 1) {  //普通管理员角色
			if(targetRole == 1 || targetRole == 5 || targetRole == 6) {
				throw new AuthorizedException("您无权重置密码");
			}
		}
		
		if(loginDoc.getRoleid().intValue() == 6) {  //系统管理员角色
			if(targetRole != 1 && targetRole != 5) {
				throw new AuthorizedException("您无权重置密码");
			}
			if(targetRole == 5) {  //金钥匙密码
//				account.setDocpass(Constants.GOLDEN_USER);
			} 
			
			if(targetRole == 1) {  //金钥匙密码
//				account.setDocpass(Constants.COMMON_ADMIN);
			} 
		}
		
		if(loginDoc.getRoleid().intValue() == 5) {  //金钥匙 只能重置系统管理元密码
			if(targetRole != 6) {
				throw new AuthorizedException("您无权重置密码");
			}
			account.setDocpass(Constants.SUPER_ADMIN);
		}
		
		return doctorAccountService.updateByPrimaryKey(account) == 1;
	}

	@Override
	public boolean insertOrUpdateDoctor(Doctor loginDoc, Doctor targetDoc) throws AuthorizedException {
		loginDoc = doctorService.selectById(loginDoc.getDocid());
		int loginRole = loginDoc.getRoleid();
		int targetRole = targetDoc.getRoleid();
		if(loginRole == 2 || loginRole == 3 || loginRole == 4 || loginRole == 7) {
			throw new AuthorizedException("无权操作");
		}
		
		if(loginRole != 5 && targetRole == 6) {  //金钥匙添加系统管理员
			throw new AuthorizedException("无权操作");
		}
		
		if(loginRole != 6 && targetRole == 1) {  //系统管理员只能操作普通管理员
			throw new AuthorizedException("无权操作");
		}
		
		if(loginRole == 1 && targetRole != 2 && targetRole != 3 && targetRole != 4 && targetRole != 7) { //普通管理员创建医生
			throw new AuthorizedException("无权操作");
		}
		
		DoctorAccount account = targetDoc.getDoctorAccount();
		if(targetDoc.getDocid() == null) {
			targetDoc.setDocGUID(StringUtil.UUID());
			if(targetRole == 6) {
				account = new DoctorAccount();
				account.setDocacc(doctorAccountService.getSuperAdminAccount());
				account.setDocpass(Constants.SUPER_ADMIN); 
				targetDoc.setDoctorAccount(account);
			} else {
				if(account == null) {
					throw new AuthorizedException("账号为空");
				}
				if(StringUtil.isEmpty(account.getDocacc())) {
					throw new AuthorizedException("账号为空");
				}
				DoctorAccount repAccount = doctorAccountService.selectByAccount(account.getDocacc());
				if(repAccount != null) {
					throw new AuthorizedException(account.getDocacc() + "账号已存在");
				}
			}
			targetDoc.setTag(TagStatus.T.name());
			doctorService.insert(targetDoc);
			account.setDocid(targetDoc.getDocid());
			account.setLogrole(String.valueOf(targetDoc.getRoleid()));
			account.setTag(targetDoc.getTag());
			account.setOrgid(targetDoc.getOrgid());
			doctorAccountService.insert(account);
			
			DoctorSession session = new DoctorSession();  //医生登录session
			session.setDoctorId(targetDoc.getDocid());
			session.setPassword(account.getDocpass());
			session.setTag(TagStatus.T.name());
			doctorSessionService.insertOrUpdate(session);
		} else {
			//账号不允许修改
			doctorService.update(targetDoc);
		}
		return true;
	}

	@Override
	public boolean delete(Doctor loginDoc, Doctor targetDoc) throws AuthorizedException {
		targetDoc = doctorService.selectById(targetDoc.getDocid());
		int targetRole = targetDoc.getRoleid();
		loginDoc = doctorService.selectById(loginDoc.getDocid());
		int loginRole = loginDoc.getRoleid();
		if(targetRole == 6) {  //只有金钥匙才能删除系统管理员
			if(loginRole != 5) {
				throw new AuthorizedException("无权删除系统管理员");
			}
		}
		
		if(targetRole == 1) {  //系统管理员才能删除普通管理员
			if(loginRole != 6) {
				throw new AuthorizedException("无权删除普通管理员");
			}
		}
		boolean isDoctor = false;
		if(targetRole == 2 || targetRole == 3 || targetRole == 4 || targetRole == 7) {
			if(loginRole != 1) {
				throw new AuthorizedException("无权删除医生");
			}
			isDoctor = true;
		}
		
		if(doctorAccountService.delete(targetDoc.getDocid()) > 0) {
			if(isDoctor) {
				doctorToGroupService.deleteByDoctor(targetDoc.getDocid());
			}
			return doctorService.delete(targetDoc.getDocid()) > 0;
		}
		return false;
	}

	@Override
	public void updateInitPwdBySelf(Doctor doctor) {
		doctorService.updateByPrimaryKey(doctor);
		doctorAccountService.updateByPrimaryKey(doctor.getDoctorAccount());
	}
}
