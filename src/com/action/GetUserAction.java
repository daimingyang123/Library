package com.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Users;
import com.service.inter.UserServiceInter;

@SuppressWarnings("serial")
public class GetUserAction extends ModelAction<Users>{
	public GetUserAction(){
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
//			if(session.getAttribute("user")=="admin"){
//				return SUCCESS;
//			}else{
//				return INPUT;
//			}
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return INPUT;
	}

}
