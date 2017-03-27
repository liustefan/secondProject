package com.bithealth.dataConversionServer.dataSource;

/**
 * @ClassName:     DataSourceSwitch.java 
 * @Description:   数据源转换类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月23日 下午8:25:04
*****/
public class DataSourceSwitch{
	private static final ThreadLocal<String> contextHolder=new ThreadLocal<String>();
	
	public static void setDataSourceType(String dataSourceType){
		contextHolder.set(dataSourceType);
	}
	
	public static String getDataSourceType(){
		return (String) contextHolder.get();
	}
	
	public static void clearDataSourceType(){
		contextHolder.remove();
	}
}



