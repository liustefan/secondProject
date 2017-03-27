 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.service.impl
 * @FileName:     PhHypertensionServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午11:09:21  
 * 
 */

package com.bithealth.inspectCore.inspect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.inspect.dao.PhHypertensionMapper;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensionExample;
import com.bithealth.inspectCore.inspect.service.PhHypertensionService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhHypertensionServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午11:09:21 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhHypertensionServiceImpl extends
		GenericBaseServiceImpl<PhHypertension, PhHypertensionExample, Long> implements
		PhHypertensionService {

	@Autowired
	private PhHypertensionMapper dao;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
	 */
	@Override
	public GenericBaseDao<PhHypertension, PhHypertensionExample, Long> getDao() {
		
		return dao;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhHypertensionService#deleteByMasterId(java.util.List)
	 */
	public int deleteByMasterId(List<Long> masterIds) {
		
		PhHypertensionExample example = new PhHypertensionExample();
		example.createCriteria().andHypertensionIDIn(masterIds);
		return deleteByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhHypertensionService#selectStayPhDiabetesByMemberId(java.lang.Integer)
	 */
	public List<PhHypertension> selectStayPhDiabetesByMemberId(Integer memberId) {
		
		PhHypertensionExample example = new PhHypertensionExample();
		example.createCriteria().andMemberIDEqualTo(memberId).andVisitClassEqualTo((byte)0);
		return selectByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhHypertensionService#selectLatestPhHypertensionByMemberId(java.lang.Integer)
	 */
	public PhHypertension selectLatestPhHypertensionByMemberId(Integer memberId) {
		
		return dao.selectLatestPhHypertensionByMemberId(memberId);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhHypertensionService#selectPhHypertensionList(com.bithealth.inspectCore.inspect.model.PhHypertension)
	 */
	public List<PhHypertension> selectPhHypertensionList(PhHypertension pojo) {
		
		return dao.selectPhHypertensionList(pojo);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhHypertensionService#selectPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.inspect.model.PhHypertension, java.util.List)
	 */
	public Page<PhHypertension> selectPage(Page<PhHypertension> page,
			PhHypertension model, List<Integer> odgpIds) {
		
		dao.selectPage(page, model, odgpIds);
		return page;
	}
}

