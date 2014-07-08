package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimerTask;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Borrow;
import com.service.inter.BookServiceInter;
import com.service.inter.BorrowServiceInter;
import com.service.inter.UserServiceInter;



public class SendEmail extends TimerTask 
{ 
 @SuppressWarnings("unused")
private ServletContext context = null; 
 
 public SendEmail(ServletContext context) 
 { 
  this.context = context; 
 } 
 
 @Override 
 public void run() 
 { 
      /*
      * 以下为javamail的邮件发送
      */
	 	try{
	 		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			BorrowServiceInter borrowServiceInter = (BorrowServiceInter) ctx.getBean("borrowService");
			UserServiceInter userServiceInter = (UserServiceInter) ctx.getBean("UserService");
			BookServiceInter bookServiceInter = (BookServiceInter) ctx.getBean("bookService");
			List<Borrow> borrows = borrowServiceInter.getBorrows();
			for(int i=0;i<borrows.size();i++){
				Borrow borrow = borrows.get(i);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
				Date now = new Date();
				String s1 = sdf.format(now);  
				String s2 = sdf.format(borrows.get(i).getReturnDate());
				if(s1.equals(s2)){
					String email = userServiceInter.findByNo(borrow.getUserNo()).getEmail();
					System.out.println("正在发送邮件");
					Properties props=new Properties();
			        props.put("mail.smtp.host","smtp.qq.com");//发件人使用发邮件的电子信箱服务器我使用的是qq的服务器
			        props.put("mail.smtp.auth","true"); //这样才能通过验证
			        Session s=Session.getInstance(props);
			        s.setDebug(true);
			        MimeMessage message=new MimeMessage(s);
			        //给消息对象设置发件人/收件人/主题/发信时间
			        InternetAddress from=new InternetAddress("1428353071@qq.com");  //发邮件的出发地（发件人的信箱），这是我的邮箱地址，使用请改成你的有效地址
			        message.setFrom(from);
			        InternetAddress to=new InternetAddress(email);// tto为发邮件的目的地（收件人信箱）
			        message.setRecipient(Message.RecipientType.TO,to);
			        message.setSubject("催还通知");// ttitle为邮件的标题
			        message.setSentDate(now);
			        BodyPart mdp=new MimeBodyPart();//新建一个存放信件内容的BodyPart对象
			        String content = bookServiceInter.findByNo(borrow.getBookNo()).getTitle();
			        mdp.setContent("お借りに  "+ content + "  が返すだった","text/html;charset=utf-8");//给BodyPart对象设置内容和格式/编码方式tcontent为邮件内容
			        Multipart mm=new MimeMultipart();//新建一个MimeMultipart对象用来存放BodyPart对
			        //象(事实上可以存放多个)
			        mm.addBodyPart(mdp);//将BodyPart加入到MimeMultipart对象中(可以加入多个BodyPart)
			        message.setContent(mm);//把mm作为消息对象的内容
			        message.saveChanges();
			        Transport transport=s.getTransport("smtp");
			        transport.connect("smtp.qq.com","1428353071@qq.com","neverreturn1314");//发邮件人帐户密码,此外是我的帐户密码，使用时请修改。
			        transport.sendMessage(message, message.getAllRecipients());
			        transport.close();  
			}
			}
	 		}catch (Exception e) 
	 		{
	 			e.printStackTrace();
	 		}       
 }  
}



