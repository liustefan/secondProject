 
/**
 * @PackageName:      com.bithealth.measure
 * @FileName:     MeasureRecordController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年8月22日 下午4:08:28  
 * 
 */

package com.bithealth.measure;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarService;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.common.service.OmdsService;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.measureCore.electrocardioPulse.service.PulseService;
import com.bithealth.sdk.common.utils.Util;
import com.bithealth.sdk.web.controller.BaseSpringController;


/**
 * 类名称: MeasureRecordController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月22日 下午4:08:28 
 * 
 * @author 陈哲
 * @version  
 */
@Controller
@RequestMapping("/measureRecord")
public class MeasureRecordController extends BaseSpringController {
	
	@Autowired
	private OmdsService omdsService;
	
	@Autowired
	private BloodPressureService BloodPressureService;
	
	@Autowired
	private BloodSugarService bloodSugarService;
	
	@Autowired
	private PulseService pulseService;
	
	@Autowired
	private ElectrocardioService electrocardioService;
	
	@RequestMapping(value="/getLastestOmds")
	public void toContent(HttpServletResponse response) throws IOException{
		List<Omds> omdsList = omdsService.getLastestMeasList(getCurentUser().getId(), getCurentUser().getDept_id());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JSONArray jsonArr = new JSONArray();
		for(Omds omds : omdsList){
			JSONObject obj = new JSONObject();
			obj.put("memberId", omds.getMemberid());
			obj.put("eventId", omds.getEventid());
			obj.put("measTime", sdf.format(omds.getMeasureTime()));
			obj.put("name", omds.getMember().getMemname());
			obj.put("typeName", omds.getTypeName());
			jsonArr.add(obj);
		}
		response.getWriter().print(jsonArr.toString());
	}
	
	/**
	 * @Title:toMeasStatisPage 
	 * @Description:统计前三个月的测量数据
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @return
	 * @throws ParseException 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/toMeasStatisPage")
	public String toMeasStatisPage(Model model,Integer memberId) throws ParseException{
		String [] strs=new String[3];
		Integer [] reps=new Integer [32];
		
		strs[0] = Util.getYearMonth(2);
		strs[1] = Util.getYearMonth(1);
		strs[2] = Util.getYearMonth(0);
		
		reps[0] = getMeasCount(1,false,2,memberId);
		reps[1] = getMeasCount(1,false,1,memberId);
		reps[2] = getMeasCount(1,false,0,memberId);
		reps[3] = reps[0] + reps[1] + reps[2];
		reps[4] = getMeasCount(1,true,2,memberId);
		reps[5] = getMeasCount(1,true,1,memberId);
		reps[6] = getMeasCount(1,true,0,memberId);
		reps[7] = reps[4] + reps[5] + reps[6];
		
		reps[8] = getMeasCount(2,false,2,memberId);
		reps[9] = getMeasCount(2,false,1,memberId);
		reps[10] = getMeasCount(2,false,0,memberId);
		reps[11] = reps[8] + reps[9] + reps[10];
		reps[12] = getMeasCount(2,true,2,memberId);
		reps[13] = getMeasCount(2,true,1,memberId);
		reps[14] = getMeasCount(2,true,0,memberId);
		reps[15] = reps[12] + reps[13] + reps[14];
		
		reps[16] = getMeasCount(3,false,2,memberId);
		reps[17] = getMeasCount(3,false,1,memberId);
		reps[18] = getMeasCount(3,false,0,memberId);
		reps[19] = reps[16] + reps[17] + reps[18];
		reps[20] = getMeasCount(3,true,2,memberId);
		reps[21] = getMeasCount(3,true,1,memberId);
		reps[22] = getMeasCount(3,true,0,memberId);
		reps[23] = reps[20] + reps[21] + reps[22];
		
		reps[24] = getMeasCount(4,false,2,memberId);
		reps[25] = getMeasCount(4,false,1,memberId);
		reps[26] = getMeasCount(4,false,0,memberId);
		reps[27] = reps[24] + reps[25] + reps[26];
		reps[28] = getMeasCount(4,true,2,memberId);
		reps[29] = getMeasCount(4,true,1,memberId);
		reps[30] = getMeasCount(4,true,0,memberId);
		reps[31] = reps[28] + reps[29] + reps[30];
		
		model.addAttribute("reps", reps);
		model.addAttribute("strs", strs);
		
		return "/audit/memMesureStatistl";
	}
	
	/**
	 * @Title:getMeasCount 
	 * @Description:
	 * @author 陈哲
	 * @param type 当值为1，则是血压数据；当值为2，则是血糖数据；当值为3，则是三合一数据；当值为4，则是动态心电数据；
	 * @param exc 当值为false，则统计时间段内所有测量数据（包括异常和非异常）数量；当值为true，则统计时间段内异常测量数据的数量
	 * @param n
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun Integer
	 */
	private Integer getMeasCount(int type, boolean exc, int n, Integer memberId){
		Timestamp date2 = null;
		Timestamp date1 = null;
		try {
			date2 = Util.getYearAndMonth(n);
			date1 = Util.getYearAndMonth(n+1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(date1 == null || date2 == null){
			return 0;
		}
		
		int count = 0;
		if(exc){
			if(type == 1){
				count = BloodPressureService.selectBloodPressMeasExcCount(memberId, date1, new Timestamp(date2.getTime()-1));
			}else if(type == 2){
				count = bloodSugarService.selectBloodSugarMeasExcCount(memberId, date1, new Timestamp(date2.getTime()-1));
			}else if(type == 3){
				count = pulseService.selectElectrocardioPulseMeasExcCount(memberId, date1, new Timestamp(date2.getTime()-1));
			}else{
				count = electrocardioService.selectElectrocardioMeasExcCount(memberId, date1, new Timestamp(date2.getTime()-1));
			}
		}else{
			if(type == 1){
				count = BloodPressureService.selectBloodPressMeasTotalCount(memberId, date1, new Timestamp(date2.getTime()-1));
			}else if(type == 2){
				count = bloodSugarService.selectBloodSugarMeasTotalCount(memberId, date1, new Timestamp(date2.getTime()-1));
			}else if(type == 3){
				count = pulseService.selectElectrocardioPulseMeasTotalCount(memberId, date1, new Timestamp(date2.getTime()-1));
			}else{
				count = electrocardioService.selectElectrocardioMeasTotalCount(memberId, date1, new Timestamp(date2.getTime()-1));
			}
		}
		return count;
	}
}

