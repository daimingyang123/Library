package com.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.User;
import com.service.inter.UserServiceInter;

public class LoginAction extends  ModelAction<User> {
//	protected String result;
//	private User user=new User();
//	public User getUser(){
//		return user;
//	}
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
					result="�û���¼�ɹ�";
					return SUCCESS;
				}
			

		}
		catch(Exception e){
			e.printStackTrace();
		}
		result="�û���¼ʧ��";
		return INPUT;
	}


}
