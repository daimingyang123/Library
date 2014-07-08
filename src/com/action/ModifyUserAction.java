package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.User;
import com.service.inter.UserServiceInter;

public class ModifyUserAction extends ModelAction<User>{
	public ModifyUserAction(){
		model = new User();
	}
	
	public String execute(){
		try
		{
//			UserServiceInter UserServiceInter = serviceManager.getUserServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserServiceInter userServiceInter = (UserServiceInter) ctx.getBean("UserService");
				userServiceInter.modifyUser(model, session, context);
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("username", model.getUserName());
				return SUCCESS;
		}catch (Exception e){
			e.printStackTrace();
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("modifyuser", "もう操作できない");
		System.out.println("fuck");
//		System.out.println("addUseraction--数据库中存在此UserNo，添加不成功！");
		return INPUT;
	}
}
