package com.bithealth.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.constants.Constants;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.model.AppUser;
import com.bithealth.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
import com.bithealth.questionCore.answer.model.Cam1;
import com.bithealth.questionCore.answer.model.Ocam;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.answer.model.OuaiExample;
import com.bithealth.questionCore.answer.model.OuaiExample.Criteria;
import com.bithealth.questionCore.answer.model.Uai21;
import com.bithealth.questionCore.answer.model.Uai4;
import com.bithealth.questionCore.answer.service.Uai21Service;
import com.bithealth.questionCore.answer.service.Uai4Service;
import com.bithealth.questionCore.audit.model.Cam2;
import com.bithealth.questionCore.audit.model.Uai3;
import com.bithealth.questionCore.enmu.QuestionType;
import com.bithealth.questionCore.enmu.SingleAnswerStatusEnum;
import com.bithealth.questionCore.facede.service.AnswerFacedeService;
import com.bithealth.questionCore.facede.service.QuestionFacedeService;
import com.bithealth.questionCore.model.Answer;
import com.bithealth.questionCore.question.model.Logics;
import com.bithealth.questionCore.question.model.Mfq1;
import com.bithealth.questionCore.question.model.Mfq11;
import com.bithealth.questionCore.question.model.Omfq;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.MessageUtil;
import com.bithealth.util.TimeUtil;

/**
 * @PackageName: com.bithealth.controller
 * @FileName:    PaperController.java  
 * @Description: 答卷问卷模块  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuxiaoqin
 * @version      V1.0  
 * @Createdate:  2016年7月28日 
 */
@Controller
@RequestMapping(value = "/paper")
public class PaperController extends BaseSpringController{
	
	@Resource
    private AnswerFacedeService answerFacedeService;
	
	@Resource
    private QuestionFacedeService questionFacedeService;
	
	@Resource
    private MemberService memberService;
	
	@Autowired
	private Uai21Service uai21Service;
	
	@Autowired
	private Uai4Service uai4Service;
	
	@Autowired
	private DoctorService doctorService;
	
	@Resource
    private MessageCenterFacadeService messageCenterFacadeService;
	
	private static Logger logger = Logger.getLogger(PaperController.class);
	
	/**
	 * @Description: 查询单份答卷明细
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年7月29日 
	 */
	@RequestMapping(value = "/findMySinglePaper", method = RequestMethod.POST)
    public void selectMySinglePaper(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
		JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer answerPaperId = StrObject.getInteger("answerPaperId");
    	if(answerPaperId == null || answerPaperId <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数answerPaperId【"+answerPaperId+"】应为正整数");
			logger.info("参数answerPaperId【"+answerPaperId+"】应为正整数");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return; 
    	}
    	try{
    		Ouai singlePaper = answerFacedeService.selectSingleAnswerById(answerPaperId);
    		if(singlePaper != null){
//    			/* 设置消息为已读   begin */
//    			String paperStatusNew = singlePaper.getQustTag();
//    			if(!StringUtils.isEmpty(paperStatusNew)){
//    				Byte msgType = null;
//    				if(paperStatusNew.equals("F")){
//    					msgType = MessageTypeEnum.SINGLE_PAPERS_PUBLIC.getType();
//    				}else if(paperStatusNew.equals("C")){
//    					msgType = MessageTypeEnum.SINGLE_AUDIT_PAPERS.getType();
//    				}
//    				if(msgType != null){
//    					boolean isOk = messageCenterFacadeService.deleteById(singlePaper.getAnsNumber(),msgType,user.getUserGUID());
//    	    			if(isOk == true){
//    	    				logger.info("更新消息为已读成功。");
//    	    			}else{
//    	    				logger.info("更新消息为已读失败。");
//    	    			}
//    				}
//    			}
    			/* 设置消息为已读   end */
    			Map<String,Object> map = new HashMap<String,Object>();
    			Integer groupAnswerPaperId = StrObject.getInteger("groupAnswerPaperId");
    			if(groupAnswerPaperId != null && groupAnswerPaperId >0){
    				map.put("groupAnswerPaperId", groupAnswerPaperId);
    			}
    			map.put("answerPaperId", singlePaper.getAnsNumber());
    			map.put("questionnaireId", singlePaper.getQustid());
    			Date publishTime = singlePaper.getPublisherTime();
    			if(publishTime != null){
    				map.put("sendoutTime", TimeUtil.formatDatetime2(publishTime));
    			}
    			map.put("answerPaperName", singlePaper.getOmfq().getQustname());
    			Date answerTime = singlePaper.getAnswerTime();
    			if(answerTime != null){
    				map.put("answerTime", TimeUtil.formatDatetime2(answerTime));
    			}
    			map.put("paperStatus", singlePaper.getQustTag());
    			map.put("sendoutDocId", singlePaper.getDocid());
    			map.put("sendoutDocName", singlePaper.getDocName());
    			Uai3 audit = singlePaper.getUai3();
    			if(audit != null){
    				Integer auditDocId = audit.getDocid();
    				map.put("auditDocId",auditDocId);
    				map.put("auditDocName", singlePaper.getDocName());
    				Doctor doctor = doctorService.selectById(auditDocId);
    				if(doctor != null){
    					String auditDocSign = doctor.getSignaddress();
    					map.put("auditDocSign", auditDocSign);
    				}
    				Date auditTime = audit.getAuditTime();
        			if(auditTime != null){
        				map.put("auditTime", TimeUtil.formatDatetime2(auditTime));
        			}
    				map.put("auditAdvise", audit.getAuditDesc());
    				map.put("auditDiagnosis", audit.getDiagnosis());
    			}
    			Uai4 uai4 = singlePaper.getUai4();
    			if(uai4 != null){
    				map.put("totalScore", uai4.getScore());
        			map.put("conclusion", uai4.getConclusion());
    			}
    			/* 所有问题     begin */
    			List<Mfq1> problems = singlePaper.getOmfq().getMfq1s();
    			if(problems != null && problems.size() >0){
    				List<Map<String,Object>> problemMapList = new ArrayList<Map<String,Object>>();
    				for(Mfq1 problem : problems){
    					Map<String,Object> problemMap = new HashMap<String, Object>();
    					int problemId = problem.getProblemid();
    					problemMap.put("problemId", problemId);
    					problemMap.put("problemType", problem.getAnsType());
    					problemMap.put("problemName", problem.getProDesc());
    					problemMap.put("problemLine", problem.getLineNum());
    					problemMap.put("linkProblemId", problem.getUproblemid());
    					problemMap.put("relationPreTitle", problem.getRelation());
    					
    					/* 所选答案id     begin */
    					List<Uai21> answerList = uai21Service.selectByMasterId(answerPaperId);
    					List<Integer> answerIds = new ArrayList<Integer>();
    	    			if(answerList != null && answerList.size()>0){
    	    				for(Uai21 answer : answerList){
    	    					Integer ansid = (int)answer.getAnsid();
    	    					if(problemId == answer.getProblemid()){
    	    						answerIds.add(ansid);
    	    					}
    	    				}
    	    			}
    	    			String answerId = StringUtils.collectionToDelimitedString(answerIds, ",");
    					problemMap.put("answerId", answerId);
    					/* 所选答案id     end */
    					
    					/* 所有答案选项     begin */
    					List<Mfq11> options = problem.getMfq11s();
    					if(options != null && options.size() >0){
    	    				List<Map<String,Object>> optionMapList = new ArrayList<Map<String,Object>>();
    	    				for(Mfq11 option : options){
    	    					Map<String,Object> optionMap = new HashMap<String, Object>();
    	    					optionMap.put("optionId", option.getAnsid());
    	    					optionMap.put("optionName", option.getDescription());
    	    					optionMap.put("mark", option.getMark());
    	    					optionMap.put("score", option.getScore());
    	    					
    	    					/* 所选问题的选项与问题id的互斥     begin */
    	    					List<Logics> logicses = problem.getLogicses();
    	    					if(logicses != null && logicses.size() >0){
    	    						for(Logics logic : logicses){
        	    						if(logic.getProblemId().equals(option.getProblemid())){
        	    							Integer logicAnswerId = logic.getAnswerId();
        	    							Integer optionAnswerId = (int)option.getAnsid();
        	    							if(logicAnswerId == optionAnswerId){
        	    								optionMap.put("unSelectedProblemIds",logic.getProblemIdsStr());
        	    							}
        	    						}
        	    					}
    	    					}
    	    					/* 所选问题的选项与问题id的互斥     end */
    	    					optionMapList.add(optionMap);
    	    				}
    	    				problemMap.put("optionList", optionMapList);
    					}
    					/* 所有答案选项     end */
    					
    					problemMapList.add(problemMap);
    				}
    				map.put("problemList", problemMapList);
    			}
    			value.setStatusCode(0);
    			value.setMessage("查询单份答卷信息成功");
    			logger.info("查询单份答卷信息成功！");
    			value.setSuccess(true);
    			value.setData(map);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有单份答卷信息 ");
    			logger.info("没有单份答卷信息");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("查询单份答卷信息异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
    }
	
	/**
	 * @Description: 根据组合答卷id查询(单份答卷列表)
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月01日 
	 */
	@RequestMapping(value = "/findMyGroupPaper", method = RequestMethod.POST)
    public void selectMyGroupPaper(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
		JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer answerPaperId = StrObject.getInteger("answerPaperId");
    	if(answerPaperId == null || answerPaperId <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数answerPaperId【"+answerPaperId+"】应为正整数");
			logger.info("参数answerPaperId【"+answerPaperId+"】应为正整数");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return; 
    	}
    	String answerPaperType = StrObject.getString("answerPaperType");
    	if(StringUtils.isEmpty(answerPaperType)){
    		value.setStatusCode(1);
			value.setMessage("参数answerPaperType【"+answerPaperType+"】不能为空");
			logger.info("参数answerPaperType【"+answerPaperType+"】不能为空");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return; 
    	}
    	try{
    		Ocam groupPaper = answerFacedeService.selectComAnswerById(answerPaperId);
    		if(groupPaper != null){
    			/* 设置消息为已读   begin */
    			//组合答卷状态：0-未完成，1-已完成正在审核中，2-审核完成 3-作答中
    			String paperStatusNew = groupPaper.getCombTag();
    			if(!StringUtils.isEmpty(paperStatusNew)){
    				Byte msgType = null;
    				if(paperStatusNew.equals("0")){
    					msgType = MessageTypeEnum.COMBINATION_AUDIT_PUBLIC.getType();
    				}else if(paperStatusNew.equals("2")){
    					msgType = MessageTypeEnum.COMBINATION_AUDIT_PAPERS.getType();
    				}
    				if(msgType != null){
    					boolean isOk = messageCenterFacadeService.deleteById(groupPaper.getCombAnsid(),msgType,user.getUserGUID());
    	    			if(isOk == true){
    	    				logger.info("更新消息为已读成功。");
    	    			}else{
    	    				logger.info("更新消息为已读失败。");
    	    			}
    				}
    			}
    			Map<String,Object> groupMap = new HashMap<String,Object>();
    			List<Cam1> cam1List = groupPaper.getCam1s();
    			if(cam1List != null && cam1List.size()>0){
    				List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
    				for(Cam1 cam1 : cam1List){
    					Map<String,Object> map = new HashMap<String,Object>();
    					map.put("groupAnswerPaperId", groupPaper.getCombAnsid());
    					map.put("answerPaperId", cam1.getAnsNumber());
    					map.put("answerPaperName", cam1.getOuai().getOmfq().getQustname());
    					Date date = groupPaper.getPublisherTime();
    					if(date != null){
    						String sendoutTime = TimeUtil.formatDatetime2(date);
    						map.put("sendoutTime", sendoutTime);
    					}
    					map.put("sendoutDocName", cam1.getOuai().getDocName());
    					String paperStatus = cam1.getOuai().getQustTag();
    					map.put("paperStatus", paperStatus);
    					Date date1 = groupPaper.getAnswerTime();
    					if(date1 != null){
    						String answerTime = TimeUtil.formatDatetime2(date1);
    						map.put("answerTime", answerTime);
    					}
    					//已作答、已审核，取结论
    					if(SingleAnswerStatusEnum.ANSWERED.getCode().equals(paperStatus) || SingleAnswerStatusEnum.APPROVED.getCode().equals(paperStatus)){
    						Uai4 uai4 = uai4Service.selectByMasterId(cam1.getAnsNumber());
    						if(uai4 != null){
        	    				map.put("totalScore", uai4.getScore());
        	        			map.put("conclusion", uai4.getConclusion());
        	    			}
    					}
    					mapList.add(map);
    				}
    				Cam2 cam2 = groupPaper.getCam2();
    				if(cam2 != null){
    					groupMap.put("auditAdvise", cam2.getAuditDesc());
    					Date date2 = cam2.getAuditTime();
    					if(date2 != null){
    						String auditTime = TimeUtil.formatDatetime2(date2);
    						groupMap.put("auditTime", auditTime);
    					}
    					groupMap.put("auditDiagnosis", cam2.getDiagnosis());
    					groupMap.put("auditDocId", cam2.getDocid());
    					groupMap.put("auditDocName", groupPaper.getDocName());
    					groupMap.put("auditDocSign", cam2.getDocSign());
    				}
    				groupMap.put("paperList", mapList);
    				groupMap.put("groupPaperStatus", groupPaper.getCombTag());
    				value.setStatusCode(0);
        			value.setMessage("查询组合答卷信息成功");
        			logger.info("查询组合答卷信息成功！");
        			value.setSuccess(true);
        			value.setData(groupMap);
    			}
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有组合答卷信息 ");
    			logger.info("没有组合答卷信息");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("查询组合答卷信息异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
    }
	
	/**
	 * @Description: 提交答卷
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月01日 
	 */
	@RequestMapping(value = "/submitAnswerPaper", method = RequestMethod.POST)
    public void insertAnswerPaper(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
		JSONObject StrObject = JSON.parseObject(otherParam);
		String isHealthPaper = StrObject.getString("isHealthPaper");
		Integer answerPaperId = 0;
		Integer questionnaireId = null;
		if(StringUtils.isEmpty(isHealthPaper)){
			answerPaperId = StrObject.getInteger("answerPaperId");
			if(answerPaperId == null || answerPaperId <= 0){
				value.setStatusCode(1);
				value.setMessage("参数answerPaperId【"+answerPaperId+"】应为正整数");
				logger.info("参数answerPaperId【"+answerPaperId+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return; 
			}
		}else{
			questionnaireId = StrObject.getInteger("questionnaireId");
			if(questionnaireId == null || questionnaireId <= 0){
				value.setStatusCode(1);
				value.setMessage("参数questionnaireId【"+questionnaireId+"】应为正整数");
				logger.info("参数questionnaireId【"+questionnaireId+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return; 
			}
		}
    	String answerPaperType = StrObject.getString("answerPaperType");
    	if(StringUtils.isEmpty(answerPaperType)){
    		value.setStatusCode(1);
			value.setMessage("参数answerPaperType【"+answerPaperType+"】不能为空");
			logger.info("参数answerPaperType【"+answerPaperType+"】不能为空");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return; 
    	}
    	String paperStatus = StrObject.getString("paperStatus");
    	if(StringUtils.isEmpty(paperStatus)){
    		value.setStatusCode(1);
			value.setMessage("参数paperStatus【"+paperStatus+"】不能为空");
			logger.info("参数paperStatus【"+paperStatus+"】不能为空");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return; 
    	}
    	String pagerList = StrObject.getString("pagerList");
    	if(StringUtils.isEmpty(pagerList)){
    		value.setStatusCode(1);
			value.setMessage("参数pagerList【"+pagerList+"】不能为空");
			logger.info("参数pagerList【"+pagerList+"】不能为空");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return; 
    	}
    	try{
    		List<Uai21> results = new ArrayList<Uai21>();
    		Ouai model = new Ouai();
    		model.setAnsNumber(answerPaperId);
    		model.setQustTag(paperStatus);
    		JSONArray arr =  JSON.parseArray(pagerList);
    		for(int i=0;i<arr.size();i++){
    			JSONObject objectStr = arr.getJSONObject(i);
    			String newAnserId = objectStr.getString("answerId");
    			if(newAnserId.length() > 1){
    				List<String> answerIds = Arrays.asList(StringUtils.commaDelimitedListToStringArray(newAnserId));
    				for(String answerIdNew : answerIds){
    					Uai21 uai21 = new Uai21();
        				uai21.setAnsNumber(answerPaperId);
        				uai21.setProblemid(objectStr.getInteger("problemId"));
        				int answerId = Integer.valueOf(answerIdNew);
        				uai21.setAnsid((short)answerId);
        				results.add(uai21);
    				}
    			}else{
    				Uai21 uai21 = new Uai21();
    				uai21.setAnsNumber(answerPaperId);
    				uai21.setProblemid(objectStr.getInteger("problemId"));
    				int answerId = Integer.valueOf(newAnserId);
    				uai21.setAnsid((short)answerId);
    				results.add(uai21);
    			}
    		}
    		if(answerPaperType.equals("single")){
    			if(!StringUtils.isEmpty(isHealthPaper)){
    				SingleAnswerStatusEnum type = SingleAnswerStatusEnum.APPROVED;
    				if(paperStatus.equals("B")){
    					type = SingleAnswerStatusEnum.STAGING;
    				}
    				Map<String, Map<Double, String>> map = answerFacedeService.insertSingleAnswerResult(results, null, questionnaireId, null, user.getUserId(),type);
    				if(map != null && map.isEmpty() == false){
    					Map<String, Object> mapNew = new HashMap<String, Object>();
    					Double finalSocre = null;
    					String conclusion = "";
    					String result = "";
                        if(map.keySet().contains(QuestionType.ONE.getName())){
                        	Set<Double> scoreList = map.get(QuestionType.ONE.getName()).keySet();
                        	for(Double score : scoreList){
                        		finalSocre = score;
                        	}
                        	conclusion = map.get(QuestionType.ONE.getName()).get(finalSocre);
                        	result = "得分: " + finalSocre + Constants.LEFT_BRACKET + conclusion + Constants.RIGHT_BRACKET;
                        	mapNew.put("result", result);
                        }else{
                        	result = getTCMResult(map);
                        	mapNew.put("result", result);
                        }
    					value.setData(mapNew);
    					value.setStatusCode(0);
    					value.setMessage("提交健康评估答卷成功");
    					logger.info("提交健康评估答卷成功！");
    					value.setSuccess(true);
    				}else if(map != null && map.isEmpty() == true){
    					value.setStatusCode(0);
    					value.setMessage("暂存健康评估答卷成功");
    					logger.info("暂存健康评估答卷成功！");
    					value.setSuccess(true);
    				}else{
    					value.setStatusCode(1);
    					value.setMessage("提交健康评估答卷失败 ");
    					logger.info("提交健康评估答卷失败");
    					value.setSuccess(false);
    				}
    			}else{
    				boolean success = answerFacedeService.insertSingleAnswerResult(results, model);
    				if(success == true){
    					value.setStatusCode(0);
    					value.setMessage("提交单份答卷成功");
    					logger.info("提交单份答卷成功！");
    					value.setSuccess(true);
    				}else{
    					value.setStatusCode(1);
    					value.setMessage("提交单份答卷失败 ");
    					logger.info("提交单份答卷失败");
    					value.setSuccess(false);
    				}
    			}
    		}else{
    			Integer groupPaperId = StrObject.getInteger("groupPaperId");
    	    	if(groupPaperId == null || groupPaperId <= 0){
    	    		value.setStatusCode(1);
    				value.setMessage("参数groupPaperId【"+groupPaperId+"】应为正整数");
    				logger.info("参数groupPaperId【"+groupPaperId+"】应为正整数");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return; 
    	    	}
    			boolean success = answerFacedeService.insertComAnswerResult(results, model, groupPaperId);
        		if(success == true){
        			value.setStatusCode(0);
        			value.setMessage("提交组合答卷成功");
        			logger.info("提交组合答卷成功！");
        			value.setSuccess(true);
        		}else{
        			value.setStatusCode(1);
        			value.setMessage("提交组合答卷失败 ");
        			logger.info("提交组合答卷失败");
        			value.setSuccess(false);
        		}
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		if(answerPaperType.equals("single")){
    			value.setMessage(MessageUtil.getValue("error.insert.data"));
    			logger.info("提交单份答卷异常"+e);
    		}else{
    			value.setMessage(MessageUtil.getValue("error.insert.data"));
    			logger.info("提交组合答卷异常"+e);
    		}
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
    }
	
	/**
	 * @Description: 会员修改答卷状态为已读
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月01日 
	 */
	@RequestMapping(value = "/updateAnswerPaperStatus", method = RequestMethod.POST)
	public void updateAnswerPaperStatus(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	String otherParam = (String)request.getAttribute("otherParamStr");
		JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer answerPaperId = StrObject.getInteger("answerPaperId");
    	if(answerPaperId == null || answerPaperId <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数answerPaperId【"+answerPaperId+"】应为正整数");
			logger.info("参数answerPaperId【"+answerPaperId+"】应为正整数");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return; 
    	}
    	String answerPaperType = StrObject.getString("answerPaperType");
    	if(!StringUtils.isEmpty(answerPaperType)){
    		value.setStatusCode(1);
			value.setMessage("参数answerPaperType【"+answerPaperType+"】不能为空");
			logger.info("参数answerPaperType【"+answerPaperType+"】不能为空");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return; 
    	}
    	try{
    		
    	}catch(Exception e){
    		value.setStatusCode(2);
    		if(answerPaperType.equals("single")){
    			value.setMessage(MessageUtil.getValue("error.update.data"));
    			logger.info("修改单份答卷状态为已读异常"+e);
    		}else{
    			value.setMessage(MessageUtil.getValue("error.update.data"));
    			logger.info("修改组合答卷状态为已读异常"+e);
    		}
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 分页或者参数查询已答和未答的(单份和组合)答卷
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月01日 
	 */
	@RequestMapping(value = "/findMyQuestionnaireList", method = RequestMethod.POST)
	public void selectMyQuestionnaireList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	boolean finished = false;
    	try{
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		Integer memberId = user.getUserId();
    		if(user.getUserType() == 2){
    			Integer newMemberId = StrObject.getInteger("memberId");
        		if(newMemberId == null || memberId <= 0){
        			value.setStatusCode(1);
        			value.setMessage("参数memberId【"+newMemberId+"】应为正整数");
        			logger.info("参数memberId【"+newMemberId+"】应为正整数");
        			value.setSuccess(false);
        			out.write(JSON.toJSONString(value));
        			return; 
        		}
        		memberId = newMemberId;
    		}
    		String hasAnswered = StrObject.getString("hasAnswered");
    		if(StringUtils.isEmpty(hasAnswered)){
    			value.setStatusCode(1);
    			value.setMessage("参数hasAnswered【"+hasAnswered+"】不能为空");
    			logger.info("参数hasAnswered【"+hasAnswered+"】不能为空");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		if(hasAnswered.equals("T")){
    			finished = true;
    		}
    		Integer pageNow = StrObject.getInteger("pageNow");
    		if(pageNow == null || pageNow <= 0){
    			value.setStatusCode(1);
    			value.setMessage("参数pageNow【"+pageNow+"】应为正整数");
    			logger.info("参数pageNow【"+pageNow+"】应为正整数");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
        	Integer pageSize = StrObject.getInteger("pageSize");
        	if(pageSize == null || pageSize <= 0){
    			value.setStatusCode(1);
    			value.setMessage("参数pageSize【"+pageSize+"】应为正整数");
    			logger.info("参数pageSize【"+pageSize+"】应为正整数");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return; 
    		}
    		Page<Answer> page = new Page<Answer>(pageNow,pageSize);
    		Page<Answer> list = answerFacedeService.selectAnswerPage(page,memberId,finished);
    		if(list != null && list.getResult() != null && list.getResult().size()>0){
    			/*获取未读数据的id begin */
    			List<Integer> unreadMgsIds = new ArrayList<Integer>();
    			//单份答卷的ids
    			List<Integer> singleMgsIds = new ArrayList<Integer>();
    			//组合答卷的ids
    			List<Integer> groupMgsIds = new ArrayList<Integer>();
    			for(Answer answer : list.getResult()){
    				if(answer.getType() == 1){
    					singleMgsIds.add(answer.getId());
    				}else{
    					groupMgsIds.add(answer.getId());
    				}
    			}
    			
    			if(singleMgsIds != null && singleMgsIds.size() > 0){
    				Byte msgType = null;
    				if(hasAnswered.equals("T")){
    					msgType = MessageTypeEnum.SINGLE_AUDIT_PAPERS.getType();
    				}else{
    					msgType = MessageTypeEnum.SINGLE_PAPERS_PUBLIC.getType();
    				}
    				List<Integer> unreadMsgList = messageCenterFacadeService.getMessageListByIds(singleMgsIds,msgType);
    				if(unreadMsgList != null && unreadMsgList.size() > 0){
    					for(Integer msgId : unreadMsgList){
    						unreadMgsIds.add(msgId);
    					}
    				}
    			}
    			
    			if(groupMgsIds != null && groupMgsIds.size() > 0){
    				Byte msgType = null;
    				if(hasAnswered.equals("T")){
    					msgType = MessageTypeEnum.COMBINATION_AUDIT_PAPERS.getType();
    				}else{
    					msgType = MessageTypeEnum.COMBINATION_AUDIT_PUBLIC.getType();
    				}
    				List<Integer> unreadMsgList = messageCenterFacadeService.getMessageListByIds(groupMgsIds,msgType);
    				if(unreadMsgList != null && unreadMsgList.size() > 0){
    					for(Integer msgId : unreadMsgList){
    						unreadMgsIds.add(msgId);
    					}
    				}
    			}
    			
    			/*获取未读数据的id end */
    			List<Map<String,Object>> newList = convertAnswerDataList(list.getResult(),unreadMgsIds);
    			value.setStatusCode(0);
    			value.setData(newList);
    			value.setMessage("分页或者参数查询已答和未答的(单份和组合)答卷成功");
    			logger.info("分页或者参数查询已答和未答的(单份和组合)答卷成功");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有答卷");
    			logger.info("没有答卷");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("分页或者参数查询已答和未答的(单份和组合)答卷异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 查询健康评估问卷
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月31日 
	 */
	@RequestMapping(value = "/findEvaluatePaper", method = RequestMethod.POST)
    public void selectEvaluatePaper(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
		JSONObject StrObject = JSON.parseObject(otherParam);
    	try{
    		Integer memberId = user.getUserId();
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
    		Member member = memberService.selectById(memberId);
    		Integer orgId = member.getOrgid();
    		QuestionType aged = QuestionType.ONE;
    		QuestionType tcm = QuestionType.TWO;
    		Map<String,Object> mapEvaluate = new HashMap<String,Object>();
    		mapEvaluate.put("aged", getEvaluatePaper(orgId,aged,memberId));
    		mapEvaluate.put("tcm",  getEvaluatePaper(orgId,tcm,memberId));
    		if(!mapEvaluate.isEmpty()){
    			value.setStatusCode(0);
    			value.setMessage("查询健康评估问卷成功");
    			logger.info("查询健康评估问卷成功！");
    			value.setSuccess(true);
    			value.setData(mapEvaluate);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有健康评估问卷");
    			logger.info("没有健康评估问卷");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("查询健康评估问卷异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
    }
	
	/**
	 * @Description: 查询健康评估问卷明细
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月31日 
	 */
	public Object getEvaluatePaper(Integer orgId,QuestionType type,Integer memberId) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Omfq omfq = questionFacedeService.selectHealthexamQuestion(orgId, type);
		if(omfq != null){
			Integer qustid = omfq.getQustid();
			//健康问卷结论
			String healthConclusion = "";
			Double totalScore = 0d;
			String conclusion = "";
			Page<Ouai> page = new Page<Ouai>();
			OuaiExample example = new OuaiExample();
			Criteria criteria = example.createCriteria();
			criteria.andQustidEqualTo(qustid);
			criteria.andMemberidEqualTo(memberId);
			example.setOrderByClause("answerTime DESC,PublisherTime DESC");
			Page<Ouai> pages = answerFacedeService.selectSingleAnswerByExampleAndPage(page, example);
			if(pages != null && pages.getResult() != null && pages.getResult().size() >0){
				Ouai ouai = pages.getResult().get(0);
				Ouai singlePaper = answerFacedeService.selectSingleAnswerById(ouai.getAnsNumber());
	    		if(singlePaper != null){
	    			map.put("answerPaperId", singlePaper.getAnsNumber());
	    			map.put("questionnaireId", singlePaper.getQustid());
	    			Date publishTime = singlePaper.getPublisherTime();
	    			if(publishTime != null){
	    				map.put("sendoutTime", TimeUtil.formatDatetime2(publishTime));
	    			}
	    			map.put("answerPaperName", singlePaper.getOmfq().getQustname());
	    			Date answerTime = singlePaper.getAnswerTime();
	    			if(answerTime != null){
	    				map.put("answerTime", TimeUtil.formatDatetime2(answerTime));
	    			}
	    			map.put("paperStatus", singlePaper.getQustTag());
	    			map.put("sendoutDocId", singlePaper.getDocid());
	    			map.put("sendoutDocName", singlePaper.getDocName());
//	    			Uai3 audit = singlePaper.getUai3();
//	    			if(audit != null){
//	    				map.put("auditDocId", audit.getDocid());
//	    				map.put("auditDocName", singlePaper.getDocName());
//	    				map.put("auditDocSign", singlePaper.getDocName());
//	    				Date auditTime = audit.getAuditTime();
//	        			if(auditTime != null){
//	        				map.put("auditTime", TimeUtil.formatDatetime2(auditTime));
//	        			}
//	    				map.put("auditAdvise", audit.getAuditDesc());
//	    				map.put("auditDiagnosis", audit.getDiagnosis());
//	    			}
	    			Uai4 uai4 = singlePaper.getUai4();
	    			if(uai4 != null){
	    				totalScore = uai4.getScore();
	    				conclusion = uai4.getConclusion();
//	    				map.put("totalScore", totalScore);
//	        			map.put("conclusion", conclusion);
	        			if(type == QuestionType.ONE){
	        				healthConclusion = "得分：" + totalScore + "分" + Constants.LEFT_BRACKET + conclusion + Constants.RIGHT_BRACKET;
	        			}else{
	        				healthConclusion = conclusion;
	        			}
	    			}
	    			/* 所有问题     begin */
	    			List<Mfq1> problems = singlePaper.getOmfq().getMfq1s();
	    			if(problems != null && problems.size() >0){
	    				List<Map<String,Object>> problemMapList = new ArrayList<Map<String,Object>>();
	    				for(Mfq1 problem : problems){
	    					Map<String,Object> problemMap = new HashMap<String, Object>();
	    					int problemId = problem.getProblemid();
	    					problemMap.put("problemId", problemId);
	    					problemMap.put("problemType", problem.getAnsType());
	    					problemMap.put("problemName", problem.getProDesc());
	    					problemMap.put("problemLine", problem.getLineNum());
	    					problemMap.put("linkProblemId", problem.getUproblemid());
	    					problemMap.put("relationPreTitle", problem.getRelation());
	    					
	    					/* 所选答案id     begin */
	    					List<Uai21> answerList = uai21Service.selectByMasterId(singlePaper.getAnsNumber());
	    					List<Integer> answerIds = new ArrayList<Integer>();
	    	    			if(answerList != null && answerList.size()>0){
	    	    				for(Uai21 answer : answerList){
	    	    					Integer ansid = (int)answer.getAnsid();
	    	    					if(problemId == answer.getProblemid()){
	    	    						answerIds.add(ansid);
	    	    					}
	    	    				}
	    	    			}
	    	    			String answerId = StringUtils.collectionToCommaDelimitedString(answerIds);
	    					problemMap.put("answerId", answerId);
	    					/* 所选答案id     end */
	    					
	    					/* 所有答案选项     begin */
	    					List<Mfq11> options = problem.getMfq11s();
	    					if(options != null && options.size() >0){
	    	    				List<Map<String,Object>> optionMapList = new ArrayList<Map<String,Object>>();
	    	    				for(Mfq11 option : options){
	    	    					Map<String,Object> optionMap = new HashMap<String, Object>();
	    	    					optionMap.put("optionId", option.getAnsid());
	    	    					optionMap.put("optionName", option.getDescription());
	    	    					optionMap.put("mark", option.getMark());
	    	    					optionMap.put("score", option.getScore());
	    	    					optionMapList.add(optionMap);
	    	    				}
	    	    				problemMap.put("optionList", optionMapList);
	    					}
	    					/* 所有答案选项     end */
	    					
	    					problemMapList.add(problemMap);
	    				}
	    				map.put("problemList", problemMapList);
	    			}
	    		}
			}else{
				/*只查询问卷    begin*/
				/* 所有问题     begin */
				map.put("questionnaireId", qustid);
				map.put("answerPaperName", omfq.getQustname());
				map.put("paperStatus", "F");
				Omfq  omfqNew = questionFacedeService.selectSingleQuestionById(qustid);
    			List<Mfq1> problems = omfqNew.getMfq1s();
    			if(problems != null && problems.size() >0){
    				List<Map<String,Object>> problemMapList = new ArrayList<Map<String,Object>>();
    				for(Mfq1 problem : problems){
    					Map<String,Object> problemMap = new HashMap<String, Object>();
    					int problemId = problem.getProblemid();
    					problemMap.put("problemId", problemId);
    					problemMap.put("problemType", problem.getAnsType());
    					problemMap.put("problemName", problem.getProDesc());
    					problemMap.put("problemLine", problem.getLineNum());
    					problemMap.put("linkProblemId", problem.getUproblemid());
    					problemMap.put("relationPreTitle", problem.getRelation());
    					
    					/* 所有答案选项     begin */
    					List<Mfq11> options = problem.getMfq11s();	
    					if(options != null && options.size() >0){
    	    				List<Map<String,Object>> optionMapList = new ArrayList<Map<String,Object>>();
    	    				for(Mfq11 option : options){
    	    					Map<String,Object> optionMap = new HashMap<String, Object>();
    	    					optionMap.put("optionId", option.getAnsid());
    	    					optionMap.put("optionName", option.getDescription());
    	    					optionMap.put("mark", option.getMark());
    	    					optionMap.put("score", option.getScore());
    	    					optionMapList.add(optionMap);
    	    				}
    	    				problemMap.put("optionList", optionMapList);
    					}
    					/* 所有答案选项     end */
    					
    					problemMapList.add(problemMap);
    				}
    				map.put("problemList", problemMapList);
    			}
				/*只查询问卷    end*/
			}
			map.put("healthConclusion", healthConclusion);
		}else{
			return null;
		}
		return map;
    }
	
	/**
	 * @Description: 转化汇总报告列表返回值属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月9日 
	 */
	public List<Map<String,Object>> convertAnswerDataList(List<Answer> list,List<Integer> unreadMgsIds)throws Exception{
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		for(Answer answer : list){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("answerPaperId", answer.getId());
			map.put("memberId", answer.getMemberId());
			map.put("answerPaperName", answer.getQuestionName());
			Date date = answer.getPublisherTime();
			if(date != null){
				map.put("sendoutTime", TimeUtil.formatDate(date));
			}
			Byte answerPaperType = answer.getType();
			if(answerPaperType != null && answerPaperType == 1){
				map.put("answerPaperType", "single");
			}else if(answerPaperType != null && answerPaperType == 2){
				map.put("answerPaperType", "group");
			}
			String paperStatus = answer.getTag();
			map.put("paperStatus", paperStatus);
			String paperStatusStr = convertPaperStatusStr(answerPaperType,paperStatus);
			map.put("paperStatusStr", paperStatusStr);
//			//是否为未读消息 :0未读；1已读
//			int hasRead = 1;
//			if(unreadMgsIds != null && unreadMgsIds.size() > 0){
//				for(Integer msgId : unreadMgsIds){
//					if(msgId.equals(answer.getId())){
//						hasRead = 0;
//					}
//				}
//			}
//			map.put("hasRead",hasRead);
			mapList.add(map);
		}
		return mapList;
	}
	
	/**
	 * @Description: 获取中医体质问卷的结果 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月9日 
	 */
	public String getTCMResult(Map<String, Map<Double, String>> map)throws Exception{
		String result = null;
		Double qxzSocre = null;
		String qxzConclusion = "";
    	Set<Double> qxzScoreList = map.get("气虚质").keySet();
    	for(Double score : qxzScoreList){
    		qxzSocre = score;
    	}
    	qxzConclusion = "气虚质"  + Constants.LEFT_BRACKET + map.get("气虚质").get(qxzSocre) + Constants.RIGHT_BRACKET;
    	
    	Double yxzSocre = null;
		String yxzConclusion = "";
    	Set<Double> yxzScoreList = map.get("阳虚质").keySet();
    	for(Double score : yxzScoreList){
    		yxzSocre = score;
    	}
    	yxzConclusion = "阳虚质"  + Constants.LEFT_BRACKET + map.get("阳虚质").get(yxzSocre) + Constants.RIGHT_BRACKET;
    	
    	Double yixzSocre = null;
		String yixzConclusion = "";
    	Set<Double> yixzScoreList = map.get("阴虚质").keySet();
    	for(Double score : yixzScoreList){
    		yixzSocre = score;
    	}
    	yixzConclusion = "阴虚质"  + Constants.LEFT_BRACKET + map.get("阴虚质").get(yixzSocre) + Constants.RIGHT_BRACKET;
    	
    	Double tszSocre = null;
		String tszConclusion = "";
    	Set<Double> tszScoreList = map.get("痰湿质").keySet();
    	for(Double score : tszScoreList){
    		tszSocre = score;
    	}
    	tszConclusion = "痰湿质"  + Constants.LEFT_BRACKET + map.get("痰湿质").get(tszSocre) + Constants.RIGHT_BRACKET;
    	
    	Double srzSocre = null;
		String srzConclusion = "";
    	Set<Double> srzScoreList = map.get("湿热质").keySet();
    	for(Double score : srzScoreList){
    		srzSocre = score;
    	}
    	srzConclusion = "湿热质"  + Constants.LEFT_BRACKET + map.get("湿热质").get(srzSocre) + Constants.RIGHT_BRACKET;
    	
    	Double xyzSocre = null;
		String xyzConclusion = "";
    	Set<Double> xyzScoreList = map.get("血瘀质").keySet();
    	for(Double score : xyzScoreList){
    		xyzSocre = score;
    	}
    	xyzConclusion = "血瘀质"  + Constants.LEFT_BRACKET + map.get("血瘀质").get(xyzSocre) + Constants.RIGHT_BRACKET;
    	
    	Double qyzSocre = null;
		String qyzConclusion = "";
    	Set<Double> qyzScoreList = map.get("气郁质").keySet();
    	for(Double score : qyzScoreList){
    		qyzSocre = score;
    	}
    	qyzConclusion = "气郁质"  + Constants.LEFT_BRACKET + map.get("气郁质").get(qyzSocre) + Constants.RIGHT_BRACKET;
    	
    	Double tbzSocre = null;
		String tbzConclusion = "";
    	Set<Double> tbzScoreList = map.get("特禀质").keySet();
    	for(Double score : tbzScoreList){
    		tbzSocre = score;
    	}
    	tbzConclusion = "特禀质"  + Constants.LEFT_BRACKET + map.get("特禀质").get(tbzSocre) + Constants.RIGHT_BRACKET;
    	
    	Double phzSocre = null;
		String phzConclusion = "";
    	Set<Double> phzScoreList = map.get("平和质").keySet();
    	for(Double score : phzScoreList){
    		phzSocre = score;
    	}
    	phzConclusion = "平和质"  + Constants.LEFT_BRACKET + map.get("平和质").get(phzSocre) + Constants.RIGHT_BRACKET;
    	
    	result = qxzConclusion + "," + yxzConclusion + "," + yixzConclusion + "," + tszConclusion + "," +  srzConclusion + "," +  xyzConclusion+ "," +  qyzConclusion+ "," +  tbzConclusion +"," + phzConclusion;
		return result;
	}

	/**
	 * @Description: 转换问卷状态中文值
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月6日 
	 */
	public String convertPaperStatusStr(Byte answerPaperType,String paperStatus)throws Exception{
		String paperStatusStr = "";
		if(answerPaperType == 1){
			if(paperStatus.equals("F")){
				paperStatusStr = "未答";
			}else if(paperStatus.equals("B")){
				paperStatusStr = "暂存";
			}else if(paperStatus.equals("T")){
				paperStatusStr = "已答";
			}else if(paperStatus.equals("C")){
				paperStatusStr = "已审核";
			}
		}else{
			if(paperStatus.equals("0")){
				paperStatusStr = "未完成";
			}else if(paperStatus.equals("1")){
				paperStatusStr = "审核中";
			}else if(paperStatus.equals("2")){
				paperStatusStr = "已审核";
			}else if(paperStatus.equals("3")){
				paperStatusStr = "作答中";
			}
		}
		return paperStatusStr;
	}
	
}
