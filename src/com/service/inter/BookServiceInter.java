package com.service.inter;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;



import com.entity.Book;

public interface BookServiceInter {
	public List<Book> getBooks(int pageIndex,int pageCount) throws Exception;
	public Book getInfor(int id) throws Exception;
	public long getBookCount() throws Exception;
	public void addBook(Book book,HttpSession session,ServletContext context) throws Exception;
	public Book findByNo(int No) throws Exception;
	public List<Book> findBook(Book book,HttpSession session,ServletContext servletContext) throws Exception;
	public boolean orderBook(List<Book> books,HttpSession session,ServletContext servletContext) throws Exception;
	public boolean verifySameBook(Integer bookNo) throws Exception;
}
