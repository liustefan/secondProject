package com.bithealth.dataConversionServer.dao;

import java.util.List;

import com.bithealth.dataConversionServer.bean.BloodGlucose;
import com.bithealth.dataConversionServer.bean.SendDataBean;
import com.bithealth.sdk.core.generic.GenericBaseDao;

/**
 * @ClassName:     BloodGlucoseMapper.java 
 * @Description:   血糖
 * @author         lenovo  
 * @version        V1.0   
 * @Date           2015年12月22日 下午3:18:03
*****/
public interface BloodGlucoseMapper extends GenericBaseDao{
    

	 /** 
     * @Title: findBloodGlucoseList 
     * @Description: 查询血糖信息发送给第三方 
     * @param SendDataBean
     * @return
     * @throws Exception    
     * @retrun BloodGlucose
     */
    List<BloodGlucose> findBloodGlucoseList(SendDataBean param);
    
   

}
