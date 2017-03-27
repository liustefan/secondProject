package com.bithealth.sdk.common.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
    /**
     * 验证Email地址的合法性
     * 
     * @param strEmail
     * @return
     */
    public static boolean isEmail(String strEmail) {

        String strPattern = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";

        Pattern p = Pattern.compile(strPattern);

        Matcher m = p.matcher(strEmail);

        return m.matches();
    }

    /**
     * 验证手机号是否合法 true 合法 false 不合法
     */
    public static boolean isMobileNo(String mobiles) {

        Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(18[0-9])|(17[0-9]))\\d{8}$");

        Matcher m = p.matcher(mobiles);

        return m.matches();
    }

    /**
     * 随机生成指定长度的数字和字母组合而成的随机数
     * 
     * @param length 需要生成随机数的长度
     * @return
     */
    public static String getCharAndNum(int length) {
        
        String val = "";

        Random random = new Random();
        
        for (int i = 0; i < length; i++) {
        
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字

            if ("char".equalsIgnoreCase(charOrNum)){  // 字符串
                
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
                
                val += (char) (choice + random.nextInt(26));
                
            } else if ("num".equalsIgnoreCase(charOrNum)){   // 数字
                
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
    
    public static String pstr = "\"([^\"|[\u4e00-\u9fa5]]+)\"";  
    public static boolean checkPassword(String pw){
        //密码不能是汉字等其他特殊字符
        if(!pw.matches("(\\w{6,12})")){
            return false;
        }
        
        if(pw.matches(pstr))
            return false;
        
        return true;
    }
    
    /**
     * 校验位整数
     * @param value
     * @return
     */
    public static boolean checkInteger(String value){
        Pattern pattern = Pattern.compile("^\\d+(\\.[0])?$");  
        Matcher match=pattern.matcher(value);
        return match.matches();
    }

    /**
     * 校验数值
     * @param value
     * @return
     */
    public static boolean checkNumber(String value){
        Pattern pattern = Pattern.compile("^[0-9]+([.]{1}[0-9]+){0,1}$");  
        Matcher match=pattern.matcher(value); 
        return match.matches();
    }
    
    /**
     * 出生日期格式：yyyy-MM-dd
     * @param birthday
     * @return
     */
    public static boolean checkBirthday(String birthday) {
    	String check = "^\\d{4}-\\d{2}-\\d{2}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(birthday);
		return matcher.matches();
    }

    public static void main(String[] args) {

//      System.out.println(isMobileNo("18779883583"));
//      System.out.println(isEmail("111"));
//      System.out.println(getCharAndNum(6));
        System.out.println(checkPassword("aaaddw1"));
    }
}
