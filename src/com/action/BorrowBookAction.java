package com.action;

import javax.servlet.http.HttpSession;

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
			HttpSession session =request.getSession();
			String userName=model.getUserName();
			session.setAttribute("borrow", "");
			session.setAttribute("borroworder", "");
			System.out.println("borrowbookaction--userno--"+userName);
			if(!borrowServiceInter.verifyBorrowNo(userName))
			{
				result="五冊を超えて";
				session.setAttribute("borrow", result);
				System.out.println("borrowBookAction--"+result);
				return INPUT;
			}
			borrowServiceInter.borrowBook(model, session, context);
			result="操作を成功";
			session.setAttribute("borrow", result);
			System.out.println("borrowBookAction--"+result);
			return SUCCESS;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		result = "操作ミス";
		session.setAttribute("borrow", result);
		System.out.println("borrowBookAction--"+result);
		return INPUT;
	}
}
