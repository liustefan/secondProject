/**
 * @PackageName:      com.bithealth.task
 * @FileName:     UpdateMemberTask.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月5日 下午3:52:07  
 * 
 */
package com.bithealth.task;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.bithealth.Constrants;
import com.bithealth.excel.ExcelUtil;
import com.bithealth.memberCore.facede.service.MemberImportService;
import com.bithealth.memberCore.facede.service.MemberInterfService;
import com.bithealth.memberCore.member.model.DiseasesHistory;
import com.bithealth.memberCore.member.model.MemImportLog;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.service.DiseaseService;
import com.bithealth.memberCore.member.service.MemImportLogService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.vo.MemberEquals;
import com.bithealth.orgainCore.model.OrgConfig;
import com.bithealth.orgainCore.service.OrgConfigService;
import com.bithealth.sdk.common.utils.CheckIdCard;
import com.bithealth.sdk.common.utils.PinYinUtil;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.common.utils.ValidateUtil;
import com.bithealth.sdk.web.beanutils.BeanUtils;
import com.bithealth.sdk.web.vo.ShiroUser;
import com.bithealth.util.MemMustItemUtil;
import com.bithealth.vo.MemberImportBean;

/**
 * 类名称: UpdateMemberTask  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月5日 下午3:52:07 
 * 
 * @author liuhm
 * @version  
 */
 @Service
public class UpdateMemberTask {
	   private final static Logger log = Logger.getLogger(UpdateMemberTask.class);
	 
	   @Resource(name="diseaseService")
		private DiseaseService diseaseService;
		
		@Resource(name="memberInterfService")
		private MemberInterfService memberInterfService;
		
		@Autowired
		private MemberImportService memberImportService;
		
		@Resource(name="memberService")
		private MemberService memberService;
		
		@Autowired
		private DeleteFileTask deleteFileTask;
		
		@Autowired
		private MemImportLogService logService;
		
		@Autowired
		private OrgConfigService configService;
	 
	   @Autowired
	   private TaskExecutor taskExecutor;
	 
	 public void readFile(final File file, final String grpIds, final ShiroUser user) throws Exception {
		 taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					List<LinkedHashMap<String, String>> dataList = ExcelUtil.readExcel(file);
					List<MemberExt> errorList = new ArrayList<MemberExt>();  //需要写入Excel的出错会员数据
					MemberEquals<MemberExt> bean = parse(dataList, grpIds, errorList, user);   //转换并过滤本文件中重复的身份证会员数据
					List<MemberExt> insertMember = bean.getResult().get(MemberEquals.FINAL);      //可以注册的会员数据
					errorList.addAll(setMemLog(bean.getResult().get(MemberEquals.DUPLICATE)));   //身份证号重复的会员数据
					if(insertMember.size() > 0) {
						try {
							memberInterfService.insertMember(insertMember, true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					 }
					 memberImportService.insertErrorData(errorList);
				} catch (Exception e) {
					log.error("导入会员出错：" + e.getMessage());
				}finally{
					file.delete();
				}
				
			}
		});
	 }
	 
	 private List<MemberExt> setMemLog(List<MemberExt> memberList) {
			if(memberList.size() > 0) {
				for(MemberExt member : memberList) {
					MemImportLog importLog = member.getImportLog();
					if(importLog != null) {
						importLog.setReason(importLog.getReason() + "；身份证或者姓名和手机号重复" );
					} else {
						importLog = new MemImportLog();
						importLog.setReason( "身份证或者姓名和手机号重复" );
					}
				}
			}
			return memberList;
		}
	 
	 private MemberEquals<MemberExt> parse(List<LinkedHashMap<String, String>> dataList, String groupId, 
			 List<MemberExt> errorList, ShiroUser user) {
			MemberEquals<MemberExt> memberEqual = new MemberEquals<MemberExt>();
			MemberImportBean bean = null;
			String[] fields = Constrants.FIELDS;
			String[] headers = Constrants.HEADER;
			OrgConfig config = configService.selectByOrgId(user.getDept_id());
			for(LinkedHashMap<String, String> data : dataList) {
				bean = new MemberImportBean();
				int fieldCount = fields.length;
				for(int index = 0; index < fieldCount; index++) {
					BeanUtils.setProperty(bean, fields[index], data.get(headers[index]));
				}
				String msg = checkData(bean);
				DiseasesHistory disease = null;
				List<DiseasesHistory> diseases = new ArrayList<DiseasesHistory>();
				for(int index = fieldCount; index < headers.length; index++){ //疾病
					if("有".equals(data.get(headers[index]))) {
						disease = new DiseasesHistory();
						disease.setDiseasename(headers[index]);
						disease.setDiseaseid(diseaseService.selectDiseaseId_cache(headers[index]));
						diseases.add(disease);
					}
				}
				bean.setDiseaseList(diseases);
				MemberExt member = bean.convertToMember(bean, groupId);
				String isExist = memberImportService.exist(member);
				if(StringUtil.isNotEmpty(isExist)) {
					msg = StringUtil.isEmpty(msg) ? isExist : (";" + isExist);
				}
				member.setOrgid(user.getDept_id());
				member.setDocid(user.getId());
				member.setDocname(user.getRealName());
				MemImportLog importLog = new MemImportLog();
				if(StringUtil.isNotEmpty(msg)) {
					importLog.setReason(msg);
					member.setImportLog(importLog);
					if(config != null) {
						member.setMemid(config.getMemId());  //设置默认会员类型
						msg = MemMustItemUtil.must(config.settings(), member);
						if(StringUtil.isNotEmpty(msg)) {
							importLog.setReason(msg);
							 member.setImportLog(importLog);
						}
					}
					errorList.add(member);
				} else {
				    if(StringUtil.isNotEmpty(member.getMemname())) {
				    	member.setMemNameCode(PinYinUtil.getPinYinHeadChar(member.getMemname()));
				    }
					if(config != null) {
						member.setMemid(config.getMemId());  //设置默认会员类型
						msg = MemMustItemUtil.must(config.settings(), member);
						if(StringUtil.isNotEmpty(msg)) {
							importLog.setReason(msg);
							member.setImportLog(importLog);
							errorList.add(member);
						} else {
							memberEqual.add(member);
						}
					} else {
						memberEqual.add(member);
					}
				}
			}
			return memberEqual;
		}
		
		private String checkData(MemberImportBean bean) {
			StringBuilder msg = new StringBuilder();
			if(StringUtil.isNotEmpty(bean.getLdlip()) && !ValidateUtil.checkNumber(bean.getLdlip())) {
				bean.setLdlip("");
//				msg.insert(0, bean.getFieldChinDesc("ldlip") + "应为整数或小数；");
			}
			if(StringUtil.isNotEmpty(bean.getDensitylipop()) && !ValidateUtil.checkNumber(bean.getDensitylipop())) {
				bean.setDensitylipop("");
//				msg.insert(0, bean.getFieldChinDesc("densitylipop") + "应为整数或小数；");
			}
			
			if(StringUtil.isNotEmpty(bean.getTotalcholesterol()) && !ValidateUtil.checkNumber(bean.getTotalcholesterol())) {
				bean.setTotalcholesterol("");
//				msg.insert(0, bean.getFieldChinDesc("totalcholesterol") + "应为整数或小数；");
			}
			
			if(StringUtil.isNotEmpty(bean.getUricacid()) && !ValidateUtil.checkInteger(bean.getUricacid())) {
				bean.setUricacid("");
//				msg.insert(0, bean.getFieldChinDesc("uricacid") + "应为整数；");
			}
			
			if(StringUtil.isNotEmpty(bean.getFastingglucose()) && !ValidateUtil.checkNumber(bean.getFastingglucose())) {
				bean.setFastingglucose("");
//				msg.insert(0, bean.getFieldChinDesc("fastingglucose") + "应为整数或小数；");
			}
			
			if(StringUtil.isNotEmpty(bean.getBloodL()) && !ValidateUtil.checkInteger(bean.getBloodL())) {
				bean.setBloodL("");
//				msg.insert(0, bean.getFieldChinDesc("bloodL") + "应为整数；");
			}
			
			if(StringUtil.isNotEmpty(bean.getBloodH()) && !ValidateUtil.checkInteger(bean.getBloodH())) {
				bean.setBloodH("");
//				msg.insert(0, bean.getFieldChinDesc("bloodH") + "应为整数；");
			}
			
			if(StringUtil.isNotEmpty(bean.getTriglyceride()) && !ValidateUtil.checkNumber(bean.getTriglyceride())) {
				bean.setTriglyceride("");
//				msg.insert(0, bean.getFieldChinDesc("triglyceride") + "应为整数或小数；");
			}
			
			if(StringUtil.isNotEmpty(bean.getHeartRate()) && !ValidateUtil.checkInteger(bean.getHeartRate())) {
				bean.setHeartRate("");
//				msg.insert(0, bean.getFieldChinDesc("heartRate") + "应为整数；");
			}
			
			if(StringUtil.isNotEmpty(bean.getPulse()) && !ValidateUtil.checkInteger(bean.getPulse())) {
				bean.setPulse("");
//				msg.insert(0, bean.getFieldChinDesc("pulse") + "应为整数；");
			}
			
			if(StringUtil.isNotEmpty(bean.getHipline()) && !ValidateUtil.checkInteger(bean.getHipline())) {
				bean.setHipline("");
//				msg.insert(0, bean.getFieldChinDesc("hipline") + "应为整数；");
			}
			
			if(StringUtil.isNotEmpty(bean.getWaistline()) && !ValidateUtil.checkInteger(bean.getWaistline())) {
				bean.setWaistline("");
//				msg.insert(0, bean.getFieldChinDesc("waistline") + "应为整数；");
			}
			
			if(StringUtil.isNotEmpty(bean.getHeight()) && !ValidateUtil.checkInteger(bean.getHeight())) {
				bean.setHeight("");
//				msg.insert(0, bean.getFieldChinDesc("height") + "应为整数；");
			}
			
			if(StringUtil.isNotEmpty(bean.getWeight()) && !ValidateUtil.checkNumber(bean.getWeight())) {
				bean.setWeight("");
//				msg.insert(0, bean.getFieldChinDesc("weight") + "应为整数或小数；");
			}
			
			if(!StringUtil.isEmpty(bean.getEmail()) && !ValidateUtil.isEmail(bean.getEmail())){
				msg.insert(0, "邮箱格式不正确！");
			}
			
			if(!StringUtil.isEmpty(bean.getTel()) && !ValidateUtil.isMobileNo(bean.getTel())){
				msg.insert(0, "手机号不合法；");
			}
			
			msg.insert(0,checkIdcard(bean));  //身份证校验
			
			if(StringUtil.isEmpty(bean.getMemberName())){
				msg.insert(0, "姓名为空；");
			}
			return msg.toString();
		}
		
		private String checkIdcard(MemberImportBean member) {
			StringBuilder msg = new StringBuilder();
			if(StringUtil.isNotEmpty(member.getIdcard())) {
				CheckIdCard checkIdCard = CheckIdCard.getInstance(member.getIdcard());
				if(!checkIdCard.validate()){
					msg.insert(0, "该身份证号格式不正确；");
					return msg.toString();
				}
				
				Date birth = checkIdCard.getBirthDate();
				if(StringUtil.isNotEmpty(member.getBirthDay())) {
					if(!ValidateUtil.checkBirthday(member.getBirthDay())) {
						msg.insert(0, "该出生日期格式不正确，例如：yyyy-MM-dd；");
					}
				} else {
					member.setBirthDay(TimeUtil.formatDate(birth));
				}
				if(StringUtil.isEmpty(member.getGender())) {
					member.setGender(checkIdCard.isMale() ? "男" : "女");
				}
			}
			return msg.toString();
		}
}
