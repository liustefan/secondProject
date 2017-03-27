package com.bithealth.questionCore.question.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.questionCore.question.dao.Mfq21Mapper;
import com.bithealth.questionCore.question.model.Mfq21;
import com.bithealth.questionCore.question.model.Mfq21Example;
import com.bithealth.questionCore.question.model.Mfq21Key;
import com.bithealth.questionCore.question.service.Mfq21Service;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class Mfq21ServiceImpl extends GenericBaseServiceImpl<Mfq21,Mfq21Example,
      Mfq21Key> implements Mfq21Service {
          
    @Autowired
	private Mfq21Mapper dao;
        
    @Override
    public GenericBaseDao<Mfq21, Mfq21Example,  Mfq21Key> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq21Service#deleteByMasterId(java.lang.Integer)
     */
    public int deleteByMasterId(Integer masterId) {
    	
    	Mfq21Example example = new Mfq21Example();
    	example.createCriteria().andQustidEqualTo(masterId);
    	return deleteByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq21Service#inserts(java.lang.Integer, java.util.List)
     */
    public int inserts(Integer masterId, List<Mfq21> list) {
    	
    	int n = 0;
    	if(list != null && list.size() > 0){
    		for(Iterator<Mfq21> it = list.iterator(); it.hasNext();){
    			Mfq21 model = it.next();
    			model.setQustid(masterId);
    			model.setLineNum(model.getConvid());
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
     *  @see com.bithealth.questionCore.question.service.Mfq21Service#deleteByMasterId(java.util.List)
     */
    public int deleteByMasterId(List<Integer> ids) {
    	
    	Mfq21Example example = new Mfq21Example();
		example.createCriteria().andQustidIn(ids);
		return deleteByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.Mfq21Service#selectByMasterId(java.lang.Integer)
     */
    public List<Mfq21> selectByMasterId(Integer masterId) {
    	
    	Mfq21Example example = new Mfq21Example();
		example.createCriteria().andQustidEqualTo(masterId);
		return selectByExample(example);
    }
    
}
