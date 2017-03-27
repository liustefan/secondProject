 
/**
 * @PackageName:      com.bithealth.measureCore.bloodSugar.service
 * @FileName:     BloodSugarService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月5日 上午9:40:21  
 * 
 */

package com.bithealth.measureCore.bloodSugar.service;

import java.util.Date;
import java.util.List;

import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.model.ObsrChart;
import com.bithealth.measureCore.bloodSugar.model.ObsrExample;
import com.bithealth.measureCore.bloodSugar.model.ObsrOmemVO;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;


/**
 * 类名称: BloodSugarService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月5日 上午9:40:21 
 * 
 * @author 陈哲
 * @version  
 */
public interface BloodSugarService extends GenericBaseService<Obsr,ObsrExample,Long>{
	Page<ObsrOmemVO> selectBloodSugarAndMemListPage(int pageNo, int pageSize, String criteria, Integer docid, String wheAbnTag);
	
	List<Obsr> selectBloodSugarByMemberId(Integer memberId);
	
	Page<Obsr> selectBloodSugarAndPage(Integer memberId, int pageNo, int pageSize, Date startTime, Date endTime, String timePeriod);
	
	List<Obsr> selectBloodSugarMaxValue(Integer memberId, Date startTime, Date endTime, String timePeriod);
	
	List<Obsr> selectBloodSugarMinValue(Integer memberId, Date startTime, Date endTime, String timePeriod);
	
	Obsr selectBloodSugarOneByDocentry(Long docentry);
	
	void deleteBloodSugarByDocentry(Long docentry);
	
	void deleteBatchBloodSugarByDocentry(List<Long> docentrys);
	
	Omds selectMeasureRecordLastOneByObsr(Integer memberId);
	
	List<Omds> selectMeasureRecordListByObsr(Integer memberId);
	
	List<ObsrChart> selectBloodSugarDistriChartData(Integer memberId, int reportNo);
	
	List<ObsrChart> selectBloodSugarDistriChartData(List<Obsr> obsrs);
	
	List<ObsrChart> selectBloodSugarDistriBoxChartData(Integer memberId, int reportNo);
	
	List<ObsrChart> selectBloodSugarDistriBoxChartData(List<Obsr> obsrs);
	
	List<ObsrChart> selectBloodSugarMaxAndMinTrendChartData(Integer memberId, int reportNo);
	
	List<ObsrChart> selectBloodSugarMaxAndMinTrendChartData(List<Obsr> obsrs);
	
	List<ObsrChart> selectBloodSugarTimeQPieChartData(Integer memberId, int reportNo);
	
	List<ObsrChart> selectBloodSugarTimeQPieChartData(List<Obsr> obsrs);
	
	List<ObsrChart> selectBloodSugarMeasTrendsChartData(Integer memberId, int reportNo);
	
	List<ObsrChart> selectBloodSugarMeasTrendsChartData(List<Obsr> obsrs);
	
	Obsr selectBloodSugarByEventId(Long eventId);
	
	/*Long generateDocentry();*/
	
	void saveObsr(Obsr obsr);
	
	Obsr selectLastestObsrByMemidAndTimeperiods(Integer memberId, List<String> timePeriods);
	
	Integer selectBloodSugarMeasTotalCount(Integer memberId, Date date1, Date date2);
	
	Integer selectBloodSugarMeasExcCount(Integer memberId, Date date1, Date date2);
	
	/**
	 * @Title:selectBloodSugarByGUID 
	 * @Description:根据会员GUID获取血糖数据 
	 * @author 谢美团
	 * @param memberGUID
	 * @param page
	 * @return 
	 * @throws
	 * @retrun List<Obsr>
	 */ 
	List<Obsr> selectBloodSugarByGUID(String memberGUID,Page<Obsr> page);
	
	//批量保存血糖数据
	
	

}

