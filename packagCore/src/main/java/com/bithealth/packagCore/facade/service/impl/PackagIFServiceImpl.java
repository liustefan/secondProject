package com.bithealth.packagCore.facade.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bithealth.packagCore.facade.constants.PackageConstants;
import com.bithealth.packagCore.facade.service.PackagIFService;
import com.bithealth.packagCore.packag.model.MemBerPackagTemplate;
import com.bithealth.packagCore.packag.model.MemBerPackagTemplateExample;
import com.bithealth.packagCore.packag.model.MemberPackag;
import com.bithealth.packagCore.packag.model.MemberPackagExample;
import com.bithealth.packagCore.packag.model.Packag;
import com.bithealth.packagCore.packag.model.PackagDetail;
import com.bithealth.packagCore.packag.model.PackagDetailExample;
import com.bithealth.packagCore.packag.model.PackagExample;
import com.bithealth.packagCore.packag.model.PackagExample.Criteria;
import com.bithealth.packagCore.packag.service.MemBerPackagTemplateService;
import com.bithealth.packagCore.packag.service.MemberPackagService;
import com.bithealth.packagCore.packag.service.PackagDetailService;
import com.bithealth.packagCore.packag.service.PackagService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名称: PackagServiceImpl  
 * 功能描述: 套餐模块对外服务接口实现类 
 * 增加/修改原 因:  
 * 日期: 2016年7月5日 下午2:11:18 
 * 
 * @author 谢美团
 * @version  
 */

@SuppressWarnings("restriction")
@Service("packagIFService") 
public class PackagIFServiceImpl implements PackagIFService{
	
	private Logger logger=Logger.getLogger(PackagIFServiceImpl.class);
	
	@Resource
	PackagService  packagService;
	
	@Resource
	PackagDetailService packagDetailService;
	
	@Resource
	MemberPackagService memberPackagService;
	
	@Resource
	MemBerPackagTemplateService templateService;

	@Override
	public List<Packag> selectPackagListByParams(Page<Packag> page, Packag packag, boolean isSelectPackagDetail) {
		PackagExample example = new PackagExample();
		Criteria  criteria = example.createCriteria();
		if(null != packag.getOrgId()){
			criteria.andOrgIdEqualTo(packag.getOrgId());
		}
		if(null != packag.getPackageName()){
			criteria.andPackageNameEqualTo(packag.getPackageName());
		}
		if(null != packag.getPackageCode()){
			criteria.andPackageCodeEqualTo(packag.getPackageCode());
		}
		criteria.andUseTagEqualTo("T");
		List<Packag> packagList = packagService.selectByExampleAndPage(page, example);
		if(isSelectPackagDetail){ //关联查询套餐明细列表
			for(Packag tempPackag:packagList){
				tempPackag.setPackagDetailList(selectPackagDetailListByPackageCode (tempPackag.getPackageCode()));
			}
		}
		return packagList;
	}
	
	@Override
	public List<PackagDetail> selectPackagDetailListByPackageCode(Integer packageCode) {
		PackagDetailExample packagDetailExample = new PackagDetailExample();
		packagDetailExample.createCriteria().andPackageCodeEqualTo(packageCode);
		return packagDetailService.selectByExample(packagDetailExample);
	}

	@Override
	public int insertPackagAndDetail(Packag packag) {
		int rows = packagService.insert(packag);
		if(rows == 1 && null != packag.getPackagDetailList() && packag.getPackagDetailList().size() > 0){
			for(PackagDetail packagDetail:packag.getPackagDetailList()){
				packagDetail.setPackageCode(packag.getPackageCode());
			}
			packagDetailService.insertByBatch(packag.getPackagDetailList());
		}
		return rows;
	}

	/** 
	     * @Title: send 
	     * @Description: 该方法参合业务逻辑：修改套餐时先行验证改套餐是否发布，已发布套餐将不进行修改，返回值为：-1.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.packagCore.facade.service.PackagIFService#updatePackag(com.bithealth.packagCore.facade.model.PackagIF)
	     */
	@Override
	public int updatePackag(Packag packag) {
		
		// 验证修改的套餐是否已经发布
		List<MemberPackag>  memberPackageList = memberPackagService.selectByParam(packag.getPackageCode());
		if(memberPackageList != null && memberPackageList.size() > 0){
			return -1; //套餐已发布，不能修改
		}
		//更新主表数据
		int rows =packagService.update(packag);

		//根据套餐代码删除从表数据
		PackagDetailExample packagDetailExample = new PackagDetailExample();
		packagDetailExample.createCriteria().andPackageCodeEqualTo(packag.getPackageCode());
		packagDetailService.deleteByExample(packagDetailExample);
		//批量插入数据
		if( null != packag.getPackagDetailList() && packag.getPackagDetailList().size() > 0){
			for(PackagDetail packagDetail:packag.getPackagDetailList()){
				packagDetail.setPackageCode(packag.getPackageCode());
			}
			packagDetailService.insertByBatch(packag.getPackagDetailList());
		}
		return rows;
	}

	/** 
	     * @Title: send 
	     * @Description: 该方法参合业务逻辑：删除套餐时先行验证改套餐是否发布，已发布套餐将不进行删除，返回值为：-1.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.packagCore.facade.service.PackagIFService#deletePackag(com.bithealth.packagCore.facade.model.PackagIF)
	     */
	@Override
	public int deletePackag(Packag packag) {
		
		// 验证修改的套餐是否已经发布
		List<MemberPackag>  memberPackageList = memberPackagService.selectByParam(packag.getPackageCode());
		if(memberPackageList != null && memberPackageList.size() > 0){
			return -1; //套餐已发布，不能修改
		}
		
		//删除业务套餐相关数据
		int rows = packagService.delete(packag.getPackageCode());
		PackagDetailExample packagDetailExample = new PackagDetailExample();
		packagDetailExample.createCriteria().andPackageCodeEqualTo(packag.getPackageCode());
		packagDetailService.deleteByExample(packagDetailExample);
		return rows;
	}


	 
	@Override
	public List<MemberPackag> selectMemberPackagListByParams(Page<MemberPackag> page, MemberPackag memberPackag) {
		MemberPackagExample example = new MemberPackagExample();
		com.bithealth.packagCore.packag.model.MemberPackagExample.Criteria  criteria = example.createCriteria();
		if(null != memberPackag.getMemberid() && memberPackag.getMemberid() != 0){
			criteria.andMemberidEqualTo(memberPackag.getMemberid());
		}
		if( null != memberPackag.getLineNum() && memberPackag.getLineNum() != 0){
			criteria.andLineNumEqualTo(memberPackag.getLineNum());
		}
		if(null !=  memberPackag.getPackageCode() ){
			criteria.andPackageCodeEqualTo(memberPackag.getPackageCode());
		}
		if(null != memberPackag.getTag()){
			criteria.andTagEqualTo(memberPackag.getTag());
		}
		criteria.andTagEqualTo("T");
		return memberPackagService.selectByExampleAndPage(page, example);
	}


	@Override
	public List<MemBerPackagTemplate> selectMemBerPackagTemplateByParams(Page<MemBerPackagTemplate> page,MemBerPackagTemplate memBerPackagTemplate) {
		
		MemBerPackagTemplateExample  example = new  MemBerPackagTemplateExample(); 
		com.bithealth.packagCore.packag.model.MemBerPackagTemplateExample.Criteria  criteria = example.createCriteria();
		if(null != memBerPackagTemplate.getMemberid()){
			criteria.andMemberidEqualTo(memBerPackagTemplate.getMemberid());
		}
		if(null != memBerPackagTemplate.getPackageCode()){
			criteria.andPackageCodeEqualTo(memBerPackagTemplate.getPackageCode());
		}
		if(null != memBerPackagTemplate.getLineNum()){
			criteria.andLineNumEqualTo(memBerPackagTemplate.getLineNum());
		}
		if(null != memBerPackagTemplate.getSumRepTempCode()){
			criteria.andSumRepTempCodeEqualTo(memBerPackagTemplate.getSumRepTempCode());
		}
		criteria.andTagEqualTo("T");
		return templateService.selectByExampleAndPage(page, example);
	}

	@Override
	public String deleteMemberPackag(MemberPackag memberPackag) {
		if(!isValidKeyParams(memberPackag)){
			return "主键参数为空，无法删除";
		}
			
		boolean result = isInValidityPeriod(memberPackag); //  验证删除的套餐是否在有效期内	
		if(result){
			return "该套餐仍在有效期内，无法删除";
		}
		
		//只进行逻辑删除，不进行物理删除
		memberPackag.setTag("F");
		memberPackagService.update(memberPackag);
		//关联删除套餐模板明细
		MemBerPackagTemplate  model  = new  MemBerPackagTemplate(); 
		model.setTag("F");
		MemBerPackagTemplateExample templateExample = new MemBerPackagTemplateExample();
		com.bithealth.packagCore.packag.model.MemBerPackagTemplateExample.Criteria  criteria = templateExample.createCriteria();
		if(memberPackag.getMemberid() != null && memberPackag.getLineNum() != null){
			criteria.andMemberidEqualTo(memberPackag.getMemberid()).andTagEqualTo("T")
					.andLineNumEqualTo(memberPackag.getLineNum());
			templateService.updateByExampleSelective(model, templateExample);
		}
		return PackageConstants.SUCCESS;
	}


	@Override
	public String updateMemberPackag(MemberPackag memberPackag) {
		if(!isValidKeyParams(memberPackag)){
			return "主键参数为空，无法修改";
		}
		//获取修改之前的套餐信息
		MemberPackagExample example  = new MemberPackagExample ();
		example.createCriteria().andMemberidEqualTo(memberPackag.getMemberid()).andLineNumEqualTo(memberPackag.getLineNum());
		List<MemberPackag> oldMemPackageList = memberPackagService.selectByExample(example);
		if(oldMemPackageList != null && oldMemPackageList.size() > 0){
			MemberPackag oldMemPackage = oldMemPackageList.get(0);
			
			boolean result = isInValidityPeriod(oldMemPackage); // 验证修改前的套餐是否在有效期内
			if(result){
				return "该套餐仍在有效期内，无法修改";
			}
			
			//先删除修改的套餐
			deleteMemberPackag(oldMemPackage);
			
			//在新增新的套餐
			insertMemberPackag(memberPackag);
			
			return PackageConstants.SUCCESS;
			
		}else{
			return "未找到修改的数据套餐，修改失败";
		}
	}


	@Override
	public String insertMemberPackag(MemberPackag memberPackag) {
		try{
			boolean result = isInValidityPeriod(memberPackag); // 验证新增的的套餐是否已经绑定且在有效期内
			if(result){
				return "该套餐已经绑定且在有效期内，无法添加";
			}
			
			Short lineNum = (short) (memberPackagService.selectMaxLineNum() +1);
			memberPackag.setLineNum(lineNum);
			memberPackag.setCreateTime(new Date());
			
			// 保存会员订购套餐主体信息
			memberPackagService.insert(memberPackag);
			
			//保存套餐关联的模板列表数据
			List<PackagDetail>  packagDetailList = selectPackagDetailListByPackageCode(memberPackag.getPackageCode());
			List<MemBerPackagTemplate> templateList  = new ArrayList<MemBerPackagTemplate>();
			for(PackagDetail tempPackagDetail:packagDetailList){
				MemBerPackagTemplate template = new MemBerPackagTemplate ();
				if("T".equals(tempPackagDetail.getCalcType())){ //计时
					template.setBeginDate(new Date());
					template.setEndDate(getEndDate(tempPackagDetail.getNumDay()));  //通过计算获得结束日期
				}else{//计次
					template.setNumTimes(tempPackagDetail.getNumTimes());
					template.setSubmitNum((short)0);
				}
				template.setCalcType(tempPackagDetail.getCalcType());
				template.setLineNum(memberPackag.getLineNum());
				template.setMemberid(memberPackag.getMemberid());
				template.setPackageCode(memberPackag.getPackageCode());
				template.setSumRepTempCode(tempPackagDetail.getSumRepTempCode());
				template.setTag("T");
				templateList.add(template);
			}
			if(templateList.size() > 0){
				templateService.insertByBatch(templateList);
			}
			
			// 调用存储过程  pro_insOMAS(?,?,?)
			memberPackagService.exProc_pro_insOMAS(memberPackag.getCreateid(), memberPackag.getCreateName(), memberPackag.getMemberid());
			
			// 调用 的存储过程 call pro_updOsrs2(?,?)
			memberPackagService.exProc_pro_updOsrs2(0, memberPackag.getMemberid());
			
			return PackageConstants.SUCCESS;
		}catch(Exception e){
			return "添加套餐异常";
		}
	}
	
	
	
	
	/**
	 * @Title:isInValidityPeriod 
	 * @Description:验证指定套餐是否在有效期内. 
	 * 有效期定义：套餐下的模板计时 或 计次 只要有一个还有有效期内，则改套餐在有效期内.  
	 * @author 谢美团
	 * @param memberPackag
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	private boolean isInValidityPeriod(MemberPackag memberPackag){
		boolean result = false;
		MemBerPackagTemplateExample  example = new MemBerPackagTemplateExample();
		
		example.createCriteria().andMemberidEqualTo(memberPackag.getMemberid()).andLineNumEqualTo(memberPackag.getLineNum())
				.andPackageCodeEqualTo(memberPackag.getPackageCode()).andTagEqualTo("T");
		List<MemBerPackagTemplate> templateList = templateService.selectByExample(example);
		for(MemBerPackagTemplate template:templateList){
			if("T".equals(template.getCalcType())){ //计时	
				long currentTime = new Date().getTime();
				if(currentTime <= template.getEndDate().getTime()){
					result = true;
					break;
				}				
			}else if("C".equals(template.getCalcType())){//计次
				if( template.getSubmitNum() <= template.getNumTimes() ){
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
	
	/**
	 * @Title:isValidKeyParams 
	 * @Description:验证 MemberPackag 是否是有效的主键参数. 
	 * (这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param memberPackag
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	private boolean isValidKeyParams(MemberPackag memberPackag){
		if(null == memberPackag.getMemberid() || memberPackag.getMemberid().intValue() == 0 || 
				null == memberPackag.getLineNum() || memberPackag.getLineNum().intValue() == 0 ){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * @Title:getEndDate 
	 * @Description:根据传入的模板周期获取套餐结束日期. 
	 * (这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param n
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun Date
	 */ 
	private Date getEndDate(Short n) throws Exception {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		if (n == null) {
			gc.add(5, 1);
		} else {
			gc.add(5, n);
		}
		Date date = gc.getTime();
		return date;
	}

}