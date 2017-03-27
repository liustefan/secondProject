 
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

package test.inspect;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.BaseTest;

import com.alibaba.fastjson.JSON;
import com.bithealth.inspectCore.facede.service.InspectFacedeService;
import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.model.Inspect;
import com.bithealth.memberCore.member.vo.MemberVo;
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
public class InspectTest extends BaseTest {
	
	@Autowired
	InspectFacedeService service;
	
	@Ignore
	@Test
	public void selectPhDiabetesById(){
		logger.info("通过主键查询糖尿病随访详情=====》" + JSON.toJSONString(service.selectPhDiabetesById(44790L)));
	}
	
//	@Ignore
//	@Test
//	public void selectPhHealthexamByExampleAndPage(){
//		logger.info("分页查询糖尿病随访数据=====》" + JSON.toJSONString(service.selectPhDiabetesByExampleAndPage(new Page<PhDiabetes>(), new PhDiabetesExample())));
//	}
	
	@Ignore
	@Test
	public void selectPhHypertensionById(){
		logger.info("通过主键查询高血压随访详情=====》" + JSON.toJSONString(service.selectPhHypertensionById(111L)));
	}
	
//	@Ignore
//	@Test
//	public void selectPhHypertensionByExampleAndPage(){
//		logger.info("分页查询高血压随访数据=====》" + JSON.toJSONString(service.selectPhHypertensionByExampleAndPage(new Page<PhHypertension>(), new PhHypertensionExample())));
//	}
	
	@Ignore
	@Test
	public void exProcGetDiabetesMemList(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iDocId", 285);
		params.put("vMemName", null);
		params.put("vTel", null);
		params.put("vIdCard", null);
		params.put("dSCreateTime", null);
		params.put("dECreateTime", null);
		logger.info("分页查询我的会员中可以添加糖尿病随访的会员=====》" + JSON.toJSONString(service.exProcGetDiabetesMemList(new Page<MemberVo>(), params)));
	}
	
	@Ignore
	@Test
	public void exProcGetHypertensionMemList(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iDocId", 285);
		params.put("vMemName", null);
		params.put("vTel", null);
		params.put("vIdCard", null);
		params.put("dSCreateTime", null);
		params.put("dECreateTime", null);
		logger.info("分页查询我的会员中可以添加高血压随访的会员=====》" + JSON.toJSONString(service.exProcGetHypertensionMemList(new Page<MemberVo>(), params)));
	}
	
	@Ignore
	@Test
	public void selectPhDiabetesByExample(){
		logger.info("通过参数查询糖尿病随访记录(系统录入数据不计算在内)=====》" + JSON.toJSONString(service.selectPhDiabetesByNum(2)));
	}
	
	@Ignore
	@Test
	public void selectPhHypertensionByExample(){
		logger.info("通过参数查询高血压随访记录数(系统录入数据不计算在内)=====》" + JSON.toJSONString(service.selectPhHypertensionByNum(3)));
	}
	
	@Ignore
	@Test
	public void selectPhDiabetesTotal(){
		logger.info("查询糖尿病随访总记录数(系统录入数据不计算在内)=====》" + JSON.toJSONString(service.selectPhDiabetesTotal()));
	}
	
	@Ignore
	@Test
	public void selectPhHypertensionTotal(){
		logger.info("查询高血压随访总记录数(系统录入数据不计算在内)=====》" + JSON.toJSONString(service.selectPhHypertensionTotal()));
	}
	
	@Ignore
	@Test
	public void selectLatestPhDiabetesInfo(){
		logger.info("查询会员最新糖尿病随访相关数据 =====》" + JSON.toJSONString(service.selectLatestPhDiabetesInfo(32252)));
	}
	
	@Ignore
	@Test
	public void selectLatestPhHypertensionInfo(){
		logger.info("查询会员最新高血压随访相关数据 =====》" + JSON.toJSONString(service.selectLatestPhHypertensionInfo(32441)));
	}
	
	@Ignore
	@Test
	public void selectPhDiabetesList(){
		logger.info("对接特殊查询=====》" + JSON.toJSONString(service.selectPhDiabetesList(new Date(), 1, "93")));
	}
	
	@Ignore
	@Test
	public void selectPhHypertensionList(){
		logger.info("对接特殊查询=====》" + JSON.toJSONString(service.selectPhHypertensionList(new Date(), 1, "93")));
	}
	
	@Ignore
	@Test
	public void selectPhDiabetesPage(){
		PhDiabetes pojo = new PhDiabetes();
		pojo.setPending(true);
		logger.info("分页查询糖尿病随访=====》" + JSON.toJSONString(service.selectPhDiabetesPage(new Page<PhDiabetes>(), pojo, 285)));
	}
	
	@Ignore
	@Test
	public void selectPhHypertensionPage(){
		PhHypertension pojo = new PhHypertension();
		pojo.setPending(true);
		logger.info("分页查询高血压随访=====》" + JSON.toJSONString(service.selectPhHypertensionPage(new Page<PhHypertension>(), pojo, 285)));
	}
	
	@Test
	public void selectPhDiabetesByRefDataPK(){
		logger.info("通过合作公司的业务数据主键查询糖尿病随访详情=====》" + JSON.toJSONString(service.selectPhDiabetesByRefDataPK("d4fb8c01-7d5d-42d3-8d6d-0f13279d1db9")));
	}
	
	@Ignore
	@Test
	public void selectPhHypertensionByRefDataPK(){
		logger.info("通过合作公司的业务数据主键查询高血压随访详情=====》" + JSON.toJSONString(service.selectPhHypertensionByRefDataPK("0123DF27-DD76-437E-8526-242A14BA285A")));
	}
	
//	@Ignore
	@Test
	public void selectInspectPage(){
		logger.info("分页查询会员公卫信息(移动会员端) =====》" + JSON.toJSONString(service.selectInspectPage(new Page<Inspect>(), 61874)));
	}
}

