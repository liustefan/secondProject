package com.bithealth.dataConversionServer.qiangHua.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.dataConversionServer.assemble.AssemUtil;
import com.bithealth.dataConversionServer.dataSource.DataSourceSwitch;
import com.bithealth.dataConversionServer.qiangHua.bean.ThypertensionVisits;
import com.bithealth.dataConversionServer.qiangHua.service.HypertensionService;
import com.bithealth.dataConversionServer.util.Constants;
import com.bithealth.dataConversionServer.util.StringUtil;
import com.bithealth.inspectCore.facede.service.InspectFacedeService;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetail;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailmedicine;
import com.bithealth.inspectCore.inspect.service.InspectService;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;
/*
 * 高血压随访入库
 */

@Service
public class HypertensionServiceImpl extends GenericBaseServiceImpl implements HypertensionService {
	@Autowired
	InspectFacedeService inspectService;
	@Autowired
	private MemberService memberService;

	
	public int saveHypertension(ThypertensionVisits visit) {
		boolean fal = false;
		//PhHypertension hypertension = AssemUtil.beanToBean(visit, PhHypertension.class, Constants.HYPERTENSION_ASSEM_FILE);
		PhHypertension hypertension = changeHyPertension(visit);
		PhHypertensiondetail  detail = AssemUtil.beanToBean(visit, PhHypertensiondetail.class, Constants.HYPERTENSION_DETAIL_FILE);
		List<PhHypertensiondetailmedicine> list=changeHyperMedical(visit);
		
		DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
		PhHypertension phHypertension=inspectService.selectPhHypertensionByRefDataPK(visit.getHypeGid());
		hypertension.setPhHypertensiondetail(detail);
		hypertension.setPhHypertensiondetailmedicines(list);
		hypertension.setRefCompany(new Byte("1"));
		hypertension.setGetTime(new java.util.Date());
		hypertension.setCreateDrID(0);
		hypertension.setCreateDrName("系统用户");
		Member member=memberService.selectByUniqueId(hypertension.getUnique_ID());
		if(null!=member){
			hypertension.setMemberID(member.getMemberid());
			if(null!=phHypertension){
				hypertension.setHypertensionID(phHypertension.getHypertensionID());
//				fal=inspectService.updatePhHypertension(hypertension);
				fal=inspectService.insertOrUpdateHypertension(hypertension);
			}else{
//				fal=inspectService.insertPhHypertension(hypertension);
				fal=inspectService.insertOrUpdateHypertension(hypertension);
			}
		}
		if(fal==false) return -1; else return 1;
	}
	
	
	private List<PhHypertensiondetailmedicine> changeHyperMedical(ThypertensionVisits visit) {
		List<PhHypertensiondetailmedicine> list = new ArrayList<PhHypertensiondetailmedicine>();
		
		PhHypertensiondetailmedicine medical = null;
		if(!StringUtil.isEmpty(visit.getDrugName())) {
			medical = new PhHypertensiondetailmedicine();
			//medical.setHypertensionID(hyId);
			medical.setDrugFreq(visit.getDrugFreq());
			medical.setDrugName(visit.getDrugName());
			medical.setDrugDosage(visit.getDrugDose() == null ? "" : visit.getDrugDose().floatValue()+"");
			medical.setDrugUnit(visit.getDrugDoseUnit());
			list.add(medical);
		}
		
		if(!StringUtil.isEmpty(visit.getDrugName2())) {
			medical = new PhHypertensiondetailmedicine();
			//medical.setHypertensionID(hyId);
			medical.setDrugFreq(visit.getDrugFreq2());
			medical.setDrugName(visit.getDrugName2());
			medical.setDrugDosage(visit.getDrugDose2() == null ? "" : visit.getDrugDose2().floatValue()+"");
			medical.setDrugUnit(visit.getDrugDoseUnit2());
			list.add(medical);
		}
		
		if(!StringUtil.isEmpty(visit.getDrugName3())) {
			medical = new PhHypertensiondetailmedicine();
			//medical.setHypertensionID(hyId);
			medical.setDrugFreq(visit.getDrugFreq3());
			medical.setDrugName(visit.getDrugName3());
			medical.setDrugDosage(visit.getDrugDose3() == null ? "" : visit.getDrugDose3().floatValue()+"");
			medical.setDrugUnit(visit.getDrugDoseUnit3());
			list.add(medical);
		}
		
		if(!StringUtil.isEmpty(visit.getDrugNameOth())) {
			// medical.setHypertensionID(hyId);
			medical.setDrugFreq(visit.getDrugFreqOth());
			medical.setDrugName(visit.getDrugNameOth());
			medical.setDrugDosage(visit.getDrugDoseOth() == null ? "" : visit.getDrugDoseOth().floatValue()+"");
			medical.setDrugUnit(visit.getDrugDoseUnitOth());
			list.add(medical);
		}
		
		return list;
	}
	
	
	private PhHypertension changeHyPertension(ThypertensionVisits v){
		PhHypertension hy = new PhHypertension();
		hy.setRefDataPK(v.getHypeGid());
		hy.setUnique_ID(v.getHrGid());
		hy.setName(v.getName());
		hy.setVisitDate(v.getVisDate());
		hy.setVisitDrName(v.getVisDoctor());
		hy.setCreateTime(v.getRecDate());
		hy.setUpdateTime(v.getUpdDate());
		hy.setCreateDrName(v.getRecUser());
		hy.setUpdateDrName(v.getUpdUser());
		hy.setVisitClass(Byte.parseByte(v.getVisitsEva()));
		return hy;
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
