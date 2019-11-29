package com.briup.app.estore.service;

import com.briup.app.estore.bean.Book;

public interface IBookService {
	 Book BookDetil(Integer bookid);
	 Book  findBookById(Integer bookid);
}
