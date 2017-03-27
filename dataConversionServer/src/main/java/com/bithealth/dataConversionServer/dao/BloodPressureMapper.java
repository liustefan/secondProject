package com.bithealth.dataConversionServer.dao;

import java.util.List;

import com.bithealth.dataConversionServer.bean.BloodPressure;
import com.bithealth.dataConversionServer.bean.SendDataBean;
import com.bithealth.sdk.core.generic.GenericBaseDao;



/**
 * @ClassName:     BloodPressureMapper.java 
 * @Description:   血压
 * @author         lenovo  
 * @version        V1.0   
 * @Date           2015年12月22日 下午3:19:32
*****/
public interface BloodPressureMapper extends GenericBaseDao{
    
    
	 /** 
     * @Title: findBloodPressureList 
     * @Description: 查询血压信息发送给第三方
     * @param SendDataBean
     * @return
     * @throws Exception    
     * @retrun BloodPressure
     */
    List<BloodPressure> findBloodPressureList(SendDataBean param);
    
  

}
