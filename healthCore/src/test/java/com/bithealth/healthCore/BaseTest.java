package com.bithealth.healthCore;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

 
/**
 * @PackageName:      
 * @FileName:     BaseTest.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月27日 上午11:33:27  
 * 
 */

/**
 * 类名称: BaseTest  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月27日 上午11:33:27 
 * 
 * @author baozj
 * @version  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:application*.xml"})
public class BaseTest {
	
	protected static Logger logger = Logger.getLogger(BaseTest.class);
	private Long time;
	@Before
	public void start(){
		time = System.currentTimeMillis();
		logger.info("======================开始单元测试============================");
	}
	
	@After
	public void end(){
		logger.info("==========耗时：" + (System.currentTimeMillis()-time) + "毫秒==========");
		logger.info("======================结束单元测试============================");
	}
	
}

