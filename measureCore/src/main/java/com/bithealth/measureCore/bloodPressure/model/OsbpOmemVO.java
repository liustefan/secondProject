 
/**
 * @PackageName:      com.bithealth.measureCore.bloodPressure.model
 * @FileName:     OsbpOmemVO.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年6月29日 上午9:56:15  
 * 
 */

package com.bithealth.measureCore.bloodPressure.model;

import java.sql.Date;


/**
 * 类名称: OsbpOmemVO  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月29日 上午9:56:15 
 * 
 * @author 陈哲
 * @version  
 */
public class OsbpOmemVO extends Osbp{
	
	private String logName;
	private Date birthDate;
	private String memName;
	private Integer memberId;
	private String gender;
	private String tel;
	
	/**
	 * logName.
	 *
	 * @return  the logName 
	 */
	public String getLogName() {
		return logName;
	}
	/**
	 * logName.
	 *
	 * @param   logName    the logName to set 
	 */
	public void setLogName(String logName) {
		this.logName = logName;
	}
	/**
	 * birthDate.
	 *
	 * @return  the birthDate 
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * birthDate.
	 *
	 * @param   birthDate    the birthDate to set 
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * memName.
	 *
	 * @return  the memName 
	 */
	public String getMemName() {
		return memName;
	}
	/**
	 * memName.
	 *
	 * @param   memName    the memName to set 
	 */
	public void setMemName(String memName) {
		this.memName = memName;
	}
	/**
	 * memberId.
	 *
	 * @return  the memberId 
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * memberId.
	 *
	 * @param   memberId    the memberId to set 
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * gender.
	 *
	 * @return  the gender 
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * gender.
	 *
	 * @param   gender    the gender to set 
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * tel.
	 *
	 * @return  the tel 
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * tel.
	 *
	 * @param   tel    the tel to set 
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
}

