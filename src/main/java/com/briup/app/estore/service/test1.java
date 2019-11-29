package com.briup.app.estore.service;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.bean.Orderline;

public class test1 {

	public static void main(String[] args) throws Exception {
		/*
		 * ICustomerService is=new CustomerServiceImpl(); Customer customer=new
		 * Customer(); customer.setName("1"); customer.setPassword("1"); Integer login =
		 * is.login(customer); System.out.println(login);
		 */
		
		Book book=new  Book();
		book.setId(1);
		Order order=new Order();
		order.setId(1);
		Orderline orderline=new Orderline(1,2,null,book);
		  ILineService ils=new LineServiceImpl();
		  ils.saveOrderLine(orderline);
		
		
	}
}
