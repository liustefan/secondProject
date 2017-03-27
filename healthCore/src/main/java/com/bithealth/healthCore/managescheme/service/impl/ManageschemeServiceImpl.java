 
/**
 * @PackageName:      com.bithealth.healthCore.managescheme.service.impl
 * @FileName:     ManageschemeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月8日 上午11:03:12  
 * 
 */

package com.bithealth.healthCore.managescheme.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.healthCore.enmu.GroupManageschemeEnum;
import com.bithealth.healthCore.enmu.MassEffectProcessEnum;
import com.bithealth.healthCore.enmu.PersonManageschemeEnum;
import com.bithealth.healthCore.enmu.SchemeTypeEnum;
import com.bithealth.healthCore.enmu.TaskExecStatusEnum;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesign;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignDetail;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignDetailExample;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignExample;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExec;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecExample;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTaskExample;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignDetailService;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignService;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignTaskService;
import com.bithealth.healthCore.managescheme.service.ManageschemeExecService;
import com.bithealth.healthCore.managescheme.service.ManageschemeExecTaskService;
import com.bithealth.healthCore.managescheme.service.ManageschemeService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: ManageschemeServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月8日 上午11:03:12 
 * 
 * @author baozj
 * @version  
 */
@Service
public class ManageschemeServiceImpl implements ManageschemeService {
	
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
	MemberService memberService;
	@Autowired
	DoctorService doctorService;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#selectPersonManageschemePage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.managescheme.model.ManageschemeExec)
	 */
	@Override
	public Page<ManageschemeExec> selectPersonManageschemePage(
			Page<ManageschemeExec> page, ManageschemeExec model) {
		
		execService.selectPersonManageschemePage(page, model);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#selectGroupManageschemePage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.managescheme.model.ManageschemeDesign)
	 */
	@Override
	public Page<ManageschemeDesign> selectGroupManageschemePage(
			Page<ManageschemeDesign> page, ManageschemeDesign model) {
		ManageschemeDesignExample example = new ManageschemeDesignExample();
		example.createCriteria()
		.andSchemeTypeEqualTo(SchemeTypeEnum.GROUP.getCode())
		.andCreateIDEqualTo(model.getCreateID())
		.andSchemeTitleLike(model.getSchemeTitle())
		.andMassStatusEqualTo(model.getMassStatus())
		.andCreateTimeGreaterThanOrEqualTo(model.getCreateTimeS())
		.andCreateTimeLessThan(model.getCreateTimeE() != null ? DateUtils.addDays(model.getCreateTimeE(), 1) : null)
		.andMassEffectProcessEqualTo(model.getMassEffectProcess());
		example.setOrderByClause("CreateTime DESC");
		designService.selectByExampleAndPage(page, example);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#selectManageschemeById(java.lang.Integer)
	 */
	@Override
	public ManageschemeDesign selectManageschemeById(Integer MSDesignID) {
		ManageschemeDesign model = designService.selectById(MSDesignID);
		if(model != null){
			model.setDesignDetail(designDetailService.selectById(model.getMSDesignID()));
			if(SchemeTypeEnum.PERSON.getCode().equals(model.getSchemeType()))
				model.setExec(execService.selectByMasterId(model.getMSDesignID()));
			model.setDesignTasks(designTaskService.selectByMasterId(model.getMSDesignID(), SchemeTypeEnum.getEnumByCode(model.getSchemeType())));
			Collections.sort(model.getDesignTasks(), new Comparator<ManageschemeDesignTask>() {
				@Override
				public int compare(ManageschemeDesignTask o1,
						ManageschemeDesignTask o2) {
					
					if(o1.getExecTask() != null && o2.getExecTask() != null){
						return o1.getExecTask().getPlanTime().compareTo(o2.getExecTask().getPlanTime());
					}else{
						return o1.getPlanTime().compareTo(o2.getPlanTime());
					}
				}
			});
		}
		return model;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#deleteManagescheme(java.lang.Integer)
	 */
	@Override
	public boolean deleteManagescheme(Integer MSDesignID) {
		ManageschemeDesignExample example = new ManageschemeDesignExample();
		example.createCriteria()
		.andMSDesignIDEqualTo(MSDesignID)
		.andMassStatusEqualTo(GroupManageschemeEnum.MAKING.getCode());
		if(designService.deleteByExample(example) > 0){
			designDetailService.deleteByMSDesignID(MSDesignID);
			designTaskService.deleteByMSDesignID(MSDesignID);
			execService.deleteByMSDesignID(MSDesignID);
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
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#deleteManageschemeTask(java.lang.Integer)
	 */
	@Override
	public boolean deleteManageschemeTask(Integer MSDTaskID, SchemeTypeEnum st) {
		int n  = 0;
		if(SchemeTypeEnum.PERSON.equals(st)){
			ManageschemeExecTaskExample example = new ManageschemeExecTaskExample();
			example.createCriteria().andMSDTaskIDEqualTo(MSDTaskID).andExecStatusEqualTo(TaskExecStatusEnum.EXECUTORY.getCode());
			n += execTaskService.deleteByExample(example);
			if(n > 0)
				n += designTaskService.delete(MSDTaskID);
			return n > 0;
		}else{
			ManageschemeExecTaskExample example = new ManageschemeExecTaskExample();
			example.createCriteria().andMSDTaskIDEqualTo(MSDTaskID);
			if(execTaskService.selectByExample(example).size() == 0)
				return designTaskService.delete(MSDTaskID) > 0;
			return false;
		}
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#updateManagescheme(java.lang.Integer, com.bithealth.healthCore.enmu.GroupManageschemeEnum, com.bithealth.healthCore.enmu.GroupManageschemeEnum, java.lang.String)
	 */
	@Override
	public boolean updateManagescheme(Integer docId, Integer MSDesignID,
			GroupManageschemeEnum newStatus, GroupManageschemeEnum oldStatus,
			String massOffReason) {
		
		if(GroupManageschemeEnum.TERMINATED.equals(newStatus)){
			if(designService.updateManageschemeStatus(docId, MSDesignID, newStatus, oldStatus, massOffReason) > 0){
				if(execService.terminatedManageschemeExec(docId, MSDesignID, massOffReason) == 0){
					ManageschemeExec model = new ManageschemeExec();
					model.setExecStatus(PersonManageschemeEnum.TERMINATED.getCode());
					model.setExecOffReason(massOffReason); 
					model.setExecOffTime(TimeUtil.now());
					model.setUpdateID(docId);
					ManageschemeExecExample example = new ManageschemeExecExample();
					example.createCriteria().andMSDesignIDEqualTo(MSDesignID);
					execService.updateByExampleSelective(model, example);
				}
				return true;
			}
		}
		return false;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#insertManagescheme(com.bithealth.healthCore.managescheme.model.ManageschemeDesign)
	 */
	@Override
	public boolean insertManagescheme(ManageschemeDesign model) {
		
		int n = 0;
		model.setCreateTime(TimeUtil.now());
		model.setMassStatus(GroupManageschemeEnum.MAKING.getCode());
		n += designService.insert(model);
		model.getDesignDetail().setCreateID(model.getCreateID());
		n += designDetailService.insert(model.getDesignDetail(), model.getMSDesignID());
		if(model.getSchemeType().equals(SchemeTypeEnum.PERSON.getCode())){
			model.getExec().setCreateID(model.getCreateID());
			model.getExec().setCreateTime(model.getCreateTime());
			
			model.getExec().setUpdateID(model.getCreateID());
			model.getExec().setUpdateTime(model.getCreateTime()); 
			model.getExec().setExecStatus(PersonManageschemeEnum.MAKING.getCode());
			n += execService.insert(model.getExec(), model.getMSDesignID());
		}else{
			ManageschemeDesign pojo = new ManageschemeDesign();
			pojo.setMassEffectProcess(MassEffectProcessEnum.NOTRIGGER.getCode());
			pojo.setMSDesignID(model.getMSDesignID());
			n += designService.update(pojo);
		}
		List<ManageschemeDesignTask> dTask = model.getDesignTasks();
		if(dTask != null && dTask.size() > 0){
			for (Iterator<ManageschemeDesignTask> iterator = dTask.iterator(); iterator.hasNext();) {
				ManageschemeDesignTask manageschemeDesignTask = iterator.next();
				manageschemeDesignTask.setCreateID(model.getCreateID());
				manageschemeDesignTask.setMSDesignID(model.getMSDesignID());
				insertManageschemeTask(manageschemeDesignTask, SchemeTypeEnum.getEnumByCode(model.getSchemeType()), model.getExec() != null ? model.getExec().getMSExecID() : null);
			}
			if(SchemeTypeEnum.PERSON.getCode().equals(model.getSchemeType())){
				n += designService.updateManageschemeStatus(model.getCreateID(), model.getMSDesignID(), GroupManageschemeEnum.EFFECT, null, null);
				n += execService.updateManageschemeStatus(model.getMSDesignID(), PersonManageschemeEnum.EXECUTION, null, null);
			}
		}
		return n > 0;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#updateManagescheme(com.bithealth.healthCore.managescheme.model.ManageschemeDesign)
	 */
	@Override
	public boolean updateManagescheme(ManageschemeDesign model) {
		
		int n = 0;
		model.setUpdateTime(TimeUtil.now());
		n += designService.update(model);
		model.getDesignDetail().setUpdateID(model.getUpdateID());
		n += designDetailService.update(model.getDesignDetail(), model.getMSDesignID());
		if(model.getSchemeType().equals(SchemeTypeEnum.PERSON.getCode())){
			model.setUpdateID(model.getUpdateID());
			n += execService.update(model.getExec(), model.getMSDesignID());
		}
		if(model.getReferenceId() != null){
			execTaskService.deleteByMSDesignID(model.getMSDesignID());
			designTaskService.deleteByMSDesignID(model.getMSDesignID());
		}
		List<ManageschemeDesignTask> dTask = model.getDesignTasks();
		if(dTask != null && dTask.size() > 0){
			for (Iterator<ManageschemeDesignTask> iterator = dTask.iterator(); iterator.hasNext();) {
				ManageschemeDesignTask manageschemeDesignTask = iterator.next();
				manageschemeDesignTask.setCreateID(model.getCreateID());
				manageschemeDesignTask.setMSDesignID(model.getMSDesignID());
				insertManageschemeTask(manageschemeDesignTask, SchemeTypeEnum.getEnumByCode(model.getSchemeType()), model.getExec() != null ? model.getExec().getMSExecID() : null);
			}
			if(SchemeTypeEnum.PERSON.getCode().equals(model.getSchemeType())){
				n += designService.updateManageschemeStatus(model.getCreateID(), model.getMSDesignID(), GroupManageschemeEnum.EFFECT, null, null);
				n += execService.updateManageschemeStatus(model.getMSDesignID(), PersonManageschemeEnum.EXECUTION, null, null);
			}
		}
		return n > 0;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#insertManageschemeTask(com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask)
	 */
	@Override
	public boolean insertManageschemeTask(ManageschemeDesignTask model, SchemeTypeEnum sType, Long MSExecID) {
		List<ManageschemeDesignTask> tasks = designTaskService.selectByMasterId(model.getMSDesignID(), SchemeTypeEnum.GROUP);
		model.setCreateTime(TimeUtil.now());
		int n = designTaskService.insert(model);
		if(SchemeTypeEnum.PERSON.equals(sType)){
			if(tasks.isEmpty() && n > 0)
				n += designService.updateManageschemeStatus(model.getCreateID(), model.getMSDesignID(), GroupManageschemeEnum.EFFECT, null, null);
			if(n > 0){
				ManageschemeExecTask eTask = new ManageschemeExecTask();
				if(model.getPlanTime() != null)
					eTask.setPlanTime(model.getPlanTime());
				else
					eTask.setPlanTime(ManageschemeDesignTask.calculatePlanTime(model.getPlanTimeType(), model.getPlanTimeValue()));
				eTask.setExecStatus(TaskExecStatusEnum.EXECUTORY.getCode());
				eTask.setMSDTaskID(model.getMSDTaskID());
				eTask.setCreateID(model.getCreateID());
				eTask.setCreateTime(model.getCreateTime());
				eTask.setMSExecID(MSExecID.intValue());
				n += execTaskService.insert(eTask);
				model.setExecTask(eTask);
				n += execService.updateManageschemeStatus(model.getMSDesignID(), PersonManageschemeEnum.EXECUTION, null, null);
			}
		}
		return n > 0;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#updateManageschemeTask(com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask)
	 */
	@Override
	public boolean updateManageschemeTask(ManageschemeDesignTask model) {
		model.setUpdateTime(TimeUtil.now());
		int n = 0;
		if(SchemeTypeEnum.PERSON.getCode().equals(model.getDesign().getSchemeType())){
			ManageschemeExecTaskExample example = new ManageschemeExecTaskExample();
			example.createCriteria().andMSDTaskIDEqualTo(model.getMSDTaskID()).andExecStatusEqualTo(TaskExecStatusEnum.EXECUTORY.getCode());;
			ManageschemeExecTask eTask = new ManageschemeExecTask();
			eTask.setPlanTime(ManageschemeDesignTask.calculatePlanTime(model.getPlanTimeType(), model.getPlanTimeValue()));
			eTask.setUpdateID(model.getUpdateID());
			eTask.setUpdateTime(model.getUpdateTime());
			n += execTaskService.updateByExampleSelective(eTask, example);
			if(n > 0)
				n += designTaskService.update(model);
		}else{
			n += designTaskService.update(model);
		}
		
		return n > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#selectManageschemePage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.managescheme.model.ManageschemeExec)
	 */
	@Override
	public Page<ManageschemeExec> selectManageschemePage(
			Page<ManageschemeExec> page, ManageschemeExec model) {
		
		execService.selectManageschemePage(page, model);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#selectManageschemeById(java.lang.Long)
	 */
	@Override
	public ManageschemeExec selectManageschemeById(Long MSExecID) {
		ManageschemeExec model = execService.selectById(MSExecID);
		if(model != null){
			model.setDesign(designService.selectById(model.getMSDesignID()));
			model.setExecTasks(execTaskService.selectByMasterId(model.getMSExecID()));
		}
		return model;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#selectHasManageschemeExec(java.lang.Integer)
	 */
	@Override
	public ManageschemeExec selectHasManageschemeExec(Integer memberId) {
		
//		ManageschemeExecExample example = new ManageschemeExecExample();
//		example.createCriteria().andMemberIDEqualTo(memberId).andExecStatusNotEqualTo(PersonManageschemeEnum.TERMINATED.getCode());
//		List<ManageschemeExec> list = execService.selectByExample(example);
//		if(!list.isEmpty()){
//			ManageschemeExec pojo = list.get(0);
//			Member member = memberService.selectById(pojo.getMemberID());
//			pojo.setMemName(member.getMemname());
//			Doctor doctor = doctorService.selectById(pojo.getCreateID());
//			pojo.setCreateName(doctor.getDocname());
//			return pojo;
//		}
		return execService.selectHasManageschemeExec(memberId);
	}
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#insertManageschemeExecs(com.bithealth.healthCore.managescheme.model.ManageschemeExec[])
	 */
	@Override
	public int insertManageschemeExecs(ManageschemeExec... execs) {
		
		return execService.inserts(Arrays.asList(execs));
	}
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeService#deleteAttached(java.lang.Integer)
	 */
	@Override
	public boolean deleteAttached(Integer id) {
		
		ManageschemeDesignDetailExample example = new ManageschemeDesignDetailExample();
		example.createCriteria().andMSDesignIDEqualTo(id);
		ManageschemeDesignDetail model = new ManageschemeDesignDetail();
		model.setFileName("");
		model.setFilePath("");
		return designDetailService.updateByExampleSelective(model, example) > 0;
	}
}

