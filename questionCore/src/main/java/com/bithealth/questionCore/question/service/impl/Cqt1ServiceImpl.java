package com.bithealth.questionCore.question.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.questionCore.question.dao.Cqt1Mapper;
import com.bithealth.questionCore.question.model.Cqt1;
import com.bithealth.questionCore.question.model.Cqt1Example;
import com.bithealth.questionCore.question.model.Cqt1Key;
import com.bithealth.questionCore.question.service.Cqt1Service;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class Cqt1ServiceImpl extends GenericBaseServiceImpl<Cqt1,Cqt1Example,
      Cqt1Key> implements Cqt1Service {
          
    @Autowired
	private Cqt1Mapper dao;
        
    @Override
    public GenericBaseDao<Cqt1, Cqt1Example,  Cqt1Key> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Cqt1Service#selectByMasterId(java.lang.Integer)
     */
    public List<Cqt1> selectByMasterId(Integer masterId) {
    	
    	Cqt1Example example = new Cqt1Example();
    	example.createCriteria().andCombQustidEqualTo(masterId);
    	return selectByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Cqt1Service#deleteByMasterId(java.util.List)
     */
    public int deleteByMasterId(List<Integer> values) {
    	
    	Cqt1Example example = new Cqt1Example();
		example.createCriteria().andCombQustidIn(values);
		return deleteByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Cqt1Service#inserts(java.lang.Integer, java.util.List)
     */
    public int inserts(Integer masterId, List<Cqt1> list) {
    	
    	int n = 0;
    	if(list != null && list.size() > 0){
    		for(Iterator<Cqt1> it = list.iterator(); it.hasNext();){
    			Cqt1 model = it.next();
    			model.setCombQustid(masterId);
    			n += insert(model);
    		}
    	}
    	return n;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Cqt1Service#updates(java.lang.Integer, java.util.List)
     */
    public int updates(Integer masterId, List<Cqt1> list) {
    	
    	int n = 0;
    	Cqt1Example example = new Cqt1Example();
    	example.createCriteria().andCombQustidEqualTo(masterId);
    	n += deleteByExample(example);
    	n += inserts(masterId, list);
    	return n;
    }
}
