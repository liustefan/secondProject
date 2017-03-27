package com.bithealth.deviceCore.service;

import com.bithealth.deviceCore.model.MeasureReqParam;



public interface DeviceMeasureService  {    
	
	/**
	 * @Title:uploadMeasureData 
	 * @Description:爱奥乐设备上传测量数据
	 * @author 谢美团
	 * @param measureReqParam
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	public boolean uploadMeasureData(MeasureReqParam measureReqParam) throws Exception;
	
	/**
	 * @Title:getResopneString 
	 * @Description:获取返回内容 
	 * @author 谢美团
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun String
	 */ 
	public String getResopneString()throws Exception;
	
}
