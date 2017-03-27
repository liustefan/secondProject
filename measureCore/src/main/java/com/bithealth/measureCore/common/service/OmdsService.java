 
/**
 * @PackageName:      com.bithealth.measureCore.common.service
 * @FileName:     OmdsService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月20日 上午11:39:16  
 * 
 */

package com.bithealth.measureCore.common.service;

import java.util.List;
import java.util.Map;

import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.common.model.MiniData;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.common.model.OmdsEvent;
import com.bithealth.measureCore.common.model.OmdsExample;
import com.bithealth.measureCore.common.model.OmdsExtend;
import com.bithealth.measureCore.common.model.ThreeOneData;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;


/**
 * 类名称: OmdsService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月20日 上午11:39:16 
 * 
 * @author 陈哲
 * @version  
 */
public interface OmdsService extends GenericBaseService<Omds, OmdsExample, Long>{
	Long generateEventId();
	
	int saveOmds(Omds omds);
	
	Omds selectOmdsByEventId(Long eventId);
	
	void updateWheAbnTagOfOmdsByEventid(Long eventId, String wheAbnTag);

	void updateStatusTagOfOmdsByEventid(Long eventId, Integer statusTag);
	
	Map<String, List<Map<String, Object>>> findAllMeasureRecordByParam(Integer memberId, 
			Integer eventType, Integer isAbnormal, String startTime, String endTime,
			Integer pageNo, Integer pageSize);
	
	public List<Omds> getLastestMeasList(Integer userId, Integer orgId);
	
	
	/**
	 * @Title:getOmdsByGUIDAndEnventType 
	 * @Description:根据GUID 和类型获取omds 数据
	 * @author 谢美团
	 * @return 
	 * @throws
	 * @retrun List<Omds>
	 */ 
	public List<Omds> getOmdsByGUIDAndEnventType(String memberGUID,String enventType,Page<Omds> page);
	
	
	//批量插入血压数据
	public void insertBloodPressure(OmdsExtend<Osbp> omdsEventOsbp);
	
	//批量插入血糖数据
	public void insertBloodSugar(OmdsExtend<Obsr> omdsEventObsr);
		
	//批量插入心电数据
	public void insertMiniData(OmdsExtend<MiniData> OmdsExtendMiniData);
		
	//批量插入三合一数据
	public void insertThreeOneData(OmdsExtend<ThreeOneData> threeOneData);
		
}

