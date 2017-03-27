package com.bithealth.healthCore.templet.service.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.healthCore.templet.dao.ManageschemeTempletTaskMapper;
import com.bithealth.healthCore.templet.model.ManageschemeTempletTask;
import com.bithealth.healthCore.templet.model.ManageschemeTempletTaskExample;
import com.bithealth.healthCore.templet.service.ManageschemeTempletTaskService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class ManageschemeTempletTaskServiceImpl extends GenericBaseServiceImpl<ManageschemeTempletTask,ManageschemeTempletTaskExample,
      Integer> implements ManageschemeTempletTaskService {
          
    @Autowired
	private ManageschemeTempletTaskMapper dao;
        
    @Override
    public GenericBaseDao<ManageschemeTempletTask, ManageschemeTempletTaskExample,  Integer> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.templet.service.ManageschemeTempletTaskService#inserts(java.lang.Integer, java.util.List)
     */
    public int inserts(Integer masterId,
    		List<ManageschemeTempletTask> models) {
    	int n = 0;
    	if(models != null && models.size() > 0){
    		for(Iterator<ManageschemeTempletTask> it = models.iterator(); it.hasNext();){
    			ManageschemeTempletTask model = it.next();
    			if(model != null){
    				model.setMSTempletID(masterId);
        			model.setCreateTime(TimeUtil.now());
        			n += insert(model);
    			}
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
     *  @see com.bithealth.healthCore.templet.service.ManageschemeTempletTaskService#selectList(java.lang.Integer)
     */
    public List<ManageschemeTempletTask> selectList(Integer masterId) {
    	
    	ManageschemeTempletTaskExample example = new ManageschemeTempletTaskExample();
    	example.createCriteria().andMSTempletIDEqualTo(masterId);
    	return selectByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.templet.service.ManageschemeTempletTaskService#deleteByMasterId(java.lang.Integer[])
     */
    @Override
    public int deleteByMasterId(Integer... ids) {
    	
    	ManageschemeTempletTaskExample example = new ManageschemeTempletTaskExample();
    	example.createCriteria().andMSTempletIDIn(Arrays.asList(ids));
    	return deleteByExample(example);
    }
}
