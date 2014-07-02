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
			session.setAttribute("borrowbook", "");
			session.setAttribute("borroworder", "");
			System.out.println("borrowbookaction--userno--"+userName);
			if(!borrowServiceInter.verifyBorrowNo(userName))
			{
				result="五冊を超えて";
				session.setAttribute("borrowbook", result);
				System.out.println("borrowBookAction--"+result);
				return INPUT;
			}
			//判断数据库是否存在此书 true代表存在并借出成功，false代表书不存在数据库中
			boolean changeState=borrowServiceInter.borrowBook(model, session, context);
			if(changeState){
				result="操作を成功";
				session.setAttribute("borrowbook", result);
				System.out.println("borrowBookAction--"+result);
				return SUCCESS;
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		result = "操作ミス";
		session.setAttribute("borrowbook", result);
		System.out.println("borrowBookAction--"+result);
		return INPUT;
	}
}
