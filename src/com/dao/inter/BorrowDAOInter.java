package com.dao.inter;

import com.entity.Borrow;

public interface BorrowDAOInter {
	public void save(Borrow borrow) throws Exception;
	public Borrow findByUNBN(final int userNo,final int bookNo) throws Exception;
}
