/*
 * PhHealthexamdetail.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-27 Created
 */
package com.bithealth.inspectCore.physical.model;

import java.math.BigDecimal;

import com.bithealth.inspectCore.model.DictEntity;

/**
 * 公共卫生_健康体检明细表
 * 
 * @author ${user}
 * @version 1.0 2016-06-27
 */
public class PhHealthexamdetail extends DictEntity {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 649864846509195796L;
	/**
     * 体检主ID，引用ph_healthexam
     */
    private Long HExamID;
    /**
     * 症状_列表(以@#拼接)，来源ph_dictitem
     */
    private String symptom;
    /**
     * 症状_其他描述
     */
    private String symptom_Desc;
    /**
     * 一般状况_体温(℃)
     */
    private BigDecimal bodyTemperature;
    /**
     * 一般状况_脉率(次/min)
     */
    private Short pulseRate;
    /**
     * 一般状况_呼吸频率(次/min)
     */
    private Short respiratoryRate;
    /**
     * 一般状况_左收缩压(mmHg)
     */
    private Short leftSystolic;
    /**
     * 一般状况_左舒张压(mmHg)
     */
    private Short leftDiastolic;
    /**
     * 一般状况_右收缩压(mmHg)
     */
    private Short rightSystolic;
    /**
     * 一般状况_右舒张压(mmHg)
     */
    private Short rightDiastolic;
    /**
     * 一般状况_身高(cm)
     */
    private BigDecimal height;
    /**
     * 一般状况_当前体重(kg)
     */
    private BigDecimal weight;
    /**
     * 一般状况_腰围(cm)
     */
    private BigDecimal waist;
    /**
     * 一般状况_体质指数
     */
    private BigDecimal BMI;
    /**
     * 一般状况_老年人健康状态自我评估，来源ph_dictitem
     */
    private Byte agedHealthEvaluate;
    /**
     * 一般状况_老年人生活自理能力自我评估，来源ph_dictitem
     */
    private Byte agedLifeEvaluate;
    /**
     * 一般状况_老年人认知功能，来源ph_dictitem
     */
    private Byte agedCognition;
    /**
     * 一般状况_老年人认知功能_总分
     */
    private Byte agedCognitionScore;
    /**
     * 一般状况_老年人情感状态，来源ph_dictitem
     */
    private Byte agedFeeling;
    /**
     * 一般状况_老年人情感状态_总分
     */
    private Byte agedFeelingScore;
    /**
     * 生活方式指导_运动频率，来源ph_dictitem
     */
    private Byte sportFrequency;
    /**
     * 生活方式指导_每次锻炼时间(分钟/次)
     */
    private Short sportDuration;
    /**
     * 生活方式指导_坚持锻炼时间(年)
     */
    private Byte sportTotalTime;
    /**
     * 生活方式指导_锻炼方式
     */
    private String sportWay;
    /**
     * 生活方式指导_饮食习惯_列表(以@#拼接)，来源ph_dictitem
     */
    private String eatingHabits;
    /**
     * 生活方式指导_吸烟状况，来源ph_dictitem
     */
    private Byte smokingState;
    /**
     * 生活方式指导_日吸烟量(支)
     */
    private Short dailySmoking;
    /**
     * 生活方式指导_开始吸烟年龄(岁)
     */
    private Byte smokingStartAge;
    /**
     * 生活方式指导_戒烟年龄(岁)
     */
    private Byte smokingEndAge;
    /**
     * 生活方式指导_饮酒频率，来源ph_dictitem
     */
    private Byte drinkFrequency;
    /**
     * 生活方式指导_日饮酒量(两)
     */
    private BigDecimal dailyDrink;
    /**
     * 生活方式指导_是否戒酒，来源ph_dictitem
     */
    private Byte isAbstinence;
    /**
     * 生活方式指导_戒酒(岁)
     */
    private Byte abstinenceAge;
    /**
     * 生活方式指导_开始饮酒年龄(岁)
     */
    private Byte drinkStartAge;
    /**
     * 生活方式指导_近一年内是否曾醉酒，来源ph_dictitem
     */
    private Byte isTemulenceLastYear;
    /**
     * 生活方式指导_饮酒种类_列表(以@#拼接)，来源ph_dictitem
     */
    private String drinkType;
    /**
     * 生活方式指导_其他饮酒种类描述
     */
    private String drinkOther_Desc;
    /**
     * 生活方式指导_职业病危害因素接触史，来源ph_dictitem
     */
    private Byte occupation;
    /**
     * 生活方式指导_工种
     */
    private String typeOfWork;
    /**
     * 生活方式指导_从业时间(年)
     */
    private Byte workTime;
    /**
     * 生活方式指导_粉尘
     */
    private String dust;
    /**
     * 生活方式指导_粉尘防护措施，来源ph_dictitem
     */
    private Byte dustGuard;
    /**
     * 生活方式指导_粉尘防护措施描述
     */
    private String dustGuard_Desc;
    /**
     * 生活方式指导_放射物质
     */
    private String radiogen;
    /**
     * 生活方式指导_放射物质防护措施，来源ph_dictitem
     */
    private Byte radiogenGuard;
    /**
     * 生活方式指导_放射物质防护措施描述
     */
    private String radiogenGuard_Desc;
    /**
     * 生活方式指导_物理因素
     */
    private String physical;
    /**
     * 生活方式指导_物理因素防护措施，来源ph_dictitem
     */
    private Byte physicalGuard;
    /**
     * 生活方式指导_物理因素防护措施描述
     */
    private String physicalGuard_Desc;
    /**
     * 生活方式指导_化学物质
     */
    private String chemical;
    /**
     * 生活方式指导_化学物质防护措施，来源ph_dictitem
     */
    private Byte chemicalGuard;
    /**
     * 生活方式指导_化学物质防护措施描述
     */
    private String chemicalGuard_Desc;
    /**
     * 生活方式指导_其他
     */
    private String toxicOther;
    /**
     * 生活方式指导_其他防护措施，来源ph_dictitem
     */
    private Byte toxicOtherGuard;
    /**
     * 生活方式指导_其他防护措施描述
     */
    private String toxicOtherGuard_Desc;
    /**
     * 脏器功能_口唇，来源ph_dictitem
     */
    private Byte lips;
    /**
     * 脏器功能_齿列，来源ph_dictitem
     */
    private Byte dentition;
    /**
     * 脏器功能_齿列描述
     */
    private String dentition_Desc;
    /**
     * 脏器功能_咽部，来源ph_dictitem
     */
    private Byte throat;
    /**
     * 脏器功能_左眼视力
     */
    private BigDecimal leftVision;
    /**
     * 脏器功能_右眼视力
     */
    private BigDecimal rightVision;
    /**
     * 脏器功能_左眼矫正视力
     */
    private BigDecimal leftCorrectVision;
    /**
     * 脏器功能_右眼矫正视力
     */
    private BigDecimal rightCorrectVision;
    /**
     * 脏器功能_听力，来源ph_dictitem
     */
    private Byte hearing;
    /**
     * 脏器功能_运动功能，来源ph_dictitem
     */
    private Byte movement;
    /**
     * 查体_眼底，来源ph_dictitem
     */
    private Byte eyeground;
    /**
     * 查体_眼底描述
     */
    private String eyeground_Desc;
    /**
     * 查体_皮肤，来源ph_dictitem
     */
    private Byte skin;
    /**
     * 查体_皮肤其他描述
     */
    private String skin_Desc;
    /**
     * 查体_巩膜，来源ph_dictitem
     */
    private Byte sclero;
    /**
     * 查体_巩膜其他描述
     */
    private String sclero_Desc;
    /**
     * 查体_淋巴结，来源ph_dictitem
     */
    private Byte lymph;
    /**
     * 查体_淋巴结其他描述
     */
    private String lymph_Desc;
    /**
     * 查体_肺桶状胸，来源ph_dictitem
     */
    private Byte lungBarrelChest;
    /**
     * 查体_肺呼吸音，来源ph_dictitem
     */
    private Byte lungBreathSounds;
    /**
     * 查体_肺呼吸音异常描述
     */
    private String lungBreathSounds_Desc;
    /**
     * 查体_肺罗音，来源ph_dictitem
     */
    private Byte lungRales;
    /**
     * 查体_肺罗音其他描述
     */
    private String lungRales_Desc;
    /**
     * 查体_心率(次/分钟)
     */
    private Short heartRate;
    /**
     * 查体_心律，来源ph_dictitem
     */
    private Byte rhythm;
    /**
     * 查体_杂音，来源ph_dictitem
     */
    private Byte murmur;
    /**
     * 查体_杂音描述
     */
    private String murmur_Desc;
    /**
     * 查体_腹压痛，来源ph_dictitem
     */
    private Byte pain;
    /**
     * 查体_腹压痛描述
     */
    private String pain_Desc;
    /**
     * 查体_腹包块，来源ph_dictitem
     */
    private Byte block;
    /**
     * 查体_腹包块描述
     */
    private String block_Desc;
    /**
     * 查体_腹肝大，来源ph_dictitem
     */
    private Byte hepatomegaly;
    /**
     * 查体_腹肝大描述
     */
    private String hepatomegaly_Desc;
    /**
     * 查体_腹脾大，来源ph_dictitem
     */
    private Byte splenomegaly;
    /**
     * 查体_腹脾大描述
     */
    private String splenomegaly_Desc;
    /**
     * 查体_腹移动浊音，来源ph_dictitem
     */
    private Byte moveSonant;
    /**
     * 查体_腹移动浊音描述
     */
    private String moveSonant_Desc;
    /**
     * 查体_下肢水肿，来源ph_dictitem
     */
    private Byte lowLimbEdema;
    /**
     * 查体_足背动脉搏动，来源ph_dictitem
     */
    private Byte arteriopalmus;
    /**
     * 查体_肛门指诊，来源ph_dictitem
     */
    private Byte anusTactus;
    /**
     * 查体_肛门指诊描述
     */
    private String anusTactus_Desc;
    /**
     * 查体_乳腺_列表(以@#拼接)，来源ph_dictitem
     */
    private String breast;
    /**
     * 查体_乳腺其他描述
     */
    private String breast_Desc;
    /**
     * 查体_外阴，来源ph_dictitem
     */
    private Byte pudendum;
    /**
     * 查体_外阴异常描述
     */
    private String pudendum_Desc;
    /**
     * 查体_阴道，来源ph_dictitem
     */
    private Byte vagina;
    /**
     * 查体_阴道异常描述
     */
    private String vagina_Desc;
    /**
     * 查体_宫颈，来源ph_dictitem
     */
    private Byte cervical;
    /**
     * 查体_宫颈异常描述
     */
    private String cervical_Desc;
    /**
     * 查体_宫体，来源ph_dictitem
     */
    private Byte uteri;
    /**
     * 查体_宫体异常描述
     */
    private String uteri_Desc;
    /**
     * 查体_附件，来源ph_dictitem
     */
    private Byte enclosure;
    /**
     * 查体_附件异常描述
     */
    private String enclosure_Desc;
    /**
     * 查体_妇科其他
     */
    private String gynaecologyOther;
    /**
     * 辅助检查_血红蛋白(g/L)
     */
    private Short hemoglobin;
    /**
     * 辅助检查_白细胞(10E9/L)
     */
    private BigDecimal leukocyte;
    /**
     * 辅助检查_血小板(10E9/L)
     */
    private Short platelet;
    /**
     * 辅助检查_血常规其他
     */
    private String bloodOther;
    /**
     * 辅助检查_尿蛋白
     */
    private String urineProtein;
    /**
     * 辅助检查_尿糖
     */
    private String urineSugar;
    /**
     * 辅助检查_尿酮体
     */
    private String urineAcetoneBody;
    /**
     * 辅助检查_尿潜血
     */
    private String urineOccultBlood;
    /**
     * 辅助检查_尿常规其他
     */
    private String urineOther;
    /**
     * 辅助检查_空腹血糖(mmol/L)
     */
    private BigDecimal GLU;
    /**
     * 辅助检查_餐后血糖(mmol/L)
     */
    private BigDecimal PGLU;
    /**
     * 辅助检查_心电图，来源ph_dictitem
     */
    private Byte cardiogram;
    /**
     * 辅助检查_心电图异常描述
     */
    private String cardiogram_Desc;
    /**
     * 辅助检查_尿微量白蛋白(mg/dL)
     */
    private BigDecimal urineMicroAlbumin;
    /**
     * 辅助检查_大便潜血，来源ph_dictitem
     */
    private Byte fecalOccultBlood;
    /**
     * 辅助检查_糖化血红蛋白(%)
     */
    private BigDecimal HBA1C;
    /**
     * 辅助检查_乙肝表面抗原，来源ph_dictitem
     */
    private Byte HBSAG;
    /**
     * 辅助检查_血清谷丙转氨酶(U/L)
     */
    private Short CPT;
    /**
     * 辅助检查_血清谷草转氨酶(U/L)
     */
    private Short AST;
    /**
     * 辅助检查_白蛋白(g/L)
     */
    private Short ALB;
    /**
     * 辅助检查_总胆红素(μmol/L)
     */
    private BigDecimal TBIL;
    /**
     * 辅助检查_结合胆红素(μmol/L)
     */
    private BigDecimal CBIL;
    /**
     * 辅助检查_血清肌酐(μmol/L)
     */
    private BigDecimal CR;
    /**
     * 辅助检查_血尿素氮(mmol/L)
     */
    private BigDecimal BUN;
    /**
     * 辅助检查_血钾浓度(mmol/L)
     */
    private BigDecimal serumPotassium;
    /**
     * 辅助检查_血钾浓度(mmol/L)
     */
    private BigDecimal serumSodium;
    /**
     * 辅助检查_总胆固醇(mmol/L)
     */
    private BigDecimal CHOL;
    /**
     * 辅助检查_甘油三酯(mmol/L)
     */
    private BigDecimal TG;
    /**
     * 辅助检查_血清低密度脂蛋白胆固醇(mmol/L)
     */
    private BigDecimal LDL_C;
    /**
     * 辅助检查_血清高密度脂蛋白胆固醇(mmol/L)
     */
    private BigDecimal HDL_C;
    /**
     * 辅助检查_胸部X线片，来源ph_dictitem
     */
    private Byte x_RAY;
    /**
     * 辅助检查_胸部X线片异常描述
     */
    private String x_RAY_Desc;
    /**
     * 辅助检查_B超，来源ph_dictitem
     */
    private Byte b_Ultrasonic;
    /**
     * 辅助检查_B超异常描述
     */
    private String b_Ultrasonic_Desc;
    /**
     * 辅助检查_宫颈涂片，来源ph_dictitem
     */
    private Byte cervicalSmear;
    /**
     * 辅助检查_宫颈涂片异常描述
     */
    private String cervicalSmear_Desc;
    /**
     * 辅助检查_其他描述
     */
    private String assistCheckOther;
    /**
     * 中医体质辨识_平和质_辨识结果，来源ph_dictitem
     */
    private Byte TCM_PHZ;
    /**
     * 中医体质辨识_平和质_保健指导_列表(以@#拼接)，来源ph_dictitem
     */
    private String TCM_PHZ_Guide;
    /**
     * 中医体质辨识_平和质_保健指导_其它描述
     */
    private String TCM_PHZ_Guide_Desc;
    /**
     * 中医体质辨识_气虚质_辨识结果，来源ph_dictitem
     */
    private Byte TCM_QXZ;
    /**
     * 中医体质辨识_气虚质_保健指导_列表(以@#拼接)，来源ph_dictitem
     */
    private String TCM_QXZ_Guide;
    /**
     * 中医体质辨识_气虚质_保健指导_其它描述
     */
    private String TCM_QXZ_Guide_Desc;
    /**
     * 中医体质辨识_阳虚质_辨识结果，来源ph_dictitem
     */
    private Byte TCM_YXZ;
    /**
     * 中医体质辨识_阳虚质_保健指导_列表(以@#拼接)，来源ph_dictitem
     */
    private String TCM_YXZ_Guide;
    /**
     * 中医体质辨识_阳虚质_保健指导_其它描述
     */
    private String TCM_YXZ_Guide_Desc;
    /**
     * 中医体质辨识_阴虚质_辨识结果，来源ph_dictitem
     */
    private Byte TCM_YIXZ;
    /**
     * 中医体质辨识_阴虚质_保健指导_列表(以@#拼接)，来源ph_dictitem
     */
    private String TCM_YIXZ_Guide;
    /**
     * 中医体质辨识_阴虚质_保健指导_其它描述
     */
    private String TCM_YIXZ_Guide_Desc;
    /**
     * 中医体质辨识_痰湿质_辨识结果，来源ph_dictitem
     */
    private Byte TCM_TSZ;
    /**
     * 中医体质辨识_痰湿质_保健指导_列表(以@#拼接)，来源ph_dictitem
     */
    private String TCM_TSZ_Guide;
    /**
     * 中医体质辨识_痰湿质_保健指导_其它描述
     */
    private String TCM_TSZ_Guide_Desc;
    /**
     * 中医体质辨识_温热质_辨识结果，来源ph_dictitem
     */
    private Byte TCM_SRZ;
    /**
     * 中医体质辨识_温热质_保健指导_列表(以@#拼接)，来源ph_dictitem
     */
    private String TCM_SRZ_Guide;
    /**
     * 中医体质辨识_温热质_保健指导_其它描述
     */
    private String TCM_SRZ_Guide_Desc;
    /**
     * 中医体质辨识_血瘀质_辨识结果，来源ph_dictitem
     */
    private Byte TCM_XTZ;
    /**
     * 中医体质辨识_血瘀质_保健指导_列表(以@#拼接)，来源ph_dictitem
     */
    private String TCM_XTZ_Guide;
    /**
     * 中医体质辨识_血瘀质_保健指导_其它描述
     */
    private String TCM_XTZ_Guide_Desc;
    /**
     * 中医体质辨识_气郁质_辨识结果，来源ph_dictitem
     */
    private Byte TCM_QYZ;
    /**
     * 中医体质辨识_气郁质_保健指导_列表(以@#拼接)，来源ph_dictitem
     */
    private String TCM_QYZ_Guide;
    /**
     * 中医体质辨识_气郁质_保健指导_其它描述
     */
    private String TCM_QYZ_Guide_Desc;
    /**
     * 中医体质辨识_特秉质_辨识结果，来源ph_dictitem
     */
    private Byte TCM_TBZ;
    /**
     * 现存主要健康问题_脑血管疾病_列表(以@#拼接)，来源ph_dictitem
     */
    private String cerebralVessel;
    /**
     * 中医体质辨识_特秉质_保健指导_列表(以@#拼接)，来源ph_dictitem
     */
    private String TCM_TBZ_Guide;
    /**
     * 中医体质辨识_特秉质_保健指导_其它描述
     */
    private String TCM_TBZ_Guide_Desc;
    /**
     * 现存主要健康问题_脑血管疾病其他描述
     */
    private String cerebralVessel_Desc;
    /**
     * 现存主要健康问题_肾脏疾病_列表(以@#拼接)，来源ph_dictitem
     */
    private String kidney;
    /**
     * 现存主要健康问题_肾脏疾病其他描述
     */
    private String kidney_Desc;
    /**
     * 现存主要健康问题_心脏疾病_列表(以@#拼接)，来源ph_dictitem
     */
    private String heart;
    /**
     * 现存主要健康问题_心脏疾病其他描述
     */
    private String heart_Desc;
    /**
     * 现存主要健康问题_血管疾病_列表(以@#拼接)，来源ph_dictitem
     */
    private String bloodPipe;
    /**
     * 现存主要健康问题_血管疾病其他描述
     */
    private String bloodPipe_Desc;
    /**
     * 现存主要健康问题_眼部疾病_列表(以@#拼接)，来源ph_dictitem
     */
    private String eyePart;
    /**
     * 现存主要健康问题_眼部疾病其他描述
     */
    private String eyePart_Desc;
    /**
     * 现存主要健康问题_神经系统疾病，来源ph_dictitem
     */
    private Byte nervousSystem;
    /**
     * 现存主要健康问题_神经系统疾病描述
     */
    private String nervousSystem_Desc;
    /**
     * 现存主要健康问题_其他系统疾病，来源ph_dictitem
     */
    private Byte otherSystem;
    /**
     * 现存主要健康问题_其他系统疾病描述
     */
    private String otherSystem_Desc;
    /**
     * 健康评价，来源ph_dictitem
     */
    private Byte healthEvaluate;
    /**
     * 健康评价异常描述(以@#拼接)
     */
    private String healthEvaluate_Desc;
    /**
     * 健康指导_列表(以@#拼接)，来源ph_dictitem
     */
    private String healthGuide;
    /**
     * 危险因素控制_列表(以@#拼接)，来源ph_dictitem
     */
    private String riskFactor;
    /**
     * 危险因素控制_目标
     */
    private String riskFactor_Target;
    /**
     * 危险因素控制_疫苗
     */
    private String riskFactor_Vaccine;
    /**
     * 危险因素控制_其他
     */
    private String riskFactor_Other;

    public Long getHExamID() {
        return HExamID;
    }
    public void setHExamID(Long HExamID) {
        this.HExamID = HExamID;
    }
    public String getSymptom() {
        return symptom;
    }
    public void setSymptom(String symptom) {
    	this.symptom = arrayToJoint(symptom);
    }
    public String getSymptom_Desc() {
        return symptom_Desc;
    }
    public void setSymptom_Desc(String symptom_Desc) {
        this.symptom_Desc = symptom_Desc;
    }
    public BigDecimal getBodyTemperature() {
        return bodyTemperature;
    }
    public void setBodyTemperature(BigDecimal bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }
    public Short getPulseRate() {
        return pulseRate;
    }
    public void setPulseRate(Short pulseRate) {
        this.pulseRate = pulseRate;
    }
    public Short getRespiratoryRate() {
        return respiratoryRate;
    }
    public void setRespiratoryRate(Short respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }
    public Short getLeftSystolic() {
        return leftSystolic;
    }
    public void setLeftSystolic(Short leftSystolic) {
        this.leftSystolic = leftSystolic;
    }
    public Short getLeftDiastolic() {
        return leftDiastolic;
    }
    public void setLeftDiastolic(Short leftDiastolic) {
        this.leftDiastolic = leftDiastolic;
    }
    public Short getRightSystolic() {
        return rightSystolic;
    }
    public void setRightSystolic(Short rightSystolic) {
        this.rightSystolic = rightSystolic;
    }
    public Short getRightDiastolic() {
        return rightDiastolic;
    }
    public void setRightDiastolic(Short rightDiastolic) {
        this.rightDiastolic = rightDiastolic;
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
    public BigDecimal getWaist() {
        return waist;
    }
    public void setWaist(BigDecimal waist) {
        this.waist = waist;
    }
    public BigDecimal getBMI() {
        return BMI;
    }
    public void setBMI(BigDecimal BMI) {
        this.BMI = BMI;
    }
    public Byte getAgedHealthEvaluate() {
        return agedHealthEvaluate;
    }
    public void setAgedHealthEvaluate(Byte agedHealthEvaluate) {
        this.agedHealthEvaluate = agedHealthEvaluate;
    }
    public Byte getAgedLifeEvaluate() {
        return agedLifeEvaluate;
    }
    public void setAgedLifeEvaluate(Byte agedLifeEvaluate) {
        this.agedLifeEvaluate = agedLifeEvaluate;
    }
    public Byte getAgedCognition() {
        return agedCognition;
    }
    public void setAgedCognition(Byte agedCognition) {
        this.agedCognition = agedCognition;
    }
    public Byte getAgedCognitionScore() {
        return agedCognitionScore;
    }
    public void setAgedCognitionScore(Byte agedCognitionScore) {
        this.agedCognitionScore = agedCognitionScore;
    }
    public Byte getAgedFeeling() {
        return agedFeeling;
    }
    public void setAgedFeeling(Byte agedFeeling) {
        this.agedFeeling = agedFeeling;
    }
    public Byte getAgedFeelingScore() {
        return agedFeelingScore;
    }
    public void setAgedFeelingScore(Byte agedFeelingScore) {
        this.agedFeelingScore = agedFeelingScore;
    }
    public Byte getSportFrequency() {
        return sportFrequency;
    }
    public void setSportFrequency(Byte sportFrequency) {
        this.sportFrequency = sportFrequency;
    }
    public Short getSportDuration() {
        return sportDuration;
    }
    public void setSportDuration(Short sportDuration) {
        this.sportDuration = sportDuration;
    }
    public Byte getSportTotalTime() {
        return sportTotalTime;
    }
    public void setSportTotalTime(Byte sportTotalTime) {
        this.sportTotalTime = sportTotalTime;
    }
    public String getSportWay() {
        return sportWay;
    }
    public void setSportWay(String sportWay) {
        this.sportWay = sportWay;
    }
    public String getEatingHabits() {
        return eatingHabits;
    }
    public void setEatingHabits(String eatingHabits) {
    	this.eatingHabits = arrayToJoint(eatingHabits);
    }
    public Byte getSmokingState() {
        return smokingState;
    }
    public void setSmokingState(Byte smokingState) {
        this.smokingState = smokingState;
    }
    public Short getDailySmoking() {
        return dailySmoking;
    }
    public void setDailySmoking(Short dailySmoking) {
        this.dailySmoking = dailySmoking;
    }
    public Byte getSmokingStartAge() {
        return smokingStartAge;
    }
    public void setSmokingStartAge(Byte smokingStartAge) {
        this.smokingStartAge = smokingStartAge;
    }
    public Byte getSmokingEndAge() {
        return smokingEndAge;
    }
    public void setSmokingEndAge(Byte smokingEndAge) {
        this.smokingEndAge = smokingEndAge;
    }
    public Byte getDrinkFrequency() {
        return drinkFrequency;
    }
    public void setDrinkFrequency(Byte drinkFrequency) {
        this.drinkFrequency = drinkFrequency;
    }
    public BigDecimal getDailyDrink() {
        return dailyDrink;
    }
    public void setDailyDrink(BigDecimal dailyDrink) {
        this.dailyDrink = dailyDrink;
    }
    public Byte getIsAbstinence() {
        return isAbstinence;
    }
    public void setIsAbstinence(Byte isAbstinence) {
        this.isAbstinence = isAbstinence;
    }
    public Byte getAbstinenceAge() {
        return abstinenceAge;
    }
    public void setAbstinenceAge(Byte abstinenceAge) {
        this.abstinenceAge = abstinenceAge;
    }
    public Byte getDrinkStartAge() {
        return drinkStartAge;
    }
    public void setDrinkStartAge(Byte drinkStartAge) {
        this.drinkStartAge = drinkStartAge;
    }
    public Byte getIsTemulenceLastYear() {
        return isTemulenceLastYear;
    }
    public void setIsTemulenceLastYear(Byte isTemulenceLastYear) {
        this.isTemulenceLastYear = isTemulenceLastYear;
    }
    public String getDrinkType() {
        return drinkType;
    }
    public void setDrinkType(String drinkType) {
    	this.drinkType = arrayToJoint(drinkType);
    }
    public String getDrinkOther_Desc() {
        return drinkOther_Desc;
    }
    public void setDrinkOther_Desc(String drinkOther_Desc) {
        this.drinkOther_Desc = drinkOther_Desc;
    }
    public Byte getOccupation() {
        return occupation;
    }
    public void setOccupation(Byte occupation) {
        this.occupation = occupation;
    }
    public String getTypeOfWork() {
        return typeOfWork;
    }
    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }
    public Byte getWorkTime() {
        return workTime;
    }
    public void setWorkTime(Byte workTime) {
        this.workTime = workTime;
    }
    public String getDust() {
        return dust;
    }
    public void setDust(String dust) {
        this.dust = dust;
    }
    public Byte getDustGuard() {
        return dustGuard;
    }
    public void setDustGuard(Byte dustGuard) {
        this.dustGuard = dustGuard;
    }
    public String getDustGuard_Desc() {
        return dustGuard_Desc;
    }
    public void setDustGuard_Desc(String dustGuard_Desc) {
        this.dustGuard_Desc = dustGuard_Desc;
    }
    public String getRadiogen() {
        return radiogen;
    }
    public void setRadiogen(String radiogen) {
        this.radiogen = radiogen;
    }
    public Byte getRadiogenGuard() {
        return radiogenGuard;
    }
    public void setRadiogenGuard(Byte radiogenGuard) {
        this.radiogenGuard = radiogenGuard;
    }
    public String getRadiogenGuard_Desc() {
        return radiogenGuard_Desc;
    }
    public void setRadiogenGuard_Desc(String radiogenGuard_Desc) {
        this.radiogenGuard_Desc = radiogenGuard_Desc;
    }
    public String getPhysical() {
        return physical;
    }
    public void setPhysical(String physical) {
        this.physical = physical;
    }
    public Byte getPhysicalGuard() {
        return physicalGuard;
    }
    public void setPhysicalGuard(Byte physicalGuard) {
        this.physicalGuard = physicalGuard;
    }
    public String getPhysicalGuard_Desc() {
        return physicalGuard_Desc;
    }
    public void setPhysicalGuard_Desc(String physicalGuard_Desc) {
        this.physicalGuard_Desc = physicalGuard_Desc;
    }
    public String getChemical() {
        return chemical;
    }
    public void setChemical(String chemical) {
        this.chemical = chemical;
    }
    public Byte getChemicalGuard() {
        return chemicalGuard;
    }
    public void setChemicalGuard(Byte chemicalGuard) {
        this.chemicalGuard = chemicalGuard;
    }
    public String getChemicalGuard_Desc() {
        return chemicalGuard_Desc;
    }
    public void setChemicalGuard_Desc(String chemicalGuard_Desc) {
        this.chemicalGuard_Desc = chemicalGuard_Desc;
    }
    public String getToxicOther() {
        return toxicOther;
    }
    public void setToxicOther(String toxicOther) {
        this.toxicOther = toxicOther;
    }
    public Byte getToxicOtherGuard() {
        return toxicOtherGuard;
    }
    public void setToxicOtherGuard(Byte toxicOtherGuard) {
        this.toxicOtherGuard = toxicOtherGuard;
    }
    public String getToxicOtherGuard_Desc() {
        return toxicOtherGuard_Desc;
    }
    public void setToxicOtherGuard_Desc(String toxicOtherGuard_Desc) {
        this.toxicOtherGuard_Desc = toxicOtherGuard_Desc;
    }
    public Byte getLips() {
        return lips;
    }
    public void setLips(Byte lips) {
        this.lips = lips;
    }
    public Byte getDentition() {
        return dentition;
    }
    public void setDentition(Byte dentition) {
        this.dentition = dentition;
    }
    public String getDentition_Desc() {
        return dentition_Desc;
    }
    public void setDentition_Desc(String dentition_Desc) {
        this.dentition_Desc = dentition_Desc;
    }
    public Byte getThroat() {
        return throat;
    }
    public void setThroat(Byte throat) {
        this.throat = throat;
    }
    public BigDecimal getLeftVision() {
        return leftVision;
    }
    public void setLeftVision(BigDecimal leftVision) {
        this.leftVision = leftVision;
    }
    public BigDecimal getRightVision() {
        return rightVision;
    }
    public void setRightVision(BigDecimal rightVision) {
        this.rightVision = rightVision;
    }
    public BigDecimal getLeftCorrectVision() {
        return leftCorrectVision;
    }
    public void setLeftCorrectVision(BigDecimal leftCorrectVision) {
        this.leftCorrectVision = leftCorrectVision;
    }
    public BigDecimal getRightCorrectVision() {
        return rightCorrectVision;
    }
    public void setRightCorrectVision(BigDecimal rightCorrectVision) {
        this.rightCorrectVision = rightCorrectVision;
    }
    public Byte getHearing() {
        return hearing;
    }
    public void setHearing(Byte hearing) {
        this.hearing = hearing;
    }
    public Byte getMovement() {
        return movement;
    }
    public void setMovement(Byte movement) {
        this.movement = movement;
    }
    public Byte getEyeground() {
        return eyeground;
    }
    public void setEyeground(Byte eyeground) {
        this.eyeground = eyeground;
    }
    public String getEyeground_Desc() {
        return eyeground_Desc;
    }
    public void setEyeground_Desc(String eyeground_Desc) {
        this.eyeground_Desc = eyeground_Desc;
    }
    public Byte getSkin() {
        return skin;
    }
    public void setSkin(Byte skin) {
        this.skin = skin;
    }
    public String getSkin_Desc() {
        return skin_Desc;
    }
    public void setSkin_Desc(String skin_Desc) {
        this.skin_Desc = skin_Desc;
    }
    public Byte getSclero() {
        return sclero;
    }
    public void setSclero(Byte sclero) {
        this.sclero = sclero;
    }
    public String getSclero_Desc() {
        return sclero_Desc;
    }
    public void setSclero_Desc(String sclero_Desc) {
        this.sclero_Desc = sclero_Desc;
    }
    public Byte getLymph() {
        return lymph;
    }
    public void setLymph(Byte lymph) {
        this.lymph = lymph;
    }
    public String getLymph_Desc() {
        return lymph_Desc;
    }
    public void setLymph_Desc(String lymph_Desc) {
        this.lymph_Desc = lymph_Desc;
    }
    public Byte getLungBarrelChest() {
        return lungBarrelChest;
    }
    public void setLungBarrelChest(Byte lungBarrelChest) {
        this.lungBarrelChest = lungBarrelChest;
    }
    public Byte getLungBreathSounds() {
        return lungBreathSounds;
    }
    public void setLungBreathSounds(Byte lungBreathSounds) {
        this.lungBreathSounds = lungBreathSounds;
    }
    public String getLungBreathSounds_Desc() {
        return lungBreathSounds_Desc;
    }
    public void setLungBreathSounds_Desc(String lungBreathSounds_Desc) {
        this.lungBreathSounds_Desc = lungBreathSounds_Desc;
    }
    public Byte getLungRales() {
        return lungRales;
    }
    public void setLungRales(Byte lungRales) {
        this.lungRales = lungRales;
    }
    public String getLungRales_Desc() {
        return lungRales_Desc;
    }
    public void setLungRales_Desc(String lungRales_Desc) {
        this.lungRales_Desc = lungRales_Desc;
    }
    public Short getHeartRate() {
        return heartRate;
    }
    public void setHeartRate(Short heartRate) {
        this.heartRate = heartRate;
    }
    public Byte getRhythm() {
        return rhythm;
    }
    public void setRhythm(Byte rhythm) {
        this.rhythm = rhythm;
    }
    public Byte getMurmur() {
        return murmur;
    }
    public void setMurmur(Byte murmur) {
        this.murmur = murmur;
    }
    public String getMurmur_Desc() {
        return murmur_Desc;
    }
    public void setMurmur_Desc(String murmur_Desc) {
        this.murmur_Desc = murmur_Desc;
    }
    public Byte getPain() {
        return pain;
    }
    public void setPain(Byte pain) {
        this.pain = pain;
    }
    public String getPain_Desc() {
        return pain_Desc;
    }
    public void setPain_Desc(String pain_Desc) {
        this.pain_Desc = pain_Desc;
    }
    public Byte getBlock() {
        return block;
    }
    public void setBlock(Byte block) {
        this.block = block;
    }
    public String getBlock_Desc() {
        return block_Desc;
    }
    public void setBlock_Desc(String block_Desc) {
        this.block_Desc = block_Desc;
    }
    public Byte getHepatomegaly() {
        return hepatomegaly;
    }
    public void setHepatomegaly(Byte hepatomegaly) {
        this.hepatomegaly = hepatomegaly;
    }
    public String getHepatomegaly_Desc() {
        return hepatomegaly_Desc;
    }
    public void setHepatomegaly_Desc(String hepatomegaly_Desc) {
        this.hepatomegaly_Desc = hepatomegaly_Desc;
    }
    public Byte getSplenomegaly() {
        return splenomegaly;
    }
    public void setSplenomegaly(Byte splenomegaly) {
        this.splenomegaly = splenomegaly;
    }
    public String getSplenomegaly_Desc() {
        return splenomegaly_Desc;
    }
    public void setSplenomegaly_Desc(String splenomegaly_Desc) {
        this.splenomegaly_Desc = splenomegaly_Desc;
    }
    public Byte getMoveSonant() {
        return moveSonant;
    }
    public void setMoveSonant(Byte moveSonant) {
        this.moveSonant = moveSonant;
    }
    public String getMoveSonant_Desc() {
        return moveSonant_Desc;
    }
    public void setMoveSonant_Desc(String moveSonant_Desc) {
        this.moveSonant_Desc = moveSonant_Desc;
    }
    public Byte getLowLimbEdema() {
        return lowLimbEdema;
    }
    public void setLowLimbEdema(Byte lowLimbEdema) {
        this.lowLimbEdema = lowLimbEdema;
    }
    public Byte getArteriopalmus() {
        return arteriopalmus;
    }
    public void setArteriopalmus(Byte arteriopalmus) {
        this.arteriopalmus = arteriopalmus;
    }
    public Byte getAnusTactus() {
        return anusTactus;
    }
    public void setAnusTactus(Byte anusTactus) {
        this.anusTactus = anusTactus;
    }
    public String getAnusTactus_Desc() {
        return anusTactus_Desc;
    }
    public void setAnusTactus_Desc(String anusTactus_Desc) {
        this.anusTactus_Desc = anusTactus_Desc;
    }
    public String getBreast() {
        return breast;
    }
    public void setBreast(String breast) {
    	this.breast = arrayToJoint(breast);
    }
    public String getBreast_Desc() {
        return breast_Desc;
    }
    public void setBreast_Desc(String breast_Desc) {
        this.breast_Desc = breast_Desc;
    }
    public Byte getPudendum() {
        return pudendum;
    }
    public void setPudendum(Byte pudendum) {
        this.pudendum = pudendum;
    }
    public String getPudendum_Desc() {
        return pudendum_Desc;
    }
    public void setPudendum_Desc(String pudendum_Desc) {
        this.pudendum_Desc = pudendum_Desc;
    }
    public Byte getVagina() {
        return vagina;
    }
    public void setVagina(Byte vagina) {
        this.vagina = vagina;
    }
    public String getVagina_Desc() {
        return vagina_Desc;
    }
    public void setVagina_Desc(String vagina_Desc) {
        this.vagina_Desc = vagina_Desc;
    }
    public Byte getCervical() {
        return cervical;
    }
    public void setCervical(Byte cervical) {
        this.cervical = cervical;
    }
    public String getCervical_Desc() {
        return cervical_Desc;
    }
    public void setCervical_Desc(String cervical_Desc) {
        this.cervical_Desc = cervical_Desc;
    }
    public Byte getUteri() {
        return uteri;
    }
    public void setUteri(Byte uteri) {
        this.uteri = uteri;
    }
    public String getUteri_Desc() {
        return uteri_Desc;
    }
    public void setUteri_Desc(String uteri_Desc) {
        this.uteri_Desc = uteri_Desc;
    }
    public Byte getEnclosure() {
        return enclosure;
    }
    public void setEnclosure(Byte enclosure) {
        this.enclosure = enclosure;
    }
    public String getEnclosure_Desc() {
        return enclosure_Desc;
    }
    public void setEnclosure_Desc(String enclosure_Desc) {
        this.enclosure_Desc = enclosure_Desc;
    }
    public String getGynaecologyOther() {
        return gynaecologyOther;
    }
    public void setGynaecologyOther(String gynaecologyOther) {
        this.gynaecologyOther = gynaecologyOther;
    }
    public Short getHemoglobin() {
        return hemoglobin;
    }
    public void setHemoglobin(Short hemoglobin) {
        this.hemoglobin = hemoglobin;
    }
    public BigDecimal getLeukocyte() {
        return leukocyte;
    }
    public void setLeukocyte(BigDecimal leukocyte) {
        this.leukocyte = leukocyte;
    }
    public Short getPlatelet() {
        return platelet;
    }
    public void setPlatelet(Short platelet) {
        this.platelet = platelet;
    }
    public String getBloodOther() {
        return bloodOther;
    }
    public void setBloodOther(String bloodOther) {
        this.bloodOther = bloodOther;
    }
    public String getUrineProtein() {
        return urineProtein;
    }
    public void setUrineProtein(String urineProtein) {
        this.urineProtein = urineProtein;
    }
    public String getUrineSugar() {
        return urineSugar;
    }
    public void setUrineSugar(String urineSugar) {
        this.urineSugar = urineSugar;
    }
    public String getUrineAcetoneBody() {
        return urineAcetoneBody;
    }
    public void setUrineAcetoneBody(String urineAcetoneBody) {
        this.urineAcetoneBody = urineAcetoneBody;
    }
    public String getUrineOccultBlood() {
        return urineOccultBlood;
    }
    public void setUrineOccultBlood(String urineOccultBlood) {
        this.urineOccultBlood = urineOccultBlood;
    }
    public String getUrineOther() {
        return urineOther;
    }
    public void setUrineOther(String urineOther) {
        this.urineOther = urineOther;
    }
    public BigDecimal getGLU() {
        return GLU;
    }
    public void setGLU(BigDecimal GLU) {
        this.GLU = GLU;
    }
    public BigDecimal getPGLU() {
        return PGLU;
    }
    public void setPGLU(BigDecimal PGLU) {
        this.PGLU = PGLU;
    }
    public Byte getCardiogram() {
        return cardiogram;
    }
    public void setCardiogram(Byte cardiogram) {
        this.cardiogram = cardiogram;
    }
    public String getCardiogram_Desc() {
        return cardiogram_Desc;
    }
    public void setCardiogram_Desc(String cardiogram_Desc) {
        this.cardiogram_Desc = cardiogram_Desc;
    }
    public BigDecimal getUrineMicroAlbumin() {
        return urineMicroAlbumin;
    }
    public void setUrineMicroAlbumin(BigDecimal urineMicroAlbumin) {
        this.urineMicroAlbumin = urineMicroAlbumin;
    }
    public Byte getFecalOccultBlood() {
        return fecalOccultBlood;
    }
    public void setFecalOccultBlood(Byte fecalOccultBlood) {
        this.fecalOccultBlood = fecalOccultBlood;
    }
    public BigDecimal getHBA1C() {
        return HBA1C;
    }
    public void setHBA1C(BigDecimal HBA1C) {
        this.HBA1C = HBA1C;
    }
    public Byte getHBSAG() {
        return HBSAG;
    }
    public void setHBSAG(Byte HBSAG) {
        this.HBSAG = HBSAG;
    }
    public Short getCPT() {
        return CPT;
    }
    public void setCPT(Short CPT) {
        this.CPT = CPT;
    }
    public Short getAST() {
        return AST;
    }
    public void setAST(Short AST) {
        this.AST = AST;
    }
    public Short getALB() {
        return ALB;
    }
    public void setALB(Short ALB) {
        this.ALB = ALB;
    }
    public BigDecimal getTBIL() {
        return TBIL;
    }
    public void setTBIL(BigDecimal TBIL) {
        this.TBIL = TBIL;
    }
    public BigDecimal getCBIL() {
        return CBIL;
    }
    public void setCBIL(BigDecimal CBIL) {
        this.CBIL = CBIL;
    }
    public BigDecimal getCR() {
        return CR;
    }
    public void setCR(BigDecimal CR) {
        this.CR = CR;
    }
    public BigDecimal getBUN() {
        return BUN;
    }
    public void setBUN(BigDecimal BUN) {
        this.BUN = BUN;
    }
    public BigDecimal getSerumPotassium() {
        return serumPotassium;
    }
    public void setSerumPotassium(BigDecimal serumPotassium) {
        this.serumPotassium = serumPotassium;
    }
    public BigDecimal getSerumSodium() {
        return serumSodium;
    }
    public void setSerumSodium(BigDecimal serumSodium) {
        this.serumSodium = serumSodium;
    }
    public BigDecimal getCHOL() {
        return CHOL;
    }
    public void setCHOL(BigDecimal CHOL) {
        this.CHOL = CHOL;
    }
    public BigDecimal getTG() {
        return TG;
    }
    public void setTG(BigDecimal TG) {
        this.TG = TG;
    }
    public BigDecimal getLDL_C() {
        return LDL_C;
    }
    public void setLDL_C(BigDecimal LDL_C) {
        this.LDL_C = LDL_C;
    }
    public BigDecimal getHDL_C() {
        return HDL_C;
    }
    public void setHDL_C(BigDecimal HDL_C) {
        this.HDL_C = HDL_C;
    }
    public Byte getX_RAY() {
        return x_RAY;
    }
    public void setX_RAY(Byte x_RAY) {
        this.x_RAY = x_RAY;
    }
    public String getX_RAY_Desc() {
        return x_RAY_Desc;
    }
    public void setX_RAY_Desc(String x_RAY_Desc) {
        this.x_RAY_Desc = x_RAY_Desc;
    }
    public Byte getB_Ultrasonic() {
        return b_Ultrasonic;
    }
    public void setB_Ultrasonic(Byte b_Ultrasonic) {
        this.b_Ultrasonic = b_Ultrasonic;
    }
    public String getB_Ultrasonic_Desc() {
        return b_Ultrasonic_Desc;
    }
    public void setB_Ultrasonic_Desc(String b_Ultrasonic_Desc) {
        this.b_Ultrasonic_Desc = b_Ultrasonic_Desc;
    }
    public Byte getCervicalSmear() {
        return cervicalSmear;
    }
    public void setCervicalSmear(Byte cervicalSmear) {
        this.cervicalSmear = cervicalSmear;
    }
    public String getCervicalSmear_Desc() {
        return cervicalSmear_Desc;
    }
    public void setCervicalSmear_Desc(String cervicalSmear_Desc) {
        this.cervicalSmear_Desc = cervicalSmear_Desc;
    }
    public String getAssistCheckOther() {
        return assistCheckOther;
    }
    public void setAssistCheckOther(String assistCheckOther) {
        this.assistCheckOther = assistCheckOther;
    }
    public Byte getTCM_PHZ() {
        return TCM_PHZ;
    }
    public void setTCM_PHZ(Byte TCM_PHZ) {
        this.TCM_PHZ = TCM_PHZ;
    }
    public String getTCM_PHZ_Guide() {
        return TCM_PHZ_Guide;
    }
    public void setTCM_PHZ_Guide(String TCM_PHZ_Guide) {
    	this.TCM_PHZ_Guide = arrayToJoint(TCM_PHZ_Guide);
    }
    public String getTCM_PHZ_Guide_Desc() {
        return TCM_PHZ_Guide_Desc;
    }
    public void setTCM_PHZ_Guide_Desc(String TCM_PHZ_Guide_Desc) {
        this.TCM_PHZ_Guide_Desc = TCM_PHZ_Guide_Desc;
    }
    public Byte getTCM_QXZ() {
        return TCM_QXZ;
    }
    public void setTCM_QXZ(Byte TCM_QXZ) {
        this.TCM_QXZ = TCM_QXZ;
    }
    public String getTCM_QXZ_Guide() {
        return TCM_QXZ_Guide;
    }
    public void setTCM_QXZ_Guide(String TCM_QXZ_Guide) {
    	this.TCM_QXZ_Guide = arrayToJoint(TCM_QXZ_Guide);
    }
    public String getTCM_QXZ_Guide_Desc() {
        return TCM_QXZ_Guide_Desc;
    }
    public void setTCM_QXZ_Guide_Desc(String TCM_QXZ_Guide_Desc) {
        this.TCM_QXZ_Guide_Desc = TCM_QXZ_Guide_Desc;
    }
    public Byte getTCM_YXZ() {
        return TCM_YXZ;
    }
    public void setTCM_YXZ(Byte TCM_YXZ) {
        this.TCM_YXZ = TCM_YXZ;
    }
    public String getTCM_YXZ_Guide() {
        return TCM_YXZ_Guide;
    }
    public void setTCM_YXZ_Guide(String TCM_YXZ_Guide) {
        this.TCM_YXZ_Guide = arrayToJoint(TCM_YXZ_Guide);
    }
    public String getTCM_YXZ_Guide_Desc() {
        return TCM_YXZ_Guide_Desc;
    }
    public void setTCM_YXZ_Guide_Desc(String TCM_YXZ_Guide_Desc) {
        this.TCM_YXZ_Guide_Desc = TCM_YXZ_Guide_Desc;
    }
    public Byte getTCM_YIXZ() {
        return TCM_YIXZ;
    }
    public void setTCM_YIXZ(Byte TCM_YIXZ) {
        this.TCM_YIXZ = TCM_YIXZ;
    }
    public String getTCM_YIXZ_Guide() {
        return TCM_YIXZ_Guide;
    }
    public void setTCM_YIXZ_Guide(String TCM_YIXZ_Guide) {
        this.TCM_YIXZ_Guide = arrayToJoint(TCM_YIXZ_Guide);
    }
    public String getTCM_YIXZ_Guide_Desc() {
        return TCM_YIXZ_Guide_Desc;
    }
    public void setTCM_YIXZ_Guide_Desc(String TCM_YIXZ_Guide_Desc) {
        this.TCM_YIXZ_Guide_Desc = TCM_YIXZ_Guide_Desc;
    }
    public Byte getTCM_TSZ() {
        return TCM_TSZ;
    }
    public void setTCM_TSZ(Byte TCM_TSZ) {
        this.TCM_TSZ = TCM_TSZ;
    }
    public String getTCM_TSZ_Guide() {
        return TCM_TSZ_Guide;
    }
    public void setTCM_TSZ_Guide(String TCM_TSZ_Guide) {
        this.TCM_TSZ_Guide = arrayToJoint(TCM_TSZ_Guide);
    }
    public String getTCM_TSZ_Guide_Desc() {
        return TCM_TSZ_Guide_Desc;
    }
    public void setTCM_TSZ_Guide_Desc(String TCM_TSZ_Guide_Desc) {
        this.TCM_TSZ_Guide_Desc = TCM_TSZ_Guide_Desc;
    }
    public Byte getTCM_SRZ() {
        return TCM_SRZ;
    }
    public void setTCM_SRZ(Byte TCM_SRZ) {
        this.TCM_SRZ = TCM_SRZ;
    }
    public String getTCM_SRZ_Guide() {
        return TCM_SRZ_Guide;
    }
    public void setTCM_SRZ_Guide(String TCM_SRZ_Guide) {
        this.TCM_SRZ_Guide = arrayToJoint(TCM_SRZ_Guide);
    }
    public String getTCM_SRZ_Guide_Desc() {
        return TCM_SRZ_Guide_Desc;
    }
    public void setTCM_SRZ_Guide_Desc(String TCM_SRZ_Guide_Desc) {
        this.TCM_SRZ_Guide_Desc = TCM_SRZ_Guide_Desc;
    }
    public Byte getTCM_XTZ() {
        return TCM_XTZ;
    }
    public void setTCM_XTZ(Byte TCM_XTZ) {
        this.TCM_XTZ = TCM_XTZ;
    }
    public String getTCM_XTZ_Guide() {
        return TCM_XTZ_Guide;
    }
    public void setTCM_XTZ_Guide(String TCM_XTZ_Guide) {
        this.TCM_XTZ_Guide = arrayToJoint(TCM_XTZ_Guide);
    }
    public String getTCM_XTZ_Guide_Desc() {
        return TCM_XTZ_Guide_Desc;
    }
    public void setTCM_XTZ_Guide_Desc(String TCM_XTZ_Guide_Desc) {
        this.TCM_XTZ_Guide_Desc = TCM_XTZ_Guide_Desc;
    }
    public Byte getTCM_QYZ() {
        return TCM_QYZ;
    }
    public void setTCM_QYZ(Byte TCM_QYZ) {
        this.TCM_QYZ = TCM_QYZ;
    }
    public String getTCM_QYZ_Guide() {
        return TCM_QYZ_Guide;
    }
    public void setTCM_QYZ_Guide(String TCM_QYZ_Guide) {
        this.TCM_QYZ_Guide = arrayToJoint(TCM_QYZ_Guide);
    }
    public String getTCM_QYZ_Guide_Desc() {
        return TCM_QYZ_Guide_Desc;
    }
    public void setTCM_QYZ_Guide_Desc(String TCM_QYZ_Guide_Desc) {
        this.TCM_QYZ_Guide_Desc = TCM_QYZ_Guide_Desc;
    }
    public Byte getTCM_TBZ() {
        return TCM_TBZ;
    }
    public void setTCM_TBZ(Byte TCM_TBZ) {
        this.TCM_TBZ = TCM_TBZ;
    }
    public String getCerebralVessel() {
        return cerebralVessel;
    }
    public void setCerebralVessel(String cerebralVessel) {
    	this.cerebralVessel = arrayToJoint(cerebralVessel);
    }
    public String getTCM_TBZ_Guide() {
        return TCM_TBZ_Guide;
    }
    public void setTCM_TBZ_Guide(String TCM_TBZ_Guide) {
        this.TCM_TBZ_Guide = arrayToJoint(TCM_TBZ_Guide);
    }
    public String getTCM_TBZ_Guide_Desc() {
        return TCM_TBZ_Guide_Desc;
    }
    public void setTCM_TBZ_Guide_Desc(String TCM_TBZ_Guide_Desc) {
        this.TCM_TBZ_Guide_Desc = TCM_TBZ_Guide_Desc;
    }
    public String getCerebralVessel_Desc() {
        return cerebralVessel_Desc;
    }
    public void setCerebralVessel_Desc(String cerebralVessel_Desc) {
        this.cerebralVessel_Desc = cerebralVessel_Desc;
    }
    public String getKidney() {
        return kidney;
    }
    public void setKidney(String kidney) {
    	this.kidney = arrayToJoint(kidney);
    }
    public String getKidney_Desc() {
        return kidney_Desc;
    }
    public void setKidney_Desc(String kidney_Desc) {
        this.kidney_Desc = kidney_Desc;
    }
    public String getHeart() {
        return heart;
    }
    public void setHeart(String heart) {
		this.heart = arrayToJoint(heart);
    }
    public String getHeart_Desc() {
        return heart_Desc;
    }
    public void setHeart_Desc(String heart_Desc) {
        this.heart_Desc = heart_Desc;
    }
    public String getBloodPipe() {
        return bloodPipe;
    }
    public void setBloodPipe(String bloodPipe) {
    	this.bloodPipe = arrayToJoint(bloodPipe);
    }
    public String getBloodPipe_Desc() {
        return bloodPipe_Desc;
    }
    public void setBloodPipe_Desc(String bloodPipe_Desc) {
        this.bloodPipe_Desc = bloodPipe_Desc;
    }
    public String getEyePart() {
        return eyePart;
    }
    public void setEyePart(String eyePart) {
    	this.eyePart = arrayToJoint(eyePart);
    }
    public String getEyePart_Desc() {
        return eyePart_Desc;
    }
    public void setEyePart_Desc(String eyePart_Desc) {
        this.eyePart_Desc = eyePart_Desc;
    }
    public Byte getNervousSystem() {
        return nervousSystem;
    }
    public void setNervousSystem(Byte nervousSystem) {
        this.nervousSystem = nervousSystem;
    }
    public String getNervousSystem_Desc() {
        return nervousSystem_Desc;
    }
    public void setNervousSystem_Desc(String nervousSystem_Desc) {
        this.nervousSystem_Desc = nervousSystem_Desc;
    }
    public Byte getOtherSystem() {
        return otherSystem;
    }
    public void setOtherSystem(Byte otherSystem) {
        this.otherSystem = otherSystem;
    }
    public String getOtherSystem_Desc() {
        return otherSystem_Desc;
    }
    public void setOtherSystem_Desc(String otherSystem_Desc) {
        this.otherSystem_Desc = otherSystem_Desc;
    }
    public Byte getHealthEvaluate() {
        return healthEvaluate;
    }
    public void setHealthEvaluate(Byte healthEvaluate) {
        this.healthEvaluate = healthEvaluate;
    }
    public String getHealthEvaluate_Desc() {
        return healthEvaluate_Desc;
    }
    public void setHealthEvaluate_Desc(String healthEvaluate_Desc) {
    	this.healthEvaluate_Desc = arrayToJoint(healthEvaluate_Desc);
    }
    public String getHealthGuide() {
        return healthGuide;
    }
    public void setHealthGuide(String healthGuide) {
    	this.healthGuide = arrayToJoint(healthGuide);
    }
    public String getRiskFactor() {
        return riskFactor;
    }
    public void setRiskFactor(String riskFactor) {
    	this.riskFactor = arrayToJoint(riskFactor);
    }
    public String getRiskFactor_Target() {
        return riskFactor_Target;
    }
    public void setRiskFactor_Target(String riskFactor_Target) {
        this.riskFactor_Target = riskFactor_Target;
    }
    public String getRiskFactor_Vaccine() {
        return riskFactor_Vaccine;
    }
    public void setRiskFactor_Vaccine(String riskFactor_Vaccine) {
        this.riskFactor_Vaccine = riskFactor_Vaccine;
    }
    public String getRiskFactor_Other() {
        return riskFactor_Other;
    }
    public void setRiskFactor_Other(String riskFactor_Other) {
        this.riskFactor_Other = riskFactor_Other;
    }
    
    //
	public String getSymptomStr() {

		return getExtendNames("症状", "健康体检", symptom, "其他", symptom_Desc, "未见异常");
	}

	public String getAgedHealthEvaluateStr() {
		return convertStr("老年人健康状态自我评估", "健康体检_一般状况", agedHealthEvaluate);

	}

	public String getAgedLifeEvaluateStr() {
		return convertStr("老年人生活自理能力自我评估", "健康体检_一般状况", agedLifeEvaluate);

	}

	public String getAgedCognitionStr() {
		return convertStr("老年人认知功能", "健康体检_一般状况", agedCognition);
	}

	public String getAgedFeelingStr() {
		return convertStr("老年人情感状态", "健康体检_一般状况", agedFeeling);
	}

	public String getSportFrequencyStr() {
		return convertStr("锻炼频率", "健康体检_生活方式_体育锻炼", sportFrequency);
	}

	public String getEatingHabitsStr() {
		return getNames("饮食习惯", "健康体检_生活方式", eatingHabits);
	}

	public String getSmokingStateStr() {
		return convertStr("吸烟状况", "健康体检_生活方式_吸烟情况", smokingState);
	}

	public String getDrinkFrequencyStr() {
		return convertStr("饮酒频率", "健康体检_生活方式_饮酒情况", drinkFrequency);
	}

	public String getIsAbstinenceStr() {
		return convertStr("是否戒酒", "健康体检_生活方式_饮酒情况", isAbstinence);
	}

	public String getIsTemulenceLastYearStr() {
		return convertStr("近一年内是否曾醉酒", "健康体检_生活方式_饮酒情况", isTemulenceLastYear);
	}

	public String getDrinkTypeStr() {
		return getExtendNames("饮酒种类", "健康体检_生活方式_饮酒情况", drinkType, "其他", drinkOther_Desc, null);
	}

	public String getOccupationStr() {
		return convertStr("职业病危害因素接触史", "健康体检_生活方式", occupation);
	}

	public String getDustGuardStr() {
		return convertStr("粉尘防护措施", "健康体检_生活方式_职业病危害因素接触史", dustGuard);
	}

	public String getRadiogenGuardStr() {
		return convertStr("放射物质防护措施", "健康体检_生活方式_职业病危害因素接触史", radiogenGuard);
	}

	public String getPhysicalGuardStr() {
		return convertStr("物理因素防护措施", "健康体检_生活方式_职业病危害因素接触史", physicalGuard);
	}

	public String getChemicalGuardStr() {
		return convertStr("化学物质防护措施", "健康体检_生活方式_职业病危害因素接触史", chemicalGuard);
	}

	public String getToxicOtherGuardStr() {
		return convertStr("其他防护措施", "健康体检_生活方式_职业病危害因素接触史", toxicOtherGuard);
	}

	public String getLipsStr() {
		return convertStr("口唇", "健康体检_脏器功能_口腔", lips);
	}

	public String getDentitionStr() {
		return convertStr("齿列", "健康体检_脏器功能_口腔", dentition);
	}

	public String getThroatStr() {
		return convertStr("咽部", "健康体检_脏器功能_口腔", throat);
	}

	public String getHearingStr() {
		return convertStr("听力", "健康体检_脏器功能", hearing);
	}

	public String getMovementStr() {
		return convertStr("运动功能", "健康体检_脏器功能", movement);
	}

	public String getEyegroundStr() {
		return convertStr("眼底", "健康体检_查体", eyeground);
	}

	public String getSkinStr() {
		return convertStr("皮肤", "健康体检_查体", skin);
	}

	public String getScleroStr() {
		return convertStr("巩膜", "健康体检_查体", sclero);
	}

	public String getLymphStr() {
		return convertStr("淋巴结", "健康体检_查体", lymph);
	}

	public String getLungBarrelChestStr() {
		return convertStr("桶状胸", "健康体检_查体_肺", lungBarrelChest);
	}

	public String getLungBreathSoundsStr() {
		return convertStr("呼吸音", "健康体检_查体_肺", lungBreathSounds);
	}

	public String getLungRalesStr() {
		return convertStr("罗音", "健康体检_查体_肺", lungRales);
	}

	public String getRhythmStr() {
		return convertStr("心律", "健康体检_查体_心脏", rhythm);
	}

	public String getMurmurStr() {
		return convertStr("杂音", "健康体检_查体_心脏", murmur);
	}

	public String getPainStr() {
		return convertStr("压痛", "健康体检_查体_腹部", pain);
	}
	
	public String getBlockStr() {
		return convertStr("包块", "健康体检_查体_腹部", block);
	}

	public String getHepatomegalyStr() {
		return convertStr("肝大", "健康体检_查体_腹部", hepatomegaly);
	}

	public String getSplenomegalyStr() {
		return convertStr("脾大", "健康体检_查体_腹部", splenomegaly);
	}

	public String getMoveSonantStr() {
		return convertStr("移动浊音", "健康体检_查体_腹部", moveSonant);
	}

	public String getLowLimbEdemaStr() {
		return convertStr("下肢水肿", "健康体检_查体", lowLimbEdema);
	}

	public String getArteriopalmusStr() {
		return convertStr("足背动脉搏动", "健康体检_查体", arteriopalmus);
	}

	public String getAnusTactusStr() {
		return convertStr("肛门指诊", "健康体检_查体", anusTactus);
	}

	public String getBreastStr() {
		return getExtendNames("乳腺", "健康体检_查体", breast, "其他", breast_Desc, "未见异常");
	}

	public String getPudendumStr() {
		return convertStr("外阴", "健康体检_查体_妇科", pudendum);
	}

	public String getVaginaStr() {
		return convertStr("阴道", "健康体检_查体_妇科", vagina);
	}

	public String getCervicalStr() {
		return convertStr("宫颈", "健康体检_查体_妇科", cervical);
	}

	public String getUteriStr() {
		return convertStr("宫体", "健康体检_查体_妇科", uteri);
	}

	public String getEnclosureStr() {
		return convertStr("附件", "健康体检_查体_妇科", enclosure);
	}

	public String getCardiogramStr() {
		return convertStr("心电图", "健康体检_辅助检查", cardiogram);
	}

	public String getFecalOccultBloodStr() {
		return convertStr("大便潜血", "健康体检_辅助检查", fecalOccultBlood);
	}

	public String getHBSAGStr() {
		return convertStr("乙肝表面抗原", "健康体检_辅助检查", HBSAG);
	}

	public String getX_RAYStr() {
		return convertStr("胸部X线片", "健康体检_辅助检查", x_RAY);
	}

	public String getB_UltrasonicStr() {
		return convertStr("B超", "健康体检_辅助检查", b_Ultrasonic);
	}

	public String getCervicalSmearStr() {
		return convertStr("宫颈涂片", "健康体检_辅助检查", cervicalSmear);
	}

	public String getTCM_PHZStr() {
		return convertStr("辨识结果", "健康体检_中医体质辨识_平和质", TCM_PHZ);
	}

	public String getTCM_QXZStr() {
		return convertStr("辨识结果", "健康体检_中医体质辨识_气虚质", TCM_QXZ);
	}

	public String getTCM_YXZStr() {
		return convertStr("辨识结果", "健康体检_中医体质辨识_阳虚质", TCM_YXZ);
	}

	public String getTCM_YIXZStr() {
		return convertStr("辨识结果", "健康体检_中医体质辨识_阴虚质", TCM_YIXZ);
	}

	public String getTCM_TSZStr() {
		return convertStr("辨识结果", "健康体检_中医体质辨识_痰湿质", TCM_TSZ);
	}

	public String getTCM_SRZStr() {
		return convertStr("辨识结果", "健康体检_中医体质辨识_湿热质", TCM_SRZ);
	}

	public String getTCM_XTZStr() {
		return convertStr("辨识结果", "健康体检_中医体质辨识_血瘀质", TCM_XTZ);
	}

	public String getTCM_QYZStr() {
		return convertStr("辨识结果", "健康体检_中医体质辨识_气郁质", TCM_QYZ);
	}

	public String getTCM_TBZStr() {
		return convertStr("辨识结果", "健康体检_中医体质辨识_特秉质", TCM_TBZ);
	}

	public String getCerebralVesseltr() {
		return getExtendNames("脑血管疾病", "健康体检_现存主要健康问题", cerebralVessel, "其他",
				cerebralVessel_Desc, "未发现");
	}

	public String getKidneyStr() {
		return getExtendNames("肾脏疾病", "健康体检_现存主要健康问题", kidney, "其他", kidney_Desc,
				"未发现");
	}

	public String getHeartStr() {
		return getExtendNames("心脏疾病", "健康体检_现存主要健康问题", heart, "其他", heart_Desc, "未发现");
		//return getExtendNames("眼部疾病", "健康体检_现存主要健康问题", eyePart, "其他", eyePart_Desc, "未发现");
	}

	public String getBloodPipeStr() {
		return getExtendNames("血管疾病", "健康体检_现存主要健康问题", bloodPipe, "其他",
				bloodPipe_Desc, "未发现");
	}

	public String getEyePartStr() {
		return getExtendNames("眼部疾病", "健康体检_现存主要健康问题", eyePart, "其他", eyePart_Desc,
				"未发现");
	}

	public String getNervousSystemStr() {
		return convertStr("神经系统疾病", "健康体检_现存主要健康问题", nervousSystem);
	}

	public String getOtherSystemStr() {
		return convertStr("其他系统疾病", "健康体检_现存主要健康问题", otherSystem);
	}

	public String getHealthEvaluateStr() {
		return convertStr("健康评价", "健康体检", healthEvaluate);
	}

	public String getHealthGuideStr() {
		return getNames("健康指导", "健康体检", healthGuide);
	}

	public String getRiskFactorStr() {
		return getNames("危险因素控制", "健康体检", riskFactor, "减体重", "建议接种疫苗", "其他");// 危险因素控制
	}
	public String getTCM_PHZ_GuideStr() {
		return getNames("健康指导", "健康体检_中医体质辨识_平和质", TCM_PHZ_Guide);
	}
	public String getTCM_QXZ_GuideStr() {
		return getNames("健康指导", "健康体检_中医体质辨识_气虚质", TCM_QXZ_Guide);
	}
	public String getTCM_YXZ_GuideStr() {
		return getNames("健康指导", "健康体检_中医体质辨识_阳虚质", TCM_YXZ_Guide);
	}
	public String getTCM_YIXZ_GuideStr() {
		return getNames("健康指导", "健康体检_中医体质辨识_阴虚质", TCM_YIXZ_Guide);
	}
	public String getTCM_TSZ_GuideStr() {
		return getNames("健康指导", "健康体检_中医体质辨识_痰湿质", TCM_TSZ_Guide);
	}
	public String getTCM_SRZ_GuideStr() {
		return getNames("健康指导", "健康体检_中医体质辨识_湿热质", TCM_SRZ_Guide);
	}
	public String getTCM_XTZ_GuideStr() {
		return getNames("健康指导", "健康体检_中医体质辨识_血瘀质", TCM_XTZ_Guide);
	}
	public String getTCM_QYZ_GuideStr() {
		return getNames("健康指导", "健康体检_中医体质辨识_气郁质", TCM_QYZ_Guide);
	}
	public String getTCM_TBZ_GuideStr() {
		return getNames("健康指导", "健康体检_中医体质辨识_特秉质", TCM_TBZ_Guide);
	}
	public String[] getSymptoms(){
		return getArray(this.symptom);
	}
	
	public String[] getEatingHabitses(){
		return getArray(this.eatingHabits);
	}
	
	public String[] getDrinkTypes(){
		return getArray(this.drinkType);
	}
	
	public String[] getTCM_QXZ_Guides(){
		return getArray(this.TCM_QXZ_Guide);
	}
	
	public String[] getTCM_YXZ_Guides(){
		return getArray(this.TCM_YXZ_Guide);
	}
	
	public String[] getTCM_YIXZ_Guides(){
		return getArray(this.TCM_YIXZ_Guide);
	}
	
	public String[] getTCM_TSZ_Guides(){
		return getArray(this.TCM_TSZ_Guide);
	}
	
	public String[] getTCM_SRZ_Guides(){
		return getArray(this.TCM_SRZ_Guide);
	}
	
	public String[] getTCM_XTZ_Guides(){
		return getArray(this.TCM_XTZ_Guide);
	}
	
	public String[] getTCM_QYZ_Guides(){
		return getArray(this.TCM_QYZ_Guide);
	}
	
	public String[] getTCM_TBZ_Guides(){
		return getArray(this.TCM_TBZ_Guide);
	}
	
	public String[] getTCM_PHZ_Guides(){
		return getArray(this.TCM_PHZ_Guide);
	}
	
	public String[] getCerebralVessels(){
		return getArray(this.cerebralVessel);
	}
	public String[] getKidneys(){
		return getArray(this.kidney);
	}
	public String[] getHearts(){
		return getArray(this.heart);
	}
	public String[] getBloodPipes(){
		return getArray(this.bloodPipe);
	}
	public String[] getEyeParts(){
		return getArray(this.eyePart);
	}
	public String[] getHealthEvaluate_Descs(){
		return getArray(this.healthEvaluate_Desc);
	}
	public String[] getRiskFactors(){
		return getArray(this.riskFactor);
	}
	public String[] getHealthGuides(){
		return getArray(this.healthGuide);
	}
	public String[] getBreasts() {
		return getArray(this.breast);
	}
}