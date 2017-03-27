package com.bithealth.measureCore.electrocardio.service;

  
import java.util.List;

import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg1Example;
import com.bithealth.measureCore.electrocardio.model.Ecg1Key;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 
 * 类名称: Ecg1Service  
 * 功能描述: 异常心电详情接口  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月12日 上午10:20:26 
 * 
 * @author 陈哲
 * @version
 */
public interface Ecg1Service extends GenericBaseService<Ecg1,Ecg1Example,Ecg1Key > {
	List<Ecg1> selectEcg1ListByDocentry(Long docentry);
	
	Ecg1 selectEcg1ByObjectid(String objectid);
	
	int deleteEcg1ByObjectid(String objectid);
	
	void updateEcg1ByDocentryAndObjectid(Long docentry, int lineNum, String objectId);
	
	int insertEcg1(long docentry, int lineNum, String objectid, String abEcgType, int abEcgTime);
	
	void deleteEcg1Bydocentry(Long docentry);
	
	void addEcg1List(List<Ecg1> ecg1);
    
}



