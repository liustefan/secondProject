package com.bithealth.questionCore.answer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.questionCore.answer.dao.OuaiMapper;
import com.bithealth.questionCore.answer.model.Ouai; 
import com.bithealth.questionCore.answer.model.OuaiExample;
import com.bithealth.questionCore.answer.service.OuaiService;

@Component
public class OuaiServiceImpl extends GenericBaseServiceImpl<Ouai,OuaiExample,
      Integer> implements OuaiService {
          
    @Autowired
	private OuaiMapper dao;
        
    @Override
    public GenericBaseDao<Ouai, OuaiExample,  Integer> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.answer.service.OuaiService#updateByPrimaryKeySelective(com.bithealth.questionCore.answer.model.Ouai)
     */
    public int updateByPrimaryKeySelective(Ouai model) {
    	
    	return dao.updateByPrimaryKeySelective(model);
    }
}
