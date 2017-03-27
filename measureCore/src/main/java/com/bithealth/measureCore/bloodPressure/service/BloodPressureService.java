package com.bithealth.measureCore.bloodPressure.service;

import java.util.Date;
import java.util.List;

import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpChart;
import com.bithealth.measureCore.bloodPressure.model.OsbpExample;
import com.bithealth.measureCore.bloodPressure.model.OsbpOmemVO;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;


/**
 * 
 * 类名称: BloodPressureService  
 * 功能描述: TODO 血压测量service接口  
 * 增加/修改原 因: TODO  
 * 日期: 2016年6月29日 下午10:58:33 
 * 
 * @author 陈哲
 * @version
 */

public interface BloodPressureService extends GenericBaseService<Osbp,OsbpExample,Long>{
	Page<OsbpOmemVO> selectBloodPresAndMemListPage(int pageNo, int pageSize, String criteria, Integer docid, String wheAbnTag);
	
	List<Osbp> selectBloodPresListByMemberId(Integer memberId);
	
	Osbp selectBloodPresOneByDocentry(Long docentry);
	
	Page<Osbp> selectBloodPressAndPage(Integer memberId, int pageNo, int pageSize, Date startTime, Date endTime);
	
	void deleteBloodPresByDocentry(Long docentry);
	
	void deleteBatchBloodPressByDocentry(List<Long> docentrys);
	 
	List<OsbpChart> selectBloodPresPieChartData(Integer memberId, int reportNo);
	
	List<OsbpChart> selectBloodPresPieChartData(List<Osbp> osbps);
	
	List<OsbpChart> selectBloodPresSubPieChartData(Integer memberId, int reportNo);
	
	List<OsbpChart> selectBloodPresSubPieChartData(List<Osbp> osbps);
	
	List<OsbpChart> selectBloodPresScaChartData(Integer memberId, int reportNo);
	
	List<OsbpChart> selectBloodPresScaChartData(List<Osbp> osbps);
	
	List<OsbpChart> selectBloodPresTrendMeasChartData(Integer memberId, int reportNo);
	
	List<OsbpChart> selectBloodPresTrendMeasChartData(List<Osbp> osbps);
	
	List<OsbpChart> selectBloodPresAfterbedTrendChartData(Integer memberId, int reportNo);
	
	List<OsbpChart> selectBloodPresAfterbedTrendChartData(List<Osbp> osbps);
	
	List<OsbpChart> selectBloodPresTrendBeforebedChartData(Integer memberId, int reportNo);
	
	List<OsbpChart> selectBloodPresTrendBeforebedChartData(List<Osbp> osbps);
	
	List<Omds> selectMeasureRecordByBloodPress(Integer memberId);
	
	Omds selectLastMeasureRecordByBloodPress(Integer memberId);
	
	Osbp selectBloodPressByEventId(Long eventId);
	
	/*Long generateDocentry();*/
	
	void saveOsbp(Osbp osbp);
	
	Integer selectBloodPressMeasTotalCount(Integer memberId, Date date1, Date date2);
	
	Integer selectBloodPressMeasExcCount(Integer memberId, Date date1, Date date2);
	
	
	/**
	 * @Title:selectBloodPresListByGUID 
	 * @Description:通过GUID查询血压 
	 * @author 谢美团
	 * @param memberGUID
	 * @return 
	 * @throws
	 * @retrun List<Osbp>
	 */ 
	List<Osbp> selectBloodPresListByGUID(String memberGUID,Page<Osbp> page);
	

}
