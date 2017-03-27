/**
 * @PackageName:      test
 * @FileName:     MyTestUtil.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      柴仕富
 * @version      V1.0  
 * @Createdate:  2016年6月17日 上午10:24:26  
 * 
 */

package care;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import com.alibaba.fastjson.JSONObject;

public class CenterServerTest {

    public static void main(String[] args) throws Exception{

    	//CenterServerTest.smsTest();
    	CenterServerTest.careTest();
/*    	String className = "care.TestReflect";
    	String methodName = "sayHello";
    	Class clazz = Class.forName(className);
    	Object obj = clazz.newInstance();
    	Method method = obj.getClass().getDeclaredMethod(methodName, String.class);
    	method.invoke(obj, "bbbbb");*/
		
    }

    
    
    public static void careTest(){
        try {

        	//String url = "http://localhost:8080/centerServer/care/getMyCareList?";
        	String url = "http://localhost:8080/centerServer/care/getCareMeList?a=1";
        	//String url = "http://localhost:8080/centerServer/care/getMember?";
        	//String url = "http://localhost:8080/centerServer/care/getMyKindlyReminder?";
        	//String url = "http://192.168.10.27:8888/centerServer/care/getMember?";
        	//String url = "http://localhost:8080/centerServer/care/getMyKindlyReminder?";


	        PostMethod postMethod = new PostMethod(url);
	        RequetParam requetParam = new RequetParam();
	        
	        RequestHead head = new RequestHead();
	        head.setDeviceType("IOS");
	        head.setLogTime("2016-08-30 15:32:30");
	        head.setSession("e31c2643-3c85-4fe1-89e0-e712ec07fa2f");
	        head.setUserId(26013);
	        head.setUserType(1);
	        head.setVersion("v3.0");
	        requetParam.setHead(head);
	        
	        
	        //getMyCareList接口
	        JSONObject obj = new JSONObject();
	        obj.put("pageNow", "1");
	        obj.put("memberGUID", "3f9d5950-645a-11e6-bbea-f96200d73995");
	        obj.put("isGetNews", "0");
	        obj.put("pageSize", "3");
	        requetParam.setContent(obj);
	        
	        //getMember 接口
	        JSONObject obj2 = new JSONObject();
	        obj2.put("searchParam", "15554554443");
	        obj2.put("memberGUID", "3f9d3ace-645a-11e6-bbea-f96200d73995");
	        //requetParam.setContent(obj2);
	        
	        //getMyKindlyReminder接口
	        JSONObject obj3 = new JSONObject();
	        obj3.put("memberGUID", "544bfa3d-39e9-4261-a1dc-54b46f69203e");
	        //requetParam.setContent(obj3);        
	
	        String str = JSONObject.toJSONString(requetParam);
	        postMethod.setRequestBody(str);
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
        
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    
    
    public static void smsTest(){
        try {

        	//String url = "http://localhost:8080/centerServer/sms/saveSmsConfig";
        	String url = "http://hq.hk-bithealth.com:8086/centerServer/sms/smsSend";
        	//String url = "http://localhost:8080/centerServer/sms/getSmsList";
        	//String url = "http://localhost:8080/centerServer/sms/getSmsStatistic";

	        PostMethod postMethod = new PostMethod(url);

	        //保存短信配置接口 saveSmsConfig
/*	        postMethod.addParameter("serverID", "18");
	        postMethod.addParameter("orgID", "0");
	        postMethod.addParameter("account", "23553660");
	        postMethod.addParameter("passwd", "c7e83141db483625c09c8aec9d0a4f2e");
	        postMethod.addParameter("sendStartTime","2016-11-30 08:30:00");
	        postMethod.addParameter("sendEndTime","2016-11-30 18:00:00");
	        postMethod.addParameter("totalSendLimit", "30");
	        postMethod.addParameter("dailyMaxSend", "10");
	        postMethod.addParameter("memberDailyMaxRecv", "5");
	        postMethod.addParameter("memberDailyMaxRepl", "2");
	        postMethod.addParameter("createID", "0");
	        postMethod.addParameter("createTime", "2016-12-02 16:45:10");*/
	        
	        
	       //发送短信接口
	        postMethod.addParameter("serverID", "18");
	        postMethod.addParameter("smsType", "5");
	        postMethod.addParameter("priority", "1");
	        postMethod.addParameter("recvNumbers", "18684021263,13699827050");
	        postMethod.addParameter("content","{\"product\":\"中科汇康\"}");
	        postMethod.addParameter("contentType","1");
	        postMethod.addParameter("orgPath", ",0,94,342,347,567,");

	       //获取短信记录接口
/*	        postMethod.addParameter("serverID", "21");
	        postMethod.addParameter("orgIDs","93");
	        postMethod.addParameter("startTime","2016-11-30 09:58:10");
	        postMethod.addParameter("endTime","2016-11-30 15:58:10");
	        postMethod.addParameter("smsType", "1");
	        postMethod.addParameter("recvNumber", "1");
	        postMethod.addParameter("sendStatus", "1");
	        postMethod.addParameter("pageSize", "10");
	        postMethod.addParameter("pageNo", "1");*/
	        
	        //获取短信发送统计数据
	        
/*	        postMethod.addParameter("serverID","18");
	        postMethod.addParameter("orgIDs","0");
	        postMethod.addParameter("startTime","");
	        postMethod.addParameter("smsType","0");
	        postMethod.addParameter("recvNumber","");
	        postMethod.addParameter("sendStatus","");*/
	        
	        

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
        
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
 
 
    
    
}

