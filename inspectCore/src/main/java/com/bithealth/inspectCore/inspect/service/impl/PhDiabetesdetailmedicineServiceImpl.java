 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.service.impl
 * @FileName:     PhDiabetesdetailmedicineServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午11:07:21  
 * 
 */

package com.bithealth.inspectCore.inspect.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.inspect.dao.PhDiabetesdetailmedicineMapper;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetailmedicine;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetailmedicineExample;
import com.bithealth.inspectCore.inspect.service.PhDiabetesdetailmedicineService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhDiabetesdetailmedicineServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午11:07:21 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhDiabetesdetailmedicineServiceImpl extends
		GenericBaseServiceImpl<PhDiabetesdetailmedicine, PhDiabetesdetailmedicineExample, Long> implements
		PhDiabetesdetailmedicineService {

	@Autowired
	private PhDiabetesdetailmedicineMapper dao;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
	 */
	@Override
	public GenericBaseDao<PhDiabetesdetailmedicine, PhDiabetesdetailmedicineExample, Long> getDao() {
		
		return dao;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhDiabetesdetailmedicineService#inserts(java.util.List, java.lang.Long)
	 */
	public int inserts(List<PhDiabetesdetailmedicine> pojos, Long masterId) {
		int n = 0;
		if(pojos != null){
			for(Iterator<PhDiabetesdetailmedicine> it = pojos.iterator(); it.hasNext();){
				PhDiabetesdetailmedicine pojo = it.next();
				pojo.setLogID(null);
				pojo.setDiabetesID(masterId);
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
	 *  @see com.bithealth.inspectCore.inspect.service.PhDiabetesdetailmedicineService#updateByMasterId(java.util.List, java.lang.Long)
	 */
	public int updateByMasterId(List<PhDiabetesdetailmedicine> pojos,
			Long masterId) {
		
		int n = 0;
		if(pojos != null){
			List<Long> ids = new ArrayList<Long>();
			for(Iterator<PhDiabetesdetailmedicine> it = pojos.iterator(); it.hasNext();){
				PhDiabetesdetailmedicine pojo = it.next();
				if(StringUtils.isNotEmpty(pojo.getDrugName())){
					pojo.setDiabetesID(masterId);
					if(pojo.getLogID() == null)
						n += insert(pojo);
					else
						n += updateByPrimaryKey(pojo);
					
					ids.add(pojo.getLogID());
				}
			}
			PhDiabetesdetailmedicineExample example = new PhDiabetesdetailmedicineExample();
			example.createCriteria().andDiabetesIDEqualTo(masterId).andLogIDNotIn(ids);
			n += deleteByExample(example);
		}
		return n;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhDiabetesdetailmedicineService#deleteByMasterID(java.util.List)
	 */
	public int deleteByMasterId(List<Long> masterIds) {
		
		PhDiabetesdetailmedicineExample example = new PhDiabetesdetailmedicineExample();
		example.createCriteria().andDiabetesIDIn(masterIds);
		return deleteByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhDiabetesdetailmedicineService#selectByMasterId(java.lang.Long)
	 */
	public List<PhDiabetesdetailmedicine> selectByMasterId(Long masterId) {
		
		PhDiabetesdetailmedicineExample example = new PhDiabetesdetailmedicineExample();
		example.createCriteria().andDiabetesIDEqualTo(masterId);
		return selectByExample(example);
	}
}

