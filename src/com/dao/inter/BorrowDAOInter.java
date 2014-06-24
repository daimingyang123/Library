package com.dao.inter;

import java.util.List;

import com.entity.Borrow;

public interface BorrowDAOInter {
	public void save(Borrow borrow) throws Exception;
	public List<Borrow> findByUserNo(final int userNo) throws Exception;
	public void delete(final Borrow borrow) throws Exception;
	public List<Borrow> getBorrows();
}
