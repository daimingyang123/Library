package com.service.inter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.entity.Borrow;

public interface BorrowServiceInter {
	public void borrowBook(Borrow borrow,HttpSession session,ServletContext servletContext) throws Exception;
	public void returnBook(Borrow borrow,HttpSession session,ServletContext servletContext) throws Exception;
}
