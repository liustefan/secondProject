package com.bithealth.dataConversionServer.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * @ClassName:     BloodPressure.java 
 * @Description:   血压
 * @author         liuxiaoqin  
 * @version        V1.0   
 * @Date           2015年12月19日 下午4:34:08
*****/
public class BloodPressure implements Serializable {

    private static final long serialVersionUID = -669243757421733928L;

    /* 数据ID */
    private long id;
    
    /* 会员代码 */
    private int memberId;
    
    /* 是否删除 (0 : 否 ,1 ： 是) */
    private int delTag;

    /* 上传时间格式如：20141021143021 */
    private Date uploadTime;

    /* 测量时间格式如：20141021143021 */
    private Date testTime;

    /* 测量记录ID */
    private long eventId;

    /* 异常状态0 正常 1 低血压2 高度高血压3 中度高血压4 轻度高血压 5 单纯收缩高血压 */
    private String abnormal;

    /* 测量时间段 0 其他时间段 1 起床后2小时 2 睡觉前 */
    private int timePeriod;

    /* 收缩压 */
    private int sbp;

    /* 舒张压 */
    private int dbp; 

    /* 脉率 */
    private int pulseRate; 

    /* 上传方式：Hand 手动或如果是蓝牙设备名称 */
    private String deviceCode; 

    /* 设备蓝牙地址 */
    private String bluetoothMacAddr;
    
    /* 身份证号码 */
    private String identification;
    
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

	public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(String abnormal) {
        this.abnormal = abnormal;
    }

    public int getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    public int getSbp() {
        return sbp;
    }

    public void setSbp(int sbp) {
        this.sbp = sbp;
    }

    public int getDbp() {
        return dbp;
    }

    public void setDbp(int dbp) {
        this.dbp = dbp;
    }

    public int getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(int pulseRate) {
        this.pulseRate = pulseRate;
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

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getDelTag() {
        return delTag;
    }

    public void setDelTag(int delTag) {
        this.delTag = delTag;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
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
