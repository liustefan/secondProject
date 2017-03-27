 

package com.bithealth.deviceCore.model;

import java.util.Date;


public class DataBean {
    /**
     * 序列号
     */
	private String serialNumber;

    private Integer data1;

    private Integer data2;

    private Integer data3;
    
    /**
     * 测量时间
     */
    private Date testtime;
    
    /**
     * 校验码
     */
    private String ascCode;
    
    private String CRC8;
    
    /**
     * 机种码
     */
    private String deviceType;
    


	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getData1() {
		return data1;
	}

	public void setData1(Integer data1) {
		this.data1 = data1;
	}

	public Integer getData2() {
		return data2;
	}

	public void setData2(Integer data2) {
		this.data2 = data2;
	}

	public Integer getData3() {
		return data3;
	}

	public void setData3(Integer data3) {
		this.data3 = data3;
	}

	public Date getTesttime() {
		return testtime;
	}

	public void setTesttime(Date testtime) {
		this.testtime = testtime;
	}

	public String getAscCode() {
		return ascCode;
	}

	public void setAscCode(String ascCode) {
		this.ascCode = ascCode;
	}

	public String getCRC8() {
		return CRC8;
	}

	public void setCRC8(String cRC8) {
		CRC8 = cRC8;
	}
    
    
	
}

