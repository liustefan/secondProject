package com.bithealth.controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.config.KDConfig;
import com.bithealth.sdk.web.controller.BaseSpringController;
/**
 * 公共视图控制器
 * 
 * @author Jason Chai
 * @since 2014年4月15日 下午4:16:34
 **/
@Controller
public class CommonController   extends BaseSpringController{
    
    
    @RequestMapping("attachedpath")
    @ResponseBody  
    public String attachedpath(HttpServletRequest request) {
    	String attpath = "";
    	KDConfig kdConfig = Env.getBean("rdConfig"); 
    	attpath =kdConfig.getProperty("www.attached.root") ; 
		 
        return attpath;
    }
    
    
    @RequestMapping(value = "/attachedurl", method = RequestMethod.GET) 
    public void attachedURL(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	String attpath = "";
    	KDConfig kdConfig = Env.getBean("rdConfig"); 
    	attpath =kdConfig.getProperty("www.attached.root") ;  
    	
    	response.setCharacterEncoding("UTF-8");
		OutputStream output = null; 
		String contentType = "";
		try{ 
	    	String fileName = request.getParameter("fileName");
			String fileType = StringUtils.getFilenameExtension(fileName); 
			 
			if(StringUtils.isEmpty(fileType)){
				fileType = "png";
			}
			if(fileType.equals("jpg") || fileType.equals("jpeg")|| fileType.equals("png")|| fileType.equals("gif") || fileType.equals("bmp")){
				contentType = "image/" + fileType;
			}else if(fileType.equals("amr")){
				contentType = "audio/" + fileType;
			}else if(fileType.equals("mp4") || fileType.equals("avi")){
				contentType = "video/" + fileType;
			}else if(fileType.equals("custom")){
				contentType = "custom/" + fileType;
			}
			 
			response.setContentType(contentType);
		    attpath +="/"+ fileName;
			 
			 FileInputStream inputStream = new FileInputStream(attpath);
		        int length = inputStream.available();
		        byte data[] = new byte[length];
		        
		        response.setContentLength(length);
		        

		        inputStream.read(data);
		        OutputStream toClient = response.getOutputStream();
		        toClient.write(data);
		        toClient.flush();
 
    	}catch(Exception e){
    		 e.printStackTrace(); 
    	}finally{
    		try{  
                if(output !=null){  
                    //关闭流  
                    output.close();  
                }  
            }catch (Exception e) {  
                e.printStackTrace();  
            }    
    	}
	  
    }
    
}