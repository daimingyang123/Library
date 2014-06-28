package com.action;

import javax.servlet.http.HttpSession;

import com.entity.User;

//import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LogoutAction extends ModelAction<User> {
	
	public LogoutAction(){

		model=new User();
	}
	
	public String execute(){
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserServiceInter userServiceInter = (UserServiceInter) ctx.getBean("UserService");
		try{
		HttpSession session = request.getSession();
		session.invalidate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
		
	}

}
