package com.dao.inter;

import org.hibernate.Session;


/**
 * Data access interface for domain model
 * @author MyEclipse Persistence Tools
 */
public interface IBaseHibernateDAO {
	public Session getSession();
	public boolean create(Object entity);
	public boolean update(Object entity);
	
}