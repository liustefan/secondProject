package com.bithealth.dataConversionServer.assemble;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import com.bithealth.dataConversionServer.util.XmlUtil;



public final class AssembleFactory {
	
	private static AssembleFactory factory = null;
	private Map<String, Assemble> assembleMap = new HashMap<String, Assemble>();
	private Document document = null;
	private String fileName;
	private final static Object locked = new Object();
	private AssembleFactory() {
		
	}
	
	public static AssembleFactory newInstence() {
		if(factory == null) {
			synchronized (locked){
				if(factory == null) {
					factory = new AssembleFactory();
				}
			}
		}
		return factory;
	}
	
	public Assemble builderAssem(String fileName) {
		this.fileName = fileName;
		document = XmlUtil.loadXml(fileName);
		return parsAssem();
	}
	
	@SuppressWarnings("unchecked")
	private Assemble parsAssem() {
		Assemble  assem = new Assemble();
		Element root = document.getRootElement();
		String namespace = root.attributeValue(Assemble.ASSEMBLE_NAMESPACE);
		if(assembleMap.containsKey(fileName)) {
			return assembleMap.get(fileName);
		}
		assem.setNamespace(namespace);
		List<Element> fileds = root.elements(Assemble.ELEMENT);
		for(Element el : fileds) {
			FieldPairs field = new FieldPairs();
			field.setSourceField(el.attributeValue(Assemble.ASSEMBLE_NAME));
			field.setTargetField(el.attributeValue(Assemble.ASSEMBLE_ASSEM));
			Attribute attr = el.attribute(Assemble.ASSEMBLY_CLS);
			if(attr != null) {
				field.setAssemCls(attr.getValue());
				field.setMethod(el.attributeValue(Assemble.ASSEMBLY_METHOD));
			}
			assem.addField(field);
		}
		assembleMap.put(fileName, assem);
		return assem;
	}

}
