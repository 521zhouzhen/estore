package com.briup.app.estore.service;

import java.util.Date;
import java.util.List;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.mapper.OrderMapper;
import com.briup.app.estore.mapper.OrderlineMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class Test {
public static void main(String[] args) {
		
	
		/*
		 * Customer c=new Customer(); c.setId(1);
		 * System.out.println("--------------------------------");
		 * System.out.println(c); Order order=new Order(20.0,new Date(),c); OrderMapper
		 * mapper = MyBatisSqlSessionFactory.openSession().getMapper(OrderMapper.class);
		 * int insertOrder = mapper.insertOrder(order); System.out.println(insertOrder);
		 */
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	Book book=new  Book();
	book.setId(1);
	Order order=new Order();
	order.setId(1);
	Customer c=new Customer(); c.setId(1);
	order.setCustomer(c);
	Orderline orderline=new Orderline(1,2,null,book);
	OrderlineMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(OrderlineMapper.class);
	  mapper.insertOrderLine(orderline);
	  
	  IOrderService  is=new OrderServiceImpl();
	  List<Order> list = is.findAllOrderByCustomerid(1);
	 for (Order order2 : list) {
		System.out.println(order.getCost());
	}
	  
	  
	
}
}
