package com.bithealth.questionCore.answer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.questionCore.answer.dao.Cam1Mapper;
import com.bithealth.questionCore.answer.model.Cam1; 
import com.bithealth.questionCore.answer.model.Cam1Example;
import com.bithealth.questionCore.answer.service.Cam1Service;
import com.bithealth.questionCore.answer.model. Cam1Key; 

@Component
public class Cam1ServiceImpl extends GenericBaseServiceImpl<Cam1,Cam1Example,
      Cam1Key> implements Cam1Service {
          
    @Autowired
	private Cam1Mapper dao;
        
    @Override
    public GenericBaseDao<Cam1, Cam1Example,  Cam1Key> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.answer.service.Cam1Service#selectByMasterId(java.lang.Integer)
     */
    public List<Cam1> selectByMasterId(Integer masterId) {
    	
    	Cam1Example example = new Cam1Example(); 
    	example.createCriteria().andCombAnsidEqualTo(masterId);
    	return dao.selectByExample(example);
    }
}
