package com.bithealth.dataConversionServer.qiangHua.bean;

import java.util.Date;
/*
 * T_HEALTH_RECORDS 健康档案
 * 
 */
public class ThealthRecords {
    private String hrGid;//内部主键

    private String docId;//档案编号

    private String name;//姓名

    private String sex;//性别代码

    private Date birthday;//出生日期

    //TODO private String IDC_TYPE 身份证件类别代码	 PDF有，数据库没有
    private String idcNo;//身份证件号码

    private String workUnit;//工作单位名称

    private String tel;//本人电话

    private String contact;//联系人姓名

    private String contactTel;//联系人电话

    private String residentFlag;//TODO pdf 没有  常住类型标志	1.户籍 2.非户籍

    private String nation;//民族	1.汉族 2.少数民族

    private String nationDes;//民族描述  TODO pdf 没有

    private String bloodGroup;//ABO血型	1.A型 2.B型 3.O型 4.AB型 5.不详

    private String rhType;//Rh血型	1.否 2.是 3.不详

    private String eduLevel;//文化程度	1.文盲及半文盲 2.小学 3.初中 4.高中/技校/中专 5.大学专科及以上 6.不详

    private String profession;//职业	1国家机关、党群组织、企业、事业单位负责人 2专业技术人员 3办事人员和有关人员 4商业、服务业人员 5 农、林、牧、渔、水利业生产人员 6生产、运输设备操作人员及有关人员 7军人 8不便分类的其他从业人员

    private String marStatus;//婚姻状况	1未婚 2 已婚 3丧偶 4离婚 5未说明的婚姻状况

    private String payType;//医疗费用支付方式	1城镇职工基本医疗保险 2城镇居民基本医疗保险 3新型农村合作医疗 4贫困救助 5商业医疗保险 6全公费 7全自费 8其他

    private String payType2;//医疗费用支付方式2	1城镇职工基本医疗保险 2城镇居民基本医疗保险 3新型农村合作医疗 4贫困救助 5商业医疗保险 6全公费 7全自费 8其他

    private String payType3;//医疗费用支付方式3	1城镇职工基本医疗保险 2城镇居民基本医疗保险 3新型农村合作医疗 4贫困救助 5商业医疗保险 6全公费 7全自费 8其他

    private String othPayType;//其他医疗费用支付方式

    private String drugAllergy;//药物过敏源1	1无 2青霉素 3磺胺 4链霉素 5其他

    private String drugAllergy2;//药物过敏源2	1无 2青霉素 3磺胺 4链霉素 5其他

    private String drugAllergy3;//药物过敏源3	1无 2青霉素 3磺胺 4链霉素 5其他

    private String drugAllergy4;//药物过敏源4	1无 2青霉素 3磺胺 4链霉素 5其他

    private String othDrugAllergy;//其他药物过敏源

    private String exposure;//暴露史1	1无 2化学品 3毒物 4射线

    private String exposure2;//暴露史2	1无 2化学品 3毒物 4射线

    private String exposure3;//暴露史3	1无 2化学品 3毒物 4射线

    //31--46 表中没有
    
    private String surgeryFlag;//TODO

    private String surgery;//SURGERY	1无 2有

    private Date surDate;//手术日期

    private String surgery2;//手术史2

    private Date surDate2;//手术日期2

    private String traumaFlag;//TODO

    private String trauma;//外伤史	1无 2有

    private Date traDate;//外伤日期

    private String trauma2;//外伤史2

    private Date traDate2;//外伤日期2

    private String traBloodFlag;//TODO

    private String traBlood;//输血原因

    private Date tbDate;//输血日期

    private String traBlood2;//输血原因2

    private Date tbDate2;//输血日期2

    private String fhFather;//家族史-父	1无 2高血压 3糖尿病 4冠心病 5慢性阻塞性肺疾病 6恶性肿瘤 7脑卒中 8重性精神疾病 9结核病 10肝炎 11先天畸形 12其他

    private String fhFather2;//家族史-父2

    private String fhFather3;//家族史-父3

    private String fhFather4;//家族史-父4

    private String fhFather5;//家族史-父5

    private String fhFather6;//家族史-父6

    private String fhFatherOth;//家族史-父其他

    private String fhMather;//家族史-母	1无 2高血压 3糖尿病 4冠心病 5慢性阻塞性肺疾病 6恶性肿瘤 7脑卒中 8重性精神疾病 9结核病 10肝炎 11先天畸形 12其他

    private String fhMather2;//

    private String fhMather3;//

    private String fhMather4;//

    private String fhMather5;//

    private String fhMather6;//

    private String fhMatherOth;//家族史-母其他

    private String fhBs;//家族史-兄弟姐妹	1无 2高血压 3糖尿病 4冠心病 5慢性阻塞性肺疾病 6恶性肿瘤 7脑卒中 8重性精神疾病 9结核病 10肝炎 11先天畸形 12其他

    private String fhBs2;//

    private String fhBs3;//

    private String fhBs4;//

    private String fhBs5;//

    private String fhBs6;//

    private String fhBsOth;//家族史-兄弟姐妹其他

    private String fhChild;//家族史-子女	1无 2高血压 3糖尿病 4冠心病 5慢性阻塞性肺疾病 6恶性肿瘤 7脑卒中 8重性精神疾病 9结核病 10肝炎 11先天畸形 12其他

    private String fhChild2;//

    private String fhChild3;//

    private String fhChild4;//

    private String fhChild5;//

    private String fhChild6;//

    private String fhChildOth;//家族史-子女其他

    private String genDiseasesFlag;//TODO

    private String genDiseases;//遗传病史	1无 2有

    private String disability;//残疾情况	1无残疾 2视力残疾 3听力残疾 4言语残疾 5肢体残疾6智力残疾 7精神残疾 8其他残疾

    private String disability2;//

    private String disability3;//

    private String disability4;//

    private String disability5;//

    private String disability6;//

    private String disabilityOth;//其他残疾情况

    private String kicExhaust;//厨房排风设施	1无 2油烟机 3换气扇 4烟囱

    private String fuel;//燃料类型	1液化气 2煤 3天然气 4沼气 5柴火 6其他

    private String driWater;//家庭饮水类别	1自来水 2经净化过滤的水 3井水 4河湖水 5塘水 6其他

    private String toilet;//厕所类别	1卫生厕所 2一格或二格粪池式 3马桶 4露天粪坑 5简易棚厕

    private String livestock;//禽畜栏类别	1.单设 2.室内 3.室外

    private String creOrg;//建档机构

    private String creUser;//建档人

    private Date creDate;//建档日期

    private String updUser;//更新人

    private Date updDate;//更新日期

    private String dataFlag;//数据标识	0无更新 1有更新 （该字段按业务分）

    private Integer archiveId;//

    public String getHrGid() {
        return hrGid;
    }

    public void setHrGid(String hrGid) {
        this.hrGid = hrGid;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdcNo() {
        return idcNo;
    }

    public void setIdcNo(String idcNo) {
        this.idcNo = idcNo;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getResidentFlag() {
        return residentFlag;
    }

    public void setResidentFlag(String residentFlag) {
        this.residentFlag = residentFlag;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNationDes() {
        return nationDes;
    }

    public void setNationDes(String nationDes) {
        this.nationDes = nationDes;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getRhType() {
        return rhType;
    }

    public void setRhType(String rhType) {
        this.rhType = rhType;
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getMarStatus() {
        return marStatus;
    }

    public void setMarStatus(String marStatus) {
        this.marStatus = marStatus;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayType2() {
        return payType2;
    }

    public void setPayType2(String payType2) {
        this.payType2 = payType2;
    }

    public String getPayType3() {
        return payType3;
    }

    public void setPayType3(String payType3) {
        this.payType3 = payType3;
    }

    public String getOthPayType() {
        return othPayType;
    }

    public void setOthPayType(String othPayType) {
        this.othPayType = othPayType;
    }

    public String getDrugAllergy() {
        return drugAllergy;
    }

    public void setDrugAllergy(String drugAllergy) {
        this.drugAllergy = drugAllergy;
    }

    public String getDrugAllergy2() {
        return drugAllergy2;
    }

    public void setDrugAllergy2(String drugAllergy2) {
        this.drugAllergy2 = drugAllergy2;
    }

    public String getDrugAllergy3() {
        return drugAllergy3;
    }

    public void setDrugAllergy3(String drugAllergy3) {
        this.drugAllergy3 = drugAllergy3;
    }

    public String getDrugAllergy4() {
        return drugAllergy4;
    }

    public void setDrugAllergy4(String drugAllergy4) {
        this.drugAllergy4 = drugAllergy4;
    }

    public String getOthDrugAllergy() {
        return othDrugAllergy;
    }

    public void setOthDrugAllergy(String othDrugAllergy) {
        this.othDrugAllergy = othDrugAllergy;
    }

    public String getExposure() {
        return exposure;
    }

    public void setExposure(String exposure) {
        this.exposure = exposure;
    }

    public String getExposure2() {
        return exposure2;
    }

    public void setExposure2(String exposure2) {
        this.exposure2 = exposure2;
    }

    public String getExposure3() {
        return exposure3;
    }

    public void setExposure3(String exposure3) {
        this.exposure3 = exposure3;
    }

    public String getSurgeryFlag() {
        return surgeryFlag;
    }

    public void setSurgeryFlag(String surgeryFlag) {
        this.surgeryFlag = surgeryFlag;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }

    public Date getSurDate() {
        return surDate;
    }

    public void setSurDate(Date surDate) {
        this.surDate = surDate;
    }

    public String getSurgery2() {
        return surgery2;
    }

    public void setSurgery2(String surgery2) {
        this.surgery2 = surgery2;
    }

    public Date getSurDate2() {
        return surDate2;
    }

    public void setSurDate2(Date surDate2) {
        this.surDate2 = surDate2;
    }

    public String getTraumaFlag() {
        return traumaFlag;
    }

    public void setTraumaFlag(String traumaFlag) {
        this.traumaFlag = traumaFlag;
    }

    public String getTrauma() {
        return trauma;
    }

    public void setTrauma(String trauma) {
        this.trauma = trauma;
    }

    public Date getTraDate() {
        return traDate;
    }

    public void setTraDate(Date traDate) {
        this.traDate = traDate;
    }

    public String getTrauma2() {
        return trauma2;
    }

    public void setTrauma2(String trauma2) {
        this.trauma2 = trauma2;
    }

    public Date getTraDate2() {
        return traDate2;
    }

    public void setTraDate2(Date traDate2) {
        this.traDate2 = traDate2;
    }

    public String getTraBloodFlag() {
        return traBloodFlag;
    }

    public void setTraBloodFlag(String traBloodFlag) {
        this.traBloodFlag = traBloodFlag;
    }

    public String getTraBlood() {
        return traBlood;
    }

    public void setTraBlood(String traBlood) {
        this.traBlood = traBlood;
    }

    public Date getTbDate() {
        return tbDate;
    }

    public void setTbDate(Date tbDate) {
        this.tbDate = tbDate;
    }

    public String getTraBlood2() {
        return traBlood2;
    }

    public void setTraBlood2(String traBlood2) {
        this.traBlood2 = traBlood2;
    }

    public Date getTbDate2() {
        return tbDate2;
    }

    public void setTbDate2(Date tbDate2) {
        this.tbDate2 = tbDate2;
    }

    public String getFhFather() {
        return fhFather;
    }

    public void setFhFather(String fhFather) {
        this.fhFather = fhFather;
    }

    public String getFhFather2() {
        return fhFather2;
    }

    public void setFhFather2(String fhFather2) {
        this.fhFather2 = fhFather2;
    }

    public String getFhFather3() {
        return fhFather3;
    }

    public void setFhFather3(String fhFather3) {
        this.fhFather3 = fhFather3;
    }

    public String getFhFather4() {
        return fhFather4;
    }

    public void setFhFather4(String fhFather4) {
        this.fhFather4 = fhFather4;
    }

    public String getFhFather5() {
        return fhFather5;
    }

    public void setFhFather5(String fhFather5) {
        this.fhFather5 = fhFather5;
    }

    public String getFhFather6() {
        return fhFather6;
    }

    public void setFhFather6(String fhFather6) {
        this.fhFather6 = fhFather6;
    }

    public String getFhFatherOth() {
        return fhFatherOth;
    }

    public void setFhFatherOth(String fhFatherOth) {
        this.fhFatherOth = fhFatherOth;
    }

    public String getFhMather() {
        return fhMather;
    }

    public void setFhMather(String fhMather) {
        this.fhMather = fhMather;
    }

    public String getFhMather2() {
        return fhMather2;
    }

    public void setFhMather2(String fhMather2) {
        this.fhMather2 = fhMather2;
    }

    public String getFhMather3() {
        return fhMather3;
    }

    public void setFhMather3(String fhMather3) {
        this.fhMather3 = fhMather3;
    }

    public String getFhMather4() {
        return fhMather4;
    }

    public void setFhMather4(String fhMather4) {
        this.fhMather4 = fhMather4;
    }

    public String getFhMather5() {
        return fhMather5;
    }

    public void setFhMather5(String fhMather5) {
        this.fhMather5 = fhMather5;
    }

    public String getFhMather6() {
        return fhMather6;
    }

    public void setFhMather6(String fhMather6) {
        this.fhMather6 = fhMather6;
    }

    public String getFhMatherOth() {
        return fhMatherOth;
    }

    public void setFhMatherOth(String fhMatherOth) {
        this.fhMatherOth = fhMatherOth;
    }

    public String getFhBs() {
        return fhBs;
    }

    public void setFhBs(String fhBs) {
        this.fhBs = fhBs;
    }

    public String getFhBs2() {
        return fhBs2;
    }

    public void setFhBs2(String fhBs2) {
        this.fhBs2 = fhBs2;
    }

    public String getFhBs3() {
        return fhBs3;
    }

    public void setFhBs3(String fhBs3) {
        this.fhBs3 = fhBs3;
    }

    public String getFhBs4() {
        return fhBs4;
    }

    public void setFhBs4(String fhBs4) {
        this.fhBs4 = fhBs4;
    }

    public String getFhBs5() {
        return fhBs5;
    }

    public void setFhBs5(String fhBs5) {
        this.fhBs5 = fhBs5;
    }

    public String getFhBs6() {
        return fhBs6;
    }

    public void setFhBs6(String fhBs6) {
        this.fhBs6 = fhBs6;
    }

    public String getFhBsOth() {
        return fhBsOth;
    }

    public void setFhBsOth(String fhBsOth) {
        this.fhBsOth = fhBsOth;
    }

    public String getFhChild() {
        return fhChild;
    }

    public void setFhChild(String fhChild) {
        this.fhChild = fhChild;
    }

    public String getFhChild2() {
        return fhChild2;
    }

    public void setFhChild2(String fhChild2) {
        this.fhChild2 = fhChild2;
    }

    public String getFhChild3() {
        return fhChild3;
    }

    public void setFhChild3(String fhChild3) {
        this.fhChild3 = fhChild3;
    }

    public String getFhChild4() {
        return fhChild4;
    }

    public void setFhChild4(String fhChild4) {
        this.fhChild4 = fhChild4;
    }

    public String getFhChild5() {
        return fhChild5;
    }

    public void setFhChild5(String fhChild5) {
        this.fhChild5 = fhChild5;
    }

    public String getFhChild6() {
        return fhChild6;
    }

    public void setFhChild6(String fhChild6) {
        this.fhChild6 = fhChild6;
    }

    public String getFhChildOth() {
        return fhChildOth;
    }

    public void setFhChildOth(String fhChildOth) {
        this.fhChildOth = fhChildOth;
    }

    public String getGenDiseasesFlag() {
        return genDiseasesFlag;
    }

    public void setGenDiseasesFlag(String genDiseasesFlag) {
        this.genDiseasesFlag = genDiseasesFlag;
    }

    public String getGenDiseases() {
        return genDiseases;
    }

    public void setGenDiseases(String genDiseases) {
        this.genDiseases = genDiseases;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getDisability2() {
        return disability2;
    }

    public void setDisability2(String disability2) {
        this.disability2 = disability2;
    }

    public String getDisability3() {
        return disability3;
    }

    public void setDisability3(String disability3) {
        this.disability3 = disability3;
    }

    public String getDisability4() {
        return disability4;
    }

    public void setDisability4(String disability4) {
        this.disability4 = disability4;
    }

    public String getDisability5() {
        return disability5;
    }

    public void setDisability5(String disability5) {
        this.disability5 = disability5;
    }

    public String getDisability6() {
        return disability6;
    }

    public void setDisability6(String disability6) {
        this.disability6 = disability6;
    }

    public String getDisabilityOth() {
        return disabilityOth;
    }

    public void setDisabilityOth(String disabilityOth) {
        this.disabilityOth = disabilityOth;
    }

    public String getKicExhaust() {
        return kicExhaust;
    }

    public void setKicExhaust(String kicExhaust) {
        this.kicExhaust = kicExhaust;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getDriWater() {
        return driWater;
    }

    public void setDriWater(String driWater) {
        this.driWater = driWater;
    }

    public String getToilet() {
        return toilet;
    }

    public void setToilet(String toilet) {
        this.toilet = toilet;
    }

    public String getLivestock() {
        return livestock;
    }

    public void setLivestock(String livestock) {
        this.livestock = livestock;
    }

    public String getCreOrg() {
        return creOrg;
    }

    public void setCreOrg(String creOrg) {
        this.creOrg = creOrg;
    }

    public String getCreUser() {
        return creUser;
    }

    public void setCreUser(String creUser) {
        this.creUser = creUser;
    }

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
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

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }
}