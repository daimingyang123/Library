package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Borrow;
import com.service.inter.BorrowServiceInter;

@SuppressWarnings("serial")
public class ReturnBookAction extends ModelAction<Borrow>{
	public ReturnBookAction(){
		model = new Borrow();

	}

	public String execute(){
		try
		{
//			BookServiceInter bookServiceInter = serviceManager.getBookServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			BorrowServiceInter borrowServiceInter = (BorrowServiceInter) ctx.getBean("borrowService");
			boolean returnBook = borrowServiceInter.returnBook(model, session, context);
			if(returnBook){
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("returnbook", "操作を成功");
				return SUCCESS;
			}
			else{
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("returnbook", "操作ミス");
				return INPUT;
			}	
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("returnbook", "操作ミス");
		return INPUT;
	}
}