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

import com.dao.inter.BorrowDAOInter;
import com.entity.Borrow;

/**
 * A data access object (DAO) providing persistence and search support for
 * borrow entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entity.Borrow
 * @author MyEclipse Persistence Tools
 */

public class BorrowDAO extends DAOSupport implements BorrowDAOInter {
	public BorrowDAO(HibernateTemplate template) {
		super(template);
		// TODO Auto-generated constructor stub
	}


	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(BorrowDAO.class);
	// property constants
	public static final String STATE = "state";
	@Override
	public void save(Borrow borrow) throws Exception {
		template.saveOrUpdate(borrow);
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Borrow> findByUserNo(final int userNo) throws Exception {
		return (List<Borrow>) template.execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException
			{   
				List<Borrow> borrow = (List<Borrow>)template.find("from Borrow where userNo = ? ",userNo);
				return borrow;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<Borrow> findByBookNo(final int bookNo) throws Exception {
		return (List<Borrow>) template.execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException
			{   
				List<Borrow> borrow = (List<Borrow>)template.find("from Borrow where bookNo = ? ",bookNo);
				return borrow;
			}
		});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delete(final Borrow borrow) throws Exception {
		template.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("delete from Borrow where id = ?");
				query.setInteger(0, borrow.getId());
				query.executeUpdate();
				return null;
			}
		});

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Borrow> getBorrows() {
		return (List<Borrow>) template.execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					 throws HibernateException, SQLException
					 {
					 Query query =
					 session.createQuery("from Borrow order by id");
					 return query.list();
					 }
		});
	}
	
//	public static void main(String args[]) throws Exception {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		BorrowDAO borrowDAO = (BorrowDAO) ctx.getBean("borrowDAO");
//		List<Borrow> borrows = borrowDAO.findByUserNo(1);
//		for(int i=0;i<borrows.size();i++){
//			System.out.println(borrows.size());	
//		}
//		
//	}

}