package com.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer bookNo;
	private String title;
	private String plot;
	private Integer state;
	private Set borrows = new HashSet(0);
	private List<Book> books;

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(String title) {
		this.title = title;
	}

	/** full constructor */
	public Book(String title, String plot, Set borrows) {
		this.title = title;
		this.plot = plot;
		this.borrows = borrows;
	}

	// Property accessors

	public Integer getBookNo() {
		return this.bookNo;
	}

	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlot() {
		return this.plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public Set getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set borrows) {
		this.borrows = borrows;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	public void setBooks(List<Book> books){
		this.books=books;
	}
	public List<Book> getBooks(){
		return books;
	}

}