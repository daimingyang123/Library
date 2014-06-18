package com.dao;

import com.dao.inter.IBaseHibernateDAO;
import com.model.HibernateSessionFactory;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO extends DAOSupport implements IBaseHibernateDAO {
	private Logger log = Logger.getLogger(this.getClass());
	public BaseHibernateDAO(HibernateTemplate template) {
		super(template);
		// TODO Auto-generated constructor stub
	}

	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	@Override
	public boolean create(Object entity) {
		try {
			System.out.println("saving");  //4test
			template.save(entity);
			return true;

		} catch (Exception e) {
			log.error("保存 " + entity.getClass().getName() + " 实例到数据库失败", e);
		}
		return false;
	}

	@Override
	public boolean update(Object entity) {
		try{
			template.update(entity);
			return true;
		}catch(Exception e){
			log.error("更新" + entity.getClass().getName() + " 失败", e);
			e.printStackTrace();
		}
		return false;
	}
	
}