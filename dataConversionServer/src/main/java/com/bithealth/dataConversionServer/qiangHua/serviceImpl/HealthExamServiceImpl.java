package com.bithealth.dataConversionServer.qiangHua.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bithealth.dataConversionServer.assemble.AssemUtil;
import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExam;
import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExamDrug;
import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExamParam;
import com.bithealth.dataConversionServer.qiangHua.dao.ThealthExamDrugMapper;
import com.bithealth.dataConversionServer.qiangHua.dao.ThealthExamMapper;
import com.bithealth.dataConversionServer.qiangHua.service.HealthExamService;
import com.bithealth.dataConversionServer.util.StringUtil;
import com.bithealth.inspectCore.facede.service.PhysicalFacedeService;
import com.bithealth.inspectCore.physical.dao.PhHealthexamMapper;
import com.bithealth.inspectCore.physical.dao.PhHealthexamdetailMapper;
import com.bithealth.inspectCore.physical.dao.PhHealthexamdetailfamilybedMapper;
import com.bithealth.inspectCore.physical.dao.PhHealthexamdetailinpatientMapper;
import com.bithealth.inspectCore.physical.dao.PhHealthexamdetailmedicineMapper;
import com.bithealth.inspectCore.physical.dao.PhHealthexamdetailnonimmuneMapper;
import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetail;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailfamilybed;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailinpatient;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailmedicine;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailnonimmune;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;



/**
 * @ClassName:     HealthExamTask.java 
 * @Description:   体检数据服务实现类入库
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年2月26日 上午10:43:16
*****/
@Service("healthExamService")
public class HealthExamServiceImpl  extends GenericBaseServiceImpl implements HealthExamService{
	
	private Logger logger = Logger.getLogger(HealthExamServiceImpl.class);
	
	@Autowired
	private ThealthExamMapper healthExamDao; //对强华数据操作dao
	
	@Autowired
	private ThealthExamDrugMapper healthExamDrugDao; //对强华数据操作dao
	@Autowired
	private PhysicalFacedeService physicalFacedeService;
	@Autowired
	private MemberService memberService;
	

	
	public List<ThealthExam> queryHealthExanByParam(ThealthExamParam param) throws Exception {
		
		return healthExamDao.findHealthExamList(param);
		
	}

	
	public long getHealthExamCount(ThealthExamParam param) throws Exception {
		
		return healthExamDao.queryHealthExamCount();
	}

	
	public List<ThealthExamDrug> queryHealthExamDrug(List<ThealthExam> exams)throws Exception {
		return healthExamDrugDao.queryHealthExamDrug(exams);
	}

	
	public boolean saveWholeHealthexam(ThealthExam tHealthExam,List<ThealthExamDrug> drugList) throws Exception {
		
		try{
			//体检主表
			 PhHealthexam phHealthexam =  changePhHealthexam(tHealthExam);//(PhHealthexam)AssemUtil.beanToBean(tHealthExam, PhHealthexam.class, "Healthexam.xml");
			 phHealthexam.setRefCompany(Byte.parseByte("1"));
			 
			 //检查该条数据是否已存在
			 PhHealthexam existExam = physicalFacedeService.selectPhHealthexamByParam(phHealthexam.getRefCompany(),phHealthexam.getUnique_ID(),phHealthexam.getRefDataPK());
			 phHealthexam.setCreateTime(new Date());
			 phHealthexam.setGetTime(new Date());
			 if(existExam != null && existExam.getHExamID() != 0){
				 phHealthexam.setHExamID(existExam.getHExamID());
				 phHealthexam.setMemberID(existExam.getMemberID());
				// phHealthexamDao.savePhHealthexam(phHealthexam);
			 }else{
				 Member member = new Member();
//				 omem.setUniqueId(phHealthexam.getUnique_ID());
//				 omem = memberDao.findOmemBeanByParam(omem);
				 member=memberService.selectByUniqueId(phHealthexam.getUnique_ID());
				 if(member != null) {
					 phHealthexam.setMemberID(member.getMemberid());
				 }else{
					 return false;
				 }
				// phHealthexamDao.savePhHealthexam(phHealthexam);
				// tHealthExam.setHexamid(Integer.parseInt(phHealthexam.getHExamID().toString()));
			 }

			 //体检明细表 getChangePhHealthexamdetail(tHealthExam);
			 PhHealthexamdetail thexamdetail = (PhHealthexamdetail)AssemUtil.beanToBean(tHealthExam, PhHealthexamdetail.class, "HealthexamDetail.xml");
			 phHealthexam.setPhHealthexamdetail(thexamdetail);
			 
			 // phExamdetailDao.savePhHealthexamdetail(thexamdetail);
			 //体检-家庭病床史
			 List<PhHealthexamdetailfamilybed> familybedList = new ArrayList<PhHealthexamdetailfamilybed>();
			 PhHealthexamdetailfamilybed familybed = changePhHealthexamdetailfamilybed(tHealthExam,1);//(PhHealthexamdetailfamilybed)AssemUtil.beanToBean(tHealthExam, PhHealthexamdetailfamilybed.class, "HealthexamDetailFamilybed.xml");
			 PhHealthexamdetailfamilybed familybed2 = changePhHealthexamdetailfamilybed(tHealthExam,1);//(PhHealthexamdetailfamilybed)AssemUtil.beanToBean(tHealthExam, PhHealthexamdetailfamilybed.class, "HealthexamDetailFamilybed2.xml");
			 familybedList.add(familybed);
			 familybedList.add(familybed2);
			// phFamilybedDao.deletePhHealthexamdetailfamilybed(tHealthExam.getHexamid());
			 if(familybedList.size() > 0){
//				 phFamilybedDao.savePhHealthexamdetailfamilybed(familybedList);
				// physicalFacedeService.
				 phHealthexam.setPhHealthexamdetailfamilybeds(familybedList);
			 }
			 //体检-住院史  
			 List<PhHealthexamdetailinpatient> inpatientList = new ArrayList<PhHealthexamdetailinpatient>();
			 PhHealthexamdetailinpatient inpatient = changePhHealthexamdetailinpatient(tHealthExam,1);//(PhHealthexamdetailinpatient)AssemUtil.beanToBean(tHealthExam, PhHealthexamdetailinpatient.class, "Healthexamdetailinpatient.xml");
			 PhHealthexamdetailinpatient inpatient2 = changePhHealthexamdetailinpatient(tHealthExam,2);//(PhHealthexamdetailinpatient)AssemUtil.beanToBean(tHealthExam, PhHealthexamdetailinpatient.class, "Healthexamdetailinpatient2.xml");
			 inpatientList.add(inpatient);
			 inpatientList.add(inpatient2);
			// phInpatientDao.deletePhHealthexamdetailinpatient(tHealthExam.getHexamid());
			 if(inpatientList.size() > 0){
				// phInpatientDao.savePhHealthexamdetailinpatient(inpatientList);
				 phHealthexam.setPhHealthexamdetailinpatients(inpatientList);
			 }
			 //体检-用药情况 
			 List<PhHealthexamdetailmedicine> medicineList = new ArrayList<PhHealthexamdetailmedicine>();
			 for(ThealthExamDrug drug:drugList){
				 if(!StringUtil.isEmpty(tHealthExam.getExGid()) && tHealthExam.getExGid().equals(drug.getExGid())){
					 drug.setHexamid(Integer.parseInt(phHealthexam.getHExamID().toString()));
					 drug.setHexamid(tHealthExam.getHexamid());
					 PhHealthexamdetailmedicine medicine =getChangePhHealthexamdetailmedicine(drug); //(PhHealthexamdetailmedicine)AssemUtil.beanToBean(drug, PhHealthexamdetailmedicine.class, "Healthexamdetailmedicine.xml");
					 medicineList.add(medicine);
				 }
			 }
			// phMedicinetDao.deletePhHealthexamdetailmedicine(tHealthExam.getHexamid());
			 if(medicineList.size() > 0){
				// phMedicinetDao.savePhHealthexamdetailmedicine(medicineList);
				 phHealthexam.setPhHealthexamdetailmedicines(medicineList);
			 }
			 //体检-预防接种
			 List<PhHealthexamdetailnonimmune> nonimmuneList = new ArrayList<PhHealthexamdetailnonimmune>();
			 PhHealthexamdetailnonimmune  nonimmune = getChangePhHealthexamdetailnonimmune(tHealthExam,1);//(PhHealthexamdetailnonimmune)AssemUtil.beanToBean(tHealthExam, PhHealthexamdetailnonimmune.class, "Healthexamdetailnonimmune.xml");
			 PhHealthexamdetailnonimmune  nonimmune2 = getChangePhHealthexamdetailnonimmune(tHealthExam,2);//(PhHealthexamdetailnonimmune)AssemUtil.beanToBean(tHealthExam, PhHealthexamdetailnonimmune.class, "Healthexamdetailnonimmune2.xml");
			 PhHealthexamdetailnonimmune  nonimmune3 = getChangePhHealthexamdetailnonimmune(tHealthExam,3);//(PhHealthexamdetailnonimmune)AssemUtil.beanToBean(tHealthExam, PhHealthexamdetailnonimmune.class, "Healthexamdetailnonimmune3.xml");
			 nonimmuneList.add(nonimmune);
			 nonimmuneList.add(nonimmune2);
			 nonimmuneList.add(nonimmune3);
			// phNonimmuneDao.deletePhHealthexamdetailnonimmune(tHealthExam.getHexamid());
			 if(nonimmuneList.size() > 0){
				// phNonimmuneDao.savePhHealthexamdetailnonimmune(nonimmuneList);
				 phHealthexam.setPhHealthexamdetailnonimmunes(nonimmuneList);
			 }
			 phHealthexam.setCreateDrID(0);
			 phHealthexam.setCreateDrName("系统用户");
			 boolean bol=physicalFacedeService.insertOrUpdatePhHealthexam(phHealthexam);
			 return bol;
		}catch(Exception e){
			logger.error("保存体检数据异常."+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	
	private PhHealthexam changePhHealthexam(ThealthExam t){
		PhHealthexam h  = new PhHealthexam();
		h.setUnique_ID(t.getHrGid());
		h.setRefDataPK(t.getExId());
		h.setName(t.getName());
		h.setExamDate(t.getExDate());
		h.setResponsibleDrName(t.getResDoctor());
		return h;
	}
	
	
	private PhHealthexamdetailinpatient  changePhHealthexamdetailinpatient(ThealthExam t,int num){
		PhHealthexamdetailinpatient ph = new PhHealthexamdetailinpatient();
		
		if(null!=t.getHexamid()&& 0!=t.getHexamid()){
			ph.setHExamID(Long.parseLong(t.getHexamid()+""));
		}
		if(num==1){
			ph.setStartDate(t.getAdmDate());
			ph.setEndTime(t.getDisDate());
			ph.setResson(t.getAdmRes());
			ph.setInstitution(t.getInpHospital());
			ph.setPatientID(t.getInpNo());
		}else{
			ph.setStartDate(t.getAdmDate2());
			ph.setEndTime(t.getDisDate2());
			ph.setResson(t.getAdmRes2());
			ph.setInstitution(t.getInpHospital2());
			ph.setPatientID(t.getInpNo2());
		}
		return ph;
	}
	
	private PhHealthexamdetailfamilybed changePhHealthexamdetailfamilybed(ThealthExam t,int num){
		PhHealthexamdetailfamilybed b = new PhHealthexamdetailfamilybed();
		if(null!=t.getHexamid()&& 0!=t.getHexamid()){
			b.setHExamID(Long.parseLong(t.getHexamid()+""));
		}
		 if(num==1){
			 b.setStartDate(t.getAdmDate());
			 b.setEndTime(t.getDisDate());
			 b.setResson(t.getAdmRes());
			 b.setInstitution(t.getInpHospital());
			 b.setPatientID(t.getInpNo());
		 }else{
			 b.setStartDate(t.getAdmDate2());
			 b.setEndTime(t.getDisDate2());
			 b.setResson(t.getAdmRes2());
			 b.setInstitution(t.getInpHospital2());
			 b.setPatientID(t.getInpNo2());
		 }
		
		 return b;
	}
	
	private PhHealthexamdetailmedicine getChangePhHealthexamdetailmedicine(ThealthExamDrug t){
		PhHealthexamdetailmedicine m= new PhHealthexamdetailmedicine();
		if(null!=t.getHexamid()&& 0!=t.getHexamid()){
			m.setHExamID(Long.parseLong(t.getHexamid()+""));
		}
		
		m.setDrugName(t.getDrugName());
		m.setDrugUsage(t.getDrugUsage());
		m.setDrugFreq(t.getDrugFreq());
		m.setDrugDosage(t.getDrugUsage());
		m.setDrugUseTime(t.getDrugTime());
		m.setDrugCompliance(Byte.parseByte(t.getMedCom()));
		return m;
	}
	
	private PhHealthexamdetailnonimmune getChangePhHealthexamdetailnonimmune(ThealthExam  t,int num){
		PhHealthexamdetailnonimmune d = new PhHealthexamdetailnonimmune();
		if(null!=t.getHexamid()&& 0!=t.getHexamid()){
			d.setHExamID(Long.parseLong(t.getHexamid()+""));
		}
		if(num==1){
			d.setVaccinateDate(t.getVaccineDate());
			d.setVaccinateName(t.getVaccine());
			d.setInstitution(t.getVaccine());
		}else if(num==2){
			d.setVaccinateDate(t.getVaccineDate2());
			d.setVaccinateName(t.getVaccine2());
			d.setInstitution(t.getVaccine2());
		}else{
			d.setVaccinateDate(t.getVaccineDate3());
			d.setVaccinateName(t.getVaccine3());
			d.setInstitution(t.getVaccine3());
		}
		
		return d;
	}
	
	private PhHealthexamdetail getChangePhHealthexamdetail(ThealthExam  t){
		PhHealthexamdetail de = new PhHealthexamdetail();
			de.setSymptom_Desc(t.getSymptomOth());
			de.setBodyTemperature(t.getTemperature());
			de.setPulseRate(t.getPulseRate());
			de.setLeftSystolic(t.getSystolicPreLeft());
			de.setLeftDiastolic(t.getDiastolicPreLeft());
			de.setRightSystolic(t.getSystolicPreRight());
			de.setRightDiastolic(t.getDiastolicPreRight());
			de.setHeight(t.getHeight());
			de.setWeight(t.getWeight());
			de.setWaist(t.getWaistCircumference());
			de.setBMI(t.getBmi());
			de.setAgedHealthEvaluate(Byte.parseByte(t.getSeothote().toString()));
			de.setAgedLifeEvaluate(Byte.parseByte(t.getSeoloop().toString()));
			de.setAgedCognition(Byte.parseByte(t.getCogFuntion()));
			de.setAgedCognitionScore(Byte.parseByte(t.getCogFunScore()+""));
			de.setAgedFeeling(Byte.parseByte(t.getEmoState()));
			de.setAgedFeelingScore(Byte.parseByte(t.getDepScore().toString()));
			de.setSportFrequency(Byte.parseByte(t.getExeFrequency()));
			de.setSportDuration(t.getExeDuration());
			de.setSportTotalTime(Byte.parseByte(t.getAttExeTime().toString()));
			de.setSportWay(t.getExeMode());
			de.setEatingHabits(t.getEatHabits());//
			de.setSmokingState(Byte.parseByte(t.getSmoke()));
			de.setDailySmoking(t.getDaoSmoking());
			de.setSmokingEndAge(Byte.parseByte(t.getQSmokingAge().toString()));
			de.setDrinkFrequency(Byte.parseByte(t.getDriFrequency()));
			de.setDailyDrink(t.getAlcConsumption());
			de.setIsAbstinence(Byte.parseByte(t.getAlcoholics()));
			de.setAbstinenceAge(Byte.parseByte(t.getAllAge().toString()));
			de.setDrinkStartAge(Byte.parseByte(t.getDrinkingAge().toString()));
			de.setIsTemulenceLastYear(Byte.parseByte(t.getDrunk()));
			de.setDrinkType(t.getDriSpecies());//
			de.setDrinkOther_Desc(t.getDriSpeciesOth());
			de.setOccupation(Byte.parseByte(t.getOccExposure()));
			de.setTypeOfWork(t.getOccDesc());
			de.setWorkTime(Byte.parseByte(t.getOccLong().toString()));
			de.setDust(t.getNoRiskFactors());
			de.setDustGuard(Byte.parseByte(t.getProMeasuresFlag()));
			de.setDustGuard_Desc(t.getProMeasures());
			de.setRadiogen(t.getNoRiskFactors2());
			de.setRadiogenGuard(Byte.parseByte(t.getProMeasuresFlag2()));
			de.setRadiogenGuard_Desc(t.getProMeasures2());
			de.setPhysical(t.getNoRiskFactors3());
			de.setPhysicalGuard(Byte.parseByte(t.getProMeasuresFlag3()));
			de.setPhysicalGuard_Desc(t.getProMeasures3());
			de.setChemical(t.getNoRiskFactors4());
			de.setChemicalGuard(Byte.parseByte(t.getProMeasuresFlag4()));
			de.setChemicalGuard_Desc(t.getProMeasures4());
			de.setToxicOther(t.getNoRiskFactorsOth());
			de.setToxicOtherGuard(Byte.parseByte(t.getProMeasuresFlagOth()));
			de.setToxicOtherGuard_Desc(t.getProMeasuresOth());
			de.setLips(Byte.parseByte(t.getLipsApp()));
			de.setDentition(Byte.parseByte(t.getDenCategory()));
			de.setDentition_Desc(t.getDenDesc());
			de.setThroat(Byte.parseByte(t.getThroatExam()));
			de.setLeftVision(t.getVisionLeft());
			de.setRightVision(t.getVisionRight());
			de.setLeftCorrectVision(t.getVisionCorLeft());
			de.setRightCorrectVision(t.getVisionCorRight());
			de.setHearing(Byte.parseByte(t.getHearing()));
			de.setMovement(Byte.parseByte(t.getMotorFun()));
			de.setEyeground(Byte.parseByte(t.getFundusExam()));
			de.setEyeground_Desc(t.getFundusExamDesc());
			de.setSkin(Byte.parseByte(t.getSkinExam()));
			de.setSkin_Desc(t.getSkinExamDesc());
			
			de.setSclero(Byte.parseByte(t.getScleraExam()));
			de.setSclero_Desc(t.getScleraExamDesc());
			de.setLymph(Byte.parseByte(t.getLymphExam()));
			de.setLymph_Desc(t.getLymphExamDesc());
			de.setLungBarrelChest(Byte.parseByte(t.getBarrelChest()));
			de.setLungBreathSounds(Byte.parseByte(t.getBreathSounds()));
			de.setLungBreathSounds_Desc(t.getBreathSoundsDesc());
			de.setLungRales(Byte.parseByte(t.getRales()));
			de.setLungRales_Desc(t.getRalesDesc());
			de.setHeartRate(t.getHeartRate());
			de.setRhythm(Byte.parseByte(t.getHeartRateType()));
			de.setMurmur(Byte.parseByte(t.getHeartMurmur()));
			de.setMurmur_Desc(t.getHeartMurmurDesc());
			de.setPain(Byte.parseByte(t.getAbdTend()));
			de.setPain_Desc(t.getAbdTendDesc());
			de.setBlock(Byte.parseByte(t.getAbdMass()));
			de.setBlock_Desc(t.getAbdMassDesc());
			de.setHepatomegaly(Byte.parseByte(t.getHepatomegaly()));
			de.setHepatomegaly_Desc(t.getHepatomegalyDesc());
			
			
			de.setSplenomegaly(Byte.parseByte(t.getSplenomegaly()));
			de.setSplenomegaly_Desc(t.getSplenomegalyDesc());
			de.setMoveSonant(Byte.parseByte(t.getShiDullness()));
			de.setMoveSonant_Desc(t.getShiDullnessDesc());
			de.setLowLimbEdema(Byte.parseByte(t.getLowExtEdema()));
			de.setArteriopalmus(Byte.parseByte(t.getDorPedPulse()));
			de.setAnusTactus(Byte.parseByte(t.getDre()));
			de.setAnusTactus_Desc(t.getDreDesc());
			de.setBreast(t.getBreastExam());//
			de.setBreast_Desc(t.getBreastExamDesc());
			de.setPudendum(Byte.parseByte(t.getGenAbn()));
			de.setPudendum_Desc(t.getGenAbnDesc());
			de.setVagina(Byte.parseByte(t.getVagAbn()));
			de.setVagina_Desc(t.getVagAbnDesc());
			de.setCervical(Byte.parseByte(t.getCerAbn()));
			de.setCervical_Desc(t.getCerAbnDesc());
			de.setCervicalSmear(Byte.parseByte(t.getCerSme()));
			de.setCervicalSmear_Desc(t.getCerSmeDesc());
			
			de.setUteri(Byte.valueOf(t.getPalAbn()));
			de.setUteri_Desc(t.getPalAbnDesc());
			de.setEnclosure(Byte.valueOf(t.getAnnAbn()));
			de.setEnclosure_Desc(t.getAnnAbnDesc());
			de.setGynaecologyOther(t.getGynOther());
			de.setHemoglobin(t.getHemoglobin());
			de.setLeukocyte(t.getLeukocyte());
			de.setPlatelet(t.getBloodPlatelet());
			de.setBloodOther(t.getRouBloodOth());
			de.setUrineProtein(t.getUriProQual());
			de.setUrineSugar(t.getUriSugQual());
			de.setUrineAcetoneBody(t.getUriKetone());
			de.setUrineOccultBlood(t.getUriOccBlo());
			de.setUrineOther(t.getUrineOth());
			de.setGLU(t.getGlu());
			de.setPGLU(t.getGlu2());
			
			de.setCardiogram(Byte.valueOf(t.getEcgAbn()));
			de.setCardiogram_Desc(t.getEcgAbnDesc());
			de.setUrineMicroAlbumin(t.getUriAlbumin());
			de.setFecalOccultBlood(Byte.valueOf(t.getFecOccBlo()));
			de.setHBA1C(t.getGlyHem());
			de.setHBSAG(Byte.valueOf(t.getHbsag()));
			de.setCPT(t.getCpt());
			de.setAST(t.getAst());
			de.setALB(t.getAlb());
			de.setTBIL(t.getTbil());
			de.setCBIL(t.getConBil());
			de.setCR(t.getCr());
			de.setBUN(t.getBun());
			de.setSerumPotassium(t.getPotCon());
			de.setSerumSodium(t.getSodCon());
			de.setCHOL(t.getChol());
			de.setTG(t.getTg());
			de.setLDL_C(t.getLdlC());
			de.setHDL_C(t.getHdlC());
			de.setX_RAY(Byte.valueOf(t.getXRay()));
			de.setX_RAY_Desc(t.getXRayDesc());
			
			de.setB_Ultrasonic(Byte.valueOf(t.getBExc()));
			de.setB_Ultrasonic_Desc(t.getBExcDesc());
			de.setAssistCheckOther(t.getAuxExam());
			de.setTCM_PHZ(Byte.valueOf(t.getTcmPhz()));
			de.setTCM_QXZ(Byte.valueOf(t.getTcmQxz()));
			de.setTCM_YXZ(Byte.valueOf(t.getTcmYxz()));
			de.setTCM_YIXZ(Byte.valueOf(t.getTcmYixz()));
			de.setTCM_TSZ(Byte.valueOf(t.getTcmTsz()));
			de.setTCM_SRZ(Byte.valueOf(t.getTcmSrz()));
			de.setTCM_XTZ(Byte.valueOf(t.getTcmXtz()));
			de.setTCM_QYZ(Byte.valueOf(t.getTcmQyz()));
			de.setTCM_TBZ(Byte.valueOf(t.getTcmTbz()));
			
			de.setCerebralVessel(t.getCerDis());//
			de.setCerebralVessel_Desc(t.getCerDisOth());
			
			de.setKidney(t.getKidDis());//
			de.setKidney_Desc(t.getKidDisOth());
			
			de.setHeart(t.getHeaDis()); //
			de.setHeart_Desc(t.getHeaDisOth());
			
			de.setBloodPipe(t.getVasDis());//
			de.setBloodPipe_Desc(t.getVasDisOth());
			
			de.setEyePart(t.getEyeDis());//
			de.setEyePart_Desc(t.getEyeDisOth());
			
			de.setNervousSystem(Byte.valueOf(t.getNerDis()));
			de.setNervousSystem_Desc(t.getNerDisDes());
			de.setOtherSystem(Byte.valueOf(t.getOtherDis()));
			de.setOtherSystem_Desc(t.getOtherDisDes());
			
			de.setHealthEvaluate(Byte.valueOf(t.getHeaAssAbnFlag()));
			de.setHealthEvaluate_Desc(t.getHeaAssAbn());//
			de.setHealthGuide(t.getHeaGui());//
			
			de.setRiskFactor(t.getHazConRec());//
			de.setRiskFactor_Target(t.getTarWeight().toString());
			de.setRiskFactor_Vaccine(t.getVaccineRec());
			de.setRiskFactor_Other(t.getOtherRec());
			
			
			
			
			
		return de;
	}
	
	public int updateDataStatus(List<String> list,boolean isSuccess) throws Exception {
		if(list.size() < 1){
			return 0;
		}
		if(isSuccess){
			healthExamDao.updateSuccessDataStatus(list);
		}else{
			healthExamDao.updateFailDataStatus(list);
		}
		return 0;
	}


	public ThealthExamMapper getHealthExamDao() {
		return healthExamDao;
	}


	public void setHealthExamDao(ThealthExamMapper healthExamDao) {
		this.healthExamDao = healthExamDao;
	}


	public ThealthExamDrugMapper getHealthExamDrugDao() {
		return healthExamDrugDao;
	}


	public void setHealthExamDrugDao(ThealthExamDrugMapper healthExamDrugDao) {
		this.healthExamDrugDao = healthExamDrugDao;
	}


	public MemberService getMemberService() {
		return memberService;
	}


	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	public int insert(Object model) {
		
		// TODO Auto-generated method stub
		return 0;
	}


	public int update(Object model) {
		
		// TODO Auto-generated method stub
		return 0;
	}


	public int updateByPrimaryKey(Object model) {
		
		// TODO Auto-generated method stub
		return 0;
	}


	public int updateByExampleSelective(Object model, Object example) {
		
		// TODO Auto-generated method stub
		return 0;
	}


	public int updateByExample(Object model, Object example) {
		
		// TODO Auto-generated method stub
		return 0;
	}


	public int delete(Object id) {
		
		// TODO Auto-generated method stub
		return 0;
	}


	public Object selectById(Object id) {
		
		// TODO Auto-generated method stub
		return null;
	}


	public List selectByExampleAndPage(Page page, Object example) {
		
		// TODO Auto-generated method stub
		return null;
	}


	public int countByExample(Object example) {
		
		// TODO Auto-generated method stub
		return 0;
	}


	public int deleteByExample(Object example) {
		
		// TODO Auto-generated method stub
		return 0;
	}


	public List selectByExample(Object example) {
		
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public GenericBaseDao getDao() {
		return healthExamDao;
	}

	
	

}