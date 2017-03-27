package com.bithealth.questionCore.answer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.questionCore.answer.dao.Uai21Mapper;
import com.bithealth.questionCore.answer.model.Uai21; 
import com.bithealth.questionCore.answer.model.Uai21Example;
import com.bithealth.questionCore.answer.service.Uai21Service;
import com.bithealth.questionCore.answer.model. Uai21Key; 

@Component
public class Uai21ServiceImpl extends GenericBaseServiceImpl<Uai21,Uai21Example,
      Uai21Key> implements Uai21Service {
          
    @Autowired
	private Uai21Mapper dao;
        
    @Override
    public GenericBaseDao<Uai21, Uai21Example,  Uai21Key> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.answer.service.Uai21Service#selectByMasterId(java.lang.Integer)
     */
    public List<Uai21> selectByMasterId(Integer masterId) {
    	Uai21Example example = new Uai21Example();
    	example.createCriteria().andAnsNumberEqualTo(masterId);
    	return selectByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.answer.service.Uai21Service#deleteByMasterId(java.lang.Integer)
     */
    public int deleteByMasterId(Integer masterId) {
    	
    	Uai21Example example = new Uai21Example();
    	example.createCriteria().andAnsNumberEqualTo(masterId);
    	return deleteByExample(example);
    }
}
