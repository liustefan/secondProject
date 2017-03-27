 
/**
 * @PackageName:      com.bithealth.questionCore.facede.service.impl
 * @FileName:     QuestionnaireFacedeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:07:24  
 * 
 */

package com.bithealth.questionCore.facede.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.questionCore.answer.service.AnswerService;
import com.bithealth.questionCore.enmu.ComQuestionStatusEnum;
import com.bithealth.questionCore.enmu.QuestionType;
import com.bithealth.questionCore.enmu.SingleQuestionStatusEnum;
import com.bithealth.questionCore.facede.service.QuestionFacedeService;
import com.bithealth.questionCore.question.model.Ocqt;
import com.bithealth.questionCore.question.model.OcqtExample;
import com.bithealth.questionCore.question.model.Omfq;
import com.bithealth.questionCore.question.model.OmfqExample;
import com.bithealth.questionCore.question.service.QuestionService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: QuestionnaireFacedeServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:07:24 
 * 
 * @author baozj
 * @version  
 */
@Service
public class QuestionFacedeServiceImpl implements
		QuestionFacedeService {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.QuestionFacedeService#insertOrUpdateQuestion(com.bithealth.questionCore.question.model.Omfq)
	 */
	public boolean insertOrUpdateQuestion(Omfq model) {
		
		Omfq pojo = questionService.selectSingleQuestionBaseInfoById(model.getQustid());
		if(pojo != null && pojo.isValid()){//生效问卷,重新生成一份草稿问卷，版本号加1
			return questionService.insertSingleQuestion(model) > 0;
		}else{
			int n = 0;
			n += questionService.insertOrUpdateSingleQuestionBaseInfo(model);
			n += questionService.insertOrUpdateSingleQuestionOptions(model.getQustid(), model.getMfq1s());
			n += questionService.insertOrUpdateSingleQuestionScoringRule(model.getQustid(), model.getMfq2(), model.getMfq21s());
			return n > 0;
		}
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.QuestionFacedeService#selectSingleQuestionNameUnique(java.lang.Integer, java.lang.String)
	 */
	public boolean selectSingleQuestionNameUnique(Integer orgId, String name) {
		
		return questionService.selectSingleQuestionNameUnique(orgId, name);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.QuestionFacedeService#selectComQuestionNameUnique(java.lang.Integer, java.lang.String)
	 */
	public boolean selectComQuestionNameUnique(Integer orgId, String name) {
		
		return questionService.selectComQuestionNameUnique(orgId, name);
	}
	
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.QuestionFacedeService#deleteSingleQuestion(java.lang.Integer[])
	 */
	public boolean deleteSingleQuestion(Integer... ids) {
		
		return questionService.deleteSingleQuestion(ids) > 0;
	}
	
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.QuestionFacedeService#selectSingleQuestionById(java.lang.Integer)
	 */
	public Omfq selectSingleQuestionById(Integer id) {
		if(id == null)
			return null;
		return questionService.selectSingleQuestionById(id);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.QuestionFacedeService#seelctSingleQuestionBaseInfoById(java.lang.Integer)
	 */
	public Omfq selctSingleQuestionBaseInfoById(Integer id) {
		
		if(id == null)
			return null;
		return questionService.selectSingleQuestionBaseInfoById(id);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.QuestionFacedeService#selectSingleQuestionCandelete(java.lang.Integer[])
	 */
	public boolean selectSingleQuestionCanDelete(Integer... ids) {
		if(ids == null)
			return false;
		for(Integer id : ids){
			Omfq pojo = questionService.selectSingleQuestionBaseInfoById(id);
			if(SingleQuestionStatusEnum.VALID.getCode().equals(pojo.getQustTag()) && (answerService.selectHasSingleAnswerReleased(id)
					|| questionService.selectHasSingleAssComQuestion(id))){//单份问卷已发放或组合问卷已关联
				return false;
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
	 *  @see com.bithealth.questionCore.facede.service.QuestionFacedeService#selectComQuestionCanDelete(java.lang.Integer[])
	 */
	public boolean selectComQuestionCanDelete(Integer... ids) {
		
		if(ids == null)
			return false;
		for(Integer id : ids){
			Ocqt pojo = questionService.selectComQuestionBaseInfoById(id);
			if(ComQuestionStatusEnum.VALID.getCode().equals(pojo.getQustTag()) && answerService.selectHasComAnswerReleased(id)){//组合问卷已发放
				return false;
			}
		}
		return true;
	}
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.QuestionFacedeService#selectSingleQuestionByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.questionCore.question.model.OmfqExample)
	 */
	public Page<Omfq> selectSingleQuestionByExampleAndPage(Page<Omfq> page,
			OmfqExample example) {
		
		return questionService.selectSingleQuestionByExampleAndPage(page, example);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.QuestionFacedeService#insertOrUpdateComQuestion(com.bithealth.questionCore.question.model.Ocqt)
	 */
	public boolean insertOrUpdateComQuestion(Ocqt model) {
		
		if(model.getCombQustid() == null){
			model.setCreateDate(TimeUtil.now());
			return questionService.insertComQuestion(model) > 0;
		}else{
			Ocqt pojo = questionService.selectComQuestionBaseInfoById(model.getCombQustid());
			if(pojo.isValid()){//生效问卷,重新生成一份草稿问卷，版本号加1
				model.setQustTag(SingleQuestionStatusEnum.DRAFT.getCode());
				return questionService.insertComQuestion(model) > 0;
			}
			return questionService.updateComQuestion(model) > 0;
		}
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.QuestionFacedeService#deleteComQuestion(java.lang.Integer[])
	 */
	public boolean deleteComQuestion(Integer... ids) {
		
		return questionService.deleteComQuestion(ids) > 0;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.QuestionFacedeService#selectComQuestionById(java.lang.Integer)
	 */
	public Ocqt selectComQuestionById(Integer id) {
		
		return questionService.selectComQuestionById(id);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.QuestionFacedeService#selectComQuestionByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.questionCore.question.model.OcqtExample)
	 */
	public Page<Ocqt> selectComQuestionByExampleAndPage(Page<Ocqt> page,
			OcqtExample example) {
		
		return questionService.selectComQuestionByExampleAndPage(page, example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.service.com.bithealth.questionCore.facede.service.QuestionFacedeService#exProcGetMyMemListByDocId(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.util.Map)
	 */
	public Page<MemberVo> exProcGetMyMemListByDocId(Page<MemberVo> page,
			Map<String, Object> params) {
		
		return questionService.exProcGetMyMemListByDocId(page, params);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.QuestionFacedeService#selectHealthexamQuestion(java.lang.Integer, java.lang.Integer)
	 */
	public Omfq selectHealthexamQuestion(Integer orgId, QuestionType type) {
		
		return questionService.selectHealthexamQuestion(orgId, type);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.QuestionFacedeService#hasDraft(java.lang.String, java.lang.Integer)
	 */
	public boolean hasDraft(String name, Integer orgId) {

		return questionService.hasDraft(name, orgId);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.QuestionFacedeService#hasComDraft(java.lang.String, java.lang.Integer)
	 */
	public boolean hasComDraft(String name, Integer orgId) {
		
		return questionService.hasComDraft(name, orgId);
	}
	
}

