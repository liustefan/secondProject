package com.bithealth.sdk.common.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.config.KDConfig;

/**
 * 描述 ：
 *
 * @author admin
 * @date 2016年6月1日
 */
public class MailSendServer {
    static String emailfrom = "";
    static String emailpassword = ""; 
    
    static String emailmailserver = "";
    static String emailpersonal = "";
    
    public static boolean sendMail(String subject, String email, String messageText) {
        
        
        KDConfig kdConfig = Env.getBean("rdConfig");
        
        emailfrom =kdConfig.getProperty("email.from") ; 
        emailpassword =kdConfig.getProperty("email.password") ;
        emailmailserver =kdConfig.getProperty("email.mailserver") ;
        emailpersonal =kdConfig.getProperty("email.personal") ;

        try {
            
            String from = emailfrom;
            
            String to = email;
             
            
            String password = emailpassword;
            
            String mailserver = emailmailserver;
            
            Properties prop = new Properties();
            
            prop.put("mail.smtp.host", mailserver);
            prop.put("mail.smtp.auth", "true");
            
            Session sess = Session.getInstance(prop);
            sess.setDebug(true);
            MimeMessage message = new MimeMessage(sess);
            
            // 给消息对象设置收件人、发件人、主题、发信时间
            InternetAddress mail_from = new InternetAddress(from);
            mail_from.setPersonal(MimeUtility.encodeText(emailpersonal));
            message.setFrom(mail_from);
            InternetAddress mail_to = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, mail_to);
            message.setSubject(subject);
            message.setSentDate(new Date());
            Multipart mul = new MimeMultipart(); // 新建一个MimeMultipart对象来存放多个BodyPart对象
            BodyPart mdp = new MimeBodyPart(); // 新建一个存放信件内容的BodyPart对象
            mdp.setContent(messageText, "text/html;charset=gb2312");
            mul.addBodyPart(mdp); // 将含有信件内容的BodyPart加入到MimeMulitipart对象中
            message.setContent(mul); // 把mul作为消息对象的内容
            message.saveChanges();
            
            Transport transport = sess.getTransport("smtp");
            
            // 以smtp方式登陆邮箱，第1个参数是发送邮件用的邮件服务器SMTP地址，第2个参数为用户名，第3个参数为密码
            
            transport.connect(mailserver, from, password);
            
            transport.sendMessage(message, message.getAllRecipients());
            
            transport.close();

            return true;
            
        } catch (Exception e) {
            
            System.out.println("发送邮件产生的错误：" + e.getMessage());
            
            return false;
        }
    }
    
}
