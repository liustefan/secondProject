/**
 * @PackageName:      com.bithealth.excel
 * @FileName:     ExcelUtil.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月30日 下午2:25:26  
 * 
 */
package com.bithealth.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 类名称: ExcelUtil  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月30日 下午2:25:26 
 * 
 * @author liuhm
 * @version  
 */
public final class ExcelUtil {
	
	private ExcelUtil() {
		
	}
	
	private static Workbook openWorkbook(File file) throws Exception {
		FileInputStream ins = new FileInputStream(file);
		try {
			return WorkbookFactory.create(ins);
		} catch (EncryptedDocumentException | InvalidFormatException e) {
			throw new Exception("文件格式不支持");
		} finally {
			if(ins != null) {
				ins.close();
			}
		}
	}
	
	private static Workbook openWorkbook(boolean isXlsx) {
		Workbook workbook = null;
		if(isXlsx) {
			workbook = new XSSFWorkbook();
		} else {
			workbook = new HSSFWorkbook();
		}
		return workbook;
	}
	
	private static void closeWorkbook(Workbook workbook) {
		if(workbook != null) {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * read excel data
	 * @param excel
	 * @return
	 * @throws Exception
	 */
	public static List<LinkedHashMap<String, String>> readExcel(File excel) throws Exception {
		if(excel == null || !excel.exists() || !excel.isFile()) {
			return null;
		}
		Workbook workbook = openWorkbook(excel);
		if(workbook == null) {
			return null;
		}
		Sheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		Row title = sheet.getRow(0);
		String[] header = getHeader(title);
		List<LinkedHashMap<String, String>> dataList = new ArrayList<LinkedHashMap<String, String>>();
		for(int i = 1; i <= rows; i++) {
			title = sheet.getRow(i);
			if(title == null || "".equals(title)) {
				continue;
			}
			LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
			boolean isBlanRow = true;  //是否存在空行
			for(int clm = 0; clm < header.length; clm++) {
				Cell cell = title.getCell(clm);
				String value = getValue(cell);
				if(value != null  && !"".equals(value.trim())) {
					isBlanRow = false;
				}
				data.put(header[clm], value);
			}
			if(!isBlanRow) {
				dataList.add(data);
			}
		}
		closeWorkbook(workbook);
		return dataList;
	}
	
	public static void writeExcel(File file, LinkedHashMap<String, Object[][]> data, boolean isxlsx) throws Exception {
		writeData(file, data, isxlsx);
	}
	
	public static void writeExcel(File file, LinkedHashMap<String, Object[][]> data) throws Exception {
		writeData(file, data, false);
	}
	
	private static void writeData(File file, LinkedHashMap<String, Object[][]> data, boolean isxlsx) throws Exception {
		if(data == null || data.isEmpty()) return;
		Workbook workbook = null;
		OutputStream outputStream = null;
		try{
			workbook = openWorkbook(isxlsx);
			if(workbook == null) return;
			for(String sheetName : data.keySet()) {
				Object[][] dataList = data.get(sheetName);
				if(dataList.length == 0) {
					continue;
				}
				Sheet sheet = workbook.createSheet(sheetName);
				Row row = null;
				for(int i = 0; i < dataList.length; i++) {
					if(dataList[i] == null) {
						break;
					}
					row = sheet.createRow(i);
					for(int j = 0; j < dataList[i].length; j++) {
						Cell cell = row.createCell(j);
						cell.setCellValue(dataList[i][j].toString());
					}
				}
			}
			outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			outputStream.flush();
		} finally {
			if(outputStream != null) {
				outputStream.close();	
			}
			if(workbook != null) {
				workbook.close();
			}
		}
	}
	
	private static String[] getHeader(Row title) {
		int columns = title.getLastCellNum();
		String[] header = new String[columns];
		for(int i = 0; i < columns; i++) {
			header[i] = title.getCell(i).getStringCellValue();
		}
		return header;
	}
	
	private static String getValue(Cell cell) {
		if(cell == null || "".equals(cell)) {
			return "";
		}
		int type = cell.getCellType();
		switch(type) {
		case Cell.CELL_TYPE_NUMERIC :
			if(DateUtil.isCellDateFormatted(cell)) {
				Date d = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
		  	   return new SimpleDateFormat("yyyy-MM-dd").format(d);
			}
			return new BigDecimal(cell.getNumericCellValue()).toPlainString();
			
		case Cell.CELL_TYPE_FORMULA :
			return String.valueOf(cell.getCellFormula());
			
		case Cell.CELL_TYPE_STRING :
			return cell.getStringCellValue();
			
		case Cell.CELL_TYPE_ERROR :
			return String.valueOf(cell.getErrorCellValue());
			
		case Cell.CELL_TYPE_BOOLEAN :
			return String.valueOf(cell.getBooleanCellValue());
			
		case Cell.CELL_TYPE_BLANK :
			return "";
			
		default :
			return cell.getStringCellValue();
		}
	}
	}