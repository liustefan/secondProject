package com.bithealth.questionCore.question.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.questionCore.question.dao.LogicsMapper;
import com.bithealth.questionCore.question.model.Logics;
import com.bithealth.questionCore.question.model.LogicsExample;
import com.bithealth.questionCore.question.model.LogicsKey;
import com.bithealth.questionCore.question.service.LogicsService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class LogicsServiceImpl extends GenericBaseServiceImpl<Logics,LogicsExample,
      LogicsKey> implements LogicsService {
          
    @Autowired
	private LogicsMapper dao;
        
    @Override
    public GenericBaseDao<Logics, LogicsExample,  LogicsKey> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.LogicsService#deleteByMasterId(java.lang.Integer)
     */
    public int deleteByMasterId(Integer masterId) {
    	
    	LogicsExample example = new LogicsExample();
    	example.createCriteria().andQuestIdEqualTo(masterId);
    	return deleteByExample(example);
    }
    
    public int inserts(Integer masterId, Integer masterId2, List<Logics> list) {
    	int n = 0;
    	if(list != null){
    		for(Iterator<Logics> it = list.iterator(); it.hasNext();){
    			Logics model = it.next();
    			model.setQuestId(masterId);
    			model.setProblemId(masterId2);
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
     *  @see com.bithealth.questionCore.question.service.LogicsService#deleteByMasterId(java.util.List)
     */
    public int deleteByMasterId(List<Integer> ids) {
    	
    	LogicsExample example = new LogicsExample();
		example.createCriteria().andQuestIdIn(ids);
		return deleteByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.LogicsService#selectByMasterId(java.lang.Integer, java.lang.Integer)
     */
    public List<Logics> selectByMasterId(Integer masterId, Integer masterId2) {
    	
    	LogicsExample example = new LogicsExample();
		example.createCriteria().andQuestIdEqualTo(masterId).andProblemIdEqualTo(masterId2);
		return selectByExample(example);
    }
}
