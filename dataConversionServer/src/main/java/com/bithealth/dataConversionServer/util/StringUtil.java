package com.bithealth.dataConversionServer.util;

public class StringUtil {
	

	public static boolean isEmpty(String param){
		return param == null || "".equals(param.trim());
	}
	
	
	 /** 
	 * @Title: parseInt 
	 * @Description: 定制化 parseInt，转换int 失败时，不抛出异常，返回 默认值 0
	 * @param str
	 * @return    
	 * @retrun int
	 */
	public static int parseInt(String str){
		try{
			return Integer.parseInt(str);
		}catch(Exception e){
			return 0;
		}
	}
	
	public static boolean isEquals(Object obj1,Object obj2){
		if(obj1 != null && obj1.equals(obj2)){
			return true;
		}else if(obj2 == null) {
			return true;
		}else{
			return false;
		}
		
	}

	

}
