 
/**
 * @PackageName:      inspect.physical
 * @FileName:     PhysicalTest.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午11:42:31  
 * 
 */

package test.physical;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.BaseTest;

import com.alibaba.fastjson.JSON;
import com.bithealth.inspectCore.facede.service.PhysicalFacedeService;
import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailfamilybed;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: PhysicalTest  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午11:42:31 
 * 
 * @author baozj
 * @version  
 */
public class PhysicalTest extends BaseTest{
	
	@Autowired
	PhysicalFacedeService service;
	
	@Ignore
	@Test
	public void selectPhHealthexamById(){
		logger.info("通过主键查询健康体检详情=====》" + JSON.toJSONString(service.selectPhHealthexamById(44211L)));
	}
	
//	@Ignore
//	@Test
//	public void selectPhHealthexamByExampleAndPage(){
//		logger.info("分页查询健康体检数据=====》" + JSON.toJSONString(service.selectPhHealthexamByExampleAndPage(new Page<PhHealthexam>(), new PhHealthexamExample())));
//	}
	
	@Ignore
	@Test
	public void deletePhHealthexam(){
		logger.info("删除健康体检数据=====》" + service.deletePhHealthexam(90004L));
	}
	
	@Ignore
	@Test
	public void insertPhHealthexam(){
		PhHealthexam pojo = new PhHealthexam();
		pojo.setMemberID(0);
		pojo.setRefCompany((byte)0);
		pojo.setRefDataPK("test");
		pojo.setGetTime(new Date());
		pojo.setIsDeleted((byte)0);
		pojo.setCreateDrID(0);
		pojo.setCreateDrName("test");
		pojo.setCreateTime(new Date());
		List<PhHealthexamdetailfamilybed> beds = new ArrayList<PhHealthexamdetailfamilybed>();
		PhHealthexamdetailfamilybed bed = new PhHealthexamdetailfamilybed();
		bed.setStartDate(TimeUtil.now());
		bed.setEndTime(TimeUtil.now());
		bed.setResson("1");
		bed.setInstitution("1");
		bed.setPatientID("1");
		beds.add(bed);
		pojo.setPhHealthexamdetailfamilybeds(beds);
		logger.info("添加健康体检信息=====》" + service.insertOrUpdatePhHealthexam(pojo));
	}
	
	@Ignore
	@Test
	public void selectPhHealthexamByTime(){
		logger.info("对接特殊查询=====》" + service.selectPhHealthexamList(new Date(), 1, "93"));
	}
	
//	@Ignore
	@Test
	public void selectPage(){
		PhHealthexam pojo = new PhHealthexam();
		pojo.setMemberID(78498);
//		pojo.createMember().setMemname("66666666");
//		pojo.setCriteria("圳中科强华科");
		logger.info("对接特殊查询=====》" + JSON.toJSONString(service.selectPage(new Page<PhHealthexam>(), pojo, 285)));
	}
	
	@Ignore
	@Test
	public void selectPhHealthexamByRefDataPK(){
		logger.info("通过合作公司的业务数据主键查询健康体检详情=====》" + JSON.toJSONString(service.selectPhHealthexamByRefDataPK("4b580ee905f14a47fb2fc031ea864f13")));
	}
	
	@Ignore
	@Test
	public void selectPhHealthexamByParam(){
		logger.info("根据参数查询健康体检信息=====》" + JSON.toJSONString(service.selectPhHealthexamByParam((byte)1, "13fcce209691b929763f246063b67d5b", "4b580ee905f14a47fb2fc031ea864f13")));
	}
}

