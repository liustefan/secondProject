/**
 * @PackageName:      com.bithealth.measureCore.electrocardioPulse.service.impl
  * @FileName:     PulseFileServiceImpl.java  
  * @Description: 脉搏以及三合一心电处理的接口实现  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
  * @Createdate:  2016年7月19日 下午3:11:09  
 * 
 */

package com.bithealth.measureCore.electrocardioPulse.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bithealth.careCore.facade.service.CareIFService;
import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpExample;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.common.model.ImageParam;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.common.service.OmdsService;
import com.bithealth.measureCore.constant.Constant;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioFileService;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.service.PulseFileService;
import com.bithealth.measureCore.electrocardioPulse.service.PulseService;
import com.bithealth.memberCore.member.model.MemScore;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.model.PhysicalExamination;
import com.bithealth.memberCore.member.service.MemScoreService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.sdk.common.rabbit.ClientSender;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.common.utils.Util;

/**
 * 类名称: PulseFileServiceImpl 
 * 功能描述: TODO ADD FUNCTION. 增加/修改原 因: TODO ADD
 * REASON(可选). 
 * 日期: 2016年7月19日 下午3:11:09
 * @author 陈哲
 * @version
 */
@Service
public class PulseFileServiceImpl implements PulseFileService {
	private final static Logger logger = Logger.getLogger(PulseFileServiceImpl.class);

	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;

	@Autowired
	private ElectrocardioFileService electrocardioFileService;
	
	@Autowired
	private OmdsService omdsService;
	
	@Autowired
	private ElectrocardioService electrocardioService;

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BloodPressureService bloodPressureService;
	
	@Autowired
	private PulseService pulseService;
	
	@Autowired
	private MemScoreService memScoreService;
	
	@Autowired
	private CareIFService careIFService;
	
	/**
	     * @Title: send 
	     * @Description:获取三合一心电图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseFileService#getElectrocardioPulseChartFileData(com.bithealth.measureCore.common.model.ImageParam)
	 */
	public Map<String, Object> getElectrocardioPulseChartFileData(
			ImageParam param) {
		byte[] file = null;
		try {
			file = electrocardioFileService.getFile(true, param.getRawImage());
		} catch (Exception e) {
			logger.error("三合一，读取心电图数据，mongodb数据读取异常！");
			return null;
		}

		Map<String, Object> map = createElectrocardioPulseDataForJs(file, param);

		return map;
	}

	/**
	 * @Title:createElectrocardioPulseDataForJs 
	 * @Description:处理三合一心电图数据
	 * @author 陈哲
	 * @param file
	 * @param param
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */
	private Map<String, Object> createElectrocardioPulseDataForJs(byte[] file, ImageParam param) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (file == null) {
			map.put("msg", false);
			return map;
		}
		map.put("measureTime", param.getMeasureTime());
		map.put("fs", param.getFs());
		map.put("width", param.getWidth());
		map.put("height", param.getHeight());
		map.put("type", "ecg");
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < file.length; i += 2) {
			if (i < file.length - 1) {
				list.add((int) Util.getShort(file, i));
			} else {
				break;
			}

		}
		map.put("data", list);

		return map;
	}
	
	/**
     * @Title: getElectrocardioPulseChartFileDataApp 
     * @Description:获取三合一心电图数据(app特有)
     * @author liuxiaoqin
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseFileService#getElectrocardioPulseChartFileData(com.bithealth.measureCore.common.model.ImageParam)
	 */
	public Map<String, Object> getElectrocardioPulseChartFileDataApp(ImageParam param){
		byte[] file = null;
		try {
			file = electrocardioFileService.getFile(true, param.getRawImage());
		}catch (Exception e){
			logger.error("三合一，读取心电图数据，mongodb数据读取异常！");
			return null;
		}
	
		Map<String, Object> map = createElectrocardioPulseDataForJsApp(file, param);
	
		return map;
	}
	
	/**
	 * @Title: createElectrocardioPulseDataForJsApp 
	 * @Description:处理三合一心电图数据（app特有）
	 * @author liuxiaoqin
	 * @param file
	 * @param param
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */
	private Map<String, Object> createElectrocardioPulseDataForJsApp(byte[] file, ImageParam param) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (file == null) {
			map.put("msg", false);
			return map;
		}
		int page = param.getPage();
		int fs = param.getFs();
		int totalPage = param.getTotalPage();
		int showTimeLength = param.getShowTimeLength();
		int startTimeQueryDis = param.getStartTimeQueryDis();
		int endTimeQueryDis = param.getEndTimeQueryDis();
		
		map.put("measureTime", param.getMeasureTime());
		map.put("page", page);
		map.put("fs", fs);
		map.put("width", param.getWidth());
		map.put("height", param.getHeight());
		map.put("showTimeLength", showTimeLength);
		map.put("totalPage", totalPage);

		List<Integer> list = new ArrayList<Integer>();
		int fileLeng = file.length;
		try {
			byte[] ubs = Util.input2byte(file, startTimeQueryDis * fs * 2 ,(startTimeQueryDis + endTimeQueryDis)* fs * 2);

			for (int i = 0; i < fileLeng; i += 2) {
				if (i < ubs.length - 1) {
					list.add((int) Util.getShort(ubs, i));
				} else {
					break;
				}
			}

			map.put("type", "ecg");
			map.put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	     * @Title: send 
	     * @Description: 脉搏图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseFileService#getPulseChartFileData(com.bithealth.measureCore.common.model.ImageParam)
	 */
	public Map<String, Object> getPulseChartFileData(ImageParam param) {
		byte[] file = null;
		try {
			file = electrocardioFileService.getFile(true, param.getRawImage());
		} catch (Exception e) {
			logger.error("读取脉搏图数据，mongodb数据读取异常！");
		}
		
		if(file == null){
			return null;
		}

		Map<String, Object> map = createPulseDataForJs(file, param);

		return map;
	}

	/**
	 * @Title:createPulseDataForJs 
	 * @Description:处理脉搏图数据
	 * @author 陈哲
	 * @param file
	 * @param param
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */
	private Map<String, Object> createPulseDataForJs(byte[] file, ImageParam param) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (file == null) {
			map.put("msg", false);
			return map;
		}
		
		int page = param.getPage();
		int fs = param.getFs();
		
		map.put("measureTime", param.getMeasureTime());
		map.put("page", page);
		map.put("fs", fs);
		map.put("width", param.getWidth());
		map.put("height", param.getHeight());
		map.put("type", "ppg");
		List<Integer> list = new ArrayList<Integer>();
		byte[] bs = Util.input2byte(file, (page - 1) * 6 * fs, page * 6 * fs);
		for (int i = 0; i < fs * 6; i++) {
			if (i < bs.length) {
				list.add((int) bs[i]);
			} else {
				break;
			}
		}
		if (bs.length < fs * 6) {
			int num = (fs * 6 - bs.length);
			for (int i = 0; i < num; i++) {
				list.add(0);
			}
		}
		map.put("data", list);
		return map;
	}

	/**
	     * @Title: send 
	     * @Description: 瞬时脉率图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseFileService#getInstantPulseChartFileData(com.bithealth.measureCore.common.model.ImageParam)
	 */
	public Map<String, Object> getInstantPulseChartFileData(ImageParam param) {
		byte[] file = null;
		try {
			file = electrocardioFileService.getFile(false, param.getRawImage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("读取瞬时脉率图数据，mongodb数据读取异常！");
		}
		
		if(file == null){
			return null;
		}

		Map<String, Object> map = createInstantPulseDataForJs(file, param);

		return map;
	}

	/**
	 * @Title:createInstantPulseDataForJs 
	 * @Description:处理瞬时脉率图数据 
	 * @author 陈哲
	 * @param file
	 * @param param
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */
	private Map<String, Object> createInstantPulseDataForJs(byte[] file, ImageParam param){
		Map<String, Object> map = new HashMap<String, Object>();
		if (file == null) {
			map.put("msg", false);
			return map;
		}
		map.put("measureTime", param.getMeasureTime());
		map.put("page", param.getPage());
		map.put("fs", param.getFs());
		map.put("width", param.getWidth());
		map.put("height", param.getHeight());
		map.put("type", "hr_ppg");
		String startTime = TimeUtil.formatDatetime2(param.getMeasureTime());
		String endTime = "";

		float time = 0;
		String message = new String(file);
		String[] hr = message.split("\n{1,}");
		for (int i = 0; i < hr.length; i++) {
			time += (float) Float.parseFloat(hr[i]) / 1000;
		}
		endTime = TimeUtil.formatDatetime2(TimeUtil.addSecond(param.getMeasureTime(), (int) time));
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		List<Float> list = new ArrayList<Float>();

		for (int i = 0; i < hr.length - 1; i++) {
			list.add(60 * 1000 / Float.parseFloat(hr[i]));
		}
		map.put("data", list);
		return map;
	}

	/**
	     * @Title: send 
	     * @Description: 获取心电分页总页数
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseFileService#getElectrocardioPulsePageByparam(com.bithealth.measureCore.common.model.ImageParam)
	 */
	public int getElectrocardioPulsePageByparam(ImageParam param) {
		byte[] file = null;
		try {
			file = electrocardioFileService.getFile(true, param.getRawImage());
		} catch (Exception e) {
			logger.error("获取mongodb数据异常！");
		}
		
		if(file == null){
			return 0;
		}
		
		int fileLeng = file.length;
		int page = 0;

		if (fileLeng % (param.getFs() * 6 * 2) == 0) {
			page = (int) (fileLeng / (param.getFs() * 6 * 2));
		} else {
			page = (int) (fileLeng / (param.getFs() * 6 * 2) + 1);
		}
		return page;
	}

	/**
	     * @Title: send 
	     * @Description: 获取脉搏图分页总页数
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseFileService#getPulsePageByParam(com.bithealth.measureCore.common.model.ImageParam)
	 */
	public int getPulsePageByParam(ImageParam param) {
		byte[] file = null;
		try {
			file = electrocardioFileService.getFile(true, param.getRawImage());
		} catch (Exception e) {
			logger.error("读取脉搏图数据，mongodb数据读取异常！");
		}
		
		if(file == null){
			return 0;
		}
		
		int fileLeng = file.length;
		int page = 0;
		if (fileLeng % (param.getFs() * 6) == 0) {
			page = (int) (fileLeng / (param.getFs() * 6));
		} else {
			page = (int) (fileLeng / (param.getFs() * 6) + 1);
		}
		return page;
	}
	
	/**
	     * @Title: send 
	     * @Description: 上传三合一数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseFileService#saveElectrocardioPulseFile(java.io.InputStream, com.bithealth.measureCore.electrocardio.model.Oecg, java.io.InputStream, com.bithealth.measureCore.electrocardioPulse.model.Oppg)
	 */
	public void saveElectrocardioPulseFile(InputStream ecg_in, Oecg oecg, InputStream ppg_in, Oppg oppg) throws Exception{
		Osbp osbp = new Osbp();
		Integer systolic = null;
		Integer diastolic = null;
		OsbpExample example = new OsbpExample();
		example.createCriteria().andMemberidEqualTo(oecg.getMemberid()).andDeltagEqualTo("0");
		example.setOrderByClause("TestTime DESC");
		List<Osbp> list = bloodPressureService.selectByExample(example);
		MemberExt memberExc = memberService.selectMemberExtById(oecg.getMemberid());
		PhysicalExamination physical = new PhysicalExamination();
		if(memberExc != null){
			physical = memberExc.getPhysical();
		}
		/* 先在osbp血压测量记录中取最新的数据 begin */
		if(list != null && list.size() >0){
			osbp = list.get(0);
			Integer systolicNew = osbp.getSbp();
			if(systolicNew != null && systolicNew >0){
				systolic = systolicNew;
			}
			Integer diastolicNew = osbp.getDbp();
			if(diastolicNew != null && diastolicNew >0){
				diastolic = diastolicNew;
			}
			/* 先在osbp血压测量记录中取最新的数据 end */
		}else{
    		/* 从健康体检表mem2中获取  begin */
			if(physical != null){
				if(!StringUtils.isEmpty(physical.getBloodh())){
					systolic = (int)physical.getBloodh();
				}
				if(!StringUtils.isEmpty(physical.getBloodl())){
					diastolic = (int)physical.getBloodl();
				}
			}
			/* 从健康体检表mem2中获取  end */
		}
		if(systolic != null && systolic >0 && diastolic != null && diastolic >0){
			osbp.setSbp(systolic);
			osbp.setDbp(diastolic);
		}else{
			throw new Exception("没有相应的血压测量信息");
		}
		
		if(memberExc != null){
			if(StringUtils.isEmpty(memberExc.getBirthdate())){
				throw new Exception("无法获取该会员的年龄");
			}
			
			if(StringUtils.isEmpty(physical.getHeight())){
				throw new Exception("无法获取该会员的身高");
			}
		}
		
		FileConfigModel model = new FileConfigModel();
		FileTypeEnum fileTypeEnum = FileTypeEnum.CUSTOM_FILE;
		model.setTypeEnum(fileTypeEnum);
		
		Date uploadTime = new Date();
		
		String rawEcg = fileManagerServiceFacade.uploadFile(ecg_in, model);
		String rawPpg = fileManagerServiceFacade.uploadFile(ppg_in, model);
		
		oecg.setRawecg(rawEcg);
		oecg.setUploadtime(uploadTime);
		
		oppg.setRawppg(rawPpg);
		oppg.setUploadtime(uploadTime);
		
		Omds omds = new Omds();
		omds.setMemberid(oecg.getMemberid());
		omds.setEventtype("3");
		omds.setStatustag((short)2);
		omds.setUploadtime(uploadTime);
		
		//保存omds测量记录
		 omdsService.saveOmds(omds);
		 Long eventId = omds.getEventid();
		 oppg.setEventid(eventId);
		 oecg.setEventid(eventId);
		//保存oecg心电信息
		electrocardioService.saveOecg(oecg);
		//保存oppg脉搏信息
		pulseService.saveOppg(oppg);
		
		String message = getMqOecgOppgMessage(oecg, oppg, osbp, memberExc);
		ClientSender.sender(message);
		
		logger.info("保存会员动态心电测量信息成功!");
		
		//添加会员测量一次三合一得2 分
		MemScore memScore = new MemScore();
		memScore.setMemberid(oecg.getMemberid());
		memScore.setScore(Constant.ONCE_MEASURE_TIN_SCORE);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		memScore.setUploadtime(sdf.format(uploadTime));
		
		try {
			memScoreService.insert(memScore);
		} catch (Exception e1) {
			logger.error("上传三合一测量数据，记录测量得分失败！");
		}
		
		/*//消息推送
		try {
			String content = memberExc.getMemname()+"(??)三合一测量：?";
			oecg.getMsgCenter().setLastsourceid(eventId); //最新的消息来源ID
			oecg.getMsgCenter().setLastcontent(content);
			careIFService.sendMsgToCareMeMember(oecg.getMsgCenter());
		} catch (Exception e) {
			logger.error("上传三合一测量数据，消息推送失败！");
		}*/
	}
	
	/**
	 * 获取心电发送到mq的数据
	 * 
	 * @param oecg
	 * @return
	 * @throws Exception
	 */
	public String getMqOecgOppgMessage(Oecg oecg, Oppg oppg, Osbp osbp,
			MemberExt memberExc) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("EP_ANALYZE|debug,");
		sb.append("ecg").append(",");
		sb.append(oecg.getEventid()).append(",");
		sb.append(oecg.getRawecg()).append(",");
		sb.append(4).append(",");
		sb.append(oecg.getFs()).append(",");
		sb.append(200).append(",");
		sb.append("ppg").append(",");
		sb.append(oppg.getEventid()).append(",");
		sb.append(oppg.getRawppg()).append(",");
		sb.append(1).append(",");
		sb.append(oppg.getFs()).append(",");
		sb.append(osbp.getSbp()).append(",");
		sb.append(osbp.getDbp()).append(",");
		sb.append(memberExc.getPhysical().getHeight()).append(",");
		sb.append(TimeUtil.getAge(memberExc.getBirthdate())).append(",");
		sb.append(oppg.getSpo()).append(",");
		sb.append(memberExc.getPhysical().getWeight() == null ? 0 : memberExc.getPhysical().getWeight()).append(",");
		sb.append(oecg.getMemberid());
		return sb.toString();
	}
	

	
}
