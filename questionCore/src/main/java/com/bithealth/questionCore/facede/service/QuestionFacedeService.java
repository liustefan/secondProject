 
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

package com.bithealth.questionCore.facede.service;

import java.util.Map;

import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.questionCore.enmu.QuestionType;
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
public interface QuestionFacedeService {

	/**
	 * 
	 * @Title:insertOrUpdateQuestion 
	 * @Description:保存单份问卷 
	 * TODO  
	 * @author baozj
	 * @param model
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertOrUpdateQuestion(Omfq model);
	
	/**
	 * 
	 * @Title:selectSingleQuestionNameUnique 
	 * @Description:查询单份问卷名称唯一性 
	 * TODO  
	 * @author baozj
	 * @param orgId
	 * @param name
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean selectSingleQuestionNameUnique(Integer orgId, String name);
	
	/**
	 * 
	 * @Title:selectComQuestionNameUnique 
	 * @Description:查询组合问卷名称唯一性  
	 * TODO  
	 * @author baozj
	 * @param orgId
	 * @param name
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
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
	 * @retrun boolean
	 */
	boolean deleteSingleQuestion(Integer... ids);
	
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
	
	Omfq selctSingleQuestionBaseInfoById(Integer id);
	
	/**
	 * 
	 * @Title:selectSingleQuestionCanDelete 
	 * @Description:验证单份问卷是否可以删除 
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean selectSingleQuestionCanDelete(Integer...ids);
	
	/**
	 * 
	 * @Title:selectComQuestionCanDelete 
	 * @Description:验证组合问卷是否可以删除  
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean selectComQuestionCanDelete(Integer...ids);
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
	 * @Title:insertOrUpdateComQuestion 
	 * @Description:保存组合问卷 
	 * TODO  
	 * @author baozj
	 * @param model
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertOrUpdateComQuestion(Ocqt model);
	
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
	boolean deleteComQuestion(Integer... ids);
	
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
	
	/**
	 * 
	 * @Title:exProcGetMyMemListByDocId 
	 * @Description:查询我的会员中可以发放单份、组合问卷的会员
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param params
	 * @return 
	 * @throws
	 * @retrun Page<Member>
	 */
	Page<MemberVo> exProcGetMyMemListByDocId(Page<MemberVo> page, Map<String, Object> params);
	
	/**
	 * 
	 * @Title:selectResultByOrgId 
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author baozj
	 * @param orgId
	 * @param type	1、老年人生活自理能力问卷; 2、中医体质辨识问卷
	 * @return 
	 * @throws
	 * @retrun Ouai
	 */
	Omfq selectHealthexamQuestion(Integer orgId, QuestionType type);
	
	boolean hasDraft(String name, Integer orgId);
	
	boolean hasComDraft(String name, Integer orgId);
}

