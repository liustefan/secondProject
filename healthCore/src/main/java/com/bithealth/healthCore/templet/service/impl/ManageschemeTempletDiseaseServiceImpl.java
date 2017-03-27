package com.bithealth.healthCore.templet.service.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.healthCore.templet.dao.ManageschemeTempletDiseaseMapper;
import com.bithealth.healthCore.templet.model.ManageschemeTempletDisease; 
import com.bithealth.healthCore.templet.model.ManageschemeTempletDiseaseExample;
import com.bithealth.healthCore.templet.service.ManageschemeTempletDiseaseService;

@Component
public class ManageschemeTempletDiseaseServiceImpl extends GenericBaseServiceImpl<ManageschemeTempletDisease,ManageschemeTempletDiseaseExample,
      Integer> implements ManageschemeTempletDiseaseService {
          
    @Autowired
	private ManageschemeTempletDiseaseMapper dao;
        
    @Override
    public GenericBaseDao<ManageschemeTempletDisease, ManageschemeTempletDiseaseExample,  Integer> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.templet.service.ManageschemeTempletDiseaseService#inserts(java.lang.Integer, java.util.List)
     */
    public int inserts(Integer masterId,
    		List<ManageschemeTempletDisease> models) {
    	int n = 0;
    	if(models != null && models.size() > 0){
    		for(Iterator<ManageschemeTempletDisease> it = models.iterator(); it.hasNext();){
    			ManageschemeTempletDisease model = it.next();
    			if(model != null){
    				model.setMSTempletID(masterId);
        			model.setUpdateTime(TimeUtil.now());
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
     *  @see com.bithealth.healthCore.templet.service.ManageschemeTempletDiseaseService#updates(java.lang.Integer, java.util.List)
     */
    public int updates(Integer masterId, List<ManageschemeTempletDisease> models) {
    	int n = 0;
    	ManageschemeTempletDiseaseExample example = new ManageschemeTempletDiseaseExample();
    	example.createCriteria().andMSTempletIDEqualTo(masterId);
    	n += deleteByExample(example);
    	n += inserts(masterId, models);
    	return n;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.templet.service.ManageschemeTempletDiseaseService#selectList(java.lang.Integer)
     */
    public List<ManageschemeTempletDisease> selectList(Integer masterId) {
    	return dao.selectList(masterId);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.templet.service.ManageschemeTempletDiseaseService#deleteByMasterId(java.lang.Integer[])
     */
    @Override
    public int deleteByMasterId(Integer... ids) {
    	ManageschemeTempletDiseaseExample example = new ManageschemeTempletDiseaseExample();
    	example.createCriteria().andMSTempletIDIn(Arrays.asList(ids));
    	return deleteByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.templet.service.ManageschemeTempletDiseaseService#deleteByMSDiseaseID(java.lang.Integer[])
     */
    @Override
    public int deleteByMSDiseaseID(Integer... MSDiseaseID) {
    	ManageschemeTempletDiseaseExample example = new ManageschemeTempletDiseaseExample();
    	example.createCriteria().andMSDiseaseIDIn(Arrays.asList(MSDiseaseID));
    	return deleteByExample(example);
    }
}
