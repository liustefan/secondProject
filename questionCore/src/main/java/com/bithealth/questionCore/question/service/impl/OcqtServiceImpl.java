package com.bithealth.questionCore.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.questionCore.question.dao.OcqtMapper;
import com.bithealth.questionCore.question.model.Ocqt;
import com.bithealth.questionCore.question.model.OcqtExample;
import com.bithealth.questionCore.question.service.OcqtService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class OcqtServiceImpl extends GenericBaseServiceImpl<Ocqt,OcqtExample,
      Integer> implements OcqtService {
          
    @Autowired
	private OcqtMapper dao;
        
    @Override
    public GenericBaseDao<Ocqt, OcqtExample,  Integer> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.OcqtService#deleteByMasterId(java.util.List)
     */
    public int deleteByMasterId(List<Integer> values) {
    	
    	OcqtExample example = new OcqtExample();
		example.createCriteria().andCombQustidIn(values);
		return deleteByExample(example);
    }
    
    /**
     * 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.OcqtService#selectComQuestionMaxQustCode(java.lang.Integer, java.lang.String)
     */
    public Integer selectComQuestionMaxQustCode(Integer orgId, String excTag) {
    	
    	Integer maxCode = dao.selectComQuestionMaxQustCode(orgId, excTag);
    	return maxCode == null ? 1000 : maxCode;
    }
    
    /**
     * 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.questionCore.question.service.OcqtService#selectComQuestionMaxQustVerByName(java.lang.Integer, java.lang.String, java.lang.String)
     */
    public String selectComQuestionMaxQustVerByName(Integer orgId,
    		String name, String excTag) {
    	
    	String maxVer = dao.selectComQuestionMaxQustVerByName(orgId, name, excTag);
    	return maxVer == null ? "1" : maxVer;
    }
}
