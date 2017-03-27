 
/**
 * @PackageName:      com.bithealth.measureCore.bloodSugar.service
 * @FileName:     BloodSugarUploadService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年8月8日 下午2:48:34  
 * 
 */

package com.bithealth.measureCore.bloodSugar.service;

import com.bithealth.measureCore.bloodSugar.model.Obsr;


/**
 * 类名称: BloodSugarUploadService  
 * 功能描述: 上传血糖接口定义
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月8日 下午2:48:34 
 * 
 * @author 陈哲
 * @version  
 */
public interface BloodSugarUploadService {
	void saveBloodSugar(Obsr obsr) throws Exception;
}

