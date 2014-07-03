package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Books;
import com.service.inter.BookServiceInter;

@SuppressWarnings("serial")
public class GetBooksAction extends ModelAction<Books>{
	public GetBooksAction(){
		model = new Books();
	}
	@Override
	public String execute()
	{
		try
		{
			
//			BookServiceInter bookServiceInter = serviceManager.getBookServiceInter();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			BookServiceInter bookServiceInter = (BookServiceInter) ctx.getBean("bookService");
//			int pageIndex = 1;
//			model.setPageIndex(pageIndex);
			model.setCurrentPage(1);
			model.setCount(bookServiceInter.getBookCount());
			int div =  (int) model.getCount() / model.getEveryPageCount();
			model.setPageCount((model.getCount() % model.getEveryPageCount() == 0)?div:div+1);
			model.setBooks(bookServiceInter.getBooks(model.getPageIndex(),
			model.getEveryPageCount()));
//			System.out.println(pageIndex);
			System.out.println(model.getPageIndex());
			if(model.getPageIndex()>0 && model.getPageCount()>=model.getPageIndex()){
//				System.out.println("合理范围");
				return SUCCESS;
			}else{
//				System.out.println("不合理范围");
				HttpSession session = ServletActionContext.getRequest().getSession();
				if(session.getAttribute("state")=="admin"){
					session.setAttribute("adminbook", "ジャンプしない");
				}else{
					session.setAttribute("userbook", "ジャンプしない");
				}
				
				return INPUT;
			}


		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return INPUT;
	}
}
