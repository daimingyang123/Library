package com.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.dao.BookDAO;
import com.dao.BorrowDAO;
import com.dao.UserDAO;
import com.entity.Book;
import com.entity.Borrow;
import com.entity.User;
import com.service.inter.BorrowServiceInter;

public class BorrowService implements BorrowServiceInter{
	private BookDAO bookDAO;
	private UserDAO userDAO;
	private BorrowDAO borrowDAO;
	
	public BorrowService(UserDAO userDAO,BookDAO bookDAO,BorrowDAO borrowDAO)
	{
		this.userDAO = userDAO;
		this.bookDAO = bookDAO;
		this.borrowDAO = borrowDAO;
	}
	@Override
	public void borrowBook(Borrow borrow, HttpSession session,
	ServletContext servletContext) throws Exception {
		String title = borrow.getTitle();
		Book mybook = bookDAO.findByTitle(title);
		mybook.setState("已借出");
		String userName = borrow.getUserName();
		User myuser = userDAO.findByName(userName);
		java.util.Date now = new java.util.Date();
		borrow.setBorrowDate(now);
		borrow.setBookNo(mybook.getBookNo());
		borrow.setUserNo(myuser.getUserNo());
//		System.out.println(mybook.getBookNo());
//		System.out.println(myuser.getUserNo());
		borrowDAO.save(borrow);
		bookDAO.save(mybook);
}
	@Override
	public void returnBook(Borrow borrow, HttpSession session,
			ServletContext servletContext) throws Exception {
		Book mybook = bookDAO.findByTitle(borrow.getTitle());
		User myuser = userDAO.findByName(borrow.getUserName());
		mybook.setState("在架可借");
		int myuserNo = myuser.getUserNo();
		int mybookNo = mybook.getBookNo();
//		int userNo = borrow.getUserNo();
//		int bookNo = borrow.getBookNo();
//		if(myuserNo == userNo && mybookNo == bookNo){
//			borrow.setState(1);
//		}
		
		
		Borrow myborrow = borrowDAO.findByUNBN(myuserNo, mybookNo); 
		borrowDAO.save(myborrow);
		bookDAO.save(mybook);
		System.out.println(myuserNo);
		System.out.println(mybookNo);
		System.out.println(myborrow.getId());
	}

}
