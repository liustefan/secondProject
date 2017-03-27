/**
 * @PackageName:      com.bithealth.memberCore.facede.service.impl
 * @FileName:     MemberInterfServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月4日 下午3:41:01  
 * 
 */
package com.bithealth.memberCore.facede.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.agentCore.AgentStatus;
import com.bithealth.agentCore.enums.UCMethodEnum;
import com.bithealth.memberCore.constants.CodeStatus;
import com.bithealth.memberCore.constants.Constrants;
import com.bithealth.memberCore.enmu.AccountTypeEnum;
import com.bithealth.memberCore.enmu.DeviceEnum;
import com.bithealth.memberCore.enmu.MemberSource;
import com.bithealth.memberCore.enmu.MovementStatusEnmu;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.exception.LoginException;
import com.bithealth.memberCore.facede.service.MemberImportService;
import com.bithealth.memberCore.facede.service.MemberInterfService;
import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.member.model.MemAccount;
import com.bithealth.memberCore.member.model.MemImportLog;
import com.bithealth.memberCore.member.model.MemSession;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.model.MemberMovment;
import com.bithealth.memberCore.member.model.MemberRegReponse;
import com.bithealth.memberCore.member.service.MemberMovmentService;
import com.bithealth.memberCore.uc.bean.AgentResponse;
import com.bithealth.memberCore.uc.bean.MemberField;
import com.bithealth.memberCore.uc.bean.MemberInfo;
import com.bithealth.memberCore.uc.bean.MemberResponse;
import com.bithealth.memberCore.uc.bean.MemberRet;
import com.bithealth.memberCore.uc.bean.MergeResult;
import com.bithealth.memberCore.uc.bean.ModifyPwd;
import com.bithealth.memberCore.uc.service.UnifiedAuthServiceImpl;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.common.utils.CheckIdCard;
import com.bithealth.sdk.common.utils.PinYinUtil;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.exception.BusinessException;

/**
 * 类名称: MemberInterfServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月4日 下午3:41:01 
 * 
 * @author liuhm
 * @version  
 */
@Service("memberInterfService")
public class MemberInterfServiceImpl extends UnifiedAuthServiceImpl implements MemberInterfService {
	
	private final static Logger logger = Logger.getLogger(MemberInterfServiceImpl.class);
	
	@Autowired
	private MemberImportService memberImportService;
	
	@Autowired
	private MemberMovmentService movmentService;
	
	@Override
	public MemAccount login(String account, String password, DeviceEnum device) throws LoginException {
		if(StringUtil.isEmpty(password) || StringUtil.isEmpty(account)) {
			throw new LoginException(LoginException.ERROR_EMPTY);
		}
		MemAccount memAccount = memAccountService.selectByAccount(account);
		if(memAccount == null) {
			throw new LoginException(LoginException.ERROR_NAME);
		}
		
		MemSession session = memAccount.getMemberSession();
		if(!password.equals(session.getPassword())) {
			throw new LoginException(LoginException.ERROR_PWD);
		}
		
		Member member = memAccount.getMember();
		
		if(member == null || UseTag.F.name().equals(member.getUsetag())) {  //已注销
			throw new LoginException(LoginException.USER_LOGOUT);
		}
		
//		if(!UseTag.T.name().equals(member.getStatus())) {  //被禁用
//			throw new LoginException(LoginException.ERROR_STATUS);
//		}
		
		device = device == null ? DeviceEnum.Other : device;
		session.setSession(UUID.randomUUID().toString());
		session.setDevice(device.name());
		session.setLogintime(new Date());
		try{
			memberSessionService.updateByPrimaryKey(session);
		} catch(Exception e) {
			logger.error("会员登录更新会员令牌出错：" + e.getLocalizedMessage());
		}
		logger.info(memAccount.getAccount() + "账号于" + new Date() + "在" + device.name() + "系统上登录");
		return memAccount;
	}

	@Override
	public void logout(MemAccount member) {
		member = memAccountService.selectByAccount(member.getAccount());
		if(member == null) {
			return;
		}
		
		MemSession session = member.getMemberSession();
		session.setSession(null);
		memAccountService.updateByPrimaryKey(member);
		logger.info(new Date() + member.getAccount() + "注销系统登录");
	}
	
	@Override
	public MemberRegReponse insertMember(List<MemberExt> memberList, boolean async) throws Exception {
		MemberRegReponse response = new MemberRegReponse();
		List<MemberExt> error = new ArrayList<MemberExt>();
		for(Iterator<MemberExt> it = memberList.iterator(); it.hasNext();) {
			MemberExt member = it.next();
			member.setMemberGUID(StringUtil.UUID());
			String msg = null;
			if(member.isFromApp()) {
				msg = isExistTel(member.getTel());
			} else {
				msg = super.isExist(member);
			}
			if(StringUtil.isNotEmpty(msg)) {
				if(async) {
					member.setImportLog(new MemImportLog());
					member.getImportLog().setReason(msg);
					error.add(member);
				} else {
					response.getErrorList().add(new MemberRet(member,msg, MemberRet.FAIL));
				}
				it.remove();
			}
		}
		if(error.size() > 0) {
			memberImportService.insertErrorData(error);  //异步保存错误数据
		}
		
		if(memberList.size() == 0) {
			return response;
		}
		
		int len = memberList.size() / Constrants.MAX_AUTH;  //分批向UC中心认证的分批数
		len = (memberList.size() % Constrants.MAX_AUTH) == 0 ? len : (len + 1);

		for(int i = 0; i < len; i++){
			int toIndex = Constrants.MAX_AUTH;
			if(toIndex >= memberList.size()){
				toIndex = memberList.size();
			}
			List<MemberExt> subList = memberList.subList(0, toIndex);
			try {
				insertByGroup(subList, response, async);
			} catch (Exception e) {
				throw new Exception(e);
			}
			memberList.removeAll(subList);
		}
		
		if(response.getErrorList().size() > 0) {
			for(MemberRet ret : response.getErrorList()) {
				if(async) {
					memberService.updateUseTagByUUID(ret.getMember().getMemberGUID(), UseTag.E);
					LogService.updateTagByUUID(ret.getMember().getMemberGUID(), UseTag.E, ret.getMessage());
				} else {
					memberService.deleteByUUID(ret.getMember().getMemberGUID());
					LogService.deleteByUUID(ret.getMember().getMemberGUID(), UseTag.R);  //删除日志表
				}
			}
		}
		return response;
	}
	
	@Override
	public MemberRet regist(MemberExt member) {
		List<MemberExt> list = new ArrayList<MemberExt>();
		list.add(member);
		try{
			MemberRegReponse response = this.insertMember(list, false);
			if(response.getErrorList().size() > 0) {
				return response.getErrorList().get(0);
			}
		}catch(Exception e) {
			MemberResponse res = new MemberResponse();
			res.setCode(MemberRet.FAIL);
			res.setGuid(member.getMemberGUID());
			this.afterInsert(member, res);
			return new MemberRet(member, e.getLocalizedMessage(), MemberRet.FAIL);
		}
		return new MemberRet(member);
	}

	@Override
	public MemberRet AppRegist(MemberExt member, String password) {
		member.setFromApp(true);
		MemSession session = member.getMemSession();
		if(session == null) {
			session = new MemSession();
			member.setMemSession(session);
		}
		member.setVerifyType(new Byte("1"));
		member.getMemSession().setPassword(password);
		return this.regist(member);
	}

	private void saveImportLog(Collection<MemberExt> list, String times, UseTag tag, boolean fromApp) {
		List<MemImportLog> logList = new ArrayList<MemImportLog>();
	    for(MemberExt member : list){
	    	MemImportLog log = newLog(member.getMemberGUID(), tag);
	    	log.setImportBatchGUID(times);
	    	member.setImportLog(log);
	    	log.setContent(super.getInfo(member));
	    	if(fromApp) {
	    		log.setSourceType(new Byte("2"));
	    	}
	    	logList.add(log);
		}
	    LogService.insertLogs(logList);
	}
	
	private MemImportLog newLog(String uuid, UseTag tag) {
		MemImportLog log = new MemImportLog();
    	log.setImportTime(new Date());
    	log.setMemberGUID(uuid);
    	log.setUpdateTime(new Date());
    	log.setUseTag(tag.name());
    	log.setSyncTimestamp(new Date().getTime());
    	return log;
	}
	
	private void insertByGroup(List<MemberExt> list, MemberRegReponse response, boolean async) throws Exception {
		Map<String, MemberExt> data = new HashMap<>();
		List<String> params = new ArrayList<String>();
		boolean isApp = false;
		for(Iterator<MemberExt> it = list.iterator(); it.hasNext();) {
			MemberExt member = it.next();
			if(!isApp) {
				isApp = member.isFromApp();
			}
			member.setUsetag(UseTag.R.name());
			if(!super.saveOrUpdateMember(member)) {
				response.getErrorList().add(new MemberRet(member, "保存业务库失败", MemberRet.FAIL));
				it.remove();
			} else {
				params.add(super.getInfo(member));
			}
			data.put(member.getMemberGUID(), member);
		}
		String batchTimes = StringUtil.UUID();
		saveImportLog(data.values(), batchTimes, UseTag.R, isApp);  //先入日志库
		if(list.isEmpty()) {
			return;
		}
		List<MemberResponse> returnList = null;
		AgentResponse result = null;
		if(isApp) {
			result = super.regist(params);
		} else {
			result = super.regist(params, async);
		}
		if(result.getCode() == CodeStatus.OK) {
			returnList = result.getContent();
		} else {
			setMsg(list, result.getMessage(), response);
		}
		if(returnList == null || returnList.isEmpty()) {
			return;
		}
		if(!async) {  //同步
			for(MemberResponse ret : returnList) {
				super.afterInsert(data.get(ret.getGuid()), ret);
				if(MemberRet.SUCCESS != ret.getCode()) {
					response.getErrorList().add(new MemberRet(data.get(ret.getGuid()), ret.getMsg(), MemberRet.FAIL));
				}
			}
		} 
	}
	
	@Override
	public MemberRegReponse syncMember(List<MemberExt> memberList, MemberSource source) {
		MemberRegReponse response = new MemberRegReponse();
		Iterator<MemberExt> it = memberList.iterator();
		List<MemberExt> updateList = new ArrayList<MemberExt>();
		List<MemberExt> addList = new ArrayList<MemberExt>();
		while(it.hasNext()) {
			MemberExt member = it.next();
			if(StringUtil.isEmpty(member.getIdcard())) {
				response.getErrorList().add(new MemberRet(member, "身份证为空", MemberRet.FAIL));
				it.remove();
				continue;
			}
			Member mem = memberService.selectByIdcard(member.getIdcard());
			if(mem != null) {
				if(source.getCode() == mem.getSource().intValue()) {
					member.setMemberid(mem.getMemberid());
					member.setMemberGUID(mem.getMemberGUID());
					updateList.add(member);
				} else {
					response.getExistsList().add(new MemberRet(member, "会员已在其他平台注册，来源：" + MemberSource.getSource(member.getSource()).getDesc(), MemberRet.FAIL));
				}
			} else {
				member.setMemberGUID(StringUtil.UUID());
				addList.add(member);
			}
		}
		
		if(addList.size() > 0) {
			try{
				MemberRegReponse addResponse = insertMember(addList, false);  //同步请求
				response.getErrorList().addAll(addResponse.getErrorList());
				response.getExistsList().addAll(addResponse.getExistsList());
				response.getSuccessList().addAll(addResponse.getSuccessList());
			} catch(Exception e) {
				logger.error(e);
			}
			
			
		}
		
		if(updateList.size() > 0) {
			for(MemberExt member : updateList) {
				if(super.saveOrUpdateMember(member)) {
					response.getSuccessList().add(new MemberRet(member, null, MemberRet.SUCCESS));
				} else {
					response.getErrorList().add(new MemberRet(member, "更新失败", MemberRet.FAIL));
				}
			}
		}
		return response;
	}

	@Override
	public String updateMember(MemberExt member) throws BusinessException {
		String msg = super.isExist(member);
		if(StringUtil.isNotEmpty(msg)) {
			return msg;
		}
		if(!this.isEdit(member)) {  //无需调用UC
			super.saveOrUpdateMember(member);
			return null;
		}
		
		//修改调用UC
		return modifyByUC(member, null);
	}
	
	@Override
	public MergeResult merge(String sourceGuid, int sourSrvId, String sourceSessionID, String pwd, Member targetMember) {
		MemberExt member = memberService.selectMemberExtByUUID(targetMember.getMemberGUID());
		if(member == null) {
			return new MergeResult(101, "会员不存在");
		}
		member.setFromApp(true);
		member.setVerifyType(new Byte("1"));
		member.setIsInfoPerfect(new Byte("1"));
		member.setTel(targetMember.getTel());
		member.setIdcard(targetMember.getIdcard());
		member.setMemname(targetMember.getMemname());
		member.setMemNameCode(PinYinUtil.getPinYinHeadChar(targetMember.getMemname()));
		CheckIdCard checkIdcard = CheckIdCard.getInstance(targetMember.getIdcard());
		if(checkIdcard.validate()) {
			member.setBirthdate(checkIdcard.getBirthDate());
			member.setGender(checkIdcard.isFemal() ? "2" : "1");
		}
		JSONObject json = new JSONObject();
		json.put("sourceGuid", sourceGuid);
		json.put("sourceSrvId", sourSrvId);
		json.put("sessionId", sourceSessionID);
		MemberInfo info  = MemberField.getInfo(member);
		info.setPwd(pwd);
		json.put("memberTarget", info);
		String result = this.modifyByUC(member, json.toJSONString());
		if(StringUtil.isNotEmpty(result)) {
			return new MergeResult(1, result);
		}
		MemAccount account = null;
		if(sourSrvId == Integer.parseInt(Constrants.SERVERID)) {
			account = memAccountService.selectByAccount(targetMember.getTel());
			if(account == null) {
				account = new MemAccount(targetMember.getTel(), AccountTypeEnum.TEL);
				account.setMemberid(member.getMemberid());
				memAccountService.insert(account);
			} else {
				account.setMemberid(member.getMemberid());
				memAccountService.update(account);
			}
		} else {
			account = new MemAccount(targetMember.getTel(), AccountTypeEnum.TEL);
			account.setMemberid(member.getMemberid());
			if(memAccountService.updateByMemberAndType(account) == 0) {
				memAccountService.insert(account);
			}
		}
		MergeResult merge = new MergeResult(0, "成功");
		merge.setPassword(pwd);
		merge.setSessionId(sourceSessionID);
		merge.setGuid(member.getMemberid() + "");  //暂存memberID
		return merge;
	}
	
	private MemberResponse getResponse(Object obj, MemberExt member) throws Exception {
		if(member.isFromApp()) {
			Response response = super.getAgentResult(obj, UCMethodEnum.Merge);
			if(response.getStatus() == AgentStatus.SC_OK) {
				return JSONObject.parseObject(response.getBody(), MergeResult.class);
			} else {
				throw new BusinessException(response.getError());
			}
		} else {
			List<String> list = new ArrayList<String>();
			list.add(super.getInfo(member));
			AgentResponse result = super.regist(list, false);
			if(result.getCode() != CodeStatus.OK) {
				throw new BusinessException(result.getMessage());
			}
			return result.getContent().get(0);
		}
	}
	
	private String modifyByUC(MemberExt member, String appParameter) {
		try {
			memberService.updateUseTagByUUID(member.getMemberGUID(), UseTag.M);
			MemImportLog log = newLog(member.getMemberGUID(), UseTag.M);
			log.setContent(JSONObject.toJSONString(member));
			if(member.isFromApp()) {
				log.setSourceType(new Integer(0).byteValue());
			}
			LogService.insert(log);
			member.setImportLog(log);
			MemberResponse response = getResponse(appParameter, member);
			super.afterUpdate(response);
			if(response.getCode() != MemberRet.SUCCESS) {
				memberService.updateUseTagByUUID(member.getMemberGUID(), UseTag.T);
				LogService.deleteByUUID(member.getMemberGUID(), UseTag.M);
				return response.getMsg();
			}
			if(member.isFromApp()) {
				MergeResult result = (MergeResult)response;
				MemSession session = member.getMemSession();
				if(session == null) {
					session = new MemSession();
					session.setMemberid(member.getMemberid());
				}
				session.setSession(result.getSessionId());
				session.setPassword(result.getPassword());
				session.setCurtag("Y");
				session.setLogintime(new Date());
				if(memberSessionService.update(session) == 0) {
					memberSessionService.insert(session);
				}
			}
		} catch (Exception e) {
			memberService.updateUseTagByUUID(member.getMemberGUID(), UseTag.T);
			LogService.deleteByUUID(member.getMemberGUID(), UseTag.M);
			return e.getLocalizedMessage();
		}
		
		return null;
	}
	
	private boolean isEdit(Member member) {
		Member old = memberService.selectById(member.getMemberid());
		return MemberField.isEdit(old, member);
	}

	@Override
	public boolean delete(List<Member> memberList) throws Exception {
		if(memberList == null || memberList.size() == 0) {
			return false;
		}
		List<String> params = new ArrayList<String>();
		Map<String, Member> data = new HashMap<String, Member>();
		for(Member member : memberList) {
			member = memberService.selectById(member.getMemberid());
			member.setUsetag(UseTag.D.name());
			memberService.update(member);
			LogService.insert(newLog(member.getMemberGUID(), UseTag.D));
			data.put(member.getMemberGUID(), member);
			params.add(JSONObject.toJSONString(member.getMemberGUID()));
		}
		
		AgentResponse res = super.delMember(params);
		if(res.getCode() == CodeStatus.OK) {
			for(MemberResponse member : res.getContent()) {
				super.afterDelete(data.get(member.getGuid()), member);
			}
		} 
		return true;
	}
	
	@Override
	public boolean updatePasswordByTel(String tel, String pwd) {
		MemAccount account = memAccountService.selectByAccount(tel);
		if(account == null) {
			throw new BusinessException("手机号不存在");
		}
		MemSession session = account.getMemberSession();
		if(session == null) {
			throw new BusinessException("会员不存在");
		}
		return updatePwdById(pwd, session);
	}

	@Override
	public boolean updatePassword(Integer memberId, String newPwd, String oldPwd) throws BusinessException {
		if(StringUtil.isEmpty(newPwd)) {
			throw new BusinessException("新密码不能为空");
		}
		if(StringUtil.isEmpty(oldPwd)) {
			throw new BusinessException("旧密码不能为空");
		}
		if(newPwd.equals(oldPwd)) {
			return true;
		}
		MemSession session = memberSessionService.selectById(memberId);
		if(session == null) {
			throw new BusinessException("会员不存在");
		}
		
		if(!session.getPassword().equals(oldPwd)) {
			throw new BusinessException("旧密码验证失败");
		}
		return updatePwdById(newPwd, session);
	}
	
	private boolean updatePwdById(String newPwd, MemSession session) {
		String guid = memberService.selectById(session.getMemberid()).getMemberGUID();
		JSONObject obj = new JSONObject();
		obj.put("guid", guid);
		obj.put("pwd", newPwd);
		List<JSONObject> list = new ArrayList<JSONObject>();
		list.add(obj);
		Response response = super.getAgentResult(JSONArray.toJSONString(list), UCMethodEnum.ModifyPwd);
		if(response.getStatus() != AgentStatus.SC_OK) {
			throw new BusinessException(response.getError());
		}
		ModifyPwd result = JSONObject.parseObject(response.getBody(), ModifyPwd.class);
		if(result == null) {
			throw new BusinessException("服务异常");
		}
		if(result.getCode() != CodeStatus.OK) {
			return false;
		}
		obj = result.getContent().get(0);
		if(obj.getIntValue("code") == 1) {
			session.setPassword(newPwd);
			return memberSessionService.update(session) > 0;
		}
		return false;
	}
	
	@Override
	public String updateMoveConfirm(MemberMovment movement, boolean hasConfirmByDoc) {
		if(hasConfirmByDoc) {
			movement = movmentService.selectById(movement.getMMovementID());
			movement.setConfirmTime(new java.sql.Timestamp(System.currentTimeMillis()));
			movement.setMoveStatus(new Integer(MovementStatusEnmu.agree.getStatus()).byteValue());
			movmentService.update(movement);
		} else {
			movement.setConfirmTime(new java.sql.Timestamp(System.currentTimeMillis()));
			movement.setMoveStatus(new Integer(MovementStatusEnmu.agree.getStatus()).byteValue());
			movmentService.insert(movement);
		}
		List<MemberGroup> groupList = new ArrayList<>();
		for(String id : movement.getInMemGrpidList().split(",")) {
			MemberGroup group = new MemberGroup();
			group.setMemgrpid(Integer.parseInt(id));
			groupList.add(group);
		}
		Member member = memberService.selectById(movement.getMemberID());
		member.setOrgid(movement.getInOrgID());
		memberService.update(member);
//		member.setMemberid(movement.getMemberID());
		MemToGroupService.insertBatchByMember(groupList, member, null); 
		
		return null;
	}

	@Override
	public String perfectMember(String account, String memberName, String idcard) {
		MemAccount memberAccount  = memAccountService.selectByAccount(account);
		if(memberAccount == null) {
			return "当前账号不存在";
		}
		MemSession session = memberAccount.getMemberSession();
		Member member = memberAccount.getMember();
		member.setIdcard(idcard);
		member.setMemname(memberName);
		MergeResult result = this.merge(member.getMemberGUID(), Integer.parseInt(Constrants.SERVERID), session == null ? "" : session.getSession(), session.getPassword(), member);
		if(result.getCode() == 0) {
			return null;
		}
		return result.getMsg();
	}

	@Override
	public boolean isFromWeb(String memberGUID) {
		Member member = memberService.selectByUUID(memberGUID, null);
		return memberLabelItemService.isAppRegist(member.getMemberid(), Constrants.WEB_USER);
	}

	private void setMsg(Collection<MemberExt> list, String msg, MemberRegReponse response) {
		for(MemberExt ext : list) {
			response.getErrorList().add(new MemberRet(ext, msg, MemberRet.FAIL));
		}
	}
	
}
