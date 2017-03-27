package com.bithealth.ucCore.facade.enmu;

/**
 * 
 * 类名称: AccountTypeEnum  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月30日 下午1:49:01 
 * 
 * @author liuhm
 * @version
 */
public enum AccountTypeEnum {
	
	TEL(new Integer(1).byteValue(), "手机号"),
	EMAIL(new Integer(2).byteValue(), "邮箱"),
	IDCARD(new Integer(3).byteValue(), "身份证号"),
	OTHER(new Integer(4).byteValue(), "其他");
	
	private Byte type;
	
	private String text;
	
	private AccountTypeEnum(Byte type, String text) {
		this.type = type;
		this.text = text;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static AccountTypeEnum getAccountType(Short type) {
		for(AccountTypeEnum accountType : AccountTypeEnum.values()) {
			if(accountType.getType().shortValue() == type.shortValue()) {
				return accountType;
			}
		}
		return OTHER;
	}
	
}
