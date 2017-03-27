 
/**
 * @PackageName:      com.bithealth.questionCore.facede.service.impl
 * @FileName:     AnswerFacedeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:06:49  
 * 
 */

package com.bithealth.questionCore.facede.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.chatCore.enmu.ChatRefTypeEnmu;
import com.bithealth.chatCore.enmu.RefStatusEnum;
import com.bithealth.chatCore.facade.service.ChatMessageFacadeService;
import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
import com.bithealth.questionCore.answer.model.Cam1;
import com.bithealth.questionCore.answer.model.Ocam;
import com.bithealth.questionCore.answer.model.OcamExample;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.answer.model.OuaiExample;
import com.bithealth.questionCore.answer.model.Uai21;
import com.bithealth.questionCore.answer.model.Uai4;
import com.bithealth.questionCore.answer.service.AnswerService;
import com.bithealth.questionCore.answer.service.OcamService;
import com.bithealth.questionCore.answer.service.OuaiService;
import com.bithealth.questionCore.dao.AnswerDao;
import com.bithealth.questionCore.enmu.ComAnswerStatusEnum;
import com.bithealth.questionCore.enmu.QuestionType;
import com.bithealth.questionCore.enmu.SingleAnswerStatusEnum;
import com.bithealth.questionCore.facede.service.AnswerFacedeService;
import com.bithealth.questionCore.model.Answer;
import com.bithealth.questionCore.question.model.Cqt1;
import com.bithealth.questionCore.question.model.Mfq2;
import com.bithealth.questionCore.question.model.Mfq21;
import com.bithealth.questionCore.question.model.Ocqt;
import com.bithealth.questionCore.question.model.Omfq;
import com.bithealth.questionCore.question.service.OmfqService;
import com.bithealth.questionCore.question.service.QuestionService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: AnswerFacedeServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:06:49 
 * 
 * @author baozj
 * @version  
 */
@Service
public class AnswerFacedeServiceImpl extends ChatMessageSendService implements AnswerFacedeService {
	
	@Autowired
	private AnswerService answerService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerDao answerDao;
//	@Autowired
//	private DoctorService doctorService;
	@Autowired
	private MessageCenterFacadeService messageCenterFacadeService;
//	@Autowired
//	private MemberService memberService;
	@Autowired
	OmfqService omfqService;
	@Autowired
	private OuaiService ouaiService;
	@Autowired
	OcamService ocamService;
	@Autowired
	ChatMessageFacadeService chatService;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.AnswerFacedeService#insertSingleAnswers(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer[])
	 */
	public boolean insertSingleAnswers(Integer qustId, Integer docId, String docName,
			Integer... memberIds) {
		Omfq omfq = questionService.selectSingleQuestionBaseInfoById(qustId);
		Map<Integer, Integer> map = insertCommonSingleAnswers(qustId, docId, docName, memberIds);
		if(omfq.getAnsMode().equals("1") && map.size() > 0){//自评问卷，发送消息
			for(Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext();){
				Entry<Integer, Integer> entry = it.next();
//				Member member = memberService.selectById(entry.getValue());
				sendChat(docId, entry.getValue(), ChatRefTypeEnmu.TYPE_SINGLE_PAPERS_PUBLIC, omfq.getQustname(), (long)entry.getKey(), RefStatusEnum.UNFINISHED);
			}
			return true;
		}
		return map.size() > 0;
	}
	
	private Map<Integer, Integer> insertCommonSingleAnswers(Integer qustId, Integer docId, String docName,
			Integer... memberIds){
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		try {
			if(memberIds != null && memberIds.length > 0){
				Omfq omfq = questionService.selectSingleQuestionBaseInfoById(qustId);
				Ouai model = new Ouai();
				BeanUtils.copyProperties(model, omfq);
				model.setDocid(docId);
				model.setDocName(docName);
				model.setQustTag(SingleAnswerStatusEnum.UNANSWERED.getCode());
				model.setPublisherTime(new Date());
				model.setFailureTime(DateUtils.addDays(model.getPublisherTime(), 3));
				for(Integer memberId : memberIds){
					model.setMemberid(memberId);
					answerService.insertSingleAnswer(model);
					map.put(model.getAnsNumber(), memberId);
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.AnswerFacedeService#selectSingleAnswerById(java.lang.Integer)
	 */
	public Ouai selectSingleAnswerById(Integer ansNumber) {
		
		Ouai model = answerService.selectSingleAnswerById(ansNumber);
		model.setOmfq(questionService.selectSingleQuestionById(model.getQustid()));
		if(model.getOmfq() != null)
			model.getOmfq().setAnswer(model.getUai21s());
		return model;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.AnswerFacedeService#selectSingleAnswerByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.questionCore.answer.model.OuaiExample)
	 */
	public Page<Ouai> selectSingleAnswerByExampleAndPage(Page<Ouai> page,
			OuaiExample example) {
		
		return answerService.selectSingleAnswerByExampleAndPage(page, example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.AnswerFacedeService#insertSingleAnswerResult(java.util.List, java.lang.Integer)
	 */
	public boolean insertSingleAnswerResult(List<Uai21> results,
			Ouai model) {
		Ouai pojo = selectSingleAnswerById(model.getAnsNumber());
		if(SingleAnswerStatusEnum.ANSWERED.getCode().equals(pojo.getQustTag()))//已作答
			return false;
		
		if(answerService.insertSingleAnswerResult(results, pojo)){//输入单份答卷答案
			if(SingleAnswerStatusEnum.STAGING.getCode().equals(model.getQustTag())){//暂存单份答卷
				answerService.updateSingleAnswerStatusAndProduceAudit(SingleAnswerStatusEnum.STAGING, pojo);
			}else{//提交单份答卷，统计分数，得出结论
				double score = sum(results, pojo.getOmfq().getMfq2());
				List<Mfq21> mfq21s = pojo.getOmfq().getMfq21s();
				Mfq21 conclusion = null;
				for(Mfq21 mfq21 : mfq21s){
					if(score >= mfq21.getMinScore() && score <= mfq21.getMaxScore()){
						conclusion = mfq21;
						break;
					}
				}
				Uai4 uai4 = new Uai4();
				uai4.setAnsNumber(model.getAnsNumber());
				uai4.setLineNum(pojo.getOmfq().getMfq2().getLineNum());
				uai4.setScore(score);
				uai4.setConclusion(conclusion == null ? "分数值未在答卷结果判定条件内" : conclusion.getConclusion());
				answerService.insertConclusion(uai4);//设置结论
				answerService.updateSingleAnswerStatusAndProduceAudit(SingleAnswerStatusEnum.ANSWERED, pojo);//单份答卷标记为已答
				model.setUai4(uai4);
				if((model.getIsComAnswer() == null || !model.getIsComAnswer()) && "1".equals(pojo.getOmfq().getAnsMode()))
					sendChat(pojo.getDocid(), pojo.getMemberid(), ChatRefTypeEnmu.TYPE_SINGLE_PAPERS_PUBLIC, pojo.getOmfq().getQustname(), pojo.getAnsNumber().longValue(), RefStatusEnum.COMPLETED);
			}
		}
		return true;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AnswerFacedeService#insertTaskSingleAnswerResult(java.util.List, com.bithealth.questionCore.answer.model.Ouai)
	 */
	@Override
	public boolean insertTaskSingleAnswerResult(List<Uai21> results, Ouai model) {
		
		Ouai pojo = selectSingleAnswerById(model.getAnsNumber());
		if(SingleAnswerStatusEnum.ANSWERED.getCode().equals(pojo.getQustTag()))//已作答
			return false;
		
		if(answerService.insertSingleAnswerResult(results, pojo)){//输入单份答卷答案
			if(SingleAnswerStatusEnum.STAGING.getCode().equals(model.getQustTag())){//暂存单份答卷
				answerService.updateSingleAnswerStatusAndProduceAudit(SingleAnswerStatusEnum.STAGING, pojo);
			}else{//提交单份答卷，统计分数，得出结论
				double score = sum(results, pojo.getOmfq().getMfq2());
				List<Mfq21> mfq21s = pojo.getOmfq().getMfq21s();
				Mfq21 conclusion = null;
				for(Mfq21 mfq21 : mfq21s){
					if(score >= mfq21.getMinScore() && score <= mfq21.getMaxScore()){
						conclusion = mfq21;
						break;
					}
				}
				Uai4 uai4 = new Uai4();
				uai4.setAnsNumber(model.getAnsNumber());
				uai4.setLineNum(pojo.getOmfq().getMfq2().getLineNum());
				uai4.setScore(score);
				uai4.setConclusion(conclusion == null ? "分数值未在答卷结果判定条件内" : conclusion.getConclusion());
				answerService.insertConclusion(uai4);//设置结论
				answerService.updateSingleAnswerStatusAndProduceAudit(SingleAnswerStatusEnum.ANSWERED, pojo);//单份答卷标记为已答
				model.setUai4(uai4);
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @Title:sum 
	 * @Description:求和 
	 * TODO  
	 * @author baozj
	 * @param uai21List
	 * @param mfq2
	 * @return 
	 * @throws
	 * @retrun double
	 */
	private double sum(List<Uai21> uai21List, Mfq2 mfq2){
		double score = 0;
		for(Iterator<Uai21> it = uai21List.iterator(); it.hasNext();){
			Uai21 pojo = it.next();
			if(mfq2 == null){
				score = score + pojo.getScore();
			}else{
				for(int i = 0; i < mfq2.getProblemIds().length; i++){
					if(pojo.getProblemid().equals(mfq2.getProblemIds()[i])){
						score = score + pojo.getScore();
					}
				}
			}
		}
		return score;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.AnswerFacedeService#insertComAnswers(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer[])
	 */
	public boolean insertComAnswers(Integer combQustId, Integer docId,
			String docName, Integer... memberIds) {
		
		try {
			int n = 0;
			Ocqt ocqt = questionService.selectComQuestionById(combQustId);
			Map<Integer, Integer> idAndMemberId = new HashMap<Integer, Integer>();
			if(memberIds != null && memberIds.length > 0){
				Ocam model = new Ocam();
				Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
				BeanUtils.copyProperties(model, ocqt);
				model.setDocid(docId);
				model.setDocName(docName);
				model.setCombTag(ComAnswerStatusEnum.UNFINISHED.getCode());
				model.setPublisherTime(new Date());
				for(Integer memberId : memberIds){
					model.setMemberid(memberId);
					n += answerService.insertComAnswer(model);//组合答卷主表
					map.put(model.getCombAnsid(), new HashMap<Integer, Integer>());
					idAndMemberId.put(model.getCombAnsid(), memberId);
					for(Iterator<Cqt1> it = ocqt.getCqt1s().iterator(); it.hasNext();){
						Cqt1 pojo = it.next();
						map.get(model.getCombAnsid()).putAll(insertCommonSingleAnswers(pojo.getQustid(), docId, docName, memberId));//组合答卷中的单份答卷主表
					}
				}
				for(Iterator<Entry<Integer, Map<Integer, Integer>>> it = map.entrySet().iterator(); it.hasNext();){
					Entry<Integer, Map<Integer, Integer>> entry = it.next();
					for(Iterator<Entry<Integer, Integer>> itV = entry.getValue().entrySet().iterator(); itV.hasNext();){
						Entry<Integer, Integer> entryV = itV.next();
						Cam1 cam1 = new Cam1(); 
						cam1.setCombAnsid(entry.getKey());
						cam1.setAnsNumber(entryV.getKey());
						cam1.setAnsTag("N");
						answerService.insertComContactSingleAnswer(cam1);
					}
				}
			}
			if(n > 0){
				for(Iterator<Entry<Integer, Integer>> it = idAndMemberId.entrySet().iterator(); it.hasNext();){
					Entry<Integer, Integer> entry = it.next();
//					Member member = memberService.selectById(entry.getValue());
					sendChat(docId, entry.getValue(), ChatRefTypeEnmu.TYPE_COMBINATION_AUDIT_PUBLIC, ocqt.getCombQustName(), (long)entry.getKey(), RefStatusEnum.UNFINISHED);
				}
				return true;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.AnswerFacedeService#insertComAnswerResult(java.util.List, com.bithealth.questionCore.answer.model.Ouai, java.lang.Integer)
	 */
	public boolean insertComAnswerResult(List<Uai21> results, Ouai model,
			Integer combQustId) {
		model.setIsComAnswer(true);
		if(insertSingleAnswerResult(results, model)){
			Ocam ocam = answerService.selectComAnswerById(combQustId);
			ComAnswerStatusEnum status = ComAnswerStatusEnum.COMPLETED;
			RefStatusEnum refStatus = RefStatusEnum.COMPLETED;
			for(Iterator<Cam1> it = ocam.getCam1s().iterator(); it.hasNext();){
				Cam1 cam1 = it.next();
				if(SingleAnswerStatusEnum.UNANSWERED.getCode().equals(cam1.getOuai().getQustTag()) || SingleAnswerStatusEnum.STAGING.getCode().equals(cam1.getOuai().getQustTag())){
					status = ComAnswerStatusEnum.STAGING;
					refStatus = RefStatusEnum.UNFINISHED;
				}
			}
			
			answerService.updateComAnswerStatus(status, ocam);
			if(RefStatusEnum.COMPLETED.equals(refStatus))
				sendChat(ocam.getDocid(), ocam.getMemberid(), ChatRefTypeEnmu.TYPE_COMBINATION_AUDIT_PUBLIC, ocam.getCombQustName(), combQustId.longValue(), RefStatusEnum.COMPLETED);
//			chatService.updateStatusByRefid(ChatRefTypeEnmu.TYPE_COMBINATION_AUDIT_PUBLIC.getType(), ocam.getCombAnsid().longValue(), refStatus.getCode());
			return true;
		}
		return false;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.AnswerFacedeService#selectComAnswerById(java.lang.Integer)
	 */
	public Ocam selectComAnswerById(Integer combAnsid) {
		
		return answerService.selectComAnswerById(combAnsid);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.AnswerFacedeService#selectComAnswerByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.questionCore.answer.model.OcamExample)
	 */
	public Page<Ocam> selectComAnswerByExampleAndPage(Page<Ocam> page,
			OcamExample example) {
		
		return answerService.selectComAnswerByExampleAndPage(page, example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 *  @see com.bithealth.questionCore.facede.service.AnswerFacedeService#insertSingleAnswerResult(java.util.List, java.lang.Integer, java.lang.Long, java.lang.Integer)
	 */
	public Map<String, Map<Double, String>> insertSingleAnswerResult(List<Uai21> results, Integer answerId,
			Integer qustId, Long HExamID, Integer memberId, SingleAnswerStatusEnum status) throws IllegalAccessException, InvocationTargetException {

		Ouai model;
		if(answerId == null){
			Omfq omfq = questionService.selectSingleQuestionById(qustId);
			model = new Ouai();
			BeanUtils.copyProperties(model, omfq);
			model.setQustTag(SingleAnswerStatusEnum.APPROVED.getCode());
			model.setPublisherTime(new Date());
			model.setFailureTime(DateUtils.addDays(model.getPublisherTime(), 3));
			model.setMemberid(memberId);
			model.setHExamID(HExamID);
			answerService.insertSingleAnswer(model);
			model.setOmfq(omfq);
		}else{
			model = selectSingleAnswerById(answerId);
		}
		if(answerService.insertSingleAnswerResult(results, model)){//输入单份答卷答案
			answerService.updateSingleAnswerStatus(status, model);
			if(!SingleAnswerStatusEnum.STAGING.equals(status)){//暂存计算结论，不返回结论
				//计算结论
				Uai4 uai4 = new Uai4();
				uai4.setAnsNumber(model.getAnsNumber());
				uai4.setLineNum((short)1);
				if(QuestionType.ONE.getName().equals(model.getOmfq().getQustname())){
					return sumHealthexam(QuestionType.ONE, results, model.getOmfq().getMfq2(), uai4);
				}else if(QuestionType.TWO.getName().equals(model.getOmfq().getQustname())){
					return sumHealthexam(QuestionType.TWO, results, null, uai4);
				}
			}
		}
		return new HashMap<String, Map<Double,String>>();
	}
	
	private Map<String, Map<Double, String>> sumHealthexam(QuestionType type, List<Uai21> results, Mfq2 mfq2, Uai4 uai4){
		Map<String, Map<Double, String>> maps = new HashMap<String, Map<Double,String>>();
		double score = 0;
		if(type == QuestionType.ONE){
			score = sum(results, mfq2);
			//0～3分者为可自理； 4～8分者为轻度依赖；9～18分者为中度依赖； ³19分者为不能自理
			Map<Double, String> map = new HashMap<Double, String>();
			if(score >= 0 && score <=3){
				map.put(score, "可自理");
			}else if(score >= 4 && score <=8){
				map.put(score, "轻度依赖");
			}else if(score >= 9 && score <=18){
				map.put(score, "中度依赖");
			}else if(score >=19){
				map.put(score, "不能自理");
			}
			maps.put(QuestionType.ONE.getName(), map);
			uai4.setScore(score);
			uai4.setConclusion(map.get(score));
			answerService.insertConclusion(uai4);//设置结论
		}else if(type == QuestionType.TWO){
			List<Double> scoreList = new ArrayList<Double>();
			maps.put("气虚质", getMap(results, scoreList, "气虚质", uai4, 2, 3, 4, 14));
			maps.put("阳虚质", getMap(results, scoreList, "阳虚质", uai4, 11, 12, 13, 29));
			maps.put("阴虚质", getMap(results, scoreList, "阴虚质", uai4, 10, 21, 26, 31));
			maps.put("痰湿质", getMap(results, scoreList, "痰湿质", uai4, 9, 16, 28, 32));
			maps.put("湿热质", getMap(results, scoreList, "湿热质", uai4, 23, 25, 27, 30));
			maps.put("血瘀质", getMap(results, scoreList, "血瘀质", uai4, 19, 22, 24, 33));
			maps.put("气郁质", getMap(results, scoreList, "气郁质", uai4, 5, 6, 7, 8));
			maps.put("特禀质", getMap(results, scoreList, "特禀质", uai4, 15, 17, 18, 20));
			Integer[] problemIds = {1, 2, 4, 5, 13};
			score = 0;
			for(Integer problemId : problemIds){
				for(Iterator<Uai21> it = results.iterator(); it.hasNext();){
					Uai21 pojo = it.next();
					if(problemId.equals(pojo.getProblemid())){
						if(problemId.equals(1)){
							score += pojo.getScore();
						}else{//反向计分，即1→5，2→4，3→3，4→2，5→1
							if(pojo.getAnsid().equals(1)){
								score += 5;
							}else if(pojo.getAnsid().equals(2)){
								score += 4;
							}else if(pojo.getAnsid().equals(3)){
								score += 3;
							}else if(pojo.getAnsid().equals(4)){
								score += 2;
							}else if(pojo.getAnsid().equals(5)){
								score += 1;
							}
						}
					}
				}
			}
			Map<Double, String> map = new HashMap<Double, String>();
			if(score >= 17 && lessThan(scoreList, 8d)){
				map.put(score, "是");
			}else if(score >= 17 && lessThan(scoreList, 10d)){
				map.put(score, "基本是");
			}else{
				map.put(score, "否");
			}
			maps.put("平和质", map);
			uai4.appendConclusion("平和质("+map.get(score)+")");
			uai4.setScore(sum(results, mfq2));
			answerService.insertConclusion(uai4);//设置结论
		}
		return maps;
	}
	
	private boolean lessThan(List<Double> scoreList, Double value){
		for(Double score : scoreList){
			if(score >= value)
				return false;
		}
		return true;
	}
	
	private Map<Double, String> getMap(List<Uai21> results, List<Double> scoreList, String typeName, Uai4 uai4, Integer...problemIds){
		Map<Double, String> map = new HashMap<Double, String>();
		double score = 0;
		for(Integer problemId : problemIds){
			for(Iterator<Uai21> it = results.iterator(); it.hasNext();){
				Uai21 pojo = it.next();
				if(problemId.equals(pojo.getProblemid())){
					score += pojo.getScore();
				}
			}
		}
		if(score >= 11){
			map.put(score, "是");
		}else if(score >= 9 && score <= 10){
			map.put(score, "倾向是");
		}else if(score <= 8){
			map.put(score, "否");
		}
		uai4.appendConclusion(typeName + "("+map.get(score)+")");
		scoreList.add(score);
		return map;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AnswerFacedeService#selectHealthexamAnswer(java.lang.Long, java.lang.Integer)
	 */
	public Ouai selectHealthexamAnswer(Long HExamID, QuestionType type) {
		
		List<Ouai> list = answerService.selectHealthexamAnswer(HExamID);
		if(list != null && !list.isEmpty()){
			for(Ouai ouai : list){
				ouai.setOmfq(questionService.selectSingleQuestionById(ouai.getQustid()));
				if(ouai.getOmfq() != null && type.getName().equals(ouai.getOmfq().getQustname()))
					return ouai;
			}
		}
		return null;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AnswerFacedeService#deleteSingleAnswers(java.lang.Integer)
	 */
	@Override
	public boolean deleteSingleAnswers(Integer...ansNumbers) {
		for(Integer id : ansNumbers){
			Ouai ouai = ouaiService.selectById(id);
			if(ouai != null){
				Omfq omfq = omfqService.selectById(ouai.getQustid());
				if("1".equals(omfq.getAnsMode()))
					sendChat(ouai.getDocid(), ouai.getMemberid(), ChatRefTypeEnmu.TYPE_SINGLE_PAPERS_PUBLIC, omfq.getQustname(), id.longValue(), RefStatusEnum.WITHDRAWN);
			}
		}
		return answerService.deleteSingleAnswers(ansNumbers);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AnswerFacedeService#deleteComAnswers(java.lang.Integer)
	 */
	@Override
	public boolean deleteComAnswers(Integer...combAnsid) {
		for(Integer id : combAnsid){
			Ocam ocam = ocamService.selectById(id);
			if(ocam != null)
				sendChat(ocam.getDocid(), ocam.getMemberid(), ChatRefTypeEnmu.TYPE_COMBINATION_AUDIT_PUBLIC, ocam.getCombQustName(), id.longValue(), RefStatusEnum.WITHDRAWN);
		}
		return answerService.deleteComAnswers(combAnsid);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AnswerFacedeService#selectPrintSingleQuestionInfoByIds(java.lang.Integer[])
	 */
	@Override
	public List<Ouai> selectPrintSingleQuestionInfoByIds(Integer... ansNumbers) {
		List<Ouai> list = new ArrayList<Ouai>();
		if(ansNumbers != null && ansNumbers.length > 0){
			for(Integer ansNumber : ansNumbers){
				Ouai ouai = answerService.selectSingleAnswerById(ansNumber);
				if(ouai != null){
					ouai.setOmfq(questionService.selectSingleQuestionById(ouai.getQustid()));
					if(ouai.getOmfq() != null)
						ouai.getOmfq().setAnswer(ouai.getUai21s());
					list.add(ouai);
				}
			}
		}
		return list;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AnswerFacedeService#selectPrintComQuestionInfoByIds(java.lang.Integer[])
	 */
	@Override
	public List<Ocam> selectPrintComQuestionInfoByIds(Integer... combAnsIds) {
		List<Ocam> list = new ArrayList<Ocam>();
		if(combAnsIds != null && combAnsIds.length > 0){
			for(Integer combAnsId : combAnsIds){
				Ocam ocam = answerService.selectComAnswerById(combAnsId);
				if(ocam != null){
					for(Cam1 cam1 : ocam.getCam1s()){
						if(ocam.getOuais() == null)
							ocam.setOuais(new ArrayList<Ouai>());
						ocam.getOuais().add(selectSingleAnswerById(cam1.getAnsNumber()));
					}
					list.add(ocam);
				}
			}
		}
		return list;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AnswerFacedeService#selectAnswerPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.lang.Integer, java.lang.Boolean)
	 */
	@Override
	public Page<Answer> selectAnswerPage(Page<Answer> page, Integer memberId,
			boolean finished) {
		answerDao.selectAnswerPage(page, memberId, finished);
		return page;
	}
	
//	/** 
//	 * @Title: send 
//	 * @Description: TODO 简单描述该方法的实现功能（可选）.
//	 * @param  
//	 * @throws      
//	 * @retrun  
//	 *  @see com.bithealth.questionCore.facede.service.AnswerFacedeService#selectSingleAnswerByCombAnsIds(java.lang.Integer)
//	 */
//	@Override
//	public List<Ouai> selectSingleAnswerByCombAnsIds(Integer combAnsId) {
//		
//		Ouai model = answerService.selectSingleAnswerById(ansNumber);
//		model.setOmfq(questionService.selectSingleQuestionById(model.getQustid()));
//		return model;
//		return null;
//	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AnswerFacedeService#selectOuaiByMSETaskID(java.lang.Long)
	 */
	@Override
	public Ouai selectOuaiByMSETaskID(Long MSETaskID) {
		
		OuaiExample example = new OuaiExample();
		example.createCriteria().andMSETaskIDEqualTo(MSETaskID);
		List<Ouai> list = ouaiService.selectByExample(example);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AnswerFacedeService#insertSingleAnswer(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Ouai insertSingleAnswer(Integer qustId, Integer memberId, Integer docId, String docName, Long MSETaskID) {
		
		try {
			Omfq omfq = questionService.selectSingleQuestionById(qustId);
			Ouai model = new Ouai();
			BeanUtils.copyProperties(model, omfq);
			model.setQustTag(SingleAnswerStatusEnum.UNANSWERED.getCode());
			model.setPublisherTime(new Date());
			model.setFailureTime(DateUtils.addDays(model.getPublisherTime(), 3));
			model.setMemberid(memberId);
			model.setDocid(docId);
			model.setDocName(docName);
			model.setMSETaskID(MSETaskID);
			if(answerService.insertSingleAnswer(model) > 0){
				return model;
			}
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}

