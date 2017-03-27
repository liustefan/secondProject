 
/**
 * @PackageName:      com.bithealth.healthCore.facede.service.impl
 * @FileName:     ManageschemeTaskFacedeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月8日 上午11:06:11  
 * 
 */

package com.bithealth.healthCore.facede.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.healthCore.enmu.ExecuteWayEnum;
import com.bithealth.healthCore.enmu.TaskExecStatusEnum;
import com.bithealth.healthCore.enmu.TaskTypeEnum;
import com.bithealth.healthCore.facede.service.ManageschemeTaskFacedeService;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTask;
import com.bithealth.healthCore.managescheme.service.ManageschemeTaskService;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.facede.service.AnswerFacedeService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: ManageschemeTaskFacedeServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月8日 上午11:06:11 
 * 
 * @author baozj
 * @version  
 */
@Service
public class ManageschemeTaskFacedeServiceImpl implements
		ManageschemeTaskFacedeService {

	@Autowired
	ManageschemeTaskService taskservice;
	@Autowired
	private AnswerFacedeService answerService;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeTaskFacedeService#selectManageschemeTaskPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.managescheme.model.ManageschemeExecTask)
	 */
	@Override
	public Page<ManageschemeExecTask> selectManageschemeTaskPage(
			Page<ManageschemeExecTask> page, ManageschemeExecTask model) {
		return taskservice.selectManageschemeTaskPage(page, model);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeTaskFacedeService#selectExecTask(java.lang.Long)
	 */
	@Override
	public ManageschemeExecTask selectExecTask(Long MSExecID) {
		
		return taskservice.selectExecTask(MSExecID);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeTaskFacedeService#updateExecTaskResult(com.bithealth.healthCore.managescheme.model.ManageschemeExecTask)
	 */
	@Override
	public boolean updateExecTaskResult(ManageschemeExecTask model, boolean finish, boolean termination) {
		
		return taskservice.updateExecTaskResult(model, finish, termination);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeTaskFacedeService#insertTaskAnswerResult(com.bithealth.questionCore.answer.model.Ouai)
	 */
	@Override
	public boolean insertTaskAnswerResult(Ouai pojo){
		
		Ouai ouai = answerService.selectOuaiByMSETaskID(pojo.getMSETaskID());
		if(ouai == null){
			ouai = answerService.insertSingleAnswer(pojo.getQustid(), pojo.getMemberid(), pojo.getDocid(), pojo.getDocName(), pojo.getMSETaskID());
		}
		pojo.setAnsNumber(ouai.getAnsNumber());
		if(answerService.insertTaskSingleAnswerResult(pojo.getUai21s(), pojo)){
			if(pojo.getUai4() != null){
				ManageschemeExecTask eTask = new ManageschemeExecTask();
				eTask.setMSETaskID(pojo.getMSETaskID());
				eTask.setExecResult(pojo.getUai4().getConclusion());
				updateExecTaskResult(eTask, false, false);
			}
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
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeTaskFacedeService#insertMessageTask()
	 */
	@Override
	public boolean insertMessageTask() {
		Page<ManageschemeExecTask> page = new Page<ManageschemeExecTask>();
		page.setPageSize(1000);
		page.setPageNo(1);
		ManageschemeExecTask pojo = new ManageschemeExecTask();
		pojo.setExecStatus(TaskExecStatusEnum.EXECUTORY.getCode());
		pojo.setPlanTimeE(TimeUtil.now("yyyy-MM-dd"));
		pojo.setDesignTask(new ManageschemeDesignTask());
		pojo.getDesignTask().setExecWay(ExecuteWayEnum.MESSAGE.getCode());
		insertMessageTask(page, pojo);
		return true;
	}
	
	private void insertMessageTask(Page<ManageschemeExecTask> page, ManageschemeExecTask pojo){
		taskservice.selectManageschemeTaskPage(page, pojo);
		List<ManageschemeExecTask> list = page.getResult();
		if(list != null && list.size() > 0){
			ManageschemeExecTask item;
			for(Iterator<ManageschemeExecTask> it = list.iterator(); it.hasNext();){
				item = it.next();
				if(TaskTypeEnum.QUESTION.getCode().equals(item.getDesignTask().getTaskType()))
					answerService.insertSingleAnswer(item.getDesignTask().getTaskRefID().intValue(), item.getMemberId(), item.getDesign().getExecDrID(), item.getDesign().getExecDrName(), item.getMSETaskID());
				taskservice.updateExecTaskResult(item, true, false);
			}
		}
		if(page.getPageNo() < page.getTotalPages()){
			page.setPageNo(page.getPageNo()+1);
			insertMessageTask(page, pojo);
		}
	}
	
}

