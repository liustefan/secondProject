package com.bithealth.dataConversionServer.qiangHua.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.dataConversionServer.assemble.AssemUtil;
import com.bithealth.dataConversionServer.qiangHua.bean.TdiabetesVisits;
import com.bithealth.dataConversionServer.qiangHua.service.IPhDiabetesService;
import com.bithealth.inspectCore.facede.service.InspectFacedeService;
import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetail;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetailmedicine;
import com.bithealth.inspectCore.inspect.service.InspectService;
import com.bithealth.inspectCore.inspect.service.PhDiabetesService;
import com.bithealth.inspectCore.inspect.service.PhDiabetesdetailService;
import com.bithealth.inspectCore.inspect.service.PhHypertensiondetailmedicineService;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;



/**
 * @ClassName:     PhDiabetesServiceImpl.java 
  * @Description:   糖尿病从强华获取入库
  * @author         Administrator  
 * @version        V1.0   
  * @Date           2016年3月18日 下午1:47:48
 *****/
@Service("phDiabetesService")
public class PhDiabetesServiceImpl extends GenericBaseServiceImpl implements IPhDiabetesService{

	@Autowired
    private PhDiabetesService phDiabetesService; 
	@Autowired
	InspectFacedeService inspectService;
	@Autowired
	private MemberService memberService;
    
    
    
    public int insertSelective(PhDiabetes record) {
    	return 0;//inspectService.insertPhDiabetes(record);
    }
    
    private String remvNu(List<String> list){
	String obj="";
	list.remove("null");
	for(String str:list){
	    if( null !=str && !"".equals(str)){
		obj+="@#"+str;
	    }
	}
	obj=obj.replaceFirst("@#", "");
	return obj;
    }

    public boolean saveAll(TdiabetesVisits tdiabetesVisits){
    	boolean bol=false;
	 	Member member = new Member();
		member=memberService.selectByUniqueId(tdiabetesVisits.getHrGid());
		PhDiabetes PhDiabetes  =changePhDiabetes(tdiabetesVisits);
		//PhDiabetes PhDiabetes=AssemUtil.beanToBean(tdiabetesVisits, PhDiabetes.class, "ph_diabetes.xml");
		if(member != null){
		    PhDiabetes.setMemberID(member.getMemberid());
		    String visiitType=(tdiabetesVisits.getVisitsEva()==""?"0":tdiabetesVisits.getVisitsEva());
		    PhDiabetes.setVisitClass(Byte.parseByte(visiitType));
			PhDiabetesdetail phDiabetesdetail=getChangePhDiabetesdetail(tdiabetesVisits); //AssemUtil.beanToBean(tdiabetesVisits, PhDiabetesdetail.class, "ph_diabetesdetail.xml");
			List<String> listmeSymptom = new ArrayList<String>();
			listmeSymptom.add(tdiabetesVisits.getSymptom());
			listmeSymptom.add(tdiabetesVisits.getSymptom2());
			listmeSymptom.add(tdiabetesVisits.getSymptom3());
			listmeSymptom.add(tdiabetesVisits.getSymptom4());
			listmeSymptom.add(tdiabetesVisits.getSymptom5());
			listmeSymptom.add(tdiabetesVisits.getSymptom6());
			listmeSymptom.add(tdiabetesVisits.getSymptom7());
			listmeSymptom.add(tdiabetesVisits.getSymptom8());
			phDiabetesdetail.setSymptom(remvNu(listmeSymptom));
			phDiabetesdetail.setSymptom_Desc(tdiabetesVisits.getSymptomOth()==null?"":tdiabetesVisits.getSymptomOth());
		
			try{
		//	    PhDiabetes diabetes=inspectService.selectByPrimaryRefDataPK(PhDiabetes);
				//TODO 查询不到数据
				System.out.println("====================redatapk:"+PhDiabetes.getRefDataPK());
				 PhDiabetes diabetes=inspectService.selectPhDiabetesByRefDataPK(PhDiabetes.getRefDataPK());
				 long ids = 0;
			    if(null!=diabetes&& !"".equals(diabetes)){
			    	 ids=diabetes.getDiabetesID();
			    	phDiabetesdetail.setDiabetesID(ids);
			    }
			    List<PhDiabetesdetailmedicine> listmedicine =getChangeMedicine(tdiabetesVisits,ids);
			    
			    PhDiabetes.setPhDiabetesdetail(phDiabetesdetail);
				PhDiabetes.setPhDiabetesdetailmedicines(listmedicine);
				
				 bol=inspectService.insertOrUpdateDiabetes(PhDiabetes);
			}catch(Exception e){
			    e.printStackTrace();
			}
		}
					return bol;
    }
    
    private List<PhDiabetesdetailmedicine> getChangeMedicine(TdiabetesVisits vistits,Long id){
	List<PhDiabetesdetailmedicine> list1 = new ArrayList<PhDiabetesdetailmedicine>();
	if(null!=vistits.getDrugName()&& !"".equals(vistits.getDrugName())){
	    PhDiabetesdetailmedicine medicine = new PhDiabetesdetailmedicine();
	   
	    if(id!=0){
	    	medicine.setDiabetesID(id);
	    }
	    medicine.setDrugName(vistits.getDrugName());
	    medicine.setDrugFreq(vistits.getDrugFreq());
	    medicine.setDrugUnit(vistits.getDrugDoseUnit());
	    medicine.setDrugDosage(vistits.getDrugDose()==null ? "":vistits.getDrugDose().toString());
	    list1.add(medicine);
	}
	if(null!=vistits.getDrugName2()&& !"".equals(vistits.getDrugName2())){
	    PhDiabetesdetailmedicine medicine2 = new PhDiabetesdetailmedicine();
	    if(id!=0){
	    	medicine2.setDiabetesID(id);
	    }
	    medicine2.setDrugName(vistits.getDrugName2());
	    medicine2.setDrugFreq(vistits.getDrugFreq2());
	    medicine2.setDrugUnit(vistits.getDrugDoseUnit2());
	    medicine2.setDrugDosage(vistits.getDrugDose2()==null ? "":vistits.getDrugDose2().toString());
	    list1.add(medicine2);
	}
	if(null!=vistits.getDrugName3()&& !"".equals(vistits.getDrugName3())){
	    PhDiabetesdetailmedicine medicine3 = new PhDiabetesdetailmedicine();
	    if(id!=0){
	    	medicine3.setDiabetesID(id);
	    }
	    medicine3.setDrugName(vistits.getDrugName3());
	    medicine3.setDrugFreq(vistits.getDrugFreq3());
	    medicine3.setDrugUnit(vistits.getDrugDoseUnit3());
	    medicine3.setDrugDosage(vistits.getDrugDose3()==null ? "":vistits.getDrugDose3().toString());
	    list1.add(medicine3);
	}
	return list1;
	
    }
    
    private PhDiabetesdetail getChangePhDiabetesdetail(TdiabetesVisits d){
    	PhDiabetesdetail pd = new PhDiabetesdetail();
    	pd.setVisitWay(Byte.parseByte(d.getVisitsSrt()));
    	pd.setSymptom_Desc(d.getSymptomOth());
    	pd.setSystolic(d.getSystolicPre());
    	pd.setDiastolic(d.getDiastolicPre());
    	pd.setHeight(d.getHeight());
    	pd.setWeight(d.getWeight());
    	pd.setWeight_Next(d.getTarWeight());
    	pd.setBMI(d.getBmi());
    	pd.setBMI_Next(d.getTarBmi());
    	pd.setArteriopalmus(Byte.parseByte(d.getDorPedPul()));
    	pd.setOtherSign(d.getPosSignsOth());
    	pd.setDailySmoking(d.getDaoSmoking());
    	pd.setDailySmoking_Next(d.getTraDaoSmoking());
    	pd.setDailyDrink(BigDecimal.valueOf(d.getAlcConsumption()));
    	pd.setDailyDrink_Next(BigDecimal.valueOf(d.getTraAlcCon()));
    	pd.setSportFrequency_Next(d.getTraExeFrequency());
    	pd.setSportFrequency(d.getExeFrequency());
    	pd.setSportDuration(d.getExeDuration());
    	pd.setSportDuration_Next(d.getTraExeDuration());
    	pd.setMainFood(d.getDaoStaFood());
    	pd.setMainFood_Next(d.getTraDaoStaFood());
    	pd.setPsychologicalRecovery(Byte.parseByte(d.getPsyAdjEva()));
    	pd.setComplianceBehavior(Byte.parseByte(d.getComBehEva()));
    	pd.setFPG(d.getGlu());
    	pd.setHBA1C(d.getGlyHem());
    	pd.setCheckDate(d.getExDate());
    	pd.setCheckResult(d.getLabExamRes());
    	pd.setDrugCompliance(Byte.parseByte(d.getMedCom()));
    	pd.setDrugAdverseReaction(Byte.parseByte(d.getAdvDrugRea()));
    	pd.setDrugAdverseReaction_Desc(d.getAdvDrugReaDes());
    	pd.setRHG(Byte.parseByte(d.getLbsRea()));
    	pd.setTransferReason(d.getRefDes());
    	pd.setTransferOrgAndDept(d.getRefDept());
    	pd.setVisitDate_Next(d.getNexVisDate());
    	return pd;
    }
    
    
    private PhDiabetes changePhDiabetes(TdiabetesVisits d){
    	PhDiabetes pd= new PhDiabetes();
    	pd.setRefDataPK(d.getDiabGid());// 数据主键
    	pd.setRefCompany(Byte.valueOf("1"));
    	pd.setCreateTime(d.getUpdDate());
    	pd.setUpdateDrID(0);
    	pd.setUpdateDrName("0");
    	pd.setCreateTime(new Date());
    	pd.setGetTime(new Date());
    	pd.setCreateDrID(0);
    	pd.setCreateDrName("0");
    	pd.setUnique_ID(d.getHrGid());
    	pd.setName(d.getName());
    	pd.setVisitDate(d.getVisDate());
    	pd.setVisitDrName(d.getVisDoctor());
    	return pd;
    }

	public int insert(Object model) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Object model) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Object model) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExampleSelective(Object model, Object example) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExample(Object model, Object example) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Object id) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public Object selectById(Object id) {
		
		// TODO Auto-generated method stub
		return null;
	}

	public List selectByExampleAndPage(Page page, Object example) {
		
		// TODO Auto-generated method stub
		return null;
	}

	public int countByExample(Object example) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByExample(Object example) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	public List selectByExample(Object example) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericBaseDao getDao() {
		
		// TODO Auto-generated method stub
		return null;
	}

}
