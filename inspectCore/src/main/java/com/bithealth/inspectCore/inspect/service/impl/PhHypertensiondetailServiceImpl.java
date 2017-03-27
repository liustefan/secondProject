 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.service.impl
 * @FileName:     PhHypertensiondetailServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午11:09:59  
 * 
 */

package com.bithealth.inspectCore.inspect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.inspect.dao.PhHypertensiondetailMapper;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetail;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailExample;
import com.bithealth.inspectCore.inspect.service.PhHypertensiondetailService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhHypertensiondetailServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午11:09:59 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhHypertensiondetailServiceImpl extends
		GenericBaseServiceImpl<PhHypertensiondetail, PhHypertensiondetailExample, Long> implements
		PhHypertensiondetailService {

	@Autowired
	private PhHypertensiondetailMapper dao;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
	 */
	@Override
	public GenericBaseDao<PhHypertensiondetail, PhHypertensiondetailExample, Long> getDao() {
		
		return dao;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhHypertensiondetailService#deleteByMasterId(java.util.List)
	 */
	public int deleteByMasterId(List<Long> masterIds) {
		
		PhHypertensiondetailExample example = new PhHypertensiondetailExample();
		example.createCriteria().andHypertensionIDIn(masterIds);
		return deleteByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhHypertensiondetailService#insert(com.bithealth.inspectCore.inspect.model.PhHypertensiondetail, java.lang.Long)
	 */
	public int insert(PhHypertensiondetail pojo, Long masterId) {
		
		if(pojo != null && masterId != null){
			pojo.setHypertensionID(masterId);
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
	 *  @see com.bithealth.inspectCore.inspect.service.PhHypertensiondetailService#updateByMasterId(com.bithealth.inspectCore.inspect.model.PhHypertensiondetail, java.lang.Long)
	 */
	public int updateByMasterId(PhHypertensiondetail pojo, Long masterId) {
		
		if(pojo != null){
			if(pojo.getHypertensionID() == null)
				return insert(pojo, masterId);
			else
				return updateByPrimaryKey(pojo);
		}else{
			return 0;
		}
	}
}

