package com.bithealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.bithealth.memberCore.enmu.DeviceEnum;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.exception.LoginException;
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
import com.bithealth.model.AppUser;
import com.bithealth.orgainCore.model.OrgConfig;
import com.bithealth.orgainCore.model.OrgConfigExample;
import com.bithealth.orgainCore.service.OrgConfigService;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
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
    private MemberAccountService memberAccountService;
	
	@Resource
    private MemFamilyCardService memFamilyCardService;
	
	@Resource
    private OrgConfigService orgConfigService;
	
	private static Logger logger = Logger.getLogger(MemberController.class);
	
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
			/*tv登录验证是否是有效智能卡   begin*/
			MemAccount newAccount = memberAccountService.selectByAccount(user.getUserAccount());
			if(newAccount != null){
				MemFamilyCardExample example = new MemFamilyCardExample();
				example.createCriteria().andMemberidEqualTo(newAccount.getMemberid());
				List<MemFamilyCard> list =  memFamilyCardService.selectByExample(example);
				if(list == null || list.size() == 0){
					value.setStatusCode(1);
		    		value.setMessage(MessageUtil.getValue("tvLogin.promptMessage"));
					logger.info(user.getUserAccount() + "的智能卡账号不存在,登陆失败");
					value.setSuccess(false);
					out.write(JSON.toJSONString(value));
					return;
				}
			}else{
				value.setStatusCode(1);
	    		value.setMessage(MessageUtil.getValue("tvLogin.promptMessage"));
				logger.info(user.getUserAccount() + "的智能卡账号不存在,登陆失败");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
			}
			/*tv登录验证是否是有效智能卡   end*/
			String newewUser = (String)request.getAttribute("isNewUser");
			if(StringUtils.isEmpty(newewUser)){
				password = PasswordEncryption.getMD5Password(user.getUserPassword()+"zkhk");
			}else{
				isNewUser = 1;
			}
			MemAccount account = memberInterfService.login(user.getUserAccount(),password,deviceType);
			if(account != null){
				/* 验证体验时间是否失效  begin*/
				OrgConfigExample example = new OrgConfigExample();
				example.createCriteria().andOrgIDEqualTo(account.getMember().getOrgid()).andMemIdEqualTo(account.getMember().getMemid());
				List<OrgConfig> orgConfigList = orgConfigService.selectByExample(example);
				if(orgConfigList != null && orgConfigList.size() >0){
					OrgConfig orgConfig = orgConfigList.get(0);
					if(orgConfig != null && orgConfig.getExperienceDay() != 0 && orgConfig.getCreateTime()!= null){
						Date currentDate = new Date();
						//失效日期
						Calendar calendar = Calendar.getInstance();  
						calendar.setTime(orgConfig.getCreateTime());
						calendar.add(Calendar.DAY_OF_MONTH, orgConfig.getExperienceDay());
						Date invalidDate = calendar.getTime();
						if(TimeUtil.isBefore(invalidDate,currentDate)){
							value.setStatusCode(1);
				    		value.setMessage(MessageUtil.getValue("tvLogin.experiencePromptMessage"));
							logger.info(user.getUserAccount() + "体验已到期");
							value.setSuccess(false);
							out.write(JSON.toJSONString(value));
							return;
						}
					}
				}
				/* 验证体验时间是否失效  end*/
				String userName = account.getMember().getMemname();
				Date logTime = account.getMemberSession().getLogintime();
				if(logTime != null){
					user.setLogTime(TimeUtil.formatDatetime2(logTime));
				}
				user.setSession(account.getMemberSession().getSession());
				user.setUserId(account.getMemberid());
				user.setUserName(userName);
				user.setUserGUID(account.getMember().getMemberGUID());
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
	
}
