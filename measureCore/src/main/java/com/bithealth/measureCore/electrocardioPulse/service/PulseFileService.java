 
/**
 * @PackageName:      com.bithealth.measureCore.electrocardioPulse.service
 * @FileName:     PulseFileService.java  
 * @Description: 脉搏以及三合一心电处理接口  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月19日 下午3:15:40  
 * 
 */

package com.bithealth.measureCore.electrocardioPulse.service;

import java.io.InputStream;
import java.util.Map;

import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.common.model.ImageParam;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.memberCore.member.model.MemberExt;


/**
 * 类名称: PulseFileService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月19日 下午3:15:40 
 * 
 * @author 陈哲
 * @version  
 */
public interface PulseFileService {
	public Map<String, Object> getElectrocardioPulseChartFileData(ImageParam param);
	
	public Map<String,Object> getPulseChartFileData(ImageParam param);
	
	public Map<String,Object> getInstantPulseChartFileData(ImageParam param);
	
	public int getElectrocardioPulsePageByparam(ImageParam param);
	
	public int getPulsePageByParam(ImageParam param);
	
	void saveElectrocardioPulseFile(InputStream ecgIn, Oecg oecg, InputStream ppgIn, Oppg oppg) throws Exception;
	
	public String getMqOecgOppgMessage(Oecg oecg, Oppg oppg, Osbp osbp,
			MemberExt memberExt) throws Exception;
	
	public Map<String, Object> getElectrocardioPulseChartFileDataApp(ImageParam param);

}

