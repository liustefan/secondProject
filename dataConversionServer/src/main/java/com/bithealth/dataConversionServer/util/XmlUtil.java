package com.bithealth.dataConversionServer.util;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


/**
 * @ClassName:     XmlUtil.java 
 * @Description:   XML解析工具类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月22日 下午3:18:13
*****/
public class XmlUtil {
	
	 /** 
	 * @Title: xmlStrToBean 
	 * @Description: xml字符串转换成bean对象 
	 * @param xmlStr
	 * @param clazz
	 * @return    
	 * @retrun Object
	 */
	private static Object xmlStrToBean(String xmlStr, Class clazz) {
		Object obj = null;
		try {
			//将xml格式的数据转换成Map对象
			Map<String, Object> map = xmlStrToMap(xmlStr);
			//将map对象的数据转换成Bean对象
			obj = mapToBean(map, clazz);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	 /** 
	 * @Title: xmlStrToBeanList 
	 * @Description: xml字符串转换成bean对象组成的List  
	 * @param xmlStr
	 * @param clazz
	 * @return    
	 * @retrun Object
	 * @throws Exception 
	 */
	public static Object xmlStrToBeanList(String xmlStr, Class clazz) throws Exception {
		List<Object> beanList = new ArrayList<Object>();
		//将xml格式的数据转换成包含Map对象的list
		List<Map<String, Object>> mapList =  parseXmlStrToListByXpath(xmlStr);

		//将包含map对象的List数据转换成包含Bean对象的list
		beanList = mapListToBeanList(mapList, clazz);
		return beanList;
	}
	
	
	
	
	

	 /** 
	 * @Title: xmlStrToMap 
	 * @Description: 将xml格式的字符串转换成Map对象
	 * @param xmlStr
	 * @return
	 * @throws Exception    
	 * @retrun Map<String,Object>
	 */
	public static Map<String, Object> xmlStrToMap(String xmlStr) throws Exception {
		if(StringUtil.isEmpty(xmlStr)) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		//将xml格式的字符串转换成Document对象
		Document doc = DocumentHelper.parseText(xmlStr);
		//获取根节点
		Element root = doc.getRootElement();
		//获取根节点下的所有元素
		List children = root.elements();
		//循环所有子元素
		if(children != null && children.size() > 0) {
			for(int i = 0; i < children.size(); i++) {
				Element child = (Element)children.get(i);
				 for(Iterator iter = child.elementIterator(); iter.hasNext();){
					 Element child2 = (Element) iter.next();  
					 map.put(child2.attributeValue("name"), child2.getTextTrim());
				 }
			}
		}
		return map;
	}
	
	
	 /** 
	 * @Title: xmlStrToList 
	 * @Description: 将xml格式的字符串转换成Map对象组成的List(适合只有三个层次结构的XML) 
	 * @param xmlStr
	 * @return    
	 * @retrun List<Map<String,Object>>
	 * @throws DocumentException 
	 */
	public static List<Map<String, Object>> xmlStrToList(String xmlStr) throws DocumentException{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		if(StringUtil.isEmpty(xmlStr)) {
			return null;
		}
		//将xml格式的字符串转换成Document对象
		Document doc = DocumentHelper.parseText(xmlStr);
		//获取根节点
		Element root = doc.getRootElement();
		//获取根节点下的所有元素
		List children = root.elements();
		//循环所有子元素
		if(children != null && children.size() > 0) {
			for(int i = 0; i < children.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				Element child = (Element)children.get(i);
				 for(Iterator iter = child.elementIterator(); iter.hasNext();){
					 Element child2 = (Element) iter.next();  
					 map.put(child2.attributeValue("name"), removeNullStr(child2.getTextTrim()));
				 }
				 list.add(map);
			}
		}
		return list;
	}
	
	
	 /** 
	 * @Title: parseXmlStrToListByXpath 
	 * @Description: 通过xpath解析xml 
	 * @param xmlStr
	 * @return
	 * @throws DocumentException    
	 * @retrun List<Map<String,Object>>
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> parseXmlStrToListByXpath(String xmlStr) throws DocumentException{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		if(StringUtil.isEmpty(xmlStr)) {
			return null;
		}
		//将xml格式的字符串转换成Document对象
		Document doc = DocumentHelper.parseText(xmlStr);
		//获取根节点
		Element root = doc.getRootElement();
		String xpath = "//row";
		List<Element> rowElementlist = (List<Element>)doc.selectNodes("//row");
		for(Element rowElement:rowElementlist){
			List<Element> fieldList = rowElement.elements();
			Map<String, Object> map = new HashMap<String, Object>();
			for(Element fieldElement:fieldList){
				map.put(fieldElement.attributeValue("name"), removeNullStr(fieldElement.getTextTrim()));
			}
			list.add(map);
		}
		return list;
	}
	
	
	
	 /** 
	 * @Title: removeNullStr 
	 * @Description: 去除字符串  的"null" 
	 * @param value
	 * @return    
	 * @retrun String
	 */
	private static String removeNullStr(String value){
		try{
			if(value != null && value.trim().equalsIgnoreCase("null")){
				return "";
			}else{
				return value;
			}
		}catch(Exception e){
			return "";
		}
	}


	 /** 
	 * @Title: mapToBean 
	 * @Description: 将Map对象通过反射机制转换成Bean对象 
	 * @param map
	 * @param clazz
	 * @return
	 * @throws Exception    
	 * @retrun Object
	 */
	public static Object mapToBean(Map<String, Object> map, Class clazz) throws Exception {
		Object obj = clazz.newInstance();
		if(map != null && map.size() > 0) {
			for(Map.Entry<String, Object> entry : map.entrySet()) {
				String propertyName = entry.getKey();
				Object value = entry.getValue();
				String setMethodName = "set"
						+ propertyName.substring(0, 1).toUpperCase()
						+ propertyName.substring(1);
				Field field = getClassField(clazz, propertyName);
				Class fieldTypeClass = field.getType();
				value = convertValType(value, fieldTypeClass);
				clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);
			}
		}
		return obj;
	}
	
	 /** 
	 * @Title: listToBeanList 
	 * @Description:  将List中的map对象转换成制定的 bean对象 组成的List
	 * @param list
	 * @param clazz
	 * @return
	 * @throws Exception    
	 * @retrun List<Object>
	 */
	public static List<Object> mapListToBeanList(List<Map<String, Object>> list,Class clazz) throws Exception{
		List<Object> newList = new ArrayList<Object>();
		for(Map<String, Object> map:list){
			Object obj = mapToBean(map,clazz);
			newList.add(obj);
		}
		return newList;
	}
	
	
	
	 /** 
	 * @Title: convertValType 
	 * @Description: 将Object类型的值，转换成bean对象属性里对应的类型值 
	 * @param value
	 * @param fieldTypeClass
	 * @return    
	 * @retrun Object
	 */
	private static Object convertValType(Object value, Class fieldTypeClass) {
		Object retVal = null;
		if(Long.class.getName().equals(fieldTypeClass.getName()) || long.class.getName().equals(fieldTypeClass.getName())) {
			retVal = Long.parseLong(value.toString());
		} else if(Integer.class.getName().equals(fieldTypeClass.getName()) || int.class.getName().equals(fieldTypeClass.getName())) {
			retVal = Integer.parseInt(value.toString());
		} else if(Float.class.getName().equals(fieldTypeClass.getName()) || float.class.getName().equals(fieldTypeClass.getName())) {
			retVal = Float.parseFloat(value.toString());
		} else if(Double.class.getName().equals(fieldTypeClass.getName()) || double.class.getName().equals(fieldTypeClass.getName())) {
			retVal = Double.parseDouble(value.toString());
		} else {
			retVal = value;
		}
		return retVal;
	}

	
	 /** 
	 * @Title: getClassField 
	 * @Description: 获取指定字段名称查找在class中的对应的Field对象(包括查找父类) 
	 * @param clazz
	 * @param fieldName
	 * @return    
	 * @retrun Field
	 */
	private static Field getClassField(Class clazz, String fieldName) {
		if( Object.class.getName().equals(clazz.getName())) {
			return null;
		}
		Field []declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			if (field.getName().equals(fieldName)) {
				return field;
			}
		}

		Class superClass = clazz.getSuperclass();
		if(superClass != null) {// 简单的递归一下
			return getClassField(superClass, fieldName);
		}
		return null;
	} 
	
	/** 
		 * @Title: listtoXml 
		 * @Description:  将List中的map对象转换成制定的xml
		 * @param list
		 * @param clazz
		 * @return
		 * @throws Exception    
		 * @retrun List<>
		 */
 public  String listtoXml(List list) throws Exception {  
        Document document = DocumentHelper.createDocument();  
        Element nodesElement = document.addElement("nodes");  
        Element nodeElement = nodesElement.addElement("node");
        int i = 0;  
        for (Object o : list) {  
            if (o instanceof Map) {  
                for (Object obj : ((Map) o).keySet()) {  
                    Element keyElement = nodeElement.addElement("field");  
                    keyElement.addAttribute("label1",String.valueOf(((Map) o).get(obj)));  
                    keyElement.setText("<![CDATA["+String.valueOf(obj)+"]]>");  
                }  
            } 
            i++;  
        }  
        return doc2String(document);  
    }
    
 	/** 
	 * @Title: doc2String 
	 * @Description:  将document中的数据输出成xml
	 * @param list
	 * @param clazz
	 * @return
	 * @throws Exception    
	 * @retrun List<>
	 */
    public  String doc2String(Document document) {  
        String s = "";  
        try {  
            // 使用输出流来进行转化  
            ByteArrayOutputStream out = new ByteArrayOutputStream();  
            // 使用UTF-8编码  
            OutputFormat format = new OutputFormat("   ", true, "UTF-8");  
            XMLWriter writer = new XMLWriter(out, format);  
            writer.write(document);  
            s = out.toString("UTF-8");  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
        return s;  
    } 
    
    /**
     * 加载xml文件，转成document对象
     * @param path
     * @return
     */
    public static Document loadXml(String fileName) {
    	SAXReader reader = new SAXReader();
    	try {
			return reader.read(XmlUtil.class.getResourceAsStream("/assem/" + fileName));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static int getTimes(float num,float total){
  		float times = total/num;
  		if(times > (int)times){
  			times+=1;
  		}
  		return (int)times;
  	}

    	 	
}
