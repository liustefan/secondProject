package com.bithealth.measureCore.electrocardio.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.measureCore.electrocardio.dao.Ecg2Mapper;
import com.bithealth.measureCore.electrocardio.dao.MultiEcg2Mapper;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Ecg2Example;
import com.bithealth.measureCore.electrocardio.model.Ecg2Example.Criteria;
import com.bithealth.measureCore.electrocardio.model.Ecg2Key;
import com.bithealth.measureCore.electrocardio.service.Ecg2Service;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;
  
/**
 * 
 * 类名称: Ecg2ServiceImpl  
 * 功能描述: 异常心电统计接口实现
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月12日 上午10:22:37 
 * 
 * @author 陈哲
 * @version
 */
@Service 
public class Ecg2ServiceImpl extends GenericBaseServiceImpl<Ecg2,Ecg2Example,Ecg2Key>    
		implements Ecg2Service {
     
    @Resource 
    Ecg2Mapper ecg2Mapper;
    
    @Autowired
    MultiEcg2Mapper multiEcg2Mapper;
    
    @Override
    public GenericBaseDao<Ecg2,Ecg2Example,  Ecg2Key > getDao() {
        return ecg2Mapper;
    }

	/** 
	     * @Title: send 
	     * @Description: TODO 简单描述该方法的实现功能（可选）.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.Ecg2Service#selectEcg2ListByDocentry(java.lang.Long)
	     */
	public List<Ecg2> selectEcg2ListByDocentry(Long docentry) {
		Ecg2Example example = new Ecg2Example();
		Criteria criteria = example.createCriteria();
		criteria.andDocentryEqualTo(docentry);
		
		return ecg2Mapper.selectByExample(example);
	}
	
	public void deleteEcg2ByDocentryAndAbnname(Long docentry, String abnName){
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("docentry", docentry);
		param.put("abnName", abnName);
		param.put("tableNum", docentry%100);
		
		multiEcg2Mapper.deleteEcg2ByDocentryAndAbnname(param);
	}
	
	public void deleteEcg2ByDocentry(Long docentry){
		Ecg2Example example = new Ecg2Example();
		Criteria criteria = example.createCriteria();
		criteria.andDocentryEqualTo(docentry);
		
		ecg2Mapper.deleteByExample(example);
	}
	
	public void updateEcg2ByDocentryAndAbnname(Long docentry, String abnName, int abnNum){
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("docentry", docentry);
		param.put("abnName", abnName);
		param.put("abnNum", abnNum);
		param.put("tableNum", docentry%100);
		
		multiEcg2Mapper.updateEcg2ByDocentryAndAbnname(param);
	}
	
	public void insertEcg2(long docentry, String abnName, int abnNum){
		Ecg2 ecg2 = new Ecg2();
		ecg2.setDocentry(docentry);
		ecg2.setAbnname(abnName);
		ecg2.setAbnnum(abnNum);
		
		multiEcg2Mapper.insertSubEcg2(ecg2);
	}

	@Override
	public void addEcg2List(List<Ecg2> ecg2) {
		 ecg2Mapper.addEcg2List(ecg2);
	}

}
