package com.bithealth.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetail;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailfamilybed;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailinpatient;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailmedicine;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailnonimmune;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.constants.Constants;

/**
 * @ClassName:     HealthCheckUtil.java 
 * @Description:   健康体检工具包
 * @author         lenovo  
 * @version        V1.0   
 * @Date           2016年3月21日 上午11:14:17
*****/
public class HealthCheckUtil {
    
    /** 
     * @Title: getMemBasicInfo 
     * @Description: 获取会员的基本资料 
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getMemBasicInfo(PhHealthexam exam) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        Member omem = exam.getMember();
        if(omem != null){
            map.put("memberId", omem.getMemberid());
            map.put("memName", omem.getMemname());
            map.put("gender", omem.getGender());
            Date date = omem.getBirthdate();
            if(date != null){
                String birthDate = TimeUtil.formatDate(date);
                map.put("age", TimeUtil.getCurrentAgeByBirthdate(birthDate));
            }else{
                map.put("age", 0);
            }
            map.put("tel", omem.getTel());
            map.put("idcard", omem.getIdcard());
        }else{
            map.put("memberId", exam.getMemberID());
            map.put("memName", exam.getName());
            map.put("idcard", exam.getIDCard());
            map.put("age", 0);
        }
        return map;
    }
    
    /** 
     * @Title: getSymptoms 
     * @Description: 获取会员的自觉症状
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getSymptoms(PhHealthexam exam) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHealthexamdetail symptomDetail = exam.getPhHealthexamdetail();
        if(symptomDetail != null){
            String symptomStr = symptomDetail.getSymptomStr();
            String symptom = symptomDetail.getSymptom();
            String symptom_Desc = symptomDetail.getSymptom_Desc();
            map.put("symptomStr", symptomStr);
            map.put("symptom", symptom);
            map.put("symptom_Desc", symptom_Desc);
        }
        return map;
    }
    
    /** 
     * @Title: getGeneralSituation 
     * @Description: 获取会员的一般情况
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getGeneralSituation(PhHealthexam exam,Integer age) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHealthexamdetail generalSituation = exam.getPhHealthexamdetail();
        if(generalSituation != null){
            map.put("bodyTemperature", generalSituation.getBodyTemperature());
            map.put("pulseRate", generalSituation.getPulseRate());
            map.put("respiratoryRate", generalSituation.getRespiratoryRate());
            Integer leftSystolic = null;
            Short leftSystolicNew = generalSituation.getLeftSystolic();
            if(leftSystolicNew != null){
            	leftSystolic = (int)leftSystolicNew;
            }
            Integer leftDiastolic = null;
            Short leftDiastolicNew = generalSituation.getLeftDiastolic();
            if(leftDiastolicNew != null){
            	leftDiastolic = (int)leftDiastolicNew;
            }
            String leftBloodPressure = "";
            if(leftSystolic != null && leftDiastolic != null){
            	leftBloodPressure = leftSystolic + "/" + leftDiastolic;
            }else if(leftSystolic != null && leftDiastolic == null){
            	leftBloodPressure = leftSystolic + "/";
            }else if(leftSystolic == null && leftDiastolic != null){
            	leftBloodPressure = "/" + leftDiastolic;
            }
            map.put("leftBloodPressure", leftBloodPressure);
            map.put("leftSystolic", leftSystolic);
            map.put("leftDiastolic", leftDiastolic);
            Integer rightSystolic = null;
            Short rightSystolicNew = generalSituation.getRightSystolic();
            if(rightSystolicNew != null){
            	rightSystolic = (int)rightSystolicNew;
            }
            Integer rightDiastolic = null;
            Short rightDiastolicNew = generalSituation.getRightDiastolic();
            if(rightDiastolicNew != null){
            	rightDiastolic = (int)rightDiastolicNew;
            }
            String rightBloodPressure = "";
            if(rightSystolic != null && rightDiastolic != null){
            	rightBloodPressure = rightSystolic + "/" + rightDiastolic;
            }else if(rightSystolic != null && rightDiastolic == null){
            	rightBloodPressure = rightSystolic + "/";
            }else if(rightSystolic == null && rightDiastolic != null){
            	rightBloodPressure = "/" + rightDiastolic;
            }
            map.put("rightBloodPressure", rightBloodPressure);
            map.put("rightSystolic", rightSystolic);
            map.put("rightDiastolic", rightDiastolic);
            //PHOmem omem = exam.getOmem();
            BigDecimal height = generalSituation.getHeight();
//            if(height == null){
//                Integer memHeight = omem.getHeight();
//                if(memHeight != null && memHeight > 0){
//                    height = (double)memHeight;
//                }
//            }
            map.put("height", height);
            BigDecimal weight = generalSituation.getWeight();
//            if(weight == null){
//                Double memWeight = omem.getWeight();
//                if(memWeight != null && memWeight > 0){
//                    weight = memWeight;
//                }
//            }
            map.put("weight", weight);
            BigDecimal waist = generalSituation.getWaist();
//            if(waist == null){
//                Integer memWaist = omem.getWaist();
//                if(memWaist != null && memWaist > 0){
//                    waist = (double)memWaist;
//                }
//            }
            map.put("waist", waist);
            map.put("bMI", generalSituation.getBMI());
            if(age != null && age >= 65){
                map.put("agedHealthEvaluateStr", generalSituation.getAgedHealthEvaluateStr());
                map.put("agedHealthEvaluate", generalSituation.getAgedHealthEvaluate());
                map.put("agedLifeEvaluateStr", generalSituation.getAgedLifeEvaluateStr());
                map.put("agedLifeEvaluate", generalSituation.getAgedLifeEvaluate());
                Byte agedCognition = generalSituation.getAgedCognition();
                String agedCognitionStr = generalSituation.getAgedCognitionStr();
                if(agedCognition != null && agedCognition == (byte)Constants.EXAM_COGNITION_SCREEN_POSITIVE){
                	Byte agedCognitionScore = generalSituation.getAgedCognitionScore();
                	if(agedCognitionScore != null){
                		agedCognitionStr += Constants.EXAM_COGNITION_SCREEN_POSITIVE_DESC + agedCognitionScore;
                	}else{
                		agedCognitionStr += Constants.EXAM_COGNITION_SCREEN_POSITIVE_DESC;
                	}
                	map.put("agedCognitionScore",agedCognitionScore);
                }
                map.put("agedCognitionStr",agedCognitionStr);
                map.put("agedCognition",agedCognition);
                Byte agedFeeling = generalSituation.getAgedFeeling();
                String agedFeelingStr = generalSituation.getAgedFeelingStr();
                if(agedFeeling != null && agedFeeling == (byte)Constants.EXAM_FEELING_SCREEN_POSITIVE){
                	Byte agedFeelingScore = generalSituation.getAgedFeelingScore();
                	if(agedFeelingScore != null){
                		agedFeelingStr +=  Constants.EXAM_FEELING_SCREEN_POSITIVE_DESC + agedFeelingScore;
                	}else{
                		agedFeelingStr +=  Constants.EXAM_FEELING_SCREEN_POSITIVE_DESC;
                	}
                	map.put("agedFeelingScore", agedFeelingScore);
                }
                map.put("agedFeelingStr", agedFeelingStr);
                map.put("agedFeeling", agedFeeling);
            }
        }
        return map;
    }
    
    /** 
     * @Title: getLifeStyle 
     * @Description: 获取会员的生活方式
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getLifeStyle(PhHealthexam exam) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHealthexamdetail lifeStyle = exam.getPhHealthexamdetail();
        if(lifeStyle != null){
            map.put("sportFrequencyStr", lifeStyle.getSportFrequencyStr());
            map.put("sportFrequency", lifeStyle.getSportFrequency());
            map.put("sportDuration", lifeStyle.getSportDuration());
            map.put("sportTotalTime",lifeStyle.getSportTotalTime());
            map.put("sportWay", lifeStyle.getSportWay());
            map.put("eatingHabitsStr", lifeStyle.getEatingHabitsStr());
            map.put("eatingHabits", lifeStyle.getEatingHabits());
            map.put("smokingStateStr",lifeStyle.getSmokingStateStr());
            map.put("smokingState",lifeStyle.getSmokingState());
            map.put("dailySmoking", lifeStyle.getDailySmoking());
            map.put("smokingStartAge",lifeStyle.getSmokingStartAge());
            map.put("smokingEndAge",lifeStyle.getSmokingEndAge());
            map.put("drinkFrequencyStr",lifeStyle.getDrinkFrequencyStr());
            map.put("drinkFrequency",lifeStyle.getDrinkFrequency());
            map.put("dailyDrink", lifeStyle.getDailyDrink());
            map.put("isAbstinenceStr", lifeStyle.getIsAbstinenceStr());
            map.put("isAbstinence", lifeStyle.getIsAbstinence());
            map.put("abstinenceAge",lifeStyle.getAbstinenceAge() );
            map.put("drinkStartAge",lifeStyle.getDrinkStartAge() );
            map.put("isTemulenceLastYearStr",lifeStyle.getIsTemulenceLastYearStr());
            map.put("isTemulenceLastYear",lifeStyle.getIsTemulenceLastYear());
            String drinkTypeStr = lifeStyle.getDrinkTypeStr();
            map.put("drinkTypeStr",drinkTypeStr );
            map.put("drinkType",lifeStyle.getDrinkType());
            String drinkOther_Desc = lifeStyle.getDrinkOther_Desc();
            if(!StringUtils.isEmpty(drinkOther_Desc)){
            	map.put("drinkOther_Desc",drinkOther_Desc);
            }
            map.put("occupationStr",lifeStyle.getOccupationStr());
            map.put("occupation",lifeStyle.getOccupation());
            map.put("typeOfWork",lifeStyle.getTypeOfWork() );
            map.put("workTime", lifeStyle.getWorkTime());
            map.put("dust", lifeStyle.getDust());
            Byte dustGuard = lifeStyle.getDustGuard();
            String dustGuardStr = "";
            if(dustGuard != null && dustGuard == (byte)2){
                dustGuardStr = lifeStyle.getDustGuard_Desc();
                map.put("dustGuard_Desc", lifeStyle.getDustGuard_Desc());
            }else{
                dustGuardStr = lifeStyle.getDustGuardStr();
            }
            map.put("dustGuardStr", dustGuardStr);
            map.put("dustGuard", dustGuard);
            map.put("physical", lifeStyle.getPhysical());
            Byte physicalGuard = lifeStyle.getPhysicalGuard();
            String physicalGuardStr = "";
            if(physicalGuard != null && physicalGuard == (byte)2){
                physicalGuardStr = lifeStyle.getPhysicalGuard_Desc();
                map.put("physicalGuard_Desc", lifeStyle.getPhysicalGuard_Desc());
            }else{
                physicalGuardStr = lifeStyle.getPhysicalGuardStr();
            }
            map.put("physicalGuardStr", physicalGuardStr);
            map.put("physicalGuard", physicalGuard);
            map.put("radiogen", lifeStyle.getRadiogen());
            Byte radiogenGuard = lifeStyle.getRadiogenGuard();
            String radiogenGuardStr = "";
            if(radiogenGuard != null && radiogenGuard == (byte)2){
                radiogenGuardStr = lifeStyle.getRadiogenGuard_Desc();
                map.put("radiogenGuard_Desc", lifeStyle.getRadiogenGuard_Desc());
            }else{
                radiogenGuardStr = lifeStyle.getRadiogenGuardStr();
            }
            map.put("radiogenGuardStr", radiogenGuardStr);
            map.put("radiogenGuard", radiogenGuard);
            map.put("chemical", lifeStyle.getChemical());
            Byte chemicalGuard = lifeStyle.getChemicalGuard();
            String chemicalGuardStr = "";
            if(chemicalGuard != null && chemicalGuard == (byte)2){
                chemicalGuardStr = lifeStyle.getChemicalGuard_Desc();
                map.put("chemicalGuard_Desc", lifeStyle.getChemicalGuard_Desc());
            }else{
                chemicalGuardStr = lifeStyle.getChemicalGuardStr();
            }
            map.put("chemicalGuardStr", chemicalGuardStr);
            map.put("chemicalGuard", chemicalGuard);
            map.put("toxicOther", lifeStyle.getToxicOther());
            Byte toxicOtherGuard = lifeStyle.getToxicOtherGuard();
            String toxicOtherGuardStr = "";
            if(toxicOtherGuard != null && toxicOtherGuard == (byte)2){
                toxicOtherGuardStr = lifeStyle.getToxicOtherGuard_Desc();
                map.put("toxicOtherGuard_Desc", lifeStyle.getToxicOtherGuard_Desc());
            }else{
                toxicOtherGuardStr = lifeStyle.getToxicOtherGuardStr();
            }
            map.put("toxicOtherGuardStr", toxicOtherGuardStr);
            map.put("toxicOtherGuard", toxicOtherGuard);
        }
        return map;
    }
    
    /** 
     * @Title: getOrganFunction 
     * @Description: 获取会员的脏器功能
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-21
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getOrganFunction(PhHealthexam exam) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHealthexamdetail organFunction = exam.getPhHealthexamdetail();
        if(organFunction != null){
            map.put("lipsStr", organFunction.getLipsStr());
            map.put("lips", organFunction.getLips());
            map.put("dentitionStr", organFunction.getDentitionStr());
            map.put("dentition", organFunction.getDentition());
            map.put("dentition_Desc", organFunction.getDentition_Desc());
            map.put("throatStr", organFunction.getThroatStr());
            map.put("throat", organFunction.getThroat());
            map.put("leftVision",organFunction.getLeftVision());
            map.put("rightVision", organFunction.getRightVision());
            map.put("leftCorrectVision",organFunction.getLeftCorrectVision());
            map.put("rightCorrectVision",organFunction.getRightCorrectVision());
            map.put("hearingStr", organFunction.getHearingStr());
            map.put("hearing", organFunction.getHearing());
            map.put("movementStr", organFunction.getMovementStr());
            map.put("movement", organFunction.getMovement());
        }
        return map;
    }
    
    /** 
     * @Title: getExamination 
     * @Description: 获取会员的查体
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-21
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getExamination(PhHealthexam exam) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHealthexamdetail examination = exam.getPhHealthexamdetail();
        if(examination != null){
        	Byte eyeground = examination.getEyeground();
            String eyegroundStr = examination.getEyegroundStr();
            if(eyeground != null && eyeground == (byte)2){
            	String eyegroundDesc = examination.getEyeground_Desc();
            	if(!StringUtils.isEmpty(eyegroundDesc)){
            		eyegroundStr += Constants.LEFT_BRACKET + eyegroundDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("eyeground_Desc",eyegroundDesc);
            }
            map.put("eyegroundStr",eyegroundStr );
            map.put("eyeground",eyeground);
            Byte skin = examination.getSkin();
            String skinStr = examination.getSkinStr();
            if(skin != null && skin == (byte)7){
            	String skinDesc = examination.getSkin_Desc();
            	if(!StringUtils.isEmpty(skinDesc)){
            		skinStr += Constants.LEFT_BRACKET + skinDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("skin_Desc",skinDesc);
            } 
            map.put("skinStr",skinStr);
            map.put("skin",skin);
            Byte sclero = examination.getSclero();
            String scleroStr = examination.getScleroStr();
            if(sclero != null && sclero == (byte)4){
            	String scleroDesc = examination.getSclero_Desc();
            	if(!StringUtils.isEmpty(scleroDesc)){
            		scleroStr += Constants.LEFT_BRACKET + scleroDesc + Constants.RIGHT_BRACKET;
            		map.put("sclero_Desc", scleroDesc);
            	}
            } 
            map.put("scleroStr", scleroStr);
            map.put("sclero", sclero);
            Byte lymph = examination.getLymph();
            String lymphStr = examination.getLymphStr();
            if(lymph != null && lymph == (byte)4){
            	String lymphDesc = examination.getLymph_Desc();
            	if(!StringUtils.isEmpty(lymphDesc)){
            		lymphStr += Constants.LEFT_BRACKET + lymphDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("lymph_Desc",lymphDesc);
            } 
            map.put("lymphStr",lymphStr);
            map.put("lymph",lymph);
            map.put("lungBarrelChestStr", examination.getLungBarrelChestStr());
            map.put("lungBarrelChest", examination.getLungBarrelChest());
            Byte lungBreathSounds = examination.getLungBreathSounds();
            String lungBreathSoundsStr = examination.getLungBreathSoundsStr();
            if(lungBreathSounds != null && lungBreathSounds == (byte)2){
            	String lungBreathSoundsDesc = examination.getLungBreathSounds_Desc();
            	if(!StringUtils.isEmpty(lungBreathSoundsDesc)){
            		lungBreathSoundsStr += Constants.LEFT_BRACKET + lungBreathSoundsDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("lungBreathSounds_Desc",lungBreathSoundsDesc);
            }
            map.put("lungBreathSoundsStr",lungBreathSoundsStr);
            map.put("lungBreathSounds",lungBreathSounds);
            Byte lungRales = examination.getLungRales();
            String lungRalesStr = examination.getLungRalesStr();
            if(lungRales != null && lungRales == (byte)4){
            	String lungRalesDesc = examination.getLungRales_Desc();
            	if(!StringUtils.isEmpty(lungRalesDesc)){
            		lungRalesStr += Constants.LEFT_BRACKET + lungRalesDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("lungRales_Desc",lungRalesDesc);
            }
            map.put("lungRalesStr",lungRalesStr);
            map.put("lungRales",lungRales);
            map.put("heartRate", examination.getHeartRate());
            map.put("rhythmStr", examination.getRhythmStr());
            map.put("rhythm", examination.getRhythm());
            Byte murmur = examination.getMurmur();
            String murmurStr = examination.getMurmurStr();
            if(murmur != null && murmur == (byte)2){
            	String murmurDesc = examination.getMurmur_Desc();
            	if(!StringUtils.isEmpty(murmurDesc)){
            		murmurStr += Constants.LEFT_BRACKET + murmurDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("murmur_Desc", murmurDesc);
            }
            map.put("murmurStr", murmurStr);
            map.put("murmur", murmur);
            Byte pain = examination.getPain();
            String painStr = "";
            if(pain != null && pain == (byte)2){
            	String painDesc = examination.getPain_Desc();
            	painStr = "有";
            	if(!StringUtils.isEmpty(painDesc)){
            		painStr += Constants.LEFT_BRACKET + painDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("pain_Desc",painDesc);
            }else if(pain != null && pain == 1){
            	painStr = "无";
            }
            map.put("painStr",painStr);
            map.put("pain",pain);
            Byte block = examination.getBlock();
            String blockStr = examination.getBlockStr();
            if(block != null && block == (byte)2){
            	String blockDesc = examination.getBlock_Desc();
            	if(!StringUtils.isEmpty(blockDesc)){
            		blockStr += Constants.LEFT_BRACKET + blockDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("block_Desc", blockDesc);
            }
            map.put("blockStr", blockStr);
            map.put("block", block);
            Byte hepatomegaly = examination.getHepatomegaly();
            String hepatomegalyStr = examination.getHepatomegalyStr();
            if(hepatomegaly != null && hepatomegaly == (byte)2){
            	String hepatomegalyDesc = examination.getHepatomegaly_Desc();
            	if(!StringUtils.isEmpty(hepatomegalyDesc)){
            		hepatomegalyStr += Constants.LEFT_BRACKET + hepatomegalyDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("hepatomegaly_Desc",hepatomegalyDesc );
            }
            map.put("hepatomegalyStr",hepatomegalyStr );
            map.put("hepatomegaly",hepatomegaly );
            Byte splenomegaly = examination.getSplenomegaly();
            String splenomegalyStr = examination.getSplenomegalyStr();
            if(splenomegaly != null && splenomegaly == (byte)2){
            	String splenomegalyDesc = examination.getSplenomegaly_Desc();
            	if(!StringUtils.isEmpty(splenomegalyDesc)){
            		splenomegalyStr += Constants.LEFT_BRACKET + splenomegalyDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("splenomegaly_Desc", splenomegalyDesc);
            }
            map.put("splenomegalyStr", splenomegalyStr);
            map.put("splenomegaly", splenomegaly);
            Byte moveSonant = examination.getMoveSonant();
            String moveSonantStr = examination.getMoveSonantStr();
            if(moveSonant != null && moveSonant == (byte)2){
            	String moveSonantDesc = examination.getMoveSonant_Desc();
            	if(!StringUtils.isEmpty(moveSonantDesc)){
            		moveSonantStr += Constants.LEFT_BRACKET + moveSonantDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("moveSonant_Desc", moveSonantDesc);
            }
            map.put("moveSonantStr", moveSonantStr);
            map.put("moveSonant", moveSonant);
            map.put("lowLimbEdemaStr", examination.getLowLimbEdemaStr());
            map.put("lowLimbEdema", examination.getLowLimbEdema());
            map.put("arteriopalmusStr", examination.getArteriopalmusStr());
            map.put("arteriopalmus", examination.getArteriopalmus());
            Byte anusTactus = examination.getAnusTactus();
            String anusTactusStr = examination.getAnusTactusStr();
            if(anusTactus != null && anusTactus == (byte)5){
            	String anusTactusDesc = examination.getAnusTactus_Desc();
            	if(!StringUtils.isEmpty(anusTactusDesc)){
            		anusTactusStr += Constants.LEFT_BRACKET + anusTactusDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("anusTactus_Desc",anusTactusDesc );
            }
            map.put("anusTactusStr",anusTactusStr );
            map.put("anusTactus",anusTactus);
            map.put("breastStr", examination.getBreastStr());
            map.put("breast", examination.getBreast());
            map.put("breast_Desc", examination.getBreast_Desc());
            Byte pudendum = examination.getPudendum();
            String pudendumStr = examination.getPudendumStr();
            if(pudendum != null && pudendum == (byte)2){
            	String pudendumDesc = examination.getPudendum_Desc();
            	if(!StringUtils.isEmpty(pudendumDesc)){
            		pudendumStr += Constants.LEFT_BRACKET + pudendumDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("pudendum_Desc",pudendumDesc);
            }
            map.put("pudendumStr",pudendumStr);
            map.put("pudendum",pudendum);
            Byte vagina = examination.getVagina();
            String vaginaStr = examination.getVaginaStr();
            if(vagina != null && vagina == (byte)2){
            	String vaginaDesc = examination.getVagina_Desc();
            	if(!StringUtils.isEmpty(vaginaDesc)){
            		vaginaStr += Constants.LEFT_BRACKET + vaginaDesc + Constants.RIGHT_BRACKET;
            	}
            	 map.put("vagina_Desc",vaginaDesc);
            }
            map.put("vaginaStr",vaginaStr);
            map.put("vagina",vagina);
            Byte cervical = examination.getCervical();
            String cervicalStr = examination.getCervicalStr();
            if(cervical != null && cervical == (byte)2){
            	String cervicalDesc = examination.getCervical_Desc();
            	if(!StringUtils.isEmpty(cervicalDesc)){
            		cervicalStr += Constants.LEFT_BRACKET + cervicalDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("cervical_Desc",cervicalDesc);
            }
            map.put("cervicalStr",cervicalStr);
            map.put("cervical",cervical);
            Byte uteri = examination.getUteri();
            String uteriStr = examination.getUteriStr();
            if(uteri != null && uteri == (byte)2){
            	String uteriDesc = examination.getUteri_Desc();
            	if(!StringUtils.isEmpty(uteriDesc)){
            		uteriStr += Constants.LEFT_BRACKET + uteriDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("uteri_Desc",uteriDesc);
            }
            map.put("uteriStr",uteriStr);
            map.put("uteri",uteri);
            Byte enclosure = examination.getEnclosure();
            String enclosureStr = examination.getEnclosureStr();
            if(enclosure != null && enclosure == (byte)2){
            	String enclosureDesc = examination.getEnclosure_Desc();
            	if(!StringUtils.isEmpty(enclosureDesc)){
            		enclosureStr += Constants.LEFT_BRACKET + enclosureDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("enclosure_Desc",enclosureDesc);
            }
            map.put("enclosureStr",enclosureStr);
            map.put("enclosure",enclosure);
        }
        return map;
    }
    
    /** 
     * @Title: getAccessoryExamination 
     * @Description: 获取会员的辅助检查
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-21
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getAccessoryExamination(PhHealthexam exam) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHealthexamdetail accessoryExam = exam.getPhHealthexamdetail();
        if(accessoryExam != null){
            map.put("hemoglobin",accessoryExam.getHemoglobin());
            map.put("leukocyte",accessoryExam.getLeukocyte());
            map.put("platelet",accessoryExam.getPlatelet());
            map.put("bloodOther",accessoryExam.getBloodOther());
            map.put("urineProtein",accessoryExam.getUrineProtein());
            map.put("urineSugar",accessoryExam.getUrineSugar());
            map.put("urineAcetoneBody",accessoryExam.getUrineAcetoneBody());
            map.put("urineOccultBlood",accessoryExam.getUrineOccultBlood());
            map.put("urineOther",accessoryExam.getUrineOther());
            map.put("gLU",accessoryExam.getGLU());
            map.put("pGLU",accessoryExam.getPGLU());
            Byte cardiogram = accessoryExam.getCardiogram();
            String cardiogramStr = accessoryExam.getCardiogramStr();
            if(cardiogram != null && cardiogram == (byte)2){
            	String cardiogramDesc = accessoryExam.getCardiogram_Desc();
            	if(!StringUtils.isEmpty(cardiogramDesc)){
            		cardiogramStr += Constants.LEFT_BRACKET + cardiogramDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("cardiogram_Desc",cardiogramDesc);
            }
            map.put("cardiogramStr",cardiogramStr);
            map.put("cardiogram",cardiogram);
            map.put("urineMicroAlbumin",accessoryExam.getUrineMicroAlbumin());
            map.put("fecalOccultBloodStr",accessoryExam.getFecalOccultBloodStr());
            map.put("fecalOccultBlood",accessoryExam.getFecalOccultBlood());
            map.put("hBA1C",accessoryExam.getHBA1C());
            map.put("hBSAGStr",accessoryExam.getHBSAGStr());
            map.put("hBSAG",accessoryExam.getHBSAG());
            map.put("cPT",accessoryExam.getCPT());
            map.put("aST",accessoryExam.getAST());
            map.put("aLB",accessoryExam.getALB());
            map.put("tBIL",accessoryExam.getTBIL());
            map.put("cBIL",accessoryExam.getCBIL());
            map.put("cR",accessoryExam.getCR());
            map.put("bUN",accessoryExam.getBUN());
            map.put("serumPotassium",accessoryExam.getSerumPotassium());
            map.put("serumSodium",accessoryExam.getSerumSodium());
            map.put("cHOL",accessoryExam.getCHOL());
            map.put("tG",accessoryExam.getTG());
            map.put("lDL_C",accessoryExam.getLDL_C());
            map.put("hDL_C",accessoryExam.getHDL_C());
            Byte x_RAY = accessoryExam.getX_RAY();
            String x_RAYStr = accessoryExam.getX_RAYStr();
            if(x_RAY != null && x_RAY == (byte)2){
            	String x_RAY_Desc = accessoryExam.getX_RAY_Desc();
            	if(!StringUtils.isEmpty(x_RAY_Desc)){
            		x_RAYStr += Constants.LEFT_BRACKET + x_RAY_Desc + Constants.RIGHT_BRACKET;
            	}
            	map.put("x_RAY_Desc",x_RAY_Desc );
            }
            map.put("x_RAYStr",x_RAYStr );
            map.put("x_RAY",x_RAY );
            Byte b_Ultrasonic = accessoryExam.getB_Ultrasonic();
            String b_UltrasonicStr = accessoryExam.getB_UltrasonicStr();
            if(b_Ultrasonic != null && b_Ultrasonic == (byte)2){
            	String b_Ultrasonic_Desc = accessoryExam.getB_Ultrasonic_Desc();
            	if(!StringUtils.isEmpty(b_Ultrasonic_Desc)){
            		b_UltrasonicStr += Constants.LEFT_BRACKET + b_Ultrasonic_Desc + Constants.RIGHT_BRACKET;
            	}
            	map.put("b_Ultrasonic_Desc",b_Ultrasonic_Desc );
            }
            map.put("b_UltrasonicStr",b_UltrasonicStr );
            map.put("b_Ultrasonic",b_Ultrasonic );
            Byte cervicalSmear = accessoryExam.getCervicalSmear();
            String cervicalSmearStr = accessoryExam.getCervicalSmearStr();
            if(cervicalSmear != null && cervicalSmear == (byte)2){
            	String cervicalSmearDesc = accessoryExam.getCervicalSmear_Desc();
            	if(!StringUtils.isEmpty(cervicalSmearDesc)){
            		cervicalSmearStr += Constants.LEFT_BRACKET + cervicalSmearDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("cervicalSmear_Desc", cervicalSmearDesc);
            }
            map.put("cervicalSmearStr", cervicalSmearStr);
            map.put("cervicalSmear", cervicalSmear);
            map.put("assistCheckOther", accessoryExam.getAssistCheckOther());
        }
        return map;
    }
    
    /** 
     * @Title: getTcm 
     * @Description: 获取会员的中医体质辨识
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-21
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getTcm(PhHealthexam exam) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHealthexamdetail tcm = exam.getPhHealthexamdetail();
        if(tcm != null){
            map.put("tCM_PHZStr",tcm.getTCM_PHZStr());
            map.put("tCM_PHZ",tcm.getTCM_PHZ());
            String tCM_PHZ_Guide = tcm.getTCM_PHZ_Guide();
            String tCM_PHZ_Guide_Str = tcm.getTCM_PHZ_GuideStr();
            String tCM_PHZ_Guide_Desc = tcm.getTCM_PHZ_Guide_Desc();
            if(!StringUtils.isEmpty(tCM_PHZ_Guide)){
                if(!StringUtils.isEmpty(tCM_PHZ_Guide_Desc)){
                    tCM_PHZ_Guide_Str += Constants.ZN_STRING_SEPARATE + tCM_PHZ_Guide_Desc;
                }
            }else{
                if(!StringUtils.isEmpty(tCM_PHZ_Guide_Desc)){
                    tCM_PHZ_Guide_Str = tCM_PHZ_Guide_Desc;
                }
            }
            map.put("tCM_PHZ_Guide_Str",tCM_PHZ_Guide_Str);
            map.put("tCM_PHZ_Guide",tCM_PHZ_Guide);
            map.put("tCM_PHZ_Guide_Desc",tCM_PHZ_Guide_Desc);
            map.put("tCM_YXZStr",tcm.getTCM_YXZStr());
            map.put("tCM_YXZ",tcm.getTCM_YXZ());
            String tCM_YXZ_Guide = tcm.getTCM_YXZ_Guide();
            String tCM_YXZ_Guide_Str = tcm.getTCM_YXZ_GuideStr();
            String tCM_YXZ_Guide_Desc = tcm.getTCM_YXZ_Guide_Desc();
            if(!StringUtils.isEmpty(tCM_YXZ_Guide)){
                if(!StringUtils.isEmpty(tCM_YXZ_Guide_Desc)){
                    tCM_YXZ_Guide_Str += Constants.ZN_STRING_SEPARATE + tCM_YXZ_Guide_Desc;
                }
            }else{
                if(!StringUtils.isEmpty(tCM_YXZ_Guide_Desc)){
                    tCM_YXZ_Guide_Str = tCM_YXZ_Guide_Desc;
                }
            }
            map.put("tCM_YXZ_Guide_Str",tCM_YXZ_Guide_Str);
            map.put("tCM_YXZ_Guide",tCM_YXZ_Guide);
            map.put("tCM_YXZ_Guide_Desc",tCM_YXZ_Guide_Desc);
            map.put("tCM_QXZStr",tcm.getTCM_QXZStr());
            map.put("tCM_QXZ",tcm.getTCM_QXZ());
            String tCM_QXZ_Guide = tcm.getTCM_QXZ_Guide();
            String tCM_QXZ_Guide_Str = tcm.getTCM_QXZ_GuideStr();
            String tCM_QXZ_Guide_Desc = tcm.getTCM_QXZ_Guide_Desc();
            if(!StringUtils.isEmpty(tCM_QXZ_Guide)){
                if(!StringUtils.isEmpty(tCM_QXZ_Guide_Desc)){
                    tCM_QXZ_Guide_Str += Constants.ZN_STRING_SEPARATE + tCM_QXZ_Guide_Desc;
                }
            }else{
                if(!StringUtils.isEmpty(tCM_QXZ_Guide_Desc)){
                    tCM_QXZ_Guide_Str = tCM_QXZ_Guide_Desc;
                }
            }
            map.put("tCM_QXZ_Guide_Str",tCM_QXZ_Guide_Str);
            map.put("tCM_QXZ_Guide",tCM_QXZ_Guide);
            map.put("tCM_QXZ_Guide_Desc",tCM_QXZ_Guide_Desc);
            map.put("tCM_YIXZStr",tcm.getTCM_YIXZStr());
            map.put("tCM_YIXZ",tcm.getTCM_YIXZ());
            String tCM_YIXZ_Guide = tcm.getTCM_YIXZ_Guide();
            String tCM_YIXZ_Guide_Str = tcm.getTCM_YIXZ_GuideStr();
            String tCM_YIXZ_Guide_Desc = tcm.getTCM_YIXZ_Guide_Desc();
            if(!StringUtils.isEmpty(tCM_YIXZ_Guide)){
                if(!StringUtils.isEmpty(tCM_YIXZ_Guide_Desc)){
                    tCM_YIXZ_Guide_Str += Constants.ZN_STRING_SEPARATE + tCM_YIXZ_Guide_Desc;
                }
            }else{
                if(!StringUtils.isEmpty(tCM_YIXZ_Guide_Desc)){
                    tCM_YIXZ_Guide_Str = tCM_YIXZ_Guide_Desc;
                }
            }
            map.put("tCM_YIXZ_Guide_Str",tCM_YIXZ_Guide_Str);
            map.put("tCM_YIXZ_Guide",tCM_YIXZ_Guide);
            map.put("tCM_YIXZ_Guide_Desc",tCM_YIXZ_Guide_Desc);
            map.put("tCM_TSZStr",tcm.getTCM_TSZStr());
            map.put("tCM_TSZ",tcm.getTCM_TSZ());
            String tCM_TSZ_Guide = tcm.getTCM_TSZ_Guide();
            String tCM_TSZ_Guide_Str = tcm.getTCM_TSZ_GuideStr();
            String tCM_TSZ_Guide_Desc = tcm.getTCM_TSZ_Guide_Desc();
            if(!StringUtils.isEmpty(tCM_TSZ_Guide)){
                if(!StringUtils.isEmpty(tCM_TSZ_Guide_Desc)){
                    tCM_TSZ_Guide_Str += Constants.ZN_STRING_SEPARATE + tCM_TSZ_Guide_Desc;
                }
            }else{
                if(!StringUtils.isEmpty(tCM_TSZ_Guide_Desc)){
                    tCM_TSZ_Guide_Str = tCM_TSZ_Guide_Desc;
                }
            }
            map.put("tCM_TSZ_Guide_Str",tCM_TSZ_Guide_Str);
            map.put("tCM_TSZ_Guide",tCM_TSZ_Guide);
            map.put("tCM_TSZ_Guide_Desc",tCM_TSZ_Guide_Desc);
            map.put("tCM_SRZStr",tcm.getTCM_SRZStr());
            map.put("tCM_SRZ",tcm.getTCM_SRZ());
            String tCM_SRZ_Guide = tcm.getTCM_SRZ_Guide();
            String tCM_SRZ_Guide_Str = tcm.getTCM_SRZ_GuideStr();
            String tCM_SRZ_Guide_Desc = tcm.getTCM_SRZ_Guide_Desc();
            if(!StringUtils.isEmpty(tCM_SRZ_Guide)){
                if(!StringUtils.isEmpty(tCM_SRZ_Guide_Desc)){
                    tCM_SRZ_Guide_Str += Constants.ZN_STRING_SEPARATE + tCM_SRZ_Guide_Desc;
                }
            }else{
                if(!StringUtils.isEmpty(tCM_SRZ_Guide_Desc)){
                    tCM_SRZ_Guide_Str = tCM_SRZ_Guide_Desc;
                }
            }
            map.put("tCM_SRZ_Guide_Str",tCM_SRZ_Guide_Str);
            map.put("tCM_SRZ_Guide",tCM_SRZ_Guide);
            map.put("tCM_SRZ_Guide_Desc",tCM_SRZ_Guide_Desc);
            map.put("tCM_XTZStr",tcm.getTCM_XTZStr());
            map.put("tCM_XTZ",tcm.getTCM_XTZ());
            String tCM_XTZ_Guide = tcm.getTCM_XTZ_Guide();
            String tCM_XTZ_Guide_Str = tcm.getTCM_XTZ_GuideStr();
            String tCM_XTZ_Guide_Desc = tcm.getTCM_XTZ_Guide_Desc();
            if(!StringUtils.isEmpty(tCM_XTZ_Guide)){
                if(!StringUtils.isEmpty(tCM_XTZ_Guide_Desc)){
                    tCM_XTZ_Guide_Str += Constants.ZN_STRING_SEPARATE + tCM_XTZ_Guide_Desc;
                }
            }else{
                if(!StringUtils.isEmpty(tCM_XTZ_Guide_Desc)){
                    tCM_XTZ_Guide_Str = tCM_XTZ_Guide_Desc;
                }
            }
            map.put("tCM_XTZ_Guide_Str", tCM_XTZ_Guide_Str);
            map.put("tCM_XTZ_Guide", tCM_XTZ_Guide);
            map.put("tCM_XTZ_Guide_Desc", tCM_XTZ_Guide_Desc);
            map.put("tCM_QYZStr",tcm.getTCM_QYZStr());
            map.put("tCM_QYZ",tcm.getTCM_QYZ());
            String tCM_QYZ_Guide = tcm.getTCM_QYZ_Guide();
            String tCM_QYZ_Guide_Str = tcm.getTCM_QYZ_GuideStr();
            String tCM_QYZ_Guide_Desc = tcm.getTCM_QYZ_Guide_Desc();
            if(!StringUtils.isEmpty(tCM_QYZ_Guide)){
                if(!StringUtils.isEmpty(tCM_QYZ_Guide_Desc)){
                    tCM_QYZ_Guide_Str += Constants.ZN_STRING_SEPARATE + tCM_QYZ_Guide_Desc;
                }
            }else{
                if(!StringUtils.isEmpty(tCM_QYZ_Guide_Desc)){
                    tCM_QYZ_Guide_Str = tCM_QYZ_Guide_Desc;
                }
            }
            map.put("tCM_QYZ_Guide_Str", tCM_QYZ_Guide_Str);
            map.put("tCM_QYZ_Guide", tCM_QYZ_Guide);
            map.put("tCM_QYZ_Guide_Desc", tCM_QYZ_Guide_Desc);
            map.put("tCM_TBZStr",tcm.getTCM_TBZStr());
            map.put("tCM_TBZ",tcm.getTCM_TBZ());
            String tCM_TBZ_Guide = tcm.getTCM_TBZ_Guide();
            String tCM_TBZ_Guide_Str = tcm.getTCM_TBZ_GuideStr();
            String tCM_TBZ_Guide_Desc = tcm.getTCM_TBZ_Guide_Desc();
            if(!StringUtils.isEmpty(tCM_TBZ_Guide)){
                if(!StringUtils.isEmpty(tCM_TBZ_Guide_Desc)){
                    tCM_TBZ_Guide_Str += Constants.ZN_STRING_SEPARATE + tCM_TBZ_Guide_Desc;
                }
            }else{
                if(!StringUtils.isEmpty(tCM_TBZ_Guide_Desc)){
                    tCM_TBZ_Guide_Str = tCM_TBZ_Guide_Desc;
                }
            }
            map.put("tCM_TBZ_Guide_Str",tCM_TBZ_Guide_Str);
            map.put("tCM_TBZ_Guide",tCM_TBZ_Guide);
            map.put("tCM_TBZ_Guide_Desc",tCM_TBZ_Guide_Desc);
        }
        return map;
    }
    
    /** 
     * @Title: getProblems 
     * @Description: 获取会员的现存主要健康问题
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-21
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getProblems(PhHealthexam exam) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHealthexamdetail problems = exam.getPhHealthexamdetail();
        if(problems != null){
            String cerebralVesselStr = problems.getCerebralVesseltr();
            String cerebralVessel = problems.getCerebralVessel();
            if(cerebralVessel != null && cerebralVessel.contains("6") == true){
            	String cerebralVessel_Desc = problems.getCerebralVessel_Desc();
            	if(!StringUtils.isEmpty(cerebralVessel_Desc)){
            		map.put("cerebralVessel_Desc",cerebralVessel_Desc);
            	}
            }
            map.put("cerebralVesselStr",cerebralVesselStr);
            map.put("cerebralVessel",cerebralVessel);
            String kidneyStr = problems.getKidneyStr();
            String kidney = problems.getKidney();
            if(kidney != null && kidney.contains("6") == true){
            	String kidney_Desc = problems.getKidney_Desc();
            	if(!StringUtils.isEmpty(kidney_Desc)){
            		map.put("kidney_Desc",kidney_Desc);
            	}
            }
            map.put("kidneyStr",kidneyStr);
            map.put("kidney",kidney);
            String heartStr = problems.getHeartStr();
            String heart = problems.getHeart();
            if(heart != null && heart.contains("7") == true){
            	String heart_Desc = problems.getHeart_Desc();
            	if(!StringUtils.isEmpty(heart_Desc)){
            		map.put("heart_Desc",heart_Desc);
            	}
            }
            map.put("heart",heart);
            map.put("heartStr",heartStr);
            String bloodPipeStr = problems.getBloodPipeStr();
            String bloodPipe = problems.getBloodPipe();
            if(bloodPipe != null && bloodPipe.contains("4") == true){
            	String bloodPipe_Desc = problems.getBloodPipe_Desc();
            	if(!StringUtils.isEmpty(bloodPipe_Desc)){
            		map.put("bloodPipe_Desc",bloodPipe_Desc);
            	}
            }
            map.put("bloodPipeStr",bloodPipeStr);
            map.put("bloodPipe",bloodPipe);
            String eyePartStr = problems.getEyePartStr();
            String eyePart = problems.getEyePart();
            if(eyePart != null && eyePart.contains("5") == true){
            	String eyePart_Desc = problems.getEyePart_Desc();
            	if(!StringUtils.isEmpty(eyePart_Desc)){
            		map.put("eyePart_Desc",eyePart_Desc);
            	}
            }
            map.put("eyePartStr",eyePartStr);
            map.put("eyePart",eyePart);
            Byte nervousSystem = problems.getNervousSystem();
            String nervousSystemStr = problems.getNervousSystemStr();
            if(nervousSystem != null && nervousSystem == (byte)2){
            	String nervousSystemDesc = problems.getNervousSystem_Desc();
            	if(!StringUtils.isEmpty(nervousSystemDesc)){
            		nervousSystemStr += Constants.LEFT_BRACKET + nervousSystemDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("nervousSystem_Desc",nervousSystemDesc);
            }
            map.put("nervousSystemStr",nervousSystemStr);
            map.put("nervousSystem",nervousSystem);
            Byte otherSystem = problems.getOtherSystem();
            String otherSystemStr = problems.getOtherSystemStr();
            if(otherSystem != null && otherSystem == (byte)2){
            	String otherSystemDesc = problems.getOtherSystem_Desc();
            	if(!StringUtils.isEmpty(otherSystemDesc)){
            		otherSystemStr += Constants.LEFT_BRACKET + otherSystemDesc + Constants.RIGHT_BRACKET;
            	}
            	map.put("otherSystem_Desc",otherSystemDesc);
            }
            map.put("otherSystemStr",otherSystemStr);
            map.put("otherSystem",otherSystem);
        }
        return map;
    }
    
    /** 
     * @Title: getHospitalCourse 
     * @Description: 获取会员的住院治疗情况
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-21
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getHospitalCourse(PhHealthexam exam) throws Exception{
        Map<String,Object> mapFinal = new HashMap<String, Object>();
        List<PhHealthexamdetailfamilybed> familyBedHistoryList = exam.getPhHealthexamdetailfamilybeds();
        List<PhHealthexamdetailinpatient> hospitalizationList = exam.getPhHealthexamdetailinpatients();
        if(familyBedHistoryList != null && familyBedHistoryList.size() > 0){
            List<Map<String,Object>> mapFamilyBedHistoryList = new ArrayList<Map<String,Object>>();
            for(PhHealthexamdetailfamilybed bed: familyBedHistoryList){
                Map<String,Object> map = new HashMap<String, Object>();
                String dateBegin = "";
                Date startDate = bed.getStartDate();
                if(startDate != null){
                    dateBegin = TimeUtil.formatDate(startDate);
                }
                String dateEnd = "";
                Date endTime = bed.getEndTime();
                if(endTime != null){
                    dateEnd = TimeUtil.formatDate(endTime);
                }
                map.put("startDate", dateBegin);
                map.put("endTime", dateEnd);
                map.put("institution", bed.getInstitution());
                map.put("resson", bed.getResson());
                map.put("patientID", bed.getPatientID());
                mapFamilyBedHistoryList.add(map);
            }
            mapFinal.put("familyBedHistory",mapFamilyBedHistoryList);
        }
        if(hospitalizationList != null && hospitalizationList.size() > 0){
            List<Map<String,Object>> mapHospitalizationList = new ArrayList<Map<String,Object>>();
            for(PhHealthexamdetailinpatient hospitalization: hospitalizationList){
                Map<String,Object> map = new HashMap<String, Object>();
                String dateBegin = "";
                Date startDate = hospitalization.getStartDate();
                if(startDate != null){
                    dateBegin = TimeUtil.formatDate(startDate);
                }
                String dateEnd = "";
                Date endTime = hospitalization.getEndTime();
                if(endTime != null){
                    dateEnd = TimeUtil.formatDate(endTime);
                }
                map.put("startDate", dateBegin);
                map.put("endTime", dateEnd);
                map.put("institution", hospitalization.getInstitution());
                map.put("resson", hospitalization.getResson());
                map.put("patientID", hospitalization.getPatientID());
                mapHospitalizationList.add(map);
            }
            mapFinal.put("hospitalization",mapHospitalizationList);
        }
        return mapFinal;
    }
    
    /** 
     * @Title: getMedication 
     * @Description: 获取会员的主要用药情况
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-21
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static List<Map<String,Object>> getMedication(PhHealthexam exam) throws Exception{
        List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        List<PhHealthexamdetailmedicine> medicationList = exam.getPhHealthexamdetailmedicines();
        if(medicationList != null && medicationList.size() > 0){
            for(PhHealthexamdetailmedicine medication: medicationList){
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("drugName", medication.getDrugName());
                map.put("drugUsage", medication.getDrugUsage());
                map.put("drugFreq", medication.getDrugFreq());
                map.put("drugDosage", medication.getDrugDosage());
                map.put("drugUnit", medication.getDrugUnit());
                map.put("drugUseTime", medication.getDrugUseTime());
                map.put("drugComplianceStr", medication.getDrugCompliance());
                map.put("drugCompliance", medication.getDrugCompliance());
                map.put("remarks", medication.getRemarks());
                mapList.add(map);
            }
        }
        return mapList;
    }
    
    /** 
     * @Title: getVaccination 
     * @Description: 获取会员的非免疫规划预防接种史
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-21
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static List<Map<String,Object>> getVaccination(PhHealthexam exam) throws Exception{
        List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        List<PhHealthexamdetailnonimmune> vaccinationList = exam.getPhHealthexamdetailnonimmunes();
        if(vaccinationList != null && vaccinationList.size() > 0){
            for(PhHealthexamdetailnonimmune vaccination: vaccinationList){
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("vaccinateName", vaccination.getVaccinateName());
                String date = "";
                Date vaccinationDate = vaccination.getVaccinateDate();
                if(vaccinationDate != null){
                    date = TimeUtil.formatDate(vaccinationDate);
                }
                map.put("vaccinateDate", date);
                map.put("institution", vaccination.getInstitution());
                mapList.add(map);
            }
        }
        return mapList;
    }
    
    /** 
     * @Title: getHealthEvaluation 
     * @Description: 获取会员的健康评价
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-21
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getHealthEvaluation(PhHealthexam exam) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHealthexamdetail evaluation = exam.getPhHealthexamdetail();
        if(evaluation != null){
            map.put("healthEvaluateStr",evaluation.getHealthEvaluateStr());
            map.put("healthEvaluate",evaluation.getHealthEvaluate());
            String[] ealthEvaluateDescs = evaluation.getHealthEvaluate_Descs();
            if(!StringUtils.isEmpty(ealthEvaluateDescs)){
            	 String healthEvaluateDescStr = StringUtils.arrayToDelimitedString(ealthEvaluateDescs, ",");
            	 map.put("healthEvaluateDescStr",healthEvaluateDescStr);
            }
            map.put("healthEvaluate_Desc",evaluation.getHealthEvaluate_Desc());
        }
        return map;
    }
    
    /** 
     * @Title: getHealthGuidance 
     * @Description: 获取会员的健康指导
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-21
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getHealthGuidance(PhHealthexam exam) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHealthexamdetail guidance = exam.getPhHealthexamdetail();
        if(guidance != null){
            map.put("healthGuideStr",guidance.getHealthGuideStr());
            map.put("healthGuide",guidance.getHealthGuide());
        }
        return map;
    }
    
    /** 
     * @Title: getRiskFactorControl 
     * @Description: 获取会员的危险因素控制
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-21
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getRiskFactorControl(PhHealthexam exam) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHealthexamdetail risk = exam.getPhHealthexamdetail();
        if(risk != null){
            map.put("riskFactorStr",risk.getRiskFactorStr());
            map.put("riskFactor",risk.getRiskFactor());
            map.put("riskFactorTarget",risk.getRiskFactor_Target());
            map.put("riskFactorVaccine",risk.getRiskFactor_Vaccine());
            map.put("riskFactorOther",risk.getRiskFactor_Other());
        }
        return map;
    }
    
    /** 
     * @Title: getNullPropertyNames 
     * @Description: 获取会员的危险因素控制
     * @param Object
     * @author liuxiaoqin
     * @createDate 2016-11-10
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
    
}

