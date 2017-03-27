 
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

package com.bithealth.questionCore.answer.service;

import java.util.List;

import com.bithealth.questionCore.answer.model.Cam1;
import com.bithealth.questionCore.answer.model.Ocam;
import com.bithealth.questionCore.answer.model.OcamExample;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.answer.model.OuaiExample;
import com.bithealth.questionCore.answer.model.Uai21;
import com.bithealth.questionCore.answer.model.Uai4;
import com.bithealth.questionCore.enmu.ComAnswerStatusEnum;
import com.bithealth.questionCore.enmu.SingleAnswerStatusEnum;
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
public interface AnswerService {
	
	int insertSingleAnswer(Ouai model);

	Ouai selectSingleAnswerById(Integer ansNumber);
	
	boolean selectHasSingleAnswerReleased(Integer qustId); 
	
	boolean selectHasComAnswerReleased(Integer combQustId);
	
	Page<Ouai> selectSingleAnswerByExampleAndPage(Page<Ouai> page, OuaiExample example);
	
	boolean insertSingleAnswerResult(List<Uai21> results,
			Ouai model);
	
	boolean updateSingleAnswerStatusAndProduceAudit(SingleAnswerStatusEnum status, Ouai pojo);
	
	boolean updateSingleAnswerStatus(SingleAnswerStatusEnum status, Ouai pojo);
	
	boolean insertConclusion(Uai4 model);
	
	int insertComAnswer(Ocam model);
	
	int insertComContactSingleAnswer(Cam1 model);
	
	Ocam selectComAnswerById(Integer combAnsId);
	
	boolean updateComAnswerStatus(ComAnswerStatusEnum status, Ocam pojo);
	
	Page<Ocam> selectComAnswerByExampleAndPage(Page<Ocam> page, OcamExample example);
	
	List<Ouai> selectHealthexamAnswer(Long HExamID);
	
	boolean deleteSingleAnswers(Integer...ansNumbers);
	
	boolean deleteComAnswers(Integer...combAnsid);
	
	/**
	 * 
	 * @Title:selectBaseSingleAnswer 
	 * @Description: 发送消息使用 
	 * TODO  
	 * @author baozj
	 * @param ansNumber
	 * @return 
	 * @throws
	 * @retrun Ouai
	 */
	Ouai selectBaseSingleAnswer(Integer ansNumber);
	
	/**
	 * 
	 * @Title:selectBaseComAnswer 
	 * @Description:发送消息使用 
	 * TODO  
	 * @author baozj
	 * @param combAnsid
	 * @return 
	 * @throws
	 * @retrun Ocam
	 */
	Ocam selectBaseComAnswer(Integer combAnsid);
}

