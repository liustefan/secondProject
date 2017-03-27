/*
 * Obsr.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.measureCore.bloodSugar.model;

import java.util.Date;

import com.bithealth.careCore.facade.model.MsgCenter;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 血糖测量表（OBSR）
 * 
 * @author ${user}
 * @version 1.0 2016-07-05
 */
public class Obsr extends GenericModel {

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
     * 是否删除
     */
    private String deltag;
    /**
     * 本次测量血糖值
     */
    private Double bsvalue;
    /**
     * 测量时间段
     */
    private String timeperiod;
    /**
     * 分析结果
     */
    private String analysisresult;
    private String devicecode;
    private String bluetoothmacaddr;

  /*  private int tableNum;*/
    
    private String periodName;
    
    private MsgCenter msgCenter;
    
    private NormalValues nv;
    
	public MsgCenter getMsgCenter() {
		return msgCenter;
	}
	public void setMsgCenter(MsgCenter msgCenter) {
		this.msgCenter = msgCenter;
	}
	public String getPeriodName() {
		return periodName;
	}
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
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
    public Double getBsvalue() {
        return bsvalue;
    }
    public void setBsvalue(Double bsvalue) {
        this.bsvalue = bsvalue;
    }
    public String getTimeperiod() {
        return timeperiod;
    }
    public void setTimeperiod(String timeperiod) {
        this.timeperiod = timeperiod;
    }
    public String getAnalysisresult() {
        return analysisresult;
    }
    public void setAnalysisresult(String analysisresult) {
        this.analysisresult = analysisresult;
    }
    public String getDevicecode() {
        return devicecode;
    }
    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode;
    }
    public String getBluetoothmacaddr() {
        return bluetoothmacaddr;
    }
    public void setBluetoothmacaddr(String bluetoothmacaddr) {
        this.bluetoothmacaddr = bluetoothmacaddr;
    }
	/**
	 * tableNum.
	 *
	 * @return  the tableNum 
	 */
	/*public int getTableNum() {
		return tableNum;
	}
	*//**
	 * tableNum.
	 *
	 * @param   tableNum    the tableNum to set 
	 *//*
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}*/
	
	public NormalValues getNv() {
		return nv;
	}
	
	public void setNv(String timePeriod) {
		switch(timePeriod){
			case "0":
				this.nv = NormalValues.KEY0;
				break;
			case "1":
				this.nv = NormalValues.KEY1;
				break;
			case "2":
				this.nv = NormalValues.KEY2;
				break;
			case "3":
				this.nv = NormalValues.KEY3;
				break;
			case "4":
				this.nv = NormalValues.KEY4;
				break;
			case "5":
				this.nv = NormalValues.KEY5;
				break;
			case "6":
				this.nv = NormalValues.KEY6;
				break;
			case "7":
				this.nv = NormalValues.KEY7;
				break;
			case "8":
				this.nv = NormalValues.KEY8;
				break;
			default:
				this.nv = NormalValues.KEY0;
		}
	}
	
	public enum NormalValues{
		KEY0(3.9, 11.0),//其他（其他随机测量）
		KEY1(3.9, 6.0),//早晨空腹血溏
		KEY2(3.9, 7.7),//早餐后2小时
		KEY3(3.9, 6.0),//午餐前
		KEY4(3.9, 7.7),//午餐后2小时
		KEY5(3.9, 6.0),//晚餐前
		KEY6(3.9, 7.7),//晚餐后2小时
		KEY7(3.9, 6.0),//睡前
		KEY8(3.9, 6.0);//夜间（下半夜）
		private double min;
		private double max;
		private NormalValues(double min, double max){
			this.min = min;
			this.max = max;
		}
		public double getMin() {
			return min;
		}
		public void setMin(double min) {
			this.min = min;
		}
		public double getMax() {
			return max;
		}
		public void setMax(double max) {
			this.max = max;
		}
		
	}
    
}