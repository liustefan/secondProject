package com.bithealth.dataConversionServer.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataTypeConvert {
	
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	@SuppressWarnings("rawtypes")
	public static Object parseData(Class targType, Object value) {
		if(value == null || "".equals(value) || value.getClass().equals(targType)) {
			return value;
		}
		Class sourceType = value.getClass();
		if(java.lang.String.class.equals(sourceType)) {
			try {
				return strToObj(targType, String.valueOf(value));
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
        if(java.math.BigDecimal.class.equals(sourceType)) {
        	return bigDecimalToObj(targType, (BigDecimal)value);
		}
        if(java.lang.Short.class.equals(sourceType)) {
        	if(java.lang.Byte.class.equals(targType)) {
        		return Byte.valueOf(value.toString());
        	}
        }
		return value;
	}
	
	@SuppressWarnings("rawtypes")
	public static String objToStr( Object value) {
		Class source = value.getClass();
		if(source.equals(java.util.Date.class)) {
			return format.format(value);
		}
		if(source.equals(java.sql.Date.class)) {
			return String.valueOf(value);
		}
		return value.toString();
	}
	
	@SuppressWarnings("rawtypes")
	private static Object bigDecimalToObj(Class targType, BigDecimal value) {
		if(targType.equals(java.lang.Integer.class)) {
			return value.intValue();
		}
		if(targType.equals(java.lang.Byte.class)) {
			return value.byteValue();
		}
		if(targType.equals(java.lang.Double.class)) {
			return value.doubleValue();
		}
		if(targType.equals(java.lang.Float.class)) {
			return value.floatValue();
		}
		if(targType.equals(java.lang.Long.class)) {
			return value.longValue();
		}
		if(targType.equals(java.lang.Short.class)) {
			return value.shortValue();
		}
		if(targType.equals(java.lang.String.class)) {
			return value.toPlainString();
		}
		return value;
	}
	
	
	@SuppressWarnings("rawtypes")
	private static Object strToObj(Class targType, String value) throws ParseException {
		if(targType.equals(java.util.Date.class)) {
			return format.parse(value);
		}
		if(targType.equals(java.sql.Date.class)) {
			return java.sql.Date.valueOf(value);
		}
		if(targType.equals(java.lang.Integer.class)) {
			return Integer.parseInt(value);
		}
		if(targType.equals(java.lang.Byte.class)) {
			return Byte.parseByte(value);
		}
		if(targType.equals(java.math.BigDecimal.class)) {
			return new BigDecimal(value);
		}
		if(targType.equals(java.lang.Double.class)) {
			return Double.parseDouble(value);
		}
		if(targType.equals(java.lang.Float.class)) {
			return Float.parseFloat(value);
		}
		if(targType.equals(java.lang.Long.class)) {
			return Long.parseLong(value);
		}
		if(targType.equals(java.lang.Short.class)) {
			return Short.parseShort(value);
		}
		if(targType.equals(java.lang.Boolean.class)){
			return Boolean.parseBoolean(value);
		}
		return value;
	}
public static void main(String[] args) {
	System.out.println(parseData(java.lang.String.class, new BigDecimal("25.331")));
}
}
