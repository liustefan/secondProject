/**
 * @PackageName:      com.bithealth.orgainCore.enmu
 * @FileName:     MemMustItemEnum.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年9月8日 下午5:30:43  
 * 
 */
package com.bithealth.orgainCore.enmu;

/**
 * 类名称: MemMustItemEnum  
 * 功能描述: 会员属性必填项枚举.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月8日 下午5:30:43 
 * 
 * @author liuhm
 * @version  
 */
public enum MemMustItemEnum {
	MemName(1, "memname", "姓名"),
	Idcard(8, "idcard", "身份证号"),
	Tel(16, "tel", "手机号"),
	Gender(2, "gender", "性别"),
	Birthday(4, "birthdate", "出生日期");

	/**
	 * 属性编号
	 */
	private int num;
	
	/**
	 * 属性
	 */
	private String field;
	
	/**
	 * 属性中文描述
	 */
	private String text;
	
	private MemMustItemEnum(int num, String field, String text) {
		this.field = field;
		this.num = num;
		this.text = text;
	}
	
	public static MemMustItemEnum get(int num) {
		for(MemMustItemEnum item : MemMustItemEnum.values()) {
			if(num == item.num) {
				return item;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @Title:checked 
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * 手机号和身份证号至少勾选一个，如果身份证未勾选时，手机号和身份证号必须都要勾选.  
	 * @author liuhm
	 * @param config
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	public static String checked(MemMustItemEnum[] enums) {
		if(enums == null || enums.length == 0) {
			return MemMustItemEnum.Idcard.getText() + "和" + MemMustItemEnum.Tel.getText() + "必须勾选一个";
		}
		boolean telChecked = false;
		boolean memNameChecked = false;
		for(MemMustItemEnum item : enums) {
			if(item == MemMustItemEnum.Idcard) {  //身份证被勾选，其他就不需要校验
				return null;
			}
			if(item == MemMustItemEnum.Tel) {
				telChecked = true;
				continue;
			}
			if(item == MemMustItemEnum.MemName) {
				memNameChecked = true;
				continue;
			}
		}
		if(!telChecked || !memNameChecked) {
			return MemMustItemEnum.Tel.getText() + "和" + MemMustItemEnum.MemName.getText() + "必须全部勾选";
		}
		
		return null;
	}

	public int getNum() {
		return num;
	}

	public String getField() {
		return field;
	}

	public String getText() {
		return text;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setText(String text) {
		this.text = text;
	}
}
