
package com.bithealth.measureCore.common.model;



/**
 * 类名称: OmdsExtend  
 * 功能描述:	Omds宽展类  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月27日 下午4:43:08 
 * 
 * @author 谢美团
 * @version @param <T> 
 */
public class OmdsExtend<T> extends Omds {

	private static final long serialVersionUID = 1L;
	
	private String memberGUID;
	
	private T data;

	public String getMemberGUID() {
		return memberGUID;
	}

	public void setMemberGUID(String memberGUID) {
		this.memberGUID = memberGUID;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}