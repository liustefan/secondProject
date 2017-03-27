package com.bithealth.deviceCore;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import com.bithealth.deviceCore.utils.BthCmdPackage;
import com.bithealth.deviceCore.utils.TimeUtil;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class DeviceCodeTest  extends TestCase{
	
	public static void main(String args[]) throws Exception{
/*		String data = "5A241210601A00027815132092078141012121807D4_460027966329481_114.297790,22.690753FFFFF".substring(0, 39);
		Integer sumDex = BthCmdPackage.convertStringToDexAndGetSum(data);
		String ascCode1 = BthCmdPackage.IntToHex(sumDex);
		byte crc8 = BthCmdPackage.calcCrc8(data.getBytes(),data.getBytes().length);
		System.out.print(crc8);*/
		
/*		String data = "5A241210601A00027815132092078141012121807D4_460027966329481_114.297790,22.690753FFFFF";
		System.out.print(data.substring(11, 20));*/
		httpPost();    
		
// +IP2A79EC874E1F690E07080A272COK
// +IPC0A80A361F90DB110112102331OK		
		
	}
	
	public static void httpPost(){
		try{
			//String data = "5A241210601A00027815132092078141012121807D4_460027966329481_114.297790,22.690753FFFFF";
			String data = "5A241210602A00027815132092078141012121807D5_460027966329481_114.297790,22.690753FFFFF";
			//String url="http://hq.hk-bithealth.com:8086/deviceServer/upload";
			String url="http://cc.hk-bithealth.com:8086/deviceServer/upload";
			//String url="http://192.168.10.62:8080/deviceServer/device/measureDataUpload";
			PostMethod postMethod = new PostMethod(url);
	        postMethod.addParameter("data",data);
	        postMethod.addParameter("productId", "01");
	        postMethod.getParams().setContentCharset("utf-8");	        
		     
	        HttpClient client = new HttpClient();
	        int statusCode = client.executeMethod(postMethod); 
	        if (statusCode == HttpStatus.SC_OK) { 
	    	    InputStream stream = postMethod.getResponseBodyAsStream();  
				BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));  
				StringBuffer buf = new StringBuffer();  
				String line;  
				while (null != (line = br.readLine())) {  
				    buf.append(line).append("\n");  
				}  
				System.out.println(buf.toString());
	        }else{
	        	System.out.println(statusCode);
	        }
	          //释放连接  
	        postMethod.releaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title:xor 
	 * @Description:两个十六进制的异或运算
	 * @author 谢美团
	 * @param strHex_X
	 * @param strHex_Y
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	private static String xor(String strHex_X,String strHex_Y){ 
		//将x、y转成二进制形式 
		String anotherBinary=Integer.toBinaryString(Integer.valueOf(strHex_X,16)); 
		String thisBinary=Integer.toBinaryString(Integer.valueOf(strHex_Y,16)); 
		String result = ""; 
		//判断是否为8位二进制，否则左补零 
		if(anotherBinary.length() != 8){ 
		for (int i = anotherBinary.length(); i <8; i++) { 
				anotherBinary = "0"+anotherBinary; 
			} 
		} 
		if(thisBinary.length() != 8){ 
		for (int i = thisBinary.length(); i <8; i++) { 
				thisBinary = "0"+thisBinary; 
			} 
		} 
		//异或运算 
		for(int i=0;i<anotherBinary.length();i++){ 
		//如果相同位置数相同，则补0，否则补1 
			if(thisBinary.charAt(i)==anotherBinary.charAt(i)) 
				result+="0"; 
			else{ 
				result+="1"; 
			} 
			}
		return Integer.toHexString(Integer.parseInt(result, 2)); 
	}
	
}
