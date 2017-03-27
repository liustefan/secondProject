package com.bithealth.healthCore.managescheme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.healthCore.enmu.GroupManageschemeEnum;
import com.bithealth.healthCore.managescheme.dao.ManageschemeDesignMapper;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesign;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignExample;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class ManageschemeDesignServiceImpl extends GenericBaseServiceImpl<ManageschemeDesign,ManageschemeDesignExample,
      Integer> implements ManageschemeDesignService {
          
    @Autowired
	private ManageschemeDesignMapper dao;
        
    @Override
    public GenericBaseDao<ManageschemeDesign, ManageschemeDesignExample,  Integer> getDao() {
        return dao;
    }  
    
//    /** 
//     * @Title: send 
//     * @Description: TODO 简单描述该方法的实现功能（可选）.
//     * @param  
//     * @throws      
//     * @retrun  
//     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeDesignService#selectGroupManageschemePage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.managescheme.model.ManageschemeDesign)
//     */
//    @Override
//    public Page<ManageschemeDesign> selectGroupManageschemePage(
//    		Page<ManageschemeDesign> page, ManageschemeDesign model) {
//    	
//    	dao.selectGroupManageschemePage(page, model);
//    	return page;
//    }
    
     
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeDesignService#updateManageschemeStatus(java.lang.Integer, com.bithealth.healthCore.enmu.GroupManageschemeEnum, com.bithealth.healthCore.enmu.GroupManageschemeEnum, java.lang.String)
     */
    @Override
    public int updateManageschemeStatus(Integer docId, Integer MSDesignID,
    		GroupManageschemeEnum newStatus, GroupManageschemeEnum oldStatus,
    		String massOffReason) {
    	
    	ManageschemeDesign model = new ManageschemeDesign();
		model.setMassStatus(newStatus.getCode());
		if(GroupManageschemeEnum.TERMINATED.equals(newStatus)){
			model.setMassOffTime(TimeUtil.now());
			model.setMassOffReason(massOffReason);
		}
		if(docId != null)
			model.setUpdateID(docId);
		if(GroupManageschemeEnum.EFFECT.equals(newStatus))
			model.setMassEffectTime(TimeUtil.now());
		ManageschemeDesignExample example = new ManageschemeDesignExample();
		example.createCriteria().andMSDesignIDEqualTo(MSDesignID).andMassStatusEqualTo(oldStatus);
		return updateByExampleSelective(model, example);
    }
}
