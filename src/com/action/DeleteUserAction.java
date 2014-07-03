package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.User;
import com.service.inter.UserServiceInter;

public class DeleteUserAction extends ModelAction<User>{
	public DeleteUserAction(){
		model = new User();
	}
	
	public String execute(){
		try
		{
//			UserServiceInter UserServiceInter = serviceManager.getUserServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserServiceInter UserServiceInter = (UserServiceInter) ctx.getBean("UserService");
			boolean state = UserServiceInter.deleteUser(model, session, context);
			if(state){
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("adminuser", "操作を成功");
			}else{
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("adminuser", "もう操作できない");
				System.out.println("sss");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
