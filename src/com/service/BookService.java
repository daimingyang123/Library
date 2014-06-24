package com.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.dao.BookDAO;
import com.entity.Book;
import com.service.inter.BookServiceInter;

public class BookService implements BookServiceInter{
	private BookDAO bookDAO;
	public BookService(BookDAO bookDAO)
	{
		this.bookDAO = bookDAO;
	}
	@Override
	public List<Book> getBooks(int pageIndex, int pageCount) throws Exception {
		return bookDAO.getBooks( (pageIndex - 1) * pageCount, pageCount);
	}

	@Override
	public Book getInfor(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getBookCount() throws Exception {
		return bookDAO.getBookCount();
	}

	@Override
	public void addBook(Book book, HttpSession session, ServletContext context)
			throws Exception {
		book.setState("ÔÚ¼Ü¿É½è");
		bookDAO.save(book);
		
	}
	@Override
	public Book findByNo(int No) throws Exception {
		return bookDAO.findByNo(No);
	}

}
