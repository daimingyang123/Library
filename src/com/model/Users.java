package com.model;

import java.util.List;

import com.entity.User;

public class Users {
//	 private String username;
	 private int everyPageCount = 15;
	 private long count;
	 private int pageCount;
	 private List<User> users;
	 private int pageIndex = 1;
	 private int currentPage;
	 
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
