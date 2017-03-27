 
/**
 * @PackageName:      com.bithealth.measureCore.bloodPressure.service
 * @FileName:     BloodPressureFileService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年8月8日 上午11:35:41  
 * 
 */

package com.bithealth.measureCore.bloodPressure.service;

import com.bithealth.measureCore.bloodPressure.model.Osbp;


/**
 * 类名称: BloodPressureFileService  
 * 功能描述: 上传血压接口定义
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月8日 上午11:35:41 
 * 
 * @author 陈哲
 * @version  
 */
public interface BloodPressureUploadService {
	void saveBloodPress(Osbp osbp) throws Exception;
}

