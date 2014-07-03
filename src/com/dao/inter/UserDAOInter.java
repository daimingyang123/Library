package com.dao.inter;


import java.util.List;

import com.entity.User;

public interface UserDAOInter {

	void save(User user) throws Exception;

	boolean delete(User user) throws Exception;

	User findById(int id) throws Exception;

	List<User> getUsers(int start, int count);
	
	User findByNo(int No) throws Exception;
	
	
//	User fingByName(String name) throws Exception;

}
