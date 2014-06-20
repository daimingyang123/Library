package com.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.BookDAO;
import com.entity.Book;
import com.service.inter.BookServiceInter;

public class BookService implements BookServiceInter{
	private BookDAO bookDAO;
	public BookService(BookDAO bookDAO)
	{
		this.bookDAO = bookDAO;
	}
	@Override
	public List<Book> getBooks(int pageIndex, int pageCount) throws Exception {
		return bookDAO.getBooks( (pageIndex - 1) * pageCount, pageCount);	
	}
	@Override
	public Book getInfor(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getBookCount() throws Exception {
		return bookDAO.getBookCount();
	}
	@Override
	public void addBook(Book book,HttpSession session,ServletContext servletContext) throws Exception {
		book.setState("ÔÚ¼Ü¿É½è");
		bookDAO.save(book);
		
	}
	
	
	public static void main(String args[]) throws Exception {
	ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	BookService bookService = (BookService) ctx.getBean("bookService");
	Book book = new Book();
//	HttpSession session = null;
//	ServletContext servletContext = null;
	book.setBookNo(7);
	book.setTitle("´ú");
	book.setPlot("fuck");
	book.setState("set");
//	bookService.addBook(book);
//	System.out.println(book.getTitle());
//	Book mybook = bookDAO
//	bookService.borrowBook(mybook, session, servletContext);
//	System.out.println(model);
//	System.out.println(bookServiceInter.getBlogs(0, 2));
	
	
}
	

}
