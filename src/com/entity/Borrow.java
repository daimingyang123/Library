package com.entity;

import java.util.Date;

/**
 * Borrow entity. @author MyEclipse Persistence Tools
 */

public class Borrow implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Book book;
	private Integer userNo;
	private Integer bookNo;
	private Date borrowDate;
	private Integer state;
	private String title;
	private String userName;

	// Constructors

	/** default constructor */
	public Borrow() {
	}

	/** minimal constructor */
	public Borrow(User user, Book book, Date borrowDate) {
		this.user = user;
		this.book = book;
		this.borrowDate = borrowDate;
	}

	/** full constructor */
	public Borrow(User user, Book book, Date borrowDate, Integer state) {
		this.user = user;
		this.book = book;
		this.borrowDate = borrowDate;
		this.state = state;
	}
	
	public Borrow(Integer userNo,Integer bookNo,Date borrowDate,Integer state) {
		this.userNo = userNo;
		this.bookNo = bookNo;
		this.borrowDate = borrowDate;
		this.state = state;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getBorrowDate() {
		return this.borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserNo() {
		return this.userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	
	public Integer getBookNo() {
		return this.bookNo;
	}

	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}


}