 
/**
 * @PackageName:      com.bithealth.healthCore.managescheme.service.impl
 * @FileName:     ManageschemeTaskServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月8日 上午11:04:28  
 * 
 */

package com.bithealth.healthCore.managescheme.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.chatCore.enmu.ChatRefTypeEnmu;
import com.bithealth.chatCore.enmu.RefStatusEnum;
import com.bithealth.chatCore.facade.service.ChatMessageFacadeService;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.healthCore.enmu.ConclusionTypeEnum;
import com.bithealth.healthCore.enmu.ExecuteWayEnum;
import com.bithealth.healthCore.enmu.GroupManageschemeEnum;
import com.bithealth.healthCore.enmu.PersonManageschemeEnum;
import com.bithealth.healthCore.enmu.SchemeTypeEnum;
import com.bithealth.healthCore.enmu.TaskExecStatusEnum;
import com.bithealth.healthCore.enmu.TaskTypeEnum;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesign;
import com.bithealth.healthCore.managescheme.model.ManageschemeExec;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecExample;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTaskExample;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignDetailService;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignService;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignTaskService;
import com.bithealth.healthCore.managescheme.service.ManageschemeExecService;
import com.bithealth.healthCore.managescheme.service.ManageschemeExecTaskService;
import com.bithealth.healthCore.managescheme.service.ManageschemeTaskService;
import com.bithealth.inspectCore.facede.service.InspectFacedeService;
import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesExample;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensionExample;
import com.bithealth.inspectCore.inspect.service.PhDiabetesService;
import com.bithealth.inspectCore.inspect.service.PhHypertensionService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.answer.model.OuaiExample;
import com.bithealth.questionCore.answer.service.OuaiService;
import com.bithealth.questionCore.enmu.SingleAnswerStatusEnum;
import com.bithealth.questionCore.facede.service.AnswerFacedeService;
import com.bithealth.questionCore.facede.service.impl.ChatMessageSendService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: ManageschemeTaskServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月8日 上午11:04:28 
 * 
 * @author baozj
 * @version  
 */
@Service
public class ManageschemeTaskServiceImpl extends ChatMessageSendService implements ManageschemeTaskService {
	
	@Autowired
	ManageschemeDesignService designService;
	@Autowired
	ManageschemeDesignDetailService designDetailService;
	@Autowired
	ManageschemeDesignTaskService designTaskService;
	@Autowired
	ManageschemeExecService execService;
	@Autowired
	ManageschemeExecTaskService execTaskService;
	@Autowired
	OuaiService ouaiService;
	@Autowired
	PhDiabetesService diabetesService; 
	@Autowired
	PhHypertensionService hypertensionService;
	@Autowired
	ChatMessageFacadeService chatService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	AnswerFacedeService answerService;
	@Autowired
	InspectFacedeService inspectService;
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeTaskService#selectManageschemeTaskPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.managescheme.model.ManageschemeExecTask)
	 */
	@Override
	public Page<ManageschemeExecTask> selectManageschemeTaskPage(
			Page<ManageschemeExecTask> page, ManageschemeExecTask model) {
		
		execTaskService.selectManageschemeTaskPage(page, model);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeTaskService#selectExecTask(java.lang.Long)
	 */
	@Override
	public ManageschemeExecTask selectExecTask(Long MSExecID) {
		
		ManageschemeExecTask model = execTaskService.selectById(MSExecID);
		if(model != null){
			model.setDesignTask(designTaskService.selectById(model.getMSDTaskID()));
			model.setExec(execService.selectById(model.getMSExecID().longValue()));
			if(model.getDesignTask() != null){
				model.setRef(new HashMap<String, Object>());
				if(TaskTypeEnum.QUESTION.getCode().equals(model.getDesignTask().getTaskType())){
					OuaiExample example = new OuaiExample();
					example.createCriteria().andMSETaskIDEqualTo(model.getMSETaskID());
					List<Ouai> list = ouaiService.selectByExample(example);
					if(!list.isEmpty()){
						Ouai pojo = list.get(0);
						model.getRef().put("id", pojo.getAnsNumber());
						model.getRef().put("done", (SingleAnswerStatusEnum.ANSWERED.getCode().equals(pojo.getQustTag()) 
								|| SingleAnswerStatusEnum.APPROVED.getCode().equals(pojo.getQustTag())) ? true : false);
					}
				}else if(TaskTypeEnum.HYPERTENSION.getCode().equals(model.getDesignTask().getTaskType())){
					PhHypertensionExample example = new PhHypertensionExample();
					example.createCriteria().andMSETaskIDEqualTo(model.getMSETaskID());
					List<PhHypertension> list = hypertensionService.selectByExample(example);
					if(!list.isEmpty()){
						PhHypertension pojo = list.get(0);
						model.getRef().put("id", pojo.getHypertensionID());
						model.getRef().put("done", pojo.getVisitClass() > 0);
					}
				}else if(TaskTypeEnum.DIABETES.getCode().equals(model.getDesignTask().getTaskType())){
					PhDiabetesExample example = new PhDiabetesExample();
					example.createCriteria().andMSETaskIDEqualTo(model.getMSETaskID());
					List<PhDiabetes> list = diabetesService.selectByExample(example);
					if(!list.isEmpty()){
						PhDiabetes pojo = list.get(0);
						model.getRef().put("id", pojo.getDiabetesID());
						model.getRef().put("done", pojo.getVisitClass() > 0);
					}
				}
				if(TaskTypeEnum.SUMMARY.getCode().equals(model.getDesignTask().getTaskType()))
					model.setDesignDetail(designDetailService.selectById(model.getDesignTask().getMSDesignID()));
				model.setDesign(designService.selectById(model.getDesignTask().getMSDesignID()));
			}
		}
		return model;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeTaskService#updateExecTaskResult(com.bithealth.healthCore.managescheme.model.ManageschemeExecTask)
	 */
	@Override
	public boolean updateExecTaskResult(ManageschemeExecTask model, boolean finish, boolean termination) {
		ManageschemeExecTask pojo = execTaskService.selectById(model.getMSETaskID());
		if(TaskExecStatusEnum.EXECUTORY.getCode().equals(pojo.getExecStatus())){
			if(finish){
				model.setExecStatus(TaskExecStatusEnum.EXECUTED.getCode());
				if(model.getExecTime() == null)
					model.setExecTime(TimeUtil.now());
				model.setUpdateTime(model.getExecTime());
				if(execTaskService.update(model) > 0){//执行当前任务
					//如果任务类型为阶段总结并且结论类型为终止方案、执行下一阶段方案就终止此方案
					if(TaskTypeEnum.SUMMARY.getCode().equals(model.getDesignTask().getTaskType()) && (ConclusionTypeEnum.TERMINATED.getCode().equals(model.getConclusionType()) || ConclusionTypeEnum.NEXT.getCode().equals(model.getConclusionType()))){
						if(SchemeTypeEnum.GROUP.getCode().equals(model.getDesign().getSchemeType())){//来源群体
							ManageschemeExec exec = new ManageschemeExec();
							exec.setExecStatus(PersonManageschemeEnum.TERMINATED.getCode());
							exec.setExecOffReason(""); 
							exec.setExecOffTime(TimeUtil.now());
							exec.setUpdateID(model.getUpdateID());
							ManageschemeExecExample example = new ManageschemeExecExample();
							example.createCriteria().andMSExecIDEqualTo(model.getMSExecID().longValue());
							execService.updateByExampleSelective(exec, example);
							
							ManageschemeExecTaskExample eTaskExample = new ManageschemeExecTaskExample();
							eTaskExample.createCriteria().andMSExecIDEqualTo(model.getMSExecID()).andExecStatusEqualTo(TaskExecStatusEnum.EXECUTORY.getCode());
							ManageschemeExecTask eTask = new ManageschemeExecTask();
							eTask.setExecStatus(TaskExecStatusEnum.TERMINATED.getCode());
							execTaskService.updateByExampleSelective(eTask, eTaskExample);
						}else{//来源个人
							if(execService.terminatedManageschemeExec(model.getUpdateID(), model.getDesign().getMSDesignID(), "") == 0){
								ManageschemeExec exec = new ManageschemeExec();
								exec.setExecStatus(PersonManageschemeEnum.TERMINATED.getCode());
								exec.setExecOffReason(""); 
								exec.setExecOffTime(TimeUtil.now());
								exec.setUpdateID(model.getUpdateID());
								ManageschemeExecExample example = new ManageschemeExecExample();
								example.createCriteria().andMSExecIDEqualTo(model.getMSExecID().longValue());
								execService.updateByExampleSelective(exec, example);
							}
						}
					}else{
						if(termination){
							ManageschemeDesign design = new ManageschemeDesign();
							design.setMSDesignID(model.getDesign().getMSDesignID());
							design.setUpdateID(model.getUpdateID());
							design.setMassStatus(GroupManageschemeEnum.TERMINATED.getCode());
							design.setMassOffTime(model.getExecTime());
							designService.update(design);
							ManageschemeExec exec = new ManageschemeExec();
							exec.setMSExecID(model.getMSExecID().longValue());
							exec.setUpdateID(model.getUpdateID());
							exec.setExecStatus(PersonManageschemeEnum.TERMINATED.getCode());
							exec.setExecOffTime(TimeUtil.now());
							exec.setExecOffReason("任务已全部执行");
							execService.update(exec);
						}else{
							ManageschemeExecTaskExample example = new ManageschemeExecTaskExample();
							example.createCriteria().andMSExecIDEqualTo(model.getMSExecID()).andExecStatusEqualTo(TaskExecStatusEnum.EXECUTORY.getCode());
							if(execTaskService.selectByExample(example).isEmpty()){//没有待执行任务，修改个人执行方案类型为无任务
								ManageschemeExec exec = new ManageschemeExec();
								if(SchemeTypeEnum.GROUP.getCode().equals(model.getDesign().getSchemeType())){//来源群体的方案，如果任务已全部执行完，终止方案
									exec.setExecStatus(PersonManageschemeEnum.TERMINATED.getCode());
									exec.setUpdateID(0);
									exec.setExecOffTime(TimeUtil.now());
									exec.setExecOffReason("任务已全部执行");
								}else{//来源个人的方案，如果任务已全部执行完，方案状态为无任务
									exec.setExecStatus(PersonManageschemeEnum.NOTHING.getCode());
									if(model.getUpdateID() != null)
										exec.setUpdateID(model.getUpdateID());
								}
								exec.setMSExecID(model.getMSExecID().longValue());
								execService.update(exec);
							}
						}
					}
					try {
						if(ExecuteWayEnum.MESSAGE.getCode().equals(model.getDesignTask().getExecWay())){//执行的是消息类任务，推送聊天消息给会员
							ChatRefTypeEnmu type = null;
							Long refID = null;
							RefStatusEnum refStatus = null;
							if(TaskTypeEnum.HEALTHEDUCATION.getCode().equals(model.getDesignTask().getTaskType())){
								type = ChatRefTypeEnmu.TYPE_HealthEdu;
								refID = model.getDesignTask().getTaskRefID();
							}else if(TaskTypeEnum.CPN.getCode().equals(model.getDesignTask().getTaskType())){
								type = ChatRefTypeEnmu.TYPE_CPN;
							}else if(TaskTypeEnum.MEASURE.getCode().equals(model.getDesignTask().getTaskType())){
								type = ChatRefTypeEnmu.TYPE_MEASURE;
							}else if(TaskTypeEnum.QUESTION.getCode().equals(model.getDesignTask().getTaskType())){
								type = ChatRefTypeEnmu.TYPE_SINGLE_PAPERS_PUBLIC;
								Ouai ouai = answerService.selectOuaiByMSETaskID(model.getMSETaskID());
								if(ouai == null)
									ouai = answerService.insertSingleAnswer(model.getDesignTask().getTaskRefID().intValue(), model.getMemberId(), model.getDesign().getExecDrID(), model.getDesign().getExecDrName(), model.getMSETaskID());
								refID = ouai.getAnsNumber().longValue();
								if(SingleAnswerStatusEnum.UNANSWERED.getCode().equals(ouai.getQustTag()) || SingleAnswerStatusEnum.STAGING.getCode().equals(ouai.getQustTag()))
									refStatus = RefStatusEnum.UNFINISHED;
								else if(SingleAnswerStatusEnum.ANSWERED.getCode().equals(ouai.getQustTag()))
									refStatus = RefStatusEnum.COMPLETED;
								else
									refStatus = RefStatusEnum.APPROVED;
							}else if(TaskTypeEnum.HYPERTENSION.getCode().equals(model.getDesignTask().getTaskType())){
								type = ChatRefTypeEnmu.TYPE_HYPERTENSION;
								PhHypertension hypertension = inspectService.selectHypertensionByMSETaskID(model.getMSETaskID());
								if(hypertension != null)
									refID = hypertension.getHypertensionID();
							}else if(TaskTypeEnum.DIABETES.getCode().equals(model.getDesignTask().getTaskType())){
								type = ChatRefTypeEnmu.TYPE_DIABETES;
								PhDiabetes diabetes = inspectService.selectDiabetesByMSETaskID(model.getMSETaskID());
								if(diabetes != null)
									refID = diabetes.getDiabetesID();
							}
							if(type != null){
								sendChat(model.getDesign().getExecDrID(), model.getMemberId(), type, model.getDesignTask().getSummary(), refID, refStatus);
							}
						}
					} catch (Exception e) {
						
						logger.error("方案任务发送聊天消息失败", e);
						
					}
					return true;
				}
			}else{
				model.setUpdateTime(model.getExecTime());
				return execTaskService.update(model) > 0;
	        }
		}
		return false;
	}
	
//	private void sendChat(Doctor doctor, Member member, ChatRefTypeEnmu type, String content, Long refID, Byte refStatus) throws Exception{
//		ChatMessage chat = new ChatMessage();
//	    chat.setSendType(ChatUserTypeEnum.DOCTOR.getType());
//	    chat.setSender(doctor.getDocid());
//	    chat.setSenderName(doctor.getDocname());
//	    chat.setSenderGUID(doctor.getDocGUID());
//	    chat.setSendTime(TimeUtil.now());
//	    chat.setReceiveType(ChatUserTypeEnum.MEMBER.getType());
//	    chat.setReceiver(member.getMemberid());
//	    chat.setReceiverGUID(member.getMemberGUID());
//	    chat.setContentType((byte)1);
//	    chat.setContent(content);
////	    chat.setLastContentNotice(chat.getContent());
//	    chat.setRefType(type.getType());
//	    chat.setRefID(refID);
//	    chat.setRefStatus(refStatus);
//		chatService.saveAndPushChatMessage(chat);
//	}
}

