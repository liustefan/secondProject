/**
 * @PackageName:      com.bithealth.doctorCore.facede.service.impl
 * @FileName:     DoctorGroupInterfServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月27日 下午4:32:08  
 * 
 */
package com.bithealth.doctorCore.facede.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bithealth.doctorCore.docGroup.model.DocGrpToMemGrpExample;
import com.bithealth.doctorCore.docGroup.model.DocGrpToMemGrpKey;
import com.bithealth.doctorCore.docGroup.model.DoctorGroup;
import com.bithealth.doctorCore.docGroup.service.DocGrpToMemGrpService;
import com.bithealth.doctorCore.docGroup.service.DoctorGroupService;
import com.bithealth.doctorCore.docGroup.service.DoctorToGroupService;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.doctorCore.facede.service.DoctorGroupInterfService;
import com.bithealth.sdk.core.exception.BusinessException;

/**
 * 类名称: DoctorGroupInterfServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月27日 下午4:32:08 
 * 
 * @author liuhm
 * @version  
 */
@Service("doctorGroupInterfService")
public class DoctorGroupInterfServiceImpl implements DoctorGroupInterfService {
	
	@Resource(name="doctorGroupService")
	private DoctorGroupService doctorGroupService;
	
	@Resource(name="doctorService")
	private DoctorService doctorService;
	
	@Resource(name="docGrpToMemGrpService")
	private DocGrpToMemGrpService docGrpToMemGrpService;
	
	@Resource(name="doctorToGroupService")
	private DoctorToGroupService doctorToGroupService;

	@Override
	public int saveOrUpdate(DoctorGroup doctorGroup) {
		if(doctorGroup.getOdgpid() == null) {  //新增
			return doctorGroupService.insert(doctorGroup);
		}
		
		//修改
		DoctorGroup oldGroup = doctorGroupService.selectById(doctorGroup.getOdgpid());
		DoctorGroup group = doctorGroupService.checkGroupExist(doctorGroup.getOrgid(), doctorGroup.getFathid(), doctorGroup.getOdgpname());
		if(group != null && group.getOdgpid() != doctorGroup.getOdgpid()) {
			return 0;  //重名不能修改
		}
		
		if(doctorGroup.getEndblocktag()) {
			if(!oldGroup.getEndblocktag()) {
				List<DoctorGroup> list = oldGroup.getChildren();
				if(list != null && !list.isEmpty()) {
					return 0;    //分组下有子节点的，不允许修改为终结点
				}
			}
		}
		
		if(!doctorGroup.getEndblocktag()) {
			if(oldGroup.getEndblocktag()) {
				if(oldGroup.getChlevel() != null) {
					return 0;   //有审核权限，不允许修改为非终结点
				}
				List<Doctor> list = doctorService.selectDoctorByGroup(oldGroup.getOdgpid());
				if(list != null && !list.isEmpty()) {
					return 0;  //有医生绑定，不能修改为非终结点
				}
			}
		}
		
		return doctorGroupService.updateByPrimaryKey(doctorGroup);
	}

	@Override
	public int deleteDoctorGroup(Integer id) throws BusinessException {
		int count = doctorGroupService.delete(id);
		docGrpToMemGrpService.deleteByDoctorGroup(id);  //会员分组与医生分组关联
		doctorToGroupService.deleteByDoctorGroup(id);  //医生分组已医生关联
		return count;
	}
}
