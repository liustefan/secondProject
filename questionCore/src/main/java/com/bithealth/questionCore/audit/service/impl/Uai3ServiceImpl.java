package com.bithealth.questionCore.audit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.questionCore.audit.dao.Uai3Mapper;
import com.bithealth.questionCore.audit.model.Uai3; 
import com.bithealth.questionCore.audit.model.Uai3Example;
import com.bithealth.questionCore.audit.service.Uai3Service;
import com.bithealth.questionCore.audit.model. Uai3Key; 

@Component
public class Uai3ServiceImpl extends GenericBaseServiceImpl<Uai3,Uai3Example,
      Uai3Key> implements Uai3Service {
          
    @Autowired
	private Uai3Mapper dao;
        
    @Override
    public GenericBaseDao<Uai3, Uai3Example,  Uai3Key> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.audit.service.Uai3Service#selectByMasterId(java.lang.Integer)
     */
    public Uai3 selectByMasterId(Integer masterId) {
    	Uai3Example example = new Uai3Example();
    	example.createCriteria().andAnsNumberEqualTo(masterId);
    	List<Uai3> list = dao.selectByExample(example);
    	return list != null && list.size() > 0 ? list.get(0) : null; 
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.audit.service.Uai3Service#selectLatestAudit(java.lang.Integer)
     */
    @Override
    public Uai3 selectLatestAudit(Integer memberId) {
    	
    	return dao.selectLatestAudit(memberId);
    }
}
