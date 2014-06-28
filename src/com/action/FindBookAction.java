package com.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Book;
import com.service.inter.BookServiceInter;

@SuppressWarnings({ "serial" })
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
			model.setBooks(bookServiceInter.findBook(model, session, context));
			request.getSession().setAttribute(result, model.getBooks());
//			String books = null;
////			List<Book> books;
//			session.setAttribute(books,model.getBooks());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
		
	}

}
