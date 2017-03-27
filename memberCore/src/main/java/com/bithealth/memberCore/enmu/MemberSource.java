/**
 * @PackageName:      com.bithealth.memberCore.enmu
 * @FileName:     MemberSource.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月8日 上午11:40:13  
 * 
 */
package com.bithealth.memberCore.enmu;

/**
 * 类名称: MemberSource  
 * 功能描述: 会员来源枚举.  
 * 日期: 2016年7月8日 上午11:40:13 
 * 
 * @author liuhm
 * @version  
 */
public enum MemberSource {
	Other(2, "其他"),
	ZLJY(1, "中联嘉裕导入"),
	WEB(0, "web医生端");
	
	private int code;
	
	private String desc;
	private MemberSource(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	 * 
	 * @Title:getSource 
	 * @Description:依据编号获取枚举. 
	 * @author liuhm
	 * @param code
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberSource
	 */
	public static MemberSource getSource(int code) {
		for(MemberSource source :MemberSource.values()) {
			if(source.code == code) {
				return source;
			}
		}
		return null;
	}
	
}
