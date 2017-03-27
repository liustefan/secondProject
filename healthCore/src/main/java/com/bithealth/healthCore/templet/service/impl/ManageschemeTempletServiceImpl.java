package com.bithealth.healthCore.templet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.healthCore.templet.dao.ManageschemeTempletMapper;
import com.bithealth.healthCore.templet.model.ManageschemeTemplet;
import com.bithealth.healthCore.templet.model.ManageschemeTempletExample;
import com.bithealth.healthCore.templet.service.ManageschemeTempletService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class ManageschemeTempletServiceImpl extends GenericBaseServiceImpl<ManageschemeTemplet,ManageschemeTempletExample,
      Integer> implements ManageschemeTempletService {
          
    @Autowired
	private ManageschemeTempletMapper dao;
        
    @Override
    public GenericBaseDao<ManageschemeTemplet, ManageschemeTempletExample,  Integer> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.templet.service.ManageschemeTempletService#selectTempletPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.templet.model.ManageschemeTemplet)
     */
    @Override
    public Page<ManageschemeTemplet> selectTempletPage(
    		Page<ManageschemeTemplet> page, ManageschemeTemplet model) {
    	
    	dao.selectTempletPage(page, model);
    	return page;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.templet.service.ManageschemeTempletService#updateUsedNumber(java.lang.Integer)
     */
    @Override
    public boolean updateUsedNumber(Integer id) {
    	
    	return dao.updateUsedNumber(id) > 0;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.templet.service.ManageschemeTempletService#selectTemplet(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String)
     */
    @Override
    public ManageschemeTemplet selectTemplet(Integer roleId, String schemeTitle,
    		Integer id, Integer docId, String allSharedOrg) {
    	
    	return dao.selectTemplet(roleId, schemeTitle, id, docId, allSharedOrg);
    }
}
