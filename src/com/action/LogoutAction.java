package com.action;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.User;
import com.service.inter.UserServiceInter;

//import com.opensymphony.xwork2.ActionSupport;

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
		System.out.println("logoutaction--已注销登录! session已被销毁");
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
		
	}

}
