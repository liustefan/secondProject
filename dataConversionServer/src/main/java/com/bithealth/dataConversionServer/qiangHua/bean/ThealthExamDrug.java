package com.bithealth.dataConversionServer.qiangHua.bean;

public class ThealthExamDrug {
    private String exdGid; //数据主键

    private String exGid; //关联健康体检表数据主键

    private Integer index; //明细序号

    private String drugName;  //药物名称

    private String drugFreq; //药物使用频率

    private String drugDose; //药物使用剂量

    private String drugUsage; //药物使用途径

    private String drugTime; //用药时间

    private String medCom; //1.规律 2.间断 3.不服药

    private Integer medicalNo;
    
    /**中科汇康体检数据主键*/
    private Integer hexamid;

	public Integer getHexamid() {
		return hexamid;
	}
	public void setHexamid(Integer hexamid) {
		this.hexamid = hexamid;
	}
    

    public String getExdGid() {
        return exdGid;
    }

    public void setExdGid(String exdGid) {
        this.exdGid = exdGid;
    }

    public String getExGid() {
        return exGid;
    }

    public void setExGid(String exGid) {
        this.exGid = exGid;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugFreq() {
        return drugFreq;
    }

    public void setDrugFreq(String drugFreq) {
        this.drugFreq = drugFreq;
    }

    public String getDrugDose() {
        return drugDose;
    }

    public void setDrugDose(String drugDose) {
        this.drugDose = drugDose;
    }

    public String getDrugUsage() {
        return drugUsage;
    }

    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage;
    }

    public String getDrugTime() {
        return drugTime;
    }

    public void setDrugTime(String drugTime) {
        this.drugTime = drugTime;
    }

    public String getMedCom() {
        return medCom;
    }

    public void setMedCom(String medCom) {
        this.medCom = medCom;
    }

    public Integer getMedicalNo() {
        return medicalNo;
    }

    public void setMedicalNo(Integer medicalNo) {
        this.medicalNo = medicalNo;
    }
}