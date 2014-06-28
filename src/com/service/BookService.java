package com.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

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
	public void addBook(Book book, HttpSession session, ServletContext context)
			throws Exception {
		book.setState("在架可借");
		bookDAO.save(book);
		
	}
	@Override
	public Book findByNo(int No) throws Exception {
		return bookDAO.findByNo(No);
	}

	public List<Book> findBook(Book book, HttpSession session,
			ServletContext servletContext) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.findByTitle(book.getTitle());
	}
	
	@SuppressWarnings("null")
	public boolean orderBook(List<Book> books,HttpSession session,ServletContext servletContext) throws Exception{
		
		if(books != null || books.size()!=0){
			for(int i=0;i<books.size();i++){
				if(books.get(i).getState()=="在架可借"){
					books.get(i).setState("已预约");
					bookDAO.save(books.get(i));
					return true;
				}
			}
		}
		System.out.println("fuck");
		return false;
	}

//	public static void main(String args[]) throws Exception {
//	ApplicationContext ctx = new ClassPathXmlApplicationContext(
//			"applicationContext.xml");
//	BookServiceInter bookServiceInter = (BookServiceInter) ctx.getBean("bookService");
//	HttpSession session = null;
//	ServletContext context = null;
//	Book book = new Book();
//	book.setTitle("1");
//	List<Book> books = bookServiceInter.findBook(book, session, context);
//	for(int i =0;i<books.size();i++){
//		
//	System.out.println(books.get(i).getBookNo());
//	}
//}
}
