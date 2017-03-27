package com.bithealth.questionCore.answer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.questionCore.answer.dao.Uai4Mapper;
import com.bithealth.questionCore.answer.model.Uai4;
import com.bithealth.questionCore.answer.model.Uai4Example;
import com.bithealth.questionCore.answer.model.Uai4Key;
import com.bithealth.questionCore.answer.service.Uai4Service;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class Uai4ServiceImpl extends GenericBaseServiceImpl<Uai4,Uai4Example,
      Uai4Key> implements Uai4Service {
          
    @Autowired
	private Uai4Mapper dao;
        
    @Override
    public GenericBaseDao<Uai4, Uai4Example,  Uai4Key> getDao() {
        return dao;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.answer.service.Uai4Service#selectByMasterId(java.lang.Integer)
     */
    public Uai4 selectByMasterId(Integer masterId) {
    	Uai4Example example = new Uai4Example();
    	example.createCriteria().andAnsNumberEqualTo(masterId);
    	List<Uai4> list = selectByExample(example);
    	return list != null && list.size() > 0 ? list.get(0) : null;
    }
}
