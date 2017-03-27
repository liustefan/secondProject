 
/**
 * @PackageName:      com.bithealth.inspectCore.physical.service.impl
 * @FileName:     PhHealthexamdetailinpatientServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午10:53:57  
 * 
 */

package com.bithealth.inspectCore.physical.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.physical.dao.PhHealthexamdetailinpatientMapper;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailinpatient;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailinpatientExample;
import com.bithealth.inspectCore.physical.service.PhHealthexamdetailinpatientService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhHealthexamdetailinpatientServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午10:53:57 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhHealthexamdetailinpatientServiceImpl extends
		GenericBaseServiceImpl<PhHealthexamdetailinpatient, PhHealthexamdetailinpatientExample, Long> implements
		PhHealthexamdetailinpatientService {

	@Autowired
	private PhHealthexamdetailinpatientMapper dao;
	/** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
     */
	@Override
	public GenericBaseDao<PhHealthexamdetailinpatient, PhHealthexamdetailinpatientExample, Long> getDao() {
		
		return dao;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailinpatientService#inserts(java.util.List)
	 */
	public int inserts(List<PhHealthexamdetailinpatient> pojos, Long masterId) {
		int n = 0;
		if(pojos != null){
			for(Iterator<PhHealthexamdetailinpatient> it = pojos.iterator(); it.hasNext();){
				PhHealthexamdetailinpatient pojo = it.next();
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
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailinpatientService#selectByHExamID(java.lang.Long)
	 */
	public List<PhHealthexamdetailinpatient> selectByMasterId(Long masterId) {
		PhHealthexamdetailinpatientExample example = new PhHealthexamdetailinpatientExample();
		example.createCriteria().andHExamIDEqualTo(masterId);
		return selectByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailinpatientService#deleteByMasterId(java.util.List)
	 */
	public int deleteByMasterId(List<Long> masterIds) {
		PhHealthexamdetailinpatientExample example = new PhHealthexamdetailinpatientExample();
		example.createCriteria().andHExamIDIn(masterIds);
		return deleteByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailinpatientService#updateByMasterId(java.util.List, java.lang.Long)
	 */
	public int updateByMasterId(List<PhHealthexamdetailinpatient> pojos,
			Long masterId) {
		
		int n = 0;
		if(pojos != null){
			List<Long> ids = new ArrayList<Long>();
			for(Iterator<PhHealthexamdetailinpatient> it = pojos.iterator(); it.hasNext();){
				PhHealthexamdetailinpatient pojo = it.next();
				if(pojo.getStartDate() != null){
					pojo.setHExamID(masterId);
					if(pojo.getLogID() == null)
						n += insert(pojo);
					else
						n += updateByPrimaryKey(pojo);

						ids.add(pojo.getLogID());
				}
			}
			PhHealthexamdetailinpatientExample example = new PhHealthexamdetailinpatientExample();
			example.createCriteria().andHExamIDEqualTo(masterId).andLogIDNotIn(ids);
			n += deleteByExample(example);
		}
		return n;
	}
}

