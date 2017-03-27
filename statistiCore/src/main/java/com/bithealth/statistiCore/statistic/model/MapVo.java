package com.bithealth.statistiCore.statistic.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 类名：
 * 描述：
 * @author 作者:周玉飞
 * @version 创建时间：2016年8月12日 上午9:30:02
 * 类说明
 */
public class MapVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5941807079617199385L;
	
	Map<String, Object> paramMap = new HashMap<String, Object>();

	public Map<String, Object> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
	
	
}
