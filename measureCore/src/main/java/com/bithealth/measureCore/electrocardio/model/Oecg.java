/*
 * Oecg.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.bithealth.careCore.facade.model.MsgCenter;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 心电测量表(OECG)
 * 
 * @author ${user}
 * @version 1.0 2016-07-11
 */
public class Oecg extends GenericModel {

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
     * 录入开始时间
     */
    private Integer timelength;
    /**
     * 录入结束时间
     */
    private Date ecgtime;
    /**
     * 测量时间
     */
    private Date meastime;
    /**
     * 写入数据库时间
     */
    private Short imagenum;
    /**
     * 总心搏数
     */
    private Integer heartnum;
    /**
     * 最小心率
     */
    private Short slowestbeat;
    /**
     * 最小心率时间
     */
    private Integer slowesttime;
    /**
     * 最大心率
     */
    private Short fastestbeat;
    /**
     * 最大心率时间
     */
    private Integer fastesttime;
    /**
     * 平均心率
     */
    private Integer averageheart;
    private BigDecimal sdnn;
    private BigDecimal pnn50;
    private BigDecimal hrvi;
    private BigDecimal rmssd;
    private BigDecimal tp;
    private BigDecimal vlf;
    private BigDecimal lf;
    private BigDecimal hf;
    private BigDecimal lfHf;
    private BigDecimal sd1;
    private BigDecimal sd2;
    private Short icount;
    private Short fs;
    private Short sdnnlevel;
    private Short pnn50level;
    private Short hrvilevel;
    private Short rmssdlevel;
    private Short tplevel;
    private Short vlflevel;
    private Short lflevel;
    private Short hflevel;
    private Short lhrlevel;
    private Short hrlevel;
    private Short addvalue;
    private String devicecode;
    private String bluetoothmacaddr;
    private String rawecgimg;
    private String freqpsd;
    private String rrinterval;
    private String rawecg;
    /**
     * 是否删除
     */
    private String deltag;
    /**
     * 状态
     */
    private Short ecgresult;
    /**
     * 分析完成状态
     */
    private Short statustag;
    
    private int tableNum;
    
    private int dataType;
    
    private List<Ecg2> ecg2s;
    
    private Oppg oppg;
    
    private MsgCenter msgCenter;
    
    
	public MsgCenter getMsgCenter() {
		return msgCenter;
	}
	public void setMsgCenter(MsgCenter msgCenter) {
		this.msgCenter = msgCenter;
	}
	public Oppg getOppg() {
		return oppg;
	}
	public void setOppg(Oppg oppg) {
		this.oppg = oppg;
	}
	public List<Ecg2> getEcg2s() {
		return ecg2s;
	}
	public void setEcg2s(List<Ecg2> ecg2s) {
		this.ecg2s = ecg2s;
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
    public Integer getTimelength() {
        return timelength == null ? 0 : timelength;
    }
    public void setTimelength(Integer timelength) {
        this.timelength = timelength;
    }
    public Date getEcgtime() {
        return ecgtime;
    }
    public void setEcgtime(Date ecgtime) {
        this.ecgtime = ecgtime;
    }
    public Date getMeastime() {
        return meastime;
    }
    public void setMeastime(Date meastime) {
        this.meastime = meastime;
    }
    public Short getImagenum() {
        return imagenum == null ? 0 : imagenum;
    }
    public void setImagenum(Short imagenum) {
        this.imagenum = imagenum;
    }
    public Integer getHeartnum() {
        return heartnum == null ? 0 : heartnum;
    }
    public void setHeartnum(Integer heartnum) {
        this.heartnum = heartnum;
    }
    public Short getSlowestbeat() {
        return slowestbeat == null ? 0 : slowestbeat;
    }
    public void setSlowestbeat(Short slowestbeat) {
        this.slowestbeat = slowestbeat;
    }
    public Integer getSlowesttime() {
        return slowesttime == null ? 0 : slowesttime;
    }
    public void setSlowesttime(Integer slowesttime) {
        this.slowesttime = slowesttime;
    }
    public Short getFastestbeat() {
        return fastestbeat == null ? 0 : fastestbeat;
    }
    public void setFastestbeat(Short fastestbeat) {
        this.fastestbeat = fastestbeat;
    }
    public Integer getFastesttime() {
        return fastesttime == null ? 0 : fastesttime;
    }
    public void setFastesttime(Integer fastesttime) {
        this.fastesttime = fastesttime;
    }
    public Integer getAverageheart() {
        return averageheart == null ? 0 : averageheart;
    }
    public void setAverageheart(Integer averageheart) {
        this.averageheart = averageheart;
    }
    public BigDecimal getSdnn() {
        return sdnn == null ? BigDecimal.ZERO : sdnn;
    }
    public void setSdnn(BigDecimal sdnn) {
        this.sdnn = sdnn;
    }
    public BigDecimal getPnn50() {
        return pnn50 == null ? BigDecimal.ZERO : pnn50;
    }
    public void setPnn50(BigDecimal pnn50) {
        this.pnn50 = pnn50;
    }
    public BigDecimal getHrvi() {
        return hrvi == null ? BigDecimal.ZERO : hrvi;
    }
    public void setHrvi(BigDecimal hrvi) {
        this.hrvi = hrvi;
    }
    public BigDecimal getRmssd() {
        return rmssd == null ? BigDecimal.ZERO : rmssd;
    }
    public void setRmssd(BigDecimal rmssd) {
        this.rmssd = rmssd;
    }
    public BigDecimal getTp() {
        return tp == null ? BigDecimal.ZERO : tp;
    }
    public void setTp(BigDecimal tp) {
        this.tp = tp;
    }
    public BigDecimal getVlf() {
        return vlf == null ? BigDecimal.ZERO : vlf;
    }
    public void setVlf(BigDecimal vlf) {
        this.vlf = vlf;
    }
    public BigDecimal getLf() {
        return lf == null ? BigDecimal.ZERO : lf;
    }
    public void setLf(BigDecimal lf) {
        this.lf = lf;
    }
    public BigDecimal getHf() {
        return hf == null ? BigDecimal.ZERO : hf;
    }
    public void setHf(BigDecimal hf) {
        this.hf = hf;
    }
    public BigDecimal getLfHf() {
        return lfHf == null ? BigDecimal.ZERO :lfHf;
    }
    public void setLfHf(BigDecimal lfHf) {
        this.lfHf = lfHf;
    }
    public BigDecimal getSd1() {
        return sd1 == null ? BigDecimal.ZERO : sd1;
    }
    public void setSd1(BigDecimal sd1) {
        this.sd1 = sd1;
    }
    public BigDecimal getSd2() {
        return sd2 == null ? BigDecimal.ZERO : sd2;
    }
    public void setSd2(BigDecimal sd2) {
        this.sd2 = sd2;
    }
    public Short getIcount() {
        return icount == null ? 0 : icount;
    }
    public void setIcount(Short icount) {
        this.icount = icount;
    }
    public Short getFs() {
        return fs == null ? 0 : fs;
    }
    public void setFs(Short fs) {
        this.fs = fs;
    }
    public Short getSdnnlevel() {
        return sdnnlevel == null ? 0 : sdnnlevel;
    }
    public void setSdnnlevel(Short sdnnlevel) {
        this.sdnnlevel = sdnnlevel;
    }
    public Short getPnn50level() {
        return pnn50level == null ? 0 : pnn50level;
    }
    public void setPnn50level(Short pnn50level) {
        this.pnn50level = pnn50level;
    }
    public Short getHrvilevel() {
        return hrvilevel == null ? 0 : hrvilevel;
    }
    public void setHrvilevel(Short hrvilevel) {
        this.hrvilevel = hrvilevel;
    }
    public Short getRmssdlevel() {
        return rmssdlevel == null ? 0 : rmssdlevel;
    }
    public void setRmssdlevel(Short rmssdlevel) {
        this.rmssdlevel = rmssdlevel;
    }
    public Short getTplevel() {
        return tplevel == null ? 0 : tplevel;
    }
    public void setTplevel(Short tplevel) {
        this.tplevel = tplevel;
    }
    public Short getVlflevel() {
        return vlflevel == null ? 0 : vlflevel;
    }
    public void setVlflevel(Short vlflevel) {
        this.vlflevel = vlflevel;
    }
    public Short getLflevel() {
        return lflevel == null ? 0 : lflevel;
    }
    public void setLflevel(Short lflevel) {
        this.lflevel = lflevel;
    }
    public Short getHflevel() {
        return hflevel == null ? 0 : hflevel;
    }
    public void setHflevel(Short hflevel) {
        this.hflevel = hflevel;
    }
    public Short getLhrlevel() {
        return lhrlevel == null ? 0 : lhrlevel;
    }
    public void setLhrlevel(Short lhrlevel) {
        this.lhrlevel = lhrlevel;
    }
    public Short getHrlevel() {
        return hrlevel == null ? 0 : hrlevel;
    }
    public void setHrlevel(Short hrlevel) {
        this.hrlevel = hrlevel;
    }
    public Short getAddvalue() {
        return addvalue == null ? 0 : addvalue;
    }
    public void setAddvalue(Short addvalue) {
        this.addvalue = addvalue;
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
    public String getRawecgimg() {
        return rawecgimg;
    }
    public void setRawecgimg(String rawecgimg) {
        this.rawecgimg = rawecgimg;
    }
    public String getFreqpsd() {
        return freqpsd;
    }
    public void setFreqpsd(String freqpsd) {
        this.freqpsd = freqpsd;
    }
    public String getRrinterval() {
        return rrinterval;
    }
    public void setRrinterval(String rrinterval) {
        this.rrinterval = rrinterval;
    }
    public String getRawecg() {
        return rawecg;
    }
    public void setRawecg(String rawecg) {
        this.rawecg = rawecg;
    }
    public String getDeltag() {
        return deltag;
    }
    public void setDeltag(String deltag) {
        this.deltag = deltag;
    }
    public Short getEcgresult() {
        return ecgresult == null ? 0 : ecgresult;
    }
    public void setEcgresult(Short ecgresult) {
        this.ecgresult = ecgresult;
    }
    public Short getStatustag() {
        return statustag == null ? 0 : statustag;
    }
    public void setStatustag(Short statustag) {
        this.statustag = statustag;
    }
	public int getTableNum() {
		return tableNum;
	}
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	public int getDataType() {
		return dataType;
	}
	public void setDataType(int dataType) {
		this.dataType = dataType;
	}
}