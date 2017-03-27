package com.bithealth.dataConversionServer.qiangHua.bean;

import java.math.BigDecimal;
import java.util.Date;
/*
 * 糖尿病随访
 */
public class TdiabetesVisits {
    private String diabGid; //数据主键

    private String hrGid;//档案内部主键 健康档案号

    private String diabId;//记录单编号

    private String docId;//档案编号

    private String name;//姓名

    private Date visDate;//访视日期

    private Date nexVisDate;//下次访视日期

    private String visDoctor;//随访医生

    private String resDoctor;//责任医师

    private String visitsSrt;//随访方式  1.门诊2.家庭3.电话

    private String symptom;//症状  1.无症状 2.多饮 3.多食 4.多尿 5.视力模糊 6.感染 7.手脚麻木 8.下肢浮肿9. 体重明显下降

    private String symptom2;//症状2

    private String symptom3;//症状3

    private String symptom4;//症状4

    private String symptom5;//症状5

    private String symptom6;//症状6

    private String symptom7;//症状7

    private String symptom8;//症状8

    private String symptomOth;//其他症状

    private Short systolicPre;//收缩压 单位为mmHg

    private Short diastolicPre;//舒张压 单位为mmHg

    private BigDecimal height;//身高  单位为cm

    private BigDecimal weight;//体重 单位为kg

    private BigDecimal tarWeight;//目标体重

    private BigDecimal bmi;//体质指数

    private BigDecimal tarBmi;//目标体质指数

    private String dorPedPul;//足背动脉搏动  1 .未触及2 .触及

    private String posSignsOth;//其他阳性体征

    private Short daoSmoking;//日吸烟量  单位为支

    private Short traDaoSmoking;//目标日吸烟量  单位为岁

    private Short alcConsumption;//日饮酒量  单位为两

    private Short traAlcCon;//目标日饮酒量  单位为两

    private String exeFrequency;//运动频率  单位为次/周

    private String traExeFrequency;//目标运动频率   单位为次/周

    private Short exeDuration;//运动时长  单位为min/次

    private Short traExeDuration; //目标运动时长 单位为min/次

    private Short daoStaFood;//日主食量	单位为g

    private Short traDaoStaFood;//目标日主食量	单位为g

    private String psyAdjEva;//心理调整评价	1.良好 2.一般 3.差

    private String comBehEva;//遵医行为评价	1.良好 2.一般 3.差

    private BigDecimal glu;//空腹血糖	单位为mmol/L

    private BigDecimal glyHem;//糖化血红蛋白	单位为%

    private Date exDate;//检查日期

    private String labExamRes;//辅助检查结果

    private String medCom;//服药依从性	1.规律 2.间断 3.不服药

    private String advDrugRea;//药物不良反应	1.无 2.有

    private String advDrugReaDes;//不良反应描述

    private String lbsRea;//低血糖反应	1.无 2.偶尔 3.频繁

    private String visitsEva;//随访评价	1.控制满意 2.控制不满意 3.不良反应 4.并发症

    private String drugName;//药物名称

    private String drugFreq;//频率

    private BigDecimal drugDose;//剂量

    private String drugDoseUnit;// TODO

    private String drugName2;//药物名称2

    private String drugFreq2;//频率21

    private BigDecimal drugDose2;//剂量2

    private String drugDoseUnit2;//	TODO

    private String drugName3;//药物名称3

    private String drugFreq3;//频率3

    private BigDecimal drugDose3;//剂量3

    private String drugDoseUnit3;//TODO

    private String insulin;//胰岛素种类

    private String insulinFreq;//胰岛素频率

    private BigDecimal insulinDose;//胰岛素剂量	单位为U

    private String insulinDoseUnit;//TODO

    private String refIns;//转入机构名称

    private String refDes;//转诊原因

    private String refDept;//转入科室

    private String regOrg;//随访机构

    private String recUser;//记录人

    private Date recDate;//记录日期

    private String updUser;//更新人

    private Date updDate;//更新日期

    private String dataFlag;//数据标识	0无更新 1有更新 （该字段按业务分）

    private Integer followupNo;//TODO

    private Integer archiveId;//TODO

    public String getDiabGid() {
        return diabGid;
    }

    public void setDiabGid(String diabGid) {
        this.diabGid = diabGid;
    }

    public String getHrGid() {
        return hrGid;
    }

    public void setHrGid(String hrGid) {
        this.hrGid = hrGid;
    }

    public String getDiabId() {
        return diabId;
    }

    public void setDiabId(String diabId) {
        this.diabId = diabId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getVisDate() {
        return visDate;
    }

    public void setVisDate(Date visDate) {
        this.visDate = visDate;
    }

    public Date getNexVisDate() {
        return nexVisDate;
    }

    public void setNexVisDate(Date nexVisDate) {
        this.nexVisDate = nexVisDate;
    }

    public String getVisDoctor() {
        return visDoctor;
    }

    public void setVisDoctor(String visDoctor) {
        this.visDoctor = visDoctor;
    }

    public String getResDoctor() {
        return resDoctor;
    }

    public void setResDoctor(String resDoctor) {
        this.resDoctor = resDoctor;
    }

    public String getVisitsSrt() {
        return visitsSrt;
    }

    public void setVisitsSrt(String visitsSrt) {
        this.visitsSrt = visitsSrt;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getSymptom2() {
        return symptom2;
    }

    public void setSymptom2(String symptom2) {
        this.symptom2 = symptom2;
    }

    public String getSymptom3() {
        return symptom3;
    }

    public void setSymptom3(String symptom3) {
        this.symptom3 = symptom3;
    }

    public String getSymptom4() {
        return symptom4;
    }

    public void setSymptom4(String symptom4) {
        this.symptom4 = symptom4;
    }

    public String getSymptom5() {
        return symptom5;
    }

    public void setSymptom5(String symptom5) {
        this.symptom5 = symptom5;
    }

    public String getSymptom6() {
        return symptom6;
    }

    public void setSymptom6(String symptom6) {
        this.symptom6 = symptom6;
    }

    public String getSymptom7() {
        return symptom7;
    }

    public void setSymptom7(String symptom7) {
        this.symptom7 = symptom7;
    }

    public String getSymptom8() {
        return symptom8;
    }

    public void setSymptom8(String symptom8) {
        this.symptom8 = symptom8;
    }

    public String getSymptomOth() {
        return symptomOth;
    }

    public void setSymptomOth(String symptomOth) {
        this.symptomOth = symptomOth;
    }

    public Short getSystolicPre() {
        return systolicPre;
    }

    public void setSystolicPre(Short systolicPre) {
        this.systolicPre = systolicPre;
    }

    public Short getDiastolicPre() {
        return diastolicPre;
    }

    public void setDiastolicPre(Short diastolicPre) {
        this.diastolicPre = diastolicPre;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getTarWeight() {
        return tarWeight;
    }

    public void setTarWeight(BigDecimal tarWeight) {
        this.tarWeight = tarWeight;
    }

    public BigDecimal getBmi() {
        return bmi;
    }

    public void setBmi(BigDecimal bmi) {
        this.bmi = bmi;
    }

    public BigDecimal getTarBmi() {
        return tarBmi;
    }

    public void setTarBmi(BigDecimal tarBmi) {
        this.tarBmi = tarBmi;
    }

    public String getDorPedPul() {
        return dorPedPul;
    }

    public void setDorPedPul(String dorPedPul) {
        this.dorPedPul = dorPedPul;
    }

    public String getPosSignsOth() {
        return posSignsOth;
    }

    public void setPosSignsOth(String posSignsOth) {
        this.posSignsOth = posSignsOth;
    }

    public Short getDaoSmoking() {
        return daoSmoking;
    }

    public void setDaoSmoking(Short daoSmoking) {
        this.daoSmoking = daoSmoking;
    }

    public Short getTraDaoSmoking() {
        return traDaoSmoking;
    }

    public void setTraDaoSmoking(Short traDaoSmoking) {
        this.traDaoSmoking = traDaoSmoking;
    }

    public Short getAlcConsumption() {
        return alcConsumption;
    }

    public void setAlcConsumption(Short alcConsumption) {
        this.alcConsumption = alcConsumption;
    }

    public Short getTraAlcCon() {
        return traAlcCon;
    }

    public void setTraAlcCon(Short traAlcCon) {
        this.traAlcCon = traAlcCon;
    }

    public String getExeFrequency() {
        return exeFrequency;
    }

    public void setExeFrequency(String exeFrequency) {
        this.exeFrequency = exeFrequency;
    }

    public String getTraExeFrequency() {
        return traExeFrequency;
    }

    public void setTraExeFrequency(String traExeFrequency) {
        this.traExeFrequency = traExeFrequency;
    }

    public Short getExeDuration() {
        return exeDuration;
    }

    public void setExeDuration(Short exeDuration) {
        this.exeDuration = exeDuration;
    }

    public Short getTraExeDuration() {
        return traExeDuration;
    }

    public void setTraExeDuration(Short traExeDuration) {
        this.traExeDuration = traExeDuration;
    }

    public Short getDaoStaFood() {
        return daoStaFood;
    }

    public void setDaoStaFood(Short daoStaFood) {
        this.daoStaFood = daoStaFood;
    }

    public Short getTraDaoStaFood() {
        return traDaoStaFood;
    }

    public void setTraDaoStaFood(Short traDaoStaFood) {
        this.traDaoStaFood = traDaoStaFood;
    }

    public String getPsyAdjEva() {
        return psyAdjEva;
    }

    public void setPsyAdjEva(String psyAdjEva) {
        this.psyAdjEva = psyAdjEva;
    }

    public String getComBehEva() {
        return comBehEva;
    }

    public void setComBehEva(String comBehEva) {
        this.comBehEva = comBehEva;
    }

    public BigDecimal getGlu() {
        return glu;
    }

    public void setGlu(BigDecimal glu) {
        this.glu = glu;
    }

    public BigDecimal getGlyHem() {
        return glyHem;
    }

    public void setGlyHem(BigDecimal glyHem) {
        this.glyHem = glyHem;
    }

    public Date getExDate() {
        return exDate;
    }

    public void setExDate(Date exDate) {
        this.exDate = exDate;
    }

    public String getLabExamRes() {
        return labExamRes;
    }

    public void setLabExamRes(String labExamRes) {
        this.labExamRes = labExamRes;
    }

    public String getMedCom() {
        return medCom;
    }

    public void setMedCom(String medCom) {
        this.medCom = medCom;
    }

    public String getAdvDrugRea() {
        return advDrugRea;
    }

    public void setAdvDrugRea(String advDrugRea) {
        this.advDrugRea = advDrugRea;
    }

    public String getAdvDrugReaDes() {
        return advDrugReaDes;
    }

    public void setAdvDrugReaDes(String advDrugReaDes) {
        this.advDrugReaDes = advDrugReaDes;
    }

    public String getLbsRea() {
        return lbsRea;
    }

    public void setLbsRea(String lbsRea) {
        this.lbsRea = lbsRea;
    }

    public String getVisitsEva() {
        return visitsEva;
    }

    public void setVisitsEva(String visitsEva) {
        this.visitsEva = visitsEva;
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

    public BigDecimal getDrugDose() {
        return drugDose;
    }

    public void setDrugDose(BigDecimal drugDose) {
        this.drugDose = drugDose;
    }

    public String getDrugDoseUnit() {
        return drugDoseUnit;
    }

    public void setDrugDoseUnit(String drugDoseUnit) {
        this.drugDoseUnit = drugDoseUnit;
    }

    public String getDrugName2() {
        return drugName2;
    }

    public void setDrugName2(String drugName2) {
        this.drugName2 = drugName2;
    }

    public String getDrugFreq2() {
        return drugFreq2;
    }

    public void setDrugFreq2(String drugFreq2) {
        this.drugFreq2 = drugFreq2;
    }

    public BigDecimal getDrugDose2() {
        return drugDose2;
    }

    public void setDrugDose2(BigDecimal drugDose2) {
        this.drugDose2 = drugDose2;
    }

    public String getDrugDoseUnit2() {
        return drugDoseUnit2;
    }

    public void setDrugDoseUnit2(String drugDoseUnit2) {
        this.drugDoseUnit2 = drugDoseUnit2;
    }

    public String getDrugName3() {
        return drugName3;
    }

    public void setDrugName3(String drugName3) {
        this.drugName3 = drugName3;
    }

    public String getDrugFreq3() {
        return drugFreq3;
    }

    public void setDrugFreq3(String drugFreq3) {
        this.drugFreq3 = drugFreq3;
    }

    public BigDecimal getDrugDose3() {
        return drugDose3;
    }

    public void setDrugDose3(BigDecimal drugDose3) {
        this.drugDose3 = drugDose3;
    }

    public String getDrugDoseUnit3() {
        return drugDoseUnit3;
    }

    public void setDrugDoseUnit3(String drugDoseUnit3) {
        this.drugDoseUnit3 = drugDoseUnit3;
    }

    public String getInsulin() {
        return insulin;
    }

    public void setInsulin(String insulin) {
        this.insulin = insulin;
    }

    public String getInsulinFreq() {
        return insulinFreq;
    }

    public void setInsulinFreq(String insulinFreq) {
        this.insulinFreq = insulinFreq;
    }

    public BigDecimal getInsulinDose() {
        return insulinDose;
    }

    public void setInsulinDose(BigDecimal insulinDose) {
        this.insulinDose = insulinDose;
    }

    public String getInsulinDoseUnit() {
        return insulinDoseUnit;
    }

    public void setInsulinDoseUnit(String insulinDoseUnit) {
        this.insulinDoseUnit = insulinDoseUnit;
    }

    public String getRefIns() {
        return refIns;
    }

    public void setRefIns(String refIns) {
        this.refIns = refIns;
    }

    public String getRefDes() {
        return refDes;
    }

    public void setRefDes(String refDes) {
        this.refDes = refDes;
    }

    public String getRefDept() {
        return refDept;
    }

    public void setRefDept(String refDept) {
        this.refDept = refDept;
    }

    public String getRegOrg() {
        return regOrg;
    }

    public void setRegOrg(String regOrg) {
        this.regOrg = regOrg;
    }

    public String getRecUser() {
        return recUser;
    }

    public void setRecUser(String recUser) {
        this.recUser = recUser;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public String getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
    }

    public Integer getFollowupNo() {
        return followupNo;
    }

    public void setFollowupNo(Integer followupNo) {
        this.followupNo = followupNo;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }
}