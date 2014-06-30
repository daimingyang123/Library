package com.action;

import java.util.List;

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
		return INPUT;
		
	}

}
