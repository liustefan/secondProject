/*
 * Oppg.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.measureCore.electrocardioPulse.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 脉搏测量表（OPPG）
 * 
 * @author ${user}
 * @version 1.0 2016-07-12
 */
public class Oppg extends GenericModel {

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
     * 测量时长
     */
    private Integer timelength;
    /**
     * 上传时间
     */
    private Date uploadtime;
    private Date measuretime;
    /**
     * 总脉搏数
     */
    private Short pulsebeatcount;
    /**
     * 最小脉搏
     */
    private Short slowpulse;
    /**
     * 最小脉搏时间
     */
    private Short slowtime;
    /**
     * 最大脉搏
     */
    private Short quickpulse;
    /**
     * 最大脉搏时间
     */
    private Short quicktime;
    /**
     * 平均脉搏
     */
    private Short pulserate;
    /**
     * 血氧饱和度
     */
    private Short spo;
    private Short spo1;
    /**
     * 平均每分射血量 CO
     */
    private BigDecimal co;
    private BigDecimal si;
    /**
     * 心脏每搏射血量 SV
     */
    private BigDecimal sv;
    /**
     * 心指数 CI
     */
    private BigDecimal ci;
    /**
     * 心搏指数 SPI
     */
    private BigDecimal spi;
    /**
     * 波形特征量 K
     */
    private BigDecimal k;
    private BigDecimal k1;
    /**
     * 血液粘度 V
     */
    private BigDecimal v;
    /**
     * 外周阻力 TPR
     */
    private BigDecimal tpr;
    private BigDecimal pwtt;
    private BigDecimal pm;
    /**
     * 血管顺应度 AC
     */
    private BigDecimal ac;
    /**
     * 瞬时脉搏图
     */
    private Short imagenum;
    /**
     * 脉搏评估
     */
    private Short prlevel;
    private Short klevel;
    private Short svlevel;
    private Short colevel;
    /**
     * ACLevel
     */
    private Short aclevel;
    private Short silevel;
    private Short vlevel;
    private Short tprlevel;
    private Short spolevel;
    private Short cilevel;
    private Short spilevel;
    private Short pwttlevel;
    private Integer abnormaldata;
    private String ppgrr;
    private String rawppg;
    private String bluetoothmacaddr;
    private String devicecode;
    private Short icount;
    private Integer addvalue;
    /**
     * 采样频率
     */
    private Short fs;
    /**
     * 状态 (0  :  未见异常, 1  ： 有异常)
     */
    private Short ppgresult;
    /**
     * 分析状态( 0 : 未分析, 1 ： 分析失败 ,2 ： 分析成功 )
     */
    private Short statustag;
    /**
     * 是否删除(0 : 否, 1 ： 是)
     */
    private String deltag;
    
    /*private int tableNum;*/
    
    private List<String> extName;//脉搏异常名称，脉搏异常有12项指标
    
    private List<ExcOppg> excOppgs;
    
    private Oecg oecg;
    
	public Oecg getOecg() {
		return oecg;
	}
	public void setOecg(Oecg oecg) {
		this.oecg = oecg;
	}
	public List<ExcOppg> getExcOppgs() {
		return excOppgs;
	}
	public void setExcOppgs(List<ExcOppg> excOppgs) {
		this.excOppgs = excOppgs;
	}
	public List<String> getExtName() {
		return extName;
	}
	public void setExtName(List<String> extName) {
		this.extName = extName;
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
        return memberid == null ? 0 : memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Integer getTimelength() {
        return timelength == null ? 0 : timelength;
    }
    public void setTimelength(Integer timelength) {
        this.timelength = timelength;
    }
    public Date getUploadtime() {
        return uploadtime;
    }
    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }
    public Date getMeasuretime() {
        return measuretime;
    }
    public void setMeasuretime(Date measuretime) {
        this.measuretime = measuretime;
    }
    public Short getPulsebeatcount() {
        return pulsebeatcount == null ? 0 : pulsebeatcount;
    }
    public void setPulsebeatcount(Short pulsebeatcount) {
        this.pulsebeatcount = pulsebeatcount;
    }
    public Short getSlowpulse() {
        return slowpulse == null ? 0 : slowpulse;
    }
    public void setSlowpulse(Short slowpulse) {
        this.slowpulse = slowpulse;
    }
    public Short getSlowtime() {
        return slowtime == null ? 0 : slowtime;
    }
    public void setSlowtime(Short slowtime) {
        this.slowtime = slowtime;
    }
    public Short getQuickpulse() {
        return quickpulse == null ? 0 : quickpulse;
    }
    public void setQuickpulse(Short quickpulse) {
        this.quickpulse = quickpulse;
    }
    public Short getQuicktime() {
        return quicktime == null ? 0 : quicktime;
    }
    public void setQuicktime(Short quicktime) {
        this.quicktime = quicktime;
    }
    public Short getPulserate() {
        return pulserate == null ? 0 : pulserate;
    }
    public void setPulserate(Short pulserate) {
        this.pulserate = pulserate;
    }
    public Short getSpo() {
        return spo == null ? 0 : spo;
    }
    public void setSpo(Short spo) {
        this.spo = spo;
    }
    public Short getSpo1() {
        return spo1 == null ? 0 : spo1;
    }
    public void setSpo1(Short spo1) {
        this.spo1 = spo1;
    }
    public BigDecimal getCo() {
        return co == null ? BigDecimal.ZERO : co;
    }
    public void setCo(BigDecimal co) {
        this.co = co;
    }
    public BigDecimal getSi() {
        return si == null ? BigDecimal.ZERO : si;
    }
    public void setSi(BigDecimal si) {
        this.si = si;
    }
    public BigDecimal getSv() {
        return sv == null ? BigDecimal.ZERO : sv;
    }
    public void setSv(BigDecimal sv) {
        this.sv = sv;
    }
    public BigDecimal getCi() {
        return ci == null ? BigDecimal.ZERO : ci;
    }
    public void setCi(BigDecimal ci) {
        this.ci = ci;
    }
    public BigDecimal getSpi() {
        return spi == null ? BigDecimal.ZERO : spi;
    }
    public void setSpi(BigDecimal spi) {
        this.spi = spi;
    }
    public BigDecimal getK() {
        return k == null ? BigDecimal.ZERO : k;
    }
    public void setK(BigDecimal k) {
        this.k = k;
    }
    public BigDecimal getK1() {
        return k1 == null ? BigDecimal.ZERO : k1;
    }
    public void setK1(BigDecimal k1) {
        this.k1 = k1;
    }
    public BigDecimal getV() {
        return v == null ? BigDecimal.ZERO : v;
    }
    public void setV(BigDecimal v) {
        this.v = v;
    }
    public BigDecimal getTpr() {
        return tpr == null ? BigDecimal.ZERO : tpr;
    }
    public void setTpr(BigDecimal tpr) {
        this.tpr = tpr;
    }
    public BigDecimal getPwtt() {
        return pwtt == null ? BigDecimal.ZERO : pwtt;
    }
    public void setPwtt(BigDecimal pwtt) {
        this.pwtt = pwtt;
    }
    public BigDecimal getPm() {
        return pm == null ? BigDecimal.ZERO : pm;
    }
    public void setPm(BigDecimal pm) {
        this.pm = pm;
    }
    public BigDecimal getAc() {
        return ac == null ? BigDecimal.ZERO : ac;
    }
    public void setAc(BigDecimal ac) {
        this.ac = ac;
    }
    public Short getImagenum() {
        return imagenum == null ? 0 : imagenum;
    }
    public void setImagenum(Short imagenum) {
        this.imagenum = imagenum;
    }
    public Short getPrlevel() {
        return prlevel == null ? 0 : prlevel;
    }
    public void setPrlevel(Short prlevel) {
        this.prlevel = prlevel;
    }
    public Short getKlevel() {
        return klevel == null ? 0 : klevel;
    }
    public void setKlevel(Short klevel) {
        this.klevel = klevel;
    }
    public Short getSvlevel() {
        return svlevel == null ? 0 : svlevel;
    }
    public void setSvlevel(Short svlevel) {
        this.svlevel = svlevel;
    }
    public Short getColevel() {
        return colevel == null ? 0 : colevel;
    }
    public void setColevel(Short colevel) {
        this.colevel = colevel;
    }
    public Short getAclevel() {
        return aclevel == null ? 0 : aclevel;
    }
    public void setAclevel(Short aclevel) {
        this.aclevel = aclevel;
    }
    public Short getSilevel() {
        return silevel == null ? 0 : silevel;
    }
    public void setSilevel(Short silevel) {
        this.silevel = silevel;
    }
    public Short getVlevel() {
        return vlevel == null ? 0 : vlevel;
    }
    public void setVlevel(Short vlevel) {
        this.vlevel = vlevel;
    }
    public Short getTprlevel() {
        return tprlevel == null ? 0 : tprlevel;
    }
    public void setTprlevel(Short tprlevel) {
        this.tprlevel = tprlevel;
    }
    public Short getSpolevel() {
        return spolevel == null ? 0 : spolevel;
    }
    public void setSpolevel(Short spolevel) {
        this.spolevel = spolevel;
    }
    public Short getCilevel() {
        return cilevel == null ? 0 : cilevel;
    }
    public void setCilevel(Short cilevel) {
        this.cilevel = cilevel;
    }
    public Short getSpilevel() {
        return spilevel == null ? 0 : spilevel;
    }
    public void setSpilevel(Short spilevel) {
        this.spilevel = spilevel;
    }
    public Short getPwttlevel() {
        return pwttlevel == null ? 0 : pwttlevel;
    }
    public void setPwttlevel(Short pwttlevel) {
        this.pwttlevel = pwttlevel;
    }
    public Integer getAbnormaldata() {
        return abnormaldata == null ? 0 : abnormaldata;
    }
    public void setAbnormaldata(Integer abnormaldata) {
        this.abnormaldata = abnormaldata;
    }
    public String getPpgrr() {
        return ppgrr;
    }
    public void setPpgrr(String ppgrr) {
        this.ppgrr = ppgrr;
    }
    public String getRawppg() {
        return rawppg;
    }
    public void setRawppg(String rawppg) {
        this.rawppg = rawppg;
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
    public Short getIcount() {
        return icount == null ? 0 : icount;
    }
    public void setIcount(Short icount) {
        this.icount = icount;
    }
    public Integer getAddvalue() {
        return addvalue == null ? 0 : addvalue;
    }
    public void setAddvalue(Integer addvalue) {
        this.addvalue = addvalue;
    }
    public Short getFs() {
        return fs == null ? 0 : fs;
    }
    public void setFs(Short fs) {
        this.fs = fs;
    }
    public Short getPpgresult() {
        return ppgresult == null ? 0 : ppgresult;
    }
    public void setPpgresult(Short ppgresult) {
        this.ppgresult = ppgresult;
    }
    public Short getStatustag() {
        return statustag == null ? 0 : statustag;
    }
    public void setStatustag(Short statustag) {
        this.statustag = statustag;
    }
    public String getDeltag() {
        return deltag;
    }
    public void setDeltag(String deltag) {
        this.deltag = deltag;
    }
	/**
	 * tableNum.
	 *
	 * @return  the tableNum 
	 *//*
	public int getTableNum() {
		return tableNum;
	}
	*//**
	 * tableNum.
	 *
	 * @param   tableNum    the tableNum to set 
	 *//*
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	*/
	//测量结果
	public List<String> getMeasureResult(){
		List<String> list = new ArrayList<String>();
		if(this.pulserate == null){
			this.pulserate = 0;
		}
		if(this.pulserate < 55){
			list.add("平均脉率 PR(偏低)");
		}else if(this.pulserate > 100){
			list.add("平均脉率 PR(偏高)");
		}
		
		if(this.co == null){
			this.co = BigDecimal.ZERO;
		}
		if(this.co.compareTo(new BigDecimal(3)) < 0){
			list.add("平均每分射血量 co(偏低)");
		}else if(this.co.compareTo(new BigDecimal(7.5)) > 0){
			list.add("平均每分射血量 co(偏高)");
		}
		
		if(this.sv == null){
			this.sv = BigDecimal.ZERO;
		}
		if(this.sv.compareTo(new BigDecimal(55)) < 0){
			list.add("心脏每搏射血量 SV(偏低)");
		}else if(this.sv.compareTo(new BigDecimal(105)) > 0){
			list.add("心脏每搏射血量 SV(偏高)");
		}
		
		if(this.spo == null){
			this.spo = 0;
		}
		if(this.spo < 95){
			list.add("血氧饱和度SO(偏低)");
		}else if(this.spo > 100){
			list.add("血氧饱和度SO(偏高)");
		}
		
		if(this.ci == null){
			this.ci = BigDecimal.ZERO;
		}
		if(this.ci.compareTo(new BigDecimal(2.3)) < 0){
			list.add("心指数 CI(偏低)");
		}else if(this.ci.compareTo(new BigDecimal(100)) > 0){
			list.add("心指数 CI(偏高)");
		}
		
		if(this.spi == null){
			this.spi = BigDecimal.ZERO;
		}
		if(this.spi.compareTo(new BigDecimal(33)) < 0){
			list.add("心搏指数SPI(偏低)");
		}else if(this.spi.compareTo(new BigDecimal(200)) > 0){
			list.add("心搏指数SPI(偏高)");
		}
		
		if(this.k == null){
			this.k = BigDecimal.ZERO;
		}
		if(this.k.compareTo(new BigDecimal(0.29)) < 0){
			list.add("波形特征量 K(偏低)");
		}else if(this.k.compareTo(new BigDecimal(0.46)) > 0){
			list.add("波形特征量 K(偏高)");
		}
		
		if(this.v == null){
			this.v = BigDecimal.ZERO;
		}
		if(this.v.compareTo(new BigDecimal(3)) < 0){
			list.add("血液黏度(偏低)");
		}else if(this.v.compareTo(new BigDecimal(5.04)) > 0){
			list.add("血液黏度(偏高)");
		}
		
		if(this.tpr == null){
			this.tpr = BigDecimal.ZERO;
		}
		if(this.tpr.compareTo(new BigDecimal(750)) < 0){
			list.add("外周阻力 TPR(偏低)");
		}else if(this.tpr.compareTo(new BigDecimal(1450)) > 0){
			list.add("外周阻力 TPR(偏高)");
		}
		
		if(this.ac == null){
			this.ac = BigDecimal.ZERO;
		}
		if(this.ac.compareTo(new BigDecimal(1.2)) < 0){
			list.add("血管顺应度 AC(偏低)");
		}else if(this.ac.compareTo(new BigDecimal(3)) > 0){
			list.add("血管顺应度 AC(偏高)");
		}
		
		if(this.pm == null){
			this.pm = BigDecimal.ZERO;
		}
		if(this.pm.compareTo(new BigDecimal(70)) < 0){
			list.add("平均动脉压(偏低)");
		}else if(this.pm.compareTo(new BigDecimal(105)) > 0){
			list.add("平均动脉压(偏高)");
		}
		
		if(this.si == null){
			this.si = BigDecimal.ZERO;
		}
		if(this.si.compareTo(new BigDecimal(0)) < 0){
			list.add("血管硬化指数(偏低)");
		}else if(this.si.compareTo(new BigDecimal(8)) > 0){
			list.add("血管硬化指数(偏高)");
		}
		return list;
	}
	
	
	
	
	public List<ExcOppg> getExcPulseInfo(){
		List<ExcOppg> list = new ArrayList<ExcOppg>();
		if(this.pulserate == null){
			this.pulserate = 0;
		}
		if(this.pulserate < 55){
			ExcOppg exc = new ExcOppg();
			exc.setName("平均脉率");
			exc.setValue(this.pulserate);
			exc.setResult("偏低");
			list.add(exc);
		}else if(this.pulserate > 100){
			ExcOppg exc = new ExcOppg();
			exc.setName("平均脉率");
			exc.setValue(this.pulserate);
			exc.setResult("偏低");
			list.add(exc);
		}
		
		if(this.co == null){
			this.co = BigDecimal.ZERO;
		}
		if(this.co.compareTo(new BigDecimal(3)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("平均每分射血量");
			exc.setValue(this.co.doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(this.co.compareTo(new BigDecimal(7.5)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("平均每分射血量");
			exc.setValue(this.co.doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(this.sv == null){
			this.sv = BigDecimal.ZERO;
		}
		if(this.sv.compareTo(new BigDecimal(55)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("心脏每搏射血量");
			exc.setValue(this.sv.doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(this.sv.compareTo(new BigDecimal(105)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("心脏每搏射血量");
			exc.setValue(this.sv.doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(this.spo == null){
			this.spo = 0;
		}
		if(this.spo < 95){
			ExcOppg exc = new ExcOppg();
			exc.setName("血氧饱和度");
			exc.setValue(this.spo);
			exc.setResult("偏低");
			list.add(exc);
		}else if(this.spo > 100){
			ExcOppg exc = new ExcOppg();
			exc.setName("血氧饱和度");
			exc.setValue(this.spo);
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(this.ci == null){
			this.ci = BigDecimal.ZERO;
		}
		if(this.ci.compareTo(new BigDecimal(2.3)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("心指数");
			exc.setValue(this.ci.doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(this.ci.compareTo(new BigDecimal(100)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("心指数");
			exc.setValue(this.ci.doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(this.spi == null){
			this.spi = BigDecimal.ZERO;
		}
		if(this.spi.compareTo(new BigDecimal(33)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("心搏指数");
			exc.setValue(this.spi.doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(this.spi.compareTo(new BigDecimal(200)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("心搏指数");
			exc.setValue(this.spi.doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}
		
		if(this.k == null){
			this.k = BigDecimal.ZERO;
		}
		if(this.k.compareTo(new BigDecimal(0.29)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("波形特征量");
			exc.setValue(this.k.doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(this.k.compareTo(new BigDecimal(0.46)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("波形特征量");
			exc.setValue(this.k.doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(this.v == null){
			this.v = BigDecimal.ZERO;
		}
		if(this.v.compareTo(new BigDecimal(3)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("血液黏度");
			exc.setValue(this.v.doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(this.v.compareTo(new BigDecimal(5.04)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("血液黏度");
			exc.setValue(this.v.doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(this.tpr == null){
			this.tpr = BigDecimal.ZERO;
		}
		if(this.tpr.compareTo(new BigDecimal(750)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("外周阻力");
			exc.setValue(this.tpr.doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(this.tpr.compareTo(new BigDecimal(1450)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("外周阻力");
			exc.setValue(this.tpr.doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(this.ac == null){
			this.ac = BigDecimal.ZERO;
		}
		if(this.ac.compareTo(new BigDecimal(1.2)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("血管顺应度");
			exc.setValue(this.ac.doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(this.ac.compareTo(new BigDecimal(3)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("血管顺应度");
			exc.setValue(this.ac.doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(this.pm == null){
			this.pm = BigDecimal.ZERO;
		}
		if(this.pm.compareTo(new BigDecimal(70)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("平均动脉压");
			exc.setValue(this.pm.doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(this.pm.compareTo(new BigDecimal(105)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("平均动脉压");
			exc.setValue(this.pm.doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(this.si == null){
			this.si = BigDecimal.ZERO;
		}
		if(this.si.compareTo(new BigDecimal(0)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("血管硬化指数");
			exc.setValue(this.si.doubleValue());
			list.add(exc);
		}else if(this.si.compareTo(new BigDecimal(8)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("血管硬化指数");
			exc.setValue(this.si.doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		return list;
	}
    
}