package com.bithealth.taskMgrCore.server.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bithealth.agentCore.agent.RedicrectService;
import com.bithealth.agentCore.bean.Parameter;
import com.bithealth.agentCore.enums.MessageMethodEnum;
import com.bithealth.agentCore.enums.RequestMethodEnum;
import com.bithealth.agentCore.enums.UCMethodEnum;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpExample;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.model.ObsrExample;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarService;
import com.bithealth.measureCore.common.model.MiniData;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.common.model.OmdsExample;
import com.bithealth.measureCore.common.model.OmdsExtend;
import com.bithealth.measureCore.common.model.ThreeOneData;
import com.bithealth.measureCore.common.service.OmdsService;
import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg1Example;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Ecg2Example;
import com.bithealth.measureCore.electrocardio.model.Ecg3;
import com.bithealth.measureCore.electrocardio.model.Ecg3Example;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExample;
import com.bithealth.measureCore.electrocardio.service.Ecg1Service;
import com.bithealth.measureCore.electrocardio.service.Ecg2Service;
import com.bithealth.measureCore.electrocardio.service.Ecg3Service;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.model.OppgExample;
import com.bithealth.measureCore.electrocardioPulse.service.PulseService;
import com.bithealth.measureCore.enmu.DeleteStatus;
import com.bithealth.measureCore.enmu.EventType;
import com.bithealth.memberCore.constants.Constrants;
import com.bithealth.msgCenterCore.model.ResponseObject;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;
import com.bithealth.sdk.web.beanutils.BeanUtils;
import com.bithealth.taskMgrCore.appServerUtil.AppServerHttpUtils;
import com.bithealth.taskMgrCore.appServerUtil.RequestHead;
import com.bithealth.taskMgrCore.appServerUtil.RequetParam;
import com.bithealth.taskMgrCore.constants.Constants;
import com.bithealth.taskMgrCore.dao.MemberMergeMapper;
import com.bithealth.taskMgrCore.enmu.APPMethodEnumEnum;
import com.bithealth.taskMgrCore.enmu.ModuleTypeEnum;
import com.bithealth.taskMgrCore.enmu.SyncStatusEnum;
import com.bithealth.taskMgrCore.model.MemberMerge;
import com.bithealth.taskMgrCore.model.MemberMergeExample;
import com.bithealth.taskMgrCore.model.UCResult;
import com.bithealth.taskMgrCore.server.MemberMergeService;

@Service("membermergeService") 
public class MemberMergeServiceImpl extends GenericBaseServiceImpl<MemberMerge,MemberMergeExample,Long> implements MemberMergeService {
          
	private static final Logger logger = Logger.getLogger(MemberMergeServiceImpl.class);
	
    @Resource 
    MemberMergeMapper membermergeMapper;
        
    @Override
    public GenericBaseDao<MemberMerge,MemberMergeExample,  Long > getDao() {
        return membermergeMapper;
    }
    
	@Resource(name="RedirectImpl")
	private RedicrectService redirect;
	
	@Autowired
	private BloodPressureService bloodPressureService;
	
	@Autowired
	private BloodSugarService bloodSugarService;
	
	@Autowired
	private OmdsService omdsService;
	
	@Autowired
	private Ecg1Service ecg1Service;
	
	@Autowired
	private Ecg2Service ecg2Service;
	
	@Autowired
	private Ecg3Service ecg3Service;
	
	@Autowired
	private ElectrocardioService oecgService;
	
	@Autowired
	private PulseService pulseService;
	

	@Override
	public void measureDataMerge(MemberMerge memberMerge) {
		
		//memberMerge = setMemberIdByGUID(memberMerge);
		
		//获取并发送血糖数据
		boolean isObsrSuccess = sendObsr(memberMerge);
		//获取并发送血压数据
		boolean isOsbpSuccess = sendOsbp(memberMerge);
		//获取并发送心电数据
		boolean isMiniSuccess = sendMini(memberMerge);
		//获取并发送三合一数据
		boolean isThreeOneSuccess = sendThreeOne(memberMerge);
		//更新同步合并结果
		updateSyncResult(isObsrSuccess,isOsbpSuccess,isMiniSuccess,isThreeOneSuccess,memberMerge.getLogID());
	}
	
	
	private void updateSyncResult(boolean isObsrSuccess,boolean isOsbpSuccess,boolean isMiniSuccess,boolean isThreeOneSuccess,Long id){
		boolean isMergeSuccess = true;
		MemberMerge record = new MemberMerge();
		String failReason = "合并";
		if(!isObsrSuccess){
			failReason = failReason+"血糖数据 ";
			isMergeSuccess = false;
		}
		if(!isOsbpSuccess){
			failReason = failReason+"血压数据 ";
			isMergeSuccess = false;
		}
		if(!isMiniSuccess){
			failReason = failReason+"mini数据 ";
			isMergeSuccess = false;
		}
		if(!isThreeOneSuccess){
			failReason = failReason+"三合一数据 ";
			isMergeSuccess = false;
		}
		failReason = failReason+"失败";
		if(isMergeSuccess){
			record.setSyncStatus(SyncStatusEnum.SYNC_SUCCESS.getCode());
		}else{
			record.setSyncStatus(SyncStatusEnum.SYNC_FAIL.getCode());
			record.setFailReason(failReason);
		}
		record.setUpdateTime(new Date());
		record.setLogID(id);
		//membermergeMapper.updateByPrimaryKeySelective(record);
	}
	
	
	private List<Omds> getOmdsByEnventType(String enventType,int pageNo,String memberGUID){
		Page<Omds> page = new Page<Omds> (pageNo,Constants.EVERY_TIME_NUMBER);
		return omdsService.getOmdsByGUIDAndEnventType(memberGUID, enventType, page);
	}
	
	private List<Long> geteventIdList(List<Omds> omdsList){
		List<Long> enventIdList = new ArrayList<Long>();
		for(Omds omds:omdsList){
			enventIdList.add(omds.getEventid());
		}
		return enventIdList;
	}
	
	
	
	/**
	 * @Title:sendObsr 
	 * @Description:发送血糖
	 * @author 谢美团
	 * @param memberMerge
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	@SuppressWarnings("rawtypes")
	private boolean sendObsr(MemberMerge memberMerge){
		try{
			boolean isSuccess = true;
			boolean isEnd = false;
			int pageNo = 1;
			while(!isEnd){
				List<Omds> omdsList = getOmdsByEnventType(EventType.BLOOD_SUGAR.getCode(),pageNo,memberMerge.getSourceMemberID());
				pageNo++;
				if(omdsList.size() < Constants.EVERY_TIME_NUMBER){
					isEnd = true;
				}
				if(omdsList.size() == 0){
					continue;
				}
				//根据omds获取对应的血糖数据
				List<Long> eventIdList = geteventIdList(omdsList);
				ObsrExample obsrExample = new ObsrExample();
				obsrExample.createCriteria().andEventidIn(eventIdList).andDeltagEqualTo(DeleteStatus.NOT_DELETE.getCode());
				List<Obsr> obsrList = bloodSugarService.selectByExample(obsrExample);
				
				List<OmdsExtend> omdsExtList = new ArrayList<OmdsExtend>(); 
				for(Omds omds:omdsList){
					OmdsExtend<Obsr> omdsExt = new OmdsExtend<Obsr>();
					omdsExt.setMemberGUID(memberMerge.getTargetMemberID());
					BeanUtils.copyProperties(omdsExt, omds);
					omdsExt.setMemberid(null);
					for(Obsr obsr:obsrList){
						if(obsr.getEventid().equals(omds.getEventid())){
							obsr.setMemberid(null);
							omdsExt.setData(obsr);
							break;
						}
					}
					omdsExtList.add(omdsExt);
				}
				//TODO
				//memberMerge.setTargetURL("http://192.168.10.54:8080/appServer/");
				RequetParam requetParam = getRequetParam(omdsExtList,2);
				String url = memberMerge.getTargetURL() +APPMethodEnumEnum.MERGERBLOODSUGAR.getValue();
				JSONObject obj = AppServerHttpUtils.sendPostToAppserver(url, requetParam);
				JSONResult result = JSONObject.parseObject(obj.toJSONString(),JSONResult.class);
				if(result.getStatusCode() ==0){ //同步成功，删除原数据
					OmdsExample omdsExample = new OmdsExample();
					omdsExample.createCriteria().andEventidIn(eventIdList);
					omdsService.deleteByExample(omdsExample);
					Obsr model = new Obsr();
					model.setDeltag(DeleteStatus.IS_DELETED.getCode());
					ObsrExample example = new ObsrExample();
					example.createCriteria().andEventidIn(eventIdList);
					bloodSugarService.updateByExampleSelective(model, example);
				}else{
					isSuccess = false;
				}
			}
			return isSuccess;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * @Title:sendOsbp 
	 * @Description:发送血压
	 * @author 谢美团
	 * @param memberMerge
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	@SuppressWarnings("rawtypes")
	private boolean sendOsbp(MemberMerge memberMerge){
		try{
			boolean isSuccess = true;
			boolean isEnd = false;
			int pageNo = 1;
			while(!isEnd){
				List<Omds> omdsList = getOmdsByEnventType(EventType.BLOOD_PRESSURE.getCode(),pageNo,memberMerge.getSourceMemberID());
				pageNo++;
				if(omdsList.size() < Constants.EVERY_TIME_NUMBER){
					isEnd = true;
				}
				//根据omds获取对应的血压数据
				List<Long> eventIdList = geteventIdList(omdsList);
				OsbpExample example = new OsbpExample();
				example.createCriteria().andEventidIn(eventIdList).andDeltagEqualTo(DeleteStatus.NOT_DELETE.getCode());
				List<Osbp> obsrList = bloodPressureService.selectByExample(example);
				
				List<OmdsExtend> omdsExtList = new ArrayList<OmdsExtend>();
				for(Omds omds:omdsList){
					OmdsExtend<Osbp> omdsExt = new OmdsExtend<Osbp>();
					omdsExt.setMemberGUID(memberMerge.getTargetMemberID());
					BeanUtils.copyProperties(omdsExt, omds);
					omdsExt.setMemberid(null);
					for(Osbp osbp:obsrList){
						if(omds.getEventid().equals(osbp.getEventid())){
							omdsExt.setData(osbp);
							break;
						}
					}
					omdsExtList.add(omdsExt);
				}
				//发送请求，同步数据
				//memberMerge.setTargetURL("http://192.168.10.54:8080/appServer/");
				RequetParam requetParam = getRequetParam(omdsExtList,2);
				String url = memberMerge.getTargetURL() +APPMethodEnumEnum.MERGERBLOODPRESSURE.getValue();
				JSONObject obj = AppServerHttpUtils.sendPostToAppserver(url, requetParam);
				JSONResult result = JSONObject.parseObject(obj.toJSONString(),JSONResult.class ) ;
				if(result.getStatusCode() ==0){ //同步成功，删除原数据
					OmdsExample omdsExample = new OmdsExample();
					omdsExample.createCriteria().andEventidIn(eventIdList);
					omdsService.deleteByExample(omdsExample);
					Osbp model = new Osbp();
					model.setDeltag(DeleteStatus.IS_DELETED.getCode());
					OsbpExample obspExample = new OsbpExample();
					obspExample.createCriteria().andEventidIn(eventIdList);
					bloodPressureService.updateByExampleSelective(model, obspExample);
				}else{
					isSuccess = false;
				}
			}
			return isSuccess;
		}catch(Exception e){
			return false;
		}
	}
	
	
	/**
	 * @Title:sendOsbp 
	 * @Description:发送心电
	 * @author 谢美团
	 * @param memberMerge
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	private boolean sendMini(MemberMerge memberMerge){
		return sendMiniOrThreeOne(memberMerge,true);
	}
	
	/**
	 * @Title:sendOsbp 
	 * @Description:发送三合一
	 * @author 谢美团
	 * @param memberMerge
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	private boolean sendThreeOne(MemberMerge memberMerge){
		return sendMiniOrThreeOne(memberMerge,false);
	}
	
	
	@SuppressWarnings("rawtypes")
	private boolean sendMiniOrThreeOne(MemberMerge memberMerge,boolean isMini){
		try{
			boolean isSuccess = true;
			boolean isEnd = false;
			int pageNo = 1;
			while(!isEnd){
				List<Omds> omdsList = getOmdsByEnventType(EventType.DONG_TAI_XIN_DIAN.getCode(),pageNo,memberMerge.getSourceMemberID());
				pageNo++;
				if(omdsList.size() < Constants.EVERY_TIME_NUMBER){
					isEnd = true;
				}
				//根据omds获取对应的心电 oecg 的数据
				List<Long> eventIdList = geteventIdList(omdsList);
				OecgExample oecgExample = new OecgExample();
				oecgExample.createCriteria().andEventidIn(eventIdList).andDeltagEqualTo(DeleteStatus.NOT_DELETE.getCode());
				List<Oecg> oecgList = oecgService.selectByExample(oecgExample);
				
				List<OmdsExtend> omdsExtList = new ArrayList<OmdsExtend>();
				for(Omds omds:omdsList){
					OmdsExtend<MiniData> omdsExt = new OmdsExtend<MiniData>();
					omdsExt.setMemberGUID(memberMerge.getTargetMemberID());
					BeanUtils.copyProperties(omdsExt, omds);
					omdsExt.setMemberid(null);
					ThreeOneData data = new ThreeOneData();

					for(Oecg oecg:oecgList){
						if(omds.getEventid().equals(oecg.getEventid())){
							if(!isMini){ //设置三合一的脉搏参数
								 OppgExample oppgExample = new OppgExample();
								 oppgExample.createCriteria().andEventidEqualTo(omds.getEventid()).andDeltagEqualTo(DeleteStatus.NOT_DELETE.getCode());
								 List<Oppg> oppgList = pulseService.selectByExample(oppgExample);
								 data.setOppg(oppgList.size() > 0?oppgList.get(0):null);
							}
							//设置oecg参数
							data.setOecg(oecg);
							//设置ecg1参数
							Ecg1Example ecg1Example = new Ecg1Example();
							ecg1Example.createCriteria().andDocentryEqualTo(oecg.getDocentry());
							List<Ecg1> ecg1List = ecg1Service.selectByExample(ecg1Example);
							data.setEcg1List(ecg1List);
							//设置ecg2参数
							Ecg2Example ecg2Example = new Ecg2Example();
							ecg2Example.createCriteria().andDocentryEqualTo(oecg.getDocentry());
							List<Ecg2> ecg2List = ecg2Service.selectByExample(ecg2Example);
							data.setEcg2List(ecg2List);
							//设置ecg3参数
							Ecg3Example ecg3Example = new Ecg3Example();
							ecg3Example.createCriteria().andDocentryEqualTo(oecg.getDocentry());
							List<Ecg3> ecg3List = ecg3Service.selectByExample(ecg3Example);
							data.setEcg3List(ecg3List);
							omdsExt.setData(data);
							break;
						}
					}
					omdsExtList.add(omdsExt);
				}
				//发送请求，同步数据
				RequetParam requetParam = getRequetParam(omdsExtList,2);
				//memberMerge.setTargetURL("http://192.168.10.54:8080/appServer/");
				String url = "";
				if(isMini){
					url = memberMerge.getTargetURL() +APPMethodEnumEnum.MERGERMINI.getValue();
				}else{
					url = memberMerge.getTargetURL() +APPMethodEnumEnum.MERGERTHREEINONE.getValue();
				}
				 
				JSONObject obj = AppServerHttpUtils.sendPostToAppserver(url, requetParam);
				JSONResult result = JSONObject.parseObject(obj.toJSONString(),JSONResult.class ) ;
				if(result.getStatusCode() ==0){ //同步成功，删除原数据
					OmdsExample omdsExample = new OmdsExample();
					omdsExample.createCriteria().andEventidIn(eventIdList);
					omdsService.deleteByExample(omdsExample);
					Oecg model = new Oecg(); 
					model.setDeltag(DeleteStatus.IS_DELETED.getCode());
					OecgExample oecgExample2 = new OecgExample();
					oecgExample2.createCriteria().andEventidIn(eventIdList);
					oecgService.updateByExampleSelective(model, oecgExample2);
					if(!isMini){ 
						Oppg oppgModel = new Oppg();
						oppgModel.setDeltag(DeleteStatus.IS_DELETED.getCode());
						OppgExample oppgExample = new OppgExample();
						oppgExample.createCriteria().andEventidIn(eventIdList);
						pulseService.updateByExampleSelective(oppgModel, oppgExample);
					}
				}else{
					isSuccess = false;
				}
			}
			return isSuccess;
		}catch(Exception e){
			return false;
		}
	}
	
	
	
	
	
	
	private MemberMerge setMemberIdByGUID(MemberMerge memberMerge){
		//根据GUID获取merberID
		JSONObject paramObj = new JSONObject();
		paramObj.put("memberGUID", memberMerge.getTargetMemberID());
		RequetParam requetParam = getRequetParam(paramObj,1);
		String url = memberMerge.getTargetURL() +APPMethodEnumEnum.FINDMEMBERHEALTHFILE.getValue();
		JSONObject obj = AppServerHttpUtils.sendPostToAppserver(url, requetParam);
		JSONResult result = JSONObject.parseObject(obj.toJSONString(),JSONResult.class ) ;
		if(result.getStatusCode() == 0 && result.getData() != null){
			JSONObject data =  JSONObject.parseObject(result.getData().toString(),JSONObject.class );
			JSONObject basicInfo =  JSONObject.parseObject(data.get("basicInfo").toString(),JSONObject.class ); 
			Integer memberId = basicInfo.getInteger("memberId");
			memberMerge.setMemberId(memberId);
		}
		return memberMerge;
	}
	
	
	
	private RequetParam getRequetParam(Object obj,int userType){
		RequetParam requetParam = new RequetParam();
		RequestHead head = new RequestHead(userType,"Other");
		requetParam.setHead(head);
		requetParam.setContent(obj);
		return requetParam;
	}
	

	@Override
	public void careDataMerge(MemberMerge memberMerge) {
		Map<String, CharSequence> paramMap = new HashMap<String, CharSequence>();
		paramMap.put("sourceGUID", memberMerge.getSourceMemberID());
		paramMap.put("targetGUID", memberMerge.getTargetMemberID());
/*		paramMap.put("sourceGUID", "ffca4638-47b3-4509-a480-a728ca5092aa");
		paramMap.put("targetGUID", "ffca4638-47b3-4509-a480-a728ca5092bb");*/
		Parameter parameter = new Parameter();
		parameter.setParam(paramMap);
		Response  response = redirect.redirect(MessageMethodEnum.MergeCareData, parameter);
		MemberMerge record = new MemberMerge();
		if(HttpStatus.SC_OK == response.getStatus()){
			ResponseObject responseObject = JSONObject.parseObject(response.getBody(), ResponseObject.class);
			if(responseObject.getStatusCode() == 0 ){
				record.setSyncStatus(SyncStatusEnum.SYNC_SUCCESS.getCode());
			}
		}else if(HttpStatus.SC_BAD_REQUEST == response.getStatus()){
			record.setSyncStatus(SyncStatusEnum.SYNC_FAIL.getCode());
			record.setFailReason("连接超时");
		}
		record.setUpdateTime(new Date());
		record.setLogID(memberMerge.getLogID());
		membermergeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void memberMerge() {
		MemberMergeExample example = new MemberMergeExample();
		example.createCriteria().andSyncStatusEqualTo(SyncStatusEnum.TO_BE_SYNC.getCode());
		Page<MemberMerge> page = new Page<MemberMerge>(1,Constants.EVERY_TIME_NUMBER);
		boolean isEnd = false;
		while(!isEnd){
			try{
				List<MemberMerge> list = membermergeMapper.selectByExampleAndPage(page, example);
				page.setPageNo(page.getPageNo() + 1);
				if(list.size() < Constants.EVERY_TIME_NUMBER){
					isEnd = true;
				}
				if(list.size() > 0){
					list = setAppServerURL(list);
				}
				for(MemberMerge memberMerge:list){
					if(memberMerge.getModuleType() == ModuleTypeEnum.MEASURE.getCode()){//合并测量数据
						measureDataMerge(memberMerge);
					}else if(memberMerge.getModuleType() == ModuleTypeEnum.CARE.getCode()){//合并关注数据
						careDataMerge(memberMerge);
					}
				}
			}catch(Exception e){
				logger.error("执行会员测量，关注数据等数据合并任务异常。"+e.getLocalizedMessage());
			}
		}
	}  
	
	
	
	
	@SuppressWarnings("unchecked")
	private List<MemberMerge> setAppServerURL(List<MemberMerge> list){
		Map<Integer,Object> serverMap = new HashMap<Integer,Object>();
		//去重List中重复的serverID
		for(MemberMerge memberMerge:list){
			serverMap.put(memberMerge.getTargetServiceID(), "");
		}
		StringBuffer severIdBuf =  new StringBuffer();
		for(Integer serverId:serverMap.keySet()){
			severIdBuf.append(serverId).append(";");
		}
		String serverIds = severIdBuf.toString();
		if(serverIds.endsWith(";")){
			serverIds = serverIds.substring(0, serverIds.length() -1);
		}
		if("".equals(serverIds)){
			return new ArrayList<MemberMerge>();
		}
		JSONObject params = new JSONObject();
		params.put("serverIds", serverIds);
		
		Response response = getDataFromUC(UCMethodEnum.GetAppServer,params.toJSONString());
		if(response != null && response.getStatus() == 200 && response.getBody() != null){
			UCResult<JSONObject> ucResult = JSONObject.parseObject(response.getBody(), UCResult.class);
			if(ucResult.getCode() == 0){
				List<JSONObject> objList = ucResult.getContent();
				for(MemberMerge memberMerge:list){
					for(JSONObject obj:objList){
						if(memberMerge.getTargetServiceID().equals(obj.getInteger("serverId"))){
							memberMerge.setTargetURL(obj.getString("url"));
							break;
						}
					}
				}
			}else{
				logger.error("根据serverID获取对应的appServer URL异常。");
				return new ArrayList<MemberMerge>();
			}
		}else{
			logger.error("根据serverID获取对应的appServer URL异常。");
			return new ArrayList<MemberMerge>();
		}
		return list;
	}
	
	/**
	 * @Title:getDataFromUC 
	 * @Description:从UC获取URL等数据
	 * @author 谢美团
	 * @param method
	 * @param obj
	 * @return 
	 * @throws
	 * @retrun Response
	 */ 
	private Response getDataFromUC(UCMethodEnum method,Object obj){
		Map<String, CharSequence> param = new HashMap<String, CharSequence>();
		param.put("params", obj.toString());
		String serverId = Constrants.SERVERID;
		param.put("serverID", serverId);
		Parameter parameters = new Parameter(RequestMethodEnum.POST);
		parameters.setHost(Constrants.DNS);
		parameters.setParam(param);
		return redirect.redirect(method, parameters);
	}
}
