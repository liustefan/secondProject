 
/**
 * @PackageName:      com.bithealth.questionCore.service
 * @FileName:     QuestionnaireService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:01:28  
 * 
 */

package com.bithealth.questionCore.question.service;

import java.util.List;
import java.util.Map;

import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.questionCore.enmu.QuestionType;
import com.bithealth.questionCore.question.model.Mfq1;
import com.bithealth.questionCore.question.model.Mfq2;
import com.bithealth.questionCore.question.model.Mfq21;
import com.bithealth.questionCore.question.model.Ocqt;
import com.bithealth.questionCore.question.model.OcqtExample;
import com.bithealth.questionCore.question.model.Omfq;
import com.bithealth.questionCore.question.model.OmfqExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;



/**
 * 类名称: QuestionnaireService  
 * 功能描述: TODO 问卷管理  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:01:28 
 * 
 * @author baozj
 * @version  
 */
public interface QuestionService {
	
	/**
	 * 
	 * @Title:insertOrUpdateSingleQuestionBaseInfo 
	 * @Description:保存单份问卷基本信息 
	 * TODO  
	 * @author baozj
	 * @param model
	 * @return 
	 * @throws
	 * @retrun int
	 */
	int insertOrUpdateSingleQuestionBaseInfo(Omfq model);
	
	/**
	 * 
	 * @Title:insertOrUpdateSingleQuestionOptions 
	 * @Description:保存单份问卷选项内容 
	 * TODO  
	 * @author baozj
	 * @param qustid
	 * @param list
	 * @return 
	 * @throws
	 * @retrun int
	 */
	int insertOrUpdateSingleQuestionOptions(Integer masterId, List<Mfq1> list);
	
	/**
	 * 
	 * @Title:insertOrUpdateSingleQuestionScoringRule 
	 * @Description:保存单份问卷评分规则和结论 
	 * TODO  
	 * @author baozj
	 * @return 
	 * @throws
	 * @retrun int
	 */
	int insertOrUpdateSingleQuestionScoringRule(Integer masterId, Mfq2 mfq2, List<Mfq21> mfq21);
	
	/**
	 * 
	 * @Title:insertSingleQuestion
	 * @Description:生成草稿单份问卷
	 * TODO  
	 * @author baozj
	 * @param omfq
	 * @return 
	 * @throws
	 * @retrun int
	 */
	int insertSingleQuestion(Omfq omfq);
	
	boolean selectSingleQuestionNameUnique(Integer orgId, String name);
	
	boolean selectComQuestionNameUnique(Integer orgId, String name);
	
	/**
	 * 
	 * @Title:deleteSingleQuestion 
	 * @Description:删除单份问卷 
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun int
	 */
	int deleteSingleQuestion(Integer... ids);
	
	/**
	 * 
	 * @Title:selectSingleQuestionById 
	 * @Description:查询单份问卷详情 
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun Omfq
	 */
	Omfq selectSingleQuestionById(Integer id);
	
	Omfq selectSingleQuestionBaseInfoById(Integer id);
	
	Ocqt selectComQuestionBaseInfoById(Integer id);
	
	/**
	 * 
	 * @Title:selectSingleQuestionByExampleAndPage 
	 * @Description:分页查询单份问卷 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param example
	 * @return 
	 * @throws
	 * @retrun Page<Omfq>
	 */
	Page<Omfq> selectSingleQuestionByExampleAndPage(Page<Omfq> page, OmfqExample example);
	
	/**
	 * 
	 * @Title:insertComQuestion 
	 * @Description:新增组合问卷 
	 * TODO  
	 * @author baozj
	 * @param model
	 * @return 
	 * @throws
	 * @retrun int
	 */
	int insertComQuestion(Ocqt model);
	
	/**
	 * 
	 * @Title:updateComQuestion 
	 * @Description:修改组合问卷 
	 * TODO  
	 * @author baozj
	 * @param model
	 * @return 
	 * @throws
	 * @retrun int
	 */
	int updateComQuestion(Ocqt model);
	/**
	 * 
	 * @Title:deleteComQuestion
	 * @Description:删除组合问卷 
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	int deleteComQuestion(Integer... ids);
	
	/**
	 * 
	 * @Title:selectComQuestionById
	 * @Description:查询组合问卷详情 
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun Omfq
	 */
	Ocqt selectComQuestionById(Integer id);
	
	/**
	 * 
	 * @Title:selectComQuestionByExampleAndPage
	 * @Description:分页查询组合问卷 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param example
	 * @return 
	 * @throws
	 * @retrun Page<Omfq>
	 */
	Page<Ocqt> selectComQuestionByExampleAndPage(Page<Ocqt> page, OcqtExample example);
	
	Page<MemberVo> exProcGetMyMemListByDocId(Page<MemberVo> page, Map<String, Object> params);
	
	Omfq selectHealthexamQuestion(Integer orgId, QuestionType type);
	
	boolean selectHasSingleAssComQuestion(Integer qustId);
	
	boolean hasDraft(String name, Integer orgId);
	
	boolean hasComDraft(String name, Integer orgId);
}

