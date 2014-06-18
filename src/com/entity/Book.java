package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer bookNo;
	private String title;
	private String plot;
	private Set borrows = new HashSet(0);

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

}