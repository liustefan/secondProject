/**
 * 
 */
package com.bithealth.sdk.common.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.util.HtmlUtils;


public class StringUtil {
	
//	@SuppressWarnings("rawtypes")
//	public static boolean isEmpty(Object str) {
//		if(str instanceof List) {
//			List l = (List)str;
//			return l== null || l.isEmpty();
//		}
//		return str == null || "".equals(str.toString().trim());
//	}
	
 
	/** 
     * 可以用于判断String,Map,Collection,Array是否为空 
     * @param o 
     * @return 
     */  
    public static boolean isEmpty(Object o) throws IllegalArgumentException {  
        if(o == null) return true;  
  
        if(o instanceof String) {  
            if(((String)o).length() == 0){  
                return true;  
            }  
        } else if(o instanceof Collection) {  
            if(((Collection)o).isEmpty()){  
                return true;  
            }  
        } else if(o.getClass().isArray()) {  
            if(Array.getLength(o) == 0){  
                return true;  
            }  
        } else if(o instanceof Map) {  
            if(((Map)o).isEmpty()){  
                return true;  
            }  
        }else {  
            return false;  
//          throw new IllegalArgumentException("Illegal argument type,must be : Map,Collection,Array,String. but was:"+o.getClass());  
        }  
  
        return false;  
    }  
      
    /** 
     * 可以用于判断 Map,Collection,String,Array是否不为空 
     * @param c 
     * @return 
     */   
    public static boolean isNotEmpty(Object o) {  
        return !isEmpty(o);  
    }  
      
    public static boolean isNotBlank(Object o) {  
        return !isBlank(o);  
    }  
    
    public static boolean isNumber(Object o) {  
        if (o instanceof Number) {  
            return true;  
        } else if (o instanceof String) {  
            return NumberUtils.isNumber((String) o);  
        } else {  
            return false;  
        }  
    }  
  
    public static boolean isBlank(Object o) {  
        return StringUtils.isBlank((String) o);  
    }  
  
  
  
    public static boolean isBlank(String str) {  
        return StringUtils.isBlank(str);  
    }  
    
	public static String UUID() {
		return UUID.randomUUID().toString();
	}
	
	public static List<String> getList(String str, String seperator) {
		if(isNotEmpty(str)) {
			String[] arr = str.split(seperator);
			List<String> list = new ArrayList<String>();
			for(String s : arr) {
				list.add(s);
			}
			return list;
		}
		return null;
	}
	
	/**
	 * 特殊字符转义
	 * @param parseStr
	 * @return
	 */
	public static String escape(String parseStr){
		if(isEmpty(parseStr)){
			return "";
		}
		parseStr = HtmlUtils.htmlEscape((String)parseStr);
		return parseStr.trim();
	}

	public static String[]   propertiestoStringArray(Properties properties ){
	    List<String> list = new ArrayList<String>();  
	    
	    Set  set = properties.keySet();
        Iterator it = set.iterator();
        
        while(it.hasNext()){
        String id = (String)it.next();
        String value = properties.getProperty(id);
       
//            System.out.println(id+":="+value);
            list.add(value);  
        }
//        
//	    list.add("a1");  
//	    list.add("a2");  
	    String[] toBeStored = list.toArray(new String[list.size()]);  
//	    for(String s : toBeStored) {  
//	         System.out.println(s);  
//	    }  
	    
	    return toBeStored;
	    
	}
}
