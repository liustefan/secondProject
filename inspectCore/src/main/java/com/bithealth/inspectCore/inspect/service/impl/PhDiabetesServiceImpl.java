 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.service.impl
 * @FileName:     PhDiabetesServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午11:04:04  
 * 
 */

package com.bithealth.inspectCore.inspect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.inspect.dao.PhDiabetesMapper;
import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesExample;
import com.bithealth.inspectCore.inspect.service.PhDiabetesService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhDiabetesServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午11:04:04 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhDiabetesServiceImpl extends GenericBaseServiceImpl<PhDiabetes, PhDiabetesExample, Long> implements PhDiabetesService {

	@Autowired
	private PhDiabetesMapper dao;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
	 */
	@Override
	public GenericBaseDao<PhDiabetes, PhDiabetesExample, Long> getDao() {
		
		return dao;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhDiabetesService#deleteByMasterId(java.util.List)
	 */
	public int deleteByMasterId(List<Long> ids) {
		
		PhDiabetesExample example = new PhDiabetesExample();
		example.createCriteria().andDiabetesIDIn(ids);
		return deleteByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhDiabetesService#selectStayPhDiabetesByMemberId(java.lang.Integer)
	 */
	public List<PhDiabetes> selectStayPhDiabetesByMemberId(Integer memberId) {
		
		PhDiabetesExample example = new PhDiabetesExample();
		example.createCriteria().andMemberIDEqualTo(memberId).andVisitClassEqualTo((byte)0);
		return selectByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhDiabetesService#selectLatestPhDiabetesByMemberId(java.lang.Integer)
	 */
	public PhDiabetes selectLatestPhDiabetesByMemberId(Integer memberId) {
		
		return dao.selectLatestPhDiabetesByMemberId(memberId);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhDiabetesService#selectPhDiabetesList(com.bithealth.inspectCore.inspect.model.PhDiabetes)
	 */
	public List<PhDiabetes> selectPhDiabetesList(PhDiabetes pojo) {
		
		return dao.selectPhDiabetesList(pojo);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhDiabetesService#selectPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.inspect.model.PhDiabetes, java.util.List)
	 */
	public Page<PhDiabetes> selectPage(Page<PhDiabetes> page, PhDiabetes model,
			List<Integer> odgpIds) {
		
		dao.selectPage(page, model, odgpIds);
		return page;
	}
}

