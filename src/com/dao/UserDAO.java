package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.inter.UserDAOInter;
import com.entity.User;


/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.entity.User
 * @author MyEclipse Persistence Tools
 */
public class UserDAO extends DAOSupport implements UserDAOInter {
	public UserDAO(HibernateTemplate template) {
		super(template);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save(User user) throws Exception {
		template.saveOrUpdate(user);
	}
	


	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean delete(final User user) throws Exception {
		try{
		template.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("delete from User where userNo = ?");
				query.setInteger(0, user.getUserNo());
				return query.executeUpdate();
			}
		});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
		return true;
}
	
	@SuppressWarnings("unchecked")
	public User findByName(String userName) throws Exception{
		List<User> users=template.find("from User where userName=?",userName);
		if(users.size()>0){
			return users.get(0);
			}
		return null;
		 
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public User findById(final int id) throws Exception
	{
		return (User) template.execute(new HibernateCallback()
		{
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException
			{   				
				User user = (User)session.get(User.class,id);
				return user;
			}

		});

	}
	

	
	 @Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<User> getUsers(final int start, final int
	 count)
	 {
	 return (List<User>) template.execute(new HibernateCallback()
	 {
	 @Override
	public Object doInHibernate(Session session)
	 throws HibernateException, SQLException
	 {
	 Query query =
	 session.createQuery("from User order by userNO DESC");
	 query.setFirstResult(start);
	 query.setMaxResults(count);
	 return query.list();
	 }
	 });
	 }

	 @SuppressWarnings("unchecked")
	 @Override
		public User findByNo(int userNo) throws Exception {
		 List<User> users=template.find("from User where userNo=?",userNo);
			if(users.size()>0){
				return users.get(0);
				}
			return null;
		}
	
	 @SuppressWarnings("rawtypes")
	public long getUserCount() throws Exception {
			List count =  template.find("select count(*) from User ");		
			return ((Long)count.get(0)).longValue();
		}
	 
	 // function test
	public static void main(String args[]) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAO userDAO = (UserDAO) ctx.getBean("UserDAO");
		User user = userDAO.findByNo(1);
		System.out.println(user.getUserName());
		
	}

	


	

}