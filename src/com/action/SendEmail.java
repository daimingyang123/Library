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
      * ����Ϊjavamail���ʼ�����
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
					System.out.println("���ڷ����ʼ�");
					Properties props=new Properties();
			        props.put("mail.smtp.host","smtp.qq.com");//������ʹ�÷��ʼ��ĵ��������������ʹ�õ���qq�ķ�����
			        props.put("mail.smtp.auth","true"); //��������ͨ����֤
			        Session s=Session.getInstance(props);
			        s.setDebug(true);
			        MimeMessage message=new MimeMessage(s);
			        //����Ϣ�������÷�����/�ռ���/����/����ʱ��
			        InternetAddress from=new InternetAddress("1428353071@qq.com");  //���ʼ��ĳ����أ������˵����䣩�������ҵ������ַ��ʹ����ĳ������Ч��ַ
			        message.setFrom(from);
			        InternetAddress to=new InternetAddress(email);// ttoΪ���ʼ���Ŀ�ĵأ��ռ������䣩
			        message.setRecipient(Message.RecipientType.TO,to);
			        message.setSubject("�߻�֪ͨ");// ttitleΪ�ʼ��ı���
			        message.setSentDate(now);
			        BodyPart mdp=new MimeBodyPart();//�½�һ������ż����ݵ�BodyPart����
			        String content = bookServiceInter.findByNo(borrow.getBookNo()).getTitle();
			        mdp.setContent("�����ͼ��"+ content + "�û���","text/html;charset=utf-8");//��BodyPart�����������ݺ͸�ʽ/���뷽ʽtcontentΪ�ʼ�����
			        Multipart mm=new MimeMultipart();//�½�һ��MimeMultipart�����������BodyPart��
			        //��(��ʵ�Ͽ��Դ�Ŷ��)
			        mm.addBodyPart(mdp);//��BodyPart���뵽MimeMultipart������(���Լ�����BodyPart)
			        message.setContent(mm);//��mm��Ϊ��Ϣ���������
			        message.saveChanges();
			        Transport transport=s.getTransport("smtp");
			        transport.connect("smtp.qq.com","1428353071@qq.com","neverreturn1314");//���ʼ����ʻ�����,�������ҵ��ʻ����룬ʹ��ʱ���޸ġ�
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



