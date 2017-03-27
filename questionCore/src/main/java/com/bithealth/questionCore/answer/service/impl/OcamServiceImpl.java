package com.bithealth.questionCore.answer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.questionCore.answer.dao.OcamMapper;
import com.bithealth.questionCore.answer.model.Ocam; 
import com.bithealth.questionCore.answer.model.OcamExample;
import com.bithealth.questionCore.answer.service.OcamService;

@Component
public class OcamServiceImpl extends GenericBaseServiceImpl<Ocam,OcamExample,
      Integer> implements OcamService {
          
    @Autowired
	private OcamMapper dao;
        
    @Override
    public GenericBaseDao<Ocam, OcamExample,  Integer> getDao() {
        return dao;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.answer.service.OcamService#updateByPrimaryKeySelective(com.bithealth.questionCore.answer.model.Ocam)
     */
    public int updateByPrimaryKeySelective(Ocam model) {
    	
    	return dao.updateByPrimaryKeySelective(model);
    }
}
