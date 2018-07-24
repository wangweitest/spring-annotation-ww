package com.ww.service;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ww.dao.BookDao;


@Service
public class BookService {
	
	//@Qualifier("bookDao2")
	@Autowired(required=false) //required=false:是否必须
	//@Resource(name="bookDao2")
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
}
