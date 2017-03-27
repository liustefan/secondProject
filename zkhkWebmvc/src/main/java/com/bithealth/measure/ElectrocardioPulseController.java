 
/**
 * @PackageName:      com.bithealth.measure.electrocardioPulse
 * @FileName:     ElectrocardioPulseController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月18日 下午4:11:49  
 * 
 */

package com.bithealth.measure;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.common.model.ImageParam;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.common.service.OmdsService;
import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Ecg3;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExc;
import com.bithealth.measureCore.electrocardio.service.Ecg1Service;
import com.bithealth.measureCore.electrocardio.service.Ecg2Service;
import com.bithealth.measureCore.electrocardio.service.Ecg3Service;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioExcService;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioFileService;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.measureCore.electrocardioPulse.model.ExcOppg;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.model.OppgOmemVO;
import com.bithealth.measureCore.electrocardioPulse.service.PulseFileService;
import com.bithealth.measureCore.electrocardioPulse.service.PulseService;
import com.bithealth.measureCore.enmu.ElectrocardioType;
import com.bithealth.measureCore.facade.Facade;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.printCore.service.ExportWordService;
import com.bithealth.reportCore.facade.constants.Contrants;
import com.bithealth.reportCore.facade.service.ReportIFService;
import com.bithealth.sdk.common.rabbit.ClientSender;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.common.utils.Util;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


/**
 * 类名称: ElectrocardioPulseController  
 * 功能描述: 三合一controller层
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月18日 下午4:11:49 
 * 
 * @author 陈哲
 * @version  
 */
@Controller
@RequestMapping("/electrocardioPulse")
public class ElectrocardioPulseController extends BaseSpringController{
	
	@Autowired
	private ElectrocardioService electrocardioService;
	
	@Autowired
	private PulseService pulseService;
	
	@Autowired
	private ElectrocardioExcService electrocardioExcService;
	
	@Autowired
	private Ecg1Service ecg1Service;
	
	@Autowired
	private Ecg2Service ecg2Service;
	
	@Autowired
	private Ecg3Service ecg3Service;
	
	@Autowired
	private PulseFileService pulseFileService;
	
	@Autowired
	private ElectrocardioFileService electrocardioFileService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ExportWordService exportWordService;
	
	@Autowired
	private OmdsService omdsService;
	
	@Resource(name="orgService")
	private OrgService orgService;
	
	@Resource
	private FileManagerServiceFacade fileManagerServiceFacade;
	
	@Resource
	private BloodPressureService bloodPressureService;
	
	@Autowired
	private Facade chartService;
	
	@Resource
	private ReportIFService reportIFService;
	
	
	/**
	 * @Title:showBloodPressPage 
	 * @Description:某医生下的会员的三合一信息
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
	@RequestMapping(value="/queryElectrocardioPulse",method=RequestMethod.GET)
	public String showElectrocardioPulsePage(Model model,String wheAbnTag, Integer pageNo, Integer pageSize, Integer docid, String criteria) {
		//解决中文乱码
		if(criteria != null){
			try {
				criteria = URLDecoder.decode(criteria,"UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
				return "/measure/showMemberOppgMeasureInfoByDocid";
			}
		}
		
		if(pageNo == null){
			pageNo = 1;
		}
		
		if(pageSize == null){
			pageSize = 10;
		}
		Page<OppgOmemVO> page = pulseService.selectElectrocardioPluseAndMemListPage(pageNo, pageSize, criteria, docid, wheAbnTag);
		
		//统计每条记录的异常心电
		for(OppgOmemVO oov : page.getResult()){
			Oecg oecg = electrocardioService.selectElectrocardioByEventId(oov.getEventid());
			List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
			List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
			List<OecgExc> oecgExcs = electrocardioExcService.doElectrocardioExcInfo(ecg1s, ecg2s, oecg);
			
			String oecgExcStr = getOecgExcStatisResult(oecgExcs);
			
			if(oov.getMeasureResult().size() > 0){
				oov.setOecgMeasResult(oecgExcStr);
			}else{
				if("".equals(oecgExcStr)){
					oov.setOecgMeasResult(oecgExcStr);
				}else{
					oov.setOecgMeasResult(oecgExcStr.substring(0, oecgExcStr.length()-1));
				}
			}
		}
		
		model.addAttribute("page",page);
		model.addAttribute("criteria",criteria);
		model.addAttribute("wheAbnTag",wheAbnTag);
		
		return "/measure/showMemberOppgMeasureInfoByDocid";
	}
	
	
	/**
	 * @Title:deleteElectrocardioPulseInfo 
	 * @Description:删除单个三合一信息（逻辑删除）
	 * @author 陈哲
	 * @param docentry
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/deleteElectrocardioPulseInfo")
	public String deleteElectrocardioPulseInfo(Long docentry){
		pulseService.deleteElectrocardioPulse(docentry);
		
		return "forward:queryElectrocardioPulse";
	}
	
	
	/**
	 * @Title:deleteBatchElectrocardioPulseInfo 
	 * @Description:批量删除三合一信息（逻辑删除）
	 * @author 陈哲
	 * @param parameter
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/deleteBatchElectrocardioPulseInfo")
	public String deleteBatchElectrocardioPulseInfo(String parameter){
		List<Long> docentryList = new ArrayList<Long>();
		String[] strs = parameter.split(",");
		for(String str : strs){
			docentryList.add(Long.valueOf(str));
		}
		
		pulseService.deleteBatchElectrocardioPulse(docentryList);
		
		return "forward:queryElectrocardioPulse";
	}
	
	
	/**
	 * @Title:showElectrocardioPulse 
	 * @Description:单个三合一详细信息
	 * @author 陈哲
	 * @param request
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/showSingleElectroPulse")
	public String showSingleElectrocardioPulse(Model model, Integer memberId, Long docentry, Long eventId, Integer pageNo, Integer flag, String view) {
		if(pageNo == null){
			pageNo = 0;
		}
		
		//三合一页面有两个入口，分别是会员管理和测量管理，flag用来标记是哪个入口，值为1标识会员管理
		model.addAttribute("flag", flag);
		model.addAttribute("view", view);
		
		Member member = memberService.selectById(memberId);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("age", age);
		model.addAttribute("omem", member);
		model.addAttribute("eventId", eventId);
		
		Oppg oppg = null;
		Oecg oecg = null;
		if("1".equals(view)){
			oecg = electrocardioService.selectElectrocardioByDocentry(docentry);
			oppg = pulseService.selectElectrocardioPulseByEventId(oecg.getEventid());
		}else{
			Omds omds = null;
			List<Omds> omdsList = pulseService.selectMeasureRecordByPulse(memberId);
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
					return "/measure/singleSanHeYi";
				}
				omds = omdsList.get(pageNo);
			}
			
			model.addAttribute("pageNo", pageNo);
			model.addAttribute("total", omdsList.size());
			
			if(omds != null){
				oppg = pulseService.selectElectrocardioPulseByEventId(omds.getEventid());
				oecg = electrocardioService.selectElectrocardioByEventId(omds.getEventid());
			}
		}
		model.addAttribute("oecg", oecg);
		model.addAttribute("oppg", oppg);
		
		if(oecg != null){
			//获取异常信息
			List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
			List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
			List<OecgExc> oecgExcs = electrocardioExcService.doElectrocardioExcInfo(ecg1s, ecg2s, oecg);
			
			String oecgExcStr = getOecgExcStatisResult(oecgExcs);
			model.addAttribute("oecgExcStr", "".equals(oecgExcStr) ? oecgExcStr : oecgExcStr.substring(0, oecgExcStr.length()-1));
			
			model.addAttribute("oecgExcs", oecgExcs);
			model.addAttribute("timeLength", formatTimeLength(oecg.getTimelength()));
			
			int pulseTotal = 0;
			if(oppg != null){
				pulseTotal= new Double(oppg.getPulserate() * (oppg.getTimelength()/60d)).intValue();
			}
			model.addAttribute("pulseTotal", pulseTotal);
			
			model.addAttribute("hfd", Util.getSpecificDate(oecg.getMeastime().getTime(), oecg.getFastesttime()));
			model.addAttribute("hsd", Util.getSpecificDate(oecg.getMeastime().getTime(), oecg.getSlowesttime()));
			
			if(oppg != null){
				model.addAttribute("pfd", Util.getSpecificDate(oecg.getMeastime().getTime(), oppg.getQuicktime()));
				model.addAttribute("psd", Util.getSpecificDate(oecg.getMeastime().getTime(), oppg.getSlowtime()));
			}
			
			
			ImageParam param = new ImageParam();
			if (oecg.getRawecgimg() != null	&& !(oecg.getRawecgimg().trim()).isEmpty()) {
				param.setRawImage(oecg.getRawecgimg());
				oecg.setRawecg(oecg.getRawecgimg());
			} else if (oecg.getRawecg() != null	&& !(oecg.getRawecg().trim()).isEmpty()) {
				param.setRawImage(oecg.getRawecg());
			}
			param.setFs(oecg.getFs());
			int ecgPage = pulseFileService.getElectrocardioPulsePageByparam(param);
			model.addAttribute("ecgPage", ecgPage);
			
			//瞬时心率
			if (oecg.getRrinterval() != null && !(oecg.getRrinterval().trim()).isEmpty()) {
				param.setFs(oecg.getFs());
				param.setRawImage(oecg.getRrinterval());
				int hrecgPage = electrocardioFileService.getInstantHeartRatePageByParam(param);
				model.addAttribute("hrecgPage", hrecgPage);
			}
			
			//脉搏
			if (oppg.getRawppg() != null && !(oppg.getRawppg().trim()).isEmpty()) {
				param.setFs(oppg.getFs());
				param.setRawImage(oppg.getRawppg());
				int ppgPage = pulseFileService.getPulsePageByParam(param);
				model.addAttribute("ppgPage", ppgPage);
			}
			
			//瞬时脉率
			if (oppg.getPpgrr() != null && !(oppg.getPpgrr().trim()).isEmpty()) {
				param.setFs(oppg.getFs());
				param.setType("hr_ppg");
				param.setRawImage(oppg.getPpgrr());
				model.addAttribute("hrppgPage", 1);
			}
		}
		
		return "/measure/singleSanHeYi";
	}
	
	
	/**
	 * @Title:getOecgExcStatisResult 
	 * @Description:统计异常心电，并组装成形如“（次数）+异常名，...”的字符串
	 * @author 陈哲
	 * @param oecgExcs
	 * @return 
	 * @throws
	 * @retrun String
	 */
	private String getOecgExcStatisResult(List<OecgExc> oecgExcs){
		StringBuilder oecgExcAppend = new StringBuilder();
		for(OecgExc oe : oecgExcs){
			if(oe.getExpNum() > 0){
				oecgExcAppend.append("("+oe.getExpNum()+")"+oe.getExpCname()+",");
			}
		}
		return oecgExcAppend.toString();
	}

	
	/**
	 * @Title:getElectrocardioPulseChartData 
	 * @Description:加载三合一心电图的数据  
	 * @author 陈哲
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */
	@ResponseBody
	@RequestMapping(value="/getElectrocardioPulseChartData",produces="plain/text;charset=UTF-8") 
	public String getElectrocardioPulseChartData(Model model, Integer memberId, Long eventId, Integer pageNo) {
		Omds omds = getOmdsByCondition(memberId, eventId, pageNo);
		if(omds == null){
			return null;
		}
		
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(omds.getEventid());
		
		if(oecg == null){
			return null;
		}
		
		model.addAttribute("oecg", oecg);
		ImageParam param = new ImageParam();
		if (oecg.getRawecgimg() != null && !(oecg.getRawecgimg().trim()).isEmpty()) {
			param.setRawImage(oecg.getRawecgimg());
			oecg.setRawecg(oecg.getRawecgimg());
		} else if (oecg.getRawecg() != null && !(oecg.getRawecg().trim()).isEmpty()) {
			param.setRawImage(oecg.getRawecg());
		}
		param.setFs(oecg.getFs());
		param.setWidth(1000);
		param.setHeight(300);
		param.setPage(1);
		param.setMeasureTime(oecg.getMeastime());
		
		Map<String, Object> map = pulseFileService.getElectrocardioPulseChartFileData(param);
		
		return JSONObject.toJSONString(map);
		
	}
	
	/**
	 * 心电图初始化时，保存之前的心电图所截取异常心电和删除心电所对应的的信息的处理
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/initElectrocardioExcAndDelData",produces="text/plain;charset=UTF-8")
	public String initElectrocardioExcAndDelData(Model model, Integer memberId, Long eventId, Integer pageNo) {
		Omds omds = getOmdsByCondition(memberId, eventId, pageNo);
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
	 * @Description:删除异常心电
	 * @author 陈哲
	 * @param response
	 * @param objectId
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @throws IOException 
	 * @throws
	 * @retrun void
	 */
	@ResponseBody
	@RequestMapping(value="/deleteExcElectrocardio",produces="text/plain;charset=UTF-8")
	public String deleteExcElectrocardio(String objectId, Integer memberId, Long eventId, Integer pageNo) {
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
		
		Omds omds = getOmdsByCondition(memberId, eventId, pageNo);
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
	 * @param response
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @param startTimes
	 * @param endTimes
	 * @param ids
	 * @param excNames
	 * @param pbTypes
	 * @param excData
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */
	@ResponseBody
	@RequestMapping(value="/reanalysisElectrocardio",produces="text/plain;charset=UTF-8")
	public String reanalysisElectrocardio(Integer memberId, Long eventId, Integer pageNo, String startTimes, String endTimes, 
							String ids,	String excNames,String pbTypes,String excData ) {
		Omds omds = getOmdsByCondition(memberId, eventId, pageNo);
		if(omds == null){
			return null;
		}
		
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(omds.getEventid());
		
		if(oecg == null){
			return null;
		}
	
		List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
		List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
		
		//删除异常心电信息
		Integer result = electrocardioExcService.deleteExcElectrocardio(oecg.getDocentry());
		
		//如果异常信息删除成功，就删除mongodb相应的心电文件
		if(result == 1){
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
			
			Oppg oppg = pulseService.selectElectrocardioPulseByEventId(oecg.getEventid());
			if(oppg.getPpgresult() == 1){
				if("0".equals(omds.getWheabntag())){
					omdsService.updateWheAbnTagOfOmdsByEventid(oecg.getEventid(), "1");
				}
			}else if(oppg.getPpgresult() == 0){
				if("1".equals(omds.getWheabntag())){
					omdsService.updateWheAbnTagOfOmdsByEventid(oecg.getEventid(), "0");
				}
			}
		}
		
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
				Object object = JSONObject.toJSON(map);
				jsonArray.add(object);
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
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */
	@ResponseBody
	@RequestMapping(value="/renewOrginalElectrocardioChart",produces="text/plain;charset=UTF-8")
	public String renewOrginalElectrocardioChart(Integer memberId, Long eventId, Integer pageNo) {
		Omds omds = getOmdsByCondition(memberId, eventId, pageNo);
		if(omds == null){
			return null;
		}
		
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(omds.getEventid());
		Oppg oppg = pulseService.selectElectrocardioPulseByEventId(omds.getEventid());
	
		List<Osbp> osbps =  bloodPressureService.selectBloodPresListByMemberId(oecg.getMemberid());
		Osbp osbp = null;
		if(osbps != null && !osbps.isEmpty()){
			osbp = osbps.get(0);
		}else{
			return null;
		}
		
		MemberExt memberExt = memberService.selectMemberExtById(oecg.getMemberid());
		if(memberExt != null){
			if(StringUtils.isEmpty(memberExt.getBirthdate())){
				return null;
			}
		}
		
		//数据初始化
		ecg1Service.deleteEcg1Bydocentry(oecg.getDocentry());
		ecg2Service.deleteEcg2ByDocentry(oecg.getDocentry());
		electrocardioService.updateEcgResultOfOecgByDocentry(0, oecg.getDocentry());
		electrocardioService.updateStatusTagOfOecgByDocentry(0, oecg.getDocentry());
		pulseService.updatePpgResultOfOppgByEventId(0, oecg.getEventid());
		pulseService.updateStatusTagOfOppgByEventId(0, oecg.getEventid());
		omdsService.updateStatusTagOfOmdsByEventid(oecg.getEventid(), 0);
		omdsService.updateWheAbnTagOfOmdsByEventid(oecg.getEventid(), "0");
		
		try {
			String message = pulseFileService.getMqOecgOppgMessage(oecg, oppg, osbp, memberExt);
			ClientSender.sender(message);
			
			JSONObject json = new JSONObject();
			json.put("docentry", oecg.getDocentry());
			
			return json.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @Title:getOrginalElectrocardioData 
	 * @Description:心电图重新分析后，更新数据，将最新数据显示在页面上
	 * @author 陈哲
	 * @param response
	 * @param docentry
	 * @throws IOException 
	 * @throws
	 * @retrun void
	 */
	@ResponseBody
	@RequestMapping(value="/getOrginalElectrocardioData",produces="text/plain;charset=UTF-8")
	public String getOrginalElectrocardioData(Long docentry){
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
	 * @Title:getInstanceHeartRateChartData 
	 * @Description:瞬时心率图数据加载
	 * @author 陈哲
	 * @param model
	 * @param response
	 * @param memberId
	 * @param eventId
	 * @param page
	 * @param pageNo
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */
	@ResponseBody
	@RequestMapping(value="/getInstanceHeartRateChartData",produces="text/plain;charset=UTF-8")
	public String getInstanceHeartRateChartData(Model model, Integer memberId, Long eventId, Integer page, Integer pageNo){
		Omds omds = getOmdsByCondition(memberId, eventId, pageNo);
		if(omds == null){
			return null;	
		}
		
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(omds.getEventid());
		
		if(oecg == null){
			return null;
		}
		
		model.addAttribute("oecg", oecg);
		
		ImageParam param = new ImageParam();
		if (oecg.getRrinterval() != null	&& !(oecg.getRrinterval().trim()).isEmpty()) {
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
	 * @Title:getPulseChartData 
	 * @Description:脉搏图数据加载
	 * @author 陈哲
	 * @param model
	 * @param response
	 * @param memberId
	 * @param eventId
	 * @param page
	 * @param pageNo
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */
	@ResponseBody
	@RequestMapping(value="/getPulseChartData", produces="text/plain;charset=UTF-8")
	public String getPulseChartData(Model model, Integer memberId, Long eventId, Integer page, Integer pageNo) {
		Omds omds = getOmdsByCondition(memberId, eventId, pageNo);
		if(omds == null){
			return null;
		}

		Oppg oppg = pulseService.selectElectrocardioPulseByEventId(omds.getEventid());
		model.addAttribute("oppg", oppg);
		
		ImageParam param = new ImageParam();
		if (oppg.getRawppg() != null&& !(oppg.getRawppg().trim()).isEmpty()) {
			param.setRawImage(oppg.getRawppg());
		}
		
		param.setFs(oppg.getFs());
		param.setWidth(1000);
		param.setHeight(300);
		param.setPage(page);
		param.setMeasureTime(oppg.getMeasuretime());
		
		int ppgPage = pulseFileService.getPulsePageByParam(param);
		
		model.addAttribute("ppgPage", ppgPage);
		
		Map<String, Object> map = pulseFileService.getPulseChartFileData(param);
		
		return JSONObject.toJSONString(map);
		
	}
	
	/**
	 * @Title:getInstancePulseRateChartData 
	 * @Description:瞬时脉率图数据加载
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
	@RequestMapping(value="/getInstancePulseRateChartData", produces="text/plain;charset=UTF-8")
	public String getInstancePulseRateChartData(Model model, Integer memberId, Long eventId, Integer page, Integer pageNo) {
		Omds omds = getOmdsByCondition(memberId, eventId, pageNo);
		if(omds == null){
			return null;
		}

		Oppg oppg = pulseService.selectElectrocardioPulseByEventId(omds.getEventid());
		model.addAttribute("oppg", oppg);
		
		ImageParam param = new ImageParam();
		if (oppg.getPpgrr() != null&& !(oppg.getPpgrr().trim()).isEmpty()) {
			param.setRawImage(oppg.getPpgrr());
		}
		
		param.setFs(oppg.getFs());
		param.setWidth(1000);
		param.setHeight(300);
		param.setPage(page);
		param.setMeasureTime(oppg.getMeasuretime());
		
		Map<String, Object> map = pulseFileService.getInstantPulseChartFileData(param);
		
		if(map != null){
			model.addAttribute("hrppgPage", 1);
		}
		
		return JSONObject.toJSONString(map);
	}
	
	/**
	 * @Title:formatTimeLength 
	 * @Description:将时长转换为时分秒
	 * @author 陈哲
	 * @param timeLength
	 * @return 
	 * @throws
	 * @retrun String
	 */
	private String formatTimeLength(Integer timeLength){
		int hour = timeLength / 3600;
		int minute = (timeLength % 3600) / 60;
		int second = (timeLength % 3600) % 60; 
		String format = hour+"时"+minute+"分"+second+"秒";
		return format;
	}
	
	
	/**
	 * @Title:getOmdsByCondition 
	 * @Description:
	 * @author 陈哲
	 * @param memberId
	 * @param eventId
	 * @param pageNo单次测量当前翻页数
	 * @return 
	 * @throws
	 * @retrun Omds
	 */
	private Omds getOmdsByCondition(Integer memberId, Long eventId, Integer pageNo){
		if(pageNo == null){
			pageNo = 0;
		}
		
		Omds omds = null;
		List<Omds> omdsList = pulseService.selectMeasureRecordByPulse(memberId);
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
	
	
	/**
	 * @Title:showAllElectrocardioPulse 
	 * @Description:所有三合一数据
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @param pageSize
	 * @param startTime
	 * @param endTime
	 * @return 
	 * @throws
	 * @retrun String
	 * @throws Exception 
	 */
	@RequestMapping(value="/showAllElectrocardioPulse")
	public String showAllElectrocardioPulse(Model model, Integer memberId,
			Long eventId, Integer pageNo, Integer pageSize, Date startTime,
			Date endTime, Integer flag) {
		if(pageNo == null){
			pageNo = 1;
		}
		
		if(pageSize == null){
			pageSize = 10;
		}
		
		//三合一页面有两个入口，分别是会员管理和测量管理，flag用来标记是哪个入口，值为1标识会员管理
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Page<Oecg> page = pulseService.selectElectrocardioPulseAndPage(memberId,pageNo,pageSize,startTime,endTime_);
		
		List<Oecg> oecgs = page.getResult();
		Map<Long, List<String>> map = new HashMap<>();
		List<Oppg> oppglist = new ArrayList<Oppg>();
		for(Oecg oecg : oecgs){
			List<String> abnormals = new ArrayList<String>();
			Oppg oppg = pulseService.selectElectrocardioPulseByEventId(oecg.getEventid());
			oppglist.add(oppg);
			if (oppg != null && oppg.getStatustag() == 2
					&& oppg.getPpgresult() == 1) {
				abnormals.add("脉搏发现异常");
			}
			
			/*if (oecg != null && oecg.getStatustag() == 2
					&& oecg.getEcgresult() == 1) {
				abnormals.add("心电发现异常");
			}*/
			
			List<Ecg2> list = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
			if(list != null && !list.isEmpty()){
				abnormals.add("心电发现异常");
			}
			
			map.put(oecg.getEventid(), abnormals);
		}
		
		String oecgJsonArr = JSONArray.toJSONString(page.getResult());
		String oppgJsonArr = JSONArray.toJSONString(oppglist);
		
		model.addAttribute("map", map);
		model.addAttribute("page", page);
		model.addAttribute("omem", member);
		model.addAttribute("age", age);
		model.addAttribute("eventId", eventId);
		model.addAttribute("oecgJsonArr", oecgJsonArr);
		model.addAttribute("oppgJsonArr", oppgJsonArr);
		
		return "/measure/allSanHeYi";
	}
	
	
	/**
	 * @Title:showSingleElectrocardioInfo 
	 * @Description:三合一弹出框数据  
	 * @author 陈哲
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */
	@ResponseBody
	@RequestMapping(value="/showSingleElectrocardioInfo", produces="text/plain;charset=utf-8")
	public String showSingleElectrocardioInfo(Long docentry) {
		JSONObject jsonObject = new JSONObject();

		Oecg oecg = electrocardioService.selectElectrocardioByDocentry(docentry);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonObject.put("timeLength", oecg.getTimelength());
		jsonObject.put("measTime", sdf.format(oecg.getMeastime()));
		jsonObject.put("heartNum", oecg.getHeartnum());
		jsonObject.put("slowestBeat", oecg.getSlowestbeat());
		jsonObject.put("slowestTime", oecg.getSlowesttime());
		jsonObject.put("fastestBeat", oecg.getFastestbeat());
		jsonObject.put("fastestTime", oecg.getFastesttime());
		jsonObject.put("averageHeart", oecg.getAverageheart());
		
		return jsonObject.toString();
	}
	
	
	/**
	 * @Title:previewElectrocardioPulseReport 
	 * @Description:三合一导出打印预览
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @param eventId
	 * @param flag
	 * @return 
	 * @throws
	 * @retrun String
	 * @throws Exception 
	 */
	@RequestMapping(value="/previewElectrocardioPulseReport")
	public String previewElectrocardioPulseReport(Model model, Integer memberId, Long eventId,boolean flag) {
		Member member = memberService.selectById(memberId);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(member != null){
			ShiroUser shiroUser = getCurentUser();
			if(member.getOrgid().equals(shiroUser.getDept_id())){}
			model.addAttribute("privilege", true);
		}
		
		
		model.addAttribute("org",member.getOrg().getOrgName());
		model.addAttribute("age", age);
		model.addAttribute("omem", member);
		
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(eventId);
		Oppg oppg = pulseService.selectElectrocardioPulseByEventId(eventId);
		
		//获取异常信息
		List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
		List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
		List<OecgExc> oecgExcs = electrocardioExcService.doElectrocardioExcInfo(ecg1s, ecg2s, oecg);

		model.addAttribute("flag", flag);
		model.addAttribute("oecg", oecg);
		model.addAttribute("oppg", oppg);
		model.addAttribute("oecgExcs", oecgExcs);
		
		return "/measure/exportSanHeYiPreview";
	}
	
	
	/**
	 * @Title:getPreviewExcElectrocardioData 
	 * @Description:获取打印预览的异常心电统计数据
	 * @author 陈哲
	 * @param docentry
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@ResponseBody
	@RequestMapping(value="/getPreviewExcElectrocardioStatisData",produces="text/plain;charset=UTF-8")
	public String getPreviewExcElectrocardioStatisData(Long docentry){
		Oecg oecg = electrocardioService.selectElectrocardioByDocentry(docentry);
		List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(docentry);
		List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(docentry);
		List<OecgExc> oecgExcs = electrocardioExcService.doElectrocardioExcInfo(ecg1s, ecg2s, oecg);

		List<OecgExc> list = new ArrayList<OecgExc>();
		for (OecgExc oecgExc : oecgExcs) {
			if (oecgExc.getExpNum() != 0) {
				list.add(oecgExc);
			};
		}
		Object json = JSONArray.toJSON(list);
		
		return json.toString();
	}
	
	/**
	 * @Title:getPreviewExcElectrocardioChartData 
	 * @Description:获取打印预览心电图的异常数据
	 * @author 陈哲
	 * @param objectId
	 * @param docentry
	 * @param measTime
	 * @param page
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun String
	 */
	@ResponseBody
	@RequestMapping(value="/getPreviewExcElectrocardioChartData",produces="text/plain;charset=UTF-8")
	public String getPreviewExcElectrocardioChartData(String objectId,Long docentry, Long measTime, Integer page) {
		if(page == null){
			page = 0;
		}
		
		Oecg oecg = electrocardioService.selectElectrocardioByDocentry(docentry);
		ImageParam param = new ImageParam();
		
		if(objectId != null && objectId != ""){
			param.setRawImage(objectId);
			param.setFs(oecg.getFs());
			param.setWidth(1000);
			param.setHeight(300);
			param.setPage(page);
			param.setMeasureTime(new Date(measTime));
			param.setDeviceCode(oecg.getDevicecode());
			
			Map<String, Object> map = electrocardioFileService.getExcElectrocardioChartFileData(param);
			
			return JSONObject.toJSONString(map);
		}
		return null;
	}
	
	
	/**
	 * @Title:getElectrocardioPulseSVGData 
	 * @Description:从前端获取心电图svg字符串，并保存在session
	 * @author 陈哲
	 * @param request
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@ResponseBody
	@RequestMapping(value="/getElectrocardioPulseSVGData")
	public String getElectrocardioPulseSVGData(HttpServletRequest request){
		String jsonStr = request.getParameter("jsonStr");
		String jsonStrEcg = request.getParameter("jsonStrEcg");
		Object jsonObj = JSONObject.toJSON(jsonStr);
		Object jsonObjEcg = JSONObject.toJSON(jsonStrEcg);

		request.getSession().setAttribute("jsonObj", jsonObj);
		request.getSession().setAttribute("jsonObjEcg", jsonObjEcg);
		
		return "1";
	}
	
	
	/**
	 * @Title:exportElectrocardioPulseWordData 
	 * @Description:导出三合一word数据 
	 * @author 陈哲
	 * @param request
	 * @param response
	 * @param memberId
	 * @param eventId
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */
	@RequestMapping(value="/exportElectrocardioPulseWordData")
	public void exportElectrocardioPulseWordData(HttpServletRequest request, HttpServletResponse response, Integer memberId, Long eventId){
		//从session中获取getElectrocardioPulseSVGData方法保存的心电svg字符串
		JSONObject jsonObj = JSONObject.parseObject((String)request.getSession().getAttribute("jsonObj"));
		JSONObject jsonObjEcg = JSONObject.parseObject((String)request.getSession().getAttribute("jsonObjEcg"));

		Map<String ,Object> dataMap = getDataByElectrocardioPulse(memberId, eventId);
		
		if(jsonObj.get("shy_exc").equals(true)){
			JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
			List<String> svgList = new ArrayList<String>();
			for(int j=0;j<jsonArrSvg.size();j++){
				String svgStr = jsonArrSvg.getString(j);
				svgList.add(exportWordService.doImage(svgStr, request));
			}
			dataMap.put("svgs", svgList);
		}else{
			dataMap.put("svgs", null);
		}
		
		String jsonEcgStr =  (String)jsonObjEcg.get("svgEcg");
		if(!"".equals(jsonEcgStr)){
			StringBuffer url = request.getRequestURL();
			String imgPath = url.substring(0, url.indexOf(request.getContextPath())) + request.getContextPath() +"\\img\\icnFullScr.png";
			String dosvgStr = jsonEcgStr.replace("../img/icnFullScr.png",imgPath).replaceAll("\\\\", "/");
			dataMap.put("svgEcg", exportWordService.doImage(dosvgStr, request));
		}else{
			dataMap.put("svgEcg", null);
		}
		
		String exportFileName = new SimpleDateFormat("yyyyMMddHH:mm:ss").format(new Date());
		exportWordService.ExportWord(request, response, dataMap, exportFileName, "shy.ftl");
	}
	
	
	/**
	 * 
	 * @Title:getDataByElectrocardioPulse 
	 * @Description:组装数据成map，供word模板ftl文件使用
	 * @author 陈哲
	 * @param memberId
	 * @param eventId
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 * @throws Exception 
	 */
	private Map<String, Object> getDataByElectrocardioPulse(Integer memberId, Long eventId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Member member = memberService.selectById(memberId);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Oecg oecg = electrocardioService.selectElectrocardioByEventId(eventId);
		Oppg oppg = pulseService.selectElectrocardioPulseByEventId(eventId);

		//获取异常信息
		List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
		List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
		List<OecgExc> oecgExcs = electrocardioExcService.doElectrocardioExcInfo(ecg1s, ecg2s, oecg);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String measureTimes = sdf.format(oecg.getMeastime());
		dataMap.put("org", member.getOrg().getOrgName());
		dataMap.put("omem", member);
		dataMap.put("age", age);
		dataMap.put("gender", "1".equals(member.getGender()) ? "男" : "2".equals(member.getGender()) ? "女" : "未知");
		dataMap.put("measureTime",measureTimes);
		dataMap.put("oecgExcs", oecgExcs);
		dataMap.put("oecg", oecg);
		dataMap.put("oppg", oppg);
		
		return dataMap;
	}
	
	public void getReportPageData(ModelMap model, List<Oecg> oecgs, List<Oppg> oppgs){
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
		
		if(oppgs != null && oppgs.size() > 0){
			for(Oppg oppg:oppgs){
				oppg.setExcOppgs(getExcPulseInfo(oppg));
				oppg.setOecg(electrocardioService.selectElectrocardioByEventId(oppg.getEventid()));
			}
			
			//获取测量数据的异常信息
			for(Oecg oecg:oecgs){
				oecg = getEcg2ByOecg(oecg);
				//获取该条心电数据对应的脉搏数据
				Oppg  oppg  = pulseService.selectOppgByOecg(oecg.getDocentry());
				if(oppg != null && oppg.getStatustag() == 2){
					oppg.setExtName(oppg.getMeasureResult());
				}
				oecg.setOppg(oppg);
			}
		}

		model.addAttribute("oecgs", oecgs);
		model.addAttribute("oppgs", oppgs);
	}
	
	public void getReportExportPageData(ModelMap model, String oecgsJson, String oppgsJson){
		List<Oppg> oppgs = JSONObject.parseArray(oppgsJson, Oppg.class);
		List<Oecg> oecgs = JSONObject.parseArray(oecgsJson, Oecg.class);
		
		Iterator<Oecg> its = oecgs.iterator();
		while(its.hasNext()){
			Oecg oecg = its.next();
			if(oecg.getStatustag() == null || oecg.getStatustag() < 2){
				its.remove();
			}
		}
		
		Iterator<Oppg> it = oppgs.iterator();
		while(it.hasNext()){
			Oppg oppg = it.next();
			if(oppg.getStatustag() == null || oppg.getStatustag() < 2){
				it.remove();
			}
		}
		
		if (oecgs != null && oecgs.size() > 0 && oppgs != null && oppgs.size() > 0) {
			Map<String, List<OecgExc>> map = new HashMap<String, List<OecgExc>>();
			List<OecgExc> oecgExcs = reportIFService.doElectrocardioReportData(oecgs, map);
			model.addAttribute("ecg12s_tab3", oecgExcs);
			model.addAttribute("ecg12s_3", JSONObject.toJSONString(map));
			
		}
	}
	
	@RequestMapping(value="/getReportSHYDetail")
	public String getReportSHYDetail(ModelMap model, String oecgsJson, String oppgsJson, Integer memberid) throws Exception{
		List<Oppg> oppgs = JSONObject.parseArray(oppgsJson, Oppg.class);
		List<Oecg> oecgs = JSONObject.parseArray(oecgsJson, Oecg.class);
		getReportPageData(model, oecgs, oppgs);
		
		MemberExt member = memberService.selectMemberExtById(memberid);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("oecgsJson", oecgsJson);
		model.addAttribute("oppgsJson", oppgsJson);
		model.addAttribute("omem",member);
		model.addAttribute("age", age);

		return "measure/sanheYiRep";
	}
	
	@RequestMapping(value="/getReportSHYPreview")
	public String getReportSHYPreview(ModelMap model, String oecgsJson, String oppgsJson, Integer memberid) throws Exception{
		List<Oppg> oppgs = JSONObject.parseArray(oppgsJson, Oppg.class);
		List<Oecg> oecgs = JSONObject.parseArray(oecgsJson, Oecg.class);
		
		getReportPageData(model, oecgs, oppgs);
		getReportExportPageData(model, oecgsJson, oppgsJson);
		
		
		MemberExt member = memberService.selectMemberExtById(memberid);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("oecgsJson", oecgsJson);
		model.addAttribute("oppgsJson", oppgsJson);
		model.addAttribute("omem",member);
		model.addAttribute("age", age);
		
		return "measure/exportPreviewSHYRep";
	}
	
    @ResponseBody
	@RequestMapping(value="/getPreviewAbecgData",produces="text/plain;charset=UTF-8")
    public String getPreviewAbecgData(String objectId, Long docentry, Long measTime) throws Exception{
		Oecg oecg = electrocardioService.selectElectrocardioByDocentry(docentry);
		
		ImageParam param = new ImageParam();
		param.setRawImage(objectId.replaceAll("'", ""));
		param.setFs(oecg.getFs());
		param.setWidth(1000);
		param.setHeight(300);
		param.setPage(1);
		param.setMeasureTime(new Date(measTime));
		param.setDeviceCode(oecg.getDevicecode());

		param.setType("ab_ecg"); 
		
		Map<String, Object> map = electrocardioFileService.getExcElectrocardioChartFileData(param);
		
		return JSONObject.toJSONString(map);
	}
	
	@ResponseBody
    @RequestMapping(value = "/getElectrocardioPulseChart",produces = "plain/text; charset=UTF-8")
	public String getElectrocardioPulseRepChart(String oecgsJson, boolean flag){
		List<Oecg> oecgs = JSONObject.parseArray(oecgsJson, Oecg.class);
		JSONArray jsonArr = new JSONArray();
		//三合一24小时异常心电分布图
		jsonArr.add(chartService.selectElectrocardioPulseExcTrendChartJson(oecgs));
		//三合一异常心电柱状图
		jsonArr.add(chartService.selectElectrocardioPulseExcBarChartJson(oecgs));
		//24小时脉搏指标分布图
		jsonArr.add(chartService.selectPulseIndicatorsTrendChartJson(oecgs));
		//异常脉搏指标柱状图
		jsonArr.add(chartService.selectPulseIndicatorsExcBarChartJson(oecgs));
		
		if(flag){
			jsonArr.add(chartService.selectPulseAllTrends(oecgs));
		}
		
		return jsonArr.toString();
	}
	
	 private List<ExcOppg> getExcPulseInfo(Oppg oppg){
			List<ExcOppg> list = new ArrayList<ExcOppg>();
			if(oppg.getPulserate() == null){
				oppg.setPulserate((short)0);
			}
			if(oppg.getPulserate() < 55){
				ExcOppg exc = new ExcOppg();
				exc.setName("平均脉率");
				exc.setValue(oppg.getPulserate());
				exc.setResult("偏低");
				list.add(exc);
			}else if(oppg.getPulserate() > 100){
				ExcOppg exc = new ExcOppg();
				exc.setName("平均脉率");
				exc.setValue(oppg.getPulserate());
				exc.setResult("偏低");
				list.add(exc);
			}
			
			if(oppg.getCo() == null){
				oppg.setCo(BigDecimal.ZERO);
			}
			if(oppg.getCo().compareTo(new BigDecimal(3)) < 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("平均每分射血量");
				exc.setValue(oppg.getCo().doubleValue());
				exc.setResult("偏低");
				list.add(exc);
			}else if(oppg.getCo().compareTo(new BigDecimal(7.5)) > 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("平均每分射血量");
				exc.setValue(oppg.getCo().doubleValue());
				exc.setResult("偏高");
				list.add(exc);
			}
			
			if(oppg.getSv() == null){
				oppg.setSv(BigDecimal.ZERO);
			}
			if(oppg.getSv().compareTo(new BigDecimal(55)) < 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("心脏每搏射血量");
				exc.setValue(oppg.getSv().doubleValue());
				exc.setResult("偏低");
				list.add(exc);
			}else if(oppg.getSv().compareTo(new BigDecimal(105)) > 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("心脏每搏射血量");
				exc.setValue(oppg.getSv().doubleValue());
				exc.setResult("偏高");
				list.add(exc);
			}
			
			if(oppg.getSpo() == null){
				oppg.setSpo((short)0);
			}
			if(oppg.getSpo() < 95){
				ExcOppg exc = new ExcOppg();
				exc.setName("血氧饱和度");
				exc.setValue(oppg.getSpo());
				exc.setResult("偏低");
				list.add(exc);
			}else if(oppg.getSpo() > 100){
				ExcOppg exc = new ExcOppg();
				exc.setName("血氧饱和度");
				exc.setValue(oppg.getSpo());
				exc.setResult("偏高");
				list.add(exc);
			}
			
			if(oppg.getCi() == null){
				oppg.setCi(BigDecimal.ZERO);
			}
			if(oppg.getCi().compareTo(new BigDecimal(2.3)) < 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("心指数");
				exc.setValue(oppg.getCi().doubleValue());
				exc.setResult("偏低");
				list.add(exc);
			}else if(oppg.getCi().compareTo(new BigDecimal(100)) > 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("心指数");
				exc.setValue(oppg.getCi().doubleValue());
				exc.setResult("偏高");
				list.add(exc);
			}
			
			if(oppg.getSpi() == null){
				oppg.setSpi(BigDecimal.ZERO);
			}
			if(oppg.getSpi().compareTo(new BigDecimal(33)) < 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("心搏指数");
				exc.setValue(oppg.getSpi().doubleValue());
				exc.setResult("偏低");
				list.add(exc);
			}else if(oppg.getSpi().compareTo(new BigDecimal(200)) > 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("心搏指数");
				exc.setValue(oppg.getSpi().doubleValue());
				exc.setResult("偏低");
				list.add(exc);
			}
			
			if(oppg.getK() == null){
				oppg.setK(BigDecimal.ZERO);
			}
			if(oppg.getK().compareTo(new BigDecimal(0.29)) < 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("波形特征量");
				exc.setValue(oppg.getK().doubleValue());
				exc.setResult("偏低");
				list.add(exc);
			}else if(oppg.getK().compareTo(new BigDecimal(0.46)) > 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("波形特征量");
				exc.setValue(oppg.getK().doubleValue());
				exc.setResult("偏高");
				list.add(exc);
			}
			
			if(oppg.getV() == null){
				oppg.setV(BigDecimal.ZERO);
			}
			if(oppg.getV().compareTo(new BigDecimal(3)) < 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("血液黏度");
				exc.setValue(oppg.getV().doubleValue());
				exc.setResult("偏低");
				list.add(exc);
			}else if(oppg.getV().compareTo(new BigDecimal(5.04)) > 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("血液黏度");
				exc.setValue(oppg.getV().doubleValue());
				exc.setResult("偏高");
				list.add(exc);
			}
			
			if(oppg.getTpr() == null){
				oppg.setTpr(BigDecimal.ZERO);
			}
			if(oppg.getTpr().compareTo(new BigDecimal(750)) < 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("外周阻力");
				exc.setValue(oppg.getTpr().doubleValue());
				exc.setResult("偏低");
				list.add(exc);
			}else if(oppg.getTpr().compareTo(new BigDecimal(1450)) > 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("外周阻力");
				exc.setValue(oppg.getTpr().doubleValue());
				exc.setResult("偏高");
				list.add(exc);
			}
			
			if(oppg.getAc() == null){
				oppg.setAc(BigDecimal.ZERO);
			}
			if(oppg.getAc().compareTo(new BigDecimal(1.2)) < 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("血管顺应度");
				exc.setValue(oppg.getAc().doubleValue());
				exc.setResult("偏低");
				list.add(exc);
			}else if(oppg.getAc().compareTo(new BigDecimal(3)) > 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("血管顺应度");
				exc.setValue(oppg.getAc().doubleValue());
				exc.setResult("偏高");
				list.add(exc);
			}
			
			if(oppg.getPm() == null){
				oppg.setPm(BigDecimal.ZERO);
			}
			if(oppg.getPm().compareTo(new BigDecimal(70)) < 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("平均动脉压");
				exc.setValue(oppg.getPm().doubleValue());
				exc.setResult("偏低");
				list.add(exc);
			}else if(oppg.getPm().compareTo(new BigDecimal(105)) > 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("平均动脉压");
				exc.setValue(oppg.getPm().doubleValue());
				exc.setResult("偏高");
				list.add(exc);
			}
			
			if(oppg.getSi() == null){
				oppg.setSi(BigDecimal.ZERO);
			}
			if(oppg.getSi().compareTo(new BigDecimal(0)) < 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("血管硬化指数");
				exc.setValue(oppg.getSi().doubleValue());
				list.add(exc);
			}else if(oppg.getSi().compareTo(new BigDecimal(8)) > 0){
				ExcOppg exc = new ExcOppg();
				exc.setName("血管硬化指数");
				exc.setValue(oppg.getSi().doubleValue());
				exc.setResult("偏高");
				list.add(exc);
			}
			return list;
	    }
	 
	 private Oecg getEcg2ByOecg(Oecg oecg){
			List<Ecg2> list = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
			for(Ecg2 ecg2:list){
				ecg2.setAbnCname(ElectrocardioType.getTypeChinaName(ecg2.getAbnname()));
			}
			oecg.setEcg2s(list);
			return oecg;
		};
		
	@ResponseBody
	@RequestMapping(value="/getReportSVGData")
	public String getReportSVGData(HttpServletRequest request){
		String jsonStr = request.getParameter("jsonStr");
		Object jsonObj = JSONObject.toJSON(jsonStr);

		request.getSession().setAttribute("jsonArr", jsonObj);
		
		return "1";
	}
	
	public Map<String, Object> getExportWordSHYData(List<Oecg> oecgs, List<Oppg> oppgs){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		Iterator<Oecg> its = oecgs.iterator();
		while(its.hasNext()){
			Oecg oecg = its.next();
			if(oecg.getStatustag() == null || oecg.getStatustag() < 2){
				its.remove();
			}
		}
		
		Iterator<Oppg> it = oppgs.iterator();
		while(it.hasNext()){
			Oppg oppg = it.next();
			if(oppg.getStatustag() == null || oppg.getStatustag() < 2){
				it.remove();
			}
		}
		
		if (oecgs != null && oecgs.size() > 0 && oppgs != null && oppgs.size() > 0) {
			Map<String, List<OecgExc>> map = new HashMap<String, List<OecgExc>>();
			List<OecgExc> oecgExcs = doElectrocardioReportData(oecgs, map);
			dataMap.put("ecg12s_tab3", oecgExcs);
			dataMap.put("ecg12s_3", JSONObject.toJSONString(map));
			
		}
		return dataMap;
	} 
	
	public void getReportPageData(Map<String, Object> dataMap, String oecgsJson, String oppgsJson){
		List<Oecg> oecgs = JSONObject.parseArray(oecgsJson, Oecg.class);
		List<Oppg> oppgs = JSONObject.parseArray(oppgsJson, Oppg.class);
		
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
		
		if(oppgs != null && oppgs.size() > 0){
			for(Oppg oppg:oppgs){
				oppg.setExcOppgs(getExcPulseInfo(oppg));
				oppg.setOecg(electrocardioService.selectElectrocardioByEventId(oppg.getEventid()));
			}
			
			//获取测量数据的异常信息
			for(Oecg oecg:oecgs){
				oecg = getEcg2ByOecg(oecg);
				//获取该条心电数据对应的脉搏数据
				Oppg  oppg  = pulseService.selectOppgByOecg(oecg.getDocentry());
				if(oppg != null && oppg.getStatustag() == 2){
					oppg.setExtName(oppg.getMeasureResult());
				}
				oecg.setOppg(oppg);
			}
		}

		dataMap.put("oecgs", oecgs);
		dataMap.put("oppgs", oppgs);
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
	public void exportReportWord(HttpServletRequest request, HttpServletResponse response, String oecgsJson, String oppgsJson, Integer memberId, Date generTime) throws Exception{
		List<Oecg> oecgs = JSONObject.parseArray(oecgsJson, Oecg.class);
		List<Oppg> oppgs = JSONObject.parseArray(oppgsJson, Oppg.class);
		
		//从session中获取svg字符串
		JSONArray jsonArr = JSONArray.parseArray((String)request.getSession().getAttribute("jsonArr"));
		Map<String ,Object> dataMap = getExportWordSHYData(oecgs, oppgs);
		//处理oppg信息，并保存在dataMap集合中
		getReportPageData(dataMap, oecgsJson, oppgsJson);
		for(int i=0;i<jsonArr.size();i++){
			JSONObject jsonObj =jsonArr.getJSONObject(i);
			Set<String> keys = jsonObj.keySet(); 
			for(String key : keys){
				if("shy_tab1".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("shy_tab2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("shy_tab3".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("shy_chart1".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("shy_chart1_svg", exportWordService.doImage(svgStr, request));
				}else if("shy_chart2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("shy_chart2_svg", exportWordService.doImage(svgStr, request));
				}else if("shy_chart3".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					List<String> svgList = new ArrayList<String>();
					for(int j=0;j<jsonArrSvg.size();j++){
						String svgStr = jsonArrSvg.getString(j);
						svgList.add(exportWordService.doImage(svgStr, request));					
					}
					dataMap.put("shy_chart3_svgs", svgList);
				}else if("shy_chart4".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("shy_chart4_svg", exportWordService.doImage(svgStr, request));				
				}else if("shy_chart5".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");			
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("shy_chart5_svg", exportWordService.doImage(svgStr, request));
				}else if("shy_chart6".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					List<String> svgList = new ArrayList<String>();
					for(int j=0;j<jsonArrSvg.size();j++){
						String svgStr = jsonArrSvg.getString(j);
						svgList.add(exportWordService.doImage(svgStr, request));
					}
					dataMap.put("shy_chart6_svgs", svgList);
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
		
		String exportFileName = member.getMemname() + "的三合一测量报告" + new SimpleDateFormat("yyyyMMdd").format(new Date());
		exportWordService.ExportWord(request, response, dataMap, exportFileName, "shyRep.ftl");
	}
	
}

