package com.bithealth.dataConversionServer.qiangHua.service;

import com.bithealth.dataConversionServer.qiangHua.bean.TdiabetesVisits;
import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.sdk.core.generic.GenericBaseService;



/**
 * @ClassName:     IPhDiabetesService.java 
  * @Description:   TODO
  * @author         Administrator  
 * @version        V1.0   
  * @Date           2016年3月18日 下午1:46:54
 *****/
public interface IPhDiabetesService extends GenericBaseService{

    int insertSelective(PhDiabetes record);
    
    boolean saveAll(TdiabetesVisits tdiabetesVisits);
    
}
