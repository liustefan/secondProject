package com.bithealth.cms;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONObject;
import com.bithealth.msgCenterCore.constants.Constrants;
import com.bithealth.msgCenterCore.enmu.SendStatusEnmu;
import com.bithealth.msgCenterCore.enmu.SmsEnmu;
import com.bithealth.msgCenterCore.enmu.SmsPriortyEnmu;
import com.bithealth.msgCenterCore.enmu.SmsTypeEnmu;
import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
import com.bithealth.msgCenterCore.model.SmsConfig;
import com.bithealth.msgCenterCore.model.SmsSearchParams;
import com.bithealth.msgCenterCore.model.SmsSendDetail;
import com.bithealth.msgCenterCore.model.SmsSendParams;
import com.bithealth.msgCenterCore.model.SmsSendRecord;
import com.bithealth.msgCenterCore.model.SmsStatistic;
import com.bithealth.orgainCore.model.Org;
import com.bithealth.orgainCore.model.OrgExample;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;

@Controller
@RequestMapping("/sms")
public class SmsController extends BaseSpringController{
	@Resource
	private MessageCenterFacadeService messageCenterFacadeService;
	
	@Resource
	private OrgService orgService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getSmsRecord")
	public String getSmsRecord(HttpServletRequest request,SmsSearchParams smsParams,Integer orgId){
		//设置serverID
		smsParams.setServerID(Integer.valueOf(Constrants.SERVERID));
		//拼接组织id（组织本身以及子组织id）
		StringBuilder sb = new StringBuilder();
		Map<Integer, String> map = new HashMap<Integer, String>();
		if(orgId != null){
			Org org = orgService.selectById(orgId);
			request.setAttribute("orgId", orgId);
			request.setAttribute("orgName", org.getOrgName());
			//获取组织的子组织
			List<Org> subOrgs = org.getChildren();
			map.put(orgId, org.getOrgName());
			sb.append(orgId);
			for(Org o : subOrgs){
				sb.append(",").append(o.getOrgId());
				map.put(o.getOrgId(), o.getOrgName());
			}
		}
		smsParams.setOrgIDs(sb.toString());
		Page<JSONObject> page = messageCenterFacadeService.getSmsList(smsParams);
		List<JSONObject> list = page.getResult();
		
		//如果组织为空，根据短信服务返回的组织id去获取组织名称
		if(orgId == null && list.size() > 0){
			List<Integer> orgIdList = new ArrayList<Integer>();
			for(JSONObject smsDetailObj:list){
				orgIdList.add(smsDetailObj.getInteger("orgID"));
			}
			OrgExample example = new OrgExample();
			example.createCriteria().andOrgIdIn(orgIdList);
			List<Org>  orgList = orgService.selectByExample(example);
			for(Org org:orgList){
				map.put(org.getOrgId(), org.getOrgName());
			}
		}
		
		//处理短信中各状态值，状态值转化为对应的中文
		Iterator ite = list.iterator();
		while(ite.hasNext()){
			JSONObject json = (JSONObject)ite.next();
			Integer orgId_ = (Integer)json.get("orgID");
			
			for(Map.Entry<Integer, String> entry : map.entrySet()){
				if(orgId_.equals(entry.getKey())){
					json.put("orgName", entry.getValue());
				}
			}
			json.put("priorityName", SmsPriortyEnmu.getEnmuByVal((Integer)json.get("priority")).getDesc());
			json.put("smsTypeName", SmsEnmu.getEnmuByVal((Integer)json.get("smsType")).getDesc());
			json.put("contentTypeName",SmsTypeEnmu.getEnmuByVal((Integer)json.get("contentType")).getDesc());
			json.put("sendStatusName",SendStatusEnmu.getEnmuByVal((Integer)json.get("sendStatus")).getDesc());
		}
		
		request.setAttribute("page", page);
		request.setAttribute("smsParams", smsParams);
		request.setAttribute("smsParamsJson", JSONObject.toJSONString(smsParams));
		return "/msgCenter/sms/smsRecord";
	}
	
	@RequestMapping("/smsSend")
	public String smsSend(SmsSendRecord smsSendRecord){
		Integer serverid = Integer.valueOf(Constrants.SERVERID);
		List<SmsSendParams> list = smsSendRecord.getSmsSendParams();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(SmsSendParams smsSendParams : list){
			smsSendParams.setServerID(serverid);
			Org org = orgService.selectById(smsSendParams.getOrgId());
			smsSendParams.setOrgPath(org.getPath());
			smsSendParams.setSendTime(sdf.format(new Date()));
			smsSendParams.setContent("{\"product\":\"中科汇康\"}");
			messageCenterFacadeService.smsSend(smsSendParams);
		}
		return "redirect:/sms/getSmsRecord";
	}
	
	@RequestMapping("/jumpSmsConfigPage")
	public String jumpSmsConfigPage(HttpServletRequest request, Integer orgID, String orgName){
		try {
			orgName = URLDecoder.decode(orgName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		Integer serverid = Integer.valueOf(Constrants.SERVERID);
		
		SmsConfig smsC = new SmsConfig();
		smsC.setServerID(serverid);
		smsC.setOrgID(orgID);
		SmsConfig smsConfig = messageCenterFacadeService.getSmsConfig(smsC);
		
		if(smsConfig.getSCfgID() == null){
			smsConfig.setServerID(serverid);
			smsConfig.setOrgID(orgID);
			smsConfig.setCreateID(getCurentUser().getId());
			smsConfig.setCreateTime(new Date());
		}
		
		request.setAttribute("orgName", orgName);
		request.setAttribute("smsConfig", smsConfig);
		
		return "/msgCenter/sms/smsSetting";
	}
	
	@RequestMapping("/saveSmsConfig")
	public String saveSmsConfig(SmsConfig smsConfig){
		smsConfig.setUpdateID(getCurentUser().getId());
		smsConfig.setUpdateTime(new Date());
		messageCenterFacadeService.saveSmsConfig(smsConfig);
		return "redirect:/org/orgPage";
	}
	
	
	/**
	 * @Title:deleteSmsConfig 
	 * @Description:删除短信配置
	 * @author 谢美团
	 * @param smsConfig
	 * @return 
	 * @throws
	 * @retrun String
	 * @throws UnsupportedEncodingException 
	 */ 
	@RequestMapping(value ="/deleteSmsConfig")
	public String deleteSmsConfig(SmsConfig smsConfig,ModelMap model ) throws UnsupportedEncodingException{
		smsConfig.setUpdateID(getCurentUser().getId());
		smsConfig.setUpdateTime(new Date());
		messageCenterFacadeService.deleteSmsConfig(smsConfig);
		model.addAttribute("orgID", smsConfig.getOrgID());
		model.addAttribute("orgName",URLEncoder.encode( smsConfig.getOrgName(),"UTF-8"));
		return "redirect:/sms/jumpSmsConfigPage";
	}
	
	
	
	@RequestMapping("/getSmsStatistic")
	public String getSmsStatistic(HttpServletRequest request, SmsSearchParams smsParams){
		Integer serverid = Integer.valueOf(Constrants.SERVERID);
		smsParams.setServerID(serverid);
		List<SmsStatistic> list = messageCenterFacadeService.getSmsStatistic(smsParams);
		
		//查询数据统计组织
		List<Integer> orgIdList = new ArrayList<Integer>();
		for(SmsStatistic smstic : list){
			if(!orgIdList.contains(smstic.getOrgID())){
				orgIdList.add(smstic.getOrgID());
			}
		}
		List<Org> orgs = new ArrayList<Org>();
		if(orgIdList.size() > 0){
			OrgExample example = new OrgExample();
			example.createCriteria().andOrgIdIn(orgIdList);
		    orgs = orgService.selectByExample(example);
		}

		Map<Integer, List<SmsStatistic>> map = new HashMap<Integer, List<SmsStatistic>>();
		for(SmsStatistic smstic : list){
			if(map.get(smstic.getOrgID()) != null){
				map.get(smstic.getOrgID()).add(smstic);
			}else{
				List<SmsStatistic> smsticList = new ArrayList<SmsStatistic>();
				
				//判断该统计对象有无组织名称，没有则查找相应的组织名称
				if((smstic.getOrgName() == null || "".equals(smstic.getOrgName().trim())) && smstic.getOrgID() != null){
					for(Org org : orgs){
						if(org.getOrgId().equals(smstic.getOrgID())){
							smstic.setOrgName(org.getOrgName());
							continue;
						}
					}
				}
				smsticList.add(smstic);
				map.put(smstic.getOrgID(), smsticList);
			}
		}

		smsParams.setSmsTypeName(SmsEnmu.getEnmuByVal(smsParams.getSmsType()).getDesc());
		request.setAttribute("map", map);
		request.setAttribute("smsParams", smsParams);
		return "/msgCenter/sms/statisticResult";
	}
}
