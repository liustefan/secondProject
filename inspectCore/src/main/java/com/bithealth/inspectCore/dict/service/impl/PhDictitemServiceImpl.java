 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.service.impl
 * @FileName:     PhDictitemServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午11:08:04  
 * 
 */

package com.bithealth.inspectCore.dict.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.dict.dao.PhDictitemMapper;
import com.bithealth.inspectCore.dict.model.PhDictitem;
import com.bithealth.inspectCore.dict.model.PhDictitemExample;
import com.bithealth.inspectCore.dict.service.PhDictitemService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhDictitemServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午11:08:04 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhDictitemServiceImpl extends
		GenericBaseServiceImpl<PhDictitem, PhDictitemExample, Integer> implements
		PhDictitemService {

	@Autowired
	private PhDictitemMapper dao;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
	 */
	@Override
	public GenericBaseDao<PhDictitem, PhDictitemExample, Integer> getDao() {
		
		return dao;
	}

}

