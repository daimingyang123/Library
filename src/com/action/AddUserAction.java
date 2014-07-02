package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
			
			if(userServiceInter.findByNo(userNo) == null){
				newUser=userServiceInter.addUser(userNo,userName,email);
				System.out.println("adduseraction--数据库中不存在此userno 添加成功");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(newUser!=null){
			
//			HttpServletRequest request = ServletActionContext.getRequest();
//			request.setAttribute(userName, newUser.getUserName());
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("adduser", "操作を成功");
			return SUCCESS;
		}
		else{
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("adduser", "操作ミス");
//			System.out.println("adduseraction--数据库中存在此userno 添加不成功");
			return INPUT;
		}
		
	}

}
