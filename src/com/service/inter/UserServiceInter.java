package com.service.inter;

import java.util.List;

import com.entity.User;

public interface UserServiceInter {
	
	public User getUser(String id) throws Exception;
	
	public boolean verifyUser(User userNo) throws Exception;

	public User addUser(Integer userNo,String userName,String email) throws Exception;
	
	public User findByNo(Integer userNo) throws Exception;
	
	public List<User> getUsers(int pageIndex, int pageCount) throws Exception;
	
	public long getUserCount() throws Exception;
	
}
