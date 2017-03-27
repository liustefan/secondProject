 
/**
 * @PackageName:      com.bithealth.inspectCore.facede.impl
 * @FileName:     InspectFacedeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月1日 上午9:43:55  
 * 
 */

package com.bithealth.inspectCore.facede.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bithealth.careCore.facade.model.MsgCenter;
import com.bithealth.careCore.facade.service.CareIFService;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.inspectCore.Constants;
import com.bithealth.inspectCore.dao.InspectDao;
import com.bithealth.inspectCore.dict.service.DictService;
import com.bithealth.inspectCore.facede.service.InspectFacedeService;
import com.bithealth.inspectCore.inspect.model.Inspectdetail;
import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesExample;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetail;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensionExample;
import com.bithealth.inspectCore.inspect.service.InspectService;
import com.bithealth.inspectCore.inspect.service.PhDiabetesService;
import com.bithealth.inspectCore.inspect.service.PhDiabetesdetailService;
import com.bithealth.inspectCore.inspect.service.PhDiabetesdetailmedicineService;
import com.bithealth.inspectCore.inspect.service.PhHypertensionService;
import com.bithealth.inspectCore.inspect.service.PhHypertensiondetailService;
import com.bithealth.inspectCore.inspect.service.PhHypertensiondetailmedicineService;
import com.bithealth.inspectCore.model.DictEntity;
import com.bithealth.inspectCore.model.Inspect;
import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetail;
import com.bithealth.inspectCore.physical.service.PhysicalService;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarService;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.msgCenterCore.constants.UserTypeEnum;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: InspectFacedeServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月1日 上午9:43:55 
 * 
 * @author baozj
 * @version  
 */
@Service
public class InspectFacedeServiceImpl implements InspectFacedeService {

	protected static Logger logger = Logger.getLogger(InspectFacedeServiceImpl.class);
	
	@Autowired
	private InspectService inspectService;
	@Autowired
	private PhysicalService physicalService;
	@Autowired
	private InspectDao inspectDao;
	@Autowired
	private DictService dictService;
	@Autowired
	private BloodSugarService bloodSugarService;
	@Autowired
	private BloodPressureService bloodPressureService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private CareIFService careIFService;
	@Autowired
	private PhDiabetesService phDiabetesService;
	@Autowired
	private PhHypertensionService phHypertensionService;
	@Autowired
	private PhDiabetesdetailService phDiabetesdetailService;
	@Autowired
	private PhDiabetesdetailmedicineService phDiabetesdetailmedicineService;
	@Autowired
	private PhHypertensiondetailService phHypertensiondetailService;
	@Autowired
	private PhHypertensiondetailmedicineService phHypertensiondetailmedicineService;
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#insertPhDiabetes(com.bithealth.inspectCore.inspect.model.PhDiabetes)
	 */
	public boolean insertPhDiabetes(PhDiabetes pojo) {
		
		return inspectService.insertPhDiabetes(pojo) > 0;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#updatePhDiabetes(com.bithealth.inspectCore.inspect.model.PhDiabetes)
	 */
	public boolean updatePhDiabetes(PhDiabetes pojo) {
		
		return inspectService.updatePhDiabetes(pojo) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#insertOrUpdateDiabetes(com.bithealth.inspectCore.inspect.model.PhDiabetes)
	 */
	public boolean insertOrUpdateDiabetes(PhDiabetes pojo) {
		DictEntity.setDicts(dictService.selectAllSecond_cache());
		if(pojo.getVisitClass() == null)
			pojo.setVisitClass((byte)0);
		if(pojo.getRefCompany() > 0){//如果是对接数据，根据对接公司主键查询数据，并赋值本地主键
			inspectService.selectPhDiabetesExistByRefDataPK(pojo);
		}else{
//			if(pojo.getVisitClass().equals((byte)0) && inspectService.hasPendingDiabetes(pojo.getMemberID(), pojo.getDiabetesID()))//有待随访数据，禁止添加待随访数据
//				return false;
		}
		if(StringUtils.isEmpty(pojo.getRefDataPK()))	
			pojo.setRefDataPK(UUID.randomUUID().toString());
		if(pojo.getDiabetesID() == null){
			if(inspectService.insertPhDiabetes(pojo) > 0){
				sendDMessage(pojo);
				return true;
			}
		}else{
			if(inspectService.updatePhDiabetes(pojo) > 0){
				sendDMessage(pojo);
				return true;
			}
		}
		return false;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#deletePhDiabetes(java.lang.Long[])
	 */
	public boolean deletePhDiabetes(Long... ids) {
		
		return inspectService.deletePhDiabetes(ids) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#deleteSoftPhDiabetes(java.lang.Long[])
	 */
	public boolean deleteSoftPhDiabetes(Long... ids) {
		
		return inspectService.deleteSoftPhDiabetes(ids) > 0;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhDiabetesById(java.lang.Long)
	 */
	public PhDiabetes selectPhDiabetesById(Long id) {
		DictEntity.setDicts(dictService.selectAllSecond_cache());
		if(id == null)
			return null;
		return inspectService.selectPhDiabetesById(id);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhDiabetesByRefDataPK(java.lang.String)
	 */
	public PhDiabetes selectPhDiabetesByRefDataPK(String refDataPK) {
		
		return inspectService.selectPhDiabetesByRefDataPK(refDataPK);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhDiabetesByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.inspect.model.PhDiabetesExample)
	 */
	public Page<PhDiabetes> selectPhDiabetesByExampleAndPage(
			Page<PhDiabetes> page, PhDiabetesExample example) {
		
		return inspectService.selectPhDiabetesByExampleAndPage(page, example);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#insertPhHypertension(com.bithealth.inspectCore.inspect.model.PhHypertension)
	 */
	public boolean insertPhHypertension(PhHypertension pojo) {
		
		return inspectService.insertPhHypertension(pojo) > 0;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#updatePhHypertension(com.bithealth.inspectCore.inspect.model.PhHypertension)
	 */
	public boolean updatePhHypertension(PhHypertension pojo) {
		
		return inspectService.updatePhHypertension(pojo) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#insertOrUpdateHypertension(com.bithealth.inspectCore.inspect.model.PhHypertension)
	 */
	public boolean insertOrUpdateHypertension(PhHypertension pojo) {
		DictEntity.setDicts(dictService.selectAllSecond_cache());
		if(pojo.getVisitClass() == null)
			pojo.setVisitClass((byte)0);
		if(pojo.getRefCompany() > 0){//如果是对接数据，根据对接公司主键查询数据，并赋值本地主键
			inspectService.selectPhHypertensionExistByRefDataPK(pojo);
		}else{
//			if(pojo.getVisitClass().equals((byte)0) && inspectService.hasPendingHypertension(pojo.getMemberID(), pojo.getHypertensionID()))//有待随访数据，禁止添加待随访数据
//				return false;
		}
		if(StringUtils.isEmpty(pojo.getRefDataPK()))
			pojo.setRefDataPK(UUID.randomUUID().toString());
		if(pojo.getHypertensionID() == null){
			if(inspectService.insertPhHypertension(pojo) > 0){
				sendHMessage(pojo);
				return true;
			}
		}else{
			if(inspectService.updatePhHypertension(pojo) > 0){
				sendHMessage(pojo);
				return true;
			}
		}
		return false;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#deletePhHypertension(java.lang.Long[])
	 */
	public boolean deletePhHypertension(Long... ids) {
		
		return inspectService.deletePhHypertension(ids) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#deleteSoftPhHypertension(java.lang.Long[])
	 */
	public boolean deleteSoftPhHypertension(Long... ids) {
		
		return inspectService.deleteSoftPhHypertension(ids) > 0;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhHypertensionById(java.lang.Long)
	 */
	public PhHypertension selectPhHypertensionById(Long id) {
		DictEntity.setDicts(dictService.selectAllSecond_cache());
		if(id == null)
			return null;
		return inspectService.selectPhHypertensionById(id);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhHypertensionByRefDataPK(java.lang.String)
	 */
	public PhHypertension selectPhHypertensionByRefDataPK(String refDataPK) {
		
		return inspectService.selectPhHypertensionByRefDataPK(refDataPK);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhHypertensionByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.inspect.model.PhHypertensionExample)
	 */
	public Page<PhHypertension> selectPhHypertensionByExampleAndPage(
			Page<PhHypertension> page, PhHypertensionExample example) {
		
		return inspectService.selectPhHypertensionByExampleAndPage(page, example);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#exProcGetDiabetesMemList(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.util.Map)
	 */
	public Page<MemberVo> exProcGetDiabetesMemList(
			Page<MemberVo> page, Map<String, Object> params) {
		
		return inspectService.exProcGetDiabetesMemList(page, params);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#exProcGetHypertensionMemList(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.util.Map)
	 */
	public Page<MemberVo> exProcGetHypertensionMemList(
			Page<MemberVo> page, Map<String, Object> params) {
		
		return inspectService.exProcGetHypertensionMemList(page, params);
	}
	
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhDiabetesByNum(java.lang.Integer)
	 */
	public List<PhDiabetes> selectPhDiabetesByNum(Integer num) {
		PhDiabetesExample example = new PhDiabetesExample();
		example.createCriteria().andRefCompanyNotEqualTo((byte)0);
		example.setPage(new Page<PhDiabetes>(1, num));
		return inspectService.selectPhDiabetesByExample(example);
	}
	
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhHypertensionByNum(java.lang.Integer)
	 */
	public List<PhHypertension> selectPhHypertensionByNum(Integer num) {
		PhHypertensionExample example = new PhHypertensionExample();
		example.createCriteria().andRefCompanyNotEqualTo((byte)0);
		example.setPage(new Page<PhHypertension>(1, num));
		return inspectService.selectPhHypertensionByExample(example);
	}
	
	/**
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhDiabetesTotal()
	 */
	public int selectPhDiabetesTotal() {
		PhDiabetesExample example = new PhDiabetesExample();
		example.createCriteria().andRefCompanyNotEqualTo((byte)0);
		return inspectService.selectPhDiabetesTotalByExample(example);
	}
	
	/** 
	 * 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhHypertensionTotal()
	 */
	public int selectPhHypertensionTotal() {
		PhHypertensionExample example = new PhHypertensionExample();
		example.createCriteria().andRefCompanyNotEqualTo((byte)0);
		return inspectService.selectPhHypertensionTotalByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectLatestPhDiabetesInfo(java.lang.Integer)
	 */
	public Map<String, Object> selectLatestPhDiabetesInfo(Integer memberId) {
		return getLastestInfo(memberId, true);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectLatestPhHypertensionInfo(java.lang.Integer)
	 */
	public Map<String, Object> selectLatestPhHypertensionInfo(Integer memberId) {
		return getLastestInfo(memberId, false);
	}
	
	/**
	 * 
	 * @Title:getLastestInfo 
	 * @Description:高血压、糖尿病最新相关数据  
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author baozj
	 * @param memberId
	 * @param isDiabetes
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */
	private Map<String, Object> getLastestInfo(Integer memberId, boolean isDiabetes){
		Map<String, Object> map = new HashMap<String, Object>();
		PhHealthexam phHealthexam = physicalService.selectLatestPhHealthexamByMemberId(memberId);
		PhDiabetes diabetes = inspectService.selectLatestPhDiabetesByMemberId(memberId);
		PhHypertension hypertension = inspectService.selectLatestPhHypertensionByMemberId(memberId);
		
		//身高、 体重、体质指数、日吸烟量、目标日吸烟量、日饮酒量、目标日饮酒量、运动、每次运动
		if(phHealthexam.getLatestTime().after(diabetes.getLatestTime()) && phHealthexam.getLatestTime().after(hypertension.getLatestTime())){
			PhHealthexamdetail hDetail = phHealthexam.getPhHealthexamdetail();
			if(hDetail != null){
				map.put("height", hDetail.getHeight());
				map.put("weight", hDetail.getWeight());
				map.put("bmi", hDetail.getBMI());
				map.put("dailySmoking", hDetail.getDailySmoking());
				map.put("dailyDrink", hDetail.getDailyDrink());
				map.put("sportFrequency", hDetail.getSportFrequency());
				map.put("sportDuration", hDetail.getSportDuration());
				if(hDetail.getLeftSystolic() != null || hDetail.getLeftDiastolic() != null){
					map.put("systolic", hDetail.getLeftSystolic());
					map.put("diastolic", hDetail.getLeftDiastolic());
				}else{
					map.put("systolic", hDetail.getRightSystolic());
					map.put("diastolic", hDetail.getRightDiastolic());
				}
				map.put("glu", hDetail.getGLU());//空腹血糖
				map.put("pglu", hDetail.getPGLU());//餐后血糖
				map.put("hba1c", hDetail.getHBA1C());//糖化血红蛋白
			}
			
			Inspectdetail idetail;
			if(diabetes.getLatestTime().after(hypertension.getLatestTime())){
				idetail = diabetes.getPhDiabetesdetail();
			}else{
				idetail = hypertension.getPhHypertensiondetail();
			}
			if(idetail != null){
				map.put("dailySmoking_Next", idetail.getDailySmoking_Next());
				map.put("dailyDrink_Next", idetail.getDailyDrink_Next());
				map.put("sportFrequency_Next", idetail.getSportFrequency_Next());
				map.put("sportDuration_Next", idetail.getSportDuration_Next());
			}
		}else{
			Inspectdetail idetail;
			if(diabetes.getLatestTime().after(hypertension.getLatestTime()))
				idetail = diabetes.getPhDiabetesdetail();
			else
				idetail = hypertension.getPhHypertensiondetail();
			if(idetail != null){
				map.put("height", idetail.getHeight());
				map.put("weight", idetail.getWeight());
				map.put("bmi", idetail.getBMI());
				map.put("dailySmoking", idetail.getDailySmoking());
				map.put("dailyDrink", idetail.getDailyDrink());
				map.put("sportFrequency", idetail.getSportFrequency());
				map.put("sportDuration", idetail.getSportDuration());
				map.put("dailySmoking_Next", idetail.getDailySmoking_Next());
				map.put("dailyDrink_Next", idetail.getDailyDrink_Next());
				map.put("sportFrequency_Next", idetail.getSportFrequency_Next());
				map.put("sportDuration_Next", idetail.getSportDuration_Next());
				map.put("systolic", idetail.getSystolic());
				map.put("diastolic", idetail.getDiastolic());
			}
		}
		//取最新血压信息
		Omds omds = bloodPressureService.selectLastMeasureRecordByBloodPress(memberId);
		if(omds != null && omds.getEventid() != null){
			
			Osbp osbp = bloodPressureService.selectBloodPressByEventId(omds.getEventid());
			if(osbp != null){
				if(osbp.getTesttime().after(phHealthexam.getLatestTime()) && osbp.getTesttime().after(diabetes.getLatestTime()) && osbp.getTesttime().after(hypertension.getLatestTime())){
					map.put("systolic", osbp.getSbp());
					map.put("diastolic", osbp.getDbp());
				}
			}
		}
		
		//用药情况
		if(isDiabetes){//糖尿病随访
			PhDiabetesdetail dDetail = diabetes.getPhDiabetesdetail();
			if(dDetail != null){
				map.put("glu", dDetail.getFPG());//空腹血糖
				map.put("pglu", dDetail.getPGLU());//餐后血糖
				map.put("hba1c", dDetail.getHBA1C());//糖化血红蛋白
			}
			if(phHealthexam.getLatestTime().after(diabetes.getLatestTime()))
				map.put("medicines", phHealthexam.getPhHealthexamdetailmedicines());
			else
				map.put("medicines", diabetes.getPhDiabetesdetailmedicines());
			//取最新血糖信息
			List<String> kongfu = new ArrayList<String>();
			kongfu.add("1");
			Obsr obsrKf = bloodSugarService.selectLastestObsrByMemidAndTimeperiods(memberId, kongfu);
			List<String> afterDinner = new ArrayList<String>();
			afterDinner.add("2");
			afterDinner.add("4");
			afterDinner.add("6");
			Obsr obsrAd = bloodSugarService.selectLastestObsrByMemidAndTimeperiods(memberId, afterDinner);
			if(obsrKf != null){
				if(obsrKf.getTesttime().after(phHealthexam.getLatestTime()) && obsrKf.getTesttime().after(diabetes.getLatestTime())){
					map.put("glu", obsrKf.getBsvalue());//空腹血糖
				}
			}
			if(obsrAd != null){
				if(obsrAd.getTesttime().after(phHealthexam.getLatestTime()) && obsrAd.getTesttime().after(diabetes.getLatestTime())){
					map.put("pglu", obsrAd.getBsvalue());//餐后血糖
				}
			}
		}else{//高血压随访
			if(phHealthexam.getLatestTime().after(hypertension.getLatestTime()))
				map.put("medicines", phHealthexam.getPhHealthexamdetailmedicines());
			else
				map.put("medicines", hypertension.getPhHypertensiondetailmedicines());
		}
		
		return map;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#batchSavePhDiabetes(java.util.List)
	 */
	public Map<String, List<PhDiabetes>> batchSavePhDiabetes(List<PhDiabetes> pojos) {
		Map<String, List<PhDiabetes>> map = new HashMap<String, List<PhDiabetes>>();
		List<PhDiabetes> success = new ArrayList<PhDiabetes>();
		map.put(Constants.PH_BATCH_SAVE_SUCCESS, success);
		for(Iterator<PhDiabetes> it = pojos.iterator(); it.hasNext();){
			PhDiabetes pojo = it.next();
			if(insertOrUpdateDiabetes(pojo)){
				success.add(pojo);
				it.remove();
			}
		}
		map.put(Constants.PH_BATCH_SAVE_ERROR, pojos);
		return map;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#batchSavePhHypertension(java.util.List)
	 */
	public Map<String, List<PhHypertension>> batchSavePhHypertension(
			List<PhHypertension> pojos) {
		Map<String, List<PhHypertension>> map = new HashMap<String, List<PhHypertension>>();
		List<PhHypertension> success = new ArrayList<PhHypertension>();
		map.put(Constants.PH_BATCH_SAVE_SUCCESS, success);
		for(Iterator<PhHypertension> it = pojos.iterator(); it.hasNext();){
			PhHypertension pojo = it.next();
			if(insertOrUpdateHypertension(pojo)){
				success.add(pojo);
				it.remove();
			}
		}
		map.put(Constants.PH_BATCH_SAVE_ERROR, pojos);
		return map;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhDiabetesList(java.util.Date, java.lang.Integer, java.lang.String)
	 */
	public List<PhDiabetes> selectPhDiabetesList(Date getTime, Integer source,
			String prgid) {
		PhDiabetes pojo = new PhDiabetes();
		pojo.setGetTime(getTime);
		pojo.createMember().setSource(source);
		pojo.createMemRelation().setPrgid(prgid);
		return inspectService.selectPhDiabetesList(pojo);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhHypertensionList(java.util.Date, java.lang.Integer, java.lang.String)
	 */
	public List<PhHypertension> selectPhHypertensionList(Date getTime,
			Integer source, String prgid) {
		PhHypertension pojo = new PhHypertension();
		pojo.setGetTime(getTime);
		pojo.createMember().setSource(source);
		pojo.createMemRelation().setPrgid(prgid);
		return inspectService.selectPhHypertensionList(pojo);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhDiabetesPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.inspect.model.PhDiabetes, java.lang.Integer)
	 */
	public Page<PhDiabetes> selectPhDiabetesPage(Page<PhDiabetes> page,
			PhDiabetes pojo, Integer docId) {
		DictEntity.setDicts(dictService.selectAllSecond_cache());
		List<Integer> odgpIds = null;
		if(pojo.getMemberID() == null){
			odgpIds = inspectDao.selectOdgpIdsByDocId(docId);
			if(odgpIds == null || odgpIds.isEmpty())
				return page;
		}
		return inspectService.selectPhDiabetesPage(page, pojo, odgpIds);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectPhHypertensionPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.inspect.model.PhHypertension, java.lang.Integer)
	 */
	public Page<PhHypertension> selectPhHypertensionPage(
			Page<PhHypertension> page, PhHypertension pojo, Integer docId) {
		DictEntity.setDicts(dictService.selectAllSecond_cache());
		List<Integer> odgpIds = null;
		if(pojo.getMemberID() == null){
			odgpIds = inspectDao.selectOdgpIdsByDocId(docId);
			if(odgpIds == null || odgpIds.isEmpty())
				return page;
		}
		return inspectService.selectPhHypertensionPage(page, pojo, odgpIds);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectInspectPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.lang.Integer)
	 */
	public Page<Inspect> selectInspectPage(Page<Inspect> page, Integer memberId) {
		
		inspectDao.selectInspectPage(page, memberId);
		for(Iterator<Inspect> it = page.getResult().iterator(); it.hasNext();){
			Inspect pojo = it.next();
			pojo.setData(JSON.parseArray(pojo.getJson(), Inspect.class));
			pojo.setJson(null);
		}
		DictEntity.setDicts(dictService.selectAllSecond_cache());
		return page;
	}
	
	/**
	 * 
	 * @Title:sendMessage 
	 * @Description:高血压随访消息发送 
	 * TODO  
	 * @author baozj
	 * @param pojo 
	 * @throws
	 * @retrun void
	 */
	private void sendHMessage(PhHypertension pojo){
		try {
			if(pojo.getRefCompany().equals((byte)0) && pojo.getVisitClass() > 0){//录入数据，并且有随访分类，发送消息
				DictEntity.setDicts(dictService.selectAllSecond_cache());
//				Doctor doctor = doctorService.selectById(pojo.getCreateDrID() == null ? pojo.getUpdateDrID() : pojo.getCreateDrID());
				Member member = memberService.selectById(pojo.getMemberID());
				MsgCenter mc = new MsgCenter(); 
				mc.setMsgtype(MessageTypeEnum.HYPERTENSION_EXAM.getType());
				mc.setSendtype(UserTypeEnum.MEMBER.getType());
				mc.setSender(member.getMemberGUID());
				mc.setLastsourceid(pojo.getHypertensionID());
				mc.setLastcontent(member.getMemname()+"(??)"+TimeUtil.formatDatetime(pojo.getVisitDate(), TimeUtil.DATE_CN_PATTERN) + "高血压随访结果："+pojo.getVisitClassStr());
				mc.setLastContentNotice(mc.getLastcontent());
				careIFService.sendMsgToCareMeMember(mc);
			}
		} catch (Exception e) {
			
			logger.error("高血压随访消息发送失败", e);
			
		}
	}
	
	/**
	 * 
	 * @Title:sendMessage 
	 * @Description:糖尿病随访消息发送 
	 * TODO  
	 * @author baozj
	 * @param pojo 
	 * @throws
	 * @retrun void
	 */
	private void sendDMessage(PhDiabetes pojo){
		try {
			if(pojo.getRefCompany().equals((byte)0) && pojo.getVisitClass() > 0){//录入数据，并且有随访分类，发送消息
				DictEntity.setDicts(dictService.selectAllSecond_cache());
//				Doctor doctor = doctorService.selectById(pojo.getCreateDrID() == null ? pojo.getUpdateDrID() : pojo.getCreateDrID());
				Member member = memberService.selectById(pojo.getMemberID());
				MsgCenter mc = new MsgCenter(); 
				mc.setMsgtype(MessageTypeEnum.DIABETES_EXAM.getType());
				mc.setSendtype(UserTypeEnum.MEMBER.getType());
				mc.setSender(member.getMemberGUID());
				mc.setLastsourceid(pojo.getDiabetesID());
				mc.setLastcontent(member.getMemname()+"(??)"+TimeUtil.formatDatetime(pojo.getVisitDate(), TimeUtil.DATE_CN_PATTERN) + "糖尿病随访结果："+pojo.getVisitClassStr());
				mc.setLastContentNotice(mc.getLastcontent());
				careIFService.sendMsgToCareMeMember(mc);
			}
		} catch (Exception e) {
			
			logger.error("糖尿病随访消息发送失败", e);
			
		}
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectDiabetesByMSETaskID(java.lang.Long)
	 */
	@Override
	public PhDiabetes selectDiabetesByMSETaskID(Long MSETaskID) {
		DictEntity.setDicts(dictService.selectAllSecond_cache());
		PhDiabetesExample example = new PhDiabetesExample();
		example.createCriteria().andMSETaskIDEqualTo(MSETaskID);
		List<PhDiabetes> list = phDiabetesService.selectByExample(example);
		PhDiabetes pojo = list != null && list.size() > 0 ? list.get(0) : null;
		if(pojo != null){
			pojo.setPhDiabetesdetail(phDiabetesdetailService.selectById(pojo.getDiabetesID()));
			pojo.setPhDiabetesdetailmedicines(phDiabetesdetailmedicineService.selectByMasterId(pojo.getDiabetesID()));
		}
		return pojo;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.InspectFacedeService#selectHypertensionByMSETaskID(java.lang.Long)
	 */
	@Override
	public PhHypertension selectHypertensionByMSETaskID(Long MSETaskID) {
		DictEntity.setDicts(dictService.selectAllSecond_cache());
		PhHypertensionExample example = new PhHypertensionExample();
		example.createCriteria().andMSETaskIDEqualTo(MSETaskID);
		List<PhHypertension> list = phHypertensionService.selectByExample(example);
		PhHypertension pojo = list != null && list.size() > 0 ? list.get(0) : null;
		if(pojo != null){
			pojo.setPhHypertensiondetail(phHypertensiondetailService.selectById(pojo.getHypertensionID()));
			pojo.setPhHypertensiondetailmedicines(phHypertensiondetailmedicineService.selectByMasterId(pojo.getHypertensionID()));
		}
		return pojo;
	}
	
}

