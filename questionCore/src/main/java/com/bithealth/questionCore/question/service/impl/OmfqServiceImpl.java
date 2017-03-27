package com.bithealth.questionCore.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.questionCore.question.dao.OmfqMapper;
import com.bithealth.questionCore.question.model.Omfq;
import com.bithealth.questionCore.question.model.OmfqExample;
import com.bithealth.questionCore.question.service.OmfqService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class OmfqServiceImpl extends GenericBaseServiceImpl<Omfq,OmfqExample,
      Integer> implements OmfqService {
          
    @Autowired
	private OmfqMapper dao;
        
    @Override
    public GenericBaseDao<Omfq, OmfqExample,  Integer> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.OmfqService#deleteByMasterId(java.util.List)
     */
    public int deleteByMasterId(List<Integer> ids) {
    	
    	OmfqExample example = new OmfqExample();
		example.createCriteria().andQustidIn(ids);
		return deleteByExample(example);
    }
    
    /**
     * 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.OmfqService#selectSingleQuestionMaxQustCode(java.lang.Integer, java.lang.String)
     */
    public String selectSingleQuestionMaxQustCode(Integer orgId, String excTag) {
    	
    	String maxCode = dao.selectSingleQuestionMaxQustCode(orgId, excTag);
    	return maxCode == null ? "1000" : maxCode;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.OmfqService#selectSingleQuestionMaxQustVerByName(java.lang.Integer, java.lang.String, java.lang.String)
     */
    public String selectSingleQuestionMaxQustVerByName(Integer orgId,
    		String name, String excTag) {
    	
    	String maxVer = dao.selectSingleQuestionMaxQustVerByName(orgId, name, excTag);
    	return maxVer == null ? "1" : maxVer;
    }
}
