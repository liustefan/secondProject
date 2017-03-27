 

package com.bithealth.taskMgrCore.measureBean;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;



/**
 * 类名称: ObsrParam  
 * 功能描述: 血糖参数 
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月22日 下午1:38:32 
 * 
 * @author 谢美团
 * @version  
 */
public class ObsrParam {
	
	private Integer memberId;
	
	@JSONField (format="yyyy-MM-dd HH:mm:ss")  
	private Date testTime; 
	
	private String timePeriod;
	
	private String bsValue;
	
	private String bluetoothMacAddr;
	
	private String deviceCode;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Date getTestTime() {
		return testTime;
	}

	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}

	public String getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}

	public String getBsValue() {
		return bsValue;
	}

	public void setBsValue(String bsValue) {
		this.bsValue = bsValue;
	}

	public String getBluetoothMacAddr() {
		return bluetoothMacAddr;
	}

	public void setBluetoothMacAddr(String bluetoothMacAddr) {
		this.bluetoothMacAddr = bluetoothMacAddr;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	
}

