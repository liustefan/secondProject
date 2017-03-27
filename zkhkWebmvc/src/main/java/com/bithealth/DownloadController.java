/**
 * @PackageName:      com.bithealth
 * @FileName:     DownloadController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月11日 下午12:18:30  
 * 
 */
package com.bithealth;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.sdk.web.controller.BaseSpringController;

/**
 * 类名称: DownloadController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月11日 下午12:18:30 
 * 
 * @author liuhm
 * @version  
 */
@Controller
@RequestMapping("/download")
public class DownloadController extends BaseSpringController {
	
	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;
	
	@RequestMapping(method=RequestMethod.GET, value="/downloadXls")
	public void downloadXls(HttpServletResponse response, String objectId) throws IOException {
		response.setContentType("text/html;charset=UTF-8");   
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName =  fmt.format(new java.util.Date()) + ".xls";
        FileConfigModel model = new FileConfigModel();
 		model.setUniqueId(objectId);
 		model.setTypeEnum(FileTypeEnum.CUSTOM_FILE);
 		ServletOutputStream outputStream = null;
        try {  
            response.setContentType("application/x-excel");  
            response.setCharacterEncoding("UTF-8");  
            response.setHeader("Content-Disposition", "attachment; filename="+fileName);  
//            response.setHeader("Content-Length",String.valueOf(f.length())); 
            outputStream = response.getOutputStream();
            byte[] byteArray = fileManagerServiceFacade.downloadFile(model);
 			outputStream.write(byteArray);
 			outputStream.flush();
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
        	if(outputStream != null) {
        		outputStream.close();
        	}
        }  
	}

}
