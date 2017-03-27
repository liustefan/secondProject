package com.bithealth.questionCore.audit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.questionCore.audit.dao.Cam2Mapper;
import com.bithealth.questionCore.audit.model.Cam2; 
import com.bithealth.questionCore.audit.model.Cam2Example;
import com.bithealth.questionCore.audit.service.Cam2Service;
import com.bithealth.questionCore.audit.model. Cam2Key; 

@Component
public class Cam2ServiceImpl extends GenericBaseServiceImpl<Cam2,Cam2Example,
      Cam2Key> implements Cam2Service {
          
    @Autowired
	private Cam2Mapper dao;
        
    @Override
    public GenericBaseDao<Cam2, Cam2Example,  Cam2Key> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.audit.service.Cam2Service#selectLatestAudit(java.lang.Integer)
     */
    @Override
    public Cam2 selectLatestAudit(Integer memberId) {
    	
    	return dao.selectLatestAudit(memberId);
    }
}
