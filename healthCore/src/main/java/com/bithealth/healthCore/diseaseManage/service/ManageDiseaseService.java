package com.bithealth.healthCore.diseaseManage.service;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.healthCore.diseaseManage.model.ManageDisease;
import com.bithealth.healthCore.diseaseManage.model.ManageDiseaseExample; 
/**
 * 类名称: ManageDiseaseService  
 * 功能描述: 疾病管理服务接口
 * 日期: 2016年11月29日 
 * 
 * @author 周玉飞
 * @version  
 */
public interface ManageDiseaseService extends GenericBaseService<ManageDisease,ManageDiseaseExample,
   Integer > {  
	
	//查询同名疾病分类(全局不可重复)
	ManageDisease selectExistByName(String diseasename);
	
	int getMaxParentId(int parentId);
	
	boolean  deleteChildren(Integer id);
	
}
