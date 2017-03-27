 
/**
 * @PackageName:      com.bithealth.questionCore.service.impl
 * @FileName:     QuestionnaireServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:05:39  
 * 
 */

package com.bithealth.questionCore.question.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.questionCore.dao.MemberDao;
import com.bithealth.questionCore.enmu.ComQuestionStatusEnum;
import com.bithealth.questionCore.enmu.QuestionType;
import com.bithealth.questionCore.enmu.SingleQuestionStatusEnum;
import com.bithealth.questionCore.question.model.Cqt1Example;
import com.bithealth.questionCore.question.model.Logics;
import com.bithealth.questionCore.question.model.Mfq1;
import com.bithealth.questionCore.question.model.Mfq2;
import com.bithealth.questionCore.question.model.Mfq21;
import com.bithealth.questionCore.question.model.Ocqt;
import com.bithealth.questionCore.question.model.OcqtExample;
import com.bithealth.questionCore.question.model.Omfq;
import com.bithealth.questionCore.question.model.OmfqExample;
import com.bithealth.questionCore.question.service.Cqt1Service;
import com.bithealth.questionCore.question.service.LogicsService;
import com.bithealth.questionCore.question.service.Mfq11Service;
import com.bithealth.questionCore.question.service.Mfq1Service;
import com.bithealth.questionCore.question.service.Mfq21Service;
import com.bithealth.questionCore.question.service.Mfq2Service;
import com.bithealth.questionCore.question.service.OcqtService;
import com.bithealth.questionCore.question.service.OmfqService;
import com.bithealth.questionCore.question.service.QuestionService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: QuestionnaireServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:05:39 
 * 
 * @author baozj
 * @version  
 */
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private OmfqService omfqService;
	@Autowired
	private Mfq1Service mfq1Service;
	@Autowired
	private Mfq11Service mfq11Service;
	@Autowired
	private LogicsService logicsService;
	@Autowired
	private Mfq2Service mfq2Service;
	@Autowired
	private Mfq21Service mfq21Service;
	@Autowired
	private OcqtService	ocqtService;
	@Autowired
	private Cqt1Service cqt1Service;
	@Autowired
	private MemberDao memberDao;
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#insertOrUpdateSingleQuestionBaseInfo(com.bithealth.questionCore.question.model.Omfq)
	 */
	public int insertOrUpdateSingleQuestionBaseInfo(Omfq model) {
		int n = 0;
		if(model.getQustid() == null){
			if(model.getQustTag() == null)
				model.setQustTag(SingleQuestionStatusEnum.DRAFT.getCode());
			model.setQustCode(omfqService.selectSingleQuestionMaxQustCode(model.getOrgId(), SingleQuestionStatusEnum.DELETED.getCode()));
			model.setQustVer(omfqService.selectSingleQuestionMaxQustVerByName(model.getOrgId(), model.getQustname(), SingleQuestionStatusEnum.VALID.getCode()));
			model.setCreateDate(TimeUtil.now());
			n += omfqService.insert(model);
		}else{
			n += omfqService.update(model);
		}
		return n;
	}
	
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#insertOrUpdateSingleQuestionOptions(java.lang.Integer, java.util.List)
	 */
	public int insertOrUpdateSingleQuestionOptions(Integer masterId, List<Mfq1> list) {
		int n  = 0;
		if(list != null){
			n += mfq1Service.deleteByMasterId(masterId);
			n += mfq11Service.deleteByMasterId(masterId);
			n += logicsService.deleteByMasterId(masterId);
			for(Iterator<Mfq1> it = list.iterator(); it.hasNext();){
				Mfq1 model = it.next();
				model.setQustid(masterId);
				n += mfq1Service.insert(model);
				n += mfq11Service.inserts(masterId, model.getProblemid(), model.getMfq11s());
				n += logicsService.inserts(masterId, model.getProblemid(), model.getLogicses());
			}
		}
		return n;
	}
	
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#insertOrUpdateSingleQuestionLogics(java.lang.Integer, java.util.List)
	 */
	public int insertOrUpdateSingleQuestionLogics(Integer masterId, List<Logics> list) {
		int n = 0;
		n += logicsService.deleteByMasterId(masterId);
		n += logicsService.inserts(masterId, null, list);
		return n;
	}
	
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#insertOrUpdateSingleQuestionScoringRule(java.lang.Integer, java.util.List, java.util.List)
	 */
	public int insertOrUpdateSingleQuestionScoringRule(Integer masterId, Mfq2 mfq2, List<Mfq21> mfq21) {
		
		int n  = 0;
		n += mfq2Service.deleteByMasterId(masterId);
		n += mfq21Service.deleteByMasterId(masterId);
		if(mfq2 != null){
			mfq2.setLineNum((short)1);
			n += mfq2Service.insert(masterId, mfq2);
			n += mfq21Service.inserts(masterId, mfq21);
		}
		return n;
	}
	
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#insertSingleQuestion(com.bithealth.questionCore.question.model.Omfq)
	 */
	public int insertSingleQuestion(Omfq omfq) {
		int n  = 0;
		omfq.setQustTag(SingleQuestionStatusEnum.DRAFT.getCode());
		omfq.setQustCode(omfqService.selectSingleQuestionMaxQustCode(omfq.getOrgId(), SingleQuestionStatusEnum.DELETED.getCode()));
		omfq.setQustVer(omfqService.selectSingleQuestionMaxQustVerByName(omfq.getOrgId(), omfq.getQustname(), SingleQuestionStatusEnum.VALID.getCode()));
		omfq.setCreateDate(TimeUtil.now());
		n += omfqService.insert(omfq);
		if(omfq.getMfq1s() != null && omfq.getMfq1s().size() > 0){
			for(Iterator<Mfq1> it = omfq.getMfq1s().iterator(); it.hasNext();){
				Mfq1 model = it.next();
				model.setQustid(omfq.getQustid());
				n += mfq1Service.insert(model);
				n += mfq11Service.inserts(model.getQustid(), model.getProblemid(), model.getMfq11s());
				n += logicsService.inserts(omfq.getQustid(), model.getProblemid(), model.getLogicses());
			}
		}
		n += mfq2Service.insert(omfq.getQustid(), omfq.getMfq2());
		n += mfq21Service.inserts(omfq.getQustid(), omfq.getMfq21s());
		return n;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#selectSingleQuestionNameUnique(java.lang.Integer, java.lang.String)
	 */
	public boolean selectSingleQuestionNameUnique(Integer orgId, String name) {
		OmfqExample example = new OmfqExample();
		example.createCriteria().andOrgIdEqualTo(orgId).andQustnameEqualTo(name).andQustTagNotEqualTo(SingleQuestionStatusEnum.DELETED.getCode());
		List<Omfq> list = omfqService.selectByExample(example);
		return list == null || list.isEmpty();
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#selectComQuestionNameUnique(java.lang.Integer, java.lang.String)
	 */
	public boolean selectComQuestionNameUnique(Integer orgId, String name) {
		
		OcqtExample example = new OcqtExample();
		example.createCriteria().andOrgIdEqualTo(orgId).andCombQustNameEqualTo(name).andQustTagNotEqualTo(ComQuestionStatusEnum.DELETED.getCode());
		List<Ocqt> list = ocqtService.selectByExample(example);
		return list == null || list.isEmpty();
	}
	
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#deleteSingleQuestion(java.lang.Integer[])
	 */
	public int deleteSingleQuestion(Integer... ids) {
		int n = 0;
		if(ids != null && ids.length > 0){
			List<Integer> values = Arrays.asList(ids);
			n += omfqService.deleteByMasterId(values);
			n += mfq1Service.deleteByMasterId(values);
			n += mfq11Service.deleteByMasterId(values);
			n += logicsService.deleteByMasterId(values);
			n += mfq2Service.deleteByMasterId(values);
			n += mfq21Service.deleteByMasterId(values);
		}
		return n;
	}
	
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#selectSingleQuestionById(java.lang.Integer)
	 */
	public Omfq selectSingleQuestionById(Integer id) {
		Omfq model = omfqService.selectById(id);
		if(model != null){
			model.setMfq1s(mfq1Service.selectByMasterId(model.getQustid()));
			if(model.getMfq1s() != null && model.getMfq1s().size() > 0){
				for(Iterator<Mfq1> it = model.getMfq1s().iterator(); it.hasNext();){
					Mfq1 mfq1 = it.next();
					mfq1.setMfq11s(mfq11Service.selectByMasterId(model.getQustid(), mfq1.getProblemid()));
					mfq1.setLogicses(logicsService.selectByMasterId(model.getQustid(), mfq1.getProblemid()));
				}
			}
			List<Mfq2> mfq2s = mfq2Service.selectByMasterId(model.getQustid());
			if(mfq2s != null && !mfq2s.isEmpty())
				model.setMfq2(mfq2s.get(0));
			model.setMfq21s(mfq21Service.selectByMasterId(model.getQustid()));
		}
		return model;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#selectSingleQuestionBaseInfoById(java.lang.Integer)
	 */
	public Omfq selectSingleQuestionBaseInfoById(Integer id) {
		if(id == null)
			return null;
		return omfqService.selectById(id);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#selectComQuestionBaseInfoById(java.lang.Integer)
	 */
	public Ocqt selectComQuestionBaseInfoById(Integer id) {
		
		return ocqtService.selectById(id);
	}
	
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#selectSingleQuestionByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.questionCore.question.model.OmfqExample)
	 */
	public Page<Omfq> selectSingleQuestionByExampleAndPage(Page<Omfq> page,
			OmfqExample example) {
		if(example == null)
			example = new OmfqExample();
		if(example.getOredCriteria().size() == 0)
			example.createCriteria();
		example.getOredCriteria().get(0).andQustTagNotEqualTo(SingleQuestionStatusEnum.DELETED.getCode());	
		omfqService.selectByExampleAndPage(page, example);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#insertComQuestion(com.bithealth.questionCore.question.model.Ocqt)
	 */
	public int insertComQuestion(Ocqt model) {
		if(model.getQustTag() == null)
			model.setQustTag(SingleQuestionStatusEnum.DRAFT.getCode());
		model.setCombQustCode(ocqtService.selectComQuestionMaxQustCode(model.getOrgId(), ComQuestionStatusEnum.DELETED.getCode()));
		model.setQustVer(ocqtService.selectComQuestionMaxQustVerByName(model.getOrgId(), model.getCombQustName(), ComQuestionStatusEnum.VALID.getCode()));
		int n = ocqtService.insert(model);
		n += cqt1Service.inserts(model.getCombQustid(), model.getCqt1s());
		return n;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#updateComQuestion(com.bithealth.questionCore.question.model.Ocqt)
	 */
	public int updateComQuestion(Ocqt model) {
		
		int n = ocqtService.update(model);
		n += cqt1Service.updates(model.getCombQustid(), model.getCqt1s());
		return n;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#deleteComQuestion(java.lang.Integer[])
	 */
	public int deleteComQuestion(Integer... ids) {
		int n = 0;
		if(ids != null && ids.length > 0){
			List<Integer> values = Arrays.asList(ids);
			n += ocqtService.deleteByMasterId(values);
			n += cqt1Service.deleteByMasterId(values);
		}
		return n;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#selectComQuestionById(java.lang.Integer)
	 */
	public Ocqt selectComQuestionById(Integer id) {
		
		Ocqt model = ocqtService.selectById(id);
		if(model != null){
			model.setCqt1s(cqt1Service.selectByMasterId(id));
		}
		return model;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#selectComQuestionByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.questionCore.question.model.OcqtExample)
	 */
	public Page<Ocqt> selectComQuestionByExampleAndPage(Page<Ocqt> page,
			OcqtExample example) {
		if(example == null)
			example = new OcqtExample();
		if(example.getOredCriteria().size() == 0)
			example.createCriteria();
		example.getOredCriteria().get(0).andQustTagNotEqualTo(ComQuestionStatusEnum.DELETED.getCode());	
		ocqtService.selectByExampleAndPage(page, example);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#exProcGetMyMemListByDocId(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.util.Map)
	 */
	public Page<MemberVo> exProcGetMyMemListByDocId(Page<MemberVo> page,
			Map<String, Object> params) {
		
		if(params == null)
			params = new HashMap<String, Object>();
		if(params.get("iMemGrpid")==null)
			params.put("iMemGrpid", 0);
		params.put("iCurrentPageIndex", page.getPageNo() - 1);
		params.put("iPageSize", page.getPageSize());
		page.setResult(memberDao.exProcGetMyMemListByDocId(params));
		page.setTotalCount(Integer.parseInt(String.valueOf(params.get("iCount"))));
		return page;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#selectHealthexamQuestion(java.lang.Integer, com.bithealth.questionCore.enmu.QuestionType)
	 */
	public Omfq selectHealthexamQuestion(Integer orgId, QuestionType type) {
		
		OmfqExample example = new OmfqExample();
		example.createCriteria().andQustTagEqualTo(SingleQuestionStatusEnum.VALID.getCode())
		.andOrgIdIn(Arrays.asList(0,orgId)).andQustnameEqualTo(type.getName());
		example.setOrderByClause("orgId desc");
		List<Omfq> omfqs = omfqService.selectByExample(example);
		if(omfqs != null && !omfqs.isEmpty()){
			Omfq pojo = omfqs.get(0);
			pojo.setMfq1s(mfq1Service.selectByMasterId(pojo.getQustid()));
			if(pojo.getMfq1s() != null && pojo.getMfq1s().size() > 0){
				for(Iterator<Mfq1> it = pojo.getMfq1s().iterator(); it.hasNext();){
					Mfq1 mfq1 = it.next();
					mfq1.setMfq11s(mfq11Service.selectByMasterId(pojo.getQustid(), mfq1.getProblemid()));
					mfq1.setLogicses(logicsService.selectByMasterId(pojo.getQustid(), mfq1.getProblemid()));
				}
			}
			return pojo;
		}
		return null;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#selectHasSingleAssComQuestion(java.lang.Integer)
	 */
	public boolean selectHasSingleAssComQuestion(Integer qustId) {
		Cqt1Example example = new Cqt1Example();
		example.createCriteria().andQustidEqualTo(qustId);
		return cqt1Service.selectByExample(example).size() > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#hasDraft(java.lang.String, java.lang.Integer)
	 */
	public boolean hasDraft(String name, Integer orgId) {
		
		OmfqExample example = new OmfqExample();
		example.createCriteria().andQustnameEqualTo(name).andOrgIdEqualTo(orgId).andQustTagEqualTo(SingleQuestionStatusEnum.DRAFT.getCode());
		return omfqService.selectByExample(example).size() > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.question.service.QuestionService#hasComDraft(java.lang.String, java.lang.Integer)
	 */
	public boolean hasComDraft(String name, Integer orgId) {
		
		OcqtExample example = new OcqtExample();
		example.createCriteria().andCombQustNameEqualTo(name).andOrgIdEqualTo(orgId).andQustTagEqualTo(ComQuestionStatusEnum.DRAFT.getCode());
		return ocqtService.selectByExample(example).size() > 0;
	}
}

