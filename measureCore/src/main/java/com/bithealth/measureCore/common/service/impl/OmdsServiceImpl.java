 
/**
 * @PackageName:      com.bithealth.measureCore.common.service.impl
 * @FileName:     OmdsServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月20日 上午11:39:31  
 * 
 */

package com.bithealth.measureCore.common.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpExample;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.model.ObsrExample;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarService;
import com.bithealth.measureCore.common.dao.MultiOmdsMapper;
import com.bithealth.measureCore.common.dao.OmdsMapper;
import com.bithealth.measureCore.common.model.MeasureRecord;
import com.bithealth.measureCore.common.model.MiniData;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.common.model.OmdsExample;
import com.bithealth.measureCore.common.model.OmdsExtend;
import com.bithealth.measureCore.common.model.ThreeOneData;
import com.bithealth.measureCore.common.service.OmdsService;
import com.bithealth.measureCore.electrocardio.dao.OecgMapper;
import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Ecg3;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExample;
import com.bithealth.measureCore.electrocardio.service.Ecg1Service;
import com.bithealth.measureCore.electrocardio.service.Ecg2Service;
import com.bithealth.measureCore.electrocardio.service.Ecg3Service;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.model.OppgExample;
import com.bithealth.measureCore.electrocardioPulse.service.PulseService;
import com.bithealth.memberCore.group.model.MemToGroupExample;
import com.bithealth.memberCore.group.model.MemToGroupKey;
import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.group.service.MemToGroupService;
import com.bithealth.memberCore.group.service.MemberGroupService;
import com.bithealth.memberCore.member.dao.MemberMapper;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: OmdsServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月20日 上午11:39:31 
 * 
 * @author 陈哲
 * @version  
 */
@Service
public class OmdsServiceImpl extends GenericBaseServiceImpl<Omds, OmdsExample, Long> implements OmdsService{
	@Autowired
	private OmdsMapper omdsMapper;
	
	@Autowired
	MultiOmdsMapper multiOmdsMapper; 
	
	@Autowired
	BloodPressureService bloodPressureService;
	
	@Autowired
	BloodSugarService bloodSugarService;
	
	@Autowired
	PulseService pulseService;
	
	@Autowired
	ElectrocardioService electrocardioService;
	
	@Autowired
	Ecg2Service ecg2Service;
	
	@Autowired
	private MemberGroupService groupService;
	
	@Autowired
	private MemToGroupService memToGroupService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	Ecg1Service ecg1Service;
	
	@Autowired
	Ecg3Service ecg3Service;
	
	/** 
	     * @Title: send 
	     * @Description: TODO 简单描述该方法的实现功能（可选）.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
	     */
	@Override
	public GenericBaseDao<Omds, OmdsExample, Long> getDao() {
		
		// TODO Auto-generated method stub
		return omdsMapper;
	}
	
	/**
	     * @Title: send 
	     * @Description: 上传心电，生成新的eventid
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.common.service.OmdsService#generateEventId()
	 */
/*	public Long generateEventId(){
		int result = multiOmdsMapper.insertOmds_eventid();
		
		Long eventid = null;
		if(result == 1){
			eventid = multiOmdsMapper.selectMaxEventid();
		}
		return eventid;
	}*/
	public Long generateEventId(){
		Long eventid =  multiOmdsMapper.selectMaxEventid();
		return eventid;
	}

	/** 
	     * @Title: send 
	     * @Description: 保存omds到数据库中
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.common.service.OmdsService#saveOmds(com.bithealth.measureCore.common.model.Omds)
	     */
	public int saveOmds(Omds omds) {
		return insert(omds) ;
	}

	
	/** 
	     * @Title: send 
	     * @Description: TODO 简单描述该方法的实现功能（可选）.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.common.service.OmdsService#selectOmdsByEventId(java.util.Map)
	     */
	@Override
	public Omds selectOmdsByEventId(Long eventId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("eventId", eventId);
		
		return multiOmdsMapper.selectOmdsByEventId(param);
	}
	
	/**
	     * @Title: send 
	     * @Description: 通过eventid查询记录，更新wheAbnTag字段
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.common.service.OmdsService#updateOmdsByEventid(java.lang.Long, int)
	 */
	public void updateWheAbnTagOfOmdsByEventid(Long eventId, String wheAbnTag){
		Omds omds = new Omds();
		omds.setWheabntag(wheAbnTag);
		OmdsExample example = new OmdsExample();
		example.createCriteria().andEventidEqualTo(eventId);
		
		omdsMapper.updateByExampleSelective(omds, example);
	}
	
	
	/**
	 * @Title:updateStatusTagOfOmdsByEventid 
	 * @Description:通过eventid查询记录，更新statusTag字段
	 * @author 陈哲
	 * @param eventId
	 * @param statusTag 
	 * @throws
	 * @retrun void
	 */
	public void updateStatusTagOfOmdsByEventid(Long eventId, Integer statusTag){
		Omds omds = new Omds();
		omds.setStatustag(new Integer(statusTag).shortValue());
		OmdsExample example = new OmdsExample();
		example.createCriteria().andEventidEqualTo(eventId);
		
		omdsMapper.updateByExampleSelective(omds, example);
	}
	
	/**
     * @Title: send 
     * @Description: 根据不同条件查询测量数据
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.measureCore.common.service.OmdsService#findAllMeasureRecordByParam(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Map<String, List<Map<String, Object>>> findAllMeasureRecordByParam(Integer memberId, Integer eventType, Integer isAbnormal,
			String startTime, String endTime, Integer pageNo, Integer pageSize){
		Page<MeasureRecord> page = new Page<MeasureRecord>(pageNo, pageSize);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("eventType", eventType);
		param.put("isAbnormal", isAbnormal);
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		
		List<MeasureRecord> list = multiOmdsMapper.findAllMeasureRecordByParam(page,param);
		
		if(list == null || list.size() == 0){
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, List<Map<String, Object>>> maps = new LinkedHashMap<String, List<Map<String, Object>>>();
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
		
		String measTime = "";
		for(MeasureRecord measureRecord : list){
			String timeF = sdf.format(measureRecord.getTestTime());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("eventId",measureRecord.getEventId());
			map.put("eventType",measureRecord.getEventType());
			map.put("isAbnormal",measureRecord.getIsAbnormal());
			map.put("testTime",measureRecord.getTestTime());
			map.put("memberId",measureRecord.getMemberId());
			if("1".equals(measureRecord.getEventType())){
				map.put("systolic",measureRecord.getSystolic());
				map.put("diastolic",measureRecord.getDiastolic());
				map.put("pulseRate",measureRecord.getPulseRate());
				map.put("timePeriod",measureRecord.getTimePeriod());
				map.put("analysisResult",measureRecord.getAnalysisResult());
			}else if("2".equals(measureRecord.getEventType())){
				map.put("bloodSugar",measureRecord.getBloodSugar());
				map.put("timePeriod",measureRecord.getTimePeriod());
	            map.put("analysisResult",measureRecord.getAnalysisResult());
			}else if("3".equals(measureRecord.getEventType())){
	            map.put("analysisResult",measureRecord.getAnalysisResult());
				map.put("averageHeart",measureRecord.getAverageHeart());
				map.put("averagePulseRate",measureRecord.getAveragePulseRate());
				
				//计算脉搏异常数量
				Oppg oppg = pulseService.selectElectrocardioPulseByEventId(measureRecord.getEventId());
				int oppgCount = 0;
				if(oppg.getStatustag() != null && oppg.getStatustag() == (short)2){
					oppgCount = oppg.getMeasureResult().size();
				}
				map.put("oppgCount", oppgCount);
				
				//计算异常心电数量
				Oecg oecg = electrocardioService.selectElectrocardioByEventId(measureRecord.getEventId());
				List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
				int num = 0;
				if(ecg2s != null && ecg2s.size() > 0){
					num = ecg2s.size();
				}
				map.put("oecgCount",num);

				map.put("statusTag",measureRecord.getAnalysisStatus());
			}else{
	            map.put("analysisResult",measureRecord.getAnalysisResult());
				map.put("averageHeart",measureRecord.getAverageHeart());
				
				//计算心电异常数量
				Oecg oecg = electrocardioService.selectElectrocardioByEventId(measureRecord.getEventId());
				List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
				int num = 0;
				if(ecg2s != null && ecg2s.size() > 0){
					num = ecg2s.size();
				}
				map.put("abnormalCount",num);
				
				map.put("statusTag",measureRecord.getAnalysisStatus());
			}
			
			//根据日期分组封装到maps集合里面
			if("".equals(measTime)){
				lists.add(map);
				measTime = timeF;
				continue;
			}
			
			if(measTime.equals(timeF)){
				lists.add(map);
			}else{
				maps.put(measTime, lists);
				lists = new ArrayList<Map<String, Object>>();
				lists.add(map);
			}
			measTime = timeF;
		}
		maps.put(measTime, lists);
		
		return maps;
	};
	
	
	@Override
	public List<Omds> getLastestMeasList(Integer userId, Integer orgId){
		List<MemberGroup> docList = groupService.selectByDoctorAndOrg(userId, orgId);
		
		List<Integer> memGrpids = new ArrayList<Integer>();
		for(MemberGroup memberGroup : docList){
			memGrpids.add(memberGroup.getMemgrpid());
		}
		
		MemToGroupExample memToGrpExample = new MemToGroupExample();
		memToGrpExample.setDistinct(true);
		MemToGroupExample.Criteria memToGrpCriteria = memToGrpExample.createCriteria();
		memToGrpCriteria.andMemgrpidIn(memGrpids);
		List<MemToGroupKey> memToGroupKeys = memToGroupService.selectByExample(memToGrpExample);
		
		List<Integer> memberIds = new ArrayList<Integer>();
		for(MemToGroupKey memToGroupKey : memToGroupKeys){
			memberIds.add(memToGroupKey.getMemberid());
		}
		
		OmdsExample omdsExample = new OmdsExample();
		OmdsExample.Criteria criteria = omdsExample.createCriteria();
		omdsExample.setDistinct(true);
		omdsExample.setOrderByClause("UploadTime DESC");
		criteria.andMemberidIn(memberIds);
		List<Omds> omdsList = omdsMapper.selectByExample(omdsExample);
		List<Omds> omds = new ArrayList<Omds>();
		
		int i=0;
		for(Omds om : omdsList){
			om.setMember(memberService.selectById(om.getMemberid()));
			
			if("1".equals(om.getEventtype())){
				Osbp osbp = bloodPressureService.selectBloodPressByEventId(om.getEventid());
				om.setMeasureTime(osbp.getTesttime());
				om.setTypeName("血压");
				omds.add(om);
			}else if("2".equals(om.getEventtype())){
				Obsr obsr = bloodSugarService.selectBloodSugarByEventId(om.getEventid());
				om.setMeasureTime(obsr.getTesttime());
				om.setTypeName("血糖");
				omds.add(om);
			}else if("3".equals(om.getEventtype())){
				Oppg oppg = pulseService.selectElectrocardioPulseByEventId(om.getEventid());
				om.setMeasureTime(oppg.getMeasuretime());
				om.setTypeName("三合一");
				omds.add(om);
			}else{
				Oecg oecg = electrocardioService.selectElectrocardioByEventId(om.getEventid());
				om.setMeasureTime(oecg.getMeastime());
				om.setTypeName("动态心电");
				omds.add(om);
			}
			i++;
			
			if(i>= 20){
				break;
			}
		}
		
		return omds;
	}

	@Override
	public List<Omds> getOmdsByGUIDAndEnventType(String memberGUID,String eventType,Page<Omds> page) {
		Map<String, Object> parammap = new HashMap<String,Object>();
		parammap.put("memberGUID", memberGUID);
		parammap.put("eventType", Integer.parseInt(eventType));
		return omdsMapper.getOmdsByGUIDAndEnventType(page,parammap);
	}
	/**
	 * StatusCode 0:上传成功 7：上传失败
	 */
	@Override
	public void insertBloodPressure(OmdsExtend<Osbp> omdsEventOsbp) {
		Member member = memberService.selectByUUID(omdsEventOsbp.getMemberGUID(), null);
		if (omdsEventOsbp!=null) {
			OsbpExample example = new OsbpExample();
    		example.createCriteria().andMemberidEqualTo(member.getMemberid()).andTesttimeEqualTo(omdsEventOsbp.getMeasureTime()).andDeltagEqualTo("0");
    		List<Osbp> oldOsbpList = bloodPressureService.selectByExample(example);
    		if(oldOsbpList != null && oldOsbpList.size() >0){
				return;
    		}
			omdsMapper.insert(omdsEventOsbp);
			Osbp osbp = omdsEventOsbp.getData();
			osbp.setDeltag("0");
			osbp.setEventid(omdsEventOsbp.getEventid());
			osbp.setMemberid(member.getMemberid());
			bloodPressureService.saveOsbp(osbp);
		
	}
		
}

	@Override
	public void insertBloodSugar(OmdsExtend<Obsr> omdsEventObsr) {
		Member member = memberService.selectByUUID(omdsEventObsr.getMemberGUID(), null);
		if (omdsEventObsr!=null) {
			ObsrExample example = new ObsrExample();
    		example.createCriteria().andMemberidEqualTo(member.getMemberid()).andTesttimeEqualTo(omdsEventObsr.getMeasureTime()).andDeltagEqualTo("0");
    		List<Obsr> obsrList = bloodSugarService.selectByExample(example);
    		if(obsrList != null && obsrList.size() >0){
				return;
    		}
			omdsMapper.insert(omdsEventObsr);
			Obsr obsr = omdsEventObsr.getData();
			obsr.setDeltag("0");
			obsr.setEventid(omdsEventObsr.getEventid());
			obsr.setMemberid(member.getMemberid());
			bloodSugarService.saveObsr(obsr);
		}
		
	}

	@Override
	public void insertMiniData(OmdsExtend<MiniData> OmdsExtendMiniData) {
		Member member = memberService.selectByUUID(OmdsExtendMiniData.getMemberGUID(), null);
		if (OmdsExtendMiniData!=null) {
			OecgExample example = new OecgExample();
    		example.createCriteria().andMemberidEqualTo(member.getMemberid()).andDeltagEqualTo("0").andMeastimeEqualTo(OmdsExtendMiniData.getMeasureTime()).andFsEqualTo((short)150);
    		List<Oecg> oecgList = electrocardioService.selectByExample(example);
    		if(oecgList != null && oecgList.size()>0){
				return;
    		}
			omdsMapper.insert(OmdsExtendMiniData);
			Oecg oecg = OmdsExtendMiniData.getData().getOecg();
			oecg.setDeltag("0");
			oecg.setStatustag((short)0);
			oecg.setEventid(OmdsExtendMiniData.getEventid());
			oecg.setMemberid(member.getMemberid());
			electrocardioService.saveOecg(oecg);
			List<Ecg2> ecg2List = OmdsExtendMiniData.getData().getEcg2List();
			for (Ecg2 ecg2: ecg2List ) {
				ecg2.setDocentry(oecg.getDocentry());
				ecg2List.add(ecg2);
				ecg2Service.addEcg2List(ecg2List);
			}
			List<Ecg1> ecg1List = OmdsExtendMiniData.getData().getEcg1List();
			for (Ecg1 ecg1: ecg1List ) {
				ecg1.setDocentry(oecg.getDocentry());
				ecg1List.add(ecg1);
				ecg1Service.addEcg1List(ecg1List);
			}
			List<Ecg3> ecg3List = OmdsExtendMiniData.getData().getEcg3List();
			for (Ecg3 ecg3: ecg3List ) {
				ecg3.setDocentry(oecg.getDocentry());
				ecg3List.add(ecg3);	
				ecg3Service.addEcg3List(ecg3List);
			}
			
		}
	}

	@Override
	public void insertThreeOneData(OmdsExtend<ThreeOneData> threeOneData) {
		Member member = memberService.selectByUUID(threeOneData.getMemberGUID(), null);
		if (threeOneData!=null) {
			OppgExample example = new OppgExample();
    		example.createCriteria().andMemberidEqualTo(member.getMemberid()).andDeltagEqualTo("0").andMeasuretimeEqualTo(threeOneData.getMeasureTime());
    		List<Oppg> oppgList = pulseService.selectByExample(example);
    		if(oppgList != null && oppgList.size()>0){
				return;
    		}
			omdsMapper.insert(threeOneData);
			Oppg oppg = threeOneData.getData().getOppg();
			oppg.setDeltag("0");
			oppg.setStatustag((short)0);
			oppg.setMemberid(member.getMemberid());
			pulseService.insert(oppg);
			
			Oecg oecg = threeOneData.getData().getOecg();
			oecg.setDeltag("0");
			oecg.setStatustag((short)0);
			oecg.setEventid(threeOneData.getEventid());
			electrocardioService.saveOecg(oecg);
			
			List<Ecg2> ecg2List = threeOneData.getData().getEcg2List();
			for (Ecg2 ecg2: ecg2List ) {
				ecg2.setDocentry(oecg.getDocentry());
				ecg2List.add(ecg2);
				ecg2Service.addEcg2List(ecg2List);
			}
			List<Ecg1> ecg1List = threeOneData.getData().getEcg1List();
			for (Ecg1 ecg1: ecg1List ) {
				ecg1.setDocentry(oecg.getDocentry());
				ecg1List.add(ecg1);
				ecg1Service.addEcg1List(ecg1List);
			}
			List<Ecg3> ecg3List = threeOneData.getData().getEcg3List();
			for (Ecg3 ecg3: ecg3List ) {
				ecg3.setDocentry(oecg.getDocentry());
				ecg3List.add(ecg3);	
				ecg3Service.addEcg3List(ecg3List);
			}
		}
	}

}

