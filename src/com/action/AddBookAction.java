package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Book;
import com.service.inter.BookServiceInter;

@SuppressWarnings("serial")
public class AddBookAction extends ModelAction<Book>{

	public AddBookAction(){
		model = new Book();
	}
	
	public String execute(){
		try
		{
//			BookServiceInter bookServiceInter = serviceManager.getBookServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			BookServiceInter bookServiceInter = (BookServiceInter) ctx.getBean("bookService");
//			System.out.println(model.getTitle());
			//如果已存在此number则不添加
			if(!bookServiceInter.verifySameBook(model.getBookNo()))
			{
				bookServiceInter.addBook(model, session, context);
				System.out.println("addbookaction--数据库中不存在此bookNo，添加成功！");
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("addbook", "操作を成功");
				return SUCCESS;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("addbook", "書籍Noは重複");
//		System.out.println("addbookaction--数据库中存在此bookNo，添加不成功！");
		return INPUT;
	}
}
