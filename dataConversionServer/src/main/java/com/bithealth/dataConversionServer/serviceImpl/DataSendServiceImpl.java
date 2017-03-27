package com.bithealth.dataConversionServer.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.dataConversionServer.assemble.AssemUtil;
import com.bithealth.dataConversionServer.bean.BloodGlucose;
import com.bithealth.dataConversionServer.bean.BloodPressure;
import com.bithealth.dataConversionServer.bean.SendDataBean;
import com.bithealth.dataConversionServer.dao.BloodGlucoseMapper;
import com.bithealth.dataConversionServer.dao.BloodPressureMapper;
import com.bithealth.dataConversionServer.dao.DataFileRelationMapper;
import com.bithealth.dataConversionServer.model.DataFileRelation;
import com.bithealth.dataConversionServer.service.DataSendService;
import com.bithealth.dataConversionServer.util.Constants;
import com.bithealth.dataConversionServer.util.DataTypeConvert;
import com.bithealth.dataConversionServer.util.FindFieldAndValue;
import com.bithealth.dataConversionServer.util.StringUtil;
import com.bithealth.dataConversionServer.util.UniqueIdCreater;
import com.bithealth.inspectCore.facede.service.InspectFacedeService;
import com.bithealth.inspectCore.facede.service.PhysicalFacedeService;
import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetail;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetailmedicine;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetail;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailmedicine;
import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetail;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailinpatient;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailmedicine;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailnonimmune;
import com.bithealth.inspectCore.physical.service.PhHealthexamdetailinpatientService;
import com.bithealth.measureCore.facade.Facade;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.sdk.common.rabbit.RabbitMqHelper;
import com.bithealth.sdk.common.rabbit.bean.MqMsgBean;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Service("dataSendService")
public class DataSendServiceImpl extends GenericBaseServiceImpl implements DataSendService {
	private static Logger logger = Logger.getLogger(DataSendServiceImpl.class);

	@Autowired
	private MemberService memberService;

	@Autowired
	private BloodGlucoseMapper bloodGlucoseMapper;

	@Autowired
	private BloodPressureMapper bloodPressureMapper;

	@Autowired
	private PhHealthexamdetailinpatientService PhHealthexamdetailinpatientService;

	@Autowired
	private DataFileRelationMapper dataFileRelationMapper;
	
	@Autowired
	private PhysicalFacedeService physicalFacedeService;
	
	@Autowired
	private InspectFacedeService inspectFacedeService;

	@Autowired
	private Facade facade;
	/**
	 *    * 
	 * <p>
	 * Title: sendMemHealthExams
	 * </p>
	 *     
	 * <p>
	 * Description:发送健康体检 
	 * </p>
	 *     @param healthExam  @return  @throws Exception   * @see
	 * com.data.service
	 * .DataSendService#sendMemHealthExams(com.data.bean.HealthExam)  
	 */
	private String sendMemHealthExams(PhHealthexam healthExam, String prgid)
			throws Exception {
		String xmlStr = "";
		if (healthExam != null) {
			Document doc = DocumentHelper.createDocument();
			// 增加根节点
			Element title = doc.addElement("XMLTOPERSONS");
			// 为根节点设置属性
			title.addAttribute("return", "TRUE");
			title.addAttribute("value", "0");
			title.addAttribute("username", "admin");
			title.addAttribute("prgid", prgid);

			Element parameter = title.addElement("Parameters");
			Element row = parameter.addElement("subrow");
			// 为子元素设置属性
			row.addAttribute("name", "T_JK_JKTJ");

			/* 增加子元素:住院治疗情况,包括住院史和家庭病床史 */
			List<PhHealthexamdetailinpatient> inpatientList = healthExam
					.getPhHealthexamdetailinpatients(); // PhHealthexamdetailinpatientService.queryInpatientByHExamID(healthExam.getHExamID());
			for (PhHealthexamdetailinpatient inpatient : inpatientList) {
				Element subrow1 = row.addElement("subrow");
				// 为子元素设置属性
				subrow1.addAttribute("name", "T_TJ_ZYZLQKB");
				// 为子元素创建节点
				// inpatient.setUniqueId(healthExam.getUnique_ID());
				// inpatient.setUpdatetime(healthExam.getUpdatetime());
				Map<String, Object> resultMap = AssemUtil.beanToMap(inpatient,
						"ZLJYHInpatient.xml");
				for (String key : resultMap.keySet()) {
					Element field = subrow1.addElement("field");
					field.addAttribute("name", key);
					field.addCDATA(DataTypeConvert.objToStr(resultMap.get(key)));
				}
			}

			/* 增加子元素:主要用药情况 */
			List<PhHealthexamdetailmedicine> medicineList = healthExam
					.getPhHealthexamdetailmedicines(); // medicineMapper.queryMedicineByHExamID(healthExam.getHExamID());
			for (PhHealthexamdetailmedicine medicine : medicineList) {
				Element subrow1 = row.addElement("subrow");
				// 为子元素设置属性
				subrow1.addAttribute("name", "T_TJ_YYQKB");
				// 为子元素创建节点
				// medicine.setUniqueId(healthExam.getUniqueId());
				// medicine.setUpdatetime(healthExam.getUpdatetime());
				Map<String, Object> resultMap = AssemUtil.beanToMap(medicine,
						"ZLJYHInpatient.xml");
				for (String key : resultMap.keySet()) {
					Element field = subrow1.addElement("field");
					field.addAttribute("name", key);
					field.addCDATA(DataTypeConvert.objToStr(resultMap.get(key)));
				}
			}

			/* 增加子元素:非免疫规划预防接种史begin */
			List<PhHealthexamdetailnonimmune> nonimmuneList = healthExam
					.getPhHealthexamdetailnonimmunes(); // nonimmuneMapper.queryNonimmuneByHExamID(healthExam.getHExamID());
			for (PhHealthexamdetailnonimmune nonimmune : nonimmuneList) {
				Element subrow1 = row.addElement("subrow");
				// 为子元素设置属性
				subrow1.addAttribute("name", "T_TJ_FMYGHYFB");
				// 为子元素创建节点
				// nonimmune.setUniqueId(healthExam.getUniqueId());
				// nonimmune.setUpdatetime(healthExam.getUpdatetime());
				Map<String, Object> resultMap = AssemUtil.beanToMap(nonimmune,
						"ZLJYHNonimmune.xml");
				for (String key : resultMap.keySet()) {
					Element field = subrow1.addElement("field");
					field.addAttribute("name", key);
					field.addCDATA(DataTypeConvert.objToStr(resultMap.get(key)));
				}
			}

			// 添加体检明细内容
			PhHealthexamdetail detail = healthExam.getPhHealthexamdetail(); // detailMapper.queryDetailByHExamID(healthExam.getHExamID());
			Map<String, Object> resultMap = AssemUtil.beanToMap(detail,
					"ZLJYHExamdetail.xml");
			if (null != resultMap) {
				for (String key : resultMap.keySet()) {
					Element field = row.addElement("field");
					field.addAttribute("name", key);
					field.addCDATA(DataTypeConvert.objToStr(resultMap.get(key)));
				}
			}
			xmlStr = doc.asXML();
		}
		return xmlStr;

	}

	/**
	 *    * 
	 * <p>
	 * Title: sendDiabetesVisits
	 * </p>
	 *     
	 * <p>
	 * Description: 发送糖尿病随访记录 
	 * </p>
	 *  @param diabetesVisits  @return  @throws Exception   * @see
	 * com.data.sevice
	 * .DataSendService#sendDiabetesVisits(com.data.bean.DiabetesVisits)  
	 */

	public String sendDiabetesVisits(PhDiabetes diabetes, String prgid)
			throws Exception {
		String xmlStr = "";
		if (diabetes != null && null != diabetes.getDiabetesID()) {
			Long diabetesId = diabetes.getDiabetesID();
			PhDiabetes phDiabetes = inspectFacedeService.selectPhDiabetesById(diabetesId);
			List<PhDiabetesdetailmedicine> listmedicine = phDiabetes.getPhDiabetesdetailmedicines();
			PhDiabetesdetail phDiabetesdetail = phDiabetes
					.getPhDiabetesdetail();
			HashMap<String, Object> myMap = new HashMap<String, Object>();
			String medicineName = "";
			String medicineyf = "";
			for (PhDiabetesdetailmedicine medic : listmedicine) {
				medicineName += medic.getDrugName() + ",";
				medicineyf += medic.getDrugFreq() + ",";
			}
			medicineyf = medicineyf.substring(0, medicineyf.length() - 1);
			medicineName = medicineName.substring(0, medicineName.length() - 1);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("DGrdabh", diabetes.getUnique_ID());
			resultMap.put("YHappentime", diabetes.getVisitDate());
			resultMap.put("YYwyf", medicineyf);
			resultMap.put("YYwmc", medicineName);
			Map<String, Object> resultDiabetes = AssemUtil.beanToMap(
					phDiabetesdetail, "ZLYJHDiabetesdetail.xml");
			myMap.putAll(resultDiabetes);
			String zz = phDiabetesdetail.getSymptom().replaceAll("@#", ",");
			myMap.put("TMqzz", zz);

			Map<String, Object> resultDetail = AssemUtil.beanToMap(diabetes,
					"ZLYJHDiabetes.xml");
			myMap.putAll(resultDetail);

			Document doc = DocumentHelper.createDocument();
			// 增加根节点
			Element title = doc.addElement("XMLTOPERSONS");
			// 为根节点设置属性
			title.addAttribute("return", "TRUE");
			title.addAttribute("value", "0");
			title.addAttribute("username", "admin");
			title.addAttribute("prgid", prgid);

			Element parameter = title.addElement("Parameters");
			Element row = parameter.addElement("subrow");
			// 为子元素设置属性
			row.addAttribute("name", "T_JG_TNBSFB");

			Element row1 = row.addElement("subrow");

			row1.addAttribute("name", "T_JG_TNBSFB_YYQK");

			for (String key : resultMap.keySet()) {
				Element field = row1.addElement("field");
				field.addAttribute("name", key);
				field.addCDATA(DataTypeConvert.objToStr(resultMap.get(key)));
			}
			/* 增加子元素: 用药情况 begin */
			// 待添加用药情况信息
			/* 增加子元素: 用药情况 end */

			for (String key : myMap.keySet()) {
				Element field = row.addElement("field");
				field.addAttribute("name", key);
				field.addCDATA(DataTypeConvert.objToStr(myMap.get(key)));
			}
			/*
			 * //为节点添加内容 List<FindFieldAndValue> objectList =
			 * FindFieldAndValue.testReflect(diabetesVisits);
			 * for(FindFieldAndValue object : objectList) { Element field =
			 * row.addElement("field "); field.addCDATA(object.getValue());
			 * field.addAttribute("name", object.getName()); }
			 */
			xmlStr = doc.asXML();
		}
		return xmlStr;

	}

	/**
	 *    * 
	 * <p>
	 * Title: sendHypertensionVisits
	 * </p>
	 *     
	 * <p>
	 * Description: 发送高血压随访记录
	 * </p>
	 *     @param hypertensionVisits  @return  @throws Exception   * @see
	 * com.data.sevice.DataSendService#sendHypertensionVisits(com.data.bean.
	 * HypertensionVisits)  
	 */

	private String sendHypertensionVisits(Map<String, Object> hypertMap,
			List<Map<String, Object>> medicalList, String prgId)
			throws Exception {
		Document doc = DocumentHelper.createDocument();
		Element title = doc.addElement("XMLTOPERSONS");
		// 为根节点设置属性
		title.addAttribute("return", "TRUE");
		title.addAttribute("value", "0");
		title.addAttribute("username", "admin");
		title.addAttribute("prgid", prgId);

		Element parameter = title.addElement("Parameters");
		Element row = parameter.addElement("subrow");
		row.addAttribute("name", "T_JG_GXYSFB");
		for (String key : hypertMap.keySet()) {
			Element field = row.addElement("field");
			field.addAttribute("name", key);
			field.addCDATA(DataTypeConvert.objToStr(hypertMap.get(key)));
		}
		if (medicalList.size() == 0) {
			return doc.asXML();
		}
		for (Map<String, Object> medical : medicalList) {
			Element drug = row.addElement("subrow");
			drug.addAttribute("name", "T_JG_GXYSFB_YYQK");
			for (String key : medical.keySet()) {
				Element field = drug.addElement("field");
				field.addAttribute("name", key);
				field.addCDATA(DataTypeConvert.objToStr(medical.get(key)));
			}
		}
		return doc.asXML();
	}

	/**
	 *    * 
	 * <p>
	 * Title: sendBloodGlucose
	 * </p>
	 *     
	 * <p>
	 * Description: 上传血糖测量结果
	 * </p>
	 *     @param bloodGlucose  @return  @throws Exception   * @see
	 * com.data.sevice
	 * .DataSendService#sendBloodGlucose(com.data.bean.BloodGlucose)  
	 */
	public String sendBloodGlucose(BloodGlucose bloodGlucose, String prgid)
			throws Exception {
		String xmlStr = "";
		if (bloodGlucose != null) {
//			bloodGlucose.setAbnormal(String.valueOf(getBloodGlucoseResult(bloodGlucose)));
			bloodGlucose.setAbnormal(facade.getBloodSugarCnType(bloodGlucose.getTimePeriod(), bloodGlucose.getBsValue()));
			Document doc = DocumentHelper.createDocument();
			// 增加根节点
			Element title = doc.addElement("XMLTOPERSONS");
			// 为根节点设置属性
			title.addAttribute("return", "TRUE");
			title.addAttribute("value", "0");
			title.addAttribute("username", "admin");
			title.addAttribute("prgid", prgid);

			Element parameter = title.addElement("Parameters");

			// Element row = parameter.addElement("row");
			// 为子元素设置属性
			parameter.addAttribute("name", "T_JK_XTCL");

			// 为节点添加内容
			List<FindFieldAndValue> objectList = FindFieldAndValue
					.testReflect(bloodGlucose);
			for (FindFieldAndValue object : objectList) {
				Element field = parameter.addElement("field ");
				field.addCDATA(object.getValue());
				field.addAttribute("name", object.getName());
			}
			xmlStr = doc.asXML();
		}
		return xmlStr;

	}

	/**
	 *    * 
	 * <p>
	 * Title: sendBloodPressure
	 * </p>
	 *     
	 * <p>
	 * Description: 上传血压、脉率测量结果
	 * </p>
	 *     @param bloodPressure  @return  @throws Exception   * @see
	 * sendBloodPressure
	 */
	public String sendBloodPressure(BloodPressure bloodPressure, String prgid)
			throws Exception {
		String xmlStr = "";
		if (bloodPressure != null) {
			//bloodPressure.setAbnormal(String.valueOf(getBloodPressureResult(bloodPressure))); 
			bloodPressure.setAbnormal(facade.getBloodPressCnType(bloodPressure.getDbp(), bloodPressure.getSbp()));
			Document doc = DocumentHelper.createDocument();
			// 增加根节点
			Element title = doc.addElement("XMLTOPERSONS");
			// 为根节点设置属性
			title.addAttribute("return", "TRUE");
			title.addAttribute("value", "0");
			title.addAttribute("username", "admin");
			title.addAttribute("prgid", prgid);
			Element parameter = title.addElement("Parameters");

			// Element row = parameter.addElement("row");
			// 为子元素设置属性
			parameter.addAttribute("name", "T_JK_XYML");

			// 为节点添加内容
			List<FindFieldAndValue> objectList = FindFieldAndValue
					.testReflect(bloodPressure);
			for (FindFieldAndValue object : objectList) {
				Element field = parameter.addElement("field ");
				field.addCDATA(object.getValue());
				field.addAttribute("name", object.getName());
			}
			xmlStr = doc.asXML();
		}
		return xmlStr;

	}

	/**
	 *    * @Title: getBloodPressureResult   * @Description: 获取血压分析结果   @param
	 * bloodPressure  @return  @throws Exception      * @retrun int
	 */
	private int getBloodPressureResult(BloodPressure bloodPressure)
			throws Exception {
		int sbp = bloodPressure.getSbp();
		int dbp = bloodPressure.getDbp();
		if ((sbp >= 140 && sbp < 150) && (dbp >= 60 && dbp < 90)) {
			return 5; // "单纯收缩期高血压";
		} else if ((sbp >= 140 && sbp < 160) || (dbp >= 90 && dbp < 100)) {
			return 4; // "轻度高血压";
		} else if ((sbp >= 160 && sbp < 180) || (dbp >= 100 && dbp < 110)) {
			return 3; // "中度高血压";
		} else if (sbp >= 180 || dbp >= 110) {
			return 2; // "高度高血压";
		} else if (sbp < 90 || dbp < 60) {
			return 1; // "低血压";
		} else if ((sbp >= 90 && sbp <= 130) && (dbp >= 60 && dbp <= 85)) {
			return 0; // "正常";
		} else if ((sbp > 130 && sbp < 140) && (dbp > 85 && dbp < 90)) {
			return 6; // "正常偏高";
		}
		return 0;
	}

	/**
	 *    * @Title: getBloodGlucoseResult   * @Description: 获取血糖分析结果   @param
	 * bloodGlucose  @return  @throws Exception      * @retrun int
	 */
	private int getBloodGlucoseResult(BloodGlucose bloodGlucose)
			throws Exception {
		float value = bloodGlucose.getBsValue();
		int timePeriod = bloodGlucose.getTimePeriod();
		// 分析结果值(1:血糖偏低;2:血糖偏高;0：正常)
		int analysisResult = 0;
		// 早晨空腹(1),午餐前(3),晚餐前(5),睡前(7),夜间(8) 值为：3.9-6.1mmol/L(正常值：包括前者，不包括后者)
		if (timePeriod == 1 || timePeriod == 3 || timePeriod == 5
				|| timePeriod == 7 || timePeriod == 8) {
			if (value < 3.9f) {
				analysisResult = 1;
			} else if (value >= 6.1f) {
				analysisResult = 2;
			}
		}
		// 早餐后2小时(2),午餐后2小时(4),晚餐后2小时(6) 值为：3.9-7.8mmol/L(正常值：包括前者，不包括后者)
		else if (timePeriod == 2 || timePeriod == 4 || timePeriod == 6) {
			if (value < 3.9f) {
				analysisResult = 1;
			} else if (value >= 7.8f) {
				analysisResult = 2;
			}
		}
		// 随机血糖(0) 值为：3.9-11.1mmol/L(正常值：包括前者，不包括后者)
		else {
			if (value < 3.9f) {
				analysisResult = 1;
			} else if (value >= 11.1f) {
				analysisResult = 2;
			}
		}
		return analysisResult;
	}

	/**
	 *    * @Title: getBloodGlucoseXmlStrs   * @Description: 获取血糖   @param
	 * BloodPressure  @return  @throws Exception      * @retrun BloodGlucose
	 */
	public List<DataFileRelation> getBloodGlucoseXmlStrs(Date startTime,
			String prgid, int source) throws Exception {
		SendDataBean param = new SendDataBean();
		param.setSendTime(startTime);
		param.setPrgid(prgid);
		param.setSource(source);
		List<DataFileRelation> bloodGlucoseStrList = new ArrayList<DataFileRelation>();
		List<BloodGlucose> bloodGlucoseList = bloodGlucoseMapper
				.findBloodGlucoseList(param);
		for (BloodGlucose newBloodGlucose : bloodGlucoseList) {
			String xmlStr = sendBloodGlucose(newBloodGlucose, prgid);
			if (!StringUtil.isEmpty(xmlStr)) {
				DataFileRelation relation = new DataFileRelation();
				relation.setDataFile(xmlStr.getBytes("utf-8"));
				relation.setTime(param.getSendTime());
				relation.setSourceKey(newBloodGlucose.getId());
				relation.setPrgId(prgid);
				bloodGlucoseStrList.add(relation);
			}
		}
		return bloodGlucoseStrList;
	}

	/**
	 *    * @Title: getBloodPressureXmlStrs   * @Description: 获取血压   @param
	 * BloodPressure  @return  @throws Exception      * @retrun BloodPressure
	 */
	public List<DataFileRelation> getBloodPressureXmlStrs(Date startTime,
			String prgid, int source) throws Exception {
		SendDataBean param = new SendDataBean();
		param.setSendTime(startTime);
		param.setPrgid(prgid);
		param.setSource(source);
		List<DataFileRelation> bloodPressureStrList = new ArrayList<DataFileRelation>();
		List<BloodPressure> bloodPressureList = bloodPressureMapper
				.findBloodPressureList(param);
		for (BloodPressure newBloodPressure : bloodPressureList) {
			String xmlStr = sendBloodPressure(newBloodPressure, prgid);
			if (!StringUtil.isEmpty(xmlStr)) {
				DataFileRelation relation = new DataFileRelation();
				relation.setDataFile(xmlStr.getBytes("utf-8"));
				relation.setTime(param.getSendTime());
				relation.setSourceKey(newBloodPressure.getId());
				relation.setPrgId(prgid);
				bloodPressureStrList.add(relation);
			}
		}
		return bloodPressureStrList;
	}

	/**
	 *    * @Title: getBloodPressureXmlStrs   * @Description: 获取糖尿病随访   @param
	 * BloodPressure  @return  @throws Exception      * @retrun BloodPressure
	 */
	public List<DataFileRelation> getDiabetesVisitsXmlStrs(Date StartTime,
			String prgid, int source) throws Exception {
		List<DataFileRelation> diabetesVisitsStrList = new ArrayList<DataFileRelation>();
		List<PhDiabetes> list1 = inspectFacedeService.selectPhDiabetesList(StartTime, source, prgid);
		if (null != list1 && list1.size() > 0) {
			for (PhDiabetes diabetes : list1) {
				String xmlStr = sendDiabetesVisits(diabetes, prgid);
				if (!StringUtil.isEmpty(xmlStr)) {
					DataFileRelation relation = new DataFileRelation();
					relation.setDataFile(xmlStr.getBytes("utf-8"));
					relation.setTime(StartTime);
					relation.setSourceKey(diabetes.getDiabetesID());
					relation.setPrgId(prgid);
					diabetesVisitsStrList.add(relation);
				}
			}
		}
		return diabetesVisitsStrList;
	}

	public List<DataFileRelation> getHypertensionVisitsXmlStrs(Date startTime,
			String prgid, int source) throws Exception {
		List<DataFileRelation> hypertensionVisitsStrList = new ArrayList<DataFileRelation>();
		List<PhHypertension> hypertensionVisitsList = inspectFacedeService.selectPhHypertensionList(startTime, source, prgid);
		if (hypertensionVisitsList.size() == 0) {
			return null;
		}
		for (PhHypertension hyper : hypertensionVisitsList) {
			String uniqueId = hyper.getUnique_ID();
			Map<String, Object> resultMap = AssemUtil.beanToMap(hyper,
					Constants.HYPERTENSION_ZLJY_FILE);
			Map<String, Object> myMap = new HashMap<String, Object>();
			myMap.putAll(resultMap);

			Member bean = memberService.selectByUniqueId(uniqueId);
			if (bean == null) {
				continue;
			}
			Map<String, Object> memMap = AssemUtil.beanToMap(bean,
					Constants.HYPERTENSION_ZLJY_FILE);
			myMap.putAll(memMap);

			PhHypertensiondetail detail = hyper.getPhHypertensiondetail(); // phHypertensiondetailMapper.selectByPrimaryKey(hyper.getHypertensionID());
			Map<String, Object> retailMap = AssemUtil.beanToMap(detail,
					Constants.HYPERTENSION_ZLJY_FILE);

			myMap.putAll(retailMap);
			List<PhHypertensiondetailmedicine> medicalList = hyper
					.getPhHypertensiondetailmedicines(); // phHypertensiondetailmedicineMapper.queryMedicalList(hyper.getHypertensionID());
			List<Map<String, Object>> medicalMapList = new ArrayList<Map<String, Object>>();
			for (PhHypertensiondetailmedicine medical : medicalList) {
				Map<String, Object> map = AssemUtil.beanToMap(medical,
						Constants.HYPERTENSION_MEDCIAL_ZLJY_FILE);
				if (map == null) {
					continue;
				}
				map.put("DGrdabh", hyper.getUnique_ID());
				map.put("YHappentime", hyper.getVisitDate());
				medicalMapList.add(map);
			}
			String xmlStr = sendHypertensionVisits(myMap, medicalMapList, prgid);
			DataFileRelation relation = new DataFileRelation();
			relation.setDataFile(xmlStr.getBytes("utf-8"));
			relation.setTime(startTime);
			relation.setSourceKey(hyper.getHypertensionID());
			relation.setPrgId(prgid);
			hypertensionVisitsStrList.add(relation);
		}
		return hypertensionVisitsStrList;
	}

	public List<DataFileRelation> getHealthExamsXmlStrs(Date startTime,
			String prgid, int source) throws Exception {
		List<DataFileRelation> healthExamStrList = new ArrayList<DataFileRelation>();
		List<PhHealthexam> healthExamList = physicalFacedeService.selectPhHealthexamList(startTime, source, prgid);
		for (PhHealthexam newHealthExam : healthExamList) {
			String xmlStr = sendMemHealthExams(newHealthExam, prgid);
			if (!StringUtil.isEmpty(xmlStr)) {
				DataFileRelation relation = new DataFileRelation();
				relation.setDataFile(xmlStr.getBytes("utf-8"));
				relation.setTime(startTime);
				relation.setSourceKey(newHealthExam.getHExamID());
				relation.setPrgId(prgid);
				healthExamStrList.add(relation);
			}
		}
		return healthExamStrList;
	}

	public void saveRelationAndSendMsgToMq(
			List<DataFileRelation> sendDataBeanList, String operation,
			int companyCode) throws Exception {
		for (DataFileRelation relation : sendDataBeanList) {
			// 获取数据并添加到data_center_relation数据文件关联关系表中
			relation.setCompanyCode(companyCode);
			relation.setDataId(UniqueIdCreater.getUUID());
			relation.setType(1);
			relation.setFileStatus(0);
			relation.setMethodCode(operation);
			dataFileRelationMapper.saveZLJYUserData(relation);

			// 发送解析命令到 rabbitMq消息队列中
			MqMsgBean msgBean = new MqMsgBean();
			msgBean.setCompanyCode(relation.getCompanyCode());
			msgBean.setDataId(relation.getDataId());
			msgBean.setOperation(operation);
			msgBean.setTimestamp(TimeUtil.currentDatetime());
			RabbitMqHelper.sendMsgToSendQueue(msgBean);
		}
	}

	@Override
	public GenericBaseDao getDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
