package com.bithealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.agentCore.agent.RedicrectService;
import com.bithealth.agentCore.bean.Parameter;
import com.bithealth.agentCore.enums.RequestMethodEnum;
import com.bithealth.constants.Constants;
import com.bithealth.doctorCore.docGroup.model.DocToGroup;
import com.bithealth.doctorCore.docGroup.model.DocToGroupExample;
import com.bithealth.doctorCore.docGroup.service.DoctorToGroupService;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorExample;
import com.bithealth.doctorCore.doctor.model.DoctorExample.Criteria;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpExample;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.memberCore.constants.Constrants;
import com.bithealth.memberCore.enmu.AccountTypeEnum;
import com.bithealth.memberCore.enmu.DeviceEnum;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.exception.LoginException;
import com.bithealth.memberCore.facede.service.AppMemberManager;
import com.bithealth.memberCore.facede.service.MemberInterfService;
import com.bithealth.memberCore.group.model.DoctorGrp;
import com.bithealth.memberCore.group.model.MemGroupExt;
import com.bithealth.memberCore.group.model.MemToGroupExample;
import com.bithealth.memberCore.group.model.MemToGroupKey;
import com.bithealth.memberCore.group.service.MemToGroupService;
import com.bithealth.memberCore.group.service.MemberGroupService;
import com.bithealth.memberCore.member.model.DiseasesHistory;
import com.bithealth.memberCore.member.model.FamilyHistory;
import com.bithealth.memberCore.member.model.FamilyHistoryExample;
import com.bithealth.memberCore.member.model.Habit;
import com.bithealth.memberCore.member.model.MemAccount;
import com.bithealth.memberCore.member.model.MemFamilyCard;
import com.bithealth.memberCore.member.model.MemFamilyCardExample;
import com.bithealth.memberCore.member.model.MemFamilyCardExt;
import com.bithealth.memberCore.member.model.MemSession;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.model.PhysicalExamination;
import com.bithealth.memberCore.member.model.SearchCondition;
import com.bithealth.memberCore.member.service.FamilyHistoryService;
import com.bithealth.memberCore.member.service.MemFamilyCardService;
import com.bithealth.memberCore.member.service.MemberAccountService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.service.PhysicalService;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.memberCore.uc.bean.AppServer;
import com.bithealth.memberCore.uc.bean.CheckResult;
import com.bithealth.memberCore.uc.bean.MemberRet;
import com.bithealth.memberCore.uc.bean.MergeResult;
import com.bithealth.memberCore.uc.bean.MergerDetail;
import com.bithealth.model.AppUser;
import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
import com.bithealth.msgCenterCore.model.SmsSendParams;
import com.bithealth.orgainCore.model.Org;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.sdk.client.http.HttpUtils;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.taskMgrCore.model.MemberMerge;
import com.bithealth.taskMgrCore.server.MemberMergeService;
import com.bithealth.util.HealthCheckUtil;
import com.bithealth.util.MessageUtil;
import com.bithealth.util.PasswordEncryption;
import com.bithealth.util.TimeUtil;

/**
 * @PackageName: com.bithealth.controller
 * @FileName:    MemberController.java  
 * @Description: 会员基本信息  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuxiaoqin
 * @version      V1.0  
 * @Createdate:  2016年7月20日 
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController extends BaseSpringController{
	
	@Resource
    private MemberService memberService;
	
	@Resource
    private MemberInterfService memberInterfService;
	
	@Resource
    private DoctorService doctorService;
	
	@Resource
    private PhysicalService physicalService;
	
	@Resource
    private FileManagerServiceFacade fileManagerServiceFacade;
	
	@Resource
    private FamilyHistoryService familyHistoryService;
	
	@Resource
    private MemToGroupService  memToGroupService;
	
	@Resource
    private MemberGroupService memberGroupService;
	
	@Resource
    private DoctorToGroupService doctorToGroupService;
	
	@Resource
    private BloodPressureService bloodPressureService;
	
	@Resource
    private MemFamilyCardService memFamilyCardService;
	
	@Resource
    private MessageCenterFacadeService messageCenterFacadeService;
	
	@Resource
    private MemberAccountService memberAccountService;
	
	@Resource
    private AppMemberManager appMemberManager;
	
	@Resource
    private OrgService orgService;
	
	@Resource
    private RedicrectService redicrectService;
	
	@Resource
    private MemberMergeService memberMergeService;
	
	private static Logger logger = Logger.getLogger(MemberController.class);
	
	/**
	 * @Description: 会员登录 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月27日 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
		PrintWriter out = response.getWriter();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
		DeviceEnum deviceType = DeviceEnum.valueOf(user.getDeviceType());
		String password = user.getUserPassword();
		int isNewUser = 0;
		try{
			JSONResult<Object> value = new JSONResult<Object>();
			String newewUser = (String)request.getAttribute("isNewUser");
			if(StringUtils.isEmpty(newewUser)){
				password = PasswordEncryption.getMD5Password(user.getUserPassword()+"zkhk");
			}else{
				isNewUser = 1;
			}
			MemAccount account = memberInterfService.login(user.getUserAccount(),password,deviceType);
			if(account != null){
				String userName = account.getMember().getMemname();
				Date logTime = account.getMemberSession().getLogintime();
				if(logTime != null){
					user.setLogTime(TimeUtil.formatDatetime2(logTime));
				}
				user.setSession(account.getMemberSession().getSession());
				user.setUserId(account.getMemberid());
				user.setUserName(userName);
				user.setUserGUID(account.getMember().getMemberGUID());
				
				/*检验手机号是否被认证过(VerifyType:0-无，1-手机认证 )     begin*/
				Byte verifyType = account.getMember().getVerifyType();
				if(StringUtils.isEmpty(verifyType) == true || verifyType == (byte)0){
					value.setStatusCode(8);
					value.setMessage(MessageUtil.getValue("user.not.register"));
					logger.info("账号为【"+user.getUserAccount()+"】的会员【"+userName+"】的手机号未认证");
					value.setSuccess(false);
					value.setData(user);
					out.write(JSON.toJSONString(value));
					return;
				}			
				/*检验手机号是否被认证过(VerifyType:0-无，1-手机认证 )     end*/
				
				/*检验资料是否完善(IsInfoPerfect: 0-否，1-是)     begin*/
				Byte isInfoPerfect = account.getMember().getIsInfoPerfect();
				if(StringUtils.isEmpty(isInfoPerfect) == true || isInfoPerfect == (byte)0){
					value.setStatusCode(11);
					value.setMessage("您的资料未完善");
					logger.info("账号为【"+user.getUserAccount()+"】的会员【"+userName+"】的资料未完善");
					value.setSuccess(false);
					value.setData(user);
					user.setUserPhoneNumber(account.getMember().getTel());
					out.write(JSON.toJSONString(value));
					return;
				}			
				/*检验资料是否完善(IsInfoPerfect: 0-否，1-是)     end*/
				value.setStatusCode(0);
				value.setMessage("会员【"+userName+"】登录成功");
				logger.info("账号为【"+user.getUserAccount()+"】的会员【"+userName+"】登录成功");
				value.setSuccess(true);
				value.setData(user);
				out.write(JSON.toJSONString(value));
			}
		}catch(LoginException e){
			String code = e.getCode();
			if(code.equals(LoginException.ERROR_PWD) && isNewUser == 0){
				request.setAttribute("isNewUser", "Y");
				login(request,response);
			}else{
				JSONResult<Object> value = new JSONResult<Object>();
				String message = "member." + code;
				value.setStatusCode(1);
				value.setMessage(MessageUtil.getValue(message));
				logger.info(MessageUtil.getValue(message));
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
			}
		}
    }
	
	/**
	 * @Description: 会员注销 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月27日 
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	MemAccount account = new MemAccount();
    	account.setAccount(user.getUserAccount());
    	try{
    		memberInterfService.logout(account);
    		value.setStatusCode(0);
			value.setMessage("会员【"+user.getUserName()+"】注销成功");
			logger.info("账号为【"+user.getUserAccount()+"】的会员【"+user.getUserName()+"】注销成功");
			value.setSuccess(true);
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.update.data"));
			logger.info("账号为【"+user.getUserAccount()+"】的会员【"+user.getUserName()+"】注销异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 根据id查询基本资料 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月27日 
	 */
	@RequestMapping(value = "/findMemberBasicInfo", method = RequestMethod.POST)
    public void selectMemberBasicInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	
    	try{
    		Member member = memberService.selectById(user.getUserId());
    		if(member == null){
    			value.setStatusCode(3);
    			value.setMessage("该会员不存在 ");
    			logger.info("该会员不存在");
    			value.setSuccess(false);
    		}else{
    			Map<String,Object> map = convertMember(member);
    			value.setStatusCode(0);
    			value.setMessage("查询会员基本资料成功！ ");
    			logger.info("查询会员基本资料成功！");
    			value.setData(map);
    			value.setSuccess(true);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("获取数据异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 分页获取医生列表 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月27日 
	 */
	@RequestMapping(value = "/findMyDoctorsByParam", method = RequestMethod.POST)
    public void selectMyDoctorsByParam(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer pageNow = StrObject.getInteger("pageNow");
    	Integer pageSize = StrObject.getInteger("pageSize");
    	try{
    		Member member = memberService.selectById(user.getUserId());
    		if(member == null){
    			value.setStatusCode(3);
    			value.setMessage("该会员不存在 ");
    			logger.info("该会员不存在");
    			value.setSuccess(false);
    		}else{
    			/*获取会员分组编号 begin */
    			Page<MemToGroupKey> page = new Page<MemToGroupKey>(1,50);
    			MemToGroupExample example = new MemToGroupExample();
    			example.createCriteria().andMemberidEqualTo(member.getMemberid());
    			List<MemToGroupKey> list = memToGroupService.selectByExampleAndPage(page, example);
    			if(list != null && list.size() >0){
    				/*获取医生分组编号  begin */
    				List<Integer> doctorGroupIds = new ArrayList<Integer>();
    				for(MemToGroupKey memberGroup : list){
    					MemGroupExt memGroupExt = memberGroupService.selectMemGrpExtById(memberGroup.getMemgrpid());
    					if(memGroupExt != null){
    						List<DoctorGrp> list1 = memGroupExt.getDoctorGrpList();
    						if(list1 != null && list1.size() >0){
    							for(DoctorGrp doctorGrp : list1){
    								doctorGroupIds.add(doctorGrp.getDoctorGrpId());
    							}
    						}
    					}
    				}
    				/*获取医生分组编号  end */
    				if(doctorGroupIds != null && doctorGroupIds.size() >0){
    					/*获取医生ids  begin */
    					List<Integer> doctorIds = new ArrayList<Integer>();
    					DocToGroupExample newExample = new DocToGroupExample();
    					newExample.createCriteria().andOdgpidIn(doctorGroupIds);
    					List<DocToGroup> list2 = doctorToGroupService.selectByExample(newExample);
    					if(list2 != null && list2.size()>0){
    						for(DocToGroup docToGroup : list2){
    							doctorIds.add(docToGroup.getDocid());
    						}
    					}
    	    			/*获取医生ids  end */
    					if(doctorIds != null && doctorIds.size()>0){
    						List<Integer> doctorNewIds = new ArrayList<Integer>();
    						for(Integer id : doctorIds){
    							if(!doctorNewIds.contains(id)){
    								doctorNewIds.add(id);
    							}
    						}
    						/*获取医生列表 begin */
    						Page<Doctor> pageDoc = new Page<Doctor>(pageNow,pageSize);
    		    			DoctorExample exampleDoc = new DoctorExample();
    		    			Criteria criteria = exampleDoc.createCriteria();
    		    			criteria.andDocidIn(doctorNewIds);
    		    			List<Doctor> list3 = doctorService.selectByExampleAndPage(pageDoc, exampleDoc);
    		    			if(list3 != null && list3.size()>0){
    		    				List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
    		    				for(Doctor doc : list3){
    		    					Map<String,Object> map = convertDcotor(doc);
    		    					mapList.add(map);
    		    				}
    		    				value.setStatusCode(0);
    		    				value.setMessage("分页查询我的医生列表成功！ ");
    		    				logger.info("分页查询我的医生列表成功！");
    		    				value.setData(mapList);
    		    				value.setSuccess(true);
    		    			}else{
    		    				value.setStatusCode(3);
    		    				value.setMessage("该会员没有医生！ ");
    		    				logger.info("该会员没有医生！");
    		    				value.setSuccess(false);
    		    			}
    						/* 获取医生列表 end */
    					}else{
    						value.setStatusCode(3);
            				value.setMessage("该会员没有医生！ ");
            				logger.info("该会员没有医生！");
            				value.setSuccess(false);
    					}
    				}else{
    					value.setStatusCode(3);
        				value.setMessage("该会员没有医生！ ");
        				logger.info("该会员没有医生！");
        				value.setSuccess(false);
    				}
    			}else{
    				value.setStatusCode(3);
    				value.setMessage("该会员没有医生！ ");
    				logger.info("该会员没有医生！");
    				value.setSuccess(false);
    			}
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("分页查询我的医生列表异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 更新会员基本信息 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月27日 
	 */
	@RequestMapping(value = "/updateMemberBasicInfo", method = RequestMethod.POST)
    public void updateMemberBasicInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	try{
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		Integer memberId = user.getUserId();
    		if(user.getUserType() == 2){
    			Integer newMemberId = StrObject.getInteger("memberId");
    			if(newMemberId == null || newMemberId <= 0){
    	    		value.setStatusCode(1);
    				value.setMessage("参数memberId【"+newMemberId+"】应为正整数");
    				logger.info("参数memberId【"+newMemberId+"】应为正整数");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return; 
    	    	}
    			memberId = newMemberId;
    		}
    		Member member = JSON.parseObject(otherParam, Member.class);
    		
    		member.setMemberid(memberId);
    		member.setMemname(StrObject.getString("memberName"));
    		member.setDocname(StrObject.getString("doctorName"));
    		member.setDocid(StrObject.getInteger("doctorId"));
    		member.setMemberGUID(StrObject.getString("memberGUID"));
    		/*上传头像 begin*/
    		String imgHead = StrObject.getString("headimg");
    		if(!StringUtils.isEmpty(imgHead)){
    			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
    			MultipartFile fileName = multipartRequest.getFile("headimg");
    			if(fileName == null){
    				value.setStatusCode(1);
    				value.setMessage("头像headimg【"+fileName+"】不能为空");
    				logger.info("头像headimg【"+fileName+"】不能为空");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return;
    			}
    			FileConfigModel modle = new FileConfigModel();
    			String fileType = fileName.getContentType();
    			int m = fileType.lastIndexOf("/");
    			String realFileType = fileType.substring(m+1);
    			modle.setTypeEnum(FileTypeEnum.findEnumByFormat(realFileType));
    			modle.setNeedCompress(false);
    			String uniqueId = fileManagerServiceFacade.uploadFile(fileName.getInputStream(), modle);
    			if(StringUtils.isEmpty(uniqueId)){
    				value.setStatusCode(1);
    				value.setMessage("上传文件失败");
    				logger.info("上传文件【"+fileName+"】失败");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return;
    			}
    			member.setHeadaddress(uniqueId);
    		}
    		member.setHeadimg(null);
    		/*上传头像 end*/
    		String oldIdCard = "";
    		Member memberOld = memberService.selectById(memberId);
    		if(memberOld != null){
    			oldIdCard =  memberOld.getIdcard();
    		}
    		String newIdCard = member.getIdcard();
    		if(StringUtils.isEmpty(newIdCard) == false && newIdCard.equals(oldIdCard) == false){
    			Member memberNew = memberService.selectByIdcard(newIdCard);
    			if(memberNew != null){
    				value.setStatusCode(1);
    				value.setMessage("身份证号【"+newIdCard+"】的会员已存在，请重新输入");
    				logger.info("身份证号【"+newIdCard+"】的会员已存在，请重新输入");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return; 
    			}
    		}
    		MemberExt oldMember = memberService.selectMemberExtById(memberId);
    		Byte verifyType = oldMember.getVerifyType();
    		Byte isInfoPerfect = oldMember.getIsInfoPerfect();
    		String usetag = oldMember.getUsetag();
    		String status = oldMember.getStatus();
    		member.setMemberGUID(user.getUserGUID());
    		member.setOrgid(oldMember.getOrgid());
    		BeanUtils.copyProperties(member,oldMember, HealthCheckUtil.getNullPropertyNames(member));
    		MemFamilyCardExample example = new MemFamilyCardExample();
    		example.createCriteria().andFamilyMemberidEqualTo(memberId);
    		List<MemFamilyCard> cardList = memFamilyCardService.selectByExample(example);
    		if(cardList != null && cardList.size() >0){
    			oldMember.setOmemCardNos(cardList);
    		}
    		List<MemFamilyCardExt> cardExtList = memFamilyCardService.selectMemCardExtNotMy(memberId);
    		if(cardExtList != null && cardExtList.size() >0){
    			oldMember.setOmemFamilyCards(cardExtList);
    		}
    		MemSession memSession = oldMember.getMemSession();
    		memSession.setSession(user.getSession());	
    		oldMember.setMemSession(memSession);
    		oldMember.setVerifyType(verifyType);
    		oldMember.setIsInfoPerfect(isInfoPerfect);
    		oldMember.setStatus(status);
    		oldMember.setUsetag(usetag);
    		String msg = memberInterfService.updateMember(oldMember);
    		if(!StringUtils.isEmpty(msg)){
    			value.setStatusCode(1);
    			value.setMessage(msg);
    			logger.info(msg);
    			value.setSuccess(false);
    		}else{
    			value.setStatusCode(0);
    			value.setMessage("更新会员基本信息成功！ ");
    			logger.info("更新会员基本信息成功！");
    			value.setSuccess(true);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.update.data"));
			logger.info("更新会员基本信息异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 修改密码 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月27日 
	 */
	@RequestMapping(value = "/updateMemberPassword", method = RequestMethod.POST)
    public void updateMemberPassword(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
		int isNewUser = 0;
		try{
			String oldPassword = StrObject.getString("oldPassword");
	    	String newPassword = StrObject.getString("newPassword");
			JSONResult<Object> value = new JSONResult<Object>();
			String newewUser = (String)request.getAttribute("isNewUser");
			if(StringUtils.isEmpty(newewUser)){
				oldPassword = PasswordEncryption.getMD5Password(oldPassword + "zkhk");
			}else{
				isNewUser = 1;
			}
			newPassword = PasswordEncryption.getMD5Password(newPassword + "zkhk");
			boolean isSuccess = memberInterfService.updatePassword(user.getUserId(), newPassword, oldPassword);
			if(isSuccess == false){
    			value.setStatusCode(1);
    			value.setMessage("失败 ");
    			logger.info("会员更新密码失败");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    		}else{
    			value.setStatusCode(0);
    			value.setMessage("会员更新密码成功！ ");
    			logger.info("会员更新密码成功！");
    			value.setSuccess(true);
    			out.write(JSON.toJSONString(value));
    		}
		}catch(BusinessException e){
			String message = e.getMessage();
			if(message.equals("抱歉，旧密码验证失败 请稍后再试或与管理员联系！") && isNewUser == 0){
				request.setAttribute("isNewUser", "Y");
				updateMemberPassword(request,response);
			}else if(message.equals("抱歉，旧密码验证失败 请稍后再试或与管理员联系！") && isNewUser != 0){
				JSONResult<Object> value = new JSONResult<Object>();
				value.setStatusCode(1);
				value.setMessage("旧密码信息输入错误！");
				logger.info(message);
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
			}else{
				JSONResult<Object> value = new JSONResult<Object>();
				value.setStatusCode(2);
				value.setMessage(MessageUtil.getValue("error.update.data"));
				logger.info("会员更新密码异常"+e);
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
			}
		}
	}
	
	/**
	 * @Description: 分页条件查询会员列表 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月27日 
	 */
	@RequestMapping(value = "/findMemberListByParam", method = RequestMethod.POST)
    public void selectMemberListByParam(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer pageNow = StrObject.getInteger("pageNow");
    	Integer pageSize = StrObject.getInteger("pageSize");
    	String tel = StrObject.getString("tel");
    	try{
    		SearchCondition<MemberVo> vo = new SearchCondition<MemberVo>();
    		vo.setMemName(user.getUserName());
    		vo.setTel(tel);
    		Page<MemberVo> page = new Page<MemberVo>(pageNow,pageSize);
    		vo.setPage(page);
    		Page<MemberVo> meberlist = memberService.listMyMemberByPage(vo);
    		if(meberlist != null && meberlist.getTotalCount()>0){
    			value.setStatusCode(0);
    			value.setMessage("查询会员成功");
    			logger.info("查询会员成功！");
    			value.setSuccess(true);
    			
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("查询会员失败 ");
    			logger.info("查询会员失败");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("查询会员异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 获取会员的健康档案资料 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月27日 
	 */
	@RequestMapping(value = "/findMemberHealthFile", method = RequestMethod.POST)
    public void selectMemberHealthFile(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	try{
    		Integer memberId = user.getUserId();
    		if(user.getUserType() == 2){
    			Integer newMemberId = StrObject.getInteger("memberId");
    			if(newMemberId == null || newMemberId <= 0){
    	    		value.setStatusCode(1);
    				value.setMessage("参数memberId【"+newMemberId+"】应为正整数");
    				logger.info("参数memberId【"+newMemberId+"】应为正整数");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return; 
    	    	}
    			memberId = newMemberId;
    		}
    		if(!StringUtils.isEmpty(StrObject)){
    			String memberGUID = StrObject.getString("memberGUID");
        		if(!StringUtils.isEmpty(memberGUID)){
        			Member member = memberService.selectByUUID(memberGUID,UseTag.T);
        			if(member != null){
        				memberId = member.getMemberid();
        			}
        		}
    		}
    		MemberExt healthFile = memberService.selectMemberExtById(memberId);
    		if(healthFile != null){
    			Map<String,Object> map = new HashMap<String,Object>();
    			Member member = memberService.selectById(healthFile.getMemberid());
    			map.put("basicInfo", convertMember(member));
    			map.put("physicalExamination", getPhysicalExamination(healthFile));
    			map.put("habit", healthFile.getHabit());
    			map.put("diseasesHistory", healthFile.getDiseasesHistoryList());
    			map.put("familyHistory", convertFamilyHistory(healthFile.getFamilyHistoryList()));
    			value.setStatusCode(0);
    			value.setData(map);
    			value.setMessage("查询会员健康档案信息成功");
    			logger.info("查询会员健康档案信息成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("该会员没有健康档案信息 ");
    			logger.info("该会员没有健康档案信息");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("查询会员健康档案信息异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 修改会员的健康档案资料 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月27日 
	 */
	@RequestMapping(value = "/updateMemberHealthFile", method = RequestMethod.POST)
    public void updateMemberHealthFile(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	try{
    		Integer memberId = user.getUserId();
    		if(user.getUserType() == 2){
    			Integer newMemberId = StrObject.getInteger("memberId");
    			if(newMemberId == null || newMemberId <= 0){
    	    		value.setStatusCode(1);
    				value.setMessage("参数memberId【"+newMemberId+"】应为正整数");
    				logger.info("参数memberId【"+newMemberId+"】应为正整数");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return; 
    	    	}
    			memberId = newMemberId;
    		}
    		MemberExt healthFile = memberService.selectMemberExtById(memberId);
    		MemFamilyCardExample example = new MemFamilyCardExample();
    		example.createCriteria().andFamilyMemberidEqualTo(memberId);
    		List<MemFamilyCard> cardList = memFamilyCardService.selectByExample(example);
    		if(cardList != null && cardList.size() >0){
    			healthFile.setOmemCardNos(cardList);
    		}
    		List<MemFamilyCardExt> cardExtList = memFamilyCardService.selectMemCardExtNotMy(memberId);
    		if(cardExtList != null && cardExtList.size() >0){
    			healthFile.setOmemFamilyCards(cardExtList);
    		}
    		String physicalExaminationStr = StrObject.getString("physicalExamination");
    		if(!StringUtils.isEmpty(physicalExaminationStr)){
    			PhysicalExamination physicalExamination = JSON.parseObject(physicalExaminationStr, PhysicalExamination.class);
    			healthFile.setPhysical(physicalExamination);
    			JSONObject physicalObject = JSON.parseObject(physicalExaminationStr);
    			String marryStatus = physicalObject.getString("marrystatus");
    			if(!StringUtils.isEmpty(marryStatus)){
    				healthFile.setMarrystatus(marryStatus);
    			}
    		}
    		String habitStr = StrObject.getString("habit");
    		if(!StringUtils.isEmpty(habitStr)){
    			Habit habit = JSON.parseObject(habitStr, Habit.class);
    			healthFile.setHabit(habit);
    		}
    		String diseasesHistoryStr = StrObject.getString("diseasesHistory");
    		if(!StringUtils.isEmpty(diseasesHistoryStr)){
    			List<DiseasesHistory> diseasesHistoryList = JSON.parseArray(diseasesHistoryStr, DiseasesHistory.class);
    			healthFile.setDiseasesHistoryList(diseasesHistoryList);
    		}
    		String familyHistoryStr = StrObject.getString("familyHistory");
    		if(!StringUtils.isEmpty(familyHistoryStr)){
    			List<FamilyHistory> familyHistoryList = new ArrayList<FamilyHistory>();
    			JSONArray arrList = JSON.parseArray(familyHistoryStr);
    			for(Object arr : arrList){
    				JSONObject object = JSON.parseObject(arr.toString());
    				Byte relation = object.getByte("relation");
    				Integer memberID = object.getInteger("memberId");
    				String diseaseIds = object.getString("diseaseIds");
    				String diseaseName = object.getString("diseaseName");
    				if(!StringUtils.isEmpty(diseaseIds)){
    					String[] strArr = diseaseIds.split(",");
    					for(String str : strArr){
    						FamilyHistory history = new FamilyHistory();
    						Integer diseaseID = Integer.valueOf(str);
    						history.setMemberID(memberID);
    						history.setDiseaseID(diseaseID);
    						history.setRelation(relation);
    						if(diseaseID == 10){
    							history.setDiseaseName(diseaseName);
    						}
    						familyHistoryList.add(history);
    					}
    				}else{
    					FamilyHistory history = new FamilyHistory();
						history.setMemberID(memberID);
						history.setRelation(relation);
						familyHistoryList.add(history);
    				}
    			}
    			healthFile.setFamilyHistoryList(familyHistoryList);
    		}else{
    			healthFile.setFamilyHistoryList(null);
    		}
    		String msg = memberInterfService.updateMember(healthFile);
    		if(!StringUtils.isEmpty(msg)){
    			value.setStatusCode(1);
    			value.setMessage(msg);
    			logger.info(msg);
    			value.setSuccess(false);
    		}else{
    			value.setStatusCode(0);
    			value.setMessage("更新会员健康档案信息成功 ");
    			logger.info("更新会员健康档案信息成功");
    			value.setSuccess(true);
    		}
    	}catch(BusinessException e){
    		value.setStatusCode(2);
			value.setMessage(e.getMessage());
			logger.info(e.getMessage());
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return;
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.update.data"));
			logger.info("更新会员健康档案异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 测量三合一之前检查身高体重脉搏收缩压舒张压 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月18日 
	 */
	@RequestMapping(value = "/findSomeValuesBeforeTest", method = RequestMethod.POST)
    public void selectSomeValuesBeforeTest(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer memberId = user.getUserId();
    	if(user.getUserType() == 2){
    		Integer newMemberId = StrObject.getInteger("memberId");
        	if(newMemberId == null || newMemberId <= 0){
        		value.setStatusCode(3);
    			value.setMessage("参数memberId【"+newMemberId+"】应为正整数！");
    			logger.info("参数memberId【"+newMemberId+"】应为正整数！");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
        	}
    		memberId = newMemberId;
    	}
    	try{
    		Map<String,Object> map = new HashMap<String,Object>();
    		Integer systolic = null;
    		Integer diastolic = null;
    		Integer pulse = null;
    		OsbpExample example = new OsbpExample();
    		example.createCriteria().andMemberidEqualTo(memberId).andDeltagEqualTo("0");
    		example.setOrderByClause("TestTime DESC");
    		List<Osbp> list = bloodPressureService.selectByExample(example);
    		PhysicalExamination physical = physicalService.selectById(memberId);
    		/* 先在osbp血压测量记录中取最新的数据 begin */
    		if(list != null && list.size() >0){
    			Osbp osbp = list.get(0);
    			Integer systolicNew = osbp.getSbp();
    			if(systolicNew != null && systolicNew >0){
    				systolic = systolicNew;
    			}
    			Integer diastolicNew = osbp.getDbp();
    			if(diastolicNew != null && diastolicNew >0){
    				diastolic = diastolicNew;
    			}
    			
    			Integer pulseNew = osbp.getPulserate();
    			if(pulseNew != null && pulseNew >0){
    				pulse = pulseNew;
    			}
				/* 先在osbp血压测量记录中取最新的数据 end */
    		}else{
        		/* 从健康体检表mem2中获取  begin */
    			if(physical != null){
    				if(!StringUtils.isEmpty(physical.getBloodh())){
    					systolic = (int)physical.getBloodh();
    				}
    				if(!StringUtils.isEmpty(physical.getBloodl())){
    					diastolic = (int)physical.getBloodl();
    				}
    				if(!StringUtils.isEmpty(physical.getPulse())){
    					pulse = (int)physical.getPulse();
    				}
    				
    			}
    			/* 从健康体检表mem2中获取  end */
    		}
    		map.put("height", physical.getHeight());
			map.put("weight", physical.getWeight());
			map.put("pulse", pulse);
			map.put("systolic", systolic);
			map.put("diastolic", diastolic);
			map.put("memberId", memberId);
    		if(map != null && map.isEmpty() == false){
    			value.setStatusCode(0);
    			value.setData(map);
    			value.setMessage("测量三合一之前检查身高体重脉搏收缩压舒张压成功");
    			logger.info("测量三合一之前检查身高体重脉搏收缩压舒张压成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("该会员没有健康档案信息 ");
    			logger.info("该会员没有健康档案信息");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("测量三合一之前检查身高体重脉搏收缩压舒张压异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 测量三合一之前完善身高体重脉搏收缩压舒张压 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月18日 
	 */
	@RequestMapping(value = "/updateSomeValuesBeforeTest", method = RequestMethod.POST)
    public void updateSomeValuesBeforeTest(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer memberId = user.getUserId();
    	if(user.getUserType() == 2){
    		Integer newMemberId = StrObject.getInteger("memberId");
        	if(newMemberId == null || newMemberId <= 0){
        		value.setStatusCode(1);
    			value.setMessage("参数memberId【"+newMemberId+"】应为正整数！");
    			logger.info("参数memberId【"+newMemberId+"】应为正整数！");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
        	}
    		memberId = newMemberId;
    	}
    	Integer height = StrObject.getInteger("height");
    	if(height == null || height <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数height【"+height+"】应为正整数！");
			logger.info("参数height【"+height+"】应为正整数！");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return;
    	}
    	BigDecimal weight = StrObject.getBigDecimal("weight");
    	if(weight == null){
    		value.setStatusCode(1);
			value.setMessage("参数weight【"+weight+"】应为正数！");
			logger.info("参数weight【"+weight+"】应为正数！");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return;
    	}
    	Integer pulse = StrObject.getInteger("pulse");
    	if(pulse == null || pulse <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数pulse【"+pulse+"】应为正整数！");
			logger.info("参数pulse【"+pulse+"】应为正整数！");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return;
    	}
    	Short systolic = StrObject.getShort("systolic");
    	if(systolic == null || systolic <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数systolic【"+systolic+"】应为正整数！");
			logger.info("参数systolic【"+systolic+"】应为正整数！");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return;
    	}
    	Short diastolic = StrObject.getShort("diastolic");
    	if(pulse == null || pulse <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数diastolic【"+diastolic+"】应为正整数！");
			logger.info("参数diastolic【"+diastolic+"】应为正整数！");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return;
    	}
		PhysicalExamination physical = new PhysicalExamination();
		physical.setMemberid(memberId);
		physical.setHeight(height);
		physical.setWeight(weight);
		physical.setPulse(pulse);
		physical.setBloodh(systolic);
		physical.setBloodl(diastolic);
    	try{
    		int count = physicalService.update(physical);
    		if(count > 0){
    			value.setStatusCode(0);
    			value.setMessage("测量三合一之前完善身高体重脉搏收缩压舒张压成功");
    			logger.info("测量三合一之前完善身高体重脉搏收缩压舒张压成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(1);
    			value.setMessage("测量三合一之前完善身高体重脉搏收缩压舒张压失败 ");
    			logger.info("测量三合一之前完善身高体重脉搏收缩压舒张压失败");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("测量三合一之前完善身高体重脉搏收缩压舒张压异常"+e);
			value.setSuccess(false);
    	}
    	/*插入最新的血压数据到osbp中 begin*/
    	
    	/*插入最新的血压数据到osbp中 end*/
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 转化会员返回值属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月9日 
	 */
	public Map<String,Object> convertMember(Member member)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId",member.getMemberid());
		map.put("memberName",member.getMemname());
		map.put("gender",member.getGender());
		map.put("logname",member.getLogname());
		map.put("orgid",member.getOrgid());
		map.put("memid",member.getMemid());
		Date date = member.getBirthdate();
		if(date != null){
			String birthdate = TimeUtil.formatDate(date);
			map.put("birthdate",birthdate);
			map.put("age",TimeUtil.getCurrentAgeByBirthdate(birthdate));
		}
		map.put("tel",member.getTel());
		map.put("email",member.getEmail());
		map.put("idcard",member.getIdcard());
		map.put("nativeaddr",member.getNativeaddr());
		map.put("address",member.getAddress());
		String marryStatus = member.getMarrystatus();
		if(StringUtils.isEmpty(marryStatus)){
			marryStatus = "8";
		}
		map.put("marrystatus",marryStatus);
		map.put("occupation",member.getOccupation());
		map.put("educationstatus",member.getEducationstatus());
		map.put("doctorId",member.getDocid());
		map.put("doctorName",member.getDocname());
		map.put("usetag",member.getUsetag());
		Date time = member.getCreatetime();
		if(time != null){
			map.put("createtime",TimeUtil.formatDatetime2(time));
		}
		map.put("headimg",member.getHeadimg());
		map.put("status",member.getStatus());
		map.put("headaddress",member.getHeadaddress());
		map.put("source",member.getSource());
		map.put("uniqueId",member.getUniqueId());
		map.put("memberGUID",member.getMemberGUID());
		/* 另加参数  */
		PhysicalExamination  exam = physicalService.selectById(member.getMemberid());
		if(exam != null){
			map.put("height",exam.getHeight());
			map.put("weight",exam.getWeight());
			map.put("sbp",exam.getBloodh());
			map.put("dbp",exam.getBloodl());
		}
		/* 另加参数 */
		map.put("isInfoPerfect",member.getIsInfoPerfect());
		map.put("verifyType",member.getVerifyType());
		return map;
	}
	
	/**
	 * @Description: 转化医生返回值属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月9日 
	 */
	public Map<String,Object> convertDcotor(Doctor doctor)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("doctorId",doctor.getDocid());
		map.put("doctorName",doctor.getDocname());
		map.put("gender",doctor.getGender());
		map.put("title",doctor.getTitle());
		map.put("unitaddress",doctor.getUnitaddress());
		map.put("workaddress",doctor.getWorkaddress());
		map.put("workdepart",doctor.getWorkdepart());
		map.put("headaddress",doctor.getHeadaddress());
		map.put("desription",doctor.getDesription());
		map.put("doctorGUID",doctor.getDocGUID());
		return map;
	}
	
	/**
	 * @Description: 转化会员返回值属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月9日 
	 */
	public Map<String,Object> getPhysicalExamination(MemberExt healthFile)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		PhysicalExamination physical = healthFile.getPhysical();
		map.put("memberId", physical.getMemberid());
		map.put("bloodType", physical.getBloodtype());
		String hasAllergicHis = physical.getAllergichis();
		String allergicHisName = physical.getAllergichisname();
		map.put("allergichis", hasAllergicHis);
		map.put("allergichisname", allergicHisName);
		if(!StringUtils.isEmpty(hasAllergicHis)){
			String allergic = "";
			if(hasAllergicHis.equals("Y")){
				if(!StringUtils.isEmpty(allergicHisName)){
					allergic = "有" + Constants.LEFT_BRACKET + allergicHisName + Constants.RIGHT_BRACKET;
				}else{
					allergic = "有";
				}
			}else{
				allergic = "无";
			}
			map.put("allergic", allergic);
		}
		map.put("height", physical.getHeight());
		map.put("weight", physical.getWeight());
		map.put("waist", physical.getWaist());
		map.put("hip", physical.getHip());
		map.put("pulse", physical.getPulse());
		map.put("heartrate", physical.getHeartrate());
		map.put("bloodh", physical.getBloodh());
		map.put("bloodl", physical.getBloodl());
		map.put("fastingglucose", physical.getFastingglucose());
		map.put("uricacid", physical.getUricacid());
		map.put("totalcholesterol", physical.getTotalcholesterol());
		map.put("triglyceride", physical.getTriglyceride());
		map.put("densitylipop", physical.getDensitylipop());
		map.put("ldlip", physical.getLdlip());
		map.put("marrystatus", healthFile.getMarrystatus());
		return map;
	}
	
	/**
	 * @Description: 转化家族病床史返回值属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月9日 
	 */
	public List<Map<String,Object>> convertFamilyHistory(List<FamilyHistory> historyList)throws Exception{
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		List<FamilyHistory> list1 =  new ArrayList<FamilyHistory>();
		for(FamilyHistory history2 :historyList){
			list1.add(history2);
		}
		for(FamilyHistory history2 :list1){
			Byte relation2 = history2.getRelation();
			Long longId2 = history2.getLogID();
			for(Iterator<FamilyHistory> it = historyList.iterator(); it.hasNext();){
				FamilyHistory history1 = it.next();
				Long longId1 = history1.getLogID();
				Byte relation1 = history1.getRelation();
				if(relation2 == relation1 && longId1.equals(longId2) == false){
					if(historyList.contains(history2)){
						it.remove();
					}
				}
			}
		}
		if(historyList != null && historyList.size() >0){
			for(FamilyHistory history : historyList){
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("logId", history.getLogID());
				Byte relation = history.getRelation();
				String relationName = "";
				String diseaseIds = "";
				String diseaseName = "";
				if(relation != null){
					// 关系：1-父亲，2-母亲，3-子女，4-兄弟姐妹
					if(relation == 1){
						relationName = "父亲";
					}else if(relation == 2){
						relationName = "母亲";
					}else if(relation == 3){
						relationName = "子女";
					}else if(relation == 4){
						relationName = "兄弟姐妹";
					}
					map.put("relationName",relationName);
				}
				map.put("relation", relation);
				Integer memberId = history.getMemberID();
				map.put("memberId", memberId);
				FamilyHistoryExample example = new FamilyHistoryExample();
				example.createCriteria().andMemberIDEqualTo(memberId).andRelationEqualTo(relation);
				List<FamilyHistory> newList = familyHistoryService.selectByExample(example);
				if(newList != null && newList.size() > 0){
					List<Integer> diseaseIdList = new ArrayList<Integer>();
					for(FamilyHistory newHistory : newList){
						diseaseIdList.add(newHistory.getDiseaseID());
						String otherDiseaseName = newHistory.getDiseaseName();
						if(!StringUtils.isEmpty(otherDiseaseName)){
							diseaseName = otherDiseaseName;
						}
					}
					if(diseaseIdList != null && diseaseIdList.size() >0){
						diseaseIds = StringUtils.collectionToDelimitedString(diseaseIdList, ",");
					}
				}
				map.put("diseaseIds", diseaseIds);
				map.put("diseaseName", diseaseName);
				Date time = history.getCreateTime();
				if(time != null){
					map.put("createTime",TimeUtil.formatDatetime2(time));
				}
				mapList.add(map);
			}
		}
		return mapList;
	}
	
	/**
	 * @Description: 创建并发送验证码
	 * @author:      liuxiaoqin
	 * @version      V3.0 
	 * @Createdate:  2016年12月05日 
	 */
	public JSONResult<Object> createAndSendVerificationCode(HttpServletRequest request,HttpServletResponse response)throws IOException{
		JSONResult<Object> value = new JSONResult<Object>();
		try{
    		String appUser = (String)request.getAttribute("appUserStr");
    		AppUser user = JSON.parseObject(appUser, AppUser.class);
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String phoneNumber = StrObject.getString("phoneNumber");
    		String verificationCodeType = StrObject.getString("verificationCodeType");
    		
    		/**创建随机生成的验证码;默认为6个   begin**/
    		int codeCount = 6;
    		Integer verificationCodeCount = StrObject.getInteger("verificationCodeCount");
    		if(verificationCodeCount != null && verificationCodeCount > 0){
    			codeCount = verificationCodeCount;
    		}
    		
    		//验证码有效时长默认为10分钟
    		Integer expireSecond = StrObject.getInteger("expireSecond");
    		if(expireSecond == null || expireSecond <= 0){
    			expireSecond = 600;
    		}
    		String verificationCode = messageCenterFacadeService.sendSmsCode(verificationCodeType, phoneNumber, codeCount, expireSecond);		
    		/**创建随机生成的验证码;默认为6个   end**/
    		
    		/**发送验证码   begin**/
    		if(!StringUtils.isEmpty(verificationCode)){
    			SmsSendParams smsSendParams = new SmsSendParams();
    			smsSendParams.setContentType((byte)1);
    			smsSendParams.setPriority((byte)1);
    			String sendTime = TimeUtil.formatDatetime2(new Date());
    			smsSendParams.setSendTime(sendTime);
    			/*根据深圳默认的serverId 获取组织id和组织路径   begin */
    			Integer serverId = Integer.valueOf(Constrants.SERVERID);
    			Integer orgId = Integer.valueOf(Constrants.DEFAULT_ORG);
    			String orgPath = orgService.selectAllSharedOrg(orgId, true);
    			smsSendParams.setOrgId(orgId);
    			smsSendParams.setOrgPath(orgPath);
    			if(verificationCodeType.equals("3") == true || verificationCodeType.equals("4") == true){
    				/* 其他组织组织path begin */
    				Integer memberId = user.getUserId();
    				Member newMember = memberService.selectById(memberId);
    				if(newMember != null){
    					smsSendParams.setOrgId(newMember.getOrgid());
    					Org org = orgService.selectById(newMember.getOrgid());
    					if(org != null){
    						smsSendParams.setOrgPath(org.getPath());
    					}
    				}
    				/* 其他组织组织path end */
    			}
    			smsSendParams.setServerID(serverId);
    			/*根据深圳默认的serverId 获取组织id和组织路径   begin */
    			smsSendParams.setRecvNumbers(phoneNumber);
    			int smsType = 0;
    			if(verificationCodeType.equals("3")){
    				smsType = 4;
    			}else{
    				smsType = Integer.valueOf(verificationCodeType);
    			}
    			smsSendParams.setSmsType(smsType);
    			Map<String,Object> map = new HashMap<String, Object>();
    			map.put("code", verificationCode);
    			map.put("product", "汇康e家");
    			String content = JSON.toJSONString(map).toString();
    			smsSendParams.setContent(content);
    			
    			boolean ok = messageCenterFacadeService.smsSend(smsSendParams);
    			if(ok == true){
    				value.setStatusCode(0);
        			value.setMessage("发送验证码成功");
        			logger.info("发送类型为【"+verificationCodeType+"】的验证码成功");
        			value.setSuccess(true);
    			}else{
    				value.setStatusCode(1);
        			value.setMessage("发送验证码失败");
        			logger.info("发送类型为【"+verificationCodeType+"】的验证码失败");
        			value.setSuccess(false);
    			}
    		}
    		else{
    			value.setStatusCode(1);
    			value.setMessage("创建随机生成的验证码失败");
    			logger.info("创建随机生成的验证码失败");
    			value.setSuccess(false);
    			return value;
    		}
    		/**发送验证码   end**/
    	}catch(Exception e){
    		value.setStatusCode(2);
			value.setMessage("发送验证码异常");
			logger.info("发送验证码异常"+e);
			value.setSuccess(false);
    	}
		return value;
	}
	
	/**
	 * @Description: 获取验证码
	 * @author:      liuxiaoqin
	 * @version      V3.0 
	 * @Createdate:  2016年12月06日 
	 */
	public JSONResult<Object> findVerificationCode(HttpServletRequest request,HttpServletResponse response)throws IOException{
		JSONResult<Object> value = new JSONResult<Object>();
		try{
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String phoneNumber = StrObject.getString("phoneNumber");
    		String verificationCodeType = (String)request.getAttribute("verificationCodeType");
    		
    		/**从缓存中获取验证码   begin**/
    		String verificationCode = messageCenterFacadeService.getSmsCode(verificationCodeType, phoneNumber);
    		if(!StringUtils.isEmpty(verificationCode)){
    			value.setStatusCode(0);
    			value.setMessage("获取验证码成功");
    			logger.info("获取验证码【"+verificationCodeType+"】成功");
    			value.setSuccess(true);
    			value.setData(verificationCode);
    		}
    		else{
    			value.setStatusCode(1);
    			value.setMessage(MessageUtil.getValue("verifyCodeInvalid"));
    			logger.info(MessageUtil.getValue("verifyCodeInvalid"));
    			value.setSuccess(false);
    			return value;
    		}
    		/**获取验证码成   end**/
    	}catch(Exception e){
    		value.setStatusCode(2);
			value.setMessage("获取验证码成异常");
			logger.info("获取验证码成异常"+e);
			value.setSuccess(false);
    	}
		return value;
	}
	
	/**
	 * @Description: 会员注册 
	 * @author:      liuxiaoqin
	 * @version      V3.0  
	 * @Createdate:  2016年12月06日 
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
    		String appUser = (String)request.getAttribute("appUserStr");
        	AppUser user = JSON.parseObject(appUser, AppUser.class);
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String phoneNumber = StrObject.getString("phoneNumber");
    		if(StringUtils.isEmpty(phoneNumber)){
    			value.setStatusCode(1);
    			value.setMessage("参数手机号【"+phoneNumber+"】不能为空");
    			logger.info("参数手机号【"+phoneNumber+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		String verificationCode = StrObject.getString("verificationCode");
    		if(StringUtils.isEmpty(verificationCode)){
    			value.setStatusCode(1);
    			value.setMessage("参数验证码【"+verificationCode+"】不能为空");
    			logger.info("参数验证码【"+verificationCode+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		String userPassword = StrObject.getString("userPassword");
    		if(StringUtils.isEmpty(userPassword)){
    			value.setStatusCode(1);
    			value.setMessage("参数密码【"+userPassword+"】不能为空");
    			logger.info("参数密码【"+userPassword+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
            /* 验证验证码     begin */
    		//验证码类型verificationCodeType: 1注册,2忘记密码,3手机号认证,4修改手机号
    		request.setAttribute("verificationCodeType", "1");
    		JSONResult<Object> codeValue = findVerificationCode(request,response);
    		if(codeValue.getData() != null && ((String)codeValue.getData()).equals(verificationCode) == true){
    			/* 调用注册接口     begin */
    			MemberExt member = new MemberExt();
    			member.setTel(phoneNumber);
    			member.setOrgid(Integer.valueOf(Constrants.DEFAULT_ORG));
    			MemberRet memRet = memberInterfService.AppRegist(member, userPassword);
    			if(memRet != null && memRet.getCode() == 1){
        			logger.info("手机号为【"+phoneNumber+"】注册成功");
        			/*调用登录接口      begin*/
        			Map<String,Object> map = new HashMap<String, Object>();
        			map.put("userType", user.getUserType());
        			map.put("version", user.getVersion());
        			map.put("logTime", TimeUtil.formatDatetime2(new Date()));
        			map.put("deviceType", user.getDeviceType());
        			map.put("userPassword", userPassword);
        			map.put("userAccount", phoneNumber);
        			request.setAttribute("appUserStr", JSON.toJSONString(map));
        			login(request,response);
        			return;
        			/*调用登录接口      end*/
    			}else{
    				value.setStatusCode(1);
        			value.setMessage(memRet.getMessage());
        			logger.info("手机号为【"+phoneNumber+"】注册失败");
        			value.setSuccess(false);
    			}
    			
    			/* 调用注册接口     end */
    			
    		}else if(codeValue.getData() != null && ((String)codeValue.getData()).equals(verificationCode) == false){
    			value.setStatusCode(10);
    			value.setMessage(MessageUtil.getValue("verifyCodeError"));
    			logger.info("验证码【"+verificationCode+"】错误");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}else{
    			value.setStatusCode(1);
    			value.setMessage(codeValue.getMessage());
    			logger.info(codeValue.getMessage());
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}
    		/* 验证验证码     end */
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.insert.data"));
			logger.info("注册异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 获取验证码 
	 * @author:      liuxiaoqin
	 * @version      V3.0  
	 * @Createdate:  2016年12月06日 
	 */
	@RequestMapping(value = "/getPhoneVerificationCode", method = RequestMethod.POST)
    public void selectPhoneVerificationCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
    		String appUser = (String)request.getAttribute("appUserStr");
        	AppUser user = JSON.parseObject(appUser, AppUser.class);
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String phoneNumber = StrObject.getString("phoneNumber");
    		if(StringUtils.isEmpty(phoneNumber)){
    			value.setStatusCode(1);
    			value.setMessage("参数手机号【"+phoneNumber+"】不能为空");
    			logger.info("参数手机号【"+phoneNumber+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		//验证码类型verificationCodeType: 1注册,2忘记密码,3手机号认证,4修改手机号
    		String verificationCodeType = StrObject.getString("verificationCodeType");
    		if(StringUtils.isEmpty(verificationCodeType)){
    			value.setStatusCode(1);
    			value.setMessage("参数验证码类型【"+verificationCodeType+"】不能为空");
    			logger.info("参数验证码类型【"+verificationCodeType+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		/*先验证组织机构是否存在本系统中   begin*/
    		Integer orgId = Integer.valueOf(Constrants.DEFAULT_ORG);
			String orgPath = orgService.selectAllSharedOrg(orgId, true);
			if(StringUtils.isEmpty(orgPath)){
				value.setStatusCode(1);
    			value.setMessage("组织机构不存在");
    			logger.info("组织机构不存在");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
			}
    		/*先验证组织机构是否存在本系统中   end*/
			
			//1:注册；2忘记密码；3认证手机号；4修改手机号
			if(verificationCodeType.equals("4")){
				/* 发送验证码     begin */
		    	JSONResult<Object> codeValue = createAndSendVerificationCode(request,response);
		    	if(codeValue != null && codeValue.getStatusCode() != 0){
		    		value.setStatusCode(1);
		    		value.setMessage(codeValue.getMessage());
		    		logger.info(codeValue.getMessage());
		    		value.setSuccess(false);
		    		value.setData(codeValue.getData());
		    	}else{
		    		value.setStatusCode(0);
		    		value.setMessage("发送验证码成功");
		    		logger.info("发送验证码【"+codeValue.getData()+"】成功");
		    		value.setSuccess(true);
		    		value.setData(codeValue.getData());
		    	}
		    	/* 发送验证码     end */
			}else if(verificationCodeType.equals("3")){
				/* 发送认证手机号验证码   begin*/
				String userAccount = user.getUserAccount();
				logger.info("用户账号为【"+userAccount+"】");
				String oldPhone = memberAccountService.selectAccountByTypeAndAccount(userAccount, AccountTypeEnum.TEL);
				if(StringUtils.isEmpty(oldPhone) == false && oldPhone.equals(phoneNumber)== true){
					/* 发送验证码     begin */
    		    	JSONResult<Object> codeValue = createAndSendVerificationCode(request,response);
    		    	if(codeValue != null && codeValue.getStatusCode() != 0){
    		    		value.setStatusCode(1);
    		    		value.setMessage(codeValue.getMessage());
    		    		logger.info(codeValue.getMessage());
    		    		value.setSuccess(false);
    		    		value.setData(codeValue.getData());
    		    	}else{
    		    		value.setStatusCode(0);
    		    		value.setMessage("发送验证码成功");
    		    		logger.info("发送验证码【"+codeValue.getData()+"】成功");
    		    		value.setSuccess(true);
    		    		value.setData(codeValue.getData());
    		    	}
    		    	/* 发送验证码     end */
				}else{
    		    	/* 发送验证码     begin */
    		    	JSONResult<Object> codeValue = createAndSendVerificationCode(request,response);
    		    	if(codeValue != null && codeValue.getStatusCode() != 0){
    		    		value.setStatusCode(1);
    		    		value.setMessage(codeValue.getMessage());
    		    		logger.info(codeValue.getMessage());
    		    		value.setSuccess(false);
    		    		value.setData(codeValue.getData());
    		    	}else{
    		    		value.setStatusCode(0);
    		    		value.setMessage("发送验证码成功");
    		    		logger.info("发送验证码【"+codeValue.getData()+"】成功");
    		    		value.setSuccess(true);
    		    		value.setData(codeValue.getData());
    		    	}
    		    	/* 发送验证码     end */
				}
				/* 发送认证手机号验证码   end*/
				
			}else{
				/* 手机号认证接口"appserver":"存在";"null":"不存在"    begin */
				AppServer appServer = appMemberManager.checkAccount(phoneNumber);
				if(verificationCodeType.equals("1")){
					/* 发送注册验证码     begin */
					if(appServer == null){
        		    	/* 发送验证码     begin */
        		    	JSONResult<Object> codeValue = createAndSendVerificationCode(request,response);
        		    	if(codeValue != null && codeValue.getStatusCode() != 0){
        		    		value.setStatusCode(1);
        		    		value.setMessage(codeValue.getMessage());
        		    		logger.info(codeValue.getMessage());
        		    		value.setSuccess(false);
        		    		value.setData(codeValue.getData());
        		    	}else{
        		    		value.setStatusCode(0);
        		    		value.setMessage("发送验证码成功");
        		    		logger.info("发送验证码【"+codeValue.getData()+"】成功");
        		    		value.setSuccess(true);
        		    		value.setData(codeValue.getData());
        		    	}
        		    	/* 发送验证码     end */
        		    }else{
        		    	value.setStatusCode(9);
    		    		value.setMessage(MessageUtil.getValue("user.phone.has.registed"));
    		    		logger.info("该手机号【"+phoneNumber+"】已被注册");
    		    		value.setSuccess(false);
    		    		out.write(JSON.toJSONString(value));
    		    		return;
        		    }
					/* 发送注册验证码     end */
				 }else{
					 /* 发送忘记密码验证码     begin */
					 if(appServer != null){
						 /* 发送验证码     begin */
						 JSONResult<Object> codeValue = createAndSendVerificationCode(request,response);
	        		     if(codeValue != null && codeValue.getStatusCode() != 0){
	        		         value.setStatusCode(1);
	        		    	 value.setMessage(codeValue.getMessage());
	        		    	 logger.info(codeValue.getMessage());
	        		    	 value.setSuccess(false);
	        		    	 value.setData(codeValue.getData());
	        		     }else{
        		    		 value.setStatusCode(0);
        		    		 value.setMessage("发送验证码成功");
        		    		 logger.info("发送验证码【"+codeValue.getData()+"】成功");
        		    		 value.setSuccess(true);
        		    		 value.setData(codeValue.getData());
        		    	 }
	        		     /* 发送验证码     end */
        		     }else{
        		    	 value.setStatusCode(8);
    		    		 value.setMessage(MessageUtil.getValue("user.not.register"));
    		    		 logger.info("该手机号【"+phoneNumber+"】未认证");
    		    		 value.setSuccess(false);
    		    		 out.write(JSON.toJSONString(value));
    		    		 return;
        		     }
					 /* 发送忘记密码验证码     end */
				 }
				/* 手机号认证接口"appserver":"存在";"null":"不存在"    end */
			}
    	}catch(Exception e){
    		String errorMsg =  e.getMessage();
    		if(StringUtils.isEmpty(errorMsg) == false && (errorMsg.equals("服务器连接超时") || errorMsg.equals("服务器无结果返回"))){
    			value.setSuccess(false);
    			value.setStatusCode(1);
    			value.setMessage(errorMsg);
    			logger.error(errorMsg);
    		}else{
    			value.setStatusCode(2);
    			value.setMessage(MessageUtil.getValue("error.select.data"));
    			logger.info("获取验证码异常"+e);
    			value.setSuccess(false);
    		}
    	}
    	out.write(JSON.toJSONString(value));
	}
	
//	/**
//	 * @Description: 忘记密码，验证用户(姓名或者身份证)
//	 * @author:      liuxiaoqin
//	 * @version      V3.0  
//	 * @Createdate:  2016年12月06日 
//	 */
//	@RequestMapping(value = "/forgotPasswordThenCheckUser", method = RequestMethod.POST)
//    public void forgotPasswordThenCheckUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
//		PrintWriter out = response.getWriter();
//		JSONResult<Object> value = new JSONResult<Object>();
//    	try{
//    		String otherParam = (String)request.getAttribute("otherParamStr");
//    		JSONObject StrObject = JSON.parseObject(otherParam);
//    		String phoneNumber = StrObject.getString("phoneNumber");
//    		if(StringUtils.isEmpty(phoneNumber)){
//    			value.setStatusCode(1);
//    			value.setMessage("参数手机号【"+phoneNumber+"】不能为空");
//    			logger.info("参数手机号【"+phoneNumber+"】不能为空");
//    			value.setSuccess(false);
//    			out.write(JSON.toJSONString(value));
//    			return; 
//    		}
//    		String verificationCode = StrObject.getString("verificationCode");
//    		if(StringUtils.isEmpty(verificationCode)){
//    			value.setStatusCode(1);
//    			value.setMessage("参数验证码【"+verificationCode+"】不能为空");
//    			logger.info("参数验证码【"+verificationCode+"】不能为空");
//    			value.setSuccess(false);
//    			out.write(JSON.toJSONString(value));
//    			return; 
//    		}
//    		String userName = StrObject.getString("userName");
//    		String idcard = StrObject.getString("idcard");
//    		if(StringUtils.isEmpty(userName) == true && StringUtils.isEmpty(idcard)){
//    			value.setStatusCode(1);
//    			value.setMessage("参数用户名【"+userName+"】或者身份证号【"+idcard+"】必须输入一个");
//    			logger.info("参数用户名【"+userName+"】或者身份证号【"+idcard+"】必须输入一个");
//    			value.setSuccess(false);
//    			out.write(JSON.toJSONString(value));
//    			return; 
//    		}
//    		
//    		/* 验证验证码     begin */
//    		//验证码类型verificationCodeType: 1注册,2忘记密码,3手机号认证,4修改手机号
//    		request.setAttribute("verificationCodeType", "2");
//    		JSONResult<Object> codeValue = findVerificationCode(request,response);
//    		if(codeValue.getData() != null && ((String)codeValue.getData()).equals(verificationCode) == true){
//    			/* 调用检查用户接口     begin */
//    			String msg = null;
//    			if(StringUtils.isEmpty(msg)){
//    				value.setStatusCode(0);
//        			value.setMessage("确认成功");
//        			logger.info("确认成功");
//        			value.setSuccess(true);
//    			}else{
//    				value.setStatusCode(1);
//        			value.setMessage(msg);
//        			logger.info(msg);
//        			value.setSuccess(false);
//        			value.setData(msg);
//    			}
//    			/* 调用检查用户接口     end */
//    			
//    		}else{
//    			value.setStatusCode(1);
//    			value.setMessage(codeValue.getMessage());
//    			logger.info(codeValue.getMessage());
//    			value.setSuccess(false);
//    			out.write(JSON.toJSONString(value));
//    			return;
//    		}
//    		/* 验证验证码     end */
//    	}catch(Exception e){
//    		value.setStatusCode(2);
//    		value.setMessage(MessageUtil.getValue("error.select.data"));
//			logger.info("忘记密码，验证用户(姓名或者身份证)异常"+e);
//			value.setSuccess(false);
//    	}
//    	out.write(JSON.toJSONString(value));
//	}
	
	/**
	 * @Description: 忘记密码，重置密码
	 * @author:      liuxiaoqin
	 * @version      V3.0  
	 * @Createdate:  2016年12月06日 
	 */
	@RequestMapping(value = "/forgotThenResetPassword", method = RequestMethod.POST)
    public void forgotThenResetPassword(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String phoneNumber = StrObject.getString("phoneNumber");
    		if(StringUtils.isEmpty(phoneNumber)){
    			value.setStatusCode(1);
    			value.setMessage("参数手机号【"+phoneNumber+"】不能为空");
    			logger.info("参数手机号【"+phoneNumber+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		String verificationCode = StrObject.getString("verificationCode");
    		if(StringUtils.isEmpty(verificationCode)){
    			value.setStatusCode(1);
    			value.setMessage("参数验证码【"+verificationCode+"】不能为空");
    			logger.info("参数验证码【"+verificationCode+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		/* 验证验证码     begin */
    		//验证码类型verificationCodeType: 1注册,2忘记密码,3手机号认证,4修改手机号
    		request.setAttribute("verificationCodeType", "2");
    		JSONResult<Object> codeValue = findVerificationCode(request,response);
    		if(codeValue.getData() != null && ((String)codeValue.getData()).equals(verificationCode) == true){
    			/* 调用修改用户密码接口     begin */
    			String userPassword = StrObject.getString("userPassword");
        		if(StringUtils.isEmpty(userPassword)){
        			value.setStatusCode(1);
        			value.setMessage("参数密码【"+userPassword+"】不能为空");
        			logger.info("参数密码【"+userPassword+"】不能为空");
        			value.setSuccess(false);
        			out.write(JSON.toJSONString(value));
        			return; 
        		}
        		String newPassword = PasswordEncryption.getMD5Password(userPassword + "zkhk");
        		boolean ok = memberInterfService.updatePasswordByTel(phoneNumber, newPassword);
        		if(ok == false){
        			value.setStatusCode(1);
        			value.setMessage("会员重置密码成功 ");
        			logger.info("会员忘记密码重置密码成功 ");
        			value.setSuccess(false);
        		}else{
        			value.setStatusCode(0);
        			value.setMessage("会员重置密码成功 ");
        			logger.info("会员重置密码成功");
        			value.setSuccess(true);
        		}
    			/* 调用修改用户密码接口     end */
    		}else if(codeValue.getData() != null && ((String)codeValue.getData()).equals(verificationCode) == false){
    			value.setStatusCode(10);
    			value.setMessage(MessageUtil.getValue("verifyCodeError"));
    			logger.info("验证码【"+verificationCode+"】错误");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}else{
    			value.setStatusCode(1);
    			value.setMessage(codeValue.getMessage());
    			logger.info(codeValue.getMessage());
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}
    		/* 验证验证码     end */
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.update.data"));
			logger.info("忘记密码，重置密码异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 修改手机号
	 * @author:      liuxiaoqin
	 * @version      V3.0  
	 * @Createdate:  2016年12月06日 
	 */
	@RequestMapping(value = "/changeNewPhoneNumber", method = RequestMethod.POST)
    public void changeNewPhoneNumber(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		//是否为2次MD5后的密码：0 是；1不是
		int isNewUser = 0;
    	try{
    		JSONResult<Object> value = new JSONResult<Object>();
    		String appUser = (String)request.getAttribute("appUserStr");
        	AppUser user = JSON.parseObject(appUser, AppUser.class);
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String phoneNumber = StrObject.getString("phoneNumber");
    		if(StringUtils.isEmpty(phoneNumber)){
    			value.setStatusCode(1);
    			value.setMessage("参数手机号【"+phoneNumber+"】不能为空");
    			logger.info("参数手机号【"+phoneNumber+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		String userPassword = StrObject.getString("userPassword");
    		if(StringUtils.isEmpty(userPassword)){
    			value.setStatusCode(1);
    			value.setMessage("参数密码【"+userPassword+"】不能为空");
    			logger.info("参数密码【"+userPassword+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		String verificationCode = StrObject.getString("verificationCode");
    		if(StringUtils.isEmpty(verificationCode)){
    			value.setStatusCode(1);
    			value.setMessage("参数验证码【"+verificationCode+"】不能为空");
    			logger.info("参数验证码【"+verificationCode+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		
    		/* 验证验证码     begin */
    		//验证码类型verificationCodeType: 1注册,2忘记密码,3手机号认证,4修改手机号
    		request.setAttribute("verificationCodeType", "4");
    		JSONResult<Object> codeValue = findVerificationCode(request,response);
    		if(codeValue.getData() != null && ((String)codeValue.getData()).equals(verificationCode) == true){
    			/* 调用修改会员手机号接口     begin */
    			String newUser = (String)request.getAttribute("isNewUser");
    			if(StringUtils.isEmpty(newUser)){
    				userPassword = PasswordEncryption.getMD5Password(userPassword+"zkhk");
    			}else{
    				isNewUser = 1;
    			}
    			boolean isSuccess = appMemberManager.changeTelByPwd(phoneNumber, user.getUserAccount(), userPassword);
    			if(isSuccess == true){
    				value.setStatusCode(0);
        			value.setMessage("修改成功");
        			logger.info("修改成功");
        			value.setSuccess(true);
        			value.setData(phoneNumber);
        			out.write(JSON.toJSONString(value));
        			return;
    			}else{
    				value.setStatusCode(1);
        			value.setMessage("修改失败");
        			logger.info("修改失败");
        			value.setSuccess(false);
        			out.write(JSON.toJSONString(value));
        			return;
    			}
    			/* 调用修改会员手机号接口     end */
    			
    		}else if(codeValue.getData() != null && ((String)codeValue.getData()).equals(verificationCode) == false){
    			value.setStatusCode(10);
    			value.setMessage(MessageUtil.getValue("verifyCodeError"));
    			logger.info("验证码【"+verificationCode+"】错误");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}else{
    			value.setStatusCode(1);
    			value.setMessage(codeValue.getMessage());
    			logger.info(codeValue.getMessage());
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}
    		/* 验证验证码     end */
    	}catch(BusinessException e){
    		String errorMsg = e.getMessage();
			if(StringUtils.isEmpty(errorMsg) == false && errorMsg.equals("抱歉，密码输入错误 请稍后再试或与管理员联系！") == true &&  isNewUser == 0){
				request.setAttribute("isNewUser", "Y");
				changeNewPhoneNumber(request,response);
			}else{
				JSONResult<Object> value = new JSONResult<Object>();
				if(StringUtils.isEmpty(errorMsg) == false && errorMsg.equals("抱歉，密码输入错误 请稍后再试或与管理员联系！") == true){
					value.setStatusCode(1);
		    		value.setMessage(errorMsg);
				}else{
					value.setStatusCode(2);
		    		value.setMessage(MessageUtil.getValue("error.update.data"));
				}
				logger.info("修改手机号异常"+errorMsg);
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
			}
    	}
	}
	
	/**
	 * @Description: 注册成功后完善资料
	 * @author:      liuxiaoqin
	 * @version      V3.0  
	 * @Createdate:  2016年12月13日 
	 */
	@RequestMapping(value = "/completeInformation", method = RequestMethod.POST)
    public void completeInformation(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
    		String appUser = (String)request.getAttribute("appUserStr");
        	AppUser user = JSON.parseObject(appUser, AppUser.class);
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String phoneNumber = StrObject.getString("phoneNumber");
    		if(StringUtils.isEmpty(phoneNumber)){
    			value.setStatusCode(1);
    			value.setMessage("参数手机号【"+phoneNumber+"】不能为空");
    			logger.info("参数手机号【"+phoneNumber+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		String idcard = StrObject.getString("idcard");
    		if(StringUtils.isEmpty(idcard)){
    			value.setStatusCode(1);
    			value.setMessage("参数身份证号【"+idcard+"】不能为空");
    			logger.info("参数身份证号【"+idcard+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		String userName = StrObject.getString("userName");
    		if(StringUtils.isEmpty(userName)){
    			value.setStatusCode(1);
    			value.setMessage("参数用户名【"+userName+"】不能为空");
    			logger.info("参数用户名【"+userName+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		/*如果是后台注册的会员，直接完善资料    begin*/
    		boolean isFromWeb = memberInterfService.isFromWeb(user.getUserGUID()); 
    		if(isFromWeb == true){
    			String result = memberInterfService.perfectMember(phoneNumber, userName, idcard);
    			if(result == null){
					value.setStatusCode(0);
        			value.setMessage("完善资料成功");
        			logger.info("完善资料成功");
        			value.setSuccess(true);
        			out.write(JSON.toJSONString(value));
        			return;
				}else{
					value.setStatusCode(1);
        			value.setMessage(result);
        			logger.info(result);
        			value.setSuccess(false);
        			out.write(JSON.toJSONString(value));
        			return;
				}
    		}
			/*如果是后台注册的会员，直接完善资料    end*/
    		
    		/* 验证是否可以合并资料     begin */
    		CheckResult checkResult = appMemberManager.checkMerge(idcard, phoneNumber, userName);
    		if(checkResult != null){
    			MergeResult mergeResult = new MergeResult();
    			if(Constants.MERGE_DIRECT == checkResult.getCode()){
    				/* 9999-新会员，直接可以保存    */
    				MergerDetail detail = checkResult.getContent();
    				Member member = new Member();
    				member.setIdcard(idcard);
    				member.setTel(phoneNumber);
    				member.setMemname(userName);
    				member.setMemberGUID(user.getUserGUID());
    				mergeResult = memberInterfService.merge(detail.getSourceGuid(), detail.getSourceSrvId(), detail.getSourceSessionID(),user.getUserPassword(), member);
    			}else if(Constants.MERGE_MAY == checkResult.getCode()){
    				/*8888-存在可以合并会员     begin */
    				MergerDetail detail = checkResult.getContent();
    				Member member = new Member();
    				member.setIdcard(idcard);
    				member.setTel(phoneNumber);
    				member.setMemname(userName);
    				member.setMemberGUID(detail.getTargetGuid());
    				Map<String,Object> map = new HashMap<String, Object>();
        			map.put("sourceMember",member);
        			map.put("detail", detail);
        			request.setAttribute("otherParamStr", JSON.toJSONString(map));
        			//调用特殊合并方法
        			updateSpecialInfomation(request,response);
        			return;
    			}else if(Constants.MERGE_NEED_CONFIRM == checkResult.getCode()){
    				/*存在简码相同会员，需页面确定再合并     begin */
    				value.setStatusCode(12);
        			value.setMessage(MessageUtil.getValue("mergeConfirmName"));
        			logger.info("存在简码相同会员，需页面确定再合并");
        			value.setSuccess(false);
        			MergerDetail detail = checkResult.getContent();
    				Member member = new Member();
    				member.setIdcard(idcard);
    				member.setTel(phoneNumber);
    				member.setMemname(userName);
    				member.setMemberGUID(detail.getTargetGuid());
    				Map<String,Object> map = new HashMap<String, Object>();
        			map.put("sourceMember",member);
        			map.put("detail", detail);
        			value.setData(map);
        			out.write(JSON.toJSONString(value));
        			return;
    			}else if(Constants.MERGE_SERVICE_CONTACT == checkResult.getCode()){
    				/* 需要联系客服     begin */
    				value.setStatusCode(13);
        			value.setMessage(MessageUtil.getValue("mergeContactService"));
        			logger.info("需要联系客服");
        			value.setSuccess(false);
        			out.write(JSON.toJSONString(value));
        			return;
    			}else{
    				String errorMsg = checkResult.getMessage();
    				if(errorMsg.equals(MessageUtil.getValue("user.idcard.exist"))){
    					errorMsg = MessageUtil.getValue("user.has.exist");
    				}
    				value.setStatusCode(1);
        			value.setMessage(errorMsg);
        			logger.info(errorMsg);
        			value.setSuccess(false);
        			out.write(JSON.toJSONString(value));
        			return;
    			}
    			if(mergeResult != null && mergeResult.getCode() == 0){
    				value.setStatusCode(0);
        			value.setMessage("合并资料成功");
        			logger.info("合并资料成功");
        			value.setSuccess(true);
    			}else{
    				value.setStatusCode(1);
        			value.setMessage(mergeResult.getMsg());
        			logger.info(mergeResult.getMsg());
        			value.setSuccess(false);
    			}
    			/* 调用本系统合并资料接口     end */
    		}else{
    			value.setStatusCode(1);
    			value.setMessage("验证是否可以合并资料失败");
    			logger.info("验证是否可以合并资料失败");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}
    		/* 验证是否可以合并资料     end */
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.update.data"));
			logger.info("注册成功后完善资料异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	
	
	/**
	 * @Description: 认证手机号为账号
	 * @author:      liuxiaoqin
	 * @version      V3.0  
	 * @Createdate:  2016年12月06日 
	 */
	@RequestMapping(value = "/authenticationPhoneNumber", method = RequestMethod.POST)
    public void authenticationPhoneNumber(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
    		String appUser = (String)request.getAttribute("appUserStr");
        	AppUser user = JSON.parseObject(appUser, AppUser.class);
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String phoneNumber = StrObject.getString("phoneNumber");
    		if(StringUtils.isEmpty(phoneNumber)){
    			value.setStatusCode(1);
    			value.setMessage("参数手机号【"+phoneNumber+"】不能为空");
    			logger.info("参数手机号【"+phoneNumber+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		String verificationCode = StrObject.getString("verificationCode");
    		if(StringUtils.isEmpty(verificationCode)){
    			value.setStatusCode(1);
    			value.setMessage("参数验证码【"+verificationCode+"】不能为空");
    			logger.info("参数验证码【"+verificationCode+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		
    		/* 验证验证码     begin */
    		//验证码类型verificationCodeType: 1注册,2忘记密码,3手机号认证,4修改手机号
    		request.setAttribute("verificationCodeType", "3");
    		JSONResult<Object> codeValue = findVerificationCode(request,response);
    		if(codeValue.getData() != null && ((String)codeValue.getData()).equals(verificationCode) == true){
    			/* 调用认证用户手机号为账号方法     begin */
    			try{
    				boolean isOk = appMemberManager.verifyTel(phoneNumber, user.getUserAccount());
        			if(isOk == true){
        				logger.info("手机号【"+phoneNumber+"】认证成功");
        				value.setStatusCode(0);
            			value.setMessage("认证成功");
            			value.setSuccess(true);
        			}else{
        				value.setStatusCode(1);
            			value.setMessage("认证失败");
            			logger.info("手机号【"+phoneNumber+"】认证失败");
            			value.setSuccess(false);
        			}
    			}catch(BusinessException be){
    				value.setStatusCode(2);
        			value.setMessage(be.getMessage());
        			logger.info(be.getMessage());
        			value.setSuccess(false);
        			out.write(JSON.toJSONString(value));
        			return;
    			}
    			
    			/* 调用认证用户手机号为账号方法     end */
    			
    		}else if(codeValue.getData() != null && ((String)codeValue.getData()).equals(verificationCode) == false){
    			value.setStatusCode(10);
    			value.setMessage(MessageUtil.getValue("verifyCodeError"));
    			logger.info("验证码【"+verificationCode+"】错误");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}else{
    			value.setStatusCode(1);
    			value.setMessage(codeValue.getMessage());
    			logger.info(codeValue.getMessage());
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}
    		/* 验证验证码     end */
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("忘记密码，验证用户(姓名或者身份证)异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 根据手机号获取正确的appserver的地址
	 * @author:      liuxiaoqin
	 * @version      V3.0  
	 * @Createdate:  2016年12月23日 
	 */
	@RequestMapping(value = "/findAppserverUrlByPhoneNumber", method = RequestMethod.POST)
    public void selectAppserverUrlByPhoneNumber(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
//    		String appUser = (String)request.getAttribute("appUserStr");
//        	AppUser user = JSON.parseObject(appUser, AppUser.class);
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String phoneNumber = StrObject.getString("phoneNumber");
    		if(StringUtils.isEmpty(phoneNumber)){
    			value.setStatusCode(1);
    			value.setMessage("参数手机号【"+phoneNumber+"】不能为空");
    			logger.info("参数手机号【"+phoneNumber+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		/* 手机号认证接口"appserver":"存在";"null":"不存在"    begin */
		    AppServer appServer = appMemberManager.checkAccount(phoneNumber);
		    if(appServer != null){
		    	value.setStatusCode(0);
	    		value.setMessage("获取appserver的url成功");
	    		logger.info("获取appserver的url【"+appServer.getServerID()+"】成功");
	    		value.setSuccess(true);
	    		Map<String,Object> map = new HashMap<String, Object>();
	    		map.put("serverId", appServer.getServerID());
	    		map.put("url", appServer.getUrl());
	    		value.setData(map);
		    }else{
		    	 value.setStatusCode(8);
	    		 value.setMessage(MessageUtil.getValue("user.not.register"));
	    		 logger.info("该手机号【"+phoneNumber+"】未认证");
	    		 value.setSuccess(false);
	    		 out.write(JSON.toJSONString(value));
	    		 return;
		    }
		    
		/* 手机号认证接口"appserver":"存在";"null":"不存在"     end */
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("忘记密码，验证用户(姓名或者身份证)异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 状态码为8888,6666的需要确认url是否一致
	 * @author:      liuxiaoqin
	 * @version      V3.0  
	 * @Createdate:  2016年12月28日 
	 */
	@RequestMapping(value = "/mergeSpecialInfomation", method = RequestMethod.POST)
	public void updateSpecialInfomation(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
    		String appUser = (String)request.getAttribute("appUserStr");
        	AppUser user = JSON.parseObject(appUser, AppUser.class);
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String detailStr = StrObject.getString("detail");
    		MergerDetail detail = JSON.parseObject(detailStr, MergerDetail.class);
    		String sourceMemberStr = StrObject.getString("sourceMember");
    		Member sourceMember = JSON.parseObject(sourceMemberStr, Member.class);
    		MergeResult mergeResult = new MergeResult();
    		if(detail.getSourceSrvId() == detail.getTargetSrvId()){
    			sourceMember.setMemberGUID(detail.getTargetGuid());
				mergeResult = memberInterfService.merge(detail.getSourceGuid(), detail.getSourceSrvId(), detail.getSourceSessionID(),user.getUserPassword(), sourceMember);
				if(!(detail.getSourceGuid()).equals(detail.getTargetGuid())){
					if(mergeResult != null && mergeResult.getCode() == 0){
						/*开始删除原服务器用户资料    begin*/
	        			Integer count = appMemberManager.deleteSourceMemberAfterMerge(detail.getSourceGuid());
	        			if(count != null && count >0){
	        				logger.info("删除原服务器上用户账号【"+ user.getUserAccount()+ "】 GUID【"+ detail.getSourceGuid()+"】的会员成功");
	        			}else{
	        				logger.info("删除原服务器上用户账号【"+ user.getUserAccount()+ "】 GUID【"+ detail.getSourceGuid()+"】的会员失败");
	        			}
	        			/*开始删除原服务器用户资料    end*/
					}
				}
			}else{
				//重新定向到新的appserver地址
				String newAddress = detail.getTargetAppSrvUrl() + "member/mergeInfomation";
				Parameter parameter = new Parameter();
				parameter.setMethod(RequestMethodEnum.POST);
				Map<String, CharSequence> param = new HashMap<String, CharSequence>();
				//head
				Map<String,Object> head = new HashMap<String, Object>();
				head.put("session", user.getSession());
				//content
				Map<String,Object> content = new HashMap<String, Object>();
				content.put("memberGuid", detail.getSourceGuid());
				content.put("serverId", detail.getSourceSrvId());
				content.put("idcard", sourceMember.getIdcard());
				content.put("userName", sourceMember.getMemname());
				content.put("phoneNumber", sourceMember.getTel());
				content.put("sessionId", user.getSession());
				content.put("userPassword", user.getUserPassword());
				content.put("tarServerId", String.valueOf(detail.getTargetSrvId()));
				content.put("tarMemberGuid", detail.getTargetGuid());
				Map<String,Object> newMap = new HashMap<String, Object>();
				newMap.put("head", head);
				newMap.put("content", content);
				param.put("params", JSONObject.toJSONString(newMap));
				parameter.setParam(param);
				parameter.setHost(Constrants.DNS);
				Response newResponse = HttpUtils.sendPost(newAddress, parameter.getParam(), parameter.getHost());
				if(newResponse != null && newResponse.getStatus() == 200){
					Integer statusCode = JSON.parseObject(newResponse.getBody()).getInteger("statusCode");
					if(statusCode != null && statusCode == 0){
						Map<String,Object> userMap = new HashMap<String, Object>();
						userMap.put("targetAppSrvUrl", detail.getTargetAppSrvUrl());
						String userData = JSON.parseObject(newResponse.getBody()).getString("data");
						AppUser tarUser = JSON.parseObject(userData, AppUser.class);
						tarUser.setDeviceType(user.getDeviceType());
						tarUser.setVersion(user.getVersion());
						tarUser.setLogTime(user.getLogTime());
						tarUser.setUserType(1);
						tarUser.setUserGUID(detail.getTargetGuid());
						tarUser.setUserName(sourceMember.getMemname());
						userMap.put("appUser", tarUser);
						userMap.put("idcard", sourceMember.getIdcard());
						value.setData(userMap);
						value.setStatusCode(0);
	        			value.setMessage("合并资料成功");
	        			logger.info("合并资料成功");
	        			value.setSuccess(true); 
	        			out.write(JSON.toJSONString(value));
	        			/*开始删除原服务器用户资料    begin*/
	        			Integer count = appMemberManager.deleteSourceMemberAfterMerge(detail.getSourceGuid());
	        			if(count != null && count >0){
	        				logger.info("删除原服务器上用户账号【"+ user.getUserAccount()+ "】 GUID【"+ detail.getSourceGuid()+"】的会员成功");
	        			}else{
	        				logger.info("删除原服务器上用户账号【"+ user.getUserAccount()+ "】 GUID【"+ detail.getSourceGuid()+"】的会员失败");
	        			}
	        			/*开始删除原服务器用户资料    end*/
	        			
	        			/*开始同步数据 begin*/
	        			MemberMerge model = new MemberMerge();
	        			model.setTargetMemberID(detail.getTargetGuid());
	        			model.setTargetServiceID(detail.getTargetSrvId());
	        			model.setCreateTime(new Date());
	        			model.setSyncStatus(Constants.MERGE_SYNC_STATUS);
	        			model.setSourceMemberID(detail.getSourceGuid());
	        			model.setSourceServiceID(detail.getSourceSrvId());
	        			model.setModuleType(Constants.MERGE_MODULETYPE_MEASURE);
	        			memberMergeService.insert(model);
	        			model.setModuleType(Constants.MERGE_MODULETYPE_FRIEND);
	        			memberMergeService.insert(model);
//	        			model.setModuleType(Constants.MERGE_MODULETYPE_PAPER);
//	        			memberMergeService.insert(model);
	        			/*开始同步数据 end*/
	        			return;
					}else{
						String errorStr = JSON.parseObject(newResponse.getBody()).getString("message");
						value.setStatusCode(1);
	        			value.setMessage(errorStr);
	        			logger.info(errorStr);
	        			value.setSuccess(false);
	        			out.write(JSON.toJSONString(value));
	        			return;
					}
					
				}else{
					value.setStatusCode(1);
        			value.setMessage(newResponse.getError());
        			logger.info(newResponse.getError());
        			value.setSuccess(false);
        			out.write(JSON.toJSONString(value));
        			return;
				}
			}
    		if(mergeResult != null && mergeResult.getCode() == 0){
    			Map<String,Object> userMap = new HashMap<String, Object>();
    			AppUser tarUser = new AppUser();
    			tarUser.setUserPassword(mergeResult.getPassword());
    			tarUser.setUserId(Integer.valueOf(mergeResult.getGuid()));
    			tarUser.setSession(mergeResult.getSessionId());
				tarUser.setDeviceType(user.getDeviceType());
				tarUser.setVersion(user.getVersion());
				tarUser.setLogTime(user.getLogTime());
				tarUser.setUserAccount(sourceMember.getTel());
				tarUser.setUserType(1);
				tarUser.setUserGUID(detail.getTargetGuid());
				tarUser.setUserName(sourceMember.getMemname());
				userMap.put("appUser", tarUser);
				value.setData(userMap);
				value.setStatusCode(0);
    			value.setMessage("合并资料成功");
    			logger.info("合并资料成功");
    			value.setSuccess(true);
			}else{
				value.setStatusCode(1);
    			value.setMessage(mergeResult.getMsg());
    			logger.info(mergeResult.getMsg());
    			value.setSuccess(false);
			}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.update.data"));
			logger.info("合并资料异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 
	 * @author:      liuxiaoqin
	 * @version      V3.0  
	 * @Createdate:  2016年12月06日 
	 */
	@RequestMapping(value = "/mergeInfomation", method = RequestMethod.POST)
	public void mergeInfomation(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String result = "";
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String memberGuid = StrObject.getString("memberGuid");
    		int serverId = Integer.valueOf(StrObject.getString("serverId"));
    		String idcard = StrObject.getString("idcard");
    		String userName = StrObject.getString("userName");
    		String phoneNumber = StrObject.getString("phoneNumber");
    		String sessionId = StrObject.getString("sessionId");
    		String tarMemberGuid = StrObject.getString("tarMemberGuid");
    		String userPassword = StrObject.getString("userPassword");
    		Member member = new Member();
    		member.setIdcard(idcard);
    		member.setMemname(userName);
    		member.setTel(phoneNumber);
    		member.setMemberGUID(tarMemberGuid);
    		MergeResult mergeResult = new MergeResult();
			mergeResult = memberInterfService.merge(memberGuid, serverId, sessionId, userPassword,member);
			if(mergeResult != null && mergeResult.getCode() == 0){
				AppUser user = new AppUser();
				user.setUserName(userName);
				user.setUserPassword(mergeResult.getPassword());
				user.setUserId(Integer.valueOf(mergeResult.getGuid()));
				user.setSession(mergeResult.getSessionId());
				user.setUserAccount(phoneNumber);
				value.setStatusCode(0);
    			value.setMessage("跨服务器合并资料成功");
    			logger.info("跨服务器合并资料成功");
    			value.setSuccess(true);
    			value.setData(user);
			}else{
				value.setStatusCode(1);
    			value.setMessage(mergeResult.getMsg());
    			logger.info(mergeResult.getMsg());
    			value.setSuccess(false);
			}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("跨服务器合并资料异常"+e);
			value.setSuccess(false);
    	}
    	result = JSON.toJSONString(value);
    	PrintWriter p = response.getWriter();
    	logger.info("result"+result);
    	p.write(result);
//    	p.close();
//		return result;
	}
	
	/**
	 * @Description: 获取邀请好友短信内容
	 * @author:      liuxiaoqin
	 * @version      V3.0  
	 * @Createdate:  2017年1月3日 
	 */
	@RequestMapping(value = "/selectInviteMemberPage", method = RequestMethod.POST)
	public void selectInviteMemberPage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
    		String appUser = (String)request.getAttribute("appUserStr");
        	AppUser user = JSON.parseObject(appUser, AppUser.class);
        	String userName = user.getUserName();
        	String inviteContent = userName + MessageUtil.getValue("inviteContent") + MessageUtil.getValue("inviteUrl");
        	value.setData(inviteContent);
        	value.setStatusCode(0);
			value.setMessage("获取邀请好友短信内容成功");
			logger.info("获取邀请好友短信内容成功");
			value.setSuccess(true);
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("获取邀请好友短信内容异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
}
