package com.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

	
	public void borrowBook(Borrow borrow,HttpSession session,ServletContext context) throws Exception {
		String title = borrow.getTitle();
		List<Book> books = (List<Book>) bookDAO.findByTitle(title);
		for(int i=0;i<books.size();i++){
			Book mybook = books.get(i);
			if(mybook.getState().equals("在架可借")){
				mybook.setState("已借出");
				borrow.setBookNo(mybook.getBookNo());
				bookDAO.save(mybook);
				break;
			}			
		}
		String userName = borrow.getUserName();
		User myuser = userDAO.findByName(userName);
		int userNo = myuser.getUserNo();
		Date now = new Date();
		Calendar calendar=Calendar.getInstance();   
		calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+30);//让日期加30 
		Date returnDate = calendar.getTime();
		borrow.setUserNo(userNo);
		borrow.setBorrowDate(now);
		borrow.setReturnDate(returnDate);
		borrowDAO.save(borrow);
		
	}

	@Override
	public void returnBook(Borrow borrow,HttpSession session,ServletContext context) throws Exception {
		List<Book> books = (List<Book>) bookDAO.findByTitle(borrow.getTitle());
		String userName = borrow.getUserName();
		User myuser = userDAO.findByName(userName);
		int userNo = myuser.getUserNo();
		List<Borrow> borrows = borrowDAO.findByUserNo(userNo);
		for(int i=0;i<books.size();i++){
			for(int j=0;j<borrows.size();j++){
				if(books.get(i).getBookNo().equals(borrows.get(j).getBookNo())){
					books.get(i).setState("在架可借");
					bookDAO.save(books.get(i));
					borrowDAO.delete(borrows.get(j));
				}
			}
		}
	}

	@Override
	public void borrowOrder(Borrow borrow, HttpSession session,
			ServletContext context) throws Exception {
		String title = borrow.getTitle();
		List<Book> books = (List<Book>) bookDAO.findByTitle(title);
		for(int i=0;i<books.size();i++){
			Book mybook = books.get(i);
			if(mybook.getState().equals("已预约")){
				mybook.setState("已借出");
				borrow.setBookNo(mybook.getBookNo());
				bookDAO.save(mybook);
				break;
			}			
		}
		String userName = borrow.getUserName();
		User myuser = userDAO.findByName(userName);
		int userNo = myuser.getUserNo();
		Date now = new Date();
		Calendar calendar=Calendar.getInstance();   
		calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+30);//让日期加30 
		Date returnDate = calendar.getTime();
		borrow.setUserNo(userNo);
		borrow.setBorrowDate(now);
		borrow.setReturnDate(returnDate);
		borrowDAO.save(borrow);
		
	}


	@Override
	public List<Borrow> getBorrows() throws Exception {
		return borrowDAO.getBorrows();
	}
	
	

}
