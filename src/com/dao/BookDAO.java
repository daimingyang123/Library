package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.inter.BookDAOInter;
import com.entity.Book;

/**
 * A data access object (DAO) providing persistence and search support for Book
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.entity.Book
 * @author MyEclipse Persistence Tools
 */

public class BookDAO extends BaseHibernateDAO implements BookDAOInter {
	public BookDAO(HibernateTemplate template) {
		super(template);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(BookDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String PLOT = "plot";
	public static final String STATE = "state";

	@Override
	public void save(Book book) throws Exception {
		template.saveOrUpdate(book);
	}
	
	public static BookDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BookDAO) ctx.getBean("BookDAO");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Book> getBooks(final int start, final int count) {
		return (List<Book>) template.execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					 throws HibernateException, SQLException
					 {
					 Query query =
					 session.createQuery("from Book order by bookNo");
					 query.setFirstResult(start);
					 query.setMaxResults(count);
					 return query.list();
					 }
		});
	}

	@SuppressWarnings("rawtypes")
	@Override
	public long getBookCount() throws Exception {
		List count =  template.find("select count(*) from Book ");		
		return ((Long)count.get(0)).longValue();
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Book findbyTitle(final String title) throws Exception {
		return (Book) template.execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException
			{   
				List<Book> book = (List<Book>)template.find("from Book where title = ?",title);
				return book.get(0);
			}
		});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Book> findByTitle(final String title) throws Exception {
		return (List<Book>) template.execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException
			{   
				List<Book> books = (List<Book>)template.find("from Book where title = ?",title);
				return books;
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Book findByNo(final int No) throws Exception {
		return (Book) template.execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException
			{   
				List<Book> book = (List<Book>)template.find("from Book where bookNo = ?",No);
				return book.get(0);
			}
		});
	}
	
	
//	public static void main(String args[]) throws Exception {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		BookDAO bookDAO = (BookDAO) ctx.getBean("bookDAO");
//		Book mybook = new Book;
//		Book mybook = bookDAO.findbyTitle("1");
//		Book book = new Book();
//		book.setTitle("fuck");
//		book.setPlot("shit");
//		book.setState("zaijia");
//		bookDAO.save(book);
//		List<Book> mybook = bookDAO.getBooks(0, 3);
//		
//		System.out.println(mybook.get(1).getPlot());
//		bookDAO.delete(mybook);
		
//	}

	

	

	
}