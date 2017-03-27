package com.bithealth.statisti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.Message;
import com.bithealth.SuccessMessage;
import com.bithealth.memberCore.member.service.DiseaseService;
import com.bithealth.orgainCore.model.Org;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;
import com.bithealth.statistiCore.statistic.model.MapVo;
import com.bithealth.statistiCore.statistic.model.MeasureRecord;
import com.bithealth.statistiCore.statistic.model.MeasureStatics;
import com.bithealth.statistiCore.statistic.service.StatisticService;

/**
 * 类名：tatisticController 
 * 描述：统计报表控制层
 * 
 * 时间: 2016/7/20 17:20:35
 * @author 周玉飞
 * @version
 */

@Controller
@RequestMapping(value = "/statistic")
public class StatisticController extends BaseSpringController {
	
	@Autowired
	private StatisticService statisticService;
	@Autowired
	private DiseaseService diseaseService;
	
	/**
	 * 测量状况统计
	 */
	@RequestMapping(value = "/exProcSelectMeasurementStatics")
	public String measurementStatics(@ModelAttribute("mapVo")MapVo mapVo, @ModelAttribute("org")Org org,  
			Page<Map<String,Object>> page, Model model,@ModelAttribute("measure") MeasureRecord measure){
		page.setPageNo(page.getPageNo());
		model.addAttribute("diseases", diseaseService.selectAll_cache());
		if(org != null && org.getOrgId() != null && org.getOrgId() > 0){
			Map<String, Object> map = mapVo.getParamMap();
			map.put("iOrgID", org.getOrgId() == null ? 0: org.getOrgId());
			map.put("cGender", measure.getGender());
			map.put("dSMeasureTime",measure.getsTestTime());
			map.put("dEMeasureTime",measure.geteTestTime());
			map.put("dSBirthDate",measure.getsBirthday());
			map.put("dEBirthDate",measure.geteBirthday());
			map.put("vDiseaseIDList",measure.getDiseaseIds());
			
			Page<Map<String, Object>> values=statisticService.exProcSelectMeasurementStatics(page, map);
			List<MeasureStatics> measureStaticsList = new ArrayList<MeasureStatics>();
			for (Iterator<Map<String,Object>> it = values.getResult().iterator(); it.hasNext();) {
				Map<String, Object> value =it.next();
					MeasureStatics measureStatics = new MeasureStatics();
					map =new HashMap<String, Object>();
					measureStatics.setArea(String.valueOf(value.get("Name")));
					measureStatics.setOsbpNum(Integer.parseInt(value.get("osbp_n1").toString()));
					measureStatics.setOsbpFreq(Integer.parseInt(value.get("osbp_n2").toString()));
					measureStatics.setObsrNum(Integer.parseInt(value.get("obsr_n1").toString()));
					measureStatics.setObsrFreq(Integer.parseInt(value.get("obsr_n2").toString()));
					measureStatics.setOppgNum(Integer.parseInt(value.get("oppg_n1").toString()));
					measureStatics.setOppgFreq(Integer.parseInt(value.get("oppg_n2").toString()));
					measureStatics.setOecgNum(Integer.parseInt(value.get("oecg_n1").toString()));
					measureStatics.setOecgFreq(Integer.parseInt(value.get("oecg_n2").toString()));
					measureStaticsList.add(measureStatics);
			}
			Page<MeasureStatics> nPage = new Page<MeasureStatics>();
			nPage.setResult(measureStaticsList);
			nPage.setPageSize(page.getPageSize());
			nPage.setPageNo(page.getPageNo());
			nPage.setTotalPages(page.getTotalPages());
			nPage.setTotalCount(page.getTotalCount());
			model.addAttribute("page", nPage);
		}
		ShiroUser user = getCurentUser();
		if(!user.getRoleid().equals(6)){
			org.setOrgId(user.getDept_id());
			org.setOrgName(user.getOrgName());
		}
		return "statistic/MeasurementStatistics";
		
	}
	
	/**
	 * 人口基本状况
	 */
	@RequestMapping(value = "/exProSelectPopulation")
	public @ResponseBody Message exProSelectPopulation(Integer orgId){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iOrgID", orgId == null ? getCurentUser().getDept_id(): orgId);
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> values = statisticService.exProcSelectPopulation(map);
		for(Iterator<Map<String, Object>> it = values.iterator(); it.hasNext();){
			Map<String, Object> value = it.next();
			map = new HashMap<String, Object>();
			map.put("placeName", value.get("Name"));
			map.put("populationCount",value.get("total"));
			map.put("age65", value.get("sixtyfive_sum"));
			map.put("hypertensionCount", value.get("hypertension_sum"));
			map.put("diabetes", value.get("diabetes_sum"));
			list.add(map);
		}
		return new SuccessMessage(list);
		
	}
	
	/**
	 * 统计老年人接受健康管理状况
	 */
	@RequestMapping(value = "/exProSelectElderlyHealthManagement")
	public @ResponseBody Message exProSelectElderlyHealthManagement(Integer orgId,Integer year) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iOrgID", orgId == null ? getCurentUser().getDept_id(): orgId);
		map.put("iYear", year);
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> values=statisticService.exProcSelectElderlyHealthManagement(map);
		for (Iterator<Map<String, Object>> it =values.iterator(); it.hasNext();){
			Map<String, Object> value =it.next();
			map = new HashMap<String, Object>();
			map.put("placeName", value.get("Name"));
			map.put("total", value.get("total"));
			map.put("noHealthManage",value.get("noaccept_sum"));
			list.add(map);
		}
		return new SuccessMessage(list);
	}
	
	/**
	 * 统计老年人年度体检状况
	 */
	@RequestMapping(value="/exProSelectElderlyHealthByYear")
	public @ResponseBody Message exProSelectElderlyHealthByYear(Integer orgId,Integer year) {
		List<Map<String, Object>> list =new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iOrgID", orgId == null ? getCurentUser().getDept_id(): orgId);
		map.put("iYear", year);
		List<Map<String, Object>> values=statisticService.exProcSelectElderlyHealthByYear(map);
		for (Iterator<Map<String, Object>> it =values.iterator(); it.hasNext();){
			Map<String, Object> value =it.next();
			map = new HashMap<String, Object>();
			map.put("placeName", value.get("Name"));
			map.put("total", value.get("total"));
			map.put("noCheckUp",value.get("noexam_sum"));
			list.add(map);
		}
		return new SuccessMessage(list);
		
	}
	
	/**
	 * 统计高血压随访
	 */
	@RequestMapping(value="/exProSelectHypertensionVisit")
	public @ResponseBody Message exProSelectHypertensionVisit(Integer orgId,Integer year) {
		List<Map<String, Object>> list =new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iOrgID", orgId == null ? getCurentUser().getDept_id(): orgId);
		map.put("iYear", year);
		List<Map<String, Object>> values=statisticService.exProcSelectHypertensionVisit(map);
		for (Iterator<Map<String, Object>> iterator =values.iterator(); iterator.hasNext();){
			map = new HashMap<String, Object>();
			Map<String, Object> value =iterator.next();
			map.put("placeName", value.get("Name"));
			map.put("total", value.get("total"));
			map.put("totalManageOneYear",value.get("manage_sum"));
			map.put("normManage", value.get("rule_sum"));
			map.put("newCustome",value.get("newadd_sum"));
			map.put("hypertensionOk", value.get("lastnormal_sum"));
			list.add(map);
		}
		return new SuccessMessage(list);
		
	}
	
	/**
	 * 统计糖尿病随访
	 */
	@RequestMapping(value="/exProSelectDiabetesVisit")
	public @ResponseBody Message exProSelectDiabetesVisit(Integer orgId,Integer year) {
		List<Map<String, Object>> list =new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iOrgID", orgId == null ? getCurentUser().getDept_id(): orgId);
		map.put("iYear", year);
		List<Map<String, Object>> values=statisticService.exProcSelectDiabetesVisit(map);
		for (Iterator<Map<String, Object>> iterator =values.iterator(); iterator.hasNext();){
			Map<String, Object> value =iterator.next();
			map = new HashMap<String, Object>();
			map.put("placeName",value.get("Name"));
			map.put("total", value.get("total"));
			map.put("totalManageOneYear",value.get("manage_sum"));
			map.put("normManage",value.get("rule_sum"));
			map.put("newCustome", value.get("newadd_sum"));
			map.put("glycuresisOk", value.get("lastnormal_sum"));
			list.add(map);
		}
		return new SuccessMessage(list);
		
	   }

}
