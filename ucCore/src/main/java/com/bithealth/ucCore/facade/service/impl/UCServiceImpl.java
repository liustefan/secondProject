package com.bithealth.ucCore.facade.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bithealth.sdk.common.utils.PinYinUtil;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.ucCore.facade.enmu.AccountTypeEnum;
import com.bithealth.ucCore.facade.enmu.UniqueEnmu;
import com.bithealth.ucCore.facade.enmu.VerifyType;
import com.bithealth.ucCore.facade.service.UCService;
import com.bithealth.ucCore.uc.model.AccountResult;
import com.bithealth.ucCore.uc.model.AppServer;
import com.bithealth.ucCore.uc.model.AppServerExample;
import com.bithealth.ucCore.uc.model.MemberAccount;
import com.bithealth.ucCore.uc.model.MemberAccountExample;
import com.bithealth.ucCore.uc.model.MemberBasicInfo;
import com.bithealth.ucCore.uc.model.MemberBasicInfoExample;
import com.bithealth.ucCore.uc.model.RegisterResult;
import com.bithealth.ucCore.uc.model.ReturnObject;
import com.bithealth.ucCore.uc.result.MemberBase;
import com.bithealth.ucCore.uc.service.AppServerService;
import com.bithealth.ucCore.uc.service.MemberAccountService;
import com.bithealth.ucCore.uc.service.MemberBasicInfoService;



@Service("ucService") 
public class UCServiceImpl implements UCService{
	private static Logger logger=Logger.getLogger(UCServiceImpl.class);

	@Resource(name="appServerService")
	AppServerService appServerService;
	@Resource
	MemberAccountService memberAccountService;
	@Resource
	MemberBasicInfoService memberBasicInfoService;
	
	@Autowired 
	private TaskExecutor taskExecutor;

	@Override
	public List<RegisterResult> memberRegisterSync(List<MemberBasicInfo> memberInfoList,int serverId) throws Exception {
		List<RegisterResult> registerList = new ArrayList<RegisterResult>();	
		for(MemberBasicInfo memberBasicInfo:memberInfoList){
			memberBasicInfo.setMemNameCode(PinYinUtil.getPinYinHeadChar(memberBasicInfo.getMemberName()));
			memberBasicInfo.setServerID(serverId);
			RegisterResult registerResult = new RegisterResult();
			registerResult.setGuid(memberBasicInfo.getMemberID());
			try{
				if(!verifyNecessaryParam(memberBasicInfo)){//必要参数为空
					registerResult.setCode(2);
					registerResult.setMsg("身份证号为空并且手机号和姓名其中一个为空，注册失败。");
					logger.error("身份证号为空并且手机号和姓名其中一个为空，注册失败。");
				}else{
					//根据guid判断是新增还是修改
					MemberBasicInfoExample arg0 = new MemberBasicInfoExample();
					arg0.createCriteria().andMemberIDEqualTo(memberBasicInfo.getMemberID());
					List<MemberBasicInfo> infoList = memberBasicInfoService.selectByExample(arg0);
					if(infoList != null && infoList.size() == 0){ //新增操作
						MemberBasicInfo result = verifyMemberBasicInfo(memberBasicInfo);//验证会员唯一性
						if(result == null){ //可注册会员
							memberBasicInfo.setCreateTime(new Date());
							int rows = memberBasicInfoService.insert(memberBasicInfo);
							if(rows == 1){ //基本资料注册成功，才进行账号的注册
								List <AccountResult> accountlist = accountRegister(memberBasicInfo);
								registerResult.setAccountlist(accountlist);
							}
							registerResult.setCode(1);
							registerResult.setMsg("会员注册成功");
							logger.info("会员注册成功。");
						}else{
							registerResult.setCode(2);
							AppServer appServer  = appServerService.selectById(result.getServerID());
							String msg ="会员已存在，与 "+ (appServer==null ? "未知平台 " : appServer.getServerName()) +"重复";
							registerResult.setMsg(msg);
							logger.error("会员已存在");
						}
					}else{//更新操作
						if(memberBasicInfo.getServerID().intValue() == infoList.get(0).getServerID().intValue()) {
							MemberBasicInfo result = null;
							if(infoList.get(0).getIsInfoPerfect() == null || infoList.get(0).getIsInfoPerfect().byteValue() == 0 ) {  //已经完善的会员不做唯一性校验
								result = verifyMemberBasicInfo(memberBasicInfo);//验证会员唯一性
							}
							if(result == null || (result != null && result.getMemberID().equals(memberBasicInfo.getMemberID()))){
								result = infoList.get(0);
								result.setMemberName(memberBasicInfo.getMemberName());
								result.setMemNameCode(PinYinUtil.getPinYinHeadChar(memberBasicInfo.getMemberName()));
								result.setMemberSex(memberBasicInfo.getMemberSex());
								result.setBirthday(memberBasicInfo.getBirthday());
								result.setMobile(memberBasicInfo.getMobile());
								result.setIDCard(memberBasicInfo.getIDCard());
								result.setHeadAddress(memberBasicInfo.getHeadAddress());
								result.setUpdateTime(new Date());
								
								MemberBasicInfoExample example  = new MemberBasicInfoExample ();
								example.createCriteria().andMemberIDEqualTo(memberBasicInfo.getMemberID()).andServerIDEqualTo(memberBasicInfo.getServerID());
								
								memberBasicInfoService.updateByExample(result, example);
								registerResult.setCode(1);
								registerResult.setMsg("会员注册或者更新成功");
								//身份证账号更新或注册或删除
								idcardAccountReset(memberBasicInfo, infoList.get(0)); 
								registerResult.setAccountlist(getAccountResult(memberBasicInfo.getMemberID()));
								logger.info("会员或者更新注册成功。");
							}else{
								registerResult.setCode(2);
								AppServer appServer = appServerService.selectById(result.getServerID());
								String msg ="会员已存在，与 " + (appServer==null ? "未知平台 " : appServer.getServerName()) + "重复";
								registerResult.setMsg(msg);
								logger.error("会员已存在");
							}
						} else {
							registerResult.setCode(2);
							AppServer appServer = appServerService.selectById(memberBasicInfo.getServerID());
							String msg ="修改的会员不存在 "+ (appServer == null ? "" : appServer.getServerName());
							registerResult.setMsg(msg);
							logger.error("修改的会员不存在");
						}
					}
				}
			}catch(Exception e){
				registerResult.setCode(2);
				registerResult.setMsg("基本资料注册异常");
				logger.error(memberBasicInfo.getMemberID()+" 基本资料注册异常： "+e.getMessage());
			}
			registerList.add(registerResult);
		}
		return registerList;
	}
	
	@Override
	public void memberRegisterAsyn(final List<MemberBasicInfo> memberInfoList,final int serverId) throws Exception {
		taskExecutor.execute(new Runnable(){
			public void run() {
				try {
					memberRegisterSync(memberInfoList,serverId);
					logger.error("异步注册会员线程完成。");
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("异步注册会员线程异常，"+e.getMessage());
				}
				
			}
		});
	}
	

	
	/**
	 * @Title:accountRegister 
	 * @Description:注册用的账号
	 * @author 谢美团
	 * @param memberBasicInfo
	 * @return 
	 * @throws
	 * @retrun List<AccountResult>
	 */ 
	private List <AccountResult> accountRegister(MemberBasicInfo memberBasicInfo){
		List <AccountResult> accountlist =  new ArrayList<AccountResult>();
		if(memberBasicInfo.getAccountList() == null ){
			return accountlist;
		}
		
		//删除该会员名下的旧的账号
		MemberAccountExample arg0 = new MemberAccountExample();
		arg0.createCriteria().andMemberIDEqualTo(memberBasicInfo.getMemberID());
		memberAccountService.deleteByExample(arg0);
		
		for(MemberAccount account:memberBasicInfo.getAccountList()){
			try{
				account.setMemberID(memberBasicInfo.getMemberID());
				account.setServerId(memberBasicInfo.getServerID());
				
				int result = verifyMemberAccount(account);
				if(result == 1){// 验证账号唯一性
					AccountResult accountResult = new AccountResult();
					account.setCreateTime(new Date());
					memberAccountService.insert(account);
					accountResult.setAccount(account.getAccount());
					accountResult.setAccountType((int)account.getAccountType());
					accountlist.add(accountResult);
					logger.info(account.getAccount()+" 账号注册成功");
				}else{
					logger.error(account.getAccount()+" 账号已被注册");
				}
			}catch(Exception e){
				logger.error(account.getAccount()+" 账号注册异常");
			}
		}
		return accountlist;
	}
	
	private void idcardAccountReset(MemberBasicInfo newAccount, MemberBasicInfo oldAccount) {
		if(StringUtil.isEmpty(newAccount.getIDCard())) {
			if(StringUtil.isNotEmpty(oldAccount.getIDCard())) {
				memberAccountService.deleteAccount(oldAccount.getMemberID(), AccountTypeEnum.IDCARD, oldAccount.getServerID());
			}
		} else {
			if(!newAccount.getIDCard().equalsIgnoreCase(oldAccount.getIDCard())) {
				MemberAccount account = new MemberAccount();
				account.setServerId(newAccount.getServerID());
				account.setAccountType(AccountTypeEnum.IDCARD.getType());
				account.setMemberID(newAccount.getMemberID());
				account.setAccount(newAccount.getIDCard());
				if(memberAccountService.updateAccount(account) == 0) {
					account.setCreateTime(new java.util.Date());
					memberAccountService.insert(account);
				}
			}
		}
	}
	
	private List<AccountResult> getAccountResult(String guid) {
		MemberAccountExample accountExample  = new MemberAccountExample ();
		accountExample.createCriteria().andMemberIDEqualTo(guid);
		List<MemberAccount> accountList = memberAccountService.selectByExample(accountExample);
		List<AccountResult>  accountResultList = new ArrayList<AccountResult>();
		for(MemberAccount account:accountList){
			AccountResult accountResult = new AccountResult();
			accountResult.setAccount(account.getAccount());
			accountResult.setAccountType((int)account.getAccountType());
			accountResult.setCode(1);
			accountResultList.add(accountResult);
		}
		
		return accountResultList;
	}
	
	@Override
	public List<RegisterResult> getRegisterResult(List<String> guidList) throws Exception {
		List<RegisterResult> registerResultList = new ArrayList<RegisterResult>();
		for(String guid:guidList){
			RegisterResult registerResult = new RegisterResult();
			registerResult.setGuid(guid);
			MemberBasicInfoExample memberExample = new MemberBasicInfoExample();
			memberExample.createCriteria().andMemberIDEqualTo(guid);
			List<MemberBasicInfo> memberList =memberBasicInfoService.selectByExample(memberExample);
			if(memberList != null && memberList.size() > 0){
				registerResult.setCode(1);
				registerResult.setMsg("基本资料注册成功");
				registerResult.setAccountlist(getAccountResult(guid));
			}else{
				registerResult.setCode(2);
				registerResult.setMsg("基本资料已经被注册或者注册异常");
			}
			registerResultList.add(registerResult);
		}
		return registerResultList;
	}

	@Override
	public ReturnObject getAddressByAccount(String account, boolean isHttps) throws Exception {
		ReturnObject result = new ReturnObject();
		if(account == null || "".equals(account)){
			result.setCode(301);
			result.setMessage("账号参数为空。");
		}else{
			//获取账号信息
			MemberAccount memberAccount = getAccount(account);
			if(memberAccount == null){ //账号不存在
				result.setCode(101);
				result.setMessage("账号不存在。");
			}else{
				AppServer appServer = appServerService.selectById(memberAccount.getServerId());
				result.setCode(0);
				if(isHttps) {
					result.setContent(appServer.getHttpsAddress());
				} else {
					result.setContent(appServer.getIpAddress());
				}
			}
		}
		return result;
	}

	@Override
	public ReturnObject getAddressByMemberIDs(List<String> memberIDList) throws Exception {
		ReturnObject result = new ReturnObject();
		List<MemberBasicInfo> lsit = new ArrayList<MemberBasicInfo>();
		for(String memberId:memberIDList){
			MemberBasicInfo info = new MemberBasicInfo();
			//获取会员基本资料
			MemberBasicInfoExample infoExample = new MemberBasicInfoExample();
			infoExample.createCriteria().andMemberIDEqualTo(memberId);
			List<MemberBasicInfo> infoList = memberBasicInfoService.selectByExample(infoExample);
			if(infoList != null && infoList.size() !=0){ 
				info = infoList.get(0);
				AppServer appServer = appServerService.selectById(info.getServerID());
				info.setUrl(appServer.getIpAddress());
			}
			info.setMemberGUID(info.getMemberID());
			info.setMemberID("");
			lsit.add(info);
		}
		result.setContent(lsit);
		return result;
	}

	@Override
	public MemberBasicInfo verifyMemberBasicInfo(MemberBasicInfo memberBasicInfo)throws Exception {
		List<MemberBasicInfo> infoList = new ArrayList<MemberBasicInfo>();
		if(memberBasicInfo.getIDCard() != null && !"".equals(memberBasicInfo.getIDCard())){//身份证号不为空 ，需要验证身份证号唯一性和 验证姓名加手机号的 唯一性
			infoList = memberBasicInfoService.selectByIdCareOrMemberNameAndTel(memberBasicInfo);
		}
		if(infoList != null && infoList.size() > 0){
			return infoList.get(0);
		}
		if(StringUtil.isNotEmpty(memberBasicInfo.getMemberName()) && StringUtil.isNotEmpty(memberBasicInfo.getMobile())){ //身份证号为空，通过会员姓名和电话号判断会员唯一性
			MemberBasicInfoExample example  = new MemberBasicInfoExample ();
			example.createCriteria().andMemberNameEqualTo(memberBasicInfo.getMemberName()).andMobileEqualTo(memberBasicInfo.getMobile());
			infoList = memberBasicInfoService.selectByExample(example);
		}
		if(infoList != null && infoList.size() > 0){
			return infoList.get(0);
		}
		return null;
	}

	@Override
	public int verifyMemberAccount(MemberAccount account) throws Exception {
		MemberAccountExample example  = new MemberAccountExample ();
		example.createCriteria().andAccountEqualTo(account.getAccount());
		List<MemberAccount> list = memberAccountService.selectByExample(example);
		if(list!= null && list.size() == 0){
			return UniqueEnmu.RESULT1.getValue();
		}else{
			return UniqueEnmu.RESULT3.getValue();
		}
	}
	
	/**
	 * @Title:verifyNecessaryParam 
	 * @Description:验证必要参数是否为空 
	 * @author 谢美团
	 * @param memberBasicInfo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	private boolean verifyNecessaryParam(MemberBasicInfo memberBasicInfo){
		if(memberBasicInfo.getIDCard() == null && (memberBasicInfo.getMemberName() == null || memberBasicInfo.getMobile() == null) ){
			return false;
		}else if(memberBasicInfo.getServerID() == null || memberBasicInfo.getServerID() == 0){
			return false;
		}
		if(memberBasicInfo.getMemberID() ==null || "".equals(memberBasicInfo.getMemberID())){
			return false;
		}
		return true;
	}

	@Override
	public List<RegisterResult> memberDelete(List<String> memberIdList,int serverId) throws Exception {
		
		List<RegisterResult> list = new ArrayList<RegisterResult>();
		for(String memberId:memberIdList){
			RegisterResult result = new RegisterResult();
			result.setGuid(memberId);
			try{
				MemberBasicInfoExample example = new MemberBasicInfoExample();
				example.createCriteria().andMemberIDEqualTo(memberId).andServerIDEqualTo(serverId);
				memberBasicInfoService.deleteByExample(example);
				MemberAccountExample accountExample  = new MemberAccountExample();
				accountExample.createCriteria().andMemberIDEqualTo(memberId);
				memberAccountService.deleteByExample(accountExample);
				result.setCode(1);
				result.setMsg("删除成功");
			}catch(Exception e){
				result.setCode(2);
				result.setMsg("删除发生异常。");
			}
			list.add(result);
		}
		return list;
	}

	@Override
	public ReturnObject getMemberBySearchParam(String searchParam)throws Exception {
		ReturnObject result = new ReturnObject();
		if(searchParam != null){
			List<MemberBasicInfo> list = memberBasicInfoService.selectMemberBySearchParam(searchParam);
			if(list == null){
				result.setContent(new ArrayList());
				return result;
			}
			List<Integer> idList = new ArrayList<Integer>();
			for(MemberBasicInfo info:list){
				idList.add(info.getServerID());
			}
			AppServerExample  example  = new AppServerExample ();
			example.createCriteria().andIdIn(idList);
			List<AppServer>  appServerList = appServerService.selectByExample(example);
			for(MemberBasicInfo info:list){
				for(AppServer appServer:appServerList){
					if(info.getServerID() != null && info.getServerID().equals(appServer.getId())){
						info.setUrl(appServer.getIpAddress());
						info.setMemberGUID(info.getMemberID());
						info.setMemberID(null);
					}
				}
			}
			result.setContent(list);
		}else{
			result.setCode(305);
			result.setMessage("查询参数为空");
		}
		return result;
	}

	@Override
	public List<JSONObject> updatePwd(List<JSONObject> objList) {
		List<JSONObject> list = new ArrayList<JSONObject>();
		for(JSONObject obj:objList){
			JSONObject resultObj = new JSONObject();
			resultObj.put("guid", obj.getString("guid"));
			try{
				MemberBasicInfoExample  example  = new MemberBasicInfoExample ();
				example.createCriteria().andMemberIDEqualTo(obj.getString("guid"));
				MemberBasicInfo info = new MemberBasicInfo();
				info.setPwd(obj.getString("pwd"));
				info.setMemberName(null);
				memberBasicInfoService.updateByExampleSelective(info, example);
				resultObj.put("code", 1);
			}catch(Exception e){
				resultObj.put("code", 2);
			}
			list.add(resultObj);
		}
		return list;
	}

	@Override
	public ReturnObject getMemberByAccountAndPwd(String account, String pwd) throws Exception {
		ReturnObject result = new ReturnObject();
		if(account != null && pwd != null){
			List<MemberBasicInfo> list = memberBasicInfoService.selectMemberByAccountAndPwd(account, pwd);
			if(list == null || list.size() ==0){
				result.setContent(new ArrayList());
				return result;
			}
			MemberBasicInfo info = list.get(0);
			info.setMemberGUID(info.getMemberID());
			info.setMemberID(null);
			result.setContent(info);
		}else{
			result.setCode(305);
			result.setMessage("查询参数为空");
		}
		return result;
	}

	@Override
	public List<MemberBase> selectMemberByDetail(String memberName, String idcard, String tel) {
		return memberBasicInfoService.selectMemberByDetail(memberName, idcard, tel);
	}

	@Override
	public AppServer checkAccount(String account) {
		MemberAccount memberAccount = getAccount(account);
		if(memberAccount != null) {
			return appServerService.selectById(memberAccount.getServerId());
		}
		return null;
	}
	
	@Override
	public List<RegisterResult> registAppMember(List<MemberBasicInfo> memberInfoList, int serverId) {
		List<RegisterResult> registerList = new ArrayList<RegisterResult>();	
		for(MemberBasicInfo memberBasicInfo : memberInfoList){
			RegisterResult registerResult = null;
			try{
				if(memberBasicInfo.getMemberName() == null) {
					memberBasicInfo.setMemberName("");
				}
				registerResult = this.registAppMember(memberBasicInfo, serverId);
				if(registerResult != null) {
					registerList.add(registerResult);
					continue;
				}
			} catch (Exception e) {
				registerList.add(new RegisterResult(memberBasicInfo.getMemberID(), 2, e.getMessage()));
				continue;
			}
			
			List <AccountResult> accountList =  new ArrayList<AccountResult>();
			for(MemberAccount account : memberBasicInfo.getAccountList()) {
				AccountResult accountResult = new AccountResult();
				accountResult.setAccount(account.getAccount());
				accountResult.setAccountType((int)account.getAccountType());
				accountList.add(accountResult);
			}
			registerResult = new RegisterResult(memberBasicInfo.getMemberID(), 1, "");
			registerResult.setAccountlist(accountList);
			registerList.add(registerResult);
		}
		return registerList;
	}
	
	@Override
	public ReturnObject changeTelByPwd(String tel, String guid, String password) {
		MemberBasicInfo member = memberBasicInfoService.selectByGuid(guid);
		if(member == null) {
			return new ReturnObject(1, "会员不存在");
		}
		if(!password.equals(member.getPwd())) {
			return new ReturnObject(1, "密码错误");
		}
		
		MemberAccount account = getAccount(tel);
		if(account != null && account.getMemberID().equals(guid)) {
			return new ReturnObject();
		}
		
		if(account != null && !account.getMemberID().equals(guid)) {
			memberAccountService.deleteAccount(account.getMemberID(), AccountTypeEnum.TEL, account.getServerId());
			memberBasicInfoService.updateLabel(VerifyType.NO.getCode(), account.getMemberID());
		}
		member.setMobile(tel);
		member.setVerifyType(VerifyType.YES.getCode());
		memberBasicInfoService.update(member);
		account = new MemberAccount(guid, tel, AccountTypeEnum.TEL.getType());
		account.setServerId(member.getServerID());
		account.setUpdateTime(new Date());
		if(memberAccountService.updateAccount(account) == 0) {
			account.setCreateTime(new Date());
			memberAccountService.insert(account);
		}
		return new ReturnObject();
	}

	@Override
	public List<AppServer> getAppServer(String serverIds) {
		String[] appId = serverIds.split(";");
		List<Integer> list = new ArrayList<Integer>();
		for(String id : appId) {
			try{
				list.add(Integer.parseInt(id));
			}catch(Exception e) {}
		}
		if(list == null || list.size() == 0) {
			return null;
		}
		AppServerExample example = new AppServerExample();
		example.createCriteria().andIdIn(list);
		List<AppServer> app = appServerService.selectByExample(example);
		return app;
	}

	/**
	 * 
	 * @Title:insertAppMember 
	 * @Description:App会员注册时，要保证手机号作为账号注册成功. 
	 * @author liuhm
	 * @param memberBasicInfo
	 * @param serverId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun RegisterResult
	 */
	private RegisterResult registAppMember(MemberBasicInfo memberBasicInfo, Integer serverId) {
		if(StringUtil.isEmpty(memberBasicInfo.getMobile())) {
			return new RegisterResult(memberBasicInfo.getMemberID(), 2, "注册手机号不能为空");
		}
		MemberAccount account = getAccount(memberBasicInfo.getMobile());
		if(account != null) {
			return new RegisterResult(memberBasicInfo.getMemberID(), 2, "手机号已经被注册");
		}
		List<MemberAccount> accounts = memberBasicInfo.getAccountList();
		if(accounts == null) {
			accounts = new ArrayList<MemberAccount>();
			memberBasicInfo.setAccountList(accounts);
		}
		if(accounts.size() > 0) {
			for(Iterator<MemberAccount> it = accounts.iterator(); it.hasNext();) {
				MemberAccount acct = it.next();
				account = getAccount(acct.getAccount());
				if(account != null) {
					it.remove();
					continue;
				}
				acct.setCreateTime(new Date());
				acct.setServerId(serverId);
				acct.setMemberID(memberBasicInfo.getMemberID());
			}
		}
		account = new MemberAccount();
		account.setAccount(memberBasicInfo.getMobile());
		account.setAccountType(AccountTypeEnum.TEL.getType());
		account.setMemberID(memberBasicInfo.getMemberID());
		account.setServerId(serverId);
		account.setCreateTime(new Date());
		memberBasicInfo.getAccountList().add(account);
		int row = memberAccountService.insertBatch(memberBasicInfo.getAccountList());
		if(row < 1) {
			return new RegisterResult(memberBasicInfo.getMemberID(), 2, "手机号注册失败");
		}
		memberBasicInfo.setServerID(serverId);
		memberBasicInfo.setVerifyType(VerifyType.YES.getCode());
		memberBasicInfoService.insert(memberBasicInfo);
		return null;
	}
	
	private MemberAccount getAccount(String account) {
		MemberAccountExample  example = new  MemberAccountExample();
		example.createCriteria().andAccountEqualTo(account);
		List<MemberAccount> accountList = memberAccountService.selectByExample(example);
		if(accountList == null || accountList.size() ==0){ //账号不存在
			return null;
		}
		return accountList.get(0);
	}

}