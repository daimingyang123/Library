package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Borrow;
import com.service.inter.BorrowServiceInter;

@SuppressWarnings("serial")
public class BorrowBookAction extends ModelAction<Borrow>{

	public BorrowBookAction(){
		model = new Borrow();
		
	}
	
	public String execute(){
		try
		{
//			BookServiceInter bookServiceInter = serviceManager.getBookServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			BorrowServiceInter borrowServiceInter = (BorrowServiceInter) ctx.getBean("borrowService");
			borrowServiceInter.borrowBook(model, session, context);
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("borrowbook", "操作を成功");
			return SUCCESS;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("borrowbook", "五冊を超えて");
		return INPUT;
	}
}
