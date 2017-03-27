package com.bithealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.constants.Constants;
import com.bithealth.inspectCore.facede.service.DictFacedeService;
import com.bithealth.inspectCore.facede.service.InspectFacedeService;
import com.bithealth.inspectCore.facede.service.PhysicalFacedeService;
import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetail;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetail;
import com.bithealth.inspectCore.model.Inspect;
import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.model.AppUser;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.HealthCheckUtil;
import com.bithealth.util.MessageUtil;
import com.bithealth.util.TimeUtil;
import com.bithealth.util.VisitUtil;

/**
 * @PackageName: com.bithealth.controller
 * @FileName:    PublicHealthController.java  
 * @Description: 公卫模块  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuxiaoqin
 * @version      V1.0  
 * @Createdate:  2016年7月28日 
 */
@Controller
@RequestMapping(value = "/health")
public class PublicHealthController extends BaseSpringController{
	
	@Resource
    private InspectFacedeService inspectFacedeService;
	
	@Resource
    private DictFacedeService dictFacedeService;
	
	@Resource
    private PhysicalFacedeService physicalFacedeService;
	
	@Resource
    private MemberService memberService;
	
	private static Logger logger = Logger.getLogger(PublicHealthController.class);
	
	/**
	 * @Description: 根据公卫健康id和服务类型查找服务明细
	 * @author:      liuxiaoqin
	 * @param        healthType:健康服务类型 “1”:”体检”,”2”:”糖尿病随访”;”3”:高血压随访’;
	 * @version      V1.0  
	 * @Createdate:  2016年7月28日 
	 */
	@RequestMapping(value = "/findHealthServiceDetail", method = RequestMethod.POST)
    public void selectHealthServiceDetail(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
		JSONObject StrObject = JSON.parseObject(otherParam);
    	Long id = StrObject.getLong("id");
    	if(id == null || id <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数id【"+id+"】应为正整数");
			logger.info("参数id【"+id+"】应为正整数");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return; 
    	}
    	Integer phType = StrObject.getInteger("phType");
    	if(phType == null || phType <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数phType【"+phType+"】应为正整数");
			logger.info("参数phType【"+phType+"】应为正整数");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return; 
    	}
    	if(phType == 1){
    		value = selectPhHealthexamById(id,user.getUserType());
    	}else if(phType == 2){
    		value = selectPhDiabetesById(id,user.getUserType());
    	}else if(phType == 3){
    		value = selectPhHypertensionById(id,user.getUserType());
    	}
    	out.write(JSON.toJSONString(value));
    }

	/**
	 * @Description: 根据id查询体检明细
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月28日 
	 */
	public JSONResult<Object> selectPhHealthexamById(Long id,Integer userType){
		JSONResult<Object> value = new JSONResult<Object>();
		try{
			PhHealthexam phHealthexam = physicalFacedeService.selectPhHealthexamById(id);
			if(phHealthexam != null){
				Map<String,Object> examMap = new HashMap<String, Object>();
				if(userType != null && userType == 2){
					examMap.put("hExamID", phHealthexam.getHExamID());
		            String uniqueId = phHealthexam.getUnique_ID();
		            if(!StringUtils.isEmpty(uniqueId)){
		                examMap.put("uniqueId", uniqueId);
		            }
		            Integer refCompany = (int)phHealthexam.getRefCompany();
		            if(refCompany != null){
		                examMap.put("refCompany", refCompany);
		            }
		            String refDataPk = phHealthexam.getRefDataPK();
		            if(!StringUtils.isEmpty(refDataPk)){
		                examMap.put("refDataPk", refDataPk);
		            }
		            Date examDate = phHealthexam.getExamDate();
		            if(examDate!= null){
		                examMap.put("examDate", TimeUtil.formatDate(examDate));
		            }
		            String responsibleDrName = phHealthexam.getResponsibleDrName();
		            if(!StringUtils.isEmpty(responsibleDrName)){
		                examMap.put("responsibleDrName", responsibleDrName);
		            }
		            Integer createDrID = phHealthexam.getCreateDrID();
		            if(createDrID != null){
		                examMap.put("createDrID", createDrID);
		            }
		            String createDrName = phHealthexam.getCreateDrName();
		            if(!StringUtils.isEmpty(createDrName)){
		                examMap.put("createDrName", createDrName);
		            }
		            Date createTime = phHealthexam.getCreateTime();
		            if(createTime != null){
		                examMap.put("createTime", TimeUtil.formatDatetime2(createTime));
		            }
		            Date getTime = phHealthexam.getGetTime();
		            if(getTime != null){
		                examMap.put("getTime", TimeUtil.formatDatetime2(getTime));
		            }
		            Integer updateDrID = phHealthexam.getUpdateDrID();
		            if(updateDrID != null ){
		                examMap.put("updateDrID", updateDrID);
		            }
		            String updateDrName = phHealthexam.getUpdateDrName();
		            if(!StringUtils.isEmpty(updateDrName)){
		                examMap.put("updateDrName", updateDrName);
		            }
				}
	            examMap.put("basicInfo", HealthCheckUtil.getMemBasicInfo(phHealthexam));
	            examMap.put("symptoms", HealthCheckUtil.getSymptoms(phHealthexam));
	            String str  = JSON.toJSONString(examMap.get("basicInfo"));
	            JSONObject strObject = JSON.parseObject(str);
	            Integer age = strObject.getInteger("age");
	            examMap.put("generalSituation", HealthCheckUtil.getGeneralSituation(phHealthexam,age));
	            examMap.put("lifeStyle", HealthCheckUtil.getLifeStyle(phHealthexam));
	            examMap.put("organFunction", HealthCheckUtil.getOrganFunction(phHealthexam));
	            examMap.put("examination", HealthCheckUtil.getExamination(phHealthexam));
	            examMap.put("accessoryExamination", HealthCheckUtil.getAccessoryExamination(phHealthexam));
	            examMap.put("tcmConstitutionIdentification", HealthCheckUtil.getTcm(phHealthexam));
	            examMap.put("majorHealthProblems", HealthCheckUtil.getProblems(phHealthexam));
	            examMap.put("hospitalCourse", HealthCheckUtil.getHospitalCourse(phHealthexam));
	            examMap.put("medication", HealthCheckUtil.getMedication(phHealthexam));
	            examMap.put("vaccination", HealthCheckUtil.getVaccination(phHealthexam));
	            examMap.put("healthEvaluation", HealthCheckUtil.getHealthEvaluation(phHealthexam));
	            examMap.put("healthGuidance", HealthCheckUtil.getHealthGuidance(phHealthexam));
	            examMap.put("riskFactorControl", HealthCheckUtil.getRiskFactorControl(phHealthexam));
				value.setSuccess(true);
				value.setStatusCode(0);
				value.setData(examMap);
				value.setMessage("查询体检报告明细成功！");
				logger.info("查询体检报告明细成功！");
			}else{
				value.setSuccess(true);
				value.setStatusCode(3);
				value.setMessage("没有该体检信息！");
				logger.info("没有该体检信息！");
			}
		}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("查询体检报告明细异常"+e);
		}
		return value;
	}
	
	/**
	 * @Description: 根据id查询糖尿病明细
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月28日 
	 */
	public JSONResult<Object> selectPhDiabetesById(Long id,Integer userType){
		JSONResult<Object> value = new JSONResult<Object>();
		try{
			PhDiabetes phDiabetes = inspectFacedeService.selectPhDiabetesById(id);
			if(phDiabetes != null){
				Map<String,Object> map = new HashMap<String, Object>();
				if(userType != null && userType == 2){
					Integer createDrID = phDiabetes.getCreateDrID();
		            if(createDrID !=null &&createDrID >0){
		            	 map.put("createDrID",createDrID);
		            }
		            String createDrName = phDiabetes.getCreateDrName();
		            if(!StringUtils.isEmpty(createDrName)){
		            	map.put("createDrName",createDrName);
		            }
		            Date createTime = phDiabetes.getCreateTime();
		            if(createTime != null){
		            	String newCreateTime = TimeUtil.formatDatetime2(createTime);
		                map.put("createTime",newCreateTime);
		            }
		            Date getTime = phDiabetes.getGetTime();
		            if(getTime != null){
		            	String newGetTime = TimeUtil.formatDatetime2(getTime);
		                map.put("getTime",newGetTime);
		            }
				}
	            String date = "";
	            Date visitDate = phDiabetes.getVisitDate();
	            if(visitDate != null){
	                date = TimeUtil.formatDate(visitDate);
	            }
	            map.put("visitDate",date);
	            PhDiabetesdetail detail = phDiabetes.getPhDiabetesdetail();
	            if(detail != null){
	            	map.put("basicInfo", VisitUtil.getDiabeBasicInfo(phDiabetes));
	                map.put("visitWayStr",detail.getVisitWayStr());
	                String symptom = detail.getSymptom();
	                String symptomStr = "";
	                if(!StringUtils.isEmpty(symptom) && !"null".equals(symptom)){
	                	symptomStr = detail.getSymptomStr();
	                }
	                map.put("symptomStr", symptomStr);
	                map.put("rhgStr", detail.getRhgStr());
	                map.put("drugComplianceStr",detail.getDrugCompliStr());
	                Byte drugAdverseReaction = detail.getDrugAdverseReaction();
	                String drugAdverseReactionStr = detail.getDrugAdverReaStr();
	                if(drugAdverseReaction != null && drugAdverseReaction == 2){
	                    String drugAdverseReactionDesc = detail.getDrugAdverseReaction_Desc();
	                    if(!StringUtils.isEmpty(drugAdverseReactionDesc)){
	                        drugAdverseReactionStr += Constants.LEFT_BRACKET + drugAdverseReactionDesc + Constants.RIGHT_BRACKET;
	                    }
	                }
	                map.put("drugAdverseReactionStr", drugAdverseReactionStr);
	                map.put("transferReason",detail.getTransferReason());
	                map.put("transferOrgAndDept",detail.getTransferOrgAndDept());
	                String nextDate = "";
	                Date newDate = detail.getVisitDate_Next();
	                if(newDate != null){
	                    nextDate = TimeUtil.formatDate(newDate);
	                }
	                map.put("nextVistDate",nextDate);
	                map.put("visitDrName",phDiabetes.getVisitDrName());
	                map.put("accessoryExamination",VisitUtil.getDiabeAccessoryExamination(phDiabetes));
	                map.put("physicalSigns",VisitUtil.getDiabePhysicalSigns(phDiabetes));
	                map.put("lifeStyle", VisitUtil.getDiabeLifeStyle(phDiabetes));
	                map.put("medication",VisitUtil.getDiabeMedication(phDiabetes));
	                map.put("visitResult", phDiabetes.getVisitClassStr());
	                value.setSuccess(true);
	                value.setStatusCode(0);
	                value.setData(map);
	                value.setMessage("查询糖尿病明细成功！");
	                logger.info("查询糖尿病明细成功！");
	            }else{
	            	value.setSuccess(true);
					value.setStatusCode(3);
					value.setMessage("没有该糖尿病信息！");
					logger.info("没有该糖尿病信息！");
					
	            }
			}else{
				value.setSuccess(true);
				value.setMessage("没有该糖尿病信息！");
				value.setStatusCode(3);
				logger.info("没有该糖尿病信息！");
			}
		}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("查询糖尿病明细异常"+e);
		}
		return value;
	}
	
	/**
	 * @Description: 根据id查询高血压明细
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月28日 
	 */
	public JSONResult<Object> selectPhHypertensionById(Long id,Integer userType){
		JSONResult<Object> value = new JSONResult<Object>();
		try{
			PhHypertension phHypertension = inspectFacedeService.selectPhHypertensionById(id);
			if(phHypertension != null){
				Map<String,Object> map = new HashMap<String, Object>();
				if(userType != null && userType == 2){
					Integer createDrID = phHypertension.getCreateDrID();
		            if(createDrID !=null &&createDrID >0){
		            	 map.put("createDrID",createDrID);
		            }
		            String createDrName = phHypertension.getCreateDrName();
		            if(!StringUtils.isEmpty(createDrName)){
		            	map.put("createDrName",createDrName);
		            }
		            Date createTime = phHypertension.getCreateTime();
		            if(createTime != null){
		            	String newCreateTime = TimeUtil.formatDatetime2(createTime);
		                map.put("createTime",newCreateTime);
		            }
		            Date getTime = phHypertension.getGetTime();
		            if(getTime != null){
		            	String newGetTime = TimeUtil.formatDatetime2(getTime);
		                map.put("getTime",newGetTime);
		            }
				}
	            String date = "";
	            Date visitDate = phHypertension.getVisitDate();
	            if(visitDate != null){
	                date = TimeUtil.formatDate(visitDate);
	            }
	            map.put("visitDate",date);
	            PhHypertensiondetail detail = phHypertension.getPhHypertensiondetail();
	            if(detail != null){
	            	map.put("basicInfo", VisitUtil.getHyperBasicInfo(phHypertension));
	                map.put("visitWayStr",detail.getVisitWayStr());
	                String symptom = detail.getSymptom();
	                String symptomStr = "";
	                if(!StringUtils.isEmpty(symptom) && !"null".equals(symptom)){
	                	symptomStr = detail.getSymptomStr();
	                }
	                map.put("symptomStr", symptomStr);
	                map.put("drugComplianceStr",detail.getDrugCompliStr());
	                Byte drugAdverseReaction = detail.getDrugAdverseReaction();
	                String drugAdverseReactionStr = detail.getDrugAdverReaStr();
	                if(drugAdverseReaction != null && drugAdverseReaction == 2){
	                    String drugAdverseReactionDesc = detail.getDrugAdverseReaction_Desc();
	                    if(!StringUtils.isEmpty(drugAdverseReactionDesc)){
	                        drugAdverseReactionStr += Constants.LEFT_BRACKET + drugAdverseReactionDesc + Constants.RIGHT_BRACKET;
	                    }
	                }
	                map.put("drugAdverseReactionStr",drugAdverseReactionStr);
	                map.put("checkResult",detail.getCheckResult() );
	                map.put("transferReason",detail.getTransferReason() );
	                map.put("transferOrgAndDept",detail.getTransferOrgAndDept());
	                String nextDate = "";
	                Date newDate = detail.getVisitDate_Next();
	                if(newDate != null){
	                    nextDate = TimeUtil.formatDate(newDate);
	                }
	                map.put("nextVistDate",nextDate);
	                map.put("physicalSigns",VisitUtil.getHyperPhysicalSigns(phHypertension));
	                map.put("lifeStyle", VisitUtil.getHyperLifeStyle(phHypertension));
	                map.put("medication",VisitUtil.getHyperMedication(phHypertension));
	                map.put("visitDrName",phHypertension.getVisitDrName());
	                map.put("visitResult", phHypertension.getVisitClassStr());
	                value.setSuccess(true);
	                value.setStatusCode(0);
	                value.setData(map);
	                value.setMessage("查询高血压明细成功！");
	                logger.info("查询高血压明细成功！");
	            }else{
	            	value.setSuccess(true);
					value.setStatusCode(3);
					value.setMessage("没有该高血压信息！");
					logger.info("没有该高血压信息！");
	            }
			}else{
				value.setSuccess(true);
				value.setStatusCode(3);
				value.setMessage("没有该高血压信息！");
				logger.info("没有该高血压信息！");
			}
		}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("查询高血压明细异常"+e);
		}
		return value;
	}
	
	/**
	 * @Description: 分页条件查询我的公卫健康服务列表
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年7月29日 
	 */
	@RequestMapping(value = "/findHealthServiceList", method = RequestMethod.POST)
    public void selectHealthServiceList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
		JSONObject StrObject = JSON.parseObject(otherParam);
		Integer pageSize = StrObject.getInteger("pageSize");
		Integer pageNow = StrObject.getInteger("pageNow");
		try{
			Integer memberId = user.getUserId();
			String memberGUID = StrObject.getString("memberGUID");
    		if(!StringUtils.isEmpty(memberGUID)){
    			Member member = memberService.selectByUUID(memberGUID,UseTag.T);
    			if(member != null){
    				memberId = member.getMemberid();
    			}
    		}
			Page<Inspect> page = new Page<Inspect>(pageNow,pageSize);
			//待完善获取三个模块的拼接数据
			Page<Inspect> newPage = inspectFacedeService.selectInspectPage(page, memberId);
			if(newPage != null && newPage.getResult()!= null && newPage.getResult().size()>0){
				List<Inspect> list = newPage.getResult();
				List<Map<String, Object>> mapList = getInspectData(list);
				value.setSuccess(true);
				value.setStatusCode(0);
				value.setMessage("分页条件查询我的公卫健康服务列表成功");
				value.setData(mapList);
				logger.error("分页条件查询我的公卫健康服务列表成功");
			}else{
				value.setSuccess(false);
				value.setStatusCode(3);
				value.setMessage("没有公卫健康服务信息");
				logger.error("没有公卫健康服务信息");
			}
		}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("分页条件查询我的公卫健康服务列表"+e);
		}
		out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 查询我的医生待随访项目
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月31日 
	 */
	@RequestMapping(value = "/findDoctorVisitingRecords", method = RequestMethod.POST)
    public void selectDoctorVisitingRecords(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
		JSONObject StrObject = JSON.parseObject(otherParam);
		try{
			Integer memberId = user.getUserId();
			Integer doctorId = user.getUserId();
			if(user.getUserType() == 1){
				Integer doctorIdNew = StrObject.getInteger("doctorId");
				if(doctorIdNew == null || doctorIdNew <= 0){
		    		value.setStatusCode(1);
					value.setMessage("参数doctorId【"+doctorIdNew+"】应为正整数");
					logger.info("参数doctorId【"+doctorIdNew+"】应为正整数");
					value.setSuccess(false);
					out.write(JSON.toJSONString(value));
					return; 
		    	}
				doctorId = doctorIdNew;
			}
			if(user.getUserType() == 2){
				Integer memberIdNew = StrObject.getInteger("memberId");
				if(memberIdNew == null || memberIdNew <= 0){
		    		value.setStatusCode(1);
					value.setMessage("参数memberId【"+memberIdNew+"】应为正整数");
					logger.info("参数memberId【"+memberIdNew+"】应为正整数");
					value.setSuccess(false);
					out.write(JSON.toJSONString(value));
					return; 
		    	}
				memberId = memberIdNew;
			}
			Byte visitClass = 0;
			Byte isDeleted = 0;
			List<Map<String,Object>> visitList = new ArrayList<Map<String,Object>>();
			
			/* 糖尿病   begin*/
			Page<PhDiabetes> pageDiabetes = new Page<PhDiabetes>();
			PhDiabetes pojoDiabetes = new PhDiabetes();
			pojoDiabetes.setMemberID(memberId);
			pojoDiabetes.setVisitClass(visitClass);
			pojoDiabetes.setIsDeleted(isDeleted);
			Page<PhDiabetes> listDiabetes = inspectFacedeService.selectPhDiabetesPage(pageDiabetes, pojoDiabetes, doctorId);
			Map<String,Object> mapDiabete = new HashMap<String, Object>();
			if(listDiabetes != null && listDiabetes.getResult() != null && listDiabetes.getResult().size() > 0){
				Date date = listDiabetes.getResult().get(0).getVisitDate();
				Integer visitDoctorId = inspectFacedeService.selectPhDiabetesById(listDiabetes.getResult().get(0).getDiabetesID()).getCreateDrID();
				if(date != null && StringUtils.isEmpty(visitDoctorId) == false && visitDoctorId.equals(doctorId) == true){
					mapDiabete.put("visitingName", Constants.VISITING_DIABETES);
					mapDiabete.put("visitingDate", TimeUtil.formatDate(date));
					mapDiabete.put("date", date);
				}
			}
			/* 糖尿病   end*/
			
			/* 高血压   begin*/
			Page<PhHypertension> pageHypertension = new Page<PhHypertension>();
			PhHypertension pojoHypertension = new PhHypertension();
			pojoHypertension.setMemberID(memberId);
			pojoHypertension.setVisitClass(visitClass);
			pojoHypertension.setIsDeleted(isDeleted);
			Page<PhHypertension> listHypertension = inspectFacedeService.selectPhHypertensionPage(pageHypertension, pojoHypertension, doctorId);
			Map<String,Object> mapHypertension = new HashMap<String, Object>();
			if(listHypertension != null && listHypertension.getResult() != null && listHypertension.getResult().size() > 0){
				Date date = listHypertension.getResult().get(0).getVisitDate();
				Integer visitDoctorId = inspectFacedeService.selectPhHypertensionById(listHypertension.getResult().get(0).getHypertensionID()).getCreateDrID();
				if(date != null && StringUtils.isEmpty(visitDoctorId) == false && visitDoctorId.equals(doctorId) == true){
					mapHypertension.put("visitingName", Constants.VISITING_HYPERTENSION);
					mapHypertension.put("visitingDate", TimeUtil.formatDate(date));
					mapHypertension.put("date", date);
				}
			}
			/* 高血压   end*/
			if(mapHypertension.isEmpty()== false && mapDiabete.isEmpty() == false){
				Date dateD = (Date)mapDiabete.get("date");
				Date dateH = (Date)mapHypertension.get("date");
				if(dateD.after(dateH)){
					visitList.add(mapHypertension);
					visitList.add(mapDiabete);
				}else{
					visitList.add(mapDiabete);
					visitList.add(mapHypertension);
				}
			}else if(mapHypertension.isEmpty()== false && mapDiabete.isEmpty() == true){
				visitList.add(mapHypertension);
			}else if(mapHypertension.isEmpty()== true && mapDiabete.isEmpty() == false){
				visitList.add(mapDiabete);
			}
			if(visitList != null && visitList.size()>0){
				value.setSuccess(true);
				value.setStatusCode(0);
				value.setMessage("查询我的医生待随访项目成功");
				value.setData(visitList);
				logger.error("查询我的医生待随访项目成功");
			}else{
				value.setSuccess(false);
				value.setStatusCode(3);
				value.setMessage("该医生没有待随访项目");
				logger.error("该医生没有待随访项目");
			}
		}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("查询我的医生待随访项目异常"+e);
		}
		out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 转化公卫数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月24日 
	 */
	public List<Map<String, Object>> getInspectData(List<Inspect> list)throws Exception{
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		for(Inspect inspect : list){
			Map<String, Object> map = new HashMap<String, Object>();
			Date date = inspect.getPhDate();
			if(date != null){
				String phDate = TimeUtil.formatDate(date);
				map.put("phDate", phDate);
				map.put("dateAlias", TimeUtil.getDateAlias(phDate));
			}
			List<Inspect> dataList = inspect.getData();
			List<Map<String, Object>> dataMapList = new ArrayList<Map<String, Object>>();
			for(Inspect data : dataList){
				Map<String, Object> dataMap = new HashMap<String, Object>();
				dataMap.put("id", data.getId());
				int phType = data.getType();
				dataMap.put("phType", phType);
				int conclusionCode = data.getConclusionCode();
				dataMap.put("conclusionCode", conclusionCode);
				dataMap.put("conclusionDesc", getPhConclusionDesc(phType,conclusionCode));
				dataMapList.add(dataMap);
			}
			map.put("data", dataMapList);
			mapList.add(map);
		}
		return mapList;
	}
	
	/**
	 * @Description: 转化公卫数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月24日 
	 */
	public String getPhConclusionDesc(int phType,int conclusionCode)throws Exception{
		String conclusionDesc = "";
		if(phType == 1){
			if(conclusionCode == 1){
				conclusionDesc = MessageUtil.getValue("ph.000000");
			}else if(conclusionCode == 2){
				conclusionDesc = MessageUtil.getValue("ph.100000");;
			}
		}else{
			if(conclusionCode == 1){
				conclusionDesc = MessageUtil.getValue("ph.200000");
			}else if(conclusionCode == 2){
				conclusionDesc = MessageUtil.getValue("ph.300000");
			}else if(conclusionCode == 3){
				conclusionDesc = MessageUtil.getValue("ph.400000");
			}else if(conclusionCode == 4){
				conclusionDesc = MessageUtil.getValue("ph.500000");
			}
		}
		return conclusionDesc;
	}
	
	
}
