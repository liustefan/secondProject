package com.bithealth.questionCore.audit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.questionCore.audit.dao.OasrMapper;
import com.bithealth.questionCore.audit.model.Oasr;
import com.bithealth.questionCore.audit.model.OasrExample;
import com.bithealth.questionCore.audit.service.OasrService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class OasrServiceImpl extends GenericBaseServiceImpl<Oasr,OasrExample,
      Long> implements OasrService {
          
    @Autowired
	private OasrMapper dao;
        
    @Override
    public GenericBaseDao<Oasr, OasrExample,  Long> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.audit.service.OasrService#selectSingleAnswerAuditByExampleAndPage(com.bithealth.questionCore.audit.model.OasrExample)
     */
    public List<Oasr> selectSingleAnswerAuditByExampleAndPage(Page<Oasr> page, 
    		OasrExample example) {
    	return dao.selectSingleAnswerAuditByExampleAndPage(page, example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.audit.service.OasrService#selectComAnswerAuditByExampleAndPage(com.bithealth.questionCore.audit.model.OasrExample)
     */
    public List<Oasr> selectComAnswerAuditByExampleAndPage(Page<Oasr> page, OasrExample example) {
    	
    	return dao.selectComAnswerAuditByExampleAndPage(page, example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.audit.service.OasrService#updateByPrimaryKeySelective(com.bithealth.questionCore.audit.model.Oasr)
     */
    public int updateByPrimaryKeySelective(Oasr model) {
    	
    	return dao.updateByPrimaryKeySelective(model);
    }
}
