/**
 * @PackageName:      com.bithealth.memberCore.enmu
 * @FileName:     UseTag.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月5日 下午5:23:52  
 * 
 */
package com.bithealth.memberCore.enmu;

/**
 * 类名称: UseTag  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月5日 下午5:23:52 
 * 
 * @author liuhm
 * @version  
 */
public enum UseTag {
	/**
	 * 冻结状态或者待删除
	 */
	D,
	
	//---------以下是Member UseTag枚举

	/**
	 * 已删除标识
	 */
	F,
	
	/**
	 * 待新增，注册中
	 */
	R,
	
	/**
	 * 修改中
	 */
	M,
	
	/**
	 * 失败 - 会员批量异步导入时才会出现
	 */
	E,
	
	/**
	 * 正常使用
	 */
	T;
}
