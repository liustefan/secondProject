 
/**
 * @PackageName:      com.bithealth.measureCore.electrocardio.service
 * @FileName:     ElectrocardioExcService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月15日 上午9:53:08  
 * 
 */

package com.bithealth.measureCore.electrocardio.service;

import java.util.List;

import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExc;


/**
 * 类名称: ElectrocardioExcService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月15日 上午9:53:08 
 * 
 * @author 陈哲
 * @version  
 */
public interface ElectrocardioExcService {
	List<OecgExc> doElectrocardioExcInfo(List<Ecg1> ecg1s, List<Ecg2> ecg2s, Oecg oecg);
	
	Integer deleteExcElectrocardio(Long docentry);
	
	int getElectrocardioExcTimeP(String objectId, Oecg oecg);

}

