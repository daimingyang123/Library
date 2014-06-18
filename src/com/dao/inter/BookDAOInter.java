package com.dao.inter;

import java.util.List;

import com.entity.Book;

public interface BookDAOInter {
	public List<Book> getBooks(final int start, final int count);
	public long getBookCount() throws Exception;
	public void save(Book book) throws Exception;
	public Book findByTitle(final String title) throws Exception;

}
