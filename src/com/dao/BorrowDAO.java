package com.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.inter.BorrowDAOInter;
import com.entity.Book;
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


	private static final Logger log = LoggerFactory.getLogger(BorrowDAO.class);
	// property constants
	public static final String STATE = "state";
	@Override
	public void save(Borrow borrow) throws Exception {
		template.saveOrUpdate(borrow);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public Borrow findByUNBN(final int userNo, final int bookNo) throws Exception {
		return (Borrow) template.execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException
			{   
				List<Borrow> borrow = (List<Borrow>)template.find("from Borrow where userNo = ? and bookNo = ?",userNo,bookNo);
				return borrow.get(0);
			}
		});
	}
	

//	public void save(Borrow transientInstance) {
//		log.debug("saving borrow instance");
//		try {
//			getSession().save(transientInstance);
//			log.debug("save successful");
//		} catch (RuntimeException re) {
//			log.error("save failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Borrow persistentInstance) {
//		log.debug("deleting borrow instance");
//		try {
//			getSession().delete(persistentInstance);
//			log.debug("delete successful");
//		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
//		}
//	}
//
//	public Borrow findById(java.lang.Integer id) {
//		log.debug("getting borrow instance with id: " + id);
//		try {
//			Borrow instance = (Borrow) getSession()
//					.get("com.entity.borrow", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//	public List findByExample(Borrow instance) {
//		log.debug("finding borrow instance by example");
//		try {
//			List results = getSession().createCriteria("com.entity.borrow")
//					.add(Example.create(instance)).list();
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
//		log.debug("finding borrow instance with property: " + propertyName
//				+ ", value: " + value);
//		try {
//			String queryString = "from borrow as model where model."
//					+ propertyName + "= ?";
//			Query queryObject = getSession().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	public List findByState(Object state) {
//		return findByProperty(STATE, state);
//	}
//
//	public List findAll() {
//		log.debug("finding all borrow instances");
//		try {
//			String queryString = "from borrow";
//			Query queryObject = getSession().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	public Borrow merge(Borrow detachedInstance) {
//		log.debug("merging borrow instance");
//		try {
//			Borrow result = (Borrow) getSession().merge(detachedInstance);
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Borrow instance) {
//		log.debug("attaching dirty borrow instance");
//		try {
//			getSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Borrow instance) {
//		log.debug("attaching clean borrow instance");
//		try {
//			getSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
}