package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

public class BookDAO extends DAOSupport implements BookDAOInter {
	public BookDAO(HibernateTemplate template) {
		super(template);
		// TODO Auto-generated constructor stub
	}

	private static final Logger log = LoggerFactory.getLogger(BookDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String PLOT = "plot";
	public static final String STATE = "state";

	protected void initDao() {
		// do nothing
	}

//	public void save(Book transientInstance) {
//		log.debug("saving Book instance");
//		try {
//			getHibernateTemplate().save(transientInstance);
//			log.debug("save successful");
//		} catch (RuntimeException re) {
//			log.error("save failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Book persistentInstance) {
//		log.debug("deleting Book instance");
//		try {
//			getHibernateTemplate().delete(persistentInstance);
//			log.debug("delete successful");
//		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
//		}
//	}
//
//	public Book findById(java.lang.Integer id) {
//		log.debug("getting Book instance with id: " + id);
//		try {
//			Book instance = (Book) getHibernateTemplate().get(
//					"com.entity.Book", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//	public List findByExample(Book instance) {
//		log.debug("finding Book instance by example");
//		try {
//			List results = getHibernateTemplate().findByExample(instance);
//			log.debug("find by example successful, result size: "
//					+ results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Book instance with property: " + propertyName
//				+ ", value: " + value);
//		try {
//			String queryString = "from Book as model where model."
//					+ propertyName + "= ?";
//			return getHibernateTemplate().find(queryString, value);
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}

//	public List findByTitle(Object title) {
//		return findByProperty(TITLE, title);
//	}
//
//	public List findByPlot(Object plot) {
//		return findByProperty(PLOT, plot);
//	}
//
//	public List findByState(Object state) {
//		return findByProperty(STATE, state);
//	}
//
//	public List findAll() {
//		log.debug("finding all Book instances");
//		try {
//			String queryString = "from Book";
//			return getHibernateTemplate().find(queryString);
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	public Book merge(Book detachedInstance) {
//		log.debug("merging Book instance");
//		try {
//			Book result = (Book) getHibernateTemplate().merge(detachedInstance);
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Book instance) {
//		log.debug("attaching dirty Book instance");
//		try {
//			getHibernateTemplate().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Book instance) {
//		log.debug("attaching clean Book instance");
//		try {
//			getHibernateTemplate().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}

	@Override
	public void save(Book book) throws Exception {
		template.saveOrUpdate(book);
	}
	
	public static BookDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BookDAO) ctx.getBean("BookDAO");
	}
	
	@SuppressWarnings("unchecked")
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

	@Override
	public long getBookCount() throws Exception {
		List count =  template.find("select count(*) from Book ");		
		return ((Long)count.get(0)).longValue();
	}
	
	
	@SuppressWarnings("unchecked")
	public Book findByTitle(final String title) throws Exception {
		return (Book) template.execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException
			{   
				List<Book> book = (List<Book>)template.find("from Book where title = ?",title);
				return book.get(0);
			}
		});
	}
	
	public static void main(String args[]) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		BookDAO bookDAO = (BookDAO) ctx.getBean("bookDAO");
//		Book mybook = new Book;
		Book mybook = bookDAO.findByTitle("fuck");
//		Book book = new Book();
//		book.setTitle("fuck");
//		book.setPlot("shit");
//		book.setState("zaijia");
//		bookDAO.save(book);
//		List<Book> mybook = bookDAO.getBooks(0, 3);
		System.out.println(mybook.getBookNo());
//		bookDAO.delete(mybook);
		
	}

	

	

	
}