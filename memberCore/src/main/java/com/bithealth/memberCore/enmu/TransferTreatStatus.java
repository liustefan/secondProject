package com.bithealth.memberCore.enmu;

public enum TransferTreatStatus {
	ApplyTransfer(1,"转诊申请"),
	AlreadyTransfer(2,"取消转诊"),
	CancelTransfer(3,"已转诊");
	
	private int code;
	private String name;
	
	private TransferTreatStatus(int code, String name){
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static String getNameByCode(int code){
		for(TransferTreatStatus transferTreatStatus : TransferTreatStatus.values()){
			if(transferTreatStatus.getCode() == code){
				return transferTreatStatus.getName();
			}
		}
		return null;
	}
}
