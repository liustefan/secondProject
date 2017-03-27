package com.bithealth.measureCore.electrocardio.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bithealth.measureCore.electrocardio.dao.Ecg1Mapper;
import com.bithealth.measureCore.electrocardio.dao.MultiEcg1Mapper;
import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg1Example;
import com.bithealth.measureCore.electrocardio.model.Ecg1Example.Criteria;
import com.bithealth.measureCore.electrocardio.model.Ecg1Key;
import com.bithealth.measureCore.electrocardio.service.Ecg1Service;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;
  
/**
 * 
 * 类名称: Ecg1ServiceImpl  
 * 功能描述: 异常心电详情接口实现 
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月12日 上午10:21:39 
 * 
 * @author 陈哲
 * @version
 */
@Service
public class Ecg1ServiceImpl extends GenericBaseServiceImpl<Ecg1,Ecg1Example,Ecg1Key>   
		implements Ecg1Service {
     
    @Resource 
    Ecg1Mapper ecg1Mapper;
    
    @Resource
    MultiEcg1Mapper multiEcg1Mapper;
    
    @Override
    public GenericBaseDao<Ecg1,Ecg1Example,  Ecg1Key > getDao() {
        return ecg1Mapper;
    }

	/** 
	     * @Title: send 
	     * @Description: TODO 简单描述该方法的实现功能（可选）.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.Ecg1Service#selectElectrocardioExcListByDocentry(java.lang.Long)
	     */
	public List<Ecg1> selectEcg1ListByDocentry(Long docentry) {
		Ecg1Example example = new Ecg1Example();
		Criteria criteria = example.createCriteria();
		criteria.andDocentryEqualTo(docentry);
		
		return ecg1Mapper.selectByExample(example);
	}
	
	/**
	     * @Title: send 
	     * @Description: TODO 简单描述该方法的实现功能（可选）.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.Ecg1Service#selectEcg1ByObjectid(java.lang.String)
	 */
	public Ecg1 selectEcg1ByObjectid(String objectid) {
		Ecg1Example example = new Ecg1Example();
		Criteria criteria = example.createCriteria();
		criteria.andObjectidEqualTo(objectid);
		List<Ecg1> list = ecg1Mapper.selectByExample(example);
		
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * @Title:deleteEcg1ByObjectid 
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 陈哲
	 * @param objectid
	 * @return 
	 * @throws
	 * @retrun int
	 */
	public int deleteEcg1ByObjectid(String objectid){
		Ecg1Example example = new Ecg1Example();
		Criteria criteria = example.createCriteria();
		criteria.andObjectidEqualTo(objectid);
		
		int result = ecg1Mapper.deleteByExample(example);
		
		return result;
	}
	
	public void deleteEcg1Bydocentry(Long docentry){
		Ecg1Example example = new Ecg1Example();
		Criteria criteria = example.createCriteria();
		criteria.andDocentryEqualTo(docentry);
		ecg1Mapper.deleteByExample(example);
	}
	
	public void updateEcg1ByDocentryAndObjectid(Long docentry, int lineNum, String objectId){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("lineNum", lineNum);
		param.put("docentry", docentry);
		param.put("objectId", objectId);
		param.put("tableNum", docentry%100);
		
		multiEcg1Mapper.updateEcg1BydocentryAndObjectid(param);
	}
	
	public int insertEcg1(long docentry, int lineNum, String objectid, String abEcgType, int abEcgTime){
		Ecg1 ecg1 = new Ecg1();
		ecg1.setDocentry(docentry);
		ecg1.setLinenum((short)lineNum);
		ecg1.setObjectid(objectid);
		ecg1.setAbecgtype(abEcgType);
		ecg1.setAbecgtime(abEcgTime);
		
		return multiEcg1Mapper.insertSubEcg1(ecg1);
		
	}

	@Override
	public void addEcg1List(List<Ecg1> ecg1) {
		 ecg1Mapper.addEcg1List(ecg1);
	}
  
}
