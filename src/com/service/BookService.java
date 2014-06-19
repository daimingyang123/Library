package com.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.BookDAO;
import com.dao.UserDAO;
import com.entity.Book;
import com.service.inter.BookServiceInter;

public class BookService implements BookServiceInter{
	private BookDAO bookDAO;
	private UserDAO userDAO;
	
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
	public void addBook(Book book, HttpSession session,
			ServletContext servletContext) throws Exception {
		book.setTitle(book.getTitle());
		book.setPlot(book.getPlot());
		bookDAO.save(book);
		
	}
	
//	public void borrowBook(Borrow borrow, HttpSession session,
//			ServletContext servletContext) throws Exception {
//		User user = new User();
//		Book book = new Book();
//		String title = book.getTitle();
//		Book mybook = bookDAO.findByTitle(title);
//		String userName = user.getUserName();
//		User myuser = userDAO.findByName(userName);
//		java.util.Date now = new java.util.Date();
//		borrow.setBorrowDate(now);
//		borrow.setState(null);
//		borrow.setbookNo(mybook.getBookNo());
//		borrow.setuserNo(myuser.getUserNo());
//		borrow.setUserNo(userNo)
//		System.out.println(title);
//		borrow.sa
		
//		bookDAO.save(mybook);
		
//	}
	
	public static void main(String args[]) throws Exception {
	ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	BookService bookService = (BookService) ctx.getBean("bookService");
	Book book = new Book();
	HttpSession session = null;
	ServletContext servletContext = null;
	book.setTitle("´ú");
	bookService.addBook(book, session, servletContext);
//	System.out.println(book.getTitle());
//	Book mybook = bookDAO
//	bookService.borrowBook(mybook, session, servletContext);
//	System.out.println(model);
//	System.out.println(bookServiceInter.getBlogs(0, 2));
	
	
}
	

}
