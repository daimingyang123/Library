package com.dao.inter;

import java.util.List;

import com.entity.Book;

public interface BookDAOInter extends IBaseHibernateDAO{
	public List<Book> getBooks(final int start, final int count);
	public long getBookCount() throws Exception;
	public void save(Book book) throws Exception;
	public Book findbyTitle(final String title) throws Exception;
	public List<Book> findByTitle(final String title) throws Exception;
	public Book findByNo(final int No) throws Exception;
	
}
