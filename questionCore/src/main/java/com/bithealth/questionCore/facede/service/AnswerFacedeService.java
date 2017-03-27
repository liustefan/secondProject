 
/**
 * @PackageName:      com.bithealth.questionCore.service
 * @FileName:     AnswerService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:01:41  
 * 
 */

package com.bithealth.questionCore.facede.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.bithealth.questionCore.answer.model.Ocam;
import com.bithealth.questionCore.answer.model.OcamExample;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.answer.model.OuaiExample;
import com.bithealth.questionCore.answer.model.Uai21;
import com.bithealth.questionCore.enmu.QuestionType;
import com.bithealth.questionCore.enmu.SingleAnswerStatusEnum;
import com.bithealth.questionCore.model.Answer;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: AnswerService  
 * 功能描述: TODO 答卷管理
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:01:41 
 * 
 * @author baozj
 * @version  
 */
public interface AnswerFacedeService {

	/**
	 * 
	 * @Title:insertSingleAnswers 
	 * @Description:发放单份答卷
	 * TODO  
	 * @author baozj
	 * @param qustId
	 * @param docId
	 * @param docName
	 * @param memberIds
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertSingleAnswers(Integer qustId, Integer docId, String docName, Integer...memberIds);
	
	/**
	 * 
	 * @Title:selectSingleAnswerById
	 * @Description:单份答卷详情 
	 * TODO  
	 * @author baozj
	 * @param ansNumber
	 * @return 
	 * @throws
	 * @retrun Ouai
	 */
	Ouai selectSingleAnswerById(Integer ansNumber);
	
	/**
	 * 
	 * @Title:selectSingleAnswerByExampleAndPage 
	 * @Description:分页查询单份答卷 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param example
	 * @return 
	 * @throws
	 * @retrun Page<Ouai>
	 */
	Page<Ouai> selectSingleAnswerByExampleAndPage(Page<Ouai> page, OuaiExample example);
	
	/**
	 * 
	 * @Title:insertSingleAnswerResult 
	 * @Description:作答单份答卷 
	 * TODO  
	 * @author baozj
	 * @param results
	 * @param model
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertSingleAnswerResult(List<Uai21> results, Ouai model);
	
	boolean insertTaskSingleAnswerResult(List<Uai21> results, Ouai model);
	
	/**
	 * 
	 * @Title:insertComAnswers 
	 * @Description:发放组合答卷 
	 * TODO  
	 * @author baozj
	 * @param combQustId
	 * @param docId
	 * @param docName
	 * @param memberIds
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertComAnswers(Integer combQustId, Integer docId, String docName, Integer...memberIds);
	
	/**
	 * 
	 * @Title:insertComAnswerResult 
	 * @Description:作答组合答卷中的单份答卷 
	 * TODO  
	 * @author baozj
	 * @param results
	 * @param model
	 * @param combQustId
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertComAnswerResult(List<Uai21> results, Ouai model, Integer combQustId);
	
	/**
	 * 
	 * @Title:selectComAnswerById 
	 * @Description:组合答卷详情 
	 * TODO  
	 * @author baozj
	 * @param combQustId
	 * @return 
	 * @throws
	 * @retrun Ocam
	 */
	Ocam selectComAnswerById(Integer combAnsid);
	
	/**
	 * 
	 * @Title:selectComAnswerByExampleAndPage 
	 * @Description:分页查询组合答卷 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param example
	 * @return 
	 * @throws
	 * @retrun Page<Ocam>
	 */
	Page<Ocam> selectComAnswerByExampleAndPage(Page<Ocam> page, OcamExample example);
	
	/**
	 * 
	 * @Title:insertSingleAnswerResult 
	 * @Description:作答健康体检问卷 
	 * TODO  
	 * @author baozj
	 * @param results
	 * @param answerId 不为空时 重新作答 和 参数 qustId， HExamID， memberId 互斥
	 * @param qustId
	 * @param HExamID
	 * @param memberId
	 * @param status STAGING：暂存、APPROVED：已审核
	 * @return 
	 * @throws
	 * @retrun Map<String,Map<Double,String>>
	 */
	Map<String, Map<Double, String>> insertSingleAnswerResult(List<Uai21> results, Integer answerId, Integer qustId, Long HExamID, Integer memberId, SingleAnswerStatusEnum status) throws IllegalAccessException, InvocationTargetException ;
	
	/**
	 * 
	 * @Title:selectHealthexamAnswer 
	 * @Description: 查询健康体检作答问卷
	 * TODO  
	 * @author baozj
	 * @param HExamID
	 * @param type 
	 * @return 
	 * @throws
	 * @retrun Ouai
	 */
	Ouai selectHealthexamAnswer(Long HExamID,  QuestionType type);
	
	/**
	 * 
	 * @Title:deleteSingleAnswers 
	 * @Description:删除单份答卷 
	 * TODO  
	 * @author baozj
	 * @param ansNumbers
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deleteSingleAnswers(Integer...ansNumbers);
	
	/**
	 * 
	 * @Title:deleteComAnswers 
	 * @Description:删除组合答卷 
	 * TODO  
	 * @author baozj
	 * @param combQustIds
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deleteComAnswers(Integer...combAnsid);
	
	/**
	 * 
	 * @Title:selectPrintSingleQuestionInfoByIds 
	 * @Description: 查询单份答卷打印信息
	 * TODO  
	 * @author baozj
	 * @param ansNumbers
	 * @return 
	 * @throws
	 * @retrun List<Ouai>
	 */
	List<Ouai> selectPrintSingleQuestionInfoByIds(Integer...ansNumbers);
	
	/**
	 * 
	 * @Title:selectPrintComQuestionInfoByIds 
	 * @Description: 查询组合答卷打印信息
	 * TODO  
	 * @author baozj
	 * @param combAnsIds
	 * @return 
	 * @throws
	 * @retrun List<Ocam>
	 */
	List<Ocam> selectPrintComQuestionInfoByIds(Integer...combAnsIds);
	
	/**
	 * 
	 * @Title:selectAnswerPage 
	 * @Description: 分页查询会员答卷信息（单份、组合合并分页查询） 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param memberId
	 * @param finished
	 * @return 
	 * @throws
	 * @retrun Page<Answer>
	 */
	Page<Answer> selectAnswerPage(Page<Answer> page, Integer memberId, boolean finished);
//	/**
//	 * 
//	 * @Title:selectSingleAnswerByCombAnsIds 
//	 * @Description: 组合答卷中的单份答卷详情 
//	 * TODO  
//	 * @author baozj
//	 * @param combAnsId
//	 * @return 
//	 * @throws
//	 * @retrun List<Ouai>
//	 */
//	List<Ouai> selectSingleAnswerByCombAnsIds(Integer combAnsId);
	
	/**
	 * 
	 * @Title:selectOuaiByMSETaskID 
	 * @Description: 查询方案执行任务对应的答卷
	 * TODO  
	 * @author baozj
	 * @param MSETaskID
	 * @return 
	 * @throws
	 * @retrun Ouai
	 */
	Ouai selectOuaiByMSETaskID(Long MSETaskID);
	
	/**
	 * 
	 * @Title:insertSingleAnswer 
	 * @Description: 作答方案任务中的问卷
	 * TODO  
	 * @author baozj
	 * @param qustId
	 * @param memberId
	 * @param docId
	 * @param docName
	 * @param MSETaskID
	 * @return 
	 * @throws
	 * @retrun Ouai
	 */
	Ouai insertSingleAnswer(Integer qustId, Integer memberId, Integer docId, String docName, Long MSETaskID);
}

