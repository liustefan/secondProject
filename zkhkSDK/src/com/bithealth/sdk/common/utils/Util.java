package com.bithealth.sdk.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.gridfs.GridFSDBFile;

/**
 * @author
 */

public class Util {
    private static Logger logger = Logger.getLogger(Util.class);

    public static boolean isEmpty(String s) {
        if (null == s || "".equals(s.trim())) {
            return true;
        }
        return false;
    }

    public static String trim(String s) {
        if (null != s) {
            s = s.trim();
        } else {
            s = "";
        }
        return s;
    }

    /**
     * 判断是否为数字
     * 
     * @param id
     * @return
     */
    public static boolean isNumber(String id) {
        try {
            if (!isEmpty(id)) {
                Long.valueOf(id);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static List<String> getSqlTypeNameList(String string) {
        String[] nameRights = string.split("\\@\\[");
        String name = null;
        List<String> sqlTypeNameList = null;
        if (nameRights != null && nameRights.length > 1) {
            sqlTypeNameList = new ArrayList<String>();
            for (int i = 1; i < nameRights.length; i++) {
                String nameRight = nameRights[i];
                name = nameRight.split("\\]")[0];
                if (!sqlTypeNameList.contains(name)) {
                    sqlTypeNameList.add(name);
                }
            }
        }
        return sqlTypeNameList;
    }

    public static List<String> getVariableNameList(String string) {
        String[] nameRights = string.split("\\$\\{");
        String name = null;
        List<String> variableNameList = null;
        if (nameRights != null && nameRights.length > 1) {
            variableNameList = new ArrayList<String>();
            for (int i = 1; i < nameRights.length; i++) {
                String nameRight = nameRights[i];
                name = nameRight.split("\\}")[0];
                if (!variableNameList.contains(name)) {
                    variableNameList.add(name);
                }
            }
        }
        return variableNameList;
    }

    public static List<String> getVariableNameListDulipSame(String string) {
        String[] nameRights = string.split("\\$\\{");
        String name = null;
        List<String> variableNameList = null;
        if (nameRights != null && nameRights.length > 1) {
            variableNameList = new ArrayList<String>();
            for (int i = 1; i < nameRights.length; i++) {
                String nameRight = nameRights[i];
                name = nameRight.split("\\}")[0];
                variableNameList.add(name);
            }
        }
        return variableNameList;
    }

    public static String getRequestScopeVariableName(String string) {
        String tempNames[] = string.split("requestScope.");
        if (tempNames != null && tempNames.length > 1) {
            return tempNames[1];
        }
        return null;
    }

    public static String getSessionScopeVariableName(String string) {
        String tempNames[] = string.split("sessionScope.");
        if (tempNames != null && tempNames.length > 1) {
            return tempNames[1];
        }
        return null;
    }

    /**
     * 把null字符串转换成空
     * 
     * @param tel
     * @return
     */
    public static String nullToEmpty(String s) {
        if (null == s || "null".equals(s.trim())) {
            return "";
        }
        return s;
    }

    /**
     * 通过HttpServletRequest返回IP地址
     * 
     * @param request
     *            HttpServletRequest
     * @return ip String
     * @throws Exception
     */
    public static String getIpAddr(HttpServletRequest request) {

        String ip = null;
        try {
            request.getHeader("x-forwarded-for");
            if ((ip == null) || (ip.length() == 0)
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if ((ip == null) || (ip.length() == 0)
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if ((ip == null) || (ip.length() == 0)
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if ((ip == null) || (ip.length() == 0)
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if ((ip == null) || (ip.length() == 0)
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return ip;
    }

    public static boolean isEmpty(Object s) {
        String h = (String) s;
        if (null == h || "".equals(h.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 读取指定位字节流
     * 
     * @param file
     * @param start
     *            开始读取位
     * @param end
     *            结束读取
     * @return
     * @throws IOException
     */
    public static final byte[] input2byte(GridFSDBFile file, int start, int end)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        InputStream stream;
        // 解压文件
        if ("gzip".equals(file.getContentType())) {
            stream = new GZIPInputStream(file.getInputStream());
        } else {
            stream = file.getInputStream();
        }

        // int length=stream.available();
        // System.out.println(length);
        // 放弃指定在字节数
        stream.skip(start);
        byte[] buff = new byte[2048];
        int rc = 0;
        while ((rc = stream.read(buff)) > 0) {
            // System.out.println(rc+"------------------------");
            swapStream.write(buff, 0, rc);
            if (swapStream.toByteArray().length >= (end - start)) {
                // System.out.println(rc+"==========================");
                return swapStream.toByteArray();
            }
        }
        byte[] in2b = swapStream.toByteArray();
        // FileOutputStream out1 = new
        // FileOutputStream("E://"+TimeUtil.currentDatetime()+"test.txt");
        // FileCopyUtils.copy(new ByteArrayInputStream(in2b) , out1);
        //
        // out1.flush();
        //
        // out1.close();

        return in2b;
    }
    
    
    /**
     * 读取指定位字节流
     * 
     * @param file
     * @param s
     *            开始读取位
     * @param e
     *            结束读取
     * @return
     * @throws IOException
     */
    public static final byte[] input2byte(byte[] file, int s, int e){
        byte[] result = null;
        if(e <= file.length){
        	result = new byte[e-s];
        	int i=0;
        	for(int j=s;j<e;j++){
        		result[i]=file[j];
        		i++;
        	}
        }else{
        	result = new byte[file.length-s];
        	int i=0;
        	for(int j=s;j<file.length;j++){
        		result[i]=file[j];
        		i++;
        	}
        }
        return result;
    }
 
    /**
     * 对异常数据进行处理
     * 
     * @param data
     * @return
     * @throws IOException
     */
    public static byte[] getAbEcg(String data) {
        StringBuffer sb = new StringBuffer("");
        String[] excDatas = data.split(",");
        for (int i = 0; i < excDatas.length; i++) {
            if (i == excDatas.length - 1) {
                sb.append(excDatas[excDatas.length - 1]);
                break;
            }
            sb.append(excDatas[i]).append("\n");
        }
        return sb.toString().getBytes();
    }

    /**
     * 读取字节流
     * 
     * @param inStream
     * 
     * @return
     * @throws IOException
     */
    @SuppressWarnings("null")
    public static final byte[] input3byte(GridFSDBFile file) {

        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();

        // 解压文件
        if (file != null) {
            InputStream stream = null;
            try {
                if ("gzip".equals(file.getContentType())) {
                    stream = new GZIPInputStream(file.getInputStream());
                } else {
                    stream = file.getInputStream();
                }
                byte[] buff = new byte[1014];
                int rc = 0;
                while ((rc = stream.read(buff)) > 0) {
                    swapStream.write(buff, 0, rc);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stream != null)
                        stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        byte[] in2b = swapStream.toByteArray();

        return in2b;
    }

    /**
     * 读取字节流
     * 
     * @param inStream
     * 
     * @return
     * @throws IOException
     */
    public static final int getFileLength(GridFSDBFile file) throws IOException {

        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();

        InputStream stream;
        // 解压文件
        if ("gzip".equals(file.getContentType())) {
            stream = new GZIPInputStream(file.getInputStream());
        } else {
            stream = file.getInputStream();
        }
        byte[] buff = new byte[1014];
        int rc = 0;
        while ((rc = stream.read(buff)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        return swapStream.toByteArray().length;
    }

    public final static int getInt(byte[] buf, boolean asc)

    {

        if (buf == null)

        {

            throw new IllegalArgumentException("byte array is null!");

        }

        if (buf.length > 4)

        {

            throw new IllegalArgumentException("byte array size > 4 !");

        }

        int r = 0;

        if (asc)

            for (int i = buf.length - 1; i >= 0; i--)

            {

                r <<= 8;

                r |= (buf[i] & 0x000000ff);

            }

        else

            for (int i = 0; i < buf.length; i++)

            {

                r <<= 8;

                r |= (buf[i] & 0x000000ff);

            }

        return r;

    }

    public final static short getShort(byte[] buf, boolean asc)

    {

        if (buf == null)

        {

            throw new IllegalArgumentException("byte array is null!");

        }

        if (buf.length > 2)

        {

            throw new IllegalArgumentException("byte array size > 2 !");

        }

        short r = 0;

        if (asc)

            for (int i = buf.length - 1; i >= 0; i--)

            {

                r <<= 8;

                r |= (buf[i] & 0x00ff);

            }

        else

            for (int i = 0; i < buf.length; i++)

            {

                r <<= 8;

                r |= (buf[i] & 0x00ff);

            }

        return r;

    }

    /**
     * 通过byte数组取到short
     * 
     * @param b
     * @param index
     *            第几位开始取
     * @return
     */
    public static short getShort(byte[] b, int index) {
        return (short) (((b[index + 1] << 8) | b[index + 0] & 0xff));
    }

    public static void main(String[] args) {
         
        System.out.println(getBejingWebsiteDatetime());
    }

     
    private static String getBejingWebsiteDatetime(){
        String webUrl = "http://www.beijing-time.org";
        try {
            URL url = new URL(webUrl);// 取得资源对象
            URLConnection uc = url.openConnection();// 生成连接对象
            uc.connect();// 发出连接
            long ld = uc.getDate();// 读取网站日期时间
            Date date = new Date(ld);// 转换为标准时间对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);// 输出北京时间
            return sdf.format(date);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 取北京时间
     * @return
     */
    public static String getBeijingTime(){
        return getFormatedDateString(8);
    }
    
    /**
     * 取班加罗尔时间
     * @return
     */
    public static String getBangaloreTime(){
        return getFormatedDateString(5.5f);
    }
    
    /**
     * 取纽约时间
     * @return
     */
    public static String getNewyorkTime(){
        return getFormatedDateString(-5);
    }
    
    /**
     * 此函数非原创，从网上搜索而来，timeZoneOffset原为int类型，为班加罗尔调整成float类型
     * timeZoneOffset表示时区，如中国一般使用东八区，因此timeZoneOffset就是8
     * @param timeZoneOffset
     * @return
     */
    public static String getFormatedDateString(float timeZoneOffset){
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }
        
        int newTime=(int)(timeZoneOffset * 60 * 60 * 1000);
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(newTime);
        if (ids.length == 0) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(newTime, ids[0]);
        }
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(timeZone);
        return sdf.format(new Date());
    }
    public static Date getDateByInt(int n) throws ParseException{
        Calendar c=Calendar.getInstance();
        //获得系统当前日期 
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH)+1;

        int day=c.get(Calendar.DAY_OF_MONTH);
        
         DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd"); 
         String s =year-n+"-"+month+"-"+day;
         return (Date) fmt.parse(s);
        
    }
    public static Timestamp  getYearAndMonth(int n) throws ParseException{
        Calendar c=Calendar.getInstance();
         DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        //获得系统当前日期 
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH)+1;
         String s =year+"-"+(month-n+1)+"-"+1+" 00:00:00";
        return new Timestamp(fmt.parse(s).getTime());
        
    }
    public static String  getYearMonth(int n){
        Calendar c=Calendar.getInstance();
        //获得系统当前日期 
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH)+1;
        if(month<=n){
            year-=1;
        }
        String s =year+"年"+(month-n)+"月";
        return s;
        
    }
    
    /**
     * 在curtime时间基础上加上<s>秒后的时间
     * @param curtime
     * @param s
     * @return
     */
    public static Date getSpecificDate(long curtime,int s){
        
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(curtime);
        ca.add(Calendar.SECOND, s);
        
        return ca.getTime();
    }
    
    /**
     * 字符串数组转Integer数组
     * 
     * @param strA
     * @return Integer[]
     * @Description:
     * @author zj
     * @date 2015年10月22日 下午3:39:17
     * @version V1.0
     */
    public static Integer[] sArrayToIArray(String[] strA) {
        Integer[] iA = new Integer[strA.length];
        for (int i = 0; i < strA.length; i++) {
            iA[i] = Integer.parseInt(strA[i]);
        }
        return iA;
    }
 

    public static TreeMap<String, Object> transBean2TreeMap(Object obj) {
        if(obj == null){
            return null;
        }        
        TreeMap<String, Object> map = new TreeMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }
        return map;
    }
    
    
	public static String calculatToken(TreeMap<String,Object> map){
		StringBuffer tokenBuf = new  StringBuffer();
		for(String key:map.keySet()){
			if(!"token".equals(key)){
				tokenBuf.append(Md5Utils.encript(key)).append(Md5Utils.encript(key+JSONObject.toJSONString(map.get(key))));
			}
		}
		return Md5Utils.encript(tokenBuf.toString());
	}
    
}
