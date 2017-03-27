 
/**
 * @PackageName:      com.bithealth.healthCore.facede.service.impl
 * @FileName:     TempletFacedeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年11月29日 上午10:31:25  
 * 
 */

package com.bithealth.healthCore.facede.service.impl;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.healthCore.enmu.TempletStatusEnum;
import com.bithealth.healthCore.facede.service.TempletFacedeService;
import com.bithealth.healthCore.templet.model.ManageschemeTemplet;
import com.bithealth.healthCore.templet.model.ManageschemeTempletDisease;
import com.bithealth.healthCore.templet.model.ManageschemeTempletTask;
import com.bithealth.healthCore.templet.service.TempletService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: TempletFacedeServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月29日 上午10:31:25 
 * 
 * @author baozj
 * @version  
 */
@Service
public class TempletFacedeServiceImpl implements TempletFacedeService {

	@Autowired
	private TempletService templetService;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.TempletFacedeService#selectTempletById(java.lang.Integer)
	 */
	public ManageschemeTemplet selectTempletById(Integer id) {
		if(id == null)
			return null;
		return templetService.selectTempletById(id);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.TempletFacedeService#deleteTemplet(java.lang.Integer[])
	 */
	public boolean deleteTemplet(Integer... ids) {
		if(ids == null || ids.length == 0)
			return false;
		return templetService.deleteTemplet(ids);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.TempletFacedeService#insertOrUpdateTemplet(com.bithealth.healthCore.templet.model.ManageschemeTemplet)
	 */
	public boolean insertOrUpdateTemplet(ManageschemeTemplet model) {
		if(model.getDiseases() == null){
			model.setDiseases(new ArrayList<ManageschemeTempletDisease>());
			if(StringUtils.isNotEmpty(model.getMSDiseaseIDs())){
				String[] ids = model.getMSDiseaseIDs().split(",");
				for(String id : ids){
					model.getDiseases().add(new ManageschemeTempletDisease(Integer.parseInt(id)));
				}
			}
		}
		if(model.getMSTempletID() == null){
			if(model.getReferenceId() != null)
				templetService.updateUsedNumber(model.getReferenceId());
			return templetService.insertTemplet(model);
		}else{
			return templetService.updateTemplet(model);
		}
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.TempletFacedeService#updateTempletStatus(java.lang.Integer, com.bithealth.healthCore.enmu.TempletStatusEnum, com.bithealth.healthCore.enmu.TempletStatusEnum)
	 */
	public boolean updateTempletStatus(Integer id, TempletStatusEnum newStatus,
			TempletStatusEnum oldStatus) {
		
		return templetService.updateTempletStatus(id, newStatus, oldStatus);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.TempletFacedeService#insertOrUpdateTempletTask(com.bithealth.healthCore.templet.model.ManageschemeTempletTask)
	 */
	public boolean insertOrUpdateTempletTask(ManageschemeTempletTask model) {

		if(model.getMSTTaskID() == null)
			return templetService.insertTempletTask(model);
		else
			return templetService.updateTempletTask(model);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.TempletFacedeService#deleteTempletTask(java.lang.Integer)
	 */
	public boolean deleteTempletTask(Integer id) {
		
		return templetService.deleteTempletTask(id);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.TempletFacedeService#selectTempletPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.templet.model.ManageschemeTemplet)
	 */
	public Page<ManageschemeTemplet> selectTempletPage(
			Page<ManageschemeTemplet> page, ManageschemeTemplet model) {
		return templetService.selectTempletPage(page, model);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.TempletFacedeService#selectTempletIsExist(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public boolean selectTempletIsExist(String schemeTitle, Integer id, Integer docId) {
		
		return templetService.selectTempletIsExist(schemeTitle, id, docId);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.TempletFacedeService#deleteAttached(java.lang.Integer)
	 */
	@Override
	public boolean deleteAttached(Integer id) {
		
		return templetService.deleteAttached(id);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.TempletFacedeService#updateUsedNumber(java.lang.Integer)
	 */
	@Override
	public boolean updateUsedNumber(Integer id) {
		
		return templetService.updateUsedNumber(id);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.facede.service.TempletFacedeService#selectTempletIsExist(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public ManageschemeTemplet selectTempletIsExist(Integer roleId, String schemeTitle, Integer id,
			Integer docId, String allSharedOrg) {
		
		return templetService.selectTempletIsExist(roleId, schemeTitle, id, docId, allSharedOrg);
	}
}

