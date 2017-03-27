/**
 * @PackageName:      com.bithealth.fileCore
 * @FileName:     FileManagerTest.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  
 * @version      V1.0  
 * @Createdate:  2016年6月20日 上午9:44:19  
 * 
 */
package com.bithealth.fileCore;

import static org.junit.Assert.assertTrue;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;

/**
 * 类名称: FileManagerTest  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月20日 上午9:44:19 
 * 
 * @author 胡翔
 * @version  
 */

public class FileCoreTest extends BaseTest{
	static String uniqueId = "57be664cbc18f69a1a4fb2fb";//"57bc0a193a14a6d1812f6a9f";
	static String pathname = "test";
	@Autowired
	FileManagerServiceFacade facde;
	
	static FileConfigModel model = new FileConfigModel();
	static{
		model.setTypeEnum(FileTypeEnum.JPG);
	}
	/**
	 * @Title:testUpload 
	 * @Description:TODO(测试文件上传方法).  
	 * @author 胡翔 
	 */ 
	@Test
	public void testUpload(){
		try {
			FileInputStream in = new FileInputStream("E://File.jpg"); //folder.files
			System.out.println("====input:"+in.available());
			uniqueId = facde.uploadFile(in, model);
			System.out.println("上传后的id为："+uniqueId);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		testGetFile();
	}
	@Test
	public void testGetFile(){
		model.setUniqueId(uniqueId);
		try {
			byte[] b=facde.downloadFile(model);
			System.out.println("源文件："+b);
			getFile(b,uniqueId);
			//byte[] bt=facde.downloadThumbnailImage(model);
			//System.out.println("压缩文件："+bt);
			//getFile(bt,uniqueId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//@Test
	public void testDelete(){
		System.out.println("================uniqueId delete:"+uniqueId);
		model.setUniqueId(uniqueId);
		try {
			assertTrue(facde.deleteFile(model));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getFile(byte[] bfile,String uniqueId){
		
		System.out.println("================uniqueId:"+uniqueId);
		String filePath="G://";
		BufferedOutputStream bos = null;  
        FileOutputStream fos = null;  
        File file = null;  
        try {  
            File dir = new File(filePath);  
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在  
                dir.mkdirs();  
            }  
            file = new File(filePath+"\\"+"File.jpg");  
            fos = new FileOutputStream(file);  
            bos = new BufferedOutputStream(fos);  
            bos.write(bfile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (bos != null) {  
                try {  
                    bos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
            if (fos != null) {  
                try {  
                    fos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
        } /* */
		
		
		
	}
}
