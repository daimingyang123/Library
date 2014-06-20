package com.service.inter;

import com.entity.User;

public interface UserServiceInter {
	
	public User getUser(String id) throws Exception;
	
	public boolean verifyUser(User userNo) throws Exception;

	public User addUser(Integer userNo,String userName) throws Exception;
}
