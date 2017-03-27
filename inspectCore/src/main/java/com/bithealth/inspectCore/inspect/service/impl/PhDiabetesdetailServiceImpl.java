 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.service.impl
 * @FileName:     PhDiabetesdetailServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午11:06:13  
 * 
 */

package com.bithealth.inspectCore.inspect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.inspect.dao.PhDiabetesdetailMapper;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetail;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetailExample;
import com.bithealth.inspectCore.inspect.service.PhDiabetesdetailService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhDiabetesdetailServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午11:06:13 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhDiabetesdetailServiceImpl extends
		GenericBaseServiceImpl<PhDiabetesdetail, PhDiabetesdetailExample, Long> implements
		PhDiabetesdetailService {

	@Autowired
	private PhDiabetesdetailMapper dao;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
	 */
	@Override
	public GenericBaseDao<PhDiabetesdetail, PhDiabetesdetailExample, Long> getDao() {
		
		return dao;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhDiabetesdetailService#insert(com.bithealth.inspectCore.inspect.model.PhDiabetesdetail, java.lang.Long)
	 */
	public int insert(PhDiabetesdetail pojo, Long masterId) {

		if(pojo != null && masterId != null){
			pojo.setDiabetesID(masterId);
			return insert(pojo);
		}
		return 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhDiabetesdetailService#updateByDiabetesID(com.bithealth.inspectCore.inspect.model.PhDiabetesdetail, java.lang.Long)
	 */
	public int updateByMasterId(PhDiabetesdetail pojo, Long masterId) {
		
		if(pojo != null){
			if(pojo.getDiabetesID() == null)
				return insert(pojo, masterId);
			else
				return updateByPrimaryKey(pojo);
		}else{
			return 0;
		}
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhDiabetesdetailService#deleteByMasterId(java.util.List)
	 */
	public int deleteByMasterId(List<Long> masterIds) {
		
		PhDiabetesdetailExample example = new PhDiabetesdetailExample();
		example.createCriteria().andDiabetesIDIn(masterIds);
		return deleteByExample(example);
	}
	
}

