 
/**
 * @PackageName:      com.bithealth.inspectCore.service
 * @FileName:     PhysicalServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午11:20:48  
 * 
 */

package com.bithealth.inspectCore.physical.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamExample;
import com.bithealth.inspectCore.physical.model.PhHealthexamExample.Criteria;
import com.bithealth.inspectCore.physical.service.PhHealthexamService;
import com.bithealth.inspectCore.physical.service.PhHealthexamdetailService;
import com.bithealth.inspectCore.physical.service.PhHealthexamdetailfamilybedService;
import com.bithealth.inspectCore.physical.service.PhHealthexamdetailinpatientService;
import com.bithealth.inspectCore.physical.service.PhHealthexamdetailmedicineService;
import com.bithealth.inspectCore.physical.service.PhHealthexamdetailnonimmuneService;
import com.bithealth.inspectCore.physical.service.PhysicalService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: PhysicalServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午11:20:48 
 * 
 * @author baozj
 * @version  
 */
@Service
public class PhysicalServiceImpl implements PhysicalService {
	
	protected static Logger logger = Logger.getLogger(PhysicalServiceImpl.class);
	
	@Autowired
	private PhHealthexamService phHealthexamService;
	@Autowired
	private PhHealthexamdetailService phHealthexamdetailService;
	@Autowired
	private PhHealthexamdetailfamilybedService phHealthexamdetailfamilybedService;
	@Autowired
	private PhHealthexamdetailinpatientService phHealthexamdetailinpatientService;
	@Autowired
	private PhHealthexamdetailmedicineService phHealthexamdetailmedicineService;
	@Autowired
	private PhHealthexamdetailnonimmuneService phHealthexamdetailnonimmuneService;
	@Autowired
	private MemberService memberService;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhysicalService#insertPhHealthexam(com.bithealth.inspectCore.physical.model.PhHealthexam)
	 */
	public int insertPhHealthexam(PhHealthexam pojo) {
		int n = 0;
		if(pojo != null){
			pojo.setCreateTime(TimeUtil.now());
			n += phHealthexamService.insert(pojo);
			n += phHealthexamdetailService.insert(pojo.getPhHealthexamdetail(), pojo.getHExamID());
			n += phHealthexamdetailfamilybedService.inserts(pojo.getPhHealthexamdetailfamilybeds(), pojo.getHExamID());
			n += phHealthexamdetailinpatientService.inserts(pojo.getPhHealthexamdetailinpatients(), pojo.getHExamID());
			n += phHealthexamdetailmedicineService.inserts(pojo.getPhHealthexamdetailmedicines(), pojo.getHExamID());
			n += phHealthexamdetailnonimmuneService.inserts(pojo.getPhHealthexamdetailnonimmunes(), pojo.getHExamID());
		}
		return n;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhysicalService#updatePhHealthexam(com.bithealth.inspectCore.physical.model.PhHealthexam)
	 */
	public int updatePhHealthexam(PhHealthexam pojo) {
		int n = 0;
		if(pojo != null && pojo.getHExamID() != null){
			pojo.setUpdateTime(TimeUtil.now());
			n += phHealthexamService.updateByPrimaryKey(pojo);
			n += phHealthexamdetailService.updateByMasterId(pojo.getPhHealthexamdetail(), pojo.getHExamID());
			n += phHealthexamdetailfamilybedService.updateByMasterId(pojo.getPhHealthexamdetailfamilybeds(), pojo.getHExamID());
			n += phHealthexamdetailinpatientService.updateByMasterId(pojo.getPhHealthexamdetailinpatients(), pojo.getHExamID());
			n += phHealthexamdetailmedicineService.updateByMasterId(pojo.getPhHealthexamdetailmedicines(), pojo.getHExamID());
			n += phHealthexamdetailnonimmuneService.updateByMasterId(pojo.getPhHealthexamdetailnonimmunes(), pojo.getHExamID());
		}
		return n;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 删除健康体检数据
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhysicalService#deletePhHealthexam(java.lang.Long[])
	 */
	public int deletePhHealthexam(Long... ids) {
		int n = 0;
		if(ids != null && ids.length > 0){
			List<Long> values = Arrays.asList(ids);
			n += phHealthexamService.deleteByMasterId(values);
			n += phHealthexamdetailService.deleteByMasterId(values);
			n += phHealthexamdetailfamilybedService.deleteByMasterId(values);
			n += phHealthexamdetailinpatientService.deleteByMasterId(values);
			n += phHealthexamdetailmedicineService.deleteByMasterId(values);
			n += phHealthexamdetailnonimmuneService.deleteByMasterId(values);
		}
		return n;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhysicalService#deleteSoftPhHealthexam(java.lang.Long[])
	 */
	public int deleteSoftPhHealthexam(Long... ids) {
		if(ids != null && ids.length > 0){
			PhHealthexam model = new PhHealthexam();
			model.setIsDeleted((byte)1);
			PhHealthexamExample example = new PhHealthexamExample();
			example.createCriteria().andHExamIDIn(Arrays.asList(ids));
			return phHealthexamService.updateByExampleSelective(model, example);
		}
		return 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhysicalService#selectPhHealthexamById(java.lang.Long)
	 */
	public PhHealthexam selectPhHealthexamById(Long id) {
		PhHealthexam pojo = phHealthexamService.selectById(id);
		if(pojo != null){
			pojo.setPhHealthexamdetail(phHealthexamdetailService.selectById(id));
			pojo.setPhHealthexamdetailfamilybeds(phHealthexamdetailfamilybedService.selectByMasterId(id));
			pojo.setPhHealthexamdetailinpatients(phHealthexamdetailinpatientService.selectByMasterId(id));
			pojo.setPhHealthexamdetailmedicines(phHealthexamdetailmedicineService.selectByMasterId(id));
			pojo.setPhHealthexamdetailnonimmunes(phHealthexamdetailnonimmuneService.selectByMasterId(id));
		}
		return pojo;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhysicalService#selectPhHealthexamByRefDataPK(java.lang.String)
	 */
	public PhHealthexam selectPhHealthexamByRefDataPK(String refDataPK) {
		
		List<PhHealthexam> pojos = selectPhHealthexamBaseInfoByParam(null, null, refDataPK);
		if(pojos != null && pojos.size() > 0){
			PhHealthexam pojo = pojos.get(0);
			pojo.setPhHealthexamdetail(phHealthexamdetailService.selectById(pojo.getHExamID()));
			pojo.setPhHealthexamdetailfamilybeds(phHealthexamdetailfamilybedService.selectByMasterId(pojo.getHExamID()));
			pojo.setPhHealthexamdetailinpatients(phHealthexamdetailinpatientService.selectByMasterId(pojo.getHExamID()));
			pojo.setPhHealthexamdetailmedicines(phHealthexamdetailmedicineService.selectByMasterId(pojo.getHExamID()));
			pojo.setPhHealthexamdetailnonimmunes(phHealthexamdetailnonimmuneService.selectByMasterId(pojo.getHExamID()));
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
	 *  @see com.bithealth.inspectCore.physical.service.PhysicalService#selectPhHealthexamByParam(java.lang.Byte, java.lang.String, java.lang.String)
	 */
	public PhHealthexam selectPhHealthexamByParam(Byte refCompany,
			String unique_ID, String refDataPK) {
		
		List<PhHealthexam> pojos = selectPhHealthexamBaseInfoByParam(refCompany, unique_ID, refDataPK);
		if(pojos != null && pojos.size() > 0){
			PhHealthexam pojo = pojos.get(0);
			pojo.setPhHealthexamdetail(phHealthexamdetailService.selectById(pojo.getHExamID()));
			pojo.setPhHealthexamdetailfamilybeds(phHealthexamdetailfamilybedService.selectByMasterId(pojo.getHExamID()));
			pojo.setPhHealthexamdetailinpatients(phHealthexamdetailinpatientService.selectByMasterId(pojo.getHExamID()));
			pojo.setPhHealthexamdetailmedicines(phHealthexamdetailmedicineService.selectByMasterId(pojo.getHExamID()));
			pojo.setPhHealthexamdetailnonimmunes(phHealthexamdetailnonimmuneService.selectByMasterId(pojo.getHExamID()));
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
	 *  @see com.bithealth.inspectCore.physical.service.PhysicalService#selectPhHealthexamByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.physical.model.PhHealthexamExample)
	 */
	public Page<PhHealthexam> selectPhHealthexamByExampleAndPage(Page<PhHealthexam> page,
			PhHealthexamExample example) {
		phHealthexamService.selectByExampleAndPage(page, example);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhysicalService#selectLatestPhHealthexamByMemberId(java.lang.Integer)
	 */
	public PhHealthexam selectLatestPhHealthexamByMemberId(Integer memberId) {
		
		PhHealthexam model =  phHealthexamService.selectLatestPhHealthexamByMemberId(memberId);
		if(model != null){
			model.setPhHealthexamdetail(phHealthexamdetailService.selectById(model.getHExamID()));
			model.setPhHealthexamdetailmedicines(phHealthexamdetailmedicineService.selectByMasterId(model.getHExamID()));
		}else{
			model = new PhHealthexam();
			model.setLatestTime(new Date(0L));
		}
		return model;
	}
	
	private List<PhHealthexam> selectPhHealthexamBaseInfoByParam(Byte refCompany,
			String unique_ID, String refDataPK) {
		PhHealthexamExample example = new PhHealthexamExample();
		Criteria c = example.createCriteria();
		c.andRefDataPKEqualTo(refDataPK);
		if(refCompany != null)
			c.andRefCompanyEqualTo(refCompany);
		if(unique_ID != null)
			c.andUnique_IDEqualTo(unique_ID);
		List<PhHealthexam> pojos = phHealthexamService.selectByExample(example);
		return pojos;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhysicalService#selectPhHealthexamExistByRefDataPK(com.bithealth.inspectCore.physical.model.PhHealthexam)
	 */
	public boolean selectPhHealthexamExistByRefDataPK(PhHealthexam pojo) {
		
		List<PhHealthexam> pojos = selectPhHealthexamBaseInfoByParam(null, null, pojo.getRefDataPK());
		if(pojos != null && pojos.size() > 0){
			pojo.setHExamID(pojos.get(0).getHExamID());
			if(phHealthexamdetailService.selectById(pojo.getHExamID()) != null && pojo.getPhHealthexamdetail() != null)
				pojo.getPhHealthexamdetail().setHExamID(pojo.getHExamID());
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
	 *  @see com.bithealth.inspectCore.physical.service.PhysicalService#selectPhHealthexamList(com.bithealth.inspectCore.physical.model.PhHealthexam)
	 */
	public List<PhHealthexam> selectPhHealthexamList(PhHealthexam pojo) {
		
		return phHealthexamService.selectPhHealthexamList(pojo);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhysicalService#selectPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.physical.model.PhHealthexam, java.util.List)
	 */
	public Page<PhHealthexam> selectPage(Page<PhHealthexam> page,
			PhHealthexam model, List<Integer> odgpIds) {
		
		phHealthexamService.selectPage(page, model, odgpIds);
		return page;
	}
}

