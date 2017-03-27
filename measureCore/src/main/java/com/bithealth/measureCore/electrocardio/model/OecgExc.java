 
/**
 * @PackageName:      com.bithealth.measureCore.electrocardio.model
 * @FileName:     OecgExc.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月15日 上午9:54:45  
 * 
 */

package com.bithealth.measureCore.electrocardio.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * 类名称: OecgExc  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月15日 上午9:54:45 
 * 
 * @author 陈哲
 * @version  
 */
public class OecgExc {
	private Long docentry;
	private String expCname;//异常中文名称
	private Integer expNum;//异常次数
	private float expRate;//异常比例 = 异常次数/总心率数
	private String expName;//异常原名称
	private List<String> extimes = new ArrayList<String>();//异常时间=测量时间+异常发生的时间，日期格式字符串
	private List<Long> extMss = new ArrayList<Long>(); //异常时间，毫秒数
	private List<String> objectIds = new ArrayList<String>();//异常id
	
	private Timestamp timePoint1;
	private Timestamp timePoint2;
	
	/**
	 * docentry.
	 *
	 * @return  the docentry 
	 */
	public Long getDocentry() {
		return docentry;
	}
	/**
	 * docentry.
	 *
	 * @param   docentry    the docentry to set 
	 */
	public void setDocentry(Long docentry) {
		this.docentry = docentry;
	}
	/**
	 * expCname.
	 *
	 * @return  the expCname 
	 */
	public String getExpCname() {
		return expCname;
	}
	/**
	 * expCname.
	 *
	 * @param   expCname    the expCname to set 
	 */
	public void setExpCname(String expCname) {
		this.expCname = expCname;
	}
	/**
	 * expNum.
	 *
	 * @return  the expNum 
	 */
	public Integer getExpNum() {
		return expNum;
	}
	/**
	 * expNum.
	 *
	 * @param   expNum    the expNum to set 
	 */
	public void setExpNum(Integer expNum) {
		this.expNum = expNum;
	}
	/**
	 * expRate.
	 *
	 * @return  the expRate 
	 */
	public float getExpRate() {
		return expRate;
	}
	/**
	 * expRate.
	 *
	 * @param   expRate    the expRate to set 
	 */
	public void setExpRate(float expRate) {
		this.expRate = expRate;
	}
	/**
	 * expName.
	 *
	 * @return  the expName 
	 */
	public String getExpName() {
		return expName;
	}
	/**
	 * expName.
	 *
	 * @param   expName    the expName to set 
	 */
	public void setExpName(String expName) {
		this.expName = expName;
	}
	/**
	 * extimes.
	 *
	 * @return  the extimes 
	 */
	public List<String> getExtimes() {
		return extimes;
	}
	/**
	 * extimes.
	 *
	 * @param   extimes    the extimes to set 
	 */
	public void setExtimes(List<String> extimes) {
		this.extimes = extimes;
	}
	/**
	 * extMss.
	 *
	 * @return  the extMss 
	 */
	public List<Long> getExtMss() {
		return extMss;
	}
	/**
	 * extMss.
	 *
	 * @param   extMss    the extMss to set 
	 */
	public void setExtMss(List<Long> extMss) {
		this.extMss = extMss;
	}
	/**
	 * objectIds.
	 *
	 * @return  the objectIds 
	 */
	public List<String> getObjectIds() {
		return objectIds;
	}
	/**
	 * objectIds.
	 *
	 * @param   objectIds    the objectIds to set 
	 */
	public void setObjectIds(List<String> objectIds) {
		this.objectIds = objectIds;
	}
	
	public Timestamp getTimePoint1() {
		return timePoint1;
	}
	public void setTimePoint1(Timestamp timePoint1) {
		this.timePoint1 = timePoint1;
	}
	public Timestamp getTimePoint2() {
		return timePoint2;
	}
	public void setTimePoint2(Timestamp timePoint2) {
		this.timePoint2 = timePoint2;
	}
}

