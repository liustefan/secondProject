package com.bithealth.centCore.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName:     DataSources.java 
 * @Description:   数据源类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月23日 下午8:24:23
*****/
public class DataSources extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceSwitch.getDataSourceType();
	}

}
