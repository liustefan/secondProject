/**
 * @PackageName:      com.bithealth.vo
 * @FileName:     AbsObjectEquals.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月30日 下午2:38:26  
 * 
 */
package com.bithealth.memberCore.member.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 类名称: AbsObjectEquals  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月30日 下午2:38:26 
 * 
 * @author liuhm
 * @version  
 */
public abstract class AbsObjectEquals<E> {
    private Map<E, List<E>> baseInfoMap = new LinkedHashMap<E,List<E>>();
	
	/*
	 * 重复数据key
	 */
	public final static String DUPLICATE = "duplicate";
	
	/*
	 * 去除重复数据后的key
	 */
	public final static String FINAL = "final";

	/**
	 * 加入对象中
	 * 依据isEquals的值，判断是否添加成功
	 * @param baseInfo
	 * @return true添加成功，否则失败（重复保存）
	 */
	public boolean add(E baseInfo) {
		Set<E> set = this.baseInfoMap.keySet();
		if(!set.isEmpty()){
			for(E base : set){
				if(isEquals(baseInfo, base)){
					this.baseInfoMap.get(base).add(baseInfo);
					return false;
				}
			}
		}
		
		List<E> list = new ArrayList<E>(); 
		list.add(baseInfo);
		this.baseInfoMap.put(baseInfo, list);
		return true;
	}
	
	/**
	 * 依据自定义业务规则过滤相同值
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public abstract boolean isEquals(E obj1, E obj2);
	
	private boolean contains(E first, E second){
		List<E> list = this.baseInfoMap.get(first);
		List<E> subList = this.baseInfoMap.get(second);
		if(list == null || list.isEmpty() || subList == null || subList.isEmpty()){
			return false;
		}
		for(E base1 : list){
			for(E base2 : subList){
				if(this.isEquals(base1, base2)){
					return true;
				}
			}
		}
		return false;
	}
	
	
	private void getData(){
		Set<E> set = this.baseInfoMap.keySet();
		if(set.isEmpty()){
			return ;
		}
		List<E> list = new ArrayList<E>();
		list.addAll(set);
		int len = list.size();
		for(int i = 0; i < len; i++){
			E base = list.get(i);
			for(int j = ++i; j < len; j++) {
				E keyBase = list.get(j);
				if(contains(base, keyBase)){
					this.baseInfoMap.get(base).addAll(this.baseInfoMap.get(keyBase));
					this.baseInfoMap.remove(keyBase);
				}
			}
		}
		
		list = null;
	}

	/**
	 * 获取去重后的对象一直重复对象的集合
	 * key-FINAL:去重后的对象
	 * key-DUPLICATE:重复对象
	 * @return
	 */
	public Map<String, List<E>> getResult(){
		getData();
		Map<String, List<E>> resultMap = new HashMap<String,List<E>>();
		List<E> finalList = new ArrayList<E>();
		List<E> dupList = new ArrayList<E>();
		Set<E> set = new HashSet<E>();
		for(E e : this.baseInfoMap.keySet()){
			List<E> list = this.baseInfoMap.get(e);
			if(list.size() > 1){
				set.addAll(list);
			}else{
				finalList.add(e);
			}
		}
		dupList.addAll(set);
		resultMap.put(DUPLICATE, dupList);
		resultMap.put(FINAL, finalList);
		return resultMap;
	}
	
	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isNull(){
		return this.baseInfoMap.isEmpty();
	}
}
