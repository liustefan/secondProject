package com.bithealth.questionCore.question.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.questionCore.question.dao.Mfq11Mapper;
import com.bithealth.questionCore.question.model.Mfq11;
import com.bithealth.questionCore.question.model.Mfq11Example;
import com.bithealth.questionCore.question.model.Mfq11Key;
import com.bithealth.questionCore.question.service.Mfq11Service;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class Mfq11ServiceImpl extends GenericBaseServiceImpl<Mfq11,Mfq11Example,
      Mfq11Key> implements Mfq11Service {
          
    @Autowired
	private Mfq11Mapper dao;
        
    @Override
    public GenericBaseDao<Mfq11, Mfq11Example,  Mfq11Key> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq11Service#deleteByMasterId(java.lang.Integer)
     */
    public int deleteByMasterId(Integer masterId) {
    	
    	Mfq11Example example = new Mfq11Example();
    	example.createCriteria().andQustidEqualTo(masterId);
    	return deleteByExample(example);
    }
    
    /**
     * 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq11Service#inserts(java.lang.Integer, java.lang.Integer, java.util.List)
     */
    public int inserts(Integer masterId, Integer masterId2, List<Mfq11> list) {
    	
    	int n = 0;
    	if(list != null){
    		for(Iterator<Mfq11> it = list.iterator(); it.hasNext();){
    			Mfq11 model = it.next();
    			model.setQustid(masterId);
    			model.setProblemid(masterId2);
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
     *  @see com.bithealth.questionCore.question.service.Mfq11Service#deleteByMasterId(java.util.List)
     */
    public int deleteByMasterId(List<Integer> ids) {
    	
    	Mfq11Example example = new Mfq11Example();
		example.createCriteria().andQustidIn(ids);
		return deleteByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq11Service#selectByMasterId(java.lang.Integer, java.lang.Integer)
     */
    public List<Mfq11> selectByMasterId(Integer masterId, Integer masterId2) {
    	
    	Mfq11Example example = new Mfq11Example();
		example.createCriteria().andQustidEqualTo(masterId).andProblemidEqualTo(masterId2);
		return selectByExample(example);
    }
}
