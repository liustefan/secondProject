package com.bithealth.healthCore.managescheme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.healthCore.enmu.SchemeTypeEnum;
import com.bithealth.healthCore.managescheme.dao.ManageschemeDesignTaskMapper;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTaskExample;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignTaskService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class ManageschemeDesignTaskServiceImpl extends GenericBaseServiceImpl<ManageschemeDesignTask,ManageschemeDesignTaskExample,
      Integer> implements ManageschemeDesignTaskService {
          
    @Autowired
	private ManageschemeDesignTaskMapper dao;
        
    @Override
    public GenericBaseDao<ManageschemeDesignTask, ManageschemeDesignTaskExample,  Integer> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeDesignTaskService#selectByMasterId(java.lang.Integer, com.bithealth.healthCore.enmu.SchemeTypeEnum)
     */
    @Override
    public List<ManageschemeDesignTask> selectByMasterId(Integer masterId, SchemeTypeEnum type) {
    	
    	if(SchemeTypeEnum.GROUP.equals(type)){
    		ManageschemeDesignTaskExample example = new ManageschemeDesignTaskExample();
        	example.createCriteria()
        	.andMSDesignIDEqualTo(masterId);
        	return selectByExample(example);
    	}else{
    		return dao.selectByMasterId(masterId);
    	}
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeDesignTaskService#deleteByMSDesignID(java.lang.Integer)
     */
    @Override
    public boolean deleteByMSDesignID(Integer MSDesignID) {
    	
    	ManageschemeDesignTaskExample example = new ManageschemeDesignTaskExample();
    	example.createCriteria().andMSDesignIDEqualTo(MSDesignID);
    	return deleteByExample(example) > 0;
    }
}
