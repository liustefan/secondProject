 
/**
 * @PackageName:      com.bithealth.healthCore
 * @FileName:     ManageschemeTest.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月8日 下午2:13:08  
 * 
 */

package com.bithealth.healthCore;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bithealth.healthCore.enmu.MassEffectProcessEnum;
import com.bithealth.healthCore.enmu.PersonManageschemeEnum;
import com.bithealth.healthCore.facede.service.ManageschemeFacedeService;
import com.bithealth.healthCore.facede.service.ManageschemeTaskFacedeService;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesign;
import com.bithealth.healthCore.managescheme.model.ManageschemeExec;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTask;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: ManageschemeTest  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月8日 下午2:13:08 
 * 
 * @author baozj
 * @version  
 */
public class ManageschemeTest extends BaseTest {
	
	@Autowired
	ManageschemeFacedeService service;
	@Autowired
	ManageschemeTaskFacedeService taskService;

	@Ignore
	@Test
	public void selectPersonManageschemePage(){
		Page<ManageschemeExec> page = new Page<ManageschemeExec>();
		ManageschemeExec model = new ManageschemeExec();
		model.setCreateID(285);
		logger.info("分页查询个人管理方案（支持查询单个群体管理方案中会员的执行方案 =====》" + JSON.toJSONString(service.selectPersonManageschemePage(page, model), SerializerFeature.PrettyFormat));
	}
	
	@Ignore
	@Test
	public void selectGroupManageschemePage(){
		Page<ManageschemeDesign> page = new Page<ManageschemeDesign>();
		ManageschemeDesign model = new ManageschemeDesign();
		model.setCreateID(0);
		logger.info("分页查询群体管理方案  =====》" + JSON.toJSONString(service.selectGroupManageschemePage(page, model), SerializerFeature.PrettyFormat));
	} 
	
	@Ignore
	@Test
	public void selectManageschemeTaskPage(){
		Page<ManageschemeExecTask> page = new Page<ManageschemeExecTask>();
		page.setPageSize(100);
		ManageschemeExecTask model = new ManageschemeExecTask();
//		model.setExecDrID(0);
//		model.setMemberDiseaseID(0);
//		model.setMemberLabelId(0);
		logger.info("分页查询健康管理任务  =====》" + JSON.toJSONString(taskService.selectManageschemeTaskPage(page, model), SerializerFeature.PrettyFormat));
	}
	
	@Ignore
	@Test
	public void selectManageschemeById(){
		logger.info("管理方案详情  =====》" + JSON.toJSONString(service.selectManageschemeById(1), SerializerFeature.PrettyFormat));
	}
	
	@Ignore
	@Test
	public void selectManageschemeById2(){
		logger.info("管理方案详情  =====》" + JSON.toJSONString(service.selectManageschemeById(43L), SerializerFeature.PrettyFormat));
	}
	
	@Ignore
	@Test
	public void selectManageschemePageByMemberId(){
		Page<ManageschemeExec> page = new Page<ManageschemeExec>();
		logger.info("  =====》" + JSON.toJSONString(service.selectManageschemePageByMemberId(page, 78882), SerializerFeature.PrettyFormat));
	}
	
	@Ignore
	@Test
	public void exProcMschemeGetMemberByDocId(){
		Page<Map<String, Object>> page = new Page<Map<String, Object>>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iDocId", 285);
		logger.info("  =====》" + JSON.toJSONString(service.exProcMschemeGetMemberByDocId(page, params), SerializerFeature.PrettyFormat));
	}
	
	@Ignore
	@Test
	public void exProcMschemeGetoraddMemberByDocId(){
		Page<Map<String, Object>> page = new Page<Map<String, Object>>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iDocId", 285);
		params.put("iMSDesignID", 1);
		logger.info("  =====》" + JSON.toJSONString(service.exProcMschemeGetoraddMemberByDocId(page, params), SerializerFeature.PrettyFormat));
	}
	
	@Ignore
	@Test
	public void exProcMschemeAddMemberByDocId(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iMSDesignID", 2);
		logger.info("  =====》" + JSON.toJSONString(service.exProcMschemeAddMemberByDocId(params), SerializerFeature.PrettyFormat));
	}
	
	@Ignore
	@Test
	public void exProcMschemeAddExecTaskByMSDesignID(){
		Map<String, Object> params = new HashMap<String, Object>();
		service.exProcMschemeAddExecTaskByMSDesignID(params);
	}
	
	@Ignore
	@Test
	public void insertManageschemeExecs(){
		ManageschemeExec exec = new ManageschemeExec();
		exec.setCreateID(285);
		exec.setCreateTime(TimeUtil.now());
		exec.setExecStatus(PersonManageschemeEnum.MAKING.getCode());
		exec.setMEPersonProcess(MassEffectProcessEnum.NOTRIGGER.getCode());
		logger.info("  =====》" + JSON.toJSONString(service.insertManageschemeExecs(exec)));
	}
	
//	@Ignore
	@Test
	public void taskService(){
		taskService.insertMessageTask();
	}
	
}

