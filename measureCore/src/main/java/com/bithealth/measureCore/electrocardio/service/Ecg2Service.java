package com.bithealth.measureCore.electrocardio.service;

  
import java.util.List;

import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Ecg2Example;
import com.bithealth.measureCore.electrocardio.model.Ecg2Key;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 
 * 类名称: Ecg2Service  
 * 功能描述: 异常心电统计接口  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月12日 上午10:21:01 
 * 
 * @author 陈哲
 * @version
 */
 
public interface Ecg2Service extends GenericBaseService<Ecg2,Ecg2Example,Ecg2Key> {
	List<Ecg2> selectEcg2ListByDocentry(Long docentry);
	
	void deleteEcg2ByDocentryAndAbnname(Long docentry, String abnName);
	
	void updateEcg2ByDocentryAndAbnname(Long docentry, String abnName, int abnNum);
	
	void insertEcg2(long docentry, String abnName, int abnNum);
	
	void deleteEcg2ByDocentry(Long docentry);
	
	void addEcg2List(List<Ecg2> ecg2);
    
}



