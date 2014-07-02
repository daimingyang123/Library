package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.BookMsg;
import com.service.inter.BorrowServiceInter;


@SuppressWarnings("serial")
public class GetBorrowsAction extends ModelAction<BookMsg>{
	
	public GetBorrowsAction(){
		model=new BookMsg();
	}
	
	public String execute(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		BorrowServiceInter borrowServiceInter = (BorrowServiceInter) ctx.getBean("borrowService");
		try {
			HttpSession session = request.getSession();
			
			
			Integer userNo=(Integer) session.getAttribute("userNo");
			
			System.out.println("getBorrowsAction userNo:"+userNo);
			
			List<BookMsg> booksList=new ArrayList<BookMsg>();
			booksList=borrowServiceInter.getBorrows(userNo);
			model.setBookMsgList(booksList);
			
			//text code
			System.out.println(booksList.get(0).getBookNo()+" "+booksList.get(0).getTitle()+" "
			+booksList.get(0).getUserNo()+" "+booksList.get(0).getState()+" "+booksList.get(0).getBorrowDate());
			
			
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("getborrowserror", "本を借りていない");
		return INPUT;
		
	}
//	public static void main(String args[]) throws Exception {
////	ApplicationContext ctx = new ClassPathXmlApplicationContext(
////			"applicationContext.xml");
////	BorrowServiceInter borrowServiceInter = (BorrowServiceInter) ctx.getBean("BorrowService");
////	User uer=new User();
//		GetBorrowsAction getba=new GetBorrowsAction();
//		getba.execute();
////	Integer userNo=1;
////	List<BookMsg> bookmsglist=borrowServiceInter.getBorrows(userNo);
////	uer.setUserNo(1);
////	uer.setUserName("fuck");
////	boolean user = userServiceInter.verifyUser(uer);
////	uer=userServiceInter.addUser("fack");
//	
//	System.out.println("ok!!");
//}

}
