/**
 * @PackageName:      com.bithealth.fileCore.util
 * @FileName:     FtpUtils.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 下午5:37:11  
 * 
 */
package com.bithealth.fileCore.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import com.bithealth.fileCore.constant.Constants;


/**
 * 类名称: FtpUtils  
 * 功能描述: TODO ftp工具类  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月29日 上午11:01:53 
 * 
 * @author 胡翔
 * @version  
 */
public class FtpUtils {
	private static Logger logger = Logger.getLogger(FtpUtils.class);
	
	/**
	 * 初始化ftp链接配置
	 */
	private static String hostname = SystemUtils.getValue(Constants.FTP_HOSTNAME);
	private static int port = Integer.parseInt(SystemUtils.getValue(Constants.FTP_PORT)); 
	private static String username = SystemUtils.getValue(Constants.FTP_USERNAME);
	private static String password = SystemUtils.getValue(Constants.FTP_PASSWORD);
	/**
	 * 初始文件夹地址
	 */
	private static String initPath = SystemUtils.getValue(Constants.FTP_INIT_PATH);
	private static String encoding = "UTF-8";
	/**
	 * @Title:getFtpClient 
	 * @Description:TODO(链接ftp服务器，并返回ftp客户端连接).  
	 * @author 胡翔
	 * @return FTPClient ftp链接
	 */
	private static FTPClient getFtpClient() {
		FTPClient ftpClient = new FTPClient();
		ftpClient.setControlEncoding(encoding);
		try {
			// 链接ftp服务器
			ftpClient.connect(hostname, port);
			// 登录ftp
			ftpClient.login(username, password);
			int reply = ftpClient.getReplyCode();
			// 如果reply返回230就算成功了，如果返回530密码用户名错误或当前用户无权限下面有详细的解释。
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				logger.info("链接文件服务器失败~!");
				return null;
			}
			logger.info("文件服务器链接成功！！");
		} catch (IOException e) {
			logger.info("链接文件服务器异常!",e);
			return null;
		}
		return ftpClient;
	}
	/**
	 * 
	 * @Title:uploadFile 
	 * @Description:TODO(上传文件至文件服务器).  
	 * @author 胡翔
	 * @param path 文件保存路径
	 * @param fileName 文件名称
	 * @param in 输入流对象
	 * @return boolean 上传结果
	 */
	public static boolean uploadFile(String path, String fileName,
			InputStream in) {
		FTPClient ftpClient = getFtpClient();
		if (ftpClient == null) {
			return false;
		}
		try {
			//更换工作目录
			if(!ftpClient.changeWorkingDirectory(initPath+Constants.DIRECTORY_SEPARATOR+path)){
				ftpClient.changeWorkingDirectory(initPath);
				//在initpath目录下创建文件夹
				ftpClient.makeDirectory(path); 
				ftpClient.changeWorkingDirectory(initPath+Constants.DIRECTORY_SEPARATOR+path);
			}
			//上传文件
			return ftpClient.storeFile(fileName, in);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally{
			disFtpConnection(ftpClient);
		}
	}
	/**
	 * 
	 * @Title:downloadFile 
	 * @Description:TODO(从ftp服务器上下载文件).  
	 * @author 胡翔
	 * @param path 文件保存路径
	 * @param fileName 文件名称
	 * @return
	 */
	public static byte[] downloadFile(String path,String fileName){
		String ftpPath = initPath+Constants.DIRECTORY_SEPARATOR+path;
		FTPClient ftpClient = getFtpClient();
		if(ftpClient == null){
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try{
 			// 设置以二进制流的方式传输
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);  
            // 设置PassiveMode传输
         	ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);  
            InputStream in = ftpClient.retrieveFileStream(fileName); 
            if (in == null) {
            	logger.error("in为空，文件读取失败，请联系管理员.");  
            	return null;
            }
            int i = 0;  
            byte[] b = new byte[4096];
            while ((i = in.read(b)) != -1) {  
                out.write(b,0,i);  
            }  
            in.close();
            out.flush();
            return out.toByteArray();
		} catch (FileNotFoundException e) {  
            logger.error("没有找到" + ftpPath + "文件",e);  
        } catch (SocketException e) {  
            logger.error("连接FTP失败.",e);
        } catch (IOException e) {  
            logger.error("文件读取错误。",e);  
        } finally {
        	try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	disFtpConnection(ftpClient);
        }
		return null;
	}
	/**
	 * @Title:disFtpConnection 
	 * @Description:TODO(关闭ftp链接).  
	 * @author 胡翔
	 * @param ftpClient ftp客户端链接
	 */
	private static void disFtpConnection(FTPClient ftpClient){
		if( ftpClient != null && ftpClient.isConnected()){
			try {
				ftpClient.logout();
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
