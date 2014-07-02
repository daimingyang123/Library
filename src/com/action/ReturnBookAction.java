package com.action;

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
			borrowServiceInter.returnBook(model, session, context);
			return SUCCESS;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return INPUT;
	}
}