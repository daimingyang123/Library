package com.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Users;
import com.service.inter.UserServiceInter;

@SuppressWarnings("serial")
public class GetUsersAction extends ModelAction<Users>{
	public GetUsersAction(){
		model = new Users();
	}
	@Override
	public String execute()
	{
		try
		{
			
//			BookServiceInter bookServiceInter = serviceManager.getBookServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserServiceInter userServiceInter = (UserServiceInter) ctx.getBean("UserService");
			int pageIndex = 1;
			model.setCurrentPage(pageIndex);
			model.setCount(userServiceInter.getUserCount());
			int div =  (int) model.getCount() / model.getEveryPageCount();
			model.setPageCount((model.getCount() % model.getEveryPageCount() == 0)?div:div+1);
			model.setUsers(userServiceInter.getUsers(model.getPageIndex(), model.getEveryPageCount()));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
