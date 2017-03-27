package com.bithealth.dataConversionServer.assemble;

import java.util.ArrayList;
import java.util.List;


public class Assemble {
	
	public static final String ROOT = "Assemes";  //装配文件根节点
	
	public static final String ELEMENT = "Assem"; //装配元素节点
	
	//装配文件命名空间
	public static final String ASSEMBLE_NAMESPACE = "namespace";
	
	//映射原对象属性名
	public static final String ASSEMBLE_NAME = "name";
	
	//装配后对象的属性名
	public static final String ASSEMBLE_ASSEM = "assembly";
	
	public static final String ASSEMBLY_CLS = "assemCls";
	
	public static final String ASSEMBLY_METHOD = "method";
	
	//装配器名
	private String namespace;
	
	//需要装配的对应关系
	private List<FieldPairs> fieldList = new ArrayList<FieldPairs>();
	
	public void addField(FieldPairs field) {
		if(this.fieldList == null) {
			this.fieldList = new ArrayList<FieldPairs>();
		}
		this.fieldList.add(field);
	}
	
	public List<FieldPairs> getFields(){
		return this.fieldList;
	}
	
	public FieldPairs getFieldPairByTarget(String targetField) {
		for(FieldPairs pair : this.fieldList) {
			if(targetField.equals(pair.getTargetField())) {
				return pair;
			}
		}
		return null;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	

//	public Map<String, String> getAssemKeyMap() {
//		return assemKeyMap;
//	}
//
//	public void setAssemKeyMap(Map<String, String> assemKeyMap) {
//		this.assemKeyMap = assemKeyMap;
//	}

}
