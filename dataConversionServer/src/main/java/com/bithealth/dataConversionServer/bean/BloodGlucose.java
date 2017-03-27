package com.bithealth.dataConversionServer.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * @ClassName:     BloodGlucose.java 
 * @Description:   血糖
 * @author         liuxiaoqin  
 * @version        V1.0   
 * @Date           2015年12月19日 下午4:34:08
*****/
public class BloodGlucose implements Serializable {

    private static final long serialVersionUID = -6372886548567951670L;

    /* 数据ID */
    private long id;

    /* 会员id */
    private int memberId; 
    
    /* 测量记录ID */
    private long eventId;
    
    /* 上传时间格式如：20141021143021 */
    private Date uploadTime;

    /* 测量时间格式如：20141021143021 */
    private Date testTime;

    /* 本次测量血糖值 */
    private float bsValue;

    /* 测量时间段 0 其他时间段 1 起床后2小时 2 睡觉前 */
    private int timePeriod;

    /* 分析结果 */
    private String analysisResult;

    /* 是否删除: 0:未删除,1:已删除*/
    private String delTag; 

    /* 上传方式：Hand 手动或如果是蓝牙设备名称 */
    private String deviceCode; 

    /* 设备蓝牙地址 */
    private String bluetoothMacAddr;
    
    /* 身份证号 */
    private String identification;
    
    /* 异常状态0正常;1低血压;2高度高血压;3中度高血压;4轻度高血压;5单纯收缩期高血压 */
    private String abnormal;
    
    /* 健康档案编号 */
    private String hrGid;
    
    /* 查询开始时间 */
    private Date lastQueryTime;
    
    /* 查询截止时间 */
    private Date endQueryTime;
    
    
    private String prgid;
    
    
    
    public String getPrgid() {
		return prgid;
	}

	public void setPrgid(String prgid) {
		this.prgid = prgid;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }


    public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Date getTestTime() {
		return testTime;
	}

	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}

	public float getBsValue() {
        return bsValue;
    }

    public void setBsValue(float bsValue) {
        this.bsValue = bsValue;
    }

    public int getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getAnalysisResult() {
        return analysisResult;
    }

    public void setAnalysisResult(String analysisResult) {
        this.analysisResult = analysisResult;
    }

    public String getDelTag() {
        return delTag;
    }

    public void setDelTag(String delTag) {
        this.delTag = delTag;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getBluetoothMacAddr() {
        return bluetoothMacAddr;
    }

    public void setBluetoothMacAddr(String bluetoothMacAddr) {
        this.bluetoothMacAddr = bluetoothMacAddr;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(String abnormal) {
        this.abnormal = abnormal;
    }

    public String getHrGid() {
        return hrGid;
    }

    public void setHrGid(String hrGid) {
        this.hrGid = hrGid;
    }

    public Date getLastQueryTime() {
        return lastQueryTime;
    }

    public void setLastQueryTime(Date lastQueryTime) {
        this.lastQueryTime = lastQueryTime;
    }

    public Date getEndQueryTime() {
        return endQueryTime;
    }

    public void setEndQueryTime(Date endQueryTime) {
        this.endQueryTime = endQueryTime;
    }
    
    
}
