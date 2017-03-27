/**
 * @PackageName:      com.bithealth.uc
 * @FileName:     PublicURLController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年11月3日 上午10:38:26  
 * 
 */
package com.bithealth.uc;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.Constrants;

/**
 * 类名称: PublicURLController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月3日 上午10:38:26 
 * 
 * @author liuhm
 * @version  
 */
@Controller
public class PublicURLController extends BaseSpringController {
	
	@RequestMapping(value = "/listPublicURL" ,produces = "text/html;charset=UTF-8")
	@ResponseBody 
	public String listPublicURL() throws UnsupportedEncodingException {
		String UC_URL = Constrants.UC_URL;
		String Push_URL = Constrants.Push_URL;
		String CenterServer_URL = Constrants.CenterServer_URL;
		String Upgrade_URL = Constrants.Upgrade_URL;
		String AppServer_Regist_URL = Constrants.AppServer_Regist_URL;
		JSONObject obj = new JSONObject();
		obj.put("uc", UC_URL == null ? "" : UC_URL);
		obj.put("push", Push_URL == null ? "" : Push_URL);
		obj.put("center", CenterServer_URL == null ? "" : CenterServer_URL);
		obj.put("upgrade", Upgrade_URL == null ? "" : Upgrade_URL);
		obj.put("defaultServer", AppServer_Regist_URL == null ? "" : AppServer_Regist_URL);
		return JSON.toJSONString(obj);
	}
	
	@RequestMapping(value = "/listPublicHttpsURL" ,produces = "text/html;charset=UTF-8")
	@ResponseBody 
	public String listPublicHttpsURL() throws UnsupportedEncodingException {
		String UC_URL = Constrants.UC_URL_HTTPS;
		String Push_URL = Constrants.Push_URL_HTTPS;
		String CenterServer_URL = Constrants.CenterServer_URL_HTTPS;
		String Upgrade_URL = Constrants.Upgrade_URL_HTTPS;
		String AppServer_Regist_URL = Constrants.AppServer_Regist_URL_HTTPS;
		JSONObject obj = new JSONObject();
		obj.put("uc", UC_URL == null ? "" : UC_URL);
		obj.put("push", Push_URL == null ? "" : Push_URL);
		obj.put("center", CenterServer_URL == null ? "" : CenterServer_URL);
		obj.put("upgrade", Upgrade_URL == null ? "" : Upgrade_URL);
		obj.put("defaultServer", AppServer_Regist_URL == null ? "" : AppServer_Regist_URL);
		return JSON.toJSONString(obj);
	}

}
