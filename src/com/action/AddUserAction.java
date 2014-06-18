package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.inter.UserServiceInter;

public class AddUserAction extends  ActionSupport {
	String result;
	String userName;
	User newUser;
	String userNo;
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	
//	 private HttpServletRequest request;
//	 public void setServletRequest(HttpServletRequest request){
//	      this.request = request;
//	     }
//	 
	public String execute(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceInter userServiceInter = (UserServiceInter) ctx.getBean("UserService");
		try {
			newUser=userServiceInter.addUser(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(newUser!=null){
			
//			Map request=(Map)ActionContext.getContext().get("request");
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute(userName, newUser.getUserName());
//			request.setAttribute(userNo, newUser.getUserNo());
			
			return SUCCESS;
		}
		else{
			return INPUT;
		}
		
	}

}
