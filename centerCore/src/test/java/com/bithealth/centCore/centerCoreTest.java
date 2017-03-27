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

package com.bithealth.centCore;



import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bithealth.centCore.sms.taobao.AlibabaSmsNumQueryReq;
import com.bithealth.centCore.sms.taobao.AlibabaSmsReq;
import com.bithealth.centCore.sms.taobao.TaoBaoSmsUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:application*.xml"})
public class centerCoreTest {
	
    public static void main(String[] args) throws Exception{

    	String appKey = "23553660";
    	String appSecret = "c7e83141db483625c09c8aec9d0a4f2e";

    	AlibabaSmsReq req = new AlibabaSmsReq();
    	req.setAppKey(appKey);
    	req.setAppSecret(appSecret);
    	req.setExtend("123456");
    	req.setRecNum("13699827050");
    	req.setSmsFreeSignName("汇康e家2");
    	req.setSmsParamString("{\"code\":\"5436\",\"product\":\"汇康e家\"}");
    	req.setSmsTemplateCode("SMS_32575037");
    	
    	//TaoBaoSmsUtil.smsSend(req);

    	AlibabaSmsNumQueryReq alibabaSmsNumQueryReq = new AlibabaSmsNumQueryReq();
    	alibabaSmsNumQueryReq.setAppKey(appKey);
    	alibabaSmsNumQueryReq.setAppSecret(appSecret);
    	alibabaSmsNumQueryReq.setCurrentPage(1L);
    	alibabaSmsNumQueryReq.setPageSize(50L);
    	alibabaSmsNumQueryReq.setQueryDate("20161202");
    	alibabaSmsNumQueryReq.setRecNum("13699827050");
    	TaoBaoSmsUtil.getSmsSendStatus(alibabaSmsNumQueryReq);
    }
	
	
	
}

