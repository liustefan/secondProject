 
/**
 * @PackageName:      test.inspect
 * @FileName:     InspectTest.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 下午5:13:30  
 * 
 */

package com.bithealth.reportCore;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
 

import com.alibaba.fastjson.JSON;
import com.bithealth.reportCore.report.model.MemberChat;
import com.bithealth.reportCore.report.model.MemberChatExample;
import com.bithealth.reportCore.report.service.MemberChatService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: InspectTest  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 下午5:13:30 
 * 
 * @author baozj
 * @version  
 */
public class MemChatTest extends BaseTest {
	
	@Autowired
	MemberChatService service;
	 
//	@Ignore
	@Test
	public void selectPhDiabetesById(){
		MemberChatExample memberChatExample = new MemberChatExample();
		

		memberChatExample.setSender(282); 

		memberChatExample.setMemname("2");
//		memberChatExample.setDateFrom("2016-07-01");
//		memberChatExample.setDateTo("2016-07-30");
		
		logger.info("通过主键查询糖尿病随访详情=====》" + JSON.toJSONString(service.selectByExampleAndPage(new Page<MemberChat>(),  memberChatExample)));


	}
	 
}

