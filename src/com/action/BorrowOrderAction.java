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
//			BookServiceInter bookServiceInter = serviceManager.getBookServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			BorrowServiceInter borrowServiceInter = (BorrowServiceInter) ctx.getBean("borrowService");
			HttpSession session = ServletActionContext.getRequest().getSession();
			try
			{
				boolean changeState=borrowServiceInter.borrowOrder(model, session, context);
				session.setAttribute("borrowbook", "");
				session.setAttribute("borroworder", "");
				if(changeState){
//				session.setAttribute("borrowbook", "");
				session.setAttribute("borroworder", "������ɹ�");
				return SUCCESS;
				}
			}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		session.setAttribute("borroworder", "�����ߥ�");
//		System.out.println("adduseraction--���ݿ��д��ڴ�userno ��Ӳ��ɹ�");
		return INPUT;
	}
}
