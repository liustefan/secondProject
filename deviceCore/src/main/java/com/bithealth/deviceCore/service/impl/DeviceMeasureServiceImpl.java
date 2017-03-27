 

package com.bithealth.deviceCore.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.careCore.facade.model.MsgCenter;
import com.bithealth.deviceCore.enmu.DeviceTypeEnmu;
import com.bithealth.deviceCore.model.DataBean;
import com.bithealth.deviceCore.model.MeasureReqParam;
import com.bithealth.deviceCore.service.DeviceMeasureService;
import com.bithealth.deviceCore.utils.BthCmdPackage;
import com.bithealth.deviceCore.utils.SystemUtils;
import com.bithealth.deviceCore.utils.TimeUtil;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureUploadService;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarService;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarUploadService;
import com.bithealth.measureCore.enmu.BloodPresTimePType;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExample;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.msgCenterCore.constants.UserTypeEnum;
import com.bithealth.sdk.common.utils.StringUtil;

@Service("deviceMeasureService") 
public class DeviceMeasureServiceImpl implements DeviceMeasureService{
	
	private static Logger logger = Logger.getLogger(DeviceMeasureServiceImpl.class);
	
	@Resource
    private BloodPressureUploadService bloodPressureUploadService;
	
	@Autowired
	private BloodSugarUploadService bloodSugarUploadService;
	
	@Resource
    private BloodSugarService bloodSugarService;
	
	@Autowired
	private MemberService memberService;

	@Override
	public boolean uploadMeasureData(MeasureReqParam measureReqParam) throws Exception {
		
		//解析data数据
		DataBean dataBean = parseMeasureReqParam(measureReqParam);
		
		//验证校验码和CRC码
		if(validateAscAndCRC(dataBean,measureReqParam.getData())){
			MemberExample memberExample = new MemberExample();
			if(SystemUtils.getValue(dataBean.getSerialNumber()) == null || SystemUtils.getValue(dataBean.getSerialNumber()).equals("")){
				logger.error("未找到设备序列号对应的会员。上传失败");
				return false;
			}
			memberExample.createCriteria().andMemberGUIDEqualTo(SystemUtils.getValue(dataBean.getSerialNumber()));
			List<Member> memberList = memberService.selectByExample(memberExample);
			Member member = new Member();
			if(memberList != null && memberList.size() == 1){
				member = memberList.get(0);
			}else{
				logger.error("未找到设备序列号对应的会员。上传失败");
				return false;
			}
			boolean isSuccess = false;
			if(DeviceTypeEnmu.Osbp.getValue().equals(dataBean.getDeviceType().toString())){//保存血压测量数据
				isSuccess = savebloodPressure(dataBean,member);
			}else if(DeviceTypeEnmu.Obsr.getValue().equals(dataBean.getDeviceType().toString())){//保存血糖测量数据
				isSuccess =saveBloodSugar(dataBean,member);
			}
			return isSuccess;
		}
		return false;
	}
	
	
	private DataBean parseMeasureReqParam(MeasureReqParam measureReqParam){
		String data = measureReqParam.getData();
		if(!StringUtil.isEmpty(data)){
			DataBean dataBean = new DataBean();
			dataBean.setSerialNumber(data.substring(11, 20));
			dataBean.setData1(Integer.parseInt(data.substring(20, 23)));
			dataBean.setData2(Integer.parseInt(data.substring(23, 26)));
			dataBean.setData3(Integer.parseInt(data.substring(26, 29)));
			String dataStr = TimeUtil.year()+""+data.substring(31, 39)+"00";
			try {
				dataBean.setTesttime(TimeUtil.parseDatetime(dataStr));
			} catch (ParseException e) {
				
			}
			dataBean.setDeviceType(data.substring(9, 11));
			dataBean.setAscCode(data.substring(39, 43));
			dataBean.setCRC8(data.substring(84, 85));
			return dataBean;
		}else{
			return null;
		}
	}
	
	private boolean validateAscAndCRC(DataBean osbpDataBean,String sourceData){
		if(osbpDataBean == null ){
			return false;
		}
		boolean isCorrect = true;
		//验证校验码
		int sumDex = BthCmdPackage.convertStringToDexAndGetSum(sourceData.substring(0, 39));
		String sumHex = BthCmdPackage.IntToHex(sumDex);
		sumHex = repairHex(sumHex);
		if(sumHex == null || !sumHex.equals(osbpDataBean.getAscCode())){
			logger.error("校验码验证不通过。");
			isCorrect = false;
		}
		//验证CRC8码 ,暂不做验证
		

		return isCorrect;
	}
	
	
	private String repairHex(String sumHex){
		if(sumHex.length() < 4){
			for(int i = 0;i<(4-sumHex.length());i++){
				sumHex="0"+sumHex;
			}
		}
		return sumHex;
	}
	
	
	/**
	 * @Title:savebloodPressure 
	 * @Description:保存血压数据
	 * @author 谢美团
	 * @param dataBean
	 * @param member
	 * @return 
	 * @throws
	 * @retrun boolean
	 * @throws Exception 
	 */ 
	private boolean savebloodPressure(DataBean dataBean,Member member) throws Exception{
		Osbp osbp = new Osbp();
		osbp.setMemberid(member.getMemberid());
		osbp.setTimeperiod(String.valueOf(BloodPresTimePType.OTHER.getNumber()));
		osbp.setSbp(dataBean.getData1());
		osbp.setDbp(dataBean.getData2());
		osbp.setPulserate(dataBean.getData3());
		osbp.setDevicecode("Hand");
		osbp.setTesttime(dataBean.getTesttime());
		
		MsgCenter mc = new MsgCenter();
		mc.setMsgtype(MessageTypeEnum.BLOOD_PRESSURE.getType());
		mc.setSendtype(UserTypeEnum.DOCTOR.getType());
		mc.setSender(member.getMemberGUID());
		osbp.setMsgCenter(mc);
		bloodPressureUploadService.saveBloodPress(osbp);
		return true;
	}
	
	
	/**
	 * @Title:saveBloodSugar 
	 * @Description:上传血糖数据
	 * @author 谢美团
	 * @param dataBean
	 * @param member
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	private boolean saveBloodSugar(DataBean dataBean,Member member) throws Exception{
		
		Obsr obsr = new Obsr();
		obsr.setMemberid(member.getMemberid());
		obsr.setTimeperiod(String.valueOf(BloodPresTimePType.OTHER.getNumber()));
		obsr.setBsvalue(dataBean.getData3().doubleValue()/18); //单位换算，从mg/dl换算成 mmol/L
		obsr.setTesttime(dataBean.getTesttime());
		obsr.setDevicecode("Hand");
		
		MsgCenter mc = new MsgCenter();
		mc.setMsgtype(MessageTypeEnum.BLOOD_SUGAR.getType());
		mc.setSendtype(UserTypeEnum.DOCTOR.getType());
		mc.setSender(member.getMemberGUID());
		obsr.setMsgCenter(mc);
		
		bloodSugarUploadService.saveBloodSugar(obsr);
		return true;
	}


	@Override
	public String getResopneString() throws Exception {
		StringBuffer responeData = new StringBuffer();	
		String ip = SystemUtils.getValue("localIP");
		int host = Integer.parseInt(SystemUtils.getValue("localHost"));
		String[] ips = ip.split("\\.");
		//将IP转换成16机制
		for(String number:ips){
			String hex = BthCmdPackage.IntToHex(Integer.parseInt(number));
			hex = hex.length() <2?"0"+hex:hex;
			responeData.append(hex);
		}
		String hostHex = BthCmdPackage.IntToHex(host);
		responeData.append(repairHex(hostHex)); //端口转换成16进制，不足4位，补零处理。
		//计算ip和端口的十六进制的异或
		String sum1 = caculateSumHex(responeData.toString());
		if(sum1.length() > 2){
			sum1=sum1.substring(0, 2);
		}else if(sum1.length() < 2){
			sum1 = "0"+sum1;
		}
		responeData.append(sum1);
		//组装时间
		String dateHex = caculateDateHex(new Date());
		responeData.append(dateHex);
		//计算sum2
		responeData.append(caculateSumHex(dateHex));
		//结束码
		responeData.append("OK");
		return "+IP"+responeData.toString();
	}
	
	private String caculateSumHex(String hexs){
		String sum="";
		int i = 0;
		boolean isEnd = true;
		while(isEnd){
			if(i == 0){
				sum = hexs.substring(i, i+2);
			}else{
				sum = BthCmdPackage.xor(sum,hexs.substring(i, i+2));
			}
			i+=2;
			if(i>=hexs.length()){
				isEnd = false;
			}
		}
		return sum;
	}

	
	private String caculateDateHex(Date date){
		String dateStr = TimeUtil.formatDatetime(date);//201701171640
		String dateHex ="";
		int year = Integer.parseInt(dateStr.substring(0, 4))%100;//年
		String yaerHex = BthCmdPackage.IntToHex(year);
		yaerHex = repairDateHex(yaerHex);
		
		int month = Integer.parseInt(dateStr.substring(4, 6));
		String monthHex = BthCmdPackage.IntToHex(month);
		monthHex = repairDateHex(monthHex);
		
		int day = Integer.parseInt(dateStr.substring(6, 8));
		String dayHex = BthCmdPackage.IntToHex(day);
		dayHex = repairDateHex(dayHex);
		
		int hours = Integer.parseInt(dateStr.substring(8, 10));
		String hoursHex = BthCmdPackage.IntToHex(hours);
		hoursHex = repairDateHex(hoursHex);
		
		int minute = Integer.parseInt(dateStr.substring(10, 12));
		String minuteHex = BthCmdPackage.IntToHex(minute);
		minuteHex = repairDateHex(minuteHex);
		
		dateHex = yaerHex+monthHex+dayHex+hoursHex+minuteHex;
		return dateHex;
	}
	
	private String repairDateHex(String hex){
		if(hex.length() > 2){
			return hex.substring(0, 2);
		}else if(hex.length() < 2){
			return "0"+hex;
		}else{
			return hex;
		}
	}
	
}

