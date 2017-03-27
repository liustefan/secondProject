package com.bithealth.healthCore.managescheme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.healthCore.managescheme.dao.ManageschemeDesignDetailMapper;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignDetail; 
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignDetailExample;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignDetailService;

@Component
public class ManageschemeDesignDetailServiceImpl extends GenericBaseServiceImpl<ManageschemeDesignDetail,ManageschemeDesignDetailExample,
      Integer> implements ManageschemeDesignDetailService {
          
    @Autowired
	private ManageschemeDesignDetailMapper dao;
        
    @Override
    public GenericBaseDao<ManageschemeDesignDetail, ManageschemeDesignDetailExample,  Integer> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeDesignDetailService#deleteByMSDesignID(java.lang.Integer)
     */
    @Override
    public boolean deleteByMSDesignID(Integer MSDesignID) {
    	
    	ManageschemeDesignDetailExample example = new ManageschemeDesignDetailExample();
    	example.createCriteria().andMSDesignIDEqualTo(MSDesignID);
    	return deleteByExample(example) > 0;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeDesignDetailService#insert(com.bithealth.healthCore.managescheme.model.ManageschemeDesignDetail, java.lang.Integer)
     */
    @Override
    public int insert(ManageschemeDesignDetail model, Integer masterId) {
    	if(model != null){
    		model.setMSDesignID(masterId);
    		model.setCreateTime(TimeUtil.now());
    		return insert(model);
    	}
    	return 0;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeDesignDetailService#update(com.bithealth.healthCore.managescheme.model.ManageschemeDesignDetail, java.lang.Integer)
     */
    @Override
    public int update(ManageschemeDesignDetail model, Integer masterId) {
    	
    	if(model != null){
    		model.setMSDesignID(masterId);
    		model.setUpdateTime(TimeUtil.now());
    		return update(model);
    	}
    	return 0;
    }
}
