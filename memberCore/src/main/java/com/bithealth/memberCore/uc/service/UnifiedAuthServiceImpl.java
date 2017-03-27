/**
 * 
 */
package com.bithealth.memberCore.uc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.agentCore.AgentStatus;
import com.bithealth.agentCore.enums.UCMethodEnum;
import com.bithealth.memberCore.constants.CodeStatus;
import com.bithealth.memberCore.constants.Constrants;
import com.bithealth.memberCore.enmu.AccountTypeEnum;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.group.service.MemToGroupService;
import com.bithealth.memberCore.member.model.DiseasesHistory;
import com.bithealth.memberCore.member.model.FamilyHistory;
import com.bithealth.memberCore.member.model.Habit;
import com.bithealth.memberCore.member.model.LinkMan;
import com.bithealth.memberCore.member.model.MemAccount;
import com.bithealth.memberCore.member.model.MemImportLog;
import com.bithealth.memberCore.member.model.MemRelation;
import com.bithealth.memberCore.member.model.MemSession;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.model.Org;
import com.bithealth.memberCore.member.model.PhysicalExamination;
import com.bithealth.memberCore.member.model.VitalIndex;
import com.bithealth.memberCore.member.service.DiseasesHistoryService;
import com.bithealth.memberCore.member.service.FamilyHistoryService;
import com.bithealth.memberCore.member.service.HabitService;
import com.bithealth.memberCore.member.service.LinkManService;
import com.bithealth.memberCore.member.service.MemFamilyCardService;
import com.bithealth.memberCore.member.service.MemImportLogService;
import com.bithealth.memberCore.member.service.MemRelationService;
import com.bithealth.memberCore.member.service.MemberAccountService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.service.MemberSessionService;
import com.bithealth.memberCore.member.service.PhysicalService;
import com.bithealth.memberCore.member.service.VitalIndexService;
import com.bithealth.memberCore.memberLabel.model.MemberLabelItem;
import com.bithealth.memberCore.memberLabel.service.MemberLabelItemService;
import com.bithealth.memberCore.uc.bean.Account;
import com.bithealth.memberCore.uc.bean.AgentResponse;
import com.bithealth.memberCore.uc.bean.MemberField;
import com.bithealth.memberCore.uc.bean.MemberInfo;
import com.bithealth.memberCore.uc.bean.MemberResponse;
import com.bithealth.memberCore.uc.bean.MemberRet;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.common.utils.Md5Utils;
import com.bithealth.sdk.common.utils.StringUtil;

/**
 * 
 * 类名称: UnifiedAuthService  
 * 功能描述: UC操作服务类.  
 * 日期: 2016年7月4日 下午2:57:12 
 * 
 * @author liuhm
 * @version
 */
//@Service("unifiedAuthService")
public class UnifiedAuthServiceImpl extends UCAgentService{
	
	private static final Logger logger = Logger.getLogger(UnifiedAuthServiceImpl.class);
	
	@Resource(name="memberAccountService")
	protected MemberAccountService memAccountService;
	
	@Resource(name="memberSessionService")
	protected MemberSessionService memberSessionService;
	
	@Resource(name="memberService")
	protected MemberService memberService;
	
	@Resource(name="memToGroupService")
	protected MemToGroupService MemToGroupService;
	
	@Resource(name="diseasesHistoryService")
	protected DiseasesHistoryService diseasesHistoryService;
	
	@Resource(name="familyHistoryService")
	protected FamilyHistoryService familyHistoryService;
	
	@Resource(name="habitService")
	protected HabitService habitService;
	
	@Resource(name="linkManService")
	protected LinkManService linkManService;
	
	@Resource(name="physicalService")
	protected PhysicalService physicalService;
	
	@Resource(name="memRelationService")
	protected MemRelationService MemRelationService;
	
	@Resource(name="vitalIndexService")
	protected VitalIndexService vitalIndexService;
	
	@Resource(name="memFamilyCardService")
	protected MemFamilyCardService familyService;
	
	@Autowired
	protected MemImportLogService LogService;
	
	@Autowired
	protected MemberLabelItemService memberLabelItemService;
	
	protected AgentResponse checkRegist(List<String> jsonStrList) throws Exception {
		AgentResponse response =  this.sendAgent(jsonStrList, UCMethodEnum.RegisterResult);
		logger.info("UC注册更新返回信息：" + response.toString());
		if(response == null || response.getCode() == CodeStatus.SC_REQUEST_TIMEOUT || response.getCode() == CodeStatus.OK) {
			return response;
		}
		throw new Exception(response.getMessage());
	}
	
	public AgentResponse regist(List<String> memList, boolean async)  throws Exception {
		UCMethodEnum method = async ? UCMethodEnum.RegisterAsync : UCMethodEnum.RegisterSync;
		AgentResponse response =  this.sendAgent(memList, method);
		logger.info("UC注册更新返回信息：" + response.toString());
		if(response == null || response.getCode() == CodeStatus.SC_REQUEST_TIMEOUT || response.getCode() == CodeStatus.OK) {
			return response;
		}
		throw new Exception(response.getMessage());
	}
	
	public AgentResponse regist(List<String> memList) throws Exception {
		AgentResponse response =  this.sendAgent(memList, UCMethodEnum.AppMemberRegist);
		logger.info("UC注册更新返回信息：" + response.toString());
		if(response == null || response.getCode() == CodeStatus.SC_REQUEST_TIMEOUT || response.getCode() == CodeStatus.OK) {
			return response;
		}
		throw new Exception(response.getMessage());
	}
	
	public AgentResponse delMember(List<String> memberList)  throws Exception {
		AgentResponse response =  this.sendAgent(memberList, UCMethodEnum.member_delete);
		logger.info("UC删除返回信息：" + response.toString());
		if(response == null || response.getCode() == CodeStatus.SC_REQUEST_TIMEOUT || response.getCode() == CodeStatus.OK) {
			return response;
		}
		throw new Exception(response.getMessage());
	}
	
	private AgentResponse sendAgent(Object obj, UCMethodEnum method) {
		Response response = this.getAgentResult(obj, method);
		if(response == null) {
			return new AgentResponse(CodeStatus.SC_REQUEST_TIMEOUT, "请求连接超时");
		}
		if(response.getStatus() == AgentStatus.SC_OK) {
			String body = response.getBody();
			if(StringUtil.isEmpty(body)) {
				return new AgentResponse(CodeStatus.DATA_ERROR, "agent返回body为空");
			}
			AgentResponse agentResponse = JSON.parseObject(body, AgentResponse.class);
			if(agentResponse == null) {
				return new AgentResponse(CodeStatus.DATA_ERROR, "agent返回数据格式不正确：" + body);
			}
			return agentResponse;
		}
		return new AgentResponse(response.getStatus(), response.getError());
	}
	
	/**
	 * 
	 * @Title:afterUpdate 
	 * @Description:会员修改调用UC后统一处理. 
	 * @author liuhm
	 * @param response 
	 * @param 
	 * @throws
	 * @retrun void
	 */
	protected void afterUpdate(MemberResponse response) {
		if(response.getCode() == MemberRet.SUCCESS) {
			MemImportLog log = LogService.selectByUUID(response.getGuid(), UseTag.M);
			MemberExt member = JSONObject.parseObject(log.getContent(), MemberExt.class);
			Member oldMember = memberService.selectByUUID(member.getMemberGUID(), null);
			member.setUsetag(UseTag.T.name());
			this.saveOrUpdateMember(member);
			LogService.deleteByUUID(response.getGuid(), UseTag.M);
			if(StringUtil.isEmpty(member.getIdcard())){
				if(StringUtil.isNotEmpty(oldMember.getIdcard())){
					memAccountService.deleteByMemberAndAccount(member.getMemberid(), AccountTypeEnum.IDCARD, oldMember.getIdcard()); //删除身份证账号
				}
			} else {
				//新增或者修改身份证账号
				if(!member.getIdcard().equalsIgnoreCase(oldMember.getIdcard())) {
					MemAccount account = new MemAccount(member.getIdcard(), AccountTypeEnum.IDCARD);
					account.setMemberid(member.getMemberid());
					account.setUpdatedrid(member.getDocid());
					if(memAccountService.updateByMemberAndType(account) == 0) {
						account.setCreatedrid(member.getDocid() == null ? 0 : member.getDocid());
						account.setCreatetime(new java.util.Date());
						memAccountService.insert(account);
					}
				}
			}
			
		} else {
			LogService.deleteByUUID(response.getGuid(), UseTag.M);
			memberService.updateUseTagByUUID(response.getGuid(), UseTag.T);
		}
	}
	
	/**
	 * 
	 * @Title:afterDelete 
	 * @Description:会员删除统一调用. 
	 * @author liuhm
	 * @param member
	 * @param response 
	 * @param 
	 * @throws
	 * @retrun void
	 */
	protected void afterDelete(Member member, MemberResponse response) {
		if(response.getCode() == MemberRet.SUCCESS) {
			int memberId = member.getMemberid();
			memberService.updateUseTagByUUID(response.getGuid(), UseTag.F);
			memberSessionService.delete(memberId);
			memAccountService.deleteByMember(memberId);
//			diseasesHistoryService.deleteByExample(example)
//			familyHistoryService.deleteByExample(example)
//			habitService.deleteByExample(example)
//			linkManService.deleteByExample(example)
//			physicalService.delete(id)
//			familyService.deleteByExample(example)
			
			MemToGroupService.insertBatchByMember(null, member, null); //从分组中移除
			LogService.deleteByUUID(response.getGuid(), UseTag.D);
		} else {
			memberService.updateUseTagByUUID(response.getGuid(), UseTag.T);
			LogService.deleteByUUID(response.getGuid(), UseTag.D);
		}
	}
	
	protected boolean afterInsert(Member member, MemberResponse response) {
		boolean suc = false;
		if(response.getCode() == MemberRet.SUCCESS) {
			suc = true;
			memberService.updateUseTagByUUID(response.getGuid(), UseTag.T);
			List<MemAccount> accountList = new ArrayList<>();
			for(Account res : response.getAccountList()) {
				accountList.add(new MemAccount(res.getAccount(), AccountTypeEnum.getAccountType(Short.valueOf(res.getAccountType()))));
			}
			memAccountService.insertOrUpdate(accountList, member);
		} else {
			memberService.deleteByUUID(response.getGuid());
		}
		LogService.deleteByUUID(response.getGuid(), UseTag.R);  //删除日志表
		return suc;
	}
	
	protected void afterImport(Member member, MemberResponse response) {
		if(response.getCode() == MemberRet.SUCCESS) {
			this.afterInsert(member, response);
		} else {
			memberService.updateUseTagByUUID(response.getGuid(), UseTag.E);
			LogService.updateTagByUUID(response.getGuid(), UseTag.E, response.getMsg());
		}
	}
	
	protected String getInfo(MemberExt member) {
		MemberInfo info = MemberField.getInfo(member);
		if(member.getImportLog() != null) {
			info.setSyncTimestamp(String.valueOf(member.getImportLog().getSyncTimestamp()));
		}
		if(member.getMemSession() != null){
			info.setPwd(member.getMemSession().getPassword());
		}
		List<Account> accountList = new ArrayList<Account>();
		List<MemAccount> memberAccountList = member.getAccountList();
		if(memberAccountList != null && memberAccountList.size() > 0) {
			for(MemAccount memberAccount : memberAccountList) {
				accountList.add(new Account(memberAccount.getAccounttype().toString(), memberAccount.getAccount()));
			}
			info.setAccountList(accountList);
		}
		return JSONObject.toJSON(info).toString();
	}
	
	protected boolean saveOrUpdateMember(MemberExt member) {
		boolean isAdd = false;
		if(member.getMemberid() == null || member.getMemberid() == 0) {
			member.setCreatetime(new Date());
			memberService.insert(member);
			isAdd = true;
		} else {
			memberService.updateByPrimaryKey(member);
		}

		memberLabelItemService.initializeItemLabel(member.getMemberid(), member.isFromApp());  //初始化默认标签
		
		List<MemberGroup> groupList = member.getMemberGroupList();  //会员与会员分组
		MemToGroupService.insertBatchByMember(groupList, member, null);
		
		List<DiseasesHistory> diseasesHistoryList = member.getDiseasesHistoryList();  //会员疾病史
		diseasesHistoryService.insertOrUpdate(diseasesHistoryList, member);
		
		List<FamilyHistory> familyHistoryList = member.getFamilyHistoryList();  //会员家族病史
		familyHistoryService.insetOrUpdate(familyHistoryList, member);
		
		Habit habit = member.getHabit();  //会员生活习惯
		if(habit == null){
			habit = new Habit();
		}
		habit.setMemberid(member.getMemberid());
		habitService.insertOrUpdate(habit);
		
		List<LinkMan> linkmanList = member.getLinkmanList(); // 紧急联系人
		linkManService.insertOrUpdate(linkmanList, member);
		
		PhysicalExamination physical = member.getPhysical();  // 会员体格检查
		if(physical == null) {
			physical = new PhysicalExamination();
		}
		physical.setMemberid(member.getMemberid());
		physicalService.insertOrUpdate(physical);
		
		MemRelation relation = member.getRelation();  //会员相关资料
		if(!StringUtil.isEmpty(member.getUniqueId())) {
			if(relation == null) {
				relation = new MemRelation();
			}
			relation.setUniqueId(member.getUniqueId());
			MemRelationService.insert(relation);
		}
		
		familyService.insertMemberCard(member.getOmemCardNos(), member.getMemberid());   //会员智能卡号新增
		
		familyService.insertMemFamily(member.getOmemFamilyCards(), member.getMemberid());
		
		memberLabelItemService.insertBatch(member.getAddLabelItems(), member.getMemberid());  //会员标签操作
		memberLabelItemService.deleteBatch(member.getRemoveLabelItems(), member.getMemberid());
		
		//生成账号，身份证不为空可作为账号
		String defaultAcct = Constrants.SERVERID + "-" + member.getMemberid(); //生成内部账号
		if(isAdd || UseTag.E.name().equals(member.getUsetag())) {
			member.getAccountList().add(new MemAccount(defaultAcct, AccountTypeEnum.OTHER));  
			if(StringUtil.isNotEmpty(member.getIdcard())) {
				defaultAcct = member.getIdcard();
				member.getAccountList().add(new MemAccount(member.getIdcard(), AccountTypeEnum.IDCARD));
			} 
		}
		
		if(isAdd) {
			VitalIndex vitalIndex = member.getVitalIndex();   //活力指数,会员修改时不影响
			if(vitalIndex == null) {
				vitalIndex = new VitalIndex();
				vitalIndex.setVigorindex(0);
			}
			vitalIndex.setMemberid(member.getMemberid());
			vitalIndexService.insert(vitalIndex);
			
			MemSession memSession = member.getMemSession();   //会员登录session，会员修改时不影响
			if(memSession == null) {
				memSession = new MemSession();
			}
			if(!member.isFromApp()) {
				memSession.setPassword(Md5Utils.encript(getDefaultPwd(defaultAcct)));  //获取默认密码
			}
			memSession.setCurtag("Y");
			memSession.setMemberid(member.getMemberid());
			member.setMemSession(memSession);
			memberSessionService.insert(memSession);
		}
		
		return true;
	}
	
	 /**
     * 
     * @Title:getDefaultPwd 
     * @Description:默认密码生成规则. 
     * @author liuhm
     * @param str
     * @return 
     * @param 
     * @throws
     * @retrun String
     */
    private String getDefaultPwd(String str) {
    	if(str.indexOf("-") > 0) {
    		String[] arr = str.split("-");
    		if(arr[1].length() < 6) {
    			StringBuilder sb = new StringBuilder(arr[1]);
    			while(sb.length() < 6) {
    				sb.insert(0, "0");
    			}
    			return Md5Utils.encript(sb.toString()) + "zkhk";
    		}
    	}
    	return Md5Utils.encript(str.substring(str.length()-6).toLowerCase()) + "zkhk";
    }
    
    protected String isExistTel(String tel) {
    	if(StringUtil.isEmpty(tel)) {
    		return "注册手机号不能为空";
    	}
    	MemAccount account = memAccountService.selectByAccount(tel);
    	if(account == null) {
    		return null;
    	}
    	Member member = account.getMember();
    	if(member == null) {
    		return tel + "已在本业务平台注册";
    	}
    	Org org = member.getOrg();
    	String orgName = "";
    	if(org != null) {
    		orgName = "组织【" + org.getOrgName() + "】下";
    	}
    	return tel + "已在本业务平台" + orgName + "注册";
    }
    
    protected String isExist(Member member) {
    	if(member.getIsInfoPerfect().byteValue() == 1) { //已经完善的不作校验
    		return null;
    	}
    	Member mem = null;
    	String stuText = "";
    	String orgText = "";
    	if(StringUtil.isNotEmpty(member.getIdcard())) {
    		mem = memberService.selectByIdcard(member.getIdcard());
    		if(mem != null) {
    			if(UseTag.R.name().equals(mem.getUsetag())) {
					stuText = "注册中的";
				}
    			if(mem.getOrg() != null) {
    				orgText = mem.getOrg().getOrgName() + "组织下";
    			}
    			if(member.getMemberid() == null || member.getMemberid() == 0) {
    				return "身份证与本系统" + orgText + stuText + "会员" + mem.getMemname() + "重复";
        		} else {
        			if(mem.getMemberid().intValue() != member.getMemberid().intValue()) {
        				return "身份证与本系统" + orgText + stuText + "会员" + mem.getMemname() + "重复";
        			}
        		}
    		}
    	}
		if(StringUtil.isNotEmpty(member.getTel()) && StringUtil.isNotEmpty(member.getMemname())) {
			mem = memberService.selectByNameAndTel(member.getTel(), member.getMemname());
			if(mem != null) {
				if(UseTag.R.name().equals(mem.getUsetag())) {
					stuText = "注册中的";
				}
				if(mem.getOrg() != null) {
    				orgText = "组织" + mem.getOrg().getOrgName() + "下";
    			}
				if(member.getMemberid() == null || member.getMemberid() == 0) {
					return "手机号和姓名同本系统" + orgText + stuText + "会员" + mem.getMemname() + "重复";
				} else {
					if(mem.getMemberid().intValue() != member.getMemberid().intValue()) {
						return "手机号和姓名同本系统" + orgText + stuText + "会员" + mem.getMemname() + "重复";
					}
				}
			}
		}
		
		return null;
	}
}
