/**
 * @PackageName:      com.bithealth.vo
 * @FileName:     MemberImportBean.java  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月9日 下午2:29:16  
 * 
 */
package com.bithealth.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bithealth.Constrants;
import com.bithealth.memberCore.enmu.AccountTypeEnum;
import com.bithealth.memberCore.enmu.EducationStatus;
import com.bithealth.memberCore.enmu.MarryStatusEnum;
import com.bithealth.memberCore.enmu.OccupationEnmu;
import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.member.model.DiseasesHistory;
import com.bithealth.memberCore.member.model.Habit;
import com.bithealth.memberCore.member.model.LinkMan;
import com.bithealth.memberCore.member.model.MemAccount;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.model.PhysicalExamination;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.common.utils.TimeUtil;

/**
 * 类名称: MemberImportBean  
 * 功能描述: 会员导入实体bean.  
 * 日期: 2016年8月9日 下午2:29:16 
 * 
 * @author liuhm
 * @version  
 */
public class MemberImportBean implements Serializable {

	private static final long serialVersionUID = -7577677642209791499L;
	
	private final static Logger log = Logger.getLogger(MemberImportBean.class);
	
	private String memberName;
	
	private String birthDay;
	
	private String gender;
	
	private String national;
	
	private String tel;
	
	private String idcard;
	
	private String address;
	
	private String email;
	
	private String height;
	
	private String weight;
	
	private String marray;
	
	private String education;
	
	private String occupation;
	
	private String contractName;
	
	private String contractTel;
	
	private String contractRelation;
	
	private String blood;
	
	/**
	 * 过敏史
	 */
	private String allergic;
	
	private String waistline;
	
	private String hipline;
	
	/**
	 * 脉搏
	 */
	private String pulse; 
	
	private String heartRate;
	
	/**
	 * 甘油三酯
	 */
	private String triglyceride;
	
	/**
	 * 收缩压
	 */
	private String bloodH;
	
	/**
	 * 舒张压
	 */
	private String bloodL;
	
	/**
	 * 空腹血糖
	 */
	private String fastingglucose;
	
	/**
	 * 尿酸
	 */
	private String uricacid;
	
	/**
	 * 总胆固醇
	 */
	private String totalcholesterol;
	
	/**
	 * 高密度脂蛋白
	 */
	private String densitylipop;
	
	/**
	 * 低密度脂蛋白
	 */
	private String ldlip;
	
	private String smoking;
	
	private String doDrink;
	
	private String sleepCond;
	
	private List<DiseasesHistory> diseaseList;
	
	private String desc;
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<DiseasesHistory> getDiseaseList() {
		return diseaseList;
	}

	public void setDiseaseList(List<DiseasesHistory> diseaseList) {
		this.diseaseList = diseaseList;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNational() {
		return national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public void setWaistline(String waistline) {
		this.waistline = waistline;
	}

	public void setHipline(String hipline) {
		this.hipline = hipline;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public void setTriglyceride(String triglyceride) {
		this.triglyceride = triglyceride;
	}

	public void setBloodH(String bloodH) {
		this.bloodH = bloodH;
	}

	public void setBloodL(String bloodL) {
		this.bloodL = bloodL;
	}

	public void setFastingglucose(String fastingglucose) {
		this.fastingglucose = fastingglucose;
	}

	public void setUricacid(String uricacid) {
		this.uricacid = uricacid;
	}

	public void setTotalcholesterol(String totalcholesterol) {
		this.totalcholesterol = totalcholesterol;
	}

	public void setDensitylipop(String densitylipop) {
		this.densitylipop = densitylipop;
	}

	public void setLdlip(String ldlip) {
		this.ldlip = ldlip;
	}

	public String getMarray() {
		return marray;
	}

	public void setMarray(String marray) {
		this.marray = marray;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getContractTel() {
		return contractTel;
	}

	public void setContractTel(String contractTel) {
		this.contractTel = contractTel;
	}

	public String getContractRelation() {
		return contractRelation;
	}

	public void setContractRelation(String contractRelation) {
		this.contractRelation = contractRelation;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getAllergic() {
		return allergic;
	}

	public void setAllergic(String allergic) {
		this.allergic = allergic;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getDoDrink() {
		return doDrink;
	}

	public void setDoDrink(String doDrink) {
		this.doDrink = doDrink;
	}

	public String getSleepCond() {
		return sleepCond;
	}

	public void setSleepCond(String sleepCond) {
		this.sleepCond = sleepCond;
	}
	
	public String getWaistline() {
		return waistline;
	}

	public String getHipline() {
		return hipline;
	}

	public String getPulse() {
		return pulse;
	}

	public String getHeartRate() {
		return heartRate;
	}

	public String getTriglyceride() {
		return triglyceride;
	}

	public String getBloodH() {
		return bloodH;
	}

	public String getBloodL() {
		return bloodL;
	}

	public String getFastingglucose() {
		return fastingglucose;
	}

	public String getUricacid() {
		return uricacid;
	}

	public String getTotalcholesterol() {
		return totalcholesterol;
	}

	public String getDensitylipop() {
		return densitylipop;
	}

	public String getLdlip() {
		return ldlip;
	}
	
	public String getFieldChinDesc(String field) {
		String[] header = Constrants.HEADER;
		String[] fields = Constrants.FIELDS;
		for(int index = 0; index < fields.length; index++) {
			if(field.equals(fields[index])) {
				return header[index];
			}
		}
		return null;
	}
	
	public MemberImportBean(MemberExt member, String desc){
		this.address = member.getAddress();
		this.birthDay = TimeUtil.formatDate(member.getBirthdate());
		this.education = EducationStatus.getEducation(member.getEducationstatus());
		this.email = member.getEmail();
		if("1".equals(member.getGender())) {
			this.gender = "男";
		} else if("2".equals(member.getGender())) {
			this.gender = "女";
		}
		
		this.idcard = member.getIdcard();
		this.marray = MarryStatusEnum.getDesc(member.getMarrystatus());
		this.memberName = member.getMemname();
		this.national = member.getNativeaddr();
		this.occupation = OccupationEnmu.getOccupation(member.getOccupation());
		this.tel = member.getTel();
		
		List<LinkMan> linkList = member.getLinkmanList();
		if(linkList != null && linkList.size() > 0) {
			this.contractName = linkList.get(0).getContactname();
			this.contractRelation = linkList.get(0).getRelation();
			this.contractTel = linkList.get(0).getContactmobphone();
		}
		
		PhysicalExamination exam = member.getPhysical();
		if(exam != null) {
			this.blood = exam.getBloodtype();
			this.bloodH = exam.getBloodh() == null ? "" :member.getPhysical().getBloodh().toString();
			this.bloodL = exam.getBloodl() == null ? "" :member.getPhysical().getBloodl().toString();
			if("Y".equals(exam.getAllergichis())) {
				this.allergic = "有";
			} else if("N".equals(exam.getAllergichis())) {
				this.allergic = "没有";
			}
			this.densitylipop = exam.getDensitylipop() == null ? "" : exam.getDensitylipop().toPlainString();
			this.fastingglucose = exam.getFastingglucose() == null ? "" : exam.getFastingglucose().toPlainString();
			this.heartRate = exam.getHeartrate() == null ? "" : exam.getHeartrate().toString();
			this.height = exam.getHeight() == null ? "" : exam.getHeight().toString();
			this.hipline = exam.getHip() == null ? "" : exam.getHip().toString();
			this.ldlip = exam.getLdlip() == null ? "" : exam.getLdlip().toPlainString();
			this.pulse = exam.getPulse() == null ? "" : exam.getPulse().toString();
			this.totalcholesterol = exam.getTotalcholesterol() == null ? "" : exam.getTotalcholesterol().toPlainString();
			this.triglyceride = exam.getTriglyceride() == null ? "" : exam.getTriglyceride().toPlainString();
			this.uricacid = exam.getUricacid() == null ? "" : exam.getUricacid().toString();
			this.waistline = exam.getWaist() == null ? "" : exam.getWaist().toString();
			this.weight = exam.getWeight() == null ? "" : exam.getWeight().toPlainString();
		}
		
		Habit habit = member.getHabit();
		if(habit != null) {
			if("Y".equals(habit.getDodrink())) {
				this.doDrink = "有";
			} else if("N".equals(habit.getDodrink())) {
				this.doDrink = "否";
			}
			if("Y".equals(habit.getSmoking())) {
				this.smoking = "有";
			} else if("N".equals(habit.getSmoking())) {
				this.smoking = "否";
			}
			if("Y".equals(habit.getSleepcond())) {
				this.sleepCond = "好";
			} else if("N".equals(habit.getSleepcond())) {
				this.sleepCond = "不好";
			}
		}
		
	}
	
	public MemberImportBean(){
		
	}

	public MemberExt convertToMember(MemberImportBean bean, String grpIds) {
		MemberExt member = new MemberExt();
		member.setMemname(bean.getMemberName());
		if(StringUtil.isNotEmpty(bean.getBirthDay())) {
			try{
				member.setBirthdate(TimeUtil.parseDate(bean.getBirthDay()));
			} catch (Exception e) { 
				log.error(bean.getBirthDay() + "无法转yyyy-MM-dd格式的日期：" + e.getMessage());
			}
		}
		
		if("男".equals(bean.getGender())){
			member.setGender("1");
		} else if("女".equals(bean.getGender())) {
			member.setGender("2");
		} else {
			member.setGender("3");
		}
		
		member.setNativeaddr(bean.getNational());
		member.setTel(bean.getTel());
		member.setIdcard(StringUtil.isEmpty(bean.getIdcard()) ? null : bean.getIdcard().trim().toUpperCase());
		member.setAddress(bean.getAddress());
		member.setEmail(bean.getEmail());
		if(StringUtil.isNotEmpty(bean.getMarray())) {
			member.setMarrystatus(MarryStatusEnum.getValue(bean.getMarray()));
		}
		if(StringUtil.isNotEmpty(bean.getEducation())) {
			member.setEducationstatus(EducationStatus.getValue(bean.getEducation()));
		}
		if(StringUtil.isNotEmpty(bean.getOccupation())) {
			member.setOccupation(OccupationEnmu.getOccupationValue(bean.getOccupation()));
		}
		
		//紧急联系人
		if(StringUtil.isNotEmpty(bean.getContractName()) && StringUtil.isNotEmpty(bean.getContractTel())) {
			LinkMan link = new LinkMan();  
			link.setContactname(bean.getContractName());
			link.setContactmobphone(bean.getContractTel());
			link.setRelation(bean.getContractRelation());
			List<LinkMan> list = new ArrayList<LinkMan>();
			list.add(link);
			member.setLinkmanList(list);
		}
		
		
		//体格检查
		PhysicalExamination exam = new PhysicalExamination();
		if(StringUtil.isNotEmpty(bean.getHeight())) {
			exam.setHeight(Integer.parseInt(bean.getHeight()));
		}
		if(StringUtil.isNotEmpty(bean.getWeight())) {
			exam.setWeight(new BigDecimal(bean.getWeight()));
		}
		exam.setBloodtype(bean.getBlood());
		if("有".equals(bean.getAllergic())) {
			exam.setAllergichis("Y");
		} else if("没有".equals(bean.getAllergic())) {
			exam.setAllergichis("N");
		}
		if(StringUtil.isNotEmpty(bean.getWaistline())) {
			exam.setWaist(Integer.parseInt(bean.getWaistline()));
		}
		if(StringUtil.isNotEmpty(bean.getHipline())) {
			exam.setHip(Integer.parseInt(bean.getHipline()));
		}
		if(StringUtil.isNotEmpty(bean.getPulse())){
			exam.setPulse(Integer.parseInt(bean.getPulse()));
		}
		if(StringUtil.isNotEmpty(bean.getHeartRate())){
			exam.setHeartrate(Integer.parseInt(bean.getHeartRate()));
		}
		if(StringUtil.isNotEmpty(bean.getTriglyceride())) {
			exam.setTriglyceride(new BigDecimal(bean.getTriglyceride()));
		}
		if(StringUtil.isNotEmpty(bean.getBloodH())) {
			exam.setBloodh(Short.parseShort(bean.getBloodH()));
		}
		if(StringUtil.isNotEmpty(bean.getBloodL())) {
			exam.setBloodl(Short.parseShort(bean.getBloodL()));
		}
		if(StringUtil.isNotEmpty(getFastingglucose())) {
			exam.setFastingglucose(new BigDecimal(bean.getFastingglucose()));
		}
		if(StringUtil.isNotEmpty(bean.getUricacid())) {
			exam.setUricacid(Integer.parseInt(bean.getUricacid()));
		}
		if(StringUtil.isNotEmpty(bean.getTotalcholesterol())) {
			exam.setTotalcholesterol(new BigDecimal(bean.getTotalcholesterol()));
		}
		if(StringUtil.isNotEmpty(bean.getDensitylipop())) {
			exam.setDensitylipop(new BigDecimal(bean.getDensitylipop()));
		}
		if(StringUtil.isNotEmpty(bean.getLdlip())) {
			exam.setLdlip(new BigDecimal(bean.getLdlip()));
		}
		member.setPhysical(exam);
		
		//习惯
		Habit habit = new Habit();
		if("有".equals(bean.getSmoking())) {
			habit.setSmoking("Y");
		} else if("否".equals(bean.getSmoking())) {
			habit.setSmoking("N");
		}
		
		if("有".equals(bean.getDoDrink())) {
			habit.setDodrink("Y");
		} else if("否".equals(bean.getDoDrink())) {
			habit.setDodrink("N");
		}
		if("好".equals(bean.getSleepCond())) {
			habit.setSleepcond("Y");
		} else if("不好".equals(bean.getSleepCond())) {
			habit.setSleepcond("N");
		}
		
		member.setHabit(habit);
		
		//账号
		if(StringUtil.isNotEmpty(bean.getIdcard())) {
			List<MemAccount> list = new ArrayList<MemAccount>();
			list.add(new MemAccount(bean.getIdcard(), AccountTypeEnum.IDCARD));
			member.setAccountList(list);
		}
		
		//疾病史
		member.setDiseasesHistoryList(bean.getDiseaseList());
		
		//会员分组
		if(StringUtil.isNotEmpty(grpIds)) {
			String[] ids = grpIds.split(",");
			if(ids.length > 0) {
				List<MemberGroup> groupList = new ArrayList<MemberGroup>();
				for(String id : ids) {
					MemberGroup group = new MemberGroup();
					group.setMemgrpid(Integer.parseInt(id));
					groupList.add(group);
				}
				member.setMemberGroupList(groupList);
			}
		}
		
		return member;
	}
	
}
