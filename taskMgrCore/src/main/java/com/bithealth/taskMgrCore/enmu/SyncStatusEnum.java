package com.bithealth.taskMgrCore.enmu;


/**
 * 类名称: SyncStatusEnum  
 * 功能描述: 同步状态枚举 
 * 日期: 2016年12月21日 上午10:43:41 
 * 
 * @author 谢美团
 * @version  
 */
public enum SyncStatusEnum {
	
	TO_BE_SYNC(new Integer(1).byteValue(), "待同步"),
	SYNCING(new Integer(2).byteValue(), "同步中"),
	SYNC_SUCCESS(new Integer(3).byteValue(), "同步成功"),
	SYNC_FAIL(new Integer(4).byteValue(), "同步失败");
	
	private Byte code;
	
	private String desc;

	public Byte getCode() {
		return code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private SyncStatusEnum(Byte code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static SyncStatusEnum getAccountType(Byte type) {
		for(SyncStatusEnum accountType : SyncStatusEnum.values()) {
			if(accountType.getCode() == type) {
				return accountType;
			}
		}
		return null;
	}
	
}
