package com.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Book;
import com.model.Books;
import com.service.inter.BookServiceInter;

public class OrderBookAction extends ModelAction<Books> {
	
	public OrderBookAction(){
		model = new Books();
	}
	
	public String execute(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookServiceInter bookServiceInter = (BookServiceInter) ctx.getBean("bookService");
		System.out.println("进入orderbookaction--execute()--");
		List<Book> booklist = (List<Book>) session.getAttribute("booklist");
		System.out.println("进入orderbookaction");
		if(booklist==null){
		System.out.println("booklist is null");}
		try {
//			if(bookServiceInter.orderBook(model.getBooks(), session, context)){
//				return SUCCESS;
//			}
			System.out.println("进入orderbookaction的try");
			if(bookServiceInter.orderBook(booklist, session, context)){
				System.out.println("进入orderbookaction的if");
				return SUCCESS;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return INPUT;
		}


}
