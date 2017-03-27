package com.bithealth.questionCore.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.questionCore.question.dao.Mfq1Mapper;
import com.bithealth.questionCore.question.model.Mfq1;
import com.bithealth.questionCore.question.model.Mfq1Example;
import com.bithealth.questionCore.question.model.Mfq1Key;
import com.bithealth.questionCore.question.service.Mfq1Service;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class Mfq1ServiceImpl extends GenericBaseServiceImpl<Mfq1,Mfq1Example,
      Mfq1Key> implements Mfq1Service {
          
    @Autowired
	private Mfq1Mapper dao;
        
    @Override
    public GenericBaseDao<Mfq1, Mfq1Example,  Mfq1Key> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq1Service#deleteByMasterId(java.lang.Integer)
     */
    public int deleteByMasterId(Integer masterId) {
    	Mfq1Example example = new Mfq1Example();
    	example.createCriteria().andQustidEqualTo(masterId);
    	return deleteByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq1Service#deleteByMasterId(java.util.List)
     */
    public int deleteByMasterId(List<Integer> ids) {
    	
    	Mfq1Example example = new Mfq1Example();
		example.createCriteria().andQustidIn(ids);
		return deleteByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq1Service#selectByMasterId(java.lang.Integer)
     */
    public List<Mfq1> selectByMasterId(Integer masterId) {
    	
    	Mfq1Example example = new Mfq1Example();
		example.createCriteria().andQustidEqualTo(masterId);
		return selectByExample(example);
    }
}
