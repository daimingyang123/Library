package com.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.BookDAO;
import com.dao.BorrowDAO;
import com.entity.Book;
import com.entity.Borrow;
import com.service.inter.BookServiceInter;

public class BookService implements BookServiceInter{
	private BookDAO bookDAO;
	private BorrowDAO borrowDAO;
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
		int bookNo = Integer.parseInt(ServletActionContext.getRequest().getParameter("bookNo"));
//		if(bookNo==0){
			book.setState(1);
			bookDAO.save(book);
//		}else{
//			
//		}
		
		
	}
	@Override
	public Book findByNo(int No) throws Exception {
		return bookDAO.findByNo(No);
	}

	@Override
	public List<Book> findBook(Book book, HttpSession session,
			ServletContext servletContext) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.findByTitle(book.getTitle());
	}
	
	@SuppressWarnings("null")
	public boolean orderBook(List<Book> books,HttpSession session,ServletContext servletContext) throws Exception{
		if(books==null){System.out.println("boos is null");}
		if(books != null || books.size()!=0){
			for(int i=0;i<books.size();i++){
				if(books.get(i).getState().equals(1)){
					books.get(i).setState(0);
					bookDAO.save(books.get(i));
					System.out.println(books.get(i).getTitle());
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public boolean verifySameBook(Integer bookNo) throws Exception {
		// TODO Auto-generated method stub
		if(bookDAO.findByNo(bookNo)==null){
			//返回true代表已存在相同number
			return false;
		}
		return true;
	}
	@Override
	public boolean deleteBook(Book book, HttpSession session,
			ServletContext context) throws Exception {
		int bookNo = Integer.parseInt(ServletActionContext.getRequest().getParameter("bookNo"));
		Book mybook = bookDAO.findByNo(bookNo);
		int i = mybook.getState();
		if(i==1){
			bookDAO.delete(mybook);
//			System.out.println("service1");
			return true;
		}
	return false;
	}
	
	public boolean modifyBook(Book book, HttpSession session,
			ServletContext context) throws Exception {
			int bookNo = Integer.parseInt(ServletActionContext.getRequest().getParameter("bookNo"));
			Book mybook = bookDAO.findByNo(bookNo);
			int i = mybook.getState();
			if(i==1){
				mybook.setState(1);
				mybook.setTitle(book.getTitle());
				mybook.setPlot(book.getPlot());
				bookDAO.save(mybook);
//				System.out.println("service1");
				return true;
			}
		return false;
	}
	
	public static void main(String args[]) throws Exception {
	ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	BookServiceInter bookServiceInter = (BookServiceInter) ctx.getBean("bookService");
	Book mybook = bookServiceInter.findByNo(2);
	HttpSession session = null;
	ServletContext context = null;
	bookServiceInter.deleteBook(mybook, session, context);
//	System.out.println(uer.getbookName());
}
	

}
