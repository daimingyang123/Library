package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userNo;
	private String userName;
	private Set borrows = new HashSet(0);
	private String email;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName) {
		this.userName = userName;
	}

	/** full constructor */
	public User(String userName, Set borrows) {
		this.userName = userName;
		this.borrows = borrows;
	}

	// Property accessors

	public Integer getUserNo() {
		return this.userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set borrows) {
		this.borrows = borrows;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}