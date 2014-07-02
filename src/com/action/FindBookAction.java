package com.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Book;
import com.service.inter.BookServiceInter;

public class FindBookAction extends ModelAction<Book> {
	
	public FindBookAction(){
		model = new Book();
	}
	
	public String execute(){
		try
		{
//			BookServiceInter bookServiceInter = serviceManager.getBookServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			BookServiceInter bookServiceInter = (BookServiceInter) ctx.getBean("bookService");
			List<Book> booklist =bookServiceInter.findBook(model, session, context);
			session.setAttribute("booklist",booklist);
			model.setBooks(booklist);
			return SUCCESS;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("userbookerror", "操作ミス");
//		System.out.println("adduseraction--数据库中存在此userno 添加不成功");
		return INPUT;
		
	}

}
