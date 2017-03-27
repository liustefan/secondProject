 
/**
 * @PackageName:      com.bithealth.inspectCore.physical.model
 * @FileName:     DictEntity.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月25日 上午11:30:29  
 * 
 */

package com.bithealth.inspectCore.model;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.bithealth.inspectCore.Constants;
import com.bithealth.inspectCore.dict.model.PhDictitem;
import com.bithealth.sdk.core.generic.GenericModel;


/**
 * 类名称: DictEntity  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月25日 上午11:30:29 
 * 
 * @author baozj
 * @version  
 */
public class DictEntity extends GenericModel {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -7158480426608584050L;

	private static Map<String, List<PhDictitem>> dicts;
	
	/**
	 * 将用数字代表的类型转换为字符串
	 * @param dTypeName
	 * @param source
	 * @param dItemId
	 * @return
	 */
	public String convertStr(String dTypeName, String source, Byte dItemId){
		if (dicts != null && dItemId != null) {
			List<PhDictitem> items = dicts.get(source + Constants.PH_DICTIONARY_SEPARATOR + dTypeName);
			if (items != null && !items.isEmpty()) {
				for(PhDictitem item : items)
					if(item.getDItemID().equals(dItemId))
						return item.getDItemName();
			}
		}
		return null;
	}
	
	/**
	 * 获取字典名称
	 * @param dTypeName 	字典类型
	 * @param source		字典来源
	 * @param codes			特殊字符拼接的字典编号（特殊字符见 {@link Constants.PH_DATA_SEPARATOR}）
	 * @param exclude 		排除的名称
	 * @author baozejun
	 */
	protected String getNames(String dTypeName, String source, String codes, String...exclude){
		return getExtendNames(dTypeName, source, codes, null, null, null, exclude);
	}
	
	/**
	 * 获取字典名称
	 * @param dTypeName 	字典类型
	 * @param source		字典来源
	 * @param codes			特殊字符拼接的字典编号（特殊字符见 {@link Constants.PH_DATA_SEPARATOR}）
	 * @param equalValue	与字典中对应名字相等后面拼接（@param desc）
	 * @param desc			
	 * @param equalValue2	与字典中对应名字相等只返回相等的名称
	 * @param exclude 		排除的名称
	 * @author baozejun
	 */
	protected String getExtendNames(String dTypeName, String source, String codes, String equalValue, String desc, String equalValue2, String...exclude){
		if (StringUtils.isNotEmpty(codes) && dicts != null) {
			StringBuilder names = new StringBuilder();
			for (String ar : codes.split(Constants.PH_DATA_SEPARATOR)) {
				
//				Map<String, Object> map = phDictionaryService.find(dTypeName, source, Integer.parseInt(ar));
//				PhDictitem pojo = dictService.select(source, dTypeName, Byte.valueOf(ar));
				String name = convertStr(dTypeName, source, Byte.valueOf(ar));
				if (StringUtils.isNotEmpty(name)) {
					if(exclude.length > 0){
						for (int i = 0; i < exclude.length; i++) {
							if(exclude[i].equals(name)){
								name = null;
								break;
							}
						}
					}
					if(StringUtils.isNotEmpty(name)){
						if(StringUtils.isNotEmpty(equalValue2) && equalValue2.equals(name)){
							names = new StringBuilder(name+" ");
							break;
						}
						if(StringUtils.isNotEmpty(equalValue) && equalValue.equals(name) && StringUtils.isNotEmpty(desc)) {
							names.append(name).append("(").append(desc).append(")").append("，");
						} else {
							names.append(name).append("，");
						}
					}
					
				}
				
			}
			return names.length() > 0 ? names.substring(0, names.toString().length() - 1) : "";
		}
		return "";
	}
	
	/**
	 * 获取数据字典数组
	 * @param str 	字典编号拼接的字符串
	 * @author baozejun
	 */
	protected String[] getArray(String str){
		return str != null ? str.split(Constants.PH_DATA_SEPARATOR) : null;
	}
	
	/**
	 * 数据字典数组转拼接的字符串
	 * @param str 	字典编号拼接的字符串
	 * @author baozejun
	 */
	protected String arrayToJoint(String str){
		return str != null&&str.contains(",") ? str.replaceAll(",", Constants.PH_DATA_SEPARATOR) : str;
	}

	@JSONField(serialize = false)
	public Map<String, List<PhDictitem>> getDicts() {
		return dicts;
	}

	public static void setDicts(Map<String, List<PhDictitem>> map) {
		dicts = map;
	}
	
}

