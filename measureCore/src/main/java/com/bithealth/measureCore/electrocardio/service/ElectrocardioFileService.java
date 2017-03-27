 
/**
 * @PackageName:      com.bithealth.measureCore.electrocardio.service
 * @FileName:     ElectrocardioFileService.java  
 * @Description: 心电文件处理接口  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月18日 下午5:32:41  
 * 
 */

package com.bithealth.measureCore.electrocardio.service;

import java.io.InputStream;
import java.util.Map;

import com.bithealth.measureCore.common.model.ImageParam;
import com.bithealth.measureCore.electrocardio.model.Oecg;



/**
 * 类名称: ElectrocardioFileService  
 * 功能描述: 心电文件处理接口  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月18日 下午5:32:41 
 * 
 * @author 陈哲
 * @version  
 */
public interface ElectrocardioFileService {
	public Map<String, Object> getElectrocardioChartFileData(ImageParam param);
	
	public Map<String, Object> getInstantHeartRateChartFileData(ImageParam param);
	
	public Map<String, Object> getExcElectrocardioChartFileData(ImageParam param);
	
	public int getElectrocardioPageByParam(ImageParam param);
	
	public int getInstantHeartRatePageByParam(ImageParam param);
	
	public byte[] getFile(boolean isCompress, String uniqueId) throws Exception;
	
	public void saveElectrocardioFile(InputStream in, Oecg oecg) throws Exception;
	
	public String getMqOecgMessage(Oecg oecg)throws Exception;
	
	public Map<String, Object> getElectrocardioChartFileDataApp(ImageParam param); 
	

}

