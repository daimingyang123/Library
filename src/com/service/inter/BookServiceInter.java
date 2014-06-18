package com.service.inter;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.entity.*;

public interface BookServiceInter {
	public List<Book> getBooks(int pageIndex,int pageCount) throws Exception;
	public Book getInfor(int id) throws Exception;
	public long getBookCount() throws Exception;
	public void addBook(Book book,HttpSession session,ServletContext servletContext) throws Exception;
//	public void borrowBook(Borrow borrow,HttpSession session,ServletContext servletContext) throws Exception;
}
