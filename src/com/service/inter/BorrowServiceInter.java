package com.service.inter;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;



import com.entity.Borrow;
import com.model.BookMsg;

public interface BorrowServiceInter {
	public void borrowBook(Borrow borrow,HttpSession session,ServletContext context) throws Exception;
	public void borrowOrder(Borrow borrow,HttpSession session,ServletContext context) throws Exception;
	public void returnBook(Borrow borrow,HttpSession session,ServletContext context) throws Exception;
	public List<Borrow> getBorrows() throws Exception;
	public List<BookMsg> getBorrows(Integer userNo) throws Exception;
	public boolean verifyBorrowNo(String userName) throws Exception;
	
}
