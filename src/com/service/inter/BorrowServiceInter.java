package com.service.inter;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;



import com.entity.Borrow;

public interface BorrowServiceInter {
	public void borrowBook(Borrow borrow,HttpSession session,ServletContext context) throws Exception;
	public void borrowOrder(Borrow borrow,HttpSession session,ServletContext context) throws Exception;
	public void returnBook(Borrow borrow,HttpSession session,ServletContext context) throws Exception;
	public List<Borrow> getBorrows() throws Exception;
}
