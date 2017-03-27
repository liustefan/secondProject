package com.bithealth.sdk.common.email;


public class MailToGetNewLoginPassword {
   
       
	public static boolean sendMail(String docAccount, String email, String content) {
		
        try{
            
        String subject = "重置密码";
            
            String messageText = "账号为: " + docAccount +" 您的新密码是: " + content + " 为了您的账户按安全，请登录并及时更改密码!"+
            "请不要回复此邮件，如有疑问请联系系统管理员";
             
			MailSendServer.sendMail(subject, email, messageText);
			
			return true;
			
		} catch (Exception e) {
			
			System.out.println("发送邮件产生的错误：" + e.getMessage());
			
			return false;
		}
	}
}
