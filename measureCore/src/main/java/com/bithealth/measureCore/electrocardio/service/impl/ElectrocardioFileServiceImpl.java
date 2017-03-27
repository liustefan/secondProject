/**
 * @PackageName:      com.bithealth.measureCore.electrocardio.service.impl
 * @FileName:     ElectrocardioFileServiceImpl.java  
 * @Description: 心电文件处理接口实现  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月18日 下午5:32:17  
 * 
 */

package com.bithealth.measureCore.electrocardio.service.impl;

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
import com.bithealth.measureCore.common.model.ImageParam;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.common.service.OmdsService;
import com.bithealth.measureCore.constant.Constant;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioFileService;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.memberCore.member.model.MemScore;
import com.bithealth.memberCore.member.service.MemScoreService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.sdk.common.rabbit.ClientSender;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.common.utils.Util;

/**
 * 类名称: ElectrocardioFileServiceImpl 
 * 功能描述: 心电文件处理接口实现 
 * 增加/修改原 因: TODO ADD REASON(可选). 
 * 日期: 2016年7月18日 下午5:32:17
 * 
 * @author 陈哲
 * @version
 */
@Service
public class ElectrocardioFileServiceImpl implements ElectrocardioFileService {
	private final static Logger logger = Logger.getLogger(ElectrocardioFileServiceImpl.class);

	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;

	@Autowired
	private OmdsService omdsService;

	@Autowired
	private ElectrocardioService electrocardioService;

	@Autowired
	private MemScoreService memScoreService;

	@Autowired
	private CareIFService careIFService;
	
	@Autowired
	private MemberService memberService;

	/**
	     * @Title: send 
	     * @Description: 动态心电中心电图数据.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioFileService#getElectrocardioChartFileData(com.bithealth.measureCore.common.model.ImageParam)
	 */
	public Map<String, Object> getElectrocardioChartFileData(ImageParam param) {
		byte[] file = null;
		try {
			file = getFile(true, param.getRawImage());
		} catch (Exception e) {
			logger.error("动态心电，读取心电图数据，mongodb数据读取异常", e);
		}

		if (file == null) {
			return null;
		}

		Map<String, Object> map = createElectrocardioDataForJs(file,	param);

		return map;
	}
	
	/**
     * @Title: send 
     * @Description: 动态心电中心电图数据(app特有)
     * @param  liuxiaoqin
     * @throws      
     * @retrun  
     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioFileService#getElectrocardioChartFileData(com.bithealth.measureCore.common.model.ImageParam)
	 */
	public Map<String, Object> getElectrocardioChartFileDataApp(ImageParam param) {
		byte[] file = null;
		try {
			file = getFile(true, param.getRawImage());
		} catch (Exception e) {
			logger.error("动态心电，读取心电图数据，mongodb数据读取异常", e);
		}
	
		if (file == null) {
			return null;
		}
	
		Map<String, Object> map = createElectrocardioDataForJsApp(file,	param);
	
		return map;
	}

	/**
	 * @Title:createElectrocardioDataForJs 
	 * @Description:处理动态心电中的心电图数据
	 * @author 陈哲
	 * @param file
	 * @param param
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */
	private Map<String, Object> createElectrocardioDataForJs(byte[] file, ImageParam param) {
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
		boolean timeQuery = param.isTimeQuery();
		
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
			if (Constant.DEVICETYPE_NEW.equals(param.getDeviceCode())) {
				byte[] ubs;
				if (timeQuery) {
					if (page == totalPage) {
						ubs = Util.input2byte(file, startTimeQueryDis * fs * 2
								+ showTimeLength * 60 * fs * 2 * (page - 1),
								startTimeQueryDis * fs * 2 + endTimeQueryDis
										* fs * 2);
					} else {
						ubs = Util.input2byte(file, startTimeQueryDis * fs * 2
								+ showTimeLength * 60 * fs * 2 * (page - 1),
								startTimeQueryDis * fs * 2 + showTimeLength
										* 60 * fs * 2 * page);
					}
				} else {
					ubs = Util.input2byte(file, showTimeLength * 60 * fs * 2
							* (page - 1), showTimeLength * 60 * fs * 2 * page);
				}

				for (int i = 0; i < fileLeng; i += 2) {
					// 无符号型双字节
					if (i < ubs.length - 1) {
						list.add((int) Util.getShort(ubs, i) - 1600);
					} else {
						break;
					}
				}
			} else {
				byte[] ubs;
				if (timeQuery) {
					if (page == totalPage) {
						ubs = Util.input2byte(file, startTimeQueryDis * fs
								+ showTimeLength * 60 * fs * (page - 1),
								startTimeQueryDis * fs + endTimeQueryDis * fs);
					} else {
						ubs = Util.input2byte(file, startTimeQueryDis * fs
								+ showTimeLength * 60 * fs * (page - 1),
								startTimeQueryDis * fs + showTimeLength * 60
										* fs * page);
					}
				} else {
					ubs = Util.input2byte(file, showTimeLength * 60 * fs
							* (page - 1), showTimeLength * 60 * fs * page);
				}

				for (int i = 0; i < fileLeng; i++) {
					if (i < ubs.length) {
						// 有符合型单字节
						if (Constant.DEVICETYPE_OLD_WEB.equals(param.getDeviceCode())) {
							list.add((int) ubs[i] * 13);
						} else {
							// 无符号型单字节
							list.add(((ubs[i] & 0x0FF) - 128) * 13);
						}
					} else {
						break;
					}
				}

			}
			map.put("type", "mi_ecg");
			map.put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * @Title:createElectrocardioDataForJsApp 
	 * @Description:处理动态心电中的心电图数据
	 * @author liuxiaoqin
	 * @param file
	 * @param param
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */
	private Map<String, Object> createElectrocardioDataForJsApp(byte[] file, ImageParam param) {
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
		boolean timeQuery = param.isTimeQuery();
		
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
			if (Constant.DEVICETYPE_NEW.equals(param.getDeviceCode())) {
				byte[] ubs;
				if (timeQuery) {
					if (page == totalPage) {
						ubs = Util.input2byte(file, startTimeQueryDis * fs * 2
								+ showTimeLength * 6 * fs * 2 * (page - 1),
								startTimeQueryDis * fs * 2 + endTimeQueryDis
										* fs * 2);
					} else {
						ubs = Util.input2byte(file, startTimeQueryDis * fs * 2
								+ showTimeLength * 6 * fs * 2 * (page - 1),
								startTimeQueryDis * fs * 2 + showTimeLength
										* 6 * fs * 2 * page);
					}
				} else {
					ubs = Util.input2byte(file, showTimeLength * 6 * fs * 2
							* (page - 1), showTimeLength * 6 * fs * 2 * page);
				}

				for (int i = 0; i < fileLeng; i += 2) {
					// 无符号型双字节
					if (i < ubs.length - 1) {
						list.add((int) Util.getShort(ubs, i) - 1600);
					} else {
						break;
					}
				}
			} else {
				byte[] ubs;
				if (timeQuery) {
					if (page == totalPage) {
						ubs = Util.input2byte(file, startTimeQueryDis * fs
								+ showTimeLength * 6 * fs * (page - 1),
								startTimeQueryDis * fs + endTimeQueryDis * fs);
					} else {
						ubs = Util.input2byte(file, startTimeQueryDis * fs
								+ showTimeLength * 6 * fs * (page - 1),
								startTimeQueryDis * fs + showTimeLength * 6
										* fs * page);
					}
				} else {
					ubs = Util.input2byte(file, showTimeLength * 6 * fs
							* (page - 1), showTimeLength * 6 * fs * page);
				}

				for (int i = 0; i < fileLeng; i++) {
					if (i < ubs.length) {
						// 有符合型单字节
						if (Constant.DEVICETYPE_OLD_WEB.equals(param.getDeviceCode())) {
							list.add((int) ubs[i] * 13);
						} else {
							// 无符号型单字节
							list.add(((ubs[i] & 0x0FF) - 128) * 13);
						}
					} else {
						break;
					}
				}

			}
			map.put("type", "mi_ecg");
			map.put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * @Title:getInstantHeartRateChartFileData  
	 * @Description:瞬时心率图数据
	 * @author 陈哲
	 * @param param
	 * @return
	 * @throws Exception
	 * @throws
	 * @retrun String
	 */
	public Map<String, Object> getInstantHeartRateChartFileData(ImageParam param) {
		byte[] file = null;
		try {
			file = getFile(false, param.getRawImage());
		} catch (Exception e) {
			logger.error("读取瞬时心率图数据，mongodb数据读取异常！", e);
		}

		if (file == null) {
			return null;
		}

		Map<String, Object> map = createInstantHeartRateDataForJs(file, param);

		return map;
	}

	/**
	 * @Title:createInstantHeartRateDataForJs 
	 * @Description:处理瞬时心率图数据
	 * @author 陈哲
	 * @param file
	 * @param fs
	 * @param page
	 * @param measureTime
	 * @param width
	 * @param height
	 * @return
	 * @throws Exception
	 * @throws
	 * @retrun Map<String,Object>
	 */
	private Map<String, Object> createInstantHeartRateDataForJs(byte[] file, ImageParam param) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (file == null) {
			map.put("msg", false);
			return map;
		}
		
		int page = param.getPage();
		
		map.put("measureTime", param.getMeasureTime());
		map.put("page", page);
		map.put("fs", param.getFs());
		map.put("width", param.getWidth());
		map.put("height", param.getHeight());
		map.put("type", "hr_ecg");
		String startTime = null;
		String endTime = null;

		byte[] ubs = Util.input2byte(file, 0, page * 684 * 2);
		byte[] b = new byte[2];
		
		float time = 0;
		for (int i = 0; i < ubs.length; i += 2) {
			if (i <= (ubs.length - 1)) {
				b[0] = ubs[i];
				b[1] = ubs[i + 1];
				short value = Util.getShort(b, false);
				time += (float) value / 1000;
				if (i == ((page - 1) * 684 * 2 - 1)
						|| i == ((page - 1) * 684 * 2 + 1)
						|| i == ((page - 1) * 684 * 2)) {

					startTime = TimeUtil.formatDatetime2(TimeUtil.addSecond(
							param.getMeasureTime(), 6 * (page - 1)));
				}
			} else {
				break;
			}
		}

		endTime = TimeUtil.formatDatetime2(TimeUtil.addSecond(param.getMeasureTime(), (int) time));
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		List<Float> list = new ArrayList<Float>();

		for (int i = (page - 1) * 684 * 2; i < ubs.length; i += 2) {
			if (i <= (ubs.length - 1)) {
				b[0] = ubs[i];
				b[1] = ubs[i + 1];
				list.add(60 * 1000 / (float) Util.getShort(b, false));
			} else {
				break;
			}
		}
		map.put("data", list);
		return map;
	}

	/**
	 * @Title:getExcElectrocardioChartFileData
	 * @Description：心电图中异常心电图数据
	 * @author 陈哲
	 * @param param
	 * @return
	 * @throws Exception
	 * @throws 
	 * @retrun String
	 */
	public Map<String, Object> getExcElectrocardioChartFileData(ImageParam param) {
		byte[] file = null;
		try {
			file = getFile(false, param.getRawImage());
		} catch (Exception e) {
			logger.error("读取异常心电图数据，mongodb数据读取异常！", e);
		}

		if (file == null) {
			return null;
		}

		Map<String, Object> map = createExcElectrocardioDataForJs(file, param);

		return map;
	}

	/**
	 * @Title:createExcElectrocardioDataForJs 
	 * @Description:处理心电图中异常心电图数据  
	 * @author 陈哲
	 * @param file
	 * @param param
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */
	private Map<String, Object> createExcElectrocardioDataForJs(byte[] file,ImageParam param) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (file == null) {
			map.put("msg", false);
			return map;
		}
		
		String deviceCode = param.getDeviceCode();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("measureTime", sdf.format(param.getMeasureTime()));
		map.put("page", param.getPage());
		map.put("fs", param.getFs());
		map.put("width", param.getWidth());
		map.put("height", param.getHeight());
		if (deviceCode != null && "SIAT3IN1_E".equals(deviceCode)) {
			map.put("type", "ab_ecg");
		} else if (deviceCode != null && "MINIHOLTER_E".equals(deviceCode)) {
			map.put("type", "ab_ecg1");
		} else {
			map.put("type", "ab_ecg2");
		}
		List<Float> list = new ArrayList<Float>();
		try {

			if (file.length != 0) {
				String message = new String(file);
				String[] hr = message.split("\n{1,}");
				for (String i : hr) {
					list.add(Float.parseFloat(i));
				}
			}
			map.put("data", list);
		} catch (Exception e) {
			logger.error("获取心电图的异常map数据，出现异常!", e);
		}
		return map;
	}

	/**
	 * 
	 * @Title:getElectrocardioPageByParam 
	 * @Description:(这里用一句话描述这个方法的作用).
	 * @author 陈哲
	 * @param param
	 * @return
	 * @throws Exception
	 * @throws
	 * @retrun int
	 */
	public int getElectrocardioPageByParam(ImageParam param) {
		byte[] file = null;
		try {
			file = getFile(true, param.getRawImage());
		} catch (Exception e) {
			logger.error("获取mongodb数据异常！", e);
		}

		if (file == null) {
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
	 * @Title:getInstantHeartRateByParam 
	 * @Description:瞬时心率图分页
	 * @author 陈哲
	 * @param param
	 * @return
	 * @throws Exception
	 * @throws
	 * @retrun int
	 */
	public int getInstantHeartRatePageByParam(ImageParam param) {
		byte[] file = null;
		try {
			file = getFile(false, param.getRawImage());
		} catch (Exception e) {
			logger.error("读取瞬时心率图数据，mongodb数据读取异常！", e);
		}

		if (file == null) {
			return 0;
		}

		int fileLeng = file.length;
		int page = 0;
		if (fileLeng % (684 * 2) == 0) {
			page = fileLeng / (684 * 2);
		} else {
			page = fileLeng / (684 * 2) + 1;
		}
		return page;
	}

	/**
	 * @Title:getFile  
	 * @Description:获取mongodb文件的数据流
	 * @author 陈哲
	 * @param uniqueId
	 * @param isCompress  读取文件，是否解压，true解压，false不解压
	 * @return
	 * @throws Exception
	 * @throws 
	 * @retrun byte[]
	 */
	public byte[] getFile(boolean isCompress, String uniqueId) throws Exception {
		FileConfigModel model = new FileConfigModel();
		model.setUniqueId(uniqueId);
		model.setNeedCompress(isCompress);
		return fileManagerServiceFacade.downloadFile(model);
	}

	/**
	 * @Title:saveElectrocardioFile  
	 * @Description:保存心电
	 * @author 陈哲
	 * @param file
	 * @return
	 * @throws Exception
	 * @throws
	 * @retrun String
	 */
	public void saveElectrocardioFile(InputStream in, Oecg oecg)
			throws Exception {
		FileConfigModel model = new FileConfigModel();
		FileTypeEnum fileTypeEnum = FileTypeEnum.CUSTOM_FILE;
		model.setTypeEnum(fileTypeEnum);
		model.setNeedCompress(true);
		Date uploadTime = new Date();

		String rawEcg = fileManagerServiceFacade.uploadFile(in, model);

		oecg.setRawecg(rawEcg);
		oecg.setUploadtime(uploadTime);

		Omds omds = new Omds();
		omds.setMemberid(oecg.getMemberid());
		omds.setEventtype("4");
		omds.setStatustag((short) 2);
		omds.setUploadtime(uploadTime);
		// 保存omds测量记录
		omdsService.saveOmds(omds);
		 Long eventId = omds.getEventid();
		 oecg.setEventid(eventId);
		// 保存oecg心电信息
		electrocardioService.saveOecg(oecg);

		String message = getMqOecgMessage(oecg);
		// 将封装的消息发送给消息队列
		ClientSender.sender(message);

		logger.info("保存会员动态心电测量信息成功!");

		// 添加会员测量一次miniHolter得5 分
		MemScore memScore = new MemScore();
		memScore.setMemberid(oecg.getMemberid());
		memScore.setScore(Constant.ONCE_MEASURE_MNH_SCORE);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		memScore.setUploadtime(sdf.format(uploadTime));

		try {
			memScoreService.insert(memScore);
		} catch (Exception e1) {
			logger.error("上传动态心电测量数据，记录测量得分失败！", e1);
		}

		/*// 消息推送
		 try {
			Member member = memberService.selectById(oecg.getMemberid());
			String content = member.getMemname()+"(??)微型动态测量：?";
			oecg.getMsgCenter().setLastsourceid(eventId); // 最新的消息来源ID
			oecg.getMsgCenter().setLastcontent(content);
			careIFService.sendMsgToCareMeMember(oecg.getMsgCenter());
		} catch (Exception e) {
			logger.error("上传动态心电测量数据，消息推送失败！", e);
		}*/
	}

	/**
	 * 获取心电发送到mq的数据
	 * 
	 * @param oecg
	 * @return
	 */
	public String getMqOecgMessage(Oecg oecg) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("ECGHOLTER_ANALYZE|debug,");
		sb.append("ecg,");
		sb.append(oecg.getEventid()).append(",");
		sb.append(oecg.getRawecg()).append(",");

		int dataType = oecg.getDataType();
		
		//无符号单字节
		int newDataType = Constant.DATATYPE_UNSIGNED_SINGLEBYTE;
		if (dataType != 0) {
			newDataType = dataType;
		}

		sb.append(newDataType).append(",");
		sb.append(oecg.getFs()).append(",");

		String deviceCode = oecg.getDevicecode();
		int addValue = oecg.getAddvalue();
		// 老mini设备
		if (!StringUtils.isEmpty(deviceCode)
				&& (Constant.DEVICETYPE_OLD.equals(deviceCode) || Constant.DEVICETYPE_OLD_WEB.equals(deviceCode))) {
			// 数据类型为双字节时，addValue的值为384;单字节时，addValue的值为47
			if (newDataType == Constant.DATATYPE_UNSIGNED_SINGLEBYTE || newDataType == Constant.DATATYPE_SIGNED_SINGLEBYTE) {
				addValue = 47;
			} else {
				addValue = 384;
			}
		}
		// 新mini设备
		else if (!StringUtils.isEmpty(deviceCode)
				&& Constant.DEVICETYPE_NEW.equals(deviceCode)) {
			addValue = 200;
		}

		sb.append(addValue).append(",");
		sb.append(oecg.getMemberid());

		logger.info("成功获取心电发送到mq的数据！");

		return sb.toString();
	}

}
