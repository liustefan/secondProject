package com.bithealth.packagCore.packag.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.packagCore.packag.model.MemBerPackagTemplate;
import com.bithealth.packagCore.packag.model.MemberPackag;
import com.bithealth.packagCore.packag.model.MemberPackagExample; 
import com.bithealth.packagCore.packag.model. MemberPackagKey; 

public interface MemberPackagService extends GenericBaseService<MemberPackag,MemberPackagExample,
   MemberPackagKey > {    
	
	/**
	 * @Title:selectMaxLineNum 
	 * @Description:获取会员订购套表中最大的lineNum. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @return 
	 * @throws
	 * @retrun MemberPackag
	 */ 
	public Integer selectMaxLineNum();
	
	
	/**
	 * @Title:selectByPamram 
	 * @Description:根据套餐代码查询会员的订购套餐信息
	 * @author 谢美团
	 * @param packageCode
	 * @return 
	 * @throws
	 * @retrun List<MemberPackag>
	 */ 
	public List<MemberPackag> selectByParam(Integer packageCode);
	
	/**
	 * @Title:exProc_pro_insOMAS 
	 * @Description:调用 pro_insOMAS 存储过程
	 * @author 谢美团
	 * @param createId
	 * @param createName
	 * @param memberId 
	 * @throws
	 * @retrun void
	 */ 
	public void exProc_pro_insOMAS(Integer createId,String createName,Integer memberId);  
	
	/**
	 * @Title:exProc_pro_updOsrs2 
	 * @Description:调用存储过程
	 * @author 谢美团
	 * @param creatId
	 * @param memberId 
	 * @throws
	 * @retrun void
	 */ 
	public void exProc_pro_updOsrs2(Integer createId,Integer memberId);
	

	
}
