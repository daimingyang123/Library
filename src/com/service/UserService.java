package com.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.BorrowDAO;
import com.dao.UserDAO;
import com.entity.Borrow;
import com.entity.User;
import com.service.inter.UserServiceInter;

public class UserService implements UserServiceInter {
	
	private UserDAO userDAO;
	private BorrowDAO borrowDAO;
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

	@Override
	public List<User> getUsers(int pageIndex, int EverypageCount) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.getUsers((pageIndex - 1) * EverypageCount, EverypageCount);
	}

	@Override
	public long getUserCount() throws Exception {
		return userDAO.getUserCount();
	}

	@Override
	public boolean deleteUser(User user, HttpSession session,
			ServletContext context) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.delete(user);
	}

	@Override
	public boolean modifyUser(User user, HttpSession session,
			ServletContext context) throws Exception {
			try {
				int userNo = Integer.parseInt(ServletActionContext.getRequest().getParameter("userNo"));
				System.out.println(userNo);
				List<Borrow> borrows = borrowDAO.findByUserNo(userNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				int userNo = Integer.parseInt(ServletActionContext.getRequest().getParameter("userNo"));
				User myuser = userDAO.findByNo(userNo);
				System.out.println(user.getUserName());
				System.out.println(myuser.getUserName());
				myuser.setUserName(user.getUserName());
				myuser.setEmail(user.getEmail());
				userDAO.save(myuser);
				return true;
			}
			return false;
	}
	
	//test
//	public static void main(String args[]) throws Exception {
//	ApplicationContext ctx = new ClassPathXmlApplicationContext(
//			"applicationContext.xml");
//	UserServiceInter userServiceInter = (UserServiceInter) ctx.getBean("UserService");
//	User uer=new User();
////	uer.setUserNo(1);
////	boolean user = userServiceInter.verifyUser(uer);
//	uer=userServiceInter.addUser("fack");
//	
//	System.out.println(uer.getUserName());
//}

}
