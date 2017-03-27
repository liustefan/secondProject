package com.bithealth.memberCore.enmu;

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
	
	TEL(new Integer(1).shortValue(), "手机号"),
	EMAIL(new Integer(2).shortValue(), "邮箱"),
	IDCARD(new Integer(3).shortValue(), "身份证号"),
	OTHER(new Integer(4).shortValue(), "其他");
	
	private Short type;
	
	private String text;
	
	private AccountTypeEnum(Short type, String text) {
		this.type = type;
		this.text = text;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
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
