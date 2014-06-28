package com.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Book;
import com.service.inter.BookServiceInter;

@SuppressWarnings("serial")
public class OrderBookAction extends ModelAction<Book> {
	
	public OrderBookAction(){
		model = new Book();
	}
	
	public String execute(){
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			BookServiceInter bookServiceInter = (BookServiceInter) ctx.getBean("bookService");
			System.out.println("fuck");
			List<Book> books = new ArrayList();
			for(int i=0;i<3;i++){
			books.set(i, (Book) request.getAttribute(result));
			System.out.println("fuck");
			}
			bookServiceInter.orderBook(books, session, context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
		}


}
