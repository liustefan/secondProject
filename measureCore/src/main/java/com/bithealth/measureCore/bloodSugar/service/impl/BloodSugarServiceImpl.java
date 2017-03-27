 
/**
 * @PackageName:      com.bithealth.measureCore.bloodSugar.service.impl
 * @FileName:     BloodSugarServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月5日 上午9:40:49  
 * 
 */

package com.bithealth.measureCore.bloodSugar.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.measureCore.bloodSugar.dao.MultiObsrMapper;
import com.bithealth.measureCore.bloodSugar.dao.ObsrMapper;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.model.ObsrChart;
import com.bithealth.measureCore.bloodSugar.model.ObsrExample;
import com.bithealth.measureCore.bloodSugar.model.ObsrExample.Criteria;
import com.bithealth.measureCore.bloodSugar.model.ObsrOmemVO;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarService;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: BloodSugarServiceImpl  
 * 功能描述: 血糖接口实现
 * 增加/修改原 因: ADD REASON(可选).  
 * 日期: 2016年7月5日 上午9:40:49 
 * 
 * @author 陈哲
 * @version  
 */
@Service
public class BloodSugarServiceImpl extends GenericBaseServiceImpl<Obsr,ObsrExample,Long> implements BloodSugarService{
	
	@Autowired
	private ObsrMapper obsrMapper;
	
	@Autowired
	private MultiObsrMapper multiObsrMapper;
	
	
	/** 
	     * @Title: send 
	     * @Description:  简单描述该方法的实现功能（可选）.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
	     */
	@Override
	public GenericBaseDao<Obsr, ObsrExample, Long> getDao() {
		
		return obsrMapper;
	}

	/** 
	     * @Title: send 
	     * @Description: 血糖以及会员信息查询，并翻页
	     * @param  wheAbnTag： 0表示正常，1表示异常
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarAndMemListPage(int, int, java.lang.String, java.lang.Integer, java.lang.String)
	     */
	public Page<ObsrOmemVO> selectBloodSugarAndMemListPage(int pageNo,
			int pageSize, String criteria, Integer docid, String wheAbnTag) {
		Page<ObsrOmemVO> page = new Page<ObsrOmemVO>(pageNo, pageSize);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("docId", docid);
		if(criteria != null && !"".equals(criteria.trim())){
			param.put("criteria", "%"+criteria.trim()+"%");
		}
		param.put("wheAbnTag", wheAbnTag);
		
		multiObsrMapper.selectObsrListAndPage(page, param);
		return page;
	}

	/** 
	     * @Title: send 
	     * @Description: 通过会员id查找血糖obsr信息.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarByMemberId(java.lang.Integer)
	     */
	public List<Obsr> selectBloodSugarByMemberId(Integer memberId) {
		ObsrExample example = new ObsrExample();
		Criteria criteria = example.createCriteria();
		criteria.andMemberidEqualTo(memberId);
		criteria.andDeltagEqualTo("0");
		example.setOrderByClause("EventId");
		return obsrMapper.selectByExample(example);
	}

	/** 
	     * @Title: send 
	     * @Description: 通过测量时间、测量时间点来查询血糖信息并分页
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarAndPage(java.lang.Integer, int, int, java.util.Date, java.util.Date, java.lang.String)
	     */
	public Page<Obsr> selectBloodSugarAndPage(Integer memberId, int pageNo,
			int pageSize, Date startTime, Date endTime, String timePeriod) {
		ObsrExample example = new ObsrExample();
		Criteria criteria = example.createCriteria();
		criteria.andMemberidEqualTo(memberId);
		
		if(startTime != null && endTime != null){
			criteria.andTesttimeBetween(startTime, endTime);
		}else if(startTime != null && endTime == null){
			criteria.andTesttimeGreaterThanOrEqualTo(startTime);
		}else if(startTime == null && endTime != null){
			criteria.andTesttimeLessThanOrEqualTo(endTime);
		}
		
		if(timePeriod != null && !"".equals(timePeriod)){
			criteria.andTimeperiodEqualTo(timePeriod);
		}
		
		criteria.andDeltagEqualTo("0");
		
		example.setOrderByClause("TestTime desc, Docentry desc");
		Page<Obsr> page = new Page<Obsr>(pageNo, pageSize);
		
		obsrMapper.selectByExampleAndPage(page, example);
		return page;
	}
	

	/** 
	     * @Title: send 
	     * @Description: 通过docentry逻辑删除血糖信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#deleteBloodSugarByDocentry(java.lang.Long)
	     */
	public void deleteBloodSugarByDocentry(Long docentry) {
		Obsr obsr = new Obsr();
		obsr.setDeltag("1");
		obsr.setDocentry(docentry);
		obsrMapper.updateByPrimaryKeySelective(obsr);
	}

	/**
	 * @Title:deleteBatchBloodSugarByDocentry 
	 * @Description:批量删除血糖信息
	 * @author 陈哲
	 * @param docentrys 
	 * @throws
	 * @retrun void
	 */
	public void deleteBatchBloodSugarByDocentry(List<Long> docentrys) {
		Obsr obsr = new Obsr();
		obsr.setDeltag("1");
		
		ObsrExample example = new ObsrExample();
		Criteria criteria = example.createCriteria();
		criteria.andDocentryIn(docentrys);
		
		obsrMapper.updateByExampleSelective(obsr, example);
	}
	
	/** 
	     * @Title: send 
	     * @Description: 通过会员id、时间点、时间段等条件查找最大值的血糖信息.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectMaxValueObsrInfo(java.lang.Integer, java.util.Date, java.util.Date, java.lang.String)
	     */
	public List<Obsr> selectBloodSugarMaxValue(Integer memberId, Date startTime,
			Date endTime, String timePeriod) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		param.put("timePeriod", timePeriod);
		param.put("delTag", "0");
		
		return multiObsrMapper.selectMaxObsrList(param);
	}

	/** 
	     * @Title: send 
	     * @Description: 通过会员id、时间点、时间段等条件查找最大值的血糖信息）.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarMinValue(java.lang.Integer, java.util.Date, java.util.Date, java.lang.String)
	     */
	public List<Obsr> selectBloodSugarMinValue(Integer memberId,
			Date startTime, Date endTime, String timePeriod) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		param.put("timePeriod", timePeriod);
		param.put("delTag", "0");
		
		return multiObsrMapper.selectMinObsrList(param);
	}

	/** 
	     * @Title: send 
	     * @Description: 通过docentry查找血糖信息.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarOneByDocentry(java.lang.Long)
	     */
	public Obsr selectBloodSugarOneByDocentry(Long docentry) {
		
		return obsrMapper.selectByPrimaryKey(docentry);
	}

	/** 
	     * @Title: send 
	     * @Description: 通过会员id查找血糖记录
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectMeasureRecordListByObsr(java.util.Map)
	     */
	public Omds selectMeasureRecordLastOneByObsr(Integer memberId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("delTag", "0");
		return multiObsrMapper.selectOmdsLastOnebyObsr(param);
	}

	/** 
	     * @Title: send 
	     * @Description: 通过会员id查找血糖测量记录，并分页
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectMeasureRecordListAndPageByObsr(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.util.Map)
	     */
	public List<Omds> selectMeasureRecordListByObsr(Integer memberId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("delTag", "0");
		
		return multiObsrMapper.selectOmdsListbyObsr(param);
	}
	
	/**
	 * @Title:selectLastestObsr 
	 * @Description:根据会员id和多个时间段查询血糖的最新一条记录
	 * @author 陈哲
	 * @param memberId
	 * @param timePeriods
	 * @return 
	 * @throws
	 * @retrun Obsr
	 */
	public Obsr selectLastestObsrByMemidAndTimeperiods(Integer memberId, List<String> timePeriods){
		ObsrExample example = new ObsrExample();
		example.setOrderByClause("TestTime DESC");
		Criteria criteria = example.createCriteria();
		criteria.andMemberidEqualTo(memberId);
		criteria.andTimeperiodIn(timePeriods);
		
		List<Obsr> obsrs = obsrMapper.selectByExample(example);
		Obsr obsr = null;
		if(obsrs != null && !obsrs.isEmpty()){
			obsr = obsrs.get(0);
		}
		return obsr;
	}

	/** 
	     * @Title: send 
	     * @Description: 血糖分布图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarDistriChartData(java.lang.Integer, int)
	     */
	public List<ObsrChart> selectBloodSugarDistriChartData(Integer memberId,
			int reportNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiObsrMapper.selectObsrDistriChart(param);
	}
	
	public List<ObsrChart> selectBloodSugarDistriChartData(List<Obsr> obsrs) {
		List<Long> list = new ArrayList<Long>();
		for(Obsr obsr : obsrs){
			list.add(obsr.getDocentry());
		}
		
		return multiObsrMapper.selectObsrDistriChart1(list);
	}

	/** 
	     * @Title: send 
	     * @Description: 血糖分布盒图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarDistriBoxChartData(java.lang.Integer, int)
	     */
	public List<ObsrChart> selectBloodSugarDistriBoxChartData(Integer memberId,
			int reportNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiObsrMapper.selectObsrDistriBoxChart(param);
	}
	
	public List<ObsrChart> selectBloodSugarDistriBoxChartData(List<Obsr> obsrs) {
		List<Long> list = new ArrayList<Long>();
		for(Obsr obsr : obsrs){
			list.add(obsr.getDocentry());
		}
		
		return multiObsrMapper.selectObsrDistriBoxChart1(list);
	}

	/** 
	     * @Title: send 
	     * @Description: 血糖最大值和最小时趋势图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarMaxAndMinTrendChartData(java.lang.Integer, int)
	     */
	public List<ObsrChart> selectBloodSugarMaxAndMinTrendChartData(
			Integer memberId, int reportNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiObsrMapper.selectObsrMaxAndMinTrendChart(param);
	}
	
	
	public List<ObsrChart> selectBloodSugarMaxAndMinTrendChartData(List<Obsr> obsrs) {
		List<Long> list = new ArrayList<Long>();
		for(Obsr obsr : obsrs){
			list.add(obsr.getDocentry());
		}
		
		return multiObsrMapper.selectObsrMaxAndMinTrendChart1(list);
	}

	/** 
	     * @Title: send 
	     * @Description: 血糖饼图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarTimeQPieChartData(java.lang.Integer, int)
	     */
	public List<ObsrChart> selectBloodSugarTimeQPieChartData(Integer memberId,
			int reportNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiObsrMapper.selectObsrTimeQPieChart(param);
	}
	
	public List<ObsrChart> selectBloodSugarTimeQPieChartData(List<Obsr> obsrs) {
		List<Long> list = new ArrayList<Long>();
		for(Obsr obsr : obsrs){
			list.add(obsr.getDocentry());
		}
		
		return multiObsrMapper.selectObsrTimeQPieChart1(list);
	}

	/** 
	     * @Title: send 
	     * @Description: 血糖测量趋势图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarMeasTrendsChartData(java.lang.Integer, int)
	     */
	public List<ObsrChart> selectBloodSugarMeasTrendsChartData(
			Integer memberId, int reportNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiObsrMapper.selectObsrMeasTrendsChart(param);
	}
	
	public List<ObsrChart> selectBloodSugarMeasTrendsChartData(List<Obsr> obsrs) {
		List<Long> list = new ArrayList<Long>();
		for(Obsr obsr : obsrs){
			list.add(obsr.getDocentry());
		}
		
		return multiObsrMapper.selectObsrMeasTrendsChart1(list);
	}
	
	
	/**
	     * @Title: send 
	     * @Description: 通过事件id查找血糖信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarByEventId(java.lang.Long)
	 */
	@Override
	public Obsr selectBloodSugarByEventId(Long eventId) {
		ObsrExample example = new ObsrExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventidEqualTo(eventId);
		List<Obsr> obsrs = obsrMapper.selectByExample(example);
		
		Obsr obsr = null;
		if(obsrs != null && !obsrs.isEmpty()){
			obsr = obsrs.get(0);
		}
		return obsr;
	}
	
	/**
	     * @Title: send 
	     * @Description: 新增血糖，生成docentry主键值
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#generateDocentry()
	 */
	/*public Long generateDocentry() {
		int result = multiObsrMapper.insertObsr_docentry();
		
		Long docentry = null;
		if(result == 1){
			docentry = multiObsrMapper.selectMaxDocentry();
		}
		
		return docentry;
	}*/
	
	/**
	     * @Title: send 
	     * @Description: 保存血糖信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#saveObsr(com.bithealth.measureCore.bloodSugar.model.Obsr)
	 */
	public void saveObsr(Obsr obsr) {
		obsr.setDeltag("0");
		multiObsrMapper.insertObsr(obsr);
	}
	
	/**
	     * @Title: send 
	     * @Description: 统计某一时间段上的血糖测量数量
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarMeasTotalCount(java.lang.Integer, java.util.Date, java.util.Date)
	 */
	public Integer selectBloodSugarMeasTotalCount(Integer memberId, Date date1, Date date2){
		ObsrExample example = new ObsrExample();
		Criteria criteria = example.createCriteria();
		criteria.andMemberidEqualTo(memberId);
		criteria.andTesttimeBetween(date1, date2);
		criteria.andDeltagEqualTo("0");
		
		return obsrMapper.countByExample(example);
	}
	
	/**
	     * @Title: send 
	     * @Description: 统计某一时间段上的血糖测量异常数量
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarService#selectBloodSugarMeasExcCount(java.lang.Integer, java.util.Date, java.util.Date)
	 */
	public Integer selectBloodSugarMeasExcCount(Integer memberId, Date date1, Date date2){
		ObsrExample example = new ObsrExample();
		Criteria criteria = example.createCriteria();
		criteria.andMemberidEqualTo(memberId);
		criteria.andTesttimeBetween(date1, date2);
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		criteria.andAnalysisresultIn(list);
		criteria.andDeltagEqualTo("0");
		
		return obsrMapper.countByExample(example);
	}

	@Override
	public List<Obsr> selectBloodSugarByGUID(String memberGUID, Page<Obsr> page) {
		return obsrMapper.selectBloodSugarByGUID(memberGUID, page);
	}
}

