package com.bithealth.dataConversionServer.enmu;

public enum CompanyConfigEnmu {
	
	COMPANY_ZLJY(1,1,1000,"合作公司-中联佳裕"),
	COMPANY_GOOD_DOCTOR(2,2,1001,"合作公司-好医生");

	private int index;
	private int source;
	private int companyCode;
	private String desc;
	
	private CompanyConfigEnmu(int index, int source, int companyCode,
			String desc) {
		this.index = index;
		this.source = source;
		this.companyCode = companyCode;
		this.desc = desc;
	}



	public static CompanyConfigEnmu getEnmuByCompanyCode(int companyCode) {
		for(CompanyConfigEnmu enmu : CompanyConfigEnmu.values()) {
			if(enmu.getCompanyCode() == companyCode) {				
				return enmu;
			}
		}
		return null;
	}



	public int getIndex() {
		return index;
	}



	public void setIndex(int index) {
		this.index = index;
	}



	public int getSource() {
		return source;
	}



	public void setSource(int source) {
		this.source = source;
	}



	public int getCompanyCode() {
		return companyCode;
	}



	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}



	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
