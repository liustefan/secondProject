package com.bithealth.dataConversionServer.assemble;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bithealth.dataConversionServer.util.DataTypeConvert;



public class AssemUtil {
	
	private static Logger log = Logger.getLogger(AssemUtil.class);
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T beanToBean(Object source, Class<T> target, String fileName) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(target);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            Object obj = target.newInstance();
            Assemble assem = AssembleFactory.newInstence().builderAssem(fileName);
            for (int i = 0; i < propertyDescriptors.length; i++) {
            	String propertyName = "";
            	try{
	            	PropertyDescriptor descriptor = propertyDescriptors[i];
	            	propertyName = descriptor.getName();
	                FieldPairs pair = assem.getFieldPairByTarget(propertyName);
	                if (pair != null) {
	                    String sourceFiled = pair.getSourceField();
	                    sourceFiled = sourceFiled.substring(0,1).toUpperCase() + sourceFiled.substring(1);
	                    Method m = source.getClass().getMethod("get" + sourceFiled);
	                    Object value =null;	                    
	                    value = m.invoke(source);	
	                    if(null == value){
	                    	continue;
	                    }
	                    value = getValue(pair, value, source);
	                    Class clz = descriptor.getPropertyType();
	                    value = DataTypeConvert.parseData(clz, value);
	                    if (value != null && !"".equals(value)) {
	                        Object[] args = new Object[1];
	                        args[0] = value;
	                        descriptor.getWriteMethod().invoke(obj, args);
	                    }
	                }
                }catch(Exception e){
                	log.error("数据实体转换异常的属性名称："+propertyName+",错误信息："+e.getMessage());
                }
            }
            return (T) obj;
        } catch (Exception e) {
        	log.error("数据实体转换异常。"+e.getMessage());
        	return null;
        }
        
    }

    /**
     * 将Bean转成对应的Map.
     * 
     * @param bean
     *            目标对象
     * @return map
     */
    @SuppressWarnings("rawtypes")
	public static Map<String, Object> beanToMap(Object bean, String fileName) {
        try {
            List<FieldPairs> fieldList = AssembleFactory.newInstence().builderAssem(fileName).getFields();
        	Map<String, Object> resultMap = new HashMap<String, Object>();
            Class type = bean.getClass();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(FieldPairs pair : fieldList) {
            	String sourceField = pair.getSourceField();
            	Object result = null;
            	for (int i = 0; i < propertyDescriptors.length; i++) {
                    PropertyDescriptor descriptor = propertyDescriptors[i];
                    String propertyName = descriptor.getName();
                    if (!propertyName.equals("class")) {
                        Method readMethod = descriptor.getReadMethod();
                        if(readMethod == null){
                        	break;
                        }
                        if(!propertyName.equals(sourceField)) {
                        	continue;
                        }
                        result = readMethod.invoke(bean);
                        result = getValue(pair, result, bean);
                        break;
                    }
                }
            	resultMap.put(pair.getTargetField(), result == null ? "" : result);
            }
            return resultMap;
        } catch (Exception e) {
        	log.error(e.getMessage());
        }
        return null;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T mapToBean(Map<String, Object> sourceMap, Class<T> target, String fileName) {
    	try {
            BeanInfo beanInfo = Introspector.getBeanInfo(target);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            Object obj = target.newInstance();
            Assemble assem = AssembleFactory.newInstence().builderAssem(fileName);
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                FieldPairs pair = assem.getFieldPairByTarget(propertyName);
                if (pair != null) {
                    String sourceFiled = pair.getSourceField();
                    Object value = sourceMap.get(sourceFiled);
                    value = getValue(pair, value, sourceMap);
                    Class clz = descriptor.getPropertyType();
                    value = DataTypeConvert.parseData(clz, value);
                    if (value != null) {
                        Object[] args = new Object[1];
                        args[0] = value;
                        descriptor.getWriteMethod().invoke(obj, args);
                    }
                }
            }
            return (T) obj;
        } catch (Exception e) {
        	log.error(e.getMessage());
        }
        return null;
    }
    
	public static Map<String, Object> mapToMap(Map<String, Object> sourceMap, String fileName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<FieldPairs> fieldList = AssembleFactory.newInstence().builderAssem(fileName).getFields();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		for (FieldPairs field : fieldList) {
			String sourceField = field.getSourceField();
			Object value = getValue(field, sourceMap.get(sourceField), sourceMap);
			resultMap.put(field.getTargetField(), value);
		}
		return resultMap;
	}
	
	private static Object getValue(FieldPairs field, Object value, Object sourceObj) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String className = field.getAssemCls();
		String methodName = field.getMethod();
		if(className == null || "".equals(className)) {
			return value;
		}
		Object clzObj = Class.forName(className).newInstance();
		try {
			return clzObj.getClass().getDeclaredMethod(methodName, new Class[]{Object.class}).invoke(clzObj, new Object[]{sourceObj});
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage());
			
		} catch (InvocationTargetException e) {
			log.error(e.getMessage());
		} catch (NoSuchMethodException e) {
			log.error(e.getMessage());
		} catch (SecurityException e) {
			log.error(e.getMessage());
		}
		return value;
	}
	
	 /** 
	 * @Title: getFileValeAssem 
	 * @Description: 拼接指定对象的指定属性 
	 * @param args 拼接的属性字符串数组
	 * @param obj 拼接的实体对象
	 * @return    
	 * @retrun String
	 */
	public static String getFileValeAssem(String[] args,Object obj){
		try{
			StringBuffer strValueBuf = new StringBuffer();
			for(int i = 0;i < args.length;i++){
				String propertyName = args[i];
				String getMethodName = "get"+ propertyName.substring(0, 1).toUpperCase()+ propertyName.substring(1);
				
				Object objValue = obj.getClass().getMethod(getMethodName).invoke(obj);
				if(objValue instanceof String && !"".equals(objValue)){
					strValueBuf.append(objValue.toString());
					strValueBuf.append("@#");
				}
			}
			String str = strValueBuf.toString();
			if(str.endsWith("@#")){
				str = str.substring(0, (str.length()-2));
			}
			return str;
		}catch(Exception e){
			log.error("拼接对象指定的属性异常。",e);
			return null;
		}
	}
	
	
}
