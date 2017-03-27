package com.bithealth.measureCore.electrocardio.service.impl;

 
 
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bithealth.measureCore.electrocardio.dao.Ecg3Mapper;
import com.bithealth.measureCore.electrocardio.model.Ecg3;
import com.bithealth.measureCore.electrocardio.model.Ecg3Example;
import com.bithealth.measureCore.electrocardio.model.Ecg3Example.Criteria;
import com.bithealth.measureCore.electrocardio.service.Ecg3Service;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;
  

@Service
public class Ecg3ServiceImpl extends GenericBaseServiceImpl<Ecg3,Ecg3Example,String>    
		implements Ecg3Service {
     
    @Resource 
    Ecg3Mapper ecg3Mapper;
    
    @Override
    public GenericBaseDao<Ecg3,Ecg3Example,  String > getDao() {
        return ecg3Mapper;
    }

	/** 
	     * @Title: send 
	     * @Description: TODO 简单描述该方法的实现功能（可选）.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.Ecg3Service#selectEcg3ListByDocentry(java.lang.Long)
	     */
	public List<Ecg3> selectEcg3ListByDocentry(Long docentry) {
		Ecg3Example example = new Ecg3Example();
		Criteria criteria = example.createCriteria();
		criteria.andDocentryEqualTo(docentry);
		
		return ecg3Mapper.selectByExample(example);
	}
	
	
	/**
	 * @Title:deleteEcg3ByDocentry 
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 陈哲
	 * @param docentry 
	 * @throws
	 * @retrun void
	 */
	public void deleteEcg3ByDocentry(Long docentry) {
		Ecg3Example example = new Ecg3Example();
		Criteria criteria = example.createCriteria();
		criteria.andDocentryEqualTo(docentry);
		
		ecg3Mapper.deleteByExample(example);
	}
	
	public void insertEcg3(long docentry, String objectId, long startTime, long endTime){
		Ecg3 ecg3 = new Ecg3();
		ecg3.setDocentry(docentry);
		ecg3.setObjectid(objectId);
		ecg3.setStarttime(startTime);
		ecg3.setEndtime(endTime);
		ecg3Mapper.insertSelective(ecg3);
	}

	@Override
	public void addEcg3List(List<Ecg3> ecg3) {
		 ecg3Mapper.addEcg3List(ecg3);
	}
	
}
