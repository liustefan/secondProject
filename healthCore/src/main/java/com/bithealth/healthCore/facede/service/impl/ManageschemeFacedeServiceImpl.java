 
/**
 * @PackageName:      com.bithealth.healthCore.facede.service.impl
 * @FileName:     ManageschemeFacedeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月8日 上午11:06:48  
 * 
 */

package com.bithealth.healthCore.facede.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.healthCore.dao.ManageschemeDao;
import com.bithealth.healthCore.enmu.GroupManageschemeEnum;
import com.bithealth.healthCore.enmu.MassEffectProcessEnum;
import com.bithealth.healthCore.enmu.PersonManageschemeEnum;
import com.bithealth.healthCore.enmu.SchemeTypeEnum;
import com.bithealth.healthCore.enmu.TaskExecStatusEnum;
import com.bithealth.healthCore.facede.service.ManageschemeFacedeService;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesign;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignExample;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExec;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecExample;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTaskExample;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignService;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignTaskService;
import com.bithealth.healthCore.managescheme.service.ManageschemeExecService;
import com.bithealth.healthCore.managescheme.service.ManageschemeExecTaskService;
import com.bithealth.healthCore.managescheme.service.ManageschemeService;
import com.bithealth.healthCore.templet.service.TempletService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: ManageschemeFacedeServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月8日 上午11:06:48 
 * 
 * @author baozj
 * @version  
 */
@Service
public class ManageschemeFacedeServiceImpl implements ManageschemeFacedeService {

	@Autowired
	ManageschemeService service;
	@Autowired
	private TempletService templetService;
	@Autowired
	ManageschemeDao manageschemeDao;
	@Autowired
	ManageschemeDesignService msDService;
	@Autowired
	ManageschemeDesignTaskService designTaskService;
	@Autowired
	ManageschemeExecService mseService;
	@Autowired
	ManageschemeExecTaskService msetService;
//	@Resource(name="taskExecutor")
//	ThreadPoolTaskExecutor taskExecutor;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#selectPersonManageschemePage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.managescheme.model.ManageschemeExec)
	 */
	@Override
	public Page<ManageschemeExec> selectPersonManageschemePage(
			Page<ManageschemeExec> page, ManageschemeExec model) {
		return service.selectPersonManageschemePage(page, model);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#selectGroupManageschemePage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.managescheme.model.ManageschemeDesign)
	 */
	@Override
	public Page<ManageschemeDesign> selectGroupManageschemePage(
			Page<ManageschemeDesign> page, ManageschemeDesign model) {
		return service.selectGroupManageschemePage(page, model);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#selectManageschemeById(java.lang.Integer)
	 */
	@Override
	public ManageschemeDesign selectManageschemeById(Integer MSDesignID) {
		if(MSDesignID == null)
			return null;
		return service.selectManageschemeById(MSDesignID);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#deleteManagescheme(java.lang.Integer)
	 */
	@Override
	public boolean deleteManagescheme(Integer MSDesignID) {
		if(MSDesignID == null)
			return false;
		return service.deleteManagescheme(MSDesignID);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#deleteManageschemeTask(java.lang.Integer)
	 */
	@Override
	public boolean deleteManageschemeTask(Integer MSDTaskID, SchemeTypeEnum st) {
		
		if(MSDTaskID == null)
			return false;
		if(SchemeTypeEnum.PERSON.equals(st)){
			ManageschemeExecTaskExample example = new ManageschemeExecTaskExample();
			example.createCriteria().andMSDTaskIDEqualTo(MSDTaskID);
			ManageschemeExecTask eTask = msetService.selectByExample(example).get(0);
			if(service.deleteManageschemeTask(MSDTaskID, st)){
				example.clear();
				example.createCriteria()
				.andMSExecIDEqualTo(eTask.getMSExecID())
				.andExecStatusEqualTo(TaskExecStatusEnum.EXECUTORY.getCode());
				if(msetService.selectByExample(example).isEmpty()){//个人方案没有待执行任务
					example.clear();
					example.createCriteria()
					.andMSExecIDEqualTo(eTask.getMSExecID())
					.andExecStatusNotEqualTo(TaskExecStatusEnum.EXECUTORY.getCode());
					if(msetService.selectByExample(example).isEmpty()){//改为制定中
						ManageschemeExec pojo = mseService.selectById(eTask.getMSExecID().longValue());
						ManageschemeDesign design = new ManageschemeDesign();
						design.setMassStatus(GroupManageschemeEnum.MAKING.getCode());
						design.setMSDesignID(pojo.getMSDesignID());
						msDService.update(design);
						ManageschemeExec exec = new ManageschemeExec();
						exec.setExecStatus(PersonManageschemeEnum.MAKING.getCode());
						exec.setMSExecID(eTask.getMSExecID().longValue());
						mseService.update(exec);
					}else{//改为无任务
						ManageschemeExec exec = new ManageschemeExec();
						exec.setExecStatus(PersonManageschemeEnum.NOTHING.getCode());
						exec.setMSExecID(eTask.getMSExecID().longValue());
						mseService.update(exec);
					}
				}
				return true;
			}
		}else{
			return service.deleteManageschemeTask(MSDTaskID, st);
		}
		return false;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#updateManagescheme(java.lang.Integer, com.bithealth.healthCore.enmu.GroupManageschemeEnum, com.bithealth.healthCore.enmu.GroupManageschemeEnum, java.lang.String)
	 */
	@Override
	public boolean updateManagescheme(Integer docId, Integer MSDesignID,
			GroupManageschemeEnum newStatus, GroupManageschemeEnum oldStatus,
			String massOffReason) {
		if(MSDesignID == null || newStatus == null)
			return false;
		return service.updateManagescheme(docId, MSDesignID, newStatus, oldStatus, massOffReason);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#insertOrUpdateManagescheme(com.bithealth.healthCore.managescheme.model.ManageschemeDesign)
	 */
	@Override
	public boolean insertOrUpdateManagescheme(ManageschemeDesign model) {
		if(model.getReferenceId() != null)
			templetService.updateUsedNumber(model.getReferenceId());
		if(model.getMSDesignID() == null){
			return service.insertManagescheme(model);
		}else{
			return service.updateManagescheme(model);
		}
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#insertOrUpdateManageschemeTask(com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask, com.bithealth.healthCore.enmu.SchemeTypeEnum, java.lang.Long)
	 */
	@Override
	public boolean insertOrUpdateManageschemeTask(ManageschemeDesignTask model,
			SchemeTypeEnum sType, Long MSExecID) {
		
		if(model.getMSDTaskID() == null)
			return service.insertManageschemeTask(model, sType, MSExecID);
		else
			return service.updateManageschemeTask(model);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#selectManageschemePageByMemberId(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.lang.Integer)
	 */
	@Override
	public Page<ManageschemeExec> selectManageschemePageByMemberId(
			Page<ManageschemeExec> page, Integer memberId) {
		if(memberId == null)
			return page;
		ManageschemeExec model = new ManageschemeExec();
		model.setMemberID(memberId);
		return service.selectManageschemePage(page, model);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#selectManageschemePage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.managescheme.model.ManageschemeExec)
	 */
	@Override
	public Page<ManageschemeExec> selectManageschemePage(
			Page<ManageschemeExec> page, ManageschemeExec model) {
		
		return service.selectManageschemePage(page, model);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#selectManageschemeById(java.lang.Long)
	 */
	@Override
	public ManageschemeExec selectManageschemeById(Long MSExecID) {
		if(MSExecID == null)
			return null;
		return service.selectManageschemeById(MSExecID);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#selectHasManageschemeExec(java.lang.Integer)
	 */
	@Override
	public ManageschemeExec selectHasManageschemeExec(Integer memberId) {
		
		return service.selectHasManageschemeExec(memberId);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#updateCanGenerateMscheme(java.lang.Integer)
	 */
	@Override
	public int updateCanGenerateMscheme(Integer MSDesignID) {
		
		if(MSDesignID == null)
			return 0;
		ManageschemeDesign model = msDService.selectById(MSDesignID);
		if(MassEffectProcessEnum.GENERATING.getCode().equals(model.getMassEffectProcess()))
			return 2;
		List<ManageschemeDesignTask> tasks = designTaskService.selectByMasterId(model.getMSDesignID(), SchemeTypeEnum.GROUP);
		if(tasks == null || tasks.size() == 0)
			return 3;
		if(GroupManageschemeEnum.MAKING.getCode().equals(model.getMassStatus())){
			if(msDService.updateManageschemeStatus(null, model.getMSDesignID(), GroupManageschemeEnum.EFFECT, null, null) == 0)
				return 0;
		}
		ManageschemeDesign design = new ManageschemeDesign();
		design.setMassEffectProcess(MassEffectProcessEnum.GENERATING.getCode());
		ManageschemeDesignExample designExample = new ManageschemeDesignExample();
		designExample.createCriteria().andMSDesignIDEqualTo(MSDesignID).andMassEffectProcessEqualTo(MassEffectProcessEnum.NOTRIGGER.getCode());
		msDService.updateByExampleSelective(design, designExample);
		
		ManageschemeExec exec = new ManageschemeExec();
		exec.setMEPersonProcess(MassEffectProcessEnum.GENERATING.getCode());
		ManageschemeExecExample execExample = new ManageschemeExecExample();
		execExample.createCriteria().andMSDesignIDEqualTo(MSDesignID).andMEPersonProcessEqualTo(MassEffectProcessEnum.NOTRIGGER.getCode());
		mseService.updateByExampleSelective(exec, execExample);
		return 1;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#exProcMschemeAddExecTaskByMSDesignID(java.util.Map)
	 */
	@Override
	public void exProcMschemeAddExecTaskByMSDesignID(Map<String, Object> params) {
		manageschemeDao.exProcMschemeAddExecTaskByMSDesignID(params);
	}
	
	private boolean updateMassEffectProcess(Integer MSDesignID, MassEffectProcessEnum newEffectProcess, MassEffectProcessEnum oldEffectProcess){
		ManageschemeDesign model = new ManageschemeDesign();
		model.setMassEffectProcess(newEffectProcess.getCode());
		ManageschemeDesignExample example = new ManageschemeDesignExample();
		example.createCriteria().andMSDesignIDEqualTo(MSDesignID).andMassEffectProcessEqualTo(oldEffectProcess);
		return msDService.updateByExampleSelective(model, example) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#exProcMschemeGetMemberByDocId(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.util.Map)
	 */
	@Override
	public Page<Map<String, Object>> exProcMschemeGetMemberByDocId(Page<Map<String, Object>> page,
			Map<String, Object> params) {
		
		if(params == null)
			params = new HashMap<String, Object>();
		if(params.get("iMemGrpid")==null)
			params.put("iMemGrpid", 0);
		params.put("iCurrentPageIndex", page.getPageNo() - 1);
		params.put("iPageSize", page.getPageSize());
		page.setResult(manageschemeDao.exProcMschemeGetMemberByDocId(params));
		page.setTotalCount(Integer.parseInt(String.valueOf(params.get("iCount"))));
		return page;
	}
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#exProcMschemeGetoraddMemberByDocId(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.util.Map)
	 */
	@Override
	public Page<Map<String, Object>> exProcMschemeGetoraddMemberByDocId(
			Page<Map<String, Object>> page, Map<String, Object> params) {
		
		if(params == null)
			params = new HashMap<String, Object>();
		params.put("iCurrentPageIndex", page.getPageNo() - 1);
		params.put("iPageSize", page.getPageSize());
		params.put("i_trueOrfalse", false);
		page.setResult(manageschemeDao.exProcMschemeGetoraddMemberByDocId(params));
		page.setTotalCount(Integer.parseInt(String.valueOf(params.get("iCount"))));
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#exProcMschemeAddMemberByDocId(java.util.Map)
	 */
	@Override
	public boolean exProcMschemeAddMemberByDocId(Map<String, Object> params) {
		
		if(params == null)
			params = new HashMap<String, Object>();
		params.put("i_trueOrfalse", true);
		Object msID = params.get("iMSDesignID");
		if(msID == null)
			return false;
		manageschemeDao.exProcMschemeAddMemberByDocId(params);
		if(params.get("iCount") != null && Integer.parseInt(params.get("iCount").toString()) > 0){
			return updateMassEffectProcess(Integer.parseInt(msID.toString()), MassEffectProcessEnum.NOTRIGGER, null);
		}
		return false;
	}
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#insertManageschemeExecs(com.bithealth.healthCore.managescheme.model.ManageschemeExec[])
	 */
	@Override
	public boolean insertManageschemeExecs(ManageschemeExec... execs) {
		
		if(execs == null || execs.length == 0)
			return false;
		if(updateMassEffectProcess(execs[0].getMSDesignID(), MassEffectProcessEnum.NOTRIGGER, null))
			return service.insertManageschemeExecs(execs) > 0;
		else
			return false;
	}
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#deleteAttached(java.lang.Integer)
	 */
	@Override
	public boolean deleteAttached(Integer id) {
		
		return service.deleteAttached(id);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#updateTaskPlanTime(java.lang.Integer, java.lang.Short, java.lang.Byte, java.util.Date)
	 */
	@Override
	public boolean updateTaskPlanTime(Integer MSDTaskID, Short planTimeValue,
			Byte planTimeType, Date planTime, Integer docId, SchemeTypeEnum type) {
		if(planTime != null){
			ManageschemeExecTaskExample example = new ManageschemeExecTaskExample();
			example.createCriteria().andMSDTaskIDEqualTo(MSDTaskID).andExecStatusEqualTo(TaskExecStatusEnum.EXECUTORY.getCode());
			ManageschemeExecTask model = new ManageschemeExecTask();
			model.setUpdateID(docId);
			model.setUpdateTime(TimeUtil.now());
			model.setPlanTime(planTime);
			return msetService.updateByExampleSelective(model, example) > 0;
		}else if(planTimeValue != null){
			ManageschemeDesignTask model = new ManageschemeDesignTask();
			model.setMSDTaskID(MSDTaskID);
			model.setUpdateID(docId);
			model.setPlanTimeValue(planTimeValue);
			model.setPlanTimeType(planTimeType);
			model.setDesign(new ManageschemeDesign());
			model.getDesign().setSchemeType(type.getCode());
			return service.updateManageschemeTask(model);
		}
		return false;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#updateTaskPlanTime(java.lang.Long, java.util.Date, java.lang.Integer)
	 */
	@Override
	public boolean updateTaskPlanTime(Long MSETaskID, Date planTime,
			Integer docId) {
		if(MSETaskID == null || planTime == null)
			return false;
		ManageschemeExecTaskExample example = new ManageschemeExecTaskExample();
		example.createCriteria().andMSETaskIDEqualTo(MSETaskID).andExecStatusEqualTo(TaskExecStatusEnum.EXECUTORY.getCode());
		ManageschemeExecTask model = new ManageschemeExecTask();
		model.setUpdateID(docId);
		model.setUpdateTime(TimeUtil.now());
		model.setPlanTime(planTime);
		return msetService.updateByExampleSelective(model, example) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#deleteGroupMember(java.lang.Long)
	 */
	@Override
	public boolean deleteGroupMember(Long MSExecID) {
		ManageschemeExec exec = mseService.selectById(MSExecID);
		ManageschemeDesign msd = msDService.selectById(exec.getMSDesignID());
		if(MassEffectProcessEnum.GENERATING.getCode().equals(msd.getMassEffectProcess())){
			return false;
		}
		ManageschemeExecExample example = new ManageschemeExecExample();
		example.createCriteria().andMSExecIDEqualTo(MSExecID)
		.andMEPersonProcessIn(Arrays.asList(MassEffectProcessEnum.NOTRIGGER.getCode(), MassEffectProcessEnum.FAIL.getCode()));
//		.andMEPersonProcessEqualTo(MassEffectProcessEnum.NOTRIGGER.getCode());
		if(mseService.deleteByExample(example) > 0){
			example.clear();
			example.createCriteria().andMSDesignIDEqualTo(msd.getMSDesignID())
			.andMEPersonProcessIn(Arrays.asList(MassEffectProcessEnum.NOTRIGGER.getCode(), MassEffectProcessEnum.FAIL.getCode()));
//			.andMEPersonProcessEqualTo(MassEffectProcessEnum.NOTRIGGER.getCode());
			if(mseService.selectByExample(example).isEmpty()){//没有未触发及失败会员，修改主表状态为已生成
				ManageschemeDesign design = new ManageschemeDesign();
				design.setMSDesignID(msd.getMSDesignID());
				design.setMassEffectProcess(MassEffectProcessEnum.FINISH.getCode());
				msDService.update(design);
			}else{//有未触发或失败会员
				example.clear();
				example.createCriteria().andMSDesignIDEqualTo(msd.getMSDesignID())
				.andMEPersonProcessEqualTo(MassEffectProcessEnum.NOTRIGGER.getCode());
				if(mseService.selectByExample(example).isEmpty()){//没有未触发但有生成失败会员
					ManageschemeDesign design = new ManageschemeDesign();
					design.setMSDesignID(msd.getMSDesignID());
					design.setMassEffectProcess(MassEffectProcessEnum.FAIL.getCode());
					msDService.update(design);
				}
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
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#selectHasOtherTask(java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean selectHasOtherExecutoryTask(Long MSExecID, Long MSETaskID) {
		
		ManageschemeExecTaskExample example = new ManageschemeExecTaskExample();
		example.createCriteria()
		.andMSExecIDEqualTo(MSExecID.intValue())
		.andMSETaskIDNotEqualTo(MSETaskID)
		.andExecStatusEqualTo(TaskExecStatusEnum.EXECUTORY.getCode());
		return !msetService.selectByExample(example).isEmpty();
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.ManageschemeFacedeService#singleTerminatedManagescheme(java.lang.Integer, java.lang.Integer, com.bithealth.healthCore.enmu.GroupManageschemeEnum, java.lang.String)
	 */
	@Override
	public boolean updateSingleTerminatedManagescheme(Integer docId,
			Integer MSDesignID, Long MSExecID, SchemeTypeEnum schemeType, GroupManageschemeEnum newStatus,
			String massOffReason) {
		if(SchemeTypeEnum.PERSON.getCode().equals(schemeType))
			msDService.updateManageschemeStatus(docId, MSDesignID, newStatus, null, massOffReason);
		if(mseService.updateSingleTerminatedManageschemeExec(docId, MSExecID, massOffReason) == 0){
			ManageschemeExec model = new ManageschemeExec();
			model.setExecStatus(PersonManageschemeEnum.TERMINATED.getCode());
			model.setExecOffReason(massOffReason); 
			model.setExecOffTime(TimeUtil.now());
			model.setUpdateID(docId);
			ManageschemeExecExample example = new ManageschemeExecExample();
			example.createCriteria().andMSExecIDEqualTo(MSExecID);
			mseService.updateByExampleSelective(model, example);
		}
		return true;
	}
}

