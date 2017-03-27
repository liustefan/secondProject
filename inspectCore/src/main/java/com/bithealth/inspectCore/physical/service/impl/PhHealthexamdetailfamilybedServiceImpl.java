 
/**
 * @PackageName:      com.bithealth.inspectCore.physical.service.impl
 * @FileName:     PhHealthexamdetailfamilybedServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午10:50:49  
 * 
 */

package com.bithealth.inspectCore.physical.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.physical.dao.PhHealthexamdetailfamilybedMapper;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailfamilybed;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailfamilybedExample;
import com.bithealth.inspectCore.physical.service.PhHealthexamdetailfamilybedService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhHealthexamdetailfamilybedServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午10:50:49 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhHealthexamdetailfamilybedServiceImpl extends
		GenericBaseServiceImpl<PhHealthexamdetailfamilybed, PhHealthexamdetailfamilybedExample, Long> implements
		PhHealthexamdetailfamilybedService {

	@Autowired
	private PhHealthexamdetailfamilybedMapper dao;
	/** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
     */
	@Override
	public GenericBaseDao<PhHealthexamdetailfamilybed, PhHealthexamdetailfamilybedExample, Long> getDao() {
		
		return dao;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailfamilybedService#inserts(java.util.List)
	 */
	public int inserts(List<PhHealthexamdetailfamilybed> pojos, Long masterId) {
		int n = 0;
		if(pojos != null){
			for(Iterator<PhHealthexamdetailfamilybed> it = pojos.iterator(); it.hasNext();){
				PhHealthexamdetailfamilybed pojo = it.next();
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
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailfamilybedService#selectByHExamID(java.lang.Long)
	 */
	public List<PhHealthexamdetailfamilybed> selectByMasterId(Long masterId) {
		
		PhHealthexamdetailfamilybedExample example = new PhHealthexamdetailfamilybedExample();
		example.createCriteria().andHExamIDEqualTo(masterId);
		return selectByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailfamilybedService#deleteByMasterId(java.util.List)
	 */
	public int deleteByMasterId(List<Long> masterIds) {
		PhHealthexamdetailfamilybedExample example = new PhHealthexamdetailfamilybedExample();
		example.createCriteria().andHExamIDIn(masterIds);
		return deleteByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailfamilybedService#updateByMasterId(java.util.List, java.lang.Long)
	 */
	public int updateByMasterId(List<PhHealthexamdetailfamilybed> pojos,
			Long masterId) {
		
		int n = 0;
		if(pojos != null){
			List<Long> ids = new ArrayList<Long>();
			for(Iterator<PhHealthexamdetailfamilybed> it = pojos.iterator(); it.hasNext();){
				PhHealthexamdetailfamilybed pojo = it.next();
				if(pojo.getStartDate() != null){
					pojo.setHExamID(masterId);
					if(pojo.getLogID() == null)
						n += insert(pojo);
					else
						n += updateByPrimaryKey(pojo);
					
					ids.add(pojo.getLogID());
				}
			}
			PhHealthexamdetailfamilybedExample example = new PhHealthexamdetailfamilybedExample();
			example.createCriteria().andHExamIDEqualTo(masterId).andLogIDNotIn(ids);
			n += deleteByExample(example);
		}
		return n;
	}
}

