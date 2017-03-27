 
/**
 * @PackageName:      com.bithealth.inspectCore.physical.service.impl
 * @FileName:     PhHealthexamdetailmedicineServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午10:55:33  
 * 
 */

package com.bithealth.inspectCore.physical.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.physical.dao.PhHealthexamdetailmedicineMapper;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailmedicine;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailmedicineExample;
import com.bithealth.inspectCore.physical.service.PhHealthexamdetailmedicineService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhHealthexamdetailmedicineServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午10:55:33 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhHealthexamdetailmedicineServiceImpl extends
		GenericBaseServiceImpl<PhHealthexamdetailmedicine, PhHealthexamdetailmedicineExample, Long> implements
		PhHealthexamdetailmedicineService {

	@Autowired
	private PhHealthexamdetailmedicineMapper dao;
	/** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
     */
	@Override
	public GenericBaseDao<PhHealthexamdetailmedicine, PhHealthexamdetailmedicineExample, Long> getDao() {
		
		return dao;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailmedicineService#inserts(java.util.List)
	 */
	public int inserts(List<PhHealthexamdetailmedicine> pojos, Long masterId) {
		int n = 0;
		if(pojos != null){
			for(Iterator<PhHealthexamdetailmedicine> it = pojos.iterator(); it.hasNext();){
				PhHealthexamdetailmedicine pojo = it.next();
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
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailmedicineService#selectByHExamID(java.lang.Long)
	 */
	public List<PhHealthexamdetailmedicine> selectByMasterId(Long masterId) {
		PhHealthexamdetailmedicineExample example = new PhHealthexamdetailmedicineExample();
		example.createCriteria().andHExamIDEqualTo(masterId);
		return selectByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailmedicineService#deleteByMasterId(java.util.List)
	 */
	public int deleteByMasterId(List<Long> masterIds) {
		PhHealthexamdetailmedicineExample example = new PhHealthexamdetailmedicineExample();
		example.createCriteria().andHExamIDIn(masterIds);
		return deleteByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailmedicineService#updateByMasterId(java.util.List, java.lang.Long)
	 */
	public int updateByMasterId(List<PhHealthexamdetailmedicine> pojos,
			Long masterId) {
		
		int n = 0;
		if(pojos != null){
			List<Long> ids = new ArrayList<Long>();
			for(Iterator<PhHealthexamdetailmedicine> it = pojos.iterator(); it.hasNext();){
				PhHealthexamdetailmedicine pojo = it.next();
				if(StringUtils.isNotEmpty(pojo.getDrugName())){
					pojo.setHExamID(masterId);
					if(pojo.getLogID() == null)
						n += insert(pojo);
					else
						n += updateByPrimaryKey(pojo);
					
					ids.add(pojo.getLogID());
				}
			}
			PhHealthexamdetailmedicineExample example = new PhHealthexamdetailmedicineExample();
			example.createCriteria().andHExamIDEqualTo(masterId).andLogIDNotIn(ids);
			n += deleteByExample(example);
		}
		return n;
	}
}

