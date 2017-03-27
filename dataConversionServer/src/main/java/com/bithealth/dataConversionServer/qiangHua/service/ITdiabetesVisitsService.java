package com.bithealth.dataConversionServer.qiangHua.service;

import java.util.List;

import com.bithealth.dataConversionServer.qiangHua.bean.TdiabetesVisits;
import com.bithealth.sdk.core.generic.GenericBaseService;




/**
 * @ClassName:     ITdiabetesVisitsService.java 
  * @Description:   TODO
  * @author         zengxuhua  
 * @version        V1.0   
  * @Date           2016年2月29日 下午2:54:06
 *****/
public interface ITdiabetesVisitsService extends GenericBaseService{

    List<TdiabetesVisits> select(int num);
    
    long selectByCount();
    
    void update(TdiabetesVisits tdiabetesVisits);
    
  
}
