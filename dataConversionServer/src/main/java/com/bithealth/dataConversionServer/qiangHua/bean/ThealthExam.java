package com.bithealth.dataConversionServer.qiangHua.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName:     ThealthExam.java 
 * @Description:   强华健康体检中间表实体类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年2月25日 下午4:34:45
*****/
public class ThealthExam {
	/**内部主键 */
    private String exGid;
    /**档案内部主键（健康档案号） */
    private String hrGid;
    /**体检编号*/
    private String exId;
    /**档案编号*/
    private String docId;
    /**姓名 */
    private String name;
    /**体检日期 */
    private Date exDate;
    /**责任医师 */
    private String resDoctor;
    /**症状  1.无症状 2.头痛 3.头晕 4.心悸 5.胸闷 6.胸痛 7.慢性咳嗽 8.咳痰 9.呼吸困难 10.多饮 11.多尿 12.体重下降 13.乏力 14.关节肿痛15.视力模糊16.手脚麻木17.尿急18.尿痛 19.便秘 20.腹泻21.恶心呕吐22.眼花 23.耳鸣 24.乳房胀痛 25.其他*/
    private String symptom;
    /**症状2 */
    private String symptom2;
    /**症状3 */
    private String symptom3;
    /**症状4 */
    private String symptom4;
    /**症状5 */
    private String symptom5;
    /**症状6 */
    private String symptom6;
    /**症状7 */
    private String symptom7;
    /**症状8 */
    private String symptom8;
    /**症状9 */
    private String symptom9;
    /**症状10 */
    private String symptom10;	                                                                   
    /**其他症状 */
    private String symptomOth;
    /**体温  单位为℃*/
    private BigDecimal temperature;
    /**脉率 单位为次/min */
    private Short pulseRate;
    /**呼吸频率 单位为次/min */
    private Short resRate;
    /**左侧收缩压 单位为mmHg */
    private Short systolicPreLeft;
    /**左侧舒张压  单位为mmHg*/
    private Short diastolicPreLeft;
    /**右侧收缩压  单位为mmHg*/
    private Short systolicPreRight;
    /**右侧舒张压 单位为mmHg*/
    private Short diastolicPreRight;
    /**身高  单位为cm*/
    private BigDecimal height;
    /**体重 单位为kg */
    private BigDecimal weight;
    /**腰围  单位为cm*/
    private BigDecimal waistCircumference;
    /**体质指数 */
    private BigDecimal bmi;
    /**老年健康自评  1.满意 2.基本满意 3.说不清楚 4.不太满意 5.不满意*/
    private String seothote;
    /**老年生活自评 1 .可自理（0～3分） 2.轻度依赖（4～8分） 3.中度依赖（9～18分) 4.不能自理（≥19分） */
    private String seoloop;
    /**老年认知功能 1.粗筛阴性 2.粗筛阳性 */
    private String cogFuntion;
    /**老年认知功能评分 */
    private Short cogFunScore;
    /**老年情感状态  1.粗筛阴性 2.粗筛阳性*/
    private String emoState;
    /**老年抑郁评分 */
    private Short depScore;
    /**运动频率代码  1.每天 2.每周一次以上 3.偶尔 4.不锻炼*/
    private String exeFrequency;
    /**运动时长 单位为min */
    private Short exeDuration;
    /**坚持运动时间 单位为月 */
    private Short attExeTime;
    /**运动方式说明 */
    private String exeMode;
    /**饮食习惯 1.荤素均衡 2.荤食为主 3.素食为主 4.嗜盐 5.嗜油 6.嗜糖 */
    private String eatHabits;
    /**饮食习惯 2*/
    private String eatHabits2;
    /**饮食习惯3 */
    private String eatHabits3;
    /**吸烟状况 1.从不吸烟 2.过去吸，已戒烟 3.吸烟*/
    private String smoke;
    /**日吸烟量  单位为支*/
    private Short daoSmoking;
    /**开始吸烟年龄 单位为岁 */
    private Short aoSmokingInit;
    /**戒烟年龄 单位为岁 */
    private Short qSmokingAge;
    /**饮酒频率 1.从不 2.偶尔 3.经常 4.每天 */
    private String driFrequency;
    /**日饮酒量 单位为两 */
    private Short alcConsumption;
    /**戒酒标志 1.未戒酒 2.已戒酒 */
    private String alcoholics;
    /**戒酒年龄 单位为岁*/
    private Short allAge;
    /**开始饮酒年龄 单位为岁 */
    private Short drinkingAge;
    /**醉酒标志 1.是 2.否 */
    private String drunk;
    /**饮酒种类  1.白酒2.啤酒3.红酒 4.黄酒 ５.其他*/
    private String driSpecies;
    /**饮酒种类2  */
    private String driSpecies2;
    /**饮酒种类3 */
    private String driSpecies3;
    /**饮酒种类4 */
    private String driSpecies4;
    /**其他酒种类 */
    private String driSpeciesOth;
    /**职业暴露 1.无 2.有 */
    private String occExposure;
    /**危害职业描述  */
    private String occDesc;
    /**危害职业时长 单位为年 */
    private Short occLong;
    /**危险因素名称  （粉尘） */
    private String noRiskFactors;
    /**防护措施标志  1.无 2.有 */
    private String proMeasuresFlag;
    /**防护措施  */
    private String proMeasures;
    /**危险因素名称2 （放射物质） */
    private String noRiskFactors2;
    /**防护措施标志  1.无 2.有 */
    private String proMeasuresFlag2;
    /**防护措施2 （放射物质） */
    private String proMeasures2;
    /**危险因素名称3（物理因素） */
    private String noRiskFactors3;
    /**防护措施标志  1.无 2.有 */
    private String proMeasuresFlag3;
    /**防护措施2 （物理因素） */
    private String proMeasures3;
    /**危险因素名称4（化学物质） */
    private String noRiskFactors4;
    /**防护措施标志  1.无 2.有 */
    private String proMeasuresFlag4;
    /**防护措施2 （化学物质） */
    private String proMeasures4;
    /**其他危险因素名称 */
    private String noRiskFactorsOth;
    /** 其他防护措施标志  1.无 2.有*/
    private String proMeasuresFlagOth;
    /**其他防护措施 */
    private String proMeasuresOth;
    /**口唇外观  1.红润 2.苍白 3.发绀 4.皲裂 5.疱疹 */
    private String lipsApp;
    /**齿列类别  1.正常 2.缺齿 3.龋齿 4.义齿(假牙) */
    private String denCategory;
    /**齿列描述 */
    private String denDesc;
    /**咽部检查结果  1.无充血 2.充血 3.淋巴滤泡增生 */
    private String throatExam;
    /**左眼裸视力 */
    private BigDecimal visionLeft;
    /**右眼裸视力 */
    private BigDecimal visionRight;
    /**左眼矫正视力 */
    private BigDecimal visionCorLeft;
    /**右眼矫正视力 */
    private BigDecimal visionCorRight;
    /**听力  1.听见 2.听不清或无法听见 */
    private String hearing;
    /**运动功能  1.可顺利完成 2.无法独立完成其中任何一个动作 */
    private String motorFun;
    /**眼底检查  1.正常 2.异常 */
    private String fundusExam;
    /**眼底检查描述 */
    private String fundusExamDesc;
    /**皮肤检查  1.正常 2.潮红 3.苍白 4.发绀 5.黄染 6.色素沉着 7.其他*/
    private String skinExam;
    /**皮肤其他说明 */
    private String skinExamDesc;
    /**巩膜检查   1.正常 2.黄染 3.充血 4.其他 */
    private String scleraExam;
    /**巩膜其他说明 */
    private String scleraExamDesc;
    /**淋巴结检查  1.未触及 2.锁骨上 3.腋窝 4.其他 */
    private String lymphExam;
    /**淋巴结其他 */
    private String lymphExamDesc;
    /**桶状胸  1.否 2.是 */
    private String barrelChest;
    /**呼吸音   1.正常 2.异常 */
    private String breathSounds;
    /**呼吸音描述 */
    private String breathSoundsDesc;
    /**罗音  1.无 2.干罗音 3.湿罗音 4.其他 */
    private String rales;
    /**罗音描述 */
    private String ralesDesc;
    /**心率   单位为次/分钟 */
    private Short heartRate;
    /**心率类别   1.心律齐 2.心律不齐 3.心律绝对不齐 */
    private String heartRateType;
    /**心脏杂音  1.无 2.有 */
    private String heartMurmur;
    /**杂音描述 */
    private String heartMurmurDesc;
    /**腹压痛 1.无 2.有 */
    private String abdTend;
    /** 腹压痛描述*/
    private String abdTendDesc;
    /**腹包块   1.无 2.有 */
    private String abdMass;
    /** 腹包块描述*/
    private String abdMassDesc;
    /**肝大标志  1.无 2.有 */
    private String hepatomegaly;
    /**肝大描述 */
    private String hepatomegalyDesc;
    /**脾大标志 1.无 2.有 */
    private String splenomegaly;
    /**脾大描述 */
    private String splenomegalyDesc;
    /**腹移动浊音  1.无 2.有 */
    private String shiDullness;
    /**腹移动浊音描述 */
    private String shiDullnessDesc;
    /**下肢水肿  1.无 2.单侧 3.双侧不对称 4.双侧对称 */
    private String lowExtEdema;
    /**足背动脉搏动 1.未触及2.触及双侧对称3.触及左侧弱或消失4.触及右侧弱或消失 */
    private String dorPedPulse;
    /**肛门指诊  1.未及异常 2.触痛 3.包块 4.前列腺异常 5.其他 */
    private String dre;
    /**肛门指诊描述 */
    private String dreDesc;
    /**乳腺检查  1.未见异常 2.乳房切除 3.异常泌乳4.乳腺包块 5.其他*/
    private String breastExam;
    /**乳腺检查 2*/
    private String breastExam2;
    /**乳腺检查3 */
    private String breastExam3;
    /**乳腺检查4 */
    private String breastExam4;
    /**乳腺检查说明 */
    private String breastExamDesc;
    /**外阴异常  1.未见异常 2.异常 */
    private String genAbn;
    /**外阴异常描述 */
    private String genAbnDesc;
    /**阴道异常  1.未见异常 2.异常 */
    private String vagAbn;
    /**阴道异常描述 */
    private String vagAbnDesc;
    /**宫颈异常   1.未见异常 2.异常 */
    private String cerAbn;
    /**宫颈异常描述 */
    private String cerAbnDesc;
    /**宫体异常    1.未见异常 2.异常*/
    private String palAbn;
    /**宫体异常描述 */
    private String palAbnDesc;
    /**附件异常    1.未见异常 2.异常*/
    private String annAbn;
    /**附件异常描述 */
    private String annAbnDesc;
    /**妇科其他结果 */
    private String gynOther;
    /**血红蛋白  单位为g/L */
    private Short hemoglobin;
    /**白细胞  单位为G/L */
    private BigDecimal leukocyte;
    /**血小板  单位为G/L */
    private Short bloodPlatelet;
    /**血常规其他 */
    private String rouBloodOth;
    /**尿蛋白定性 */
    private String uriProQual;
    /**尿蛋白定量  单位为mg/24h */
    private BigDecimal uriProQuan;
    /**尿糖定性 */
    private String uriSugQual;
    /**尿糖定量   单位为mmol/L*/
    private BigDecimal uriSugQuan;
    /**尿酮体定性 */
    private String uriKetone;
    /**尿潜血 */
    private String uriOccBlo;
    /**尿常规其他 */
    private String urineOth;
    /**空腹血糖  单位为mmol/L */
    private BigDecimal glu;
    /** 餐后血糖  */
    private BigDecimal glu2;
    /**心电异常标志  1.正常 2.异常 */
    private String ecgAbn;
    /**心电异常描述 */
    private String ecgAbnDesc;
    /**尿微量白蛋白  单位为mg/dL */
    private BigDecimal uriAlbumin;
    /**大便潜血  1.阴性 2.阳性 */
    private String fecOccBlo;
    /**糖化血红蛋白  单位为% */
    private BigDecimal glyHem;
    /**乙肝表面抗原  1.阴性 2.阳性 */
    private String hbsag;
    /**血清谷丙转氨酶  单位为U/L */
    private Short cpt;
    /**血清谷草转氨酶  单位为U/L*/
    private Short ast;
    /**白蛋白  单位为g/L */
    private Short alb;
    /**总胆红素  单位为μmol/L */
    private BigDecimal tbil;
    /**结合胆红素 */
    private BigDecimal conBil;
    /**血清肌酐 */
    private BigDecimal cr;
    /**血尿素氮 */
    private BigDecimal bun;
    /**血钾浓度 */
    private BigDecimal potCon;
    /**血钠浓度 */
    private Short sodCon;
    /**总胆固醇 */
    private BigDecimal chol;
    /**甘油三酯 */
    private BigDecimal tg;
    /**血清低密度脂蛋白胆固醇 */
    private BigDecimal ldlC;
    /**血清高密度脂蛋白胆固醇 */
    private BigDecimal hdlC;
    /**胸部X线片  1正常 2异常 */
    private String xRay;
    /**胸部X线片描述 */
    private String xRayDesc;
    /**B超异常标志 1正常 2异常 */
    private String bExc;
    /**B超异常描述 */
    private String bExcDesc;
    /**宫颈涂片标志 */
    private String cerSme;
    /**宫颈涂片描述 */
    private String cerSmeDesc;
    /**其他辅助检查 */
    private String auxExam;
    /**中医_平和质  1.是 2.基本是 */
    private String tcmPhz;
    /**中医_气虚质 */
    private String tcmQxz;
    /**中医_阳虚质 */
    private String tcmYxz;
    /**中医_阴虚质 */
    private String tcmYixz;
    /**中医_痰湿质 */
    private String tcmTsz;
    /**中医_温热质 */
    private String tcmSrz;
    /**中医_血瘀质 */
    private String tcmXtz;
    /**中医_气郁质 */
    private String tcmQyz;
    /**中医_特秉质 */
    private String tcmTbz;
    /**脑血管疾病    1.未发现 2.缺血性卒中 3.脑出血 4.蛛网膜下腔出血 5.短暂性脑缺血发作 6.其他*/
    private String cerDis;
    /**脑血管疾病2 */
    private String cerDis2;
    /**脑血管疾病3 */
    private String cerDis3;
    /**脑血管疾病4 */
    private String cerDis4;
    /**脑血管疾病5 */
    private String cerDis5;
    /**其他脑血管疾病 */
    private String cerDisOth;
    /**肾脏疾病  1.未发现 2.糖尿病肾病 3.肾功能衰竭 4.急性肾炎 5.慢性肾炎 6.其他 */
    private String kidDis;
    /**肾脏疾病2 */
    private String kidDis2;
    /**肾脏疾病3 */
    private String kidDis3;
    /**肾脏疾病4 */
    private String kidDis4;
    /**肾脏疾病 5*/
    private String kidDis5;
    /**其他肾脏疾病 */
    private String kidDisOth;
    /**心脏疾病  1.未发现 2.心肌梗死 3.心绞痛 4.冠状动脉血运重建 5.充血性心力衰竭 6.心前区疼痛 7.其他 */
    private String heaDis;
    /**心脏疾病2 */
    private String heaDis2;
    /**心脏疾病3 */
    private String heaDis3;
    /**心脏疾病4 */
    private String heaDis4;
    /**心脏疾病5 */
    private String heaDis5;
    /**其他心脏疾病 */
    private String heaDisOth;
    /**血管疾病   1.未发现 2.夹层动脉瘤 3.动脉闭塞性疾病 4.其他*/
    private String vasDis;
    /**血管疾病2 */
    private String vasDis2;
    /**血管疾病3 */
    private String vasDis3;
    /**其他血管疾病 */
    private String vasDisOth;
    /**眼部疾病   1.未发现 2.视网膜出血或渗出 3.视乳头水肿 4.白内障 5.其他*/
    private String eyeDis;
    /**眼部疾病2 */
    private String eyeDis2;
    /**眼部疾病3 */
    private String eyeDis3;
    /**其他眼部疾病 */
    private String eyeDisOth;
    /**神经系统疾病  1未发现 2有 */
    private String nerDis;
    /**神经系统疾病说明 */
    private String nerDisDes;
    /**其他系统疾病  1未发现 2有 */
    private String otherDis;
    /**其他疾病说明 */
    private String otherDisDes;
    /**入院日期 */
    private Date admDate;
    /**出院日期 */
    private Date disDate;
    /**入院原因 */
    private String admRes;
    /**住院医疗机构 */
    private String inpHospital;
    /**住院病案号 */
    private String inpNo;
    /**入院日期2 */
    private Date admDate2;
    /**出院日期2 */
    private Date disDate2;
    /**入院原因2 */
    private String admRes2;
    /**住院医疗机构2 */
    private String inpHospital2;
    /**住院病案号2 */
    private String inpNo2;
    /**建床日期 */
    private Date hbStrDate;
    /**撤床日期 */
    private Date hbStoDate;
    /**建床原因 */
    private String hbRes;
    /**家床医疗机构 */
    private String hbHospital;
    /** 家床病案号*/
    private String hbIpNo;
    /** 建床日期2*/
    private Date hbStrDate2;
    /** 撤床日期2*/
    private Date hbStoDate2;
    /**建床原因2 */
    private String hbRes2;
    /**家床医疗机构2 */
    private String hbHospital2;
    /**家床病案号2 */
    private String hbIpNo2;
    /**疫苗名称 */
    private String vaccine;
    /**接种日期 */
    private Date vaccineDate;
    /**接种机构 */
    private String vaccineIns;
    /**疫苗名称2 */
    private String vaccine2;
    /**接种日期2 */
    private Date vaccineDate2;
    /**接种机构 2 */
    private String vaccineIns2;
    /**疫苗名称3 */
    private String vaccine3;
    /**接种日期3 */
    private Date vaccineDate3;
    /**接种机构 3 */
    private String vaccineIns3;
    /**健康评价结果  1.体检无异常 2.有异常 */
    private String heaAssAbnFlag;
    /**健康评价异常 */
    private String heaAssAbn;
    /**健康评价异常2 */
    private String heaAssAbn2;
    /**健康评价异常3 */
    private String heaAssAbn3;
    /**健康评价异常4 */
    private String heaAssAbn4;
    /**健康指导    1.纳入慢性病患者健康管理 2.建议复查 3.建议转诊*/
    private String heaGui;
    /**健康指导2 */
    private String heaGui2;
    /**健康指导3 */
    private String heaGui3;
    /**危险控制建议  1.戒烟 2.健康饮酒 3.饮食 4.锻炼 5.减体重 6.建议接种疫苗 7.其他 */
    private String hazConRec;
    /**危险控制建议2 */
    private String hazConRec2;
    /**危险控制建议3 */
    private String hazConRec3;
    /**危险控制建议4 */
    private String hazConRec4;
    /**危险控制建议5 */
    private String hazConRec5;
    /**危险控制建议6 */
    private String hazConRec6;
    /**目标体重 */
    private BigDecimal tarWeight;
    /**建设疫苗 */
    private String vaccineRec;
    /**其他建议 */
    private String otherRec;
    /**体检机构 */
    private String examOrg;
    /**记录人 */
    private String recUser;
    /**记录日期 */
    private Date recDate;
    /**更新人 */
    private String updUser;
    /**更新日期 */
    private Date updDate;
    /** 数据标识*/
    private String dataFlag;
    /** */
    private Integer archiveId;
    /** */
    private Integer medicalNo;
    
    /**中科汇康体检数据主键*/
    private Integer hexamid;

	public Integer getHexamid() {
		return hexamid;
	}
	public void setHexamid(Integer hexamid) {
		this.hexamid = hexamid;
	}
	public String getExGid() {
		return exGid;
	}
	public void setExGid(String exGid) {
		this.exGid = exGid;
	}
	public String getHrGid() {
		return hrGid;
	}
	public void setHrGid(String hrGid) {
		this.hrGid = hrGid;
	}
	public String getExId() {
		return exId;
	}
	public void setExId(String exId) {
		this.exId = exId;
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
	public Date getExDate() {
		return exDate;
	}
	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}
	public String getResDoctor() {
		return resDoctor;
	}
	public void setResDoctor(String resDoctor) {
		this.resDoctor = resDoctor;
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
	public String getSymptom9() {
		return symptom9;
	}
	public void setSymptom9(String symptom9) {
		this.symptom9 = symptom9;
	}
	public String getSymptom10() {
		return symptom10;
	}
	public void setSymptom10(String symptom10) {
		this.symptom10 = symptom10;
	}
	public String getSymptomOth() {
		return symptomOth;
	}
	public void setSymptomOth(String symptomOth) {
		this.symptomOth = symptomOth;
	}
	public BigDecimal getTemperature() {
		return temperature;
	}
	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}
	public Short getPulseRate() {
		return pulseRate;
	}
	public void setPulseRate(Short pulseRate) {
		this.pulseRate = pulseRate;
	}
	public Short getResRate() {
		return resRate;
	}
	public void setResRate(Short resRate) {
		this.resRate = resRate;
	}
	public Short getSystolicPreLeft() {
		return systolicPreLeft;
	}
	public void setSystolicPreLeft(Short systolicPreLeft) {
		this.systolicPreLeft = systolicPreLeft;
	}
	public Short getDiastolicPreLeft() {
		return diastolicPreLeft;
	}
	public void setDiastolicPreLeft(Short diastolicPreLeft) {
		this.diastolicPreLeft = diastolicPreLeft;
	}
	public Short getSystolicPreRight() {
		return systolicPreRight;
	}
	public void setSystolicPreRight(Short systolicPreRight) {
		this.systolicPreRight = systolicPreRight;
	}
	public Short getDiastolicPreRight() {
		return diastolicPreRight;
	}
	public void setDiastolicPreRight(Short diastolicPreRight) {
		this.diastolicPreRight = diastolicPreRight;
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
	public BigDecimal getWaistCircumference() {
		return waistCircumference;
	}
	public void setWaistCircumference(BigDecimal waistCircumference) {
		this.waistCircumference = waistCircumference;
	}
	public BigDecimal getBmi() {
		return bmi;
	}
	public void setBmi(BigDecimal bmi) {
		this.bmi = bmi;
	}
	public String getSeothote() {
		return seothote;
	}
	public void setSeothote(String seothote) {
		this.seothote = seothote;
	}
	public String getSeoloop() {
		return seoloop;
	}
	public void setSeoloop(String seoloop) {
		this.seoloop = seoloop;
	}
	public String getCogFuntion() {
		return cogFuntion;
	}
	public void setCogFuntion(String cogFuntion) {
		this.cogFuntion = cogFuntion;
	}
	public Short getCogFunScore() {
		return cogFunScore;
	}
	public void setCogFunScore(Short cogFunScore) {
		this.cogFunScore = cogFunScore;
	}
	public String getEmoState() {
		return emoState;
	}
	public void setEmoState(String emoState) {
		this.emoState = emoState;
	}
	public Short getDepScore() {
		return depScore;
	}
	public void setDepScore(Short depScore) {
		this.depScore = depScore;
	}
	public String getExeFrequency() {
		return exeFrequency;
	}
	public void setExeFrequency(String exeFrequency) {
		this.exeFrequency = exeFrequency;
	}
	public Short getExeDuration() {
		return exeDuration;
	}
	public void setExeDuration(Short exeDuration) {
		this.exeDuration = exeDuration;
	}
	public Short getAttExeTime() {
		return attExeTime;
	}
	public void setAttExeTime(Short attExeTime) {
		this.attExeTime = attExeTime;
	}
	public String getExeMode() {
		return exeMode;
	}
	public void setExeMode(String exeMode) {
		this.exeMode = exeMode;
	}
	public String getEatHabits() {
		return eatHabits;
	}
	public void setEatHabits(String eatHabits) {
		this.eatHabits = eatHabits;
	}
	public String getEatHabits2() {
		return eatHabits2;
	}
	public void setEatHabits2(String eatHabits2) {
		this.eatHabits2 = eatHabits2;
	}
	public String getEatHabits3() {
		return eatHabits3;
	}
	public void setEatHabits3(String eatHabits3) {
		this.eatHabits3 = eatHabits3;
	}
	public String getSmoke() {
		return smoke;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public Short getDaoSmoking() {
		return daoSmoking;
	}
	public void setDaoSmoking(Short daoSmoking) {
		this.daoSmoking = daoSmoking;
	}
	public Short getAoSmokingInit() {
		return aoSmokingInit;
	}
	public void setAoSmokingInit(Short aoSmokingInit) {
		this.aoSmokingInit = aoSmokingInit;
	}
	public Short getQSmokingAge() {
		return qSmokingAge;
	}
	public void setQSmokingAge(Short qSmokingAge) {
		this.qSmokingAge = qSmokingAge;
	}
	public String getDriFrequency() {
		return driFrequency;
	}
	public void setDriFrequency(String driFrequency) {
		this.driFrequency = driFrequency;
	}
	public Short getAlcConsumption() {
		return alcConsumption;
	}
	public void setAlcConsumption(Short alcConsumption) {
		this.alcConsumption = alcConsumption;
	}
	public String getAlcoholics() {
		return alcoholics;
	}
	public void setAlcoholics(String alcoholics) {
		this.alcoholics = alcoholics;
	}
	public Short getAllAge() {
		return allAge;
	}
	public void setAllAge(Short allAge) {
		this.allAge = allAge;
	}
	public Short getDrinkingAge() {
		return drinkingAge;
	}
	public void setDrinkingAge(Short drinkingAge) {
		this.drinkingAge = drinkingAge;
	}
	public String getDrunk() {
		return drunk;
	}
	public void setDrunk(String drunk) {
		this.drunk = drunk;
	}
	public String getDriSpecies() {
		return driSpecies;
	}
	public void setDriSpecies(String driSpecies) {
		this.driSpecies = driSpecies;
	}
	public String getDriSpecies2() {
		return driSpecies2;
	}
	public void setDriSpecies2(String driSpecies2) {
		this.driSpecies2 = driSpecies2;
	}
	public String getDriSpecies3() {
		return driSpecies3;
	}
	public void setDriSpecies3(String driSpecies3) {
		this.driSpecies3 = driSpecies3;
	}
	public String getDriSpecies4() {
		return driSpecies4;
	}
	public void setDriSpecies4(String driSpecies4) {
		this.driSpecies4 = driSpecies4;
	}
	public String getDriSpeciesOth() {
		return driSpeciesOth;
	}
	public void setDriSpeciesOth(String driSpeciesOth) {
		this.driSpeciesOth = driSpeciesOth;
	}
	public String getOccExposure() {
		return occExposure;
	}
	public void setOccExposure(String occExposure) {
		this.occExposure = occExposure;
	}
	public String getOccDesc() {
		return occDesc;
	}
	public void setOccDesc(String occDesc) {
		this.occDesc = occDesc;
	}
	public Short getOccLong() {
		return occLong;
	}
	public void setOccLong(Short occLong) {
		this.occLong = occLong;
	}
	public String getNoRiskFactors() {
		return noRiskFactors;
	}
	public void setNoRiskFactors(String noRiskFactors) {
		this.noRiskFactors = noRiskFactors;
	}
	public String getProMeasuresFlag() {
		return proMeasuresFlag;
	}
	public void setProMeasuresFlag(String proMeasuresFlag) {
		this.proMeasuresFlag = proMeasuresFlag;
	}
	public String getProMeasures() {
		return proMeasures;
	}
	public void setProMeasures(String proMeasures) {
		this.proMeasures = proMeasures;
	}
	public String getNoRiskFactors2() {
		return noRiskFactors2;
	}
	public void setNoRiskFactors2(String noRiskFactors2) {
		this.noRiskFactors2 = noRiskFactors2;
	}
	public String getProMeasuresFlag2() {
		return proMeasuresFlag2;
	}
	public void setProMeasuresFlag2(String proMeasuresFlag2) {
		this.proMeasuresFlag2 = proMeasuresFlag2;
	}
	public String getProMeasures2() {
		return proMeasures2;
	}
	public void setProMeasures2(String proMeasures2) {
		this.proMeasures2 = proMeasures2;
	}
	public String getNoRiskFactors3() {
		return noRiskFactors3;
	}
	public void setNoRiskFactors3(String noRiskFactors3) {
		this.noRiskFactors3 = noRiskFactors3;
	}
	public String getProMeasuresFlag3() {
		return proMeasuresFlag3;
	}
	public void setProMeasuresFlag3(String proMeasuresFlag3) {
		this.proMeasuresFlag3 = proMeasuresFlag3;
	}
	public String getProMeasures3() {
		return proMeasures3;
	}
	public void setProMeasures3(String proMeasures3) {
		this.proMeasures3 = proMeasures3;
	}
	public String getNoRiskFactors4() {
		return noRiskFactors4;
	}
	public void setNoRiskFactors4(String noRiskFactors4) {
		this.noRiskFactors4 = noRiskFactors4;
	}
	public String getProMeasuresFlag4() {
		return proMeasuresFlag4;
	}
	public void setProMeasuresFlag4(String proMeasuresFlag4) {
		this.proMeasuresFlag4 = proMeasuresFlag4;
	}
	public String getProMeasures4() {
		return proMeasures4;
	}
	public void setProMeasures4(String proMeasures4) {
		this.proMeasures4 = proMeasures4;
	}
	public String getNoRiskFactorsOth() {
		return noRiskFactorsOth;
	}
	public void setNoRiskFactorsOth(String noRiskFactorsOth) {
		this.noRiskFactorsOth = noRiskFactorsOth;
	}
	public String getProMeasuresFlagOth() {
		return proMeasuresFlagOth;
	}
	public void setProMeasuresFlagOth(String proMeasuresFlagOth) {
		this.proMeasuresFlagOth = proMeasuresFlagOth;
	}
	public String getProMeasuresOth() {
		return proMeasuresOth;
	}
	public void setProMeasuresOth(String proMeasuresOth) {
		this.proMeasuresOth = proMeasuresOth;
	}
	public String getLipsApp() {
		return lipsApp;
	}
	public void setLipsApp(String lipsApp) {
		this.lipsApp = lipsApp;
	}
	public String getDenCategory() {
		return denCategory;
	}
	public void setDenCategory(String denCategory) {
		this.denCategory = denCategory;
	}
	public String getDenDesc() {
		return denDesc;
	}
	public void setDenDesc(String denDesc) {
		this.denDesc = denDesc;
	}
	public String getThroatExam() {
		return throatExam;
	}
	public void setThroatExam(String throatExam) {
		this.throatExam = throatExam;
	}
	public BigDecimal getVisionLeft() {
		return visionLeft;
	}
	public void setVisionLeft(BigDecimal visionLeft) {
		this.visionLeft = visionLeft;
	}
	public BigDecimal getVisionRight() {
		return visionRight;
	}
	public void setVisionRight(BigDecimal visionRight) {
		this.visionRight = visionRight;
	}
	public BigDecimal getVisionCorLeft() {
		return visionCorLeft;
	}
	public void setVisionCorLeft(BigDecimal visionCorLeft) {
		this.visionCorLeft = visionCorLeft;
	}
	public BigDecimal getVisionCorRight() {
		return visionCorRight;
	}
	public void setVisionCorRight(BigDecimal visionCorRight) {
		this.visionCorRight = visionCorRight;
	}
	public String getHearing() {
		return hearing;
	}
	public void setHearing(String hearing) {
		this.hearing = hearing;
	}
	public String getMotorFun() {
		return motorFun;
	}
	public void setMotorFun(String motorFun) {
		this.motorFun = motorFun;
	}
	public String getFundusExam() {
		return fundusExam;
	}
	public void setFundusExam(String fundusExam) {
		this.fundusExam = fundusExam;
	}
	public String getFundusExamDesc() {
		return fundusExamDesc;
	}
	public void setFundusExamDesc(String fundusExamDesc) {
		this.fundusExamDesc = fundusExamDesc;
	}
	public String getSkinExam() {
		return skinExam;
	}
	public void setSkinExam(String skinExam) {
		this.skinExam = skinExam;
	}
	public String getSkinExamDesc() {
		return skinExamDesc;
	}
	public void setSkinExamDesc(String skinExamDesc) {
		this.skinExamDesc = skinExamDesc;
	}
	public String getScleraExam() {
		return scleraExam;
	}
	public void setScleraExam(String scleraExam) {
		this.scleraExam = scleraExam;
	}
	public String getScleraExamDesc() {
		return scleraExamDesc;
	}
	public void setScleraExamDesc(String scleraExamDesc) {
		this.scleraExamDesc = scleraExamDesc;
	}
	public String getLymphExam() {
		return lymphExam;
	}
	public void setLymphExam(String lymphExam) {
		this.lymphExam = lymphExam;
	}
	public String getLymphExamDesc() {
		return lymphExamDesc;
	}
	public void setLymphExamDesc(String lymphExamDesc) {
		this.lymphExamDesc = lymphExamDesc;
	}
	public String getBarrelChest() {
		return barrelChest;
	}
	public void setBarrelChest(String barrelChest) {
		this.barrelChest = barrelChest;
	}
	public String getBreathSounds() {
		return breathSounds;
	}
	public void setBreathSounds(String breathSounds) {
		this.breathSounds = breathSounds;
	}
	public String getBreathSoundsDesc() {
		return breathSoundsDesc;
	}
	public void setBreathSoundsDesc(String breathSoundsDesc) {
		this.breathSoundsDesc = breathSoundsDesc;
	}
	public String getRales() {
		return rales;
	}
	public void setRales(String rales) {
		this.rales = rales;
	}
	public String getRalesDesc() {
		return ralesDesc;
	}
	public void setRalesDesc(String ralesDesc) {
		this.ralesDesc = ralesDesc;
	}
	public Short getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(Short heartRate) {
		this.heartRate = heartRate;
	}
	public String getHeartRateType() {
		return heartRateType;
	}
	public void setHeartRateType(String heartRateType) {
		this.heartRateType = heartRateType;
	}
	public String getHeartMurmur() {
		return heartMurmur;
	}
	public void setHeartMurmur(String heartMurmur) {
		this.heartMurmur = heartMurmur;
	}
	public String getHeartMurmurDesc() {
		return heartMurmurDesc;
	}
	public void setHeartMurmurDesc(String heartMurmurDesc) {
		this.heartMurmurDesc = heartMurmurDesc;
	}
	public String getAbdTend() {
		return abdTend;
	}
	public void setAbdTend(String abdTend) {
		this.abdTend = abdTend;
	}
	public String getAbdTendDesc() {
		return abdTendDesc;
	}
	public void setAbdTendDesc(String abdTendDesc) {
		this.abdTendDesc = abdTendDesc;
	}
	public String getAbdMass() {
		return abdMass;
	}
	public void setAbdMass(String abdMass) {
		this.abdMass = abdMass;
	}
	public String getAbdMassDesc() {
		return abdMassDesc;
	}
	public void setAbdMassDesc(String abdMassDesc) {
		this.abdMassDesc = abdMassDesc;
	}
	public String getHepatomegaly() {
		return hepatomegaly;
	}
	public void setHepatomegaly(String hepatomegaly) {
		this.hepatomegaly = hepatomegaly;
	}
	public String getHepatomegalyDesc() {
		return hepatomegalyDesc;
	}
	public void setHepatomegalyDesc(String hepatomegalyDesc) {
		this.hepatomegalyDesc = hepatomegalyDesc;
	}
	public String getSplenomegaly() {
		return splenomegaly;
	}
	public void setSplenomegaly(String splenomegaly) {
		this.splenomegaly = splenomegaly;
	}
	public String getSplenomegalyDesc() {
		return splenomegalyDesc;
	}
	public void setSplenomegalyDesc(String splenomegalyDesc) {
		this.splenomegalyDesc = splenomegalyDesc;
	}
	public String getShiDullness() {
		return shiDullness;
	}
	public void setShiDullness(String shiDullness) {
		this.shiDullness = shiDullness;
	}
	public String getShiDullnessDesc() {
		return shiDullnessDesc;
	}
	public void setShiDullnessDesc(String shiDullnessDesc) {
		this.shiDullnessDesc = shiDullnessDesc;
	}
	public String getLowExtEdema() {
		return lowExtEdema;
	}
	public void setLowExtEdema(String lowExtEdema) {
		this.lowExtEdema = lowExtEdema;
	}
	public String getDorPedPulse() {
		return dorPedPulse;
	}
	public void setDorPedPulse(String dorPedPulse) {
		this.dorPedPulse = dorPedPulse;
	}
	public String getDre() {
		return dre;
	}
	public void setDre(String dre) {
		this.dre = dre;
	}
	public String getDreDesc() {
		return dreDesc;
	}
	public void setDreDesc(String dreDesc) {
		this.dreDesc = dreDesc;
	}
	public String getBreastExam() {
		return breastExam;
	}
	public void setBreastExam(String breastExam) {
		this.breastExam = breastExam;
	}
	public String getBreastExam2() {
		return breastExam2;
	}
	public void setBreastExam2(String breastExam2) {
		this.breastExam2 = breastExam2;
	}
	public String getBreastExam3() {
		return breastExam3;
	}
	public void setBreastExam3(String breastExam3) {
		this.breastExam3 = breastExam3;
	}
	public String getBreastExam4() {
		return breastExam4;
	}
	public void setBreastExam4(String breastExam4) {
		this.breastExam4 = breastExam4;
	}
	public String getBreastExamDesc() {
		return breastExamDesc;
	}
	public void setBreastExamDesc(String breastExamDesc) {
		this.breastExamDesc = breastExamDesc;
	}
	public String getGenAbn() {
		return genAbn;
	}
	public void setGenAbn(String genAbn) {
		this.genAbn = genAbn;
	}
	public String getGenAbnDesc() {
		return genAbnDesc;
	}
	public void setGenAbnDesc(String genAbnDesc) {
		this.genAbnDesc = genAbnDesc;
	}
	public String getVagAbn() {
		return vagAbn;
	}
	public void setVagAbn(String vagAbn) {
		this.vagAbn = vagAbn;
	}
	public String getVagAbnDesc() {
		return vagAbnDesc;
	}
	public void setVagAbnDesc(String vagAbnDesc) {
		this.vagAbnDesc = vagAbnDesc;
	}
	public String getCerAbn() {
		return cerAbn;
	}
	public void setCerAbn(String cerAbn) {
		this.cerAbn = cerAbn;
	}
	public String getCerAbnDesc() {
		return cerAbnDesc;
	}
	public void setCerAbnDesc(String cerAbnDesc) {
		this.cerAbnDesc = cerAbnDesc;
	}
	public String getPalAbn() {
		return palAbn;
	}
	public void setPalAbn(String palAbn) {
		this.palAbn = palAbn;
	}
	public String getPalAbnDesc() {
		return palAbnDesc;
	}
	public void setPalAbnDesc(String palAbnDesc) {
		this.palAbnDesc = palAbnDesc;
	}
	public String getAnnAbn() {
		return annAbn;
	}
	public void setAnnAbn(String annAbn) {
		this.annAbn = annAbn;
	}
	public String getAnnAbnDesc() {
		return annAbnDesc;
	}
	public void setAnnAbnDesc(String annAbnDesc) {
		this.annAbnDesc = annAbnDesc;
	}
	public String getGynOther() {
		return gynOther;
	}
	public void setGynOther(String gynOther) {
		this.gynOther = gynOther;
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
	public Short getBloodPlatelet() {
		return bloodPlatelet;
	}
	public void setBloodPlatelet(Short bloodPlatelet) {
		this.bloodPlatelet = bloodPlatelet;
	}
	public String getRouBloodOth() {
		return rouBloodOth;
	}
	public void setRouBloodOth(String rouBloodOth) {
		this.rouBloodOth = rouBloodOth;
	}
	public String getUriProQual() {
		return uriProQual;
	}
	public void setUriProQual(String uriProQual) {
		this.uriProQual = uriProQual;
	}
	public BigDecimal getUriProQuan() {
		return uriProQuan;
	}
	public void setUriProQuan(BigDecimal uriProQuan) {
		this.uriProQuan = uriProQuan;
	}
	public String getUriSugQual() {
		return uriSugQual;
	}
	public void setUriSugQual(String uriSugQual) {
		this.uriSugQual = uriSugQual;
	}
	public BigDecimal getUriSugQuan() {
		return uriSugQuan;
	}
	public void setUriSugQuan(BigDecimal uriSugQuan) {
		this.uriSugQuan = uriSugQuan;
	}
	public String getUriKetone() {
		return uriKetone;
	}
	public void setUriKetone(String uriKetone) {
		this.uriKetone = uriKetone;
	}
	public String getUriOccBlo() {
		return uriOccBlo;
	}
	public void setUriOccBlo(String uriOccBlo) {
		this.uriOccBlo = uriOccBlo;
	}
	public String getUrineOth() {
		return urineOth;
	}
	public void setUrineOth(String urineOth) {
		this.urineOth = urineOth;
	}
	public BigDecimal getGlu() {
		return glu;
	}
	public void setGlu(BigDecimal glu) {
		this.glu = glu;
	}
	public BigDecimal getGlu2() {
		return glu2;
	}
	public void setGlu2(BigDecimal glu2) {
		this.glu2 = glu2;
	}
	public String getEcgAbn() {
		return ecgAbn;
	}
	public void setEcgAbn(String ecgAbn) {
		this.ecgAbn = ecgAbn;
	}
	public String getEcgAbnDesc() {
		return ecgAbnDesc;
	}
	public void setEcgAbnDesc(String ecgAbnDesc) {
		this.ecgAbnDesc = ecgAbnDesc;
	}
	public BigDecimal getUriAlbumin() {
		return uriAlbumin;
	}
	public void setUriAlbumin(BigDecimal uriAlbumin) {
		this.uriAlbumin = uriAlbumin;
	}
	public String getFecOccBlo() {
		return fecOccBlo;
	}
	public void setFecOccBlo(String fecOccBlo) {
		this.fecOccBlo = fecOccBlo;
	}
	public BigDecimal getGlyHem() {
		return glyHem;
	}
	public void setGlyHem(BigDecimal glyHem) {
		this.glyHem = glyHem;
	}
	public String getHbsag() {
		return hbsag;
	}
	public void setHbsag(String hbsag) {
		this.hbsag = hbsag;
	}
	public Short getCpt() {
		return cpt;
	}
	public void setCpt(Short cpt) {
		this.cpt = cpt;
	}
	public Short getAst() {
		return ast;
	}
	public void setAst(Short ast) {
		this.ast = ast;
	}
	public Short getAlb() {
		return alb;
	}
	public void setAlb(Short alb) {
		this.alb = alb;
	}
	public BigDecimal getTbil() {
		return tbil;
	}
	public void setTbil(BigDecimal tbil) {
		this.tbil = tbil;
	}
	public BigDecimal getConBil() {
		return conBil;
	}
	public void setConBil(BigDecimal conBil) {
		this.conBil = conBil;
	}
	public BigDecimal getCr() {
		return cr;
	}
	public void setCr(BigDecimal cr) {
		this.cr = cr;
	}
	public BigDecimal getBun() {
		return bun;
	}
	public void setBun(BigDecimal bun) {
		this.bun = bun;
	}
	public BigDecimal getPotCon() {
		return potCon;
	}
	public void setPotCon(BigDecimal potCon) {
		this.potCon = potCon;
	}
	public Short getSodCon() {
		return sodCon;
	}
	public void setSodCon(Short sodCon) {
		this.sodCon = sodCon;
	}
	public BigDecimal getChol() {
		return chol;
	}
	public void setChol(BigDecimal chol) {
		this.chol = chol;
	}
	public BigDecimal getTg() {
		return tg;
	}
	public void setTg(BigDecimal tg) {
		this.tg = tg;
	}
	public BigDecimal getLdlC() {
		return ldlC;
	}
	public void setLdlC(BigDecimal ldlC) {
		this.ldlC = ldlC;
	}
	public BigDecimal getHdlC() {
		return hdlC;
	}
	public void setHdlC(BigDecimal hdlC) {
		this.hdlC = hdlC;
	}
	public String getXRay() {
		return xRay;
	}
	public void setXRay(String xRay) {
		this.xRay = xRay;
	}
	public String getXRayDesc() {
		return xRayDesc;
	}
	public void setXRayDesc(String xRayDesc) {
		this.xRayDesc = xRayDesc;
	}
	public String getBExc() {
		return bExc;
	}
	public void setBExc(String bExc) {
		this.bExc = bExc;
	}
	public String getBExcDesc() {
		return bExcDesc;
	}
	public void setBExcDesc(String bExcDesc) {
		this.bExcDesc = bExcDesc;
	}
	public String getCerSme() {
		return cerSme;
	}
	public void setCerSme(String cerSme) {
		this.cerSme = cerSme;
	}
	public String getCerSmeDesc() {
		return cerSmeDesc;
	}
	public void setCerSmeDesc(String cerSmeDesc) {
		this.cerSmeDesc = cerSmeDesc;
	}
	public String getAuxExam() {
		return auxExam;
	}
	public void setAuxExam(String auxExam) {
		this.auxExam = auxExam;
	}
	public String getTcmPhz() {
		return tcmPhz;
	}
	public void setTcmPhz(String tcmPhz) {
		this.tcmPhz = tcmPhz;
	}
	public String getTcmQxz() {
		return tcmQxz;
	}
	public void setTcmQxz(String tcmQxz) {
		this.tcmQxz = tcmQxz;
	}
	public String getTcmYxz() {
		return tcmYxz;
	}
	public void setTcmYxz(String tcmYxz) {
		this.tcmYxz = tcmYxz;
	}
	public String getTcmYixz() {
		return tcmYixz;
	}
	public void setTcmYixz(String tcmYixz) {
		this.tcmYixz = tcmYixz;
	}
	public String getTcmTsz() {
		return tcmTsz;
	}
	public void setTcmTsz(String tcmTsz) {
		this.tcmTsz = tcmTsz;
	}
	public String getTcmSrz() {
		return tcmSrz;
	}
	public void setTcmSrz(String tcmSrz) {
		this.tcmSrz = tcmSrz;
	}
	public String getTcmXtz() {
		return tcmXtz;
	}
	public void setTcmXtz(String tcmXtz) {
		this.tcmXtz = tcmXtz;
	}
	public String getTcmQyz() {
		return tcmQyz;
	}
	public void setTcmQyz(String tcmQyz) {
		this.tcmQyz = tcmQyz;
	}
	public String getTcmTbz() {
		return tcmTbz;
	}
	public void setTcmTbz(String tcmTbz) {
		this.tcmTbz = tcmTbz;
	}
	public String getCerDis() {
		return cerDis;
	}
	public void setCerDis(String cerDis) {
		this.cerDis = cerDis;
	}
	public String getCerDis2() {
		return cerDis2;
	}
	public void setCerDis2(String cerDis2) {
		this.cerDis2 = cerDis2;
	}
	public String getCerDis3() {
		return cerDis3;
	}
	public void setCerDis3(String cerDis3) {
		this.cerDis3 = cerDis3;
	}
	public String getCerDis4() {
		return cerDis4;
	}
	public void setCerDis4(String cerDis4) {
		this.cerDis4 = cerDis4;
	}
	public String getCerDis5() {
		return cerDis5;
	}
	public void setCerDis5(String cerDis5) {
		this.cerDis5 = cerDis5;
	}
	public String getCerDisOth() {
		return cerDisOth;
	}
	public void setCerDisOth(String cerDisOth) {
		this.cerDisOth = cerDisOth;
	}
	public String getKidDis() {
		return kidDis;
	}
	public void setKidDis(String kidDis) {
		this.kidDis = kidDis;
	}
	public String getKidDis2() {
		return kidDis2;
	}
	public void setKidDis2(String kidDis2) {
		this.kidDis2 = kidDis2;
	}
	public String getKidDis3() {
		return kidDis3;
	}
	public void setKidDis3(String kidDis3) {
		this.kidDis3 = kidDis3;
	}
	public String getKidDis4() {
		return kidDis4;
	}
	public void setKidDis4(String kidDis4) {
		this.kidDis4 = kidDis4;
	}
	public String getKidDis5() {
		return kidDis5;
	}
	public void setKidDis5(String kidDis5) {
		this.kidDis5 = kidDis5;
	}
	public String getKidDisOth() {
		return kidDisOth;
	}
	public void setKidDisOth(String kidDisOth) {
		this.kidDisOth = kidDisOth;
	}
	public String getHeaDis() {
		return heaDis;
	}
	public void setHeaDis(String heaDis) {
		this.heaDis = heaDis;
	}
	public String getHeaDis2() {
		return heaDis2;
	}
	public void setHeaDis2(String heaDis2) {
		this.heaDis2 = heaDis2;
	}
	public String getHeaDis3() {
		return heaDis3;
	}
	public void setHeaDis3(String heaDis3) {
		this.heaDis3 = heaDis3;
	}
	public String getHeaDis4() {
		return heaDis4;
	}
	public void setHeaDis4(String heaDis4) {
		this.heaDis4 = heaDis4;
	}
	public String getHeaDis5() {
		return heaDis5;
	}
	public void setHeaDis5(String heaDis5) {
		this.heaDis5 = heaDis5;
	}
	public String getHeaDisOth() {
		return heaDisOth;
	}
	public void setHeaDisOth(String heaDisOth) {
		this.heaDisOth = heaDisOth;
	}
	public String getVasDis() {
		return vasDis;
	}
	public void setVasDis(String vasDis) {
		this.vasDis = vasDis;
	}
	public String getVasDis2() {
		return vasDis2;
	}
	public void setVasDis2(String vasDis2) {
		this.vasDis2 = vasDis2;
	}
	public String getVasDis3() {
		return vasDis3;
	}
	public void setVasDis3(String vasDis3) {
		this.vasDis3 = vasDis3;
	}
	public String getVasDisOth() {
		return vasDisOth;
	}
	public void setVasDisOth(String vasDisOth) {
		this.vasDisOth = vasDisOth;
	}
	public String getEyeDis() {
		return eyeDis;
	}
	public void setEyeDis(String eyeDis) {
		this.eyeDis = eyeDis;
	}
	public String getEyeDis2() {
		return eyeDis2;
	}
	public void setEyeDis2(String eyeDis2) {
		this.eyeDis2 = eyeDis2;
	}
	public String getEyeDis3() {
		return eyeDis3;
	}
	public void setEyeDis3(String eyeDis3) {
		this.eyeDis3 = eyeDis3;
	}
	public String getEyeDisOth() {
		return eyeDisOth;
	}
	public void setEyeDisOth(String eyeDisOth) {
		this.eyeDisOth = eyeDisOth;
	}
	public String getNerDis() {
		return nerDis;
	}
	public void setNerDis(String nerDis) {
		this.nerDis = nerDis;
	}
	public String getNerDisDes() {
		return nerDisDes;
	}
	public void setNerDisDes(String nerDisDes) {
		this.nerDisDes = nerDisDes;
	}
	public String getOtherDis() {
		return otherDis;
	}
	public void setOtherDis(String otherDis) {
		this.otherDis = otherDis;
	}
	public String getOtherDisDes() {
		return otherDisDes;
	}
	public void setOtherDisDes(String otherDisDes) {
		this.otherDisDes = otherDisDes;
	}
	public Date getAdmDate() {
		return admDate;
	}
	public void setAdmDate(Date admDate) {
		this.admDate = admDate;
	}
	public Date getDisDate() {
		return disDate;
	}
	public void setDisDate(Date disDate) {
		this.disDate = disDate;
	}
	public String getAdmRes() {
		return admRes;
	}
	public void setAdmRes(String admRes) {
		this.admRes = admRes;
	}
	public String getInpHospital() {
		return inpHospital;
	}
	public void setInpHospital(String inpHospital) {
		this.inpHospital = inpHospital;
	}
	public String getInpNo() {
		return inpNo;
	}
	public void setInpNo(String inpNo) {
		this.inpNo = inpNo;
	}
	public Date getAdmDate2() {
		return admDate2;
	}
	public void setAdmDate2(Date admDate2) {
		this.admDate2 = admDate2;
	}
	public Date getDisDate2() {
		return disDate2;
	}
	public void setDisDate2(Date disDate2) {
		this.disDate2 = disDate2;
	}
	public String getAdmRes2() {
		return admRes2;
	}
	public void setAdmRes2(String admRes2) {
		this.admRes2 = admRes2;
	}
	public String getInpHospital2() {
		return inpHospital2;
	}
	public void setInpHospital2(String inpHospital2) {
		this.inpHospital2 = inpHospital2;
	}
	public String getInpNo2() {
		return inpNo2;
	}
	public void setInpNo2(String inpNo2) {
		this.inpNo2 = inpNo2;
	}
	public Date getHbStrDate() {
		return hbStrDate;
	}
	public void setHbStrDate(Date hbStrDate) {
		this.hbStrDate = hbStrDate;
	}
	public Date getHbStoDate() {
		return hbStoDate;
	}
	public void setHbStoDate(Date hbStoDate) {
		this.hbStoDate = hbStoDate;
	}
	public String getHbRes() {
		return hbRes;
	}
	public void setHbRes(String hbRes) {
		this.hbRes = hbRes;
	}
	public String getHbHospital() {
		return hbHospital;
	}
	public void setHbHospital(String hbHospital) {
		this.hbHospital = hbHospital;
	}
	public String getHbIpNo() {
		return hbIpNo;
	}
	public void setHbIpNo(String hbIpNo) {
		this.hbIpNo = hbIpNo;
	}
	public Date getHbStrDate2() {
		return hbStrDate2;
	}
	public void setHbStrDate2(Date hbStrDate2) {
		this.hbStrDate2 = hbStrDate2;
	}
	public Date getHbStoDate2() {
		return hbStoDate2;
	}
	public void setHbStoDate2(Date hbStoDate2) {
		this.hbStoDate2 = hbStoDate2;
	}
	public String getHbRes2() {
		return hbRes2;
	}
	public void setHbRes2(String hbRes2) {
		this.hbRes2 = hbRes2;
	}
	public String getHbHospital2() {
		return hbHospital2;
	}
	public void setHbHospital2(String hbHospital2) {
		this.hbHospital2 = hbHospital2;
	}
	public String getHbIpNo2() {
		return hbIpNo2;
	}
	public void setHbIpNo2(String hbIpNo2) {
		this.hbIpNo2 = hbIpNo2;
	}
	public String getVaccine() {
		return vaccine;
	}
	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	public Date getVaccineDate() {
		return vaccineDate;
	}
	public void setVaccineDate(Date vaccineDate) {
		this.vaccineDate = vaccineDate;
	}
	public String getVaccineIns() {
		return vaccineIns;
	}
	public void setVaccineIns(String vaccineIns) {
		this.vaccineIns = vaccineIns;
	}
	public String getVaccine2() {
		return vaccine2;
	}
	public void setVaccine2(String vaccine2) {
		this.vaccine2 = vaccine2;
	}
	public Date getVaccineDate2() {
		return vaccineDate2;
	}
	public void setVaccineDate2(Date vaccineDate2) {
		this.vaccineDate2 = vaccineDate2;
	}
	public String getVaccineIns2() {
		return vaccineIns2;
	}
	public void setVaccineIns2(String vaccineIns2) {
		this.vaccineIns2 = vaccineIns2;
	}
	public String getVaccine3() {
		return vaccine3;
	}
	public void setVaccine3(String vaccine3) {
		this.vaccine3 = vaccine3;
	}
	public Date getVaccineDate3() {
		return vaccineDate3;
	}
	public void setVaccineDate3(Date vaccineDate3) {
		this.vaccineDate3 = vaccineDate3;
	}
	public String getVaccineIns3() {
		return vaccineIns3;
	}
	public void setVaccineIns3(String vaccineIns3) {
		this.vaccineIns3 = vaccineIns3;
	}
	public String getHeaAssAbnFlag() {
		return heaAssAbnFlag;
	}
	public void setHeaAssAbnFlag(String heaAssAbnFlag) {
		this.heaAssAbnFlag = heaAssAbnFlag;
	}
	public String getHeaAssAbn() {
		return heaAssAbn;
	}
	public void setHeaAssAbn(String heaAssAbn) {
		this.heaAssAbn = heaAssAbn;
	}
	public String getHeaAssAbn2() {
		return heaAssAbn2;
	}
	public void setHeaAssAbn2(String heaAssAbn2) {
		this.heaAssAbn2 = heaAssAbn2;
	}
	public String getHeaAssAbn3() {
		return heaAssAbn3;
	}
	public void setHeaAssAbn3(String heaAssAbn3) {
		this.heaAssAbn3 = heaAssAbn3;
	}
	public String getHeaAssAbn4() {
		return heaAssAbn4;
	}
	public void setHeaAssAbn4(String heaAssAbn4) {
		this.heaAssAbn4 = heaAssAbn4;
	}
	public String getHeaGui() {
		return heaGui;
	}
	public void setHeaGui(String heaGui) {
		this.heaGui = heaGui;
	}
	public String getHeaGui2() {
		return heaGui2;
	}
	public void setHeaGui2(String heaGui2) {
		this.heaGui2 = heaGui2;
	}
	public String getHeaGui3() {
		return heaGui3;
	}
	public void setHeaGui3(String heaGui3) {
		this.heaGui3 = heaGui3;
	}
	public String getHazConRec() {
		return hazConRec;
	}
	public void setHazConRec(String hazConRec) {
		this.hazConRec = hazConRec;
	}
	public String getHazConRec2() {
		return hazConRec2;
	}
	public void setHazConRec2(String hazConRec2) {
		this.hazConRec2 = hazConRec2;
	}
	public String getHazConRec3() {
		return hazConRec3;
	}
	public void setHazConRec3(String hazConRec3) {
		this.hazConRec3 = hazConRec3;
	}
	public String getHazConRec4() {
		return hazConRec4;
	}
	public void setHazConRec4(String hazConRec4) {
		this.hazConRec4 = hazConRec4;
	}
	public String getHazConRec5() {
		return hazConRec5;
	}
	public void setHazConRec5(String hazConRec5) {
		this.hazConRec5 = hazConRec5;
	}
	public String getHazConRec6() {
		return hazConRec6;
	}
	public void setHazConRec6(String hazConRec6) {
		this.hazConRec6 = hazConRec6;
	}
	public BigDecimal getTarWeight() {
		return tarWeight;
	}
	public void setTarWeight(BigDecimal tarWeight) {
		this.tarWeight = tarWeight;
	}
	public String getVaccineRec() {
		return vaccineRec;
	}
	public void setVaccineRec(String vaccineRec) {
		this.vaccineRec = vaccineRec;
	}
	public String getOtherRec() {
		return otherRec;
	}
	public void setOtherRec(String otherRec) {
		this.otherRec = otherRec;
	}
	public String getExamOrg() {
		return examOrg;
	}
	public void setExamOrg(String examOrg) {
		this.examOrg = examOrg;
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
	public Integer getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	public Integer getMedicalNo() {
		return medicalNo;
	}
	public void setMedicalNo(Integer medicalNo) {
		this.medicalNo = medicalNo;
	}
    
    

}