package com.bithealth.measureCore.bloodPressure.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.measureCore.bloodPressure.dao.MultiOsbpMapper;
import com.bithealth.measureCore.bloodPressure.dao.OsbpMapper;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpChart;
import com.bithealth.measureCore.bloodPressure.model.OsbpExample;
import com.bithealth.measureCore.bloodPressure.model.OsbpExample.Criteria;
import com.bithealth.measureCore.bloodPressure.model.OsbpOmemVO;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 
 * 类名称: BloodPressureServiceImpl  
 * 功能描述: TODO 血压测量service实现 
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月29日 下午10:59:00 
 * 
 * @author 陈哲
 * @version
 */

@Service
public class BloodPressureServiceImpl extends GenericBaseServiceImpl<Osbp,OsbpExample,Long>
	implements BloodPressureService{
	
	@Autowired
	private OsbpMapper osbpMapper;
	
	@Autowired
	private MultiOsbpMapper multiOsbpMapper;
	
	/** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
     */
	@Override
	public GenericBaseDao<Osbp, OsbpExample, Long> getDao() {
		
		return osbpMapper;
	}

	/** 
	     * @Title: send 
	     * @Description: TODO 血压以及会员信息查询，并翻页.
	     * @param  wheAbnTag： 0表示正常，1表示异常
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectOsbpListByPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.measureCore.bloodPressure.model.OsbpOmemVO)
	     */
	public Page<OsbpOmemVO> selectBloodPresAndMemListPage(int pageNo, int pageSize, String criteria, Integer docid, String wheAbnTag) {
		Page<OsbpOmemVO> page = new Page<OsbpOmemVO>(pageNo, pageSize);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("docId", docid);
		if(criteria != null && !"".equals(criteria.trim())){
			param.put("criteria", "%"+criteria.trim()+"%");
		}
		param.put("wheAbnTag", wheAbnTag);
		
		 multiOsbpMapper.selectOsbpListAndPage(page, param);
		 
		 return page;
	}


	/** 
	     * @Title: send 
	     * @Description: 通过memberId查找osbp血压信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectBloodPresListByMemberId(java.lang.Integer)
	     */
	public List<Osbp> selectBloodPresListByMemberId(Integer memberId) {
		OsbpExample osbpExample = new OsbpExample();
		Criteria criteria = osbpExample.createCriteria();
		criteria.andMemberidEqualTo(memberId);
		criteria.andDeltagEqualTo("0");
		osbpExample.setOrderByClause("EventId desc");
		return osbpMapper.selectByExample(osbpExample);
	}
	

	/** 
	     * @Title: send 
	     * @Description: TODO 通过查询某一会员在某时间段的血压信息，并分页
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectBloodPressAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.measureCore.bloodPressure.model.OsbpExample)
	     */
	public Page<Osbp> selectBloodPressAndPage(Integer memberId, int pageNo, int pageSize, Date startTime, Date endTime) {
		OsbpExample example = new OsbpExample();
		Criteria criteria = example.createCriteria();
		criteria.andMemberidEqualTo(memberId);
	
		if(startTime != null && endTime != null){
			criteria.andTesttimeBetween(startTime, endTime);
		}else if(startTime != null && endTime == null){
			criteria.andTesttimeGreaterThanOrEqualTo(startTime);
		}else if(startTime == null && endTime != null){
			criteria.andTesttimeLessThanOrEqualTo(endTime);
		}
		
		criteria.andDeltagEqualTo("0");
		
		example.setOrderByClause("TestTime desc");
		Page<Osbp> page = new Page<Osbp>(pageNo, pageSize);
		
		osbpMapper.selectByExampleAndPage(page, example);
		return page;
	}


	/** 
	     * @Title: send 
	     * @Description: TODO 通过docentry查询血压信息.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectBloodPresOneByDocentry(java.lang.Long)
	     */
	public Osbp selectBloodPresOneByDocentry(Long docentry) {
		return osbpMapper.selectByPrimaryKey(docentry);
	}
	
	/** 
     * @Title: send 
     * @Description: TODO 通过docentry逻辑删除osbp血压信息
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#updateOsbp(java.lang.Long)
     */
	public void deleteBloodPresByDocentry(Long docentry) {
		Osbp osbp = new Osbp();
		osbp.setDeltag("1");
		osbp.setDocentry(docentry);
		osbpMapper.updateByPrimaryKeySelective(osbp);
	}
	
	
	/**
	 * @Title:deleteBatchBloodPressByDocentry 
	 * @Description:批量逻辑删除osbp血压信息 
	 * @author 陈哲
	 * @param docentrys 
	 * @throws
	 * @retrun void
	 */
	public void deleteBatchBloodPressByDocentry(List<Long> docentrys){
		Osbp osbp = new Osbp();
		osbp.setDeltag("1");
		
		OsbpExample example = new OsbpExample();
		Criteria criteria = example.createCriteria();
		criteria.andDocentryIn(docentrys);
		
		osbpMapper.updateByExampleSelective(osbp, example);
	}

	/** 
	     * @Title: send 
	     * @Description: 血压饼状图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectBloodPresPieChartData(java.lang.Integer, int)
	     */
	public List<OsbpChart> selectBloodPresPieChartData(Integer memberId,
			int reportNo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiOsbpMapper.selectOsbpPieChart(param);
	}
	
	public List<OsbpChart> selectBloodPresPieChartData(List<Osbp> osbps) {
		List<Long> list = new ArrayList<Long>();
		for(Osbp osbp : osbps){
			list.add(osbp.getDocentry());
		}
		
		return multiOsbpMapper.selectOsbpPieChart1(list);
	}

	/** 
	     * @Title: send 
	     * @Description: 血压饼状图（四个小图）数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectBloodPresSubPieChartData(java.lang.Integer, int)
	     */
	public List<OsbpChart> selectBloodPresSubPieChartData(Integer memberId,
			int reportNo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiOsbpMapper.selectOsbpSubPieChart(param);
	}
	
	public List<OsbpChart> selectBloodPresSubPieChartData(List<Osbp> osbps){
		List<Long> list = new ArrayList<Long>();
		for(Osbp osbp : osbps){
			list.add(osbp.getDocentry());
		}
		
		return multiOsbpMapper.selectOsbpSubPieChart1(list);
	}

	/** 
	     * @Title: send 
	     * @Description: 24小时血压分布图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectBloodPresScaChartData(java.lang.Integer, int)
	     */
	public List<OsbpChart> selectBloodPresScaChartData(Integer memberId,
			int reportNo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiOsbpMapper.selectOsbpScachart(param);
	}
	
	public List<OsbpChart> selectBloodPresScaChartData(List<Osbp> osbps) {
		List<Long> list = new ArrayList<Long>();
		for(Osbp osbp : osbps){
			list.add(osbp.getDocentry());
		}
		
		return multiOsbpMapper.selectOsbpScachart1(list);
	}

	/** 
	     * @Title: send 
	     * @Description: 血压趋势图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectBloodPresTrendMeasChartData(java.lang.Integer, int)
	     */
	public List<OsbpChart> selectBloodPresTrendMeasChartData(Integer memberId,
			int reportNo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiOsbpMapper.selectOsbpTrendChart(param);
	}
	
	public List<OsbpChart> selectBloodPresTrendMeasChartData(List<Osbp> osbps) {
		List<Long> list = new ArrayList<Long>();
		for(Osbp osbp : osbps){
			list.add(osbp.getDocentry());
		}
		
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("list", list);
		
		return multiOsbpMapper.selectOsbpTrendChart1(param);
	}

	/** 
	     * @Title: send 
	     * @Description: TODO 起床后血压趋势图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectBloodPresAfterbedTrendChartData(java.lang.Integer, int)
	     */
	public List<OsbpChart> selectBloodPresAfterbedTrendChartData(Integer memberId,
			int reportNo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		param.put("timePeriod", "1");
		
		return multiOsbpMapper.selectOsbpTrendChart(param);
	}
	
	public List<OsbpChart> selectBloodPresAfterbedTrendChartData(List<Osbp> osbps) {
		Map<String,Object> param = new HashMap<String, Object>();
		
		List<Long> list = new ArrayList<Long>();
		for(Osbp osbp : osbps){
			list.add(osbp.getDocentry());
		}
		
		param.put("list", list);
		param.put("timePeriod", "1");
		
		return multiOsbpMapper.selectOsbpTrendChart1(param);
	}

	/** 
	     * @Title: send 
	     * @Description: TODO 起床前血压趋势图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectBloodPresTrendBeforebedChartData(java.lang.Integer, int)
	     */
	public List<OsbpChart> selectBloodPresTrendBeforebedChartData(Integer memberId,
			int reportNo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		param.put("timePeriod", "2");
		
		return multiOsbpMapper.selectOsbpTrendChart(param);
	}
	
	
	
	public List<OsbpChart> selectBloodPresTrendBeforebedChartData(List<Osbp> osbps) {
		Map<String,Object> param = new HashMap<String, Object>();

		List<Long> list = new ArrayList<Long>();
		for(Osbp osbp : osbps){
			list.add(osbp.getDocentry());
		}
		
		param.put("list", list);
		param.put("timePeriod", "2");
		
		return multiOsbpMapper.selectOsbpTrendChart1(param);
	}

	/** 
	     * @Title: send 
	     * @Description: 查找血压记录信息omds
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectMeasureRecordByBloodPress(java.lang.Integer)
	     */
	@Override
	public List<Omds> selectMeasureRecordByBloodPress(Integer memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		return multiOsbpMapper.selectOmdsByOsbp(param);
	}
	
	/**
	     * @Title: send 
	     * @Description: 查找最新一条血压测量记录omds
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectLastMeasureRecordByBloodPress(java.lang.Integer)
	 */
	@Override
	public Omds selectLastMeasureRecordByBloodPress(Integer memberId) {
		List<Omds> omdsList = selectMeasureRecordByBloodPress(memberId);
				
		Omds omds = null;
		if(omdsList != null && !omdsList.isEmpty()){
			omds = omdsList.get(0);
		}
		
		return omds;
	}
	
	
	/**
	     * @Title: send 
	     * @Description: 通过事件id查找血压信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectBloodPressByEventId(java.lang.Long)
	 */
	@Override
	public Osbp selectBloodPressByEventId(Long eventId) {
		OsbpExample example = new OsbpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventidEqualTo(eventId);
		List<Osbp> osbps = osbpMapper.selectByExample(example);
		
		Osbp osbp = null;
		if(osbps != null && !osbps.isEmpty()){
			osbp = osbps.get(0);
		}
		return osbp;
	}
	
	/**
	     * @Title: send 
	     * @Description: 新增血压信息，生成docentry主键值
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#generateDocentry()
	 */
	/*public Long generateDocentry() {
		int result = multiOsbpMapper.insertOsbp_docentry();
		
		Long docentry = null;
		if(result == 1){
			docentry = multiOsbpMapper.selectMaxDocentry();
		}
		
		return docentry;
	}*/
	
	/**
	     * @Title: send 
	     * @Description: 保存血压信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#saveOsbp(com.bithealth.measureCore.bloodPressure.model.Osbp)
	 */
	public void saveOsbp(Osbp osbp) {
		osbp.setDeltag("0");
		multiOsbpMapper.insertOsbp(osbp);
	}
	
	/**
	     * @Title: send 
	     * @Description: 统计某一时间段上的血压总数量
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectBloodPressMeasTotalCount(java.lang.Integer, java.util.Date, java.util.Date)
	 */
	public Integer selectBloodPressMeasTotalCount(Integer memberId, Date date1, Date date2){
		OsbpExample example = new OsbpExample();
		Criteria criteria = example.createCriteria();
		criteria.andMemberidEqualTo(memberId);
		criteria.andTesttimeBetween(date1, date2);
		criteria.andDeltagEqualTo("0");

		return osbpMapper.countByExample(example);
	}
	
	/**
	     * @Title: send 
	     * @Description:统计某一时间段的血压异常数量
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.bloodPressure.service.BloodPressureService#selectBloodPressMeasExcCount(java.lang.Integer, java.util.Date, java.util.Date)
	 */
	public Integer selectBloodPressMeasExcCount(Integer memberId, Date date1, Date date2){
		OsbpExample example = new OsbpExample();
		Criteria criteria = example.createCriteria();
		criteria.andMemberidEqualTo(memberId);
		criteria.andTesttimeBetween(date1, date2);
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		criteria.andAbnormalIn(list);
		
		criteria.andDeltagEqualTo("0");

		return osbpMapper.countByExample(example);
	}

	@Override
	public List<Osbp> selectBloodPresListByGUID(String memberGUID,Page<Osbp> page) {
		return osbpMapper.selectBloodPresListByGUID(memberGUID, page);
	}
}
