/**
 * @PackageName:      com.bithealth.doctorCore.doctor.service.impl
 * @FileName:     DoctorAccountServiceImpl.java  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月23日 下午1:58:42  
 * 
 */
package com.bithealth.doctorCore.doctor.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.doctorCore.constants.Constants;
import com.bithealth.doctorCore.doctor.dao.DoctorAccountMapper;
import com.bithealth.doctorCore.doctor.model.DoctorAccount;
import com.bithealth.doctorCore.doctor.model.DoctorAccountExample;
import com.bithealth.doctorCore.doctor.service.DoctorAccountService;
import com.bithealth.doctorCore.enmu.TagStatus;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: DoctorAccountServiceImpl  
 * 日期: 2016年6月23日 下午1:58:42 
 * 
 * @author liuhm
 * @version  
 */
@Service("doctorAccountServiceImpl")
public class DoctorAccountServiceImpl extends GenericBaseServiceImpl<DoctorAccount, DoctorAccountExample, Integer> implements DoctorAccountService {

	@Autowired
    private DoctorAccountMapper doctorAccountMapper;
	@Override
	public GenericBaseDao<DoctorAccount, DoctorAccountExample, Integer> getDao() {
		return doctorAccountMapper;
	}
	
	@Override
	public String getSuperAdminAccount() {
		DoctorAccountExample example = new DoctorAccountExample();
		com.bithealth.doctorCore.doctor.model.DoctorAccountExample.Criteria criteria = example.createCriteria();
		criteria.andTagEqualTo(TagStatus.T.name());
		criteria.andLogroleEqualTo("6");
		example.setOrderByClause("Docid DESC");
		List<DoctorAccount> accounts = doctorAccountMapper.selectByExample(example);
		if(accounts == null || accounts.size() == 0) {
			return "Admin1";
		}
		return "Admin" + (Integer.parseInt(accounts.get(0).getDocacc().substring(5)) + 1);
	}

	@Override
	public DoctorAccount selectByAccount(String account) {
		DoctorAccountExample example = new DoctorAccountExample();
		com.bithealth.doctorCore.doctor.model.DoctorAccountExample.Criteria criteria = example.createCriteria();
		if(!StringUtil.isEmpty(account)) {
			criteria.andDocaccEqualTo(account);
		}
		criteria.andTagEqualTo(TagStatus.T.name());
		example.setOrderByClause("Docid DESC");
		List<DoctorAccount> accounts = doctorAccountMapper.selectByExample(example);
		if(accounts == null || accounts.size() == 0) {
			return null;
		}
		return accounts.get(0);
	}

	@Override
	public int delete(Integer id) {
		DoctorAccount account = doctorAccountMapper.selectByPrimaryKey(id);
		if(account == null) {
			return 1;
		}
		if(account.getLogrole().equals("6")) { //删除系统管理员时，至少保留一个系统管理员
			DoctorAccountExample example = new DoctorAccountExample();
			DoctorAccountExample.Criteria criteria = example.createCriteria();
			criteria.andLogroleEqualTo(account.getLogrole());
			int count = doctorAccountMapper.countByExample(example);
			if(count <= 1) {
				return 0;
			}
//			return doctorAccountMapper.deleteByPrimaryKey(id);  //系统管理员物理删除，其他逻辑删除
		}
//		account.setTag(TagStatus.E.name());
//		return doctorAccountMapper.updateByPrimaryKey(account);
		return doctorAccountMapper.deleteByPrimaryKey(id);  //系统管理员物理删除，其他逻辑删除
	}

	@Override
	public int deleteByExample(DoctorAccountExample example) {
		DoctorAccount account = new DoctorAccount();
		account.setTag(TagStatus.E.name());
		return doctorAccountMapper.updateByExampleSelective(account, example);
	}

	@Override
	public boolean updateAcountByLogin(boolean isLogined, DoctorAccount model) {
		String ip = model.getLastloginaddr();  //当前登录IP
		model = this.selectByAccount(model.getDocacc());
		if(isLogined) {
			model.setFailcount(0);
			model.setLastloginaddr(ip);
			model.setLastlogintime(new Date());
			return super.updateByPrimaryKey(model) > 0;
		}
		
		int fails = model.getFailcount() == null ? 0 : model.getFailcount();
		long time = model.getFailtime() == null ? 0 : model.getFailtime().getTime();
		long now = System.currentTimeMillis();
		if((now - time) <= Constants.INTERVAL_MAX * 60 * 1000) {  //在规定间隔时间内
			if(Constants.FAIL_COUNT_MAX <= fails) {  //超过失败次数,只更新出错时间
				model.setFailtime(new Date());
			} else {
				model.setFailcount(fails + 1);
				if(Constants.FAIL_COUNT_MAX == (fails + 1)) {  //临界时间
					model.setFailtime(new Date()); //记录达到上限的错误时间
				}
			}
		} else {  //在规定时间以外,重置失败次数为0，重新计数
			model.setFailcount(1);
			model.setFailtime(new Date());
		}
		return super.updateByPrimaryKey(model) > 0;
	}

	@Override
	public boolean updateSelfPwd(String oldPwd, DoctorAccount account) {
		String newPwd = account.getDocpass();
		account = doctorAccountMapper.selectByPrimaryKey(account.getDocid());
		if(account == null) {
			return false;
		}
		if(!oldPwd.equals(account.getDocpass())) {
			throw new BusinessException("原始密码输入不匹配");
		}
		
		account.setDocpass(newPwd);
		return doctorAccountMapper.updateByPrimaryKey(account) > 0;
	}
	
	
}
