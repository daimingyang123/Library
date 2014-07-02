package com.model;

import java.util.Date;
import java.util.List;

public class BookMsg {
	
	private Integer bookNo;
	private String title;
	private String plot;
	private Integer state;
	private Integer borrowId;
	private Integer userNo;
	private Date borrowDate;
	private Date returnDate;
	private List<BookMsg> bookMsgList;
	
	public BookMsg(){
		
	}
	public Integer getBookNo(){
		return bookNo;
	}
	public void setBookNo(Integer bookNo){
		this.bookNo=bookNo;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getPlot(){
		return plot;
	}
	public void setPlot(String plot){
		this.plot=plot;
	}
	public Integer getState(){
		return state;
	}
	public void setState(Integer integer){
		this.state=integer;
	}
	public Integer getBorrowId(){
		return borrowId;
	}
	public void setBorrowId(Integer borrowId){
		this.borrowId=borrowId;
	}
	public Integer getUserNo(){
		return userNo;
	}
	public void setUserNo(Integer userNo){
		this.userNo=userNo;
	}
	public Date getBorrowDate() {
		return this.borrowDate;
	}

	public void setBorrowDate(Date now) {
		this.borrowDate = now;
	}
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public List<BookMsg> getBookMsgList(){
		return bookMsgList;
	}
	public void setBookMsgList(List<BookMsg> bookMsgList){
		this.bookMsgList=bookMsgList;
	}

}
