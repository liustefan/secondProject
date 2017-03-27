package com.bithealth.dataConversionServer.assemble;

import org.apache.log4j.Logger;

import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExam;





/**
 * @ClassName:     HealthexamAssem.java 
 * @Description:   健康体检特殊字段装配方法类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年3月1日 下午6:02:22
*****/
public class HealthexamAssem {
	
	private Logger logger = Logger.getLogger(AssemUtil.class);
	
	public Object symptomAssem(Object sourceObj){
		try {
			ThealthExam thealthExam = (ThealthExam)sourceObj;
			return AssemUtil.getFileValeAssem(new String[]{"symptom","symptom2","symptom3","symptom4","symptom5",
														    "symptom6","symptom7","symptom8","symptom9","symptom10"},thealthExam);
		} catch (Exception e) {
			logger.error("装配对象属性异常。"+e);
			return null;
		}
	}
	
	public Object eatinghabitsAssem(Object sourceObj){
		try {
			ThealthExam thealthExam = (ThealthExam)sourceObj;
			return AssemUtil.getFileValeAssem(new String[]{"eatHabits","eatHabits2","eatHabits3"},thealthExam);
		} catch (Exception e) {
			logger.error("装配对象属性异常。"+e);
			return null;
		}
	}
	
	
	public Object driSpeciesAssem(Object sourceObj){
		try {
			ThealthExam thealthExam = (ThealthExam)sourceObj;
			return AssemUtil.getFileValeAssem(new String[]{"driSpecies","driSpecies2","driSpecies3","driSpecies4"},thealthExam);
		} catch (Exception e) {
			logger.error("装配对象属性异常。"+e);
			return null;
		}
	}
	
	public Object breastExamAssem(Object sourceObj){
		try {
			ThealthExam thealthExam = (ThealthExam)sourceObj;
			return AssemUtil.getFileValeAssem(new String[]{"breastExam","breastExam2","breastExam3","breastExam4"},thealthExam);
		} catch (Exception e) {
			logger.error("装配对象属性异常。"+e);
			return null;
		}
	}
	
	public Object cerDisAssem(Object sourceObj){
		try {
			ThealthExam thealthExam = (ThealthExam)sourceObj;
			return AssemUtil.getFileValeAssem(new String[]{"cerDis","cerDis2","cerDis3","cerDis4","cerDis5"},thealthExam);
		} catch (Exception e) {
			logger.error("装配对象属性异常。"+e);
			return null;
		}
	}
	
	
	public Object kidDisAssem(Object sourceObj){
		try {
			ThealthExam thealthExam = (ThealthExam)sourceObj;
			return AssemUtil.getFileValeAssem(new String[]{"kidDis","kidDis2","kidDis3","kidDis4","kidDis5"},thealthExam);
		} catch (Exception e) {
			logger.error("装配对象属性异常。"+e);
			return null;
		}
	}
	
	public Object heaDisAssem(Object sourceObj){
		try {
			ThealthExam thealthExam = (ThealthExam)sourceObj;
			return AssemUtil.getFileValeAssem(new String[]{"heaDis","heaDis2","heaDis3","heaDis4","heaDis5"},thealthExam);
		} catch (Exception e) {
			logger.error("装配对象属性异常。"+e);
			return null;
		}
	}
	
	
	public Object vasDisAssem(Object sourceObj){
		try {
			ThealthExam thealthExam = (ThealthExam)sourceObj;
			return AssemUtil.getFileValeAssem(new String[]{"vasDis","vasDis2","vasDis3"},thealthExam);
		} catch (Exception e) {
			logger.error("装配对象属性异常。"+e);
			return null;
		}
	}
	
	public Object heaAssAbnAssem(Object sourceObj){
		try {
			ThealthExam thealthExam = (ThealthExam)sourceObj;
			return AssemUtil.getFileValeAssem(new String[]{"heaAssAbn","heaAssAbn2","heaAssAbn3","heaAssAbn4"},thealthExam);
		} catch (Exception e) {
			logger.error("装配对象属性异常。"+e);
			return null;
		}
	}
	
	public Object heaGuiAssem(Object sourceObj){
		try {
			ThealthExam thealthExam = (ThealthExam)sourceObj;
			return AssemUtil.getFileValeAssem(new String[]{"heaGui","heaGui2","heaGui3"},thealthExam);
		} catch (Exception e) {
			logger.error("装配对象属性异常。"+e);
			return null;
		}
	}
	
	public Object hazConRecAssem(Object sourceObj){
		try {
			ThealthExam thealthExam = (ThealthExam)sourceObj;
			return AssemUtil.getFileValeAssem(new String[]{"hazConRec","hazConRec2","hazConRec3","hazConRec4","hazConRec5","hazConRec6"},thealthExam);
		} catch (Exception e) {
			logger.error("装配对象属性异常。"+e);
			return null;
		}
	}
	
	
	

}