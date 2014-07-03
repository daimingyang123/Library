package com.service;

import java.util.ArrayList;
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
import com.model.BookMsg;
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

	
	public boolean borrowBook(Borrow borrow,HttpSession session,ServletContext context) throws Exception {
		String title = borrow.getTitle();
		List<Book> books = (List<Book>) bookDAO.findByTitle(title);
		if(books.isEmpty()){
			return false;
		}
		for(int i=0;i<books.size();i++){
			Book mybook = books.get(i);
			Integer state =1;
//			if(mybook.getState().equals(1)){
			if(state.equals(mybook.getState())){
				mybook.setState(null);
				borrow.setBookNo(mybook.getBookNo());
				bookDAO.save(mybook);
				break;
			}
			if(i==books.size()-1){
				return false;
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
		return true;
		
	}

	public boolean returnBook(Borrow borrow,HttpSession session,ServletContext context) throws Exception {
		List<Book> books = (List<Book>) bookDAO.findByTitle(borrow.getTitle());
		if(books.isEmpty()){
			return false;
		}
		String userName = borrow.getUserName();
		User myuser = userDAO.findByName(userName);
		int userNo = myuser.getUserNo();
		List<Borrow> borrows = borrowDAO.findByUserNo(userNo);
		for(int i=0;i<books.size();i++){
			for(int j=0;j<borrows.size();j++){
				if(books.get(i).getBookNo().equals(borrows.get(j).getBookNo())){
					books.get(i).setState(1);
					bookDAO.save(books.get(i));
					borrowDAO.delete(borrows.get(j));
				}
			}
		}
		return true;

	}
//这里原为无返回值，现改为boolean
	//return false 为新添加  返回true为成功，FALSE为失败
	@Override
	public boolean borrowOrder(Borrow borrow, HttpSession session,
			ServletContext context) throws Exception {
		String title = borrow.getTitle();
		List<Book> books = (List<Book>) bookDAO.findByTitle(title);
		if(books.isEmpty()){
			return false;
		}
		for(int i=0;i<books.size();i++){
			Book mybook = books.get(i);
			System.out.println("borrowservice--"+mybook);
//			if(mybook.getState().equals(0)){\
			Integer state =0;
			if(state.equals(mybook.getState())){	
				mybook.setState(null);
				borrow.setBookNo(mybook.getBookNo());
				bookDAO.save(mybook);
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
				return true;
			}
		}
		return false;
		
		
	}


	@Override
	public List<Borrow> getBorrows() throws Exception {
		return borrowDAO.getBorrows();
	}


	@Override
	public List<BookMsg> getBorrows(Integer userNo) throws Exception {
		// TODO Auto-generated method stub
		List<Borrow> borrowList = borrowDAO.findByUserNo(userNo);
//		BookMsg borrowBookMsg=new BookMsg();
		List<BookMsg> borrowBookMsgList = new ArrayList<BookMsg>();
		if(borrowList==null){
			return null;}
		System.out.println("BorrowService--before enter for");
		for(int i=0;i<borrowList.size();i++){
			BookMsg borrowBookMsg=new BookMsg();
			borrowBookMsg.setBookNo(borrowList.get(i).getBookNo());
			borrowBookMsg.setUserNo(borrowList.get(i).getUserNo());
			borrowBookMsg.setBorrowDate(borrowList.get(i).getBorrowDate());
			borrowBookMsg.setReturnDate(borrowList.get(i).getReturnDate());
			borrowBookMsg.setBorrowId(borrowList.get(i).getId());
			System.out.println("BorrowService--borrowBookMsg--bookNo: "+borrowList.get(i).getBookNo());
			Book book =bookDAO.findByNo(borrowList.get(i).getBookNo());
			borrowBookMsg.setTitle(book.getTitle());
			borrowBookMsg.setPlot(book.getPlot());
			borrowBookMsg.setState(book.getState());
			borrowBookMsgList.add(borrowBookMsg);
			System.out.println("BorrowService--borrowBookMsgList--bookNo: "+borrowBookMsgList.get(i).getBookNo()+"   "+i);
		}
		for(int i=0;i<borrowBookMsgList.size();i++){
		System.out.println("BorrowService--borrowBookMsgList--Time2--bookNo: "+borrowBookMsgList.get(i).getBookNo()+"    "+i);}
		return borrowBookMsgList;
	}


	@Override
	public boolean verifyBorrowNo(String userName) throws Exception {
		// TODO Auto-generated method stub
		Integer userNo=userDAO.findByName(userName).getUserNo();
		System.out.println("borrowservice--"+userNo);
		if(borrowDAO.findByUserNo(userNo).size()<5)
		{
			System.out.println("borrowservice--size--"+borrowDAO.findByUserNo(userNo).size());
			return true;
		}
		return false;
	}

	
	

}
