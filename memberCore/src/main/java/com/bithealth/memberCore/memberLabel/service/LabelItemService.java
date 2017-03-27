package com.bithealth.memberCore.memberLabel.service;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.model.LabelItemExample; 
/**
 * 类名称: LabelItemService  
 * 功能描述: 标签小项关系接口
 * 日期: 2016年11月29日 
 * 
 * @author 周玉飞
 * @version  
 */
public interface LabelItemService extends GenericBaseService<LabelItem,LabelItemExample, Integer > {    
	
	LabelItem selectLabelItem(Integer roleId, String itemname, Integer id, Integer docId, String allSharedOrg);
	
	
}
