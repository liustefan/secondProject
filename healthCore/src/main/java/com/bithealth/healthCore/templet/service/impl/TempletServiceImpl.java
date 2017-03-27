 
/**
 * @PackageName:      com.bithealth.healthCore.templet.service.impl
 * @FileName:     TempletServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年11月29日 上午10:23:54  
 * 
 */

package com.bithealth.healthCore.templet.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.healthCore.enmu.TempletStatusEnum;
import com.bithealth.healthCore.templet.model.ManageschemeTemplet;
import com.bithealth.healthCore.templet.model.ManageschemeTempletExample;
import com.bithealth.healthCore.templet.model.ManageschemeTempletTask;
import com.bithealth.healthCore.templet.service.ManageschemeTempletDiseaseService;
import com.bithealth.healthCore.templet.service.ManageschemeTempletService;
import com.bithealth.healthCore.templet.service.ManageschemeTempletTaskService;
import com.bithealth.healthCore.templet.service.TempletService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: TempletServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月29日 上午10:23:54 
 * 
 * @author baozj
 * @version  
 */
@Service
public class TempletServiceImpl implements TempletService {

	@Autowired
	private ManageschemeTempletService templetService;
	@Autowired
	private ManageschemeTempletDiseaseService templetDiseaseService;
	@Autowired
	private ManageschemeTempletTaskService templetTaskService;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.templet.service.TempletService#selectTempletById(java.lang.Integer)
	 */
	public ManageschemeTemplet selectTempletById(Integer id) {
		ManageschemeTemplet pojo = templetService.selectById(id);
		if(pojo != null)
			pojo.setTasks(templetTaskService.selectList(pojo.getMSTempletID()));
		return pojo;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.templet.service.TempletService#deleteTemplet(java.lang.Integer[])
	 */
	public boolean deleteTemplet(Integer... ids) {
		int n = 0;
		if(ids.length == 1){
			n = templetService.delete(ids[0]);
		}else{
			ManageschemeTempletExample example = new ManageschemeTempletExample();
			example.createCriteria().andMSTempletIDIn(Arrays.asList(ids));
			n = templetService.deleteByExample(example);
		}
		if(n > 0){
			templetDiseaseService.deleteByMasterId(ids);
			templetTaskService.deleteByMasterId(ids);
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
	 *  @see com.bithealth.healthCore.templet.service.TempletService#insertTemplet(com.bithealth.healthCore.templet.model.ManageschemeTemplet)
	 */
	public boolean insertTemplet(ManageschemeTemplet model) {
		int n = 0;
		model.setCreateTime(TimeUtil.now());
		model.setUpdateTime(TimeUtil.now());
		model.setUsedNumber(0);
		n += templetService.insert(model);
		n += templetDiseaseService.inserts(model.getMSTempletID(), model.getDiseases());
		n += templetTaskService.inserts(model.getMSTempletID(), model.getTasks());
		return n > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.templet.service.TempletService#updateTemplet(com.bithealth.healthCore.templet.model.ManageschemeTemplet)
	 */
	public boolean updateTemplet(ManageschemeTemplet model) {
		int n = 0;
		model.setUpdateTime(TimeUtil.now());
		n += templetService.update(model);
		n += templetDiseaseService.updates(model.getMSTempletID(), model.getDiseases());
		return n > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.templet.service.TempletService#updateTempletStatus(java.lang.Integer, com.bithealth.healthCore.enmu.TempletStatusEnum, com.bithealth.healthCore.enmu.TempletStatusEnum)
	 */
	public boolean updateTempletStatus(Integer id, TempletStatusEnum newStatus,
			TempletStatusEnum oldStatus) {
		ManageschemeTempletExample example = new ManageschemeTempletExample();
		example.createCriteria().andMSTempletIDEqualTo(id).andTempletStatusEqualTo(oldStatus);
		ManageschemeTemplet model = new ManageschemeTemplet();
		model.setTempletStatus(newStatus.getCode());
		return templetService.updateByExampleSelective(model, example) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.templet.service.TempletService#insertTempletTask(com.bithealth.healthCore.templet.model.ManageschemeTempletTask)
	 */
	public boolean insertTempletTask(ManageschemeTempletTask model) {
		model.setCreateTime(TimeUtil.now());
		return templetTaskService.insert(model) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.templet.service.TempletService#updateTempletTask(com.bithealth.healthCore.templet.model.ManageschemeTempletTask)
	 */
	public boolean updateTempletTask(ManageschemeTempletTask model) {
		model.setUpdateTime(TimeUtil.now());
		return templetTaskService.update(model) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.templet.service.TempletService#deleteTempletTask(java.lang.Integer)
	 */
	public boolean deleteTempletTask(Integer id) {
		return templetTaskService.delete(id) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.templet.service.TempletService#selectTempletPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.templet.model.ManageschemeTempletExample)
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
	 *  @see com.bithealth.healthCore.templet.service.TempletService#selectTempletIsExist(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public boolean selectTempletIsExist(String schemeTitle, Integer id, Integer docId) {
		ManageschemeTempletExample example = new ManageschemeTempletExample();
		example.createCriteria()
		.andSchemeTitleEqualTo(schemeTitle)
		.andCreateIDEqualTo(docId)
		.andMSTempletIDNotEqualTo(id);
		return templetService.selectByExample(example).size() > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.templet.service.TempletService#deleteAttached(java.lang.Integer)
	 */
	@Override
	public boolean deleteAttached(Integer id) {
		ManageschemeTempletExample example = new ManageschemeTempletExample();
		example.createCriteria().andMSTempletIDEqualTo(id);
		ManageschemeTemplet model = new ManageschemeTemplet();
		model.setFileName("");
		model.setFilePath("");
		return templetService.updateByExampleSelective(model, example) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.templet.service.TempletService#updateUsedNumber(java.lang.Integer)
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
	 *  @see com.bithealth.healthCore.templet.service.TempletService#selectTempletIsExist(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public ManageschemeTemplet selectTempletIsExist(Integer roleId, String schemeTitle, Integer id,
			Integer docId, String allSharedOrg) {
		
		return templetService.selectTemplet(roleId, schemeTitle, id, docId, allSharedOrg);
	}
	
}

