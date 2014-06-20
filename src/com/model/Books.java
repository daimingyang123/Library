package com.model;

import java.util.List;

import com.entity.Book;


public class Books {
//	 private String username;
	 private int everyPageCount = 10;
	 private long count;
	 private int pageCount;
	 private List<Book> books;
	 private int pageIndex = 1;
	 public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getEveryPageCount() {
		return everyPageCount;
	}
	public void setEveryPageCount(int everyPageCount) {
		this.everyPageCount = everyPageCount;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
