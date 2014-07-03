package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
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
//			int pageIndex = 1;
			model.setCurrentPage(1);
			model.setCount(userServiceInter.getUserCount());
			int div =  (int) model.getCount() / model.getEveryPageCount();
			model.setPageCount((model.getCount() % model.getEveryPageCount() == 0)?div:div+1);
			model.setUsers(userServiceInter.getUsers(model.getPageIndex(), model.getEveryPageCount()));
			if(model.getPageIndex()>0 && model.getPageCount()>=model.getPageIndex()){
//				System.out.println("合理范围");
				return SUCCESS;
			}else{
//				System.out.println("不合理范围");
				HttpSession session = ServletActionContext.getRequest().getSession();
					session.setAttribute("adminuser", "ジャンプしない");
				return INPUT;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
