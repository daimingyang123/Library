package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Book;
import com.service.inter.BookServiceInter;

public class DeleteBookAction extends ModelAction<Book>{
	public DeleteBookAction(){
		model = new Book();
	}
	
	public String execute(){
		try
		{
//			BookServiceInter bookServiceInter = serviceManager.getBookServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			BookServiceInter bookServiceInter = (BookServiceInter) ctx.getBean("bookService");
				bookServiceInter.deleteBook(model, session, context);
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("adminbook", "操作を成功");
		}catch (Exception e){
			e.printStackTrace();
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("adminbook", "書物は貸した");
		}
		return SUCCESS;
	}
}
