package com.bithealth.questionCore.question.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.questionCore.question.dao.Mfq2Mapper;
import com.bithealth.questionCore.question.model.Mfq2;
import com.bithealth.questionCore.question.model.Mfq2Example;
import com.bithealth.questionCore.question.model.Mfq2Key;
import com.bithealth.questionCore.question.service.Mfq2Service;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class Mfq2ServiceImpl extends GenericBaseServiceImpl<Mfq2,Mfq2Example,
      Mfq2Key> implements Mfq2Service {
          
    @Autowired
	private Mfq2Mapper dao;
        
    @Override
    public GenericBaseDao<Mfq2, Mfq2Example,  Mfq2Key> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq2Service#deleteByMasterId(java.lang.Integer)
     */
    public int deleteByMasterId(Integer masterId) {
    	
    	Mfq2Example example = new Mfq2Example();
    	example.createCriteria().andQustidEqualTo(masterId);
    	return deleteByExample(example);
    }
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq2Service#insert(java.lang.Integer, com.bithealth.questionCore.question.model.Mfq2)
     */
    public int insert(Integer masterId, Mfq2 model) {
    	
    	model.setQustid(masterId);
		return insert(model);
    }
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq2Service#inserts(java.lang.Integer, java.util.List)
     */
    public int inserts(Integer masterId, List<Mfq2> list) {
    	
    	int n = 0;
    	if(list != null && list.size() > 0){
    		for(Iterator<Mfq2> it = list.iterator(); it.hasNext();){
    			Mfq2 model = it.next();
    			n += insert(masterId, model);
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
     *  @see com.bithealth.questionCore.question.service.Mfq2Service#deleteByMasterId(java.util.List)
     */
    public int deleteByMasterId(List<Integer> ids) {
    	
    	Mfq2Example example = new Mfq2Example();
		example.createCriteria().andQustidIn(ids);
		return deleteByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq2Service#selectByMasterId(java.lang.Integer)
     */
    public List<Mfq2> selectByMasterId(Integer masterId) {
    	
    	Mfq2Example example = new Mfq2Example();
		example.createCriteria().andQustidEqualTo(masterId);
		return selectByExample(example);
    }
}
