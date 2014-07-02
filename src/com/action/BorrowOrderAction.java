package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Borrow;
import com.service.inter.BorrowServiceInter;

@SuppressWarnings("serial")
public class BorrowOrderAction extends ModelAction<Borrow>{

	public BorrowOrderAction(){
		model = new Borrow();
		
	}
	
	public String execute(){
		try
		{
//			BookServiceInter bookServiceInter = serviceManager.getBookServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			BorrowServiceInter borrowServiceInter = (BorrowServiceInter) ctx.getBean("borrowService");
			borrowServiceInter.borrowOrder(model, session, context);
			return SUCCESS;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("userbookerror", "�����ߥ�");
//		System.out.println("adduseraction--���ݿ��д��ڴ�userno ��Ӳ��ɹ�");
		return INPUT;
	}
}
