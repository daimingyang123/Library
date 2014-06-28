package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.inter.UserServiceInter;

@SuppressWarnings("serial")
public class AddUserAction extends  ActionSupport {
	String result;
	String userName;
	String email;
	User newUser;
	Integer userNo;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public int getUserNo(){
		return userNo;
	}
	public void setUserNo(int userNo){
		this.userNo=userNo;
	}
	 
	public String execute(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceInter userServiceInter = (UserServiceInter) ctx.getBean("UserService");
		try {
			newUser=userServiceInter.addUser(userNo,userName,email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(newUser!=null){
			
//			HttpServletRequest request = ServletActionContext.getRequest();
//			request.setAttribute(userName, newUser.getUserName());
			
			return SUCCESS;
		}
		else{
			return INPUT;
		}
		
	}

}
