package com.service;

import com.service.inter.BookServiceInter;


public class ServiceManager {
	 private BookServiceInter bookServiceInter;

		public BookServiceInter getBookServiceInter()
		{
			return bookServiceInter;
		}
		public void setBookServiceInter(BookServiceInter bookServiceInter)
		{
			this.bookServiceInter = bookServiceInter;
		}
}
