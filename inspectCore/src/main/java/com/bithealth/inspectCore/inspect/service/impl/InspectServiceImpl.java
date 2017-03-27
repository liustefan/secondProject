 
/**
 * @PackageName:      com.bithealth.inspectCore.service.impl
 * @FileName:     InspectServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午11:28:34  
 * 
 */

package com.bithealth.inspectCore.inspect.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.inspectCore.dao.InspectDao;
import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesExample;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensionExample;
import com.bithealth.inspectCore.inspect.service.InspectService;
import com.bithealth.inspectCore.inspect.service.PhDiabetesService;
import com.bithealth.inspectCore.inspect.service.PhDiabetesdetailService;
import com.bithealth.inspectCore.inspect.service.PhDiabetesdetailmedicineService;
import com.bithealth.inspectCore.inspect.service.PhHypertensionService;
import com.bithealth.inspectCore.inspect.service.PhHypertensiondetailService;
import com.bithealth.inspectCore.inspect.service.PhHypertensiondetailmedicineService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: InspectServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午11:28:34 
 * 
 * @author baozj
 * @version  
 */
@Service
public class InspectServiceImpl implements InspectService {
	
	protected static Logger logger = Logger.getLogger(InspectServiceImpl.class);
	
	@Autowired
	private PhDiabetesService phDiabetesService;
	@Autowired
	private PhDiabetesdetailService phDiabetesdetailService;
	@Autowired
	private PhDiabetesdetailmedicineService phDiabetesdetailmedicineService;
	@Autowired
	private PhHypertensionService phHypertensionService;
	@Autowired
	private PhHypertensiondetailService phHypertensiondetailService;
	@Autowired
	private PhHypertensiondetailmedicineService phHypertensiondetailmedicineService;
	@Autowired
	InspectDao dao;
	@Autowired
	private MemberService memberService;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#insertPhDiabetes(com.bithealth.inspectCore.inspect.model.PhDiabetes)
	 */
	public int insertPhDiabetes(PhDiabetes pojo) {
		int n = 0;
		if(pojo != null){
			pojo.setIsDeleted((byte)0);
			pojo.setCreateTime(TimeUtil.now());
			n += phDiabetesService.insert(pojo);
			n += phDiabetesdetailService.insert(pojo.getPhDiabetesdetail(), pojo.getDiabetesID());
			n += phDiabetesdetailmedicineService.inserts(pojo.getPhDiabetesdetailmedicines(), pojo.getDiabetesID());
//			if(pojo.getRefCompany().equals((byte)0) && !pojo.getVisitClass().equals((byte)0) && pojo.getPhDiabetesdetail() != null && pojo.getPhDiabetesdetail().getVisitDate_Next() != null 
//					&& phDiabetesService.selectStayPhDiabetesByMemberId(pojo.getMemberID()).size() == 0){//录入数据、此次随访分类不等0、有下次随访时间、当前会员没有待随访记录 才会生成一条待随访记录
//				pojo.setVisitClass((byte)0);
//				pojo.setVisitDate(pojo.getPhDiabetesdetail().getVisitDate_Next());
//				pojo.setRefDataPK(UUID.randomUUID().toString().replaceAll("-", ""));
//				n += phDiabetesService.insert(pojo);
//			}
		}
		return n;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#updatePhDiabetes(com.bithealth.inspectCore.inspect.model.PhDiabetes)
	 */
	public int updatePhDiabetes(PhDiabetes pojo) {
		int n = 0;
		if(pojo != null && pojo.getDiabetesID() != null){
			pojo.setUpdateTime(TimeUtil.now());
			n += phDiabetesService.updateByPrimaryKey(pojo);
			n += phDiabetesdetailService.updateByMasterId(pojo.getPhDiabetesdetail(), pojo.getDiabetesID());
			n += phDiabetesdetailmedicineService.updateByMasterId(pojo.getPhDiabetesdetailmedicines(), pojo.getDiabetesID());
//			if(pojo.getRefCompany().equals((byte)0) && !pojo.getVisitClass().equals((byte)0) && pojo.getPhDiabetesdetail() != null && pojo.getPhDiabetesdetail().getVisitDate_Next() != null 
//					&& phDiabetesService.selectStayPhDiabetesByMemberId(pojo.getMemberID()).size() == 0){//录入数据、此次随访分类不等0、有下次随访时间、当前会员没有待随访记录 才会生成一条待随访记录
//				pojo.setVisitClass((byte)0);
//				pojo.setVisitDate(pojo.getPhDiabetesdetail().getVisitDate_Next());
//				pojo.setRefDataPK(UUID.randomUUID().toString().replaceAll("-", ""));
//				pojo.setIsDeleted((byte)0);
//				pojo.setCreateTime(new Date());
//				pojo.setUpdateTime(null);
//				n += phDiabetesService.insert(pojo);
//			}
		}
		return n;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#deletePhDiabetes(java.lang.Long[])
	 */
	public int deletePhDiabetes(Long... ids) {
		int n = 0;
		if(ids != null && ids.length > 0){
			List<Long> values = Arrays.asList(ids);
			n += phDiabetesService.deleteByMasterId(values);
			n += phDiabetesdetailService.deleteByMasterId(values);
			n += phDiabetesdetailmedicineService.deleteByMasterId(values);
		}
		return n;
	}
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#deleteSoftPhDiabetes(java.lang.Long[])
	 */
	public int deleteSoftPhDiabetes(Long... ids) {
		
		if(ids != null && ids.length > 0){
			PhDiabetes model = new PhDiabetes();
			model.setIsDeleted((byte)1);
			PhDiabetesExample example = new PhDiabetesExample();
			example.createCriteria().andDiabetesIDIn(Arrays.asList(ids));
			return phDiabetesService.updateByExampleSelective(model, example);
		}
		return 0;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhDiabetesById(java.lang.Long)
	 */
	public PhDiabetes selectPhDiabetesById(Long id) {
		
		PhDiabetes pojo = phDiabetesService.selectById(id);
		if(pojo != null){
			pojo.setPhDiabetesdetail(phDiabetesdetailService.selectById(id));
			pojo.setPhDiabetesdetailmedicines(phDiabetesdetailmedicineService.selectByMasterId(id));
		}
		return pojo;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhDiabetesByRefDataPK(java.lang.String)
	 */
	public PhDiabetes selectPhDiabetesByRefDataPK(String refDataPK) {
		
		List<PhDiabetes> pojos = selectPhDiabetesBaseInfoByRefDataPK(refDataPK);
		if(pojos != null && pojos.size() > 0){
			PhDiabetes pojo = pojos.get(0);
			pojo.setPhDiabetesdetail(phDiabetesdetailService.selectById(pojo.getDiabetesID()));
			pojo.setPhDiabetesdetailmedicines(phDiabetesdetailmedicineService.selectByMasterId(pojo.getDiabetesID()));
			pojo.setMember(memberService.selectById(pojo.getMemberID()));			
			return pojo;
		}
		return null;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhDiabetesByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.inspect.model.PhDiabetesExample)
	 */
	public Page<PhDiabetes> selectPhDiabetesByExampleAndPage(
			Page<PhDiabetes> page, PhDiabetesExample example) {
		
		phDiabetesService.selectByExampleAndPage(page, example);
		return page;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#insertPhHypertension(com.bithealth.inspectCore.inspect.model.PhHypertension)
	 */
	public int insertPhHypertension(PhHypertension pojo) {
		
		int n = 0;
		if(pojo != null){
			pojo.setIsDeleted((byte)0);
			pojo.setCreateTime(TimeUtil.now());
			n += phHypertensionService.insert(pojo);
			n += phHypertensiondetailService.insert(pojo.getPhHypertensiondetail(), pojo.getHypertensionID());
			n += phHypertensiondetailmedicineService.inserts(pojo.getPhHypertensiondetailmedicines(), pojo.getHypertensionID());
//			if(pojo.getRefCompany().equals((byte)0) && !pojo.getVisitClass().equals((byte)0) && pojo.getPhHypertensiondetail() != null && pojo.getPhHypertensiondetail().getVisitDate_Next() != null 
//					&& phHypertensionService.selectStayPhDiabetesByMemberId(pojo.getMemberID()).size() == 0){//录入数据、此次随访分类不等0、有下次随访时间、当前会员没有待随访记录 才会生成一条待随访记录
//				pojo.setVisitClass((byte)0);
//				pojo.setVisitDate(pojo.getPhHypertensiondetail().getVisitDate_Next());
//				pojo.setRefDataPK(UUID.randomUUID().toString().replaceAll("-", ""));
//				n += phHypertensionService.insert(pojo);
//			}
		}
		return n;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#updatePhHypertension(com.bithealth.inspectCore.inspect.model.PhHypertension)
	 */
	public int updatePhHypertension(PhHypertension pojo) {
		
		int n = 0;
		if(pojo != null && pojo.getHypertensionID() != null){
			pojo.setUpdateTime(TimeUtil.now());
			n += phHypertensionService.updateByPrimaryKey(pojo);
			n += phHypertensiondetailService.updateByMasterId(pojo.getPhHypertensiondetail(), pojo.getHypertensionID());
			n += phHypertensiondetailmedicineService.updateByMasterId(pojo.getPhHypertensiondetailmedicines(), pojo.getHypertensionID());
//			if(pojo.getRefCompany().equals((byte)0) && !pojo.getVisitClass().equals((byte)0) && pojo.getPhHypertensiondetail() != null && pojo.getPhHypertensiondetail().getVisitDate_Next() != null 
//					&& phHypertensionService.selectStayPhDiabetesByMemberId(pojo.getMemberID()).size() == 0){//录入数据、此次随访分类不等0、有下次随访时间、当前会员没有待随访记录 才会生成一条待随访记录
//				pojo.setVisitClass((byte)0);
//				pojo.setVisitDate(pojo.getPhHypertensiondetail().getVisitDate_Next());
//				pojo.setRefDataPK(UUID.randomUUID().toString().replaceAll("-", ""));
//				pojo.setIsDeleted((byte)0);
//				pojo.setCreateTime(new Date());
//				pojo.setUpdateTime(null);
//				n += phHypertensionService.insert(pojo);
//			}
		}
		return n;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#deletePhHypertension(java.lang.Long[])
	 */
	public int deletePhHypertension(Long... ids) {
		
		int n = 0;
		if(ids != null && ids.length > 0){
			List<Long> values = Arrays.asList(ids);
			n += phHypertensionService.deleteByMasterId(values);
			n += phHypertensiondetailService.deleteByMasterId(values);
			n += phHypertensiondetailmedicineService.deleteByMasterId(values);
		}
		return n;
	}
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#deleteSoftPhHypertension(java.lang.Long[])
	 */
	public int deleteSoftPhHypertension(Long... ids) {
		
		if(ids != null && ids.length > 0){
			PhHypertension model = new PhHypertension();
			model.setIsDeleted((byte)1);
			PhHypertensionExample example = new PhHypertensionExample();
			example.createCriteria().andHypertensionIDIn(Arrays.asList(ids));
			return phHypertensionService.updateByExampleSelective(model, example);
		}
		return 0;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhHypertensionById(java.lang.Long)
	 */
	public PhHypertension selectPhHypertensionById(Long id) {
		
		PhHypertension pojo = phHypertensionService.selectById(id);
		if(pojo != null){
			pojo.setPhHypertensiondetail(phHypertensiondetailService.selectById(id));
			pojo.setPhHypertensiondetailmedicines(phHypertensiondetailmedicineService.selectByMasterId(id));
		}
		return pojo;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhHypertensionByRefDataPK(java.lang.String)
	 */
	public PhHypertension selectPhHypertensionByRefDataPK(String refDataPK) {
		
		List<PhHypertension> pojos = selectPhHypertensionBaseInfoByRefDataPK(refDataPK);
		if(pojos != null && pojos.size() > 0){
			PhHypertension pojo = pojos.get(0);
			pojo.setPhHypertensiondetail(phHypertensiondetailService.selectById(pojo.getHypertensionID()));
			pojo.setPhHypertensiondetailmedicines(phHypertensiondetailmedicineService.selectByMasterId(pojo.getHypertensionID()));
			pojo.setMember(memberService.selectById(pojo.getMemberID()));
			return pojo;
		}
		return null;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhHypertensionByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.inspect.model.PhHypertensionExample)
	 */
	public Page<PhHypertension> selectPhHypertensionByExampleAndPage(
			Page<PhHypertension> page, PhHypertensionExample example) {
		
		phHypertensionService.selectByExampleAndPage(page, example);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#exProcGetDiabetesMemList(java.util.Map)
	 */
	public Page<MemberVo> exProcGetDiabetesMemList(Page<MemberVo> page, Map<String, Object> params) {
		if(params == null)
			params = new HashMap<String, Object>();
		params.put("iCurrentPageIndex", page.getPageNo() - 1);
		params.put("iPageSize", page.getPageSize());
		page.setResult(dao.exProcGetDiabetesMemList(params));
		page.setTotalCount(Integer.parseInt(String.valueOf(params.get("iCount"))));
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#exProcGetHypertensionMemList(java.util.Map)
	 */
	public Page<MemberVo> exProcGetHypertensionMemList(Page<MemberVo> page, Map<String, Object> params) {
		if(params == null)
			params = new HashMap<String, Object>();
		params.put("iCurrentPageIndex", page.getPageNo() - 1);
		params.put("iPageSize", page.getPageSize());
		page.setResult(dao.exProcGetHypertensionMemList(params));
		page.setTotalCount(Integer.parseInt(String.valueOf(params.get("iCount"))));
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhHypertensionByExample(com.bithealth.inspectCore.inspect.model.PhDiabetesExample)
	 */
	public List<PhDiabetes> selectPhDiabetesByExample(PhDiabetesExample example) {
		
		return phDiabetesService.selectByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhHypertensionTotalByCountExample(com.bithealth.inspectCore.inspect.model.PhHypertensionExample)
	 */
	public List<PhHypertension> selectPhHypertensionByExample(
			PhHypertensionExample example) {
		
		return phHypertensionService.selectByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhDiabetesTotalByExample(com.bithealth.inspectCore.inspect.model.PhDiabetesExample)
	 */
	public int selectPhDiabetesTotalByExample(PhDiabetesExample example) {
		
		return phDiabetesService.countByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhHypertensionTotalByExample(com.bithealth.inspectCore.inspect.model.PhHypertensionExample)
	 */
	public int selectPhHypertensionTotalByExample(PhHypertensionExample example) {
		
		return phHypertensionService.countByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectLatestPhDiabetesByMemberId(java.lang.Integer)
	 */
	public PhDiabetes selectLatestPhDiabetesByMemberId(Integer memberId) {
		
		PhDiabetes model = phDiabetesService.selectLatestPhDiabetesByMemberId(memberId);
		if(model != null){
			model.setPhDiabetesdetail(phDiabetesdetailService.selectById(model.getDiabetesID()));
			model.setPhDiabetesdetailmedicines(phDiabetesdetailmedicineService.selectByMasterId(model.getDiabetesID()));
		}else{
			model = new PhDiabetes();
			model.setLatestTime(new Date(0L));
		}
		return model;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectLatestPhHypertensionByMemberId(java.lang.Integer)
	 */
	public PhHypertension selectLatestPhHypertensionByMemberId(Integer memberId) {
		
		PhHypertension model = phHypertensionService.selectLatestPhHypertensionByMemberId(memberId);
		if(model != null){
			model.setPhHypertensiondetail(phHypertensiondetailService.selectById(model.getHypertensionID()));
			model.setPhHypertensiondetailmedicines(phHypertensiondetailmedicineService.selectByMasterId(model.getHypertensionID()));
		}else{
			model = new PhHypertension();
			model.setLatestTime(new Date(0L));
		}
		return model;
	}
	
	private List<PhDiabetes> selectPhDiabetesBaseInfoByRefDataPK(String refDataPK) {
		PhDiabetesExample example = new PhDiabetesExample();
		example.createCriteria().andRefDataPKEqualTo(refDataPK);
		List<PhDiabetes> pojos = phDiabetesService.selectByExample(example);
		return pojos;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhDiabetesExistByRefDataPK(com.bithealth.inspectCore.inspect.model.PhDiabetes)
	 */
	public boolean selectPhDiabetesExistByRefDataPK(PhDiabetes pojo) {
		List<PhDiabetes> pojos = selectPhDiabetesBaseInfoByRefDataPK(pojo.getRefDataPK());
		if(pojos != null && pojos.size() > 0){
			pojo.setDiabetesID(pojos.get(0).getDiabetesID());
			if(phDiabetesdetailService.selectById(pojo.getDiabetesID()) != null && pojo.getPhDiabetesdetail() != null)
				pojo.getPhDiabetesdetail().setDiabetesID(pojo.getDiabetesID());
			return true;
		}
		return false;
	}
	
	private List<PhHypertension> selectPhHypertensionBaseInfoByRefDataPK(String refDataPK) {
		PhHypertensionExample example = new PhHypertensionExample();
		example.createCriteria().andRefDataPKEqualTo(refDataPK);
		List<PhHypertension> pojos = phHypertensionService.selectByExample(example);
		return pojos;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhHypertensionExistByRefDataPK(com.bithealth.inspectCore.inspect.model.PhHypertension)
	 */
	public boolean selectPhHypertensionExistByRefDataPK(PhHypertension pojo) {
		List<PhHypertension> pojos = selectPhHypertensionBaseInfoByRefDataPK(pojo.getRefDataPK());
		if(pojos != null && pojos.size() > 0){
			pojo.setHypertensionID(pojos.get(0).getHypertensionID());
			if(phHypertensiondetailService.selectById(pojo.getHypertensionID()) != null && pojo.getPhHypertensiondetail() != null)
				pojo.getPhHypertensiondetail().setHypertensionID(pojo.getHypertensionID());
			return true;
		}
		return false;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhDiabetesList(com.bithealth.inspectCore.inspect.model.PhDiabetes)
	 */
	public List<PhDiabetes> selectPhDiabetesList(PhDiabetes pojo) {
		
		return phDiabetesService.selectPhDiabetesList(pojo);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhHypertensionList(com.bithealth.inspectCore.inspect.model.PhHypertension)
	 */
	public List<PhHypertension> selectPhHypertensionList(PhHypertension pojo) {
		
		return phHypertensionService.selectPhHypertensionList(pojo);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhDiabetesPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.inspect.model.PhDiabetes, java.util.List)
	 */
	public Page<PhDiabetes> selectPhDiabetesPage(Page<PhDiabetes> page,
			PhDiabetes pojo, List<Integer> odgpIds) {
		
		return phDiabetesService.selectPage(page, pojo, odgpIds);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#selectPhHypertensionPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.inspect.model.PhHypertension, java.util.List)
	 */
	public Page<PhHypertension> selectPhHypertensionPage(
			Page<PhHypertension> page, PhHypertension pojo,
			List<Integer> odgpIds) {
		
		return phHypertensionService.selectPage(page, pojo, odgpIds);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#hasPendingDiabetes(java.lang.Integer, java.lang.Long)
	 */
	@Override
	public boolean hasPendingDiabetes(Integer memberId, Long id) {
		PhDiabetesExample example = new PhDiabetesExample();
		example.createCriteria().andMemberIDEqualTo(memberId)
		.andVisitClassEqualTo((byte)0)
		.andDiabetesIDNotEqualTo(id);
		return phDiabetesService.selectByExample(example).size() > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.InspectService#hasPendingHypertension(java.lang.Integer, java.lang.Long)
	 */
	@Override
	public boolean hasPendingHypertension(Integer memberId, Long id) {
		PhHypertensionExample example = new PhHypertensionExample();
		example.createCriteria().andMemberIDEqualTo(memberId)
		.andVisitClassEqualTo((byte)0)
		.andHypertensionIDNotEqualTo(id);
		return phHypertensionService.selectByExample(example).size() > 0;
	}
}

