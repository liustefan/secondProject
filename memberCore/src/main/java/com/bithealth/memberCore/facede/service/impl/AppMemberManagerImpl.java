/**
 * @PackageName:      com.bithealth.memberCore.facede.service.impl
 * @FileName:     AppMemberManagerImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月9日 上午10:35:11  
 * 
 */
package com.bithealth.memberCore.facede.service.impl;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bithealth.agentCore.AgentStatus;
import com.bithealth.agentCore.enums.UCMethodEnum;
import com.bithealth.memberCore.constants.CodeStatus;
import com.bithealth.memberCore.enmu.AccountTypeEnum;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.facede.service.AppMemberManager;
import com.bithealth.memberCore.facede.service.MemberInterfService;
import com.bithealth.memberCore.member.model.MemAccount;
import com.bithealth.memberCore.member.model.MemSession;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberAccountService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.service.MemberSessionService;
import com.bithealth.memberCore.memberLabel.service.MemberLabelItemService;
import com.bithealth.memberCore.uc.bean.AppServer;
import com.bithealth.memberCore.uc.bean.CheckAccountResult;
import com.bithealth.memberCore.uc.bean.CheckResult;
import com.bithealth.memberCore.uc.bean.MemberInfo;
import com.bithealth.memberCore.uc.bean.UCRetBase;
import com.bithealth.memberCore.uc.service.UCAgentService;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.exception.BusinessException;

/**
 * 类名称: AppMemberManagerImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月9日 上午10:35:11 
 * 
 * @author liuhm
 * @version  
 */
@Service
public class AppMemberManagerImpl extends UCAgentService implements AppMemberManager {
	
	private final static Logger logger = Logger.getLogger(AppMemberManagerImpl.class);
	
	@Resource(name="memberAccountService")
	private MemberAccountService accountService;
	
	@Resource(name="memberAccountService")
	protected MemberAccountService memAccountService;
	
	@Resource(name="memberSessionService")
	protected MemberSessionService memberSessionService;
	
	@Resource(name="memberService")
	protected MemberService memberService;
	
	@Resource(name="memberInterfService")
	private MemberInterfService memberInterfService;
	
	@Resource
	private MemberLabelItemService memberLabelItemService;

	@Override
	public CheckResult checkMerge(String idcard, String tel, String name) {
		MemAccount account = accountService.selectByAccount(tel);
		if(account == null) {
			return new CheckResult(101, "会员不存在");
		}
		MemSession session = account.getMemberSession();
		if(session == null || StringUtil.isEmpty(session.getSession())) {
			return new CheckResult(100, tel + "账号未登陆");
		}
		JSONObject obj = new JSONObject();
		obj.put("memberName", name);
		obj.put("IDCard", idcard);
		obj.put("mobile", tel);
		Response response = super.getAgentResult(obj.toJSONString(), UCMethodEnum.CheckMerge);
		if(response == null) {
			return new CheckResult(CodeStatus.SC_REQUEST_TIMEOUT, "请求连接超时");
		}
		if(response.getStatus() == AgentStatus.SC_OK) {
			String body = response.getBody();
			if(StringUtil.isEmpty(body)) {
				return new CheckResult(CodeStatus.DATA_ERROR, "agent返回body为空");
			}
			CheckResult result = JSONObject.parseObject(body, CheckResult.class);
			if(result == null) {
				return new CheckResult(CodeStatus.DATA_ERROR, "agent返回body格式错误");
			}
			if(result.getCode() == CheckResult.CONFIRM_MEMBER || result.getCode() == CheckResult.MERGE_MEMBER
					|| result.getCode() == CheckResult.NEW_MEMBER) {
				result.getContent().setSourceSessionID(session.getSession());
			}
			return result;
		}
		return new CheckResult(response.getStatus(), response.getError());
	}

	@Override
	public AppServer checkAccount(String account) throws Exception {
		logger.info("校验账号是否存在,输入参数：" + account );
		if(StringUtil.isEmpty(account)) {
			throw new Exception("参数为空");
		}
		JSONObject obj = new JSONObject();
		obj.put("account", account);
		Response response = super.getAgentResult(obj.toJSONString(), UCMethodEnum.CheckAccount);
		if(response == null) {
			throw new Exception("服务器连接超时");
		}
		if(response.getStatus() == AgentStatus.SC_OK) {
			String body = response.getBody();
			logger.info("UC返回数据：" + body);
			if(StringUtil.isEmpty(body)) {
				throw new Exception("服务器无结果返回");
			}
			CheckAccountResult base = JSONObject.parseObject(body, CheckAccountResult.class);
			if(base.getCode() == 101) {
				return null;
			} else if(base.getCode() == 0) {
				return base.getContent();
			} else {
				throw new Exception(base.getMessage());
			}
		}
		throw new Exception(response.getError());
	}

	@Override
	public boolean changeTelByPwd(String tel, String account, String pwd) throws BusinessException{
		MemAccount memAccount = memAccountService.selectByAccount(account);
		if(memAccount == null) {
			throw new BusinessException("账号不存在");
		}
		MemSession session = memAccount.getMemberSession();
		if(session == null) {
			throw new BusinessException("您尚未登录，无法操作");
		}
		if(!pwd.equals(session.getPassword())) {
			throw new BusinessException("密码输入错误");
		}
		Member member = memAccount.getMember();
		if(member == null || UseTag.F.name().equals(member.getUsetag())) {
			throw new BusinessException("会员已注销");
		}
		MemberInfo info = new MemberInfo();
		info.setMemberID(member.getMemberGUID());
		info.setMobile(tel);
		info.setPwd(pwd);
		Response response = super.getAgentResult(JSONObject.toJSONString(info), UCMethodEnum.ChangeTel);
		if(response.getStatus() != HttpStatus.SC_OK) {
			throw new BusinessException(response.getError());
		}
		
		UCRetBase result = JSONObject.parseObject(response.getBody(), UCRetBase.class);
		logger.info("手机号修改、认证返回状态码：" + result.getCode() + ",信息：" + result.getMessage());
		if(result.getCode() == 0) {
			MemAccount oldAccount = memAccountService.selectByAccount(tel);
			if(oldAccount != null) {
				Member oldMember = oldAccount.getMember();
				memAccountService.deleteByMemberAndAccount(oldAccount.getMemberid(), AccountTypeEnum.TEL, tel);
				oldMember.setVerifyType(new Byte("0"));
				memberService.update(oldMember);
			}
			member.setVerifyType(new Byte("1"));
			member.setTel(tel);
			if(member.getIsInfoPerfect() == null || member.getIsInfoPerfect().byteValue() == 0) {
				if(StringUtil.isNotEmpty(member.getIdcard()) && StringUtil.isNotEmpty(member.getMemname())) {
					member.setIsInfoPerfect(new Byte("1"));
				}
			}
			
			memberService.update(member);
			oldAccount = new MemAccount(tel, AccountTypeEnum.TEL);
			oldAccount.setMemberid(member.getMemberid());
			if(memAccountService.updateByMemberAndType(oldAccount) == 0) {
				memAccountService.insert(oldAccount);
			}
			memberLabelItemService.initializeItemLabel(member.getMemberid(), true);
			return true;
		}
		return false;
	}

	@Override
	public boolean verifyTel(String tel, String account) {
		MemAccount memAccount = memAccountService.selectByAccount(account);
		if(memAccount == null) {
			throw new BusinessException("账号不存在");
		}
		MemSession session = memAccount.getMemberSession();
		if(session == null) {
			throw new BusinessException("您尚未登录，无法操作");
		}
		Member member = memAccount.getMember();
		if(member == null || UseTag.F.name().equals(member.getUsetag())) {
			throw new BusinessException("会员已注销");
		}
		
		return changeTelByPwd(tel, account, session.getPassword());
	}

	@Override
	public int deleteSourceMemberAfterMerge(String memberGUID) {
		Member member = memberService.selectByUUID(memberGUID, null);
		if(member == null) {
			return 0;
		}
		
		int count = memberService.updateUseTagByUUID(memberGUID, UseTag.F);
		memAccountService.deleteByMember(member.getMemberid());
		return count;
	}
	
	
}
