package com.bithealth.healthCore.managescheme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.healthCore.managescheme.dao.ManageschemeExecTaskMapper;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTaskExample;
import com.bithealth.healthCore.managescheme.service.ManageschemeExecTaskService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class ManageschemeExecTaskServiceImpl extends GenericBaseServiceImpl<ManageschemeExecTask,ManageschemeExecTaskExample,
      Long> implements ManageschemeExecTaskService {
          
    @Autowired
	private ManageschemeExecTaskMapper dao;
        
    @Override
    public GenericBaseDao<ManageschemeExecTask, ManageschemeExecTaskExample,  Long> getDao() {
        return dao;
    }

    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecTaskService#selectManageschemeTaskPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.managescheme.model.ManageschemeExecTask)
     */
    @Override
    public List<ManageschemeExecTask> selectManageschemeTaskPage(
    		Page<ManageschemeExecTask> page, ManageschemeExecTask model) {
    	
    	return dao.selectManageschemeTaskPage(page, model);
    }
    
   /** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecTaskService#selectByMasterId(java.lang.Long)
	 */
	@Override
	public List<ManageschemeExecTask> selectByMasterId(Long masterId) {
		
		return dao.selectByMasterId(masterId);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecTaskService#deleteByMSDesignID(java.lang.Integer)
	 */
	@Override
	public boolean deleteByMSDesignID(Integer MSDesignID) {
		
		return dao.deleteByMSDesignID(MSDesignID) > 0;
	}
}
