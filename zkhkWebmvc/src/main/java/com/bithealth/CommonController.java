package com.bithealth;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.constant.MimeTypeEnmu;
import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.common.utils.StringUtil; 
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
    /**
     * 首页
     * 
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        return "/public/index";
    }


    /**
     * 登录页tologin
     */
    @RequestMapping("tologin")
    public String tologin() {
        return "tologin";
    }
    
    
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
		 
    	 
//     	response.setCharacterEncoding("UTF-8");
		OutputStream output = null; 
		String contentType = "";
//		try{
			
			
	    	String fileName = request.getParameter("fileName");
			String fileType = StringUtils.getFilenameExtension(fileName);
//			String fileId = StringUtils.stripFilenameExtension(fileName);
			String alias = request.getParameter("alias");
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
			}else{
				response.setContentType(this.getContentType(fileName));
//				response.setContentType("application/msword"); 
				if(org.apache.commons.lang.StringUtils.isEmpty(alias))
					response.setHeader("content-disposition", "inline;filename=" + fileName.substring(fileName.lastIndexOf("/")+1));
				else
				
//			     response.setHeader("content-disposition", "inline;filename=" + new String(alias.getBytes(), "ISO-8859-1"));//URLEncoder.encode(alias, "utf-8"));
				response.setHeader("content-disposition", "inline;filename=" +toUtf8String(alias)); //URLEncoder.encode(alias, "utf-8"));
				
				
			}
			
			
			 
//			response.setContentType(contentType);
		    attpath +="/"+ fileName;
			 
		    BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			OutputStream fos = null;
			InputStream fis = null;
			
			 
			try {
//				response.setContentType(this.getContentType(fileName));
//				response.setHeader("Content-disposition", "attachment;filename=" + fileName);
				fis = new FileInputStream(attpath);
				bis = new BufferedInputStream(fis);
				fos = response.getOutputStream();
				bos = new BufferedOutputStream(fos);

				int bytesRead = 0;
				byte[] buffer = new byte[5 * 1024];
				while ((bytesRead = bis.read(buffer)) != -1) {
					bos.write(buffer, 0, bytesRead);// 将文件发送到客户端
				}
				bos.flush();
				bos.close();
				bis.close();
				fos.close();
				fis.close();

			} catch (IOException e) {
				response.reset();
				e.printStackTrace();
			} finally {
				try {
					if (fos != null) {
						fos.close();
					}
					if (bos != null) {
						bos.close();
					}
					if (fis != null) {
						fis.close();
					}
					if (bis != null) {
						bis.close();
					}
				} catch (IOException e) {

					System.err.print(e);
				}
			}
 
    }
    
    
    public static String toUtf8String(String s) { 
	     
        StringBuffer sb = new StringBuffer(); 
        for (int i = 0; i < s.length(); i++) { 
            char c = s.charAt(i); 
            if (c >= 0 && c <= 255) { 
                sb.append(c); 
            } else { 
                byte[] b; 
                try { 
                    b = Character.toString(c).getBytes("utf-8"); 
                } catch (Exception ex) { 
                    //error("将文件名中的汉字转为UTF8编码的串时错误，输入的字符串为：" + s); 
                    b = new byte[0]; 
                } 
                for (int j = 0; j < b.length; j++) { 
                    int k = b[j]; 
                    if (k < 0) 
                        k += 256; 
                    sb.append("%" + Integer.toHexString(k).toUpperCase()); 
                } 
            } 
        } 
        return sb.toString(); 
    } 
 
    /** 
     * 根据不同浏览器将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名. 
     *  
     * @param s 
     *            原文件名 
     * @return 重新编码后的文件名 
     */ 
    public static String toUtf8String(HttpServletRequest request, String s) { 
        String agent = request.getHeader("User-Agent"); 
        try { 
            boolean isFireFox = (agent != null && agent.toLowerCase().indexOf("firefox") != -1); 
            if (isFireFox) { 
                s = new String(s.getBytes("UTF-8"), "ISO8859-1"); 
            } else { 
                s =  toUtf8String(s); 
                if ((agent != null && agent.indexOf("MSIE") != -1)) { 
                    // see http://support.microsoft.com/default.aspx?kbid=816868 
                    if (s.length() > 150) { 
                        // 根据request的locale 得出可能的编码 
                        s = new String(s.getBytes("UTF-8"), "ISO8859-1"); 
                    } 
                } 
            } 
        } catch (UnsupportedEncodingException e) { 
            e.printStackTrace(); 
        } 
        return s; 
    }
    
    /*
	 * 
	 * 设置文件类型
	 */

	private String getContentType(String fileName) {
		String fileNameTmp = fileName.toLowerCase();
		String ret = "";
		 
		if (fileNameTmp.indexOf(".")>0)
		   fileNameTmp  =fileNameTmp.substring(fileNameTmp.lastIndexOf(".")+1);
		ret = MimeTypeEnmu.getMimeTypeEnmu(fileNameTmp);
		if(ret == null){ //校验是否为可上传的文件类型
			logger.info("文件类型不匹配！");
			return null;
		}  
		return ret;
	}

    
}