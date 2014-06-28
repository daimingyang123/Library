package com.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Book;
import com.service.inter.BookServiceInter;

@SuppressWarnings("serial")
public class AddBookAction extends ModelAction<Book>{

	public AddBookAction(){
		model = new Book();
	}
	
	public String execute(){
		try
		{
//			BookServiceInter bookServiceInter = serviceManager.getBookServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			BookServiceInter bookServiceInter = (BookServiceInter) ctx.getBean("bookService");
//			System.out.println(model.getTitle());
			bookServiceInter.addBook(model, session, context);

			return SUCCESS;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		result = "·¢²¼Ê§°Ü";
		return INPUT;
	}
}
