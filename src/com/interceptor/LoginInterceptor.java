package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor  extends MethodFilterInterceptor {
	
	private String name;
	public String getName(){
		return name;
	}
	public void setName(){
		this.name=name;
	}
	
	public void init() {}  
	public void destroy() {}  

	@Override
	protected String doIntercept(ActionInvocation actionInvacation) throws Exception {
		// TODO Auto-generated method stub
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpSession session = request.getSession();
//		String name = (String)session.getAttribute("userName");
		String user=(String)ServletActionContext.getRequest().getSession().getAttribute("userName");
		System.out.println("invacation"+user);
//		HttpSession session = ServletActionContext.getRequest().getSession();
//		session.invalidate();
		if(user!=null){
			System.out.println("invacation:进入IF"+user);
			return actionInvacation.invoke();
		}else{
			System.out.println("invacation：没有进入if"+user);
//		response.sendRedirect("user.jsp");
		return Action.LOGIN;}
	}
	

}
