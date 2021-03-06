package com.entity;

import java.util.Calendar;
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
	private String title;
	private String userName;
	private String email;
	private Date returnDate;

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
	}
	
	public Borrow(Integer userNo,Integer bookNo,Date borrowDate,Integer state) {
		this.userNo = userNo;
		this.bookNo = bookNo;
		this.borrowDate = borrowDate;
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

	public void setBorrowDate(Date now) {
		this.borrowDate = now;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


}