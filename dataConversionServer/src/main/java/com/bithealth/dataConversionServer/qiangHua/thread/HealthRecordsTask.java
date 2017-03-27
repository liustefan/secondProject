package com.bithealth.dataConversionServer.qiangHua.thread;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.dataConversionServer.dataSource.DataSourceSwitch;
import com.bithealth.dataConversionServer.qiangHua.bean.ThealthRecords;
import com.bithealth.dataConversionServer.qiangHua.dao.ThealthRecordsMapper;
import com.bithealth.dataConversionServer.util.Constants;
import com.bithealth.dataConversionServer.util.SystemUtils;
import com.bithealth.dataConversionServer.util.XmlUtil;
import com.bithealth.memberCore.enmu.MemberSource;
import com.bithealth.memberCore.member.model.MemRelation;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemRelationService;
import com.bithealth.memberCore.member.service.MemberService;



/*
 * 通过健康档案到强化数据库
 */
@Service("healthRecordsTask")
public class HealthRecordsTask {
    private Logger logger = Logger.getLogger(HealthRecordsTask.class);
	
    @Autowired
	private MemberService memberService;
    @Autowired
	private ThealthRecordsMapper thealthRecordsMapper;
	private ThealthRecords  healthRecords;
	@Autowired
	private MemRelationService memRelationService;
	@Autowired
	private MemberService memeberService;
	private  Member member;

	
	public void insertDbToHealthRecords(){
	    int  num =Integer.parseInt(SystemUtils.getValue(Constants.QH_EVERY_TIME_NUM));
	    DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
	    long count=memRelationService.countFailDataBySource(MemberSource.ZLJY,0);
	    int times=XmlUtil.getTimes(num, count);
		    for(int j=0;j<times;j++){
		    List<MemRelation> list =memRelationService.selectFailDataBySource(MemberSource.ZLJY,num);
		    int i = 0;
		    if(list.size()>0){
			 for(MemRelation relation:list){
				 System.out.println("====relation:"+relation.getUniqueId());
				 member= memeberService.selectByUniqueId(relation.getUniqueId());//relation.getMember();
			     //healthRecords  =AssemUtil.beanToBean(omem, ThealthRecords.class, "HealthexamRecords.xml");
				// MemRelation omemRelation=  memRelationService.selectByPrimaryKey(member.getUniqueId());
			     healthRecords = new ThealthRecords();
			     healthRecords=getChangeBean(healthRecords,member,relation);
			     healthRecords.setDocId(member.getUniqueId().substring(0, member.getUniqueId().length()-1));
			     healthRecords.setHrGid(member.getUniqueId());
			     healthRecords.setCreOrg(relation.getPrgid());
			     healthRecords.setDataFlag("1");
			     if(null!=healthRecords.getIdcNo()&& !"".equals(healthRecords.getIdcNo())){
	        		     try{
	        			 DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_3);
	        			 ThealthRecords healthRecords1= thealthRecordsMapper.selectByPrimaryKey(healthRecords.getHrGid());
	        			 if(null!=healthRecords1){
	        			     thealthRecordsMapper.deleteByPrimaryKey(healthRecords1.getHrGid());
	        			 }
	        			 i=thealthRecordsMapper.insertSelective(healthRecords);
	        			 DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
	        		     }catch(Exception e){
	        		    	 relation.setState((byte)2);
	        			 e.printStackTrace();
	        		     }finally{
	        			 if(i==1){
	        				 relation.setState((byte)1);
	        			 }else if(i!=1 && i!=2){
	        			     logger.info("保存强华数据为空或出现异常！");
	        			     relation.setState((byte)3);
	        			 }
	        			 	memRelationService.insert(relation);
	        		     }
			     }
			 }
			 logger.info("查询数据源为1的数据已完成");
		    }else{
			logger.info("查询数据源为1的，为空或出现异常");
		    }
		}
		logger.info("同步基本资料到强华中间表任务执行完成。");
	    
	}
	
	private ThealthRecords getChangeBean( ThealthRecords healthRecords,Member omem,MemRelation omemRelation){
	    if(null!=omemRelation.getPayType()&& !"".equals(omemRelation.getPayType())){
		healthRecords.setPayType(getPayType(omemRelation.getPayType()));
	    }
	    healthRecords.setOthPayType(omemRelation.getOtherPay());
	    healthRecords.setName(omem.getMemname());
	    String sex=null;
	    if(null!=omem.getGender()&& !"".equals(omem.getGender())){
        	    if(omem.getGender().equals("M")){
        		sex="1";
        	    }else if(omem.getGender().equals("F")){
        		sex="2";
        	    }else{
        		sex="9";
        	    }
	    }
	    healthRecords.setSex(sex);
	    healthRecords.setBirthday(omem.getBirthdate());
	    healthRecords.setTel(omem.getTel());
	    healthRecords.setIdcNo(omem.getIdcard());
	    healthRecords.setProfession(omem.getOccupation()); 
//	    healthRecords.setContact(omem.getContactname());
//	    healthRecords.setContactTel(omem.getContactmobphone());
	    if(null!=omemRelation.getNation()&& !"".equals(omemRelation.getNation())){
		if(omemRelation.getNation().equals("汉族")){
		    healthRecords.setNation("1");
        	}else{
        	    healthRecords.setNation("2");
        	}
	    }
	    if(null!=omem.getOccupation() && !"".equals(omem.getOccupation())){
		healthRecords.setProfession(getChangeProfession(omem.getOccupation()));
	    }
	     if(null!=omem.getEducationstatus() && !"".equals(omem.getEducationstatus())){
		 healthRecords.setEduLevel(getChangeEducation(omem.getEducationstatus()));
	     }
	     if(null!=omem.getMarrystatus() && !"".equals(omem.getMarrystatus())){
		 healthRecords.setMarStatus(getMarStatus(omem.getMarrystatus()));
	     }
	     healthRecords.setCreDate(omem.getCreatetime());
	     healthRecords.setUpdDate(new Date());
	    return healthRecords;
	}
	 // 强华的类型   医疗费用支付方式	1城镇职工基本医疗保险 2城镇居民基本医疗保险 3新型农村合作医疗 4贫困救助 5商业医疗保险 6全公费 7全自费 8其他
	 /** 自己公司的类型  支付类型:1.全自费;2.全公费;3.城镇职工基本医疗保险;4.城镇居民基本医疗保险;5.新型农村合作医疗;6.社会医疗保险;7.商业医疗保险;8.贫困救助;99.其他;'*/
	private String getPayType(int str){
	    String fla;
	     if(str==3){ //3.城镇职工基本医疗保险;
		 fla="1"; //1城镇职工基本医疗保险
	     }else if(str==4){//4.城镇居民基本医疗保险
		 fla="2";//2城镇居民基本医疗保险
	     }else if(str==5){//5.新型农村合作医疗
		 fla="3";//3新型农村合作医疗
	     }else if(str==8){//8.贫困救助
		 fla="4";//4贫困救助
	     }else if(str==7){//7.商业医疗保险
		 fla="5";//5商业医疗保险
	     }else if(str==2){//2.全公费
		 fla="6";//6全公费
	     }else if(str==1){//1.全自费
		 fla="7";// 7全自费
	     }else{// 6.社会医疗保险  99.其他
		 fla="8";//8其他
	     }
	     return fla;
	}
	
	
	private String getMarStatus(String str){
	    String fla;
	     if(str.equals("Y")){
		 fla="2";
	     }else if(str.equals("N")){
		 fla="1";
	     }else{
		 fla="5";
	     }
	     return fla;
	}
	
	private String getChangeEducation(String str){
	    String fla;
	     if(str.equals("文盲及半文盲")){
		 fla="1";
	     }else if(str.equals("小学")){
		 fla="2";
	     }else if(str.equals("初中")){
		 fla="3";
	     }else if(str.equals("高中")|| str.equals("技校")||str.equals("中专")){
		 fla="4";
	     }else if(str.equals("大学专科及以上")){
		 fla="5";
	     }else{
		 fla="6";
	     }
	     return fla;
	}
	
	private String getChangeProfession(String str){
	    String fla;
	     if(str.equals("国家机关、党群组织、企业、事业单位负责人")){
		 fla="1";
	     }else if(str.equals("专业技术人员")){
		 fla="2";
	     }else if(str.equals("办事人员和有关人员")){
		 fla="3";
	     }else if(str.equals("商业、服务业人员")){
		 fla="4";
	     }else if(str.equals("农、林、牧、渔、水利业生产人员")){
		 fla="5";
	     }else if(str.equals("生产、运输设备操作人员及有关人员")){
		 fla="6";
	     }else if(str.equals("军人")){
		 fla="7";
	     }else {
		 fla="8";
	     }
	     return fla;
	}
	
	

}