 
/**
 * @PackageName:      com.bithealth.measureCore.electrocardioPulse.model
 * @FileName:     OppgOmemVO.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月12日 上午11:24:20  
 * 
 */

package com.bithealth.measureCore.electrocardioPulse.model;

import java.sql.Date;


/**
 * 类名称: OppgOmemVO  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月12日 上午11:24:20 
 * 
 * @author 陈哲
 * @version  
 */
public class OppgOmemVO extends Oppg{
	private String logName;
	private Date birthDate;
	private String memName;
	private String gender;
	private String tel;
	private String headAddress;
	private String oecgMeasResult;//心电异常结果
	
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
	
	public String getHeadAddress() {
		return headAddress;
	}
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}
	
	public String getOecgMeasResult() {
		return oecgMeasResult;
	}
	public void setOecgMeasResult(String oecgMeasResult) {
		this.oecgMeasResult = oecgMeasResult;
	}
}

