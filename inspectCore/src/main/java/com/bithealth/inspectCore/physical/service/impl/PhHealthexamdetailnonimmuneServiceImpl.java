 
/**
 * @PackageName:      com.bithealth.inspectCore.physical.service.impl
 * @FileName:     PhHealthexamdetailnonimmuneServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午10:57:59  
 * 
 */

package com.bithealth.inspectCore.physical.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.physical.dao.PhHealthexamdetailnonimmuneMapper;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailnonimmune;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailnonimmuneExample;
import com.bithealth.inspectCore.physical.service.PhHealthexamdetailnonimmuneService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhHealthexamdetailnonimmuneServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午10:57:59 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhHealthexamdetailnonimmuneServiceImpl extends
		GenericBaseServiceImpl<PhHealthexamdetailnonimmune, PhHealthexamdetailnonimmuneExample, Long> implements
		PhHealthexamdetailnonimmuneService {

	@Autowired
	private PhHealthexamdetailnonimmuneMapper dao;
	/** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
     */
	@Override
	public GenericBaseDao<PhHealthexamdetailnonimmune, PhHealthexamdetailnonimmuneExample, Long> getDao() {
		
		return dao;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailnonimmuneService#inserts(java.util.List)
	 */
	public int inserts(List<PhHealthexamdetailnonimmune> pojos, Long masterId) {
		int n = 0;
		if(pojos != null){
			for(Iterator<PhHealthexamdetailnonimmune> it = pojos.iterator(); it.hasNext();){
				PhHealthexamdetailnonimmune pojo = it.next();
				pojo.setHExamID(masterId);
				n += insert(pojo);
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
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailnonimmuneService#selectByHExamID(java.lang.Long)
	 */
	public List<PhHealthexamdetailnonimmune> selectByMasterId(Long masterId) {
		PhHealthexamdetailnonimmuneExample example = new PhHealthexamdetailnonimmuneExample();
		example.createCriteria().andHExamIDEqualTo(masterId);
		return selectByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailnonimmuneService#deleteByMasterId(java.util.List)
	 */
	public int deleteByMasterId(List<Long> masterIds) {
		PhHealthexamdetailnonimmuneExample example = new PhHealthexamdetailnonimmuneExample();
		example.createCriteria().andHExamIDIn(masterIds);
		return deleteByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailnonimmuneService#updateByMasterId(java.util.List, java.lang.Long)
	 */
	public int updateByMasterId(List<PhHealthexamdetailnonimmune> pojos,
			Long masterId) {
		
		int n = 0;
		if(pojos != null){
			List<Long> ids = new ArrayList<Long>();
			for(Iterator<PhHealthexamdetailnonimmune> it = pojos.iterator(); it.hasNext();){
				PhHealthexamdetailnonimmune pojo = it.next();
				if(StringUtils.isNotEmpty(pojo.getVaccinateName())){
					pojo.setHExamID(masterId);
					if(pojo.getLogID() == null)
						n += insert(pojo);
					else
						n += updateByPrimaryKey(pojo);
						
						ids.add(pojo.getLogID());
				}
			}
			PhHealthexamdetailnonimmuneExample example = new PhHealthexamdetailnonimmuneExample();
			example.createCriteria().andHExamIDEqualTo(masterId).andLogIDNotIn(ids);
			n += deleteByExample(example);
		}
		return n;
	}
}

