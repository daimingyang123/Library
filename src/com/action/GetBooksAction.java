package com.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Books;
import com.service.inter.BookServiceInter;

@SuppressWarnings("serial")
public class GetBooksAction extends ModelAction<Books>{
	public GetBooksAction(){
		model = new Books();
	}
	@Override
	public String execute()
	{
		try
		{
			
//			BookServiceInter bookServiceInter = serviceManager.getBookServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			BookServiceInter bookServiceInter = (BookServiceInter) ctx.getBean("bookService");
			int pageIndex = 1;
			model.setCurrentPage(pageIndex);
			model.setCount(bookServiceInter.getBookCount());
			int div =  (int) model.getCount() / model.getEveryPageCount();
			model.setPageCount((model.getCount() % model.getEveryPageCount() == 0)?div:div+1);
			model.setBooks(bookServiceInter.getBooks(model.getPageIndex(),
			model.getEveryPageCount()));
			return SUCCESS;


		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return INPUT;
	}
}
