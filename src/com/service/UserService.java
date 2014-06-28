package com.service;

import com.dao.UserDAO;
import com.entity.User;
import com.service.inter.UserServiceInter;

public class UserService implements UserServiceInter {
	
	private UserDAO userDAO;
	private User addDbUser;
	UserService(UserDAO userDAO)
	{
		this.userDAO=userDAO;
	}

	@Override
	public User getUser(String id) throws Exception {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean verifyUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
		User dbUser=userDAO.findById(user.getUserNo());
		if (dbUser==null){
			return false;
		}
		int dbno=dbUser.getUserNo();
		if(user.getUserNo().equals(dbUser.getUserNo()) && user.getUserName().equals(dbUser.getUserName()))
		{
			return true;
		}
		return false;
	}

	@SuppressWarnings("null")
	@Override
	public User addUser(Integer userNo,String userName,String email) throws Exception {
		// TODO Auto-generated method stub
		addDbUser=new User();
		if(userName==null&&userName.length()==0){
			return null;
		}
		if(userName!=null&&userName.length()!=0){
			addDbUser.setUserNo(userNo);
			addDbUser.setUserName(userName);
			addDbUser.setEmail(email);
			userDAO.save(addDbUser);
			return userDAO.findByName(userName);
		}
		return null;
	}

	@Override
	public User findByNo(Integer userNo) throws Exception {
		return userDAO.findByNo(userNo);
	}
	
	//test
//	public static void main(String args[]) throws Exception {
//	ApplicationContext ctx = new ClassPathXmlApplicationContext(
//			"applicationContext.xml");
//	UserServiceInter userServiceInter = (UserServiceInter) ctx.getBean("UserService");
//	User uer=new User();
////	uer.setUserNo(1);
////	uer.setUserName("fuck");
////	boolean user = userServiceInter.verifyUser(uer);
//	uer=userServiceInter.addUser("fack");
//	
//	System.out.println(uer.getUserName());
//}

}
