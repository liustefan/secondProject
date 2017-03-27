 
/**
 * @PackageName:      com.bithealth.healthCore
 * @FileName:     Templet.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年11月29日 上午10:34:12  
 * 
 */

package com.bithealth.healthCore;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.bithealth.healthCore.enmu.TempletStatusEnum;
import com.bithealth.healthCore.facede.service.TempletFacedeService;
import com.bithealth.healthCore.templet.model.ManageschemeTemplet;
import com.bithealth.healthCore.templet.model.ManageschemeTempletTask;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: Templet  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月29日 上午10:34:12 
 * 
 * @author baozj
 * @version  
 */
public class TempletTest extends BaseTest {

	@Autowired
	TempletFacedeService templetService;
	
	@Ignore
	@Test
	public void selectById(){
		logger.info("根据管理方案模板ID，查询详细信息 =====》" + JSON.toJSONString(templetService.selectTempletById(7)));
	}
	
//	@Ignore
	@Test
	public void selectTempletPage(){
		ManageschemeTemplet model = new ManageschemeTemplet(); 
		model.setSuperOrgIds("93");
		model.setRoleId(2);
		model.setCreateID(285);
		logger.info("分页查询方案模板=====》" + JSON.toJSONString(templetService.selectTempletPage(new Page<ManageschemeTemplet>(), model)));
	}
	
	@Ignore
	@Test
	public void deleteTemplet(){
		logger.info("软删除方案模板=====》" + JSON.toJSONString(templetService.deleteTemplet(1)));
	}
	
	@Ignore
	@Test
	public void deleteTempletTask(){
		logger.info("软删除方案模板任务信息=====》" + JSON.toJSONString(templetService.deleteTempletTask(1)));
	}
	
	@Ignore
	@Test
	public void insertOrUpdateTemplet(){
		ManageschemeTemplet model = new ManageschemeTemplet();
		logger.info("保存方案模板基本信息=====》" + JSON.toJSONString(templetService.insertOrUpdateTemplet(model)));
	}
	
	@Ignore
	@Test
	public void insertOrUpdateTempletTask(){
		ManageschemeTempletTask model = new ManageschemeTempletTask();
		logger.info("保存方案模板任务信息=====》" + JSON.toJSONString(templetService.insertOrUpdateTempletTask(model)));
	}
	
	@Ignore
	@Test
	public void updateTempletStatus(){
		logger.info("更新方案模板状态=====》" + JSON.toJSONString(templetService.updateTempletStatus(1, TempletStatusEnum.EFFECT, TempletStatusEnum.ADDED)));
	}
	
	@Ignore
	@Test
	public void selectTempletIsExist(){
		logger.info("更新方案模板状态=====》" + JSON.toJSONString(templetService.selectTempletIsExist(2, "标题二", 3, 285, "93")));
	}
	
	@Ignore
	@Test
	public void updateUsedNumber(){
		logger.info("模板被使用次数加1=====》" + JSON.toJSONString(templetService.updateUsedNumber(1)));
	}
}

