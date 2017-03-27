package com.bithealth.dataConversionServer.util;


import java.lang.reflect.Field;
import java.util.Map;





/**
 * @ClassName:     BeanUtil.java 
 * @Description:   实体类操作帮助类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年2月26日 上午9:42:38
*****/
public class BeanUtil {

	
	
	
	 /** 
	 * @Title: beanConversion 
	 * @Description: 根据 
	 * @param map
	 * @param targetClazz
	 * @param sourceClazz
	 * @return    
	 * @retrun Object
	 */
	@SuppressWarnings("rawtypes")
	public static Object beanConversion(Map<String, Object> mappingMap,Class targetClazz,Class sourceClazz){
		
		
		
		
		
		return null;
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
	
    	 	
}
