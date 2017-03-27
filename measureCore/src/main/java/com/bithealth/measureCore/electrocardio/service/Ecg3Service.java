package com.bithealth.measureCore.electrocardio.service;

  
import java.util.List;

import com.bithealth.measureCore.electrocardio.model.Ecg3;
import com.bithealth.measureCore.electrocardio.model.Ecg3Example;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 角色 业务接口
 * 
 * @author JasonChai
 * @since 2014年6月10日 下午4:15:01
 **/
 
public interface Ecg3Service extends GenericBaseService<Ecg3,Ecg3Example,String> {
	List<Ecg3> selectEcg3ListByDocentry(Long docentry);
	
	void deleteEcg3ByDocentry(Long docentry);
	
	void insertEcg3(long docentry, String objectId, long startTime, long endTime);
	
	void addEcg3List(List<Ecg3> ecg3);
    
}



