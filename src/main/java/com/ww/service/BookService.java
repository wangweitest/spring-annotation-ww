package com.ww.service;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ww.dao.BookDao;


@Service
public class BookService {
	
	//@Qualifier("bookDao")
	//@Autowired(required=false) //required=false:ÊÇ·ñ±ØÐë
	@Resource(name="bookDao2")
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
}
