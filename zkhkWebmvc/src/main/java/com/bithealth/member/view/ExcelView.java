/**
 * @PackageName:      com.bithealth.member.view
 * @FileName:     ExcelView.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月7日 下午4:40:32  
 * 
 */
package com.bithealth.member.view;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.bithealth.Constrants;
import com.bithealth.memberCore.member.model.DiseasesHistory;
import com.bithealth.memberCore.member.model.MemImportLog;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.vo.MemberImportBean;

/**
 * 类名称: ExcelView  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月7日 下午4:40:32 
 * 
 * @author liuhm
 * @version  
 */
public class ExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] fields = Constrants.FIELDS;
		String[] headers = Constrants.HEADER;
	    int fieldLen = fields.length;
	    String excelName = "用户信息.xls";  
        // 设置response方式,使执行此controller时候自动出现下载页面,而非直接使用excel打开  
        response.setContentType("APPLICATION/OCTET-STREAM");  
        response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(excelName, "UTF-8")); 
        HSSFSheet sheet = workbook.createSheet();  
        HSSFRow header = sheet.createRow(0); // 第0行  
        for(int i = 0; i < headers.length; i++) {
        	header.createCell(i).setCellValue(headers[i]);
        }
        header.createCell(headers.length).setCellValue("原因");
        List<MemberExt> list = (List<MemberExt>)model.get("list");
        if(list == null || list.size() == 0) {
        	return;
        }
        int rowNum = 1;
        for(MemberExt member : list) {
        	 HSSFRow row = sheet.createRow(rowNum++);  
        	MemberImportBean bean = new MemberImportBean(member, null);
        	for(int i = 0; i < fieldLen; i++) {
        		String value = BeanUtils.getProperty(bean, fields[i]);
        		row.createCell(i).setCellValue(value == null ? "" : value);
        	}
        	List<DiseasesHistory> diseasesList = member.getDiseasesHistoryList();
        	for(int i = fieldLen; i < headers.length; i++) {
        		Cell cell = row.createCell(i);
        		if(diseasesList != null && diseasesList.size() > 0) {
        			boolean hasDisease = false;
        			for(DiseasesHistory disease : diseasesList) {
        				if(headers[i].equals(disease.getDiseasename())) {
        					hasDisease = true;
        				}
        			}
        			if(hasDisease) {
        				cell.setCellValue("有");
        			} else {
        				cell.setCellValue("");
        			}
        		} else {
        			cell.setCellValue("");
        		}
        	}
        	MemImportLog importLog = member.getImportLog();
        	String desc = "";
        	if(importLog != null) {
        		desc = importLog.getReason();
        	}
        	row.createCell(headers.length).setCellValue(desc);
        }
	}

}
