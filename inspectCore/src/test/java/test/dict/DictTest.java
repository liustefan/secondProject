 
/**
 * @PackageName:      test.inspect
 * @FileName:     DictTest.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月30日 下午2:29:40  
 * 
 */

package test.dict;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.BaseTest;

import com.alibaba.fastjson.JSON;
import com.bithealth.inspectCore.facede.service.DictFacedeService;


/**
 * 类名称: DictTest  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月30日 下午2:29:40 
 * 
 * @author baozj
 * @version  
 */
public class DictTest extends BaseTest {

	@Autowired
	DictFacedeService service;
	
//	@Ignore
	@Test
	public void selectAllSecond(){
		logger.info("查询公卫数据字典所有数据封闭到map中====》" + JSON.toJSONString(service.selectAllSecond()));
	}
	
	@Ignore
	@Test
	public void selectSecond(){
		logger.info("查询公卫数据字典某二级的所有数据====》" + JSON.toJSONString(service.select("高血压随访_生活方式指导", "心理调整")));
	}
	
	@Ignore
	@Test
	public void selectThird(){
		logger.info("查询公卫数据字典三级对应的数据====》" + JSON.toJSONString(service.select("高血压随访_生活方式指导", "心理调整", (byte)1)));
	}
}

