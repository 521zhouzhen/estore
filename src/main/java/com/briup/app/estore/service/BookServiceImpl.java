package com.briup.app.estore.service;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.mapper.BookMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class BookServiceImpl  implements IBookService{

	@Override
	public Book BookDetil(Integer bookid) {
		
		 BookMapper  mapper=MyBatisSqlSessionFactory.openSession().getMapper(BookMapper.class);
		    Book book = mapper.selectByPrimaryKey(bookid);
		
		return book;
		
	}

	@Override
	public Book findBookById(Integer bookid) {
		BookMapper  mapper=MyBatisSqlSessionFactory.openSession().getMapper(BookMapper.class);
	    Book book = mapper.selectByPrimaryKey(bookid);
		return book;
	}

}
