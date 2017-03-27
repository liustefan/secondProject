package com.bithealth.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetail;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetailmedicine;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetail;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailmedicine;
import com.bithealth.memberCore.member.model.Member;


/**
 * @ClassName:     HealthCheckUtil.java 
 * @Description:   健康体检工具包
 * @author         lenovo  
 * @version        V1.0   
 * @Date           2016年3月21日 上午11:14:17
*****/
public class VisitUtil {
    
    /** 
     * @Title: getHyperBasicInfo 
     * @Description: 获取会员的高血压基本资料 
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getHyperBasicInfo(PhHypertension visit) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        Member omem = visit.getMember();
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
            map.put("memberId", visit.getMemberID());
            map.put("memName", visit.getName());
            map.put("idcard", visit.getIDCard());
            map.put("age", 0);
        }
        return map;
    }
    
    /** 
     * @Title: getHyperPhysicalSigns 
     * @Description: 获取会员的高血压体征
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getHyperPhysicalSigns(PhHypertension visit) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHypertensiondetail detail = visit.getPhHypertensiondetail();
        if(detail != null){
            map.put("systolic", detail.getSystolic());
            map.put("diastolic", detail.getDiastolic());
            //PHOmem omem = visit.getOmem();
            BigDecimal height = detail.getHeight();
//            if(height == null){
//                Integer memHeight = omem.getHeight();
//                if(memHeight != null && memHeight > 0){
//                    height = (double)memHeight;
//                }
//            }
            map.put("height", height);
            BigDecimal weight = detail.getWeight();
//            if(weight == null){
//                Double memWeight = omem.getWeight();
//                if(memWeight != null && memWeight > 0){
//                    weight = memWeight;
//                }
//            }
            map.put("weight", weight);
            map.put("bmi", detail.getBMI());
            map.put("otherSign", detail.getOtherSign());
            map.put("heartRate", detail.getHeartRate());
        }
        return map;
    }
    
    /** 
     * @Title: getHyperLifeStyle 
     * @Description: 获取会员的高血压生活方式指导
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getHyperLifeStyle(PhHypertension visit) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhHypertensiondetail detail = visit.getPhHypertensiondetail();
        if(detail != null){
            map.put("dailySmoking", detail.getDailySmoking());
            map.put("dailySmokingNext", detail.getDailySmoking_Next());
            map.put("dailyDrink", detail.getDailyDrink());
            map.put("dailyDrinkNext", detail.getDailyDrink_Next());
            map.put("sportFrequency", detail.getSportFrequency());
            map.put("sportDuration", detail.getSportDuration());
            map.put("intakeSaltStr", detail.getIntakeSaltStr());
            map.put("psychologicalRecoveryStr", detail.getPsychoRecoStr());
            map.put("complianceBehaviorStr", detail.getCompliBehavStr());
        }
        return map;
    }
    
    /** 
     * @Title: getHyperMedication 
     * @Description: 获取会员的高血压用药情况
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static List<Map<String,Object>> getHyperMedication(PhHypertension visit) throws Exception{
        List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        List<PhHypertensiondetailmedicine> medicationList = visit.getPhHypertensiondetailmedicines();
        if(medicationList != null && medicationList.size() > 0){
            for(PhHypertensiondetailmedicine medication: medicationList){
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("logID", medication.getLogID());
                map.put("hypertensionID", medication.getHypertensionID());
                map.put("drugName", medication.getDrugName());
                map.put("drugUsage", medication.getDrugUsage());
                map.put("drugFreq", medication.getDrugFreq());
                map.put("drugDosage", medication.getDrugDosage());
                map.put("drugUnit", medication.getDrugUnit());
                map.put("remarks", medication.getRemarks());
                mapList.add(map);
            }
        }
        return mapList;
    }
    
    /** 
     * @Title: getHyperBasicInfo 
     * @Description: 获取会员的糖尿病基本资料 
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getDiabeBasicInfo(PhDiabetes visit) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        Member omem = visit.getMember();
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
            map.put("memberId", visit.getMemberID());
            map.put("memName", visit.getName());
            map.put("idcard", visit.getIDCard());
            map.put("age", 0);
        }
        return map;
    }
    
    /** 
     * @Title: getDiabePhysicalSigns 
     * @Description: 获取会员的糖尿病体征
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getDiabePhysicalSigns(PhDiabetes visit) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhDiabetesdetail detail = visit.getPhDiabetesdetail();
        if(detail != null){
            map.put("systolic", detail.getSystolic());
            map.put("diastolic", detail.getDiastolic());
            //PHOmem omem = visit.getOmem();
            BigDecimal height = detail.getHeight();
//            if(height == null){
//                Integer memHeight = omem.getHeight();
//                if(memHeight != null && memHeight > 0){
//                    height = (double)memHeight;
//                }
//            }
            map.put("height", height);
            BigDecimal weight = detail.getWeight();
//            if(weight == null){
//                Double memWeight = omem.getWeight();
//                if(memWeight != null && memWeight > 0){
//                    weight = memWeight;
//                }
//            }
            map.put("weight", weight);
            map.put("bmi", detail.getBMI());
            map.put("otherSign", detail.getOtherSign());
            map.put("arteriopalmusStr", detail.getArteriopalmusStr());
        }
        return map;
    }
    
    /** 
     * @Title: getHyperLifeStyle 
     * @Description: 获取会员的糖尿病生活方式指导
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getDiabeLifeStyle(PhDiabetes visit) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhDiabetesdetail detail = visit.getPhDiabetesdetail();
        if(detail != null){
            map.put("dailySmoking", detail.getDailySmoking());
            map.put("dailySmokingNext", detail.getDailySmoking_Next());
            map.put("dailyDrink", detail.getDailyDrink());
            map.put("dailyDrinkNext", detail.getDailyDrink_Next());
            map.put("sportFrequency", detail.getSportFrequency());
            map.put("sportDuration", detail.getSportDuration());
            map.put("mainFood", detail.getMainFood());
            map.put("psychologicalRecoveryStr", detail.getPsychoRecoStr());
            map.put("complianceBehaviorStr", detail.getCompliBehavStr());
        }
        return map;
    }
    
    /** 
     * @Title: getHyperLifeStyle 
     * @Description: 获取会员的糖尿病辅助检查
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static Map<String,Object> getDiabeAccessoryExamination(PhDiabetes visit) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        PhDiabetesdetail detail = visit.getPhDiabetesdetail();
        if(detail != null){
            map.put("fpg", detail.getFPG());
            map.put("hba1c", detail.getHBA1C());
            map.put("pglu", detail.getPGLU());
            map.put("checkResult", detail.getCheckResult());
        }
        return map;
    }
    
    /** 
     * @Title: getDiabeMedication 
     * @Description: 获取会员的糖尿病用药情况
     * @param exam
     * @author liuxiaoqin
     * @createDate 2016-03-18
     * @return
     * @throws Exception    
     * @retrun Map<String,Object>
     */
    public static List<Map<String,Object>> getDiabeMedication(PhDiabetes visit) throws Exception{
        List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        List<PhDiabetesdetailmedicine> medicationList = visit.getPhDiabetesdetailmedicines();
        if(medicationList != null && medicationList.size() > 0){
            for(PhDiabetesdetailmedicine medication: medicationList){
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("logID", medication.getLogID());
                map.put("diabetesID", medication.getDiabetesID());
                map.put("drugName", medication.getDrugName());
                map.put("drugUsage", medication.getDrugUsage());
                map.put("drugFreq", medication.getDrugFreq());
                map.put("drugDosage", medication.getDrugDosage());
                map.put("drugUnit", medication.getDrugUnit());
                map.put("remarks", medication.getRemarks());
                mapList.add(map);
            }
        }
        return mapList;
    }
    
}

