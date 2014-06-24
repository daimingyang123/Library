package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.User;
import com.service.inter.UserServiceInter;

@SuppressWarnings("serial")
public class LoginAction extends  ModelAction<User> {
	public LoginAction(){

		model=new User();
	}
	public String execute(){
		try
		{
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserServiceInter userServiceInter = (UserServiceInter) ctx.getBean("UserService");
			if(userServiceInter.verifyUser(model))
				{
					HttpSession session = ServletActionContext.getRequest().getSession();
					session.setAttribute("userName", model.getUserName());
					result="用户登录成功";
					return SUCCESS;
				}
			

		}
		catch(Exception e){
			e.printStackTrace();
		}
		result="用户登录失败";
		return INPUT;
	}


}
