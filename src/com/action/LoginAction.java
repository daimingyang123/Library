package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
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
			//text code
			System.out.println("进入execute()");
			System.out.println(session.getAttribute("userNo")+"----"+session.getAttribute("userName"));
			session.setAttribute("userNo", null);
		    session.setAttribute("userName", null);//text code
			if(userServiceInter.verifyUser(model))
				{
				    HttpSession session = request.getSession();
				    session.setAttribute("userNo", model.getUserNo());
				    session.setAttribute("userName", model.getUserName());
				    //TEXT
				    System.out.println("enter--if()--"+session.getAttribute("userNo")+"---"+session.getAttribute("userName"));
					return SUCCESS;
				}
			

		}
		catch(Exception e){
			e.printStackTrace();
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("usererror", "ユーザー名やパスワードエラー");
		return ERROR;
	}


}
