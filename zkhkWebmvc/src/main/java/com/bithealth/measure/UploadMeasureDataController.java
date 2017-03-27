 
/**
 * @PackageName:      com.bithealth.measure
 * @FileName:     UploadMeasureDataController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年8月4日 下午1:44:32  
 * 
 */

package com.bithealth.measure;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bithealth.careCore.facade.model.MsgCenter;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureUploadService;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarUploadService;
import com.bithealth.measureCore.constant.Constant;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioFileService;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.service.PulseFileService;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.msgCenterCore.constants.UserTypeEnum;
import com.bithealth.sdk.web.controller.BaseSpringController;


/**
 * 类名称: UploadMeasureDataController  
 * 功能描述: 上传血压、血糖、三合一、动态心电数据
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月4日 下午1:44:32 
 * 
 * @author 陈哲
 * @version  
 */
@Controller
@RequestMapping("/uploadMeasData")
public class UploadMeasureDataController extends BaseSpringController{
	@Autowired
	private ElectrocardioFileService electrocardioFileService;
	
	@Autowired
	private PulseFileService pulseFileService;
	
	@Autowired
	private BloodPressureUploadService bloodPressureUploadService;
	
	@Autowired
	private BloodSugarUploadService bloodSugarUploadService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private DoctorService doctorService;
	
	/**
	 * @Title:showUploadMeasDataPage 
	 * @Description:跳转到上传文件页面  
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/showUploadMeasPage")
	public String showUploadMeasDataPage(Model model, Integer memberId){
		Member member = memberService.selectById(memberId);
		model.addAttribute("uploadShow", "ecg");
		model.addAttribute("memberId", memberId);
		model.addAttribute("member", member);
		
		return "/measure/UploadMeasureData";
	}
	
	
	/**
	 * @Title:uploadBloodPresData 
	 * @Description:上传血压数据 
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @param timePeriod1
	 * @param sbp
	 * @param dbp
	 * @param pulseRate
	 * @param startTime2
	 * @param deviceCode1
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/uploadBloodPresData")
	public String uploadBloodPresData(Model model, Integer memberId,
			String timePeriod1, Integer sbp, Integer dbp, Integer pulseRate,
			Date startTime2, String deviceCode1) {
		Member member = memberService.selectById(memberId);
		
		Osbp osbp = new Osbp();
		osbp.setMemberid(memberId);
		osbp.setTimeperiod(timePeriod1);
		osbp.setSbp(sbp);
		osbp.setDbp(dbp);
		osbp.setPulserate(pulseRate);
		osbp.setDevicecode(deviceCode1);
		osbp.setTesttime(startTime2);
		
		MsgCenter mc = new MsgCenter();
		mc.setMsgtype(MessageTypeEnum.BLOOD_PRESSURE.getType());
		mc.setSendtype(UserTypeEnum.DOCTOR.getType());
		mc.setSender(member.getMemberGUID());
	
		
		osbp.setMsgCenter(mc);
		try {
			bloodPressureUploadService.saveBloodPress(osbp);
			
			model.addAttribute("uploadOsbp", "上传成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("uploadOsbp", "上传失败");
		}
		model.addAttribute("uploadShow", "osbp");
		model.addAttribute("memberId", memberId);
		
		return "/measure/UploadMeasureData";
	}
	
	
	/**
	 * @Title:uploadBloodSugarData 
	 * @Description:上传血糖数据  
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @param timePeriod2
	 * @param bsValue
	 * @param startTime3
	 * @param deviceCode2
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/uploadBloodSugarData")
	public String uploadBloodSugarData(Model model, Integer memberId,
			String timePeriod2, Double bsValue, Date startTime3,
			String deviceCode2) {
		Member member = memberService.selectById(memberId);
		
		Obsr obsr = new Obsr();
		obsr.setMemberid(memberId);
		obsr.setTimeperiod(timePeriod2);
		obsr.setBsvalue(bsValue);
		obsr.setTesttime(startTime3);
		obsr.setDevicecode(deviceCode2);
		
		MsgCenter mc = new MsgCenter();
		mc.setMsgtype(MessageTypeEnum.BLOOD_SUGAR.getType());
		mc.setSendtype(UserTypeEnum.DOCTOR.getType());
		mc.setSender(member.getMemberGUID());
		
		obsr.setMsgCenter(mc);
		
		try {
			bloodSugarUploadService.saveBloodSugar(obsr);
			
			model.addAttribute("uploadObsr", "上传成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("uploadObsr", "上传失败");
		}
		model.addAttribute("uploadShow", "obsr");
		model.addAttribute("memberId", memberId);
		
		return "/measure/UploadMeasureData";
	}
	
	
	/**
	 * @Title:uploadElectrocardioPulseData 
	 * @Description:上传三合一数据
	 * @author 陈哲
	 * @param model
	 * @param fileField1
	 * @param fileField2
	 * @param memberId
	 * @param spo
	 * @param startTime1
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/uploadElectrocardioPulseData")
	public String uploadElectrocardioPulseData(Model model,
			MultipartFile fileField1, MultipartFile fileField2,
			Integer memberId, Integer spo, Date startTime1) throws IOException {
		/*Member member = memberService.selectById(memberId);*/
		
		Oecg oecg = new Oecg();
		oecg.setMemberid(memberId);
		oecg.setFs((short)250);
		oecg.setDevicecode(Constant.DEVICETYPE_ELE_PULSE);
		oecg.setMeastime(startTime1);
		
		Oppg oppg = new Oppg();
		oppg.setMemberid(memberId);
		oppg.setSpo((short)spo.intValue());
		oppg.setFs((short)60);
		oppg.setDevicecode(Constant.DEVICETYPE_ELE_PULSE);
		oppg.setMeasuretime(startTime1);
		
		/*MsgCenter mc = new MsgCenter();
		mc.setMsgtype(MessageTypeEnum.TRE_MEASURE.getType());
		mc.setSendtype(UserTypeEnum.DOCTOR.getType());
		mc.setSender(member.getMemberGUID());
		
		oecg.setMsgCenter(mc);*/
		
		ByteArrayOutputStream os = null;
		try {
			//对三合一心电数据字节流进行处理
			InputStream ecg_is = fileField1.getInputStream();
			InputStream ppg_is = fileField2.getInputStream();
			
			os = new ByteArrayOutputStream();
			short dataRead = 0;
			byte[] b = new byte[2];
			int i = 0;//计算字节数	
			while ((ecg_is.read(b)) != -1) {
				dataRead = (short) (((b[0] << 8) | b[1] & 0xff));
				dataRead = (short) (2000 - dataRead);
				os.write(dataRead >> 8);
				os.write(dataRead & 0x00ff);
				i++;
			}
			int timeLength = i/150;
			oecg.setTimelength(timeLength);
			oppg.setTimelength(timeLength);
			
			InputStream ecg_in = new ByteArrayInputStream(os.toByteArray());
			pulseFileService.saveElectrocardioPulseFile(ecg_in, oecg, ppg_is, oppg);
			
			model.addAttribute("uploadShy", "上传成功");
		} catch (Exception e) {
			model.addAttribute("uploadShy", "上传失败：" + e.getMessage());
		}finally{
			if(os != null){
				os.close();
			}
		}
		model.addAttribute("uploadShow", "sanheyi");
		model.addAttribute("memberId", memberId);
		
		return "/measure/UploadMeasureData";
	}
	
	
	/**
	 * @Title:uploadElectricardioData 
	 * @Description:上传动态心电数据
	 * @author 陈哲
	 * @param fileField
	 * @param memberId
	 * @param startTime
	 * @return 
	 * @throws
	 * @retrun String
	 * @throws IOException 
	 */
	@RequestMapping(value="/uploadElectricardioData")
	public String uploadElectricardioData(Model model, MultipartFile fileField, Integer memberId, Date startTime) throws IOException{
		String fileName = fileField.getOriginalFilename();
		if(!(fileName.contains("ecghex") || fileName.contains("ECGHEX"))){
			model.addAttribute("upload", "当前文件不是mini1.0格式!");
			return "/measure/UploadMeasureData";
		}
		
		/*Member member = memberService.selectById(memberId);*/
		
		Oecg oecg = new Oecg();
		oecg.setMemberid(memberId);
		oecg.setMeastime(startTime);
		oecg.setFs((short)150);
		
		/*MsgCenter mc = new MsgCenter();
		mc.setMsgtype(MessageTypeEnum.ECG_MEASURE.getType());
		mc.setSendtype(UserTypeEnum.DOCTOR.getType());
		mc.setSender(member.getMemberGUID());
		
		oecg.setMsgCenter(mc);*/
		
		oecg.setDataType(Constant.DATATYPE_SIGNED_SINGLEBYTE);
		oecg.setDevicecode(Constant.DEVICETYPE_OLD_WEB);
		
		ByteArrayOutputStream os = null;
		try {
			//字节流处理，按照要求，每个字节减去128
			os = new ByteArrayOutputStream();
			byte[] bytes = fileField.getBytes();
			
			 for(byte b : bytes){
				 os.write(b-128);
			 }

			InputStream in = new ByteArrayInputStream(os.toByteArray());
			
			electrocardioFileService.saveElectrocardioFile(in, oecg);
			model.addAttribute("upload", "上传成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("upload", "上传失败");
		}finally{
			if(os != null){
				os.close();
			}
		}
		model.addAttribute("uploadShow", "ecg");
		model.addAttribute("memberId", memberId);
		
		return "/measure/UploadMeasureData";
	}
}

