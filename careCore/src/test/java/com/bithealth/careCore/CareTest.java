/**
 * @PackageName:      test
 * @FileName:     MyTestUtil.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      柴仕富
 * @version      V1.0  
 * @Createdate:  2016年6月17日 上午10:24:26  
 * 
 */

package com.bithealth.careCore;



import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bithealth.careCore.facade.service.CareIFService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:application*.xml"})
public class CareTest {

	@Resource(name="careIFService")
	private CareIFService careIFService;
  
	@Test
	public void test(){
		
		
	} 
	    
    
    
}

