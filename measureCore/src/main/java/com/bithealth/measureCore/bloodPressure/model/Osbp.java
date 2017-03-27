/*
 * Osbp.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-29 Created
 */
package com.bithealth.measureCore.bloodPressure.model;

import java.util.Date;

import com.bithealth.careCore.facade.model.MsgCenter;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 血压测量表（osbp）
 * 
 * @author ${user}
 * @version 1.0 2016-06-29
 */
public class Osbp extends GenericModel {

    /**
     * 测量记录号
     */
    private Long docentry;
    private Long eventid;
    /**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 上传时间
     */
    private Date uploadtime;
    /**
     * 测量时间
     */
    private Date testtime;
    /**
     * 是否删除 (0 : 否 ,1 ： 是)
     */
    private String deltag;
    /**
     * 异常状态 ( 0  : 正常 , 1  :  低血压 ,2  : 高度高血压, 3  : 中度高血压, 4  : 轻度高血压 ,5  : 单纯收缩期高血压)
     */
    private String abnormal;
    /**
     * 测量时间段( 0  :  其他（随机测量）,1  : 起床后2小时内, 2  : 睡觉前 )
     */
    private String timeperiod;
    /**
     * 收缩压
     */
    private Integer sbp;
    /**
     * 舒张压
     */
    private Integer dbp;
    /**
     * 脉搏率
     */
    private Integer pulserate;
    private String bluetoothmacaddr;
    private String devicecode;
    
    private int tableNum;
    
    private MsgCenter msgCenter;

    
	public MsgCenter getMsgCenter() {
		return msgCenter;
	}
	public void setMsgCenter(MsgCenter msgCenter) {
		this.msgCenter = msgCenter;
	}
	public Long getDocentry() {
        return docentry;
    }
    public void setDocentry(Long docentry) {
        this.docentry = docentry;
    }
    public Long getEventid() {
        return eventid;
    }
    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Date getUploadtime() {
        return uploadtime;
    }
    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }
    public Date getTesttime() {
        return testtime;
    }
    public void setTesttime(Date testtime) {
        this.testtime = testtime;
    }
    public String getDeltag() {
        return deltag;
    }
    public void setDeltag(String deltag) {
        this.deltag = deltag;
    }
    public String getAbnormal() {
        return abnormal;
    }
    public void setAbnormal(String abnormal) {
        this.abnormal = abnormal;
    }
    public String getTimeperiod() {
        return timeperiod;
    }
    public void setTimeperiod(String timeperiod) {
        this.timeperiod = timeperiod;
    }
    public Integer getSbp() {
        return sbp;
    }
    public void setSbp(Integer sbp) {
        this.sbp = sbp;
    }
    public Integer getDbp() {
        return dbp;
    }
    public void setDbp(Integer dbp) {
        this.dbp = dbp;
    }
    public Integer getPulserate() {
        return pulserate;
    }
    public void setPulserate(Integer pulserate) {
        this.pulserate = pulserate;
    }
    public String getBluetoothmacaddr() {
        return bluetoothmacaddr;
    }
    public void setBluetoothmacaddr(String bluetoothmacaddr) {
        this.bluetoothmacaddr = bluetoothmacaddr;
    }
    public String getDevicecode() {
        return devicecode;
    }
    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode;
    }
	/**
	 * tableNum.
	 *
	 * @return  the tableNum 
	 */
	public int getTableNum() {
		return tableNum;
	}
	/**
	 * tableNum.
	 *
	 * @param   tableNum    the tableNum to set 
	 */
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
    
}