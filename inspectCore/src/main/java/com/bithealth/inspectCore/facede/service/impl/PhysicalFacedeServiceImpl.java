 
/**
 * @PackageName:      com.bithealth.inspectCore.facede.impl
 * @FileName:     PhysicalFacedeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月1日 上午9:44:43  
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

import com.bithealth.careCore.facade.model.MsgCenter;
import com.bithealth.careCore.facade.service.CareIFService;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.inspectCore.Constants;
import com.bithealth.inspectCore.dao.InspectDao;
import com.bithealth.inspectCore.dict.service.DictService;
import com.bithealth.inspectCore.facede.service.PhysicalFacedeService;
import com.bithealth.inspectCore.model.DictEntity;
import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamExample;
import com.bithealth.inspectCore.physical.service.PhysicalService;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.msgCenterCore.constants.UserTypeEnum;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: PhysicalFacedeServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月1日 上午9:44:43 
 * 
 * @author baozj
 * @version  
 */
@Service
public class PhysicalFacedeServiceImpl implements PhysicalFacedeService {

	protected static Logger logger = Logger.getLogger(PhysicalFacedeServiceImpl.class);
	
	@Autowired
	private PhysicalService physicalService;
	@Autowired
	private InspectDao inspectDao;
	@Autowired
	private DictService dictService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private CareIFService careIFService;
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.PhysicalFacedeService#insertPhHealthexam(com.bithealth.inspectCore.physical.model.PhHealthexam)
	 */
	public boolean insertPhHealthexam(PhHealthexam pojo) {
		
		return physicalService.insertPhHealthexam(pojo) > 0;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.PhysicalFacedeService#updatePhHealthexam(com.bithealth.inspectCore.physical.model.PhHealthexam)
	 */
	public boolean updatePhHealthexam(PhHealthexam pojo) {
		
		return physicalService.updatePhHealthexam(pojo) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.PhysicalFacedeService#insertOrUpdatePhHealthexam(com.bithealth.inspectCore.physical.model.PhHealthexam)
	 */
	public boolean insertOrUpdatePhHealthexam(PhHealthexam pojo) {
		
		if(!pojo.getRefCompany().equals((byte)0))//如果是对接数据，根据对接公司主键查询数据，并赋值本地主键
			physicalService.selectPhHealthexamExistByRefDataPK(pojo);
		if(StringUtils.isEmpty(pojo.getRefDataPK()))
			pojo.setRefDataPK(UUID.randomUUID().toString());
		if(pojo.getPhHealthexamdetail().getHealthEvaluate() == null)
			pojo.getPhHealthexamdetail().setHealthEvaluate((byte)0);
		if(pojo.getHExamID() == null){
			if(physicalService.insertPhHealthexam(pojo) > 0){
				sendMessage(pojo);
				return true;
			}
		}else{
			if(physicalService.updatePhHealthexam(pojo) > 0){
				sendMessage(pojo);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @Title:sendMessage 
	 * @Description:健康体检消息发送 
	 * TODO  
	 * @author baozj
	 * @param pojo 
	 * @throws
	 * @retrun void
	 */
	private void sendMessage(PhHealthexam pojo){
		try {
			if(pojo.getRefCompany().equals((byte)0) && pojo.getPhHealthexamdetail() != null && pojo.getPhHealthexamdetail().getHealthEvaluate() > 0){//录入数据，并且有健康评价，发送消息
				DictEntity.setDicts(dictService.selectAllSecond_cache());
//				Doctor doctor = doctorService.selectById(pojo.getCreateDrID() == null ? pojo.getUpdateDrID() : pojo.getCreateDrID());
				Member member = memberService.selectById(pojo.getMemberID());
				MsgCenter mc = new MsgCenter(); 
				mc.setMsgtype(MessageTypeEnum.PHYSICAL_EXAM.getType());
				mc.setSendtype(UserTypeEnum.MEMBER.getType());
				mc.setSender(member.getMemberGUID());
				mc.setLastsourceid(pojo.getHExamID());
				mc.setLastcontent(member.getMemname()+"(??)"+TimeUtil.formatDatetime(pojo.getExamDate(), TimeUtil.DATE_CN_PATTERN) + "体检结果"+pojo.getPhHealthexamdetail().getHealthEvaluateStr());
				mc.setLastContentNotice(mc.getLastcontent());
				careIFService.sendMsgToCareMeMember(mc);
			}
		} catch (Exception e) {
			
			logger.error("健康体检消息发送失败", e);
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.PhysicalFacedeService#batchSavePhHealthexam(com.bithealth.inspectCore.physical.model.PhHealthexam)
	 */
	public Map<String, List<PhHealthexam>> batchSavePhHealthexam(List<PhHealthexam> pojos) {
		Map<String, List<PhHealthexam>> map = new HashMap<String, List<PhHealthexam>>();
		List<PhHealthexam> success = new ArrayList<PhHealthexam>();
		map.put(Constants.PH_BATCH_SAVE_SUCCESS, success);
		for(Iterator<PhHealthexam> it = pojos.iterator(); it.hasNext();){
			PhHealthexam pojo = it.next();
			if(insertOrUpdatePhHealthexam(pojo)){
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
	 *  @see com.bithealth.inspectCore.facede.service.PhysicalFacedeService#deletePhHealthexam(java.lang.Long[])
	 */
	public boolean deletePhHealthexam(Long... ids) {
		
		return physicalService.deletePhHealthexam(ids) > 0;
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.PhysicalFacedeService#deleteSoftPhHealthexam(java.lang.Long[])
	 */
	public boolean deleteSoftPhHealthexam(Long... ids) {
		
		return physicalService.deleteSoftPhHealthexam(ids) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.PhysicalFacedeService#selectPhHealthexamById(java.lang.Long)
	 */
	public PhHealthexam selectPhHealthexamById(Long id) {
		DictEntity.setDicts(dictService.selectAllSecond_cache());
		if(id == null)
			return null;
		return physicalService.selectPhHealthexamById(id);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.PhysicalFacedeService#selectPhHealthexamByRefDataPK(java.lang.String)
	 */
	public PhHealthexam selectPhHealthexamByRefDataPK(String refDataPK) {
		
		return physicalService.selectPhHealthexamByRefDataPK(refDataPK);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.PhysicalFacedeService#selectPhHealthexamByParam(java.lang.Byte, java.lang.String, java.lang.String)
	 */
	public PhHealthexam selectPhHealthexamByParam(Byte refCompany,
			String unique_ID, String refDataPK) {
		
		return physicalService.selectPhHealthexamByParam(refCompany, unique_ID, refDataPK);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.PhysicalFacedeService#selectPhHealthexamByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.physical.model.PhHealthexamExample)
	 */
	public Page<PhHealthexam> selectPhHealthexamByExampleAndPage(
			Page<PhHealthexam> page, PhHealthexamExample example) {
		
		return physicalService.selectPhHealthexamByExampleAndPage(page, example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.PhysicalFacedeService#selectPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.physical.model.PhHealthexam, java.lang.Integer)
	 */
	public Page<PhHealthexam> selectPage(Page<PhHealthexam> page,
			PhHealthexam pojo, Integer currentDocId) {
		List<Integer> odgpIds = null;
		if(pojo.getMemberID() == null){
			odgpIds = inspectDao.selectOdgpIdsByDocId(currentDocId);
			if(odgpIds == null || odgpIds.isEmpty())
				return page;
		}
		return physicalService.selectPage(page, pojo, odgpIds);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.PhysicalFacedeService#selectPhHealthexamList(java.util.Date, java.lang.Integer, java.lang.String)
	 */
	public List<PhHealthexam> selectPhHealthexamList(Date getTime,
			Integer source, String prgid) {
		PhHealthexam pojo = new PhHealthexam();
		pojo.setGetTime(getTime);
		pojo.createMember().setSource(source);
		pojo.createMemRelation().setPrgid(prgid);
		return physicalService.selectPhHealthexamList(pojo);
	}

}

