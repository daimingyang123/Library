package com.service.inter;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;



import com.entity.Borrow;
import com.model.BookMsg;

public interface BorrowServiceInter {
	public boolean borrowBook(Borrow borrow,HttpSession session,ServletContext context) throws Exception;
	//这里原为无返回值，现改为boolean
	public boolean borrowOrder(Borrow borrow,HttpSession session,ServletContext context) throws Exception;
	public boolean returnBook(Borrow borrow,HttpSession session,ServletContext context) throws Exception;
	public List<Borrow> getBorrows() throws Exception;
	public List<BookMsg> getBorrows(Integer userNo) throws Exception;
	public boolean verifyBorrowNo(String userName) throws Exception;
	
}
