/**
 * @PackageName:      com.bithealth.ucCore.facade.service.impl
 * @FileName:     MergeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月7日 上午10:50:32  
 * 
 */
package com.bithealth.ucCore.facade.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import sun.util.logging.resources.logging;

import com.bithealth.sdk.common.utils.PinYinUtil;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.ucCore.facade.enmu.AccountTypeEnum;
import com.bithealth.ucCore.facade.enmu.ResultCode;
import com.bithealth.ucCore.facade.enmu.VerifyType;
import com.bithealth.ucCore.facade.service.MergeService;
import com.bithealth.ucCore.uc.model.AccountResult;
import com.bithealth.ucCore.uc.model.AppServer;
import com.bithealth.ucCore.uc.model.MemberAccount;
import com.bithealth.ucCore.uc.model.MemberBasicInfo;
import com.bithealth.ucCore.uc.model.ReturnObject;
import com.bithealth.ucCore.uc.result.CheckMember;
import com.bithealth.ucCore.uc.result.MemberBase;
import com.bithealth.ucCore.uc.result.MergeResult;
import com.bithealth.ucCore.uc.service.AppServerService;
import com.bithealth.ucCore.uc.service.MemberAccountService;
import com.bithealth.ucCore.uc.service.MemberBasicInfoService;

/**
 * 类名称: MergeServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月7日 上午10:50:32 
 * 
 * @author liuhm
 * @version  
 */
@Service
public class MergeServiceImpl implements MergeService {
	private static Logger logger=Logger.getLogger(MergeServiceImpl.class);

	@Resource(name="appServerService")
	AppServerService appServerService;
	
	@Resource
	MemberAccountService memberAccountService;
	
	@Resource
	MemberBasicInfoService memberBasicInfoService;

	@Override
	public ReturnObject checkMerge(String tel, String idcard, String name) {
		logger.info("合并校验接收参数：tel=" + tel + ",idcard=" + idcard + ",name=" + name);
		if(StringUtil.isEmpty(tel) || StringUtil.isEmpty(idcard) || StringUtil.isEmpty(name)) {
			return new ReturnObject(ResultCode.Parameter_Error.code, ResultCode.Parameter_Error.desc);
		}
		
		MemberBasicInfo member = memberBasicInfoService.selectByAccount(tel);
		if(member == null) {
			return new ReturnObject(ResultCode.User_Unknow.code, ResultCode.User_Unknow.desc);
		}
		
		MemberBasicInfo existMem = memberBasicInfoService.selectByIdcard(idcard);
		if(existMem == null) {  
			return checkByTelAndName(name, tel, member);
		}
		if(name.equals(existMem.getMemberName())) {
			logger.info("8888:自动合并");
			return new ReturnObject(8888, "直接合并", getCheckMember(existMem.getMemberID(), existMem.getServerID(), member));
		}
		String nameCode = PinYinUtil.getPinYinHeadChar(name);
		if(nameCode.equalsIgnoreCase(existMem.getMemNameCode())) {
			logger.info("6666：存在简码相同会员，确认是否合并");
			return new ReturnObject(6666, "存在简码相同会员，确认是否合并", getCheckMember(existMem.getMemberID(), existMem.getServerID(), member));
		}
		logger.info("7777：身份证号可能不是本人");
		return new ReturnObject(7777, "身份证号可能不是你本人");
	}
	
	@Override
	public MergeResult merge(String sourGuid, int sourSrvId, MemberBasicInfo info) {
		AppServer app = appServerService.selectById(info.getServerID());
		int srvId  = info.getServerID();
		String appServerUrl = app.getIpAddress();
		MemberBasicInfo source = memberBasicInfoService.selectByGuid(sourGuid);
		if(source == null || sourSrvId != source.getServerID().intValue()) {
			return new MergeResult(info.getMemberID(), ResultCode.User_Unknow.code, ResultCode.User_Unknow.desc, srvId, appServerUrl);
		}
		MemberBasicInfo source1 = memberBasicInfoService.selectByIdcard(info.getIDCard());
		if(source1 != null && !sourGuid.equals(source1.getMemberID()) && !info.getMemberID().equals(source1.getMemberID())) {
			return new MergeResult(info.getMemberID(), ResultCode.Other_ERROR.code, "身份证号已经存在", srvId, appServerUrl);
		}
		
		MemberBasicInfo target = memberBasicInfoService.selectByGuid(info.getMemberID());
		if(target == null) {
			return new MergeResult(info.getMemberID(), ResultCode.User_Unknow.code, "目标会员不存在", srvId, appServerUrl);
		}
		if(target.getIsInfoPerfect().byteValue() == 1) {
			return new MergeResult(info.getMemberID(), ResultCode.Other_ERROR.code, "目标会员资料已完善，无法合并", srvId, appServerUrl);
		}
		
		MemberBasicInfo base = memberBasicInfoService.selectByNameAndTel(info.getMemberName(), info.getMobile(), VerifyType.YES.getCode());
		if(base != null && !base.getMemberID().equals(info.getMemberID())){
			return new MergeResult(info.getMemberID(), ResultCode.Other_ERROR.code, "手机号，会员姓名已经存在", srvId, appServerUrl);
		}
		target.setMemberName(info.getMemberName());
		target.setMemNameCode(PinYinUtil.getPinYinHeadChar(info.getMemberName()));
		target.setIDCard(info.getIDCard());
		target.setMobile(info.getMobile());
		target.setIsInfoPerfect(VerifyType.YES.getCode());
		target.setVerifyType(VerifyType.YES.getCode());
		memberBasicInfoService.update(target);
		List<AccountResult> accountList = updateMemberInfo(source, target);
		MergeResult result = new MergeResult(info.getMemberID(), 1, "合并成功", srvId, appServerUrl);
		result.setPassword(source.getPwd());
		result.setAccountlist(accountList);
		return result;
	}
	
	private List<AccountResult> updateMemberInfo(MemberBasicInfo source, MemberBasicInfo member) {
		List<AccountResult> accountList = new ArrayList<>();
		if(!source.getMemberID().equals(member.getMemberID())) {
			memberBasicInfoService.delete(source.getLogID());
			memberAccountService.deleteAccountByGuid(source.getMemberID());
		}
		
		memberBasicInfoService.update(member);
		
		MemberAccount account = new MemberAccount(member.getMemberID(), member.getMobile(), AccountTypeEnum.TEL.getType());
		account.setServerId(member.getServerID());
		if(memberAccountService.updateAccount(account) == 0) {
			account.setCreateTime(new java.util.Date());
			account.setUpdateTime(new java.util.Date());
			memberAccountService.insert(account);
		}
		accountList.add(new AccountResult(1, account.getAccount(), account.getAccountType().intValue()));
		account = new MemberAccount(member.getMemberID(), member.getIDCard(), AccountTypeEnum.IDCARD.getType());
		account.setServerId(member.getServerID());
		if(memberAccountService.updateAccount(account) == 0) {
			account.setCreateTime(new java.util.Date());
			account.setUpdateTime(new java.util.Date());
			memberAccountService.insert(account);
		}
		accountList.add(new AccountResult(1, account.getAccount(), account.getAccountType().intValue()));
		return accountList;
	}



	private CheckMember getCheckMember(String targetGid, int targetSrvId, MemberBasicInfo source) {
		AppServer sourceServer = appServerService.selectById(source.getServerID());
		AppServer targetServer = appServerService.selectById(targetSrvId);
		CheckMember check = new CheckMember();
		check.setSourceGuid(source.getMemberID());
		check.setSourceSrvId(source.getServerID());
		check.setSourceAppSrvUrl(sourceServer.getIpAddress());
		
		check.setTargetGuid(targetGid);
		check.setTargetSrvId(targetSrvId);
		check.setTargetAppSrvUrl(targetServer.getIpAddress());
		return check;
	}
	
	/**
	 * 
	 * @Title:checkByTelAndName 
	 * @Description:(身份证不存在的情况下，手机号和姓名判断是否合并). 
	 * @author liuhm
	 * @param name
	 * @param tel
	 * @return 
	 * @param 
	 * @throws
	 * @retrun ReturnObject
	 */
	private ReturnObject checkByTelAndName(String name, String tel, MemberBasicInfo orginalMem) {
		Integer count = memberBasicInfoService.countByTel(tel, orginalMem.getMemberID());
		if(count == null || count == 0) {
			logger.info("9999:无需合并，在中心直接完善资料");
			return new ReturnObject(9999, "无需合并，在中心直接完善资料", getCheckMember(orginalMem.getMemberID(), orginalMem.getServerID(), orginalMem));
		}
		List<MemberBase> memberList = memberBasicInfoService.selectMemberByDetail(null, null, tel);
		for(MemberBase member : memberList) {
			if(member.getMemberGUID().equals(orginalMem.getMemberID())) {
				continue;
			}
			if(StringUtil.isNotEmpty(member.getMemberName())) {
				if(name.equals(member.getMemberName())) { //手机号+姓名相同，这样的会员最多两个，一个未完善，一个以完善的会员
					if(StringUtil.isNotEmpty(member.getIdcard())) {
						logger.info("7777:身份证号可能不是本人");
						return new ReturnObject(7777, "身份证号可能不是你本人");
					} else {
						logger.info("8888:自动合并");
						return new ReturnObject(8888, "直接合并", getCheckMember(member.getMemberGUID(), member.getServerId(), orginalMem));
					}
				}
			}
		}
		logger.info("9999:无需合并，在中心直接完善资料");
		return new ReturnObject(9999, "无需合并，在中心直接完善资料", getCheckMember(orginalMem.getMemberID(), orginalMem.getServerID(), orginalMem));
	}
	

}
