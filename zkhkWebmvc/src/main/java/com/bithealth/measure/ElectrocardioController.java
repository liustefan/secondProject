package com.bithealth.measure;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.measureCore.common.model.ImageParam;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.common.service.OmdsService;
import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Ecg3;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExc;
import com.bithealth.measureCore.electrocardio.model.OecgOmemVO;
import com.bithealth.measureCore.electrocardio.service.Ecg1Service;
import com.bithealth.measureCore.electrocardio.service.Ecg2Service;
import com.bithealth.measureCore.electrocardio.service.Ecg3Service;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioExcService;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioFileService;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.enmu.ElectrocardioType;
import com.bithealth.measureCore.facade.Facade;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.printCore.service.ExportWordService;
import com.bithealth.reportCore.facade.constants.Contrants;
import com.bithealth.reportCore.facade.service.ReportIFService;
import com.bithealth.sdk.common.rabbit.ClientSender;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.common.utils.Util;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;

/**
 * 类名称: ElectrocardioController  
 * 功能描述: 动态心电controller层.  
 * 日期: 2016年7月19日 上午10:08:45 
 * 
 * @author 陈哲
 * @version
 */
@Controller
@RequestMapping("/electrocardio")
public class ElectrocardioController extends BaseSpringController{
	
	@Autowired
	private ElectrocardioService electrocardioService;
	
	@Autowired
	private ElectrocardioExcService electrocardioExcService;
	
	@Autowired
	private Ecg1Service ecg1Service;
	
	@Autowired
	private Ecg2Service ecg2Service;
	
	@Autowired
	private Ecg3Service ecg3Service;
	
	@Autowired
	private ElectrocardioFileService electrocardioFileService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;
	
	@Autowired
	private OmdsService omdsService;
	
	@Autowired
	private Facade chartService;
	
	@Autowired
	private ReportIFService reportIFService;
	
	@Autowired
	private ExportWordService exportWordService;
	
	
	/**
	 * @Title:showBloodPressPage 
	 * @Description:测量管理动态心电页面
	 * @author 陈哲
	 * @param model
	 * @param wheAbnTag
	 * @param pageNo
	 * @param pageSize
	 * @param docid
	 * @param criteria
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/queryElectrocardio",method=RequestMethod.GET)
	public String showElectrocardioPage(Model model,String wheAbnTag, Integer pageNo, Integer pageSize, Integer docid, String criteria) {
		//解决中文乱码
		if(criteria != null){
			try {
				criteria = URLDecoder.decode(criteria,"UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
				return "/measure/showMemberOecgMeasureInfoByDocid";
			}
		}
		
		if(pageNo == null){
			pageNo = 1;
		}
		
		if(pageSize == null){
			pageSize = 10;
		}
		Page<OecgOmemVO> page = electrocardioService.selectElectrocardioAndMemListPage(pageNo, pageSize, criteria, docid, wheAbnTag);
		model.addAttribute("page",page);
		model.addAttribute("criteria",criteria);
		model.addAttribute("wheAbnTag",wheAbnTag);
		
		return "/measure/showMemberOecgMeasureInfoByDocid";
	}
	
	/**
	 * @Title:deleteElectrocardioInfo 
	 * @Description:删除单个心电信息
	 * @author 陈哲
	 * @param docentry
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/deleteElectrocardioInfo")
	public String deleteElectrocardioInfo(Long docentry){
		electrocardioService.deleteElectrocardio(docentry);
		
		return "forward:queryElectrocardio";
	}
	
	/**
	 * @Title:deleteBatchElectrocardioInfo 
	 * @Description:批量删除心电信息
	 * @author 陈哲
	 * @param parameter
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/deleteBatchElectrocardioInfo")
	public String deleteBatchElectrocardioInfo(String parameter){
		List<Long> docentryList = new ArrayList<Long>();
		String[] strs = parameter.split(",");
		for(String str : strs){
			docentryList.add(Long.valueOf(str));
		}
		
		electrocardioService.deleteBatchElectrocardio(docentryList);
		
		return "forward:queryElectrocardio";
	}
	
	/**
	 * @Title:showSingleElectrocardio 
	 * @Description:单次测量页面信息
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @param flag
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/showSingleElectrocardio")
	public String showSingleElectrocardio(Model model, Integer memberId, Long docentry, Long eventId, Integer pageNo, Integer flag, String view) {
		if(pageNo == null){
			pageNo = 0;
		}
		
		//动态心电页面有两个入口，分别是会员管理和测量管理，flag用来标记是哪个入口，值为1标识会员管理
		model.addAttribute("flag", flag);
		model.addAttribute("view", view);
		
		Member member = memberService.selectById(memberId);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("omem", member);
		model.addAttribute("age", age);
		model.addAttribute("eventId", eventId);
		
		Oecg oecg = null;
		if("1".equals(view)){
			oecg = electrocardioService.selectElectrocardioByDocentry(docentry);
		}else{
			List<Omds> omdsList = electrocardioService.selectMeasureRecordByElectro(memberId);
			Omds omds = null;
			if(eventId != null){
				pageNo = -1;
				for(Omds om : omdsList){
					pageNo++;
					if(om.getEventid().equals(eventId)){
						omds = om;
						break;
					}
				}
			}else{
				if(omdsList == null || omdsList.isEmpty()){
					return "/measure/singleXinDian";
				}
				omds = omdsList.get(pageNo);
			}
			
			model.addAttribute("pageNo", pageNo);
			model.addAttribute("total", omdsList.size());
			
			if(omds != null){
				oecg = electrocardioService.selectElectrocardioByEventId(omds.getEventid());
			}
		}
		model.addAttribute("oecg", oecg);

		if(oecg != null){
			//获取异常信息
			List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
			List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
			List<OecgExc> oecgExcs = electrocardioExcService.doElectrocardioExcInfo(ecg1s, ecg2s, oecg);
			model.addAttribute("oecgExcs", oecgExcs);
			model.addAttribute("timeLength", formatTimeLength(oecg.getTimelength()));
			
			model.addAttribute("hfd", Util.getSpecificDate(oecg.getMeastime().getTime(), oecg.getFastesttime()));
			model.addAttribute("hsd", Util.getSpecificDate(oecg.getMeastime().getTime(), oecg.getSlowesttime()));
			
			//心电分页，默认分页时长60min
			int totalPage = 1;
			if(oecg.getTimelength() % (60 * 60) == 0){
				totalPage = oecg.getTimelength() / (60 * 60);
			}else{
				totalPage = oecg.getTimelength() / (60 * 60) + 1;
			}
			model.addAttribute("totalPage", totalPage);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Long time = oecg.getMeastime().getTime() + oecg.getTimelength()*1000;
			Date d = new Date(time);
			String endTimeStr = sdf.format(d);
			model.addAttribute("endTimeStr", endTimeStr);
			
			ImageParam param = new ImageParam();
			//瞬时心率
			if (oecg.getRrinterval() != null && !(oecg.getRrinterval().trim()).isEmpty()) {
				param.setFs(oecg.getFs());
				param.setRawImage(oecg.getRrinterval());

				int hrecgPage = electrocardioFileService.getInstantHeartRatePageByParam(param);

				model.addAttribute("hrecgPage", hrecgPage);
			}
		}
		
		return "/measure/singleXinDian";
	}
	
	
	private String formatTimeLength(Integer timeLength){
		int hour = timeLength / 3600;
		int minute = (timeLength % 3600) / 60;
		int second = (timeLength % 3600) % 60; 
		String format = hour+"时"+minute+"分"+second+"秒";
		return format;
	}
	
	/**
	 * @Title:getInstanceHeartRateChartData 
	 * @Description:瞬时心率图数据 
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @param eventId
	 * @param page
	 * @param pageNo
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@ResponseBody
	@RequestMapping(value="getInstanceHeartRateChartData",produces="text/plain;charset=UTF-8")
	public String getInstanceHeartRateChartData(Model model, Integer memberId, Long eventId, Integer page, Integer pageNo){
		Omds omds = getOmdsByCondition (memberId, eventId, pageNo);
		
		if(omds == null){
			return null;
		}
		
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(omds.getEventid());
		
		if(oecg == null){
			return null;
		}
		
		model.addAttribute("oecg", oecg);
		
		ImageParam param = new ImageParam();
		if (oecg.getRrinterval() != null && !(oecg.getRrinterval().trim()).isEmpty()) {
			param.setRawImage(oecg.getRrinterval());
		} 
		
		param.setFs(oecg.getFs());
		param.setWidth(1000);
		param.setHeight(300);
		param.setPage(page);
		param.setMeasureTime(oecg.getMeastime());
		
		int hrecgPage = electrocardioFileService.getInstantHeartRatePageByParam(param);
		
		model.addAttribute("hrecgPage", hrecgPage);
		
		Map<String, Object> map = electrocardioFileService.getInstantHeartRateChartFileData(param);
		
		return JSONObject.toJSONString(map);
	}
	
	
	/**
	 * @Title:getElectrocardioChartData 
	 * @Description:心电图数据
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @param showTimeLength
	 * @param page
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws ParseException 
	 * @throws
	 * @retrun String
	 */
	@ResponseBody
	@RequestMapping(value="/getElectrocardioChartData",produces="text/plain;charset=UTF-8")
	public String getElectrocardioChartData(Model model, Integer memberId, Long eventId, Integer pageNo, Integer showTimeLength, Integer page,
			String startTime, String endTime) throws ParseException {
		Omds omds = getOmdsByCondition (memberId, eventId, pageNo);
		
		if(omds == null){
			return null;
		}
		
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(omds.getEventid());
		ImageParam param = new ImageParam();
		if(oecg != null){
			if (oecg.getRawecgimg() != null && !(oecg.getRawecgimg().trim()).isEmpty()) {
				param.setRawImage(oecg.getRawecgimg());
				oecg.setRawecg(oecg.getRawecgimg());
			} else if (oecg.getRawecg() != null && !(oecg.getRawecg().trim()).isEmpty()) {
				param.setRawImage(oecg.getRawecg());
			}
			
			int totalPage = 1;
			Date measTime = null;
			if(showTimeLength == null){
				showTimeLength = 0;
			}
			
			if((startTime == null || "".equals(startTime)) && (endTime == null || "".equals(endTime))){
				param.setTimeQuery(false);//说明不是以时间查询为条件加载心电
				if(showTimeLength != 0){
					if(oecg.getTimelength() % (showTimeLength * 60) == 0){
						totalPage = oecg.getTimelength() / (showTimeLength * 60);
					}else{
						totalPage = oecg.getTimelength() / (showTimeLength * 60) + 1;
					}
				}

				Long measureTime = oecg.getMeastime().getTime() + showTimeLength*60*1000*(page-1);
				measTime = new Date(measureTime);
			}else{
				param.setTimeQuery(true);//说明是以时间查询为条件加载心电
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				int timeQueryLength = 0;
				if((startTime != null && !"".equals(startTime)) && (endTime != null && !"".equals(endTime))){
					Long measureTimeQuery = sdf.parse(startTime).getTime() + showTimeLength*60*1000*(page-1);
					measTime = new Date(measureTimeQuery);
					
					int startTimeQuery = (int)((sdf.parse(startTime).getTime() - oecg.getMeastime().getTime())/1000);
					param.setStartTimeQueryDis(startTimeQuery);
					timeQueryLength = (int)((sdf.parse(endTime).getTime() - sdf.parse(startTime).getTime())/1000);
					param.setEndTimeQueryDis(timeQueryLength);
				}else if(startTime == null || "".equals(startTime)){
					Long measureTimeQuery = oecg.getMeastime().getTime() + showTimeLength*60*1000*(page-1);
					measTime = new Date(measureTimeQuery);
					
					timeQueryLength = (int)((sdf.parse(endTime).getTime() - oecg.getMeastime().getTime())/1000);
					param.setEndTimeQueryDis(timeQueryLength);
				}else if(endTime == null || "".equals(endTime)){
					Long measureTimeQuery = sdf.parse(startTime).getTime() + showTimeLength*60*1000*(page-1);
					measTime = new Date(measureTimeQuery);
					
					int startTimeQuery = (int)((sdf.parse(startTime).getTime() - oecg.getMeastime().getTime())/1000);
					param.setStartTimeQueryDis(startTimeQuery);
					timeQueryLength = oecg.getTimelength() - startTimeQuery;
					param.setEndTimeQueryDis(timeQueryLength);
				}

				if(timeQueryLength % (showTimeLength*60) == 0){
					totalPage = timeQueryLength / (showTimeLength * 60);
				}else{
					totalPage = timeQueryLength / (showTimeLength * 60) + 1;
				}
			}
			model.addAttribute("totalPage", totalPage);
		
			param.setFs(oecg.getFs());
			param.setWidth(1000);
			param.setHeight(300);
			param.setPage(page);
			param.setMeasureTime(measTime);
			param.setDeviceCode(oecg.getDevicecode());
			param.setShowTimeLength(showTimeLength);
			param.setTotalPage(totalPage);
		}
		
		Map<String, Object> map = electrocardioFileService.getElectrocardioChartFileData(param);
		
		return JSONObject.toJSONString(map);
	}
	
	
	/**
	 * @Title:initElectrocardioExcAndDelData 
	 * @Description:心电图初始化时，保存之前的心电图所截取异常心电和删除心电所对应的的信息的处理
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@ResponseBody
	@RequestMapping(value="/initElectrocardioExcAndDelData",produces="text/plain;charset=UTF-8")
	public String initElectrocardioExcAndDelData(Model model, Integer memberId, Long eventId, Integer pageNo){
		Omds omds = getOmdsByCondition (memberId, eventId, pageNo);
		
		if(omds == null){
			return null;
		}
		
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(omds.getEventid());
		
		if(oecg == null){
			return null;
		}
		
		model.addAttribute("oecg", oecg);
		
		long time = oecg.getMeastime().getTime();
		List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
		JSONArray json = new JSONArray();
		for(Ecg1 ecg1 : ecg1s){
			String[] abEcgTypes = ecg1.getAbecgtype().split(",");
			String[] abEcgType = abEcgTypes[0].split(":");
			int dataPoint = Integer.parseInt(abEcgType[1]);
			int startMilli = (int)(((float)dataPoint / oecg.getFs()) * 1000);
			
			byte[] data = null;
			try {
				data = electrocardioFileService.getFile(false, ecg1.getObjectid());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(data != null){
				String dataStr = new String(data);	
				int endDataPoint = dataStr.split("\n").length;
				int endMilli = (int) (((float)endDataPoint / oecg.getFs()) * 1000);
				if(endMilli == 6000){
					endMilli = 1000;
				}
				
				JSONObject jo = new JSONObject();
				jo.put("pbType", "Exc");
				jo.put("excName", ElectrocardioType.getChineseNameByEcg1(abEcgType[0]));
				jo.put("startTime", ecg1.getAbecgtime() * 1000 + startMilli
						+ time);
				jo.put("endTime", ecg1.getAbecgtime() * 1000 + startMilli
						+ endMilli + time);
				jo.put("objid", ecg1.getObjectid());
				json.add(jo);
			}
		}
		
		List<Ecg3> ecg3s = ecg3Service.selectEcg3ListByDocentry(oecg.getDocentry());
		for(Ecg3 ecg3 : ecg3s){
			JSONObject jo = new JSONObject();
			jo.put("pbType", "delete");
			jo.put("startTime", ecg3.getStarttime()+time);
			jo.put("endTime", ecg3.getEndtime()+time);
			jo.put("objid", ecg3.getObjectid());
			json.add(jo);
		}
		return json.toString();
	}
	
	
	/**
	 * @Title:deleteExcElectrocardio 
	 * @Description:删除指定的异常心电数据
	 * @author 陈哲
	 * @param objectId
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@ResponseBody
	@RequestMapping(value="/deleteExcElectrocardio",produces="text/plain;charset=UTF-8")
	public String deleteExcElectrocardio(String objectId, Integer memberId, Long eventId, Integer pageNo){
		Ecg1 ecg1 = ecg1Service.selectEcg1ByObjectid(objectId);
		List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(ecg1.getDocentry());
		List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(ecg1.getDocentry());
		
		int result = ecg1Service.deleteEcg1ByObjectid(objectId);
		
		//result为1时，表示删除成功，则ecg1表中的LineNum数值均减小1，同时ecg2中AbnNum数量相应的减少。
		if(result == 1){
			for(Ecg1 _ecg1 : ecg1s){
				if(_ecg1.getLinenum() > ecg1.getLinenum()){
					ecg1Service.updateEcg1ByDocentryAndObjectid(_ecg1.getDocentry(), _ecg1.getLinenum()-1, _ecg1.getObjectid());
				}
			}
			
			String[] ecgTypes = ecg1.getAbecgtype().split(":");
			String abnName = ElectrocardioType.getEcg2TypeByEcg1(ecgTypes[0]);
			
			int abnNum = 1;
			for(Ecg2 _ecg2 : ecg2s){
				if(abnName.equals(_ecg2.getAbnname())){
					abnNum = _ecg2.getAbnnum();
				}
			}
			
			if(abnNum == 1){
				ecg2Service.deleteEcg2ByDocentryAndAbnname(ecg1.getDocentry(), abnName);
			}else{
				ecg2Service.updateEcg2ByDocentryAndAbnname(ecg1.getDocentry(), abnName, abnNum-1);
			}
		}
		
		Omds omds = getOmdsByCondition (memberId, eventId, pageNo);
		
		if(omds == null){
			return null;
		}
		
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(omds.getEventid());
		//刷新ecg1和ecg2
		ecg1s = ecg1Service.selectEcg1ListByDocentry(ecg1.getDocentry());
		ecg2s = ecg2Service.selectEcg2ListByDocentry(ecg1.getDocentry());
		
		Map<String,Object> map = new HashMap<String,Object>();
		JSONArray jsonArray = new JSONArray();
		
		List<OecgExc> oecgExcs = electrocardioExcService.doElectrocardioExcInfo(ecg1s, ecg2s, oecg);
		for(OecgExc oecgExc : oecgExcs ){
			map.put("测量项", oecgExc.getExpCname());
			map.put("异常次数", oecgExc.getExpNum());
			map.put("异常比率", oecgExc.getExpRate());
			map.put("异常Id", oecgExc.getObjectIds());
			map.put("异常时间", oecgExc.getExtimes());
			map.put("异常毫秒", oecgExc.getExtMss());
			map.put("result", result);
			Object jsonObject = JSONObject.toJSON(map);
			jsonArray.add(jsonObject);
		}
		return jsonArray.toString();
	}
	
	
	/**
	 * @Title:reanalysisElectrocardio 
	 * @Description:心电图手动截取异常信息功能处理，心电图重新分析功能
	 * @author 陈哲
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @param startTimes
	 * @param endTimes
	 * @param ids
	 * @param excNames
	 * @param pbTypes
	 * @param excData
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@ResponseBody
	@RequestMapping(value="/reanalysisElectrocardio",produces="text/plain;charset=UTF-8")
	public String reanalysisElectrocardio(Integer memberId, Long eventId, Integer pageNo, String startTimes, String endTimes, 
							String ids,	String excNames,String pbTypes,String excData ) {
		Omds omds = getOmdsByCondition (memberId, eventId, pageNo);
		
		if(omds == null){
			return null;
		}
		
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(omds.getEventid());
		
		if(oecg == null){
			return null;
		}
		
		List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
		List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
		List<Ecg3> ecg3s = ecg3Service.selectEcg3ListByDocentry(oecg.getDocentry());
		
		try {
			//删除异常心电的mongodb文件
			for(Ecg1 ecg1 : ecg1s){
				FileConfigModel model = new FileConfigModel();
				FileTypeEnum fileTypeEnum = FileTypeEnum.CUSTOM_FILE;
				fileTypeEnum.setFormat("fs");
				model.setTypeEnum(fileTypeEnum);
				model.setUniqueId(ecg1.getObjectid());
				fileManagerServiceFacade.deleteFile(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//删除异常心电的数据记录
		if (ecg1s != null && !ecg1s.isEmpty()) {
			ecg1Service.deleteEcg1Bydocentry(oecg.getDocentry());
		}
		
		if (ecg2s != null && !ecg2s.isEmpty()) {
			ecg2Service.deleteEcg2ByDocentry(oecg.getDocentry());
		}
		
		//删除心电图删除数据
		if(ecg3s != null && !ecg3s.isEmpty()){
			ecg3Service.deleteEcg3ByDocentry(oecg.getDocentry());
		}

		//心电图添加异常，并保存数据库，同时将异常心电数据保存到mongoDB中
		String[] startTimeArr = startTimes.trim().split(",");
		String[] endTimeArr = endTimes.trim().split(",");
		String[] excNameArr = excNames.trim().split(",");
		String[] pbTypeArr = pbTypes.trim().split(",");
		String[] idArr = ids.trim().split(",");
		String[] excDataArr = excData.trim().split("#");

		try {
			for(int i = 0; i < excNameArr.length; i++){
				if(excNameArr[i] == null || excNameArr[i].equals("")){
					continue;
				}
				int startTime = Integer.parseInt(startTimeArr[i]);
				int endTime = Integer.parseInt(endTimeArr[i]);
				
				byte[] ubs  = Util.getAbEcg(excDataArr[i]);
				if("Exc".equals(pbTypeArr[i])){
					FileConfigModel model = new FileConfigModel();
					FileTypeEnum fileTypeEnum = FileTypeEnum.CUSTOM_FILE;
					fileTypeEnum.setFormat("fs");
					model.setTypeEnum(fileTypeEnum);
					model.setNeedCompress(false);

					InputStream in = new ByteArrayInputStream(ubs);
					String objectid = fileManagerServiceFacade.uploadFile(in, model);

					int abEcgTime = startTime / 1000;
					int distance = startTime % 1000;
					int dataPoint = (distance * oecg.getFs()) / 1000;
					
					String abEcgType = ElectrocardioType.getEcg1TypeByChineseName(excNameArr[i])+":"+dataPoint;
					String abnName = ElectrocardioType.getEcg2TypeByChineseName(excNameArr[i]);
					
					//刷新ecg1和ecg2数据
					ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
					ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
					
					int abnNum = 0;

					for(Ecg2 ecg2 : ecg2s){
						if(ecg2.getAbnname().equals(abnName)){
							abnNum = ecg2.getAbnnum();
							break;
						}
					}
					
					int ret = ecg1Service.insertEcg1(oecg.getDocentry(), ecg1s.size(), objectid, abEcgType, abEcgTime);
					
					if(ret != 0){
						if(abnNum == 0){
							ecg2Service.insertEcg2(oecg.getDocentry(), abnName, 1);
						}else{
							ecg2Service.updateEcg2ByDocentryAndAbnname(oecg.getDocentry(), abnName, abnNum+1);
						}
					}
				}else{
					String id = idArr[i];			
					ecg3Service.insertEcg3(oecg.getDocentry(), id, startTime, endTime);
				}	
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//刷新ecg1和ecg2数据
		ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
		ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
		
		if(!ecg1s.isEmpty() && oecg.getEcgresult() == 0){
			electrocardioService.updateEcgResultOfOecgByDocentry(1, oecg.getDocentry());
			
			if("0".equals(omds.getWheabntag())){
				omdsService.updateWheAbnTagOfOmdsByEventid(oecg.getEventid(), "1");
			}
		}else if(ecg1s.isEmpty() && oecg.getEcgresult() == 1){
			electrocardioService.updateEcgResultOfOecgByDocentry(0, oecg.getDocentry());
			
			if("1".equals(omds.getWheabntag())){
				omdsService.updateWheAbnTagOfOmdsByEventid(oecg.getEventid(), "0");
			}
		}
		
		JSONArray jsonArray = new JSONArray();
		List<OecgExc> oecgExcs = electrocardioExcService.doElectrocardioExcInfo(ecg1s, ecg2s, oecg);
			for(OecgExc oecgExc : oecgExcs ){
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("测量项", oecgExc.getExpCname());
				jsonObject.put("异常次数", oecgExc.getExpNum());
				jsonObject.put("异常比率", oecgExc.getExpRate());
				
				jsonObject.put("异常Id", oecgExc.getObjectIds());
				jsonObject.put("异常时间", oecgExc.getExtimes());
				jsonObject.put("异常毫秒", oecgExc.getExtMss());
				jsonArray.add(jsonObject);
			}
			
			return jsonArray.toString();
		}
	
	
	/**
	 * @Title:renewOrginalElectrocardioChart 
	 * @Description:心电图还原到最初功能实现
	 * @author 陈哲
	 * @param response
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@ResponseBody
	@RequestMapping(value="/renewOrginalElectrocardioChart",produces="text/plain;charset=UTF-8")
	public String renewOrginalElectrocardioChart(Integer memberId, Long eventId, Integer pageNo) {
		Omds omds = getOmdsByCondition (memberId, eventId, pageNo);
		
		if(omds == null){
			return null;
		}
		
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(omds.getEventid());
		
		if(oecg == null){
			return null;
		}
		
		//数据初始化
		ecg1Service.deleteEcg1Bydocentry(oecg.getDocentry());
		ecg2Service.deleteEcg2ByDocentry(oecg.getDocentry());
		electrocardioService.updateEcgResultOfOecgByDocentry(0, oecg.getDocentry());
		electrocardioService.updateStatusTagOfOecgByDocentry(0, oecg.getDocentry());
		omdsService.updateStatusTagOfOmdsByEventid(oecg.getEventid(), 0);
		omdsService.updateWheAbnTagOfOmdsByEventid(oecg.getEventid(), "0");

		try {
			String message = electrocardioFileService.getMqOecgMessage(oecg);
			if(message != null){
				ClientSender.sender(message);
				
				JSONObject json = new JSONObject();
				json.put("docentry", oecg.getDocentry());
				
				return json.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * @Title:getOrginalElectrocardioData 
	 * @Description:心电图重新分析后，更新数据，将最新数据显示在页面上
	 * @author 陈哲
	 * @param docentry
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@ResponseBody
	@RequestMapping(value="/getOrginalElectrocardioData",produces="text/plain;charset=UTF-8")
	public String getOrginalElectrocardioData(Long docentry) {
		Oecg oecg = electrocardioService.selectElectrocardioByDocentry(docentry);
		List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
		List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
		
		Map<String,Object> map = new HashMap<String,Object>();
		JSONArray jsonArray = new JSONArray();

		List<OecgExc> oecgExcs = electrocardioExcService.doElectrocardioExcInfo(ecg1s, ecg2s, oecg);
		for (OecgExc oecgExc : oecgExcs) {
			map.put("测量项", oecgExc.getExpCname());
			map.put("异常次数", oecgExc.getExpNum());
			map.put("异常比率", oecgExc.getExpRate());
			map.put("异常Id", oecgExc.getObjectIds());
			map.put("异常时间", oecgExc.getExtimes());
			map.put("异常毫秒", oecgExc.getExtMss());
			Object object = JSONObject.toJSON(map);
			jsonArray.add(object);
		}

		Omds omds = omdsService.selectOmdsByEventId(oecg.getEventid());
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("status", omds.getStatustag());
		jsonArray.add(map1);

		return jsonArray.toString();
	}
	
	
	/**
	 * @Title:showAllElectrocardio 
	 * @Description:根据条件查询心电信息
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @param pageSize
	 * @param startTime
	 * @param endTime
	 * @param flag
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/showAllElectrocardio")
	public String showAllElectrocardio(Model model, Integer memberId,
			Long eventId, Integer pageNo, Integer pageSize, Date startTime,
			Date endTime, Integer flag) {
		if(pageNo == null){
			pageNo = 1;
		}
		
		if(pageSize == null){
			pageSize = 10;
		}
		
		//动态心电页面有两个入口，分别是会员管理和测量管理，flag用来标记是哪个入口，值为1标识会员管理
		model.addAttribute("flag", flag);
		
		//日期处理
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		if(startTime != null){
			//日期类型数据回显
			model.addAttribute("startTime", sdf.format(startTime));
		}
		
		Date endTime_ = null;
		if(endTime != null){
			//endTime加一天
			Calendar cal = Calendar.getInstance();
			cal.setTime(endTime);
			cal.add(Calendar.DATE, 1);
			endTime_ = cal.getTime();
			
			//日期类型数据回显
			model.addAttribute("endTime", sdf.format(endTime));
		}
		
		//获取会员信息
		Member member = memberService.selectById(memberId);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		Page<Oecg> page = electrocardioService.selectElectrocardioAndPage(memberId,pageNo,pageSize,startTime,endTime_);
		
		List<Oecg> oecgs = page.getResult();
		
		List<Ecg2> lists = null;
		Map<Oecg, List<Ecg2>> map = new HashMap<>();
		
		for(Oecg oecg : oecgs){
			lists = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
			
			for (Ecg2 e : lists) {
				e.setAbnname(ElectrocardioType.getTypeChinaName(e.getAbnname()));
			}
			map.put(oecg, lists);
		}
		
		String oecgJsonArr = JSONArray.toJSONString(page.getResult());
		
		model.addAttribute("map", map);
		model.addAttribute("omem", member);
		model.addAttribute("age", age);
		model.addAttribute("page", page);
		model.addAttribute("eventId", eventId);
		model.addAttribute("oecgJsonArr", oecgJsonArr);
		
		return "/measure/allXinDian";
	}
	
	/**
	 * @Title:getOmdsByCondition 
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * @author 陈哲
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @return 
	 * @throws
	 * @retrun Omds
	 */
	private Omds getOmdsByCondition(Integer memberId, Long eventId, Integer pageNo){
		if(pageNo == null){
			pageNo = 0;
		}
		
		Omds omds = null;
		List<Omds> omdsList = electrocardioService.selectMeasureRecordByElectro(memberId);
		if(eventId != null){
			for(Omds om : omdsList){
				if(om.getEventid().equals(eventId)){
					omds = om;
					break;
				}
			}
		}else{
			if(omdsList == null || omdsList.isEmpty()){
				return null;
			}
			omds = omdsList.get(pageNo);
		}
		return omds;
	}
	
	@ResponseBody
    @RequestMapping(value = "/getElectrocardioChart",produces = "plain/text; charset=UTF-8")
    public String getElectrocardioChart(String oecgsJson){
		List<Oecg> oecgs = JSONObject.parseArray(oecgsJson, Oecg.class);
		JSONArray jsonArr = new JSONArray();
		
		// 动态心电24小时异常心电分布图
		jsonArr.add(chartService.selectElectrocardioExcTrendChartJson(oecgs));
		// 动态心电异常心电柱状图
		jsonArr.add(chartService.selectElectrocardioExcBarChartJson(oecgs));

		return jsonArr.toString();
    }
	
	public void getReportPageData(ModelMap model, List<Oecg> oecgs){
		//计算血压测量数据测量时间段
		Date startMeasureTime = null;
		Date endMeasureTime = null;
		int recordDay = 0;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(oecgs.get(0).getMeastime());
		int day_0 = calendar.get(Calendar.DAY_OF_YEAR);
		
		for(Oecg oecg : oecgs){
			if(startMeasureTime == null && endMeasureTime == null){
				startMeasureTime = oecg.getMeastime();
				endMeasureTime = oecg.getMeastime();
				continue;
			}
			
			if(startMeasureTime.after(oecg.getMeastime())){
				startMeasureTime = oecg.getMeastime();
			}else{
				endMeasureTime = oecg.getMeastime();
			}
			
			calendar.setTime(oecg.getMeastime());
			int day = calendar.get(Calendar.DAY_OF_YEAR);
			if(day_0 - day != 0){
				recordDay++;
				day_0 = day;
			}
		}
		
		model.addAttribute("startMeasTime",startMeasureTime);
		model.addAttribute("endMeasTime",endMeasureTime);
		model.addAttribute("recordDay",recordDay+1);
		
		//血压测量持续天数
		calendar.setTime(startMeasureTime);
		int s_day = calendar.get(Calendar.DAY_OF_YEAR);
		
		calendar.setTime(endMeasureTime);
		int e_day = calendar.get(Calendar.DAY_OF_YEAR);
		
		int day = e_day - s_day + 1;
		model.addAttribute("lastDay", day);
		model.addAttribute("generTime",new Date());
				
		//获取测量数据的异常信息
		for(Oecg oecg:oecgs){
			oecg = getEcg2ByOecg(oecg);
		}
		model.addAttribute("oecgs", oecgs);
	}
	
	public void getReportExportPageData(ModelMap model, String oecgsJson){
		List<Oecg> oecgs = JSONObject.parseArray(oecgsJson, Oecg.class);
		Iterator<Oecg> its = oecgs.iterator();
		while(its.hasNext()){
			Oecg oecg = its.next();
			if(oecg.getStatustag() == null || oecg.getStatustag() < 2){
				its.remove();
			}
		}
		
		if (oecgs != null && oecgs.size() > 0) {
			Map<String, List<OecgExc>> map = new HashMap<String, List<OecgExc>>();
			List<OecgExc> oecgExcs = reportIFService.doElectrocardioReportData(oecgs, map);
			model.addAttribute("ecg12s_tab4", oecgExcs);
			model.addAttribute("ecg12s_4", JSONObject.toJSONString(map));
		}
	}
	
	@RequestMapping(value="/getReportXDDetail")
	public String getReportXDDetail(ModelMap model, String oecgsJson, Integer memberid) throws Exception{
		List<Oecg> oecgs = JSONObject.parseArray(oecgsJson, Oecg.class);
		getReportPageData(model, oecgs);
		
		MemberExt member = memberService.selectMemberExtById(memberid);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("oecgsJson", oecgsJson);
		model.addAttribute("omem",member);
		model.addAttribute("age", age);

		return "measure/xindianRep";
	}
	
	@RequestMapping(value="/getReportXDPreview")
	public String getReportXDPreview(ModelMap model, String oecgsJson, Integer memberid) throws Exception{
		List<Oecg> oecgs = JSONObject.parseArray(oecgsJson, Oecg.class);
		
		getReportPageData(model,oecgs);
		getReportExportPageData(model, oecgsJson);
		
		MemberExt member = memberService.selectMemberExtById(memberid);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("oecgsJson", oecgsJson);
		model.addAttribute("omem",member);
		model.addAttribute("age", age);
		
		return "measure/exportPreviewXDRep";
	}
	
	private Oecg getEcg2ByOecg(Oecg oecg){
		List<Ecg2> list = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
		for(Ecg2 ecg2:list){
			ecg2.setAbnCname(ElectrocardioType.getTypeChinaName(ecg2.getAbnname()));
		}
		oecg.setEcg2s(list);
		return oecg;
	}
	
	@ResponseBody
	@RequestMapping(value="/getReportSVGData")
	public String getReportSVGData(HttpServletRequest request){
		String jsonStr = request.getParameter("jsonStr");
		Object jsonObj = JSONObject.toJSON(jsonStr);

		request.getSession().setAttribute("jsonArr", jsonObj);
		
		return "1";
	}
	
	public Map<String, Object> getExportWordXDData(List<Oecg> oecgs){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		Iterator<Oecg> its = oecgs.iterator();
		while(its.hasNext()){
			Oecg oecg = its.next();
			if(oecg.getStatustag() == null || oecg.getStatustag() < 2){
				its.remove();
			}
		}
		
		if (oecgs != null && oecgs.size() > 0) {
			Map<String, List<OecgExc>> map = new HashMap<String, List<OecgExc>>();
			List<OecgExc> oecgExcs = doElectrocardioReportData(oecgs, map);
			dataMap.put("ecg12s_tab4", oecgExcs);
			dataMap.put("ecg12s_3", JSONObject.toJSONString(map));
		}
		
		return dataMap;
	} 
	
	public void getReportData(Map<String, Object> dataMap, String oecgsJson){
		List<Oecg> oecgs = JSONObject.parseArray(oecgsJson, Oecg.class);
		
		//计算血压测量数据测量时间段
		Date startMeasureTime = null;
		Date endMeasureTime = null;
		int recordDay = 0;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(oecgs.get(0).getMeastime());
		int day_0 = calendar.get(Calendar.DAY_OF_YEAR);
		
		for(Oecg oecg : oecgs){
			if(startMeasureTime == null && endMeasureTime == null){
				startMeasureTime = oecg.getMeastime();
				endMeasureTime = oecg.getMeastime();
				continue;
			}
			
			if(startMeasureTime.after(oecg.getMeastime())){
				startMeasureTime = oecg.getMeastime();
			}else{
				endMeasureTime = oecg.getMeastime();
			}
			
			calendar.setTime(oecg.getMeastime());
			int day = calendar.get(Calendar.DAY_OF_YEAR);
			if(day_0 - day != 0){
				recordDay++;
				day_0 = day;
			}
		}
		
		dataMap.put("startMeasTime",startMeasureTime);
		dataMap.put("endMeasTime",endMeasureTime);
		dataMap.put("recordDay",recordDay+1);
		
		//血压测量持续天数
		calendar.setTime(startMeasureTime);
		int s_day = calendar.get(Calendar.DAY_OF_YEAR);
		
		calendar.setTime(endMeasureTime);
		int e_day = calendar.get(Calendar.DAY_OF_YEAR);
		
		int day = e_day - s_day + 1;
		dataMap.put("lastDay", day);
		
		//获取测量数据的异常信息
		for(Oecg oecg:oecgs){
			oecg = getEcg2ByOecg(oecg);
		}
		dataMap.put("oecgs", oecgs);
	}
	
    public List<OecgExc> doElectrocardioReportData(List<Oecg> oecgs, Map<String, List<OecgExc>> map){
		List<OecgExc> oecgExc_tab = new ArrayList<OecgExc>();
		for(int k=0; k<oecgs.size();k++){
			Oecg oecg = oecgs.get(k);
			
			List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
			List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
			List<OecgExc> oecgExcs = electrocardioExcService.doElectrocardioExcInfo(ecg1s, ecg2s, oecg);
			
			List<OecgExc> oecgExcs1 = getOecgExcNewList(oecgExcs, oecg, map);
			
			for(OecgExc oecgExc : oecgExcs1){
				OecgExc oecgExc_tab1 = new OecgExc();
				
				oecgExc_tab1.setExpCname(oecgExc.getExpCname());
				oecgExc_tab1.setExpName(oecgExc.getExpName());
				
				if(oecgExc.getExtMss().size() == 1){
					String[] objectids = oecgExc.getObjectIds().get(0).split("'");
					int periodTime = electrocardioExcService.getElectrocardioExcTimeP(objectids[1], oecg);
					long endTime = oecgExc.getExtMss().get(0) + periodTime;
					
					Timestamp timestamp1 = new Timestamp(oecgExc.getExtMss().get(0));
					Timestamp timestamp2 = new Timestamp(endTime);
					oecgExc.setTimePoint1(timestamp1);
					oecgExc.setTimePoint2(timestamp2);
					
					oecgExc_tab.add(oecgExc);
				}else{
					List<Long> extMss_tab = new ArrayList<Long>();
					List<String> objectIds_tab = new ArrayList<String>();
					
					for(int i=0;i<oecgExc.getExtMss().size();i++){
						if(i==0){
							objectIds_tab.add(oecgExc.getObjectIds().get(i));
							extMss_tab.add(oecgExc.getExtMss().get(i));
							continue;
						}
						long time = oecgExc.getExtMss().get(i);
						String[] objectids = oecgExc.getObjectIds().get(i-1).split("'");
						String objectid = objectids[1];
						int periodTime = electrocardioExcService.getElectrocardioExcTimeP(objectid, oecg);
						long endTime = oecgExc.getExtMss().get(i-1) + periodTime;
						float minu = ((float)(time - endTime) / 1000 / 60);
						
						Integer intervalTime = Contrants.INTERVAL_TIME;
						
						if(minu < intervalTime){
							objectIds_tab.add(oecgExc.getObjectIds().get(i));
							extMss_tab.add(oecgExc.getExtMss().get(i));
						}else{
							oecgExc_tab1.setObjectIds(objectIds_tab);
							oecgExc_tab1.setExtMss(extMss_tab);
							
							Timestamp timestamp1 = new Timestamp(extMss_tab.get(0));
							Timestamp timestamp2 = new Timestamp(endTime);
							oecgExc_tab1.setTimePoint1(timestamp1);
							oecgExc_tab1.setTimePoint2(timestamp2);
							
							oecgExc_tab.add(oecgExc_tab1);
							
							oecgExc_tab1 = new OecgExc();
							oecgExc_tab1.setExpCname(oecgExc.getExpCname());
							oecgExc_tab1.setExpName(oecgExc.getExpName());
							
							extMss_tab = new ArrayList<Long>();
							objectIds_tab = new ArrayList<String>();
							
							objectIds_tab.add(oecgExc.getObjectIds().get(i));
							extMss_tab.add(oecgExc.getExtMss().get(i));
						}
						
						if(i==oecgExc.getExtMss().size()-1){
							oecgExc_tab1.setObjectIds(objectIds_tab);
							oecgExc_tab1.setExtMss(extMss_tab);
							
							String[] objectids1 = oecgExc.getObjectIds().get(i).split("'");
							
							int periodTime1 = electrocardioExcService.getElectrocardioExcTimeP(objectids1[1], oecg);
							long endTime1 = oecgExc.getExtMss().get(i) + periodTime1;
							
							Timestamp timestamp1 = new Timestamp(extMss_tab.get(0));
							Timestamp timestamp2 = new Timestamp(endTime1);
							oecgExc_tab1.setTimePoint1(timestamp1);
							oecgExc_tab1.setTimePoint2(timestamp2);
							
							oecgExc_tab.add(oecgExc_tab1);
						}
					}
				}
			}
		}
    	return oecgExc_tab;
    }
    
    private List<OecgExc> getOecgExcNewList(List<OecgExc> oecgExcs, Oecg oecg, Map<String, List<OecgExc>> map){
    	List<OecgExc> oecgExcList = new ArrayList<OecgExc>();
		for(OecgExc oecgExc : oecgExcs){
			if(oecgExc.getExpNum() != 0){
				oecgExc.setDocentry(oecg.getDocentry());
				oecgExcList.add(oecgExc);
				if(!map.containsKey(oecgExc.getExpCname())){
					map.put(oecgExc.getExpCname(), new ArrayList<OecgExc>());
				}
				map.get(oecgExc.getExpCname()).add(oecgExc);
			}
		}
    	return oecgExcList;
    }
	
	@RequestMapping(value="/exportReportWord")
	public void exportReportWord(HttpServletRequest request, HttpServletResponse response,String oecgsJson, Integer memberId, Date generTime) throws Exception{
		List<Oecg> oecgs = JSONObject.parseArray(oecgsJson, Oecg.class);
		//从session中获取svg字符串
		JSONArray jsonArr = JSONArray.parseArray((String)request.getSession().getAttribute("jsonArr"));
		Map<String ,Object> dataMap = getExportWordXDData(oecgs);
		getReportData(dataMap,oecgsJson);
		for(int i=0;i<jsonArr.size();i++){
			JSONObject jsonObj =jsonArr.getJSONObject(i);
			Set<String> keys = jsonObj.keySet(); 
			for(String key : keys){
				if("xd_tab1".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("xd_tab2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("xd_chart1".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");				
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xd_chart1_svg", exportWordService.doImage(svgStr, request));			
				}else if("xd_chart2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xd_chart2_svg", exportWordService.doImage(svgStr, request));
				}else if("xd_chart3".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					List<String> svgList = new ArrayList<String>();
					for(int j=0;j<jsonArrSvg.size();j++){
						String svgStr = jsonArrSvg.getString(j);
						svgList.add(exportWordService.doImage(svgStr, request));
					}
					dataMap.put("xd_chart3_svgs", svgList);
				}		
			}
		}
		
		MemberExt member = memberService.selectMemberExtById(memberId);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dataMap.put("omem", member);
		dataMap.put("age", age);
		dataMap.put("generTime",generTime);
		dataMap.put("gender", "1".equals(member.getGender())?"男": "2".equals(member.getGender())?"女":"未知");
		
		String exportFileName = member.getMemname() + "的动态心电测量报告"+ new SimpleDateFormat("yyyyMMdd").format(new Date());
		exportWordService.ExportWord(request, response, dataMap, exportFileName, "xdRep.ftl");
	}

}